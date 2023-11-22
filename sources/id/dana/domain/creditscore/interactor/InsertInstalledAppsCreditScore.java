package id.dana.domain.creditscore.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.creditscore.CreditScoreRepository;
import id.dana.domain.creditscore.model.InsertInstalledAppsScoringData;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\r\u000eB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/creditscore/interactor/InsertInstalledAppsCreditScore;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/creditscore/interactor/InsertInstalledAppsCreditScore$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/creditscore/interactor/InsertInstalledAppsCreditScore$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/creditscore/CreditScoreRepository;", "creditScoreRepository", "Lid/dana/domain/creditscore/CreditScoreRepository;", "<init>", "(Lid/dana/domain/creditscore/CreditScoreRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InsertInstalledAppsCreditScore extends BaseUseCase<Boolean, Params> {
    public static final String TAG = "InsertInstalledAppsCreditScore";
    private final CreditScoreRepository creditScoreRepository;

    @Inject
    public InsertInstalledAppsCreditScore(CreditScoreRepository creditScoreRepository) {
        Intrinsics.checkNotNullParameter(creditScoreRepository, "");
        this.creditScoreRepository = creditScoreRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.creditScoreRepository.sendDataInstalledApp(params.getRequest());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/creditscore/interactor/InsertInstalledAppsCreditScore$Params;", "", "Lid/dana/domain/creditscore/model/InsertInstalledAppsScoringData;", "request", "Lid/dana/domain/creditscore/model/InsertInstalledAppsScoringData;", "getRequest", "()Lid/dana/domain/creditscore/model/InsertInstalledAppsScoringData;", "<init>", "(Lid/dana/domain/creditscore/model/InsertInstalledAppsScoringData;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String SCHEME_DASHBOARD_CICIL = "DASHBOARD_CICIL";
        private static final String TYPE_DASHBOARD_CICIL = "INSTALLED_APPS";
        private final InsertInstalledAppsScoringData request;

        public /* synthetic */ Params(InsertInstalledAppsScoringData insertInstalledAppsScoringData, DefaultConstructorMarker defaultConstructorMarker) {
            this(insertInstalledAppsScoringData);
        }

        @JvmStatic
        public static final Params createDashboardDanaCicilCreditScoring(List<InsertInstalledAppsScoringData.InstalledAppDataInfo> list) {
            return INSTANCE.createDashboardDanaCicilCreditScoring(list);
        }

        private Params(InsertInstalledAppsScoringData insertInstalledAppsScoringData) {
            this.request = insertInstalledAppsScoringData;
        }

        @JvmName(name = "getRequest")
        public final InsertInstalledAppsScoringData getRequest() {
            return this.request;
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\n"}, d2 = {"Lid/dana/domain/creditscore/interactor/InsertInstalledAppsCreditScore$Params$Companion;", "", "", "Lid/dana/domain/creditscore/model/InsertInstalledAppsScoringData$InstalledAppDataInfo;", "value", "Lid/dana/domain/creditscore/interactor/InsertInstalledAppsCreditScore$Params;", "createDashboardDanaCicilCreditScoring", "(Ljava/util/List;)Lid/dana/domain/creditscore/interactor/InsertInstalledAppsCreditScore$Params;", "", "SCHEME_DASHBOARD_CICIL", "Ljava/lang/String;", "TYPE_DASHBOARD_CICIL", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params createDashboardDanaCicilCreditScoring(List<InsertInstalledAppsScoringData.InstalledAppDataInfo> value) {
                Intrinsics.checkNotNullParameter(value, "");
                return new Params(new InsertInstalledAppsScoringData(Params.SCHEME_DASHBOARD_CICIL, Params.TYPE_DASHBOARD_CICIL, value), null);
            }
        }
    }
}
