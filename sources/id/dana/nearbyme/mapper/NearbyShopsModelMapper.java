package id.dana.nearbyme.mapper;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.data.base.BaseMapper;
import id.dana.domain.nearbyme.model.ContactAddress;
import id.dana.domain.nearbyme.model.Shop;
import id.dana.domain.nearbyme.model.ShopsPage;
import id.dana.nearbyme.MerchantViewType;
import id.dana.nearbyme.model.ContactAddressModel;
import id.dana.nearbyme.model.MerchantSubcategoryModel;
import id.dana.nearbyme.model.NearbyShopsModel;
import id.dana.nearbyme.model.ShopModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class NearbyShopsModelMapper extends BaseMapper<ShopsPage, NearbyShopsModel> {
    public Double BuiltInFictitiousFunctionClassFactory = Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    private final MerchantSubcategoriesMapper KClassImpl$Data$declaredNonStaticMembers$2;
    private final ShopOpenHourListMapper PlaceComponentResult;
    public boolean getAuthRequestContext;

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ NearbyShopsModel map(ShopsPage shopsPage) {
        List<Shop> shops;
        ShopsPage shopsPage2 = shopsPage;
        NearbyShopsModel nearbyShopsModel = new NearbyShopsModel();
        if (shopsPage2 != null && (shops = shopsPage2.getShops()) != null) {
            ArrayList arrayList = new ArrayList();
            if (shops != null) {
                for (Shop shop : shops) {
                    if (!this.getAuthRequestContext || !shop.isMerchantIdIrrelevant() || !shop.isReviewCountNotValid(this.BuiltInFictitiousFunctionClassFactory.doubleValue())) {
                        arrayList.add(PlaceComponentResult(shop));
                    }
                }
            }
            nearbyShopsModel.MyBillsEntityDataFactory = arrayList;
            nearbyShopsModel.KClassImpl$Data$declaredNonStaticMembers$2 = shopsPage2.getHasMore();
            nearbyShopsModel.BuiltInFictitiousFunctionClassFactory = shopsPage2.getPromoFlag();
        }
        return nearbyShopsModel;
    }

    @Inject
    public NearbyShopsModelMapper(MerchantSubcategoriesMapper merchantSubcategoriesMapper, ShopOpenHourListMapper shopOpenHourListMapper) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = merchantSubcategoriesMapper;
        this.PlaceComponentResult = shopOpenHourListMapper;
    }

    public final ShopModel PlaceComponentResult(Shop shop) {
        ShopModel shopModel = new ShopModel();
        if (shop != null) {
            shopModel.MyBillsEntityDataFactory = shop.getBranchName();
            shopModel.getAuthRequestContext = shop.getBrandName();
            shopModel.BuiltInFictitiousFunctionClassFactory = shop.getCertStatus();
            shopModel.KClassImpl$Data$declaredNonStaticMembers$2 = getAuthRequestContext(shop.getContactAddresses());
            shopModel.lookAheadTest = shop.getExternalShopId();
            shopModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = shop.getExtInfo();
            shopModel.DatabaseTableConfigUtil = shop.getLatitude();
            shopModel.PrepareContext = shop.getLongtitude();
            shopModel.NetworkUserEntityData$$ExternalSyntheticLambda8 = shop.getLogoUrl();
            shopModel.NetworkUserEntityData$$ExternalSyntheticLambda7 = shop.getLogoUrlMap();
            shopModel.newProxyInstance = shop.getMainName();
            shopModel.isLayoutRequested = shop.getMccCodes();
            shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3 = shop.getMerchantId();
            shopModel.getOnBoardingScenario = this.KClassImpl$Data$declaredNonStaticMembers$2.apply(shop.getSubcategories());
            shopModel.getSupportButtonTintMode = shop.getRegisterSource();
            shopModel.B = shop.getShopDesc();
            shopModel.BottomSheetCardBindingView$watcherCardNumberView$1 = shop.getShopId();
            shopModel.D = shop.getShopType();
            shopModel.getErrorConfigVersion = shop.getDistance();
            shopModel.VerifyPinStateManager$executeRiskChallenge$2$1 = shop.getShopStatus();
            shopModel.NetworkUserEntityData$$ExternalSyntheticLambda5 = shop.getOfficeNumbers();
            shopModel.GetContactSyncConfig = shop.getInstId();
            double round = Math.round(shop.getRating() * 10.0d);
            Double.isNaN(round);
            shopModel.readMicros = round / 10.0d;
            shopModel.SubSequence = shop.getReviewNumbers();
            shopModel.moveToNextValue = shop.getFullDay();
            shopModel.BuiltInFictitiousFunctionClassFactory(new ArrayList(this.PlaceComponentResult.apply(shop.getShopOpenHours())));
            shopModel.FragmentBottomSheetPaymentSettingBinding = shop.getMerchantSizeType();
            shopModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = shop.getHasMoreShop();
            shopModel.NetworkUserEntityData$$ExternalSyntheticLambda6 = shop.getMerchantName();
            shopModel.VerifyPinStateManager$executeRiskChallenge$2$2 = shop.getTransactionDate();
            shopModel.NetworkUserEntityData$$ExternalSyntheticLambda8();
            boolean hasDeals = shop.getHasDeals();
            shopModel.scheduleImpl = hasDeals;
            if (hasDeals) {
                MerchantSubcategoryModel merchantSubcategoryModel = new MerchantSubcategoryModel();
                List<String> list = merchantSubcategoryModel.BuiltInFictitiousFunctionClassFactory;
                if (list != null && !list.contains(MerchantViewType.MERCHANT_CAT_DEALS)) {
                    merchantSubcategoryModel.BuiltInFictitiousFunctionClassFactory.add(MerchantViewType.MERCHANT_CAT_DEALS);
                }
                if (shopModel.getOnBoardingScenario == null) {
                    shopModel.getOnBoardingScenario = new ArrayList();
                }
                shopModel.getOnBoardingScenario.add(merchantSubcategoryModel);
            }
        }
        return shopModel;
    }

    private static List<ContactAddressModel> getAuthRequestContext(List<ContactAddress> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (ContactAddress contactAddress : list) {
                ContactAddressModel contactAddressModel = new ContactAddressModel();
                if (contactAddress != null) {
                    contactAddressModel.PlaceComponentResult = contactAddress.getAddress1();
                    contactAddressModel.BuiltInFictitiousFunctionClassFactory = contactAddress.getAddress2();
                    contactAddressModel.KClassImpl$Data$declaredNonStaticMembers$2 = contactAddress.getArea();
                    contactAddressModel.getAuthRequestContext = contactAddress.getCity();
                    contactAddressModel.MyBillsEntityDataFactory = contactAddress.getContactAddressId();
                    contactAddressModel.getErrorConfigVersion = contactAddress.getContactAddressType();
                    contactAddressModel.scheduleImpl = contactAddress.getCountry();
                    contactAddressModel.lookAheadTest = contactAddress.isDefaultAddress();
                    contactAddressModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = contactAddress.getExtendInfo();
                    contactAddressModel.moveToNextValue = contactAddress.getProvince();
                    contactAddressModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = contactAddress.isVerified();
                    contactAddressModel.initRecordTimeStamp = contactAddress.getZipcode();
                }
                arrayList.add(contactAddressModel);
            }
        }
        return arrayList;
    }
}
