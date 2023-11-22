package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.recentbank.model.RecentBank;
import id.dana.sendmoney.model.RecentBankModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class RecentBankModelMapper extends BaseMapper<List<RecentBank>, List<RecentBankModel>> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<RecentBankModel> apply(List<RecentBank> list) {
        return KClassImpl$Data$declaredNonStaticMembers$2(list);
    }

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<RecentBankModel> map(List<RecentBank> list) {
        return KClassImpl$Data$declaredNonStaticMembers$2(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public RecentBankModelMapper() {
    }

    public static List<RecentBankModel> PlaceComponentResult(List<RecentBank> list) {
        return KClassImpl$Data$declaredNonStaticMembers$2(list);
    }

    private static List<RecentBankModel> KClassImpl$Data$declaredNonStaticMembers$2(List<RecentBank> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (RecentBank recentBank : list) {
                RecentBankModel recentBankModel = new RecentBankModel();
                recentBankModel.scheduleImpl = recentBank.getBankName();
                recentBankModel.getAuthRequestContext = recentBank.getBankNumber();
                String recipientName = recentBank.getRecipientName();
                if (recipientName == null) {
                    recipientName = "";
                }
                recentBankModel.NetworkUserEntityData$$ExternalSyntheticLambda7 = recipientName;
                recentBankModel.BuiltInFictitiousFunctionClassFactory = recentBank.getBankLogo();
                recentBankModel.KClassImpl$Data$declaredNonStaticMembers$2 = recentBank.getAlias();
                recentBankModel.lookAheadTest = recentBank.getInstId();
                recentBankModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = recentBank.getInstLocalName();
                recentBankModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = recentBank.getPayMethod();
                recentBankModel.initRecordTimeStamp = recentBank.getPayOption();
                recentBankModel.newProxyInstance = recentBank.getSenderName();
                recentBankModel.KClassImpl$Data$declaredNonStaticMembers$2 = recentBank.getCardIndexNo();
                recentBankModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = recentBank.getPrefix();
                recentBankModel.PrepareContext = recentBank.getTransactionCount();
                recentBankModel.PlaceComponentResult = Long.valueOf(recentBank.getLastUpdated());
                recentBankModel.getErrorConfigVersion = recentBank.isFavorite();
                arrayList.add(recentBankModel);
            }
            return arrayList;
        }
        return Collections.emptyList();
    }
}
