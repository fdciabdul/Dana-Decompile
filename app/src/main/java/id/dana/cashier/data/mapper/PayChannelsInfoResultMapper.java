package id.dana.cashier.data.mapper;

import id.dana.cashier.data.repository.source.network.result.AddOnChannelSupportInfosResult;
import id.dana.cashier.data.repository.source.network.result.ExtendInfoResult;
import id.dana.cashier.data.repository.source.network.result.ExtendInfoResultKt;
import id.dana.cashier.data.repository.source.network.result.PayChannelResult;
import id.dana.cashier.data.repository.source.network.result.PromoInfoResult;
import id.dana.cashier.data.repository.source.network.result.ViewConfigInfoResult;
import id.dana.cashier.domain.model.CashierAddOnChannelSupportInfo;
import id.dana.cashier.domain.model.CashierPayChannelInfo;
import id.dana.cashier.domain.model.ExtendCashierInfo;
import id.dana.cashier.domain.model.VoucherCashierInfo;
import id.dana.cashier.domain.model.paylater.DanaCredit;
import id.dana.cashier.domain.model.paylater.LoanCreditChannelInfo;
import id.dana.cashier.domain.model.paylater.RepaymentInfo;
import id.dana.cashier.domain.model.paylater.RepaymentPlan;
import id.dana.data.base.BaseMapper;
import id.dana.data.model.cashier.PayMethodRiskResult;
import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.data.payasset.source.network.result.AmountRangeResult;
import id.dana.data.paylater.repository.source.network.result.DanaCreditResult;
import id.dana.data.paylater.repository.source.network.result.LoanCreditChannelInfosResult;
import id.dana.data.paylater.repository.source.network.result.RepaymentInfoResult;
import id.dana.data.paylater.repository.source.network.result.RepaymentPlanResult;
import id.dana.data.sendmoney.mapper.PayMethodRiskResultMapper;
import id.dana.domain.model.cashier.PayMethodRisk;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.payasset.model.AmountRange;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b0\u00101J%\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u000e\u001a\u00020\r*\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u0004*\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0014\u001a\u00020\u0013*\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0002*\b\u0012\u0004\u0012\u00020\b0\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0007J\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0002*\b\u0012\u0004\u0012\u00020\u00170\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u0007J\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0002*\b\u0012\u0004\u0012\u00020\u001a0\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\u0007J\u001f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0002*\b\u0012\u0004\u0012\u00020\u001d0\u0002H\u0002¢\u0006\u0004\b\u001f\u0010\u0007J\u0013\u0010 \u001a\u00020\u0018*\u00020\u0017H\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u0006*\u00020#0#*\u00020\"H\u0002¢\u0006\u0004\b$\u0010%J\u0013\u0010&\u001a\u00020\u001b*\u00020\u001aH\u0002¢\u0006\u0004\b&\u0010'J\u0013\u0010(\u001a\u00020\u001e*\u00020\u001dH\u0002¢\u0006\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/"}, d2 = {"Lid/dana/cashier/data/mapper/PayChannelsInfoResultMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/cashier/data/repository/source/network/result/PayChannelResult;", "Lid/dana/cashier/domain/model/CashierPayChannelInfo;", "oldItem", "map", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/cashier/data/repository/source/network/result/AddOnChannelSupportInfosResult;", "Lid/dana/cashier/domain/model/CashierAddOnChannelSupportInfo;", "toAddOnChannelSupportInfo", "(Lid/dana/cashier/data/repository/source/network/result/AddOnChannelSupportInfosResult;)Lid/dana/cashier/domain/model/CashierAddOnChannelSupportInfo;", "Lid/dana/data/payasset/source/network/result/AmountRangeResult;", "Lid/dana/domain/payasset/model/AmountRange;", "toAmountRange", "(Lid/dana/data/payasset/source/network/result/AmountRangeResult;)Lid/dana/domain/payasset/model/AmountRange;", "toCashierPayChannelInfo", "(Lid/dana/cashier/data/repository/source/network/result/PayChannelResult;)Lid/dana/cashier/domain/model/CashierPayChannelInfo;", "Lid/dana/data/paylater/repository/source/network/result/DanaCreditResult;", "Lid/dana/cashier/domain/model/paylater/DanaCredit;", "toDanaCredit", "(Lid/dana/data/paylater/repository/source/network/result/DanaCreditResult;)Lid/dana/cashier/domain/model/paylater/DanaCredit;", "toListCashierAddOnChannelSupportInfo", "Lid/dana/data/paylater/repository/source/network/result/LoanCreditChannelInfosResult;", "Lid/dana/cashier/domain/model/paylater/LoanCreditChannelInfo;", "toListLoanCreditChannelInfo", "Lid/dana/data/paylater/repository/source/network/result/RepaymentInfoResult;", "Lid/dana/cashier/domain/model/paylater/RepaymentInfo;", "toListOfRepaymentInfo", "Lid/dana/data/paylater/repository/source/network/result/RepaymentPlanResult;", "Lid/dana/cashier/domain/model/paylater/RepaymentPlan;", "toListOfRepaymentPlan", "toLoanCreditChannelInfo", "(Lid/dana/data/paylater/repository/source/network/result/LoanCreditChannelInfosResult;)Lid/dana/cashier/domain/model/paylater/LoanCreditChannelInfo;", "Lid/dana/data/model/cashier/PayMethodRiskResult;", "Lid/dana/domain/model/cashier/PayMethodRisk;", "toPayMethodRisk", "(Lid/dana/data/model/cashier/PayMethodRiskResult;)Lid/dana/domain/model/cashier/PayMethodRisk;", "toRepaymentInfo", "(Lid/dana/data/paylater/repository/source/network/result/RepaymentInfoResult;)Lid/dana/cashier/domain/model/paylater/RepaymentInfo;", "toRepaymentPlan", "(Lid/dana/data/paylater/repository/source/network/result/RepaymentPlanResult;)Lid/dana/cashier/domain/model/paylater/RepaymentPlan;", "Lid/dana/data/sendmoney/mapper/PayMethodRiskResultMapper;", "payMethodRiskResultMapper", "Lid/dana/data/sendmoney/mapper/PayMethodRiskResultMapper;", "Lid/dana/cashier/data/mapper/VoucherInfoResultsMapper;", "voucherInfoResultsMapper", "Lid/dana/cashier/data/mapper/VoucherInfoResultsMapper;", "<init>", "(Lid/dana/data/sendmoney/mapper/PayMethodRiskResultMapper;Lid/dana/cashier/data/mapper/VoucherInfoResultsMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PayChannelsInfoResultMapper extends BaseMapper<List<? extends PayChannelResult>, List<? extends CashierPayChannelInfo>> {
    private final PayMethodRiskResultMapper payMethodRiskResultMapper;
    private final VoucherInfoResultsMapper voucherInfoResultsMapper;

    @Override // id.dana.data.base.BaseMapper
    public final /* bridge */ /* synthetic */ List<? extends CashierPayChannelInfo> map(List<? extends PayChannelResult> list) {
        return map2((List<PayChannelResult>) list);
    }

    @Inject
    public PayChannelsInfoResultMapper(PayMethodRiskResultMapper payMethodRiskResultMapper, VoucherInfoResultsMapper voucherInfoResultsMapper) {
        Intrinsics.checkNotNullParameter(payMethodRiskResultMapper, "");
        Intrinsics.checkNotNullParameter(voucherInfoResultsMapper, "");
        this.payMethodRiskResultMapper = payMethodRiskResultMapper;
        this.voucherInfoResultsMapper = voucherInfoResultsMapper;
    }

    /* renamed from: map  reason: avoid collision after fix types in other method */
    protected final List<CashierPayChannelInfo> map2(List<PayChannelResult> oldItem) {
        ArrayList arrayList;
        if (oldItem != null) {
            List<PayChannelResult> list = oldItem;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(toCashierPayChannelInfo((PayChannelResult) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private final CashierPayChannelInfo toCashierPayChannelInfo(PayChannelResult payChannelResult) {
        MoneyViewEntity balanceAmount = payChannelResult.getBalanceAmount();
        MoneyView moneyView = balanceAmount != null ? MoneyViewEntityMapperKt.toMoneyView(balanceAmount) : null;
        MoneyViewEntity chargeAmount = payChannelResult.getChargeAmount();
        MoneyView moneyView2 = chargeAmount != null ? MoneyViewEntityMapperKt.toMoneyView(chargeAmount) : null;
        String bankPhoneNo = payChannelResult.getBankPhoneNo();
        Boolean canUse = payChannelResult.getCanUse();
        String cardBrand = payChannelResult.getCardBrand();
        List<String> cardBrands = payChannelResult.getCardBrands();
        Boolean directDebit = payChannelResult.getDirectDebit();
        String disableCode = payChannelResult.getDisableCode();
        String disableReason = payChannelResult.getDisableReason();
        Boolean enableStatus = payChannelResult.getEnableStatus();
        ExtendInfoResult extendInfo = payChannelResult.getExtendInfo();
        ExtendCashierInfo extendCashierInfo = extendInfo != null ? ExtendInfoResultKt.toExtendCashierInfo(extendInfo) : null;
        String index = payChannelResult.getIndex();
        String instId = payChannelResult.getInstId();
        String instName = payChannelResult.getInstName();
        Boolean instSupportDirectDebit = payChannelResult.getInstSupportDirectDebit();
        Integer maxPeriod = payChannelResult.getMaxPeriod();
        String name = payChannelResult.getName();
        String payMethod = payChannelResult.getPayMethod();
        PayMethodRiskResult payMethodRiskResult = payChannelResult.getPayMethodRiskResult();
        PayMethodRisk payMethodRisk = payMethodRiskResult != null ? toPayMethodRisk(payMethodRiskResult) : null;
        PromoInfoResult promo = payChannelResult.getPromo();
        String description = promo != null ? promo.getDescription() : null;
        PromoInfoResult promo2 = payChannelResult.getPromo();
        Boolean status = promo2 != null ? promo2.getStatus() : null;
        String serviceInstId = payChannelResult.getServiceInstId();
        String serviceInstName = payChannelResult.getServiceInstName();
        ViewConfigInfoResult viewConfig = payChannelResult.getViewConfig();
        String shortDescription = viewConfig != null ? viewConfig.getShortDescription() : null;
        ViewConfigInfoResult viewConfig2 = payChannelResult.getViewConfig();
        List<String> iconList = viewConfig2 != null ? viewConfig2.getIconList() : null;
        List<? extends VoucherCashierInfo> apply = this.voucherInfoResultsMapper.apply(payChannelResult.getVoucherList());
        Boolean pivotCard = payChannelResult.getPivotCard();
        String bankCode = payChannelResult.getBankCode();
        String bankName = payChannelResult.getBankName();
        AmountRangeResult amountRange = payChannelResult.getAmountRange();
        AmountRange amountRange2 = amountRange != null ? toAmountRange(amountRange) : null;
        Boolean interBank = payChannelResult.getInterBank();
        String payAccountNo = payChannelResult.getPayAccountNo();
        String payOption = payChannelResult.getPayOption();
        String companyCode = payChannelResult.getCompanyCode();
        String serviceBankCode = payChannelResult.getServiceBankCode();
        DanaCreditResult danaCredit = payChannelResult.getDanaCredit();
        DanaCredit danaCredit2 = danaCredit != null ? toDanaCredit(danaCredit) : null;
        List<RepaymentPlanResult> repaymentPlans = payChannelResult.getRepaymentPlans();
        List<RepaymentPlan> listOfRepaymentPlan = repaymentPlans != null ? toListOfRepaymentPlan(repaymentPlans) : null;
        if (listOfRepaymentPlan == null) {
            listOfRepaymentPlan = CollectionsKt.emptyList();
        }
        List<RepaymentPlan> list = listOfRepaymentPlan;
        List<AddOnChannelSupportInfosResult> addOnChannelSupportInfosResult = payChannelResult.getAddOnChannelSupportInfosResult();
        List<CashierAddOnChannelSupportInfo> listCashierAddOnChannelSupportInfo = addOnChannelSupportInfosResult != null ? toListCashierAddOnChannelSupportInfo(addOnChannelSupportInfosResult) : null;
        List<LoanCreditChannelInfosResult> loanCreditChannelInfos = payChannelResult.getLoanCreditChannelInfos();
        return new CashierPayChannelInfo(bankCode, bankName, moneyView, moneyView2, bankPhoneNo, canUse, cardBrand, cardBrands, directDebit, disableCode, disableReason, enableStatus, extendCashierInfo, index, instId, instName, instSupportDirectDebit, maxPeriod, name, payMethod, payMethodRisk, description, status, serviceInstId, serviceInstName, shortDescription, iconList, apply, pivotCard, amountRange2, interBank, payAccountNo, payOption, companyCode, serviceBankCode, danaCredit2, list, null, null, listCashierAddOnChannelSupportInfo, loanCreditChannelInfos != null ? toListLoanCreditChannelInfo(loanCreditChannelInfos) : null, MoneyViewEntityMapperKt.toMoneyView(payChannelResult.getForeignBalanceAmount()), 0, 96, null);
    }

    private final List<RepaymentPlan> toListOfRepaymentPlan(List<RepaymentPlanResult> list) {
        List<RepaymentPlanResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toRepaymentPlan((RepaymentPlanResult) it.next()));
        }
        return arrayList;
    }

    private final RepaymentPlan toRepaymentPlan(RepaymentPlanResult repaymentPlanResult) {
        Integer period = repaymentPlanResult.getPeriod();
        MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(repaymentPlanResult.getAmount());
        List<RepaymentInfoResult> repaymentInfo = repaymentPlanResult.getRepaymentInfo();
        List<RepaymentInfo> listOfRepaymentInfo = repaymentInfo != null ? toListOfRepaymentInfo(repaymentInfo) : null;
        if (listOfRepaymentInfo == null) {
            listOfRepaymentInfo = CollectionsKt.emptyList();
        }
        return new RepaymentPlan(period, moneyView, listOfRepaymentInfo, repaymentPlanResult.getRecommended());
    }

    private final List<RepaymentInfo> toListOfRepaymentInfo(List<RepaymentInfoResult> list) {
        List<RepaymentInfoResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toRepaymentInfo((RepaymentInfoResult) it.next()));
        }
        return arrayList;
    }

    private final RepaymentInfo toRepaymentInfo(RepaymentInfoResult repaymentInfoResult) {
        String repaymentDueDate = repaymentInfoResult.getRepaymentDueDate();
        if (repaymentDueDate == null) {
            repaymentDueDate = "";
        }
        return new RepaymentInfo(repaymentDueDate, MoneyViewEntityMapperKt.toMoneyView(repaymentInfoResult.getRepaymentAmount()), MoneyViewEntityMapperKt.toMoneyView(repaymentInfoResult.getRepaymentAmountWithFee()), MoneyViewEntityMapperKt.toMoneyView(repaymentInfoResult.getPrincipalAmount()), MoneyViewEntityMapperKt.toMoneyView(repaymentInfoResult.getInterestFeeAmount()), MoneyViewEntityMapperKt.toMoneyView(repaymentInfoResult.getLateFeeAmount()));
    }

    private final DanaCredit toDanaCredit(DanaCreditResult danaCreditResult) {
        return new DanaCredit(MoneyViewEntityMapperKt.toMoneyView(danaCreditResult.getAvailableQuota()), MoneyViewEntityMapperKt.toMoneyView(danaCreditResult.getInitCreditQuota()), danaCreditResult.getInstallmentPlanId(), MoneyViewEntityMapperKt.toMoneyView(danaCreditResult.getTotalAmount()));
    }

    private final PayMethodRisk toPayMethodRisk(PayMethodRiskResult payMethodRiskResult) {
        return this.payMethodRiskResultMapper.apply(payMethodRiskResult);
    }

    private final AmountRange toAmountRange(AmountRangeResult amountRangeResult) {
        AmountRange amountRange = new AmountRange();
        amountRange.setMaxAmount(amountRangeResult.maxAmount.toCurrencyAmount());
        amountRange.setMinAmount(amountRangeResult.minAmount.toCurrencyAmount());
        return amountRange;
    }

    private final List<CashierAddOnChannelSupportInfo> toListCashierAddOnChannelSupportInfo(List<AddOnChannelSupportInfosResult> list) {
        List<AddOnChannelSupportInfosResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toAddOnChannelSupportInfo((AddOnChannelSupportInfosResult) it.next()));
        }
        return arrayList;
    }

    private final CashierAddOnChannelSupportInfo toAddOnChannelSupportInfo(AddOnChannelSupportInfosResult addOnChannelSupportInfosResult) {
        return new CashierAddOnChannelSupportInfo(addOnChannelSupportInfosResult.getStatus(), addOnChannelSupportInfosResult.getGoodsId(), addOnChannelSupportInfosResult.getDisableReason());
    }

    private final List<LoanCreditChannelInfo> toListLoanCreditChannelInfo(List<LoanCreditChannelInfosResult> list) {
        List<LoanCreditChannelInfosResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toLoanCreditChannelInfo((LoanCreditChannelInfosResult) it.next()));
        }
        return arrayList;
    }

    private final LoanCreditChannelInfo toLoanCreditChannelInfo(LoanCreditChannelInfosResult loanCreditChannelInfosResult) {
        return new LoanCreditChannelInfo(loanCreditChannelInfosResult.getNeedRegistration(), loanCreditChannelInfosResult.getMerchantId(), loanCreditChannelInfosResult.getSubMerchantId());
    }
}
