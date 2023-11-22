package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.repository.source.network.result.CardHolderResult;
import id.dana.data.sendmoney.repository.source.network.result.WithdrawNameCheckResult;
import id.dana.domain.sendmoney.model.CardHolder;
import id.dana.domain.sendmoney.model.WithdrawNameCheck;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class WithdrawNameCheckMapper extends BaseMapper<WithdrawNameCheckResult, WithdrawNameCheck> {
    @Inject
    public WithdrawNameCheckMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public WithdrawNameCheck map(WithdrawNameCheckResult withdrawNameCheckResult) {
        if (withdrawNameCheckResult != null) {
            WithdrawNameCheck withdrawNameCheck = new WithdrawNameCheck();
            withdrawNameCheck.setCardIndexNo(withdrawNameCheckResult.getCardIndexNo());
            withdrawNameCheck.setFormattedHolderName(withdrawNameCheckResult.getFormattedHolderName());
            withdrawNameCheck.setFormattedMaskedCardNo(withdrawNameCheckResult.getFormattedMaskedCardNo());
            withdrawNameCheck.setHolderName(transform(withdrawNameCheckResult.getHolderName()));
            return withdrawNameCheck;
        }
        return null;
    }

    private CardHolder transform(CardHolderResult cardHolderResult) {
        CardHolder cardHolder = new CardHolder();
        cardHolder.setFirstName(cardHolderResult.getFirstName());
        cardHolder.setLastName(cardHolderResult.getLastName());
        return cardHolder;
    }
}
