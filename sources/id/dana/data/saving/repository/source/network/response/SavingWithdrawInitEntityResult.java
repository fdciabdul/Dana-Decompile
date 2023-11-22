package id.dana.data.saving.repository.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.saving.model.SavingView;
import id.dana.data.saving.model.WithdrawMethodView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\n\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005"}, d2 = {"Lid/dana/data/saving/repository/source/network/response/SavingWithdrawInitEntityResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/data/saving/model/WithdrawMethodView;", "component1", "()Ljava/util/List;", "Lid/dana/data/saving/model/SavingView;", "component2", "()Lid/dana/data/saving/model/SavingView;", "withdrawMethodViews", "savingView", "copy", "(Ljava/util/List;Lid/dana/data/saving/model/SavingView;)Lid/dana/data/saving/repository/source/network/response/SavingWithdrawInitEntityResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/data/saving/model/SavingView;", "getSavingView", "Ljava/util/List;", "getWithdrawMethodViews", "<init>", "(Ljava/util/List;Lid/dana/data/saving/model/SavingView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SavingWithdrawInitEntityResult extends BaseRpcResult {
    private final SavingView savingView;
    private final List<WithdrawMethodView> withdrawMethodViews;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SavingWithdrawInitEntityResult copy$default(SavingWithdrawInitEntityResult savingWithdrawInitEntityResult, List list, SavingView savingView, int i, Object obj) {
        if ((i & 1) != 0) {
            list = savingWithdrawInitEntityResult.withdrawMethodViews;
        }
        if ((i & 2) != 0) {
            savingView = savingWithdrawInitEntityResult.savingView;
        }
        return savingWithdrawInitEntityResult.copy(list, savingView);
    }

    public final List<WithdrawMethodView> component1() {
        return this.withdrawMethodViews;
    }

    /* renamed from: component2  reason: from getter */
    public final SavingView getSavingView() {
        return this.savingView;
    }

    public final SavingWithdrawInitEntityResult copy(List<WithdrawMethodView> withdrawMethodViews, SavingView savingView) {
        Intrinsics.checkNotNullParameter(withdrawMethodViews, "");
        Intrinsics.checkNotNullParameter(savingView, "");
        return new SavingWithdrawInitEntityResult(withdrawMethodViews, savingView);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SavingWithdrawInitEntityResult) {
            SavingWithdrawInitEntityResult savingWithdrawInitEntityResult = (SavingWithdrawInitEntityResult) other;
            return Intrinsics.areEqual(this.withdrawMethodViews, savingWithdrawInitEntityResult.withdrawMethodViews) && Intrinsics.areEqual(this.savingView, savingWithdrawInitEntityResult.savingView);
        }
        return false;
    }

    public final int hashCode() {
        return (this.withdrawMethodViews.hashCode() * 31) + this.savingView.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavingWithdrawInitEntityResult(withdrawMethodViews=");
        sb.append(this.withdrawMethodViews);
        sb.append(", savingView=");
        sb.append(this.savingView);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getWithdrawMethodViews")
    public final List<WithdrawMethodView> getWithdrawMethodViews() {
        return this.withdrawMethodViews;
    }

    @JvmName(name = "getSavingView")
    public final SavingView getSavingView() {
        return this.savingView;
    }

    public SavingWithdrawInitEntityResult(List<WithdrawMethodView> list, SavingView savingView) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(savingView, "");
        this.withdrawMethodViews = list;
        this.savingView = savingView;
    }
}
