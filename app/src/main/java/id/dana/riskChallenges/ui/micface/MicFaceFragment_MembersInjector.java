package id.dana.riskChallenges.ui.micface;

import dagger.MembersInjector;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.lib.bio.faceauth.FaceAuthentication;

/* loaded from: classes5.dex */
public final class MicFaceFragment_MembersInjector implements MembersInjector<MicFaceFragment> {
    public static void BuiltInFictitiousFunctionClassFactory(MicFaceFragment micFaceFragment, ViewModelFactory viewModelFactory) {
        micFaceFragment.viewModelFactory = viewModelFactory;
    }

    public static void getAuthRequestContext(MicFaceFragment micFaceFragment, FaceAuthentication faceAuthentication) {
        micFaceFragment.faceAuthentication = faceAuthentication;
    }
}
