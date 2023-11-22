package id.dana.contract.ott;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.ott.OttVerifyContract;

/* loaded from: classes4.dex */
public final class OttVerifyModule_ProvideViewFactory implements Factory<OttVerifyContract.View> {
    private final OttVerifyModule KClassImpl$Data$declaredNonStaticMembers$2;

    private OttVerifyModule_ProvideViewFactory(OttVerifyModule ottVerifyModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = ottVerifyModule;
    }

    public static OttVerifyModule_ProvideViewFactory PlaceComponentResult(OttVerifyModule ottVerifyModule) {
        return new OttVerifyModule_ProvideViewFactory(ottVerifyModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OttVerifyContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getGetAuthRequestContext());
    }
}
