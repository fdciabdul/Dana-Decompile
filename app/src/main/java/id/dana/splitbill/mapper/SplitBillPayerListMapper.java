package id.dana.splitbill.mapper;

import android.text.TextUtils;
import id.dana.data.base.BaseMapper;
import id.dana.data.util.NumberUtils;
import id.dana.domain.splitbill.model.SplitBillPayer;
import id.dana.splitbill.model.SplitBillPayerModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SplitBillPayerListMapper extends BaseMapper<List<SplitBillPayerModel>, List<SplitBillPayer>> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<SplitBillPayer> map(List<SplitBillPayerModel> list) {
        String str;
        String str2;
        String str3;
        List<SplitBillPayerModel> list2 = list;
        if (list2 != null) {
            ArrayList arrayList = new ArrayList();
            for (SplitBillPayerModel splitBillPayerModel : list2) {
                if (splitBillPayerModel.GetContactSyncConfig == 0) {
                    SplitBillPayer splitBillPayer = new SplitBillPayer();
                    if (splitBillPayerModel.NetworkUserEntityData$$ExternalSyntheticLambda0.equals("-")) {
                        str = splitBillPayerModel.moveToNextValue;
                    } else {
                        str = splitBillPayerModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    }
                    if (!BuiltInFictitiousFunctionClassFactory(str)) {
                        if (splitBillPayerModel.NetworkUserEntityData$$ExternalSyntheticLambda0.equals("-")) {
                            str3 = splitBillPayerModel.moveToNextValue;
                        } else {
                            str3 = splitBillPayerModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        }
                        splitBillPayer.setName(str3);
                    }
                    splitBillPayer.setUserId(splitBillPayerModel.lookAheadTest);
                    splitBillPayer.setFundAmount(NumberUtils.getCleanDot(splitBillPayerModel.getAuthRequestContext.MyBillsEntityDataFactory));
                    if (!BuiltInFictitiousFunctionClassFactory(splitBillPayerModel.scheduleImpl)) {
                        splitBillPayer.setLoginId(splitBillPayerModel.scheduleImpl);
                    }
                    splitBillPayer.setImageUrl(splitBillPayerModel.MyBillsEntityDataFactory);
                    if (splitBillPayerModel.NetworkUserEntityData$$ExternalSyntheticLambda0.equals("-")) {
                        str2 = splitBillPayerModel.moveToNextValue;
                    } else {
                        str2 = splitBillPayerModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    }
                    splitBillPayer.setShownName(str2);
                    splitBillPayer.setShownNumber(splitBillPayerModel.scheduleImpl);
                    arrayList.add(splitBillPayer);
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    @Inject
    public SplitBillPayerListMapper() {
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(String str) {
        return !TextUtils.isEmpty(str) && str.contains("*");
    }
}
