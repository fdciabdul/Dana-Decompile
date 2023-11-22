package id.dana.data.nearbyme.repository.source.network.request.merchantdetail;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.contract.deeplink.path.FeatureParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ:\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0015\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\bR\u001a\u0010\r\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001b\u0010\bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0004"}, d2 = {"Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/MerchantPromoDanaDealRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "component4", "merchantId", FeatureParams.SHOP_ID, "pageNum", SecurityConstants.KEY_PAGE_SIZE, "copy", "(Ljava/lang/String;Ljava/lang/String;II)Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/MerchantPromoDanaDealRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getMerchantId", "I", "getPageNum", "getPageSize", "getShopId", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MerchantPromoDanaDealRequest extends BaseRpcRequest {
    private final String merchantId;
    private final int pageNum;
    private final int pageSize;
    private final String shopId;

    public static /* synthetic */ MerchantPromoDanaDealRequest copy$default(MerchantPromoDanaDealRequest merchantPromoDanaDealRequest, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = merchantPromoDanaDealRequest.merchantId;
        }
        if ((i3 & 2) != 0) {
            str2 = merchantPromoDanaDealRequest.shopId;
        }
        if ((i3 & 4) != 0) {
            i = merchantPromoDanaDealRequest.pageNum;
        }
        if ((i3 & 8) != 0) {
            i2 = merchantPromoDanaDealRequest.pageSize;
        }
        return merchantPromoDanaDealRequest.copy(str, str2, i, i2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getShopId() {
        return this.shopId;
    }

    /* renamed from: component3  reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    /* renamed from: component4  reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    public final MerchantPromoDanaDealRequest copy(String merchantId, String shopId, int pageNum, int pageSize) {
        Intrinsics.checkNotNullParameter(merchantId, "");
        return new MerchantPromoDanaDealRequest(merchantId, shopId, pageNum, pageSize);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MerchantPromoDanaDealRequest) {
            MerchantPromoDanaDealRequest merchantPromoDanaDealRequest = (MerchantPromoDanaDealRequest) other;
            return Intrinsics.areEqual(this.merchantId, merchantPromoDanaDealRequest.merchantId) && Intrinsics.areEqual(this.shopId, merchantPromoDanaDealRequest.shopId) && this.pageNum == merchantPromoDanaDealRequest.pageNum && this.pageSize == merchantPromoDanaDealRequest.pageSize;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.merchantId.hashCode();
        String str = this.shopId;
        return (((((hashCode * 31) + (str == null ? 0 : str.hashCode())) * 31) + this.pageNum) * 31) + this.pageSize;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantPromoDanaDealRequest(merchantId=");
        sb.append(this.merchantId);
        sb.append(", shopId=");
        sb.append(this.shopId);
        sb.append(", pageNum=");
        sb.append(this.pageNum);
        sb.append(", pageSize=");
        sb.append(this.pageSize);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "getShopId")
    public final String getShopId() {
        return this.shopId;
    }

    @JvmName(name = "getPageNum")
    public final int getPageNum() {
        return this.pageNum;
    }

    @JvmName(name = "getPageSize")
    public final int getPageSize() {
        return this.pageSize;
    }

    public MerchantPromoDanaDealRequest(String str, String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "");
        this.merchantId = str;
        this.shopId = str2;
        this.pageNum = i;
        this.pageSize = i2;
    }
}
