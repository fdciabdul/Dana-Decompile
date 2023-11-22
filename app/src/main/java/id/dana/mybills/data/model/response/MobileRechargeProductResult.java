package id.dana.mybills.data.model.response;

import id.dana.network.base.BaseRpcResultAphome;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BG\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\r¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012"}, d2 = {"Lid/dana/mybills/data/model/response/MobileRechargeProductResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "mobileNo", "Ljava/lang/String;", "getMobileNo", "()Ljava/lang/String;", "", "Lid/dana/mybills/data/model/response/ProductProviderResult;", "products", "Ljava/util/Map;", "getProducts", "()Ljava/util/Map;", "", "Lid/dana/mybills/data/model/response/PromoBannerResult;", "promoBanners", "Ljava/util/List;", "getPromoBanners", "()Ljava/util/List;", "Lid/dana/mybills/data/model/response/ProviderRuleResult;", "providerRules", "getProviderRules", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobileRechargeProductResult extends BaseRpcResultAphome {
    private final String mobileNo;
    private final Map<String, ProductProviderResult> products;
    private final List<PromoBannerResult> promoBanners;
    private final List<ProviderRuleResult> providerRules;

    @JvmName(name = "getMobileNo")
    public final String getMobileNo() {
        return this.mobileNo;
    }

    @JvmName(name = "getProducts")
    public final Map<String, ProductProviderResult> getProducts() {
        return this.products;
    }

    @JvmName(name = "getPromoBanners")
    public final List<PromoBannerResult> getPromoBanners() {
        return this.promoBanners;
    }

    @JvmName(name = "getProviderRules")
    public final List<ProviderRuleResult> getProviderRules() {
        return this.providerRules;
    }

    public MobileRechargeProductResult(String str, Map<String, ProductProviderResult> map, List<PromoBannerResult> list, List<ProviderRuleResult> list2) {
        this.mobileNo = str;
        this.products = map;
        this.promoBanners = list;
        this.providerRules = list2;
    }
}
