package id.dana.domain.promoquest.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public class MissionRedeem {
    private List<PrizeInfoEntity> prizeInfoList = Collections.emptyList();

    public List<PrizeInfoEntity> getPrizeInfoList() {
        List<PrizeInfoEntity> list = this.prizeInfoList;
        return list == null ? new ArrayList() : list;
    }

    public void setPrizeInfoList(List<PrizeInfoEntity> list) {
        this.prizeInfoList = list;
    }

    public static MissionRedeem emptyData() {
        return new MissionRedeem();
    }

    public boolean isEmpty() {
        return this.prizeInfoList.isEmpty();
    }
}
