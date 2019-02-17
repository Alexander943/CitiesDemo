package com.citiestest.ui.cities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.citiestest.R;
import com.citiestest.data.city.model.City;
import com.citiestest.ui.BaseFragment;
import com.citiestest.ui.BaseListAdapter;
import com.citiestest.ui.NavigationListener;
import com.citiestest.ui.map.MapFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;


public class CitiesFragment extends BaseFragment implements BaseListAdapter.OnItemClickListener {

    private CitiesAdapter mAdapter;

    private CitiesViewModel mViewModel;

    private NavigationListener mNavigationListener;

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.progress)
    ProgressBar mProgressBar;


    @Override
    protected int getFragmentLayout() {
        return R.layout.cities_frag;
    }

    @Inject
    public CitiesFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof NavigationListener) {
            mNavigationListener = (NavigationListener) context;
        }
    }

    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdapter = new CitiesAdapter(new ArrayList<>(), this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(mRecyclerView.getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(
                ContextCompat.getDrawable(getContext(), R.drawable.divider_recycler));

        mRecyclerView.addItemDecoration(dividerItemDecoration);

        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(CitiesViewModel.class);
        mViewModel.loading().observe(this, this::processLoading);
        mViewModel.response().observe(this, this::processResponse);

        if (savedInstanceState == null) {
            mViewModel.loadCities();
            setArguments(new Bundle());
        }
    }

    private void processLoading(Boolean isLoading) {
        if (isLoading) {
            mRecyclerView.setVisibility(View.GONE);
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
        }
    }

    private void processResponse(List<City> cities) {
        if (mAdapter != null) {
            mAdapter.updateItems(cities);
        }
    }

    @Override
    public void onItemClick(int position) {
        if (mAdapter == null || mAdapter.getItem(position) == null || mNavigationListener == null) {
            return;
        }
        mNavigationListener.pushFragment(MapFragment.newInstance(mAdapter.getItem(position)));
    }
}
