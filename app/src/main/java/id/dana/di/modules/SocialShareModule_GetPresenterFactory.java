package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.richview.socialshare.SocialShareContract;
import id.dana.richview.socialshare.presenter.SocialSharePresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SocialShareModule_GetPresenterFactory implements Factory<SocialShareContract.Presenter> {
    private final Provider<SocialSharePresenter> BuiltInFictitiousFunctionClassFactory;
    private final SocialShareModule getAuthRequestContext;

    public static SocialShareContract.Presenter BuiltInFictitiousFunctionClassFactory(SocialShareModule socialShareModule, SocialSharePresenter socialSharePresenter) {
        return (SocialShareContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(socialShareModule.PlaceComponentResult(socialSharePresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SocialShareContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
