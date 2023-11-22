package id.dana.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.promotion.CdpContent;
import id.dana.domain.promotion.Space;
import id.dana.model.CdpContentModel;
import id.dana.model.LeaderboardModel;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes9.dex */
public class LeaderboardMapper extends BaseMapper<Space, LeaderboardModel> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ LeaderboardModel map(Space space) {
        CdpContent cdpContent;
        Space space2 = space;
        CdpContentModel cdpContentModel = null;
        if (space2 == null) {
            return null;
        }
        LeaderboardModel leaderboardModel = new LeaderboardModel();
        leaderboardModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = space2.getSpaceCode();
        leaderboardModel.GetContactSyncConfig = space2.getSpaceName();
        leaderboardModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = space2.getStatus();
        leaderboardModel.getErrorConfigVersion = space2.getGmtModified();
        leaderboardModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = space2.getGmtCreate();
        leaderboardModel.lookAheadTest = space2.getPlatform();
        leaderboardModel.initRecordTimeStamp = space2.getSpaceType();
        leaderboardModel.PlaceComponentResult = space2.getAllowedContent();
        leaderboardModel.moveToNextValue = space2.getDisplayStrategy();
        leaderboardModel.scheduleImpl = space2.getMarqueeTime();
        leaderboardModel.getAuthRequestContext = space2.getContentNumLimit();
        leaderboardModel.MyBillsEntityDataFactory = space2.getContentTextLimit();
        leaderboardModel.DatabaseTableConfigUtil = space2.getSpm();
        leaderboardModel.PrepareContext = space2.getWhiteList();
        leaderboardModel.KClassImpl$Data$declaredNonStaticMembers$2 = space2.getDefaultLang();
        List<CdpContent> cdpContents = space2.getCdpContents();
        if (cdpContents != null && !cdpContents.isEmpty() && (cdpContent = cdpContents.get(0)) != null) {
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
            cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda5 = cdpContent.getLanguage();
            cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda6 = cdpContent.getGmtModified();
            cdpContentModel.isLayoutRequested = cdpContent.getGmtCreate();
            cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda3 = cdpContent.getPriority();
            cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda8 = cdpContent.getEffectiveDate();
            cdpContentModel.PrepareContext = cdpContent.getExpireDate();
            cdpContentModel.FragmentBottomSheetPaymentSettingBinding = cdpContent.getSelectRule();
            cdpContentModel.initRecordTimeStamp = cdpContent.getBizType();
            cdpContentModel.newProxyInstance = cdpContent.getExtendInfo();
        }
        leaderboardModel.BuiltInFictitiousFunctionClassFactory = cdpContentModel;
        return leaderboardModel;
    }

    @Inject
    public LeaderboardMapper() {
    }
}
