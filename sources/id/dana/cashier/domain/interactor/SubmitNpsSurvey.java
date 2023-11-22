package id.dana.cashier.domain.interactor;

import id.dana.cashier.domain.CashierRepository;
import id.dana.cashier.domain.model.NpsSurveySubmitRequest;
import id.dana.domain.core.usecase.CompletableUseCase;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/cashier/domain/interactor/SubmitNpsSurvey;", "Lid/dana/domain/core/usecase/CompletableUseCase;", "Lid/dana/cashier/domain/interactor/SubmitNpsSurvey$Params;", "params", "Lio/reactivex/Completable;", "buildUseCase", "(Lid/dana/cashier/domain/interactor/SubmitNpsSurvey$Params;)Lio/reactivex/Completable;", "Lid/dana/cashier/domain/CashierRepository;", "cashierRepository", "Lid/dana/cashier/domain/CashierRepository;", "<init>", "(Lid/dana/cashier/domain/CashierRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SubmitNpsSurvey extends CompletableUseCase<Params> {
    private final CashierRepository cashierRepository;

    @Inject
    public SubmitNpsSurvey(CashierRepository cashierRepository) {
        Intrinsics.checkNotNullParameter(cashierRepository, "");
        this.cashierRepository = cashierRepository;
    }

    @Override // id.dana.domain.core.usecase.CompletableUseCase
    public final Completable buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Completable ignoreElements = this.cashierRepository.submitNpsSurvey(params.getRequest()).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/interactor/SubmitNpsSurvey$Params;", "", "Lid/dana/cashier/domain/model/NpsSurveySubmitRequest;", "request", "Lid/dana/cashier/domain/model/NpsSurveySubmitRequest;", "getRequest", "()Lid/dana/cashier/domain/model/NpsSurveySubmitRequest;", "<init>", "(Lid/dana/cashier/domain/model/NpsSurveySubmitRequest;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final NpsSurveySubmitRequest request;

        public /* synthetic */ Params(NpsSurveySubmitRequest npsSurveySubmitRequest, DefaultConstructorMarker defaultConstructorMarker) {
            this(npsSurveySubmitRequest);
        }

        @JvmStatic
        public static final Params createNpsSurveySubmitRequest(NpsSurveySubmitRequest npsSurveySubmitRequest) {
            return INSTANCE.createNpsSurveySubmitRequest(npsSurveySubmitRequest);
        }

        private Params(NpsSurveySubmitRequest npsSurveySubmitRequest) {
            this.request = npsSurveySubmitRequest;
        }

        @JvmName(name = "getRequest")
        public final NpsSurveySubmitRequest getRequest() {
            return this.request;
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/interactor/SubmitNpsSurvey$Params$Companion;", "", "Lid/dana/cashier/domain/model/NpsSurveySubmitRequest;", "request", "Lid/dana/cashier/domain/interactor/SubmitNpsSurvey$Params;", "createNpsSurveySubmitRequest", "(Lid/dana/cashier/domain/model/NpsSurveySubmitRequest;)Lid/dana/cashier/domain/interactor/SubmitNpsSurvey$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params createNpsSurveySubmitRequest(NpsSurveySubmitRequest request) {
                Intrinsics.checkNotNullParameter(request, "");
                return new Params(request, null);
            }
        }
    }
}
