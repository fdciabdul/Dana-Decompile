package id.dana.splitbill.mapper;

import android.text.TextUtils;
import id.dana.data.base.BaseMapper;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.splitbill.model.SplitBillPayerModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class RecipientModelMapper extends BaseMapper<List<RecipientModel>, List<SplitBillPayerModel>> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<SplitBillPayerModel> map(List<RecipientModel> list) {
        SplitBillPayerModel splitBillPayerModel;
        List<RecipientModel> list2 = list;
        ArrayList arrayList = new ArrayList();
        if (list2 != null) {
            for (RecipientModel recipientModel : list2) {
                if (recipientModel != null) {
                    splitBillPayerModel = new SplitBillPayerModel();
                    splitBillPayerModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = recipientModel.PlaceComponentResult();
                    splitBillPayerModel.scheduleImpl = recipientModel.getErrorConfigVersion;
                    splitBillPayerModel.MyBillsEntityDataFactory = recipientModel.BuiltInFictitiousFunctionClassFactory();
                    splitBillPayerModel.moveToNextValue = recipientModel.getSupportButtonTintMode;
                    if (!TextUtils.isEmpty(recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda3)) {
                        splitBillPayerModel.lookAheadTest = recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda3;
                    }
                } else {
                    splitBillPayerModel = null;
                }
                arrayList.add(splitBillPayerModel);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public RecipientModelMapper() {
    }
}
