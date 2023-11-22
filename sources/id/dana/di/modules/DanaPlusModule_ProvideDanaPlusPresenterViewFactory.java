package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.investment.contract.DanaPlusContract;

/* loaded from: classes4.dex */
public final class DanaPlusModule_ProvideDanaPlusPresenterViewFactory implements Factory<DanaPlusContract.View> {
    private final DanaPlusModule getAuthRequestContext;

    private DanaPlusModule_ProvideDanaPlusPresenterViewFactory(DanaPlusModule danaPlusModule) {
        this.getAuthRequestContext = danaPlusModule;
    }

    public static DanaPlusModule_ProvideDanaPlusPresenterViewFactory MyBillsEntityDataFactory(DanaPlusModule danaPlusModule) {
        return new DanaPlusModule_ProvideDanaPlusPresenterViewFactory(danaPlusModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DanaPlusContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getMyBillsEntityDataFactory());
    }
}
