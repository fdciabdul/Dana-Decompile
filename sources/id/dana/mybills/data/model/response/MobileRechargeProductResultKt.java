package id.dana.mybills.data.model.response;

import id.dana.mybills.domain.model.MobileRechargeProduct;
import id.dana.mybills.domain.model.ProductProviderInfo;
import id.dana.mybills.domain.model.PromoBannerInfo;
import id.dana.mybills.domain.model.ProviderRuleInfo;
import id.dana.mybills.domain.model.ProviderRuleInfoKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a)\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0004*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\t\u001a\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\n*\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000e\u001a\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\n*\b\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\u0004\b\u0011\u0010\u000e"}, d2 = {"Lid/dana/mybills/data/model/response/MobileRechargeProductResult;", "Lid/dana/mybills/domain/model/MobileRechargeProduct;", "toMobileRechargeProduct", "(Lid/dana/mybills/data/model/response/MobileRechargeProductResult;)Lid/dana/mybills/domain/model/MobileRechargeProduct;", "", "", "Lid/dana/mybills/data/model/response/ProductProviderResult;", "Lid/dana/mybills/domain/model/ProductProviderInfo;", "toProductProviderInfos", "(Ljava/util/Map;)Ljava/util/Map;", "", "Lid/dana/mybills/data/model/response/PromoBannerResult;", "Lid/dana/mybills/domain/model/PromoBannerInfo;", "toPromoBannerInfos", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/mybills/data/model/response/ProviderRuleResult;", "Lid/dana/mybills/domain/model/ProviderRuleInfo;", "toProviderRuleInfos"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobileRechargeProductResultKt {
    public static final MobileRechargeProduct toMobileRechargeProduct(MobileRechargeProductResult mobileRechargeProductResult) {
        Intrinsics.checkNotNullParameter(mobileRechargeProductResult, "");
        String mobileNo = mobileRechargeProductResult.getMobileNo();
        Map<String, ProductProviderResult> products = mobileRechargeProductResult.getProducts();
        Map<String, ProductProviderInfo> productProviderInfos = products != null ? toProductProviderInfos(products) : null;
        List<PromoBannerResult> promoBanners = mobileRechargeProductResult.getPromoBanners();
        List<PromoBannerInfo> promoBannerInfos = promoBanners != null ? toPromoBannerInfos(promoBanners) : null;
        List<ProviderRuleResult> providerRules = mobileRechargeProductResult.getProviderRules();
        return new MobileRechargeProduct(mobileNo, productProviderInfos, promoBannerInfos, providerRules != null ? toProviderRuleInfos(providerRules) : null);
    }

    public static final List<ProviderRuleInfo> toProviderRuleInfos(List<ProviderRuleResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<ProviderRuleResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(ProviderRuleInfoKt.toProviderRuleInfo((ProviderRuleResult) it.next()));
        }
        return arrayList;
    }

    public static final List<PromoBannerInfo> toPromoBannerInfos(List<PromoBannerResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<PromoBannerResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(PromoBannerResultKt.toPromoBannerInfo((PromoBannerResult) it.next()));
        }
        return arrayList;
    }

    public static final Map<String, ProductProviderInfo> toProductProviderInfos(Map<String, ProductProviderResult> map) {
        Intrinsics.checkNotNullParameter(map, "");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ProductProviderResultKt.toProductProviderInfo((ProductProviderResult) entry.getValue()));
        }
        return linkedHashMap;
    }
}
