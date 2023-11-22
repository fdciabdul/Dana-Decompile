package id.dana.sendmoney.data.repository.groupsend.source;

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
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H&¢\u0006\u0004\b\u0006\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0004H&¢\u0006\u0004\b\u000b\u0010\tJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u0003\u001a\u00020\fH&¢\u0006\u0004\b\u000b\u0010\u000eJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H&¢\u0006\u0004\b\u000f\u0010\tJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H&¢\u0006\u0004\b\u0010\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\u0006\u0010\u0003\u001a\u00020\u0011H&¢\u0006\u0004\b\u0006\u0010\u0013J\u001b\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0004H&¢\u0006\u0004\b\u0016\u0010\tJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00042\u0006\u0010\u0003\u001a\u00020\u0017H&¢\u0006\u0004\b\u000b\u0010\u0019J\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00042\u0006\u0010\u0003\u001a\u00020\u001aH&¢\u0006\u0004\b\u000f\u0010\u001cJ\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00042\u0006\u0010\u0003\u001a\u00020\bH&¢\u0006\u0004\b\u0016\u0010\u001eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/data/repository/groupsend/source/GroupSendEntityData;", "", "Lid/dana/sendmoney/data/api/groupsend/submit/model/request/BizGroupTransferSubmitRequest;", "p0", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/data/api/groupsend/submit/model/response/BizGroupTransferSubmitResult;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/data/api/groupsend/submit/model/request/BizGroupTransferSubmitRequest;)Lkotlinx/coroutines/flow/Flow;", "", "()Lkotlinx/coroutines/flow/Flow;", "", "getAuthRequestContext", "Lid/dana/sendmoney/data/api/groupsend/detail/model/request/BizGroupDetailEntityRequest;", "Lid/dana/sendmoney/data/api/groupsend/detail/model/response/BizGroupDetailEntityResult;", "(Lid/dana/sendmoney/data/api/groupsend/detail/model/request/BizGroupDetailEntityRequest;)Lkotlinx/coroutines/flow/Flow;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/data/api/groupsend/query/model/request/BizGroupQueryEntityRequest;", "Lid/dana/sendmoney/data/api/groupsend/query/model/response/BizGroupQueryEntityResult;", "(Lid/dana/sendmoney/data/api/groupsend/query/model/request/BizGroupQueryEntityRequest;)Lkotlinx/coroutines/flow/Flow;", "", "Lid/dana/sendmoney/data/config/groupsend/model/GroupSendScenarioConfigEntity;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/data/api/groupsend/init/model/request/BizGroupTransferInitRequest;", "Lid/dana/sendmoney/data/api/groupsend/init/model/response/BizGroupTransferInitResult;", "(Lid/dana/sendmoney/data/api/groupsend/init/model/request/BizGroupTransferInitRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/data/api/groupsend/modify/model/request/BizGroupModifyEntityRequest;", "Lid/dana/sendmoney/data/api/groupsend/modify/model/response/BizGroupModifyEntityResult;", "(Lid/dana/sendmoney/data/api/groupsend/modify/model/request/BizGroupModifyEntityRequest;)Lkotlinx/coroutines/flow/Flow;", "", "(I)Lkotlinx/coroutines/flow/Flow;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface GroupSendEntityData {
    Flow<Integer> BuiltInFictitiousFunctionClassFactory();

    Flow<BizGroupQueryEntityResult> BuiltInFictitiousFunctionClassFactory(BizGroupQueryEntityRequest p0);

    Flow<BizGroupTransferSubmitResult> BuiltInFictitiousFunctionClassFactory(BizGroupTransferSubmitRequest p0);

    Flow<Integer> KClassImpl$Data$declaredNonStaticMembers$2();

    Flow<List<GroupSendScenarioConfigEntity>> MyBillsEntityDataFactory();

    Flow<Unit> MyBillsEntityDataFactory(int p0);

    Flow<Integer> PlaceComponentResult();

    Flow<BizGroupModifyEntityResult> PlaceComponentResult(BizGroupModifyEntityRequest p0);

    Flow<Boolean> getAuthRequestContext();

    Flow<BizGroupDetailEntityResult> getAuthRequestContext(BizGroupDetailEntityRequest p0);

    Flow<BizGroupTransferInitResult> getAuthRequestContext(BizGroupTransferInitRequest p0);
}
