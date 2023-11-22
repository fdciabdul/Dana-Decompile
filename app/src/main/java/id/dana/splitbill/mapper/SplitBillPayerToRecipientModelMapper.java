package id.dana.splitbill.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.splitbill.model.SplitBillPayerModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SplitBillPayerToRecipientModelMapper extends BaseMapper<SplitBillPayerModel, RecipientModel> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ RecipientModel map(SplitBillPayerModel splitBillPayerModel) {
        SplitBillPayerModel splitBillPayerModel2 = splitBillPayerModel;
        if (splitBillPayerModel2 != null) {
            RecipientModel recipientModel = new RecipientModel("contact");
            recipientModel.getErrorConfigVersion = splitBillPayerModel2.scheduleImpl;
            return recipientModel;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public SplitBillPayerToRecipientModelMapper() {
    }
}
