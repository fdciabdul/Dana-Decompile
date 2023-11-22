package id.dana.data.homeinfo.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.homeinfo.model.KycEntity;
import id.dana.data.homeinfo.model.ProcessingTransactionEntity;
import id.dana.data.homeinfo.model.SurveyInfo;
import id.dana.data.homeinfo.model.ThirdPartyEntity;
import id.dana.data.model.CurrencyAmountResult;
import id.dana.domain.homeinfo.AkuInfo;
import java.util.List;

/* loaded from: classes4.dex */
public class HomeInfoResult extends BaseRpcResult {
    private AkuInfo akuInfo;
    private String avatarUrl;
    private CurrencyAmountResult balance;
    private KycEntity kyc;
    private String mobileNo;
    private String nickname;
    public String paylaterChannel;
    private ProcessingTransactionEntity processingTrans;
    private SurveyInfo surveyInfo;
    private List<ThirdPartyEntity> thirdPartyLinks;

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public CurrencyAmountResult getBalance() {
        return this.balance;
    }

    public void setBalance(CurrencyAmountResult currencyAmountResult) {
        this.balance = currencyAmountResult;
    }

    public KycEntity getKyc() {
        return this.kyc;
    }

    public void setKyc(KycEntity kycEntity) {
        this.kyc = kycEntity;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public void setMobileNo(String str) {
        this.mobileNo = str;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public ProcessingTransactionEntity getProcessingTrans() {
        return this.processingTrans;
    }

    public void setProcessingTrans(ProcessingTransactionEntity processingTransactionEntity) {
        this.processingTrans = processingTransactionEntity;
    }

    public SurveyInfo getSurveyInfo() {
        return this.surveyInfo;
    }

    public void setSurveyInfo(SurveyInfo surveyInfo) {
        this.surveyInfo = surveyInfo;
    }

    public AkuInfo getAkuInfo() {
        return this.akuInfo;
    }

    public void setAkuInfo(AkuInfo akuInfo) {
        this.akuInfo = akuInfo;
    }

    public List<ThirdPartyEntity> getThirdPartyLinks() {
        return this.thirdPartyLinks;
    }

    public void setThirdPartyLinks(List<ThirdPartyEntity> list) {
        this.thirdPartyLinks = list;
    }

    public String getPaylaterChannel() {
        return this.paylaterChannel;
    }

    public void setPaylaterChannel(String str) {
        this.paylaterChannel = str;
    }
}
