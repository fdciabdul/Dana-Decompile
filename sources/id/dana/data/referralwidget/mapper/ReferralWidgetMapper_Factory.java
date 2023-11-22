package id.dana.data.referralwidget.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class ReferralWidgetMapper_Factory implements Factory<ReferralWidgetMapper> {
    @Override // javax.inject.Provider
    public final ReferralWidgetMapper get() {
        return newInstance();
    }

    public static ReferralWidgetMapper_Factory create() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    public static ReferralWidgetMapper newInstance() {
        return new ReferralWidgetMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final ReferralWidgetMapper_Factory BuiltInFictitiousFunctionClassFactory = new ReferralWidgetMapper_Factory();

        private InstanceHolder() {
        }
    }
}
