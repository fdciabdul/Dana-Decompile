package id.dana.data.splitbill.repository.source.persistence.dao;

import id.dana.data.splitbill.repository.source.persistence.entity.RecentPayerSplitBillEntity;
import java.util.List;

/* loaded from: classes4.dex */
public interface RecentPayerSplitBillDao {
    void deleteOldRecentPayer();

    RecentPayerSplitBillEntity getRecentContactByPhoneNumber(String str);

    RecentPayerSplitBillEntity getRecentContactByUserId(String str);

    List<RecentPayerSplitBillEntity> getSomeRecentPayer(int i);

    void removeAllRecentContact();

    Long saveRecentContactSplitBill(RecentPayerSplitBillEntity recentPayerSplitBillEntity);

    int updateRecentContact(RecentPayerSplitBillEntity recentPayerSplitBillEntity);
}
