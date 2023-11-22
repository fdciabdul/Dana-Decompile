package id.dana.contract.shortener;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.shortener.ShortenUrlContract;

/* loaded from: classes8.dex */
public final class ShortenUrlModule_ProvideViewFactory implements Factory<ShortenUrlContract.View> {
    private final ShortenUrlModule PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ShortenUrlContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getAuthRequestContext());
    }
}
