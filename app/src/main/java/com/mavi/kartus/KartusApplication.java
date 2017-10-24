package com.mavi.kartus;

import android.app.Application;
import com.mavi.kartus.di.component.ApplicationComponent;
import com.mavi.kartus.di.component.KartusApplicationComponent;

public class KartusApplication extends Application {

  protected ApplicationComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    injectComponents();
  }

  public void injectComponents() {
    if (this.applicationComponent == null) {
      this.applicationComponent = KartusApplicationComponent.InitiliazerClass.init(this);
    }
    this.applicationComponent.inject(this);
  }

  public ApplicationComponent getApplicationComponent() {
    return this.applicationComponent;
  }
}
