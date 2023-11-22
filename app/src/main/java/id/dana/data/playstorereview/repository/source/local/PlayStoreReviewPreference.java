package id.dana.data.playstorereview.repository.source.local;

import android.content.Context;
import android.text.TextUtils;
import id.dana.data.playstorereview.model.PlayStoreReviewEntity;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class PlayStoreReviewPreference {
    private static final String PLAYSTORE_PREFERENCES;
    private final PreferenceFacade preferenceFacade;
    private final Serializer serializer;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("PlayStoreReviewPreference");
        sb.append("production");
        PLAYSTORE_PREFERENCES = sb.toString();
    }

    @Inject
    public PlayStoreReviewPreference(Context context, Serializer serializer) {
        this.serializer = serializer;
        this.preferenceFacade = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(PLAYSTORE_PREFERENCES).setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
    }

    public boolean saveLastPlayStoreReviewShow(PlayStoreReviewEntity playStoreReviewEntity) {
        this.preferenceFacade.saveData("play_store_review_last_show_key", this.serializer.serialize(playStoreReviewEntity));
        return true;
    }

    public PlayStoreReviewEntity getLastPlayStoreReviewShow() {
        String string = this.preferenceFacade.getString("play_store_review_last_show_key");
        if (TextUtils.isEmpty(string)) {
            return new PlayStoreReviewEntity(null, null, null);
        }
        return (PlayStoreReviewEntity) this.serializer.deserialize(string, PlayStoreReviewEntity.class);
    }

    public int getTransactionSuccessCount() {
        return this.preferenceFacade.getInteger("first_success_transaction_count").intValue();
    }

    public boolean saveFirstSuccessTransactionResult(int i) {
        this.preferenceFacade.saveData("first_success_transaction_count", Integer.valueOf(i));
        return true;
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
