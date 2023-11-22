package id.dana.mybills.data.model.response;

import id.dana.network.base.BaseRpcResultAphome;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R\u001a\u0010\n\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\b"}, d2 = {"Lid/dana/mybills/data/model/response/CumulateDueDatePaylaterResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "Lid/dana/mybills/data/model/response/CumulateDueDateDetail;", "component1", "()Ljava/util/List;", "Lid/dana/mybills/data/model/response/PagingInfo;", "component2", "()Lid/dana/mybills/data/model/response/PagingInfo;", "cumulateDueDateDetailList", "pagingInfo", "copy", "(Ljava/util/List;Lid/dana/mybills/data/model/response/PagingInfo;)Lid/dana/mybills/data/model/response/CumulateDueDatePaylaterResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getCumulateDueDateDetailList", "Lid/dana/mybills/data/model/response/PagingInfo;", "getPagingInfo", "<init>", "(Ljava/util/List;Lid/dana/mybills/data/model/response/PagingInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CumulateDueDatePaylaterResult extends BaseRpcResultAphome {
    private final List<CumulateDueDateDetail> cumulateDueDateDetailList;
    private final PagingInfo pagingInfo;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker, id.dana.mybills.data.model.response.PagingInfo] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CumulateDueDatePaylaterResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.data.model.response.CumulateDueDatePaylaterResult.<init>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CumulateDueDatePaylaterResult copy$default(CumulateDueDatePaylaterResult cumulateDueDatePaylaterResult, List list, PagingInfo pagingInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            list = cumulateDueDatePaylaterResult.cumulateDueDateDetailList;
        }
        if ((i & 2) != 0) {
            pagingInfo = cumulateDueDatePaylaterResult.pagingInfo;
        }
        return cumulateDueDatePaylaterResult.copy(list, pagingInfo);
    }

    public final List<CumulateDueDateDetail> component1() {
        return this.cumulateDueDateDetailList;
    }

    /* renamed from: component2  reason: from getter */
    public final PagingInfo getPagingInfo() {
        return this.pagingInfo;
    }

    public final CumulateDueDatePaylaterResult copy(List<CumulateDueDateDetail> cumulateDueDateDetailList, PagingInfo pagingInfo) {
        Intrinsics.checkNotNullParameter(cumulateDueDateDetailList, "");
        Intrinsics.checkNotNullParameter(pagingInfo, "");
        return new CumulateDueDatePaylaterResult(cumulateDueDateDetailList, pagingInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CumulateDueDatePaylaterResult) {
            CumulateDueDatePaylaterResult cumulateDueDatePaylaterResult = (CumulateDueDatePaylaterResult) other;
            return Intrinsics.areEqual(this.cumulateDueDateDetailList, cumulateDueDatePaylaterResult.cumulateDueDateDetailList) && Intrinsics.areEqual(this.pagingInfo, cumulateDueDatePaylaterResult.pagingInfo);
        }
        return false;
    }

    public final int hashCode() {
        return (this.cumulateDueDateDetailList.hashCode() * 31) + this.pagingInfo.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CumulateDueDatePaylaterResult(cumulateDueDateDetailList=");
        sb.append(this.cumulateDueDateDetailList);
        sb.append(", pagingInfo=");
        sb.append(this.pagingInfo);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ CumulateDueDatePaylaterResult(List list, PagingInfo pagingInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? new PagingInfo(false, 0, 0, 7, null) : pagingInfo);
    }

    @JvmName(name = "getCumulateDueDateDetailList")
    public final List<CumulateDueDateDetail> getCumulateDueDateDetailList() {
        return this.cumulateDueDateDetailList;
    }

    @JvmName(name = "getPagingInfo")
    public final PagingInfo getPagingInfo() {
        return this.pagingInfo;
    }

    public CumulateDueDatePaylaterResult(List<CumulateDueDateDetail> list, PagingInfo pagingInfo) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(pagingInfo, "");
        this.cumulateDueDateDetailList = list;
        this.pagingInfo = pagingInfo;
    }
}
