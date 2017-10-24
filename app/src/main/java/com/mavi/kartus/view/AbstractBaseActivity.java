package com.mavi.kartus.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import com.mavi.kartus.KartusApplication;
import com.mavi.kartus.bus.RxEventBus;
import com.mavi.kartus.di.component.AbstractBaseActivityComponent;
import com.mavi.kartus.di.module.activity.AbstractBaseActivityModule;
import javax.inject.Inject;
import timber.log.Timber;

public class AbstractBaseActivity extends AppCompatActivity {

  @Inject protected RxEventBus bus;

  private AbstractBaseActivityComponent component;
  protected Toolbar toolbar;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    inject();
  }

  private void inject() {
    if (component == null) {
      component = (getKartusApplication()).getApplicationComponent()
          .plus(new AbstractBaseActivityModule(this));
    }
    component.inject(this);
  }

  protected KartusApplication getKartusApplication() {
    return ((KartusApplication) getApplication());
  }

  protected void prepareRecyclerviewLayoutManager(RecyclerView view) {
    LinearLayoutManager layoutManager =
        new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    view.setNestedScrollingEnabled(false);
    view.setLayoutManager(layoutManager);
    view.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
/*    itemAnimator.setAddDuration(1000);
    itemAnimator.setRemoveDuration(1000);*/
    view.setItemAnimator(itemAnimator);
  }

  protected void generateToolbarAsActionBar(Toolbar view) {
    this.toolbar = view;
    if (toolbar != null) {
      setSupportActionBar(toolbar);
      if (getSupportActionBar() != null) {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
      }
    }
  }

  public void onError(Throwable throwable) {
    Timber.e(throwable);
    Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
  }
}
