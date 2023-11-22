package id.dana.sendmoney.ui.groupsend.recipient.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.sendmoney.ui.groupsend.recipient.model.RecentBankModel;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class BankToRecipientViewModelMapper extends BaseMapper<List<RecentBankModel>, List<RecipientViewModel>> {
    private boolean PlaceComponentResult;

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<RecipientViewModel> map(List<RecentBankModel> list) {
        RecipientViewModel recipientViewModel;
        List<RecentBankModel> list2 = list;
        ArrayList arrayList = new ArrayList();
        for (RecentBankModel recentBankModel : list2) {
            int size = list2.size();
            if (recentBankModel != null) {
                recipientViewModel = new RecipientViewModel(recentBankModel.MyBillsEntityDataFactory == 3 ? size == 4 ? 13 : 14 : 2);
                if (this.PlaceComponentResult) {
                    recipientViewModel = new RecipientViewModel(24);
                }
                recipientViewModel.PlaceComponentResult = recentBankModel.getErrorConfigVersion;
                recipientViewModel.NetworkUserEntityData$$ExternalSyntheticLambda8 = recentBankModel.initRecordTimeStamp;
                recipientViewModel.scheduleImpl = recentBankModel.KClassImpl$Data$declaredNonStaticMembers$2;
                recipientViewModel.MyBillsEntityDataFactory = recentBankModel.PlaceComponentResult;
                recipientViewModel.DatabaseTableConfigUtil = recentBankModel.PlaceComponentResult;
                recipientViewModel.initRecordTimeStamp = recentBankModel.MyBillsEntityDataFactory;
                recipientViewModel.NetworkUserEntityData$$ExternalSyntheticLambda7 = recentBankModel.NetworkUserEntityData$$ExternalSyntheticLambda8;
                recipientViewModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = recentBankModel.BuiltInFictitiousFunctionClassFactory.longValue();
                recipientViewModel.getErrorConfigVersion = recentBankModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
                recipientViewModel.newProxyInstance = recentBankModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
                recipientViewModel.PrepareContext = recentBankModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
                recipientViewModel.KClassImpl$Data$declaredNonStaticMembers$2 = recentBankModel.KClassImpl$Data$declaredNonStaticMembers$2;
                recipientViewModel.isLayoutRequested = recentBankModel.GetContactSyncConfig;
                recipientViewModel.NetworkUserEntityData$$ExternalSyntheticLambda3 = recentBankModel.isLayoutRequested;
                recipientViewModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = recentBankModel.getScheduleImpl();
            } else {
                recipientViewModel = null;
            }
            arrayList.add(recipientViewModel);
        }
        return arrayList;
    }
}
