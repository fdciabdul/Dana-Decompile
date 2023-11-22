package id.dana.domain.nearbyme.model;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\rJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ\u008a\u0001\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b'\u0010\u0004R\u0017\u0010\u001d\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u001d\u0010(\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010*\u001a\u0004\b+\u0010\rR\u001a\u0010\u0019\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010*\u001a\u0004\b,\u0010\rR\u001a\u0010\u0018\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\b-\u0010\rR\u001a\u0010\u001c\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010(\u001a\u0004\b.\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b/\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b0\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b1\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b2\u0010\u0004R\u001a\u0010\u0017\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b3\u0010\rR\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b4\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b5\u0010\r"}, d2 = {"Lid/dana/domain/nearbyme/model/VoucherInfo;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component2", "component3", "component4", "Lid/dana/domain/nearbyme/model/MoneyView;", "component5", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component6", "component7", "component8", "component9", "voucherName", "voucherIcon", "voucherBackground", "voucherShortDescription", "voucherValue", "voucherPrice", "displayVoucherValue", "displayVoucherPrice", "displayStrikethroughPrice", "tnc", "howTo", "discountOffRate", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/nearbyme/model/VoucherInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getDiscountOffRate", "Lid/dana/domain/nearbyme/model/MoneyView;", "getDisplayStrikethroughPrice", "getDisplayVoucherPrice", "getDisplayVoucherValue", "getHowTo", "getTnc", "getVoucherBackground", "getVoucherIcon", "getVoucherName", "getVoucherPrice", "getVoucherShortDescription", "getVoucherValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class VoucherInfo {
    private final String discountOffRate;
    private final MoneyView displayStrikethroughPrice;
    private final MoneyView displayVoucherPrice;
    private final MoneyView displayVoucherValue;
    private final String howTo;
    private final String tnc;
    private final String voucherBackground;
    private final String voucherIcon;
    private final String voucherName;
    private final MoneyView voucherPrice;
    private final String voucherShortDescription;
    private final MoneyView voucherValue;

    public VoucherInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, ARiverTrackWatchDogEventConstant.STARTUP_FLAG, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getVoucherName() {
        return this.voucherName;
    }

    /* renamed from: component10  reason: from getter */
    public final String getTnc() {
        return this.tnc;
    }

    /* renamed from: component11  reason: from getter */
    public final String getHowTo() {
        return this.howTo;
    }

    /* renamed from: component12  reason: from getter */
    public final String getDiscountOffRate() {
        return this.discountOffRate;
    }

    /* renamed from: component2  reason: from getter */
    public final String getVoucherIcon() {
        return this.voucherIcon;
    }

    /* renamed from: component3  reason: from getter */
    public final String getVoucherBackground() {
        return this.voucherBackground;
    }

    /* renamed from: component4  reason: from getter */
    public final String getVoucherShortDescription() {
        return this.voucherShortDescription;
    }

    /* renamed from: component5  reason: from getter */
    public final MoneyView getVoucherValue() {
        return this.voucherValue;
    }

    /* renamed from: component6  reason: from getter */
    public final MoneyView getVoucherPrice() {
        return this.voucherPrice;
    }

    /* renamed from: component7  reason: from getter */
    public final MoneyView getDisplayVoucherValue() {
        return this.displayVoucherValue;
    }

    /* renamed from: component8  reason: from getter */
    public final MoneyView getDisplayVoucherPrice() {
        return this.displayVoucherPrice;
    }

    /* renamed from: component9  reason: from getter */
    public final MoneyView getDisplayStrikethroughPrice() {
        return this.displayStrikethroughPrice;
    }

    public final VoucherInfo copy(String voucherName, String voucherIcon, String voucherBackground, String voucherShortDescription, MoneyView voucherValue, MoneyView voucherPrice, MoneyView displayVoucherValue, MoneyView displayVoucherPrice, MoneyView displayStrikethroughPrice, String tnc, String howTo, String discountOffRate) {
        Intrinsics.checkNotNullParameter(voucherName, "");
        Intrinsics.checkNotNullParameter(voucherIcon, "");
        Intrinsics.checkNotNullParameter(voucherBackground, "");
        Intrinsics.checkNotNullParameter(voucherShortDescription, "");
        Intrinsics.checkNotNullParameter(voucherValue, "");
        Intrinsics.checkNotNullParameter(voucherPrice, "");
        Intrinsics.checkNotNullParameter(displayVoucherValue, "");
        Intrinsics.checkNotNullParameter(displayVoucherPrice, "");
        Intrinsics.checkNotNullParameter(tnc, "");
        Intrinsics.checkNotNullParameter(howTo, "");
        Intrinsics.checkNotNullParameter(discountOffRate, "");
        return new VoucherInfo(voucherName, voucherIcon, voucherBackground, voucherShortDescription, voucherValue, voucherPrice, displayVoucherValue, displayVoucherPrice, displayStrikethroughPrice, tnc, howTo, discountOffRate);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof VoucherInfo) {
            VoucherInfo voucherInfo = (VoucherInfo) other;
            return Intrinsics.areEqual(this.voucherName, voucherInfo.voucherName) && Intrinsics.areEqual(this.voucherIcon, voucherInfo.voucherIcon) && Intrinsics.areEqual(this.voucherBackground, voucherInfo.voucherBackground) && Intrinsics.areEqual(this.voucherShortDescription, voucherInfo.voucherShortDescription) && Intrinsics.areEqual(this.voucherValue, voucherInfo.voucherValue) && Intrinsics.areEqual(this.voucherPrice, voucherInfo.voucherPrice) && Intrinsics.areEqual(this.displayVoucherValue, voucherInfo.displayVoucherValue) && Intrinsics.areEqual(this.displayVoucherPrice, voucherInfo.displayVoucherPrice) && Intrinsics.areEqual(this.displayStrikethroughPrice, voucherInfo.displayStrikethroughPrice) && Intrinsics.areEqual(this.tnc, voucherInfo.tnc) && Intrinsics.areEqual(this.howTo, voucherInfo.howTo) && Intrinsics.areEqual(this.discountOffRate, voucherInfo.discountOffRate);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.voucherName.hashCode();
        int hashCode2 = this.voucherIcon.hashCode();
        int hashCode3 = this.voucherBackground.hashCode();
        int hashCode4 = this.voucherShortDescription.hashCode();
        int hashCode5 = this.voucherValue.hashCode();
        int hashCode6 = this.voucherPrice.hashCode();
        int hashCode7 = this.displayVoucherValue.hashCode();
        int hashCode8 = this.displayVoucherPrice.hashCode();
        MoneyView moneyView = this.displayStrikethroughPrice;
        return (((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + (moneyView == null ? 0 : moneyView.hashCode())) * 31) + this.tnc.hashCode()) * 31) + this.howTo.hashCode()) * 31) + this.discountOffRate.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VoucherInfo(voucherName=");
        sb.append(this.voucherName);
        sb.append(", voucherIcon=");
        sb.append(this.voucherIcon);
        sb.append(", voucherBackground=");
        sb.append(this.voucherBackground);
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
        sb.append(", displayStrikethroughPrice=");
        sb.append(this.displayStrikethroughPrice);
        sb.append(", tnc=");
        sb.append(this.tnc);
        sb.append(", howTo=");
        sb.append(this.howTo);
        sb.append(", discountOffRate=");
        sb.append(this.discountOffRate);
        sb.append(')');
        return sb.toString();
    }

    public VoucherInfo(String str, String str2, String str3, String str4, MoneyView moneyView, MoneyView moneyView2, MoneyView moneyView3, MoneyView moneyView4, MoneyView moneyView5, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(moneyView, "");
        Intrinsics.checkNotNullParameter(moneyView2, "");
        Intrinsics.checkNotNullParameter(moneyView3, "");
        Intrinsics.checkNotNullParameter(moneyView4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        this.voucherName = str;
        this.voucherIcon = str2;
        this.voucherBackground = str3;
        this.voucherShortDescription = str4;
        this.voucherValue = moneyView;
        this.voucherPrice = moneyView2;
        this.displayVoucherValue = moneyView3;
        this.displayVoucherPrice = moneyView4;
        this.displayStrikethroughPrice = moneyView5;
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

    @JvmName(name = "getVoucherBackground")
    public final String getVoucherBackground() {
        return this.voucherBackground;
    }

    @JvmName(name = "getVoucherShortDescription")
    public final String getVoucherShortDescription() {
        return this.voucherShortDescription;
    }

    public /* synthetic */ VoucherInfo(String str, String str2, String str3, String str4, MoneyView moneyView, MoneyView moneyView2, MoneyView moneyView3, MoneyView moneyView4, MoneyView moneyView5, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? new MoneyView(null, null, null, 7, null) : moneyView, (i & 32) != 0 ? new MoneyView(null, null, null, 7, null) : moneyView2, (i & 64) != 0 ? new MoneyView(null, null, null, 7, null) : moneyView3, (i & 128) != 0 ? new MoneyView(null, null, null, 7, null) : moneyView4, (i & 256) != 0 ? new MoneyView(null, null, null, 7, null) : moneyView5, (i & 512) != 0 ? "" : str5, (i & 1024) != 0 ? "" : str6, (i & 2048) == 0 ? str7 : "");
    }

    @JvmName(name = "getVoucherValue")
    public final MoneyView getVoucherValue() {
        return this.voucherValue;
    }

    @JvmName(name = "getVoucherPrice")
    public final MoneyView getVoucherPrice() {
        return this.voucherPrice;
    }

    @JvmName(name = "getDisplayVoucherValue")
    public final MoneyView getDisplayVoucherValue() {
        return this.displayVoucherValue;
    }

    @JvmName(name = "getDisplayVoucherPrice")
    public final MoneyView getDisplayVoucherPrice() {
        return this.displayVoucherPrice;
    }

    @JvmName(name = "getDisplayStrikethroughPrice")
    public final MoneyView getDisplayStrikethroughPrice() {
        return this.displayStrikethroughPrice;
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
}
