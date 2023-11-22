package id.dana.data.nearbyme.mapper;

import android.location.Location;
import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.data.base.BaseMapper;
import id.dana.data.merchant.mapper.MerchantSubcategoryMapper;
import id.dana.data.merchant.model.MerchantSubcategoryEntity;
import id.dana.data.nearbyme.model.ContactAddressEntity;
import id.dana.data.nearbyme.model.PromoInfoEntity;
import id.dana.data.nearbyme.model.ShopEntity;
import id.dana.data.nearbyme.model.ShopOpenHourEntity;
import id.dana.data.nearbyme.repository.source.network.result.NearbyShopsResult;
import id.dana.domain.nearbyme.model.ContactAddress;
import id.dana.domain.nearbyme.model.PromoInfo;
import id.dana.domain.nearbyme.model.Shop;
import id.dana.domain.nearbyme.model.ShopOpenHour;
import id.dana.domain.nearbyme.model.ShopsPage;
import id.dana.domain.util.LocationUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 X2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001XB\u0019\b\u0007\u0012\u0006\u0010T\u001a\u00020S\u0012\u0006\u0010Q\u001a\u00020P¢\u0006\u0004\bV\u0010WJ)\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010#\u001a\u00020\u001d2\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!\u0018\u00010 ¢\u0006\u0004\b#\u0010$J#\u0010&\u001a\u00020\u001d2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0018\u0018\u00010 ¢\u0006\u0004\b&\u0010$J\u0015\u0010)\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J#\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0004\b.\u0010/J\u0019\u00103\u001a\u0002022\b\u00101\u001a\u0004\u0018\u000100H\u0002¢\u0006\u0004\b3\u00104J%\u00106\u001a\b\u0012\u0004\u0012\u0002020,2\u000e\u00105\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010\u0017H\u0002¢\u0006\u0004\b6\u0010/J\u001b\u00108\u001a\u0004\u0018\u00010!2\b\u00107\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0004\b8\u00109J%\u0010=\u001a\b\u0012\u0004\u0012\u00020<0,2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010\u0017H\u0002¢\u0006\u0004\b=\u0010/J\u0017\u0010>\u001a\u00020-2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b>\u0010?J\u0019\u0010C\u001a\u00020B2\b\u0010A\u001a\u0004\u0018\u00010@H\u0002¢\u0006\u0004\bC\u0010DJ%\u0010F\u001a\b\u0012\u0004\u0012\u00020B0,2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u0017H\u0002¢\u0006\u0004\bF\u0010/R(\u0010H\u001a\u0004\u0018\u00010\f2\b\u0010G\u001a\u0004\u0018\u00010\f8\u0007@BX\u0086\u000e¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b(\u0010LR$\u0010M\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0018\u0018\u00010 8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bM\u0010NR$\u0010O\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bO\u0010NR\u0014\u0010Q\u001a\u00020P8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020S8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bT\u0010U"}, d2 = {"Lid/dana/data/nearbyme/mapper/NearbyShopsResultMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/data/nearbyme/repository/source/network/result/NearbyShopsResult;", "Lid/dana/domain/nearbyme/model/ShopsPage;", "", "currentLat", "currentLon", "oldItem", "apply", "(DDLid/dana/data/nearbyme/repository/source/network/result/NearbyShopsResult;)Lid/dana/domain/nearbyme/model/ShopsPage;", "Lid/dana/data/nearbyme/model/ShopEntity;", "shopEntity", "Landroid/location/Location;", "markerLocation", "getDistanceBetweenShopAndMarkerPosition", "(Lid/dana/data/nearbyme/model/ShopEntity;Landroid/location/Location;)D", "distance", "getDistanceInKM", "(D)D", "latitude", "longitude", "getLocation", "(DD)Landroid/location/Location;", "", "Lid/dana/data/merchant/model/MerchantSubcategoryEntity;", "getSubCategory", "(Lid/dana/data/nearbyme/model/ShopEntity;)Ljava/util/List;", "map", "(Lid/dana/data/nearbyme/repository/source/network/result/NearbyShopsResult;)Lid/dana/domain/nearbyme/model/ShopsPage;", "", "setCurrentMarkerLocation", "(DD)V", "", "", "merchantTopUpMap", "setMerchantInstId", "(Ljava/util/Map;)V", "merchantCategoryMap", "setMerchantSubcategory", "", "isUsingNewMerchantCategories", "setUsingNewMerchantCategories", "(Z)V", "shopEntities", "", "Lid/dana/domain/nearbyme/model/Shop;", "transform", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/data/nearbyme/model/ContactAddressEntity;", "contactAddressEntity", "Lid/dana/domain/nearbyme/model/ContactAddress;", "transformContactAddress", "(Lid/dana/data/nearbyme/model/ContactAddressEntity;)Lid/dana/domain/nearbyme/model/ContactAddress;", "contactAddressEntities", "transformContactAddressEntities", "merchantId", "transformMerchantId", "(Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/data/nearbyme/model/PromoInfoEntity;", "promoInfoEntities", "Lid/dana/domain/nearbyme/model/PromoInfo;", "transformPromoInfoEntities", "transformShopEntity", "(Lid/dana/data/nearbyme/model/ShopEntity;)Lid/dana/domain/nearbyme/model/Shop;", "Lid/dana/data/nearbyme/model/ShopOpenHourEntity;", "shopOpenHourEntity", "Lid/dana/domain/nearbyme/model/ShopOpenHour;", "transformShopOpenHour", "(Lid/dana/data/nearbyme/model/ShopOpenHourEntity;)Lid/dana/domain/nearbyme/model/ShopOpenHour;", "shopOpenHourEntities", "transformShopOpenHourEntities", "p0", "currentMarkerLocation", "Landroid/location/Location;", "getCurrentMarkerLocation", "()Landroid/location/Location;", "Z", "merchantSubcategoriesMap", "Ljava/util/Map;", "merchantTopUpEntityMap", "Lid/dana/data/nearbyme/mapper/PromoInfoEntityMapper;", "promoInfoEntityMapper", "Lid/dana/data/nearbyme/mapper/PromoInfoEntityMapper;", "Lid/dana/data/merchant/mapper/MerchantSubcategoryMapper;", "subcategoryMapper", "Lid/dana/data/merchant/mapper/MerchantSubcategoryMapper;", "<init>", "(Lid/dana/data/merchant/mapper/MerchantSubcategoryMapper;Lid/dana/data/nearbyme/mapper/PromoInfoEntityMapper;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NearbyShopsResultMapper extends BaseMapper<NearbyShopsResult, ShopsPage> {
    private static final int METER_TO_KM_DIVIDER = 1000;
    private Location currentMarkerLocation;
    private boolean isUsingNewMerchantCategories;
    private Map<String, ? extends MerchantSubcategoryEntity> merchantSubcategoriesMap;
    private Map<String, String> merchantTopUpEntityMap;
    private final PromoInfoEntityMapper promoInfoEntityMapper;
    private final MerchantSubcategoryMapper subcategoryMapper;

    private final double getDistanceInKM(double distance) {
        return distance / 1000.0d;
    }

    @Inject
    public NearbyShopsResultMapper(MerchantSubcategoryMapper merchantSubcategoryMapper, PromoInfoEntityMapper promoInfoEntityMapper) {
        Intrinsics.checkNotNullParameter(merchantSubcategoryMapper, "");
        Intrinsics.checkNotNullParameter(promoInfoEntityMapper, "");
        this.subcategoryMapper = merchantSubcategoryMapper;
        this.promoInfoEntityMapper = promoInfoEntityMapper;
    }

    @JvmName(name = "getCurrentMarkerLocation")
    public final Location getCurrentMarkerLocation() {
        return this.currentMarkerLocation;
    }

    public final void setMerchantSubcategory(Map<String, ? extends MerchantSubcategoryEntity> merchantCategoryMap) {
        this.merchantSubcategoriesMap = merchantCategoryMap;
    }

    public final void setMerchantInstId(Map<String, String> merchantTopUpMap) {
        this.merchantTopUpEntityMap = merchantTopUpMap;
    }

    public final void setCurrentMarkerLocation(double currentLat, double currentLon) {
        this.currentMarkerLocation = getLocation(currentLat, currentLon);
    }

    public final void setUsingNewMerchantCategories(boolean isUsingNewMerchantCategories) {
        this.isUsingNewMerchantCategories = isUsingNewMerchantCategories;
    }

    private final Location getLocation(double latitude, double longitude) {
        return LocationUtil.latLonToLocation(latitude, longitude);
    }

    public final ShopsPage apply(double currentLat, double currentLon, NearbyShopsResult oldItem) {
        this.currentMarkerLocation = getLocation(currentLat, currentLon);
        return apply(oldItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public final ShopsPage map(NearbyShopsResult oldItem) {
        if (oldItem != null) {
            return new ShopsPage(oldItem.hasMore(), transform(oldItem.getShops()), oldItem.promoFlag());
        }
        return ShopsPage.INSTANCE.empty();
    }

    public final List<Shop> transform(List<? extends ShopEntity> shopEntities) {
        ArrayList arrayList = new ArrayList();
        if (shopEntities != null) {
            List<? extends ShopEntity> list = shopEntities;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Boolean.valueOf(arrayList.add(transformShopEntity((ShopEntity) it.next()))));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r16v0, types: [java.util.Map, java.lang.String] */
    public final Shop transformShopEntity(ShopEntity shopEntity) {
        ?? r16 = 0;
        Shop shop = new Shop(null, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, false, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, r16, r16, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, false, null, null, false, -1, null);
        if (shopEntity != null) {
            shop.setBranchName(shopEntity.getBranchName());
            shop.setBrandName(shopEntity.getBrandName());
            shop.setCertStatus(shopEntity.getCertStatus());
            shop.setContactAddresses(transformContactAddressEntities(shopEntity.getContactAddresses()));
            shop.setExternalShopId(shopEntity.getExternalShopId());
            shop.setExtInfo(shopEntity.getExtInfo());
            shop.setLatitude(shopEntity.getLatitude());
            shop.setLongtitude(shopEntity.getLongtitude());
            shop.setLogoUrl(shopEntity.getLogoUrl());
            shop.setLogoUrlMap(shopEntity.getLogoUrlMap());
            shop.setMainName(shopEntity.getMainName());
            shop.setMccCodes(shopEntity.getMccCodes());
            shop.setSubcategories(this.subcategoryMapper.apply(getSubCategory(shopEntity)));
            shop.setMerchantId(shopEntity.getMerchantId());
            shop.setRegisterSource(shopEntity.getRegisterSource());
            shop.setShopDesc(shopEntity.getShopDesc());
            shop.setShopId(shopEntity.getShopId());
            shop.setShopType(shopEntity.getShopType());
            shop.setInstId(transformMerchantId(shopEntity.getMerchantId()));
            shop.setReviewNumbers(shopEntity.getReviewNumber());
            shop.setRating(shopEntity.getRating());
            shop.setFullDay(shopEntity.getFullDay());
            shop.setOfficeNumbers(shopEntity.getOfficeNumbers());
            shop.setShopOpenHours(transformShopOpenHourEntities(shopEntity.getShopOpenHours()));
            Location location = this.currentMarkerLocation;
            if (location != null) {
                Intrinsics.checkNotNull(location);
                shop.setDistance(getDistanceBetweenShopAndMarkerPosition(shopEntity, location));
            }
            shop.setPromoInfos(transformPromoInfoEntities(shopEntity.getPromoInfos()));
            shop.setMerchantSizeType(shopEntity.getMerchantSizeType());
            shop.setHasMoreShop(shopEntity.isHasMoreShops());
            shop.setMerchantName(shopEntity.getMerchantName());
            shop.setTransactionDate(shopEntity.getTransactionDate());
            shop.setHasDeals(shopEntity.isHasDeals());
            return shop;
        }
        return shop;
    }

    private final List<ContactAddress> transformContactAddressEntities(List<? extends ContactAddressEntity> contactAddressEntities) {
        ArrayList arrayList = new ArrayList();
        if (contactAddressEntities != null) {
            List<? extends ContactAddressEntity> list = contactAddressEntities;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Boolean.valueOf(arrayList.add(transformContactAddress((ContactAddressEntity) it.next()))));
            }
        }
        return arrayList;
    }

    private final List<MerchantSubcategoryEntity> getSubCategory(ShopEntity shopEntity) {
        MerchantSubcategoryEntity merchantSubcategoryEntity;
        Map<String, ? extends MerchantSubcategoryEntity> map = this.merchantSubcategoriesMap;
        ArrayList arrayList = null;
        if (map != null) {
            if (shopEntity.getMccCodes() == null) {
                return null;
            }
            for (String str : shopEntity.getMccCodes()) {
                if (this.isUsingNewMerchantCategories) {
                    merchantSubcategoryEntity = map.get(str);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("msc_");
                    sb.append(str);
                    merchantSubcategoryEntity = map.get(sb.toString());
                }
                if (merchantSubcategoryEntity != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(merchantSubcategoryEntity);
                }
            }
        }
        return arrayList;
    }

    private final String transformMerchantId(String merchantId) {
        Map<String, String> map;
        if (merchantId == null || (map = this.merchantTopUpEntityMap) == null || map == null) {
            return null;
        }
        return map.get(merchantId);
    }

    private final List<ShopOpenHour> transformShopOpenHourEntities(List<ShopOpenHourEntity> shopOpenHourEntities) {
        ArrayList arrayList = new ArrayList();
        if (shopOpenHourEntities != null) {
            List<ShopOpenHourEntity> list = shopOpenHourEntities;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Boolean.valueOf(arrayList.add(transformShopOpenHour((ShopOpenHourEntity) it.next()))));
            }
        }
        return arrayList;
    }

    private final double getDistanceBetweenShopAndMarkerPosition(ShopEntity shopEntity, Location markerLocation) {
        return getDistanceInKM(markerLocation.distanceTo(getLocation(shopEntity.getLatitude(), shopEntity.getLongtitude())));
    }

    private final List<PromoInfo> transformPromoInfoEntities(List<? extends PromoInfoEntity> promoInfoEntities) {
        ArrayList arrayList = new ArrayList();
        if (promoInfoEntities != null) {
            List<? extends PromoInfoEntity> list = promoInfoEntities;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                PromoInfo apply = this.promoInfoEntityMapper.apply((PromoInfoEntity) it.next());
                Intrinsics.checkNotNullExpressionValue(apply, "");
                arrayList2.add(Boolean.valueOf(arrayList.add(apply)));
            }
        }
        return arrayList;
    }

    private final ContactAddress transformContactAddress(ContactAddressEntity contactAddressEntity) {
        ContactAddress contactAddress = new ContactAddress(null, null, null, null, null, null, null, false, null, null, false, null, ARiverTrackWatchDogEventConstant.STARTUP_FLAG, null);
        if (contactAddressEntity != null) {
            contactAddress.setAddress1(contactAddressEntity.getAddress1());
            contactAddress.setAddress2(contactAddressEntity.getAddress2());
            contactAddress.setArea(contactAddressEntity.getArea());
            contactAddress.setCity(contactAddressEntity.getCity());
            contactAddress.setContactAddressId(contactAddressEntity.getContactAddressId());
            contactAddress.setContactAddressType(contactAddressEntity.getContactAddressType());
            contactAddress.setCountry(contactAddressEntity.getCountry());
            contactAddress.setDefaultAddress(contactAddressEntity.isDefaultAddress());
            contactAddress.setExtendInfo(contactAddressEntity.getExtendInfo());
            contactAddress.setProvince(contactAddressEntity.getProvince());
            contactAddress.setVerified(contactAddressEntity.isVerified());
            contactAddress.setZipcode(contactAddressEntity.getZipcode());
        }
        return contactAddress;
    }

    private final ShopOpenHour transformShopOpenHour(ShopOpenHourEntity shopOpenHourEntity) {
        if (shopOpenHourEntity != null) {
            return new ShopOpenHour(shopOpenHourEntity.getDay(), shopOpenHourEntity.getOpenHour(), shopOpenHourEntity.getCloseHour());
        }
        return new ShopOpenHour(null, 0L, 0L, 7, null);
    }
}
