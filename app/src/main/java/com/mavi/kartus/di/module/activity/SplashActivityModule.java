package com.mavi.kartus.di.module.activity;

import android.app.Activity;
import com.mavi.kartus.di.scope.PerActivity;
import com.mavi.kartus.contract.SplashContract;
import dagger.Module;
import dagger.Provides;

@Module public class SplashActivityModule extends AbstractBaseActivityModule {
  public SplashActivityModule(Activity activity) {
    super(activity);
  }

  @Provides @PerActivity SplashContract.View provideView() {
    return ((SplashContract.View) provideActivityContext());
  }
}
