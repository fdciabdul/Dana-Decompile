package id.dana.sendmoney.data.api.groupsend.detail.model.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.sendmoney.data.api.groupsend.detail.model.ParticipantDetailEntity;
import id.dana.sendmoney.data.api.groupsend.query.model.GroupEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\b"}, d2 = {"Lid/dana/sendmoney/data/api/groupsend/detail/model/response/BizGroupDetailEntityResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/sendmoney/data/api/groupsend/query/model/GroupEntity;", "component1", "()Lid/dana/sendmoney/data/api/groupsend/query/model/GroupEntity;", "", "Lid/dana/sendmoney/data/api/groupsend/detail/model/ParticipantDetailEntity;", "component2", "()Ljava/util/List;", "group", "participants", "copy", "(Lid/dana/sendmoney/data/api/groupsend/query/model/GroupEntity;Ljava/util/List;)Lid/dana/sendmoney/data/api/groupsend/detail/model/response/BizGroupDetailEntityResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/sendmoney/data/api/groupsend/query/model/GroupEntity;", "getGroup", "Ljava/util/List;", "getParticipants", "<init>", "(Lid/dana/sendmoney/data/api/groupsend/query/model/GroupEntity;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BizGroupDetailEntityResult extends BaseRpcResult {
    private final GroupEntity group;
    private final List<ParticipantDetailEntity> participants;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BizGroupDetailEntityResult copy$default(BizGroupDetailEntityResult bizGroupDetailEntityResult, GroupEntity groupEntity, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            groupEntity = bizGroupDetailEntityResult.group;
        }
        if ((i & 2) != 0) {
            list = bizGroupDetailEntityResult.participants;
        }
        return bizGroupDetailEntityResult.copy(groupEntity, list);
    }

    /* renamed from: component1  reason: from getter */
    public final GroupEntity getGroup() {
        return this.group;
    }

    public final List<ParticipantDetailEntity> component2() {
        return this.participants;
    }

    public final BizGroupDetailEntityResult copy(GroupEntity group, List<ParticipantDetailEntity> participants) {
        return new BizGroupDetailEntityResult(group, participants);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BizGroupDetailEntityResult) {
            BizGroupDetailEntityResult bizGroupDetailEntityResult = (BizGroupDetailEntityResult) other;
            return Intrinsics.areEqual(this.group, bizGroupDetailEntityResult.group) && Intrinsics.areEqual(this.participants, bizGroupDetailEntityResult.participants);
        }
        return false;
    }

    public final int hashCode() {
        GroupEntity groupEntity = this.group;
        int hashCode = groupEntity == null ? 0 : groupEntity.hashCode();
        List<ParticipantDetailEntity> list = this.participants;
        return (hashCode * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizGroupDetailEntityResult(group=");
        sb.append(this.group);
        sb.append(", participants=");
        sb.append(this.participants);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getGroup")
    public final GroupEntity getGroup() {
        return this.group;
    }

    @JvmName(name = "getParticipants")
    public final List<ParticipantDetailEntity> getParticipants() {
        return this.participants;
    }

    public BizGroupDetailEntityResult(GroupEntity groupEntity, List<ParticipantDetailEntity> list) {
        this.group = groupEntity;
        this.participants = list;
    }
}
