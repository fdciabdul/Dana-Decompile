package id.dana.mybills.domain.model;

import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import id.dana.mybills.danah5.BillerPortalBridge;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import id.dana.wallet_v3.constant.WalletConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b9\u0010:J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J \u0001\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b'\u0010\u0004R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010(\u001a\u0004\b)\u0010\u0004\"\u0004\b*\u0010+R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b,\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010-\u001a\u0004\b.\u0010\rR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b/\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b0\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b1\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b2\u0010\u0004R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010(\u001a\u0004\b3\u0010\u0004\"\u0004\b4\u0010+R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b5\u0010\u0004R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010(\u001a\u0004\b6\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010-\u001a\u0004\b7\u0010\rR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b8\u0010\u0004"}, d2 = {"Lid/dana/mybills/domain/model/CreateSubscriptionExtendInfo;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component2", "component3", "component4", "Lid/dana/domain/nearbyme/model/MoneyView;", "component5", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component6", "component7", "component8", "component9", WalletConstant.CARD_INDEX_NO, "provider", InvoiceConstant.PAYMENT_METHOD, "payMode", UpdateSubscriptionRequest.KEY_EXTEND_INFO_DENOM, "totalAmount", "timezone", "type", "title", "productTitle", BillerPortalBridge.Event.Info.KEY_QUERY_URL_PROVIDER, BillerPortalBridge.Event.Info.KEY_BILLER_DENOM_TEXT, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/mybills/domain/model/CreateSubscriptionExtendInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBillerDenomText", "setBillerDenomText", "(Ljava/lang/String;)V", "getCardIndexNo", "Lid/dana/domain/nearbyme/model/MoneyView;", "getDenom", "getPayMode", "getPaymentMethod", "getProductTitle", "getProvider", "getQueryUrlProvider", "setQueryUrlProvider", "getTimezone", "getTitle", "getTotalAmount", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CreateSubscriptionExtendInfo {
    private String billerDenomText;
    private final String cardIndexNo;
    private final MoneyView denom;
    private final String payMode;
    private final String paymentMethod;
    private final String productTitle;
    private final String provider;
    private String queryUrlProvider;
    private final String timezone;
    private final String title;
    private final MoneyView totalAmount;
    private final String type;

    /* renamed from: component1  reason: from getter */
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    /* renamed from: component10  reason: from getter */
    public final String getProductTitle() {
        return this.productTitle;
    }

    /* renamed from: component11  reason: from getter */
    public final String getQueryUrlProvider() {
        return this.queryUrlProvider;
    }

    /* renamed from: component12  reason: from getter */
    public final String getBillerDenomText() {
        return this.billerDenomText;
    }

    /* renamed from: component2  reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    /* renamed from: component3  reason: from getter */
    public final String getPaymentMethod() {
        return this.paymentMethod;
    }

    /* renamed from: component4  reason: from getter */
    public final String getPayMode() {
        return this.payMode;
    }

    /* renamed from: component5  reason: from getter */
    public final MoneyView getDenom() {
        return this.denom;
    }

    /* renamed from: component6  reason: from getter */
    public final MoneyView getTotalAmount() {
        return this.totalAmount;
    }

    /* renamed from: component7  reason: from getter */
    public final String getTimezone() {
        return this.timezone;
    }

    /* renamed from: component8  reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component9  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final CreateSubscriptionExtendInfo copy(String cardIndexNo, String provider, String paymentMethod, String payMode, MoneyView denom, MoneyView totalAmount, String timezone, String type, String title, String productTitle, String queryUrlProvider, String billerDenomText) {
        return new CreateSubscriptionExtendInfo(cardIndexNo, provider, paymentMethod, payMode, denom, totalAmount, timezone, type, title, productTitle, queryUrlProvider, billerDenomText);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CreateSubscriptionExtendInfo) {
            CreateSubscriptionExtendInfo createSubscriptionExtendInfo = (CreateSubscriptionExtendInfo) other;
            return Intrinsics.areEqual(this.cardIndexNo, createSubscriptionExtendInfo.cardIndexNo) && Intrinsics.areEqual(this.provider, createSubscriptionExtendInfo.provider) && Intrinsics.areEqual(this.paymentMethod, createSubscriptionExtendInfo.paymentMethod) && Intrinsics.areEqual(this.payMode, createSubscriptionExtendInfo.payMode) && Intrinsics.areEqual(this.denom, createSubscriptionExtendInfo.denom) && Intrinsics.areEqual(this.totalAmount, createSubscriptionExtendInfo.totalAmount) && Intrinsics.areEqual(this.timezone, createSubscriptionExtendInfo.timezone) && Intrinsics.areEqual(this.type, createSubscriptionExtendInfo.type) && Intrinsics.areEqual(this.title, createSubscriptionExtendInfo.title) && Intrinsics.areEqual(this.productTitle, createSubscriptionExtendInfo.productTitle) && Intrinsics.areEqual(this.queryUrlProvider, createSubscriptionExtendInfo.queryUrlProvider) && Intrinsics.areEqual(this.billerDenomText, createSubscriptionExtendInfo.billerDenomText);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.cardIndexNo;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.provider;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.paymentMethod;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.payMode;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        MoneyView moneyView = this.denom;
        int hashCode5 = moneyView == null ? 0 : moneyView.hashCode();
        MoneyView moneyView2 = this.totalAmount;
        int hashCode6 = moneyView2 == null ? 0 : moneyView2.hashCode();
        String str5 = this.timezone;
        int hashCode7 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.type;
        int hashCode8 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.title;
        int hashCode9 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.productTitle;
        int hashCode10 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.queryUrlProvider;
        int hashCode11 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.billerDenomText;
        return (((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + (str10 != null ? str10.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreateSubscriptionExtendInfo(cardIndexNo=");
        sb.append(this.cardIndexNo);
        sb.append(", provider=");
        sb.append(this.provider);
        sb.append(", paymentMethod=");
        sb.append(this.paymentMethod);
        sb.append(", payMode=");
        sb.append(this.payMode);
        sb.append(", denom=");
        sb.append(this.denom);
        sb.append(", totalAmount=");
        sb.append(this.totalAmount);
        sb.append(", timezone=");
        sb.append(this.timezone);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", productTitle=");
        sb.append(this.productTitle);
        sb.append(", queryUrlProvider=");
        sb.append(this.queryUrlProvider);
        sb.append(", billerDenomText=");
        sb.append(this.billerDenomText);
        sb.append(')');
        return sb.toString();
    }

    public CreateSubscriptionExtendInfo(String str, String str2, String str3, String str4, MoneyView moneyView, MoneyView moneyView2, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.cardIndexNo = str;
        this.provider = str2;
        this.paymentMethod = str3;
        this.payMode = str4;
        this.denom = moneyView;
        this.totalAmount = moneyView2;
        this.timezone = str5;
        this.type = str6;
        this.title = str7;
        this.productTitle = str8;
        this.queryUrlProvider = str9;
        this.billerDenomText = str10;
    }

    public /* synthetic */ CreateSubscriptionExtendInfo(String str, String str2, String str3, String str4, MoneyView moneyView, MoneyView moneyView2, String str5, String str6, String str7, String str8, String str9, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, moneyView, moneyView2, str5, str6, str7, str8, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : str10);
    }

    @JvmName(name = "getCardIndexNo")
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    @JvmName(name = "getProvider")
    public final String getProvider() {
        return this.provider;
    }

    @JvmName(name = "getPaymentMethod")
    public final String getPaymentMethod() {
        return this.paymentMethod;
    }

    @JvmName(name = "getPayMode")
    public final String getPayMode() {
        return this.payMode;
    }

    @JvmName(name = "getDenom")
    public final MoneyView getDenom() {
        return this.denom;
    }

    @JvmName(name = "getTotalAmount")
    public final MoneyView getTotalAmount() {
        return this.totalAmount;
    }

    @JvmName(name = "getTimezone")
    public final String getTimezone() {
        return this.timezone;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getProductTitle")
    public final String getProductTitle() {
        return this.productTitle;
    }

    @JvmName(name = "getQueryUrlProvider")
    public final String getQueryUrlProvider() {
        return this.queryUrlProvider;
    }

    @JvmName(name = "setQueryUrlProvider")
    public final void setQueryUrlProvider(String str) {
        this.queryUrlProvider = str;
    }

    @JvmName(name = "getBillerDenomText")
    public final String getBillerDenomText() {
        return this.billerDenomText;
    }

    @JvmName(name = "setBillerDenomText")
    public final void setBillerDenomText(String str) {
        this.billerDenomText = str;
    }
}
