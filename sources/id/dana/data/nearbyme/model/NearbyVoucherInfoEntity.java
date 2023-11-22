package id.dana.data.nearbyme.model;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import id.dana.data.investment.repository.source.network.response.MultiCurrencyMoneyResult;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b#\u0010$R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u0016R\u001a\u0010\u001f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001a\u0010!\u001a\u00020\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u0016"}, d2 = {"Lid/dana/data/nearbyme/model/NearbyVoucherInfoEntity;", "", "", "discountOffRate", "Ljava/lang/String;", "getDiscountOffRate", "()Ljava/lang/String;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "displayStrikethroughPrice", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getDisplayStrikethroughPrice", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "displayVoucherPrice", "getDisplayVoucherPrice", "displayVoucherValue", "getDisplayVoucherValue", "howTo", "getHowTo", "Lid/dana/data/investment/repository/source/network/response/MultiCurrencyMoneyResult;", "strikethroughPrice", "Lid/dana/data/investment/repository/source/network/response/MultiCurrencyMoneyResult;", "getStrikethroughPrice", "()Lid/dana/data/investment/repository/source/network/response/MultiCurrencyMoneyResult;", "tnc", "getTnc", "voucherIcon", "getVoucherIcon", "voucherName", "getVoucherName", "voucherPrice", "getVoucherPrice", "voucherShortDescription", "getVoucherShortDescription", "voucherValue", "getVoucherValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/investment/repository/source/network/response/MultiCurrencyMoneyResult;Lid/dana/data/investment/repository/source/network/response/MultiCurrencyMoneyResult;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/investment/repository/source/network/response/MultiCurrencyMoneyResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NearbyVoucherInfoEntity {
    private final String discountOffRate;
    private final MoneyViewEntity displayStrikethroughPrice;
    private final MoneyViewEntity displayVoucherPrice;
    private final MoneyViewEntity displayVoucherValue;
    private final String howTo;
    private final MultiCurrencyMoneyResult strikethroughPrice;
    private final String tnc;
    private final String voucherIcon;
    private final String voucherName;
    private final MultiCurrencyMoneyResult voucherPrice;
    private final String voucherShortDescription;
    private final MultiCurrencyMoneyResult voucherValue;

    public NearbyVoucherInfoEntity() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, ARiverTrackWatchDogEventConstant.STARTUP_FLAG, null);
    }

    public NearbyVoucherInfoEntity(String str, String str2, String str3, MultiCurrencyMoneyResult multiCurrencyMoneyResult, MultiCurrencyMoneyResult multiCurrencyMoneyResult2, MoneyViewEntity moneyViewEntity, MoneyViewEntity moneyViewEntity2, MoneyViewEntity moneyViewEntity3, String str4, String str5, String str6, MultiCurrencyMoneyResult multiCurrencyMoneyResult3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(multiCurrencyMoneyResult, "");
        Intrinsics.checkNotNullParameter(multiCurrencyMoneyResult2, "");
        Intrinsics.checkNotNullParameter(moneyViewEntity, "");
        Intrinsics.checkNotNullParameter(moneyViewEntity2, "");
        Intrinsics.checkNotNullParameter(moneyViewEntity3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(multiCurrencyMoneyResult3, "");
        this.voucherName = str;
        this.voucherIcon = str2;
        this.voucherShortDescription = str3;
        this.voucherValue = multiCurrencyMoneyResult;
        this.voucherPrice = multiCurrencyMoneyResult2;
        this.displayVoucherValue = moneyViewEntity;
        this.displayVoucherPrice = moneyViewEntity2;
        this.displayStrikethroughPrice = moneyViewEntity3;
        this.tnc = str4;
        this.howTo = str5;
        this.discountOffRate = str6;
        this.strikethroughPrice = multiCurrencyMoneyResult3;
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

    public /* synthetic */ NearbyVoucherInfoEntity(String str, String str2, String str3, MultiCurrencyMoneyResult multiCurrencyMoneyResult, MultiCurrencyMoneyResult multiCurrencyMoneyResult2, MoneyViewEntity moneyViewEntity, MoneyViewEntity moneyViewEntity2, MoneyViewEntity moneyViewEntity3, String str4, String str5, String str6, MultiCurrencyMoneyResult multiCurrencyMoneyResult3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? new MultiCurrencyMoneyResult(null, null, null, null, null, null, 63, null) : multiCurrencyMoneyResult, (i & 16) != 0 ? new MultiCurrencyMoneyResult(null, null, null, null, null, null, 63, null) : multiCurrencyMoneyResult2, (i & 32) != 0 ? new MoneyViewEntity(null, null, null, 7, null) : moneyViewEntity, (i & 64) != 0 ? new MoneyViewEntity(null, null, null, 7, null) : moneyViewEntity2, (i & 128) != 0 ? new MoneyViewEntity(null, null, null, 7, null) : moneyViewEntity3, (i & 256) != 0 ? "" : str4, (i & 512) != 0 ? "" : str5, (i & 1024) == 0 ? str6 : "", (i & 2048) != 0 ? new MultiCurrencyMoneyResult(null, null, null, null, null, null, 63, null) : multiCurrencyMoneyResult3);
    }

    @JvmName(name = "getVoucherValue")
    public final MultiCurrencyMoneyResult getVoucherValue() {
        return this.voucherValue;
    }

    @JvmName(name = "getVoucherPrice")
    public final MultiCurrencyMoneyResult getVoucherPrice() {
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

    @JvmName(name = "getDisplayStrikethroughPrice")
    public final MoneyViewEntity getDisplayStrikethroughPrice() {
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

    @JvmName(name = "getStrikethroughPrice")
    public final MultiCurrencyMoneyResult getStrikethroughPrice() {
        return this.strikethroughPrice;
    }
}
