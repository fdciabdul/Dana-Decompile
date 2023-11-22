package id.dana.data.version;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class StorageVersionPreference {
    private static final String getAuthRequestContext;
    final PreferenceFacade KClassImpl$Data$declaredNonStaticMembers$2;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("StorageVersionPreference");
        sb.append("production");
        getAuthRequestContext = sb.toString();
    }

    @Inject
    public StorageVersionPreference(Context context, Serializer serializer) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(getAuthRequestContext).setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
    }

    public final boolean PlaceComponentResult(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.saveData("storage_version", Integer.valueOf(i));
        return true;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.saveData("version_code", Integer.valueOf(i));
        return true;
    }

    /* loaded from: classes8.dex */
    static class Key {
        private Key() {
        }
    }
}
