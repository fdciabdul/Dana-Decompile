package id.dana.data.sendmoney.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.sendmoney.model.BaseWithdrawInit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b#\u0010$J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJF\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b \u0010\u0004R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010\f"}, d2 = {"Lid/dana/data/sendmoney/repository/source/network/result/WithdrawInitResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/Boolean;", "", "component2", "()Ljava/lang/Integer;", "component3", "", "Lid/dana/data/sendmoney/model/BaseWithdrawInit;", "component4", "()Ljava/util/List;", "enableWithdrawSaveAccount", "maxNumOfAssets", "needSenderName", "withdrawMethodViewList", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;)Lid/dana/data/sendmoney/repository/source/network/result/WithdrawInitResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Boolean;", "getEnableWithdrawSaveAccount", "Ljava/lang/Integer;", "getMaxNumOfAssets", "getNeedSenderName", "Ljava/util/List;", "getWithdrawMethodViewList", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class WithdrawInitResult extends BaseRpcResult {
    private final Boolean enableWithdrawSaveAccount;
    private final Integer maxNumOfAssets;
    private final Boolean needSenderName;
    private final List<BaseWithdrawInit> withdrawMethodViewList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WithdrawInitResult copy$default(WithdrawInitResult withdrawInitResult, Boolean bool, Integer num, Boolean bool2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = withdrawInitResult.enableWithdrawSaveAccount;
        }
        if ((i & 2) != 0) {
            num = withdrawInitResult.maxNumOfAssets;
        }
        if ((i & 4) != 0) {
            bool2 = withdrawInitResult.needSenderName;
        }
        if ((i & 8) != 0) {
            list = withdrawInitResult.withdrawMethodViewList;
        }
        return withdrawInitResult.copy(bool, num, bool2, list);
    }

    /* renamed from: component1  reason: from getter */
    public final Boolean getEnableWithdrawSaveAccount() {
        return this.enableWithdrawSaveAccount;
    }

    /* renamed from: component2  reason: from getter */
    public final Integer getMaxNumOfAssets() {
        return this.maxNumOfAssets;
    }

    /* renamed from: component3  reason: from getter */
    public final Boolean getNeedSenderName() {
        return this.needSenderName;
    }

    public final List<BaseWithdrawInit> component4() {
        return this.withdrawMethodViewList;
    }

    public final WithdrawInitResult copy(Boolean enableWithdrawSaveAccount, Integer maxNumOfAssets, Boolean needSenderName, List<BaseWithdrawInit> withdrawMethodViewList) {
        return new WithdrawInitResult(enableWithdrawSaveAccount, maxNumOfAssets, needSenderName, withdrawMethodViewList);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof WithdrawInitResult) {
            WithdrawInitResult withdrawInitResult = (WithdrawInitResult) other;
            return Intrinsics.areEqual(this.enableWithdrawSaveAccount, withdrawInitResult.enableWithdrawSaveAccount) && Intrinsics.areEqual(this.maxNumOfAssets, withdrawInitResult.maxNumOfAssets) && Intrinsics.areEqual(this.needSenderName, withdrawInitResult.needSenderName) && Intrinsics.areEqual(this.withdrawMethodViewList, withdrawInitResult.withdrawMethodViewList);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.enableWithdrawSaveAccount;
        int hashCode = bool == null ? 0 : bool.hashCode();
        Integer num = this.maxNumOfAssets;
        int hashCode2 = num == null ? 0 : num.hashCode();
        Boolean bool2 = this.needSenderName;
        int hashCode3 = bool2 == null ? 0 : bool2.hashCode();
        List<BaseWithdrawInit> list = this.withdrawMethodViewList;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WithdrawInitResult(enableWithdrawSaveAccount=");
        sb.append(this.enableWithdrawSaveAccount);
        sb.append(", maxNumOfAssets=");
        sb.append(this.maxNumOfAssets);
        sb.append(", needSenderName=");
        sb.append(this.needSenderName);
        sb.append(", withdrawMethodViewList=");
        sb.append(this.withdrawMethodViewList);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getEnableWithdrawSaveAccount")
    public final Boolean getEnableWithdrawSaveAccount() {
        return this.enableWithdrawSaveAccount;
    }

    @JvmName(name = "getMaxNumOfAssets")
    public final Integer getMaxNumOfAssets() {
        return this.maxNumOfAssets;
    }

    @JvmName(name = "getNeedSenderName")
    public final Boolean getNeedSenderName() {
        return this.needSenderName;
    }

    @JvmName(name = "getWithdrawMethodViewList")
    public final List<BaseWithdrawInit> getWithdrawMethodViewList() {
        return this.withdrawMethodViewList;
    }

    public WithdrawInitResult(Boolean bool, Integer num, Boolean bool2, List<BaseWithdrawInit> list) {
        this.enableWithdrawSaveAccount = bool;
        this.maxNumOfAssets = num;
        this.needSenderName = bool2;
        this.withdrawMethodViewList = list;
    }
}
