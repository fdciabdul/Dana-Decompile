package id.dana.data.referral.repository.source.local;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class ReferralPreferences {
    private static final String REFERRAL_PREFERENCES;
    private final PreferenceFacade preferenceFacade;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("ReferralPreferences");
        sb.append("production");
        REFERRAL_PREFERENCES = sb.toString();
    }

    @Inject
    public ReferralPreferences(Context context, Serializer serializer) {
        this.preferenceFacade = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(REFERRAL_PREFERENCES).setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
    }

    public String getReferralCode() {
        if (this.preferenceFacade.getString("referral_code_key") != null) {
            return this.preferenceFacade.getString("referral_code_key");
        }
        return null;
    }

    public Boolean saveReferralCode(String str) {
        this.preferenceFacade.saveData("referral_code_key", str);
        return Boolean.TRUE;
    }

    public void clearAll() {
        this.preferenceFacade.clearAllData();
    }

    /* loaded from: classes8.dex */
    static class Key {
        private Key() {
        }
    }
}
