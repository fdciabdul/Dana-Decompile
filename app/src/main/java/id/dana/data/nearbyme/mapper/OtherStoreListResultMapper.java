package id.dana.data.nearbyme.mapper;

import android.location.Location;
import id.dana.data.base.BaseMapper;
import id.dana.data.nearbyme.model.ShopEntity;
import id.dana.data.nearbyme.repository.source.network.result.NearbyQueryOtherShopListResult;
import id.dana.domain.nearbyme.model.OtherStoreListResult;
import id.dana.domain.nearbyme.model.Shop;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u001f\u0010 J'\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001e"}, d2 = {"Lid/dana/data/nearbyme/mapper/OtherStoreListResultMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/data/nearbyme/repository/source/network/result/NearbyQueryOtherShopListResult;", "Lid/dana/domain/nearbyme/model/OtherStoreListResult;", "", "currentLat", "currentLong", "sourceItem", "apply", "(DDLid/dana/data/nearbyme/repository/source/network/result/NearbyQueryOtherShopListResult;)Lid/dana/domain/nearbyme/model/OtherStoreListResult;", "Lid/dana/domain/nearbyme/model/Shop;", "shop", "Landroid/location/Location;", "markerLocation", "getDistanceBetweenShopAndMarkerPosition", "(Lid/dana/domain/nearbyme/model/Shop;Landroid/location/Location;)D", "distance", "getDistanceInKM", "(D)D", "oldItem", "map", "(Lid/dana/data/nearbyme/repository/source/network/result/NearbyQueryOtherShopListResult;)Lid/dana/domain/nearbyme/model/OtherStoreListResult;", "", "Lid/dana/data/nearbyme/model/ShopEntity;", "shopEntityList", "transformShopEntityListToShopList", "(Ljava/util/List;)Ljava/util/List;", "", "METER_TO_KM_DIVIDER", "I", SummaryActivity.DAYS, "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OtherStoreListResultMapper extends BaseMapper<NearbyQueryOtherShopListResult, OtherStoreListResult> {
    private final int METER_TO_KM_DIVIDER = 1000;
    private double currentLat;
    private double currentLong;

    @Inject
    public OtherStoreListResultMapper() {
    }

    public final OtherStoreListResult apply(double currentLat, double currentLong, NearbyQueryOtherShopListResult sourceItem) {
        this.currentLat = currentLat;
        this.currentLong = currentLong;
        Object apply = super.apply(sourceItem);
        Intrinsics.checkNotNullExpressionValue(apply, "");
        return (OtherStoreListResult) apply;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public final OtherStoreListResult map(NearbyQueryOtherShopListResult oldItem) {
        Intrinsics.checkNotNullParameter(oldItem, "");
        return new OtherStoreListResult(transformShopEntityListToShopList(oldItem.getShops()), oldItem.getHasMore(), oldItem.getPromoFlag());
    }

    private final List<Shop> transformShopEntityListToShopList(List<? extends ShopEntity> shopEntityList) {
        List<? extends ShopEntity> list = shopEntityList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ShopEntity) it.next()).toShop());
        }
        ArrayList<Shop> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (Shop shop : arrayList2) {
            Intrinsics.checkNotNullExpressionValue(shop, "");
            Location location = new Location("");
            location.setLatitude(this.currentLat);
            location.setLongitude(this.currentLong);
            Unit unit = Unit.INSTANCE;
            shop.setDistance(getDistanceBetweenShopAndMarkerPosition(shop, location));
            arrayList3.add(shop);
        }
        return arrayList3;
    }

    private final double getDistanceBetweenShopAndMarkerPosition(Shop shop, Location markerLocation) {
        Location location = new Location("");
        location.setLatitude(shop.getLatitude());
        location.setLongitude(shop.getLongtitude());
        return getDistanceInKM(markerLocation.distanceTo(location));
    }

    private final double getDistanceInKM(double distance) {
        double d = this.METER_TO_KM_DIVIDER;
        Double.isNaN(d);
        return distance / d;
    }
}
