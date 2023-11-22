package id.dana.domain.kycamledd.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.kycamledd.KycAmlEddRepository;
import id.dana.domain.kycamledd.model.EddSubmitInfo;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/kycamledd/interactor/SubmitEddAmlKyc;", "Lid/dana/domain/UseCase;", "", "Lid/dana/domain/kycamledd/interactor/SubmitEddAmlKyc$Params;", "params", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Lid/dana/domain/kycamledd/interactor/SubmitEddAmlKyc$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/kycamledd/KycAmlEddRepository;", "kycAmlEddRepository", "Lid/dana/domain/kycamledd/KycAmlEddRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/domain/kycamledd/KycAmlEddRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SubmitEddAmlKyc extends UseCase<Boolean, Params> {
    private final KycAmlEddRepository kycAmlEddRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public SubmitEddAmlKyc(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, KycAmlEddRepository kycAmlEddRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        Intrinsics.checkNotNullParameter(kycAmlEddRepository, "");
        this.kycAmlEddRepository = kycAmlEddRepository;
    }

    @Override // id.dana.domain.UseCase
    public final Observable<Boolean> buildUseCaseObservable(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.kycAmlEddRepository.submitEddAmlKyc(params.getEddSubmitInfo());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/kycamledd/interactor/SubmitEddAmlKyc$Params;", "", "Lid/dana/domain/kycamledd/model/EddSubmitInfo;", "eddSubmitInfo", "Lid/dana/domain/kycamledd/model/EddSubmitInfo;", "getEddSubmitInfo", "()Lid/dana/domain/kycamledd/model/EddSubmitInfo;", "<init>", "(Lid/dana/domain/kycamledd/model/EddSubmitInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final EddSubmitInfo eddSubmitInfo;

        public Params(EddSubmitInfo eddSubmitInfo) {
            Intrinsics.checkNotNullParameter(eddSubmitInfo, "");
            this.eddSubmitInfo = eddSubmitInfo;
        }

        @JvmName(name = "getEddSubmitInfo")
        public final EddSubmitInfo getEddSubmitInfo() {
            return this.eddSubmitInfo;
        }
    }
}
