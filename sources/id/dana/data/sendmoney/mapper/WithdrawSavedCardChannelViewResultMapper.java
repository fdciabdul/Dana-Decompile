package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.model.WithdrawCardOptionViewResult;
import id.dana.domain.withdraw.model.WithdrawSavedCardChannelView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class WithdrawSavedCardChannelViewResultMapper extends BaseMapper<List<WithdrawCardOptionViewResult>, List<WithdrawSavedCardChannelView>> {
    @Inject
    public WithdrawSavedCardChannelViewResultMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<WithdrawSavedCardChannelView> map(List<WithdrawCardOptionViewResult> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (WithdrawCardOptionViewResult withdrawCardOptionViewResult : list) {
            arrayList.add(new WithdrawSavedCardChannelView.Builder().bindingId(withdrawCardOptionViewResult.getBindingId()).cardIndexNo(withdrawCardOptionViewResult.getCardIndexNo()).cardNoLength(withdrawCardOptionViewResult.getCardNoLength()).disable(withdrawCardOptionViewResult.isDisable()).formattedHolderName(withdrawCardOptionViewResult.getFormattedHolderName()).formattedMaskedCardNo(withdrawCardOptionViewResult.getFormattedMaskedCardNo()).instId(withdrawCardOptionViewResult.getInstId()).instLocalName(withdrawCardOptionViewResult.getInstLocalName()).instName(withdrawCardOptionViewResult.getInstName()).payMethod(withdrawCardOptionViewResult.getPayMethod()).payOption(withdrawCardOptionViewResult.getPayOption()).validData(withdrawCardOptionViewResult.isValidData()).build());
        }
        return arrayList;
    }
}
