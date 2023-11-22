package id.dana.domain.announcement.model;

import com.alibaba.griver.api.constants.GriverEvents;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001:\u0002JKB¯\u0001\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b¢\u0006\u0004\bH\u0010IJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J¸\u0001\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b)\u0010\u0004R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010*\u001a\u0004\b+\u0010\u0004\"\u0004\b,\u0010-R0\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010.\u001a\u0004\b/\u0010\n\"\u0004\b0\u00101R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010*\u001a\u0004\b2\u0010\u0004\"\u0004\b3\u0010-R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010*\u001a\u0004\b4\u0010\u0004\"\u0004\b5\u0010-R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010*\u001a\u0004\b6\u0010\u0004\"\u0004\b7\u0010-R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010*\u001a\u0004\b8\u0010\u0004\"\u0004\b9\u0010-R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010*\u001a\u0004\b:\u0010\u0004\"\u0004\b;\u0010-R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010*\u001a\u0004\b<\u0010\u0004\"\u0004\b=\u0010-R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010*\u001a\u0004\b>\u0010\u0004\"\u0004\b?\u0010-R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010*\u001a\u0004\b@\u0010\u0004\"\u0004\bA\u0010-R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010*\u001a\u0004\bB\u0010\u0004\"\u0004\bC\u0010-R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010*\u001a\u0004\bD\u0010\u0004\"\u0004\bE\u0010-R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010*\u001a\u0004\bF\u0010\u0004\"\u0004\bG\u0010-"}, d2 = {"Lid/dana/domain/announcement/model/RecurringAnnouncement;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "", "component13", "()Ljava/util/Map;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "id", "title", "subtitle", "widgetType", "expirationDate", "gmtCreate", "subMerchantId", "goodsName", "goodsType", "subscriptionDueDate", "paymentStatus", "totalAmount", "extInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lid/dana/domain/announcement/model/RecurringAnnouncement;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getExpirationDate", "setExpirationDate", "(Ljava/lang/String;)V", "Ljava/util/Map;", "getExtInfo", "setExtInfo", "(Ljava/util/Map;)V", "getGmtCreate", "setGmtCreate", "getGoodsName", "setGoodsName", "getGoodsType", "setGoodsType", "getId", "setId", "getPaymentStatus", "setPaymentStatus", "getSubMerchantId", "setSubMerchantId", "getSubscriptionDueDate", "setSubscriptionDueDate", "getSubtitle", "setSubtitle", "getTitle", GriverEvents.EVENT_SET_TITLE, "getTotalAmount", "setTotalAmount", "getWidgetType", "setWidgetType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "PaymentStatus", "Type"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RecurringAnnouncement {
    private String expirationDate;
    private Map<String, String> extInfo;
    private String gmtCreate;
    private String goodsName;
    private String goodsType;
    private String id;
    private String paymentStatus;
    private String subMerchantId;
    private String subscriptionDueDate;
    private String subtitle;
    private String title;
    private String totalAmount;
    private String widgetType;

    public RecurringAnnouncement() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10  reason: from getter */
    public final String getSubscriptionDueDate() {
        return this.subscriptionDueDate;
    }

    /* renamed from: component11  reason: from getter */
    public final String getPaymentStatus() {
        return this.paymentStatus;
    }

    /* renamed from: component12  reason: from getter */
    public final String getTotalAmount() {
        return this.totalAmount;
    }

    public final Map<String, String> component13() {
        return this.extInfo;
    }

    /* renamed from: component2  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3  reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* renamed from: component4  reason: from getter */
    public final String getWidgetType() {
        return this.widgetType;
    }

    /* renamed from: component5  reason: from getter */
    public final String getExpirationDate() {
        return this.expirationDate;
    }

    /* renamed from: component6  reason: from getter */
    public final String getGmtCreate() {
        return this.gmtCreate;
    }

    /* renamed from: component7  reason: from getter */
    public final String getSubMerchantId() {
        return this.subMerchantId;
    }

    /* renamed from: component8  reason: from getter */
    public final String getGoodsName() {
        return this.goodsName;
    }

    /* renamed from: component9  reason: from getter */
    public final String getGoodsType() {
        return this.goodsType;
    }

    public final RecurringAnnouncement copy(String id2, String title, String subtitle, String widgetType, String expirationDate, String gmtCreate, String subMerchantId, String goodsName, String goodsType, String subscriptionDueDate, String paymentStatus, String totalAmount, Map<String, String> extInfo) {
        return new RecurringAnnouncement(id2, title, subtitle, widgetType, expirationDate, gmtCreate, subMerchantId, goodsName, goodsType, subscriptionDueDate, paymentStatus, totalAmount, extInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RecurringAnnouncement) {
            RecurringAnnouncement recurringAnnouncement = (RecurringAnnouncement) other;
            return Intrinsics.areEqual(this.id, recurringAnnouncement.id) && Intrinsics.areEqual(this.title, recurringAnnouncement.title) && Intrinsics.areEqual(this.subtitle, recurringAnnouncement.subtitle) && Intrinsics.areEqual(this.widgetType, recurringAnnouncement.widgetType) && Intrinsics.areEqual(this.expirationDate, recurringAnnouncement.expirationDate) && Intrinsics.areEqual(this.gmtCreate, recurringAnnouncement.gmtCreate) && Intrinsics.areEqual(this.subMerchantId, recurringAnnouncement.subMerchantId) && Intrinsics.areEqual(this.goodsName, recurringAnnouncement.goodsName) && Intrinsics.areEqual(this.goodsType, recurringAnnouncement.goodsType) && Intrinsics.areEqual(this.subscriptionDueDate, recurringAnnouncement.subscriptionDueDate) && Intrinsics.areEqual(this.paymentStatus, recurringAnnouncement.paymentStatus) && Intrinsics.areEqual(this.totalAmount, recurringAnnouncement.totalAmount) && Intrinsics.areEqual(this.extInfo, recurringAnnouncement.extInfo);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.id;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.title;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.subtitle;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.widgetType;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.expirationDate;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.gmtCreate;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.subMerchantId;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.goodsName;
        int hashCode8 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.goodsType;
        int hashCode9 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.subscriptionDueDate;
        int hashCode10 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.paymentStatus;
        int hashCode11 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.totalAmount;
        int hashCode12 = str12 == null ? 0 : str12.hashCode();
        Map<String, String> map = this.extInfo;
        return (((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + (map != null ? map.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RecurringAnnouncement(id=");
        sb.append(this.id);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", subtitle=");
        sb.append(this.subtitle);
        sb.append(", widgetType=");
        sb.append(this.widgetType);
        sb.append(", expirationDate=");
        sb.append(this.expirationDate);
        sb.append(", gmtCreate=");
        sb.append(this.gmtCreate);
        sb.append(", subMerchantId=");
        sb.append(this.subMerchantId);
        sb.append(", goodsName=");
        sb.append(this.goodsName);
        sb.append(", goodsType=");
        sb.append(this.goodsType);
        sb.append(", subscriptionDueDate=");
        sb.append(this.subscriptionDueDate);
        sb.append(", paymentStatus=");
        sb.append(this.paymentStatus);
        sb.append(", totalAmount=");
        sb.append(this.totalAmount);
        sb.append(", extInfo=");
        sb.append(this.extInfo);
        sb.append(')');
        return sb.toString();
    }

    public RecurringAnnouncement(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Map<String, String> map) {
        this.id = str;
        this.title = str2;
        this.subtitle = str3;
        this.widgetType = str4;
        this.expirationDate = str5;
        this.gmtCreate = str6;
        this.subMerchantId = str7;
        this.goodsName = str8;
        this.goodsType = str9;
        this.subscriptionDueDate = str10;
        this.paymentStatus = str11;
        this.totalAmount = str12;
        this.extInfo = map;
    }

    public /* synthetic */ RecurringAnnouncement(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : str12, (i & 4096) == 0 ? map : null);
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "setId")
    public final void setId(String str) {
        this.id = str;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = GriverEvents.EVENT_SET_TITLE)
    public final void setTitle(String str) {
        this.title = str;
    }

    @JvmName(name = "getSubtitle")
    public final String getSubtitle() {
        return this.subtitle;
    }

    @JvmName(name = "setSubtitle")
    public final void setSubtitle(String str) {
        this.subtitle = str;
    }

    @JvmName(name = "getWidgetType")
    public final String getWidgetType() {
        return this.widgetType;
    }

    @JvmName(name = "setWidgetType")
    public final void setWidgetType(String str) {
        this.widgetType = str;
    }

    @JvmName(name = "getExpirationDate")
    public final String getExpirationDate() {
        return this.expirationDate;
    }

    @JvmName(name = "setExpirationDate")
    public final void setExpirationDate(String str) {
        this.expirationDate = str;
    }

    @JvmName(name = "getGmtCreate")
    public final String getGmtCreate() {
        return this.gmtCreate;
    }

    @JvmName(name = "setGmtCreate")
    public final void setGmtCreate(String str) {
        this.gmtCreate = str;
    }

    @JvmName(name = "getSubMerchantId")
    public final String getSubMerchantId() {
        return this.subMerchantId;
    }

    @JvmName(name = "setSubMerchantId")
    public final void setSubMerchantId(String str) {
        this.subMerchantId = str;
    }

    @JvmName(name = "getGoodsName")
    public final String getGoodsName() {
        return this.goodsName;
    }

    @JvmName(name = "setGoodsName")
    public final void setGoodsName(String str) {
        this.goodsName = str;
    }

    @JvmName(name = "getGoodsType")
    public final String getGoodsType() {
        return this.goodsType;
    }

    @JvmName(name = "setGoodsType")
    public final void setGoodsType(String str) {
        this.goodsType = str;
    }

    @JvmName(name = "getSubscriptionDueDate")
    public final String getSubscriptionDueDate() {
        return this.subscriptionDueDate;
    }

    @JvmName(name = "setSubscriptionDueDate")
    public final void setSubscriptionDueDate(String str) {
        this.subscriptionDueDate = str;
    }

    @JvmName(name = "getPaymentStatus")
    public final String getPaymentStatus() {
        return this.paymentStatus;
    }

    @JvmName(name = "setPaymentStatus")
    public final void setPaymentStatus(String str) {
        this.paymentStatus = str;
    }

    @JvmName(name = "getTotalAmount")
    public final String getTotalAmount() {
        return this.totalAmount;
    }

    @JvmName(name = "setTotalAmount")
    public final void setTotalAmount(String str) {
        this.totalAmount = str;
    }

    @JvmName(name = "getExtInfo")
    public final Map<String, String> getExtInfo() {
        return this.extInfo;
    }

    @JvmName(name = "setExtInfo")
    public final void setExtInfo(Map<String, String> map) {
        this.extInfo = map;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/domain/announcement/model/RecurringAnnouncement$Type;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public @interface Type {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String PAY_STATUS = "SUBSCRIPTION_PAY_STATUS";
        public static final String SUMMARY = "SUBSCRIPTION_SUMMARY";

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/domain/announcement/model/RecurringAnnouncement$Type$Companion;", "", "", "PAY_STATUS", "Ljava/lang/String;", "SUMMARY", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes8.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String PAY_STATUS = "SUBSCRIPTION_PAY_STATUS";
            public static final String SUMMARY = "SUBSCRIPTION_SUMMARY";

            private Companion() {
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/domain/announcement/model/RecurringAnnouncement$PaymentStatus;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public @interface PaymentStatus {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String FAILED = "FAILED";
        public static final String SUCCESS = "SUCCESS";

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/domain/announcement/model/RecurringAnnouncement$PaymentStatus$Companion;", "", "", "FAILED", "Ljava/lang/String;", "SUCCESS", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes8.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String FAILED = "FAILED";
            public static final String SUCCESS = "SUCCESS";

            private Companion() {
            }
        }
    }
}
