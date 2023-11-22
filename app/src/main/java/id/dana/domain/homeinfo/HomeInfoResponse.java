package id.dana.domain.homeinfo;

import id.dana.domain.user.CurrencyAmount;
import id.dana.utils.rpc.response.BaseRpcResponse;
import java.util.List;

/* loaded from: classes4.dex */
public class HomeInfoResponse extends BaseRpcResponse {
    private AkuInfo akuInfo;
    private String avatarUrl;
    private CurrencyAmount balance;
    private KycResponse kyc;
    private String mobileNo;
    private String nickname;
    private String paylaterChannel;
    private ProcessingTransactionResponse processingTrans;
    private SurveyInfoResponse surveyInfo;
    private List<ThirdPartyServiceResponse> thirdPartyLinks;

    public String getMobileNo() {
        return this.mobileNo;
    }

    public void setMobileNo(String str) {
        this.mobileNo = str;
    }

    public CurrencyAmount getBalance() {
        return this.balance;
    }

    public void setBalance(CurrencyAmount currencyAmount) {
        this.balance = currencyAmount;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public ProcessingTransactionResponse getProcessingTrans() {
        return this.processingTrans;
    }

    public void setProcessingTrans(ProcessingTransactionResponse processingTransactionResponse) {
        this.processingTrans = processingTransactionResponse;
    }

    public List<ThirdPartyServiceResponse> getThirdPartyLinks() {
        return this.thirdPartyLinks;
    }

    public void setThirdPartyLinks(List<ThirdPartyServiceResponse> list) {
        this.thirdPartyLinks = list;
    }

    public KycResponse getKyc() {
        return this.kyc;
    }

    public void setKyc(KycResponse kycResponse) {
        this.kyc = kycResponse;
    }

    public SurveyInfoResponse getSurveyInfo() {
        return this.surveyInfo;
    }

    public void setSurveyInfo(SurveyInfoResponse surveyInfoResponse) {
        this.surveyInfo = surveyInfoResponse;
    }

    public AkuInfo getAkuInfo() {
        return this.akuInfo;
    }

    public void setAkuInfo(AkuInfo akuInfo) {
        this.akuInfo = akuInfo;
    }

    public String getPaylaterChannel() {
        return this.paylaterChannel;
    }

    public void setPaylaterChannel(String str) {
        this.paylaterChannel = str;
    }
}
