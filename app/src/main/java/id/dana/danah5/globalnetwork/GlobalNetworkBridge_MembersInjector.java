package id.dana.danah5.globalnetwork;

import dagger.MembersInjector;
import id.dana.danah5.globalnetwork.manager.GlobalNetworkPluginManager;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GlobalNetworkBridge_MembersInjector implements MembersInjector<GlobalNetworkBridge> {
    private final Provider<GlobalNetworkPluginManager> globalNetworkPluginManagerProvider;

    public GlobalNetworkBridge_MembersInjector(Provider<GlobalNetworkPluginManager> provider) {
        this.globalNetworkPluginManagerProvider = provider;
    }

    public static MembersInjector<GlobalNetworkBridge> create(Provider<GlobalNetworkPluginManager> provider) {
        return new GlobalNetworkBridge_MembersInjector(provider);
    }

    public final void injectMembers(GlobalNetworkBridge globalNetworkBridge) {
        injectGlobalNetworkPluginManager(globalNetworkBridge, this.globalNetworkPluginManagerProvider.get());
    }

    public static void injectGlobalNetworkPluginManager(GlobalNetworkBridge globalNetworkBridge, GlobalNetworkPluginManager globalNetworkPluginManager) {
        globalNetworkBridge.globalNetworkPluginManager = globalNetworkPluginManager;
    }
}
