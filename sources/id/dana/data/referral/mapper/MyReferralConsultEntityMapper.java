package id.dana.data.referral.mapper;

import id.dana.data.BaseMapper;
import id.dana.data.referral.repository.source.network.result.MyReferralConsultEntityResult;
import id.dana.data.referral.repository.source.network.result.ReferralCampaignEntityResult;
import id.dana.domain.referral.model.MyReferralConsultRpcResponse;
import id.dana.domain.referral.model.ReferralCampaignInfoResponse;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class MyReferralConsultEntityMapper {
    @Inject
    public MyReferralConsultEntityMapper() {
    }

    public MyReferralConsultRpcResponse transformMyReferral(MyReferralConsultEntityResult myReferralConsultEntityResult) {
        if (myReferralConsultEntityResult != null) {
            MyReferralConsultRpcResponse myReferralConsultRpcResponse = new MyReferralConsultRpcResponse();
            BaseMapper.transform(myReferralConsultRpcResponse, myReferralConsultEntityResult);
            myReferralConsultRpcResponse.setHowToUrl(myReferralConsultEntityResult.getHowToUrl());
            myReferralConsultRpcResponse.setReferralCode(myReferralConsultEntityResult.getReferralCode());
            myReferralConsultRpcResponse.setReferrerCampaignInfo(transFormCampaign(myReferralConsultEntityResult.getReferrerCampaignInfo()));
            myReferralConsultRpcResponse.setReferredCampaignInfo(transFormCampaign(myReferralConsultEntityResult.getReferredCampaignInfo()));
            myReferralConsultRpcResponse.setCampaignUpdated(myReferralConsultEntityResult.isCampaignUpdated());
            return myReferralConsultRpcResponse;
        }
        return null;
    }

    private ReferralCampaignInfoResponse transFormCampaign(ReferralCampaignEntityResult referralCampaignEntityResult) {
        if (referralCampaignEntityResult != null) {
            ReferralCampaignInfoResponse referralCampaignInfoResponse = new ReferralCampaignInfoResponse();
            referralCampaignInfoResponse.setPrizeName(referralCampaignEntityResult.getPrizeName());
            referralCampaignInfoResponse.setCampaignId(referralCampaignEntityResult.getActivityId());
            referralCampaignInfoResponse.setCampaignEnabled(referralCampaignEntityResult.isCampaignEnabled());
            referralCampaignInfoResponse.setPrizeAmount(referralCampaignEntityResult.getPrizeAmount());
            return referralCampaignInfoResponse;
        }
        return null;
    }
}
