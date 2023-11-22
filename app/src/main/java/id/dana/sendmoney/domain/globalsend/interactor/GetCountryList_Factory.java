package id.dana.sendmoney.domain.globalsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.globalsend.GlobalSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetCountryList_Factory implements Factory<GetCountryList> {
    private final Provider<GlobalSendRepository> getAuthRequestContext;

    private GetCountryList_Factory(Provider<GlobalSendRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static GetCountryList_Factory PlaceComponentResult(Provider<GlobalSendRepository> provider) {
        return new GetCountryList_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetCountryList(this.getAuthRequestContext.get());
    }
}
