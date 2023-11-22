package id.dana.data.recentrecipient.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RecentBankMapper_Factory implements Factory<RecentBankMapper> {
    private final Provider<RecentRecipientEntityMapper> recentRecipientEntityMapperProvider;

    public RecentBankMapper_Factory(Provider<RecentRecipientEntityMapper> provider) {
        this.recentRecipientEntityMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RecentBankMapper get() {
        return newInstance(this.recentRecipientEntityMapperProvider.get());
    }

    public static RecentBankMapper_Factory create(Provider<RecentRecipientEntityMapper> provider) {
        return new RecentBankMapper_Factory(provider);
    }

    public static RecentBankMapper newInstance(RecentRecipientEntityMapper recentRecipientEntityMapper) {
        return new RecentBankMapper(recentRecipientEntityMapper);
    }
}
