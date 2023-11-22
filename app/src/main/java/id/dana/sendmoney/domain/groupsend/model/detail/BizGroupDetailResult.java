package id.dana.sendmoney.domain.groupsend.model.detail;

import id.dana.sendmoney.domain.groupsend.model.query.Group;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\f\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000f\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/model/detail/BizGroupDetailResult;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/sendmoney/domain/groupsend/model/query/Group;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/domain/groupsend/model/query/Group;", "BuiltInFictitiousFunctionClassFactory", "", "Lid/dana/sendmoney/domain/groupsend/model/detail/ParticipantDetail;", "getAuthRequestContext", "Ljava/util/List;", "MyBillsEntityDataFactory", "p1", "<init>", "(Lid/dana/sendmoney/domain/groupsend/model/query/Group;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BizGroupDetailResult {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Group BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final List<ParticipantDetail> MyBillsEntityDataFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof BizGroupDetailResult) {
            BizGroupDetailResult bizGroupDetailResult = (BizGroupDetailResult) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, bizGroupDetailResult.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, bizGroupDetailResult.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        return (this.BuiltInFictitiousFunctionClassFactory.hashCode() * 31) + this.MyBillsEntityDataFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizGroupDetailResult(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    public BizGroupDetailResult(Group group, List<ParticipantDetail> list) {
        Intrinsics.checkNotNullParameter(group, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.BuiltInFictitiousFunctionClassFactory = group;
        this.MyBillsEntityDataFactory = list;
    }
}
