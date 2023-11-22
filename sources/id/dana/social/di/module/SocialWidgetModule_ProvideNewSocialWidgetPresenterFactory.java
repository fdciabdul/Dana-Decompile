package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.presenter.NewSocialWidgetPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SocialWidgetModule_ProvideNewSocialWidgetPresenterFactory implements Factory<NewSocialWidgetPresenter> {
    private final SocialWidgetModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<NewSocialWidgetPresenter> getAuthRequestContext;

    private SocialWidgetModule_ProvideNewSocialWidgetPresenterFactory(SocialWidgetModule socialWidgetModule, Provider<NewSocialWidgetPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = socialWidgetModule;
        this.getAuthRequestContext = provider;
    }

    public static SocialWidgetModule_ProvideNewSocialWidgetPresenterFactory MyBillsEntityDataFactory(SocialWidgetModule socialWidgetModule, Provider<NewSocialWidgetPresenter> provider) {
        return new SocialWidgetModule_ProvideNewSocialWidgetPresenterFactory(socialWidgetModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NewSocialWidgetPresenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}
