package id.dana.domain.qrbarcode.interactor;

import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.domain.core.usecase.SingleUseCase;
import id.dana.domain.qrbarcode.DecodedScan;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/qrbarcode/interactor/GetDecodedQrBarcode;", "Lid/dana/domain/core/usecase/SingleUseCase;", "Lid/dana/domain/qrbarcode/DecodedScan;", "Lid/dana/domain/qrbarcode/interactor/GetDecodedQrBarcode$Params;", "params", "Lio/reactivex/Single;", "buildUseCase", "(Lid/dana/domain/qrbarcode/interactor/GetDecodedQrBarcode$Params;)Lio/reactivex/Single;", "Lid/dana/domain/qrbarcode/QrBarcodeRepository;", "repository", "Lid/dana/domain/qrbarcode/QrBarcodeRepository;", "<init>", "(Lid/dana/domain/qrbarcode/QrBarcodeRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetDecodedQrBarcode extends SingleUseCase<DecodedScan, Params> {
    private final QrBarcodeRepository repository;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [io.reactivex.Scheduler, kotlin.jvm.internal.DefaultConstructorMarker] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GetDecodedQrBarcode(id.dana.domain.qrbarcode.QrBarcodeRepository r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            r2.repository = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.qrbarcode.interactor.GetDecodedQrBarcode.<init>(id.dana.domain.qrbarcode.QrBarcodeRepository):void");
    }

    @Override // id.dana.domain.core.usecase.SingleUseCase
    public final Single<DecodedScan> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Single<DecodedScan> firstOrError = this.repository.getDecodedQrBarcode(params.getScanResult(), params.getScene(), params.getIsNeedCheckScanSelf()).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "");
        return firstOrError;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB!\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\u0007\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n"}, d2 = {"Lid/dana/domain/qrbarcode/interactor/GetDecodedQrBarcode$Params;", "", "", "isNeedCheckScanSelf", "Z", "()Z", "", ZdocRecordService.SCAN_RESULT, "Ljava/lang/String;", "getScanResult", "()Ljava/lang/String;", "scene", "getScene", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean isNeedCheckScanSelf;
        private final String scanResult;
        private final String scene;

        public /* synthetic */ Params(String str, String str2, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, z);
        }

        @JvmStatic
        public static final Params forDecodeQrBarcode(String str, String str2, boolean z) {
            return INSTANCE.forDecodeQrBarcode(str, str2, z);
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/qrbarcode/interactor/GetDecodedQrBarcode$Params$Companion;", "", "", ZdocRecordService.SCAN_RESULT, "scene", "", "isNeedCheckScanSelf", "Lid/dana/domain/qrbarcode/interactor/GetDecodedQrBarcode$Params;", "forDecodeQrBarcode", "(Ljava/lang/String;Ljava/lang/String;Z)Lid/dana/domain/qrbarcode/interactor/GetDecodedQrBarcode$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params forDecodeQrBarcode(String scanResult, String scene, boolean isNeedCheckScanSelf) {
                Intrinsics.checkNotNullParameter(scanResult, "");
                Intrinsics.checkNotNullParameter(scene, "");
                return new Params(scanResult, scene, isNeedCheckScanSelf, null);
            }
        }

        private Params(String str, String str2, boolean z) {
            this.scanResult = str;
            this.scene = str2;
            this.isNeedCheckScanSelf = z;
        }

        @JvmName(name = "getScanResult")
        public final String getScanResult() {
            return this.scanResult;
        }

        @JvmName(name = "getScene")
        public final String getScene() {
            return this.scene;
        }

        @JvmName(name = "isNeedCheckScanSelf")
        /* renamed from: isNeedCheckScanSelf  reason: from getter */
        public final boolean getIsNeedCheckScanSelf() {
            return this.isNeedCheckScanSelf;
        }
    }
}
