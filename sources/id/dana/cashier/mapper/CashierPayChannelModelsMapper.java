package id.dana.cashier.mapper;

import id.dana.cashier.domain.model.CashierAddOnChannelSupportInfo;
import id.dana.cashier.domain.model.CashierPayChannelInfo;
import id.dana.cashier.domain.model.ExtendCashierInfo;
import id.dana.cashier.domain.model.paylater.DanaCredit;
import id.dana.cashier.domain.model.paylater.LoanCreditChannelInfo;
import id.dana.cashier.model.AddOnChannelSupportInfo;
import id.dana.cashier.model.CashierPayChannelModel;
import id.dana.cashier.model.DanaCreditModel;
import id.dana.cashier.model.DanaCreditModelKt;
import id.dana.cashier.model.ExtendCashierModel;
import id.dana.cashier.model.ExtendCashierModelKt;
import id.dana.cashier.model.LoanCreditChannelInfoModel;
import id.dana.cashier.model.RepaymentPlanModel;
import id.dana.cashier.model.RepaymentPlanModelKt;
import id.dana.cashier.model.VoucherCashierModel;
import id.dana.data.base.BaseMapper;
import id.dana.data.config.model.PayLaterMethodConfig;
import id.dana.domain.model.cashier.PayMethodRisk;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.payasset.model.AmountRange;
import id.dana.domain.paylater.model.PaylaterCicilMethodConfig;
import id.dana.domain.user.CurrencyAmount;
import id.dana.model.CurrencyAmountModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModelKt;
import id.dana.sendmoney.model.PayMethodRiskModel;
import id.dana.statement.model.UserStatementModelKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/cashier/mapper/CashierPayChannelModelsMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/cashier/domain/model/CashierPayChannelInfo;", "Lid/dana/cashier/model/CashierPayChannelModel;", "Lid/dana/cashier/mapper/VoucherCashierModelsMapper;", "getAuthRequestContext", "Lid/dana/cashier/mapper/VoucherCashierModelsMapper;", "p0", "<init>", "(Lid/dana/cashier/mapper/VoucherCashierModelsMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPayChannelModelsMapper extends BaseMapper<List<? extends CashierPayChannelInfo>, List<? extends CashierPayChannelModel>> {
    private final VoucherCashierModelsMapper getAuthRequestContext;

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ List<? extends CashierPayChannelModel> map(List<? extends CashierPayChannelInfo> list) {
        MoneyViewModel authRequestContext;
        MoneyViewModel moneyViewModel;
        Iterator it;
        ArrayList arrayList;
        ArrayList arrayList2;
        CurrencyAmount minAmount;
        CurrencyAmount maxAmount;
        MoneyView availableQuota;
        List<? extends CashierPayChannelInfo> list2 = list;
        if (list2 != null) {
            List<? extends CashierPayChannelInfo> list3 = list2;
            int i = 10;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator it2 = list3.iterator();
            while (it2.hasNext()) {
                CashierPayChannelInfo cashierPayChannelInfo = (CashierPayChannelInfo) it2.next();
                DanaCredit danaCredit = cashierPayChannelInfo.getDanaCredit();
                if ((danaCredit != null ? danaCredit.getAvailableQuota() : null) != null) {
                    DanaCredit danaCredit2 = cashierPayChannelInfo.getDanaCredit();
                    if (danaCredit2 != null && (availableQuota = danaCredit2.getAvailableQuota()) != null) {
                        authRequestContext = MoneyViewModelKt.getAuthRequestContext(availableQuota);
                        moneyViewModel = authRequestContext;
                    }
                    moneyViewModel = null;
                } else {
                    MoneyView balanceAmount = cashierPayChannelInfo.getBalanceAmount();
                    if (balanceAmount != null) {
                        authRequestContext = MoneyViewModelKt.getAuthRequestContext(balanceAmount);
                        moneyViewModel = authRequestContext;
                    }
                    moneyViewModel = null;
                }
                String bankPhoneNo = cashierPayChannelInfo.getBankPhoneNo();
                Boolean canUse = cashierPayChannelInfo.getCanUse();
                String cardBrand = cashierPayChannelInfo.getCardBrand();
                List<String> cardBrands = cashierPayChannelInfo.getCardBrands();
                Boolean directDebit = cashierPayChannelInfo.getDirectDebit();
                String disableCode = cashierPayChannelInfo.getDisableCode();
                String disableReason = cashierPayChannelInfo.getDisableReason();
                Boolean enableStatus = cashierPayChannelInfo.getEnableStatus();
                ExtendCashierInfo extendInfo = cashierPayChannelInfo.getExtendInfo();
                ExtendCashierModel PlaceComponentResult = extendInfo != null ? ExtendCashierModelKt.PlaceComponentResult(extendInfo) : null;
                String index = cashierPayChannelInfo.getIndex();
                String instId = cashierPayChannelInfo.getInstId();
                String instName = cashierPayChannelInfo.getInstName();
                Boolean instSupportDirectDebit = cashierPayChannelInfo.getInstSupportDirectDebit();
                Integer maxPeriod = cashierPayChannelInfo.getMaxPeriod();
                String name = cashierPayChannelInfo.getName();
                String payMethod = cashierPayChannelInfo.getPayMethod();
                PayMethodRisk payMethodRiskResult = cashierPayChannelInfo.getPayMethodRiskResult();
                PayMethodRiskModel payMethodRiskModel = payMethodRiskResult != null ? new PayMethodRiskModel(payMethodRiskResult.getMaskPhoneNumber(), payMethodRiskResult.getResult(), payMethodRiskResult.getRiskInfo(), payMethodRiskResult.getVerificationMethod(), payMethodRiskResult.getVerificationPriority()) : null;
                String promoDescription = cashierPayChannelInfo.getPromoDescription();
                Boolean promoStatus = cashierPayChannelInfo.getPromoStatus();
                String serviceInstId = cashierPayChannelInfo.getServiceInstId();
                String serviceInstName = cashierPayChannelInfo.getServiceInstName();
                String viewConfigShortDescription = cashierPayChannelInfo.getViewConfigShortDescription();
                List<String> viewConfigIconList = cashierPayChannelInfo.getViewConfigIconList();
                List<? extends VoucherCashierModel> apply = this.getAuthRequestContext.apply(cashierPayChannelInfo.getVoucherList());
                Boolean pivotCard = cashierPayChannelInfo.getPivotCard();
                String bankName = cashierPayChannelInfo.getBankName();
                String bankCode = cashierPayChannelInfo.getBankCode();
                AmountRange amountRange = cashierPayChannelInfo.getAmountRange();
                CurrencyAmountModel PlaceComponentResult2 = (amountRange == null || (maxAmount = amountRange.getMaxAmount()) == null) ? null : UserStatementModelKt.PlaceComponentResult(maxAmount);
                AmountRange amountRange2 = cashierPayChannelInfo.getAmountRange();
                CurrencyAmountModel PlaceComponentResult3 = (amountRange2 == null || (minAmount = amountRange2.getMinAmount()) == null) ? null : UserStatementModelKt.PlaceComponentResult(minAmount);
                Boolean interBank = cashierPayChannelInfo.getInterBank();
                String payAccountNo = cashierPayChannelInfo.getPayAccountNo();
                String payOption = cashierPayChannelInfo.getPayOption();
                String companyCode = cashierPayChannelInfo.getCompanyCode();
                String serviceBankCode = cashierPayChannelInfo.getServiceBankCode();
                DanaCredit danaCredit3 = cashierPayChannelInfo.getDanaCredit();
                DanaCreditModel PlaceComponentResult4 = danaCredit3 != null ? DanaCreditModelKt.PlaceComponentResult(danaCredit3) : null;
                List<RepaymentPlanModel> authRequestContext2 = RepaymentPlanModelKt.getAuthRequestContext(cashierPayChannelInfo.getRepaymentPlans());
                PayLaterMethodConfig payLaterMethodConfig = cashierPayChannelInfo.getPayLaterMethodConfig();
                PaylaterCicilMethodConfig payLaterCicilMethodConfig = cashierPayChannelInfo.getPayLaterCicilMethodConfig();
                List<CashierAddOnChannelSupportInfo> addOnChannelSupportInfos = cashierPayChannelInfo.getAddOnChannelSupportInfos();
                if (addOnChannelSupportInfos != null) {
                    List<CashierAddOnChannelSupportInfo> list4 = addOnChannelSupportInfos;
                    ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, i));
                    Iterator it3 = list4.iterator();
                    while (it3.hasNext()) {
                        CashierAddOnChannelSupportInfo cashierAddOnChannelSupportInfo = (CashierAddOnChannelSupportInfo) it3.next();
                        arrayList4.add(new AddOnChannelSupportInfo(cashierAddOnChannelSupportInfo.getStatus(), cashierAddOnChannelSupportInfo.getGoodsId(), cashierAddOnChannelSupportInfo.getDisableReason()));
                        it3 = it3;
                        it2 = it2;
                    }
                    it = it2;
                    arrayList = arrayList4;
                } else {
                    it = it2;
                    arrayList = null;
                }
                List<LoanCreditChannelInfo> loanCreditChannelInfos = cashierPayChannelInfo.getLoanCreditChannelInfos();
                if (loanCreditChannelInfos != null) {
                    List<LoanCreditChannelInfo> list5 = loanCreditChannelInfos;
                    ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
                    for (Iterator it4 = list5.iterator(); it4.hasNext(); it4 = it4) {
                        LoanCreditChannelInfo loanCreditChannelInfo = (LoanCreditChannelInfo) it4.next();
                        arrayList5.add(new LoanCreditChannelInfoModel(loanCreditChannelInfo.getNeedRegistration(), loanCreditChannelInfo.getMerchantId(), loanCreditChannelInfo.getSubMerchantId()));
                    }
                    arrayList2 = arrayList5;
                } else {
                    arrayList2 = null;
                }
                MoneyView chargeAmount = cashierPayChannelInfo.getChargeAmount();
                MoneyViewModel authRequestContext3 = chargeAmount != null ? MoneyViewModelKt.getAuthRequestContext(chargeAmount) : null;
                MoneyView foreignBalanceAmount = cashierPayChannelInfo.getForeignBalanceAmount();
                arrayList3.add(new CashierPayChannelModel(bankCode, bankName, moneyViewModel, authRequestContext3, bankPhoneNo, canUse, cardBrand, cardBrands, directDebit, disableCode, disableReason, enableStatus, PlaceComponentResult, index, instId, instName, instSupportDirectDebit, maxPeriod, name, payMethod, payMethodRiskModel, promoDescription, promoStatus, serviceInstId, serviceInstName, viewConfigShortDescription, viewConfigIconList, apply, pivotCard, PlaceComponentResult2, PlaceComponentResult3, interBank, payAccountNo, payOption, companyCode, serviceBankCode, PlaceComponentResult4, authRequestContext2, payLaterMethodConfig, payLaterCicilMethodConfig, arrayList, arrayList2, foreignBalanceAmount != null ? MoneyViewModelKt.getAuthRequestContext(foreignBalanceAmount) : null));
                it2 = it;
                i = 10;
            }
            return arrayList3;
        }
        return null;
    }

    @Inject
    public CashierPayChannelModelsMapper(VoucherCashierModelsMapper voucherCashierModelsMapper) {
        Intrinsics.checkNotNullParameter(voucherCashierModelsMapper, "");
        this.getAuthRequestContext = voucherCashierModelsMapper;
    }
}
