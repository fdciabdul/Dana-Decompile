package id.dana.cashier.domain.model;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ:\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R+\u0010\u000b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/cashier/domain/model/ConfigCashierInfo;", "", "", "component1", "()Ljava/lang/Boolean;", "", "", "", "component2", "()Ljava/util/List;", "cashierShowlogin", "cardRegexes", "copy", "(Ljava/lang/Boolean;Ljava/util/List;)Lid/dana/cashier/domain/model/ConfigCashierInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getCardRegexes", "Ljava/lang/Boolean;", "getCashierShowlogin", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ConfigCashierInfo {
    private final List<Map<String, String>> cardRegexes;
    private final Boolean cashierShowlogin;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConfigCashierInfo copy$default(ConfigCashierInfo configCashierInfo, Boolean bool, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = configCashierInfo.cashierShowlogin;
        }
        if ((i & 2) != 0) {
            list = configCashierInfo.cardRegexes;
        }
        return configCashierInfo.copy(bool, list);
    }

    /* renamed from: component1  reason: from getter */
    public final Boolean getCashierShowlogin() {
        return this.cashierShowlogin;
    }

    public final List<Map<String, String>> component2() {
        return this.cardRegexes;
    }

    public final ConfigCashierInfo copy(Boolean cashierShowlogin, List<? extends Map<String, String>> cardRegexes) {
        return new ConfigCashierInfo(cashierShowlogin, cardRegexes);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ConfigCashierInfo) {
            ConfigCashierInfo configCashierInfo = (ConfigCashierInfo) other;
            return Intrinsics.areEqual(this.cashierShowlogin, configCashierInfo.cashierShowlogin) && Intrinsics.areEqual(this.cardRegexes, configCashierInfo.cardRegexes);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.cashierShowlogin;
        int hashCode = bool == null ? 0 : bool.hashCode();
        List<Map<String, String>> list = this.cardRegexes;
        return (hashCode * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConfigCashierInfo(cashierShowlogin=");
        sb.append(this.cashierShowlogin);
        sb.append(", cardRegexes=");
        sb.append(this.cardRegexes);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ConfigCashierInfo(Boolean bool, List<? extends Map<String, String>> list) {
        this.cashierShowlogin = bool;
        this.cardRegexes = list;
    }

    @JvmName(name = "getCashierShowlogin")
    public final Boolean getCashierShowlogin() {
        return this.cashierShowlogin;
    }

    @JvmName(name = "getCardRegexes")
    public final List<Map<String, String>> getCardRegexes() {
        return this.cardRegexes;
    }
}
