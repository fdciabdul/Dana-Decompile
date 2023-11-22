package id.dana.cashier.domain.model;

import id.dana.cashier.utils.CashierKeyParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/cashier/domain/model/QueryPayOptionInfoRequest;", "", "", CashierKeyParams.CASHIER_ORDER_ID, "Ljava/lang/String;", "getCashierOrderId", "()Ljava/lang/String;", "setCashierOrderId", "(Ljava/lang/String;)V", "", "disablePayMethod", "Ljava/util/List;", "getDisablePayMethod", "()Ljava/util/List;", "setDisablePayMethod", "(Ljava/util/List;)V", "<init>", "(Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QueryPayOptionInfoRequest {
    private String cashierOrderId;
    private List<String> disablePayMethod;

    public QueryPayOptionInfoRequest(String str, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "");
        this.cashierOrderId = str;
        this.disablePayMethod = list;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "setCashierOrderId")
    public final void setCashierOrderId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.cashierOrderId = str;
    }

    @JvmName(name = "getDisablePayMethod")
    public final List<String> getDisablePayMethod() {
        return this.disablePayMethod;
    }

    @JvmName(name = "setDisablePayMethod")
    public final void setDisablePayMethod(List<String> list) {
        this.disablePayMethod = list;
    }
}
