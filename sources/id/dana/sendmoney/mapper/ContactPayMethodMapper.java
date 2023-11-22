package id.dana.sendmoney.mapper;

import android.text.TextUtils;
import id.dana.data.base.BaseMapper;
import id.dana.domain.payasset.model.Institution;
import id.dana.domain.payasset.model.PayCardOptionView;
import id.dana.domain.payasset.model.PayMethodView;
import id.dana.domain.sendmoney.model.AddPayMethod;
import id.dana.domain.sendmoney.model.PayOptionDTOResponse;
import id.dana.domain.sendmoney.model.SendMoneyInit;
import id.dana.domain.user.CurrencyAmount;
import id.dana.model.CurrencyAmountModel;
import id.dana.model.PayMethodModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class ContactPayMethodMapper extends BaseMapper<SendMoneyInit, List<PayMethodModel>> {
    private List<AddPayMethod> getAuthRequestContext;

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<PayMethodModel> map(SendMoneyInit sendMoneyInit) {
        SendMoneyInit sendMoneyInit2 = sendMoneyInit;
        ArrayList arrayList = new ArrayList();
        this.getAuthRequestContext = new ArrayList();
        PayMethodModel payMethodModel = new PayMethodModel();
        payMethodModel.NetworkUserEntityData$$ExternalSyntheticLambda8 = "BALANCE";
        arrayList.add(payMethodModel);
        PayMethodModel payMethodModel2 = new PayMethodModel();
        if (sendMoneyInit2.getPayerAccountBalance() != null) {
            CurrencyAmount payerAccountBalance = sendMoneyInit2.getPayerAccountBalance();
            payMethodModel2.PlaceComponentResult = payerAccountBalance == null ? null : new CurrencyAmountModel(payerAccountBalance.getAmount(), payerAccountBalance.getCurrency());
        }
        payMethodModel2.NetworkUserEntityData$$ExternalSyntheticLambda2 = sendMoneyInit2.getPayeeMaskedPhoneNumber();
        payMethodModel2.initRecordTimeStamp = sendMoneyInit2.getKyc().getLevel();
        payMethodModel2.lookAheadTest = Institution.DANA;
        payMethodModel2.newProxyInstance = "BALANCE";
        CurrencyAmount currencyAmount = new CurrencyAmount(sendMoneyInit2.getPayerMaxAmount().getAmount(), "Rp");
        payMethodModel2.GetContactSyncConfig = new CurrencyAmountModel(currencyAmount.getAmount(), currencyAmount.getCurrency());
        CurrencyAmount currencyAmount2 = new CurrencyAmount(sendMoneyInit2.getPayerMinAmount().getAmount(), "Rp");
        payMethodModel2.DatabaseTableConfigUtil = new CurrencyAmountModel(currencyAmount2.getAmount(), currencyAmount2.getCurrency());
        arrayList.add(payMethodModel2);
        List<PayOptionDTOResponse> payOptions = sendMoneyInit2.getPayOptions();
        ArrayList arrayList2 = new ArrayList();
        for (PayOptionDTOResponse payOptionDTOResponse : payOptions) {
            PayMethodView payMethodView = payOptionDTOResponse.getPayMethodView();
            CurrencyAmount payerMaxAmount = payOptionDTOResponse.getPayerMaxAmount();
            CurrencyAmountModel currencyAmountModel = payerMaxAmount == null ? null : new CurrencyAmountModel(payerMaxAmount.getAmount(), payerMaxAmount.getCurrency());
            CurrencyAmount payerMinAmount = payOptionDTOResponse.getPayerMinAmount();
            CurrencyAmountModel currencyAmountModel2 = payerMinAmount == null ? null : new CurrencyAmountModel(payerMinAmount.getAmount(), payerMinAmount.getCurrency());
            String fundType = payOptionDTOResponse.getFundType();
            List<PayCardOptionView> payCardOptionViews = payMethodView.getPayCardOptionViews();
            if (payCardOptionViews != null && !payCardOptionViews.isEmpty()) {
                if (arrayList2.isEmpty()) {
                    PayMethodModel payMethodModel3 = new PayMethodModel();
                    payMethodModel3.NetworkUserEntityData$$ExternalSyntheticLambda8 = PayMethodModel.SectionTitle.DEBIT_CARD;
                    arrayList2.add(payMethodModel3);
                }
                for (PayCardOptionView payCardOptionView : payCardOptionViews) {
                    PayMethodModel payMethodModel4 = new PayMethodModel();
                    payMethodModel4.NetworkUserEntityData$$ExternalSyntheticLambda2 = payCardOptionView.getMaskedCardNo();
                    payMethodModel4.KClassImpl$Data$declaredNonStaticMembers$2 = payCardOptionView.getCardScheme();
                    payMethodModel4.MyBillsEntityDataFactory = payCardOptionView.isEnableStatus();
                    payMethodModel4.lookAheadTest = payCardOptionView.getInstId();
                    payMethodModel4.getAuthRequestContext = payCardOptionView.getCardIndexNo();
                    payMethodModel4.NetworkUserEntityData$$ExternalSyntheticLambda1 = payCardOptionView.getInstName();
                    payMethodModel4.getErrorConfigVersion = payCardOptionView.getInstLocalName();
                    payMethodModel4.MyBillsEntityDataFactory = payCardOptionView.isEnableStatus();
                    payMethodModel4.newProxyInstance = payOptionDTOResponse.getPayMethod();
                    payMethodModel4.moveToNextValue = fundType;
                    payMethodModel4.GetContactSyncConfig = currencyAmountModel;
                    payMethodModel4.DatabaseTableConfigUtil = currencyAmountModel2;
                    arrayList2.add(payMethodModel4);
                }
            }
        }
        arrayList.addAll(arrayList2);
        if (this.getAuthRequestContext != null) {
            Iterator<PayOptionDTOResponse> it = sendMoneyInit2.getPayOptions().iterator();
            while (it.hasNext()) {
                this.getAuthRequestContext = it.next().getPayMethodView().getAddPayMethods();
            }
            PayMethodModel payMethodModel5 = new PayMethodModel();
            payMethodModel5.NetworkUserEntityData$$ExternalSyntheticLambda8 = PayMethodModel.SectionTitle.ADD_CARD;
            arrayList.add(payMethodModel5);
            for (AddPayMethod addPayMethod : this.getAuthRequestContext) {
                if (addPayMethod.isEnable()) {
                    PayMethodModel payMethodModel6 = new PayMethodModel();
                    payMethodModel6.KClassImpl$Data$declaredNonStaticMembers$2 = "ADD_CARD";
                    if (!TextUtils.isEmpty(addPayMethod.getInstId())) {
                        payMethodModel6.lookAheadTest = addPayMethod.getInstId();
                    }
                    payMethodModel6.newProxyInstance = addPayMethod.getPayMethod();
                    payMethodModel6.MyBillsEntityDataFactory = addPayMethod.isEnable();
                    payMethodModel6.isLayoutRequested = addPayMethod.getUrl();
                    arrayList.add(payMethodModel6);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public ContactPayMethodMapper() {
    }
}
