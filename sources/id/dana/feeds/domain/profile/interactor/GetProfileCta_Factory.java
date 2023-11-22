package id.dana.feeds.domain.profile.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.config.FeedsConfigRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetProfileCta_Factory implements Factory<GetProfileCta> {
    private final Provider<FeedsConfigRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetProfileCta(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
