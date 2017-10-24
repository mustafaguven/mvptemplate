package com.mavi.kartus.di.component;

import com.mavi.kartus.KartusApplication;
import com.mavi.kartus.di.module.ApplicationModule;
import com.mavi.kartus.di.module.cache.CacheModule;
import com.mavi.kartus.di.module.network.RestServicesModule;
import com.mavi.kartus.di.module.utility.UtilityModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = {
    ApplicationModule.class, UtilityModule.class, RestServicesModule.class, CacheModule.class
}) public interface KartusApplicationComponent extends ApplicationComponent {

  final class InitiliazerClass {
    private InitiliazerClass() {
    }

    public static KartusApplicationComponent init(KartusApplication application) {
      return DaggerKartusApplicationComponent.builder()
          .applicationModule(new ApplicationModule(application))
          .build();
    }
  }
}
