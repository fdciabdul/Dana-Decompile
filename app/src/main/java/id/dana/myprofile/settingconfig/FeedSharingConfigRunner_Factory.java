package id.dana.myprofile.settingconfig;

import dagger.internal.Factory;
import id.dana.feeds.domain.activation.FeedInitRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FeedSharingConfigRunner_Factory implements Factory<FeedSharingConfigRunner> {
    private final Provider<FeedInitRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private FeedSharingConfigRunner_Factory(Provider<FeedInitRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static FeedSharingConfigRunner_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<FeedInitRepository> provider) {
        return new FeedSharingConfigRunner_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedSharingConfigRunner(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
