package id.dana.sendmoney.mapper;

import android.text.TextUtils;
import id.dana.data.base.BaseMapper;
import id.dana.domain.payasset.model.PayCardOptionView;
import id.dana.domain.payasset.model.PayChannelOptionView;
import id.dana.domain.sendmoney.model.AddPayMethod;
import id.dana.domain.sendmoney.model.PayOptionDTOResponse;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.withdraw.model.TransferMethodView;
import id.dana.domain.withdraw.model.WithdrawMethodOption;
import id.dana.model.CurrencyAmountModel;
import id.dana.model.PayMethodModel;
import id.dana.sendmoney.model.WithdrawMethodOptionModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class TransferMethodMapper extends BaseMapper<TransferInit, List<TransferMethod>> {
    private long BuiltInFictitiousFunctionClassFactory;
    private List<WithdrawMethodOptionModel> DatabaseTableConfigUtil;
    private CurrencyAmountModel KClassImpl$Data$declaredNonStaticMembers$2;
    private final CurrencyAmountModelMapper MyBillsEntityDataFactory;
    private List<PayMethodModel> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private List<AddPayMethod> PlaceComponentResult;
    private long getAuthRequestContext;
    private final WithdrawMethodOptionModelMapper getErrorConfigVersion;
    private TransferInit lookAheadTest;
    private List<PayMethodModel> moveToNextValue;
    private boolean scheduleImpl;

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<TransferMethod> map(TransferInit transferInit) {
        ArrayList arrayList;
        TransferInit transferInit2 = transferInit;
        this.lookAheadTest = transferInit2;
        ArrayList arrayList2 = new ArrayList();
        Iterator<TransferMethodView> it = transferInit2.getTransferMethod().iterator();
        while (it.hasNext()) {
            TransferMethodView next = it.next();
            TransferMethod transferMethod = new TransferMethod();
            transferMethod.BuiltInFictitiousFunctionClassFactory = new CurrencyAmountModel(next.getChargeAmount());
            transferMethod.PlaceComponentResult = next.getFreeRemainedTimes();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new CurrencyAmountModel(next.getChargeAmount());
            this.BuiltInFictitiousFunctionClassFactory = next.getFreeTimes();
            long freeRemainedTimes = next.getFreeRemainedTimes();
            this.getAuthRequestContext = freeRemainedTimes;
            transferMethod.KClassImpl$Data$declaredNonStaticMembers$2 = freeRemainedTimes;
            transferMethod.MyBillsEntityDataFactory = next.getTransferMethod();
            if (next.getPayOptionDTOResponses() != null) {
                List<PayOptionDTOResponse> payOptionDTOResponses = next.getPayOptionDTOResponses();
                this.moveToNextValue = new ArrayList();
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ArrayList();
                this.PlaceComponentResult = new ArrayList();
                int i = 0;
                while (i < payOptionDTOResponses.size()) {
                    PayOptionDTOResponse payOptionDTOResponse = payOptionDTOResponses.get(i);
                    String fundType = payOptionDTOResponse.getFundType();
                    CurrencyAmountModel currencyAmountModel = new CurrencyAmountModel(payOptionDTOResponse.getPayerMaxAmount());
                    CurrencyAmountModel currencyAmountModel2 = new CurrencyAmountModel(payOptionDTOResponse.getPayerMinAmount());
                    for (PayChannelOptionView payChannelOptionView : payOptionDTOResponse.getPayMethodView().getPayChannelOptionViews()) {
                        List<PayMethodModel> list = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        PayMethodModel payMethodModel = new PayMethodModel();
                        payMethodModel.MyBillsEntityDataFactory = payChannelOptionView.isEnableStatus();
                        payMethodModel.lookAheadTest = payChannelOptionView.getInstId();
                        payMethodModel.KClassImpl$Data$declaredNonStaticMembers$2 = "ADD_CARD";
                        payMethodModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = payChannelOptionView.getInstName();
                        payMethodModel.getErrorConfigVersion = payChannelOptionView.getInstLocalName();
                        payMethodModel.NetworkUserEntityData$$ExternalSyntheticLambda7 = payChannelOptionView.getPayOption();
                        payMethodModel.newProxyInstance = payChannelOptionView.getPayMethod();
                        payMethodModel.DatabaseTableConfigUtil = CurrencyAmountModelMapper.getAuthRequestContext(payChannelOptionView.getMinAmount());
                        payMethodModel.GetContactSyncConfig = CurrencyAmountModelMapper.getAuthRequestContext(payChannelOptionView.getMaxAmount());
                        payMethodModel.moveToNextValue = fundType;
                        list.add(payMethodModel);
                        it = it;
                    }
                    Iterator<TransferMethodView> it2 = it;
                    if (!BuiltInFictitiousFunctionClassFactory(payOptionDTOResponse)) {
                        arrayList = arrayList2;
                        if (!MyBillsEntityDataFactory(payOptionDTOResponse)) {
                            if (!this.scheduleImpl) {
                                List<PayMethodModel> list2 = this.moveToNextValue;
                                PayMethodModel payMethodModel2 = new PayMethodModel();
                                payMethodModel2.NetworkUserEntityData$$ExternalSyntheticLambda8 = PayMethodModel.SectionTitle.DEBIT_CARD;
                                list2.add(payMethodModel2);
                                this.scheduleImpl = true;
                            }
                            for (Iterator<PayCardOptionView> it3 = payOptionDTOResponse.getPayMethodView().getPayCardOptionViews().iterator(); it3.hasNext(); it3 = it3) {
                                PayCardOptionView next2 = it3.next();
                                List<PayMethodModel> list3 = this.moveToNextValue;
                                PayMethodModel payMethodModel3 = new PayMethodModel();
                                payMethodModel3.getAuthRequestContext = next2.getCardIndexNo();
                                payMethodModel3.KClassImpl$Data$declaredNonStaticMembers$2 = next2.getCardScheme();
                                payMethodModel3.NetworkUserEntityData$$ExternalSyntheticLambda2 = next2.getMaskedCardNo();
                                payMethodModel3.MyBillsEntityDataFactory = next2.isEnableStatus();
                                payMethodModel3.lookAheadTest = next2.getInstId();
                                payMethodModel3.NetworkUserEntityData$$ExternalSyntheticLambda1 = next2.getInstName();
                                payMethodModel3.getErrorConfigVersion = next2.getInstLocalName();
                                payMethodModel3.NetworkUserEntityData$$ExternalSyntheticLambda7 = next2.getPayOption();
                                payMethodModel3.MyBillsEntityDataFactory = next2.isEnableStatus();
                                payMethodModel3.newProxyInstance = next2.getPayMethod();
                                payMethodModel3.moveToNextValue = fundType;
                                payMethodModel3.BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2;
                                payMethodModel3.scheduleImpl = this.getAuthRequestContext;
                                payMethodModel3.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.BuiltInFictitiousFunctionClassFactory;
                                PlaceComponentResult(payMethodModel3, currencyAmountModel, currencyAmountModel2);
                                list3.add(payMethodModel3);
                            }
                        }
                    } else {
                        List<PayMethodModel> list4 = this.moveToNextValue;
                        PayMethodModel payMethodModel4 = new PayMethodModel();
                        payMethodModel4.NetworkUserEntityData$$ExternalSyntheticLambda8 = "BALANCE";
                        list4.add(payMethodModel4);
                        Iterator<PayChannelOptionView> it4 = payOptionDTOResponse.getPayMethodView().getPayChannelOptionViews().iterator();
                        while (it4.hasNext()) {
                            PayChannelOptionView next3 = it4.next();
                            List<PayMethodModel> list5 = this.moveToNextValue;
                            TransferInit transferInit3 = this.lookAheadTest;
                            PayMethodModel payMethodModel5 = new PayMethodModel();
                            payMethodModel5.PlaceComponentResult = new CurrencyAmountModel(transferInit3.getPayerAccountBalance());
                            payMethodModel5.NetworkUserEntityData$$ExternalSyntheticLambda2 = transferInit3.getPayerMaskedPhoneNumber();
                            payMethodModel5.initRecordTimeStamp = transferInit3.getKyc();
                            payMethodModel5.lookAheadTest = next3.getInstId();
                            payMethodModel5.newProxyInstance = next3.getPayMethod();
                            payMethodModel5.NetworkUserEntityData$$ExternalSyntheticLambda7 = next3.getPayOption();
                            payMethodModel5.MyBillsEntityDataFactory = next3.isEnableStatus();
                            payMethodModel5.moveToNextValue = fundType;
                            payMethodModel5.GetContactSyncConfig = currencyAmountModel;
                            payMethodModel5.DatabaseTableConfigUtil = currencyAmountModel2;
                            payMethodModel5.BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2;
                            payMethodModel5.scheduleImpl = this.getAuthRequestContext;
                            payMethodModel5.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.BuiltInFictitiousFunctionClassFactory;
                            list5.add(payMethodModel5);
                            it4 = it4;
                            arrayList2 = arrayList2;
                        }
                        arrayList = arrayList2;
                    }
                    if (payOptionDTOResponse.getPayMethodView().getAddPayMethods() != null) {
                        this.PlaceComponentResult.addAll(payOptionDTOResponse.getPayMethodView().getAddPayMethods());
                    }
                    if (BuiltInFictitiousFunctionClassFactory(i, payOptionDTOResponses.size(), payOptionDTOResponse) && this.PlaceComponentResult != null) {
                        PayMethodModel payMethodModel6 = new PayMethodModel();
                        payMethodModel6.NetworkUserEntityData$$ExternalSyntheticLambda8 = PayMethodModel.SectionTitle.ADD_CARD;
                        this.moveToNextValue.add(payMethodModel6);
                        for (AddPayMethod addPayMethod : this.PlaceComponentResult) {
                            if (addPayMethod.isEnable()) {
                                PayMethodModel payMethodModel7 = new PayMethodModel();
                                payMethodModel7.KClassImpl$Data$declaredNonStaticMembers$2 = "ADD_CARD";
                                if (!TextUtils.isEmpty(addPayMethod.getInstId())) {
                                    payMethodModel7.lookAheadTest = addPayMethod.getInstId();
                                }
                                payMethodModel7.getErrorConfigVersion = addPayMethod.getInstLocalName();
                                payMethodModel7.newProxyInstance = addPayMethod.getPayMethod();
                                payMethodModel7.MyBillsEntityDataFactory = addPayMethod.isEnable();
                                payMethodModel7.isLayoutRequested = addPayMethod.getUrl();
                                payMethodModel7.moveToNextValue = fundType;
                                payMethodModel7.BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2;
                                payMethodModel7.scheduleImpl = this.getAuthRequestContext;
                                payMethodModel7.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.BuiltInFictitiousFunctionClassFactory;
                                PlaceComponentResult(payMethodModel7, currencyAmountModel, currencyAmountModel2);
                                if (TextUtils.isEmpty(payMethodModel7.lookAheadTest)) {
                                    int indexOf = this.moveToNextValue.indexOf(payMethodModel6);
                                    if (indexOf >= 0) {
                                        this.moveToNextValue.add(indexOf + 1, payMethodModel7);
                                    } else {
                                        this.moveToNextValue.add(payMethodModel7);
                                    }
                                } else {
                                    this.moveToNextValue.add(payMethodModel7);
                                }
                            }
                        }
                    }
                    i++;
                    it = it2;
                    arrayList2 = arrayList;
                }
            }
            Iterator<TransferMethodView> it5 = it;
            ArrayList arrayList3 = arrayList2;
            if (next.getWithdrawMethodOptions() != null) {
                List<WithdrawMethodOption> withdrawMethodOptions = next.getWithdrawMethodOptions();
                ArrayList arrayList4 = new ArrayList();
                this.DatabaseTableConfigUtil = arrayList4;
                arrayList4.addAll(this.getErrorConfigVersion.apply(withdrawMethodOptions));
            }
            transferMethod.getAuthRequestContext = this.moveToNextValue;
            transferMethod.scheduleImpl = this.DatabaseTableConfigUtil;
            arrayList3.add(transferMethod);
            this.scheduleImpl = false;
            arrayList2 = arrayList3;
            it = it5;
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public TransferMethodMapper(CurrencyAmountModelMapper currencyAmountModelMapper, WithdrawMethodOptionModelMapper withdrawMethodOptionModelMapper) {
        this.MyBillsEntityDataFactory = currencyAmountModelMapper;
        this.getErrorConfigVersion = withdrawMethodOptionModelMapper;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(PayOptionDTOResponse payOptionDTOResponse) {
        return "BALANCE".equals(payOptionDTOResponse.getPayMethod());
    }

    private static boolean MyBillsEntityDataFactory(PayOptionDTOResponse payOptionDTOResponse) {
        return payOptionDTOResponse.getPayMethodView().getPayCardOptionViews().isEmpty();
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(int i, int i2, PayOptionDTOResponse payOptionDTOResponse) {
        return i == i2 - 1 && !BuiltInFictitiousFunctionClassFactory(payOptionDTOResponse);
    }

    private void PlaceComponentResult(PayMethodModel payMethodModel, CurrencyAmountModel currencyAmountModel, CurrencyAmountModel currencyAmountModel2) {
        for (PayMethodModel payMethodModel2 : this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            if (payMethodModel2.NetworkUserEntityData$$ExternalSyntheticLambda7.equals(payMethodModel.NetworkUserEntityData$$ExternalSyntheticLambda7) || (payMethodModel2.newProxyInstance.equals(payMethodModel.newProxyInstance) && payMethodModel2.lookAheadTest.equals(payMethodModel.lookAheadTest))) {
                if (payMethodModel2.GetContactSyncConfig != null) {
                    currencyAmountModel = payMethodModel2.GetContactSyncConfig;
                }
                if (payMethodModel2.GetContactSyncConfig != null) {
                    currencyAmountModel2 = payMethodModel2.DatabaseTableConfigUtil;
                }
            }
        }
        payMethodModel.GetContactSyncConfig = currencyAmountModel;
        payMethodModel.DatabaseTableConfigUtil = currencyAmountModel2;
    }
}
