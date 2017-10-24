package com.mavi.kartus.di.module.network;

import com.google.gson.Gson;
import com.mavi.kartus.BuildConfig;
import com.mavi.kartus.network.EndPoints;
import com.mavi.kartus.network.XService;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module public class RestServicesModule {

  private static final int CONNECT_TIMEOUT = 30;
  private static final int READ_TIMEOUT = 30;

  @Provides @Singleton Converter.Factory provideGsonFactory(Gson gson) {
    return GsonConverterFactory.create(gson);
  }

  @Provides @Singleton CallAdapter.Factory provideRxCallAdapterFactory() {
    return RxJavaCallAdapterFactory.create();
  }

  @Provides @Singleton
  public OkHttpClient provideOkHttpClient(@HeaderInterceptor Interceptor headerInterceptor,
      @LoggingInterceptor Interceptor loggingInterceptor) {
    return new OkHttpClient.Builder().addInterceptor(headerInterceptor)
        .addInterceptor(loggingInterceptor)
        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build();
  }

  @Provides @Singleton @LoggingInterceptor public Interceptor provideLoggingInterceptor() {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(
        BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
    return interceptor;
  }

  @Provides @Singleton public XService proviceXService(CallAdapter.Factory callAdapterFactory,
      Converter.Factory converterFactory, OkHttpClient okHttpClient) {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(EndPoints.BASE_URL)
        .addCallAdapterFactory(callAdapterFactory)
        .addConverterFactory(converterFactory)
        .client(okHttpClient)
        .build();
    return retrofit.create(XService.class);
  }

  @Provides @Singleton @HeaderInterceptor public Interceptor provideHeaderInterceptor() {
    return chain -> {
      Request request = chain.request();
      Request newRequest;
      Request.Builder builder = request.newBuilder()
          .addHeader("Content-Type", "application/json")
          .addHeader("User-Agent", System.getProperty("http.agent"))
          .addHeader("Accept", "application/json");
      newRequest = builder.build();
      return chain.proceed(newRequest);
    };
  }
}
