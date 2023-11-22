package id.dana.sendmoney.data.api.globalsend.transferSubmit.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.data.constant.UrlParam;
import id.dana.data.model.CurrencyAmountResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/data/api/globalsend/transferSubmit/response/TransferSubmitResultEntity;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "checkoutUrl", "Ljava/lang/String;", "getCheckoutUrl", "()Ljava/lang/String;", "Lid/dana/data/model/CurrencyAmountResult;", "fundAmount", "Lid/dana/data/model/CurrencyAmountResult;", "getFundAmount", "()Lid/dana/data/model/CurrencyAmountResult;", "fundOrderId", "getFundOrderId", "orderTitle", CashierKeyParams.GET_ORDER_TITLE, UrlParam.REQUEST_ID, "getRequestId", "<init>", "(Ljava/lang/String;Lid/dana/data/model/CurrencyAmountResult;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransferSubmitResultEntity extends BaseRpcResult {
    private final String checkoutUrl;
    private final CurrencyAmountResult fundAmount;
    private final String fundOrderId;
    private final String orderTitle;
    private final String requestId;

    @JvmName(name = "getCheckoutUrl")
    public final String getCheckoutUrl() {
        return this.checkoutUrl;
    }

    @JvmName(name = "getFundAmount")
    public final CurrencyAmountResult getFundAmount() {
        return this.fundAmount;
    }

    @JvmName(name = "getFundOrderId")
    public final String getFundOrderId() {
        return this.fundOrderId;
    }

    @JvmName(name = CashierKeyParams.GET_ORDER_TITLE)
    public final String getOrderTitle() {
        return this.orderTitle;
    }

    @JvmName(name = "getRequestId")
    public final String getRequestId() {
        return this.requestId;
    }

    public TransferSubmitResultEntity(String str, CurrencyAmountResult currencyAmountResult, String str2, String str3, String str4) {
        this.checkoutUrl = str;
        this.fundAmount = currencyAmountResult;
        this.fundOrderId = str2;
        this.orderTitle = str3;
        this.requestId = str4;
    }
}
