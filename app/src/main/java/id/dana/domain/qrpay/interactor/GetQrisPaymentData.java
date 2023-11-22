package id.dana.domain.qrpay.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.model.f2fpay.response.F2FPaymentCodeResponse;
import id.dana.domain.qrpay.QrPayRepository;
import id.dana.domain.qrpay.model.QrisPaymentData;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.repository.UserRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ!\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/domain/qrpay/interactor/GetQrisPaymentData;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/qrpay/model/QrisPaymentData;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/domain/model/f2fpay/response/F2FPaymentCodeResponse;", "getPaymentCode", "()Lio/reactivex/Observable;", "Lio/reactivex/functions/Function;", "Lio/reactivex/ObservableSource;", "Lid/dana/domain/user/UserInfoResponse;", "getUserInfo", "()Lio/reactivex/functions/Function;", "putPaymentCodeQrisData", "putUserInfoInQrisData", "Lid/dana/domain/qrpay/QrPayRepository;", "qrPayRepository", "Lid/dana/domain/qrpay/QrPayRepository;", "qrisPaymentData", "Lid/dana/domain/qrpay/model/QrisPaymentData;", "Lid/dana/domain/user/repository/UserRepository;", "userRepository", "Lid/dana/domain/user/repository/UserRepository;", "<init>", "(Lid/dana/domain/qrpay/QrPayRepository;Lid/dana/domain/qrpay/model/QrisPaymentData;Lid/dana/domain/user/repository/UserRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetQrisPaymentData extends BaseUseCase<QrisPaymentData, NoParams> {
    private final QrPayRepository qrPayRepository;
    private final QrisPaymentData qrisPaymentData;
    private final UserRepository userRepository;

    @Inject
    public GetQrisPaymentData(QrPayRepository qrPayRepository, QrisPaymentData qrisPaymentData, UserRepository userRepository) {
        Intrinsics.checkNotNullParameter(qrPayRepository, "");
        Intrinsics.checkNotNullParameter(qrisPaymentData, "");
        Intrinsics.checkNotNullParameter(userRepository, "");
        this.qrPayRepository = qrPayRepository;
        this.qrisPaymentData = qrisPaymentData;
        this.userRepository = userRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<QrisPaymentData> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<QrisPaymentData> flatMap = getPaymentCode().flatMap(putPaymentCodeQrisData()).flatMap(getUserInfo()).flatMap(putUserInfoInQrisData());
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    private final Observable<F2FPaymentCodeResponse> getPaymentCode() {
        Observable<F2FPaymentCodeResponse> onErrorResumeNext = this.qrPayRepository.getPaymentCode().onErrorResumeNext(Observable.just(new F2FPaymentCodeResponse()));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    private final Function<F2FPaymentCodeResponse, ObservableSource<QrisPaymentData>> putPaymentCodeQrisData() {
        return new Function() { // from class: id.dana.domain.qrpay.interactor.GetQrisPaymentData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2445putPaymentCodeQrisData$lambda0;
                m2445putPaymentCodeQrisData$lambda0 = GetQrisPaymentData.m2445putPaymentCodeQrisData$lambda0(GetQrisPaymentData.this, (F2FPaymentCodeResponse) obj);
                return m2445putPaymentCodeQrisData$lambda0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: putPaymentCodeQrisData$lambda-0  reason: not valid java name */
    public static final ObservableSource m2445putPaymentCodeQrisData$lambda0(GetQrisPaymentData getQrisPaymentData, F2FPaymentCodeResponse f2FPaymentCodeResponse) {
        Intrinsics.checkNotNullParameter(getQrisPaymentData, "");
        Intrinsics.checkNotNullParameter(f2FPaymentCodeResponse, "");
        getQrisPaymentData.qrisPaymentData.setPaymentCodeResponse(f2FPaymentCodeResponse);
        return Observable.just(getQrisPaymentData.qrisPaymentData);
    }

    private final Function<QrisPaymentData, ObservableSource<UserInfoResponse>> getUserInfo() {
        return new Function() { // from class: id.dana.domain.qrpay.interactor.GetQrisPaymentData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2444getUserInfo$lambda1;
                m2444getUserInfo$lambda1 = GetQrisPaymentData.m2444getUserInfo$lambda1(GetQrisPaymentData.this, (QrisPaymentData) obj);
                return m2444getUserInfo$lambda1;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getUserInfo$lambda-1  reason: not valid java name */
    public static final ObservableSource m2444getUserInfo$lambda1(GetQrisPaymentData getQrisPaymentData, QrisPaymentData qrisPaymentData) {
        Intrinsics.checkNotNullParameter(getQrisPaymentData, "");
        Intrinsics.checkNotNullParameter(qrisPaymentData, "");
        return getQrisPaymentData.userRepository.getUserInfoWithUserPanForCPM().onErrorResumeNext(Observable.just(new UserInfoResponse(null, null, null, null, false, null, null, null, null, null, null, false, false, false, null, null, null, null, null, 524287, null)));
    }

    private final Function<UserInfoResponse, ObservableSource<QrisPaymentData>> putUserInfoInQrisData() {
        return new Function() { // from class: id.dana.domain.qrpay.interactor.GetQrisPaymentData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2446putUserInfoInQrisData$lambda2;
                m2446putUserInfoInQrisData$lambda2 = GetQrisPaymentData.m2446putUserInfoInQrisData$lambda2(GetQrisPaymentData.this, (UserInfoResponse) obj);
                return m2446putUserInfoInQrisData$lambda2;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: putUserInfoInQrisData$lambda-2  reason: not valid java name */
    public static final ObservableSource m2446putUserInfoInQrisData$lambda2(GetQrisPaymentData getQrisPaymentData, UserInfoResponse userInfoResponse) {
        Intrinsics.checkNotNullParameter(getQrisPaymentData, "");
        Intrinsics.checkNotNullParameter(userInfoResponse, "");
        getQrisPaymentData.qrisPaymentData.setUserInfoResponse(userInfoResponse);
        return Observable.just(getQrisPaymentData.qrisPaymentData);
    }
}
