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

public class ArticlesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_articles, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.articles_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        List<MeditationArticles> articleList = new ArrayList<>();
        // Populate with dummy data
        articleList.add(new MeditationArticles("https://example.com/article1", "Meditation Article 1"));
        articleList.add(new MeditationArticles("https://example.com/article2", "Meditation Article 2"));

        ArticlesAdapter adapter = new ArticlesAdapter(articleList);
        recyclerView.setAdapter(adapter);
    }
}
