package id.dana.data.statement.repository.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.statement.repository.source.UserStatementEntityData;
import id.dana.data.statement.repository.source.network.request.StatementDetailRequest;
import id.dana.data.statement.repository.source.network.request.StatementSummaryRequest;
import id.dana.data.statement.repository.source.network.response.StatementDetailResult;
import id.dana.data.statement.repository.source.network.response.UserAccumulateQuerySummaryResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0012\u0012\u0006\u0010\u0006\u001a\u00020\u0013\u0012\u0006\u0010\b\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u0006\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/data/statement/repository/source/network/NetworkUserStatementEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/statement/repository/source/network/UserAccumulateFacade;", "Lid/dana/data/statement/repository/source/UserStatementEntityData;", "", "p0", "p1", "", "p2", "Lio/reactivex/Observable;", "Lid/dana/data/statement/repository/source/network/response/StatementDetailResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(JJLjava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/statement/repository/source/network/response/UserAccumulateQuerySummaryResult;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Landroid/content/Context;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p3", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkUserStatementEntityData extends SecureBaseNetwork<UserAccumulateFacade> implements UserStatementEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<UserAccumulateFacade> getFacadeClass() {
        return UserAccumulateFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkUserStatementEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
    }

    @Override // id.dana.data.statement.repository.source.UserStatementEntityData
    public final Observable<UserAccumulateQuerySummaryResult> KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        final StatementSummaryRequest statementSummaryRequest = new StatementSummaryRequest(p0, p1, p2);
        statementSummaryRequest.envInfo = generateMobileEnvInfo();
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.statement.repository.source.network.NetworkUserStatementEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkUserStatementEntityData.BuiltInFictitiousFunctionClassFactory(StatementSummaryRequest.this, (UserAccumulateFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.data.statement.repository.source.UserStatementEntityData
    public final Observable<StatementDetailResult> KClassImpl$Data$declaredNonStaticMembers$2(long p0, long p1, String p2) {
        Intrinsics.checkNotNullParameter(p2, "");
        final StatementDetailRequest statementDetailRequest = new StatementDetailRequest(p0, p1, p2);
        statementDetailRequest.envInfo = generateMobileEnvInfo();
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.statement.repository.source.network.NetworkUserStatementEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkUserStatementEntityData.getAuthRequestContext(StatementDetailRequest.this, (UserAccumulateFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    public static /* synthetic */ StatementDetailResult getAuthRequestContext(StatementDetailRequest statementDetailRequest, UserAccumulateFacade userAccumulateFacade) {
        Intrinsics.checkNotNullParameter(statementDetailRequest, "");
        return userAccumulateFacade.getStatementDetail(statementDetailRequest);
    }

    public static /* synthetic */ UserAccumulateQuerySummaryResult BuiltInFictitiousFunctionClassFactory(StatementSummaryRequest statementSummaryRequest, UserAccumulateFacade userAccumulateFacade) {
        Intrinsics.checkNotNullParameter(statementSummaryRequest, "");
        return userAccumulateFacade.getStatementSummary(statementSummaryRequest);
    }
}
