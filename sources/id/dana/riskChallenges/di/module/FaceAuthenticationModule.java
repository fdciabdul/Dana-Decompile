package id.dana.riskChallenges.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.lib.bio.faceauth.DefaultFaceAuthentication;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/riskChallenges/di/module/FaceAuthenticationModule;", "", "Lid/dana/lib/bio/faceauth/FaceAuthentication;", "MyBillsEntityDataFactory", "()Lid/dana/lib/bio/faceauth/FaceAuthentication;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes3.dex */
public final class FaceAuthenticationModule {
    @Provides
    public final FaceAuthentication MyBillsEntityDataFactory() {
        DefaultFaceAuthentication.Companion companion = DefaultFaceAuthentication.INSTANCE;
        return DefaultFaceAuthentication.Companion.KClassImpl$Data$declaredNonStaticMembers$2();
    }
}
