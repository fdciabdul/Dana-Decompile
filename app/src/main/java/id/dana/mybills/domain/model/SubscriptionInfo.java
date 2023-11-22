package id.dana.mybills.domain.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0007J~\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b'\u0010\u0004R\u0017\u0010\u0015\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b*\u0010\u0004R\u001a\u0010\u001d\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b,\u0010\u0007R\u001a\u0010\u0018\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010-\u001a\u0004\b.\u0010\u000fR\u001a\u0010\u001a\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b/\u0010\u0007R\u001a\u0010\u0016\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b0\u0010\u0004R\u001a\u0010\u0019\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b1\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b2\u0010\u0007R\u001a\u0010\u001c\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b3\u0010\u0007R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b4\u0010\u0004R\u001a\u0010\u0017\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b5\u0010\u0004"}, d2 = {"Lid/dana/mybills/domain/model/SubscriptionInfo;", "", "", "component1", "()Ljava/lang/String;", "", "component10", "()J", "component11", "component2", "component3", "component4", "component5", "Lid/dana/mybills/domain/model/ExtendInfoQuerySubscription;", "component6", "()Lid/dana/mybills/domain/model/ExtendInfoQuerySubscription;", "component7", "component8", "component9", "subscriptionId", "bizType", "billerId", "goodsId", "title", "extendInfo", "recurringType", "gmtDueDate", "scheduleTime", "startPeriod", "endPeriod", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/mybills/domain/model/ExtendInfoQuerySubscription;Ljava/lang/String;JJJJ)Lid/dana/mybills/domain/model/SubscriptionInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBillerId", "getBizType", "J", "getEndPeriod", "Lid/dana/mybills/domain/model/ExtendInfoQuerySubscription;", "getExtendInfo", "getGmtDueDate", "getGoodsId", "getRecurringType", "getScheduleTime", "getStartPeriod", "getSubscriptionId", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/mybills/domain/model/ExtendInfoQuerySubscription;Ljava/lang/String;JJJJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SubscriptionInfo {
    private final String billerId;
    private final String bizType;
    private final long endPeriod;
    private final ExtendInfoQuerySubscription extendInfo;
    private final long gmtDueDate;
    private final String goodsId;
    private final String recurringType;
    private final long scheduleTime;
    private final long startPeriod;
    private final String subscriptionId;
    private final String title;

    public SubscriptionInfo() {
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
    public final ExtendInfoQuerySubscription getExtendInfo() {
        return this.extendInfo;
    }

    /* renamed from: component7  reason: from getter */
    public final String getRecurringType() {
        return this.recurringType;
    }

    /* renamed from: component8  reason: from getter */
    public final long getGmtDueDate() {
        return this.gmtDueDate;
    }

    /* renamed from: component9  reason: from getter */
    public final long getScheduleTime() {
        return this.scheduleTime;
    }

    public final SubscriptionInfo copy(String subscriptionId, String bizType, String billerId, String goodsId, String title, ExtendInfoQuerySubscription extendInfo, String recurringType, long gmtDueDate, long scheduleTime, long startPeriod, long endPeriod) {
        Intrinsics.checkNotNullParameter(subscriptionId, "");
        Intrinsics.checkNotNullParameter(bizType, "");
        Intrinsics.checkNotNullParameter(billerId, "");
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(extendInfo, "");
        Intrinsics.checkNotNullParameter(recurringType, "");
        return new SubscriptionInfo(subscriptionId, bizType, billerId, goodsId, title, extendInfo, recurringType, gmtDueDate, scheduleTime, startPeriod, endPeriod);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SubscriptionInfo) {
            SubscriptionInfo subscriptionInfo = (SubscriptionInfo) other;
            return Intrinsics.areEqual(this.subscriptionId, subscriptionInfo.subscriptionId) && Intrinsics.areEqual(this.bizType, subscriptionInfo.bizType) && Intrinsics.areEqual(this.billerId, subscriptionInfo.billerId) && Intrinsics.areEqual(this.goodsId, subscriptionInfo.goodsId) && Intrinsics.areEqual(this.title, subscriptionInfo.title) && Intrinsics.areEqual(this.extendInfo, subscriptionInfo.extendInfo) && Intrinsics.areEqual(this.recurringType, subscriptionInfo.recurringType) && this.gmtDueDate == subscriptionInfo.gmtDueDate && this.scheduleTime == subscriptionInfo.scheduleTime && this.startPeriod == subscriptionInfo.startPeriod && this.endPeriod == subscriptionInfo.endPeriod;
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((((((this.subscriptionId.hashCode() * 31) + this.bizType.hashCode()) * 31) + this.billerId.hashCode()) * 31) + this.goodsId.hashCode()) * 31) + this.title.hashCode()) * 31) + this.extendInfo.hashCode()) * 31) + this.recurringType.hashCode()) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.gmtDueDate)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.scheduleTime)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.startPeriod)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.endPeriod);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SubscriptionInfo(subscriptionId=");
        sb.append(this.subscriptionId);
        sb.append(", bizType=");
        sb.append(this.bizType);
        sb.append(", billerId=");
        sb.append(this.billerId);
        sb.append(", goodsId=");
        sb.append(this.goodsId);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", recurringType=");
        sb.append(this.recurringType);
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

    public SubscriptionInfo(String str, String str2, String str3, String str4, String str5, ExtendInfoQuerySubscription extendInfoQuerySubscription, String str6, long j, long j2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(extendInfoQuerySubscription, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.subscriptionId = str;
        this.bizType = str2;
        this.billerId = str3;
        this.goodsId = str4;
        this.title = str5;
        this.extendInfo = extendInfoQuerySubscription;
        this.recurringType = str6;
        this.gmtDueDate = j;
        this.scheduleTime = j2;
        this.startPeriod = j3;
        this.endPeriod = j4;
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

    public /* synthetic */ SubscriptionInfo(String str, String str2, String str3, String str4, String str5, ExtendInfoQuerySubscription extendInfoQuerySubscription, String str6, long j, long j2, long j3, long j4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? new ExtendInfoQuerySubscription(null, null, null, 7, null) : extendInfoQuerySubscription, (i & 64) == 0 ? str6 : "", (i & 128) != 0 ? 0L : j, (i & 256) != 0 ? 0L : j2, (i & 512) != 0 ? 0L : j3, (i & 1024) == 0 ? j4 : 0L);
    }

    @JvmName(name = "getExtendInfo")
    public final ExtendInfoQuerySubscription getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getRecurringType")
    public final String getRecurringType() {
        return this.recurringType;
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
