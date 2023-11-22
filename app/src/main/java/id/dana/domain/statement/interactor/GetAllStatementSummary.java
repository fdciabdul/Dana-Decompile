package id.dana.domain.statement.interactor;

import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.statement.UserStatementRepository;
import id.dana.domain.statement.model.UserStatement;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/statement/interactor/GetAllStatementSummary;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/statement/model/UserStatement;", "Lid/dana/domain/statement/interactor/GetAllStatementSummary$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/statement/interactor/GetAllStatementSummary$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/statement/UserStatementRepository;", "userStatementRepository", "Lid/dana/domain/statement/UserStatementRepository;", "<init>", "(Lid/dana/domain/statement/UserStatementRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetAllStatementSummary extends BaseUseCase<List<? extends UserStatement>, Params> {
    private final UserStatementRepository userStatementRepository;

    @Inject
    public GetAllStatementSummary(UserStatementRepository userStatementRepository) {
        Intrinsics.checkNotNullParameter(userStatementRepository, "");
        this.userStatementRepository = userStatementRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<UserStatement>> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.userStatementRepository.getAllStatementSummary(params.getDate(), params.getInterval());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/domain/statement/interactor/GetAllStatementSummary$Params;", "", "", MaintenanceBroadcastResult.KEY_DATE, "Ljava/lang/String;", "getDate", "()Ljava/lang/String;", "interval", "getInterval", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final String date;
        private final String interval;

        public Params(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.date = str;
            this.interval = str2;
        }

        @JvmName(name = "getDate")
        public final String getDate() {
            return this.date;
        }

        @JvmName(name = "getInterval")
        public final String getInterval() {
            return this.interval;
        }
    }
}
