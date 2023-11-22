package id.dana.cashier.data.repository.source.network.request;

import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\n\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006"}, d2 = {"Lid/dana/cashier/data/repository/source/network/request/CashierBannerEntityRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "bizType", "Ljava/lang/String;", "getBizType", "()Ljava/lang/String;", CashierKeyParams.CASHIER_ORDER_ID, "getCashierOrderId", "merchantId", "getMerchantId", CashierKeyParams.TOTAL_AMOUNT, "getOrderAmount", "", InvoiceConstant.PAYMENT_METHOD, "Ljava/util/List;", "getPaymentMethod", "()Ljava/util/List;", TinyAppLogUtil.TINY_APP_STANDARD_EXTRA_PLATFORM, "getPlatform", "transType", "getTransType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierBannerEntityRequest extends BaseRpcRequest {
    private final String bizType;
    private final String cashierOrderId;
    private final String merchantId;
    private final String orderAmount;
    private final List<String> paymentMethod;
    private final String platform;
    private final String transType;

    public CashierBannerEntityRequest() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "getPlatform")
    public final String getPlatform() {
        return this.platform;
    }

    @JvmName(name = "getOrderAmount")
    public final String getOrderAmount() {
        return this.orderAmount;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    public /* synthetic */ CashierBannerEntityRequest(String str, String str2, String str3, String str4, List list, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? CollectionsKt.emptyList() : list, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? "" : str6);
    }

    @JvmName(name = "getPaymentMethod")
    public final List<String> getPaymentMethod() {
        return this.paymentMethod;
    }

    @JvmName(name = "getTransType")
    public final String getTransType() {
        return this.transType;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    public CashierBannerEntityRequest(String str, String str2, String str3, String str4, List<String> list, String str5, String str6) {
        this.bizType = str;
        this.platform = str2;
        this.orderAmount = str3;
        this.merchantId = str4;
        this.paymentMethod = list;
        this.transType = str5;
        this.cashierOrderId = str6;
    }
}
