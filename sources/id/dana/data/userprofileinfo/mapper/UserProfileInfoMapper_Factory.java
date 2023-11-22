package id.dana.data.userprofileinfo.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class UserProfileInfoMapper_Factory implements Factory<UserProfileInfoMapper> {
    @Override // javax.inject.Provider
    public final UserProfileInfoMapper get() {
        return newInstance();
    }

    public static UserProfileInfoMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static UserProfileInfoMapper newInstance() {
        return new UserProfileInfoMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final UserProfileInfoMapper_Factory PlaceComponentResult = new UserProfileInfoMapper_Factory();

        private InstanceHolder() {
        }
    }
}
