package id.dana.danah5.getonlineconfig;

import dagger.MembersInjector;
import id.dana.domain.h5onlineconfig.GetH5OnlineConfig;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetOnlineConfigBridge_MembersInjector implements MembersInjector<GetOnlineConfigBridge> {
    private final Provider<GetH5OnlineConfig> getH5OnlineConfigProvider;

    public GetOnlineConfigBridge_MembersInjector(Provider<GetH5OnlineConfig> provider) {
        this.getH5OnlineConfigProvider = provider;
    }

    public static MembersInjector<GetOnlineConfigBridge> create(Provider<GetH5OnlineConfig> provider) {
        return new GetOnlineConfigBridge_MembersInjector(provider);
    }

    public final void injectMembers(GetOnlineConfigBridge getOnlineConfigBridge) {
        injectGetH5OnlineConfig(getOnlineConfigBridge, this.getH5OnlineConfigProvider.get());
    }

    public static void injectGetH5OnlineConfig(GetOnlineConfigBridge getOnlineConfigBridge, GetH5OnlineConfig getH5OnlineConfig) {
        getOnlineConfigBridge.getH5OnlineConfig = getH5OnlineConfig;
    }
}
