package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.sendmoney.model.PayOptionDTOResponse;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.user.CurrencyAmount;
import id.dana.domain.withdraw.model.TransferMethodView;
import id.dana.domain.withdraw.model.WithdrawMethodOption;
import id.dana.model.CurrencyAmountModel;
import id.dana.sendmoney.model.TransferAmountConfig;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class TransferBankMapper extends BaseMapper<TransferInit, TransferAmountConfig> {
    public String BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ TransferAmountConfig map(TransferInit transferInit) {
        TransferMethodView transferMethodView;
        List<PayOptionDTOResponse> payOptionDTOResponses;
        CurrencyAmountModel currencyAmountModel;
        TransferInit transferInit2 = transferInit;
        TransferAmountConfig transferAmountConfig = null;
        if (transferInit2 != null && transferInit2.getTransferMethod() != null) {
            String str = this.BuiltInFictitiousFunctionClassFactory;
            Iterator<TransferMethodView> it = transferInit2.getTransferMethod().iterator();
            while (true) {
                if (!it.hasNext()) {
                    transferMethodView = null;
                    break;
                }
                transferMethodView = it.next();
                if (str.equals(transferMethodView.getTransferMethod())) {
                    break;
                }
            }
            if (transferMethodView != null) {
                transferAmountConfig = new TransferAmountConfig();
                List<WithdrawMethodOption> withdrawMethodOptions = transferMethodView.getWithdrawMethodOptions();
                if ("OTC".equals(this.BuiltInFictitiousFunctionClassFactory) && withdrawMethodOptions != null && withdrawMethodOptions.get(0).getWithdrawChannelOptions() != null) {
                    payOptionDTOResponses = withdrawMethodOptions.get(0).getWithdrawChannelOptions().get(0).getPayOptionDTOResponses();
                } else {
                    payOptionDTOResponses = transferMethodView.getPayOptionDTOResponses();
                }
                if (transferMethodView.getTransferMaxAmount() != null) {
                    CurrencyAmount transferMaxAmount = transferMethodView.getTransferMaxAmount();
                    transferAmountConfig.MyBillsEntityDataFactory = new CurrencyAmountModel(transferMaxAmount.getAmount(), transferMaxAmount.getCurrency());
                } else {
                    CurrencyAmount payerMaxAmount = payOptionDTOResponses.get(0).getPayerMaxAmount();
                    CurrencyAmountModel currencyAmountModel2 = new CurrencyAmountModel(payerMaxAmount.getAmount(), payerMaxAmount.getCurrency());
                    Iterator<PayOptionDTOResponse> it2 = payOptionDTOResponses.iterator();
                    while (it2.hasNext()) {
                        CurrencyAmount payerMaxAmount2 = it2.next().getPayerMaxAmount();
                        CurrencyAmountModel currencyAmountModel3 = new CurrencyAmountModel(payerMaxAmount2.getAmount(), payerMaxAmount2.getCurrency());
                        if (currencyAmountModel3.getAuthRequestContext(currencyAmountModel2)) {
                            currencyAmountModel2 = currencyAmountModel3;
                        }
                    }
                    transferAmountConfig.MyBillsEntityDataFactory = currencyAmountModel2;
                }
                if (transferMethodView.getTransferMinAmount() != null) {
                    CurrencyAmount transferMinAmount = transferMethodView.getTransferMinAmount();
                    currencyAmountModel = new CurrencyAmountModel(transferMinAmount.getAmount(), transferMinAmount.getCurrency());
                } else {
                    CurrencyAmount payerMinAmount = payOptionDTOResponses.get(0).getPayerMinAmount();
                    CurrencyAmountModel currencyAmountModel4 = new CurrencyAmountModel(payerMinAmount.getAmount(), payerMinAmount.getCurrency());
                    Iterator<PayOptionDTOResponse> it3 = payOptionDTOResponses.iterator();
                    currencyAmountModel = currencyAmountModel4;
                    while (it3.hasNext()) {
                        CurrencyAmount payerMinAmount2 = it3.next().getPayerMinAmount();
                        CurrencyAmountModel currencyAmountModel5 = new CurrencyAmountModel(payerMinAmount2.getAmount(), payerMinAmount2.getCurrency());
                        if (currencyAmountModel5.KClassImpl$Data$declaredNonStaticMembers$2(currencyAmountModel)) {
                            currencyAmountModel = currencyAmountModel5;
                        }
                    }
                    CurrencyAmountModel currencyAmountModel6 = new CurrencyAmountModel("1");
                    if (currencyAmountModel.KClassImpl$Data$declaredNonStaticMembers$2(currencyAmountModel6)) {
                        currencyAmountModel = currencyAmountModel6;
                    }
                }
                transferAmountConfig.PlaceComponentResult = currencyAmountModel;
                CurrencyAmount chargeAmount = transferMethodView.getChargeAmount();
                transferAmountConfig.NetworkUserEntityData$$ExternalSyntheticLambda0 = new CurrencyAmountModel(chargeAmount.getAmount(), chargeAmount.getCurrency());
                if (transferMethodView.getFreeFeeMinAmount() != null) {
                    CurrencyAmount freeFeeMinAmount = transferMethodView.getFreeFeeMinAmount();
                    transferAmountConfig.BuiltInFictitiousFunctionClassFactory = new CurrencyAmountModel(freeFeeMinAmount.getAmount(), freeFeeMinAmount.getCurrency());
                }
                if (transferInit2.getTransferMethod().get(0).getPayeeMaxBalanceAmount() != null) {
                    transferAmountConfig.getAuthRequestContext = new CurrencyAmountModel(transferInit2.getTransferMethod().get(0).getPayeeMaxBalanceAmount());
                }
                if (transferInit2.getTransferMethod().get(0).getPayeeMaxMonthFundInAmount() != null) {
                    transferAmountConfig.moveToNextValue = new CurrencyAmountModel(transferInit2.getTransferMethod().get(0).getPayeeMaxMonthFundInAmount());
                }
                if (transferInit2.getTransferMethod().get(0).getPayeeMonthConsumedAmount() != null) {
                    transferAmountConfig.getErrorConfigVersion = new CurrencyAmountModel(transferInit2.getTransferMethod().get(0).getPayeeMonthConsumedAmount());
                }
                if (transferInit2.getPayeeAccountBalance() != null) {
                    transferAmountConfig.KClassImpl$Data$declaredNonStaticMembers$2 = new CurrencyAmountModel(transferInit2.getPayeeAccountBalance());
                }
                if (transferInit2.getPayeeMaxTransferAmount() != null) {
                    transferAmountConfig.scheduleImpl = new CurrencyAmountModel(transferInit2.getPayeeMaxTransferAmount());
                }
            }
        }
        return transferAmountConfig;
    }

    @Inject
    public TransferBankMapper() {
    }
}
