package id.dana.cashier.guide.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.guide.contract.GuideContract;
import id.dana.cashier.guide.contract.GuidePresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GuideModule_ProvideGuidePresenterPresenterFactory implements Factory<GuideContract.Presenter> {
    private final GuideModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<GuidePresenter> PlaceComponentResult;

    public static GuideContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(GuideModule guideModule, GuidePresenter guidePresenter) {
        return (GuideContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(guideModule.KClassImpl$Data$declaredNonStaticMembers$2(guidePresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GuideContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}
