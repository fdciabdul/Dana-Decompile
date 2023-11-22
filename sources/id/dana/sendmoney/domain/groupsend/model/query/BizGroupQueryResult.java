package id.dana.sendmoney.domain.groupsend.model.query;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/model/query/BizGroupQueryResult;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lid/dana/sendmoney/domain/groupsend/model/query/Group;", "MyBillsEntityDataFactory", "Ljava/util/List;", "PlaceComponentResult", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BizGroupQueryResult {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final List<Group> PlaceComponentResult;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        return (p0 instanceof BizGroupQueryResult) && Intrinsics.areEqual(this.PlaceComponentResult, ((BizGroupQueryResult) p0).PlaceComponentResult);
    }

    public final int hashCode() {
        return this.PlaceComponentResult.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizGroupQueryResult(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    public BizGroupQueryResult(List<Group> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.PlaceComponentResult = list;
    }
}
