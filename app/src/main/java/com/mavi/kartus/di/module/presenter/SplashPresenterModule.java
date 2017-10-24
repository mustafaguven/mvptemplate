package com.mavi.kartus.di.module.presenter;

import com.mavi.kartus.contract.SplashContract;
import com.mavi.kartus.di.scope.PerActivity;
import com.mavi.kartus.presenter.splash.SplashPresenter;
import dagger.Module;
import dagger.Provides;

@Module public class SplashPresenterModule {

  @PerActivity @Provides
  public SplashContract.Presenter providePresenter(SplashContract.View view) {
    return new SplashPresenter(view);
  }
}
