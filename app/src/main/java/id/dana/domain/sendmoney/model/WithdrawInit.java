package id.dana.domain.sendmoney.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\"\u0010#J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJF\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001f\u0010\u0004R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\f"}, d2 = {"Lid/dana/domain/sendmoney/model/WithdrawInit;", "", "", "component1", "()Ljava/lang/Boolean;", "", "component2", "()Ljava/lang/Integer;", "component3", "", "Lid/dana/domain/sendmoney/model/WithdrawInitBase;", "component4", "()Ljava/util/List;", "enableWithdrawSaveAccount", "maxNumOfAssets", "needSenderName", "withdrawMethodViewList", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;)Lid/dana/domain/sendmoney/model/WithdrawInit;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Boolean;", "getEnableWithdrawSaveAccount", "Ljava/lang/Integer;", "getMaxNumOfAssets", "getNeedSenderName", "Ljava/util/List;", "getWithdrawMethodViewList", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class WithdrawInit {
    private final Boolean enableWithdrawSaveAccount;
    private final Integer maxNumOfAssets;
    private final Boolean needSenderName;
    private final List<WithdrawInitBase> withdrawMethodViewList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WithdrawInit copy$default(WithdrawInit withdrawInit, Boolean bool, Integer num, Boolean bool2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = withdrawInit.enableWithdrawSaveAccount;
        }
        if ((i & 2) != 0) {
            num = withdrawInit.maxNumOfAssets;
        }
        if ((i & 4) != 0) {
            bool2 = withdrawInit.needSenderName;
        }
        if ((i & 8) != 0) {
            list = withdrawInit.withdrawMethodViewList;
        }
        return withdrawInit.copy(bool, num, bool2, list);
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

    public final List<WithdrawInitBase> component4() {
        return this.withdrawMethodViewList;
    }

    public final WithdrawInit copy(Boolean enableWithdrawSaveAccount, Integer maxNumOfAssets, Boolean needSenderName, List<WithdrawInitBase> withdrawMethodViewList) {
        return new WithdrawInit(enableWithdrawSaveAccount, maxNumOfAssets, needSenderName, withdrawMethodViewList);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof WithdrawInit) {
            WithdrawInit withdrawInit = (WithdrawInit) other;
            return Intrinsics.areEqual(this.enableWithdrawSaveAccount, withdrawInit.enableWithdrawSaveAccount) && Intrinsics.areEqual(this.maxNumOfAssets, withdrawInit.maxNumOfAssets) && Intrinsics.areEqual(this.needSenderName, withdrawInit.needSenderName) && Intrinsics.areEqual(this.withdrawMethodViewList, withdrawInit.withdrawMethodViewList);
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
        List<WithdrawInitBase> list = this.withdrawMethodViewList;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WithdrawInit(enableWithdrawSaveAccount=");
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

    public WithdrawInit(Boolean bool, Integer num, Boolean bool2, List<WithdrawInitBase> list) {
        this.enableWithdrawSaveAccount = bool;
        this.maxNumOfAssets = num;
        this.needSenderName = bool2;
        this.withdrawMethodViewList = list;
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
    public final List<WithdrawInitBase> getWithdrawMethodViewList() {
        return this.withdrawMethodViewList;
    }
}
