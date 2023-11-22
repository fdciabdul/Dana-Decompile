package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.sendmoney.model.RecentRecipientModel;
import id.dana.sendmoney.model.RecipientViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/mapper/RecentRecipientToRecipientViewModelMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/sendmoney/model/RecentRecipientModel;", "Lid/dana/sendmoney/model/RecipientViewModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecentRecipientToRecipientViewModelMapper extends BaseMapper<List<? extends RecentRecipientModel>, List<? extends RecipientViewModel>> {
    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ List<? extends RecipientViewModel> map(List<? extends RecentRecipientModel> list) {
        RecipientViewModel recipientViewModel;
        List<? extends RecentRecipientModel> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "");
        ArrayList arrayList = new ArrayList();
        for (RecentRecipientModel recentRecipientModel : CollectionsKt.toList(list2)) {
            ArrayList arrayList2 = arrayList;
            int i = recentRecipientModel.isLayoutRequested;
            if (i == 4) {
                recipientViewModel = new RecipientViewModel(24);
            } else if (i == 6) {
                recipientViewModel = new RecipientViewModel(27);
            } else if (i == 7) {
                recipientViewModel = new RecipientViewModel(25);
            } else {
                recipientViewModel = new RecipientViewModel(3);
            }
            recipientViewModel.getAuthRequestContext = recentRecipientModel.getAuthRequestContext;
            recipientViewModel.MyBillsEntityDataFactory = recentRecipientModel.KClassImpl$Data$declaredNonStaticMembers$2();
            recipientViewModel.PlaceComponentResult = recentRecipientModel.BuiltInFictitiousFunctionClassFactory();
            recipientViewModel.BuiltInFictitiousFunctionClassFactory = recentRecipientModel.BuiltInFictitiousFunctionClassFactory;
            recipientViewModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = recentRecipientModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
            recipientViewModel.scheduleImpl = recentRecipientModel.PlaceComponentResult();
            recipientViewModel.getErrorConfigVersion = recentRecipientModel.getErrorConfigVersion;
            recipientViewModel.getAuthRequestContext(recentRecipientModel.NetworkUserEntityData$$ExternalSyntheticLambda0());
            recipientViewModel.initRecordTimeStamp = recentRecipientModel.initRecordTimeStamp;
            recipientViewModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = recentRecipientModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
            recipientViewModel.DatabaseTableConfigUtil = recentRecipientModel.DatabaseTableConfigUtil;
            recipientViewModel.MyBillsEntityDataFactory(recentRecipientModel.getAuthRequestContext());
            recipientViewModel.KClassImpl$Data$declaredNonStaticMembers$2(recentRecipientModel.MyBillsEntityDataFactory());
            recipientViewModel.moveToNextValue = recentRecipientModel.moveToNextValue;
            arrayList2.add(recipientViewModel);
        }
        return arrayList;
    }
}
