package id.dana.domain.statement;

import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.domain.statement.model.UserStatement;
import id.dana.domain.statement.model.UserStatementDetail;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/statement/UserStatementRepository;", "", "", MaintenanceBroadcastResult.KEY_DATE, "timeInterval", "Lio/reactivex/Observable;", "", "Lid/dana/domain/statement/model/UserStatement;", "getAllStatementSummary", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "", "dateStart", "dateEnd", "Lid/dana/domain/statement/StatementType;", "detailStatementType", "Lid/dana/domain/statement/model/UserStatementDetail;", "getStatementDetail", "(JJLid/dana/domain/statement/StatementType;)Lio/reactivex/Observable;", "summaryStatementType", "getStatementSummary", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface UserStatementRepository {
    Observable<List<UserStatement>> getAllStatementSummary(String date, String timeInterval);

    Observable<UserStatementDetail> getStatementDetail(long dateStart, long dateEnd, StatementType detailStatementType);

    Observable<UserStatement> getStatementSummary(String date, String timeInterval, String summaryStatementType);
}
