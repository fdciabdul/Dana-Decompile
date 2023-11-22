package id.dana.data.storage;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.utils.storage.AppInfo;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class AppInfoPreference implements AppInfo {
    private static final String APP_INFO_PREFERENCES;
    private final PreferenceFacade preferenceFacade;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("AppInfoPreference");
        sb.append("production");
        APP_INFO_PREFERENCES = sb.toString();
    }

    @Inject
    public AppInfoPreference(Context context, Serializer serializer) {
        this.preferenceFacade = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(APP_INFO_PREFERENCES).setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
    }

    @Override // id.dana.utils.storage.AppInfo
    public void saveUtdid(String str) {
        this.preferenceFacade.saveData("utdid", str);
    }

    @Override // id.dana.utils.storage.AppInfo
    public void saveUtdIdForMixpanel(String str) {
        this.preferenceFacade.saveData("utdid_for_mixpanel", str);
    }

    @Override // id.dana.utils.storage.AppInfo
    public String getUtdid() {
        return this.preferenceFacade.getString("utdid");
    }

    @Override // id.dana.utils.storage.AppInfo
    public String getUtdIdForMixpanel() {
        return this.preferenceFacade.getString("utdid_for_mixpanel");
    }

    /* loaded from: classes8.dex */
    static class Key {
        private Key() {
        }
    }
}
