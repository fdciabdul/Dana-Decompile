package id.dana.data.card.repository.source.local;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class CardPreferences {
    private static final String CARD_PREFERENCES = "Cardproduction";
    private final String key = "CARD_INDEX_NO";
    private PreferenceFacade preferenceFacade;

    @Inject
    public CardPreferences(Context context, Serializer serializer) {
        this.preferenceFacade = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(CARD_PREFERENCES).setUseDrutherPreference(true).setSerializerFacade(serializer)).createData("local");
    }

    public Boolean saveLastCardUsed(String str) {
        this.preferenceFacade.saveData("CARD_INDEX_NO", str);
        return Boolean.TRUE;
    }

    public String getDefaultCard() {
        String string = this.preferenceFacade.getString("CARD_INDEX_NO");
        return string == null ? "" : string;
    }
}
