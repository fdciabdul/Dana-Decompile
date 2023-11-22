package id.dana.dialog;

import dagger.internal.Factory;

/* loaded from: classes4.dex */
public final class RiskRejectDialog_Factory implements Factory<RiskRejectDialog> {
    public static RiskRejectDialog_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.getAuthRequestContext;
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final RiskRejectDialog_Factory getAuthRequestContext = new RiskRejectDialog_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RiskRejectDialog();
    }
}
