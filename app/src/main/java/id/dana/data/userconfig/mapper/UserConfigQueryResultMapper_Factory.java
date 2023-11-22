package id.dana.data.userconfig.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class UserConfigQueryResultMapper_Factory implements Factory<UserConfigQueryResultMapper> {
    @Override // javax.inject.Provider
    public final UserConfigQueryResultMapper get() {
        return newInstance();
    }

    public static UserConfigQueryResultMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static UserConfigQueryResultMapper newInstance() {
        return new UserConfigQueryResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final UserConfigQueryResultMapper_Factory MyBillsEntityDataFactory = new UserConfigQueryResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
