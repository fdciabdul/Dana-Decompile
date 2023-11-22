package id.dana.mybills.domain.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t¢\u0006\u0004\b+\u0010,J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000e\u0010\fJX\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004\"\u0004\b\u001f\u0010 R0\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010\b\"\u0004\b#\u0010$R*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010(R*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010%\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010("}, d2 = {"Lid/dana/mybills/domain/model/MobileRechargeProduct;", "", "", "component1", "()Ljava/lang/String;", "", "Lid/dana/mybills/domain/model/ProductProviderInfo;", "component2", "()Ljava/util/Map;", "", "Lid/dana/mybills/domain/model/PromoBannerInfo;", "component3", "()Ljava/util/List;", "Lid/dana/mybills/domain/model/ProviderRuleInfo;", "component4", "mobileNo", "products", "promoBanners", "providerRules", "copy", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/List;)Lid/dana/mybills/domain/model/MobileRechargeProduct;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getMobileNo", "setMobileNo", "(Ljava/lang/String;)V", "Ljava/util/Map;", "getProducts", "setProducts", "(Ljava/util/Map;)V", "Ljava/util/List;", "getPromoBanners", "setPromoBanners", "(Ljava/util/List;)V", "getProviderRules", "setProviderRules", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MobileRechargeProduct {
    private String mobileNo;
    private Map<String, ProductProviderInfo> products;
    private List<PromoBannerInfo> promoBanners;
    private List<ProviderRuleInfo> providerRules;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MobileRechargeProduct copy$default(MobileRechargeProduct mobileRechargeProduct, String str, Map map, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mobileRechargeProduct.mobileNo;
        }
        if ((i & 2) != 0) {
            map = mobileRechargeProduct.products;
        }
        if ((i & 4) != 0) {
            list = mobileRechargeProduct.promoBanners;
        }
        if ((i & 8) != 0) {
            list2 = mobileRechargeProduct.providerRules;
        }
        return mobileRechargeProduct.copy(str, map, list, list2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMobileNo() {
        return this.mobileNo;
    }

    public final Map<String, ProductProviderInfo> component2() {
        return this.products;
    }

    public final List<PromoBannerInfo> component3() {
        return this.promoBanners;
    }

    public final List<ProviderRuleInfo> component4() {
        return this.providerRules;
    }

    public final MobileRechargeProduct copy(String mobileNo, Map<String, ProductProviderInfo> products, List<PromoBannerInfo> promoBanners, List<ProviderRuleInfo> providerRules) {
        return new MobileRechargeProduct(mobileNo, products, promoBanners, providerRules);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MobileRechargeProduct) {
            MobileRechargeProduct mobileRechargeProduct = (MobileRechargeProduct) other;
            return Intrinsics.areEqual(this.mobileNo, mobileRechargeProduct.mobileNo) && Intrinsics.areEqual(this.products, mobileRechargeProduct.products) && Intrinsics.areEqual(this.promoBanners, mobileRechargeProduct.promoBanners) && Intrinsics.areEqual(this.providerRules, mobileRechargeProduct.providerRules);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.mobileNo;
        int hashCode = str == null ? 0 : str.hashCode();
        Map<String, ProductProviderInfo> map = this.products;
        int hashCode2 = map == null ? 0 : map.hashCode();
        List<PromoBannerInfo> list = this.promoBanners;
        int hashCode3 = list == null ? 0 : list.hashCode();
        List<ProviderRuleInfo> list2 = this.providerRules;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (list2 != null ? list2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MobileRechargeProduct(mobileNo=");
        sb.append(this.mobileNo);
        sb.append(", products=");
        sb.append(this.products);
        sb.append(", promoBanners=");
        sb.append(this.promoBanners);
        sb.append(", providerRules=");
        sb.append(this.providerRules);
        sb.append(')');
        return sb.toString();
    }

    public MobileRechargeProduct(String str, Map<String, ProductProviderInfo> map, List<PromoBannerInfo> list, List<ProviderRuleInfo> list2) {
        this.mobileNo = str;
        this.products = map;
        this.promoBanners = list;
        this.providerRules = list2;
    }

    @JvmName(name = "getMobileNo")
    public final String getMobileNo() {
        return this.mobileNo;
    }

    @JvmName(name = "setMobileNo")
    public final void setMobileNo(String str) {
        this.mobileNo = str;
    }

    public /* synthetic */ MobileRechargeProduct(String str, HashMap hashMap, ArrayList arrayList, ArrayList arrayList2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new HashMap() : hashMap, (i & 4) != 0 ? new ArrayList() : arrayList, (i & 8) != 0 ? new ArrayList() : arrayList2);
    }

    @JvmName(name = "getProducts")
    public final Map<String, ProductProviderInfo> getProducts() {
        return this.products;
    }

    @JvmName(name = "setProducts")
    public final void setProducts(Map<String, ProductProviderInfo> map) {
        this.products = map;
    }

    @JvmName(name = "getPromoBanners")
    public final List<PromoBannerInfo> getPromoBanners() {
        return this.promoBanners;
    }

    @JvmName(name = "setPromoBanners")
    public final void setPromoBanners(List<PromoBannerInfo> list) {
        this.promoBanners = list;
    }

    @JvmName(name = "getProviderRules")
    public final List<ProviderRuleInfo> getProviderRules() {
        return this.providerRules;
    }

    @JvmName(name = "setProviderRules")
    public final void setProviderRules(List<ProviderRuleInfo> list) {
        this.providerRules = list;
    }
}
