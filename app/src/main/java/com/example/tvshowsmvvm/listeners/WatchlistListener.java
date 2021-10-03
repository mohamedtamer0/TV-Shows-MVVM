package com.example.tvshowsmvvm.listeners;

import com.example.tvshowsmvvm.models.TVShow;

public interface WatchlistListener {
    void onTVShowClicked(TVShow tvShow);
    void removeTVShowFromWatchList(TVShow tvShow,int position);
}
