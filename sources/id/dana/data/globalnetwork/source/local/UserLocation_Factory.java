package id.dana.data.globalnetwork.source.local;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class UserLocation_Factory implements Factory<UserLocation> {
    @Override // javax.inject.Provider
    public final UserLocation get() {
        return newInstance();
    }

    public static UserLocation_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static UserLocation newInstance() {
        return new UserLocation();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final UserLocation_Factory PlaceComponentResult = new UserLocation_Factory();

        private InstanceHolder() {
        }
    }
}
