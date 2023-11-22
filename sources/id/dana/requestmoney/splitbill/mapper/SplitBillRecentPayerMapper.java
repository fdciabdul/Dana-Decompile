package id.dana.requestmoney.splitbill.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import id.dana.sendmoney.model.RecipientModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SplitBillRecentPayerMapper extends BaseMapper<List<RecentRecipient>, List<RecipientModel>> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<RecipientModel> apply(List<RecentRecipient> list) {
        return getAuthRequestContext(list, 2);
    }

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<RecipientModel> map(List<RecentRecipient> list) {
        return getAuthRequestContext(list, 2);
    }

    @Inject
    public SplitBillRecentPayerMapper() {
    }

    public static List<RecipientModel> getAuthRequestContext(List<RecentRecipient> list, int i) {
        RecipientModel recipientModel;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (RecentRecipient recentRecipient : list) {
                if (recentRecipient != null) {
                    RecipientModel.Builder builder = new RecipientModel.Builder(i != 2 ? "contact" : "recentContacts");
                    builder.scheduleImpl = recentRecipient.getNumber();
                    builder.initRecordTimeStamp = recentRecipient.getName();
                    builder.PlaceComponentResult = recentRecipient.getAlias();
                    builder.getErrorConfigVersion = recentRecipient.getImageUrl();
                    builder.lookAheadTest = recentRecipient.getInstLocalName();
                    builder.GetContactSyncConfig = recentRecipient.getNumber();
                    builder.NetworkUserEntityData$$ExternalSyntheticLambda3 = recentRecipient.getSenderName();
                    builder.PrepareContext = "phonenumber";
                    builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = recentRecipient.getId();
                    builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = recentRecipient.getPayMethod();
                    builder.DatabaseTableConfigUtil = recentRecipient.getPayOption();
                    builder.getAuthRequestContext = recentRecipient.getCardIndexNo();
                    builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = recentRecipient.getPrefix();
                    builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                    recipientModel = builder.KClassImpl$Data$declaredNonStaticMembers$2();
                } else {
                    recipientModel = null;
                }
                arrayList.add(recipientModel);
            }
        }
        return arrayList;
    }
}
