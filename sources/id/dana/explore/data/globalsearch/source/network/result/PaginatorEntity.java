package id.dana.explore.data.globalsearch.source.network.result;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004JL\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001e\u0010\u0004"}, d2 = {"Lid/dana/explore/data/globalsearch/source/network/result/PaginatorEntity;", "", "", "component1", "()Ljava/lang/Integer;", "component2", "component3", "component4", "component5", "offset", "pageNum", "totalCount", "totalPage", SecurityConstants.KEY_PAGE_SIZE, "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lid/dana/explore/data/globalsearch/source/network/result/PaginatorEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getOffset", "getPageNum", "getPageSize", "getTotalCount", "getTotalPage", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaginatorEntity {
    private final Integer offset;
    private final Integer pageNum;
    private final Integer pageSize;
    private final Integer totalCount;
    private final Integer totalPage;

    public static /* synthetic */ PaginatorEntity copy$default(PaginatorEntity paginatorEntity, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, int i, Object obj) {
        if ((i & 1) != 0) {
            num = paginatorEntity.offset;
        }
        if ((i & 2) != 0) {
            num2 = paginatorEntity.pageNum;
        }
        Integer num6 = num2;
        if ((i & 4) != 0) {
            num3 = paginatorEntity.totalCount;
        }
        Integer num7 = num3;
        if ((i & 8) != 0) {
            num4 = paginatorEntity.totalPage;
        }
        Integer num8 = num4;
        if ((i & 16) != 0) {
            num5 = paginatorEntity.pageSize;
        }
        return paginatorEntity.copy(num, num6, num7, num8, num5);
    }

    /* renamed from: component1  reason: from getter */
    public final Integer getOffset() {
        return this.offset;
    }

    /* renamed from: component2  reason: from getter */
    public final Integer getPageNum() {
        return this.pageNum;
    }

    /* renamed from: component3  reason: from getter */
    public final Integer getTotalCount() {
        return this.totalCount;
    }

    /* renamed from: component4  reason: from getter */
    public final Integer getTotalPage() {
        return this.totalPage;
    }

    /* renamed from: component5  reason: from getter */
    public final Integer getPageSize() {
        return this.pageSize;
    }

    public final PaginatorEntity copy(Integer offset, Integer pageNum, Integer totalCount, Integer totalPage, Integer pageSize) {
        return new PaginatorEntity(offset, pageNum, totalCount, totalPage, pageSize);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PaginatorEntity) {
            PaginatorEntity paginatorEntity = (PaginatorEntity) other;
            return Intrinsics.areEqual(this.offset, paginatorEntity.offset) && Intrinsics.areEqual(this.pageNum, paginatorEntity.pageNum) && Intrinsics.areEqual(this.totalCount, paginatorEntity.totalCount) && Intrinsics.areEqual(this.totalPage, paginatorEntity.totalPage) && Intrinsics.areEqual(this.pageSize, paginatorEntity.pageSize);
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.offset;
        int hashCode = num == null ? 0 : num.hashCode();
        Integer num2 = this.pageNum;
        int hashCode2 = num2 == null ? 0 : num2.hashCode();
        Integer num3 = this.totalCount;
        int hashCode3 = num3 == null ? 0 : num3.hashCode();
        Integer num4 = this.totalPage;
        int hashCode4 = num4 == null ? 0 : num4.hashCode();
        Integer num5 = this.pageSize;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (num5 != null ? num5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaginatorEntity(offset=");
        sb.append(this.offset);
        sb.append(", pageNum=");
        sb.append(this.pageNum);
        sb.append(", totalCount=");
        sb.append(this.totalCount);
        sb.append(", totalPage=");
        sb.append(this.totalPage);
        sb.append(", pageSize=");
        sb.append(this.pageSize);
        sb.append(')');
        return sb.toString();
    }

    public PaginatorEntity(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        this.offset = num;
        this.pageNum = num2;
        this.totalCount = num3;
        this.totalPage = num4;
        this.pageSize = num5;
    }

    @JvmName(name = "getOffset")
    public final Integer getOffset() {
        return this.offset;
    }

    @JvmName(name = "getPageNum")
    public final Integer getPageNum() {
        return this.pageNum;
    }

    @JvmName(name = "getTotalCount")
    public final Integer getTotalCount() {
        return this.totalCount;
    }

    @JvmName(name = "getTotalPage")
    public final Integer getTotalPage() {
        return this.totalPage;
    }

    @JvmName(name = "getPageSize")
    public final Integer getPageSize() {
        return this.pageSize;
    }
}
