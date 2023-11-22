package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.sendmoney.model.RecentBankModel;
import id.dana.sendmoney.model.RecipientViewModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class BankToRecipientViewModelMapper extends BaseMapper<List<RecentBankModel>, List<RecipientViewModel>> {
    public boolean BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<RecipientViewModel> map(List<RecentBankModel> list) {
        RecipientViewModel recipientViewModel;
        List<RecentBankModel> list2 = list;
        ArrayList arrayList = new ArrayList();
        for (RecentBankModel recentBankModel : new ArrayList(list2)) {
            int size = list2.size();
            if (recentBankModel == null) {
                recipientViewModel = null;
            } else {
                RecipientViewModel recipientViewModel2 = this.BuiltInFictitiousFunctionClassFactory ? new RecipientViewModel(24) : new RecipientViewModel(recentBankModel.MyBillsEntityDataFactory == 3 ? size == 4 ? 13 : 14 : 2);
                recipientViewModel2.MyBillsEntityDataFactory = recentBankModel.lookAheadTest;
                recipientViewModel2.getAuthRequestContext(recentBankModel.NetworkUserEntityData$$ExternalSyntheticLambda7);
                recipientViewModel2.PlaceComponentResult = recentBankModel.BuiltInFictitiousFunctionClassFactory;
                recipientViewModel2.getAuthRequestContext = recentBankModel.KClassImpl$Data$declaredNonStaticMembers$2;
                recipientViewModel2.getErrorConfigVersion = recentBankModel.getAuthRequestContext;
                recipientViewModel2.scheduleImpl = recentBankModel.BuiltInFictitiousFunctionClassFactory;
                recipientViewModel2.initRecordTimeStamp = recentBankModel.newProxyInstance;
                recipientViewModel2.NetworkUserEntityData$$ExternalSyntheticLambda0 = recentBankModel.PlaceComponentResult.longValue();
                recipientViewModel2.BuiltInFictitiousFunctionClassFactory = recentBankModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
                recipientViewModel2.NetworkUserEntityData$$ExternalSyntheticLambda2 = recentBankModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
                recipientViewModel2.DatabaseTableConfigUtil = recentBankModel.initRecordTimeStamp;
                recipientViewModel2.MyBillsEntityDataFactory(recentBankModel.KClassImpl$Data$declaredNonStaticMembers$2);
                recipientViewModel2.KClassImpl$Data$declaredNonStaticMembers$2(recentBankModel.NetworkUserEntityData$$ExternalSyntheticLambda1);
                recipientViewModel2.NetworkUserEntityData$$ExternalSyntheticLambda1 = recentBankModel.PrepareContext;
                recipientViewModel2.lookAheadTest = recentBankModel.getGetErrorConfigVersion();
                recipientViewModel = recipientViewModel2;
            }
            arrayList.add(recipientViewModel);
        }
        return arrayList;
    }
}
