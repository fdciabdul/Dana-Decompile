package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.splitbill.SplitBillIntroductionContract;
import id.dana.splitbill.SplitBillIntroductionPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SplitBillIntroductionModule_ProvidePresenterFactory implements Factory<SplitBillIntroductionContract.Presenter> {
    private final SplitBillIntroductionModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<SplitBillIntroductionPresenter> getAuthRequestContext;

    private SplitBillIntroductionModule_ProvidePresenterFactory(SplitBillIntroductionModule splitBillIntroductionModule, Provider<SplitBillIntroductionPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = splitBillIntroductionModule;
        this.getAuthRequestContext = provider;
    }

    public static SplitBillIntroductionModule_ProvidePresenterFactory KClassImpl$Data$declaredNonStaticMembers$2(SplitBillIntroductionModule splitBillIntroductionModule, Provider<SplitBillIntroductionPresenter> provider) {
        return new SplitBillIntroductionModule_ProvidePresenterFactory(splitBillIntroductionModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SplitBillIntroductionContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}
