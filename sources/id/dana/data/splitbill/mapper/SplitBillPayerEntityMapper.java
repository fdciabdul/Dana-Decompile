package id.dana.data.splitbill.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.qrbarcode.repository.source.network.request.SplitBillPayerEntity;
import id.dana.data.util.NumberUtils;
import id.dana.domain.splitbill.model.SplitBillPayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class SplitBillPayerEntityMapper extends BaseMapper<List<SplitBillPayer>, List<SplitBillPayerEntity>> {
    private static final String DEFAULT_PAYER_KEY = "splitBillPayer";

    @Inject
    public SplitBillPayerEntityMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<SplitBillPayerEntity> map(List<SplitBillPayer> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<SplitBillPayer> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(map(it.next()));
            }
            return arrayList;
        }
        return new ArrayList();
    }

    private SplitBillPayerEntity map(SplitBillPayer splitBillPayer) {
        SplitBillPayerEntity splitBillPayerEntity = new SplitBillPayerEntity();
        splitBillPayerEntity.fundAmount = splitBillPayer.getFundAmount();
        splitBillPayerEntity.name = DEFAULT_PAYER_KEY.equals(splitBillPayer.getName()) ? "" : splitBillPayer.getName();
        splitBillPayerEntity.userId = splitBillPayer.getUserId();
        splitBillPayerEntity.loginId = NumberUtils.getIndoPhoneNumber(splitBillPayer.getLoginId());
        return splitBillPayerEntity;
    }
}
