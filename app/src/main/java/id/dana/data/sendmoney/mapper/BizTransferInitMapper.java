package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.model.QrisTcicoEntryPointInfoEntityKt;
import id.dana.data.sendmoney.repository.source.network.result.BizTransferInitResult;
import id.dana.domain.sendmoney.model.AddPayMethod;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.user.CurrencyAmount;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class BizTransferInitMapper extends BaseMapper<BizTransferInitResult, TransferInit> {
    private List<AddPayMethod> addPayMethods;
    private final CurrencyAmountResultMapper currencyAmountResultMapper;
    private final WithdrawMethodViewResultMapper withdrawMethodViewResultMapper;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public BizTransferInitMapper(WithdrawMethodViewResultMapper withdrawMethodViewResultMapper, CurrencyAmountResultMapper currencyAmountResultMapper) {
        this.withdrawMethodViewResultMapper = withdrawMethodViewResultMapper;
        this.currencyAmountResultMapper = currencyAmountResultMapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public TransferInit map(BizTransferInitResult bizTransferInitResult) {
        CurrencyAmount currencyAmount = null;
        if (bizTransferInitResult != null) {
            this.withdrawMethodViewResultMapper.setAddPayMethods(this.addPayMethods);
            TransferInit.Builder payeeAccountBalance = new TransferInit.Builder().setNeedSenderName(bizTransferInitResult.needSenderName).setTransferMethod(this.withdrawMethodViewResultMapper.map(bizTransferInitResult.transferMethodInfo)).setKyc(bizTransferInitResult.payerUserInfo.getKycLevel()).setPayerMaskedNickname(bizTransferInitResult.payerUserInfo.getMaskedNickname()).setPayerMaskedPhoneNumber(bizTransferInitResult.payerUserInfo.getMaskedLoginId()).setPayerUserId(bizTransferInitResult.payerUserInfo.getUserId()).setPayerAccountBalance(this.currencyAmountResultMapper.map(bizTransferInitResult.payerUserInfo.getBalanceAmount())).setPayeeMaskedNickname(bizTransferInitResult.payeeUserInfo != null ? bizTransferInitResult.payeeUserInfo.getMaskedNickname() : "-").setPayeeMaskedPhoneNumber(bizTransferInitResult.payeeUserInfo != null ? bizTransferInitResult.payeeUserInfo.getMaskedLoginId() : "").setPayeeUserId(bizTransferInitResult.payeeUserInfo != null ? bizTransferInitResult.payeeUserInfo.getUserId() : "").setPayeeAvatar(bizTransferInitResult.payeeUserInfo != null ? bizTransferInitResult.payeeUserInfo.getAvatar() : "").setqrisTcicoEntryPoint(QrisTcicoEntryPointInfoEntityKt.toQrisTcicoEntryPoint(bizTransferInitResult.qrisTcicoEntryPointInfo)).setAccountFrozen(bizTransferInitResult.payeeUserInfo != null && bizTransferInitResult.payeeUserInfo.isAccountFrozen()).setUserFrozen(bizTransferInitResult.payeeUserInfo != null && bizTransferInitResult.payeeUserInfo.isUserFrozen()).setPayeeAccountBalance((bizTransferInitResult.payeeUserInfo == null || bizTransferInitResult.payeeUserInfo.getBalanceAmount() == null) ? null : this.currencyAmountResultMapper.map(bizTransferInitResult.payeeUserInfo.getBalanceAmount()));
            if (bizTransferInitResult.payeeUserInfo != null && bizTransferInitResult.payeeUserInfo.getBalanceAmount() != null) {
                currencyAmount = this.currencyAmountResultMapper.map(bizTransferInitResult.payeeUserInfo.getMaxTrxAmount());
            }
            return payeeAccountBalance.setPayeeMaxTransferAmount(currencyAmount).build();
        }
        return null;
    }

    public void setPayChannelFromAmcs(List<AddPayMethod> list) {
        this.addPayMethods = list;
    }
}
