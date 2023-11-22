package id.dana.domain.promocenter.model;

import com.alibaba.exthub.config.ExtHubMetaInfoParser;
import com.alipay.mobile.map.model.MapConstant;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ`\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004J\u0010\u0010\u001f\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u000bR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0007¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\tR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b#\u0010\u000bR\u001a\u0010\u0016\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b%\u0010\u000fR\u001a\u0010\u0017\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b&\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010'\u001a\u0004\b(\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010'\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b*\u0010\u000b"}, d2 = {"Lid/dana/domain/promocenter/model/PromoCategoryRequest;", "", "", "component1", "()I", "component2", "", "", "component3", "()Ljava/util/List;", "component4", "()Ljava/lang/String;", "component5", "", "component6", "()D", "component7", SecurityConstants.KEY_PAGE_SIZE, ZdocRecordService.PAGE_NUMBER, "categories", "sortBy", ExtHubMetaInfoParser.KEY_EXTENSION_FILTERSTRS, "lat", MapConstant.EXTRA_LON, "copy", "(IILjava/util/List;Ljava/lang/String;Ljava/lang/String;DD)Lid/dana/domain/promocenter/model/PromoCategoryRequest;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/util/List;", "getCategories", "Ljava/lang/String;", "getFilters", SummaryActivity.DAYS, "getLat", "getLon", "I", "getPageNumber", "getPageSize", "getSortBy", "<init>", "(IILjava/util/List;Ljava/lang/String;Ljava/lang/String;DD)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PromoCategoryRequest {
    private final List<String> categories;
    private final String filters;
    private final double lat;
    private final double lon;
    private final int pageNumber;
    private final int pageSize;
    private final String sortBy;

    /* renamed from: component1  reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    /* renamed from: component2  reason: from getter */
    public final int getPageNumber() {
        return this.pageNumber;
    }

    public final List<String> component3() {
        return this.categories;
    }

    /* renamed from: component4  reason: from getter */
    public final String getSortBy() {
        return this.sortBy;
    }

    /* renamed from: component5  reason: from getter */
    public final String getFilters() {
        return this.filters;
    }

    /* renamed from: component6  reason: from getter */
    public final double getLat() {
        return this.lat;
    }

    /* renamed from: component7  reason: from getter */
    public final double getLon() {
        return this.lon;
    }

    public final PromoCategoryRequest copy(int pageSize, int pageNumber, List<String> categories, String sortBy, String filters, double lat, double lon) {
        Intrinsics.checkNotNullParameter(categories, "");
        return new PromoCategoryRequest(pageSize, pageNumber, categories, sortBy, filters, lat, lon);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PromoCategoryRequest) {
            PromoCategoryRequest promoCategoryRequest = (PromoCategoryRequest) other;
            return this.pageSize == promoCategoryRequest.pageSize && this.pageNumber == promoCategoryRequest.pageNumber && Intrinsics.areEqual(this.categories, promoCategoryRequest.categories) && Intrinsics.areEqual(this.sortBy, promoCategoryRequest.sortBy) && Intrinsics.areEqual(this.filters, promoCategoryRequest.filters) && Intrinsics.areEqual((Object) Double.valueOf(this.lat), (Object) Double.valueOf(promoCategoryRequest.lat)) && Intrinsics.areEqual((Object) Double.valueOf(this.lon), (Object) Double.valueOf(promoCategoryRequest.lon));
        }
        return false;
    }

    public final int hashCode() {
        int i = this.pageSize;
        int i2 = this.pageNumber;
        int hashCode = this.categories.hashCode();
        String str = this.sortBy;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.filters;
        return (((((((((((i * 31) + i2) * 31) + hashCode) * 31) + hashCode2) * 31) + (str2 != null ? str2.hashCode() : 0)) * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.lat)) * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.lon);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PromoCategoryRequest(pageSize=");
        sb.append(this.pageSize);
        sb.append(", pageNumber=");
        sb.append(this.pageNumber);
        sb.append(", categories=");
        sb.append(this.categories);
        sb.append(", sortBy=");
        sb.append(this.sortBy);
        sb.append(", filters=");
        sb.append(this.filters);
        sb.append(", lat=");
        sb.append(this.lat);
        sb.append(", lon=");
        sb.append(this.lon);
        sb.append(')');
        return sb.toString();
    }

    public PromoCategoryRequest(int i, int i2, List<String> list, String str, String str2, double d, double d2) {
        Intrinsics.checkNotNullParameter(list, "");
        this.pageSize = i;
        this.pageNumber = i2;
        this.categories = list;
        this.sortBy = str;
        this.filters = str2;
        this.lat = d;
        this.lon = d2;
    }

    @JvmName(name = "getPageNumber")
    public final int getPageNumber() {
        return this.pageNumber;
    }

    @JvmName(name = "getPageSize")
    public final int getPageSize() {
        return this.pageSize;
    }

    public /* synthetic */ PromoCategoryRequest(int i, int i2, List list, String str, String str2, double d, double d2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? CollectionsKt.emptyList() : list, str, str2, d, d2);
    }

    @JvmName(name = "getCategories")
    public final List<String> getCategories() {
        return this.categories;
    }

    @JvmName(name = "getSortBy")
    public final String getSortBy() {
        return this.sortBy;
    }

    @JvmName(name = "getFilters")
    public final String getFilters() {
        return this.filters;
    }

    @JvmName(name = "getLat")
    public final double getLat() {
        return this.lat;
    }

    @JvmName(name = "getLon")
    public final double getLon() {
        return this.lon;
    }
}
