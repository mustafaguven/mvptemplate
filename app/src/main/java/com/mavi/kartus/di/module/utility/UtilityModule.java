package com.mavi.kartus.di.module.utility;

import android.os.AsyncTask;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mavi.kartus.bus.RxEventBus;
import com.mavi.kartus.constant.Constant;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Named;
import javax.inject.Singleton;

@Module public class UtilityModule {

  @Provides @Singleton public RxEventBus provideBus() {
    return new RxEventBus();
  }

  @Provides @Singleton public Gson provideGson() {
    return new GsonBuilder().create();
  }

  @Provides @Singleton @Named(Constant.MAIN_SCHEDULER) public Scheduler provideMainScheduler() {
    return AndroidSchedulers.mainThread();
  }

  @Provides @Singleton @Named(Constant.WORKER_SCHEDULER) public Scheduler provideWorkerScheduler() {
    return Schedulers.from(AsyncTask.THREAD_POOL_EXECUTOR);
  }
}
