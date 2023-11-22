package id.dana.riskChallenges.ui.micface.viewmodel;

import dagger.internal.Factory;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MicFaceViewModel_Factory implements Factory<MicFaceViewModel> {
    private final Provider<DanaVizTrackerImpl> PlaceComponentResult;
    private final Provider<FaceAuthentication> getAuthRequestContext;

    private MicFaceViewModel_Factory(Provider<FaceAuthentication> provider, Provider<DanaVizTrackerImpl> provider2) {
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
    }

    public static MicFaceViewModel_Factory getAuthRequestContext(Provider<FaceAuthentication> provider, Provider<DanaVizTrackerImpl> provider2) {
        return new MicFaceViewModel_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MicFaceViewModel(this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}
