package id.dana.kyb.domain.interactor;

import dagger.internal.Factory;
import id.dana.kyb.domain.KybRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetKybPaymentRequest_Factory implements Factory<GetKybPaymentRequest> {
    private final Provider<KybRepository> PlaceComponentResult;

    private GetKybPaymentRequest_Factory(Provider<KybRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static GetKybPaymentRequest_Factory PlaceComponentResult(Provider<KybRepository> provider) {
        return new GetKybPaymentRequest_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetKybPaymentRequest(this.PlaceComponentResult.get());
    }
}
