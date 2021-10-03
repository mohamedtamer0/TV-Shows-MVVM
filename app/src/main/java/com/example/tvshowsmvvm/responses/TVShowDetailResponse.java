package com.example.tvshowsmvvm.responses;

import com.example.tvshowsmvvm.models.TVShowDetails;
import com.google.gson.annotations.SerializedName;

public class TVShowDetailResponse {
    @SerializedName("tvShow")
    private TVShowDetails tvShowDetail;

    public TVShowDetails getTvShowDetail() {
        return tvShowDetail;
    }
}
