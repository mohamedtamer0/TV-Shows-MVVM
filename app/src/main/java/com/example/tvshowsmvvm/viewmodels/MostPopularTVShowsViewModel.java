package com.example.tvshowsmvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.tvshowsmvvm.repositories.MostPopularTVShowsRepository;
import com.example.tvshowsmvvm.responses.TVShowsResponse;

public class MostPopularTVShowsViewModel extends ViewModel {
    private final MostPopularTVShowsRepository mostPopularTVShowsRepository;
    public MostPopularTVShowsViewModel(){
        mostPopularTVShowsRepository = new MostPopularTVShowsRepository();

    }
    public LiveData<TVShowsResponse> getMostPopularTVShows(int page){
        return mostPopularTVShowsRepository.getMostPopularTVShows(page);
    }

}