package id.dana.data.nearbyme.repository.source.network.request.merchantdetail;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.contract.deeplink.path.FeatureParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJH\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0019\u0010\bJ\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u001eR\"\u0010\r\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\u0004\"\u0004\b!\u0010\"R\"\u0010\u000f\u001a\u00020\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010#\u001a\u0004\b$\u0010\b\"\u0004\b%\u0010&R\"\u0010\u0010\u001a\u00020\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010#\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010&R\"\u0010\u000e\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b)\u0010\u0004\"\u0004\b*\u0010\""}, d2 = {"Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/MerchantQueryReviewRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "component4", "", "component5", "()Ljava/util/List;", "merchantId", FeatureParams.SHOP_ID, "pageNum", SecurityConstants.KEY_PAGE_SIZE, "filterCriteria", "copy", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/List;)Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/MerchantQueryReviewRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/util/List;", "getFilterCriteria", "setFilterCriteria", "(Ljava/util/List;)V", "Ljava/lang/String;", "getMerchantId", "setMerchantId", "(Ljava/lang/String;)V", "I", "getPageNum", "setPageNum", "(I)V", "getPageSize", "setPageSize", "getShopId", "setShopId", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MerchantQueryReviewRequest extends BaseRpcRequest {
    private List<String> filterCriteria;
    private String merchantId;
    private int pageNum;
    private int pageSize;
    private String shopId;

    public static /* synthetic */ MerchantQueryReviewRequest copy$default(MerchantQueryReviewRequest merchantQueryReviewRequest, String str, String str2, int i, int i2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = merchantQueryReviewRequest.merchantId;
        }
        if ((i3 & 2) != 0) {
            str2 = merchantQueryReviewRequest.shopId;
        }
        String str3 = str2;
        if ((i3 & 4) != 0) {
            i = merchantQueryReviewRequest.pageNum;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = merchantQueryReviewRequest.pageSize;
        }
        int i5 = i2;
        List<String> list2 = list;
        if ((i3 & 16) != 0) {
            list2 = merchantQueryReviewRequest.filterCriteria;
        }
        return merchantQueryReviewRequest.copy(str, str3, i4, i5, list2);
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

    public final List<String> component5() {
        return this.filterCriteria;
    }

    public final MerchantQueryReviewRequest copy(String merchantId, String shopId, int pageNum, int pageSize, List<String> filterCriteria) {
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(shopId, "");
        Intrinsics.checkNotNullParameter(filterCriteria, "");
        return new MerchantQueryReviewRequest(merchantId, shopId, pageNum, pageSize, filterCriteria);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MerchantQueryReviewRequest) {
            MerchantQueryReviewRequest merchantQueryReviewRequest = (MerchantQueryReviewRequest) other;
            return Intrinsics.areEqual(this.merchantId, merchantQueryReviewRequest.merchantId) && Intrinsics.areEqual(this.shopId, merchantQueryReviewRequest.shopId) && this.pageNum == merchantQueryReviewRequest.pageNum && this.pageSize == merchantQueryReviewRequest.pageSize && Intrinsics.areEqual(this.filterCriteria, merchantQueryReviewRequest.filterCriteria);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((this.merchantId.hashCode() * 31) + this.shopId.hashCode()) * 31) + this.pageNum) * 31) + this.pageSize) * 31) + this.filterCriteria.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantQueryReviewRequest(merchantId=");
        sb.append(this.merchantId);
        sb.append(", shopId=");
        sb.append(this.shopId);
        sb.append(", pageNum=");
        sb.append(this.pageNum);
        sb.append(", pageSize=");
        sb.append(this.pageSize);
        sb.append(", filterCriteria=");
        sb.append(this.filterCriteria);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "setMerchantId")
    public final void setMerchantId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.merchantId = str;
    }

    @JvmName(name = "getShopId")
    public final String getShopId() {
        return this.shopId;
    }

    @JvmName(name = "setShopId")
    public final void setShopId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.shopId = str;
    }

    @JvmName(name = "getPageNum")
    public final int getPageNum() {
        return this.pageNum;
    }

    @JvmName(name = "setPageNum")
    public final void setPageNum(int i) {
        this.pageNum = i;
    }

    @JvmName(name = "getPageSize")
    public final int getPageSize() {
        return this.pageSize;
    }

    @JvmName(name = "setPageSize")
    public final void setPageSize(int i) {
        this.pageSize = i;
    }

    public /* synthetic */ MerchantQueryReviewRequest(String str, String str2, int i, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? 1 : i, (i3 & 8) != 0 ? 10 : i2, (i3 & 16) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getFilterCriteria")
    public final List<String> getFilterCriteria() {
        return this.filterCriteria;
    }

    @JvmName(name = "setFilterCriteria")
    public final void setFilterCriteria(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.filterCriteria = list;
    }

    public MerchantQueryReviewRequest(String str, String str2, int i, int i2, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.merchantId = str;
        this.shopId = str2;
        this.pageNum = i;
        this.pageSize = i2;
        this.filterCriteria = list;
    }
}
