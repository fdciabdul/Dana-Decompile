package id.dana.data.toggle;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.data.toggle.traffictype.LazyTrafficTypeFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitFacade_Factory implements Factory<SplitFacade> {
    private final Provider<LazyTrafficTypeFactory> BuiltInFictitiousFunctionClassFactory;
    private final Provider<DeviceInformationProvider> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<BaseTrafficType> MyBillsEntityDataFactory;
    private final Provider<PreferenceFacade> PlaceComponentResult;
    private final Provider<Context> getAuthRequestContext;

    private SplitFacade_Factory(Provider<Context> provider, Provider<DeviceInformationProvider> provider2, Provider<BaseTrafficType> provider3, Provider<LazyTrafficTypeFactory> provider4, Provider<PreferenceFacade> provider5) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.PlaceComponentResult = provider5;
    }

    public static SplitFacade_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider, Provider<DeviceInformationProvider> provider2, Provider<BaseTrafficType> provider3, Provider<LazyTrafficTypeFactory> provider4, Provider<PreferenceFacade> provider5) {
        return new SplitFacade_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitFacade(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
