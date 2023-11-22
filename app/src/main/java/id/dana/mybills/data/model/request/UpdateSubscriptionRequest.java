package id.dana.mybills.data.model.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u0000 42\u00020\u0001:\u00014Be\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0080\u0001\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÖ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b#\u0010\u000eJ\u0010\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010\u0004R\u0017\u0010\u0013\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010\u0004R&\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010'\u001a\u0004\b(\u0010\bR\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b)\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b*\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b+\u0010\u0004R\u001a\u0010\u0017\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b-\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b.\u0010\u000eR\u001a\u0010\u001a\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010%\u001a\u0004\b/\u0010\u0004R\u001a\u0010\u0019\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\b0\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010%\u001a\u0004\b1\u0010\u0004"}, d2 = {"Lid/dana/mybills/data/model/request/UpdateSubscriptionRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "", "", "component10", "()Ljava/util/Map;", "component2", "component3", "component4", "", "component5", "()I", "component6", "component7", "component8", "component9", "billerId", "goodsId", "message", "recurringType", "subscriptionDayOfMonth", "subscriptionHourOfDay", "subscriptionMonthOfYear", "subscriptionId", "title", "extendInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lid/dana/mybills/data/model/request/UpdateSubscriptionRequest;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getBillerId", "Ljava/util/Map;", "getExtendInfo", "getGoodsId", "getMessage", "getRecurringType", "I", "getSubscriptionDayOfMonth", "getSubscriptionHourOfDay", "getSubscriptionId", "getSubscriptionMonthOfYear", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class UpdateSubscriptionRequest extends BaseRpcRequest {
    public static final String KEY_EXTEND_INFO_DENOM = "denom";
    public static final String KEY_EXTEND_INFO_TIMEZONE = "TIMEZONE";
    public static final String KEY_EXTEND_INFO_TOTAL_AMOUNT = "TOTAL_AMOUNT";
    private final String billerId;
    private final Map<String, Object> extendInfo;
    private final String goodsId;
    private final String message;
    private final String recurringType;
    private final int subscriptionDayOfMonth;
    private final int subscriptionHourOfDay;
    private final String subscriptionId;
    private final int subscriptionMonthOfYear;
    private final String title;

    /* renamed from: component1  reason: from getter */
    public final String getBillerId() {
        return this.billerId;
    }

    public final Map<String, Object> component10() {
        return this.extendInfo;
    }

    /* renamed from: component2  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component4  reason: from getter */
    public final String getRecurringType() {
        return this.recurringType;
    }

    /* renamed from: component5  reason: from getter */
    public final int getSubscriptionDayOfMonth() {
        return this.subscriptionDayOfMonth;
    }

    /* renamed from: component6  reason: from getter */
    public final int getSubscriptionHourOfDay() {
        return this.subscriptionHourOfDay;
    }

    /* renamed from: component7  reason: from getter */
    public final int getSubscriptionMonthOfYear() {
        return this.subscriptionMonthOfYear;
    }

    /* renamed from: component8  reason: from getter */
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    /* renamed from: component9  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final UpdateSubscriptionRequest copy(String billerId, String goodsId, String message, String recurringType, int subscriptionDayOfMonth, int subscriptionHourOfDay, int subscriptionMonthOfYear, String subscriptionId, String title, Map<String, ? extends Object> extendInfo) {
        Intrinsics.checkNotNullParameter(billerId, "");
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(message, "");
        Intrinsics.checkNotNullParameter(recurringType, "");
        Intrinsics.checkNotNullParameter(subscriptionId, "");
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(extendInfo, "");
        return new UpdateSubscriptionRequest(billerId, goodsId, message, recurringType, subscriptionDayOfMonth, subscriptionHourOfDay, subscriptionMonthOfYear, subscriptionId, title, extendInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UpdateSubscriptionRequest) {
            UpdateSubscriptionRequest updateSubscriptionRequest = (UpdateSubscriptionRequest) other;
            return Intrinsics.areEqual(this.billerId, updateSubscriptionRequest.billerId) && Intrinsics.areEqual(this.goodsId, updateSubscriptionRequest.goodsId) && Intrinsics.areEqual(this.message, updateSubscriptionRequest.message) && Intrinsics.areEqual(this.recurringType, updateSubscriptionRequest.recurringType) && this.subscriptionDayOfMonth == updateSubscriptionRequest.subscriptionDayOfMonth && this.subscriptionHourOfDay == updateSubscriptionRequest.subscriptionHourOfDay && this.subscriptionMonthOfYear == updateSubscriptionRequest.subscriptionMonthOfYear && Intrinsics.areEqual(this.subscriptionId, updateSubscriptionRequest.subscriptionId) && Intrinsics.areEqual(this.title, updateSubscriptionRequest.title) && Intrinsics.areEqual(this.extendInfo, updateSubscriptionRequest.extendInfo);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((((this.billerId.hashCode() * 31) + this.goodsId.hashCode()) * 31) + this.message.hashCode()) * 31) + this.recurringType.hashCode()) * 31) + this.subscriptionDayOfMonth) * 31) + this.subscriptionHourOfDay) * 31) + this.subscriptionMonthOfYear) * 31) + this.subscriptionId.hashCode()) * 31) + this.title.hashCode()) * 31) + this.extendInfo.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UpdateSubscriptionRequest(billerId=");
        sb.append(this.billerId);
        sb.append(", goodsId=");
        sb.append(this.goodsId);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", recurringType=");
        sb.append(this.recurringType);
        sb.append(", subscriptionDayOfMonth=");
        sb.append(this.subscriptionDayOfMonth);
        sb.append(", subscriptionHourOfDay=");
        sb.append(this.subscriptionHourOfDay);
        sb.append(", subscriptionMonthOfYear=");
        sb.append(this.subscriptionMonthOfYear);
        sb.append(", subscriptionId=");
        sb.append(this.subscriptionId);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getBillerId")
    public final String getBillerId() {
        return this.billerId;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getMessage")
    public final String getMessage() {
        return this.message;
    }

    @JvmName(name = "getRecurringType")
    public final String getRecurringType() {
        return this.recurringType;
    }

    @JvmName(name = "getSubscriptionDayOfMonth")
    public final int getSubscriptionDayOfMonth() {
        return this.subscriptionDayOfMonth;
    }

    @JvmName(name = "getSubscriptionHourOfDay")
    public final int getSubscriptionHourOfDay() {
        return this.subscriptionHourOfDay;
    }

    @JvmName(name = "getSubscriptionMonthOfYear")
    public final int getSubscriptionMonthOfYear() {
        return this.subscriptionMonthOfYear;
    }

    @JvmName(name = "getSubscriptionId")
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    public /* synthetic */ UpdateSubscriptionRequest(String str, String str2, String str3, String str4, int i, int i2, int i3, String str5, String str6, Map map, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, i, i2, i3, str5, str6, (i4 & 512) != 0 ? MapsKt.mapOf(TuplesKt.to(KEY_EXTEND_INFO_TIMEZONE, "GMT+7")) : map);
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, Object> getExtendInfo() {
        return this.extendInfo;
    }

    public UpdateSubscriptionRequest(String str, String str2, String str3, String str4, int i, int i2, int i3, String str5, String str6, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.billerId = str;
        this.goodsId = str2;
        this.message = str3;
        this.recurringType = str4;
        this.subscriptionDayOfMonth = i;
        this.subscriptionHourOfDay = i2;
        this.subscriptionMonthOfYear = i3;
        this.subscriptionId = str5;
        this.title = str6;
        this.extendInfo = map;
    }
}
