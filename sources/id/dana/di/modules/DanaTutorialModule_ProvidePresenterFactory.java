package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.tutorial.TutorialContract;
import id.dana.tutorial.TutorialPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DanaTutorialModule_ProvidePresenterFactory implements Factory<TutorialContract.Presenter> {
    private final DanaTutorialModule PlaceComponentResult;
    private final Provider<TutorialPresenter> getAuthRequestContext;

    public static TutorialContract.Presenter BuiltInFictitiousFunctionClassFactory(DanaTutorialModule danaTutorialModule, TutorialPresenter tutorialPresenter) {
        return (TutorialContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(danaTutorialModule.KClassImpl$Data$declaredNonStaticMembers$2(tutorialPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TutorialContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}
