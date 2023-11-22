package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.ipg.IpgGuideContract;

/* loaded from: classes4.dex */
public final class IpgModule_ProvideViewFactory implements Factory<IpgGuideContract.View> {
    private final IpgModule PlaceComponentResult;

    public static IpgGuideContract.View getAuthRequestContext(IpgModule ipgModule) {
        return (IpgGuideContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(ipgModule.getKClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (IpgGuideContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
