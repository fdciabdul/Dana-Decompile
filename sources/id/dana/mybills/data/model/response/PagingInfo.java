package id.dana.mybills.data.model.response;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0007"}, d2 = {"Lid/dana/mybills/data/model/response/PagingInfo;", "", "", "component1", "()Z", "", "component2", "()I", "component3", "hasNext", ZdocRecordService.PAGE_NUMBER, SecurityConstants.KEY_PAGE_SIZE, "copy", "(ZII)Lid/dana/mybills/data/model/response/PagingInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Z", "getHasNext", "I", "getPageNumber", "getPageSize", "<init>", "(ZII)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PagingInfo {
    private final boolean hasNext;
    private final int pageNumber;
    private final int pageSize;

    public PagingInfo() {
        this(false, 0, 0, 7, null);
    }

    public static /* synthetic */ PagingInfo copy$default(PagingInfo pagingInfo, boolean z, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = pagingInfo.hasNext;
        }
        if ((i3 & 2) != 0) {
            i = pagingInfo.pageNumber;
        }
        if ((i3 & 4) != 0) {
            i2 = pagingInfo.pageSize;
        }
        return pagingInfo.copy(z, i, i2);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getHasNext() {
        return this.hasNext;
    }

    /* renamed from: component2  reason: from getter */
    public final int getPageNumber() {
        return this.pageNumber;
    }

    /* renamed from: component3  reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    public final PagingInfo copy(boolean hasNext, int pageNumber, int pageSize) {
        return new PagingInfo(hasNext, pageNumber, pageSize);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PagingInfo) {
            PagingInfo pagingInfo = (PagingInfo) other;
            return this.hasNext == pagingInfo.hasNext && this.pageNumber == pagingInfo.pageNumber && this.pageSize == pagingInfo.pageSize;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z = this.hasNext;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + this.pageNumber) * 31) + this.pageSize;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PagingInfo(hasNext=");
        sb.append(this.hasNext);
        sb.append(", pageNumber=");
        sb.append(this.pageNumber);
        sb.append(", pageSize=");
        sb.append(this.pageSize);
        sb.append(')');
        return sb.toString();
    }

    public PagingInfo(boolean z, int i, int i2) {
        this.hasNext = z;
        this.pageNumber = i;
        this.pageSize = i2;
    }

    public /* synthetic */ PagingInfo(boolean z, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? 1 : i, (i3 & 4) != 0 ? 10 : i2);
    }

    @JvmName(name = "getHasNext")
    public final boolean getHasNext() {
        return this.hasNext;
    }

    @JvmName(name = "getPageNumber")
    public final int getPageNumber() {
        return this.pageNumber;
    }

    @JvmName(name = "getPageSize")
    public final int getPageSize() {
        return this.pageSize;
    }
}
