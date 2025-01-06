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

import java.net.MalformedURLException;
import java.net.URL;
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
        try {
            videoList.add(new MeditationVideos(new URL("https://www.youtube.com/watch?v=AVHuvI0fbTI"), "Relaxing Video 1"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try {
            videoList.add(new MeditationVideos(new URL("https://www.youtube.com/watch?v=Sbp_EeBk-As"), "Relaxing Video 2"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        VideosAdapter adapter = new VideosAdapter(videoList);
        recyclerView.setAdapter(adapter);
    }
}
