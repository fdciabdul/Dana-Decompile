package id.dana.data.tracker.repository.source.local;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class MixpanelPreferences {
    private static final String MIXPANEL_ALIAS_EXIST_PREFERENCES;
    private final PreferenceFacade preferenceFacade;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("MixpanelPreferences");
        sb.append("production");
        MIXPANEL_ALIAS_EXIST_PREFERENCES = sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public MixpanelPreferences(Context context, Serializer serializer) {
        this.preferenceFacade = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(MIXPANEL_ALIAS_EXIST_PREFERENCES).setSerializerFacade(serializer)).createData("local");
    }

    public boolean getAliasExist() {
        return this.preferenceFacade.getBoolean("mixpanel_alias_exist_key").booleanValue();
    }

    public void saveMixpanelAliasExist(boolean z) {
        this.preferenceFacade.saveData("mixpanel_alias_exist_key", Boolean.valueOf(z));
    }

    /* loaded from: classes8.dex */
    static class Key {
        private Key() {
        }
    }
}
