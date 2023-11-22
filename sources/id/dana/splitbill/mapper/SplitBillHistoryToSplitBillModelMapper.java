package id.dana.splitbill.mapper;

import android.text.TextUtils;
import id.dana.data.base.BaseMapper;
import id.dana.domain.splitbill.model.SplitBillHistory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import id.dana.splitbill.model.PayerModel;
import id.dana.splitbill.model.SplitBillModel;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SplitBillHistoryToSplitBillModelMapper extends BaseMapper<SplitBillHistory, SplitBillModel> {
    private final PayerModelListMapper MyBillsEntityDataFactory;
    private final CurrencyAmountModelMapper getAuthRequestContext;

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ SplitBillModel map(SplitBillHistory splitBillHistory) {
        int parseInt;
        int parseInt2;
        SplitBillHistory splitBillHistory2 = splitBillHistory;
        if (splitBillHistory2 != null) {
            SplitBillModel splitBillModel = new SplitBillModel();
            splitBillModel.moveToNextValue = splitBillHistory2.getStatus();
            splitBillModel.BuiltInFictitiousFunctionClassFactory = splitBillHistory2.getComment();
            splitBillModel.lookAheadTest = this.getAuthRequestContext.apply(splitBillHistory2.getTotalAmount());
            splitBillModel.scheduleImpl = splitBillHistory2.getSplitBillId();
            splitBillModel.getAuthRequestContext = Integer.valueOf(splitBillHistory2.getPayeeIndex()).intValue();
            splitBillModel.MyBillsEntityDataFactory = Integer.valueOf(splitBillHistory2.getPayerIndex()).intValue();
            List<PayerModel> apply = this.MyBillsEntityDataFactory.apply(splitBillHistory2.getPayers());
            splitBillModel.PlaceComponentResult = apply;
            if (!TextUtils.isEmpty(splitBillHistory2.getPayeeIndex()) && apply.size() > (parseInt2 = Integer.parseInt(splitBillHistory2.getPayeeIndex()))) {
                splitBillModel.getAuthRequestContext = parseInt2;
                apply.get(parseInt2).getErrorConfigVersion = true;
                splitBillModel.getErrorConfigVersion = apply.get(parseInt2);
            }
            if (TextUtils.isEmpty(splitBillHistory2.getPayerIndex()) || apply.size() <= (parseInt = Integer.parseInt(splitBillHistory2.getPayerIndex()))) {
                return splitBillModel;
            }
            splitBillModel.MyBillsEntityDataFactory = parseInt;
            apply.get(parseInt).getAuthRequestContext = true;
            splitBillModel.KClassImpl$Data$declaredNonStaticMembers$2 = apply.get(parseInt);
            return splitBillModel;
        }
        return null;
    }

    @Inject
    public SplitBillHistoryToSplitBillModelMapper(CurrencyAmountModelMapper currencyAmountModelMapper, PayerModelListMapper payerModelListMapper) {
        this.getAuthRequestContext = currencyAmountModelMapper;
        this.MyBillsEntityDataFactory = payerModelListMapper;
    }
}
