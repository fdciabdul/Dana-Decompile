package id.dana.data.cancelsurvey.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.cashier.utils.CashierKeyParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/data/cancelsurvey/repository/source/network/request/SurveyCancelReasonConsultRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", CashierKeyParams.CASHIER_ORDER_ID, "Ljava/lang/String;", "getCashierOrderId", "()Ljava/lang/String;", "goodsId", "getGoodsId", "scenario", "getScenario", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SurveyCancelReasonConsultRequest extends BaseRpcRequest {
    private final String cashierOrderId;
    private final String goodsId;
    private final String scenario;

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getScenario")
    public final String getScenario() {
        return this.scenario;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    public SurveyCancelReasonConsultRequest(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        this.cashierOrderId = str;
        this.scenario = str2;
        this.goodsId = str3;
    }
}
