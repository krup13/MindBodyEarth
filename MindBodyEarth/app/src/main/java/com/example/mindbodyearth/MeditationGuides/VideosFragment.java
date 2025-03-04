package com.example.mindbodyearth.MeditationGuides;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mindbodyearth.Dao.MeditationDaos.MeditationVideoDao;
import com.example.mindbodyearth.Entities.Meditation.MeditationVideo;
import com.example.mindbodyearth.R;

import java.util.List;

public class VideosFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_videos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.videos_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // TODO: Initialize the Room database and DAO
        MeditationVideoDao videoDao = null; // Replace with initialized DAO

        // Fetch data from database
        new Thread(() -> {
            List<MeditationVideo> videoList = videoDao.getFavoriteVideos();

            requireActivity().runOnUiThread(() -> {
                VideosAdapter adapter = new VideosAdapter(videoList);
                recyclerView.setAdapter(adapter);
            });
        }).start();
    }
}

