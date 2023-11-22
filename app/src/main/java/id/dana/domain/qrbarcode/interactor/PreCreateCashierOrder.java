package id.dana.domain.qrbarcode.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.qrbarcode.PreCreateOrderRequest;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import id.dana.utils.rpc.response.DefaultResponse;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/qrbarcode/interactor/PreCreateCashierOrder;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/utils/rpc/response/DefaultResponse;", "Lid/dana/domain/qrbarcode/interactor/PreCreateCashierOrder$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/qrbarcode/interactor/PreCreateCashierOrder$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/qrbarcode/QrBarcodeRepository;", "repository", "Lid/dana/domain/qrbarcode/QrBarcodeRepository;", "<init>", "(Lid/dana/domain/qrbarcode/QrBarcodeRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PreCreateCashierOrder extends BaseUseCase<DefaultResponse, Params> {
    private final QrBarcodeRepository repository;

    @Inject
    public PreCreateCashierOrder(QrBarcodeRepository qrBarcodeRepository) {
        Intrinsics.checkNotNullParameter(qrBarcodeRepository, "");
        this.repository = qrBarcodeRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<DefaultResponse> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<DefaultResponse> preCreateCashierOrder = this.repository.preCreateCashierOrder(params.getPreCreateOrderRequest());
        Intrinsics.checkNotNullExpressionValue(preCreateCashierOrder, "");
        return preCreateCashierOrder;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/qrbarcode/interactor/PreCreateCashierOrder$Params;", "", "Lid/dana/domain/qrbarcode/PreCreateOrderRequest;", "preCreateOrderRequest", "Lid/dana/domain/qrbarcode/PreCreateOrderRequest;", "getPreCreateOrderRequest", "()Lid/dana/domain/qrbarcode/PreCreateOrderRequest;", "<init>", "(Lid/dana/domain/qrbarcode/PreCreateOrderRequest;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final PreCreateOrderRequest preCreateOrderRequest;

        public /* synthetic */ Params(PreCreateOrderRequest preCreateOrderRequest, DefaultConstructorMarker defaultConstructorMarker) {
            this(preCreateOrderRequest);
        }

        @JvmStatic
        public static final Params preCreateCashierOrder(PreCreateOrderRequest preCreateOrderRequest) {
            return INSTANCE.preCreateCashierOrder(preCreateOrderRequest);
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/qrbarcode/interactor/PreCreateCashierOrder$Params$Companion;", "", "Lid/dana/domain/qrbarcode/PreCreateOrderRequest;", "preCreateOrderRequest", "Lid/dana/domain/qrbarcode/interactor/PreCreateCashierOrder$Params;", "preCreateCashierOrder", "(Lid/dana/domain/qrbarcode/PreCreateOrderRequest;)Lid/dana/domain/qrbarcode/interactor/PreCreateCashierOrder$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params preCreateCashierOrder(PreCreateOrderRequest preCreateOrderRequest) {
                Intrinsics.checkNotNullParameter(preCreateOrderRequest, "");
                return new Params(preCreateOrderRequest, null);
            }
        }

        private Params(PreCreateOrderRequest preCreateOrderRequest) {
            this.preCreateOrderRequest = preCreateOrderRequest;
        }

        @JvmName(name = "getPreCreateOrderRequest")
        public final PreCreateOrderRequest getPreCreateOrderRequest() {
            return this.preCreateOrderRequest;
        }
    }
}
