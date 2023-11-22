package id.dana.data.synccontact.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class ContactEntityMapper_Factory implements Factory<ContactEntityMapper> {
    @Override // javax.inject.Provider
    public final ContactEntityMapper get() {
        return newInstance();
    }

    public static ContactEntityMapper_Factory create() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static ContactEntityMapper newInstance() {
        return new ContactEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final ContactEntityMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new ContactEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}
