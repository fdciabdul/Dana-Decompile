package id.dana.data.nearbyme.model;

import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.nearbyme.model.VoucherInfo;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b6\u00107J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000e\u0010\fJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000f\u0010\fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0094\u0001\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b%\u0010\u0004J\r\u0010'\u001a\u00020&¢\u0006\u0004\b'\u0010(R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u001b\u0010)\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b,\u0010\fR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b-\u0010\fR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010)\u001a\u0004\b.\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010)\u001a\u0004\b/\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b0\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010)\u001a\u0004\b1\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010)\u001a\u0004\b2\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b3\u0010\fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010)\u001a\u0004\b4\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b5\u0010\f"}, d2 = {"Lid/dana/data/nearbyme/model/VoucherInfoEntity;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component2", "component3", "component4", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component5", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component6", "component7", "component8", "component9", "voucherName", "voucherIcon", "voucherBackGround", "voucherShortDescription", "voucherValue", "voucherPrice", "displayVoucherValue", "displayVoucherPrice", "tnc", "howTo", "discountOffRate", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/nearbyme/model/VoucherInfoEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/domain/nearbyme/model/VoucherInfo;", "toVoucherInfo", "()Lid/dana/domain/nearbyme/model/VoucherInfo;", "Ljava/lang/String;", "getDiscountOffRate", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getDisplayVoucherPrice", "getDisplayVoucherValue", "getHowTo", "getTnc", "getVoucherBackGround", "getVoucherIcon", "getVoucherName", "getVoucherPrice", "getVoucherShortDescription", "getVoucherValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class VoucherInfoEntity {
    private final String discountOffRate;
    private final MoneyViewEntity displayVoucherPrice;
    private final MoneyViewEntity displayVoucherValue;
    private final String howTo;
    private final String tnc;
    private final String voucherBackGround;
    private final String voucherIcon;
    private final String voucherName;
    private final MoneyViewEntity voucherPrice;
    private final String voucherShortDescription;
    private final MoneyViewEntity voucherValue;

    public VoucherInfoEntity() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getVoucherName() {
        return this.voucherName;
    }

    /* renamed from: component10  reason: from getter */
    public final String getHowTo() {
        return this.howTo;
    }

    /* renamed from: component11  reason: from getter */
    public final String getDiscountOffRate() {
        return this.discountOffRate;
    }

    /* renamed from: component2  reason: from getter */
    public final String getVoucherIcon() {
        return this.voucherIcon;
    }

    /* renamed from: component3  reason: from getter */
    public final String getVoucherBackGround() {
        return this.voucherBackGround;
    }

    /* renamed from: component4  reason: from getter */
    public final String getVoucherShortDescription() {
        return this.voucherShortDescription;
    }

    /* renamed from: component5  reason: from getter */
    public final MoneyViewEntity getVoucherValue() {
        return this.voucherValue;
    }

    /* renamed from: component6  reason: from getter */
    public final MoneyViewEntity getVoucherPrice() {
        return this.voucherPrice;
    }

    /* renamed from: component7  reason: from getter */
    public final MoneyViewEntity getDisplayVoucherValue() {
        return this.displayVoucherValue;
    }

    /* renamed from: component8  reason: from getter */
    public final MoneyViewEntity getDisplayVoucherPrice() {
        return this.displayVoucherPrice;
    }

    /* renamed from: component9  reason: from getter */
    public final String getTnc() {
        return this.tnc;
    }

    public final VoucherInfoEntity copy(String voucherName, String voucherIcon, String voucherBackGround, String voucherShortDescription, MoneyViewEntity voucherValue, MoneyViewEntity voucherPrice, MoneyViewEntity displayVoucherValue, MoneyViewEntity displayVoucherPrice, String tnc, String howTo, String discountOffRate) {
        return new VoucherInfoEntity(voucherName, voucherIcon, voucherBackGround, voucherShortDescription, voucherValue, voucherPrice, displayVoucherValue, displayVoucherPrice, tnc, howTo, discountOffRate);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof VoucherInfoEntity) {
            VoucherInfoEntity voucherInfoEntity = (VoucherInfoEntity) other;
            return Intrinsics.areEqual(this.voucherName, voucherInfoEntity.voucherName) && Intrinsics.areEqual(this.voucherIcon, voucherInfoEntity.voucherIcon) && Intrinsics.areEqual(this.voucherBackGround, voucherInfoEntity.voucherBackGround) && Intrinsics.areEqual(this.voucherShortDescription, voucherInfoEntity.voucherShortDescription) && Intrinsics.areEqual(this.voucherValue, voucherInfoEntity.voucherValue) && Intrinsics.areEqual(this.voucherPrice, voucherInfoEntity.voucherPrice) && Intrinsics.areEqual(this.displayVoucherValue, voucherInfoEntity.displayVoucherValue) && Intrinsics.areEqual(this.displayVoucherPrice, voucherInfoEntity.displayVoucherPrice) && Intrinsics.areEqual(this.tnc, voucherInfoEntity.tnc) && Intrinsics.areEqual(this.howTo, voucherInfoEntity.howTo) && Intrinsics.areEqual(this.discountOffRate, voucherInfoEntity.discountOffRate);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.voucherName;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.voucherIcon;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.voucherBackGround;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.voucherShortDescription;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        MoneyViewEntity moneyViewEntity = this.voucherValue;
        int hashCode5 = moneyViewEntity == null ? 0 : moneyViewEntity.hashCode();
        MoneyViewEntity moneyViewEntity2 = this.voucherPrice;
        int hashCode6 = moneyViewEntity2 == null ? 0 : moneyViewEntity2.hashCode();
        MoneyViewEntity moneyViewEntity3 = this.displayVoucherValue;
        int hashCode7 = moneyViewEntity3 == null ? 0 : moneyViewEntity3.hashCode();
        MoneyViewEntity moneyViewEntity4 = this.displayVoucherPrice;
        int hashCode8 = moneyViewEntity4 == null ? 0 : moneyViewEntity4.hashCode();
        String str5 = this.tnc;
        int hashCode9 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.howTo;
        int hashCode10 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.discountOffRate;
        return (((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + (str7 != null ? str7.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VoucherInfoEntity(voucherName=");
        sb.append(this.voucherName);
        sb.append(", voucherIcon=");
        sb.append(this.voucherIcon);
        sb.append(", voucherBackGround=");
        sb.append(this.voucherBackGround);
        sb.append(", voucherShortDescription=");
        sb.append(this.voucherShortDescription);
        sb.append(", voucherValue=");
        sb.append(this.voucherValue);
        sb.append(", voucherPrice=");
        sb.append(this.voucherPrice);
        sb.append(", displayVoucherValue=");
        sb.append(this.displayVoucherValue);
        sb.append(", displayVoucherPrice=");
        sb.append(this.displayVoucherPrice);
        sb.append(", tnc=");
        sb.append(this.tnc);
        sb.append(", howTo=");
        sb.append(this.howTo);
        sb.append(", discountOffRate=");
        sb.append(this.discountOffRate);
        sb.append(')');
        return sb.toString();
    }

    public VoucherInfoEntity(String str, String str2, String str3, String str4, MoneyViewEntity moneyViewEntity, MoneyViewEntity moneyViewEntity2, MoneyViewEntity moneyViewEntity3, MoneyViewEntity moneyViewEntity4, String str5, String str6, String str7) {
        this.voucherName = str;
        this.voucherIcon = str2;
        this.voucherBackGround = str3;
        this.voucherShortDescription = str4;
        this.voucherValue = moneyViewEntity;
        this.voucherPrice = moneyViewEntity2;
        this.displayVoucherValue = moneyViewEntity3;
        this.displayVoucherPrice = moneyViewEntity4;
        this.tnc = str5;
        this.howTo = str6;
        this.discountOffRate = str7;
    }

    @JvmName(name = "getVoucherName")
    public final String getVoucherName() {
        return this.voucherName;
    }

    @JvmName(name = "getVoucherIcon")
    public final String getVoucherIcon() {
        return this.voucherIcon;
    }

    @JvmName(name = "getVoucherBackGround")
    public final String getVoucherBackGround() {
        return this.voucherBackGround;
    }

    @JvmName(name = "getVoucherShortDescription")
    public final String getVoucherShortDescription() {
        return this.voucherShortDescription;
    }

    public /* synthetic */ VoucherInfoEntity(String str, String str2, String str3, String str4, MoneyViewEntity moneyViewEntity, MoneyViewEntity moneyViewEntity2, MoneyViewEntity moneyViewEntity3, MoneyViewEntity moneyViewEntity4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? new MoneyViewEntity(null, null, null, 7, null) : moneyViewEntity, (i & 32) != 0 ? new MoneyViewEntity(null, null, null, 7, null) : moneyViewEntity2, (i & 64) != 0 ? new MoneyViewEntity(null, null, null, 7, null) : moneyViewEntity3, (i & 128) != 0 ? new MoneyViewEntity(null, null, null, 7, null) : moneyViewEntity4, (i & 256) != 0 ? "" : str5, (i & 512) != 0 ? "" : str6, (i & 1024) == 0 ? str7 : "");
    }

    @JvmName(name = "getVoucherValue")
    public final MoneyViewEntity getVoucherValue() {
        return this.voucherValue;
    }

    @JvmName(name = "getVoucherPrice")
    public final MoneyViewEntity getVoucherPrice() {
        return this.voucherPrice;
    }

    @JvmName(name = "getDisplayVoucherValue")
    public final MoneyViewEntity getDisplayVoucherValue() {
        return this.displayVoucherValue;
    }

    @JvmName(name = "getDisplayVoucherPrice")
    public final MoneyViewEntity getDisplayVoucherPrice() {
        return this.displayVoucherPrice;
    }

    @JvmName(name = "getTnc")
    public final String getTnc() {
        return this.tnc;
    }

    @JvmName(name = "getHowTo")
    public final String getHowTo() {
        return this.howTo;
    }

    @JvmName(name = "getDiscountOffRate")
    public final String getDiscountOffRate() {
        return this.discountOffRate;
    }

    public final VoucherInfo toVoucherInfo() {
        String str = this.voucherName;
        String str2 = str == null ? "" : str;
        String str3 = this.voucherIcon;
        String str4 = str3 == null ? "" : str3;
        String str5 = this.voucherBackGround;
        String str6 = str5 == null ? "" : str5;
        String str7 = this.voucherShortDescription;
        String str8 = str7 == null ? "" : str7;
        MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(this.voucherValue);
        MoneyView moneyView2 = MoneyViewEntityMapperKt.toMoneyView(this.voucherPrice);
        MoneyView moneyView3 = MoneyViewEntityMapperKt.toMoneyView(this.displayVoucherValue);
        MoneyView moneyView4 = MoneyViewEntityMapperKt.toMoneyView(this.displayVoucherPrice);
        String str9 = this.tnc;
        String str10 = str9 == null ? "" : str9;
        String str11 = this.howTo;
        String str12 = str11 == null ? "" : str11;
        String str13 = this.discountOffRate;
        return new VoucherInfo(str2, str4, str6, str8, moneyView, moneyView2, moneyView3, moneyView4, null, str10, str12, str13 == null ? "" : str13, 256, null);
    }
}
