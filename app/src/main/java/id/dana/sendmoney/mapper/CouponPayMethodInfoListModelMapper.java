package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.sendmoney.model.CouponPayMethodInfo;
import id.dana.sendmoney.model.CouponPayMethodInfoModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class CouponPayMethodInfoListModelMapper extends BaseMapper<List<CouponPayMethodInfo>, List<CouponPayMethodInfoModel>> {
    private final CouponPayMethodInfoModelMapper KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<CouponPayMethodInfoModel> map(List<CouponPayMethodInfo> list) {
        List<CouponPayMethodInfo> list2 = list;
        if (!list2.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<CouponPayMethodInfo> it = list2.iterator();
            while (it.hasNext()) {
                CouponPayMethodInfoModel map = this.KClassImpl$Data$declaredNonStaticMembers$2.map(it.next());
                if (map != null) {
                    arrayList.add(map);
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    @Inject
    public CouponPayMethodInfoListModelMapper(CouponPayMethodInfoModelMapper couponPayMethodInfoModelMapper) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = couponPayMethodInfoModelMapper;
    }
}
