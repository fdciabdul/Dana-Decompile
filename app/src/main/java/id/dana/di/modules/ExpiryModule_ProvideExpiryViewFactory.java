package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.sendmoney.ExpiryContract;

/* loaded from: classes4.dex */
public final class ExpiryModule_ProvideExpiryViewFactory implements Factory<ExpiryContract.View> {
    private final ExpiryModule PlaceComponentResult;

    private ExpiryModule_ProvideExpiryViewFactory(ExpiryModule expiryModule) {
        this.PlaceComponentResult = expiryModule;
    }

    public static ExpiryModule_ProvideExpiryViewFactory getAuthRequestContext(ExpiryModule expiryModule) {
        return new ExpiryModule_ProvideExpiryViewFactory(expiryModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ExpiryContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
