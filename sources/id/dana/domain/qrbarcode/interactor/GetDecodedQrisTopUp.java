package id.dana.domain.qrbarcode.interactor;

import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.qrbarcode.DecodedScan;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/qrbarcode/interactor/GetDecodedQrisTopUp;", "Lid/dana/domain/UseCase;", "Lid/dana/domain/qrbarcode/DecodedScan;", "Lid/dana/domain/qrbarcode/interactor/GetDecodedQrisTopUp$Params;", "params", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Lid/dana/domain/qrbarcode/interactor/GetDecodedQrisTopUp$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/qrbarcode/QrBarcodeRepository;", "qrBarcodeRepository", "Lid/dana/domain/qrbarcode/QrBarcodeRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/domain/qrbarcode/QrBarcodeRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetDecodedQrisTopUp extends UseCase<DecodedScan, Params> {
    private final QrBarcodeRepository qrBarcodeRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetDecodedQrisTopUp(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, QrBarcodeRepository qrBarcodeRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        Intrinsics.checkNotNullParameter(qrBarcodeRepository, "");
        this.qrBarcodeRepository = qrBarcodeRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public final Observable<DecodedScan> buildUseCaseObservable(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.qrBarcodeRepository.getDecodedQrBarcode(params.getScanResult(), params.getScene(), params.isNeedCheckScanSelf());
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u000b\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004"}, d2 = {"Lid/dana/domain/qrbarcode/interactor/GetDecodedQrisTopUp$Params;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", ZdocRecordService.SCAN_RESULT, "scene", "isNeedCheckScanSelf", "copy", "(Ljava/lang/String;Ljava/lang/String;Z)Lid/dana/domain/qrbarcode/interactor/GetDecodedQrisTopUp$Params;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "Ljava/lang/String;", "getScanResult", "getScene", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final boolean isNeedCheckScanSelf;
        private final String scanResult;
        private final String scene;

        public static /* synthetic */ Params copy$default(Params params, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.scanResult;
            }
            if ((i & 2) != 0) {
                str2 = params.scene;
            }
            if ((i & 4) != 0) {
                z = params.isNeedCheckScanSelf;
            }
            return params.copy(str, str2, z);
        }

        /* renamed from: component1  reason: from getter */
        public final String getScanResult() {
            return this.scanResult;
        }

        /* renamed from: component2  reason: from getter */
        public final String getScene() {
            return this.scene;
        }

        /* renamed from: component3  reason: from getter */
        public final boolean getIsNeedCheckScanSelf() {
            return this.isNeedCheckScanSelf;
        }

        public final Params copy(String scanResult, String scene, boolean isNeedCheckScanSelf) {
            Intrinsics.checkNotNullParameter(scanResult, "");
            return new Params(scanResult, scene, isNeedCheckScanSelf);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.scanResult, params.scanResult) && Intrinsics.areEqual(this.scene, params.scene) && this.isNeedCheckScanSelf == params.isNeedCheckScanSelf;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.scanResult.hashCode();
            String str = this.scene;
            int hashCode2 = str == null ? 0 : str.hashCode();
            boolean z = this.isNeedCheckScanSelf;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return (((hashCode * 31) + hashCode2) * 31) + i;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(scanResult=");
            sb.append(this.scanResult);
            sb.append(", scene=");
            sb.append(this.scene);
            sb.append(", isNeedCheckScanSelf=");
            sb.append(this.isNeedCheckScanSelf);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
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
        public final boolean isNeedCheckScanSelf() {
            return this.isNeedCheckScanSelf;
        }
    }
}
