package id.dana.domain.referral.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.promotion.Space;
import id.dana.domain.referral.MyReferralConsultRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/domain/referral/interactor/GetReferralBanner;", "Lid/dana/domain/UseCase;", "Lid/dana/domain/promotion/Space;", "Ljava/lang/Void;", "params", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Ljava/lang/Void;)Lio/reactivex/Observable;", "Lid/dana/domain/referral/MyReferralConsultRepository;", "myReferralConsultRepository", "Lid/dana/domain/referral/MyReferralConsultRepository;", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "Lid/dana/domain/PostExecutionThread;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/utils/concurrent/ThreadExecutor;", "<init>", "(Lid/dana/domain/referral/MyReferralConsultRepository;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetReferralBanner extends UseCase<Space, Void> {
    private final MyReferralConsultRepository myReferralConsultRepository;
    private final PostExecutionThread postExecutionThread;
    private final ThreadExecutor threadExecutor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetReferralBanner(MyReferralConsultRepository myReferralConsultRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(myReferralConsultRepository, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        this.myReferralConsultRepository = myReferralConsultRepository;
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    @Override // id.dana.domain.UseCase
    public final Observable<Space> buildUseCaseObservable(Void params) {
        Observable<Space> referralBanner = this.myReferralConsultRepository.getReferralBanner();
        Intrinsics.checkNotNullExpressionValue(referralBanner, "");
        return referralBanner;
    }
}
