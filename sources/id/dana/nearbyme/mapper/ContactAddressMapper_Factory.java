package id.dana.nearbyme.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class ContactAddressMapper_Factory implements Factory<ContactAddressMapper> {
    public static ContactAddressMapper_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final ContactAddressMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new ContactAddressMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ContactAddressMapper();
    }
}
