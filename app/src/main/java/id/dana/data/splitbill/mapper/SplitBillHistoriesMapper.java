package id.dana.data.splitbill.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.model.CurrencyAmountResult;
import id.dana.data.splitbill.model.SplitBillHistoryResult;
import id.dana.data.splitbill.repository.source.network.response.GetSplitBillHistoriesResult;
import id.dana.domain.splitbill.model.SplitBillHistory;
import id.dana.domain.user.CurrencyAmount;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class SplitBillHistoriesMapper extends BaseMapper<GetSplitBillHistoriesResult, List<SplitBillHistory>> {
    @Inject
    public SplitBillHistoriesMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<SplitBillHistory> map(GetSplitBillHistoriesResult getSplitBillHistoriesResult) {
        if (getSplitBillHistoriesResult != null && getSplitBillHistoriesResult.getSplitBillHistoryList() != null && !getSplitBillHistoriesResult.getSplitBillHistoryList().isEmpty()) {
            Collections.sort(getSplitBillHistoriesResult.getSplitBillHistoryList(), getComparator());
            return transformSortedHistories(getSplitBillHistoriesResult.getSplitBillHistoryList());
        }
        return new ArrayList();
    }

    private Comparator<SplitBillHistoryResult> getComparator() {
        return new Comparator() { // from class: id.dana.data.splitbill.mapper.SplitBillHistoriesMapper$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return SplitBillHistoriesMapper.lambda$getComparator$0((SplitBillHistoryResult) obj, (SplitBillHistoryResult) obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int lambda$getComparator$0(SplitBillHistoryResult splitBillHistoryResult, SplitBillHistoryResult splitBillHistoryResult2) {
        if (splitBillHistoryResult.isPendingItem() && splitBillHistoryResult2.isPendingItem()) {
            return Long.compare(splitBillHistoryResult2.getSplitBillDate(), splitBillHistoryResult.getSplitBillDate());
        }
        if (splitBillHistoryResult.isPendingItem()) {
            return -1;
        }
        if (splitBillHistoryResult2.isPendingItem()) {
            return 1;
        }
        return Long.compare(splitBillHistoryResult2.getSplitBillDate(), splitBillHistoryResult.getSplitBillDate());
    }

    private List<SplitBillHistory> transformSortedHistories(List<SplitBillHistoryResult> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (SplitBillHistoryResult splitBillHistoryResult : list) {
                if (splitBillHistoryResult != null) {
                    arrayList.add(map(splitBillHistoryResult));
                }
            }
        }
        return arrayList;
    }

    private SplitBillHistory map(SplitBillHistoryResult splitBillHistoryResult) {
        SplitBillHistory splitBillHistory = new SplitBillHistory();
        splitBillHistory.setComment(splitBillHistoryResult.getComment());
        splitBillHistory.setSplitBillId(splitBillHistoryResult.getSplitBillId());
        splitBillHistory.setStatus(splitBillHistoryResult.getStatus());
        splitBillHistory.setAvatars(splitBillHistoryResult.getAvatarPayersList());
        splitBillHistory.setCreatedDate(splitBillHistoryResult.getSplitBillDate());
        splitBillHistory.setTotalAmount(map(splitBillHistoryResult.getTotalAmount()));
        return splitBillHistory;
    }

    private CurrencyAmount map(CurrencyAmountResult currencyAmountResult) {
        CurrencyAmount currencyAmount = new CurrencyAmount();
        if (currencyAmountResult != null) {
            currencyAmount.setAmount(currencyAmountResult.getAmount());
            currencyAmount.setCurrency(currencyAmountResult.getCurrency());
        }
        return currencyAmount;
    }
}
