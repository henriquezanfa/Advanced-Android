package com.refinaria.advancedandroidcourse.trending;

import android.annotation.SuppressLint;

import com.refinaria.advancedandroidcourse.data.RepoRequester;
import com.refinaria.advancedandroidcourse.di.ScreenScope;
import com.refinaria.advancedandroidcourse.models.Repo;

import javax.inject.Inject;

@ScreenScope
public class TrendingReposPresenter implements RepoAdapter.RepoClickedListener {

    private final TrendingReposViewModel viewModel;
    private final RepoRequester repoRequester;

    @Inject
    TrendingReposPresenter(TrendingReposViewModel trendingReposViewModel, RepoRequester repoRequester) {
        this.viewModel = trendingReposViewModel;
        this.repoRequester = repoRequester;
        loadRepos();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @SuppressLint("CheckResult")
    private void loadRepos() {
        repoRequester.getTrendingRepos()
                .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
                .doOnEvent((d, t) -> viewModel.loadingUpdated().accept(false))
                .subscribe(viewModel.reposUpdated(), viewModel.onError());
    }

    @Override
    public void onRepoClicked(Repo repo) {

    }
}
