package id.dana.nearbyme.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.nearbyme.model.ContactAddress;
import id.dana.domain.nearbyme.model.PromoInfo;
import id.dana.domain.nearbyme.model.Shop;
import id.dana.domain.nearbyme.model.ShopOpenHour;
import id.dana.nearbyme.model.ShopModel;
import id.dana.nearbyme.model.ShopOpenHourModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B)\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\f\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010"}, d2 = {"Lid/dana/nearbyme/mapper/ShopMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/domain/nearbyme/model/Shop;", "Lid/dana/nearbyme/model/ShopModel;", "Lid/dana/nearbyme/mapper/ContactAddressMapper;", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/mapper/ContactAddressMapper;", "PlaceComponentResult", "Lid/dana/nearbyme/mapper/PromoInfoMapper;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/mapper/PromoInfoMapper;", "Lid/dana/nearbyme/mapper/ShopOpenHourListMapper;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/mapper/ShopOpenHourListMapper;", "getAuthRequestContext", "Lid/dana/nearbyme/mapper/MerchantSubcategoriesMapper;", "Lid/dana/nearbyme/mapper/MerchantSubcategoriesMapper;", "p0", "p1", "p2", "p3", "<init>", "(Lid/dana/nearbyme/mapper/ContactAddressMapper;Lid/dana/nearbyme/mapper/PromoInfoMapper;Lid/dana/nearbyme/mapper/ShopOpenHourListMapper;Lid/dana/nearbyme/mapper/MerchantSubcategoriesMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShopMapper extends BaseMapper<Shop, ShopModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final ShopOpenHourListMapper getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final PromoInfoMapper MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ContactAddressMapper PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final MerchantSubcategoriesMapper BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ ShopModel map(Shop shop) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Shop shop2 = shop;
        Intrinsics.checkNotNullParameter(shop2, "");
        ShopModel shopModel = new ShopModel();
        shopModel.MyBillsEntityDataFactory = shop2.getBranchName();
        shopModel.getAuthRequestContext = shop2.getBrandName();
        shopModel.BuiltInFictitiousFunctionClassFactory = shop2.getCertStatus();
        List<ContactAddress> contactAddresses = shop2.getContactAddresses();
        if (contactAddresses != null) {
            List<ContactAddress> list = contactAddresses;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList3.add(this.PlaceComponentResult.apply((ContactAddress) it.next()));
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            arrayList = CollectionsKt.emptyList();
        }
        shopModel.KClassImpl$Data$declaredNonStaticMembers$2 = arrayList;
        shopModel.getErrorConfigVersion = shop2.getDistance();
        shopModel.lookAheadTest = shop2.getExternalShopId();
        shopModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = shop2.getExtInfo();
        shopModel.moveToNextValue = shop2.getFullDay();
        shopModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = shop2.getHasMoreShop();
        shopModel.GetContactSyncConfig = shop2.getInstId();
        shopModel.DatabaseTableConfigUtil = shop2.getLatitude();
        shopModel.NetworkUserEntityData$$ExternalSyntheticLambda8 = shop2.getLogoUrl();
        shopModel.NetworkUserEntityData$$ExternalSyntheticLambda7 = shop2.getLogoUrlMap();
        shopModel.PrepareContext = shop2.getLongtitude();
        shopModel.newProxyInstance = shop2.getMainName();
        shopModel.isLayoutRequested = shop2.getMccCodes();
        shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3 = shop2.getMerchantId();
        shopModel.NetworkUserEntityData$$ExternalSyntheticLambda6 = shop2.getMerchantName();
        shopModel.FragmentBottomSheetPaymentSettingBinding = shop2.getMerchantSizeType();
        List<PromoInfo> promoInfos = shop2.getPromoInfos();
        if (promoInfos != null) {
            List<PromoInfo> list2 = promoInfos;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList4.add(this.MyBillsEntityDataFactory.apply((PromoInfo) it2.next()));
            }
            arrayList2 = arrayList4;
        } else {
            arrayList2 = null;
        }
        if (arrayList2 == null) {
            arrayList2 = CollectionsKt.emptyList();
        }
        shopModel.MyBillsEntityDataFactory(arrayList2);
        shopModel.readMicros = shop2.getRating();
        shopModel.getSupportButtonTintMode = shop2.getRegisterSource();
        shopModel.SubSequence = shop2.getReviewNumbers();
        shopModel.B = shop2.getShopDesc();
        shopModel.BottomSheetCardBindingView$watcherCardNumberView$1 = shop2.getShopId();
        List<ShopOpenHour> shopOpenHours = shop2.getShopOpenHours();
        List<ShopOpenHourModel> list3 = shopOpenHours != null ? (List) this.getAuthRequestContext.apply(shopOpenHours) : null;
        if (list3 == null) {
            list3 = CollectionsKt.emptyList();
        }
        shopModel.BuiltInFictitiousFunctionClassFactory(list3);
        shopModel.VerifyPinStateManager$executeRiskChallenge$2$1 = shop2.getShopStatus();
        shopModel.D = shop2.getShopType();
        shopModel.getOnBoardingScenario = this.BuiltInFictitiousFunctionClassFactory.apply(shop2.getSubcategories());
        shopModel.VerifyPinStateManager$executeRiskChallenge$2$2 = shop2.getTransactionDate();
        return shopModel;
    }

    @Inject
    public ShopMapper(ContactAddressMapper contactAddressMapper, PromoInfoMapper promoInfoMapper, ShopOpenHourListMapper shopOpenHourListMapper, MerchantSubcategoriesMapper merchantSubcategoriesMapper) {
        Intrinsics.checkNotNullParameter(contactAddressMapper, "");
        Intrinsics.checkNotNullParameter(promoInfoMapper, "");
        Intrinsics.checkNotNullParameter(shopOpenHourListMapper, "");
        Intrinsics.checkNotNullParameter(merchantSubcategoriesMapper, "");
        this.PlaceComponentResult = contactAddressMapper;
        this.MyBillsEntityDataFactory = promoInfoMapper;
        this.getAuthRequestContext = shopOpenHourListMapper;
        this.BuiltInFictitiousFunctionClassFactory = merchantSubcategoriesMapper;
    }
}
