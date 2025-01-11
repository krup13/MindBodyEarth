package com.example.mindbodyearth.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.mindbodyearth.AppDatabase;
import com.example.mindbodyearth.Dao.MeditationDaos.MeditationVideoDao;
import com.example.mindbodyearth.Entities.Meditation.MeditationVideo;
import com.example.mindbodyearth.R;

import java.util.List;

public class MeditationFragment extends Fragment {
    private MeditationVideoDao meditationVideoDao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meditation, container, false);

        // Initialize DAO
        AppDatabase database = AppDatabase.getDatabase(requireContext());
        meditationVideoDao = database.meditationVideoDao();

        // Example: Fetch favorite videos
        List<MeditationVideo> favoriteVideos = meditationVideoDao.getFavoriteVideos();
        for (MeditationVideo video : favoriteVideos) {
            Log.d("MeditationFragment", "Video Title: " + video.getTitle());
        }

        return view;
    }
}
