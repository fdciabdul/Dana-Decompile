package id.dana.data.sendmoney.mapper;

import android.text.TextUtils;
import id.dana.data.encryptcardno.EncryptCardNumber;
import id.dana.data.sendmoney.repository.source.network.request.WithdrawNameCheckRequest;
import id.dana.domain.sendmoney.model.NameCheckParam;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class NameCheckParamMapper {
    @Inject
    public NameCheckParamMapper() {
    }

    public WithdrawNameCheckRequest map(NameCheckParam nameCheckParam, String str, Boolean bool) {
        WithdrawNameCheckRequest withdrawNameCheckRequest = new WithdrawNameCheckRequest();
        if (nameCheckParam != null) {
            withdrawNameCheckRequest.setSavedAccount(nameCheckParam.isSavedAccount());
            withdrawNameCheckRequest.setSavedAccountHolderName(nameCheckParam.getSavedAccountHolderName());
            withdrawNameCheckRequest.setInstId(nameCheckParam.getInstId());
            withdrawNameCheckRequest.setSenderName(nameCheckParam.getSenderName());
            if (nameCheckParam.isSavedAccount()) {
                handleSavedCard(withdrawNameCheckRequest, nameCheckParam);
            } else {
                withdrawNameCheckRequest.setCardCredential(EncryptCardNumber.MyBillsEntityDataFactory(nameCheckParam.getCardNo().replace(" ", ""), str, bool.booleanValue()));
                if (!TextUtils.isEmpty(withdrawNameCheckRequest.getCardCredential())) {
                    withdrawNameCheckRequest.setCardNo("");
                } else {
                    withdrawNameCheckRequest.setCardNo(nameCheckParam.getCardNo().replace(" ", ""));
                }
            }
            withdrawNameCheckRequest.setFundAmount(nameCheckParam.getFundAmount());
            withdrawNameCheckRequest.setSaveCard(nameCheckParam.isSaveCard());
            withdrawNameCheckRequest.setWithdrawPayMethod(nameCheckParam.getWithdrawPayMethod());
            withdrawNameCheckRequest.setWithdrawPayOption(nameCheckParam.getWithdrawPayOption());
            withdrawNameCheckRequest.setWithdrawInstLocalName(nameCheckParam.getWithdrawInstLocalName());
        }
        return withdrawNameCheckRequest;
    }

    private void handleSavedCard(WithdrawNameCheckRequest withdrawNameCheckRequest, NameCheckParam nameCheckParam) {
        String cardIndexNo = nameCheckParam.getCardIndexNo();
        if (!TextUtils.isEmpty(cardIndexNo)) {
            withdrawNameCheckRequest.setCardIndexNo(cardIndexNo);
            withdrawNameCheckRequest.setCardNo("");
            return;
        }
        withdrawNameCheckRequest.setCardNo(nameCheckParam.getCardNo());
    }
}
