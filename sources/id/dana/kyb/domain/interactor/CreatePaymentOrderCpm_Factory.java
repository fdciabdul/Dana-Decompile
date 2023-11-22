package id.dana.kyb.domain.interactor;

import dagger.internal.Factory;
import id.dana.kyb.domain.KybRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CreatePaymentOrderCpm_Factory implements Factory<CreatePaymentOrderCpm> {
    private final Provider<KybRepository> PlaceComponentResult;

    private CreatePaymentOrderCpm_Factory(Provider<KybRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static CreatePaymentOrderCpm_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<KybRepository> provider) {
        return new CreatePaymentOrderCpm_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CreatePaymentOrderCpm(this.PlaceComponentResult.get());
    }
}
