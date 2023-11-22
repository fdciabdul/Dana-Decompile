package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.MutedFragmentContract;
import id.dana.social.presenter.MutedFragmentPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MutedFragmentModule_ProvidePresenterFactory implements Factory<MutedFragmentContract.Presenter> {
    private final MutedFragmentModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<MutedFragmentPresenter> MyBillsEntityDataFactory;

    public static MutedFragmentContract.Presenter PlaceComponentResult(MutedFragmentModule mutedFragmentModule, MutedFragmentPresenter mutedFragmentPresenter) {
        return (MutedFragmentContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(mutedFragmentModule.MyBillsEntityDataFactory(mutedFragmentPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MutedFragmentContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.get()));
    }
}
