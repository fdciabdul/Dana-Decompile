package id.dana.sendmoney_v2.landing.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney_v2.smartfriction.contract.SuspiciousAccountContract;

/* loaded from: classes5.dex */
public final class SuspiciousAccountModule_ProvideViewFactory implements Factory<SuspiciousAccountContract.View> {
    private final SuspiciousAccountModule MyBillsEntityDataFactory;

    private SuspiciousAccountModule_ProvideViewFactory(SuspiciousAccountModule suspiciousAccountModule) {
        this.MyBillsEntityDataFactory = suspiciousAccountModule;
    }

    public static SuspiciousAccountModule_ProvideViewFactory MyBillsEntityDataFactory(SuspiciousAccountModule suspiciousAccountModule) {
        return new SuspiciousAccountModule_ProvideViewFactory(suspiciousAccountModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SuspiciousAccountContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
