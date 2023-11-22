package id.dana.domain.auth.face.interactor;

import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.auth.face.repository.source.network.NetworkFaceAuthenticationEntityData;
import id.dana.domain.auth.face.repository.FaceAuthenticationRepository;
import id.dana.domain.auth.face.result.FaceAuthenticationResult;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/auth/face/interactor/SwitchFaceAuthentication;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/auth/face/result/FaceAuthenticationResult;", "Lid/dana/domain/auth/face/interactor/SwitchFaceAuthentication$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/auth/face/interactor/SwitchFaceAuthentication$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/auth/face/repository/FaceAuthenticationRepository;", "faceAuthenticationRepository", "Lid/dana/domain/auth/face/repository/FaceAuthenticationRepository;", "<init>", "(Lid/dana/domain/auth/face/repository/FaceAuthenticationRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SwitchFaceAuthentication extends BaseUseCase<FaceAuthenticationResult, Params> {
    private final FaceAuthenticationRepository faceAuthenticationRepository;

    @Inject
    public SwitchFaceAuthentication(FaceAuthenticationRepository faceAuthenticationRepository) {
        Intrinsics.checkNotNullParameter(faceAuthenticationRepository, "");
        this.faceAuthenticationRepository = faceAuthenticationRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<FaceAuthenticationResult> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.faceAuthenticationRepository.mo785switch(params.getFaceAuthNew(), params.getSecurityId(), params.getPageSource());
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b"}, d2 = {"Lid/dana/domain/auth/face/interactor/SwitchFaceAuthentication$Params;", "", "", "faceAuthNew", "Z", "getFaceAuthNew$domain_productionRelease", "()Z", "", NetworkFaceAuthenticationEntityData.PAGE_SOURCE, "Ljava/lang/String;", "getPageSource$domain_productionRelease", "()Ljava/lang/String;", BioUtilityBridge.SECURITY_ID, "getSecurityId$domain_productionRelease", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final boolean faceAuthNew;
        private final String pageSource;
        private final String securityId;

        public Params(boolean z, String str, String str2) {
            this.faceAuthNew = z;
            this.securityId = str;
            this.pageSource = str2;
        }

        public /* synthetic */ Params(boolean z, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, str, (i & 4) != 0 ? null : str2);
        }

        @JvmName(name = "getFaceAuthNew$domain_productionRelease")
        /* renamed from: getFaceAuthNew$domain_productionRelease  reason: from getter */
        public final boolean getFaceAuthNew() {
            return this.faceAuthNew;
        }

        @JvmName(name = "getSecurityId$domain_productionRelease")
        /* renamed from: getSecurityId$domain_productionRelease  reason: from getter */
        public final String getSecurityId() {
            return this.securityId;
        }

        @JvmName(name = "getPageSource$domain_productionRelease")
        /* renamed from: getPageSource$domain_productionRelease  reason: from getter */
        public final String getPageSource() {
            return this.pageSource;
        }
    }
}
