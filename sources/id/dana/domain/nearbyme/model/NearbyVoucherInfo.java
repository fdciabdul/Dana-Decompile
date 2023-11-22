package id.dana.domain.nearbyme.model;

import id.dana.domain.investment.model.MultiCurrencyMoneyView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0010\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014R\u001a\u0010\u001d\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001a\u0010\u001f\u001a\u00020\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0014"}, d2 = {"Lid/dana/domain/nearbyme/model/NearbyVoucherInfo;", "", "", "discountOffRate", "Ljava/lang/String;", "getDiscountOffRate", "()Ljava/lang/String;", "Lid/dana/domain/nearbyme/model/MoneyView;", "displayVoucherPrice", "Lid/dana/domain/nearbyme/model/MoneyView;", "getDisplayVoucherPrice", "()Lid/dana/domain/nearbyme/model/MoneyView;", "displayVoucherValue", "getDisplayVoucherValue", "howTo", "getHowTo", "Lid/dana/domain/investment/model/MultiCurrencyMoneyView;", "strikethroughPrice", "Lid/dana/domain/investment/model/MultiCurrencyMoneyView;", "getStrikethroughPrice", "()Lid/dana/domain/investment/model/MultiCurrencyMoneyView;", "tnc", "getTnc", "voucherIcon", "getVoucherIcon", "voucherName", "getVoucherName", "voucherPrice", "getVoucherPrice", "voucherShortDescription", "getVoucherShortDescription", "voucherValue", "getVoucherValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class NearbyVoucherInfo {
    private final String discountOffRate;
    private final MoneyView displayVoucherPrice;
    private final MoneyView displayVoucherValue;
    private final String howTo;
    private final MultiCurrencyMoneyView strikethroughPrice;
    private final String tnc;
    private final String voucherIcon;
    private final String voucherName;
    private final MultiCurrencyMoneyView voucherPrice;
    private final String voucherShortDescription;
    private final MultiCurrencyMoneyView voucherValue;

    public NearbyVoucherInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public NearbyVoucherInfo(String str, String str2, String str3, MultiCurrencyMoneyView multiCurrencyMoneyView, MultiCurrencyMoneyView multiCurrencyMoneyView2, MoneyView moneyView, MoneyView moneyView2, String str4, String str5, String str6, MultiCurrencyMoneyView multiCurrencyMoneyView3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(multiCurrencyMoneyView, "");
        Intrinsics.checkNotNullParameter(multiCurrencyMoneyView2, "");
        Intrinsics.checkNotNullParameter(moneyView, "");
        Intrinsics.checkNotNullParameter(moneyView2, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(multiCurrencyMoneyView3, "");
        this.voucherName = str;
        this.voucherIcon = str2;
        this.voucherShortDescription = str3;
        this.voucherValue = multiCurrencyMoneyView;
        this.voucherPrice = multiCurrencyMoneyView2;
        this.displayVoucherValue = moneyView;
        this.displayVoucherPrice = moneyView2;
        this.tnc = str4;
        this.howTo = str5;
        this.discountOffRate = str6;
        this.strikethroughPrice = multiCurrencyMoneyView3;
    }

    @JvmName(name = "getVoucherName")
    public final String getVoucherName() {
        return this.voucherName;
    }

    @JvmName(name = "getVoucherIcon")
    public final String getVoucherIcon() {
        return this.voucherIcon;
    }

    @JvmName(name = "getVoucherShortDescription")
    public final String getVoucherShortDescription() {
        return this.voucherShortDescription;
    }

    public /* synthetic */ NearbyVoucherInfo(String str, String str2, String str3, MultiCurrencyMoneyView multiCurrencyMoneyView, MultiCurrencyMoneyView multiCurrencyMoneyView2, MoneyView moneyView, MoneyView moneyView2, String str4, String str5, String str6, MultiCurrencyMoneyView multiCurrencyMoneyView3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? new MultiCurrencyMoneyView(null, null, null, null, null, null, 63, null) : multiCurrencyMoneyView, (i & 16) != 0 ? new MultiCurrencyMoneyView(null, null, null, null, null, null, 63, null) : multiCurrencyMoneyView2, (i & 32) != 0 ? new MoneyView(null, null, null, 7, null) : moneyView, (i & 64) != 0 ? new MoneyView(null, null, null, 7, null) : moneyView2, (i & 128) != 0 ? "" : str4, (i & 256) != 0 ? "" : str5, (i & 512) == 0 ? str6 : "", (i & 1024) != 0 ? new MultiCurrencyMoneyView(null, null, null, null, null, null, 63, null) : multiCurrencyMoneyView3);
    }

    @JvmName(name = "getVoucherValue")
    public final MultiCurrencyMoneyView getVoucherValue() {
        return this.voucherValue;
    }

    @JvmName(name = "getVoucherPrice")
    public final MultiCurrencyMoneyView getVoucherPrice() {
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

    @JvmName(name = "getStrikethroughPrice")
    public final MultiCurrencyMoneyView getStrikethroughPrice() {
        return this.strikethroughPrice;
    }
}
