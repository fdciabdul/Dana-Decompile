package id.dana.domain.saving.model;

import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.requestmoney.BundleKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/domain/saving/model/SavingTopUpInit;", "", "Lid/dana/domain/nearbyme/model/MoneyView;", "component1", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component2", "component3", BundleKey.MAXIMUM_AMOUNT, "currentAmount", "targetAmount", "copy", "(Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;)Lid/dana/domain/saving/model/SavingTopUpInit;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/domain/nearbyme/model/MoneyView;", "getCurrentAmount", "getMaxAmount", "getTargetAmount", "<init>", "(Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SavingTopUpInit {
    private final MoneyView currentAmount;
    private final MoneyView maxAmount;
    private final MoneyView targetAmount;

    public static /* synthetic */ SavingTopUpInit copy$default(SavingTopUpInit savingTopUpInit, MoneyView moneyView, MoneyView moneyView2, MoneyView moneyView3, int i, Object obj) {
        if ((i & 1) != 0) {
            moneyView = savingTopUpInit.maxAmount;
        }
        if ((i & 2) != 0) {
            moneyView2 = savingTopUpInit.currentAmount;
        }
        if ((i & 4) != 0) {
            moneyView3 = savingTopUpInit.targetAmount;
        }
        return savingTopUpInit.copy(moneyView, moneyView2, moneyView3);
    }

    /* renamed from: component1  reason: from getter */
    public final MoneyView getMaxAmount() {
        return this.maxAmount;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyView getCurrentAmount() {
        return this.currentAmount;
    }

    /* renamed from: component3  reason: from getter */
    public final MoneyView getTargetAmount() {
        return this.targetAmount;
    }

    public final SavingTopUpInit copy(MoneyView maxAmount, MoneyView currentAmount, MoneyView targetAmount) {
        Intrinsics.checkNotNullParameter(maxAmount, "");
        Intrinsics.checkNotNullParameter(currentAmount, "");
        Intrinsics.checkNotNullParameter(targetAmount, "");
        return new SavingTopUpInit(maxAmount, currentAmount, targetAmount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SavingTopUpInit) {
            SavingTopUpInit savingTopUpInit = (SavingTopUpInit) other;
            return Intrinsics.areEqual(this.maxAmount, savingTopUpInit.maxAmount) && Intrinsics.areEqual(this.currentAmount, savingTopUpInit.currentAmount) && Intrinsics.areEqual(this.targetAmount, savingTopUpInit.targetAmount);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.maxAmount.hashCode() * 31) + this.currentAmount.hashCode()) * 31) + this.targetAmount.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavingTopUpInit(maxAmount=");
        sb.append(this.maxAmount);
        sb.append(", currentAmount=");
        sb.append(this.currentAmount);
        sb.append(", targetAmount=");
        sb.append(this.targetAmount);
        sb.append(')');
        return sb.toString();
    }

    public SavingTopUpInit(MoneyView moneyView, MoneyView moneyView2, MoneyView moneyView3) {
        Intrinsics.checkNotNullParameter(moneyView, "");
        Intrinsics.checkNotNullParameter(moneyView2, "");
        Intrinsics.checkNotNullParameter(moneyView3, "");
        this.maxAmount = moneyView;
        this.currentAmount = moneyView2;
        this.targetAmount = moneyView3;
    }

    @JvmName(name = "getMaxAmount")
    public final MoneyView getMaxAmount() {
        return this.maxAmount;
    }

    @JvmName(name = "getCurrentAmount")
    public final MoneyView getCurrentAmount() {
        return this.currentAmount;
    }

    @JvmName(name = "getTargetAmount")
    public final MoneyView getTargetAmount() {
        return this.targetAmount;
    }
}
