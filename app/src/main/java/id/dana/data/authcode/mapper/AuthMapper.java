package id.dana.data.authcode.mapper;

import android.text.TextUtils;
import id.dana.data.BaseMapper;
import id.dana.data.authcode.AuthCodeEntity;
import id.dana.data.authcode.QueryAuthInfoResult;
import id.dana.data.oauth.model.AgreementResult;
import id.dana.data.oauth.model.MerchantInfoResult;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.authcode.QueryAuthInfo;
import id.dana.domain.oauth.model.Agreement;
import id.dana.domain.oauth.model.MerchantInfo;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class AuthMapper {
    @Inject
    public AuthMapper() {
    }

    public AuthCodeResult transform(AuthCodeEntity authCodeEntity) {
        if (authCodeEntity != null) {
            AuthCodeResult authCodeResult = new AuthCodeResult();
            BaseMapper.transform(authCodeResult, authCodeEntity);
            authCodeResult.setAuthCode(authCodeEntity.getAuthCode());
            authCodeResult.setState(authCodeEntity.getState());
            authCodeResult.setMerchantRedirectUrl(authCodeEntity.getMerchantRedirectUrl());
            authCodeResult.setAction(authCodeEntity.getAction());
            authCodeResult.setPhoneNumber(authCodeEntity.getPhoneNumber());
            authCodeResult.setRiskPhoneNumber(authCodeEntity.getRiskPhoneNumber());
            authCodeResult.setSecurityId(authCodeEntity.getSecurityId());
            authCodeResult.setMerchantInfo(transform(authCodeEntity.getMerchantInfo()));
            authCodeResult.setAgreements(transform(authCodeEntity.getAgreements()));
            authCodeResult.setMobileAuthCode(authCodeEntity.getMobileAuthCode());
            authCodeResult.setVerificationMethods(authCodeEntity.getVerificationMethods());
            return authCodeResult;
        }
        return null;
    }

    public MerchantInfo transform(MerchantInfoResult merchantInfoResult) {
        if (merchantInfoResult != null) {
            MerchantInfo merchantInfo = new MerchantInfo();
            merchantInfo.setMerchantLogo(merchantInfoResult.getMerchantLogo());
            merchantInfo.setMerchantPCLogo(merchantInfoResult.getMerchantPCLogo());
            merchantInfo.setMerchantName(merchantInfoResult.getMerchantName());
            return merchantInfo;
        }
        return null;
    }

    public List<Agreement> transform(List<AgreementResult> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (AgreementResult agreementResult : list) {
                Agreement agreement = new Agreement();
                agreement.setDescription(agreementResult.getDescription());
                agreement.setTitle(agreementResult.getTitle());
                agreement.setName(agreementResult.getName());
                agreement.setType(agreementResult.getType());
                arrayList.add(agreement);
            }
            return arrayList;
        }
        return null;
    }

    public QueryAuthInfo transform(QueryAuthInfoResult queryAuthInfoResult) {
        if (queryAuthInfoResult != null) {
            return new QueryAuthInfo(!TextUtils.isEmpty(queryAuthInfoResult.getAuthBindStatus()) ? queryAuthInfoResult.getAuthBindStatus() : "", queryAuthInfoResult.getQueryAgain() != null ? queryAuthInfoResult.getQueryAgain().booleanValue() : false, TextUtils.isEmpty(queryAuthInfoResult.traceId) ? "" : queryAuthInfoResult.traceId);
        }
        return null;
    }
}
