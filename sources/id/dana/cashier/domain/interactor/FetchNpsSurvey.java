package id.dana.cashier.domain.interactor;

import id.dana.cashier.domain.CashierRepository;
import id.dana.cashier.domain.model.NpsSurveyConsultInfo;
import id.dana.cashier.domain.model.NpsSurveyConsultRequest;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/domain/interactor/FetchNpsSurvey;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/cashier/domain/model/NpsSurveyConsultInfo;", "Lid/dana/cashier/domain/interactor/FetchNpsSurvey$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/cashier/domain/interactor/FetchNpsSurvey$Params;)Lio/reactivex/Observable;", "Lid/dana/cashier/domain/CashierRepository;", "cashierRepository", "Lid/dana/cashier/domain/CashierRepository;", "<init>", "(Lid/dana/cashier/domain/CashierRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FetchNpsSurvey extends BaseUseCase<NpsSurveyConsultInfo, Params> {
    private final CashierRepository cashierRepository;

    @Inject
    public FetchNpsSurvey(CashierRepository cashierRepository) {
        Intrinsics.checkNotNullParameter(cashierRepository, "");
        this.cashierRepository = cashierRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<NpsSurveyConsultInfo> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.cashierRepository.fetchNpsSurvey(params.getRequest());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/interactor/FetchNpsSurvey$Params;", "", "Lid/dana/cashier/domain/model/NpsSurveyConsultRequest;", "request", "Lid/dana/cashier/domain/model/NpsSurveyConsultRequest;", "getRequest", "()Lid/dana/cashier/domain/model/NpsSurveyConsultRequest;", "<init>", "(Lid/dana/cashier/domain/model/NpsSurveyConsultRequest;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final NpsSurveyConsultRequest request;

        public /* synthetic */ Params(NpsSurveyConsultRequest npsSurveyConsultRequest, DefaultConstructorMarker defaultConstructorMarker) {
            this(npsSurveyConsultRequest);
        }

        @JvmStatic
        public static final Params createFetchNpsSurveyRequest(String str, String str2, String str3, boolean z) {
            return INSTANCE.createFetchNpsSurveyRequest(str, str2, str3, z);
        }

        private Params(NpsSurveyConsultRequest npsSurveyConsultRequest) {
            this.request = npsSurveyConsultRequest;
        }

        @JvmName(name = "getRequest")
        public final NpsSurveyConsultRequest getRequest() {
            return this.request;
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/domain/interactor/FetchNpsSurvey$Params$Companion;", "", "", "transType", "merchantTransType", "merchantName", "", "npsScenario", "Lid/dana/cashier/domain/interactor/FetchNpsSurvey$Params;", "createFetchNpsSurveyRequest", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lid/dana/cashier/domain/interactor/FetchNpsSurvey$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params createFetchNpsSurveyRequest(String transType, String merchantTransType, String merchantName, boolean npsScenario) {
                Intrinsics.checkNotNullParameter(transType, "");
                Intrinsics.checkNotNullParameter(merchantTransType, "");
                Intrinsics.checkNotNullParameter(merchantName, "");
                return new Params(new NpsSurveyConsultRequest(transType, merchantTransType, merchantName, npsScenario), null);
            }
        }
    }
}
