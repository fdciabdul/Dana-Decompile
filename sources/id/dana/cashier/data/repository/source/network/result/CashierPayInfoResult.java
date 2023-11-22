package id.dana.cashier.data.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.network.base.BaseRpcResultAphome;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b)\u0010*J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJL\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0007R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010%R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b&\u0010\u0007R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010\u000e"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/CashierPayInfoResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "Lid/dana/cashier/data/repository/source/network/result/AttributesResult;", "component1", "()Lid/dana/cashier/data/repository/source/network/result/AttributesResult;", "", "component2", "()Ljava/lang/String;", "Lid/dana/cashier/data/repository/source/network/result/ConfigCashierResult;", "component3", "()Lid/dana/cashier/data/repository/source/network/result/ConfigCashierResult;", "component4", "", "component5", "()Ljava/lang/Integer;", "attributes", CashierKeyParams.CASHIER_ORDER_ID, "config", "location", "resultStatus", "copy", "(Lid/dana/cashier/data/repository/source/network/result/AttributesResult;Ljava/lang/String;Lid/dana/cashier/data/repository/source/network/result/ConfigCashierResult;Ljava/lang/String;Ljava/lang/Integer;)Lid/dana/cashier/data/repository/source/network/result/CashierPayInfoResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Lid/dana/cashier/data/repository/source/network/result/AttributesResult;", "getAttributes", "Ljava/lang/String;", "getCashierOrderId", "Lid/dana/cashier/data/repository/source/network/result/ConfigCashierResult;", "getConfig", "setConfig", "(Lid/dana/cashier/data/repository/source/network/result/ConfigCashierResult;)V", "getLocation", "Ljava/lang/Integer;", "getResultStatus", "<init>", "(Lid/dana/cashier/data/repository/source/network/result/AttributesResult;Ljava/lang/String;Lid/dana/cashier/data/repository/source/network/result/ConfigCashierResult;Ljava/lang/String;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierPayInfoResult extends BaseRpcResultAphome {
    @SerializedName("attributes")
    private final AttributesResult attributes;
    private final String cashierOrderId;
    private ConfigCashierResult config;
    private final String location;
    private final Integer resultStatus;

    public static /* synthetic */ CashierPayInfoResult copy$default(CashierPayInfoResult cashierPayInfoResult, AttributesResult attributesResult, String str, ConfigCashierResult configCashierResult, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            attributesResult = cashierPayInfoResult.attributes;
        }
        if ((i & 2) != 0) {
            str = cashierPayInfoResult.cashierOrderId;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            configCashierResult = cashierPayInfoResult.config;
        }
        ConfigCashierResult configCashierResult2 = configCashierResult;
        if ((i & 8) != 0) {
            str2 = cashierPayInfoResult.location;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            num = cashierPayInfoResult.resultStatus;
        }
        return cashierPayInfoResult.copy(attributesResult, str3, configCashierResult2, str4, num);
    }

    /* renamed from: component1  reason: from getter */
    public final AttributesResult getAttributes() {
        return this.attributes;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    /* renamed from: component3  reason: from getter */
    public final ConfigCashierResult getConfig() {
        return this.config;
    }

    /* renamed from: component4  reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* renamed from: component5  reason: from getter */
    public final Integer getResultStatus() {
        return this.resultStatus;
    }

    public final CashierPayInfoResult copy(AttributesResult attributes, String cashierOrderId, ConfigCashierResult config, String location, Integer resultStatus) {
        return new CashierPayInfoResult(attributes, cashierOrderId, config, location, resultStatus);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CashierPayInfoResult) {
            CashierPayInfoResult cashierPayInfoResult = (CashierPayInfoResult) other;
            return Intrinsics.areEqual(this.attributes, cashierPayInfoResult.attributes) && Intrinsics.areEqual(this.cashierOrderId, cashierPayInfoResult.cashierOrderId) && Intrinsics.areEqual(this.config, cashierPayInfoResult.config) && Intrinsics.areEqual(this.location, cashierPayInfoResult.location) && Intrinsics.areEqual(this.resultStatus, cashierPayInfoResult.resultStatus);
        }
        return false;
    }

    public final int hashCode() {
        AttributesResult attributesResult = this.attributes;
        int hashCode = attributesResult == null ? 0 : attributesResult.hashCode();
        String str = this.cashierOrderId;
        int hashCode2 = str == null ? 0 : str.hashCode();
        ConfigCashierResult configCashierResult = this.config;
        int hashCode3 = configCashierResult == null ? 0 : configCashierResult.hashCode();
        String str2 = this.location;
        int hashCode4 = str2 == null ? 0 : str2.hashCode();
        Integer num = this.resultStatus;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierPayInfoResult(attributes=");
        sb.append(this.attributes);
        sb.append(", cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(", config=");
        sb.append(this.config);
        sb.append(", location=");
        sb.append(this.location);
        sb.append(", resultStatus=");
        sb.append(this.resultStatus);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getAttributes")
    public final AttributesResult getAttributes() {
        return this.attributes;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getConfig")
    public final ConfigCashierResult getConfig() {
        return this.config;
    }

    @JvmName(name = "setConfig")
    public final void setConfig(ConfigCashierResult configCashierResult) {
        this.config = configCashierResult;
    }

    @JvmName(name = "getLocation")
    public final String getLocation() {
        return this.location;
    }

    @JvmName(name = "getResultStatus")
    public final Integer getResultStatus() {
        return this.resultStatus;
    }

    public CashierPayInfoResult(AttributesResult attributesResult, String str, ConfigCashierResult configCashierResult, String str2, Integer num) {
        this.attributes = attributesResult;
        this.cashierOrderId = str;
        this.config = configCashierResult;
        this.location = str2;
        this.resultStatus = num;
    }
}
