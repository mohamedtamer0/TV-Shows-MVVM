package com.example.tvshowsmvvm.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.tvshowsmvvm.database.TVShowDatabase;
import com.example.tvshowsmvvm.models.TVShow;
import com.example.tvshowsmvvm.repositories.TVShowDetailRepository;
import com.example.tvshowsmvvm.responses.TVShowDetailResponse;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class TvShowDetailsViewModel extends AndroidViewModel {
    private TVShowDetailRepository tvShowDetailRepository;
    private TVShowDatabase tvShowDatabase;

    public TvShowDetailsViewModel(@NonNull Application application){
        super(application);
        tvShowDetailRepository = new TVShowDetailRepository();
        tvShowDatabase = TVShowDatabase.getTvShowDatabase(application);
    }

    public LiveData<TVShowDetailResponse> getTVShowDetails(String tvShowId){
        return tvShowDetailRepository.getTvShowDetails(tvShowId);
    }
    public Completable addToWatchList(TVShow tvShow){
        return tvShowDatabase.tvShowDao().addToWatchList(tvShow);
    }
    public Flowable<TVShow> getTVSHowFromWatchList(String tvShowId){
        return tvShowDatabase.tvShowDao().getTVShowFromWatchList(tvShowId);
    }

    public Completable removeTVShowFromWatchList(TVShow tvShow){
        return tvShowDatabase.tvShowDao().removeFromWatchList(tvShow);
    }
}
