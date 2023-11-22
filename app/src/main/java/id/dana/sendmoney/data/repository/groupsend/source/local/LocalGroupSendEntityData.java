package id.dana.sendmoney.data.repository.groupsend.source.local;

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
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@GroupSendScope
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u0003\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000b\u0010\u000eJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\tJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\u0006\u0010\u0003\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0006\u0010\u0013J\u001b\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\tJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00042\u0006\u0010\u0003\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u000b\u0010\u0019J\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00042\u0006\u0010\u0003\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u000f\u0010\u001cJ\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00042\u0006\u0010\u0003\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u001eR\u0014\u0010\u0010\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010 "}, d2 = {"Lid/dana/sendmoney/data/repository/groupsend/source/local/LocalGroupSendEntityData;", "Lid/dana/sendmoney/data/repository/groupsend/source/GroupSendEntityData;", "Lid/dana/sendmoney/data/api/groupsend/submit/model/request/BizGroupTransferSubmitRequest;", "p0", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/data/api/groupsend/submit/model/response/BizGroupTransferSubmitResult;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/data/api/groupsend/submit/model/request/BizGroupTransferSubmitRequest;)Lkotlinx/coroutines/flow/Flow;", "", "()Lkotlinx/coroutines/flow/Flow;", "", "getAuthRequestContext", "Lid/dana/sendmoney/data/api/groupsend/detail/model/request/BizGroupDetailEntityRequest;", "Lid/dana/sendmoney/data/api/groupsend/detail/model/response/BizGroupDetailEntityResult;", "(Lid/dana/sendmoney/data/api/groupsend/detail/model/request/BizGroupDetailEntityRequest;)Lkotlinx/coroutines/flow/Flow;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/data/api/groupsend/query/model/request/BizGroupQueryEntityRequest;", "Lid/dana/sendmoney/data/api/groupsend/query/model/response/BizGroupQueryEntityResult;", "(Lid/dana/sendmoney/data/api/groupsend/query/model/request/BizGroupQueryEntityRequest;)Lkotlinx/coroutines/flow/Flow;", "", "Lid/dana/sendmoney/data/config/groupsend/model/GroupSendScenarioConfigEntity;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/data/api/groupsend/init/model/request/BizGroupTransferInitRequest;", "Lid/dana/sendmoney/data/api/groupsend/init/model/response/BizGroupTransferInitResult;", "(Lid/dana/sendmoney/data/api/groupsend/init/model/request/BizGroupTransferInitRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/data/api/groupsend/modify/model/request/BizGroupModifyEntityRequest;", "Lid/dana/sendmoney/data/api/groupsend/modify/model/response/BizGroupModifyEntityResult;", "(Lid/dana/sendmoney/data/api/groupsend/modify/model/request/BizGroupModifyEntityRequest;)Lkotlinx/coroutines/flow/Flow;", "", "(I)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/data/repository/groupsend/source/local/GroupSendPreference;", "Lid/dana/sendmoney/data/repository/groupsend/source/local/GroupSendPreference;", "<init>", "(Lid/dana/sendmoney/data/repository/groupsend/source/local/GroupSendPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocalGroupSendEntityData implements GroupSendEntityData {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GroupSendPreference KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public LocalGroupSendEntityData(GroupSendPreference groupSendPreference) {
        Intrinsics.checkNotNullParameter(groupSendPreference, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = groupSendPreference;
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
        return FlowKt.flow(new LocalGroupSendEntityData$getDefaultAvatarGroup$1(this, null));
    }

    @Override // id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityData
    public final Flow<Unit> MyBillsEntityDataFactory(int p0) {
        return FlowKt.flow(new LocalGroupSendEntityData$saveDefaultAvatarGroup$1(this, p0, null));
    }

    @Override // id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityData
    public final Flow<List<GroupSendScenarioConfigEntity>> MyBillsEntityDataFactory() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityData
    public final Flow<BizGroupQueryEntityResult> BuiltInFictitiousFunctionClassFactory(BizGroupQueryEntityRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityData
    public final Flow<BizGroupTransferSubmitResult> BuiltInFictitiousFunctionClassFactory(BizGroupTransferSubmitRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityData
    public final Flow<BizGroupTransferInitResult> getAuthRequestContext(BizGroupTransferInitRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityData
    public final Flow<BizGroupDetailEntityResult> getAuthRequestContext(BizGroupDetailEntityRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityData
    public final Flow<BizGroupModifyEntityResult> PlaceComponentResult(BizGroupModifyEntityRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }
}
