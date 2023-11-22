package id.dana.data.expresspurchase.source.network.pojo.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import id.dana.cashier.utils.CashierKeyParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/data/expresspurchase/source/network/pojo/request/GetExpressPurchaseRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "addonId", "Ljava/lang/String;", "getAddonId", "()Ljava/lang/String;", "addonLogicType", "getAddonLogicType", CashierKeyParams.CASHIER_ORDER_ID, "getCashierOrderId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetExpressPurchaseRequest extends BaseRpcRequest {
    @SerializedName("addonId")
    private final String addonId;
    private final String addonLogicType;
    private final String cashierOrderId;

    @JvmName(name = "getAddonId")
    public final String getAddonId() {
        return this.addonId;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getAddonLogicType")
    public final String getAddonLogicType() {
        return this.addonLogicType;
    }

    public GetExpressPurchaseRequest(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.addonId = str;
        this.cashierOrderId = str2;
        this.addonLogicType = str3;
    }
}
