package id.dana.data.nearbyme.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.nearbyme.repository.source.network.request.NearbyPromoShopEntity;
import id.dana.domain.nearbyme.model.MerchantInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\n"}, d2 = {"Lid/dana/data/nearbyme/mapper/MerchantInfoMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/domain/nearbyme/model/MerchantInfo;", "", "Lid/dana/data/nearbyme/repository/source/network/request/NearbyPromoShopEntity;", "merchantInfo", "map", "(Lid/dana/domain/nearbyme/model/MerchantInfo;)Lid/dana/data/nearbyme/repository/source/network/request/NearbyPromoShopEntity;", "oldItem", "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MerchantInfoMapper extends BaseMapper<List<? extends MerchantInfo>, List<NearbyPromoShopEntity>> {
    @Override // id.dana.data.base.BaseMapper
    public final /* bridge */ /* synthetic */ List<NearbyPromoShopEntity> map(List<? extends MerchantInfo> list) {
        return map2((List<MerchantInfo>) list);
    }

    @Inject
    public MerchantInfoMapper() {
    }

    /* renamed from: map  reason: avoid collision after fix types in other method */
    public final List<NearbyPromoShopEntity> map2(List<MerchantInfo> oldItem) {
        ArrayList arrayList = new ArrayList();
        if (oldItem != null) {
            List<MerchantInfo> list = oldItem;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Boolean.valueOf(arrayList.add(map((MerchantInfo) it.next()))));
            }
        }
        return arrayList;
    }

    private final NearbyPromoShopEntity map(MerchantInfo merchantInfo) {
        NearbyPromoShopEntity nearbyPromoShopEntity = new NearbyPromoShopEntity();
        nearbyPromoShopEntity.merchantId = merchantInfo.getMerchantId();
        nearbyPromoShopEntity.shopId = merchantInfo.getShopId();
        return nearbyPromoShopEntity;
    }
}
