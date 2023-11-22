package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.model.CouponPayMethodInfoResult;
import id.dana.domain.sendmoney.model.CouponPayMethodInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class CouponPayMethodInfoResultMapper extends BaseMapper<List<CouponPayMethodInfoResult>, List<CouponPayMethodInfo>> {
    private final CurrencyAmountResultMapper currencyAmountResultMapper;

    @Inject
    public CouponPayMethodInfoResultMapper(CurrencyAmountResultMapper currencyAmountResultMapper) {
        this.currencyAmountResultMapper = currencyAmountResultMapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<CouponPayMethodInfo> map(List<CouponPayMethodInfoResult> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<CouponPayMethodInfoResult> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(mapSingle(it.next()));
        }
        return arrayList;
    }

    private CouponPayMethodInfo mapSingle(CouponPayMethodInfoResult couponPayMethodInfoResult) {
        if (couponPayMethodInfoResult != null) {
            CouponPayMethodInfo couponPayMethodInfo = new CouponPayMethodInfo();
            couponPayMethodInfo.setPayMethod(couponPayMethodInfoResult.getPayMethod());
            couponPayMethodInfo.setPayOption(couponPayMethodInfoResult.getPayOption());
            couponPayMethodInfo.setCardBin(couponPayMethodInfoResult.getCardBin());
            couponPayMethodInfo.setBindingId(couponPayMethodInfoResult.getBindingId());
            couponPayMethodInfo.setRecommended(couponPayMethodInfoResult.isRecommended());
            couponPayMethodInfo.setEligible(couponPayMethodInfoResult.isEligible());
            couponPayMethodInfo.setRecommendedAmount(this.currencyAmountResultMapper.apply(couponPayMethodInfoResult.getRecommendedAmount()));
            return couponPayMethodInfo;
        }
        return null;
    }
}
