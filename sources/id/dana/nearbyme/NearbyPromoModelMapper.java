package id.dana.nearbyme;

import id.dana.domain.nearbyme.model.NearbyShopsPromo;
import id.dana.domain.nearbyme.model.PromoInfo;
import id.dana.domain.nearbyme.model.PromoLimitInfo;
import id.dana.nearbyme.model.PromoInfoModel;
import id.dana.nearbyme.model.PromoLimitInfoModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class NearbyPromoModelMapper {
    private final CurrencyAmountModelMapper MyBillsEntityDataFactory;

    @Inject
    public NearbyPromoModelMapper(CurrencyAmountModelMapper currencyAmountModelMapper) {
        this.MyBillsEntityDataFactory = currencyAmountModelMapper;
    }

    public final List<ShopModel> BuiltInFictitiousFunctionClassFactory(List<ShopModel> list, List<NearbyShopsPromo> list2) {
        ArrayList arrayList = new ArrayList();
        for (NearbyShopsPromo nearbyShopsPromo : list2) {
            int indexOf = list.indexOf(new ShopModel(nearbyShopsPromo.getMerchantId(), nearbyShopsPromo.getShopId()));
            if (indexOf >= 0) {
                ShopModel shopModel = list.get(indexOf);
                shopModel.MyBillsEntityDataFactory(getAuthRequestContext(nearbyShopsPromo.getPromoInfos()));
                arrayList.add(shopModel);
            }
        }
        return arrayList;
    }

    public final List<PromoInfoModel> getAuthRequestContext(List<PromoInfo> list) {
        PromoLimitInfoModel promoLimitInfoModel;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (PromoInfo promoInfo : list) {
                if (promoInfo != null) {
                    PromoInfoModel promoInfoModel = new PromoInfoModel();
                    promoInfoModel.BuiltInFictitiousFunctionClassFactory = promoInfo.getActivityId();
                    promoInfoModel.getErrorConfigVersion = promoInfo.getPrizeType();
                    promoInfoModel.lookAheadTest = promoInfo.getPaymentMethods();
                    promoInfoModel.scheduleImpl = this.MyBillsEntityDataFactory.apply(promoInfo.getMinTransactionAmount());
                    promoInfoModel.getAuthRequestContext = promoInfo.getEndDate();
                    promoInfoModel.MyBillsEntityDataFactory = promoInfo.getBeginDate();
                    promoInfoModel.KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory.apply(promoInfo.getMaxAmount());
                    promoInfoModel.moveToNextValue = promoInfo.getPromoType();
                    promoInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = promoInfo.getPromoDescription();
                    promoInfoModel.initRecordTimeStamp = promoInfo.getPromoValue();
                    List<PromoLimitInfo> limitRule = promoInfo.getLimitRule();
                    ArrayList arrayList2 = new ArrayList();
                    if (limitRule != null) {
                        for (PromoLimitInfo promoLimitInfo : limitRule) {
                            if (promoLimitInfo == null) {
                                promoLimitInfoModel = null;
                            } else {
                                PromoLimitInfoModel promoLimitInfoModel2 = new PromoLimitInfoModel();
                                promoLimitInfoModel2.KClassImpl$Data$declaredNonStaticMembers$2 = promoLimitInfo.getLimitType();
                                promoLimitInfoModel2.MyBillsEntityDataFactory = promoLimitInfo.getLimitRangeType();
                                promoLimitInfoModel2.BuiltInFictitiousFunctionClassFactory = promoLimitInfo.getLimitCount();
                                promoLimitInfoModel = promoLimitInfoModel2;
                            }
                            arrayList2.add(promoLimitInfoModel);
                        }
                    }
                    promoInfoModel.PlaceComponentResult = arrayList2;
                    arrayList.add(promoInfoModel);
                }
            }
        }
        return arrayList;
    }
}
