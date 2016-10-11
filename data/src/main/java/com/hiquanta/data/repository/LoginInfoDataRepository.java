package com.hiquanta.data.repository;

import android.util.Log;

import com.hiquanta.data.entity.mapper.LoginInfoEntityDataMapper;
import com.hiquanta.data.repository.datasource.LoginInfo.LoginInfoDataStore;
import com.hiquanta.data.repository.datasource.LoginInfo.LoginInfoDataStoreFactory;
import com.hiquanta.domain.LoginInfo;
import com.hiquanta.domain.User;
import com.hiquanta.domain.repository.LoginInfoRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by hiquanta on 2016/10/10.
 */
@Singleton
public class LoginInfoDataRepository implements LoginInfoRepository {
    private final  LoginInfoDataStoreFactory loginInfoDataStoreFactory;
    private final LoginInfoEntityDataMapper loginInfoEntityDataMapper;
    @Inject
    public LoginInfoDataRepository(LoginInfoDataStoreFactory loginInfoDataStoreFactory,
                                   LoginInfoEntityDataMapper loginInfoEntityDataMapper) {
        this.loginInfoDataStoreFactory = loginInfoDataStoreFactory;
        this.loginInfoEntityDataMapper = loginInfoEntityDataMapper;
    }

    @Override
    public Observable<LoginInfo> LoginInfo(String userName, String passWord) {
        Log.i("LoginInfoDataRepository",userName+":"+passWord);
        final LoginInfoDataStore loginInfoDataStore = this.loginInfoDataStoreFactory.create();
        return loginInfoDataStore.LoginInfoEntityDetails(userName, passWord).map(this.loginInfoEntityDataMapper::transform);
    }
}
