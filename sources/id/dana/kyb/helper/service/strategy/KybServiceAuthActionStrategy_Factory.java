package id.dana.kyb.helper.service.strategy;

import dagger.internal.Factory;
import id.dana.domain.authcode.interactor.GetAuthCode;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class KybServiceAuthActionStrategy_Factory implements Factory<KybServiceAuthActionStrategy> {
    private final Provider<GetAuthCode> getAuthRequestContext;

    private KybServiceAuthActionStrategy_Factory(Provider<GetAuthCode> provider) {
        this.getAuthRequestContext = provider;
    }

    public static KybServiceAuthActionStrategy_Factory MyBillsEntityDataFactory(Provider<GetAuthCode> provider) {
        return new KybServiceAuthActionStrategy_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new KybServiceAuthActionStrategy(this.getAuthRequestContext.get());
    }
}
