package id.dana.domain.investment.model;

import id.dana.data.config.source.amcs.result.OTCAcceptExpiryTimeConfigResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b \u0010!J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J4\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004\"\u0004\b\u0018\u0010\u0019R$\u0010\n\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\u001dR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001e\u0010\u0004\"\u0004\b\u001f\u0010\u0019"}, d2 = {"Lid/dana/domain/investment/model/InvestmentUnitInfo;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Long;", "component3", "type", OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT, "unitValue", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lid/dana/domain/investment/model/InvestmentUnitInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getType", "setType", "(Ljava/lang/String;)V", "Ljava/lang/Long;", "getUnit", "setUnit", "(Ljava/lang/Long;)V", "getUnitValue", "setUnitValue", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class InvestmentUnitInfo {
    private String type;
    private Long unit;
    private String unitValue;

    public InvestmentUnitInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ InvestmentUnitInfo copy$default(InvestmentUnitInfo investmentUnitInfo, String str, Long l, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = investmentUnitInfo.type;
        }
        if ((i & 2) != 0) {
            l = investmentUnitInfo.unit;
        }
        if ((i & 4) != 0) {
            str2 = investmentUnitInfo.unitValue;
        }
        return investmentUnitInfo.copy(str, l, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2  reason: from getter */
    public final Long getUnit() {
        return this.unit;
    }

    /* renamed from: component3  reason: from getter */
    public final String getUnitValue() {
        return this.unitValue;
    }

    public final InvestmentUnitInfo copy(String type, Long unit, String unitValue) {
        return new InvestmentUnitInfo(type, unit, unitValue);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof InvestmentUnitInfo) {
            InvestmentUnitInfo investmentUnitInfo = (InvestmentUnitInfo) other;
            return Intrinsics.areEqual(this.type, investmentUnitInfo.type) && Intrinsics.areEqual(this.unit, investmentUnitInfo.unit) && Intrinsics.areEqual(this.unitValue, investmentUnitInfo.unitValue);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.type;
        int hashCode = str == null ? 0 : str.hashCode();
        Long l = this.unit;
        int hashCode2 = l == null ? 0 : l.hashCode();
        String str2 = this.unitValue;
        return (((hashCode * 31) + hashCode2) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InvestmentUnitInfo(type=");
        sb.append(this.type);
        sb.append(", unit=");
        sb.append(this.unit);
        sb.append(", unitValue=");
        sb.append(this.unitValue);
        sb.append(')');
        return sb.toString();
    }

    public InvestmentUnitInfo(String str, Long l, String str2) {
        this.type = str;
        this.unit = l;
        this.unitValue = str2;
    }

    public /* synthetic */ InvestmentUnitInfo(String str, Long l, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? "" : str2);
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "setType")
    public final void setType(String str) {
        this.type = str;
    }

    @JvmName(name = "getUnit")
    public final Long getUnit() {
        return this.unit;
    }

    @JvmName(name = "setUnit")
    public final void setUnit(Long l) {
        this.unit = l;
    }

    @JvmName(name = "getUnitValue")
    public final String getUnitValue() {
        return this.unitValue;
    }

    @JvmName(name = "setUnitValue")
    public final void setUnitValue(String str) {
        this.unitValue = str;
    }
}
