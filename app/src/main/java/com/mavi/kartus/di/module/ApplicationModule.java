package com.mavi.kartus.di.module;

import com.mavi.kartus.KartusApplication;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public class ApplicationModule {
  private final KartusApplication application;

  public ApplicationModule(KartusApplication application) {
    this.application = application;
  }

  @Provides @Singleton KartusApplication provideApplication() {
    return this.application;
  }
}
