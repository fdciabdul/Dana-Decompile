package id.dana.domain.statement.interactor;

import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.domain.statement.UserStatementRepository;
import id.dana.domain.statement.model.UserStatement;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/statement/interactor/GetAllStatementSummarySynchronously;", "", "", MaintenanceBroadcastResult.KEY_DATE, "interval", "", "Lid/dana/domain/statement/model/UserStatement;", "execute", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "Lid/dana/domain/statement/UserStatementRepository;", "userStatementRepository", "Lid/dana/domain/statement/UserStatementRepository;", "<init>", "(Lid/dana/domain/statement/UserStatementRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class GetAllStatementSummarySynchronously {
    private final UserStatementRepository userStatementRepository;

    @Inject
    public GetAllStatementSummarySynchronously(UserStatementRepository userStatementRepository) {
        Intrinsics.checkNotNullParameter(userStatementRepository, "");
        this.userStatementRepository = userStatementRepository;
    }

    public final List<UserStatement> execute(String date, String interval) {
        Intrinsics.checkNotNullParameter(date, "");
        Intrinsics.checkNotNullParameter(interval, "");
        try {
            List<UserStatement> blockingFirst = this.userStatementRepository.getAllStatementSummary(date, interval).blockingFirst(CollectionsKt.emptyList());
            Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
            return blockingFirst;
        } catch (RuntimeException unused) {
            return CollectionsKt.emptyList();
        }
    }
}
