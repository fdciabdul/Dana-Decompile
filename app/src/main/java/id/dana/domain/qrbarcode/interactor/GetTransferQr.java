package id.dana.domain.qrbarcode.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.model.QrisTciCoConfig;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
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
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0002\u0018\u0019B\u0019\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u001d\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/domain/qrbarcode/interactor/GetTransferQr;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/qrbarcode/QrUserResult;", "Lid/dana/domain/qrbarcode/interactor/GetTransferQr$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/qrbarcode/interactor/GetTransferQr$Params;)Lio/reactivex/Observable;", "getDynamicTransferQr", "getStaticTransferQr", "", "", "qrisList", "", "removeQrisFirsIndex", "(Ljava/util/List;)V", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "featureConfigRepository", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "Lid/dana/domain/qrbarcode/QrBarcodeRepository;", "repository", "Lid/dana/domain/qrbarcode/QrBarcodeRepository;", "<init>", "(Lid/dana/domain/qrbarcode/QrBarcodeRepository;Lid/dana/domain/featureconfig/FeatureConfigRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetTransferQr extends BaseUseCase<QrUserResult, Params> {
    private static final long REFRESH_QR_IN_SECOND = 60;
    private final FeatureConfigRepository featureConfigRepository;
    private final QrBarcodeRepository repository;

    @Inject
    public GetTransferQr(QrBarcodeRepository qrBarcodeRepository, FeatureConfigRepository featureConfigRepository) {
        Intrinsics.checkNotNullParameter(qrBarcodeRepository, "");
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        this.repository = qrBarcodeRepository;
        this.featureConfigRepository = featureConfigRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<QrUserResult> buildUseCase(final Params params) {
        if (params == null) {
            Observable<QrUserResult> just = Observable.just(new QrUserResult());
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }
        Observable flatMap = this.featureConfigRepository.getQrisTcicoConfig().flatMap(new Function() { // from class: id.dana.domain.qrbarcode.interactor.GetTransferQr$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2428buildUseCase$lambda0;
                m2428buildUseCase$lambda0 = GetTransferQr.m2428buildUseCase$lambda0(GetTransferQr.this, params, (QrisTciCoConfig) obj);
                return m2428buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* renamed from: buildUseCase$lambda-0 */
    public static final ObservableSource m2428buildUseCase$lambda0(GetTransferQr getTransferQr, Params params, QrisTciCoConfig qrisTciCoConfig) {
        Intrinsics.checkNotNullParameter(getTransferQr, "");
        Intrinsics.checkNotNullParameter(qrisTciCoConfig, "");
        return qrisTciCoConfig.getIsRequestMoneyEnabled() ? getTransferQr.getDynamicTransferQr(params) : getTransferQr.getStaticTransferQr(params);
    }

    private final Observable<QrUserResult> getDynamicTransferQr(final Params params) {
        Observable<QrUserResult> flatMap = this.featureConfigRepository.getQrCount().flatMap(new Function() { // from class: id.dana.domain.qrbarcode.interactor.GetTransferQr$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2429getDynamicTransferQr$lambda1;
                m2429getDynamicTransferQr$lambda1 = GetTransferQr.m2429getDynamicTransferQr$lambda1(GetTransferQr.this, params, (Integer) obj);
                return m2429getDynamicTransferQr$lambda1;
            }
        }).flatMap(new Function() { // from class: id.dana.domain.qrbarcode.interactor.GetTransferQr$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2430getDynamicTransferQr$lambda4;
                m2430getDynamicTransferQr$lambda4 = GetTransferQr.m2430getDynamicTransferQr$lambda4(GetTransferQr.this, (QrUserResult) obj);
                return m2430getDynamicTransferQr$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* renamed from: getDynamicTransferQr$lambda-1 */
    public static final ObservableSource m2429getDynamicTransferQr$lambda1(GetTransferQr getTransferQr, Params params, Integer num) {
        Intrinsics.checkNotNullParameter(getTransferQr, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(num, "");
        return getTransferQr.repository.getTransferQr(true, params.getAmount(), params.getComment(), num.intValue());
    }

    /* renamed from: getDynamicTransferQr$lambda-4 */
    public static final ObservableSource m2430getDynamicTransferQr$lambda4(final GetTransferQr getTransferQr, QrUserResult qrUserResult) {
        Intrinsics.checkNotNullParameter(getTransferQr, "");
        Intrinsics.checkNotNullParameter(qrUserResult, "");
        return Observable.just(qrUserResult).map(new Function() { // from class: id.dana.domain.qrbarcode.interactor.GetTransferQr$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                QrUserResult m2431getDynamicTransferQr$lambda4$lambda2;
                m2431getDynamicTransferQr$lambda4$lambda2 = GetTransferQr.m2431getDynamicTransferQr$lambda4$lambda2(GetTransferQr.this, (QrUserResult) obj);
                return m2431getDynamicTransferQr$lambda4$lambda2;
            }
        }).repeatWhen(new Function() { // from class: id.dana.domain.qrbarcode.interactor.GetTransferQr$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2432getDynamicTransferQr$lambda4$lambda3;
                m2432getDynamicTransferQr$lambda4$lambda3 = GetTransferQr.m2432getDynamicTransferQr$lambda4$lambda3((Observable) obj);
                return m2432getDynamicTransferQr$lambda4$lambda3;
            }
        });
    }

    /* renamed from: getDynamicTransferQr$lambda-4$lambda-2 */
    public static final QrUserResult m2431getDynamicTransferQr$lambda4$lambda2(GetTransferQr getTransferQr, QrUserResult qrUserResult) {
        Intrinsics.checkNotNullParameter(getTransferQr, "");
        Intrinsics.checkNotNullParameter(qrUserResult, "");
        if (qrUserResult.getQrCodeList().isEmpty()) {
            return qrUserResult;
        }
        List<String> qrCodeList = qrUserResult.getQrCodeList();
        Intrinsics.checkNotNullExpressionValue(qrCodeList, "");
        qrUserResult.setQrCode((String) CollectionsKt.firstOrNull((List) qrCodeList));
        List<String> qrCodeList2 = qrUserResult.getQrCodeList();
        Intrinsics.checkNotNullExpressionValue(qrCodeList2, "");
        getTransferQr.removeQrisFirsIndex(qrCodeList2);
        return qrUserResult;
    }

    /* renamed from: getDynamicTransferQr$lambda-4$lambda-3 */
    public static final ObservableSource m2432getDynamicTransferQr$lambda4$lambda3(Observable observable) {
        Intrinsics.checkNotNullParameter(observable, "");
        return observable.delay(60L, TimeUnit.SECONDS);
    }

    private final Observable<QrUserResult> getStaticTransferQr(Params params) {
        Observable<QrUserResult> transferQr = this.repository.getTransferQr(false, params.getAmount(), params.getComment(), 1);
        Intrinsics.checkNotNullExpressionValue(transferQr, "");
        return transferQr;
    }

    private final void removeQrisFirsIndex(List<String> qrisList) {
        ((ArrayList) qrisList).remove(0);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/domain/qrbarcode/interactor/GetTransferQr$Params;", "", "", "amount", "Ljava/lang/String;", "getAmount", "()Ljava/lang/String;", DecodedScanBizInfoKey.COMMENT, "getComment", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String amount;
        private final String comment;

        public /* synthetic */ Params(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2);
        }

        @JvmStatic
        public static final Params forGetTransferQr(String str, String str2) {
            return INSTANCE.forGetTransferQr(str, str2);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/qrbarcode/interactor/GetTransferQr$Params$Companion;", "", "", "amount", DecodedScanBizInfoKey.COMMENT, "Lid/dana/domain/qrbarcode/interactor/GetTransferQr$Params;", "forGetTransferQr", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/qrbarcode/interactor/GetTransferQr$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params forGetTransferQr(String amount, String r4) {
                Intrinsics.checkNotNullParameter(amount, "");
                Intrinsics.checkNotNullParameter(r4, "");
                return new Params(amount, r4, null);
            }
        }

        private Params(String str, String str2) {
            this.amount = str;
            this.comment = str2;
        }

        @JvmName(name = "getAmount")
        public final String getAmount() {
            return this.amount;
        }

        @JvmName(name = "getComment")
        public final String getComment() {
            return this.comment;
        }
    }
}
