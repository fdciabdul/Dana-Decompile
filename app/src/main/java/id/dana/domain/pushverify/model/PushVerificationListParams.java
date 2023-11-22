package id.dana.domain.pushverify.model;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/domain/pushverify/model/PushVerificationListParams;", "", "", "component1", "()I", "component2", "pageNum", SecurityConstants.KEY_PAGE_SIZE, "copy", "(II)Lid/dana/domain/pushverify/model/PushVerificationListParams;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getPageNum", "getPageSize", "<init>", "(II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PushVerificationListParams {
    private final int pageNum;
    private final int pageSize;

    public static /* synthetic */ PushVerificationListParams copy$default(PushVerificationListParams pushVerificationListParams, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = pushVerificationListParams.pageNum;
        }
        if ((i3 & 2) != 0) {
            i2 = pushVerificationListParams.pageSize;
        }
        return pushVerificationListParams.copy(i, i2);
    }

    /* renamed from: component1  reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    /* renamed from: component2  reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    public final PushVerificationListParams copy(int pageNum, int pageSize) {
        return new PushVerificationListParams(pageNum, pageSize);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PushVerificationListParams) {
            PushVerificationListParams pushVerificationListParams = (PushVerificationListParams) other;
            return this.pageNum == pushVerificationListParams.pageNum && this.pageSize == pushVerificationListParams.pageSize;
        }
        return false;
    }

    public final int hashCode() {
        return (this.pageNum * 31) + this.pageSize;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PushVerificationListParams(pageNum=");
        sb.append(this.pageNum);
        sb.append(", pageSize=");
        sb.append(this.pageSize);
        sb.append(')');
        return sb.toString();
    }

    public PushVerificationListParams(int i, int i2) {
        this.pageNum = i;
        this.pageSize = i2;
    }

    @JvmName(name = "getPageNum")
    public final int getPageNum() {
        return this.pageNum;
    }

    @JvmName(name = "getPageSize")
    public final int getPageSize() {
        return this.pageSize;
    }
}
