package com.citiestest.ui.map;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.citiestest.R;
import com.citiestest.data.city.model.City;
import com.citiestest.ui.BaseFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;


public class MapFragment extends BaseFragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private static final String KEY_CITY = "key.city.cityId";
    private static final float DEFAULT_ZOOM = 15.0f;

    private MapViewModel mViewModel;
    private GoogleMap map;

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    @Override
    protected int getFragmentLayout() {
        return R.layout.map_frag;
    }

    public static MapFragment newInstance(int cityId) {
        Bundle args = new Bundle();
        args.putInt(KEY_CITY, cityId);
        MapFragment fragment = new MapFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NotNull @NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment)
                this.getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MapViewModel.class);

        // request values
        if (savedInstanceState == null && getArguments() != null) {
//            mViewModel.simpleAction(getArguments().getParcelable(KEY_CITY));
//            setArguments(new Bundle());
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        mViewModel.response().observe(this, this::showMarkerOnMap);
    }

    private void showMarkerOnMap(City city) {
        if (city == null) {
            return;
        }
        LatLng position = new LatLng(city.getCityLatitude(), city.getCityLongitude());
        String title = city.getCityName();
        // add marker
        MarkerOptions markerOptions = new MarkerOptions()
                .position(position)
                .title(title);
        map.addMarker(markerOptions);
        // camera move
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(position)
                .zoom(DEFAULT_ZOOM)
                .build();
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        // show action in debug console
        Log.e(TAG, "showMarkerOnMap: ");
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}
