package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.sendmoney.model.CouponPayMethodInfo;
import id.dana.sendmoney.model.CouponPayMethodInfoModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class CouponPayMethodInfoModelMapper extends BaseMapper<CouponPayMethodInfo, CouponPayMethodInfoModel> {
    private final CurrencyAmountModelMapper MyBillsEntityDataFactory;

    @Inject
    public CouponPayMethodInfoModelMapper(CurrencyAmountModelMapper currencyAmountModelMapper) {
        this.MyBillsEntityDataFactory = currencyAmountModelMapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
    public final CouponPayMethodInfoModel map(CouponPayMethodInfo couponPayMethodInfo) {
        if (couponPayMethodInfo != null) {
            CouponPayMethodInfoModel couponPayMethodInfoModel = new CouponPayMethodInfoModel();
            couponPayMethodInfoModel.KClassImpl$Data$declaredNonStaticMembers$2 = couponPayMethodInfo.getPayMethod();
            couponPayMethodInfoModel.MyBillsEntityDataFactory = couponPayMethodInfo.getPayOption();
            couponPayMethodInfoModel.BuiltInFictitiousFunctionClassFactory = couponPayMethodInfo.getCardBin();
            couponPayMethodInfoModel.getErrorConfigVersion = couponPayMethodInfo.isRecommended();
            couponPayMethodInfoModel.lookAheadTest = CurrencyAmountModelMapper.getAuthRequestContext(couponPayMethodInfo.getRecommendedAmount());
            couponPayMethodInfoModel.PlaceComponentResult = couponPayMethodInfo.isEligible();
            couponPayMethodInfoModel.getAuthRequestContext = couponPayMethodInfo.getPriority();
            return couponPayMethodInfoModel;
        }
        return null;
    }
}
