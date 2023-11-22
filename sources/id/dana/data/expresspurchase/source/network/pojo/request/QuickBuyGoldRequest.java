package id.dana.data.expresspurchase.source.network.pojo.request;

import com.alipay.iap.android.aplog.rpc.BaseRpcRequest;
import com.iap.ac.android.acs.plugin.utils.Constants;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.data.constant.UrlParam;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\f\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0016\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006"}, d2 = {"Lid/dana/data/expresspurchase/source/network/pojo/request/QuickBuyGoldRequest;", "Lcom/alipay/iap/android/aplog/rpc/BaseRpcRequest;", "", "aggregatorGoodsId", "Ljava/lang/String;", "getAggregatorGoodsId", "()Ljava/lang/String;", "authCode", Constants.JS_API_GET_AUTH_CODE, CashierKeyParams.CASHIER_ORDER_ID, "getCashierOrderId", "epTemplateType", "getEpTemplateType", "", "extendInfo", "Ljava/util/Map;", "getExtendInfo", "()Ljava/util/Map;", "goodsId", "getGoodsId", UrlParam.REQUEST_ID, "getRequestId", "thirdRefId", "getThirdRefId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QuickBuyGoldRequest extends BaseRpcRequest {
    private final String aggregatorGoodsId;
    private final String authCode;
    private final String cashierOrderId;
    private final String epTemplateType;
    private final Map<String, String> extendInfo;
    private final String goodsId;
    private final String requestId;
    private final String thirdRefId;

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getRequestId")
    public final String getRequestId() {
        return this.requestId;
    }

    @JvmName(name = "getAggregatorGoodsId")
    public final String getAggregatorGoodsId() {
        return this.aggregatorGoodsId;
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getEpTemplateType")
    public final String getEpTemplateType() {
        return this.epTemplateType;
    }

    @JvmName(name = "getThirdRefId")
    public final String getThirdRefId() {
        return this.thirdRefId;
    }

    @JvmName(name = Constants.JS_API_GET_AUTH_CODE)
    public final String getAuthCode() {
        return this.authCode;
    }

    public QuickBuyGoldRequest(String str, String str2, String str3, Map<String, String> map, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        this.goodsId = str;
        this.requestId = str2;
        this.aggregatorGoodsId = str3;
        this.extendInfo = map;
        this.cashierOrderId = str4;
        this.epTemplateType = str5;
        this.thirdRefId = str6;
        this.authCode = str7;
    }
}
