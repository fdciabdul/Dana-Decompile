package id.dana.nearbyme.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.nearbyme.model.ContactAddress;
import id.dana.domain.nearbyme.model.OtherStoreListResult;
import id.dana.domain.nearbyme.model.PromoInfo;
import id.dana.domain.nearbyme.model.Shop;
import id.dana.domain.nearbyme.model.ShopOpenHour;
import id.dana.model.OtherStoreListResultModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.nearbyme.model.ShopOpenHourModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B)\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\t\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010"}, d2 = {"Lid/dana/nearbyme/mapper/OtherStoreListResultModelMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/domain/nearbyme/model/OtherStoreListResult;", "Lid/dana/model/OtherStoreListResultModel;", "Lid/dana/nearbyme/mapper/ContactAddressMapper;", "PlaceComponentResult", "Lid/dana/nearbyme/mapper/ContactAddressMapper;", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/mapper/MerchantSubcategoriesMapper;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/mapper/MerchantSubcategoriesMapper;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/mapper/PromoInfoMapper;", "getAuthRequestContext", "Lid/dana/nearbyme/mapper/PromoInfoMapper;", "Lid/dana/nearbyme/mapper/ShopOpenHourListMapper;", "Lid/dana/nearbyme/mapper/ShopOpenHourListMapper;", "p0", "p1", "p2", "p3", "<init>", "(Lid/dana/nearbyme/mapper/ShopOpenHourListMapper;Lid/dana/nearbyme/mapper/ContactAddressMapper;Lid/dana/nearbyme/mapper/PromoInfoMapper;Lid/dana/nearbyme/mapper/MerchantSubcategoriesMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OtherStoreListResultModelMapper extends BaseMapper<OtherStoreListResult, OtherStoreListResultModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final ShopOpenHourListMapper PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final MerchantSubcategoriesMapper BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final ContactAddressMapper MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final PromoInfoMapper KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ OtherStoreListResultModel map(OtherStoreListResult otherStoreListResult) {
        ArrayList arrayList;
        OtherStoreListResult otherStoreListResult2 = otherStoreListResult;
        Intrinsics.checkNotNullParameter(otherStoreListResult2, "");
        List<Shop> shops = otherStoreListResult2.getShops();
        ArrayList arrayList2 = new ArrayList();
        for (Shop shop : shops) {
            ShopModel shopModel = new ShopModel();
            shopModel.MyBillsEntityDataFactory = shop.getBranchName();
            shopModel.getAuthRequestContext = shop.getBrandName();
            shopModel.getOnBoardingScenario = MerchantSubcategoriesMapper.KClassImpl$Data$declaredNonStaticMembers$2(shop.getSubcategories());
            List<ShopOpenHour> shopOpenHours = shop.getShopOpenHours();
            ArrayList arrayList3 = null;
            List<ShopOpenHourModel> list = shopOpenHours != null ? (List) this.PlaceComponentResult.apply(shopOpenHours) : null;
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            shopModel.BuiltInFictitiousFunctionClassFactory(list);
            shopModel.BuiltInFictitiousFunctionClassFactory = shop.getCertStatus();
            List<ContactAddress> contactAddresses = shop.getContactAddresses();
            if (contactAddresses != null) {
                List<ContactAddress> list2 = contactAddresses;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList4.add(this.MyBillsEntityDataFactory.apply((ContactAddress) it.next()));
                }
                arrayList = arrayList4;
            } else {
                arrayList = null;
            }
            if (arrayList == null) {
                arrayList = CollectionsKt.emptyList();
            }
            shopModel.KClassImpl$Data$declaredNonStaticMembers$2 = arrayList;
            shopModel.getErrorConfigVersion = shop.getDistance();
            shopModel.lookAheadTest = shop.getExternalShopId();
            shopModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = shop.getExtInfo();
            shopModel.moveToNextValue = shop.getFullDay();
            shopModel.GetContactSyncConfig = shop.getInstId();
            shopModel.DatabaseTableConfigUtil = shop.getLatitude();
            shopModel.NetworkUserEntityData$$ExternalSyntheticLambda8 = shop.getLogoUrl();
            shopModel.NetworkUserEntityData$$ExternalSyntheticLambda7 = shop.getLogoUrlMap();
            shopModel.PrepareContext = shop.getLongtitude();
            shopModel.newProxyInstance = shop.getMainName();
            shopModel.isLayoutRequested = shop.getMccCodes();
            shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3 = shop.getMerchantId();
            shopModel.NetworkUserEntityData$$ExternalSyntheticLambda6 = shop.getMerchantName();
            shopModel.FragmentBottomSheetPaymentSettingBinding = shop.getMerchantSizeType();
            List<PromoInfo> promoInfos = shop.getPromoInfos();
            if (promoInfos != null) {
                List<PromoInfo> list3 = promoInfos;
                ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                Iterator<T> it2 = list3.iterator();
                while (it2.hasNext()) {
                    arrayList5.add(this.KClassImpl$Data$declaredNonStaticMembers$2.apply((PromoInfo) it2.next()));
                }
                arrayList3 = arrayList5;
            }
            if (arrayList3 == null) {
                arrayList3 = CollectionsKt.emptyList();
            }
            shopModel.MyBillsEntityDataFactory(arrayList3);
            double round = Math.round(shop.getRating() * 10.0d);
            Double.isNaN(round);
            shopModel.readMicros = round / 10.0d;
            shopModel.getSupportButtonTintMode = shop.getRegisterSource();
            shopModel.SubSequence = shop.getReviewNumbers();
            shopModel.B = shop.getShopDesc();
            shopModel.BottomSheetCardBindingView$watcherCardNumberView$1 = shop.getShopId();
            shopModel.VerifyPinStateManager$executeRiskChallenge$2$1 = shop.getShopStatus();
            shopModel.D = shop.getShopType();
            shopModel.NetworkUserEntityData$$ExternalSyntheticLambda5 = shop.getOfficeNumbers();
            arrayList2.add(shopModel);
        }
        return new OtherStoreListResultModel(arrayList2, otherStoreListResult2.getHasMore(), otherStoreListResult2.getPromoFlag());
    }

    @Inject
    public OtherStoreListResultModelMapper(ShopOpenHourListMapper shopOpenHourListMapper, ContactAddressMapper contactAddressMapper, PromoInfoMapper promoInfoMapper, MerchantSubcategoriesMapper merchantSubcategoriesMapper) {
        Intrinsics.checkNotNullParameter(shopOpenHourListMapper, "");
        Intrinsics.checkNotNullParameter(contactAddressMapper, "");
        Intrinsics.checkNotNullParameter(promoInfoMapper, "");
        Intrinsics.checkNotNullParameter(merchantSubcategoriesMapper, "");
        this.PlaceComponentResult = shopOpenHourListMapper;
        this.MyBillsEntityDataFactory = contactAddressMapper;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = promoInfoMapper;
        this.BuiltInFictitiousFunctionClassFactory = merchantSubcategoriesMapper;
    }
}
