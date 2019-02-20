package com.citiestest.ui.cities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.citiestest.ui.BaseListAdapter;
import com.citiestest.R;
import com.citiestest.data.city.model.City;
import com.citiestest.ui.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;


public class CitiesAdapter extends BaseListAdapter<City, CitiesAdapter.CityViewHolder> {

    CitiesAdapter(List<City> items, OnItemClickListener onItemClickListener) {
        super(items, onItemClickListener);
    }

    @NotNull
    @Override
    public CityViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cities_list_item, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NotNull CityViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

        City city = items.get(position);

        if (city == null) {
            return;
        }
        if (city.getCityName() != null) {
            holder.cityName.setText(city.getCityName());
        }
    }

    static class CityViewHolder extends BaseViewHolder {

        @BindView(R.id.city_name)
        TextView cityName;

        CityViewHolder(View itemView) {
            super(itemView);
        }
    }
}
