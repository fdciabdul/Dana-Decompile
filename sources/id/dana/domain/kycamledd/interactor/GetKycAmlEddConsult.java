package id.dana.domain.kycamledd.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.kycamledd.AmlStatusFalseException;
import id.dana.domain.kycamledd.KycAmlEddRepository;
import id.dana.domain.kycamledd.model.EddConsult;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/kycamledd/interactor/GetKycAmlEddConsult;", "Lid/dana/domain/UseCase;", "Lid/dana/domain/kycamledd/model/EddConsult;", "", "params", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Lkotlin/Unit;)Lio/reactivex/Observable;", "Lid/dana/domain/kycamledd/KycAmlEddRepository;", "kycAmlEddRepository", "Lid/dana/domain/kycamledd/KycAmlEddRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/domain/kycamledd/KycAmlEddRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetKycAmlEddConsult extends UseCase<EddConsult, Unit> {
    private final KycAmlEddRepository kycAmlEddRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetKycAmlEddConsult(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, KycAmlEddRepository kycAmlEddRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        Intrinsics.checkNotNullParameter(kycAmlEddRepository, "");
        this.kycAmlEddRepository = kycAmlEddRepository;
    }

    @Override // id.dana.domain.UseCase
    public final Observable<EddConsult> buildUseCaseObservable(Unit params) {
        Observable flatMap = this.kycAmlEddRepository.getFeatureKycAmlEddEnabled().flatMap(new Function() { // from class: id.dana.domain.kycamledd.interactor.GetKycAmlEddConsult$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2358buildUseCaseObservable$lambda0;
                m2358buildUseCaseObservable$lambda0 = GetKycAmlEddConsult.m2358buildUseCaseObservable$lambda0(GetKycAmlEddConsult.this, (Boolean) obj);
                return m2358buildUseCaseObservable$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCaseObservable$lambda-0  reason: not valid java name */
    public static final ObservableSource m2358buildUseCaseObservable$lambda0(GetKycAmlEddConsult getKycAmlEddConsult, Boolean bool) {
        Observable<EddConsult> error;
        Intrinsics.checkNotNullParameter(getKycAmlEddConsult, "");
        Intrinsics.checkNotNullParameter(bool, "");
        if (bool.booleanValue()) {
            error = getKycAmlEddConsult.kycAmlEddRepository.getEddAmlKycConsult();
        } else {
            error = Observable.error(new AmlStatusFalseException());
            Intrinsics.checkNotNullExpressionValue(error, "");
        }
        return error;
    }
}
