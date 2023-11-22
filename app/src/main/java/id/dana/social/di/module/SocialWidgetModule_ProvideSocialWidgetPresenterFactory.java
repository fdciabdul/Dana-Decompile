package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.SocialWidgetContract;
import id.dana.social.presenter.SocialWidgetPresenter;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class SocialWidgetModule_ProvideSocialWidgetPresenterFactory implements Factory<SocialWidgetContract.Presenter> {
    private final Provider<SocialWidgetPresenter> MyBillsEntityDataFactory;
    private final SocialWidgetModule PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SocialWidgetContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get()));
    }
}
