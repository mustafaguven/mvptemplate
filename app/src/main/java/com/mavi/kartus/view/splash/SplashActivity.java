package com.mavi.kartus.view.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import butterknife.ButterKnife;
import com.mavi.kartus.R;
import com.mavi.kartus.contract.SplashContract;
import com.mavi.kartus.di.component.SplashComponent;
import com.mavi.kartus.di.module.activity.SplashActivityModule;
import com.mavi.kartus.view.AbstractBaseActivity;
import javax.inject.Inject;

public class SplashActivity extends AbstractBaseActivity implements SplashContract.View {

  private SplashComponent splashComponent;

  @Inject SplashContract.Presenter presenter;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);
    inject();
    presenter.onCreate();
  }

  private void inject() {
    if (splashComponent == null) {
      splashComponent =
          (getKartusApplication()).getApplicationComponent().plus(new SplashActivityModule(this));
    }
    splashComponent.inject(this);
    ButterKnife.bind(this);
  }
}
