package com.citiestest.ui.main;

import android.os.Bundle;

import com.citiestest.R;
import com.citiestest.ui.BaseActivity;
import com.citiestest.ui.NavigationListener;
import com.citiestest.ui.cities.CitiesFragment;
import com.citiestest.util.ActivityUtils;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import butterknife.BindView;


public class MainActivity extends BaseActivity implements NavigationListener {

    @Inject
    CitiesFragment mCitiesFragment;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void pushFragment(Fragment fragment) {
        if (fragment != null) {
            ActivityUtils.pushFragment(getSupportFragmentManager(), fragment, R.id.container);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.container_act;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.cities_list);

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if (fragment == null) {
            fragment = mCitiesFragment;
            ActivityUtils.addFragment(getSupportFragmentManager(), fragment, R.id.container);
        }
    }
}
