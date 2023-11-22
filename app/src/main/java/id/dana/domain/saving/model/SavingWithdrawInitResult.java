package id.dana.domain.saving.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\b"}, d2 = {"Lid/dana/domain/saving/model/SavingWithdrawInitResult;", "", "Lid/dana/domain/saving/model/SavingGoalView;", "component1", "()Lid/dana/domain/saving/model/SavingGoalView;", "", "Lid/dana/domain/saving/model/SavingGoalWithdrawMethod;", "component2", "()Ljava/util/List;", "savingGoalView", "savingGoalWithdrawMethods", "copy", "(Lid/dana/domain/saving/model/SavingGoalView;Ljava/util/List;)Lid/dana/domain/saving/model/SavingWithdrawInitResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/domain/saving/model/SavingGoalView;", "getSavingGoalView", "Ljava/util/List;", "getSavingGoalWithdrawMethods", "<init>", "(Lid/dana/domain/saving/model/SavingGoalView;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SavingWithdrawInitResult {
    private final SavingGoalView savingGoalView;
    private final List<SavingGoalWithdrawMethod> savingGoalWithdrawMethods;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SavingWithdrawInitResult copy$default(SavingWithdrawInitResult savingWithdrawInitResult, SavingGoalView savingGoalView, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            savingGoalView = savingWithdrawInitResult.savingGoalView;
        }
        if ((i & 2) != 0) {
            list = savingWithdrawInitResult.savingGoalWithdrawMethods;
        }
        return savingWithdrawInitResult.copy(savingGoalView, list);
    }

    /* renamed from: component1  reason: from getter */
    public final SavingGoalView getSavingGoalView() {
        return this.savingGoalView;
    }

    public final List<SavingGoalWithdrawMethod> component2() {
        return this.savingGoalWithdrawMethods;
    }

    public final SavingWithdrawInitResult copy(SavingGoalView savingGoalView, List<SavingGoalWithdrawMethod> savingGoalWithdrawMethods) {
        Intrinsics.checkNotNullParameter(savingGoalView, "");
        Intrinsics.checkNotNullParameter(savingGoalWithdrawMethods, "");
        return new SavingWithdrawInitResult(savingGoalView, savingGoalWithdrawMethods);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SavingWithdrawInitResult) {
            SavingWithdrawInitResult savingWithdrawInitResult = (SavingWithdrawInitResult) other;
            return Intrinsics.areEqual(this.savingGoalView, savingWithdrawInitResult.savingGoalView) && Intrinsics.areEqual(this.savingGoalWithdrawMethods, savingWithdrawInitResult.savingGoalWithdrawMethods);
        }
        return false;
    }

    public final int hashCode() {
        return (this.savingGoalView.hashCode() * 31) + this.savingGoalWithdrawMethods.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavingWithdrawInitResult(savingGoalView=");
        sb.append(this.savingGoalView);
        sb.append(", savingGoalWithdrawMethods=");
        sb.append(this.savingGoalWithdrawMethods);
        sb.append(')');
        return sb.toString();
    }

    public SavingWithdrawInitResult(SavingGoalView savingGoalView, List<SavingGoalWithdrawMethod> list) {
        Intrinsics.checkNotNullParameter(savingGoalView, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.savingGoalView = savingGoalView;
        this.savingGoalWithdrawMethods = list;
    }

    @JvmName(name = "getSavingGoalView")
    public final SavingGoalView getSavingGoalView() {
        return this.savingGoalView;
    }

    @JvmName(name = "getSavingGoalWithdrawMethods")
    public final List<SavingGoalWithdrawMethod> getSavingGoalWithdrawMethods() {
        return this.savingGoalWithdrawMethods;
    }
}
