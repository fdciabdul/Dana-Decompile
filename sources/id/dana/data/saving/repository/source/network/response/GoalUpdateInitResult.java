package id.dana.data.saving.repository.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.saving.model.SavingView;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b!\u0010\"J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005R\u001a\u0010\r\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\bR\u001a\u0010\u000e\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\u000b"}, d2 = {"Lid/dana/data/saving/repository/source/network/response/GoalUpdateInitResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "", "component1", "()Ljava/util/List;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component2", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "Lid/dana/data/saving/model/SavingView;", "component3", "()Lid/dana/data/saving/model/SavingView;", "categoryCodes", "maxTargetAmount", "savingView", "copy", "(Ljava/util/List;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/data/saving/model/SavingView;)Lid/dana/data/saving/repository/source/network/response/GoalUpdateInitResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getCategoryCodes", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getMaxTargetAmount", "Lid/dana/data/saving/model/SavingView;", "getSavingView", "<init>", "(Ljava/util/List;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/data/saving/model/SavingView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GoalUpdateInitResult extends BaseRpcResult {
    private final List<String> categoryCodes;
    private final MoneyViewEntity maxTargetAmount;
    private final SavingView savingView;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GoalUpdateInitResult copy$default(GoalUpdateInitResult goalUpdateInitResult, List list, MoneyViewEntity moneyViewEntity, SavingView savingView, int i, Object obj) {
        if ((i & 1) != 0) {
            list = goalUpdateInitResult.categoryCodes;
        }
        if ((i & 2) != 0) {
            moneyViewEntity = goalUpdateInitResult.maxTargetAmount;
        }
        if ((i & 4) != 0) {
            savingView = goalUpdateInitResult.savingView;
        }
        return goalUpdateInitResult.copy(list, moneyViewEntity, savingView);
    }

    public final List<String> component1() {
        return this.categoryCodes;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyViewEntity getMaxTargetAmount() {
        return this.maxTargetAmount;
    }

    /* renamed from: component3  reason: from getter */
    public final SavingView getSavingView() {
        return this.savingView;
    }

    public final GoalUpdateInitResult copy(List<String> categoryCodes, MoneyViewEntity maxTargetAmount, SavingView savingView) {
        Intrinsics.checkNotNullParameter(categoryCodes, "");
        Intrinsics.checkNotNullParameter(maxTargetAmount, "");
        Intrinsics.checkNotNullParameter(savingView, "");
        return new GoalUpdateInitResult(categoryCodes, maxTargetAmount, savingView);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GoalUpdateInitResult) {
            GoalUpdateInitResult goalUpdateInitResult = (GoalUpdateInitResult) other;
            return Intrinsics.areEqual(this.categoryCodes, goalUpdateInitResult.categoryCodes) && Intrinsics.areEqual(this.maxTargetAmount, goalUpdateInitResult.maxTargetAmount) && Intrinsics.areEqual(this.savingView, goalUpdateInitResult.savingView);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.categoryCodes.hashCode() * 31) + this.maxTargetAmount.hashCode()) * 31) + this.savingView.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GoalUpdateInitResult(categoryCodes=");
        sb.append(this.categoryCodes);
        sb.append(", maxTargetAmount=");
        sb.append(this.maxTargetAmount);
        sb.append(", savingView=");
        sb.append(this.savingView);
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

    @JvmName(name = "getSavingView")
    public final SavingView getSavingView() {
        return this.savingView;
    }

    public GoalUpdateInitResult(List<String> list, MoneyViewEntity moneyViewEntity, SavingView savingView) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(moneyViewEntity, "");
        Intrinsics.checkNotNullParameter(savingView, "");
        this.categoryCodes = list;
        this.maxTargetAmount = moneyViewEntity;
        this.savingView = savingView;
    }
}
