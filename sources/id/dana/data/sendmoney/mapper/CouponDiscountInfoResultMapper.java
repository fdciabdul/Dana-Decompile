package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.model.CouponDiscountInfoResult;
import id.dana.domain.sendmoney.model.CouponDiscountInfo;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class CouponDiscountInfoResultMapper extends BaseMapper<CouponDiscountInfoResult, CouponDiscountInfo> {
    @Inject
    public CouponDiscountInfoResultMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public CouponDiscountInfo map(CouponDiscountInfoResult couponDiscountInfoResult) {
        if (couponDiscountInfoResult != null) {
            CouponDiscountInfo couponDiscountInfo = new CouponDiscountInfo();
            couponDiscountInfo.setContent(couponDiscountInfoResult.getContent());
            couponDiscountInfo.setDiscountOffRate(couponDiscountInfoResult.getDiscountOffRate());
            couponDiscountInfo.setDiscountType(couponDiscountInfoResult.getDiscountType());
            return couponDiscountInfo;
        }
        return null;
    }
}
