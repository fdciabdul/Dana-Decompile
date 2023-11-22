package id.dana.danah5.customredirectto;

import dagger.MembersInjector;
import id.dana.data.miniprogram.source.local.MiniProgramPreference;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CutomRedirectToBridge_MembersInjector implements MembersInjector<CutomRedirectToBridge> {
    private final Provider<MiniProgramPreference> miniProgramPreferenceProvider;

    public CutomRedirectToBridge_MembersInjector(Provider<MiniProgramPreference> provider) {
        this.miniProgramPreferenceProvider = provider;
    }

    public static MembersInjector<CutomRedirectToBridge> create(Provider<MiniProgramPreference> provider) {
        return new CutomRedirectToBridge_MembersInjector(provider);
    }

    public final void injectMembers(CutomRedirectToBridge cutomRedirectToBridge) {
        injectMiniProgramPreference(cutomRedirectToBridge, this.miniProgramPreferenceProvider.get());
    }

    public static void injectMiniProgramPreference(CutomRedirectToBridge cutomRedirectToBridge, MiniProgramPreference miniProgramPreference) {
        cutomRedirectToBridge.miniProgramPreference = miniProgramPreference;
    }
}
