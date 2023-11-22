package id.dana.data.splitbill.mapper;

import android.text.TextUtils;
import id.dana.data.base.BaseMapper;
import id.dana.data.splitbill.model.SplitBillDetailResult;
import id.dana.data.splitbill.model.SplitBillPayerResult;
import id.dana.data.splitbill.repository.source.network.response.GetSplitBillDetailResult;
import id.dana.data.splitbill.repository.source.persistence.entity.SplitBillHistoryEntity;
import id.dana.data.storage.Serializer;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class SplitBillHistoryEntityToSplitBillDetailResult extends BaseMapper<SplitBillHistoryEntity, GetSplitBillDetailResult> {
    private final Serializer serializer;

    @Inject
    public SplitBillHistoryEntityToSplitBillDetailResult(Serializer serializer) {
        this.serializer = serializer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public GetSplitBillDetailResult map(SplitBillHistoryEntity splitBillHistoryEntity) {
        if (splitBillHistoryEntity != null) {
            GetSplitBillDetailResult getSplitBillDetailResult = new GetSplitBillDetailResult();
            getSplitBillDetailResult.success = true;
            getSplitBillDetailResult.setSplitBillOrder(transform(splitBillHistoryEntity));
            return getSplitBillDetailResult;
        }
        return null;
    }

    private SplitBillDetailResult transform(SplitBillHistoryEntity splitBillHistoryEntity) {
        SplitBillDetailResult splitBillDetailResult = new SplitBillDetailResult();
        splitBillDetailResult.setSplitBillId(splitBillHistoryEntity.getSplitBillId());
        splitBillDetailResult.setStatus(splitBillHistoryEntity.getStatus());
        splitBillDetailResult.setComment(splitBillHistoryEntity.getComment());
        splitBillDetailResult.setPayeeIndex(String.valueOf(splitBillHistoryEntity.getPayeeIndex()));
        splitBillDetailResult.setPayerIndex(String.valueOf(splitBillHistoryEntity.getPayerIndex()));
        splitBillDetailResult.setPayersResult(this.serializer.deserializeList(splitBillHistoryEntity.getPayers(), SplitBillPayerResult.class));
        splitBillDetailResult.setPayerAmount(getPayerAmount(splitBillDetailResult));
        splitBillDetailResult.setDeeplinkUrl(splitBillHistoryEntity.getDeepLinkUrl());
        return splitBillDetailResult;
    }

    private String getPayerAmount(SplitBillDetailResult splitBillDetailResult) {
        if (TextUtils.isEmpty(splitBillDetailResult.getPayerIndex())) {
            return "";
        }
        return splitBillDetailResult.getPayersResult().get(Integer.valueOf(splitBillDetailResult.getPayeeIndex()).intValue()).getFundAmount();
    }
}
