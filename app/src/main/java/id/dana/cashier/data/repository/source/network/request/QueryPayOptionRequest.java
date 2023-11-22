package id.dana.cashier.data.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import id.dana.cashier.utils.CashierKeyParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/cashier/data/repository/source/network/request/QueryPayOptionRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", CashierKeyParams.CASHIER_ORDER_ID, "Ljava/lang/String;", "getCashierOrderId", "()Ljava/lang/String;", "", "disablePayMethod", "Ljava/util/List;", "getDisablePayMethod", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QueryPayOptionRequest extends BaseRpcRequest {
    @SerializedName(CashierKeyParams.CASHIER_ORDER_ID)
    private final String cashierOrderId;
    private final List<String> disablePayMethod;

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getDisablePayMethod")
    public final List<String> getDisablePayMethod() {
        return this.disablePayMethod;
    }

    public QueryPayOptionRequest(String str, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "");
        this.cashierOrderId = str;
        this.disablePayMethod = list;
    }
}
