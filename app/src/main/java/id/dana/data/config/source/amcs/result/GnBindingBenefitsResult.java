package id.dana.data.config.source.amcs.result;

import com.google.gson.annotations.SerializedName;
import id.dana.data.config.model.BindingBenefitEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u001c\u0010\u0004"}, d2 = {"Lid/dana/data/config/source/amcs/result/GnBindingBenefitsResult;", "", "Lid/dana/data/config/model/BindingBenefitEntity;", "component1", "()Lid/dana/data/config/model/BindingBenefitEntity;", "component2", "component3", "component4", "gnBenefitEntitySendmoney", "gnBenefitEntityBillpayment", "gnBenefitEntityCashoutBalance", "gnBenefitEntityDanaProtection", "copy", "(Lid/dana/data/config/model/BindingBenefitEntity;Lid/dana/data/config/model/BindingBenefitEntity;Lid/dana/data/config/model/BindingBenefitEntity;Lid/dana/data/config/model/BindingBenefitEntity;)Lid/dana/data/config/source/amcs/result/GnBindingBenefitsResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/data/config/model/BindingBenefitEntity;", "getGnBenefitEntityBillpayment", "getGnBenefitEntityCashoutBalance", "getGnBenefitEntityDanaProtection", "getGnBenefitEntitySendmoney", "<init>", "(Lid/dana/data/config/model/BindingBenefitEntity;Lid/dana/data/config/model/BindingBenefitEntity;Lid/dana/data/config/model/BindingBenefitEntity;Lid/dana/data/config/model/BindingBenefitEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class GnBindingBenefitsResult {
    @SerializedName("gn_benefit_billpayment")
    private final BindingBenefitEntity gnBenefitEntityBillpayment;
    @SerializedName("gn_benefit_cashoutbalance")
    private final BindingBenefitEntity gnBenefitEntityCashoutBalance;
    @SerializedName("gn_benefit_danaprotection")
    private final BindingBenefitEntity gnBenefitEntityDanaProtection;
    @SerializedName("gn_benefit_sendmoney")
    private final BindingBenefitEntity gnBenefitEntitySendmoney;

    public static /* synthetic */ GnBindingBenefitsResult copy$default(GnBindingBenefitsResult gnBindingBenefitsResult, BindingBenefitEntity bindingBenefitEntity, BindingBenefitEntity bindingBenefitEntity2, BindingBenefitEntity bindingBenefitEntity3, BindingBenefitEntity bindingBenefitEntity4, int i, Object obj) {
        if ((i & 1) != 0) {
            bindingBenefitEntity = gnBindingBenefitsResult.gnBenefitEntitySendmoney;
        }
        if ((i & 2) != 0) {
            bindingBenefitEntity2 = gnBindingBenefitsResult.gnBenefitEntityBillpayment;
        }
        if ((i & 4) != 0) {
            bindingBenefitEntity3 = gnBindingBenefitsResult.gnBenefitEntityCashoutBalance;
        }
        if ((i & 8) != 0) {
            bindingBenefitEntity4 = gnBindingBenefitsResult.gnBenefitEntityDanaProtection;
        }
        return gnBindingBenefitsResult.copy(bindingBenefitEntity, bindingBenefitEntity2, bindingBenefitEntity3, bindingBenefitEntity4);
    }

    /* renamed from: component1  reason: from getter */
    public final BindingBenefitEntity getGnBenefitEntitySendmoney() {
        return this.gnBenefitEntitySendmoney;
    }

    /* renamed from: component2  reason: from getter */
    public final BindingBenefitEntity getGnBenefitEntityBillpayment() {
        return this.gnBenefitEntityBillpayment;
    }

    /* renamed from: component3  reason: from getter */
    public final BindingBenefitEntity getGnBenefitEntityCashoutBalance() {
        return this.gnBenefitEntityCashoutBalance;
    }

    /* renamed from: component4  reason: from getter */
    public final BindingBenefitEntity getGnBenefitEntityDanaProtection() {
        return this.gnBenefitEntityDanaProtection;
    }

    public final GnBindingBenefitsResult copy(BindingBenefitEntity gnBenefitEntitySendmoney, BindingBenefitEntity gnBenefitEntityBillpayment, BindingBenefitEntity gnBenefitEntityCashoutBalance, BindingBenefitEntity gnBenefitEntityDanaProtection) {
        Intrinsics.checkNotNullParameter(gnBenefitEntitySendmoney, "");
        Intrinsics.checkNotNullParameter(gnBenefitEntityBillpayment, "");
        Intrinsics.checkNotNullParameter(gnBenefitEntityCashoutBalance, "");
        Intrinsics.checkNotNullParameter(gnBenefitEntityDanaProtection, "");
        return new GnBindingBenefitsResult(gnBenefitEntitySendmoney, gnBenefitEntityBillpayment, gnBenefitEntityCashoutBalance, gnBenefitEntityDanaProtection);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GnBindingBenefitsResult) {
            GnBindingBenefitsResult gnBindingBenefitsResult = (GnBindingBenefitsResult) other;
            return Intrinsics.areEqual(this.gnBenefitEntitySendmoney, gnBindingBenefitsResult.gnBenefitEntitySendmoney) && Intrinsics.areEqual(this.gnBenefitEntityBillpayment, gnBindingBenefitsResult.gnBenefitEntityBillpayment) && Intrinsics.areEqual(this.gnBenefitEntityCashoutBalance, gnBindingBenefitsResult.gnBenefitEntityCashoutBalance) && Intrinsics.areEqual(this.gnBenefitEntityDanaProtection, gnBindingBenefitsResult.gnBenefitEntityDanaProtection);
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.gnBenefitEntitySendmoney.hashCode() * 31) + this.gnBenefitEntityBillpayment.hashCode()) * 31) + this.gnBenefitEntityCashoutBalance.hashCode()) * 31) + this.gnBenefitEntityDanaProtection.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GnBindingBenefitsResult(gnBenefitEntitySendmoney=");
        sb.append(this.gnBenefitEntitySendmoney);
        sb.append(", gnBenefitEntityBillpayment=");
        sb.append(this.gnBenefitEntityBillpayment);
        sb.append(", gnBenefitEntityCashoutBalance=");
        sb.append(this.gnBenefitEntityCashoutBalance);
        sb.append(", gnBenefitEntityDanaProtection=");
        sb.append(this.gnBenefitEntityDanaProtection);
        sb.append(')');
        return sb.toString();
    }

    public GnBindingBenefitsResult(BindingBenefitEntity bindingBenefitEntity, BindingBenefitEntity bindingBenefitEntity2, BindingBenefitEntity bindingBenefitEntity3, BindingBenefitEntity bindingBenefitEntity4) {
        Intrinsics.checkNotNullParameter(bindingBenefitEntity, "");
        Intrinsics.checkNotNullParameter(bindingBenefitEntity2, "");
        Intrinsics.checkNotNullParameter(bindingBenefitEntity3, "");
        Intrinsics.checkNotNullParameter(bindingBenefitEntity4, "");
        this.gnBenefitEntitySendmoney = bindingBenefitEntity;
        this.gnBenefitEntityBillpayment = bindingBenefitEntity2;
        this.gnBenefitEntityCashoutBalance = bindingBenefitEntity3;
        this.gnBenefitEntityDanaProtection = bindingBenefitEntity4;
    }

    @JvmName(name = "getGnBenefitEntitySendmoney")
    public final BindingBenefitEntity getGnBenefitEntitySendmoney() {
        return this.gnBenefitEntitySendmoney;
    }

    @JvmName(name = "getGnBenefitEntityBillpayment")
    public final BindingBenefitEntity getGnBenefitEntityBillpayment() {
        return this.gnBenefitEntityBillpayment;
    }

    @JvmName(name = "getGnBenefitEntityCashoutBalance")
    public final BindingBenefitEntity getGnBenefitEntityCashoutBalance() {
        return this.gnBenefitEntityCashoutBalance;
    }

    @JvmName(name = "getGnBenefitEntityDanaProtection")
    public final BindingBenefitEntity getGnBenefitEntityDanaProtection() {
        return this.gnBenefitEntityDanaProtection;
    }
}
