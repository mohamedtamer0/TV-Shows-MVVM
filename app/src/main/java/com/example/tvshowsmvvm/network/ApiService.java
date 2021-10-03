package com.example.tvshowsmvvm.network;

import com.example.tvshowsmvvm.responses.TVShowDetailResponse;
import com.example.tvshowsmvvm.responses.TVShowsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("most-popular")
    Call<TVShowsResponse> getMostPopularTVShows(@Query("page") int page);

    @GET("show-details")
    Call<TVShowDetailResponse> getTVShowDetails(@Query("q") String tvShowId);


    @GET("search")
    Call<TVShowsResponse> searchTVShow(@Query("q") String query, @Query("page") int page);



}
