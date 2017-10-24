package com.mavi.kartus.cache;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.mavi.kartus.bus.RxEventBus;

public class ApplicationCache {

  private final SharedPreferences applicationSharedPreferences;
  private final Gson gson;
  private final RxEventBus bus;

  public ApplicationCache(SharedPreferences applicationPreferences, Gson gson, RxEventBus bus) {
    this.applicationSharedPreferences = applicationPreferences;
    this.gson = gson;
    this.bus = bus;
  }

  private <T> T getObjectWithGenericDeserializer(String key, Class<T> clz) {
    return gson.fromJson(applicationSharedPreferences.getString(key, null), clz);
  }

  private <T> void setObjectWithGenericSerializer(String key, T t) {
    this.applicationSharedPreferences.edit().putString(key, gson.toJson(t)).apply();
  }

  public void removeApplicationCache() {
    applicationSharedPreferences.edit().clear().apply();
  }
}
