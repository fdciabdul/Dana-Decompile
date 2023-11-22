package id.dana.sendmoney.data.repository.groupsend.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.network.base.SecureBaseNetworkFlow;
import id.dana.network.rpc.RpcConnector;
import id.dana.sendmoney.data.api.groupsend.detail.model.request.BizGroupDetailEntityRequest;
import id.dana.sendmoney.data.api.groupsend.detail.model.response.BizGroupDetailEntityResult;
import id.dana.sendmoney.data.api.groupsend.init.model.request.BizGroupTransferInitRequest;
import id.dana.sendmoney.data.api.groupsend.init.model.response.BizGroupTransferInitResult;
import id.dana.sendmoney.data.api.groupsend.modify.model.request.BizGroupModifyEntityRequest;
import id.dana.sendmoney.data.api.groupsend.modify.model.response.BizGroupModifyEntityResult;
import id.dana.sendmoney.data.api.groupsend.query.model.request.BizGroupQueryEntityRequest;
import id.dana.sendmoney.data.api.groupsend.query.model.response.BizGroupQueryEntityResult;
import id.dana.sendmoney.data.api.groupsend.submit.model.request.BizGroupTransferSubmitRequest;
import id.dana.sendmoney.data.api.groupsend.submit.model.response.BizGroupTransferSubmitResult;
import id.dana.sendmoney.data.config.groupsend.model.GroupSendScenarioConfigEntity;
import id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityData;
import id.dana.sendmoney.di.scope.GroupSendScope;
import id.dana.utils.foundation.facede.ApSecurity;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@GroupSendScope
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B!\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020$\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H\u0016¢\u0006\u0004\b\b\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\u0006\u0010\u0005\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\r\u0010\u0013J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u000bJ\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u000bJ\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\u0006\u0010\u0005\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\b\u0010\u0018J\u001b\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u000bJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00062\u0006\u0010\u0005\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\r\u0010\u001eJ\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020 0\u00062\u0006\u0010\u0005\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\u0014\u0010!J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\"0\u00062\u0006\u0010\u0005\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001b\u0010#"}, d2 = {"Lid/dana/sendmoney/data/repository/groupsend/source/network/NetworkGroupSendEntityData;", "Lid/dana/network/base/SecureBaseNetworkFlow;", "Lid/dana/sendmoney/data/repository/groupsend/source/network/GroupSendFacade;", "Lid/dana/sendmoney/data/repository/groupsend/source/GroupSendEntityData;", "Lid/dana/sendmoney/data/api/groupsend/submit/model/request/BizGroupTransferSubmitRequest;", "p0", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/data/api/groupsend/submit/model/response/BizGroupTransferSubmitResult;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/data/api/groupsend/submit/model/request/BizGroupTransferSubmitRequest;)Lkotlinx/coroutines/flow/Flow;", "", "()Lkotlinx/coroutines/flow/Flow;", "", "getAuthRequestContext", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/sendmoney/data/api/groupsend/detail/model/request/BizGroupDetailEntityRequest;", "Lid/dana/sendmoney/data/api/groupsend/detail/model/response/BizGroupDetailEntityResult;", "(Lid/dana/sendmoney/data/api/groupsend/detail/model/request/BizGroupDetailEntityRequest;)Lkotlinx/coroutines/flow/Flow;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/data/api/groupsend/query/model/request/BizGroupQueryEntityRequest;", "Lid/dana/sendmoney/data/api/groupsend/query/model/response/BizGroupQueryEntityResult;", "(Lid/dana/sendmoney/data/api/groupsend/query/model/request/BizGroupQueryEntityRequest;)Lkotlinx/coroutines/flow/Flow;", "", "Lid/dana/sendmoney/data/config/groupsend/model/GroupSendScenarioConfigEntity;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/data/api/groupsend/init/model/request/BizGroupTransferInitRequest;", "Lid/dana/sendmoney/data/api/groupsend/init/model/response/BizGroupTransferInitResult;", "(Lid/dana/sendmoney/data/api/groupsend/init/model/request/BizGroupTransferInitRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/data/api/groupsend/modify/model/request/BizGroupModifyEntityRequest;", "Lid/dana/sendmoney/data/api/groupsend/modify/model/response/BizGroupModifyEntityResult;", "(Lid/dana/sendmoney/data/api/groupsend/modify/model/request/BizGroupModifyEntityRequest;)Lkotlinx/coroutines/flow/Flow;", "", "(I)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/foundation/facede/ApSecurity;", "p1", "Landroid/content/Context;", "p2", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/foundation/facede/ApSecurity;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NetworkGroupSendEntityData extends SecureBaseNetworkFlow<GroupSendFacade> implements GroupSendEntityData {
    @Override // id.dana.network.base.BaseNetworkFlow
    public final Class<GroupSendFacade> getFacadeClass() {
        return GroupSendFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkGroupSendEntityData(RpcConnector rpcConnector, ApSecurity apSecurity, Context context) {
        super(apSecurity, context, rpcConnector);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(apSecurity, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityData
    public final Flow<Integer> PlaceComponentResult() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityData
    public final Flow<Integer> KClassImpl$Data$declaredNonStaticMembers$2() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityData
    public final Flow<Boolean> getAuthRequestContext() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityData
    public final Flow<Integer> BuiltInFictitiousFunctionClassFactory() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityData
    public final Flow<Unit> MyBillsEntityDataFactory(int p0) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityData
    public final Flow<List<GroupSendScenarioConfigEntity>> MyBillsEntityDataFactory() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityData
    public final Flow<BizGroupQueryEntityResult> BuiltInFictitiousFunctionClassFactory(final BizGroupQueryEntityRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<GroupSendFacade, BizGroupQueryEntityResult>() { // from class: id.dana.sendmoney.data.repository.groupsend.source.network.NetworkGroupSendEntityData$getGroupSendQuery$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BizGroupQueryEntityResult invoke(GroupSendFacade groupSendFacade) {
                Intrinsics.checkNotNullParameter(groupSendFacade, "");
                return groupSendFacade.getBizGroupQuery((BizGroupQueryEntityRequest) NetworkGroupSendEntityData.getAuthRequestContext(NetworkGroupSendEntityData.this, p0));
            }
        });
    }

    @Override // id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityData
    public final Flow<BizGroupTransferSubmitResult> BuiltInFictitiousFunctionClassFactory(final BizGroupTransferSubmitRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<GroupSendFacade, BizGroupTransferSubmitResult>() { // from class: id.dana.sendmoney.data.repository.groupsend.source.network.NetworkGroupSendEntityData$confirmSendMoneyGroup$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BizGroupTransferSubmitResult invoke(GroupSendFacade groupSendFacade) {
                Intrinsics.checkNotNullParameter(groupSendFacade, "");
                return groupSendFacade.submit((BizGroupTransferSubmitRequest) NetworkGroupSendEntityData.getAuthRequestContext(NetworkGroupSendEntityData.this, p0));
            }
        });
    }

    @Override // id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityData
    public final Flow<BizGroupTransferInitResult> getAuthRequestContext(final BizGroupTransferInitRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<GroupSendFacade, BizGroupTransferInitResult>() { // from class: id.dana.sendmoney.data.repository.groupsend.source.network.NetworkGroupSendEntityData$init$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BizGroupTransferInitResult invoke(GroupSendFacade groupSendFacade) {
                Intrinsics.checkNotNullParameter(groupSendFacade, "");
                return groupSendFacade.init((BizGroupTransferInitRequest) NetworkGroupSendEntityData.getAuthRequestContext(NetworkGroupSendEntityData.this, p0));
            }
        });
    }

    @Override // id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityData
    public final Flow<BizGroupDetailEntityResult> getAuthRequestContext(final BizGroupDetailEntityRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<GroupSendFacade, BizGroupDetailEntityResult>() { // from class: id.dana.sendmoney.data.repository.groupsend.source.network.NetworkGroupSendEntityData$getGroupSendDetail$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BizGroupDetailEntityResult invoke(GroupSendFacade groupSendFacade) {
                Intrinsics.checkNotNullParameter(groupSendFacade, "");
                return groupSendFacade.getBizGroupDetail((BizGroupDetailEntityRequest) NetworkGroupSendEntityData.getAuthRequestContext(NetworkGroupSendEntityData.this, p0));
            }
        });
    }

    @Override // id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityData
    public final Flow<BizGroupModifyEntityResult> PlaceComponentResult(final BizGroupModifyEntityRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<GroupSendFacade, BizGroupModifyEntityResult>() { // from class: id.dana.sendmoney.data.repository.groupsend.source.network.NetworkGroupSendEntityData$modifyGroup$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BizGroupModifyEntityResult invoke(GroupSendFacade groupSendFacade) {
                Intrinsics.checkNotNullParameter(groupSendFacade, "");
                return groupSendFacade.modifyGroup((BizGroupModifyEntityRequest) NetworkGroupSendEntityData.getAuthRequestContext(NetworkGroupSendEntityData.this, p0));
            }
        });
    }

    public static final /* synthetic */ BaseRpcRequest getAuthRequestContext(NetworkGroupSendEntityData networkGroupSendEntityData, BaseRpcRequest baseRpcRequest) {
        baseRpcRequest.envInfo = networkGroupSendEntityData.generateMobileEnvInfo();
        return baseRpcRequest;
    }
}
