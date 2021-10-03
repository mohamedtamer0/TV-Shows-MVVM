package com.example.tvshowsmvvm.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tvshowsmvvm.R;
import com.example.tvshowsmvvm.adapters.WatchListAdapter;
import com.example.tvshowsmvvm.databinding.ActivityWatchListBinding;
import com.example.tvshowsmvvm.listeners.WatchlistListener;
import com.example.tvshowsmvvm.models.TVShow;
import com.example.tvshowsmvvm.utilities.TempDataHolder;
import com.example.tvshowsmvvm.viewmodels.WatchListViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class WatchListActivity extends AppCompatActivity implements WatchlistListener {

    private ActivityWatchListBinding activityWatchListBinding;
    private WatchListViewModel viewModel;
    private WatchListAdapter watchListAdapter;
    private List<TVShow> watchList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityWatchListBinding = DataBindingUtil.setContentView(this, R.layout.activity_watch_list);
        doInitalization();
    }
    private void doInitalization(){
        viewModel = new ViewModelProvider(this).get(WatchListViewModel.class);
        activityWatchListBinding.imageBack.setOnClickListener(v -> onBackPressed());
        watchList = new ArrayList<>();
        loadWatchList();
    }

    private void loadWatchList(){
        activityWatchListBinding.setIsLoading(true);
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(viewModel.loadWatchlist().subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(tvShows -> {
                    activityWatchListBinding.setIsLoading(false);
                    if (watchList.size() > 0){
                        watchList.clear();
                    }
                    watchList.addAll(tvShows);
                    watchListAdapter = new WatchListAdapter(watchList,this);
                    activityWatchListBinding.watchListRecyclerView.setAdapter(watchListAdapter);
                    activityWatchListBinding.watchListRecyclerView.setVisibility(View.VISIBLE);
                    compositeDisposable.dispose();
                }));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (TempDataHolder.IS_WATCHLIST_UPDATED){
            loadWatchList();
            TempDataHolder.IS_WATCHLIST_UPDATED = false;
        }

    }

    @Override
    public void onTVShowClicked(TVShow tvShow) {
        Intent intent = new Intent(getApplicationContext(),TVShowsDetailActivity.class);
        intent.putExtra("tvShow",tvShow);
        startActivity(intent);
    }

    @Override
    public void removeTVShowFromWatchList(TVShow tvShow, int position) {
        CompositeDisposable compositeDisposableForDelete  = new CompositeDisposable();
        compositeDisposableForDelete.add(viewModel.removeTVShowFromWatchList(tvShow).subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(()->{
                    watchList.remove(position);
                    watchListAdapter.notifyItemRemoved(position);
                    watchListAdapter.notifyItemChanged(position,watchListAdapter.getItemCount());
                    compositeDisposableForDelete.dispose();
                }));
    }
}