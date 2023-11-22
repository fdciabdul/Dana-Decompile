package id.dana.data.globalnetwork.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class ForexResultMapper_Factory implements Factory<ForexResultMapper> {
    @Override // javax.inject.Provider
    public final ForexResultMapper get() {
        return newInstance();
    }

    public static ForexResultMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static ForexResultMapper newInstance() {
        return new ForexResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final ForexResultMapper_Factory PlaceComponentResult = new ForexResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
