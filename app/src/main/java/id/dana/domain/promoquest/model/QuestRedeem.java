package id.dana.domain.promoquest.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QuestRedeem {
    private List<PrizeInfoEntity> prizeInfoList;

    public List<PrizeInfoEntity> getPrizeInfoList() {
        List<PrizeInfoEntity> list = this.prizeInfoList;
        return list == null ? new ArrayList() : list;
    }

    public void setPrizeInfoList(List<PrizeInfoEntity> list) {
        this.prizeInfoList = list;
    }
}
