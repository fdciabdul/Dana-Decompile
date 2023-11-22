package id.dana.data.splitbill.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.foundation.utils.CommonUtil;
import id.dana.data.splitbill.repository.source.persistence.entity.SplitBillHistoryEntity;
import id.dana.data.storage.Serializer;
import id.dana.domain.splitbill.model.SplitBill;
import id.dana.domain.splitbill.model.SplitBillPayer;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class SplitBillToSplitBillEntityMapper extends BaseMapper<SplitBill, SplitBillHistoryEntity> {
    private String deeplinkUrl;
    private final Serializer serializer;
    private String splitBillId;

    @Inject
    public SplitBillToSplitBillEntityMapper(Serializer serializer) {
        this.serializer = serializer;
    }

    public void setSplitBillId(String str) {
        this.splitBillId = str;
    }

    public void setDeeplinkUrl(String str) {
        this.deeplinkUrl = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public SplitBillHistoryEntity map(SplitBill splitBill) {
        String totalAmount = getTotalAmount(splitBill.getPayers());
        return new SplitBillHistoryEntity(splitBill.getComment(), this.deeplinkUrl, this.serializer.serialize(splitBill.getPayers()), this.splitBillId, totalAmount, CommonUtil.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    private String getTotalAmount(List<SplitBillPayer> list) {
        Iterator<SplitBillPayer> it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += Long.valueOf(it.next().getFundAmount()).longValue();
        }
        return String.valueOf(j);
    }
}
