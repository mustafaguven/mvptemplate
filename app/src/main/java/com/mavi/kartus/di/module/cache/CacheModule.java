package com.mavi.kartus.di.module.cache;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.mavi.kartus.KartusApplication;
import com.mavi.kartus.bus.RxEventBus;
import com.mavi.kartus.cache.ApplicationCache;
import com.mavi.kartus.constant.Constant;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;

@Module public class CacheModule {

  @Provides @Singleton @Named(Constant.APPLICATION_SHARED_PREFERENCES)
  SharedPreferences provideApplicationSharedPreference(KartusApplication application) {
    return application.getSharedPreferences(Constant.APPLICATION_SHARED_PREFERENCES,
        Context.MODE_PRIVATE);
  }

  @Provides @Singleton ApplicationCache provideApplicationCache(
      @Named(Constant.APPLICATION_SHARED_PREFERENCES) SharedPreferences applicationPreferences,
      Gson gson, RxEventBus bus) {
    return new ApplicationCache(applicationPreferences, gson, bus);
  }
}
