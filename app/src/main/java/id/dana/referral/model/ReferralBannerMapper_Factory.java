package id.dana.referral.model;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class ReferralBannerMapper_Factory implements Factory<ReferralBannerMapper> {
    public static ReferralBannerMapper_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final ReferralBannerMapper_Factory MyBillsEntityDataFactory = new ReferralBannerMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ReferralBannerMapper();
    }
}
