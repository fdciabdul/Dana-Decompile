package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.model.CouponChannelInfoResult;
import id.dana.domain.sendmoney.model.CouponChannelInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class CouponChannelInfoResultMapper extends BaseMapper<List<CouponChannelInfoResult>, List<CouponChannelInfo>> {
    private final CouponDiscountInfoResultMapper couponDiscountInfoResultMapper;
    private final CouponPayMethodInfoResultMapper couponPayMethodInfoResultMapper;
    private final CurrencyAmountResultMapper currencyAmountResultMapper;

    @Inject
    public CouponChannelInfoResultMapper(CurrencyAmountResultMapper currencyAmountResultMapper, CouponDiscountInfoResultMapper couponDiscountInfoResultMapper, CouponPayMethodInfoResultMapper couponPayMethodInfoResultMapper) {
        this.currencyAmountResultMapper = currencyAmountResultMapper;
        this.couponDiscountInfoResultMapper = couponDiscountInfoResultMapper;
        this.couponPayMethodInfoResultMapper = couponPayMethodInfoResultMapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<CouponChannelInfo> map(List<CouponChannelInfoResult> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<CouponChannelInfoResult> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(mapSingle(it.next()));
            }
            return arrayList;
        }
        return null;
    }

    private CouponChannelInfo mapSingle(CouponChannelInfoResult couponChannelInfoResult) {
        if (couponChannelInfoResult != null) {
            CouponChannelInfo couponChannelInfo = new CouponChannelInfo();
            couponChannelInfo.setCouponId(couponChannelInfoResult.getCouponId());
            couponChannelInfo.setCouponName(couponChannelInfoResult.getCouponName());
            couponChannelInfo.setAvailableAmount(this.currencyAmountResultMapper.map(couponChannelInfoResult.getAvailableAmount()));
            couponChannelInfo.setTotalAmount(this.currencyAmountResultMapper.map(couponChannelInfoResult.getTotalAmount()));
            couponChannelInfo.setActiveTime(couponChannelInfoResult.getActiveTime());
            couponChannelInfo.setExpiryTime(couponChannelInfoResult.getExpiryTime());
            couponChannelInfo.setExtendTime(couponChannelInfoResult.getExtendTime());
            couponChannelInfo.setCreatedTime(couponChannelInfoResult.getCreatedTime());
            couponChannelInfo.setModifiedTime(couponChannelInfoResult.getModifiedTime());
            couponChannelInfo.setCouponDiscountInfo(this.couponDiscountInfoResultMapper.map(couponChannelInfoResult.getCouponDiscountInfo()));
            couponChannelInfo.setCouponPayMethodInfos(this.couponPayMethodInfoResultMapper.map(couponChannelInfoResult.getCouponPayMethodInfos()));
            couponChannelInfo.setDescription(couponChannelInfoResult.getDescription());
            couponChannelInfo.setIconUrl(couponChannelInfoResult.getIconUrl());
            couponChannelInfo.setTnc(couponChannelInfoResult.getTnc());
            return couponChannelInfo;
        }
        return null;
    }
}
