package com.example.mindbodyearth.Fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import android.widget.Toast;

import com.example.mindbodyearth.Dao.JournallingPackageDaos.JournalDao;
import com.example.mindbodyearth.Dao.JournallingPackageDaos.JournalEntryDao;
import com.example.mindbodyearth.Entities.JournallingPackageEntities.Journal;
import com.example.mindbodyearth.Entities.JournallingPackageEntities.JournalEntry;
import com.example.mindbodyearth.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class JournalFragment extends Fragment {

    private EditText journalEditText;
    private JournalEntryDao journalEntryDao;
    private JournalDao journalDao;

    private Handler autoSaveHandler;
    private Runnable autoSaveRunnable;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_journal, container, false);

        // Initialize views
        journalEditText = view.findViewById(R.id.journalEditText);
        Button saveButton = view.findViewById(R.id.saveButton);

        TextView topBarTitle = view.findViewById(R.id.topBarTitle);
        String currentDate = getCurrentDateAndDay();
        String currentDay = extractDayFromDate(currentDate);
        topBarTitle.setText(String.format("%s %s", currentDate, getString(R.string.journalTitle)));

        saveButton.setOnClickListener(v -> saveJournalEntry(currentDay));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setup methods that depend on the view
        setupTitleChangeListener(view);
        setupSearchBar(view);
        loadPastJournals(view);
    }

    private void setupTitleChangeListener(View view) {
        EditText titleEditText = view.findViewById(R.id.topBarTitle);
        if (titleEditText != null) {
            titleEditText.setOnFocusChangeListener((v, hasFocus) -> {
                if (!hasFocus) {
                    String newTitle = titleEditText.getText().toString().trim();
                    new Thread(() -> {
                        JournalEntry currentEntry = getCurrentJournalEntry();
                        if (currentEntry != null) {
                            currentEntry.setTitle(newTitle);
                            journalEntryDao.updateJournalEntry(currentEntry);
                        }
                    }).start();
                }
            });
        }
    }

    private void setupSearchBar(View view) {
        EditText searchBar = view.findViewById(R.id.searchBar);
        if (searchBar != null) {
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
                            ListView pastJournalsListView = view.findViewById(R.id.pastJournalsListView);
                            pastJournalsListView.setAdapter(adapter);
                        });
                    }).start();
                }

                @Override
                public void afterTextChanged(Editable s) {}
            });
        }
    }

    private void loadPastJournals(View view) {
        new Thread(() -> {
            List<JournalEntry> pastEntries = journalEntryDao.getEntriesForYear(Calendar.getInstance().get(Calendar.YEAR) - 1);
            requireActivity().runOnUiThread(() -> {
                ArrayAdapter<JournalEntry> adapter = new ArrayAdapter<>(
                        requireContext(),
                        android.R.layout.simple_list_item_1,
                        pastEntries
                );
                ListView pastJournalsListView = view.findViewById(R.id.pastJournalsListView);
                pastJournalsListView.setAdapter(adapter);
            });
        }).start();
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

    private JournalEntry getCurrentJournalEntry() {
        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        int currentYear = calendar.get(Calendar.YEAR);

        JournalEntry currentEntry = journalEntryDao.findEntryByDateAndYear(currentDate.getTime(), currentYear);

        if (currentEntry == null) {
            JournalEntry newEntry = new JournalEntry(
                    System.currentTimeMillis(),
                    currentYear,
                    extractDayFromDate(getCurrentDateAndDay()),
                    currentDate,
                    "Today's Journal Entry",
                    ""
            );
            new Thread(() -> journalEntryDao.insertJournalEntry(newEntry)).start();
            return newEntry;
        }
        return currentEntry;
    }

    private void saveJournalEntry(String day) {
        String journalText = journalEditText.getText().toString().trim();

        if (!journalText.isEmpty()) {
            new Thread(() -> {
                java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(currentDate);
                int currentYear = calendar.get(Calendar.YEAR);

                // Fetch the journal entry for the current date and year
                JournalEntry currentEntry = journalEntryDao.findEntryByDateAndYear(currentDate.getTime(), currentYear);

                if (currentEntry == null) {
                    // Create a new entry if none exists
                    currentEntry = new JournalEntry(
                            System.currentTimeMillis(),
                            currentYear,
                            day,
                            currentDate,
                            "Untitled", // Default title
                            journalText
                    );
                    journalEntryDao.insertJournalEntry(currentEntry);
                } else {
                    // Update the existing entry
                    currentEntry.setContent(journalText);
                    journalEntryDao.updateJournalEntry(currentEntry);
                }
            }).start();

            requireActivity().runOnUiThread(() ->
                    Toast.makeText(requireContext(), "Journal entry saved!", Toast.LENGTH_SHORT).show()
            );
        } else {
            requireActivity().runOnUiThread(() ->
                    Toast.makeText(requireContext(), "Journal content cannot be empty!", Toast.LENGTH_SHORT).show()
            );
        }
    }

}
