package com.citiestest.ui;

import androidx.fragment.app.Fragment;

public interface NavigationListener<T extends Fragment> {

    void pushFragment(T fragment);
}
