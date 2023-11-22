package id.dana.domain.featureconfig.model;

import com.google.firebase.perf.util.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b \u0010!J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\tHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0017J\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\bR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0007¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\b"}, d2 = {"Lid/dana/domain/featureconfig/model/CashierMerchantWhitelistConfig;", "", "", "mid", "", "checkIfMidWhitelisted", "(Ljava/lang/String;)Z", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "mode", "mids", "copy", "(Ljava/lang/String;Ljava/util/List;)Lid/dana/domain/featureconfig/model/CashierMerchantWhitelistConfig;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "isBlacklist", "()Z", Constants.ENABLE_DISABLE, "isOpenToPublic", "isWhitelist", "toString", "Ljava/util/List;", "getMids", "Ljava/lang/String;", "getMode", "<init>", "(Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierMerchantWhitelistConfig {
    public List<String> mids;
    public String mode;

    public /* synthetic */ CashierMerchantWhitelistConfig() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CashierMerchantWhitelistConfig copy$default(CashierMerchantWhitelistConfig cashierMerchantWhitelistConfig, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cashierMerchantWhitelistConfig.mode;
        }
        if ((i & 2) != 0) {
            list = cashierMerchantWhitelistConfig.mids;
        }
        return cashierMerchantWhitelistConfig.copy(str, list);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    public final List<String> component2() {
        return this.mids;
    }

    public final CashierMerchantWhitelistConfig copy(String mode, List<String> mids) {
        Intrinsics.checkNotNullParameter(mode, "");
        Intrinsics.checkNotNullParameter(mids, "");
        return new CashierMerchantWhitelistConfig(mode, mids);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CashierMerchantWhitelistConfig) {
            CashierMerchantWhitelistConfig cashierMerchantWhitelistConfig = (CashierMerchantWhitelistConfig) other;
            return Intrinsics.areEqual(this.mode, cashierMerchantWhitelistConfig.mode) && Intrinsics.areEqual(this.mids, cashierMerchantWhitelistConfig.mids);
        }
        return false;
    }

    public final int hashCode() {
        return (this.mode.hashCode() * 31) + this.mids.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierMerchantWhitelistConfig(mode=");
        sb.append(this.mode);
        sb.append(", mids=");
        sb.append(this.mids);
        sb.append(')');
        return sb.toString();
    }

    public CashierMerchantWhitelistConfig(String str, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
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

    public final boolean isEnabled() {
        for (CashierMerchantWhitelistEnum cashierMerchantWhitelistEnum : CashierMerchantWhitelistEnum.values()) {
            if (StringsKt.equals(cashierMerchantWhitelistEnum.getMode(), this.mode, true)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isOpenToPublic() {
        return StringsKt.equals(this.mode, CashierMerchantWhitelistEnum.MODE_OPEN_TO_PUBLIC.getMode(), true);
    }

    private final boolean isWhitelist() {
        return StringsKt.equals(this.mode, CashierMerchantWhitelistEnum.MODE_WHITELIST.getMode(), true);
    }

    private final boolean isBlacklist() {
        return StringsKt.equals(this.mode, CashierMerchantWhitelistEnum.MODE_BLACKLIST.getMode(), true);
    }

    public final boolean checkIfMidWhitelisted(String mid) {
        Intrinsics.checkNotNullParameter(mid, "");
        if (mid.length() == 0) {
            return false;
        }
        if (isBlacklist()) {
            return !this.mids.contains(mid);
        } else if (isWhitelist()) {
            return this.mids.contains(mid);
        } else {
            return isOpenToPublic();
        }
    }
}
