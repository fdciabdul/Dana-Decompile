package id.dana.domain.auth.face.interactor;

import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import id.dana.domain.auth.face.result.FaceAuthPopUpConsultationResult;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/auth/face/interactor/ConsultFaceAuthPopUp;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/auth/face/result/FaceAuthPopUpConsultationResult;", "Lid/dana/domain/auth/face/interactor/ConsultFaceAuthPopUp$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/auth/face/interactor/ConsultFaceAuthPopUp$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/auth/face/repository/FaceAuthPopUpConsultationRepository;", "repository", "Lid/dana/domain/auth/face/repository/FaceAuthPopUpConsultationRepository;", "<init>", "(Lid/dana/domain/auth/face/repository/FaceAuthPopUpConsultationRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ConsultFaceAuthPopUp extends BaseUseCase<FaceAuthPopUpConsultationResult, Params> {
    private final FaceAuthPopUpConsultationRepository repository;

    @Inject
    public ConsultFaceAuthPopUp(FaceAuthPopUpConsultationRepository faceAuthPopUpConsultationRepository) {
        Intrinsics.checkNotNullParameter(faceAuthPopUpConsultationRepository, "");
        this.repository = faceAuthPopUpConsultationRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<FaceAuthPopUpConsultationResult> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.repository.consultFaceAuthPopUpToBackend(params.getParallelMode(), params.getWithKycStatus());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/domain/auth/face/interactor/ConsultFaceAuthPopUp$Params;", "", "", "parallelMode", "Z", "getParallelMode$domain_productionRelease", "()Z", "withKycStatus", "getWithKycStatus$domain_productionRelease", "<init>", "(ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Params {
        private final boolean parallelMode;
        private final boolean withKycStatus;

        public Params(boolean z, boolean z2) {
            this.parallelMode = z;
            this.withKycStatus = z2;
        }

        @JvmName(name = "getParallelMode$domain_productionRelease")
        /* renamed from: getParallelMode$domain_productionRelease  reason: from getter */
        public final boolean getParallelMode() {
            return this.parallelMode;
        }

        @JvmName(name = "getWithKycStatus$domain_productionRelease")
        /* renamed from: getWithKycStatus$domain_productionRelease  reason: from getter */
        public final boolean getWithKycStatus() {
            return this.withKycStatus;
        }
    }
}
