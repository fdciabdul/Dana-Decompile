package id.dana.data.holdlogin.v2.interceptor;

import dagger.internal.Factory;
import id.dana.utils.holdlogin.v2.HoldLoginConfig;
import id.dana.utils.holdlogin.v2.interceptor.HoldLoginV2Interceptor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class OkhttpHoldLoginV2Interceptor_Factory implements Factory<OkhttpHoldLoginV2Interceptor> {
    private final Provider<HoldLoginV2Interceptor> BuiltInFictitiousFunctionClassFactory;
    private final Provider<HoldLoginConfig> KClassImpl$Data$declaredNonStaticMembers$2;

    private OkhttpHoldLoginV2Interceptor_Factory(Provider<HoldLoginV2Interceptor> provider, Provider<HoldLoginConfig> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static OkhttpHoldLoginV2Interceptor_Factory MyBillsEntityDataFactory(Provider<HoldLoginV2Interceptor> provider, Provider<HoldLoginConfig> provider2) {
        return new OkhttpHoldLoginV2Interceptor_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OkhttpHoldLoginV2Interceptor(this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
