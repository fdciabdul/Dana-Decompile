package id.dana.data.errorconfig.local;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class ErrorConfigPreferences {
    private static final String ERROR_CONFIG_PREFERENCES;
    private final PreferenceFacade preferenceFacade;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("ErrorConfigPreferences");
        sb.append("production");
        ERROR_CONFIG_PREFERENCES = sb.toString();
    }

    @Inject
    public ErrorConfigPreferences(Context context, Serializer serializer) {
        this.preferenceFacade = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(ERROR_CONFIG_PREFERENCES).setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
    }

    public int getErrorConfigVersion() {
        if (this.preferenceFacade.getInteger("error_config_version_code_key") != null) {
            return this.preferenceFacade.getInteger("error_config_version_code_key").intValue();
        }
        return 0;
    }

    public void saveErrorConfigVersion(int i) {
        this.preferenceFacade.saveData("error_config_version_code_key", Integer.valueOf(i));
    }

    /* loaded from: classes8.dex */
    static class Key {
        private Key() {
        }
    }
}
