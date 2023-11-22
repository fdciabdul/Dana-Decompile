package id.dana.data.storage;

import android.content.Context;
import android.text.TextUtils;
import id.dana.data.login.source.network.result.LoginRegisterConfigResult;
import id.dana.data.storage.LocalStorageFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class GeneralPreferences {
    private static final String GENERAL_PREFERENCES;
    private final PreferenceFacade preferenceFacade;
    private final Serializer serializer;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("GeneralPreferences");
        sb.append("production");
        GENERAL_PREFERENCES = sb.toString();
    }

    @Inject
    public GeneralPreferences(Context context, Serializer serializer) {
        this.serializer = serializer;
        this.preferenceFacade = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(GENERAL_PREFERENCES).setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
    }

    public Boolean getNotificationRegistrationToken() {
        return this.preferenceFacade.getBoolean("notif_regist_token");
    }

    public Boolean saveNotificationRegistrationToken(Boolean bool) {
        this.preferenceFacade.saveData("notif_regist_token", bool);
        return Boolean.TRUE;
    }

    public void saveLoginRegisterConfigResult(LoginRegisterConfigResult loginRegisterConfigResult) {
        this.preferenceFacade.saveData("LOGIN_REGISTER_CONFIG", (String) loginRegisterConfigResult);
    }

    public LoginRegisterConfigResult getLoginRegisterConfigResult() {
        return (LoginRegisterConfigResult) this.preferenceFacade.getObject("LOGIN_REGISTER_CONFIG", LoginRegisterConfigResult.class);
    }

    public Boolean isLocationPermissionDenied() {
        return this.preferenceFacade.getBoolean("location_permission_denied_and_never_ask_again");
    }

    public Boolean setLocationPermissionDenied(Boolean bool) {
        this.preferenceFacade.saveData("location_permission_denied_and_never_ask_again", bool);
        return Boolean.TRUE;
    }

    public boolean isAppFirstLaunch() {
        boolean z = !this.preferenceFacade.getBoolean("is_app_launched").booleanValue();
        if (z) {
            this.preferenceFacade.saveData("is_app_launched", Boolean.TRUE);
        }
        return z;
    }

    public String addInterstitialBannerReadList(String str) {
        List<String> interstitialBannerReadList = getInterstitialBannerReadList();
        interstitialBannerReadList.add(str);
        this.preferenceFacade.saveData("interstitial_banner_list", (String) interstitialBannerReadList);
        return str;
    }

    private List<String> getInterstitialBannerReadList() {
        String string = this.preferenceFacade.getString("interstitial_banner_list");
        if (TextUtils.isEmpty(string)) {
            return new ArrayList();
        }
        return this.serializer.deserializeList(string);
    }

    private void resetInterstitialBannerReadList() {
        this.preferenceFacade.clearData("interstitial_banner_reset_time");
        this.preferenceFacade.clearData("interstitial_banner_list");
    }

    public Boolean checkResetInterstitialBannerReadList(Long l) {
        if (isResetTimeValueLower(l).booleanValue() && l.longValue() > 0) {
            resetInterstitialBannerReadList();
        }
        return Boolean.TRUE;
    }

    private Boolean isResetTimeValueLower(Long l) {
        if (this.preferenceFacade.getLong("interstitial_banner_reset_time") != null) {
            return Boolean.valueOf(System.currentTimeMillis() >= this.preferenceFacade.getLong("interstitial_banner_reset_time").longValue() + l.longValue());
        }
        return Boolean.FALSE;
    }

    public Boolean saveResetInterstitialBannerTime(Long l) {
        if (isCheckShouldSaveResetTime().booleanValue()) {
            this.preferenceFacade.saveData("interstitial_banner_reset_time", l);
        }
        return Boolean.TRUE;
    }

    private Boolean isCheckShouldSaveResetTime() {
        return Boolean.valueOf(this.preferenceFacade.getLong("interstitial_banner_reset_time") == null || this.preferenceFacade.getLong("interstitial_banner_reset_time").longValue() < 0);
    }

    public Boolean checkBannerReadList(String str) {
        List<String> interstitialBannerReadList;
        boolean isEmpty = TextUtils.isEmpty(str);
        Boolean bool = Boolean.FALSE;
        if (!isEmpty && (interstitialBannerReadList = getInterstitialBannerReadList()) != null && !interstitialBannerReadList.isEmpty()) {
            Iterator<String> it = interstitialBannerReadList.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next())) {
                    return Boolean.TRUE;
                }
            }
        }
        return bool;
    }

    public Boolean checkShouldShowInterstitialBanner(Long l) {
        if (this.preferenceFacade.getLong("interstitial_banner_gap_time") != null && this.preferenceFacade.getLong("interstitial_banner_gap_time").longValue() >= 0) {
            return Boolean.valueOf(System.currentTimeMillis() >= this.preferenceFacade.getLong("interstitial_banner_gap_time").longValue() + l.longValue());
        }
        return Boolean.TRUE;
    }

    public Boolean saveInterstitialBannerNextGapTime(Long l) {
        this.preferenceFacade.saveData("interstitial_banner_gap_time", l);
        return Boolean.TRUE;
    }

    public boolean getBalanceVisibility() {
        return this.preferenceFacade.getBoolean("hide_balance_amount", true).booleanValue();
    }

    public Boolean setBalanceVisibility(Boolean bool) {
        this.preferenceFacade.saveData("hide_balance_amount", bool);
        return Boolean.TRUE;
    }

    public boolean getSavingBalanceVisibility() {
        return this.preferenceFacade.getBoolean("saving_balance_visibility", true).booleanValue();
    }

    public Boolean saveSavingBalanceVisibility(Boolean bool) {
        this.preferenceFacade.saveData("saving_balance_visibility", bool);
        return Boolean.TRUE;
    }

    public Boolean saveMigrateRoomToUserConfig(boolean z) {
        this.preferenceFacade.saveData("migrate_room_to_user_config", Boolean.valueOf(z));
        return Boolean.TRUE;
    }

    public boolean needMigrateRoomToUserConfig() {
        return this.preferenceFacade.getBoolean("migrate_room_to_user_config", false).booleanValue();
    }

    public boolean isRecentRecipientMigratedToRoom() {
        return this.preferenceFacade.getBoolean("recent_recipient_migrated_to_room", false).booleanValue();
    }

    public boolean setIsRecentRecipientMigratedToRoom(boolean z) {
        this.preferenceFacade.saveData("recent_recipient_migrated_to_room", Boolean.valueOf(z));
        return true;
    }

    public Boolean saveLatestSeenReferralCampaign(String str) {
        this.preferenceFacade.saveData("last_seen_referral_campaign_id", str);
        return Boolean.TRUE;
    }

    public String getLatestSeenReferralCampaignId() {
        return this.preferenceFacade.getString("last_seen_referral_campaign_id");
    }

    public Boolean setGeofenceRetryInterval(int i) {
        this.preferenceFacade.saveData("geofence_retry_interval", Integer.valueOf(i));
        return Boolean.TRUE;
    }

    public int getGeofenceRetryInterval() {
        return this.preferenceFacade.getInteger("geofence_retry_interval").intValue();
    }

    public boolean getAppShortcutEnabledFlag() {
        return this.preferenceFacade.getBoolean("dana_app_shortcut_enabled", false).booleanValue();
    }

    public boolean setAppShortcutEnabledFlag(boolean z) {
        this.preferenceFacade.saveData("dana_app_shortcut_enabled", Boolean.valueOf(z));
        return true;
    }

    public Boolean setGoalsBalanceVisibility(Boolean bool) {
        this.preferenceFacade.saveData("goals_balance_visibility", bool);
        return Boolean.TRUE;
    }

    public Boolean getGoalsBalanceVisibility() {
        return this.preferenceFacade.getBoolean("goals_balance_visibility", true);
    }

    public Boolean setInvestmentBalanceVisibility(Boolean bool) {
        this.preferenceFacade.saveData("investment_balance_amount", bool);
        return Boolean.TRUE;
    }

    public Boolean getInvestmentBalanceVisibility() {
        return this.preferenceFacade.getBoolean("investment_balance_amount", true);
    }

    public Boolean setEmasBalanceVisibility(Boolean bool) {
        this.preferenceFacade.saveData("emas_balance_visibility", bool);
        return Boolean.TRUE;
    }

    public Boolean getEmasBalanceVisibility() {
        return this.preferenceFacade.getBoolean("emas_balance_visibility", true);
    }

    public Boolean saveIsSessionChecked(Boolean bool) {
        this.preferenceFacade.saveData("IS_SESSION_CHECKED", bool);
        return Boolean.TRUE;
    }

    public Boolean getIsSessionChecked() {
        return this.preferenceFacade.getBoolean("IS_SESSION_CHECKED", false);
    }

    public <T> boolean saveData(String str, T t) {
        try {
            this.preferenceFacade.saveData(str, (String) t);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public <T> T getObject(String str, Class<T> cls) {
        try {
            return (T) this.preferenceFacade.getObject(str, cls);
        } catch (Exception unused) {
            return null;
        }
    }

    public void clearAll() {
        Boolean isLocationPermissionDenied = isLocationPermissionDenied();
        this.preferenceFacade.clearAllData();
        setLocationPermissionDenied(isLocationPermissionDenied);
    }

    /* loaded from: classes8.dex */
    static class Key {
        private Key() {
        }
    }
}
