package id.dana.data.sendmoney.model;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0003\u0010\t\u001a\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/data/sendmoney/model/DigitalMoneyResult;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "instId", "bankName", "eWalletName", "identifier", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/sendmoney/model/DigitalMoneyResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBankName", "getEWalletName", "getIdentifier", "getInstId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DigitalMoneyResult {
    public String bankName;
    public String eWalletName;
    public String identifier;
    public String instId;

    public /* synthetic */ DigitalMoneyResult() {
    }

    public static /* synthetic */ DigitalMoneyResult copy$default(DigitalMoneyResult digitalMoneyResult, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = digitalMoneyResult.instId;
        }
        if ((i & 2) != 0) {
            str2 = digitalMoneyResult.bankName;
        }
        if ((i & 4) != 0) {
            str3 = digitalMoneyResult.eWalletName;
        }
        if ((i & 8) != 0) {
            str4 = digitalMoneyResult.identifier;
        }
        return digitalMoneyResult.copy(str, str2, str3, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getInstId() {
        return this.instId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getBankName() {
        return this.bankName;
    }

    /* renamed from: component3  reason: from getter */
    public final String getEWalletName() {
        return this.eWalletName;
    }

    /* renamed from: component4  reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    public final DigitalMoneyResult copy(String instId, @JSONField(name = "bank_name") String bankName, @JSONField(name = "ewallet_name") String eWalletName, String identifier) {
        Intrinsics.checkNotNullParameter(instId, "");
        Intrinsics.checkNotNullParameter(bankName, "");
        Intrinsics.checkNotNullParameter(eWalletName, "");
        Intrinsics.checkNotNullParameter(identifier, "");
        return new DigitalMoneyResult(instId, bankName, eWalletName, identifier);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DigitalMoneyResult) {
            DigitalMoneyResult digitalMoneyResult = (DigitalMoneyResult) other;
            return Intrinsics.areEqual(this.instId, digitalMoneyResult.instId) && Intrinsics.areEqual(this.bankName, digitalMoneyResult.bankName) && Intrinsics.areEqual(this.eWalletName, digitalMoneyResult.eWalletName) && Intrinsics.areEqual(this.identifier, digitalMoneyResult.identifier);
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.instId.hashCode() * 31) + this.bankName.hashCode()) * 31) + this.eWalletName.hashCode()) * 31) + this.identifier.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DigitalMoneyResult(instId=");
        sb.append(this.instId);
        sb.append(", bankName=");
        sb.append(this.bankName);
        sb.append(", eWalletName=");
        sb.append(this.eWalletName);
        sb.append(", identifier=");
        sb.append(this.identifier);
        sb.append(')');
        return sb.toString();
    }

    public DigitalMoneyResult(String str, @JSONField(name = "bank_name") String str2, @JSONField(name = "ewallet_name") String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.instId = str;
        this.bankName = str2;
        this.eWalletName = str3;
        this.identifier = str4;
    }

    @JvmName(name = "getInstId")
    public final String getInstId() {
        return this.instId;
    }

    @JvmName(name = "getBankName")
    public final String getBankName() {
        return this.bankName;
    }

    @JvmName(name = "getEWalletName")
    public final String getEWalletName() {
        return this.eWalletName;
    }

    @JvmName(name = "getIdentifier")
    public final String getIdentifier() {
        return this.identifier;
    }
}
