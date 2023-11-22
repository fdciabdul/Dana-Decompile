package id.dana.data.splitbill.repository.source;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.splitbill.repository.source.network.response.GetSplitBillDetailResult;
import id.dana.data.splitbill.repository.source.network.response.GetSplitBillHistoriesResult;
import id.dana.data.splitbill.repository.source.persistence.entity.SplitBillHistoryEntity;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface SplitBillEntityData {
    void clearAll();

    Observable<BaseRpcResult> closePayers(List<String> list, String str);

    Observable<GetSplitBillDetailResult> getSplitBillDetail(String str);

    Observable<GetSplitBillHistoriesResult> getSplitBillHistories(int i);

    Observable<Long> saveSplitBillHistory(SplitBillHistoryEntity splitBillHistoryEntity);

    Observable<Boolean> updateSplitBillDetail(SplitBillHistoryEntity splitBillHistoryEntity);

    Observable<Boolean> updateSplitBillHistories(List<SplitBillHistoryEntity> list);
}
