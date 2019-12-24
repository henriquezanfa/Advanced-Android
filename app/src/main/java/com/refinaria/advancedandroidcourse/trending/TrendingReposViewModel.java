package com.refinaria.advancedandroidcourse.trending;

import com.jakewharton.rxrelay2.BehaviorRelay;
import com.refinaria.advancedandroidcourse.R;
import com.refinaria.advancedandroidcourse.di.ScreenScope;
import com.refinaria.advancedandroidcourse.models.Repo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

@ScreenScope
class TrendingReposViewModel {

    private final BehaviorRelay<List<Repo>> reposRelay = BehaviorRelay.create();
    private final BehaviorRelay<Integer> errorRelay = BehaviorRelay.create();
    private final BehaviorRelay<Boolean> loadingRelay = BehaviorRelay.create();

    @Inject
    TrendingReposViewModel() {

    }

    Observable<List<Repo>> repos() {
        return reposRelay;
    }

    Observable<Integer> error() {
        return errorRelay;
    }

    Observable<Boolean> loading() {
        return loadingRelay;
    }

    Consumer<Boolean> loadingUpdated() {
        return loadingRelay;
    }

    Consumer<List<Repo>> reposUpdated() {
        errorRelay.accept(-1);
        return reposRelay;
    }

    Consumer<Throwable> onError() {
        return throwable -> {
            Timber.e(throwable, "Error loading repos");
            errorRelay.accept(R.string.api_error_repos);
        };
    }
}
