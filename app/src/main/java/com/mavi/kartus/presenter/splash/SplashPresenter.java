package com.mavi.kartus.presenter.splash;

import com.mavi.kartus.contract.SplashContract;

public class SplashPresenter implements SplashContract.Presenter {

  private final SplashContract.View view;

  public SplashPresenter(SplashContract.View view) {
    this.view = view;
  }

  @Override public void onCreate() {
    //do nothing yet
  }

  @Override public void onDestroy() {
    //do nothing yet
  }
}
