package com.citiestest.ui;

import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel {

    protected final CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    protected void onCleared() {
        mCompositeDisposable.clear();
    }
}
