package id.dana.data.saving.repository.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\b"}, d2 = {"Lid/dana/data/saving/repository/source/network/response/GoalCreateInitResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "", "component1", "()Ljava/util/List;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component2", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "categoryCodes", "maxTargetAmount", "copy", "(Ljava/util/List;Lid/dana/network/response/expresspurchase/MoneyViewEntity;)Lid/dana/data/saving/repository/source/network/response/GoalCreateInitResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getCategoryCodes", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getMaxTargetAmount", "<init>", "(Ljava/util/List;Lid/dana/network/response/expresspurchase/MoneyViewEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GoalCreateInitResult extends BaseRpcResult {
    private final List<String> categoryCodes;
    private final MoneyViewEntity maxTargetAmount;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GoalCreateInitResult copy$default(GoalCreateInitResult goalCreateInitResult, List list, MoneyViewEntity moneyViewEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            list = goalCreateInitResult.categoryCodes;
        }
        if ((i & 2) != 0) {
            moneyViewEntity = goalCreateInitResult.maxTargetAmount;
        }
        return goalCreateInitResult.copy(list, moneyViewEntity);
    }

    public final List<String> component1() {
        return this.categoryCodes;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyViewEntity getMaxTargetAmount() {
        return this.maxTargetAmount;
    }

    public final GoalCreateInitResult copy(List<String> categoryCodes, MoneyViewEntity maxTargetAmount) {
        return new GoalCreateInitResult(categoryCodes, maxTargetAmount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GoalCreateInitResult) {
            GoalCreateInitResult goalCreateInitResult = (GoalCreateInitResult) other;
            return Intrinsics.areEqual(this.categoryCodes, goalCreateInitResult.categoryCodes) && Intrinsics.areEqual(this.maxTargetAmount, goalCreateInitResult.maxTargetAmount);
        }
        return false;
    }

    public final int hashCode() {
        List<String> list = this.categoryCodes;
        int hashCode = list == null ? 0 : list.hashCode();
        MoneyViewEntity moneyViewEntity = this.maxTargetAmount;
        return (hashCode * 31) + (moneyViewEntity != null ? moneyViewEntity.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GoalCreateInitResult(categoryCodes=");
        sb.append(this.categoryCodes);
        sb.append(", maxTargetAmount=");
        sb.append(this.maxTargetAmount);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getCategoryCodes")
    public final List<String> getCategoryCodes() {
        return this.categoryCodes;
    }

    @JvmName(name = "getMaxTargetAmount")
    public final MoneyViewEntity getMaxTargetAmount() {
        return this.maxTargetAmount;
    }

    public GoalCreateInitResult(List<String> list, MoneyViewEntity moneyViewEntity) {
        this.categoryCodes = list;
        this.maxTargetAmount = moneyViewEntity;
    }
}
