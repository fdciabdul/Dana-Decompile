package id.dana.domain.resetpin.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.resetpin.ResetPinRepository;
import id.dana.domain.resetpin.model.ConsultDanaVizModel;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.repository.UserRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\b\u001a\u001a\u0012\b\u0012\u0006*\u00020\u00020\u0002*\f\u0012\b\u0012\u0006*\u00020\u00020\u00020\u00050\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u000f\u001a\u001a\u0012\b\u0012\u0006*\u00020\u00020\u0002*\f\u0012\b\u0012\u0006*\u00020\u00020\u00020\u00050\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\tJ'\u0010\u0010\u001a\u001a\u0012\b\u0012\u0006*\u00020\u00020\u0002*\f\u0012\b\u0012\u0006*\u00020\u00020\u00020\u00050\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\tR\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/domain/resetpin/interactor/ConsultForceDanaVizEnrollAfterLogin;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/resetpin/model/ConsultDanaVizModel;", "Lid/dana/domain/resetpin/interactor/ConsultForceDanaVizEnrollAfterLogin$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/resetpin/interactor/ConsultForceDanaVizEnrollAfterLogin$Params;)Lio/reactivex/Observable;", "checkDanaVizEnroll", "()Lio/reactivex/Observable;", "", "phoneNumber", "", "checkDanaVizPromptFlag", "(Ljava/lang/String;)Lio/reactivex/Observable;", "consultForceFaceAuth", "getForceDanaVizPrompt", "Lid/dana/domain/resetpin/ResetPinRepository;", "resetPinRepository", "Lid/dana/domain/resetpin/ResetPinRepository;", "Lid/dana/domain/user/repository/UserRepository;", "userRepository", "Lid/dana/domain/user/repository/UserRepository;", "<init>", "(Lid/dana/domain/resetpin/ResetPinRepository;Lid/dana/domain/user/repository/UserRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConsultForceDanaVizEnrollAfterLogin extends BaseUseCase<ConsultDanaVizModel, Params> {
    private ResetPinRepository resetPinRepository;
    private UserRepository userRepository;

    @Inject
    public ConsultForceDanaVizEnrollAfterLogin(ResetPinRepository resetPinRepository, UserRepository userRepository) {
        Intrinsics.checkNotNullParameter(resetPinRepository, "");
        Intrinsics.checkNotNullParameter(userRepository, "");
        this.resetPinRepository = resetPinRepository;
        this.userRepository = userRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<ConsultDanaVizModel> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable flatMap = checkDanaVizPromptFlag(params.getPhoneNumber()).flatMap(new Function() { // from class: id.dana.domain.resetpin.interactor.ConsultForceDanaVizEnrollAfterLogin$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2471buildUseCase$lambda0;
                m2471buildUseCase$lambda0 = ConsultForceDanaVizEnrollAfterLogin.m2471buildUseCase$lambda0(ConsultForceDanaVizEnrollAfterLogin.this, (Boolean) obj);
                return m2471buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final ObservableSource m2471buildUseCase$lambda0(ConsultForceDanaVizEnrollAfterLogin consultForceDanaVizEnrollAfterLogin, Boolean bool) {
        Intrinsics.checkNotNullParameter(consultForceDanaVizEnrollAfterLogin, "");
        Intrinsics.checkNotNullParameter(bool, "");
        return bool.booleanValue() ? consultForceDanaVizEnrollAfterLogin.getForceDanaVizPrompt() : Observable.just(new ConsultDanaVizModel(false, false));
    }

    private final Observable<ConsultDanaVizModel> getForceDanaVizPrompt() {
        return this.resetPinRepository.getForceDanaVizPrompt().flatMap(new Function() { // from class: id.dana.domain.resetpin.interactor.ConsultForceDanaVizEnrollAfterLogin$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2476getForceDanaVizPrompt$lambda1;
                m2476getForceDanaVizPrompt$lambda1 = ConsultForceDanaVizEnrollAfterLogin.m2476getForceDanaVizPrompt$lambda1(ConsultForceDanaVizEnrollAfterLogin.this, (Boolean) obj);
                return m2476getForceDanaVizPrompt$lambda1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getForceDanaVizPrompt$lambda-1  reason: not valid java name */
    public static final ObservableSource m2476getForceDanaVizPrompt$lambda1(ConsultForceDanaVizEnrollAfterLogin consultForceDanaVizEnrollAfterLogin, Boolean bool) {
        Intrinsics.checkNotNullParameter(consultForceDanaVizEnrollAfterLogin, "");
        Intrinsics.checkNotNullParameter(bool, "");
        return bool.booleanValue() ? Observable.just(new ConsultDanaVizModel(true, true)) : consultForceDanaVizEnrollAfterLogin.checkDanaVizEnroll();
    }

    private final Observable<ConsultDanaVizModel> checkDanaVizEnroll() {
        return this.userRepository.getFaceAuthInfo(true).flatMap(new Function() { // from class: id.dana.domain.resetpin.interactor.ConsultForceDanaVizEnrollAfterLogin$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2472checkDanaVizEnroll$lambda2;
                m2472checkDanaVizEnroll$lambda2 = ConsultForceDanaVizEnrollAfterLogin.m2472checkDanaVizEnroll$lambda2(ConsultForceDanaVizEnrollAfterLogin.this, (UserInfoResponse) obj);
                return m2472checkDanaVizEnroll$lambda2;
            }
        }).onErrorReturn(new Function() { // from class: id.dana.domain.resetpin.interactor.ConsultForceDanaVizEnrollAfterLogin$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ConsultDanaVizModel m2473checkDanaVizEnroll$lambda3;
                m2473checkDanaVizEnroll$lambda3 = ConsultForceDanaVizEnrollAfterLogin.m2473checkDanaVizEnroll$lambda3((Throwable) obj);
                return m2473checkDanaVizEnroll$lambda3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkDanaVizEnroll$lambda-2  reason: not valid java name */
    public static final ObservableSource m2472checkDanaVizEnroll$lambda2(ConsultForceDanaVizEnrollAfterLogin consultForceDanaVizEnrollAfterLogin, UserInfoResponse userInfoResponse) {
        Intrinsics.checkNotNullParameter(consultForceDanaVizEnrollAfterLogin, "");
        Intrinsics.checkNotNullParameter(userInfoResponse, "");
        return !userInfoResponse.getHasFaceLoginEnrolled() ? consultForceDanaVizEnrollAfterLogin.consultForceFaceAuth() : Observable.just(new ConsultDanaVizModel(false, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkDanaVizEnroll$lambda-3  reason: not valid java name */
    public static final ConsultDanaVizModel m2473checkDanaVizEnroll$lambda3(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new ConsultDanaVizModel(false, false);
    }

    private final Observable<ConsultDanaVizModel> consultForceFaceAuth() {
        return this.resetPinRepository.consultForceDanaVizEnroll().map(new Function() { // from class: id.dana.domain.resetpin.interactor.ConsultForceDanaVizEnrollAfterLogin$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ConsultDanaVizModel m2474consultForceFaceAuth$lambda4;
                m2474consultForceFaceAuth$lambda4 = ConsultForceDanaVizEnrollAfterLogin.m2474consultForceFaceAuth$lambda4((ConsultDanaVizModel) obj);
                return m2474consultForceFaceAuth$lambda4;
            }
        }).onErrorReturn(new Function() { // from class: id.dana.domain.resetpin.interactor.ConsultForceDanaVizEnrollAfterLogin$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ConsultDanaVizModel m2475consultForceFaceAuth$lambda5;
                m2475consultForceFaceAuth$lambda5 = ConsultForceDanaVizEnrollAfterLogin.m2475consultForceFaceAuth$lambda5((Throwable) obj);
                return m2475consultForceFaceAuth$lambda5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: consultForceFaceAuth$lambda-4  reason: not valid java name */
    public static final ConsultDanaVizModel m2474consultForceFaceAuth$lambda4(ConsultDanaVizModel consultDanaVizModel) {
        Intrinsics.checkNotNullParameter(consultDanaVizModel, "");
        return new ConsultDanaVizModel(true, consultDanaVizModel.getIsForced());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: consultForceFaceAuth$lambda-5  reason: not valid java name */
    public static final ConsultDanaVizModel m2475consultForceFaceAuth$lambda5(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new ConsultDanaVizModel(true, false);
    }

    private final Observable<Boolean> checkDanaVizPromptFlag(String phoneNumber) {
        return this.resetPinRepository.getDanaVizPromptAfterResetPin(phoneNumber);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/resetpin/interactor/ConsultForceDanaVizEnrollAfterLogin$Params;", "", "", "phoneNumber", "Ljava/lang/String;", "getPhoneNumber", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final String phoneNumber;

        public Params(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.phoneNumber = str;
        }

        @JvmName(name = "getPhoneNumber")
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }
    }
}
