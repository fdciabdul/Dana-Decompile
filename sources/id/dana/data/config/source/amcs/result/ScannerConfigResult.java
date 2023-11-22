package id.dana.data.config.source.amcs.result;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b!\u0010\"R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R$\u0010\u001e\u001a\u0004\u0018\u00010\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017"}, d2 = {"Lid/dana/data/config/source/amcs/result/ScannerConfigResult;", "", "Lid/dana/data/config/source/amcs/result/CashierMerchantWhitelistConfigResult;", "cashierMerchantWhitelistConfig", "Lid/dana/data/config/source/amcs/result/CashierMerchantWhitelistConfigResult;", "getCashierMerchantWhitelistConfig", "()Lid/dana/data/config/source/amcs/result/CashierMerchantWhitelistConfigResult;", "setCashierMerchantWhitelistConfig", "(Lid/dana/data/config/source/amcs/result/CashierMerchantWhitelistConfigResult;)V", "", "", "cashierNativeEntryPoints", "Ljava/util/List;", "getCashierNativeEntryPoints", "()Ljava/util/List;", "setCashierNativeEntryPoints", "(Ljava/util/List;)V", "", "featureCashierDeeplinkKycEnable", "Ljava/lang/Boolean;", "getFeatureCashierDeeplinkKycEnable", "()Ljava/lang/Boolean;", "setFeatureCashierDeeplinkKycEnable", "(Ljava/lang/Boolean;)V", "featureCashierEnable", "getFeatureCashierEnable", "setFeatureCashierEnable", "featureNativeDecodeEnable", "getFeatureNativeDecodeEnable", "setFeatureNativeDecodeEnable", "featurePaymentKeyboardEnable", "getFeaturePaymentKeyboardEnable", "setFeaturePaymentKeyboardEnable", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lid/dana/data/config/source/amcs/result/CashierMerchantWhitelistConfigResult;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ScannerConfigResult {
    private CashierMerchantWhitelistConfigResult cashierMerchantWhitelistConfig;
    private List<String> cashierNativeEntryPoints;
    private Boolean featureCashierDeeplinkKycEnable;
    private Boolean featureCashierEnable;
    private Boolean featureNativeDecodeEnable;
    private Boolean featurePaymentKeyboardEnable;

    public ScannerConfigResult() {
        this(null, null, null, null, null, null, 63, null);
    }

    public ScannerConfigResult(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, CashierMerchantWhitelistConfigResult cashierMerchantWhitelistConfigResult, List<String> list) {
        this.featureCashierEnable = bool;
        this.featureCashierDeeplinkKycEnable = bool2;
        this.featurePaymentKeyboardEnable = bool3;
        this.featureNativeDecodeEnable = bool4;
        this.cashierMerchantWhitelistConfig = cashierMerchantWhitelistConfigResult;
        this.cashierNativeEntryPoints = list;
    }

    public /* synthetic */ ScannerConfigResult(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, CashierMerchantWhitelistConfigResult cashierMerchantWhitelistConfigResult, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : bool3, (i & 8) != 0 ? null : bool4, (i & 16) != 0 ? null : cashierMerchantWhitelistConfigResult, (i & 32) != 0 ? null : list);
    }

    @JvmName(name = "getFeatureCashierEnable")
    public final Boolean getFeatureCashierEnable() {
        return this.featureCashierEnable;
    }

    @JvmName(name = "setFeatureCashierEnable")
    public final void setFeatureCashierEnable(Boolean bool) {
        this.featureCashierEnable = bool;
    }

    @JvmName(name = "getFeatureCashierDeeplinkKycEnable")
    public final Boolean getFeatureCashierDeeplinkKycEnable() {
        return this.featureCashierDeeplinkKycEnable;
    }

    @JvmName(name = "setFeatureCashierDeeplinkKycEnable")
    public final void setFeatureCashierDeeplinkKycEnable(Boolean bool) {
        this.featureCashierDeeplinkKycEnable = bool;
    }

    @JvmName(name = "getFeaturePaymentKeyboardEnable")
    public final Boolean getFeaturePaymentKeyboardEnable() {
        return this.featurePaymentKeyboardEnable;
    }

    @JvmName(name = "setFeaturePaymentKeyboardEnable")
    public final void setFeaturePaymentKeyboardEnable(Boolean bool) {
        this.featurePaymentKeyboardEnable = bool;
    }

    @JvmName(name = "getFeatureNativeDecodeEnable")
    public final Boolean getFeatureNativeDecodeEnable() {
        return this.featureNativeDecodeEnable;
    }

    @JvmName(name = "setFeatureNativeDecodeEnable")
    public final void setFeatureNativeDecodeEnable(Boolean bool) {
        this.featureNativeDecodeEnable = bool;
    }

    @JvmName(name = "getCashierMerchantWhitelistConfig")
    public final CashierMerchantWhitelistConfigResult getCashierMerchantWhitelistConfig() {
        return this.cashierMerchantWhitelistConfig;
    }

    @JvmName(name = "setCashierMerchantWhitelistConfig")
    public final void setCashierMerchantWhitelistConfig(CashierMerchantWhitelistConfigResult cashierMerchantWhitelistConfigResult) {
        this.cashierMerchantWhitelistConfig = cashierMerchantWhitelistConfigResult;
    }

    @JvmName(name = "getCashierNativeEntryPoints")
    public final List<String> getCashierNativeEntryPoints() {
        return this.cashierNativeEntryPoints;
    }

    @JvmName(name = "setCashierNativeEntryPoints")
    public final void setCashierNativeEntryPoints(List<String> list) {
        this.cashierNativeEntryPoints = list;
    }
}
