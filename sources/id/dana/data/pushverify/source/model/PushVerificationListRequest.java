package id.dana.data.pushverify.source.model;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ4\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0014\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\bR\u001a\u0010\f\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0019\u0010\bR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005"}, d2 = {"Lid/dana/data/pushverify/source/model/PushVerificationListRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "", "component1", "()Ljava/util/List;", "", "component2", "()I", "component3", "verificationStatusList", "pageNum", SecurityConstants.KEY_PAGE_SIZE, "copy", "(Ljava/util/List;II)Lid/dana/data/pushverify/source/model/PushVerificationListRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "()Ljava/lang/String;", "I", "getPageNum", "getPageSize", "Ljava/util/List;", "getVerificationStatusList", "<init>", "(Ljava/util/List;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PushVerificationListRequest extends BaseRpcRequest {
    private final int pageNum;
    private final int pageSize;
    private final List<String> verificationStatusList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PushVerificationListRequest copy$default(PushVerificationListRequest pushVerificationListRequest, List list, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = pushVerificationListRequest.verificationStatusList;
        }
        if ((i3 & 2) != 0) {
            i = pushVerificationListRequest.pageNum;
        }
        if ((i3 & 4) != 0) {
            i2 = pushVerificationListRequest.pageSize;
        }
        return pushVerificationListRequest.copy(list, i, i2);
    }

    public final List<String> component1() {
        return this.verificationStatusList;
    }

    /* renamed from: component2  reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    /* renamed from: component3  reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    public final PushVerificationListRequest copy(List<String> verificationStatusList, int pageNum, int pageSize) {
        Intrinsics.checkNotNullParameter(verificationStatusList, "");
        return new PushVerificationListRequest(verificationStatusList, pageNum, pageSize);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PushVerificationListRequest) {
            PushVerificationListRequest pushVerificationListRequest = (PushVerificationListRequest) other;
            return Intrinsics.areEqual(this.verificationStatusList, pushVerificationListRequest.verificationStatusList) && this.pageNum == pushVerificationListRequest.pageNum && this.pageSize == pushVerificationListRequest.pageSize;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.verificationStatusList.hashCode() * 31) + this.pageNum) * 31) + this.pageSize;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PushVerificationListRequest(verificationStatusList=");
        sb.append(this.verificationStatusList);
        sb.append(", pageNum=");
        sb.append(this.pageNum);
        sb.append(", pageSize=");
        sb.append(this.pageSize);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getVerificationStatusList")
    public final List<String> getVerificationStatusList() {
        return this.verificationStatusList;
    }

    @JvmName(name = "getPageNum")
    public final int getPageNum() {
        return this.pageNum;
    }

    @JvmName(name = "getPageSize")
    public final int getPageSize() {
        return this.pageSize;
    }

    public PushVerificationListRequest(List<String> list, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "");
        this.verificationStatusList = list;
        this.pageNum = i;
        this.pageSize = i2;
    }
}
