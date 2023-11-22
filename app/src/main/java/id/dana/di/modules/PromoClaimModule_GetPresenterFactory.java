package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.richview.promoclaim.PromoClaimContract;
import id.dana.richview.promoclaim.PromoClaimPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class PromoClaimModule_GetPresenterFactory implements Factory<PromoClaimContract.Presenter> {
    private final Provider<PromoClaimPresenter> BuiltInFictitiousFunctionClassFactory;
    private final PromoClaimModule KClassImpl$Data$declaredNonStaticMembers$2;

    public static PromoClaimContract.Presenter MyBillsEntityDataFactory(PromoClaimModule promoClaimModule, PromoClaimPresenter promoClaimPresenter) {
        return (PromoClaimContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(promoClaimModule.getAuthRequestContext(promoClaimPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PromoClaimContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
