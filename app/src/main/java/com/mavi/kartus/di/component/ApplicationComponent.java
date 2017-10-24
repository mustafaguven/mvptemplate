package com.mavi.kartus.di.component;

import com.mavi.kartus.KartusApplication;
import com.mavi.kartus.di.module.activity.AbstractBaseActivityModule;

public interface ApplicationComponent {
  void inject(KartusApplication application);

  AbstractBaseActivityComponent plus(AbstractBaseActivityModule abstractBaseActivityModule);

}
