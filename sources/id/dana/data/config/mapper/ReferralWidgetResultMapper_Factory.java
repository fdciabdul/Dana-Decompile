package id.dana.data.config.mapper;

import dagger.internal.Factory;

/* loaded from: classes8.dex */
public final class ReferralWidgetResultMapper_Factory implements Factory<ReferralWidgetResultMapper> {
    @Override // javax.inject.Provider
    public final ReferralWidgetResultMapper get() {
        return newInstance();
    }

    public static ReferralWidgetResultMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static ReferralWidgetResultMapper newInstance() {
        return new ReferralWidgetResultMapper();
    }

    /* loaded from: classes8.dex */
    static final class InstanceHolder {
        private static final ReferralWidgetResultMapper_Factory PlaceComponentResult = new ReferralWidgetResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
