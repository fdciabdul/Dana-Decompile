package id.dana.announcement.mapper;

import id.dana.domain.announcement.model.RecurringAnnouncement;
import id.dana.model.CdpContentModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/announcement/model/RecurringAnnouncement;", "Lid/dana/model/CdpContentModel;", "MyBillsEntityDataFactory", "(Lid/dana/domain/announcement/model/RecurringAnnouncement;)Lid/dana/model/CdpContentModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AnnouncementModelMapperKt {
    public static final CdpContentModel MyBillsEntityDataFactory(RecurringAnnouncement recurringAnnouncement) {
        String str;
        String title;
        String subtitle;
        String str2;
        String str3 = "";
        Intrinsics.checkNotNullParameter(recurringAnnouncement, "");
        CdpContentModel cdpContentModel = new CdpContentModel();
        cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = recurringAnnouncement.getId();
        cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = recurringAnnouncement.getTitle();
        cdpContentModel.DatabaseTableConfigUtil = recurringAnnouncement.getWidgetType();
        cdpContentModel.GetContactSyncConfig = recurringAnnouncement.getSubtitle();
        Map<String, String> extInfo = recurringAnnouncement.getExtInfo();
        if (extInfo == null || (str = extInfo.get("redirectUrl")) == null) {
            str = "";
        }
        cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda4 = str;
        cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = recurringAnnouncement.getSubMerchantId();
        Map<String, String> extInfo2 = recurringAnnouncement.getExtInfo();
        if (extInfo2 == null || (title = extInfo2.get("EN_TITLE")) == null) {
            title = recurringAnnouncement.getTitle();
        }
        cdpContentModel.scheduleImpl = title;
        Map<String, String> extInfo3 = recurringAnnouncement.getExtInfo();
        if (extInfo3 == null || (subtitle = extInfo3.get("EN_DESC_SINGLE")) == null) {
            subtitle = recurringAnnouncement.getSubtitle();
        }
        cdpContentModel.getErrorConfigVersion = subtitle;
        cdpContentModel.getAuthRequestContext = recurringAnnouncement.getGoodsName();
        cdpContentModel.KClassImpl$Data$declaredNonStaticMembers$2 = recurringAnnouncement.getGoodsType();
        cdpContentModel.moveToNextValue = recurringAnnouncement.getSubscriptionDueDate();
        cdpContentModel.MyBillsEntityDataFactory = recurringAnnouncement.getPaymentStatus();
        cdpContentModel.lookAheadTest = recurringAnnouncement.getTotalAmount();
        Map<String, String> extInfo4 = recurringAnnouncement.getExtInfo();
        if (extInfo4 != null && (str2 = extInfo4.get("widgetIconUrl")) != null) {
            str3 = str2;
        }
        cdpContentModel.BuiltInFictitiousFunctionClassFactory = str3;
        return cdpContentModel;
    }
}
