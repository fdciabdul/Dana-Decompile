package id.dana.cashier.mapper;

import id.dana.cashier.domain.model.AssetCard;
import id.dana.cashier.domain.model.PayMethodViewDto;
import id.dana.cashier.domain.model.TopUpConsult;
import id.dana.cashier.model.AssetCardModelKt;
import id.dana.cashier.model.PayMethodViewDtoModel;
import id.dana.cashier.model.TopUpConsultModel;
import id.dana.data.base.BaseMapper;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/mapper/TopUpConsultModelMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/cashier/domain/model/TopUpConsult;", "Lid/dana/cashier/model/TopUpConsultModel;", "Lid/dana/cashier/mapper/CashierPayChannelModelsMapper;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/mapper/CashierPayChannelModelsMapper;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/cashier/mapper/CashierPayChannelModelsMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TopUpConsultModelMapper extends BaseMapper<TopUpConsult, TopUpConsultModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final CashierPayChannelModelsMapper PlaceComponentResult;

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ TopUpConsultModel map(TopUpConsult topUpConsult) {
        ArrayList arrayList;
        TopUpConsult topUpConsult2 = topUpConsult;
        if (topUpConsult2 != null) {
            Boolean canSaveCC = topUpConsult2.getCanSaveCC();
            List<String> cardSchemes = topUpConsult2.getCardSchemes();
            MoneyView currentMonthFundInAmount = topUpConsult2.getCurrentMonthFundInAmount();
            MoneyViewModel.Companion companion = MoneyViewModel.INSTANCE;
            MoneyViewModel PlaceComponentResult = MoneyViewModel.Companion.PlaceComponentResult(currentMonthFundInAmount);
            MoneyView maxAmount = topUpConsult2.getMaxAmount();
            MoneyViewModel.Companion companion2 = MoneyViewModel.INSTANCE;
            MoneyViewModel PlaceComponentResult2 = MoneyViewModel.Companion.PlaceComponentResult(maxAmount);
            MoneyView maxBalanceAmount = topUpConsult2.getMaxBalanceAmount();
            MoneyViewModel.Companion companion3 = MoneyViewModel.INSTANCE;
            MoneyViewModel PlaceComponentResult3 = MoneyViewModel.Companion.PlaceComponentResult(maxBalanceAmount);
            MoneyView maxMonthFundInAmount = topUpConsult2.getMaxMonthFundInAmount();
            MoneyViewModel.Companion companion4 = MoneyViewModel.INSTANCE;
            MoneyViewModel PlaceComponentResult4 = MoneyViewModel.Companion.PlaceComponentResult(maxMonthFundInAmount);
            MoneyView minAmount = topUpConsult2.getMinAmount();
            MoneyViewModel.Companion companion5 = MoneyViewModel.INSTANCE;
            MoneyViewModel PlaceComponentResult5 = MoneyViewModel.Companion.PlaceComponentResult(minAmount);
            List<PayMethodViewDto> payMethodViewDTOs = topUpConsult2.getPayMethodViewDTOs();
            if (payMethodViewDTOs != null) {
                List<PayMethodViewDto> list = payMethodViewDTOs;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (PayMethodViewDto payMethodViewDto : list) {
                    String defaultChannelOption = payMethodViewDto.getDefaultChannelOption();
                    List<AssetCard> payCardOptionViewDtos = payMethodViewDto.getPayCardOptionViewDtos();
                    arrayList2.add(new PayMethodViewDtoModel(defaultChannelOption, payCardOptionViewDtos != null ? AssetCardModelKt.MyBillsEntityDataFactory(payCardOptionViewDtos) : null, this.PlaceComponentResult.apply(payMethodViewDto.getPayChannelOptionViewDtos()), payMethodViewDto.getPayMethod()));
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            return new TopUpConsultModel(canSaveCC, cardSchemes, PlaceComponentResult, PlaceComponentResult2, PlaceComponentResult3, PlaceComponentResult4, PlaceComponentResult5, arrayList, topUpConsult2.getExpressPayAgreementToken(), topUpConsult2.getMaskedLoginId(), topUpConsult2.getReachSaveCardLimit(), topUpConsult2.getSaveCardLimitNumber(), topUpConsult2.getUserAccountName(), topUpConsult2.getAssetAssignNo(), topUpConsult2.getSuccess(), topUpConsult2.getErrorCode(), topUpConsult2.getErrorMessage());
        }
        return null;
    }

    @Inject
    public TopUpConsultModelMapper(CashierPayChannelModelsMapper cashierPayChannelModelsMapper) {
        Intrinsics.checkNotNullParameter(cashierPayChannelModelsMapper, "");
        this.PlaceComponentResult = cashierPayChannelModelsMapper;
    }
}
