package id.dana.myprofile.settingconfig;

import dagger.internal.Factory;
import id.dana.feeds.domain.share.FeedsShareRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ShareFeedSettingConfigRunner_Factory implements Factory<ShareFeedSettingConfigRunner> {
    private final Provider<FeedsShareRepository> getAuthRequestContext;

    private ShareFeedSettingConfigRunner_Factory(Provider<FeedsShareRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static ShareFeedSettingConfigRunner_Factory getAuthRequestContext(Provider<FeedsShareRepository> provider) {
        return new ShareFeedSettingConfigRunner_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ShareFeedSettingConfigRunner(this.getAuthRequestContext.get());
    }
}
