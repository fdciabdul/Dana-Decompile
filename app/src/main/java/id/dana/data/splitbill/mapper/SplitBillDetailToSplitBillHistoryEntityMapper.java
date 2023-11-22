package id.dana.data.splitbill.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.foundation.utils.CommonUtil;
import id.dana.data.splitbill.model.SplitBillDetailResult;
import id.dana.data.splitbill.model.SplitBillPayerResult;
import id.dana.data.splitbill.repository.source.persistence.entity.SplitBillHistoryEntity;
import id.dana.data.storage.Serializer;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class SplitBillDetailToSplitBillHistoryEntityMapper extends BaseMapper<SplitBillDetailResult, SplitBillHistoryEntity> {
    private final Serializer serializer;

    @Inject
    public SplitBillDetailToSplitBillHistoryEntityMapper(Serializer serializer) {
        this.serializer = serializer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public SplitBillHistoryEntity map(SplitBillDetailResult splitBillDetailResult) {
        if (splitBillDetailResult != null) {
            SplitBillHistoryEntity splitBillHistoryEntity = new SplitBillHistoryEntity();
            splitBillHistoryEntity.setStatus(splitBillDetailResult.getStatus());
            splitBillHistoryEntity.setComment(splitBillDetailResult.getComment());
            splitBillHistoryEntity.setSplitBillId(splitBillDetailResult.getSplitBillId());
            splitBillHistoryEntity.setPayeeIndex(Integer.valueOf(splitBillDetailResult.getPayeeIndex()).intValue());
            splitBillHistoryEntity.setPayerIndex(Integer.valueOf(splitBillDetailResult.getPayerIndex()).intValue());
            splitBillHistoryEntity.setTotalAmount(getTotalAmount(splitBillDetailResult.getPayersResult()));
            splitBillHistoryEntity.setPayers(this.serializer.serialize(splitBillDetailResult.getPayersResult()));
            splitBillHistoryEntity.setLastUpdated(CommonUtil.KClassImpl$Data$declaredNonStaticMembers$2());
            return splitBillHistoryEntity;
        }
        return null;
    }

    private String getTotalAmount(List<SplitBillPayerResult> list) {
        long j = 0;
        if (list != null) {
            Iterator<SplitBillPayerResult> it = list.iterator();
            while (it.hasNext()) {
                j += Long.valueOf(it.next().getFundAmount()).longValue();
            }
        }
        return String.valueOf(j);
    }
}
