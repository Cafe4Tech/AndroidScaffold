package com.hiquanta.data.net.component;

import com.hiquanta.data.net.RestApiWrapper;
import com.hiquanta.data.net.module.RestApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hiquanta on 2016/10/8.
 */
@Singleton
@Component(
        modules = RestApiModule.class
)
public interface RestApiComponent {
    void inject(RestApiWrapper restApiWrapper);
}
