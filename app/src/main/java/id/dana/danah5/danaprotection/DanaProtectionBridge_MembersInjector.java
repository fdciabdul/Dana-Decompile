package id.dana.danah5.danaprotection;

import dagger.MembersInjector;
import id.dana.domain.danaprotection.interactor.GetDanaProtectionInfo;
import id.dana.domain.danaprotection.interactor.GetDanaProtectionRecommendation;
import id.dana.domain.featureconfig.interactor.GetDanaProtectionWidgetConfig;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanaProtectionBridge_MembersInjector implements MembersInjector<DanaProtectionBridge> {
    private final Provider<GetDanaProtectionInfo> getDanaProtectionInfoProvider;
    private final Provider<GetDanaProtectionRecommendation> getDanaProtectionRecommendationProvider;
    private final Provider<GetDanaProtectionWidgetConfig> getDanaProtectionWidgetConfigProvider;

    public DanaProtectionBridge_MembersInjector(Provider<GetDanaProtectionWidgetConfig> provider, Provider<GetDanaProtectionRecommendation> provider2, Provider<GetDanaProtectionInfo> provider3) {
        this.getDanaProtectionWidgetConfigProvider = provider;
        this.getDanaProtectionRecommendationProvider = provider2;
        this.getDanaProtectionInfoProvider = provider3;
    }

    public static MembersInjector<DanaProtectionBridge> create(Provider<GetDanaProtectionWidgetConfig> provider, Provider<GetDanaProtectionRecommendation> provider2, Provider<GetDanaProtectionInfo> provider3) {
        return new DanaProtectionBridge_MembersInjector(provider, provider2, provider3);
    }

    public final void injectMembers(DanaProtectionBridge danaProtectionBridge) {
        injectGetDanaProtectionWidgetConfig(danaProtectionBridge, this.getDanaProtectionWidgetConfigProvider.get());
        injectGetDanaProtectionRecommendation(danaProtectionBridge, this.getDanaProtectionRecommendationProvider.get());
        injectGetDanaProtectionInfo(danaProtectionBridge, this.getDanaProtectionInfoProvider.get());
    }

    public static void injectGetDanaProtectionWidgetConfig(DanaProtectionBridge danaProtectionBridge, GetDanaProtectionWidgetConfig getDanaProtectionWidgetConfig) {
        danaProtectionBridge.getDanaProtectionWidgetConfig = getDanaProtectionWidgetConfig;
    }

    public static void injectGetDanaProtectionRecommendation(DanaProtectionBridge danaProtectionBridge, GetDanaProtectionRecommendation getDanaProtectionRecommendation) {
        danaProtectionBridge.getDanaProtectionRecommendation = getDanaProtectionRecommendation;
    }

    public static void injectGetDanaProtectionInfo(DanaProtectionBridge danaProtectionBridge, GetDanaProtectionInfo getDanaProtectionInfo) {
        danaProtectionBridge.getDanaProtectionInfo = getDanaProtectionInfo;
    }
}
