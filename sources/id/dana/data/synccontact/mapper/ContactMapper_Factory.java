package id.dana.data.synccontact.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class ContactMapper_Factory implements Factory<ContactMapper> {
    @Override // javax.inject.Provider
    public final ContactMapper get() {
        return newInstance();
    }

    public static ContactMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static ContactMapper newInstance() {
        return new ContactMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final ContactMapper_Factory MyBillsEntityDataFactory = new ContactMapper_Factory();

        private InstanceHolder() {
        }
    }
}
