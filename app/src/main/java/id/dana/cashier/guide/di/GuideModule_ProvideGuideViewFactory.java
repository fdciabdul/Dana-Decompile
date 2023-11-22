package id.dana.cashier.guide.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.guide.contract.GuideContract;

/* loaded from: classes4.dex */
public final class GuideModule_ProvideGuideViewFactory implements Factory<GuideContract.View> {
    private final GuideModule getAuthRequestContext;

    private GuideModule_ProvideGuideViewFactory(GuideModule guideModule) {
        this.getAuthRequestContext = guideModule;
    }

    public static GuideModule_ProvideGuideViewFactory KClassImpl$Data$declaredNonStaticMembers$2(GuideModule guideModule) {
        return new GuideModule_ProvideGuideViewFactory(guideModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GuideContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getPlaceComponentResult());
    }
}
