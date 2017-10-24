package com.mavi.kartus.di.component;

import com.mavi.kartus.di.module.activity.SplashActivityModule;
import com.mavi.kartus.di.module.presenter.SplashPresenterModule;
import com.mavi.kartus.di.scope.PerActivity;
import com.mavi.kartus.view.splash.SplashActivity;
import dagger.Subcomponent;

@PerActivity @Subcomponent(modules = { SplashActivityModule.class, SplashPresenterModule.class })
public interface SplashComponent {
  void inject(SplashActivity activity);
}
