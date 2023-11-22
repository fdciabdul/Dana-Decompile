package id.dana.mybills.data.model.request;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010Jt\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\"\u0010\u0010J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0004R\u0017\u0010\u0018\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b%\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010&\u001a\u0004\b(\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b)\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b*\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b+\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b,\u0010\u000bR\u001a\u0010\u0019\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010-\u001a\u0004\b.\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b/\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b0\u0010\u0004"}, d2 = {"Lid/dana/mybills/data/model/request/HighlightSubscriptionRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component10", "component2", "component3", "component4", "", "component5", "()Z", "component6", "component7", "", "component8", "()I", "component9", "divisionId", "goodsType", "ipRoleId", "merchantId", "needScheduleInfo", "recurringType", "countOnlv", "pageNum", SecurityConstants.KEY_PAGE_SIZE, "dueType", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZIILjava/lang/String;)Lid/dana/mybills/data/model/request/HighlightSubscriptionRequest;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Z", "getCountOnlv", "Ljava/lang/String;", "getDivisionId", "getDueType", "getGoodsType", "getIpRoleId", "getMerchantId", "getNeedScheduleInfo", "I", "getPageNum", "getPageSize", "getRecurringType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZIILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class HighlightSubscriptionRequest extends BaseRpcRequest {
    private final boolean countOnlv;
    private final String divisionId;
    private final String dueType;
    private final String goodsType;
    private final String ipRoleId;
    private final String merchantId;
    private final boolean needScheduleInfo;
    private final int pageNum;
    private final int pageSize;
    private final String recurringType;

    public HighlightSubscriptionRequest() {
        this(null, null, null, null, false, null, false, 0, 0, null, 1023, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getDivisionId() {
        return this.divisionId;
    }

    /* renamed from: component10  reason: from getter */
    public final String getDueType() {
        return this.dueType;
    }

    /* renamed from: component2  reason: from getter */
    public final String getGoodsType() {
        return this.goodsType;
    }

    /* renamed from: component3  reason: from getter */
    public final String getIpRoleId() {
        return this.ipRoleId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component5  reason: from getter */
    public final boolean getNeedScheduleInfo() {
        return this.needScheduleInfo;
    }

    /* renamed from: component6  reason: from getter */
    public final String getRecurringType() {
        return this.recurringType;
    }

    /* renamed from: component7  reason: from getter */
    public final boolean getCountOnlv() {
        return this.countOnlv;
    }

    /* renamed from: component8  reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    /* renamed from: component9  reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    public final HighlightSubscriptionRequest copy(String divisionId, String goodsType, String ipRoleId, String merchantId, boolean needScheduleInfo, String recurringType, boolean countOnlv, int pageNum, int pageSize, String dueType) {
        Intrinsics.checkNotNullParameter(divisionId, "");
        Intrinsics.checkNotNullParameter(goodsType, "");
        Intrinsics.checkNotNullParameter(ipRoleId, "");
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(recurringType, "");
        Intrinsics.checkNotNullParameter(dueType, "");
        return new HighlightSubscriptionRequest(divisionId, goodsType, ipRoleId, merchantId, needScheduleInfo, recurringType, countOnlv, pageNum, pageSize, dueType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof HighlightSubscriptionRequest) {
            HighlightSubscriptionRequest highlightSubscriptionRequest = (HighlightSubscriptionRequest) other;
            return Intrinsics.areEqual(this.divisionId, highlightSubscriptionRequest.divisionId) && Intrinsics.areEqual(this.goodsType, highlightSubscriptionRequest.goodsType) && Intrinsics.areEqual(this.ipRoleId, highlightSubscriptionRequest.ipRoleId) && Intrinsics.areEqual(this.merchantId, highlightSubscriptionRequest.merchantId) && this.needScheduleInfo == highlightSubscriptionRequest.needScheduleInfo && Intrinsics.areEqual(this.recurringType, highlightSubscriptionRequest.recurringType) && this.countOnlv == highlightSubscriptionRequest.countOnlv && this.pageNum == highlightSubscriptionRequest.pageNum && this.pageSize == highlightSubscriptionRequest.pageSize && Intrinsics.areEqual(this.dueType, highlightSubscriptionRequest.dueType);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.divisionId.hashCode();
        int hashCode2 = this.goodsType.hashCode();
        int hashCode3 = this.ipRoleId.hashCode();
        int hashCode4 = this.merchantId.hashCode();
        boolean z = this.needScheduleInfo;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode5 = this.recurringType.hashCode();
        boolean z2 = this.countOnlv;
        return (((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i) * 31) + hashCode5) * 31) + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.pageNum) * 31) + this.pageSize) * 31) + this.dueType.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HighlightSubscriptionRequest(divisionId=");
        sb.append(this.divisionId);
        sb.append(", goodsType=");
        sb.append(this.goodsType);
        sb.append(", ipRoleId=");
        sb.append(this.ipRoleId);
        sb.append(", merchantId=");
        sb.append(this.merchantId);
        sb.append(", needScheduleInfo=");
        sb.append(this.needScheduleInfo);
        sb.append(", recurringType=");
        sb.append(this.recurringType);
        sb.append(", countOnlv=");
        sb.append(this.countOnlv);
        sb.append(", pageNum=");
        sb.append(this.pageNum);
        sb.append(", pageSize=");
        sb.append(this.pageSize);
        sb.append(", dueType=");
        sb.append(this.dueType);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ HighlightSubscriptionRequest(String str, String str2, String str3, String str4, boolean z, String str5, boolean z2, int i, int i2, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? false : z, (i3 & 32) != 0 ? "" : str5, (i3 & 64) == 0 ? z2 : false, (i3 & 128) != 0 ? 1 : i, (i3 & 256) == 0 ? i2 : 1, (i3 & 512) == 0 ? str6 : "");
    }

    @JvmName(name = "getDivisionId")
    public final String getDivisionId() {
        return this.divisionId;
    }

    @JvmName(name = "getGoodsType")
    public final String getGoodsType() {
        return this.goodsType;
    }

    @JvmName(name = "getIpRoleId")
    public final String getIpRoleId() {
        return this.ipRoleId;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "getNeedScheduleInfo")
    public final boolean getNeedScheduleInfo() {
        return this.needScheduleInfo;
    }

    @JvmName(name = "getRecurringType")
    public final String getRecurringType() {
        return this.recurringType;
    }

    @JvmName(name = "getCountOnlv")
    public final boolean getCountOnlv() {
        return this.countOnlv;
    }

    @JvmName(name = "getPageNum")
    public final int getPageNum() {
        return this.pageNum;
    }

    @JvmName(name = "getPageSize")
    public final int getPageSize() {
        return this.pageSize;
    }

    @JvmName(name = "getDueType")
    public final String getDueType() {
        return this.dueType;
    }

    public HighlightSubscriptionRequest(String str, String str2, String str3, String str4, boolean z, String str5, boolean z2, int i, int i2, String str6) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.divisionId = str;
        this.goodsType = str2;
        this.ipRoleId = str3;
        this.merchantId = str4;
        this.needScheduleInfo = z;
        this.recurringType = str5;
        this.countOnlv = z2;
        this.pageNum = i;
        this.pageSize = i2;
        this.dueType = str6;
    }
}
