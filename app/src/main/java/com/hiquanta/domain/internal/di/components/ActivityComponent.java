package com.hiquanta.domain.internal.di.components;

import android.app.Activity;

import com.hiquanta.domain.internal.di.modules.ActivityModule;

import dagger.Component;

/**
 * Created by hiquanta on 2016/9/26.
 */

@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}