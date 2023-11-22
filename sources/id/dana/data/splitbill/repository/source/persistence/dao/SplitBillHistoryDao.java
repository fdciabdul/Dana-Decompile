package id.dana.data.splitbill.repository.source.persistence.dao;

import id.dana.data.splitbill.repository.source.persistence.entity.SplitBillHistoryEntity;
import java.util.List;

/* loaded from: classes4.dex */
public interface SplitBillHistoryDao {
    void clearAll();

    void deleteOldSplitBillHistories();

    SplitBillHistoryEntity getHistoryById(String str);

    List<SplitBillHistoryEntity> getSplitBillHistories();

    Long saveSplitBillHistory(SplitBillHistoryEntity splitBillHistoryEntity);

    int updateSplitBillHistoryEntity(SplitBillHistoryEntity splitBillHistoryEntity);
}
