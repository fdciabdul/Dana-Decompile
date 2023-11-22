package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.model.CurrencyAmountModel;
import id.dana.sendmoney.model.PayOptionDTO;
import id.dana.sendmoney.model.SendMoneyInitModel;
import id.dana.sendmoney.model.TransferAmountConfig;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class TransferContactMapper extends BaseMapper<SendMoneyInitModel, TransferAmountConfig> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ TransferAmountConfig map(SendMoneyInitModel sendMoneyInitModel) {
        SendMoneyInitModel sendMoneyInitModel2 = sendMoneyInitModel;
        TransferAmountConfig transferAmountConfig = new TransferAmountConfig();
        List<PayOptionDTO> list = sendMoneyInitModel2.BuiltInFictitiousFunctionClassFactory;
        CurrencyAmountModel currencyAmountModel = list.get(0).BuiltInFictitiousFunctionClassFactory;
        Iterator<PayOptionDTO> it = list.iterator();
        while (it.hasNext()) {
            CurrencyAmountModel currencyAmountModel2 = it.next().BuiltInFictitiousFunctionClassFactory;
            if (currencyAmountModel2.getAuthRequestContext(currencyAmountModel)) {
                currencyAmountModel = currencyAmountModel2;
            }
        }
        transferAmountConfig.MyBillsEntityDataFactory = currencyAmountModel;
        List<PayOptionDTO> list2 = sendMoneyInitModel2.BuiltInFictitiousFunctionClassFactory;
        CurrencyAmountModel currencyAmountModel3 = list2.get(0).getAuthRequestContext;
        Iterator<PayOptionDTO> it2 = list2.iterator();
        while (it2.hasNext()) {
            CurrencyAmountModel currencyAmountModel4 = it2.next().getAuthRequestContext;
            if (currencyAmountModel4.KClassImpl$Data$declaredNonStaticMembers$2(currencyAmountModel3)) {
                currencyAmountModel3 = currencyAmountModel4;
            }
        }
        CurrencyAmountModel currencyAmountModel5 = new CurrencyAmountModel("1");
        if (currencyAmountModel3.KClassImpl$Data$declaredNonStaticMembers$2(currencyAmountModel5)) {
            currencyAmountModel3 = currencyAmountModel5;
        }
        transferAmountConfig.PlaceComponentResult = currencyAmountModel3;
        return transferAmountConfig;
    }

    @Inject
    public TransferContactMapper() {
    }
}
