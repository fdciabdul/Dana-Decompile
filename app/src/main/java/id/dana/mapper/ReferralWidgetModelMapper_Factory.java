package id.dana.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class ReferralWidgetModelMapper_Factory implements Factory<ReferralWidgetModelMapper> {
    public static ReferralWidgetModelMapper_Factory PlaceComponentResult() {
        return InstanceHolder.PlaceComponentResult;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final ReferralWidgetModelMapper_Factory PlaceComponentResult = new ReferralWidgetModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ReferralWidgetModelMapper();
    }
}
