package com.mavi.kartus.di.component;

import com.mavi.kartus.di.module.activity.AbstractBaseActivityModule;
import com.mavi.kartus.di.scope.PerActivity;
import com.mavi.kartus.view.AbstractBaseActivity;
import dagger.Subcomponent;

@PerActivity @Subcomponent(modules = {
    AbstractBaseActivityModule.class
}) public interface AbstractBaseActivityComponent {
  void inject(AbstractBaseActivity activity);
}
