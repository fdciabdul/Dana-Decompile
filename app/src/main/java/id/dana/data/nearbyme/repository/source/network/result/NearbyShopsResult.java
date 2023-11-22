package id.dana.data.nearbyme.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.nearbyme.model.ShopEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

/* loaded from: classes4.dex */
public class NearbyShopsResult extends BaseRpcResult {
    private static final List<String> SENSITIVE_EXTINFO_KEYS;
    private boolean hasMore;
    private boolean promoFlag;
    private List<ShopEntity> shops;

    static {
        ArrayList arrayList = new ArrayList();
        SENSITIVE_EXTINFO_KEYS = arrayList;
        arrayList.add("ktpNumber");
        arrayList.add("ownerEmail");
        arrayList.add("ktpName");
    }

    public List<ShopEntity> getShops() {
        return this.shops;
    }

    public void setShops(List<ShopEntity> list) {
        if (list == null) {
            return;
        }
        this.shops = CollectionsKt.map(list, new Function1() { // from class: id.dana.data.nearbyme.repository.source.network.result.NearbyShopsResult$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NearbyShopsResult.lambda$setShops$1((ShopEntity) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ShopEntity lambda$setShops$1(ShopEntity shopEntity) {
        if (shopEntity.getExtInfo() != null) {
            shopEntity.setExtInfo(MapsKt.filterKeys(shopEntity.getExtInfo(), new Function1() { // from class: id.dana.data.nearbyme.repository.source.network.result.NearbyShopsResult$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Boolean valueOf;
                    String str = (String) obj;
                    valueOf = Boolean.valueOf((boolean) (!NearbyShopsResult.SENSITIVE_EXTINFO_KEYS.contains(str)));
                    return valueOf;
                }
            }));
        }
        return shopEntity;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public boolean promoFlag() {
        return this.promoFlag;
    }

    public void setPromoFlag(boolean z) {
        this.promoFlag = z;
    }
}
