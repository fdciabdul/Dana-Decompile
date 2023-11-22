package id.dana.danah5.faceverificationenablement;

import dagger.internal.Factory;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.auth.face.interactor.SwitchFaceAuthentication;
import id.dana.domain.resetpin.interactor.FinishForceDanaVizEnroll;
import id.dana.domain.transferaccount.interactor.DeletionChangeNumber;
import id.dana.domain.transferaccount.interactor.SaveTransferAccountToken;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DefaultFaceAuthenticationManager_Factory implements Factory<DefaultFaceAuthenticationManager> {
    private final Provider<DanaVizTrackerImpl> danaVizTrackerImplProvider;
    private final Provider<DeletionChangeNumber> deletionChangeNumberProvider;
    private final Provider<FaceAuthentication> faceAuthenticationProvider;
    private final Provider<FinishForceDanaVizEnroll> finishForceDanaVizEnrollProvider;
    private final Provider<GetUserId> getUserIdProvider;
    private final Provider<SaveTransferAccountToken> saveTransferAccountTokenProvider;
    private final Provider<SwitchFaceAuthentication> switchFaceAuthenticationProvider;

    public DefaultFaceAuthenticationManager_Factory(Provider<SwitchFaceAuthentication> provider, Provider<GetUserId> provider2, Provider<FaceAuthentication> provider3, Provider<DanaVizTrackerImpl> provider4, Provider<SaveTransferAccountToken> provider5, Provider<DeletionChangeNumber> provider6, Provider<FinishForceDanaVizEnroll> provider7) {
        this.switchFaceAuthenticationProvider = provider;
        this.getUserIdProvider = provider2;
        this.faceAuthenticationProvider = provider3;
        this.danaVizTrackerImplProvider = provider4;
        this.saveTransferAccountTokenProvider = provider5;
        this.deletionChangeNumberProvider = provider6;
        this.finishForceDanaVizEnrollProvider = provider7;
    }

    @Override // javax.inject.Provider
    public final DefaultFaceAuthenticationManager get() {
        return newInstance(this.switchFaceAuthenticationProvider.get(), this.getUserIdProvider.get(), this.faceAuthenticationProvider.get(), this.danaVizTrackerImplProvider.get(), this.saveTransferAccountTokenProvider.get(), this.deletionChangeNumberProvider.get(), this.finishForceDanaVizEnrollProvider.get());
    }

    public static DefaultFaceAuthenticationManager_Factory create(Provider<SwitchFaceAuthentication> provider, Provider<GetUserId> provider2, Provider<FaceAuthentication> provider3, Provider<DanaVizTrackerImpl> provider4, Provider<SaveTransferAccountToken> provider5, Provider<DeletionChangeNumber> provider6, Provider<FinishForceDanaVizEnroll> provider7) {
        return new DefaultFaceAuthenticationManager_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static DefaultFaceAuthenticationManager newInstance(SwitchFaceAuthentication switchFaceAuthentication, GetUserId getUserId, FaceAuthentication faceAuthentication, DanaVizTrackerImpl danaVizTrackerImpl, SaveTransferAccountToken saveTransferAccountToken, DeletionChangeNumber deletionChangeNumber, FinishForceDanaVizEnroll finishForceDanaVizEnroll) {
        return new DefaultFaceAuthenticationManager(switchFaceAuthentication, getUserId, faceAuthentication, danaVizTrackerImpl, saveTransferAccountToken, deletionChangeNumber, finishForceDanaVizEnroll);
    }
}
