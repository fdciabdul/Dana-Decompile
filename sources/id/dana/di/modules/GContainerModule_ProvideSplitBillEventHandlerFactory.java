package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig;
import id.dana.splitbill.SplitBillEventHandler;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GContainerModule_ProvideSplitBillEventHandlerFactory implements Factory<SplitBillEventHandler> {
    private final Provider<GetSplitBillConfig> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetRequestMoneyInfoFeature> PlaceComponentResult;
    private final GContainerModule getAuthRequestContext;

    private GContainerModule_ProvideSplitBillEventHandlerFactory(GContainerModule gContainerModule, Provider<GetRequestMoneyInfoFeature> provider, Provider<GetSplitBillConfig> provider2) {
        this.getAuthRequestContext = gContainerModule;
        this.PlaceComponentResult = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static GContainerModule_ProvideSplitBillEventHandlerFactory PlaceComponentResult(GContainerModule gContainerModule, Provider<GetRequestMoneyInfoFeature> provider, Provider<GetSplitBillConfig> provider2) {
        return new GContainerModule_ProvideSplitBillEventHandlerFactory(gContainerModule, provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SplitBillEventHandler) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.MyBillsEntityDataFactory(this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
