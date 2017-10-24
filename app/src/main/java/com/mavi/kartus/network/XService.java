package com.mavi.kartus.network;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface XService {

  @GET("users") Single<Object> getXMethod();
}
