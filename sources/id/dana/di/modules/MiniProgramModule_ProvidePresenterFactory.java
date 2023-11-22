package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.miniprogram.di.MiniProgramContract;
import id.dana.miniprogram.di.MiniProgramPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class MiniProgramModule_ProvidePresenterFactory implements Factory<MiniProgramContract.Presenter> {
    private final MiniProgramModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<MiniProgramPresenter> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MiniProgramContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.get()));
    }
}
