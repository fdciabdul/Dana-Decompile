package id.dana.domain.featureconfig.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003¢\u0006\u0004\b\f\u0010\rJH\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00072\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0007¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u001e\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b\u000e\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b\u0010\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b\u000f\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b!\u0010\t"}, d2 = {"Lid/dana/domain/featureconfig/model/CashierNativeConfig;", "", "", "component1", "()Z", "component2", "component3", "Lid/dana/domain/featureconfig/model/CashierMerchantWhitelistConfig;", "component4", "()Lid/dana/domain/featureconfig/model/CashierMerchantWhitelistConfig;", "", "", "component5", "()Ljava/util/List;", "isCashierNativeEnable", "isDeeplinkKybEnable", "isCustomKeyboardEnable", "merchantWhitelistConfig", "cashierNativeEntryPoints", "copy", "(ZZZLid/dana/domain/featureconfig/model/CashierMerchantWhitelistConfig;Ljava/util/List;)Lid/dana/domain/featureconfig/model/CashierNativeConfig;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getCashierNativeEntryPoints", "Z", "Lid/dana/domain/featureconfig/model/CashierMerchantWhitelistConfig;", "getMerchantWhitelistConfig", "<init>", "(ZZZLid/dana/domain/featureconfig/model/CashierMerchantWhitelistConfig;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierNativeConfig {
    private final List<String> cashierNativeEntryPoints;
    private final boolean isCashierNativeEnable;
    private final boolean isCustomKeyboardEnable;
    private final boolean isDeeplinkKybEnable;
    private final CashierMerchantWhitelistConfig merchantWhitelistConfig;

    public static /* synthetic */ CashierNativeConfig copy$default(CashierNativeConfig cashierNativeConfig, boolean z, boolean z2, boolean z3, CashierMerchantWhitelistConfig cashierMerchantWhitelistConfig, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = cashierNativeConfig.isCashierNativeEnable;
        }
        if ((i & 2) != 0) {
            z2 = cashierNativeConfig.isDeeplinkKybEnable;
        }
        boolean z4 = z2;
        if ((i & 4) != 0) {
            z3 = cashierNativeConfig.isCustomKeyboardEnable;
        }
        boolean z5 = z3;
        if ((i & 8) != 0) {
            cashierMerchantWhitelistConfig = cashierNativeConfig.merchantWhitelistConfig;
        }
        CashierMerchantWhitelistConfig cashierMerchantWhitelistConfig2 = cashierMerchantWhitelistConfig;
        List<String> list2 = list;
        if ((i & 16) != 0) {
            list2 = cashierNativeConfig.cashierNativeEntryPoints;
        }
        return cashierNativeConfig.copy(z, z4, z5, cashierMerchantWhitelistConfig2, list2);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getIsCashierNativeEnable() {
        return this.isCashierNativeEnable;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getIsDeeplinkKybEnable() {
        return this.isDeeplinkKybEnable;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getIsCustomKeyboardEnable() {
        return this.isCustomKeyboardEnable;
    }

    /* renamed from: component4  reason: from getter */
    public final CashierMerchantWhitelistConfig getMerchantWhitelistConfig() {
        return this.merchantWhitelistConfig;
    }

    public final List<String> component5() {
        return this.cashierNativeEntryPoints;
    }

    public final CashierNativeConfig copy(boolean isCashierNativeEnable, boolean isDeeplinkKybEnable, boolean isCustomKeyboardEnable, CashierMerchantWhitelistConfig merchantWhitelistConfig, List<String> cashierNativeEntryPoints) {
        Intrinsics.checkNotNullParameter(merchantWhitelistConfig, "");
        Intrinsics.checkNotNullParameter(cashierNativeEntryPoints, "");
        return new CashierNativeConfig(isCashierNativeEnable, isDeeplinkKybEnable, isCustomKeyboardEnable, merchantWhitelistConfig, cashierNativeEntryPoints);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CashierNativeConfig) {
            CashierNativeConfig cashierNativeConfig = (CashierNativeConfig) other;
            return this.isCashierNativeEnable == cashierNativeConfig.isCashierNativeEnable && this.isDeeplinkKybEnable == cashierNativeConfig.isDeeplinkKybEnable && this.isCustomKeyboardEnable == cashierNativeConfig.isCustomKeyboardEnable && Intrinsics.areEqual(this.merchantWhitelistConfig, cashierNativeConfig.merchantWhitelistConfig) && Intrinsics.areEqual(this.cashierNativeEntryPoints, cashierNativeConfig.cashierNativeEntryPoints);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public final int hashCode() {
        boolean z = this.isCashierNativeEnable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        ?? r2 = this.isDeeplinkKybEnable;
        int i = r2;
        if (r2 != 0) {
            i = 1;
        }
        boolean z2 = this.isCustomKeyboardEnable;
        return (((((((r0 * 31) + i) * 31) + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.merchantWhitelistConfig.hashCode()) * 31) + this.cashierNativeEntryPoints.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierNativeConfig(isCashierNativeEnable=");
        sb.append(this.isCashierNativeEnable);
        sb.append(", isDeeplinkKybEnable=");
        sb.append(this.isDeeplinkKybEnable);
        sb.append(", isCustomKeyboardEnable=");
        sb.append(this.isCustomKeyboardEnable);
        sb.append(", merchantWhitelistConfig=");
        sb.append(this.merchantWhitelistConfig);
        sb.append(", cashierNativeEntryPoints=");
        sb.append(this.cashierNativeEntryPoints);
        sb.append(')');
        return sb.toString();
    }

    public CashierNativeConfig(boolean z, boolean z2, boolean z3, CashierMerchantWhitelistConfig cashierMerchantWhitelistConfig, List<String> list) {
        Intrinsics.checkNotNullParameter(cashierMerchantWhitelistConfig, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.isCashierNativeEnable = z;
        this.isDeeplinkKybEnable = z2;
        this.isCustomKeyboardEnable = z3;
        this.merchantWhitelistConfig = cashierMerchantWhitelistConfig;
        this.cashierNativeEntryPoints = list;
    }

    @JvmName(name = "isCashierNativeEnable")
    public final boolean isCashierNativeEnable() {
        return this.isCashierNativeEnable;
    }

    @JvmName(name = "isDeeplinkKybEnable")
    public final boolean isDeeplinkKybEnable() {
        return this.isDeeplinkKybEnable;
    }

    @JvmName(name = "isCustomKeyboardEnable")
    public final boolean isCustomKeyboardEnable() {
        return this.isCustomKeyboardEnable;
    }

    @JvmName(name = "getMerchantWhitelistConfig")
    public final CashierMerchantWhitelistConfig getMerchantWhitelistConfig() {
        return this.merchantWhitelistConfig;
    }

    @JvmName(name = "getCashierNativeEntryPoints")
    public final List<String> getCashierNativeEntryPoints() {
        return this.cashierNativeEntryPoints;
    }
}
