package id.dana.data.statement.repository.source;

import id.dana.data.statement.repository.source.network.response.StatementDetailResult;
import id.dana.data.statement.repository.source.network.response.UserAccumulateQuerySummaryResult;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\nJ-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/statement/repository/source/UserStatementEntityData;", "", "", "p0", "p1", "", "p2", "Lio/reactivex/Observable;", "Lid/dana/data/statement/repository/source/network/response/StatementDetailResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(JJLjava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/statement/repository/source/network/response/UserAccumulateQuerySummaryResult;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface UserStatementEntityData {
    Observable<StatementDetailResult> KClassImpl$Data$declaredNonStaticMembers$2(long p0, long p1, String p2);

    Observable<UserAccumulateQuerySummaryResult> KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2);
}
