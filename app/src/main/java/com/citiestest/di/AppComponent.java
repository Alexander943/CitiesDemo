package com.citiestest.di;

import android.app.Application;

import com.citiestest.App;
import com.citiestest.di.module.ActivityBuilderModule;
import com.citiestest.di.module.AppModule;
import com.citiestest.di.module.DataModule;
import com.citiestest.di.module.FragmentBuildersModule;
import com.citiestest.di.module.NetworkModule;
import com.citiestest.di.module.RoomModule;
import com.citiestest.di.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * This is a Dagger component. Refer to {@link App} for the list of Dagger components
 * used in this application.
 * <p>
 * Even though Dagger allows annotating a {@link Component} as a singleton, the code
 * itself must ensure only one instance of the class is created. This is done in {@link App}.
 * //{@link AndroidSupportInjectionModule}
 * // is the module from Dagger.Android that helps with the generation
 * // and location of subcomponents.
 */

@Singleton
@Component(modules = {NetworkModule.class,
        DataModule.class,
        AppModule.class,
        ActivityBuilderModule.class,
        FragmentBuildersModule.class,
        ViewModelModule.class,
        RoomModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
