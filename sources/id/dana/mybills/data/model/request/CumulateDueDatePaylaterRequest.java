package id.dana.mybills.data.model.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007"}, d2 = {"Lid/dana/mybills/data/model/request/CumulateDueDatePaylaterRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "Lid/dana/mybills/data/model/request/PagingInfo;", "component2", "()Lid/dana/mybills/data/model/request/PagingInfo;", "cumulateDueDateType", "pagingInfo", "copy", "(Ljava/lang/String;Lid/dana/mybills/data/model/request/PagingInfo;)Lid/dana/mybills/data/model/request/CumulateDueDatePaylaterRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCumulateDueDateType", "Lid/dana/mybills/data/model/request/PagingInfo;", "getPagingInfo", "<init>", "(Ljava/lang/String;Lid/dana/mybills/data/model/request/PagingInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CumulateDueDatePaylaterRequest extends BaseRpcRequest {
    private final String cumulateDueDateType;
    private final PagingInfo pagingInfo;

    public static /* synthetic */ CumulateDueDatePaylaterRequest copy$default(CumulateDueDatePaylaterRequest cumulateDueDatePaylaterRequest, String str, PagingInfo pagingInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cumulateDueDatePaylaterRequest.cumulateDueDateType;
        }
        if ((i & 2) != 0) {
            pagingInfo = cumulateDueDatePaylaterRequest.pagingInfo;
        }
        return cumulateDueDatePaylaterRequest.copy(str, pagingInfo);
    }

    /* renamed from: component1  reason: from getter */
    public final String getCumulateDueDateType() {
        return this.cumulateDueDateType;
    }

    /* renamed from: component2  reason: from getter */
    public final PagingInfo getPagingInfo() {
        return this.pagingInfo;
    }

    public final CumulateDueDatePaylaterRequest copy(String cumulateDueDateType, PagingInfo pagingInfo) {
        Intrinsics.checkNotNullParameter(cumulateDueDateType, "");
        Intrinsics.checkNotNullParameter(pagingInfo, "");
        return new CumulateDueDatePaylaterRequest(cumulateDueDateType, pagingInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CumulateDueDatePaylaterRequest) {
            CumulateDueDatePaylaterRequest cumulateDueDatePaylaterRequest = (CumulateDueDatePaylaterRequest) other;
            return Intrinsics.areEqual(this.cumulateDueDateType, cumulateDueDatePaylaterRequest.cumulateDueDateType) && Intrinsics.areEqual(this.pagingInfo, cumulateDueDatePaylaterRequest.pagingInfo);
        }
        return false;
    }

    public final int hashCode() {
        return (this.cumulateDueDateType.hashCode() * 31) + this.pagingInfo.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CumulateDueDatePaylaterRequest(cumulateDueDateType=");
        sb.append(this.cumulateDueDateType);
        sb.append(", pagingInfo=");
        sb.append(this.pagingInfo);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getCumulateDueDateType")
    public final String getCumulateDueDateType() {
        return this.cumulateDueDateType;
    }

    @JvmName(name = "getPagingInfo")
    public final PagingInfo getPagingInfo() {
        return this.pagingInfo;
    }

    public CumulateDueDatePaylaterRequest(String str, PagingInfo pagingInfo) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(pagingInfo, "");
        this.cumulateDueDateType = str;
        this.pagingInfo = pagingInfo;
    }
}
