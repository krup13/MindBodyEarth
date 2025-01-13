// Generated by view binder compiler. Do not edit!
package com.example.mindbodyearth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.example.mindbodyearth.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class FragmentArticlesBinding implements ViewBinding {
  @NonNull
  private final RecyclerView rootView;

  @NonNull
  public final RecyclerView articlesRecyclerView;

  private FragmentArticlesBinding(@NonNull RecyclerView rootView,
      @NonNull RecyclerView articlesRecyclerView) {
    this.rootView = rootView;
    this.articlesRecyclerView = articlesRecyclerView;
  }

  @Override
  @NonNull
  public RecyclerView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentArticlesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentArticlesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_articles, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentArticlesBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    RecyclerView articlesRecyclerView = (RecyclerView) rootView;

    return new FragmentArticlesBinding((RecyclerView) rootView, articlesRecyclerView);
  }
}
