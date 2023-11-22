package id.dana.riskChallenges.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.lib.bio.faceauth.FaceAuthentication;

/* loaded from: classes5.dex */
public final class FaceAuthenticationModule_ProvideFaceAuthenticationFactory implements Factory<FaceAuthentication> {
    private final FaceAuthenticationModule MyBillsEntityDataFactory;

    private FaceAuthenticationModule_ProvideFaceAuthenticationFactory(FaceAuthenticationModule faceAuthenticationModule) {
        this.MyBillsEntityDataFactory = faceAuthenticationModule;
    }

    public static FaceAuthenticationModule_ProvideFaceAuthenticationFactory getAuthRequestContext(FaceAuthenticationModule faceAuthenticationModule) {
        return new FaceAuthenticationModule_ProvideFaceAuthenticationFactory(faceAuthenticationModule);
    }

    public static FaceAuthentication MyBillsEntityDataFactory(FaceAuthenticationModule faceAuthenticationModule) {
        return (FaceAuthentication) Preconditions.BuiltInFictitiousFunctionClassFactory(faceAuthenticationModule.MyBillsEntityDataFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FaceAuthentication) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory());
    }
}
