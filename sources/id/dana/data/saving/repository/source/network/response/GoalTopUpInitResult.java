package id.dana.data.saving.repository.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import id.dana.requestmoney.BundleKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/data/saving/repository/source/network/response/GoalTopUpInitResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component1", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component2", "component3", BundleKey.MAXIMUM_AMOUNT, "currentAmount", "targetAmount", "copy", "(Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;)Lid/dana/data/saving/repository/source/network/response/GoalTopUpInitResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getCurrentAmount", "getMaxAmount", "getTargetAmount", "<init>", "(Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GoalTopUpInitResult extends BaseRpcResult {
    private final MoneyViewEntity currentAmount;
    private final MoneyViewEntity maxAmount;
    private final MoneyViewEntity targetAmount;

    public static /* synthetic */ GoalTopUpInitResult copy$default(GoalTopUpInitResult goalTopUpInitResult, MoneyViewEntity moneyViewEntity, MoneyViewEntity moneyViewEntity2, MoneyViewEntity moneyViewEntity3, int i, Object obj) {
        if ((i & 1) != 0) {
            moneyViewEntity = goalTopUpInitResult.maxAmount;
        }
        if ((i & 2) != 0) {
            moneyViewEntity2 = goalTopUpInitResult.currentAmount;
        }
        if ((i & 4) != 0) {
            moneyViewEntity3 = goalTopUpInitResult.targetAmount;
        }
        return goalTopUpInitResult.copy(moneyViewEntity, moneyViewEntity2, moneyViewEntity3);
    }

    /* renamed from: component1  reason: from getter */
    public final MoneyViewEntity getMaxAmount() {
        return this.maxAmount;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyViewEntity getCurrentAmount() {
        return this.currentAmount;
    }

    /* renamed from: component3  reason: from getter */
    public final MoneyViewEntity getTargetAmount() {
        return this.targetAmount;
    }

    public final GoalTopUpInitResult copy(MoneyViewEntity maxAmount, MoneyViewEntity currentAmount, MoneyViewEntity targetAmount) {
        Intrinsics.checkNotNullParameter(maxAmount, "");
        Intrinsics.checkNotNullParameter(currentAmount, "");
        Intrinsics.checkNotNullParameter(targetAmount, "");
        return new GoalTopUpInitResult(maxAmount, currentAmount, targetAmount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GoalTopUpInitResult) {
            GoalTopUpInitResult goalTopUpInitResult = (GoalTopUpInitResult) other;
            return Intrinsics.areEqual(this.maxAmount, goalTopUpInitResult.maxAmount) && Intrinsics.areEqual(this.currentAmount, goalTopUpInitResult.currentAmount) && Intrinsics.areEqual(this.targetAmount, goalTopUpInitResult.targetAmount);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.maxAmount.hashCode() * 31) + this.currentAmount.hashCode()) * 31) + this.targetAmount.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GoalTopUpInitResult(maxAmount=");
        sb.append(this.maxAmount);
        sb.append(", currentAmount=");
        sb.append(this.currentAmount);
        sb.append(", targetAmount=");
        sb.append(this.targetAmount);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getMaxAmount")
    public final MoneyViewEntity getMaxAmount() {
        return this.maxAmount;
    }

    @JvmName(name = "getCurrentAmount")
    public final MoneyViewEntity getCurrentAmount() {
        return this.currentAmount;
    }

    @JvmName(name = "getTargetAmount")
    public final MoneyViewEntity getTargetAmount() {
        return this.targetAmount;
    }

    public GoalTopUpInitResult(MoneyViewEntity moneyViewEntity, MoneyViewEntity moneyViewEntity2, MoneyViewEntity moneyViewEntity3) {
        Intrinsics.checkNotNullParameter(moneyViewEntity, "");
        Intrinsics.checkNotNullParameter(moneyViewEntity2, "");
        Intrinsics.checkNotNullParameter(moneyViewEntity3, "");
        this.maxAmount = moneyViewEntity;
        this.currentAmount = moneyViewEntity2;
        this.targetAmount = moneyViewEntity3;
    }
}
