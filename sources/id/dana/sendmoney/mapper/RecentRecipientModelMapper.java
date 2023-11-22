package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import id.dana.sendmoney.model.RecentRecipientModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class RecentRecipientModelMapper extends BaseMapper<List<RecentRecipient>, List<RecentRecipientModel>> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<RecentRecipientModel> apply(List<RecentRecipient> list) {
        return MyBillsEntityDataFactory(list, 0);
    }

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<RecentRecipientModel> map(List<RecentRecipient> list) {
        return MyBillsEntityDataFactory(list, 0);
    }

    @Inject
    public RecentRecipientModelMapper() {
    }

    public static List<RecentRecipientModel> MyBillsEntityDataFactory(List<RecentRecipient> list, int i) {
        RecentRecipientModel recentRecipientModel;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (RecentRecipient recentRecipient : list) {
                if (recentRecipient != null) {
                    recentRecipientModel = new RecentRecipientModel();
                    recentRecipientModel.MyBillsEntityDataFactory = recentRecipient.getId();
                    recentRecipientModel.scheduleImpl = recentRecipient.getName();
                    recentRecipientModel.getAuthRequestContext = recentRecipient.getAlias();
                    recentRecipientModel.getErrorConfigVersion = recentRecipient.getNumber();
                    recentRecipientModel.PlaceComponentResult = recentRecipient.getImageUrl();
                    recentRecipientModel.getAuthRequestContext(recentRecipient.getRecipientName());
                    recentRecipientModel.initRecordTimeStamp = recentRecipient.getSenderName();
                    recentRecipientModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = recentRecipient.getLastUpdated();
                    recentRecipientModel.BuiltInFictitiousFunctionClassFactory = recentRecipient.getInstLocalName();
                    int type = recentRecipient.getType();
                    int i2 = 2;
                    if (type == 1) {
                        i2 = 4;
                    } else if (type == 2) {
                        i2 = 7;
                    } else if (type == 3) {
                        i2 = 6;
                    }
                    recentRecipientModel.isLayoutRequested = i2;
                    recentRecipientModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = recentRecipient.getPayMethod();
                    recentRecipientModel.DatabaseTableConfigUtil = recentRecipient.getPayOption();
                    recentRecipientModel.MyBillsEntityDataFactory(recentRecipient.getCardIndexNo());
                    recentRecipientModel.KClassImpl$Data$declaredNonStaticMembers$2(recentRecipient.getPrefix());
                    recentRecipientModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = recentRecipient.getTransactionCount();
                    recentRecipientModel.lookAheadTest = recentRecipient.isFavorite();
                    recentRecipientModel.moveToNextValue = recentRecipient.getParticipantCount();
                } else {
                    recentRecipientModel = null;
                }
                if (recentRecipientModel != null) {
                    recentRecipientModel.newProxyInstance = i;
                    arrayList.add(recentRecipientModel);
                }
            }
        }
        return arrayList;
    }
}
