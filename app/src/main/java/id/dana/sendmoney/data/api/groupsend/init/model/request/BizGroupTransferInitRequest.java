package id.dana.sendmoney.data.api.groupsend.init.model.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ4\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\bR\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001b\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/data/api/groupsend/init/model/request/BizGroupTransferInitRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/util/List;", "bizType", "subBizType", "payeeLoginIds", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lid/dana/sendmoney/data/api/groupsend/init/model/request/BizGroupTransferInitRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizType", "Ljava/util/List;", "getPayeeLoginIds", "getSubBizType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BizGroupTransferInitRequest extends BaseRpcRequest {
    private final String bizType;
    private final List<String> payeeLoginIds;
    private final String subBizType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BizGroupTransferInitRequest copy$default(BizGroupTransferInitRequest bizGroupTransferInitRequest, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bizGroupTransferInitRequest.bizType;
        }
        if ((i & 2) != 0) {
            str2 = bizGroupTransferInitRequest.subBizType;
        }
        if ((i & 4) != 0) {
            list = bizGroupTransferInitRequest.payeeLoginIds;
        }
        return bizGroupTransferInitRequest.copy(str, str2, list);
    }

    /* renamed from: component1  reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSubBizType() {
        return this.subBizType;
    }

    public final List<String> component3() {
        return this.payeeLoginIds;
    }

    public final BizGroupTransferInitRequest copy(String bizType, String subBizType, List<String> payeeLoginIds) {
        Intrinsics.checkNotNullParameter(bizType, "");
        Intrinsics.checkNotNullParameter(subBizType, "");
        Intrinsics.checkNotNullParameter(payeeLoginIds, "");
        return new BizGroupTransferInitRequest(bizType, subBizType, payeeLoginIds);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BizGroupTransferInitRequest) {
            BizGroupTransferInitRequest bizGroupTransferInitRequest = (BizGroupTransferInitRequest) other;
            return Intrinsics.areEqual(this.bizType, bizGroupTransferInitRequest.bizType) && Intrinsics.areEqual(this.subBizType, bizGroupTransferInitRequest.subBizType) && Intrinsics.areEqual(this.payeeLoginIds, bizGroupTransferInitRequest.payeeLoginIds);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.bizType.hashCode() * 31) + this.subBizType.hashCode()) * 31) + this.payeeLoginIds.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizGroupTransferInitRequest(bizType=");
        sb.append(this.bizType);
        sb.append(", subBizType=");
        sb.append(this.subBizType);
        sb.append(", payeeLoginIds=");
        sb.append(this.payeeLoginIds);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "getSubBizType")
    public final String getSubBizType() {
        return this.subBizType;
    }

    @JvmName(name = "getPayeeLoginIds")
    public final List<String> getPayeeLoginIds() {
        return this.payeeLoginIds;
    }

    public BizGroupTransferInitRequest(String str, String str2, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.bizType = str;
        this.subBizType = str2;
        this.payeeLoginIds = list;
    }
}
