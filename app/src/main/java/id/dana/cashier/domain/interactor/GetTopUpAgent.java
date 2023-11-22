package id.dana.cashier.domain.interactor;

import id.dana.cashier.domain.CashierRepository;
import id.dana.cashier.domain.model.TopUpConsult;
import id.dana.cashier.domain.model.TopUpConsultRequest;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/domain/interactor/GetTopUpAgent;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/cashier/domain/model/TopUpConsult;", "Lid/dana/cashier/domain/interactor/GetTopUpAgent$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/cashier/domain/interactor/GetTopUpAgent$Params;)Lio/reactivex/Observable;", "Lid/dana/cashier/domain/CashierRepository;", "cashierRepository", "Lid/dana/cashier/domain/CashierRepository;", "<init>", "(Lid/dana/cashier/domain/CashierRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetTopUpAgent extends BaseUseCase<TopUpConsult, Params> {
    private final CashierRepository cashierRepository;

    @Inject
    public GetTopUpAgent(CashierRepository cashierRepository) {
        Intrinsics.checkNotNullParameter(cashierRepository, "");
        this.cashierRepository = cashierRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<TopUpConsult> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.cashierRepository.getTopUpAgent(params.getTopUpConsultRequest());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/interactor/GetTopUpAgent$Params;", "", "Lid/dana/cashier/domain/model/TopUpConsultRequest;", "topUpConsultRequest", "Lid/dana/cashier/domain/model/TopUpConsultRequest;", "getTopUpConsultRequest", "()Lid/dana/cashier/domain/model/TopUpConsultRequest;", "<init>", "(Lid/dana/cashier/domain/model/TopUpConsultRequest;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final TopUpConsultRequest topUpConsultRequest;

        public /* synthetic */ Params(TopUpConsultRequest topUpConsultRequest, DefaultConstructorMarker defaultConstructorMarker) {
            this(topUpConsultRequest);
        }

        @JvmStatic
        public static final Params createTopUpConsultParams(String str, String str2) {
            return INSTANCE.createTopUpConsultParams(str, str2);
        }

        private Params(TopUpConsultRequest topUpConsultRequest) {
            this.topUpConsultRequest = topUpConsultRequest;
        }

        @JvmName(name = "getTopUpConsultRequest")
        public final TopUpConsultRequest getTopUpConsultRequest() {
            return this.topUpConsultRequest;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/cashier/domain/interactor/GetTopUpAgent$Params$Companion;", "", "", "payMethod", "payOption", "Lid/dana/cashier/domain/interactor/GetTopUpAgent$Params;", "createTopUpConsultParams", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/domain/interactor/GetTopUpAgent$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params createTopUpConsultParams(String payMethod, String payOption) {
                return new Params(new TopUpConsultRequest(null, null, payMethod, payOption, 3, null), null);
            }
        }
    }
}
