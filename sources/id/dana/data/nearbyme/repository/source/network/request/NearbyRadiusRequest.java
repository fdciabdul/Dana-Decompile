package id.dana.data.nearbyme.repository.source.network.request;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.sendmoney.summary.SummaryActivity;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BE\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0010\u0010\u000b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJV\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001e\u0010\tJ\u0010\u0010\u001f\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001f\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\u0005R\u001a\u0010\u0011\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b\"\u0010\u0005R\u001a\u0010\u0014\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b$\u0010\tR\u001a\u0010\u0013\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b%\u0010\tR\u001a\u0010\u0012\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b&\u0010\tR\u001a\u0010\u0015\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b(\u0010\u000eR\u001a\u0010\u0016\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b)\u0010\u000e"}, d2 = {"Lid/dana/data/nearbyme/repository/source/network/request/NearbyRadiusRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "Ljava/io/Serializable;", "", "component1", "()D", "component2", "", "component3", "()I", "component4", "component5", "", "component6", "()Ljava/lang/String;", "component7", "latitude", "longitude", "radius", SecurityConstants.KEY_PAGE_SIZE, "pageNum", "searchKeyword", "searchType", "copy", "(DDIIILjava/lang/String;Ljava/lang/String;)Lid/dana/data/nearbyme/repository/source/network/request/NearbyRadiusRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", SummaryActivity.DAYS, "getLatitude", "getLongitude", "I", "getPageNum", "getPageSize", "getRadius", "Ljava/lang/String;", "getSearchKeyword", "getSearchType", "<init>", "(DDIIILjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class NearbyRadiusRequest extends BaseRpcRequest implements Serializable {
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
    public final int getRadius() {
        return this.radius;
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

    public final NearbyRadiusRequest copy(double latitude, double longitude, int radius, int pageSize, int pageNum, String searchKeyword, String searchType) {
        Intrinsics.checkNotNullParameter(searchKeyword, "");
        Intrinsics.checkNotNullParameter(searchType, "");
        return new NearbyRadiusRequest(latitude, longitude, radius, pageSize, pageNum, searchKeyword, searchType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof NearbyRadiusRequest) {
            NearbyRadiusRequest nearbyRadiusRequest = (NearbyRadiusRequest) other;
            return Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(nearbyRadiusRequest.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(nearbyRadiusRequest.longitude)) && this.radius == nearbyRadiusRequest.radius && this.pageSize == nearbyRadiusRequest.pageSize && this.pageNum == nearbyRadiusRequest.pageNum && Intrinsics.areEqual(this.searchKeyword, nearbyRadiusRequest.searchKeyword) && Intrinsics.areEqual(this.searchType, nearbyRadiusRequest.searchType);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.latitude) * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.longitude)) * 31) + this.radius) * 31) + this.pageSize) * 31) + this.pageNum) * 31) + this.searchKeyword.hashCode()) * 31) + this.searchType.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NearbyRadiusRequest(latitude=");
        sb.append(this.latitude);
        sb.append(", longitude=");
        sb.append(this.longitude);
        sb.append(", radius=");
        sb.append(this.radius);
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

    public /* synthetic */ NearbyRadiusRequest(double d, double d2, int i, int i2, int i3, String str, String str2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, d2, i, (i4 & 8) != 0 ? 20 : i2, i3, (i4 & 32) != 0 ? "" : str, (i4 & 64) != 0 ? "" : str2);
    }

    @JvmName(name = "getLatitude")
    public final double getLatitude() {
        return this.latitude;
    }

    @JvmName(name = "getLongitude")
    public final double getLongitude() {
        return this.longitude;
    }

    @JvmName(name = "getRadius")
    public final int getRadius() {
        return this.radius;
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

    public NearbyRadiusRequest(double d, double d2, int i, int i2, int i3, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.latitude = d;
        this.longitude = d2;
        this.radius = i;
        this.pageSize = i2;
        this.pageNum = i3;
        this.searchKeyword = str;
        this.searchType = str2;
    }
}
