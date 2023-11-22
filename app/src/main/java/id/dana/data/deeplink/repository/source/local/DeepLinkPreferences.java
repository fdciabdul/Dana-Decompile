package id.dana.data.deeplink.repository.source.local;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class DeepLinkPreferences {
    private static final String DEEPLINK_PREFERENCES;
    private final PreferenceFacade preferenceFacade;

    private String getKey(boolean z) {
        return z ? "profile_deeplink_url_key" : "profile_deeplink_url_key_without_referral";
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("DeepLinkPreferences");
        sb.append("production");
        DEEPLINK_PREFERENCES = sb.toString();
    }

    @Inject
    public DeepLinkPreferences(Context context, Serializer serializer) {
        this.preferenceFacade = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(DEEPLINK_PREFERENCES).setUseDrutherPreference(true).setSerializerFacade(serializer)).createData("local");
    }

    public String getProfileDeepLinkUrl(boolean z) {
        return this.preferenceFacade.getString(getKey(z));
    }

    public Boolean saveProfileDeepLinkUrl(String str, boolean z) {
        this.preferenceFacade.saveData(getKey(z), str);
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
