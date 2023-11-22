package id.dana.sendmoney.ui.groupsend.recipient.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class UserContactMapper_Factory implements Factory<UserContactMapper> {
    public static UserContactMapper_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final UserContactMapper_Factory MyBillsEntityDataFactory = new UserContactMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UserContactMapper();
    }
}
