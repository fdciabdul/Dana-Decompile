package id.dana.mybills.data.model.response;

import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\"\u001a\u00020\u000f\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010'\u001a\u00020\u0018\u0012\u0006\u0010(\u001a\u00020\u001b\u0012\u0006\u0010)\u001a\u00020\u001e\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010+\u001a\u00020\u0006\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010-\u001a\u00020\n\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bQ\u0010RJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0014J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J¸\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\"\u001a\u00020\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010'\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020\u001b2\b\b\u0002\u0010)\u001a\u00020\u001e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010+\u001a\u00020\u00062\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010-\u001a\u00020\n2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b0\u00101J\u001a\u00104\u001a\u0002032\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b4\u00105J\u0010\u00107\u001a\u000206HÖ\u0001¢\u0006\u0004\b7\u00108J\u0010\u00109\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b9\u0010\u0004R\u0019\u0010!\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b!\u0010:\u001a\u0004\b;\u0010\u0004R\u001a\u0010\"\u001a\u00020\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010<\u001a\u0004\b=\u0010\u0011R\u001c\u0010#\u001a\u0004\u0018\u00010\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010>\u001a\u0004\b?\u0010\u0014R\u001c\u0010$\u001a\u0004\u0018\u00010\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010>\u001a\u0004\b@\u0010\u0014R\u001c\u0010%\u001a\u0004\u0018\u00010\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010>\u001a\u0004\bA\u0010\u0014R\u001c\u0010&\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010:\u001a\u0004\bB\u0010\u0004R\u001a\u0010'\u001a\u00020\u00188\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010C\u001a\u0004\bD\u0010\u001aR\u001a\u0010(\u001a\u00020\u001b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010E\u001a\u0004\bF\u0010\u001dR\u001a\u0010)\u001a\u00020\u001e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010G\u001a\u0004\bH\u0010 R\u001c\u0010*\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010:\u001a\u0004\bI\u0010\u0004R\u001a\u0010+\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010J\u001a\u0004\bK\u0010\bR\u001c\u0010,\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010:\u001a\u0004\bL\u0010\u0004R\u001a\u0010-\u001a\u00020\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010M\u001a\u0004\bN\u0010\fR\u001c\u0010.\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010:\u001a\u0004\bO\u0010\u0004R\u001c\u0010/\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010:\u001a\u0004\bP\u0010\u0004"}, d2 = {"Lid/dana/mybills/data/model/response/SubscriptionHighlightViewResult;", "", "", "component1", "()Ljava/lang/String;", "component10", "Lid/dana/mybills/data/model/response/PeriodInfo;", "component11", "()Lid/dana/mybills/data/model/response/PeriodInfo;", "component12", "Lid/dana/mybills/data/model/response/ScheduleView;", "component13", "()Lid/dana/mybills/data/model/response/ScheduleView;", "component14", "component15", "Lid/dana/mybills/data/model/response/BillViewResult;", "component2", "()Lid/dana/mybills/data/model/response/BillViewResult;", "", "component3", "()Ljava/lang/Long;", "component4", "component5", "component6", "Lid/dana/mybills/data/model/response/IntervalInfo;", "component7", "()Lid/dana/mybills/data/model/response/IntervalInfo;", "Lid/dana/mybills/data/model/response/MerchantInfo;", "component8", "()Lid/dana/mybills/data/model/response/MerchantInfo;", "Lid/dana/mybills/data/model/response/PaymentCycleInfoViewsResult;", "component9", "()Lid/dana/mybills/data/model/response/PaymentCycleInfoViewsResult;", "actionRedirectUrl", "billView", "gmtCreate", "gmtDueDate", "gmtModified", "goodsType", "intervalInfo", "merchantInfo", "paymentCycleInfoViews", InvoiceConstant.PAYMENT_METHOD, "periodInfo", "recurringType", "scheduleView", "status", "subscriptionId", "copy", "(Ljava/lang/String;Lid/dana/mybills/data/model/response/BillViewResult;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lid/dana/mybills/data/model/response/IntervalInfo;Lid/dana/mybills/data/model/response/MerchantInfo;Lid/dana/mybills/data/model/response/PaymentCycleInfoViewsResult;Ljava/lang/String;Lid/dana/mybills/data/model/response/PeriodInfo;Ljava/lang/String;Lid/dana/mybills/data/model/response/ScheduleView;Ljava/lang/String;Ljava/lang/String;)Lid/dana/mybills/data/model/response/SubscriptionHighlightViewResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getActionRedirectUrl", "Lid/dana/mybills/data/model/response/BillViewResult;", "getBillView", "Ljava/lang/Long;", "getGmtCreate", "getGmtDueDate", "getGmtModified", "getGoodsType", "Lid/dana/mybills/data/model/response/IntervalInfo;", "getIntervalInfo", "Lid/dana/mybills/data/model/response/MerchantInfo;", "getMerchantInfo", "Lid/dana/mybills/data/model/response/PaymentCycleInfoViewsResult;", "getPaymentCycleInfoViews", "getPaymentMethod", "Lid/dana/mybills/data/model/response/PeriodInfo;", "getPeriodInfo", "getRecurringType", "Lid/dana/mybills/data/model/response/ScheduleView;", "getScheduleView", "getStatus", "getSubscriptionId", "<init>", "(Ljava/lang/String;Lid/dana/mybills/data/model/response/BillViewResult;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lid/dana/mybills/data/model/response/IntervalInfo;Lid/dana/mybills/data/model/response/MerchantInfo;Lid/dana/mybills/data/model/response/PaymentCycleInfoViewsResult;Ljava/lang/String;Lid/dana/mybills/data/model/response/PeriodInfo;Ljava/lang/String;Lid/dana/mybills/data/model/response/ScheduleView;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SubscriptionHighlightViewResult {
    private final String actionRedirectUrl;
    private final BillViewResult billView;
    private final Long gmtCreate;
    private final Long gmtDueDate;
    private final Long gmtModified;
    private final String goodsType;
    private final IntervalInfo intervalInfo;
    private final MerchantInfo merchantInfo;
    private final PaymentCycleInfoViewsResult paymentCycleInfoViews;
    private final String paymentMethod;
    private final PeriodInfo periodInfo;
    private final String recurringType;
    private final ScheduleView scheduleView;
    private final String status;
    private final String subscriptionId;

    /* renamed from: component1  reason: from getter */
    public final String getActionRedirectUrl() {
        return this.actionRedirectUrl;
    }

    /* renamed from: component10  reason: from getter */
    public final String getPaymentMethod() {
        return this.paymentMethod;
    }

    /* renamed from: component11  reason: from getter */
    public final PeriodInfo getPeriodInfo() {
        return this.periodInfo;
    }

    /* renamed from: component12  reason: from getter */
    public final String getRecurringType() {
        return this.recurringType;
    }

    /* renamed from: component13  reason: from getter */
    public final ScheduleView getScheduleView() {
        return this.scheduleView;
    }

    /* renamed from: component14  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component15  reason: from getter */
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    /* renamed from: component2  reason: from getter */
    public final BillViewResult getBillView() {
        return this.billView;
    }

    /* renamed from: component3  reason: from getter */
    public final Long getGmtCreate() {
        return this.gmtCreate;
    }

    /* renamed from: component4  reason: from getter */
    public final Long getGmtDueDate() {
        return this.gmtDueDate;
    }

    /* renamed from: component5  reason: from getter */
    public final Long getGmtModified() {
        return this.gmtModified;
    }

    /* renamed from: component6  reason: from getter */
    public final String getGoodsType() {
        return this.goodsType;
    }

    /* renamed from: component7  reason: from getter */
    public final IntervalInfo getIntervalInfo() {
        return this.intervalInfo;
    }

    /* renamed from: component8  reason: from getter */
    public final MerchantInfo getMerchantInfo() {
        return this.merchantInfo;
    }

    /* renamed from: component9  reason: from getter */
    public final PaymentCycleInfoViewsResult getPaymentCycleInfoViews() {
        return this.paymentCycleInfoViews;
    }

    public final SubscriptionHighlightViewResult copy(String actionRedirectUrl, BillViewResult billView, Long gmtCreate, Long gmtDueDate, Long gmtModified, String goodsType, IntervalInfo intervalInfo, MerchantInfo merchantInfo, PaymentCycleInfoViewsResult paymentCycleInfoViews, String paymentMethod, PeriodInfo periodInfo, String recurringType, ScheduleView scheduleView, String status, String subscriptionId) {
        Intrinsics.checkNotNullParameter(billView, "");
        Intrinsics.checkNotNullParameter(intervalInfo, "");
        Intrinsics.checkNotNullParameter(merchantInfo, "");
        Intrinsics.checkNotNullParameter(paymentCycleInfoViews, "");
        Intrinsics.checkNotNullParameter(periodInfo, "");
        Intrinsics.checkNotNullParameter(scheduleView, "");
        return new SubscriptionHighlightViewResult(actionRedirectUrl, billView, gmtCreate, gmtDueDate, gmtModified, goodsType, intervalInfo, merchantInfo, paymentCycleInfoViews, paymentMethod, periodInfo, recurringType, scheduleView, status, subscriptionId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SubscriptionHighlightViewResult) {
            SubscriptionHighlightViewResult subscriptionHighlightViewResult = (SubscriptionHighlightViewResult) other;
            return Intrinsics.areEqual(this.actionRedirectUrl, subscriptionHighlightViewResult.actionRedirectUrl) && Intrinsics.areEqual(this.billView, subscriptionHighlightViewResult.billView) && Intrinsics.areEqual(this.gmtCreate, subscriptionHighlightViewResult.gmtCreate) && Intrinsics.areEqual(this.gmtDueDate, subscriptionHighlightViewResult.gmtDueDate) && Intrinsics.areEqual(this.gmtModified, subscriptionHighlightViewResult.gmtModified) && Intrinsics.areEqual(this.goodsType, subscriptionHighlightViewResult.goodsType) && Intrinsics.areEqual(this.intervalInfo, subscriptionHighlightViewResult.intervalInfo) && Intrinsics.areEqual(this.merchantInfo, subscriptionHighlightViewResult.merchantInfo) && Intrinsics.areEqual(this.paymentCycleInfoViews, subscriptionHighlightViewResult.paymentCycleInfoViews) && Intrinsics.areEqual(this.paymentMethod, subscriptionHighlightViewResult.paymentMethod) && Intrinsics.areEqual(this.periodInfo, subscriptionHighlightViewResult.periodInfo) && Intrinsics.areEqual(this.recurringType, subscriptionHighlightViewResult.recurringType) && Intrinsics.areEqual(this.scheduleView, subscriptionHighlightViewResult.scheduleView) && Intrinsics.areEqual(this.status, subscriptionHighlightViewResult.status) && Intrinsics.areEqual(this.subscriptionId, subscriptionHighlightViewResult.subscriptionId);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.actionRedirectUrl;
        int hashCode = str == null ? 0 : str.hashCode();
        int hashCode2 = this.billView.hashCode();
        Long l = this.gmtCreate;
        int hashCode3 = l == null ? 0 : l.hashCode();
        Long l2 = this.gmtDueDate;
        int hashCode4 = l2 == null ? 0 : l2.hashCode();
        Long l3 = this.gmtModified;
        int hashCode5 = l3 == null ? 0 : l3.hashCode();
        String str2 = this.goodsType;
        int hashCode6 = str2 == null ? 0 : str2.hashCode();
        int hashCode7 = this.intervalInfo.hashCode();
        int hashCode8 = this.merchantInfo.hashCode();
        int hashCode9 = this.paymentCycleInfoViews.hashCode();
        String str3 = this.paymentMethod;
        int hashCode10 = str3 == null ? 0 : str3.hashCode();
        int hashCode11 = this.periodInfo.hashCode();
        String str4 = this.recurringType;
        int hashCode12 = str4 == null ? 0 : str4.hashCode();
        int hashCode13 = this.scheduleView.hashCode();
        String str5 = this.status;
        int hashCode14 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.subscriptionId;
        return (((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + (str6 != null ? str6.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SubscriptionHighlightViewResult(actionRedirectUrl=");
        sb.append(this.actionRedirectUrl);
        sb.append(", billView=");
        sb.append(this.billView);
        sb.append(", gmtCreate=");
        sb.append(this.gmtCreate);
        sb.append(", gmtDueDate=");
        sb.append(this.gmtDueDate);
        sb.append(", gmtModified=");
        sb.append(this.gmtModified);
        sb.append(", goodsType=");
        sb.append(this.goodsType);
        sb.append(", intervalInfo=");
        sb.append(this.intervalInfo);
        sb.append(", merchantInfo=");
        sb.append(this.merchantInfo);
        sb.append(", paymentCycleInfoViews=");
        sb.append(this.paymentCycleInfoViews);
        sb.append(", paymentMethod=");
        sb.append(this.paymentMethod);
        sb.append(", periodInfo=");
        sb.append(this.periodInfo);
        sb.append(", recurringType=");
        sb.append(this.recurringType);
        sb.append(", scheduleView=");
        sb.append(this.scheduleView);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", subscriptionId=");
        sb.append(this.subscriptionId);
        sb.append(')');
        return sb.toString();
    }

    public SubscriptionHighlightViewResult(String str, BillViewResult billViewResult, Long l, Long l2, Long l3, String str2, IntervalInfo intervalInfo, MerchantInfo merchantInfo, PaymentCycleInfoViewsResult paymentCycleInfoViewsResult, String str3, PeriodInfo periodInfo, String str4, ScheduleView scheduleView, String str5, String str6) {
        Intrinsics.checkNotNullParameter(billViewResult, "");
        Intrinsics.checkNotNullParameter(intervalInfo, "");
        Intrinsics.checkNotNullParameter(merchantInfo, "");
        Intrinsics.checkNotNullParameter(paymentCycleInfoViewsResult, "");
        Intrinsics.checkNotNullParameter(periodInfo, "");
        Intrinsics.checkNotNullParameter(scheduleView, "");
        this.actionRedirectUrl = str;
        this.billView = billViewResult;
        this.gmtCreate = l;
        this.gmtDueDate = l2;
        this.gmtModified = l3;
        this.goodsType = str2;
        this.intervalInfo = intervalInfo;
        this.merchantInfo = merchantInfo;
        this.paymentCycleInfoViews = paymentCycleInfoViewsResult;
        this.paymentMethod = str3;
        this.periodInfo = periodInfo;
        this.recurringType = str4;
        this.scheduleView = scheduleView;
        this.status = str5;
        this.subscriptionId = str6;
    }

    @JvmName(name = "getActionRedirectUrl")
    public final String getActionRedirectUrl() {
        return this.actionRedirectUrl;
    }

    @JvmName(name = "getBillView")
    public final BillViewResult getBillView() {
        return this.billView;
    }

    public /* synthetic */ SubscriptionHighlightViewResult(String str, BillViewResult billViewResult, Long l, Long l2, Long l3, String str2, IntervalInfo intervalInfo, MerchantInfo merchantInfo, PaymentCycleInfoViewsResult paymentCycleInfoViewsResult, String str3, PeriodInfo periodInfo, String str4, ScheduleView scheduleView, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, billViewResult, (i & 4) != 0 ? 0L : l, (i & 8) != 0 ? 0L : l2, (i & 16) != 0 ? 0L : l3, (i & 32) != 0 ? "" : str2, intervalInfo, merchantInfo, paymentCycleInfoViewsResult, (i & 512) != 0 ? "" : str3, periodInfo, (i & 2048) != 0 ? "" : str4, scheduleView, (i & 8192) != 0 ? "" : str5, (i & 16384) != 0 ? "" : str6);
    }

    @JvmName(name = "getGmtCreate")
    public final Long getGmtCreate() {
        return this.gmtCreate;
    }

    @JvmName(name = "getGmtDueDate")
    public final Long getGmtDueDate() {
        return this.gmtDueDate;
    }

    @JvmName(name = "getGmtModified")
    public final Long getGmtModified() {
        return this.gmtModified;
    }

    @JvmName(name = "getGoodsType")
    public final String getGoodsType() {
        return this.goodsType;
    }

    @JvmName(name = "getIntervalInfo")
    public final IntervalInfo getIntervalInfo() {
        return this.intervalInfo;
    }

    @JvmName(name = "getMerchantInfo")
    public final MerchantInfo getMerchantInfo() {
        return this.merchantInfo;
    }

    @JvmName(name = "getPaymentCycleInfoViews")
    public final PaymentCycleInfoViewsResult getPaymentCycleInfoViews() {
        return this.paymentCycleInfoViews;
    }

    @JvmName(name = "getPaymentMethod")
    public final String getPaymentMethod() {
        return this.paymentMethod;
    }

    @JvmName(name = "getPeriodInfo")
    public final PeriodInfo getPeriodInfo() {
        return this.periodInfo;
    }

    @JvmName(name = "getRecurringType")
    public final String getRecurringType() {
        return this.recurringType;
    }

    @JvmName(name = "getScheduleView")
    public final ScheduleView getScheduleView() {
        return this.scheduleView;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getSubscriptionId")
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }
}
