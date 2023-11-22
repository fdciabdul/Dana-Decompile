package id.dana.domain.nearbyme.model;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001BE\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0016¢\u0006\u0004\b%\u0010&Ba\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b%\u0010'R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0010\u001a\u00020\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0005\"\u0004\b\u001d\u0010\u0007R\u001a\u0010\u001e\u001a\u00020\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001aR\"\u0010 \u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0005\"\u0004\b\"\u0010\u0007R\u001a\u0010#\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0005"}, d2 = {"Lid/dana/domain/nearbyme/model/ShopListRequest;", "", "", "isFilterByKybKa", "Z", "()Z", "setFilterByKybKa", "(Z)V", "", "latitude", SummaryActivity.DAYS, "getLatitude", "()D", "longitude", "getLongitude", "", "pageNum", "I", "getPageNum", "()I", SecurityConstants.KEY_PAGE_SIZE, "getPageSize", "", "searchKeyword", "Ljava/lang/String;", "getSearchKeyword", "()Ljava/lang/String;", "shouldFetchFromBackend", "getShouldFetchFromBackend", "setShouldFetchFromBackend", "source", "getSource", "useDiscoveryApi", "getUseDiscoveryApi", "setUseDiscoveryApi", "useNewMerchantCategory", "getUseNewMerchantCategory", "<init>", "(DDIILjava/lang/String;ZLjava/lang/String;)V", "(DDIILjava/lang/String;ZLjava/lang/String;ZZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ShopListRequest {
    private boolean isFilterByKybKa;
    private final double latitude;
    private final double longitude;
    private final int pageNum;
    private final int pageSize;
    private final String searchKeyword;
    private boolean shouldFetchFromBackend;
    private final String source;
    private boolean useDiscoveryApi;
    private final boolean useNewMerchantCategory;

    public ShopListRequest(double d, double d2, int i, int i2, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.latitude = d;
        this.longitude = d2;
        this.pageNum = i;
        this.pageSize = i2;
        this.searchKeyword = str;
        this.useNewMerchantCategory = z;
        this.source = str2;
        this.isFilterByKybKa = z2;
        this.useDiscoveryApi = z3;
        this.shouldFetchFromBackend = z4;
    }

    public /* synthetic */ ShopListRequest(double d, double d2, int i, int i2, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, d2, i, i2, (i3 & 16) != 0 ? "" : str, (i3 & 32) != 0 ? false : z, str2, (i3 & 128) != 0 ? false : z2, (i3 & 256) != 0 ? false : z3, (i3 & 512) != 0 ? false : z4);
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

    @JvmName(name = "getUseNewMerchantCategory")
    public final boolean getUseNewMerchantCategory() {
        return this.useNewMerchantCategory;
    }

    @JvmName(name = "getSource")
    public final String getSource() {
        return this.source;
    }

    @JvmName(name = "isFilterByKybKa")
    /* renamed from: isFilterByKybKa  reason: from getter */
    public final boolean getIsFilterByKybKa() {
        return this.isFilterByKybKa;
    }

    @JvmName(name = "setFilterByKybKa")
    public final void setFilterByKybKa(boolean z) {
        this.isFilterByKybKa = z;
    }

    @JvmName(name = "getUseDiscoveryApi")
    public final boolean getUseDiscoveryApi() {
        return this.useDiscoveryApi;
    }

    @JvmName(name = "setUseDiscoveryApi")
    public final void setUseDiscoveryApi(boolean z) {
        this.useDiscoveryApi = z;
    }

    @JvmName(name = "getShouldFetchFromBackend")
    public final boolean getShouldFetchFromBackend() {
        return this.shouldFetchFromBackend;
    }

    @JvmName(name = "setShouldFetchFromBackend")
    public final void setShouldFetchFromBackend(boolean z) {
        this.shouldFetchFromBackend = z;
    }

    public /* synthetic */ ShopListRequest(double d, double d2, int i, int i2, String str, boolean z, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, d2, i, i2, (i3 & 16) != 0 ? "" : str, (i3 & 32) != 0 ? false : z, str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShopListRequest(double d, double d2, int i, int i2, String str, boolean z, String str2) {
        this(d, d2, i, i2, str, z, str2, false, false, false);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
    }
}
