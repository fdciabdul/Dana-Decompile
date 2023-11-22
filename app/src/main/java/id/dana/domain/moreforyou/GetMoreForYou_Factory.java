package id.dana.domain.moreforyou;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetMoreForYou_Factory implements Factory<GetMoreForYou> {
    private final Provider<MoreForYouRepository> repositoryProvider;

    public GetMoreForYou_Factory(Provider<MoreForYouRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMoreForYou get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetMoreForYou_Factory create(Provider<MoreForYouRepository> provider) {
        return new GetMoreForYou_Factory(provider);
    }

    public static GetMoreForYou newInstance(MoreForYouRepository moreForYouRepository) {
        return new GetMoreForYou(moreForYouRepository);
    }
}
