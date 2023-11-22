package id.dana.data.sendmoney.mapper;

import id.dana.data.model.cashier.AttributesResult;
import id.dana.data.payasset.mapper.PayAssetMapper;
import id.dana.data.payasset.source.network.result.PayChannelOptionViewDTO;
import id.dana.data.payasset.source.network.result.PayMethodViewDTO;
import id.dana.data.sendmoney.model.KycResult;
import id.dana.data.sendmoney.model.PayOptionDTOResult;
import id.dana.data.sendmoney.repository.source.network.result.SendMoneyInitResult;
import id.dana.data.sendmoney.repository.source.network.result.SendMoneyResult;
import id.dana.data.sendmoney.repository.source.network.result.WithdrawSubmitResult;
import id.dana.domain.homeinfo.KycResponse;
import id.dana.domain.model.cashier.Attributes;
import id.dana.domain.sendmoney.model.AddPayMethod;
import id.dana.domain.sendmoney.model.PayOptionDTOResponse;
import id.dana.domain.sendmoney.model.SendMoneyConfirm;
import id.dana.domain.sendmoney.model.SendMoneyInit;
import id.dana.domain.sendmoney.model.WithdrawSubmit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class SendMoneyMapper {
    private List<AddPayMethod> addPayMethods;
    private final CurrencyAmountResultMapper currencyAmountResultMapper;
    private final PayAssetMapper payAssetMapper;
    private final PayMethodRiskResultMapper payMethodRiskResultMapper;

    @Inject
    public SendMoneyMapper(CurrencyAmountResultMapper currencyAmountResultMapper, PayAssetMapper payAssetMapper, PayMethodRiskResultMapper payMethodRiskResultMapper) {
        this.currencyAmountResultMapper = currencyAmountResultMapper;
        this.payAssetMapper = payAssetMapper;
        this.payMethodRiskResultMapper = payMethodRiskResultMapper;
    }

    public SendMoneyConfirm transform(SendMoneyResult sendMoneyResult) {
        if (sendMoneyResult != null) {
            SendMoneyConfirm sendMoneyConfirm = new SendMoneyConfirm();
            sendMoneyConfirm.setFundAmount(sendMoneyResult.fundAmount);
            sendMoneyConfirm.setFundOrderId(sendMoneyResult.fundOrderId);
            sendMoneyConfirm.setCashierOrderId(sendMoneyResult.cashierOrderId);
            sendMoneyConfirm.setPubkey(sendMoneyResult.pubKey);
            sendMoneyConfirm.setRiskPhoneNumber(sendMoneyResult.riskPhoneNumber);
            sendMoneyConfirm.setAttributes(transform(sendMoneyResult.attributes));
            sendMoneyConfirm.setPayMethodRiskResult(this.payMethodRiskResultMapper.apply(sendMoneyResult.payMethodRiskResult));
            return sendMoneyConfirm;
        }
        return null;
    }

    private Attributes transform(AttributesResult attributesResult) {
        if (attributesResult != null) {
            Attributes attributes = new Attributes();
            attributes.setLoginStatus(attributesResult.loginStatus);
            attributes.setMaskedLoginId(attributesResult.maskedLoginId);
            attributes.setPayMethodRiskResponse(this.payMethodRiskResultMapper.apply(attributesResult.payMethodRiskResult));
            return attributes;
        }
        return null;
    }

    public SendMoneyInit transform(SendMoneyInitResult sendMoneyInitResult, List<AddPayMethod> list) {
        this.addPayMethods = list;
        return transform(sendMoneyInitResult);
    }

    public SendMoneyInit transform(SendMoneyInitResult sendMoneyInitResult) {
        if (sendMoneyInitResult == null) {
            return null;
        }
        return new SendMoneyInit.Builder().setPayeeMaskedNickname(sendMoneyInitResult.payeeMaskedNickname).setPayeeMaskedPhoneNumber(sendMoneyInitResult.payeeMaskedPhoneNumber).setPayeeUserId(sendMoneyInitResult.payeeUserId).setPayerAccountBalance(sendMoneyInitResult.payerAccountBalance).setPayerMaxAmount(sendMoneyInitResult.payerMaxAmount).setPayerMinAmount(sendMoneyInitResult.payerMinAmount).setPayOptions(transform(sendMoneyInitResult.payOptions)).setAvatarUrl(sendMoneyInitResult.avatarUrl).setKyc(transform(sendMoneyInitResult.kyc)).build();
    }

    List<PayOptionDTOResponse> transform(List<PayOptionDTOResult> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<PayOptionDTOResult> it = list.iterator();
        while (it.hasNext()) {
            PayOptionDTOResponse transform = transform(it.next());
            if (transform != null) {
                List<AddPayMethod> list2 = this.addPayMethods;
                if (list2 != null && !list2.isEmpty()) {
                    transform.getPayMethodView().setAddPayMethods(this.addPayMethods);
                }
                arrayList.add(transform);
            }
        }
        return arrayList;
    }

    private KycResponse transform(KycResult kycResult) {
        if (kycResult == null) {
            return null;
        }
        KycResponse kycResponse = new KycResponse();
        kycResponse.setLevel(kycResult.getLevel());
        kycResponse.setOrderStatus(kycResult.getOrderStatus());
        return kycResponse;
    }

    @Nullable
    PayOptionDTOResponse transform(PayOptionDTOResult payOptionDTOResult) {
        if (payOptionDTOResult == null) {
            return null;
        }
        PayOptionDTOResponse payOptionDTOResponse = new PayOptionDTOResponse();
        payOptionDTOResponse.setPayMethodView(this.payAssetMapper.transform(payOptionDTOResult.getPayMethodView()));
        payOptionDTOResponse.setPayMethod(payOptionDTOResult.getPayMethod());
        payOptionDTOResponse.setPayerMinAmount(this.currencyAmountResultMapper.apply(payOptionDTOResult.getPayerMinAmount()));
        payOptionDTOResponse.setPayerMaxAmount(this.currencyAmountResultMapper.apply(payOptionDTOResult.getPayerMaxAmount()));
        payOptionDTOResponse.setPayMethodFlag(getPayMethodFlag(payOptionDTOResult.getPayMethodView()));
        return payOptionDTOResponse;
    }

    boolean getPayMethodFlag(PayMethodViewDTO payMethodViewDTO) {
        List<PayChannelOptionViewDTO> list = payMethodViewDTO.payChannelOptionViewDTOS;
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (PayChannelOptionViewDTO payChannelOptionViewDTO : list) {
            if (payChannelOptionViewDTO.enableStatus) {
                return payChannelOptionViewDTO.enableStatus;
            }
        }
        return false;
    }

    public WithdrawSubmit transform(WithdrawSubmitResult withdrawSubmitResult) {
        if (withdrawSubmitResult == null) {
            return null;
        }
        WithdrawSubmit withdrawSubmit = new WithdrawSubmit();
        withdrawSubmit.setCardCacheToken(withdrawSubmitResult.getCardCacheToken());
        withdrawSubmit.setFormattedHolderName(withdrawSubmitResult.getFormattedHolderName());
        withdrawSubmit.setFormattedMaskedCardNo(withdrawSubmitResult.getFormattedMaskedCardNo());
        withdrawSubmit.setFundOrderId(withdrawSubmitResult.getFundOrderId());
        withdrawSubmit.setMaskedPhoneNumber(withdrawSubmitResult.getMaskedPhoneNumber());
        withdrawSubmit.setPayMethodRiskResult(this.payMethodRiskResultMapper.apply(withdrawSubmitResult.getPayMethodRiskResult()));
        withdrawSubmit.setPublicKey(withdrawSubmitResult.getPublicKey());
        withdrawSubmit.setTotalAmount(this.currencyAmountResultMapper.apply(withdrawSubmitResult.getTotalAmount()));
        return withdrawSubmit;
    }
}
