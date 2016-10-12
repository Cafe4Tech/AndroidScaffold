package com.hiquanta.scaffold.internal.di.components;

import android.content.Context;


import com.hiquanta.domain.executor.PostExecutionThread;
import com.hiquanta.domain.executor.ThreadExecutor;
import com.hiquanta.domain.repository.LoginInfoRepository;
import com.hiquanta.domain.repository.UserRepository;
import com.hiquanta.scaffold.internal.di.modules.ApplicationModule;

import com.hiquanta.scaffold.internal.di.modules.LoginModule;
import com.hiquanta.scaffold.internal.di.modules.UserModule;
import com.hiquanta.scaffold.view.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hiquanta on 2016/9/26.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    UserRepository userRepository();
    LoginInfoRepository loginRepository();
    LoginComponent plus(LoginModule loginModule);
   UserComponent plus(UserModule userModule);
}
