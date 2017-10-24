package com.mavi.kartus.di.module.activity;

import android.app.Activity;
import android.view.LayoutInflater;
import com.mavi.kartus.di.scope.PerActivity;
import com.squareup.picasso.Picasso;
import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

@Module public class ActivityModule {

  protected final Activity activity;

  public ActivityModule(Activity activity) {
    this.activity = activity;
  }

  public @Provides @PerActivity Activity provideActivityContext() {
    return this.activity;
  }

  public @Provides @PerActivity LayoutInflater provideLayoutInflater() {
    return LayoutInflater.from(this.activity);
  }

  public @Provides @PerActivity CompositeSubscription provideCompositeSubscription() {
    return new CompositeSubscription();
  }

  public @Provides @PerActivity Picasso providePicasso() {
    return Picasso.with(provideActivityContext());
  }
}

