package id.dana.data.statement.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.statement.repository.source.network.request.StatementDetailRequest;
import id.dana.data.statement.repository.source.network.request.StatementSummaryRequest;
import id.dana.data.statement.repository.source.network.response.StatementDetailResult;
import id.dana.data.statement.repository.source.network.response.UserAccumulateQuerySummaryResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/statement/repository/source/network/UserAccumulateFacade;", "", "Lid/dana/data/statement/repository/source/network/request/StatementDetailRequest;", "request", "Lid/dana/data/statement/repository/source/network/response/StatementDetailResult;", "getStatementDetail", "(Lid/dana/data/statement/repository/source/network/request/StatementDetailRequest;)Lid/dana/data/statement/repository/source/network/response/StatementDetailResult;", "Lid/dana/data/statement/repository/source/network/request/StatementSummaryRequest;", "Lid/dana/data/statement/repository/source/network/response/UserAccumulateQuerySummaryResult;", "getStatementSummary", "(Lid/dana/data/statement/repository/source/network/request/StatementSummaryRequest;)Lid/dana/data/statement/repository/source/network/response/UserAccumulateQuerySummaryResult;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface UserAccumulateFacade {
    @OperationType("alipayplus.mobilewallet.user.accumulate.detail")
    @SignCheck
    StatementDetailResult getStatementDetail(StatementDetailRequest request);

    @OperationType("alipayplus.mobilewallet.user.accumulate.summary")
    @SignCheck
    UserAccumulateQuerySummaryResult getStatementSummary(StatementSummaryRequest request);
}
