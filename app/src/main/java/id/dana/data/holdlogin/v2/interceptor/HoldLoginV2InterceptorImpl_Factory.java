package id.dana.data.holdlogin.v2.interceptor;

import com.google.gson.Gson;
import dagger.internal.Factory;
import id.dana.data.holdlogin.v2.engine.HoldLoginV2Engine;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HoldLoginV2InterceptorImpl_Factory implements Factory<HoldLoginV2InterceptorImpl> {
    private final Provider<Gson> BuiltInFictitiousFunctionClassFactory;
    private final Provider<HoldLoginV2Engine> MyBillsEntityDataFactory;
    private final Provider<ThreadExecutor> PlaceComponentResult;
    private final Provider<SetCookieInterceptor> getAuthRequestContext;

    private HoldLoginV2InterceptorImpl_Factory(Provider<Gson> provider, Provider<HoldLoginV2Engine> provider2, Provider<ThreadExecutor> provider3, Provider<SetCookieInterceptor> provider4) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.PlaceComponentResult = provider3;
        this.getAuthRequestContext = provider4;
    }

    public static HoldLoginV2InterceptorImpl_Factory getAuthRequestContext(Provider<Gson> provider, Provider<HoldLoginV2Engine> provider2, Provider<ThreadExecutor> provider3, Provider<SetCookieInterceptor> provider4) {
        return new HoldLoginV2InterceptorImpl_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new HoldLoginV2InterceptorImpl(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.getAuthRequestContext.get());
    }
}
