package com.refinaria.advancedandroidcourse.data;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface RepoService {
    @GET("search/repositories?q=language:java&order=desc&sort=starts")
    Single<TrendingReposResponse> getTrendingRepos();
}