package id.dana.data.statement.repository.source.network.response;

import id.dana.domain.statement.model.UserStatement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/statement/repository/source/network/response/UserAccumulateQuerySummaryResult;", "", "p0", "Lid/dana/domain/statement/model/UserStatement;", "PlaceComponentResult", "(Lid/dana/data/statement/repository/source/network/response/UserAccumulateQuerySummaryResult;Ljava/lang/String;)Lid/dana/domain/statement/model/UserStatement;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserAccumulateQuerySummaryResultKt {
    public static final UserStatement PlaceComponentResult(UserAccumulateQuerySummaryResult userAccumulateQuerySummaryResult, String str) {
        Intrinsics.checkNotNullParameter(userAccumulateQuerySummaryResult, "");
        Intrinsics.checkNotNullParameter(str, "");
        return new UserStatement(UserAccumulateSummaryKt.PlaceComponentResult(userAccumulateQuerySummaryResult.getAccumulateAmount()), UserAccumulateSummaryKt.MyBillsEntityDataFactory(userAccumulateQuerySummaryResult.getUserAccumulateSummaries()), str, 0, 8, null);
    }
}
