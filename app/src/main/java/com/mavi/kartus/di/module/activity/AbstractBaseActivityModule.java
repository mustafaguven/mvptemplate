package com.mavi.kartus.di.module.activity;

import android.app.Activity;
import dagger.Module;

@Module public class AbstractBaseActivityModule extends ActivityModule {

  public AbstractBaseActivityModule(Activity activity) {
    super(activity);
  }
}
