package id.dana.sendmoney.data.api.groupsend.query.model.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.sendmoney.data.api.groupsend.query.model.GroupEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0007\u001a\u00020\u00002\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005"}, d2 = {"Lid/dana/sendmoney/data/api/groupsend/query/model/response/BizGroupQueryEntityResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/sendmoney/data/api/groupsend/query/model/GroupEntity;", "component1", "()Ljava/util/List;", "groups", "copy", "(Ljava/util/List;)Lid/dana/sendmoney/data/api/groupsend/query/model/response/BizGroupQueryEntityResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getGroups", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BizGroupQueryEntityResult extends BaseRpcResult {
    private final List<GroupEntity> groups;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BizGroupQueryEntityResult copy$default(BizGroupQueryEntityResult bizGroupQueryEntityResult, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = bizGroupQueryEntityResult.groups;
        }
        return bizGroupQueryEntityResult.copy(list);
    }

    public final List<GroupEntity> component1() {
        return this.groups;
    }

    public final BizGroupQueryEntityResult copy(List<GroupEntity> groups) {
        return new BizGroupQueryEntityResult(groups);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BizGroupQueryEntityResult) && Intrinsics.areEqual(this.groups, ((BizGroupQueryEntityResult) other).groups);
    }

    public final int hashCode() {
        List<GroupEntity> list = this.groups;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizGroupQueryEntityResult(groups=");
        sb.append(this.groups);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getGroups")
    public final List<GroupEntity> getGroups() {
        return this.groups;
    }

    public BizGroupQueryEntityResult(List<GroupEntity> list) {
        this.groups = list;
    }
}
