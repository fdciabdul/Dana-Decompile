package id.dana.data.promoquest;

import id.dana.data.promoquest.repository.source.network.result.RedeemQuestEntityResult;
import id.dana.data.promoquest.repository.source.network.result.RedeemUserMissionResult;
import id.dana.data.promoquest.repository.source.result.PrizeInfoEntityResult;
import id.dana.data.sendmoney.mapper.CurrencyAmountResultMapper;
import id.dana.domain.promoquest.model.MissionRedeem;
import id.dana.domain.promoquest.model.PrizeInfoEntity;
import id.dana.domain.promoquest.model.QuestRedeem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class RedeemQuestEntityMapper {
    private final CurrencyAmountResultMapper currencyAmountResultMapper;

    @Inject
    public RedeemQuestEntityMapper(CurrencyAmountResultMapper currencyAmountResultMapper) {
        this.currencyAmountResultMapper = currencyAmountResultMapper;
    }

    public QuestRedeem transform(RedeemQuestEntityResult redeemQuestEntityResult) {
        if (redeemQuestEntityResult != null) {
            QuestRedeem questRedeem = new QuestRedeem();
            questRedeem.setPrizeInfoList(transform(redeemQuestEntityResult.getPrizeInfoList()));
            return questRedeem;
        }
        return null;
    }

    public MissionRedeem transformMission(RedeemUserMissionResult redeemUserMissionResult) {
        MissionRedeem emptyData = MissionRedeem.emptyData();
        if (redeemUserMissionResult == null || !redeemUserMissionResult.success) {
            return emptyData;
        }
        MissionRedeem missionRedeem = new MissionRedeem();
        missionRedeem.setPrizeInfoList(transform(redeemUserMissionResult.getPrizeInfoList()));
        return missionRedeem;
    }

    private List<PrizeInfoEntity> transform(List<PrizeInfoEntityResult> list) {
        if (list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<PrizeInfoEntityResult> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(transform(it.next()));
        }
        return arrayList;
    }

    private PrizeInfoEntity transform(PrizeInfoEntityResult prizeInfoEntityResult) {
        if (prizeInfoEntityResult != null) {
            PrizeInfoEntity prizeInfoEntity = new PrizeInfoEntity();
            prizeInfoEntity.setPrizeId(prizeInfoEntityResult.getPrizeId());
            prizeInfoEntity.setPrizeType(prizeInfoEntityResult.getPrizeType());
            prizeInfoEntity.setVoucherId(prizeInfoEntityResult.getVoucherId());
            prizeInfoEntity.setVoucherName(prizeInfoEntityResult.getVoucherName());
            prizeInfoEntity.setPrizeMoneyAmount(this.currencyAmountResultMapper.apply(prizeInfoEntityResult.getPrizeMoneyAmount()));
            return prizeInfoEntity;
        }
        return null;
    }
}
