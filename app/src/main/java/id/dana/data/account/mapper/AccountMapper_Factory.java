package id.dana.data.account.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class AccountMapper_Factory implements Factory<AccountMapper> {
    @Override // javax.inject.Provider
    public final AccountMapper get() {
        return newInstance();
    }

    public static AccountMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static AccountMapper newInstance() {
        return new AccountMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final AccountMapper_Factory MyBillsEntityDataFactory = new AccountMapper_Factory();

        private InstanceHolder() {
        }
    }
}
