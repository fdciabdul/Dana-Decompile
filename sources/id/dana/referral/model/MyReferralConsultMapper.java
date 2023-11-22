package id.dana.referral.model;

import id.dana.domain.referral.model.MyReferralConsultRpcResponse;
import id.dana.domain.referral.model.ReferralCampaignInfoResponse;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class MyReferralConsultMapper {
    private final CurrencyAmountModelMapper getAuthRequestContext;

    @Inject
    public MyReferralConsultMapper(CurrencyAmountModelMapper currencyAmountModelMapper) {
        this.getAuthRequestContext = currencyAmountModelMapper;
    }

    public final MyReferralConsult BuiltInFictitiousFunctionClassFactory(MyReferralConsultRpcResponse myReferralConsultRpcResponse) {
        if (myReferralConsultRpcResponse != null) {
            MyReferralConsult myReferralConsult = new MyReferralConsult();
            myReferralConsult.PlaceComponentResult = myReferralConsultRpcResponse.getHowToUrl();
            myReferralConsult.MyBillsEntityDataFactory = myReferralConsultRpcResponse.getReferralCode();
            myReferralConsult.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory(myReferralConsultRpcResponse.getReferrerCampaignInfo());
            myReferralConsult.getAuthRequestContext = MyBillsEntityDataFactory(myReferralConsultRpcResponse.getReferredCampaignInfo());
            return myReferralConsult;
        }
        return null;
    }

    private ReferralCampaignInfo MyBillsEntityDataFactory(ReferralCampaignInfoResponse referralCampaignInfoResponse) {
        if (referralCampaignInfoResponse != null) {
            ReferralCampaignInfo referralCampaignInfo = new ReferralCampaignInfo();
            referralCampaignInfo.MyBillsEntityDataFactory = referralCampaignInfoResponse.getPrizeName();
            referralCampaignInfo.KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext.apply(referralCampaignInfoResponse.getPrizeAmount());
            referralCampaignInfo.PlaceComponentResult = referralCampaignInfoResponse.getCampaignId();
            referralCampaignInfo.BuiltInFictitiousFunctionClassFactory = referralCampaignInfoResponse.isCampaignEnabled();
            return referralCampaignInfo;
        }
        return null;
    }
}
