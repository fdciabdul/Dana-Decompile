package id.dana.network.response.expresspurchase;

import id.dana.network.base.BaseRpcResultAphome;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/network/response/expresspurchase/ValidateProductGoldResponse;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "aggregatorGoodsId", "Ljava/lang/String;", "getAggregatorGoodsId", "()Ljava/lang/String;", "Lid/dana/network/response/expresspurchase/ProductValidateStatusInfoResponse;", "productValidateStatusInfo", "Lid/dana/network/response/expresspurchase/ProductValidateStatusInfoResponse;", "getProductValidateStatusInfo", "()Lid/dana/network/response/expresspurchase/ProductValidateStatusInfoResponse;", "", "", "validationInfo", "Ljava/util/Map;", "getValidationInfo", "()Ljava/util/Map;", "", "validationTypes", "Ljava/util/List;", "getValidationTypes", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Lid/dana/network/response/expresspurchase/ProductValidateStatusInfoResponse;Ljava/util/List;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ValidateProductGoldResponse extends BaseRpcResultAphome {
    private final String aggregatorGoodsId;
    private final ProductValidateStatusInfoResponse productValidateStatusInfo;
    private final Map<String, Object> validationInfo;
    private final List<String> validationTypes;

    @JvmName(name = "getAggregatorGoodsId")
    public final String getAggregatorGoodsId() {
        return this.aggregatorGoodsId;
    }

    @JvmName(name = "getProductValidateStatusInfo")
    public final ProductValidateStatusInfoResponse getProductValidateStatusInfo() {
        return this.productValidateStatusInfo;
    }

    @JvmName(name = "getValidationTypes")
    public final List<String> getValidationTypes() {
        return this.validationTypes;
    }

    @JvmName(name = "getValidationInfo")
    public final Map<String, Object> getValidationInfo() {
        return this.validationInfo;
    }

    public ValidateProductGoldResponse(String str, ProductValidateStatusInfoResponse productValidateStatusInfoResponse, List<String> list, Map<String, ? extends Object> map) {
        this.aggregatorGoodsId = str;
        this.productValidateStatusInfo = productValidateStatusInfoResponse;
        this.validationTypes = list;
        this.validationInfo = map;
    }
}
