package id.dana.sendmoney.mapper;

import id.dana.domain.sendmoney.model.WithdrawNameCheck;
import id.dana.sendmoney.model.CardHolderModel;
import id.dana.sendmoney.model.WithdrawNameCheckModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SendMoneyBankMapper {
    private final PayMethodRiskMapper KClassImpl$Data$declaredNonStaticMembers$2;
    private final CurrencyAmountModelMapper getAuthRequestContext;

    @Inject
    public SendMoneyBankMapper(PayMethodRiskMapper payMethodRiskMapper, CurrencyAmountModelMapper currencyAmountModelMapper) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = payMethodRiskMapper;
        this.getAuthRequestContext = currencyAmountModelMapper;
    }

    public static WithdrawNameCheckModel KClassImpl$Data$declaredNonStaticMembers$2(WithdrawNameCheck withdrawNameCheck) {
        if (withdrawNameCheck != null) {
            WithdrawNameCheckModel withdrawNameCheckModel = new WithdrawNameCheckModel();
            withdrawNameCheckModel.KClassImpl$Data$declaredNonStaticMembers$2 = withdrawNameCheck.getCardIndexNo();
            withdrawNameCheckModel.getAuthRequestContext = withdrawNameCheck.getFormattedHolderName();
            withdrawNameCheckModel.MyBillsEntityDataFactory = withdrawNameCheck.getFormattedMaskedCardNo();
            withdrawNameCheckModel.BuiltInFictitiousFunctionClassFactory = new CardHolderModel(withdrawNameCheck.getHolderName().getFirstName(), withdrawNameCheck.getHolderName().getLastName());
            return withdrawNameCheckModel;
        }
        return null;
    }
}
