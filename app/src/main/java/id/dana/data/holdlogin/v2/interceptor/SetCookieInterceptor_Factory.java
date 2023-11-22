package id.dana.data.holdlogin.v2.interceptor;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.utils.holdlogin.v2.HoldLoginConfig;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SetCookieInterceptor_Factory implements Factory<SetCookieInterceptor> {
    private final Provider<HoldLoginConfig> MyBillsEntityDataFactory;
    private final Provider<Context> PlaceComponentResult;

    private SetCookieInterceptor_Factory(Provider<Context> provider, Provider<HoldLoginConfig> provider2) {
        this.PlaceComponentResult = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static SetCookieInterceptor_Factory getAuthRequestContext(Provider<Context> provider, Provider<HoldLoginConfig> provider2) {
        return new SetCookieInterceptor_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SetCookieInterceptor(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get());
    }
}
