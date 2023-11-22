package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.pushverify.view.verificationdetail.PushVerifyContract;

/* loaded from: classes4.dex */
public final class PushVerifyModule_ProvideView$app_productionReleaseFactory implements Factory<PushVerifyContract.View> {
    private final PushVerifyModule MyBillsEntityDataFactory;

    private PushVerifyModule_ProvideView$app_productionReleaseFactory(PushVerifyModule pushVerifyModule) {
        this.MyBillsEntityDataFactory = pushVerifyModule;
    }

    public static PushVerifyModule_ProvideView$app_productionReleaseFactory KClassImpl$Data$declaredNonStaticMembers$2(PushVerifyModule pushVerifyModule) {
        return new PushVerifyModule_ProvideView$app_productionReleaseFactory(pushVerifyModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PushVerifyContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getBuiltInFictitiousFunctionClassFactory());
    }
}
