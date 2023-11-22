package id.dana.animation.promobanner.mapper;

import id.dana.domain.home.model.PromoBannerAnnouncementModel;
import id.dana.domain.home.model.PromoBannerContentModel;
import id.dana.domain.home.model.PromoBannerModel;
import id.dana.model.CdpContentModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005*\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "p0", "Ljava/util/Date;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Ljava/util/Date;", "", "Lid/dana/domain/home/model/PromoBannerModel;", "Lid/dana/model/CdpContentModel;", "getAuthRequestContext", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoBannerModelMapperKt {
    public static final List<CdpContentModel> getAuthRequestContext(List<? extends PromoBannerModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<? extends PromoBannerModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (PromoBannerModel promoBannerModel : list2) {
            Intrinsics.checkNotNullParameter(promoBannerModel, "");
            CdpContentModel cdpContentModel = new CdpContentModel();
            if (promoBannerModel instanceof PromoBannerAnnouncementModel) {
                PromoBannerAnnouncementModel promoBannerAnnouncementModel = (PromoBannerAnnouncementModel) promoBannerModel;
                cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = promoBannerAnnouncementModel.getSubscriptionId();
                cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = promoBannerAnnouncementModel.getContentName();
                cdpContentModel.DatabaseTableConfigUtil = promoBannerModel.getContentType();
                cdpContentModel.GetContactSyncConfig = promoBannerAnnouncementModel.getContentValue();
                cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda4 = promoBannerAnnouncementModel.getRedirectUrl();
                cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = promoBannerAnnouncementModel.getSubMerchantId();
                cdpContentModel.scheduleImpl = promoBannerAnnouncementModel.getTitle();
                cdpContentModel.getErrorConfigVersion = promoBannerAnnouncementModel.getSubtitle();
                cdpContentModel.getAuthRequestContext = promoBannerAnnouncementModel.getGoodsName();
                cdpContentModel.KClassImpl$Data$declaredNonStaticMembers$2 = promoBannerAnnouncementModel.getGoodsType();
                cdpContentModel.moveToNextValue = promoBannerAnnouncementModel.getSubscriptionDueDate();
                cdpContentModel.MyBillsEntityDataFactory = promoBannerAnnouncementModel.getPaymentStatus();
                cdpContentModel.lookAheadTest = promoBannerAnnouncementModel.getTotalAmount();
                cdpContentModel.BuiltInFictitiousFunctionClassFactory = promoBannerAnnouncementModel.getIconUrl();
            } else if (promoBannerModel instanceof PromoBannerContentModel) {
                PromoBannerContentModel promoBannerContentModel = (PromoBannerContentModel) promoBannerModel;
                cdpContentModel.initRecordTimeStamp = promoBannerContentModel.getBizType();
                cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = promoBannerContentModel.getContentId();
                cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = promoBannerContentModel.getContentName();
                cdpContentModel.DatabaseTableConfigUtil = promoBannerModel.getContentType();
                cdpContentModel.GetContactSyncConfig = promoBannerContentModel.getContentValue();
                cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda8 = KClassImpl$Data$declaredNonStaticMembers$2(promoBannerContentModel.getEffectiveDate());
                cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda7 = promoBannerContentModel.getEnvType();
                cdpContentModel.PrepareContext = KClassImpl$Data$declaredNonStaticMembers$2(promoBannerContentModel.getExpireDate());
                cdpContentModel.isLayoutRequested = KClassImpl$Data$declaredNonStaticMembers$2(promoBannerContentModel.getGmtCreate());
                cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda6 = KClassImpl$Data$declaredNonStaticMembers$2(promoBannerContentModel.getGmtModified());
                cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda5 = promoBannerContentModel.getLanguage();
                Integer priority = promoBannerContentModel.getPriority();
                cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda3 = priority != null ? priority.intValue() : 0;
                cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda4 = promoBannerContentModel.getRedirectUrl();
                cdpContentModel.FragmentBottomSheetPaymentSettingBinding = promoBannerContentModel.getSelectRule();
                cdpContentModel.whenAvailable = promoBannerContentModel.getSpaceCode();
                cdpContentModel.getCallingPid = promoBannerContentModel.getStatus();
                cdpContentModel.readMicros = promoBannerContentModel.getTenantId();
                cdpContentModel.newProxyInstance = promoBannerContentModel.getExtendInfo();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            arrayList.add(cdpContentModel);
        }
        return arrayList;
    }

    private static final Date KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Locale locale;
        if (str != null) {
            if (!(str.length() > 0)) {
                str = null;
            }
            if (str != null) {
                locale = Locale.getDefault();
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).parse(str);
            }
            return null;
        }
        return null;
    }
}
