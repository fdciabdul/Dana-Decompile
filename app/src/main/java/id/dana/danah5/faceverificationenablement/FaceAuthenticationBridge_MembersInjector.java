package id.dana.danah5.faceverificationenablement;

import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FaceAuthenticationBridge_MembersInjector implements MembersInjector<FaceAuthenticationBridge> {
    private final Provider<FaceAuthenticationManager> faceAuthenticationManagerProvider;

    public FaceAuthenticationBridge_MembersInjector(Provider<FaceAuthenticationManager> provider) {
        this.faceAuthenticationManagerProvider = provider;
    }

    public static MembersInjector<FaceAuthenticationBridge> create(Provider<FaceAuthenticationManager> provider) {
        return new FaceAuthenticationBridge_MembersInjector(provider);
    }

    public final void injectMembers(FaceAuthenticationBridge faceAuthenticationBridge) {
        injectFaceAuthenticationManager(faceAuthenticationBridge, this.faceAuthenticationManagerProvider.get());
    }

    public static void injectFaceAuthenticationManager(FaceAuthenticationBridge faceAuthenticationBridge, FaceAuthenticationManager faceAuthenticationManager) {
        faceAuthenticationBridge.faceAuthenticationManager = faceAuthenticationManager;
    }
}
