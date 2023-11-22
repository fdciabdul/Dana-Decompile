package id.dana.synccontact.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class ContactModelMapper_Factory implements Factory<ContactModelMapper> {
    public static ContactModelMapper_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.PlaceComponentResult;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final ContactModelMapper_Factory PlaceComponentResult = new ContactModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ContactModelMapper();
    }
}
