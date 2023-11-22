package id.dana.data.splitbill.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.foundation.utils.CommonUtil;
import id.dana.data.splitbill.model.SplitBillHistoryResult;
import id.dana.data.splitbill.repository.source.persistence.entity.SplitBillHistoryEntity;
import id.dana.data.storage.Serializer;
import id.dana.domain.splitbill.model.SplitBillPayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class SplitBillHistoryEntitiesMapper extends BaseMapper<List<SplitBillHistoryResult>, List<SplitBillHistoryEntity>> {
    private final Serializer serializer;

    @Inject
    public SplitBillHistoryEntitiesMapper(Serializer serializer) {
        this.serializer = serializer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<SplitBillHistoryEntity> map(List<SplitBillHistoryResult> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (SplitBillHistoryResult splitBillHistoryResult : list) {
            if (splitBillHistoryResult != null) {
                arrayList.add(map(splitBillHistoryResult));
            }
        }
        return arrayList;
    }

    private SplitBillHistoryEntity map(SplitBillHistoryResult splitBillHistoryResult) {
        SplitBillHistoryEntity splitBillHistoryEntity = new SplitBillHistoryEntity();
        splitBillHistoryEntity.setSplitBillId(splitBillHistoryResult.getSplitBillId());
        splitBillHistoryEntity.setLastUpdated(CommonUtil.KClassImpl$Data$declaredNonStaticMembers$2());
        splitBillHistoryEntity.setCreatedDate(splitBillHistoryResult.getSplitBillDate());
        splitBillHistoryEntity.setStatus(splitBillHistoryResult.getStatus());
        splitBillHistoryEntity.setComment(splitBillHistoryResult.getComment());
        splitBillHistoryEntity.setPayers(mapAvatars(splitBillHistoryResult.getAvatarPayersList()));
        splitBillHistoryEntity.setTotalAmount(splitBillHistoryResult.getTotalAmount().getAmount());
        return splitBillHistoryEntity;
    }

    private String mapAvatars(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new SplitBillPayer(it.next()));
            }
        }
        return this.serializer.serialize(arrayList);
    }
}
