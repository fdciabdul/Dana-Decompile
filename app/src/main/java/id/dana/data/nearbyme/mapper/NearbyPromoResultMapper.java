package id.dana.data.nearbyme.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.nearbyme.model.NearbyPromoResult;
import id.dana.data.nearbyme.model.PromoInfoEntity;
import id.dana.data.nearbyme.repository.source.network.result.NearbyShopsPromoResult;
import id.dana.domain.nearbyme.model.NearbyShopsPromo;
import id.dana.domain.nearbyme.model.PromoInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\nJ%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0007\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/data/nearbyme/mapper/NearbyPromoResultMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/data/nearbyme/repository/source/network/result/NearbyShopsPromoResult;", "", "Lid/dana/domain/nearbyme/model/NearbyShopsPromo;", "Lid/dana/data/nearbyme/model/NearbyPromoResult;", "nearbyPromoResult", "map", "(Lid/dana/data/nearbyme/model/NearbyPromoResult;)Lid/dana/domain/nearbyme/model/NearbyShopsPromo;", "oldItem", "(Lid/dana/data/nearbyme/repository/source/network/result/NearbyShopsPromoResult;)Ljava/util/List;", "", "Lid/dana/data/nearbyme/model/PromoInfoEntity;", "entities", "Lid/dana/domain/nearbyme/model/PromoInfo;", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/data/nearbyme/mapper/PromoInfoEntityMapper;", "promoInfoEntityMapper", "Lid/dana/data/nearbyme/mapper/PromoInfoEntityMapper;", "<init>", "(Lid/dana/data/nearbyme/mapper/PromoInfoEntityMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public class NearbyPromoResultMapper extends BaseMapper<NearbyShopsPromoResult, List<NearbyShopsPromo>> {
    private final PromoInfoEntityMapper promoInfoEntityMapper;

    @Inject
    public NearbyPromoResultMapper(PromoInfoEntityMapper promoInfoEntityMapper) {
        Intrinsics.checkNotNullParameter(promoInfoEntityMapper, "");
        this.promoInfoEntityMapper = promoInfoEntityMapper;
    }

    @Override // id.dana.data.base.BaseMapper
    public List<NearbyShopsPromo> map(NearbyShopsPromoResult oldItem) {
        ArrayList arrayList = new ArrayList();
        if (oldItem != null) {
            List<NearbyPromoResult> shops = oldItem.getShops();
            if (!(shops == null || shops.isEmpty())) {
                List<NearbyPromoResult> shops2 = oldItem.getShops();
                Intrinsics.checkNotNullExpressionValue(shops2, "");
                List<NearbyPromoResult> list = shops2;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (NearbyPromoResult nearbyPromoResult : list) {
                    Intrinsics.checkNotNullExpressionValue(nearbyPromoResult, "");
                    arrayList2.add(Boolean.valueOf(arrayList.add(map(nearbyPromoResult))));
                }
            }
        }
        return arrayList;
    }

    protected final NearbyShopsPromo map(NearbyPromoResult nearbyPromoResult) {
        Intrinsics.checkNotNullParameter(nearbyPromoResult, "");
        NearbyShopsPromo nearbyShopsPromo = new NearbyShopsPromo(null, null, null, 7, null);
        nearbyShopsPromo.setMerchantId(nearbyPromoResult.getMerchantId());
        nearbyShopsPromo.setShopId(nearbyPromoResult.getShopId());
        nearbyShopsPromo.setPromoInfos(map((List<? extends PromoInfoEntity>) nearbyPromoResult.getPromoInfos()));
        return nearbyShopsPromo;
    }

    private final List<PromoInfo> map(List<? extends PromoInfoEntity> entities) {
        ArrayList arrayList = new ArrayList();
        if (entities != null) {
            List<? extends PromoInfoEntity> list = entities;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Boolean.valueOf(arrayList.add(this.promoInfoEntityMapper.map((PromoInfoEntity) it.next()))));
            }
        }
        return arrayList;
    }
}
