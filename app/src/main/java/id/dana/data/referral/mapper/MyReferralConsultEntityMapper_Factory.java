package id.dana.data.referral.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class MyReferralConsultEntityMapper_Factory implements Factory<MyReferralConsultEntityMapper> {
    @Override // javax.inject.Provider
    public final MyReferralConsultEntityMapper get() {
        return newInstance();
    }

    public static MyReferralConsultEntityMapper_Factory create() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static MyReferralConsultEntityMapper newInstance() {
        return new MyReferralConsultEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final MyReferralConsultEntityMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new MyReferralConsultEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}
