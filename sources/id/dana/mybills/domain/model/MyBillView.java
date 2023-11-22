package id.dana.mybills.domain.model;

import id.dana.animation.HomeTabActivity;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import id.dana.mybills.data.model.response.ExtInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010!\u001a\u00020\u0010\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010'\u001a\u00020\r¢\u0006\u0004\bK\u0010LJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0012J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J®\u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010!\u001a\u00020\u00102\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010#\u001a\u00020\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010%\u001a\u00020\u00022\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010'\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010+\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,J\u0010\u0010.\u001a\u00020-HÖ\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b0\u0010\u0004R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u001a\u00101\u001a\u0004\b2\u0010\u0004R$\u0010$\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u00101\u001a\u0004\b3\u0010\u0004\"\u0004\b4\u00105R\u001a\u0010#\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u00106\u001a\u0004\b7\u0010\u0007R\u001a\u0010\u001b\u001a\u00020\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00108\u001a\u0004\b9\u0010\u0012R\"\u0010'\u001a\u00020\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010:\u001a\u0004\b;\u0010\u000f\"\u0004\b<\u0010=R$\u0010&\u001a\u0004\u0018\u00010\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010>\u001a\u0004\b?\u0010\f\"\u0004\b@\u0010AR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00101\u001a\u0004\bB\u0010\u0004R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00101\u001a\u0004\bC\u0010\u0004R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00101\u001a\u0004\bD\u0010\u0004R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00101\u001a\u0004\bE\u0010\u0004R\"\u0010%\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u00101\u001a\u0004\bF\u0010\u0004\"\u0004\bG\u00105R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00101\u001a\u0004\bH\u0010\u0004R\u001a\u0010!\u001a\u00020\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u00108\u001a\u0004\bI\u0010\u0012R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00101\u001a\u0004\bJ\u0010\u0004"}, d2 = {"Lid/dana/mybills/domain/model/MyBillView;", "", "", "component1", "()Ljava/lang/String;", "", "component10", "()Z", "component11", "component12", "", "component13", "()Ljava/lang/Long;", "Lid/dana/mybills/data/model/response/ExtInfo;", "component14", "()Lid/dana/mybills/data/model/response/ExtInfo;", "Lid/dana/domain/nearbyme/model/MoneyView;", "component2", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "billId", UpdateSubscriptionRequest.KEY_EXTEND_INFO_DENOM, "goodsId", "goodsName", "iconUrl", "provider", "subscriptionTitle", "totalAmount", "type", "canInquiry", "billerServiceIcon", HomeTabActivity.WALLET_SECTION, "gmtDueDate", "extInfo", "copy", "(Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lid/dana/mybills/data/model/response/ExtInfo;)Lid/dana/mybills/domain/model/MyBillView;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBillId", "getBillerServiceIcon", "setBillerServiceIcon", "(Ljava/lang/String;)V", "Z", "getCanInquiry", "Lid/dana/domain/nearbyme/model/MoneyView;", "getDenom", "Lid/dana/mybills/data/model/response/ExtInfo;", "getExtInfo", "setExtInfo", "(Lid/dana/mybills/data/model/response/ExtInfo;)V", "Ljava/lang/Long;", "getGmtDueDate", "setGmtDueDate", "(Ljava/lang/Long;)V", "getGoodsId", "getGoodsName", "getIconUrl", "getProvider", "getSection", "setSection", "getSubscriptionTitle", "getTotalAmount", "getType", "<init>", "(Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lid/dana/mybills/data/model/response/ExtInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MyBillView {
    private final String billId;
    private String billerServiceIcon;
    private final boolean canInquiry;
    private final MoneyView denom;
    private ExtInfo extInfo;
    private Long gmtDueDate;
    private final String goodsId;
    private final String goodsName;
    private final String iconUrl;
    private final String provider;
    private String section;
    private final String subscriptionTitle;
    private final MoneyView totalAmount;
    private final String type;

    /* renamed from: component1  reason: from getter */
    public final String getBillId() {
        return this.billId;
    }

    /* renamed from: component10  reason: from getter */
    public final boolean getCanInquiry() {
        return this.canInquiry;
    }

    /* renamed from: component11  reason: from getter */
    public final String getBillerServiceIcon() {
        return this.billerServiceIcon;
    }

    /* renamed from: component12  reason: from getter */
    public final String getSection() {
        return this.section;
    }

    /* renamed from: component13  reason: from getter */
    public final Long getGmtDueDate() {
        return this.gmtDueDate;
    }

    /* renamed from: component14  reason: from getter */
    public final ExtInfo getExtInfo() {
        return this.extInfo;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyView getDenom() {
        return this.denom;
    }

    /* renamed from: component3  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getGoodsName() {
        return this.goodsName;
    }

    /* renamed from: component5  reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component6  reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    /* renamed from: component7  reason: from getter */
    public final String getSubscriptionTitle() {
        return this.subscriptionTitle;
    }

    /* renamed from: component8  reason: from getter */
    public final MoneyView getTotalAmount() {
        return this.totalAmount;
    }

    /* renamed from: component9  reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final MyBillView copy(String billId, MoneyView denom, String goodsId, String goodsName, String iconUrl, String provider, String subscriptionTitle, MoneyView totalAmount, String type, boolean canInquiry, String billerServiceIcon, String section, Long gmtDueDate, ExtInfo extInfo) {
        Intrinsics.checkNotNullParameter(denom, "");
        Intrinsics.checkNotNullParameter(totalAmount, "");
        Intrinsics.checkNotNullParameter(section, "");
        Intrinsics.checkNotNullParameter(extInfo, "");
        return new MyBillView(billId, denom, goodsId, goodsName, iconUrl, provider, subscriptionTitle, totalAmount, type, canInquiry, billerServiceIcon, section, gmtDueDate, extInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MyBillView) {
            MyBillView myBillView = (MyBillView) other;
            return Intrinsics.areEqual(this.billId, myBillView.billId) && Intrinsics.areEqual(this.denom, myBillView.denom) && Intrinsics.areEqual(this.goodsId, myBillView.goodsId) && Intrinsics.areEqual(this.goodsName, myBillView.goodsName) && Intrinsics.areEqual(this.iconUrl, myBillView.iconUrl) && Intrinsics.areEqual(this.provider, myBillView.provider) && Intrinsics.areEqual(this.subscriptionTitle, myBillView.subscriptionTitle) && Intrinsics.areEqual(this.totalAmount, myBillView.totalAmount) && Intrinsics.areEqual(this.type, myBillView.type) && this.canInquiry == myBillView.canInquiry && Intrinsics.areEqual(this.billerServiceIcon, myBillView.billerServiceIcon) && Intrinsics.areEqual(this.section, myBillView.section) && Intrinsics.areEqual(this.gmtDueDate, myBillView.gmtDueDate) && Intrinsics.areEqual(this.extInfo, myBillView.extInfo);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.billId;
        int hashCode = str == null ? 0 : str.hashCode();
        int hashCode2 = this.denom.hashCode();
        String str2 = this.goodsId;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.goodsName;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.iconUrl;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.provider;
        int hashCode6 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.subscriptionTitle;
        int hashCode7 = str6 == null ? 0 : str6.hashCode();
        int hashCode8 = this.totalAmount.hashCode();
        String str7 = this.type;
        int hashCode9 = str7 == null ? 0 : str7.hashCode();
        boolean z = this.canInquiry;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        String str8 = this.billerServiceIcon;
        int hashCode10 = str8 == null ? 0 : str8.hashCode();
        int hashCode11 = this.section.hashCode();
        Long l = this.gmtDueDate;
        return (((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + i) * 31) + hashCode10) * 31) + hashCode11) * 31) + (l != null ? l.hashCode() : 0)) * 31) + this.extInfo.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyBillView(billId=");
        sb.append(this.billId);
        sb.append(", denom=");
        sb.append(this.denom);
        sb.append(", goodsId=");
        sb.append(this.goodsId);
        sb.append(", goodsName=");
        sb.append(this.goodsName);
        sb.append(", iconUrl=");
        sb.append(this.iconUrl);
        sb.append(", provider=");
        sb.append(this.provider);
        sb.append(", subscriptionTitle=");
        sb.append(this.subscriptionTitle);
        sb.append(", totalAmount=");
        sb.append(this.totalAmount);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", canInquiry=");
        sb.append(this.canInquiry);
        sb.append(", billerServiceIcon=");
        sb.append(this.billerServiceIcon);
        sb.append(", section=");
        sb.append(this.section);
        sb.append(", gmtDueDate=");
        sb.append(this.gmtDueDate);
        sb.append(", extInfo=");
        sb.append(this.extInfo);
        sb.append(')');
        return sb.toString();
    }

    public MyBillView(String str, MoneyView moneyView, String str2, String str3, String str4, String str5, String str6, MoneyView moneyView2, String str7, boolean z, String str8, String str9, Long l, ExtInfo extInfo) {
        Intrinsics.checkNotNullParameter(moneyView, "");
        Intrinsics.checkNotNullParameter(moneyView2, "");
        Intrinsics.checkNotNullParameter(str9, "");
        Intrinsics.checkNotNullParameter(extInfo, "");
        this.billId = str;
        this.denom = moneyView;
        this.goodsId = str2;
        this.goodsName = str3;
        this.iconUrl = str4;
        this.provider = str5;
        this.subscriptionTitle = str6;
        this.totalAmount = moneyView2;
        this.type = str7;
        this.canInquiry = z;
        this.billerServiceIcon = str8;
        this.section = str9;
        this.gmtDueDate = l;
        this.extInfo = extInfo;
    }

    @JvmName(name = "getBillId")
    public final String getBillId() {
        return this.billId;
    }

    @JvmName(name = "getDenom")
    public final MoneyView getDenom() {
        return this.denom;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getGoodsName")
    public final String getGoodsName() {
        return this.goodsName;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @JvmName(name = "getProvider")
    public final String getProvider() {
        return this.provider;
    }

    @JvmName(name = "getSubscriptionTitle")
    public final String getSubscriptionTitle() {
        return this.subscriptionTitle;
    }

    @JvmName(name = "getTotalAmount")
    public final MoneyView getTotalAmount() {
        return this.totalAmount;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getCanInquiry")
    public final boolean getCanInquiry() {
        return this.canInquiry;
    }

    @JvmName(name = "getBillerServiceIcon")
    public final String getBillerServiceIcon() {
        return this.billerServiceIcon;
    }

    @JvmName(name = "setBillerServiceIcon")
    public final void setBillerServiceIcon(String str) {
        this.billerServiceIcon = str;
    }

    @JvmName(name = "getSection")
    public final String getSection() {
        return this.section;
    }

    @JvmName(name = "setSection")
    public final void setSection(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.section = str;
    }

    public /* synthetic */ MyBillView(String str, MoneyView moneyView, String str2, String str3, String str4, String str5, String str6, MoneyView moneyView2, String str7, boolean z, String str8, String str9, Long l, ExtInfo extInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, moneyView, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? "" : str6, moneyView2, (i & 256) != 0 ? "" : str7, (i & 512) != 0 ? false : z, (i & 1024) != 0 ? "" : str8, (i & 2048) != 0 ? "" : str9, (i & 4096) != 0 ? 0L : l, (i & 8192) != 0 ? new ExtInfo(null, null, null, null, null, 31, null) : extInfo);
    }

    @JvmName(name = "getGmtDueDate")
    public final Long getGmtDueDate() {
        return this.gmtDueDate;
    }

    @JvmName(name = "setGmtDueDate")
    public final void setGmtDueDate(Long l) {
        this.gmtDueDate = l;
    }

    @JvmName(name = "getExtInfo")
    public final ExtInfo getExtInfo() {
        return this.extInfo;
    }

    @JvmName(name = "setExtInfo")
    public final void setExtInfo(ExtInfo extInfo) {
        Intrinsics.checkNotNullParameter(extInfo, "");
        this.extInfo = extInfo;
    }
}
