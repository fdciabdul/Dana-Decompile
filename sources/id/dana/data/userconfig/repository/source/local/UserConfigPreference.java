package id.dana.data.userconfig.repository.source.local;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.userconfig.UserConfigBizTypeConstant;
import id.dana.data.userconfig.repository.source.network.result.UserGeneralConfig;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class UserConfigPreference {
    public static final String CONTENT = "_CONTENT";
    public static final String ETAG = "_ETAG";
    public static final String LAST_UPDATED_TIME = "_LAST_UPDATED_TIME";
    private static final String USER_CONFIG_PREFERENCE = "UserConfigPreferenceproduction";
    private final PreferenceFacade preferenceFacade;
    private final SecurityGuardFacade securityGuardFacade;

    @Inject
    public UserConfigPreference(Context context) {
        this.preferenceFacade = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(USER_CONFIG_PREFERENCE)).createData("local");
        this.securityGuardFacade = new SecurityGuardFacade(context);
    }

    public UserConfigEntity getUserConfig(String str) {
        UserConfigEntity fromPreference = UserConfigEntity.fromPreference(this.preferenceFacade, str);
        if (UserConfigBizTypeConstant.CONFIG_SECURE_RECENT_TRANSACTION.equals(str)) {
            if (!this.preferenceFacade.getBoolean(LocalStorageFactory.KEY_SECURED, false).booleanValue()) {
                saveUserConfig(fromPreference.config);
                return fromPreference;
            }
            try {
                UserGeneralConfig userGeneralConfig = fromPreference.config;
                SecurityGuardFacade securityGuardFacade = this.securityGuardFacade;
                userGeneralConfig.setContent(securityGuardFacade.PlaceComponentResult().getDynamicDataEncryptComp().dynamicDecryptDDp(fromPreference.config.getContent()));
                return fromPreference;
            } catch (SecException unused) {
                return null;
            }
        }
        return fromPreference;
    }

    public boolean saveUserConfig(UserGeneralConfig userGeneralConfig) {
        String bizType = userGeneralConfig.getBizType();
        if (UserConfigBizTypeConstant.CONFIG_SECURE_RECENT_TRANSACTION.equals(bizType)) {
            try {
                PreferenceFacade preferenceFacade = this.preferenceFacade;
                StringBuilder sb = new StringBuilder();
                sb.append(bizType);
                sb.append(CONTENT);
                String obj = sb.toString();
                SecurityGuardFacade securityGuardFacade = this.securityGuardFacade;
                preferenceFacade.saveData(obj, securityGuardFacade.PlaceComponentResult().getDynamicDataEncryptComp().dynamicEncryptDDp(userGeneralConfig.getContent()));
                this.preferenceFacade.saveData(LocalStorageFactory.KEY_SECURED, Boolean.TRUE);
            } catch (SecException unused) {
                PreferenceFacade preferenceFacade2 = this.preferenceFacade;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(bizType);
                sb2.append(CONTENT);
                preferenceFacade2.saveData(sb2.toString(), userGeneralConfig.getContent());
            }
        } else {
            PreferenceFacade preferenceFacade3 = this.preferenceFacade;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(bizType);
            sb3.append(CONTENT);
            preferenceFacade3.saveData(sb3.toString(), userGeneralConfig.getContent());
        }
        PreferenceFacade preferenceFacade4 = this.preferenceFacade;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(bizType);
        sb4.append(LAST_UPDATED_TIME);
        preferenceFacade4.saveData(sb4.toString(), Long.valueOf(userGeneralConfig.getLastUpdatedTime()));
        return true;
    }

    public boolean saveEtag(String str, String str2) {
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(ETAG);
        preferenceFacade.saveData(sb.toString(), str2);
        return true;
    }

    public String getEtag(String str) {
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(ETAG);
        String string = preferenceFacade.getString(sb.toString());
        return string == null ? "" : string;
    }

    public void clearAll() {
        this.preferenceFacade.clearAllData();
    }
}
