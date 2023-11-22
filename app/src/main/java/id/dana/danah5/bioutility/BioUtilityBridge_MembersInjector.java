package id.dana.danah5.bioutility;

import dagger.MembersInjector;
import id.dana.danah5.faceverificationenablement.FaceAuthenticationManager;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class BioUtilityBridge_MembersInjector implements MembersInjector<BioUtilityBridge> {
    private final Provider<FaceAuthenticationManager> defaultFaceAuthenticationManagerProvider;

    public BioUtilityBridge_MembersInjector(Provider<FaceAuthenticationManager> provider) {
        this.defaultFaceAuthenticationManagerProvider = provider;
    }

    public static MembersInjector<BioUtilityBridge> create(Provider<FaceAuthenticationManager> provider) {
        return new BioUtilityBridge_MembersInjector(provider);
    }

    public final void injectMembers(BioUtilityBridge bioUtilityBridge) {
        injectDefaultFaceAuthenticationManager(bioUtilityBridge, this.defaultFaceAuthenticationManagerProvider.get());
    }

    public static void injectDefaultFaceAuthenticationManager(BioUtilityBridge bioUtilityBridge, FaceAuthenticationManager faceAuthenticationManager) {
        bioUtilityBridge.defaultFaceAuthenticationManager = faceAuthenticationManager;
    }
}
