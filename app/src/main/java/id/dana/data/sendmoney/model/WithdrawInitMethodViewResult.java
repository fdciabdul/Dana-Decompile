package id.dana.data.sendmoney.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ@\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\nR\u001f\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001a\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\n"}, d2 = {"Lid/dana/data/sendmoney/model/WithdrawInitMethodViewResult;", "", "", "Lid/dana/data/sendmoney/model/WithdrawCardOptionViewResult;", "component1", "()Ljava/util/List;", "Lid/dana/data/sendmoney/model/WithdrawInitChannelOptionViewResult;", "component2", "", "component3", "()Ljava/lang/String;", "withdrawCardOptions", "withdrawChannelOptions", "withdrawMethod", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)Lid/dana/data/sendmoney/model/WithdrawInitMethodViewResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/List;", "getWithdrawCardOptions", "getWithdrawChannelOptions", "Ljava/lang/String;", "getWithdrawMethod", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class WithdrawInitMethodViewResult {
    private final List<WithdrawCardOptionViewResult> withdrawCardOptions;
    private final List<WithdrawInitChannelOptionViewResult> withdrawChannelOptions;
    private final String withdrawMethod;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WithdrawInitMethodViewResult copy$default(WithdrawInitMethodViewResult withdrawInitMethodViewResult, List list, List list2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = withdrawInitMethodViewResult.withdrawCardOptions;
        }
        if ((i & 2) != 0) {
            list2 = withdrawInitMethodViewResult.withdrawChannelOptions;
        }
        if ((i & 4) != 0) {
            str = withdrawInitMethodViewResult.withdrawMethod;
        }
        return withdrawInitMethodViewResult.copy(list, list2, str);
    }

    public final List<WithdrawCardOptionViewResult> component1() {
        return this.withdrawCardOptions;
    }

    public final List<WithdrawInitChannelOptionViewResult> component2() {
        return this.withdrawChannelOptions;
    }

    /* renamed from: component3  reason: from getter */
    public final String getWithdrawMethod() {
        return this.withdrawMethod;
    }

    public final WithdrawInitMethodViewResult copy(List<? extends WithdrawCardOptionViewResult> withdrawCardOptions, List<WithdrawInitChannelOptionViewResult> withdrawChannelOptions, String withdrawMethod) {
        return new WithdrawInitMethodViewResult(withdrawCardOptions, withdrawChannelOptions, withdrawMethod);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof WithdrawInitMethodViewResult) {
            WithdrawInitMethodViewResult withdrawInitMethodViewResult = (WithdrawInitMethodViewResult) other;
            return Intrinsics.areEqual(this.withdrawCardOptions, withdrawInitMethodViewResult.withdrawCardOptions) && Intrinsics.areEqual(this.withdrawChannelOptions, withdrawInitMethodViewResult.withdrawChannelOptions) && Intrinsics.areEqual(this.withdrawMethod, withdrawInitMethodViewResult.withdrawMethod);
        }
        return false;
    }

    public final int hashCode() {
        List<WithdrawCardOptionViewResult> list = this.withdrawCardOptions;
        int hashCode = list == null ? 0 : list.hashCode();
        List<WithdrawInitChannelOptionViewResult> list2 = this.withdrawChannelOptions;
        int hashCode2 = list2 == null ? 0 : list2.hashCode();
        String str = this.withdrawMethod;
        return (((hashCode * 31) + hashCode2) * 31) + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WithdrawInitMethodViewResult(withdrawCardOptions=");
        sb.append(this.withdrawCardOptions);
        sb.append(", withdrawChannelOptions=");
        sb.append(this.withdrawChannelOptions);
        sb.append(", withdrawMethod=");
        sb.append(this.withdrawMethod);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WithdrawInitMethodViewResult(List<? extends WithdrawCardOptionViewResult> list, List<WithdrawInitChannelOptionViewResult> list2, String str) {
        this.withdrawCardOptions = list;
        this.withdrawChannelOptions = list2;
        this.withdrawMethod = str;
    }

    @JvmName(name = "getWithdrawCardOptions")
    public final List<WithdrawCardOptionViewResult> getWithdrawCardOptions() {
        return this.withdrawCardOptions;
    }

    @JvmName(name = "getWithdrawChannelOptions")
    public final List<WithdrawInitChannelOptionViewResult> getWithdrawChannelOptions() {
        return this.withdrawChannelOptions;
    }

    @JvmName(name = "getWithdrawMethod")
    public final String getWithdrawMethod() {
        return this.withdrawMethod;
    }
}
