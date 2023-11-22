package id.dana.richview.contactselector;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class UserContactMapper_Factory implements Factory<UserContactMapper> {
    public static UserContactMapper_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.PlaceComponentResult;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final UserContactMapper_Factory PlaceComponentResult = new UserContactMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UserContactMapper();
    }
}
