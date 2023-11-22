package id.dana.requestmoney.splitbill.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.model.ScanModel;
import id.dana.sendmoney.model.RecipientModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SplitBillScanToRecipientModelMapper extends BaseMapper<ScanModel, RecipientModel> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ RecipientModel apply(ScanModel scanModel) {
        return PlaceComponentResult(scanModel, "contact");
    }

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ RecipientModel map(ScanModel scanModel) {
        return PlaceComponentResult(scanModel, "contact");
    }

    @Inject
    public SplitBillScanToRecipientModelMapper() {
    }

    public static RecipientModel PlaceComponentResult(ScanModel scanModel, String str) {
        if (scanModel != null) {
            RecipientModel.Builder builder = new RecipientModel.Builder(str);
            builder.scheduleImpl = scanModel.getMobileNumber();
            builder.initRecordTimeStamp = scanModel.getNickname();
            builder.PlaceComponentResult = scanModel.getAvatarUrl();
            builder.getErrorConfigVersion = scanModel.getAvatarUrl();
            builder.lookAheadTest = scanModel.getNickname();
            builder.GetContactSyncConfig = scanModel.getMobileNumber();
            builder.PrepareContext = "phonenumber";
            builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = scanModel.getReceiverId();
            builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            return builder.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        return null;
    }
}
