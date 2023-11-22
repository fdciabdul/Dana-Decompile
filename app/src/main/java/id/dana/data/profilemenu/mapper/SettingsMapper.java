package id.dana.data.profilemenu.mapper;

import id.dana.data.profilemenu.model.SettingEntity;
import id.dana.data.profilemenu.repository.source.network.result.AuthenticationTypeOptionResult;
import id.dana.data.profilemenu.repository.source.network.result.PaymentSecurityInitResult;
import id.dana.domain.profilemenu.model.AuthenticationTypeOption;
import id.dana.domain.profilemenu.model.PaymentSecurityInit;
import id.dana.domain.profilemenu.model.PaymentSecuritySwitch;
import id.dana.domain.profilemenu.model.Risk;
import id.dana.domain.profilemenu.model.SecurityContext;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.network.response.profilemenu.PaymentSecuritySwitchResult;
import id.dana.network.response.profilemenu.RiskResult;
import id.dana.network.response.profilemenu.SecurityContextResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class SettingsMapper {
    @Inject
    public SettingsMapper() {
    }

    public LinkedHashMap<String, LinkedHashMap<String, SettingModel>> transform(LinkedHashMap<String, LinkedHashMap<String, SettingEntity>> linkedHashMap) {
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            return null;
        }
        LinkedHashMap<String, LinkedHashMap<String, SettingModel>> linkedHashMap2 = new LinkedHashMap<>();
        for (Map.Entry<String, LinkedHashMap<String, SettingEntity>> entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry.getKey(), transforms(entry.getValue()));
        }
        return linkedHashMap2;
    }

    public LinkedHashMap<String, SettingModel> transforms(LinkedHashMap<String, SettingEntity> linkedHashMap) {
        if (linkedHashMap != null) {
            LinkedHashMap<String, SettingModel> linkedHashMap2 = new LinkedHashMap<>();
            for (Map.Entry<String, SettingEntity> entry : linkedHashMap.entrySet()) {
                String key = entry.getKey();
                linkedHashMap2.put(key, transform(key, entry.getValue()));
            }
            return linkedHashMap2;
        }
        return null;
    }

    public SettingModel transform(String str, SettingEntity settingEntity) {
        if (settingEntity != null) {
            SettingModel settingModel = new SettingModel();
            settingModel.setName(str);
            settingModel.setTitle(settingEntity.getTitle());
            settingModel.setTitleEn(settingEntity.getTitleEn());
            settingModel.setSubtitle(settingEntity.getSubtitle());
            settingModel.setSubtitleEn(settingEntity.getSubtitleEn());
            settingModel.setSubtitleIsBelow(settingEntity.getSubtitleIsBelow());
            settingModel.setSubtitleType(settingEntity.getSubtitleType());
            settingModel.setSubtitleColor(settingEntity.getSubtitleColor());
            settingModel.setIconUrl(settingEntity.getIconUrl());
            settingModel.setEnable(settingEntity.isEnable());
            settingModel.setAction(settingEntity.getAction());
            settingModel.setRedirectUrl(settingEntity.getRedirectUrl());
            settingModel.setCollection(settingEntity.getCollection());
            settingModel.setHasReddot(settingEntity.hasReddot());
            return settingModel;
        }
        return null;
    }

    public PaymentSecurityInit transform(PaymentSecurityInitResult paymentSecurityInitResult) {
        if (paymentSecurityInitResult != null) {
            PaymentSecurityInit paymentSecurityInit = new PaymentSecurityInit();
            paymentSecurityInit.setAuthenticationFeatureStatus(paymentSecurityInitResult.authenticationFeatureStatus);
            paymentSecurityInit.setAuthenticationStatus(paymentSecurityInitResult.authenticationStatus);
            ArrayList arrayList = new ArrayList();
            Iterator<AuthenticationTypeOptionResult> it = paymentSecurityInitResult.authenticationSettingOptions.iterator();
            while (it.hasNext()) {
                arrayList.add(transform(it.next()));
            }
            paymentSecurityInit.setAuthenticationTypeOption(arrayList);
            return paymentSecurityInit;
        }
        return null;
    }

    public PaymentSecuritySwitch transform(PaymentSecuritySwitchResult paymentSecuritySwitchResult) {
        if (paymentSecuritySwitchResult != null) {
            PaymentSecuritySwitch paymentSecuritySwitch = new PaymentSecuritySwitch();
            paymentSecuritySwitch.setRisk(transform(paymentSecuritySwitchResult.riskResult));
            paymentSecuritySwitch.setSecurityContext(transform(paymentSecuritySwitchResult.securityContext));
            return paymentSecuritySwitch;
        }
        return null;
    }

    public AuthenticationTypeOption transform(AuthenticationTypeOptionResult authenticationTypeOptionResult) {
        if (authenticationTypeOptionResult != null) {
            AuthenticationTypeOption authenticationTypeOption = new AuthenticationTypeOption();
            authenticationTypeOption.setAuthenticationType(authenticationTypeOptionResult.authenticationType);
            return authenticationTypeOption;
        }
        return null;
    }

    public Risk transform(RiskResult riskResult) {
        if (riskResult != null) {
            Risk risk = new Risk();
            risk.setSecurityId(riskResult.securityId);
            risk.setResult(riskResult.result);
            risk.setVerificationMethod(riskResult.verificationMethod);
            return risk;
        }
        return null;
    }

    public SecurityContext transform(SecurityContextResult securityContextResult) {
        if (securityContextResult != null) {
            SecurityContext securityContext = new SecurityContext();
            securityContext.setPubKey(securityContextResult.pubKey);
            return securityContext;
        }
        return null;
    }
}
