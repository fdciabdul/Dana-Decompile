package id.dana.data.user.source.persistence;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.base.BasePersistenceDao;
import id.dana.data.user.UserInfoMapper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalUserInfoData_Factory implements Factory<LocalUserInfoData> {
    private final Provider<BasePersistenceDao> persistenceDaoProvider;
    private final Provider<UserInfoMapper> userInfoMapperProvider;

    public LocalUserInfoData_Factory(Provider<UserInfoMapper> provider, Provider<BasePersistenceDao> provider2) {
        this.userInfoMapperProvider = provider;
        this.persistenceDaoProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final LocalUserInfoData get() {
        return newInstance(this.userInfoMapperProvider.get(), DoubleCheck.MyBillsEntityDataFactory(this.persistenceDaoProvider));
    }

    public static LocalUserInfoData_Factory create(Provider<UserInfoMapper> provider, Provider<BasePersistenceDao> provider2) {
        return new LocalUserInfoData_Factory(provider, provider2);
    }

    public static LocalUserInfoData newInstance(UserInfoMapper userInfoMapper, Lazy<BasePersistenceDao> lazy) {
        return new LocalUserInfoData(userInfoMapper, lazy);
    }
}
