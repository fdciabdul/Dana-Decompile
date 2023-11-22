package id.dana.data.nearbyme.repository.source.network.request;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004JV\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u000bJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004R\u0017\u0010\u0010\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\u0007R\u001a\u0010\u0011\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b!\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b&\u0010\u000bR\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b'\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b(\u0010\u0004"}, d2 = {"Lid/dana/data/nearbyme/repository/source/network/request/NearbyQueryOtherShopListRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "", "component2", "()D", "component3", "", "component4", "()I", "component5", "component6", "component7", "merchantId", "latitude", "longitude", SecurityConstants.KEY_PAGE_SIZE, "pageNum", "searchKeyword", "searchType", "copy", "(Ljava/lang/String;DDIILjava/lang/String;Ljava/lang/String;)Lid/dana/data/nearbyme/repository/source/network/request/NearbyQueryOtherShopListRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", SummaryActivity.DAYS, "getLatitude", "getLongitude", "Ljava/lang/String;", "getMerchantId", "I", "getPageNum", "getPageSize", "getSearchKeyword", "getSearchType", "<init>", "(Ljava/lang/String;DDIILjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class NearbyQueryOtherShopListRequest extends BaseRpcRequest {
    private final double latitude;
    private final double longitude;
    private final String merchantId;
    private final int pageNum;
    private final int pageSize;
    private final String searchKeyword;
    private final String searchType;

    /* renamed from: component1  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component2  reason: from getter */
    public final double getLatitude() {
        return this.latitude;
    }

    /* renamed from: component3  reason: from getter */
    public final double getLongitude() {
        return this.longitude;
    }

    /* renamed from: component4  reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    /* renamed from: component5  reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    /* renamed from: component6  reason: from getter */
    public final String getSearchKeyword() {
        return this.searchKeyword;
    }

    /* renamed from: component7  reason: from getter */
    public final String getSearchType() {
        return this.searchType;
    }

    public final NearbyQueryOtherShopListRequest copy(String merchantId, double latitude, double longitude, int pageSize, int pageNum, String searchKeyword, String searchType) {
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(searchKeyword, "");
        Intrinsics.checkNotNullParameter(searchType, "");
        return new NearbyQueryOtherShopListRequest(merchantId, latitude, longitude, pageSize, pageNum, searchKeyword, searchType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof NearbyQueryOtherShopListRequest) {
            NearbyQueryOtherShopListRequest nearbyQueryOtherShopListRequest = (NearbyQueryOtherShopListRequest) other;
            return Intrinsics.areEqual(this.merchantId, nearbyQueryOtherShopListRequest.merchantId) && Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(nearbyQueryOtherShopListRequest.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(nearbyQueryOtherShopListRequest.longitude)) && this.pageSize == nearbyQueryOtherShopListRequest.pageSize && this.pageNum == nearbyQueryOtherShopListRequest.pageNum && Intrinsics.areEqual(this.searchKeyword, nearbyQueryOtherShopListRequest.searchKeyword) && Intrinsics.areEqual(this.searchType, nearbyQueryOtherShopListRequest.searchType);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((this.merchantId.hashCode() * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.latitude)) * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.longitude)) * 31) + this.pageSize) * 31) + this.pageNum) * 31) + this.searchKeyword.hashCode()) * 31) + this.searchType.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NearbyQueryOtherShopListRequest(merchantId=");
        sb.append(this.merchantId);
        sb.append(", latitude=");
        sb.append(this.latitude);
        sb.append(", longitude=");
        sb.append(this.longitude);
        sb.append(", pageSize=");
        sb.append(this.pageSize);
        sb.append(", pageNum=");
        sb.append(this.pageNum);
        sb.append(", searchKeyword=");
        sb.append(this.searchKeyword);
        sb.append(", searchType=");
        sb.append(this.searchType);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ NearbyQueryOtherShopListRequest(String str, double d, double d2, int i, int i2, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, d, d2, i, i2, (i3 & 32) != 0 ? "" : str2, (i3 & 64) != 0 ? "" : str3);
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "getLatitude")
    public final double getLatitude() {
        return this.latitude;
    }

    @JvmName(name = "getLongitude")
    public final double getLongitude() {
        return this.longitude;
    }

    @JvmName(name = "getPageSize")
    public final int getPageSize() {
        return this.pageSize;
    }

    @JvmName(name = "getPageNum")
    public final int getPageNum() {
        return this.pageNum;
    }

    @JvmName(name = "getSearchKeyword")
    public final String getSearchKeyword() {
        return this.searchKeyword;
    }

    @JvmName(name = "getSearchType")
    public final String getSearchType() {
        return this.searchType;
    }

    public NearbyQueryOtherShopListRequest(String str, double d, double d2, int i, int i2, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.merchantId = str;
        this.latitude = d;
        this.longitude = d2;
        this.pageSize = i;
        this.pageNum = i2;
        this.searchKeyword = str2;
        this.searchType = str3;
    }
}
