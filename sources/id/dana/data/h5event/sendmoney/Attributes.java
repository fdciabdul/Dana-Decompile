package id.dana.data.h5event.sendmoney;

import id.dana.cashier.utils.CashierKeyParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b;\u0010<J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\r\u0010\tJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J¸\u0001\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010%\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010(\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b*\u0010\u0004R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b,\u0010\u0004R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010-\u001a\u0004\b.\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010-\u001a\u0004\b/\u0010\tR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010+\u001a\u0004\b0\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b1\u0010\u0004R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b2\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b3\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b4\u0010\u0004R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b5\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b6\u0010\u0004R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010+\u001a\u0004\b7\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010+\u001a\u0004\b8\u0010\u0004R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b9\u0010\u0004R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010+\u001a\u0004\b:\u0010\u0004"}, d2 = {"Lid/dana/data/h5event/sendmoney/Attributes;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "", "component12", "()Ljava/lang/Boolean;", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "payAccountNo", "accountName", "loginStatus", "networkScenario", "networkInfoName", "networkInfoScene", "networkInfoSubscene", "merchantReturnUrl", "processingStatus", "merchantTransId", "merchantLogoUrl", "displayMerchantOrder", "orderTitle", "vaExpiredTime", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/h5event/sendmoney/Attributes;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAccountName", "Ljava/lang/Boolean;", "getDisplayMerchantOrder", "getLoginStatus", "getMerchantLogoUrl", "getMerchantReturnUrl", "getMerchantTransId", "getNetworkInfoName", "getNetworkInfoScene", "getNetworkInfoSubscene", "getNetworkScenario", CashierKeyParams.GET_ORDER_TITLE, "getPayAccountNo", "getProcessingStatus", "getVaExpiredTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Attributes {
    public String accountName;
    public Boolean displayMerchantOrder;
    public Boolean loginStatus;
    public String merchantLogoUrl;
    public String merchantReturnUrl;
    public String merchantTransId;
    public String networkInfoName;
    public String networkInfoScene;
    public String networkInfoSubscene;
    public String networkScenario;
    public String orderTitle;
    public String payAccountNo;
    public String processingStatus;
    public String vaExpiredTime;

    public Attributes() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPayAccountNo() {
        return this.payAccountNo;
    }

    /* renamed from: component10  reason: from getter */
    public final String getMerchantTransId() {
        return this.merchantTransId;
    }

    /* renamed from: component11  reason: from getter */
    public final String getMerchantLogoUrl() {
        return this.merchantLogoUrl;
    }

    /* renamed from: component12  reason: from getter */
    public final Boolean getDisplayMerchantOrder() {
        return this.displayMerchantOrder;
    }

    /* renamed from: component13  reason: from getter */
    public final String getOrderTitle() {
        return this.orderTitle;
    }

    /* renamed from: component14  reason: from getter */
    public final String getVaExpiredTime() {
        return this.vaExpiredTime;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAccountName() {
        return this.accountName;
    }

    /* renamed from: component3  reason: from getter */
    public final Boolean getLoginStatus() {
        return this.loginStatus;
    }

    /* renamed from: component4  reason: from getter */
    public final String getNetworkScenario() {
        return this.networkScenario;
    }

    /* renamed from: component5  reason: from getter */
    public final String getNetworkInfoName() {
        return this.networkInfoName;
    }

    /* renamed from: component6  reason: from getter */
    public final String getNetworkInfoScene() {
        return this.networkInfoScene;
    }

    /* renamed from: component7  reason: from getter */
    public final String getNetworkInfoSubscene() {
        return this.networkInfoSubscene;
    }

    /* renamed from: component8  reason: from getter */
    public final String getMerchantReturnUrl() {
        return this.merchantReturnUrl;
    }

    /* renamed from: component9  reason: from getter */
    public final String getProcessingStatus() {
        return this.processingStatus;
    }

    public final Attributes copy(String payAccountNo, String accountName, Boolean loginStatus, String networkScenario, String networkInfoName, String networkInfoScene, String networkInfoSubscene, String merchantReturnUrl, String processingStatus, String merchantTransId, String merchantLogoUrl, Boolean displayMerchantOrder, String orderTitle, String vaExpiredTime) {
        return new Attributes(payAccountNo, accountName, loginStatus, networkScenario, networkInfoName, networkInfoScene, networkInfoSubscene, merchantReturnUrl, processingStatus, merchantTransId, merchantLogoUrl, displayMerchantOrder, orderTitle, vaExpiredTime);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Attributes) {
            Attributes attributes = (Attributes) other;
            return Intrinsics.areEqual(this.payAccountNo, attributes.payAccountNo) && Intrinsics.areEqual(this.accountName, attributes.accountName) && Intrinsics.areEqual(this.loginStatus, attributes.loginStatus) && Intrinsics.areEqual(this.networkScenario, attributes.networkScenario) && Intrinsics.areEqual(this.networkInfoName, attributes.networkInfoName) && Intrinsics.areEqual(this.networkInfoScene, attributes.networkInfoScene) && Intrinsics.areEqual(this.networkInfoSubscene, attributes.networkInfoSubscene) && Intrinsics.areEqual(this.merchantReturnUrl, attributes.merchantReturnUrl) && Intrinsics.areEqual(this.processingStatus, attributes.processingStatus) && Intrinsics.areEqual(this.merchantTransId, attributes.merchantTransId) && Intrinsics.areEqual(this.merchantLogoUrl, attributes.merchantLogoUrl) && Intrinsics.areEqual(this.displayMerchantOrder, attributes.displayMerchantOrder) && Intrinsics.areEqual(this.orderTitle, attributes.orderTitle) && Intrinsics.areEqual(this.vaExpiredTime, attributes.vaExpiredTime);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.payAccountNo;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.accountName;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        Boolean bool = this.loginStatus;
        int hashCode3 = bool == null ? 0 : bool.hashCode();
        String str3 = this.networkScenario;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.networkInfoName;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.networkInfoScene;
        int hashCode6 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.networkInfoSubscene;
        int hashCode7 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.merchantReturnUrl;
        int hashCode8 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.processingStatus;
        int hashCode9 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.merchantTransId;
        int hashCode10 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.merchantLogoUrl;
        int hashCode11 = str10 == null ? 0 : str10.hashCode();
        Boolean bool2 = this.displayMerchantOrder;
        int hashCode12 = bool2 == null ? 0 : bool2.hashCode();
        String str11 = this.orderTitle;
        int hashCode13 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.vaExpiredTime;
        return (((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + (str12 != null ? str12.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Attributes(payAccountNo=");
        sb.append(this.payAccountNo);
        sb.append(", accountName=");
        sb.append(this.accountName);
        sb.append(", loginStatus=");
        sb.append(this.loginStatus);
        sb.append(", networkScenario=");
        sb.append(this.networkScenario);
        sb.append(", networkInfoName=");
        sb.append(this.networkInfoName);
        sb.append(", networkInfoScene=");
        sb.append(this.networkInfoScene);
        sb.append(", networkInfoSubscene=");
        sb.append(this.networkInfoSubscene);
        sb.append(", merchantReturnUrl=");
        sb.append(this.merchantReturnUrl);
        sb.append(", processingStatus=");
        sb.append(this.processingStatus);
        sb.append(", merchantTransId=");
        sb.append(this.merchantTransId);
        sb.append(", merchantLogoUrl=");
        sb.append(this.merchantLogoUrl);
        sb.append(", displayMerchantOrder=");
        sb.append(this.displayMerchantOrder);
        sb.append(", orderTitle=");
        sb.append(this.orderTitle);
        sb.append(", vaExpiredTime=");
        sb.append(this.vaExpiredTime);
        sb.append(')');
        return sb.toString();
    }

    public Attributes(String str, String str2, Boolean bool, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Boolean bool2, String str11, String str12) {
        this.payAccountNo = str;
        this.accountName = str2;
        this.loginStatus = bool;
        this.networkScenario = str3;
        this.networkInfoName = str4;
        this.networkInfoScene = str5;
        this.networkInfoSubscene = str6;
        this.merchantReturnUrl = str7;
        this.processingStatus = str8;
        this.merchantTransId = str9;
        this.merchantLogoUrl = str10;
        this.displayMerchantOrder = bool2;
        this.orderTitle = str11;
        this.vaExpiredTime = str12;
    }

    public /* synthetic */ Attributes(String str, String str2, Boolean bool, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Boolean bool2, String str11, String str12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & 2048) != 0 ? null : bool2, (i & 4096) != 0 ? null : str11, (i & 8192) == 0 ? str12 : null);
    }

    @JvmName(name = "getPayAccountNo")
    public final String getPayAccountNo() {
        return this.payAccountNo;
    }

    @JvmName(name = "getAccountName")
    public final String getAccountName() {
        return this.accountName;
    }

    @JvmName(name = "getLoginStatus")
    public final Boolean getLoginStatus() {
        return this.loginStatus;
    }

    @JvmName(name = "getNetworkScenario")
    public final String getNetworkScenario() {
        return this.networkScenario;
    }

    @JvmName(name = "getNetworkInfoName")
    public final String getNetworkInfoName() {
        return this.networkInfoName;
    }

    @JvmName(name = "getNetworkInfoScene")
    public final String getNetworkInfoScene() {
        return this.networkInfoScene;
    }

    @JvmName(name = "getNetworkInfoSubscene")
    public final String getNetworkInfoSubscene() {
        return this.networkInfoSubscene;
    }

    @JvmName(name = "getMerchantReturnUrl")
    public final String getMerchantReturnUrl() {
        return this.merchantReturnUrl;
    }

    @JvmName(name = "getProcessingStatus")
    public final String getProcessingStatus() {
        return this.processingStatus;
    }

    @JvmName(name = "getMerchantTransId")
    public final String getMerchantTransId() {
        return this.merchantTransId;
    }

    @JvmName(name = "getMerchantLogoUrl")
    public final String getMerchantLogoUrl() {
        return this.merchantLogoUrl;
    }

    @JvmName(name = "getDisplayMerchantOrder")
    public final Boolean getDisplayMerchantOrder() {
        return this.displayMerchantOrder;
    }

    @JvmName(name = CashierKeyParams.GET_ORDER_TITLE)
    public final String getOrderTitle() {
        return this.orderTitle;
    }

    @JvmName(name = "getVaExpiredTime")
    public final String getVaExpiredTime() {
        return this.vaExpiredTime;
    }
}
