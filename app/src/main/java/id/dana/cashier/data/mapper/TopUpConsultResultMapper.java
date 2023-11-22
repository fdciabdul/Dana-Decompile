package id.dana.cashier.data.mapper;

import id.dana.cashier.data.repository.source.network.result.AssetCardResult;
import id.dana.cashier.data.repository.source.network.result.AssetCardResultKt;
import id.dana.cashier.data.repository.source.network.result.PayMethodViewDtoResult;
import id.dana.cashier.data.repository.source.network.result.TopUpConsultResult;
import id.dana.cashier.domain.model.PayMethodViewDto;
import id.dana.cashier.domain.model.TopUpConsult;
import id.dana.data.base.BaseMapper;
import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.domain.nearbyme.model.MoneyView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\u00020\b*\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b*\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/cashier/data/mapper/TopUpConsultResultMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/cashier/data/repository/source/network/result/TopUpConsultResult;", "Lid/dana/cashier/domain/model/TopUpConsult;", "oldItem", "map", "(Lid/dana/cashier/data/repository/source/network/result/TopUpConsultResult;)Lid/dana/cashier/domain/model/TopUpConsult;", "Lid/dana/cashier/data/repository/source/network/result/PayMethodViewDtoResult;", "Lid/dana/cashier/domain/model/PayMethodViewDto;", "toPayMethodViewDto", "(Lid/dana/cashier/data/repository/source/network/result/PayMethodViewDtoResult;)Lid/dana/cashier/domain/model/PayMethodViewDto;", "", "toPayMethodViewDtos", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/cashier/data/mapper/PayChannelsInfoResultMapper;", "payChannelsInfoResultMapper", "Lid/dana/cashier/data/mapper/PayChannelsInfoResultMapper;", "<init>", "(Lid/dana/cashier/data/mapper/PayChannelsInfoResultMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TopUpConsultResultMapper extends BaseMapper<TopUpConsultResult, TopUpConsult> {
    private final PayChannelsInfoResultMapper payChannelsInfoResultMapper;

    @Inject
    public TopUpConsultResultMapper(PayChannelsInfoResultMapper payChannelsInfoResultMapper) {
        Intrinsics.checkNotNullParameter(payChannelsInfoResultMapper, "");
        this.payChannelsInfoResultMapper = payChannelsInfoResultMapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public final TopUpConsult map(TopUpConsultResult oldItem) {
        if (oldItem != null) {
            Boolean canSaveCC = oldItem.getCanSaveCC();
            List<String> cardSchemes = oldItem.getCardSchemes();
            MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(oldItem.getCurrentMonthFundInAmount());
            MoneyView moneyView2 = MoneyViewEntityMapperKt.toMoneyView(oldItem.getMaxAmount());
            MoneyView moneyView3 = MoneyViewEntityMapperKt.toMoneyView(oldItem.getMaxBalanceAmount());
            MoneyView moneyView4 = MoneyViewEntityMapperKt.toMoneyView(oldItem.getMaxMonthFundInAmount());
            MoneyView moneyView5 = MoneyViewEntityMapperKt.toMoneyView(oldItem.getMinAmount());
            List<PayMethodViewDtoResult> payMethodViewDTOs = oldItem.getPayMethodViewDTOs();
            return new TopUpConsult(canSaveCC, cardSchemes, moneyView, moneyView2, moneyView3, moneyView4, moneyView5, payMethodViewDTOs != null ? toPayMethodViewDtos(payMethodViewDTOs) : null, oldItem.getExpressPayAgreementToken(), oldItem.getMaskedLoginId(), oldItem.getReachSaveCardLimit(), oldItem.getSaveCardLimitNumber(), oldItem.getUserAccountName(), oldItem.getAssetAssignNo(), Boolean.valueOf(oldItem.success), oldItem.errorCode, oldItem.getErrorMsg());
        }
        return null;
    }

    private final List<PayMethodViewDto> toPayMethodViewDtos(List<PayMethodViewDtoResult> list) {
        List<PayMethodViewDtoResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toPayMethodViewDto((PayMethodViewDtoResult) it.next()));
        }
        return arrayList;
    }

    private final PayMethodViewDto toPayMethodViewDto(PayMethodViewDtoResult payMethodViewDtoResult) {
        String defaultChannelOption = payMethodViewDtoResult.getDefaultChannelOption();
        List<AssetCardResult> payCardOptionViewDTOs = payMethodViewDtoResult.getPayCardOptionViewDTOs();
        return new PayMethodViewDto(defaultChannelOption, payCardOptionViewDTOs != null ? AssetCardResultKt.toListAssetCardInfo(payCardOptionViewDTOs) : null, this.payChannelsInfoResultMapper.apply(payMethodViewDtoResult.getPayChannelOptionViewDTOs()), payMethodViewDtoResult.getPayMethod());
    }
}
