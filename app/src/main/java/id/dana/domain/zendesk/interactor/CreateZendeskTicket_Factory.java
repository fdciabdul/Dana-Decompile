package id.dana.domain.zendesk.interactor;

import dagger.internal.Factory;
import id.dana.domain.zendesk.ZendeskRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CreateZendeskTicket_Factory implements Factory<CreateZendeskTicket> {
    private final Provider<ZendeskRepository> zendeskRepositoryProvider;

    public CreateZendeskTicket_Factory(Provider<ZendeskRepository> provider) {
        this.zendeskRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CreateZendeskTicket get() {
        return newInstance(this.zendeskRepositoryProvider.get());
    }

    public static CreateZendeskTicket_Factory create(Provider<ZendeskRepository> provider) {
        return new CreateZendeskTicket_Factory(provider);
    }

    public static CreateZendeskTicket newInstance(ZendeskRepository zendeskRepository) {
        return new CreateZendeskTicket(zendeskRepository);
    }
}
