package id.dana.data.nearbyme.repository.source.network.request.merchantdetail;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.contract.deeplink.path.FeatureParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J0\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001a\u0010\n\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0017\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/BaseMerchantInfoRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "component3", FeatureParams.SHOP_ID, SecurityConstants.KEY_PAGE_SIZE, "pageNum", "copy", "(Ljava/lang/String;II)Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/BaseMerchantInfoRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "I", "getPageNum", "getPageSize", "Ljava/lang/String;", "getShopId", "<init>", "(Ljava/lang/String;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BaseMerchantInfoRequest extends BaseRpcRequest {
    private final int pageNum;
    private final int pageSize;
    private final String shopId;

    public static /* synthetic */ BaseMerchantInfoRequest copy$default(BaseMerchantInfoRequest baseMerchantInfoRequest, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = baseMerchantInfoRequest.shopId;
        }
        if ((i3 & 2) != 0) {
            i = baseMerchantInfoRequest.pageSize;
        }
        if ((i3 & 4) != 0) {
            i2 = baseMerchantInfoRequest.pageNum;
        }
        return baseMerchantInfoRequest.copy(str, i, i2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getShopId() {
        return this.shopId;
    }

    /* renamed from: component2  reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    /* renamed from: component3  reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    public final BaseMerchantInfoRequest copy(String shopId, int pageSize, int pageNum) {
        return new BaseMerchantInfoRequest(shopId, pageSize, pageNum);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BaseMerchantInfoRequest) {
            BaseMerchantInfoRequest baseMerchantInfoRequest = (BaseMerchantInfoRequest) other;
            return Intrinsics.areEqual(this.shopId, baseMerchantInfoRequest.shopId) && this.pageSize == baseMerchantInfoRequest.pageSize && this.pageNum == baseMerchantInfoRequest.pageNum;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.shopId;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.pageSize) * 31) + this.pageNum;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseMerchantInfoRequest(shopId=");
        sb.append(this.shopId);
        sb.append(", pageSize=");
        sb.append(this.pageSize);
        sb.append(", pageNum=");
        sb.append(this.pageNum);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ BaseMerchantInfoRequest(String str, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? 10 : i, (i3 & 4) != 0 ? 1 : i2);
    }

    @JvmName(name = "getShopId")
    public final String getShopId() {
        return this.shopId;
    }

    @JvmName(name = "getPageSize")
    public final int getPageSize() {
        return this.pageSize;
    }

    @JvmName(name = "getPageNum")
    public final int getPageNum() {
        return this.pageNum;
    }

    public BaseMerchantInfoRequest(String str, int i, int i2) {
        this.shopId = str;
        this.pageSize = i;
        this.pageNum = i2;
    }
}
