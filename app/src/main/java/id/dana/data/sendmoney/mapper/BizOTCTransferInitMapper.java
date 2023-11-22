package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.model.QrisTcicoEntryPointInfoEntityKt;
import id.dana.data.sendmoney.repository.source.network.result.BizTransferInitResult;
import id.dana.domain.sendmoney.model.AddPayMethod;
import id.dana.domain.sendmoney.model.OTCTransferInit;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class BizOTCTransferInitMapper extends BaseMapper<BizTransferInitResult, OTCTransferInit> {
    private String acceptExpiryTimeUnit;
    private String acceptExpiryTimeValue;
    private List<AddPayMethod> addPayMethods;
    private final CurrencyAmountResultMapper currencyAmountResultMapper;
    private final WithdrawMethodViewResultMapper withdrawMethodViewResultMapper;

    @Inject
    public BizOTCTransferInitMapper(CurrencyAmountResultMapper currencyAmountResultMapper, WithdrawMethodViewResultMapper withdrawMethodViewResultMapper) {
        this.currencyAmountResultMapper = currencyAmountResultMapper;
        this.withdrawMethodViewResultMapper = withdrawMethodViewResultMapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public OTCTransferInit map(BizTransferInitResult bizTransferInitResult) {
        if (bizTransferInitResult == null) {
            return null;
        }
        this.withdrawMethodViewResultMapper.setAddPayMethods(this.addPayMethods);
        OTCTransferInit oTCTransferInit = new OTCTransferInit();
        oTCTransferInit.setNeedSenderName(bizTransferInitResult.needSenderName);
        oTCTransferInit.setTransferMethod(this.withdrawMethodViewResultMapper.map(bizTransferInitResult.transferMethodInfo));
        oTCTransferInit.setKyc(bizTransferInitResult.payerUserInfo.getKycLevel());
        oTCTransferInit.setPayerMaskedNickname(bizTransferInitResult.payerUserInfo.getMaskedNickname());
        oTCTransferInit.setPayerMaskedPhoneNumber(bizTransferInitResult.payerUserInfo.getMaskedLoginId());
        oTCTransferInit.setPayerUserId(bizTransferInitResult.payerUserInfo.getUserId());
        oTCTransferInit.setPayerAccountBalance(this.currencyAmountResultMapper.map(bizTransferInitResult.payerUserInfo.getBalanceAmount()));
        oTCTransferInit.setPayeeMaskedNickname(bizTransferInitResult.payeeUserInfo != null ? bizTransferInitResult.payeeUserInfo.getMaskedNickname() : "-");
        oTCTransferInit.setPayeeMaskedPhoneNumber(bizTransferInitResult.payeeUserInfo != null ? bizTransferInitResult.payeeUserInfo.getMaskedLoginId() : "");
        oTCTransferInit.setPayeeUserId(bizTransferInitResult.payeeUserInfo != null ? bizTransferInitResult.payeeUserInfo.getUserId() : "");
        oTCTransferInit.setPayeeAvatar(bizTransferInitResult.payeeUserInfo != null ? bizTransferInitResult.payeeUserInfo.getAvatar() : "");
        oTCTransferInit.setAcceptExpiryTimeUnit(this.acceptExpiryTimeUnit);
        oTCTransferInit.setAcceptExpiryTimeValue(this.acceptExpiryTimeValue);
        oTCTransferInit.setQrisTcicoEntryPointInfo(QrisTcicoEntryPointInfoEntityKt.toQrisTcicoEntryPoint(bizTransferInitResult.qrisTcicoEntryPointInfo));
        return oTCTransferInit;
    }

    public void setPayChannelFromAmcs(List<AddPayMethod> list) {
        this.addPayMethods = list;
    }

    public void setAcceptExpiryTimeUnit(String str) {
        this.acceptExpiryTimeUnit = str;
    }

    public void setAcceptExpiryTimeValue(String str) {
        this.acceptExpiryTimeValue = str;
    }
}
