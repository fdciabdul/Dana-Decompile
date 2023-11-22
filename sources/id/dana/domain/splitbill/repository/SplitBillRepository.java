package id.dana.domain.splitbill.repository;

import id.dana.domain.splitbill.model.SplitBillHistory;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface SplitBillRepository {
    Observable<Boolean> closePayers(List<String> list, String str);

    Observable<SplitBillHistory> getPayerSplitBillDetail(String str);

    Observable<SplitBillHistory> getSplitBillDetail(String str);

    Observable<List<SplitBillHistory>> getSplitBillHistories(int i);
}
