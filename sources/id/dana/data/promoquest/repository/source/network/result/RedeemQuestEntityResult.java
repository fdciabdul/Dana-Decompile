package id.dana.data.promoquest.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.promoquest.repository.source.result.PrizeInfoEntityResult;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class RedeemQuestEntityResult extends BaseRpcResult {
    private List<PrizeInfoEntityResult> prizeInfoList;

    public List<PrizeInfoEntityResult> getPrizeInfoList() {
        List<PrizeInfoEntityResult> list = this.prizeInfoList;
        return list == null ? new ArrayList() : list;
    }

    public void setPrizeInfoList(List<PrizeInfoEntityResult> list) {
        this.prizeInfoList = list;
    }
}
