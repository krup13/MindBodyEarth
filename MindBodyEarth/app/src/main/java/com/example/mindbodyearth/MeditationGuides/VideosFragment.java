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

import com.example.mindbodyearth.R;

import java.util.ArrayList;
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

        List<MeditationVideos> videoList = new ArrayList<>();
        // Populate with dummy data
        videoList.add(new MeditationVideos("https://youtu.be/example", "Relaxing Video 1"));
        videoList.add(new MeditationVideos("https://youtu.be/example2", "Relaxing Video 2"));

        VideosAdapter adapter = new VideosAdapter(videoList);
        recyclerView.setAdapter(adapter);
    }
}
