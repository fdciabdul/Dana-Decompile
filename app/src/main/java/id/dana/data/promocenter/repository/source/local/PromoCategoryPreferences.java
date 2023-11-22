package id.dana.data.promocenter.repository.source.local;

import android.content.Context;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterCategoryResult;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class PromoCategoryPreferences {
    private static final String PROMO_CENTER_CATEGORY_PREFERENCES;
    private final PreferenceFacade preferenceFacade;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("PromoCategoryPreferences");
        sb.append("production");
        PROMO_CENTER_CATEGORY_PREFERENCES = sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public PromoCategoryPreferences(Context context, Serializer serializer) {
        this.preferenceFacade = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(PROMO_CENTER_CATEGORY_PREFERENCES).setSerializerFacade(serializer)).createData2("local");
    }

    public PromoCenterCategoryResult getCategories() {
        PromoCenterCategoryResult promoCenterCategoryResult = (PromoCenterCategoryResult) this.preferenceFacade.getObject("promo_center_category_key", PromoCenterCategoryResult.class);
        return promoCenterCategoryResult == null ? new PromoCenterCategoryResult() : promoCenterCategoryResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean saveCategories(PromoCenterCategoryResult promoCenterCategoryResult) {
        this.preferenceFacade.saveData("promo_center_category_key", (String) promoCenterCategoryResult);
        return true;
    }

    /* loaded from: classes8.dex */
    static class Key {
        private Key() {
        }
    }
}
