package id.dana.domain.qrbarcode.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import id.dana.domain.qrbarcode.QrUserResult;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u0019\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/domain/qrbarcode/interactor/GetUserDynamicQr;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/qrbarcode/QrUserResult;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "qrUserResult", "getSequenceQr", "(Lid/dana/domain/qrbarcode/QrUserResult;)Lio/reactivex/Observable;", "", "", "qrisList", "", "removeQrisFirsIndex", "(Ljava/util/List;)V", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "featureConfigRepository", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "Lid/dana/domain/qrbarcode/QrBarcodeRepository;", "qrBarcodeRepository", "Lid/dana/domain/qrbarcode/QrBarcodeRepository;", "<init>", "(Lid/dana/domain/qrbarcode/QrBarcodeRepository;Lid/dana/domain/featureconfig/FeatureConfigRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetUserDynamicQr extends BaseUseCase<QrUserResult, NoParams> {
    private static final long REFRESH_QR_IN_SECOND = 60;
    private final FeatureConfigRepository featureConfigRepository;
    private final QrBarcodeRepository qrBarcodeRepository;

    @Inject
    public GetUserDynamicQr(QrBarcodeRepository qrBarcodeRepository, FeatureConfigRepository featureConfigRepository) {
        Intrinsics.checkNotNullParameter(qrBarcodeRepository, "");
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        this.qrBarcodeRepository = qrBarcodeRepository;
        this.featureConfigRepository = featureConfigRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<QrUserResult> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<QrUserResult> flatMap = this.featureConfigRepository.getQrCount().flatMap(new Function() { // from class: id.dana.domain.qrbarcode.interactor.GetUserDynamicQr$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2437buildUseCase$lambda0;
                m2437buildUseCase$lambda0 = GetUserDynamicQr.m2437buildUseCase$lambda0(GetUserDynamicQr.this, (Integer) obj);
                return m2437buildUseCase$lambda0;
            }
        }).flatMap(new Function() { // from class: id.dana.domain.qrbarcode.interactor.GetUserDynamicQr$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2438buildUseCase$lambda1;
                m2438buildUseCase$lambda1 = GetUserDynamicQr.m2438buildUseCase$lambda1(GetUserDynamicQr.this, (QrUserResult) obj);
                return m2438buildUseCase$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final ObservableSource m2437buildUseCase$lambda0(GetUserDynamicQr getUserDynamicQr, Integer num) {
        Intrinsics.checkNotNullParameter(getUserDynamicQr, "");
        Intrinsics.checkNotNullParameter(num, "");
        return getUserDynamicQr.qrBarcodeRepository.getUserQr(true, "", num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-1  reason: not valid java name */
    public static final ObservableSource m2438buildUseCase$lambda1(GetUserDynamicQr getUserDynamicQr, QrUserResult qrUserResult) {
        Intrinsics.checkNotNullParameter(getUserDynamicQr, "");
        Intrinsics.checkNotNullParameter(qrUserResult, "");
        return getUserDynamicQr.getSequenceQr(qrUserResult);
    }

    private final Observable<QrUserResult> getSequenceQr(QrUserResult qrUserResult) {
        Observable<QrUserResult> repeatWhen = Observable.just(qrUserResult).map(new Function() { // from class: id.dana.domain.qrbarcode.interactor.GetUserDynamicQr$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                QrUserResult m2439getSequenceQr$lambda2;
                m2439getSequenceQr$lambda2 = GetUserDynamicQr.m2439getSequenceQr$lambda2(GetUserDynamicQr.this, (QrUserResult) obj);
                return m2439getSequenceQr$lambda2;
            }
        }).repeatWhen(new Function() { // from class: id.dana.domain.qrbarcode.interactor.GetUserDynamicQr$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2440getSequenceQr$lambda3;
                m2440getSequenceQr$lambda3 = GetUserDynamicQr.m2440getSequenceQr$lambda3((Observable) obj);
                return m2440getSequenceQr$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(repeatWhen, "");
        return repeatWhen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSequenceQr$lambda-2  reason: not valid java name */
    public static final QrUserResult m2439getSequenceQr$lambda2(GetUserDynamicQr getUserDynamicQr, QrUserResult qrUserResult) {
        Intrinsics.checkNotNullParameter(getUserDynamicQr, "");
        Intrinsics.checkNotNullParameter(qrUserResult, "");
        if (qrUserResult.getQrCodeList().isEmpty()) {
            return qrUserResult;
        }
        List<String> qrCodeList = qrUserResult.getQrCodeList();
        Intrinsics.checkNotNullExpressionValue(qrCodeList, "");
        qrUserResult.setQrCode((String) CollectionsKt.firstOrNull((List) qrCodeList));
        List<String> qrCodeList2 = qrUserResult.getQrCodeList();
        Intrinsics.checkNotNullExpressionValue(qrCodeList2, "");
        getUserDynamicQr.removeQrisFirsIndex(qrCodeList2);
        return qrUserResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSequenceQr$lambda-3  reason: not valid java name */
    public static final ObservableSource m2440getSequenceQr$lambda3(Observable observable) {
        Intrinsics.checkNotNullParameter(observable, "");
        return observable.delay(60L, TimeUnit.SECONDS);
    }

    private final void removeQrisFirsIndex(List<String> qrisList) {
        ((ArrayList) qrisList).remove(0);
    }
}
