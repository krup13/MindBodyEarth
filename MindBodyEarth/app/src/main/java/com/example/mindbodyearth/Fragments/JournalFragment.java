package com.example.mindbodyearth.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.example.mindbodyearth.Dao.JournallingPackageDaos.JournalDao;
import com.example.mindbodyearth.Dao.JournallingPackageDaos.JournalEntryDao;
import com.example.mindbodyearth.Entities.JournallingPackageEntities.Journal;
import com.example.mindbodyearth.Entities.JournallingPackageEntities.JournalEntry;
import com.example.mindbodyearth.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JournalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JournalFragment extends Fragment {

    private EditText journalEditText;
    private JournalEntryDao journalEntryDao; // To be initialized by your partner
    private JournalDao journalDao;           // To be initialized by your partner

    private Handler autoSaveHandler;
    private Runnable autoSaveRunnable;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public JournalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JournalFragment.
     */
    public static JournalFragment newInstance(String param1, String param2) {
        JournalFragment fragment = new JournalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // TODO: Rename and change types of parameters
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }

        // TODO: Initialize the database and DAOs here. Replace this comment with actual initialization code.
        // AppDatabase db = Room.databaseBuilder(
        //         requireContext(),
        //         AppDatabase.class, "journal-database"
        // ).build();
        // journalEntryDao = db.journalEntryDao();
        // journalDao = db.journalDao();

        // Setup autosave handler
        autoSaveHandler = new Handler();
        autoSaveRunnable = this::autoSaveJournal;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_journal, container, false);

        journalEditText = view.findViewById(R.id.journalEditText);
        Button saveButton = view.findViewById(R.id.saveButton);

        TextView TopBarTitle = view.findViewById(R.id.topBarTitle);
        String currentDate = getCurrentDateAndDay();
        String currentDay = extractDayFromDate(currentDate);
        TopBarTitle.setText(String.format("%s %s", currentDate, getString(R.string.journalTitle)));
        setupTitleChangeListener();
        setupSearchBar();
        loadPastJournals();

        saveButton.setOnClickListener(v -> saveJournalEntry(currentDay));
        return view;
    }

    private String getCurrentDateAndDay() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy", Locale.getDefault());
        return dateFormat.format(new Date());
    }

    private String extractDayFromDate(String currentDate) {
        if (currentDate != null && !currentDate.isEmpty()) {
            String[] parts = currentDate.split(",");
            return parts.length > 0 ? parts[0].trim() : "";
        }
        return "";
    }

    private void saveJournalEntry(String currentDay) {
        String content = journalEditText.getText().toString().trim();
        if (!content.isEmpty()) {
            // Use Calendar to get the current year
            Calendar calendar = Calendar.getInstance();
            int currentYear = calendar.get(Calendar.YEAR);

            new Thread(() -> {
                // Create new journal for the year if it doesn't exist
                checkAndCreateJournal(currentYear);

                // Create and save the journal entry
                JournalEntry newEntry = new JournalEntry(
                        System.currentTimeMillis(),
                        currentYear,
                        currentDay,
                        calendar.getTime(),
                        "Default Title", // Replace with a method to get the title from the user if needed
                        content
                );

                journalEntryDao.insert(newEntry);
            }).start();
        }
    }


    private void loadPastJournals() {
        new Thread(() -> {
            List<JournalEntry> pastEntries = journalEntryDao.getEntriesForYear(Calendar.getInstance().get(Calendar.YEAR) - 1);
            requireActivity().runOnUiThread(() -> {
                ArrayAdapter<JournalEntry> adapter = new ArrayAdapter<>(
                        requireContext(),
                        android.R.layout.simple_list_item_1,
                        pastEntries
                );
                ListView pastJournalsListView = requireView().findViewById(R.id.pastJournalsListView);
                pastJournalsListView.setAdapter(adapter);
            });
        }).start();
    }

    private void setupTitleChangeListener() {
        EditText titleEditText = requireView().findViewById(R.id.topBarTitle);
        titleEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) { // Save title when focus is lost
                String newTitle = titleEditText.getText().toString().trim();
                new Thread(() -> {
                    JournalEntry currentEntry = getCurrentJournalEntry(); // Implement logic to fetch the current journal entry
                    currentEntry.setTitle(newTitle);
                    journalEntryDao.update(currentEntry);
                }).start();
            }
        });
    }

    private JournalEntry getCurrentJournalEntry() {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        int currentYear = calendar.get(Calendar.YEAR); // Get the current year

        // Fetch the current journal entry based on today's date and current year
        final JournalEntry currentEntry = journalEntryDao.findEntryByDateAndYear(
                currentDate.getTime(),
                currentYear
        );

        // If no entry exists, create a new one
        if (currentEntry == null) {
            final JournalEntry newEntry = new JournalEntry(
                    System.currentTimeMillis(),
                    currentYear,
                    extractDayFromDate(getCurrentDateAndDay()),
                    currentDate,
                    "Today's Journal Entry", // Default title
                    "" // Default content
            );

            // Save the new entry
            new Thread(() -> journalEntryDao.insert(newEntry)).start();
            return newEntry;
        }

        return currentEntry;
    }


    private void setupSearchBar() {
        EditText searchBar = requireView().findViewById(R.id.searchBar);
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = s.toString().trim();
                new Thread(() -> {
                    List<JournalEntry> searchResults = journalEntryDao.searchEntries("%" + query + "%");
                    requireActivity().runOnUiThread(() -> {
                        ArrayAdapter<JournalEntry> adapter = new ArrayAdapter<>(
                                requireContext(),
                                android.R.layout.simple_list_item_1,
                                searchResults
                        );
                        ListView pastJournalsListView = requireView().findViewById(R.id.pastJournalsListView);
                        pastJournalsListView.setAdapter(adapter);
                    });
                }).start();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void checkAndCreateJournal(int year) {
        new Thread(() -> {
            Journal journal = journalDao.getJournalByYear(year);
            if (journal == null) {
                journal = new Journal(year);
                journalDao.insert(journal);
            }
        }).start();
    }


    private void autoSaveJournal() {
        saveJournalEntry(extractDayFromDate(getCurrentDateAndDay()));
        autoSaveHandler.postDelayed(autoSaveRunnable, 300000); // Autosave every 5 minutes
    }

    @Override
    public void onResume() {
        super.onResume();
        autoSaveHandler.post(autoSaveRunnable);
    }

    @Override
    public void onPause() {
        super.onPause();
        autoSaveHandler.removeCallbacks(autoSaveRunnable);
    }
}
