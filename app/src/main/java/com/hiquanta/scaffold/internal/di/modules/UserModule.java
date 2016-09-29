package com.hiquanta.scaffold.internal.di.modules;



import com.hiquanta.domain.executor.PostExecutionThread;
import com.hiquanta.domain.executor.ThreadExecutor;
import com.hiquanta.domain.interactor.GetUserDetails;
import com.hiquanta.domain.interactor.GetUserList;
import com.hiquanta.domain.interactor.UseCase;
import com.hiquanta.domain.repository.UserRepository;
import com.hiquanta.scaffold.internal.di.PerActivity;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hiquanta on 2016/9/26.
 */
@Module
public class UserModule {
    private int userId = -1;

    public UserModule() {}

    public UserModule(int userId) {
        this.userId = userId;
    }
    @Provides
    @PerActivity
    @Named("userList")
    UseCase provideGetUserListUseCase(
            GetUserList getUserList) {
        return getUserList;
    }
    @Provides
    @PerActivity
   @Named("userDetails")
    UseCase provideGetUserDetailsUseCase(
            UserRepository userRepository, ThreadExecutor threadExecutor,
            PostExecutionThread postExecutionThread) {
        return new GetUserDetails(userId, userRepository, threadExecutor, postExecutionThread);
    }
}
