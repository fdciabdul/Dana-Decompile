package id.dana.domain.resetpin.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.resetpin.ResetPinRepository;
import id.dana.domain.resetpin.model.ConsultDanaVizModel;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.repository.UserRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\b\u001a\u001a\u0012\b\u0012\u0006*\u00020\u00020\u0002*\f\u0012\b\u0012\u0006*\u00020\u00020\u00020\u00050\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\n\u001a\u001a\u0012\b\u0012\u0006*\u00020\u00020\u0002*\f\u0012\b\u0012\u0006*\u00020\u00020\u00020\u00050\u0005H\u0002¢\u0006\u0004\b\n\u0010\tR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/domain/resetpin/interactor/ConsultForceDanaVizEnroll;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/resetpin/model/ConsultDanaVizModel;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "checkDanaVizEnroll", "()Lio/reactivex/Observable;", "consultForceFaceAuth", "Lid/dana/domain/resetpin/ResetPinRepository;", "resetPinRepository", "Lid/dana/domain/resetpin/ResetPinRepository;", "Lid/dana/domain/user/repository/UserRepository;", "userRepository", "Lid/dana/domain/user/repository/UserRepository;", "<init>", "(Lid/dana/domain/resetpin/ResetPinRepository;Lid/dana/domain/user/repository/UserRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConsultForceDanaVizEnroll extends BaseUseCase<ConsultDanaVizModel, NoParams> {
    public static final String FACE_AUTH_QUERY_TYPE = "FACE_AUTH";
    private ResetPinRepository resetPinRepository;
    private UserRepository userRepository;

    @Inject
    public ConsultForceDanaVizEnroll(ResetPinRepository resetPinRepository, UserRepository userRepository) {
        Intrinsics.checkNotNullParameter(resetPinRepository, "");
        Intrinsics.checkNotNullParameter(userRepository, "");
        this.resetPinRepository = resetPinRepository;
        this.userRepository = userRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<ConsultDanaVizModel> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable flatMap = this.userRepository.checkUserInfoCacheExpired("FACE_AUTH").flatMap(new Function() { // from class: id.dana.domain.resetpin.interactor.ConsultForceDanaVizEnroll$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2464buildUseCase$lambda0;
                m2464buildUseCase$lambda0 = ConsultForceDanaVizEnroll.m2464buildUseCase$lambda0(ConsultForceDanaVizEnroll.this, (Boolean) obj);
                return m2464buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final ObservableSource m2464buildUseCase$lambda0(ConsultForceDanaVizEnroll consultForceDanaVizEnroll, Boolean bool) {
        Intrinsics.checkNotNullParameter(consultForceDanaVizEnroll, "");
        Intrinsics.checkNotNullParameter(bool, "");
        return bool.booleanValue() ? consultForceDanaVizEnroll.checkDanaVizEnroll() : Observable.just(new ConsultDanaVizModel(false, false));
    }

    private final Observable<ConsultDanaVizModel> checkDanaVizEnroll() {
        return this.userRepository.getFaceAuthInfo(true).flatMap(new Function() { // from class: id.dana.domain.resetpin.interactor.ConsultForceDanaVizEnroll$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2465checkDanaVizEnroll$lambda1;
                m2465checkDanaVizEnroll$lambda1 = ConsultForceDanaVizEnroll.m2465checkDanaVizEnroll$lambda1(ConsultForceDanaVizEnroll.this, (UserInfoResponse) obj);
                return m2465checkDanaVizEnroll$lambda1;
            }
        }).onErrorReturn(new Function() { // from class: id.dana.domain.resetpin.interactor.ConsultForceDanaVizEnroll$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ConsultDanaVizModel m2466checkDanaVizEnroll$lambda2;
                m2466checkDanaVizEnroll$lambda2 = ConsultForceDanaVizEnroll.m2466checkDanaVizEnroll$lambda2((Throwable) obj);
                return m2466checkDanaVizEnroll$lambda2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkDanaVizEnroll$lambda-1  reason: not valid java name */
    public static final ObservableSource m2465checkDanaVizEnroll$lambda1(ConsultForceDanaVizEnroll consultForceDanaVizEnroll, UserInfoResponse userInfoResponse) {
        Intrinsics.checkNotNullParameter(consultForceDanaVizEnroll, "");
        Intrinsics.checkNotNullParameter(userInfoResponse, "");
        return !userInfoResponse.getHasFaceLoginEnrolled() ? consultForceDanaVizEnroll.consultForceFaceAuth() : Observable.just(new ConsultDanaVizModel(false, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkDanaVizEnroll$lambda-2  reason: not valid java name */
    public static final ConsultDanaVizModel m2466checkDanaVizEnroll$lambda2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new ConsultDanaVizModel(false, false);
    }

    private final Observable<ConsultDanaVizModel> consultForceFaceAuth() {
        return this.resetPinRepository.consultForceDanaVizEnroll().map(new Function() { // from class: id.dana.domain.resetpin.interactor.ConsultForceDanaVizEnroll$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ConsultDanaVizModel m2467consultForceFaceAuth$lambda3;
                m2467consultForceFaceAuth$lambda3 = ConsultForceDanaVizEnroll.m2467consultForceFaceAuth$lambda3((ConsultDanaVizModel) obj);
                return m2467consultForceFaceAuth$lambda3;
            }
        }).onErrorReturn(new Function() { // from class: id.dana.domain.resetpin.interactor.ConsultForceDanaVizEnroll$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ConsultDanaVizModel m2468consultForceFaceAuth$lambda4;
                m2468consultForceFaceAuth$lambda4 = ConsultForceDanaVizEnroll.m2468consultForceFaceAuth$lambda4((Throwable) obj);
                return m2468consultForceFaceAuth$lambda4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: consultForceFaceAuth$lambda-3  reason: not valid java name */
    public static final ConsultDanaVizModel m2467consultForceFaceAuth$lambda3(ConsultDanaVizModel consultDanaVizModel) {
        Intrinsics.checkNotNullParameter(consultDanaVizModel, "");
        return new ConsultDanaVizModel(consultDanaVizModel.getIsForced(), consultDanaVizModel.getIsForced());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: consultForceFaceAuth$lambda-4  reason: not valid java name */
    public static final ConsultDanaVizModel m2468consultForceFaceAuth$lambda4(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new ConsultDanaVizModel(false, false);
    }
}
