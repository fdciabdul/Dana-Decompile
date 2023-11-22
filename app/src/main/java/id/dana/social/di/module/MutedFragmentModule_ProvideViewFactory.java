package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.MutedFragmentContract;

/* loaded from: classes5.dex */
public final class MutedFragmentModule_ProvideViewFactory implements Factory<MutedFragmentContract.View> {
    private final MutedFragmentModule PlaceComponentResult;

    public static MutedFragmentContract.View BuiltInFictitiousFunctionClassFactory(MutedFragmentModule mutedFragmentModule) {
        return (MutedFragmentContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(mutedFragmentModule.getPlaceComponentResult());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MutedFragmentContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getPlaceComponentResult());
    }
}
