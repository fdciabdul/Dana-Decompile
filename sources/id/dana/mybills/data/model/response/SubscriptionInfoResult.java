package id.dana.mybills.data.model.response;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b3\u00104J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J~\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b%\u0010\u0004R\u0017\u0010\u0013\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b(\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010)\u001a\u0004\b*\u0010\u0007R\u001a\u0010\u0017\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b+\u0010\u0004R\u001a\u0010\u0018\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\b,\u0010\u0007R\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b-\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b.\u0010\u0004R\u001a\u0010\u0019\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010)\u001a\u0004\b/\u0010\u0007R\u001a\u0010\u001a\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010)\u001a\u0004\b0\u0010\u0007R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b1\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b2\u0010\u0004"}, d2 = {"Lid/dana/mybills/data/model/response/SubscriptionInfoResult;", "", "", "component1", "()Ljava/lang/String;", "", "component10", "()J", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "subscriptionId", "bizType", "billerId", "goodsId", "title", "recurringType", "extendInfo", "gmtDueDate", "scheduleTime", "startPeriod", "endPeriod", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJ)Lid/dana/mybills/data/model/response/SubscriptionInfoResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBillerId", "getBizType", "J", "getEndPeriod", "getExtendInfo", "getGmtDueDate", "getGoodsId", "getRecurringType", "getScheduleTime", "getStartPeriod", "getSubscriptionId", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SubscriptionInfoResult {
    private final String billerId;
    private final String bizType;
    private final long endPeriod;
    private final String extendInfo;
    private final long gmtDueDate;
    private final String goodsId;
    private final String recurringType;
    private final long scheduleTime;
    private final long startPeriod;
    private final String subscriptionId;
    private final String title;

    public SubscriptionInfoResult() {
        this(null, null, null, null, null, null, null, 0L, 0L, 0L, 0L, 2047, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    /* renamed from: component10  reason: from getter */
    public final long getStartPeriod() {
        return this.startPeriod;
    }

    /* renamed from: component11  reason: from getter */
    public final long getEndPeriod() {
        return this.endPeriod;
    }

    /* renamed from: component2  reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    /* renamed from: component3  reason: from getter */
    public final String getBillerId() {
        return this.billerId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component6  reason: from getter */
    public final String getRecurringType() {
        return this.recurringType;
    }

    /* renamed from: component7  reason: from getter */
    public final String getExtendInfo() {
        return this.extendInfo;
    }

    /* renamed from: component8  reason: from getter */
    public final long getGmtDueDate() {
        return this.gmtDueDate;
    }

    /* renamed from: component9  reason: from getter */
    public final long getScheduleTime() {
        return this.scheduleTime;
    }

    public final SubscriptionInfoResult copy(String subscriptionId, String bizType, String billerId, String goodsId, String title, String recurringType, String extendInfo, long gmtDueDate, long scheduleTime, long startPeriod, long endPeriod) {
        Intrinsics.checkNotNullParameter(subscriptionId, "");
        Intrinsics.checkNotNullParameter(bizType, "");
        Intrinsics.checkNotNullParameter(billerId, "");
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(recurringType, "");
        Intrinsics.checkNotNullParameter(extendInfo, "");
        return new SubscriptionInfoResult(subscriptionId, bizType, billerId, goodsId, title, recurringType, extendInfo, gmtDueDate, scheduleTime, startPeriod, endPeriod);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SubscriptionInfoResult) {
            SubscriptionInfoResult subscriptionInfoResult = (SubscriptionInfoResult) other;
            return Intrinsics.areEqual(this.subscriptionId, subscriptionInfoResult.subscriptionId) && Intrinsics.areEqual(this.bizType, subscriptionInfoResult.bizType) && Intrinsics.areEqual(this.billerId, subscriptionInfoResult.billerId) && Intrinsics.areEqual(this.goodsId, subscriptionInfoResult.goodsId) && Intrinsics.areEqual(this.title, subscriptionInfoResult.title) && Intrinsics.areEqual(this.recurringType, subscriptionInfoResult.recurringType) && Intrinsics.areEqual(this.extendInfo, subscriptionInfoResult.extendInfo) && this.gmtDueDate == subscriptionInfoResult.gmtDueDate && this.scheduleTime == subscriptionInfoResult.scheduleTime && this.startPeriod == subscriptionInfoResult.startPeriod && this.endPeriod == subscriptionInfoResult.endPeriod;
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((((((this.subscriptionId.hashCode() * 31) + this.bizType.hashCode()) * 31) + this.billerId.hashCode()) * 31) + this.goodsId.hashCode()) * 31) + this.title.hashCode()) * 31) + this.recurringType.hashCode()) * 31) + this.extendInfo.hashCode()) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.gmtDueDate)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.scheduleTime)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.startPeriod)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.endPeriod);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SubscriptionInfoResult(subscriptionId=");
        sb.append(this.subscriptionId);
        sb.append(", bizType=");
        sb.append(this.bizType);
        sb.append(", billerId=");
        sb.append(this.billerId);
        sb.append(", goodsId=");
        sb.append(this.goodsId);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", recurringType=");
        sb.append(this.recurringType);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", gmtDueDate=");
        sb.append(this.gmtDueDate);
        sb.append(", scheduleTime=");
        sb.append(this.scheduleTime);
        sb.append(", startPeriod=");
        sb.append(this.startPeriod);
        sb.append(", endPeriod=");
        sb.append(this.endPeriod);
        sb.append(')');
        return sb.toString();
    }

    public SubscriptionInfoResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j, long j2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        this.subscriptionId = str;
        this.bizType = str2;
        this.billerId = str3;
        this.goodsId = str4;
        this.title = str5;
        this.recurringType = str6;
        this.extendInfo = str7;
        this.gmtDueDate = j;
        this.scheduleTime = j2;
        this.startPeriod = j3;
        this.endPeriod = j4;
    }

    public /* synthetic */ SubscriptionInfoResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j, long j2, long j3, long j4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) == 0 ? str7 : "", (i & 128) != 0 ? 0L : j, (i & 256) != 0 ? 0L : j2, (i & 512) != 0 ? 0L : j3, (i & 1024) == 0 ? j4 : 0L);
    }

    @JvmName(name = "getSubscriptionId")
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "getBillerId")
    public final String getBillerId() {
        return this.billerId;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getRecurringType")
    public final String getRecurringType() {
        return this.recurringType;
    }

    @JvmName(name = "getExtendInfo")
    public final String getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getGmtDueDate")
    public final long getGmtDueDate() {
        return this.gmtDueDate;
    }

    @JvmName(name = "getScheduleTime")
    public final long getScheduleTime() {
        return this.scheduleTime;
    }

    @JvmName(name = "getStartPeriod")
    public final long getStartPeriod() {
        return this.startPeriod;
    }

    @JvmName(name = "getEndPeriod")
    public final long getEndPeriod() {
        return this.endPeriod;
    }
}
