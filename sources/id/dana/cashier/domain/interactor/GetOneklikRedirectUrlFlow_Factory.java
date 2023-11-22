package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetOneklikRedirectUrlFlow_Factory implements Factory<GetOneklikRedirectUrlFlow> {
    private final Provider<GetOneklikRedirectUrl> getOneklikRedirectUrlProvider;

    public GetOneklikRedirectUrlFlow_Factory(Provider<GetOneklikRedirectUrl> provider) {
        this.getOneklikRedirectUrlProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetOneklikRedirectUrlFlow get() {
        return newInstance(this.getOneklikRedirectUrlProvider.get());
    }

    public static GetOneklikRedirectUrlFlow_Factory create(Provider<GetOneklikRedirectUrl> provider) {
        return new GetOneklikRedirectUrlFlow_Factory(provider);
    }

    public static GetOneklikRedirectUrlFlow newInstance(GetOneklikRedirectUrl getOneklikRedirectUrl) {
        return new GetOneklikRedirectUrlFlow(getOneklikRedirectUrl);
    }
}
