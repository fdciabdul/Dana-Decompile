package id.dana.cashier.data.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/TitleInfoResult;", "", "", "component1", "()Ljava/lang/String;", "component2", "choosePaymentMethod", "confirmPayment", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/data/repository/source/network/result/TitleInfoResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getChoosePaymentMethod", "getConfirmPayment", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TitleInfoResult {
    @SerializedName("choosePaymentMethod")
    private final String choosePaymentMethod;
    private final String confirmPayment;

    public static /* synthetic */ TitleInfoResult copy$default(TitleInfoResult titleInfoResult, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = titleInfoResult.choosePaymentMethod;
        }
        if ((i & 2) != 0) {
            str2 = titleInfoResult.confirmPayment;
        }
        return titleInfoResult.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getChoosePaymentMethod() {
        return this.choosePaymentMethod;
    }

    /* renamed from: component2  reason: from getter */
    public final String getConfirmPayment() {
        return this.confirmPayment;
    }

    public final TitleInfoResult copy(String choosePaymentMethod, String confirmPayment) {
        return new TitleInfoResult(choosePaymentMethod, confirmPayment);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TitleInfoResult) {
            TitleInfoResult titleInfoResult = (TitleInfoResult) other;
            return Intrinsics.areEqual(this.choosePaymentMethod, titleInfoResult.choosePaymentMethod) && Intrinsics.areEqual(this.confirmPayment, titleInfoResult.confirmPayment);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.choosePaymentMethod;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.confirmPayment;
        return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TitleInfoResult(choosePaymentMethod=");
        sb.append(this.choosePaymentMethod);
        sb.append(", confirmPayment=");
        sb.append(this.confirmPayment);
        sb.append(')');
        return sb.toString();
    }

    public TitleInfoResult(String str, String str2) {
        this.choosePaymentMethod = str;
        this.confirmPayment = str2;
    }

    @JvmName(name = "getChoosePaymentMethod")
    public final String getChoosePaymentMethod() {
        return this.choosePaymentMethod;
    }

    @JvmName(name = "getConfirmPayment")
    public final String getConfirmPayment() {
        return this.confirmPayment;
    }
}
