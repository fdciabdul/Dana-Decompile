package id.dana.sendmoney.domain.groupsend.interactor;

import dagger.internal.Factory;
import id.dana.domain.contactinjection.ContactInjectionRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class InjectDanaContact_Factory implements Factory<InjectDanaContact> {
    private final Provider<ContactInjectionRepository> PlaceComponentResult;

    private InjectDanaContact_Factory(Provider<ContactInjectionRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static InjectDanaContact_Factory getAuthRequestContext(Provider<ContactInjectionRepository> provider) {
        return new InjectDanaContact_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new InjectDanaContact(this.PlaceComponentResult.get());
    }
}
