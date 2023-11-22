package id.dana.data.merchantmanagement.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0007\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0017\u0010\u0004\"\u0004\b\u0018\u0010\u0016"}, d2 = {"Lid/dana/data/merchantmanagement/repository/source/network/request/BoundMerchantRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()I", "component2", "pageNum", "requestVersion", "copy", "(II)Lid/dana/data/merchantmanagement/repository/source/network/request/BoundMerchantRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getPageNum", "setPageNum", "(I)V", "getRequestVersion", "setRequestVersion", "<init>", "(II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BoundMerchantRequest extends BaseRpcRequest {
    private static final int FOR_NEW_VERSION = 2;
    private int pageNum;
    private int requestVersion;

    public static /* synthetic */ BoundMerchantRequest copy$default(BoundMerchantRequest boundMerchantRequest, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = boundMerchantRequest.pageNum;
        }
        if ((i3 & 2) != 0) {
            i2 = boundMerchantRequest.requestVersion;
        }
        return boundMerchantRequest.copy(i, i2);
    }

    /* renamed from: component1  reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    /* renamed from: component2  reason: from getter */
    public final int getRequestVersion() {
        return this.requestVersion;
    }

    public final BoundMerchantRequest copy(int pageNum, int requestVersion) {
        return new BoundMerchantRequest(pageNum, requestVersion);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BoundMerchantRequest) {
            BoundMerchantRequest boundMerchantRequest = (BoundMerchantRequest) other;
            return this.pageNum == boundMerchantRequest.pageNum && this.requestVersion == boundMerchantRequest.requestVersion;
        }
        return false;
    }

    public final int hashCode() {
        return (this.pageNum * 31) + this.requestVersion;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BoundMerchantRequest(pageNum=");
        sb.append(this.pageNum);
        sb.append(", requestVersion=");
        sb.append(this.requestVersion);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ BoundMerchantRequest(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? 2 : i2);
    }

    @JvmName(name = "getPageNum")
    public final int getPageNum() {
        return this.pageNum;
    }

    @JvmName(name = "setPageNum")
    public final void setPageNum(int i) {
        this.pageNum = i;
    }

    @JvmName(name = "getRequestVersion")
    public final int getRequestVersion() {
        return this.requestVersion;
    }

    @JvmName(name = "setRequestVersion")
    public final void setRequestVersion(int i) {
        this.requestVersion = i;
    }

    public BoundMerchantRequest(int i, int i2) {
        this.pageNum = i;
        this.requestVersion = i2;
    }
}
