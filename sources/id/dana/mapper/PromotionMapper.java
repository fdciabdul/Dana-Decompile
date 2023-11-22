package id.dana.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.promotion.CdpContent;
import id.dana.domain.promotion.Space;
import id.dana.model.CdpContentModel;
import id.dana.model.PromotionModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class PromotionMapper extends BaseMapper<Space, PromotionModel> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ PromotionModel map(Space space) {
        CdpContentModel cdpContentModel;
        Space space2 = space;
        ArrayList arrayList = null;
        if (space2 != null) {
            PromotionModel promotionModel = new PromotionModel();
            promotionModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = space2.getSpaceCode();
            promotionModel.GetContactSyncConfig = space2.getSpaceName();
            promotionModel.initRecordTimeStamp = space2.getStatus();
            promotionModel.getErrorConfigVersion = space2.getGmtModified();
            promotionModel.moveToNextValue = space2.getGmtCreate();
            promotionModel.lookAheadTest = space2.getPlatform();
            promotionModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = space2.getSpaceType();
            promotionModel.MyBillsEntityDataFactory = space2.getAllowedContent();
            promotionModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = space2.getDisplayStrategy();
            promotionModel.scheduleImpl = space2.getMarqueeTime();
            promotionModel.PlaceComponentResult = space2.getContentNumLimit();
            promotionModel.getAuthRequestContext = space2.getContentTextLimit();
            promotionModel.DatabaseTableConfigUtil = space2.getSpm();
            promotionModel.NetworkUserEntityData$$ExternalSyntheticLambda7 = space2.getWhiteList();
            promotionModel.BuiltInFictitiousFunctionClassFactory = space2.getDefaultLang();
            List<CdpContent> cdpContents = space2.getCdpContents();
            if (cdpContents != null && !cdpContents.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                for (CdpContent cdpContent : cdpContents) {
                    if (cdpContent != null) {
                        cdpContentModel = new CdpContentModel();
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
                    } else {
                        cdpContentModel = null;
                    }
                    arrayList2.add(cdpContentModel);
                }
                arrayList = arrayList2;
            }
            promotionModel.KClassImpl$Data$declaredNonStaticMembers$2 = arrayList;
            return promotionModel;
        }
        return null;
    }

    @Inject
    public PromotionMapper() {
    }
}
