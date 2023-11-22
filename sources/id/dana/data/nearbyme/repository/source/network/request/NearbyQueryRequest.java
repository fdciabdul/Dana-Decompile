package id.dana.data.nearbyme.repository.source.network.request;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000f¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J`\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b \u0010\bJ\u0010\u0010!\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b!\u0010\fR\u0017\u0010\u0019\u001a\u00020\u000f8\u0007¢\u0006\f\n\u0004\b\u0019\u0010\"\u001a\u0004\b#\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b&\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010\bR\u001a\u0010\u0015\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b)\u0010\bR\u001a\u0010\u0018\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b*\u0010\bR\u001a\u0010\u0016\u001a\u00020\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010\fR\u001a\u0010\u0017\u001a\u00020\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b-\u0010\f"}, d2 = {"Lid/dana/data/nearbyme/repository/source/network/request/NearbyQueryRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()D", "component2", "", "component3", "()I", "component4", "", "component5", "()Ljava/lang/String;", "component6", "component7", "", "component8", "()Z", "latitude", "longitude", "pageNum", SecurityConstants.KEY_PAGE_SIZE, "searchKeyword", "searchType", "radius", "homeNearbyFlag", "copy", "(DDIILjava/lang/String;Ljava/lang/String;IZ)Lid/dana/data/nearbyme/repository/source/network/request/NearbyQueryRequest;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Z", "getHomeNearbyFlag", SummaryActivity.DAYS, "getLatitude", "getLongitude", "I", "getPageNum", "getPageSize", "getRadius", "Ljava/lang/String;", "getSearchKeyword", "getSearchType", "<init>", "(DDIILjava/lang/String;Ljava/lang/String;IZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class NearbyQueryRequest extends BaseRpcRequest {
    private final boolean homeNearbyFlag;
    private final double latitude;
    private final double longitude;
    private final int pageNum;
    private final int pageSize;
    private final int radius;
    private final String searchKeyword;
    private final String searchType;

    /* renamed from: component1  reason: from getter */
    public final double getLatitude() {
        return this.latitude;
    }

    /* renamed from: component2  reason: from getter */
    public final double getLongitude() {
        return this.longitude;
    }

    /* renamed from: component3  reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    /* renamed from: component4  reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    /* renamed from: component5  reason: from getter */
    public final String getSearchKeyword() {
        return this.searchKeyword;
    }

    /* renamed from: component6  reason: from getter */
    public final String getSearchType() {
        return this.searchType;
    }

    /* renamed from: component7  reason: from getter */
    public final int getRadius() {
        return this.radius;
    }

    /* renamed from: component8  reason: from getter */
    public final boolean getHomeNearbyFlag() {
        return this.homeNearbyFlag;
    }

    public final NearbyQueryRequest copy(double latitude, double longitude, int pageNum, int pageSize, String searchKeyword, String searchType, int radius, boolean homeNearbyFlag) {
        Intrinsics.checkNotNullParameter(searchKeyword, "");
        Intrinsics.checkNotNullParameter(searchType, "");
        return new NearbyQueryRequest(latitude, longitude, pageNum, pageSize, searchKeyword, searchType, radius, homeNearbyFlag);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof NearbyQueryRequest) {
            NearbyQueryRequest nearbyQueryRequest = (NearbyQueryRequest) other;
            return Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(nearbyQueryRequest.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(nearbyQueryRequest.longitude)) && this.pageNum == nearbyQueryRequest.pageNum && this.pageSize == nearbyQueryRequest.pageSize && Intrinsics.areEqual(this.searchKeyword, nearbyQueryRequest.searchKeyword) && Intrinsics.areEqual(this.searchType, nearbyQueryRequest.searchType) && this.radius == nearbyQueryRequest.radius && this.homeNearbyFlag == nearbyQueryRequest.homeNearbyFlag;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int KClassImpl$Data$declaredNonStaticMembers$2 = BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.latitude);
        int KClassImpl$Data$declaredNonStaticMembers$22 = BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.longitude);
        int i = this.pageNum;
        int i2 = this.pageSize;
        int hashCode = this.searchKeyword.hashCode();
        int hashCode2 = this.searchType.hashCode();
        int i3 = this.radius;
        boolean z = this.homeNearbyFlag;
        int i4 = z;
        if (z != 0) {
            i4 = 1;
        }
        return (((((((((((((KClassImpl$Data$declaredNonStaticMembers$2 * 31) + KClassImpl$Data$declaredNonStaticMembers$22) * 31) + i) * 31) + i2) * 31) + hashCode) * 31) + hashCode2) * 31) + i3) * 31) + i4;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NearbyQueryRequest(latitude=");
        sb.append(this.latitude);
        sb.append(", longitude=");
        sb.append(this.longitude);
        sb.append(", pageNum=");
        sb.append(this.pageNum);
        sb.append(", pageSize=");
        sb.append(this.pageSize);
        sb.append(", searchKeyword=");
        sb.append(this.searchKeyword);
        sb.append(", searchType=");
        sb.append(this.searchType);
        sb.append(", radius=");
        sb.append(this.radius);
        sb.append(", homeNearbyFlag=");
        sb.append(this.homeNearbyFlag);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ NearbyQueryRequest(double d, double d2, int i, int i2, String str, String str2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, d2, i, i2, (i4 & 16) != 0 ? "" : str, (i4 & 32) != 0 ? "" : str2, (i4 & 64) != 0 ? 5000 : i3, (i4 & 128) != 0 ? false : z);
    }

    @JvmName(name = "getLatitude")
    public final double getLatitude() {
        return this.latitude;
    }

    @JvmName(name = "getLongitude")
    public final double getLongitude() {
        return this.longitude;
    }

    @JvmName(name = "getPageNum")
    public final int getPageNum() {
        return this.pageNum;
    }

    @JvmName(name = "getPageSize")
    public final int getPageSize() {
        return this.pageSize;
    }

    @JvmName(name = "getSearchKeyword")
    public final String getSearchKeyword() {
        return this.searchKeyword;
    }

    @JvmName(name = "getSearchType")
    public final String getSearchType() {
        return this.searchType;
    }

    @JvmName(name = "getRadius")
    public final int getRadius() {
        return this.radius;
    }

    @JvmName(name = "getHomeNearbyFlag")
    public final boolean getHomeNearbyFlag() {
        return this.homeNearbyFlag;
    }

    public NearbyQueryRequest(double d, double d2, int i, int i2, String str, String str2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.latitude = d;
        this.longitude = d2;
        this.pageNum = i;
        this.pageSize = i2;
        this.searchKeyword = str;
        this.searchType = str2;
        this.radius = i3;
        this.homeNearbyFlag = z;
    }
}
