package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.BlockedFragmentContract;

/* loaded from: classes5.dex */
public final class BlockedFragmentModule_ProvideViewFactory implements Factory<BlockedFragmentContract.View> {
    private final BlockedFragmentModule getAuthRequestContext;

    public static BlockedFragmentContract.View PlaceComponentResult(BlockedFragmentModule blockedFragmentModule) {
        return (BlockedFragmentContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(blockedFragmentModule.getGetAuthRequestContext());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (BlockedFragmentContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getGetAuthRequestContext());
    }
}
