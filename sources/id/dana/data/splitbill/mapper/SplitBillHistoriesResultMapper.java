package id.dana.data.splitbill.mapper;

import android.text.TextUtils;
import id.dana.data.base.BaseMapper;
import id.dana.data.model.CurrencyAmountResult;
import id.dana.data.splitbill.model.SplitBillHistoryResult;
import id.dana.data.splitbill.repository.source.network.response.GetSplitBillHistoriesResult;
import id.dana.data.splitbill.repository.source.persistence.entity.SplitBillHistoryEntity;
import id.dana.data.storage.Serializer;
import id.dana.data.util.NumberUtils;
import id.dana.domain.splitbill.model.SplitBillPayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class SplitBillHistoriesResultMapper extends BaseMapper<List<SplitBillHistoryEntity>, GetSplitBillHistoriesResult> {
    private static final String CURRENCY = "Rp";
    private Serializer serializer;

    @Inject
    public SplitBillHistoriesResultMapper(Serializer serializer) {
        this.serializer = serializer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public GetSplitBillHistoriesResult map(List<SplitBillHistoryEntity> list) {
        if (list != null) {
            GetSplitBillHistoriesResult getSplitBillHistoriesResult = new GetSplitBillHistoriesResult();
            getSplitBillHistoriesResult.success = true;
            getSplitBillHistoriesResult.setSplitBillHistoryList(transform(list));
            return getSplitBillHistoriesResult;
        }
        return null;
    }

    private List<SplitBillHistoryResult> transform(List<SplitBillHistoryEntity> list) {
        ArrayList arrayList = new ArrayList();
        for (SplitBillHistoryEntity splitBillHistoryEntity : list) {
            if (splitBillHistoryEntity != null) {
                arrayList.add(map(splitBillHistoryEntity));
            }
        }
        return arrayList;
    }

    private SplitBillHistoryResult map(SplitBillHistoryEntity splitBillHistoryEntity) {
        SplitBillHistoryResult splitBillHistoryResult = new SplitBillHistoryResult();
        List<SplitBillPayer> deserializeList = this.serializer.deserializeList(splitBillHistoryEntity.getPayers(), SplitBillPayer.class);
        splitBillHistoryResult.setAvatarPayersList(getAvatarPayers(deserializeList));
        splitBillHistoryResult.setComment(splitBillHistoryEntity.getComment());
        if (!isSplitBillHasCreatedDate(splitBillHistoryEntity)) {
            splitBillHistoryResult.setSplitBillDate(splitBillHistoryEntity.getLastUpdated() * 1000);
        } else {
            splitBillHistoryResult.setSplitBillDate(splitBillHistoryEntity.getCreatedDate());
        }
        if (!isHasTotalAmount(splitBillHistoryEntity)) {
            splitBillHistoryResult.setTotalAmount(calculate(deserializeList));
        } else {
            CurrencyAmountResult currencyAmountResult = new CurrencyAmountResult();
            currencyAmountResult.setAmount(splitBillHistoryEntity.getTotalAmount());
            splitBillHistoryResult.setTotalAmount(currencyAmountResult);
        }
        splitBillHistoryResult.setStatus(splitBillHistoryEntity.getStatus());
        splitBillHistoryResult.setSplitBillId(splitBillHistoryEntity.getSplitBillId());
        return splitBillHistoryResult;
    }

    private CurrencyAmountResult calculate(List<SplitBillPayer> list) {
        Iterator<SplitBillPayer> it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += Long.valueOf(it.next().getFundAmount()).longValue();
        }
        CurrencyAmountResult currencyAmountResult = new CurrencyAmountResult();
        currencyAmountResult.setCurrency("Rp");
        currencyAmountResult.setAmount(String.valueOf(j));
        return currencyAmountResult;
    }

    private List<String> getAvatarPayers(List<SplitBillPayer> list) {
        ArrayList arrayList = new ArrayList();
        for (SplitBillPayer splitBillPayer : list) {
            if (splitBillPayer != null) {
                arrayList.add(splitBillPayer.getImageUrl());
            }
        }
        return arrayList;
    }

    private boolean isSplitBillHasCreatedDate(SplitBillHistoryEntity splitBillHistoryEntity) {
        return splitBillHistoryEntity.getCreatedDate() != 0;
    }

    private boolean isHasTotalAmount(SplitBillHistoryEntity splitBillHistoryEntity) {
        return (TextUtils.isEmpty(splitBillHistoryEntity.getTotalAmount()) || Long.valueOf(NumberUtils.getCleanDot(splitBillHistoryEntity.getTotalAmount())).longValue() == 0) ? false : true;
    }
}
