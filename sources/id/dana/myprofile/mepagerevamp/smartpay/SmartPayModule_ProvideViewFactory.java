package id.dana.myprofile.mepagerevamp.smartpay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.myprofile.mepagerevamp.smartpay.SmartPayContract;

/* loaded from: classes5.dex */
public final class SmartPayModule_ProvideViewFactory implements Factory<SmartPayContract.View> {
    private final SmartPayModule KClassImpl$Data$declaredNonStaticMembers$2;

    private SmartPayModule_ProvideViewFactory(SmartPayModule smartPayModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = smartPayModule;
    }

    public static SmartPayModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(SmartPayModule smartPayModule) {
        return new SmartPayModule_ProvideViewFactory(smartPayModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SmartPayContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getMyBillsEntityDataFactory());
    }
}
