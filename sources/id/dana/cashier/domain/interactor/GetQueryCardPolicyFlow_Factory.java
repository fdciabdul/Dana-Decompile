package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetQueryCardPolicyFlow_Factory implements Factory<GetQueryCardPolicyFlow> {
    private final Provider<GetQueryCardPolicy> getQueryCardPolicyProvider;

    public GetQueryCardPolicyFlow_Factory(Provider<GetQueryCardPolicy> provider) {
        this.getQueryCardPolicyProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetQueryCardPolicyFlow get() {
        return newInstance(this.getQueryCardPolicyProvider.get());
    }

    public static GetQueryCardPolicyFlow_Factory create(Provider<GetQueryCardPolicy> provider) {
        return new GetQueryCardPolicyFlow_Factory(provider);
    }

    public static GetQueryCardPolicyFlow newInstance(GetQueryCardPolicy getQueryCardPolicy) {
        return new GetQueryCardPolicyFlow(getQueryCardPolicy);
    }
}
