package id.dana.data.splitbill.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.foundation.utils.CommonUtil;
import id.dana.data.splitbill.repository.source.persistence.entity.RecentPayerSplitBillEntity;
import id.dana.domain.splitbill.model.SplitBillPayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class RecentPayerEntityMapper extends BaseMapper<List<SplitBillPayer>, List<RecentPayerSplitBillEntity>> {
    @Inject
    public RecentPayerEntityMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<RecentPayerSplitBillEntity> map(List<SplitBillPayer> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<SplitBillPayer> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(map(it.next()));
            }
            return arrayList;
        }
        return new ArrayList();
    }

    private RecentPayerSplitBillEntity map(SplitBillPayer splitBillPayer) {
        return new RecentPayerSplitBillEntity(splitBillPayer.getUserId(), splitBillPayer.getLoginId(), splitBillPayer.getName(), splitBillPayer.getImageUrl(), CommonUtil.KClassImpl$Data$declaredNonStaticMembers$2(), splitBillPayer.getShownName(), splitBillPayer.getShownNumber());
    }
}
