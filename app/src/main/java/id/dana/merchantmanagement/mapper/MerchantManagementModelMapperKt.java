package id.dana.merchantmanagement.mapper;

import id.dana.domain.merchantmanagement.model.LinkedMerchant;
import id.dana.domain.merchantmanagement.model.LinkedMerchantInfo;
import id.dana.domain.merchantmanagement.model.UnbindConsultInfo;
import id.dana.domain.promotion.CdpContent;
import id.dana.merchantmanagement.model.LinkedMerchantModel;
import id.dana.merchantmanagement.model.UnbindMerchantModel;
import id.dana.model.CdpContentModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0000*\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\u0007\u001a\u00020\r*\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0007\u0010\u000e"}, d2 = {"", "Lid/dana/domain/promotion/CdpContent;", "Lid/dana/model/CdpContentModel;", "PlaceComponentResult", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/domain/merchantmanagement/model/LinkedMerchantInfo;", "Lid/dana/merchantmanagement/model/LinkedMerchantModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/merchantmanagement/model/LinkedMerchantInfo;)Ljava/util/List;", "Lid/dana/domain/merchantmanagement/model/UnbindConsultInfo;", "", "p0", "p1", "Lid/dana/merchantmanagement/model/UnbindMerchantModel;", "(Lid/dana/domain/merchantmanagement/model/UnbindConsultInfo;Ljava/lang/String;Ljava/lang/String;)Lid/dana/merchantmanagement/model/UnbindMerchantModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantManagementModelMapperKt {
    public static final List<LinkedMerchantModel> KClassImpl$Data$declaredNonStaticMembers$2(LinkedMerchantInfo linkedMerchantInfo) {
        Intrinsics.checkNotNullParameter(linkedMerchantInfo, "");
        List<LinkedMerchant> merchantList = linkedMerchantInfo.getMerchantList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(merchantList, 10));
        for (LinkedMerchant linkedMerchant : merchantList) {
            arrayList.add(new LinkedMerchantModel(linkedMerchant.getMerchantName(), linkedMerchant.getMerchantLogo(), linkedMerchant.getMerchantPCLogo(), linkedMerchant.getMerchantBoundDate(), linkedMerchant.getMerchantId(), linkedMerchant.getDivisionId(), linkedMerchant.getClientId(), linkedMerchant.getRegId(), linkedMerchant.getUserBoundId(), 0, 512, null));
        }
        return arrayList;
    }

    public static final UnbindMerchantModel KClassImpl$Data$declaredNonStaticMembers$2(UnbindConsultInfo unbindConsultInfo, String str, String str2) {
        Intrinsics.checkNotNullParameter(unbindConsultInfo, "");
        return new UnbindMerchantModel(unbindConsultInfo.getPubKey(), unbindConsultInfo.getSecurityId(), unbindConsultInfo.getClientId(), unbindConsultInfo.getMerchantId(), unbindConsultInfo.getDivisionId(), str, str2);
    }

    public static final List<CdpContentModel> PlaceComponentResult(List<? extends CdpContent> list) {
        if (list != null) {
            List<? extends CdpContent> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (CdpContent cdpContent : list2) {
                Intrinsics.checkNotNullParameter(cdpContent, "");
                CdpContentModel cdpContentModel = new CdpContentModel();
                cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = cdpContent.getContentId();
                cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = cdpContent.getContentName();
                cdpContentModel.DatabaseTableConfigUtil = cdpContent.getContentType();
                cdpContentModel.GetContactSyncConfig = cdpContent.getContentValue();
                cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda4 = cdpContent.getRedirectUrl();
                cdpContentModel.whenAvailable = cdpContent.getSpaceCode();
                cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda7 = cdpContent.getEnvType();
                cdpContentModel.getCallingPid = cdpContent.getStatus();
                cdpContentModel.readMicros = cdpContent.getTenantId();
                cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = cdpContent.getContentName();
                cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda5 = cdpContent.getLanguage();
                cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda6 = cdpContent.getGmtModified();
                cdpContentModel.isLayoutRequested = cdpContent.getGmtCreate();
                cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda3 = cdpContent.getPriority();
                cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda8 = cdpContent.getEffectiveDate();
                cdpContentModel.PrepareContext = cdpContent.getExpireDate();
                cdpContentModel.FragmentBottomSheetPaymentSettingBinding = cdpContent.getSelectRule();
                cdpContentModel.initRecordTimeStamp = cdpContent.getBizType();
                cdpContentModel.newProxyInstance = cdpContent.getExtendInfo();
                arrayList.add(cdpContentModel);
            }
            return arrayList;
        }
        return new ArrayList();
    }
}
