package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.BlockedFragmentContract;
import id.dana.social.presenter.BlockedFragmentPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class BlockedFragmentModule_ProvidePresenterFactory implements Factory<BlockedFragmentContract.Presenter> {
    private final Provider<BlockedFragmentPresenter> BuiltInFictitiousFunctionClassFactory;
    private final BlockedFragmentModule getAuthRequestContext;

    public static BlockedFragmentContract.Presenter PlaceComponentResult(BlockedFragmentModule blockedFragmentModule, BlockedFragmentPresenter blockedFragmentPresenter) {
        return (BlockedFragmentContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(blockedFragmentModule.getAuthRequestContext(blockedFragmentPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (BlockedFragmentContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
