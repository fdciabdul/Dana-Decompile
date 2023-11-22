package id.dana.kyb.domain.interactor;

import dagger.internal.Factory;
import id.dana.kyb.domain.KybRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetKybBanner_Factory implements Factory<GetKybBanner> {
    private final Provider<KybRepository> getAuthRequestContext;

    private GetKybBanner_Factory(Provider<KybRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static GetKybBanner_Factory PlaceComponentResult(Provider<KybRepository> provider) {
        return new GetKybBanner_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetKybBanner(this.getAuthRequestContext.get());
    }
}
