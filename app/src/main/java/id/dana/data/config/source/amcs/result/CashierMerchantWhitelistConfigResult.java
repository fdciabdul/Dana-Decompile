package id.dana.data.config.source.amcs.result;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/data/config/source/amcs/result/CashierMerchantWhitelistConfigResult;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "mode", "mids", "copy", "(Ljava/lang/String;Ljava/util/List;)Lid/dana/data/config/source/amcs/result/CashierMerchantWhitelistConfigResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/List;", "getMids", "Ljava/lang/String;", "getMode", "<init>", "(Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CashierMerchantWhitelistConfigResult {
    public List<String> mids;
    public String mode;

    public /* synthetic */ CashierMerchantWhitelistConfigResult() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CashierMerchantWhitelistConfigResult copy$default(CashierMerchantWhitelistConfigResult cashierMerchantWhitelistConfigResult, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cashierMerchantWhitelistConfigResult.mode;
        }
        if ((i & 2) != 0) {
            list = cashierMerchantWhitelistConfigResult.mids;
        }
        return cashierMerchantWhitelistConfigResult.copy(str, list);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    public final List<String> component2() {
        return this.mids;
    }

    public final CashierMerchantWhitelistConfigResult copy(String mode, List<String> mids) {
        return new CashierMerchantWhitelistConfigResult(mode, mids);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CashierMerchantWhitelistConfigResult) {
            CashierMerchantWhitelistConfigResult cashierMerchantWhitelistConfigResult = (CashierMerchantWhitelistConfigResult) other;
            return Intrinsics.areEqual(this.mode, cashierMerchantWhitelistConfigResult.mode) && Intrinsics.areEqual(this.mids, cashierMerchantWhitelistConfigResult.mids);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.mode;
        int hashCode = str == null ? 0 : str.hashCode();
        List<String> list = this.mids;
        return (hashCode * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierMerchantWhitelistConfigResult(mode=");
        sb.append(this.mode);
        sb.append(", mids=");
        sb.append(this.mids);
        sb.append(')');
        return sb.toString();
    }

    public CashierMerchantWhitelistConfigResult(String str, List<String> list) {
        this.mode = str;
        this.mids = list;
    }

    @JvmName(name = "getMode")
    public final String getMode() {
        return this.mode;
    }

    @JvmName(name = "getMids")
    public final List<String> getMids() {
        return this.mids;
    }
}
