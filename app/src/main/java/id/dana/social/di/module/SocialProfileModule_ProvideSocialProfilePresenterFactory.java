package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.SocialProfileContract;
import id.dana.social.presenter.SocialProfilePresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SocialProfileModule_ProvideSocialProfilePresenterFactory implements Factory<SocialProfileContract.Presenter> {
    private final SocialProfileModule MyBillsEntityDataFactory;
    private final Provider<SocialProfilePresenter> PlaceComponentResult;

    public static SocialProfileContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(SocialProfileModule socialProfileModule, SocialProfilePresenter socialProfilePresenter) {
        return (SocialProfileContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(socialProfileModule.BuiltInFictitiousFunctionClassFactory(socialProfilePresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SocialProfileContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.get()));
    }
}
