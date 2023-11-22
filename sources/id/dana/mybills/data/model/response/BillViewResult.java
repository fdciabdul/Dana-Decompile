package id.dana.mybills.data.model.response;

import id.dana.animation.HomeTabActivity;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\"\u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\t\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\f¢\u0006\u0004\bA\u0010BJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0011J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J¦\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\t2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010)\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*J\u0010\u0010,\u001a\u00020+HÖ\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b.\u0010\u0004R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b0\u0010\u0004R\u001a\u0010\"\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00101\u001a\u0004\b2\u0010\u0007R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00103\u001a\u0004\b4\u0010\u0011R\u001a\u0010$\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u00105\u001a\u0004\b6\u0010\u000bR\u001c\u0010%\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u00107\u001a\u0004\b8\u0010\u000eR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b9\u0010\u0004R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b:\u0010\u0004R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010/\u001a\u0004\b;\u0010\u0004R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010/\u001a\u0004\b<\u0010\u0004R\u001a\u0010#\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010/\u001a\u0004\b=\u0010\u0004R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010/\u001a\u0004\b>\u0010\u0004R\u001c\u0010 \u001a\u0004\u0018\u00010\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00103\u001a\u0004\b?\u0010\u0011R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010/\u001a\u0004\b@\u0010\u0004"}, d2 = {"Lid/dana/mybills/data/model/response/BillViewResult;", "", "", "component1", "()Ljava/lang/String;", "", "component10", "()Z", "component11", "Lid/dana/mybills/data/model/response/ExtInfo;", "component12", "()Lid/dana/mybills/data/model/response/ExtInfo;", "", "component13", "()Ljava/lang/Long;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component2", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "billId", UpdateSubscriptionRequest.KEY_EXTEND_INFO_DENOM, "goodsId", "goodsName", "iconUrl", "provider", "subscriptionTitle", "totalAmount", "type", "canInquiry", HomeTabActivity.WALLET_SECTION, "extInfo", "gmtDueDate", "copy", "(Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;ZLjava/lang/String;Lid/dana/mybills/data/model/response/ExtInfo;Ljava/lang/Long;)Lid/dana/mybills/data/model/response/BillViewResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBillId", "Z", "getCanInquiry", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getDenom", "Lid/dana/mybills/data/model/response/ExtInfo;", "getExtInfo", "Ljava/lang/Long;", "getGmtDueDate", "getGoodsId", "getGoodsName", "getIconUrl", "getProvider", "getSection", "getSubscriptionTitle", "getTotalAmount", "getType", "<init>", "(Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;ZLjava/lang/String;Lid/dana/mybills/data/model/response/ExtInfo;Ljava/lang/Long;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BillViewResult {
    private final String billId;
    private final boolean canInquiry;
    private final MoneyViewEntity denom;
    private final ExtInfo extInfo;
    private final Long gmtDueDate;
    private final String goodsId;
    private final String goodsName;
    private final String iconUrl;
    private final String provider;
    private final String section;
    private final String subscriptionTitle;
    private final MoneyViewEntity totalAmount;
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
    public final String getSection() {
        return this.section;
    }

    /* renamed from: component12  reason: from getter */
    public final ExtInfo getExtInfo() {
        return this.extInfo;
    }

    /* renamed from: component13  reason: from getter */
    public final Long getGmtDueDate() {
        return this.gmtDueDate;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyViewEntity getDenom() {
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
    public final MoneyViewEntity getTotalAmount() {
        return this.totalAmount;
    }

    /* renamed from: component9  reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final BillViewResult copy(String billId, MoneyViewEntity denom, String goodsId, String goodsName, String iconUrl, String provider, String subscriptionTitle, MoneyViewEntity totalAmount, String type, boolean canInquiry, String section, ExtInfo extInfo, Long gmtDueDate) {
        Intrinsics.checkNotNullParameter(section, "");
        Intrinsics.checkNotNullParameter(extInfo, "");
        return new BillViewResult(billId, denom, goodsId, goodsName, iconUrl, provider, subscriptionTitle, totalAmount, type, canInquiry, section, extInfo, gmtDueDate);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BillViewResult) {
            BillViewResult billViewResult = (BillViewResult) other;
            return Intrinsics.areEqual(this.billId, billViewResult.billId) && Intrinsics.areEqual(this.denom, billViewResult.denom) && Intrinsics.areEqual(this.goodsId, billViewResult.goodsId) && Intrinsics.areEqual(this.goodsName, billViewResult.goodsName) && Intrinsics.areEqual(this.iconUrl, billViewResult.iconUrl) && Intrinsics.areEqual(this.provider, billViewResult.provider) && Intrinsics.areEqual(this.subscriptionTitle, billViewResult.subscriptionTitle) && Intrinsics.areEqual(this.totalAmount, billViewResult.totalAmount) && Intrinsics.areEqual(this.type, billViewResult.type) && this.canInquiry == billViewResult.canInquiry && Intrinsics.areEqual(this.section, billViewResult.section) && Intrinsics.areEqual(this.extInfo, billViewResult.extInfo) && Intrinsics.areEqual(this.gmtDueDate, billViewResult.gmtDueDate);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.billId;
        int hashCode = str == null ? 0 : str.hashCode();
        MoneyViewEntity moneyViewEntity = this.denom;
        int hashCode2 = moneyViewEntity == null ? 0 : moneyViewEntity.hashCode();
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
        MoneyViewEntity moneyViewEntity2 = this.totalAmount;
        int hashCode8 = moneyViewEntity2 == null ? 0 : moneyViewEntity2.hashCode();
        String str7 = this.type;
        int hashCode9 = str7 == null ? 0 : str7.hashCode();
        boolean z = this.canInquiry;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode10 = this.section.hashCode();
        int hashCode11 = this.extInfo.hashCode();
        Long l = this.gmtDueDate;
        return (((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + i) * 31) + hashCode10) * 31) + hashCode11) * 31) + (l != null ? l.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BillViewResult(billId=");
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
        sb.append(", section=");
        sb.append(this.section);
        sb.append(", extInfo=");
        sb.append(this.extInfo);
        sb.append(", gmtDueDate=");
        sb.append(this.gmtDueDate);
        sb.append(')');
        return sb.toString();
    }

    public BillViewResult(String str, MoneyViewEntity moneyViewEntity, String str2, String str3, String str4, String str5, String str6, MoneyViewEntity moneyViewEntity2, String str7, boolean z, String str8, ExtInfo extInfo, Long l) {
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(extInfo, "");
        this.billId = str;
        this.denom = moneyViewEntity;
        this.goodsId = str2;
        this.goodsName = str3;
        this.iconUrl = str4;
        this.provider = str5;
        this.subscriptionTitle = str6;
        this.totalAmount = moneyViewEntity2;
        this.type = str7;
        this.canInquiry = z;
        this.section = str8;
        this.extInfo = extInfo;
        this.gmtDueDate = l;
    }

    @JvmName(name = "getBillId")
    public final String getBillId() {
        return this.billId;
    }

    public /* synthetic */ BillViewResult(String str, MoneyViewEntity moneyViewEntity, String str2, String str3, String str4, String str5, String str6, MoneyViewEntity moneyViewEntity2, String str7, boolean z, String str8, ExtInfo extInfo, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? new MoneyViewEntity(null, null, null, 7, null) : moneyViewEntity, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? new MoneyViewEntity(null, null, null, 7, null) : moneyViewEntity2, (i & 256) != 0 ? "" : str7, z, (i & 1024) != 0 ? "" : str8, (i & 2048) != 0 ? new ExtInfo(null, null, null, null, null, 31, null) : extInfo, (i & 4096) != 0 ? 0L : l);
    }

    @JvmName(name = "getDenom")
    public final MoneyViewEntity getDenom() {
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
    public final MoneyViewEntity getTotalAmount() {
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

    @JvmName(name = "getSection")
    public final String getSection() {
        return this.section;
    }

    @JvmName(name = "getExtInfo")
    public final ExtInfo getExtInfo() {
        return this.extInfo;
    }

    @JvmName(name = "getGmtDueDate")
    public final Long getGmtDueDate() {
        return this.gmtDueDate;
    }
}
