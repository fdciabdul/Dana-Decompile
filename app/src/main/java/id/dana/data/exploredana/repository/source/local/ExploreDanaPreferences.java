package id.dana.data.exploredana.repository.source.local;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.domain.promotion.CdpContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class ExploreDanaPreferences {
    private static final String EXPLORE_DANA_PREFERENCES = "ExploreDanaPreferencesproduction";
    private PreferenceFacade preferenceFacade;

    @Inject
    public ExploreDanaPreferences(Context context, Serializer serializer) {
        this.preferenceFacade = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(EXPLORE_DANA_PREFERENCES).setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
    }

    public List<CdpContent> checkExploreDanaItem(List<CdpContent> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (int i = 0; i < list.size(); i++) {
            if (this.preferenceFacade.getString(list.get(i).getContentId()) == null) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }

    public Boolean setDismissAll(List<String> list) {
        if (list == null) {
            return Boolean.FALSE;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            saveExploreDanaItem(it.next());
        }
        return Boolean.TRUE;
    }

    public Boolean saveExploreDanaItem(String str) {
        this.preferenceFacade.saveData(str, str);
        return Boolean.TRUE;
    }
}
