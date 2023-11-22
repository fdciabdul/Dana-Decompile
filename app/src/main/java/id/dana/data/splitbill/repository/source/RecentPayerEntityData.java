package id.dana.data.splitbill.repository.source;

import id.dana.data.splitbill.repository.source.persistence.entity.RecentPayerSplitBillEntity;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface RecentPayerEntityData {
    void clearAll();

    Observable<List<RecentPayerSplitBillEntity>> getRecentPayers(int i);

    Observable<List<Long>> saveRecentPayers(List<RecentPayerSplitBillEntity> list);
}
