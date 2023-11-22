package id.dana.toggle.locationpermission;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class LocationPermissionSubject_Factory implements Factory<LocationPermissionSubject> {
    public static LocationPermissionSubject_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.PlaceComponentResult;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final LocationPermissionSubject_Factory PlaceComponentResult = new LocationPermissionSubject_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LocationPermissionSubject();
    }
}
