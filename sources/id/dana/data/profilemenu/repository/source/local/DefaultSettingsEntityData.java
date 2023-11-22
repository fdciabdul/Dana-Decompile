package id.dana.data.profilemenu.repository.source.local;

import android.content.Context;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.profilemenu.model.SettingEntity;
import id.dana.data.profilemenu.repository.source.SettingsEntityData;
import id.dana.data.storage.Serializer;
import io.reactivex.Observable;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONArray;
import org.json.JSONObject;

@Singleton
/* loaded from: classes2.dex */
public class DefaultSettingsEntityData implements SettingsEntityData {
    public static final String SETTING_CATEGORIES_JSON = "split/default-setting-categories-default.json";
    public static final String SETTING_JSON = "split/default-setting.json";
    public static final String SETTING_ORDER_JSON = "split/default-setting-collection-me-default.json";
    private final Context context;
    private final Serializer serializer;

    @Inject
    public DefaultSettingsEntityData(Context context, Serializer serializer) {
        this.context = context;
        this.serializer = serializer;
    }

    @Override // id.dana.data.profilemenu.repository.source.SettingsEntityData
    public Observable<LinkedHashMap<String, LinkedHashMap<String, SettingEntity>>> getSettingCollection(final String str) {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.profilemenu.repository.source.local.DefaultSettingsEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultSettingsEntityData.this.m1607x35171f86(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSettingCollection$0$id-dana-data-profilemenu-repository-source-local-DefaultSettingsEntityData  reason: not valid java name */
    public /* synthetic */ LinkedHashMap m1607x35171f86(String str) throws Exception {
        JSONArray jSONArray = new JSONObject(JsonUtil.PlaceComponentResult(this.context, SETTING_ORDER_JSON)).getJSONArray(str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            linkedHashMap.put(jSONArray.getString(i), new LinkedHashMap());
        }
        return linkedHashMap;
    }

    @Override // id.dana.data.profilemenu.repository.source.SettingsEntityData
    public Observable<LinkedHashMap<String, SettingEntity>> getSettingKeyByCategoryKey(final String str) {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.profilemenu.repository.source.local.DefaultSettingsEntityData$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultSettingsEntityData.this.m1608xbf8ea658(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSettingKeyByCategoryKey$1$id-dana-data-profilemenu-repository-source-local-DefaultSettingsEntityData  reason: not valid java name */
    public /* synthetic */ LinkedHashMap m1608xbf8ea658(String str) throws Exception {
        JSONObject jSONObject = new JSONObject(JsonUtil.PlaceComponentResult(this.context, SETTING_CATEGORIES_JSON));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < jSONObject.getJSONArray(str).length(); i++) {
            linkedHashMap.put(jSONObject.getJSONArray(str).getString(i), new SettingEntity());
        }
        return linkedHashMap;
    }

    @Override // id.dana.data.profilemenu.repository.source.SettingsEntityData
    public Observable<SettingEntity> getSettingByKey(final String str) {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.profilemenu.repository.source.local.DefaultSettingsEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultSettingsEntityData.this.m1606xe6121328(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSettingByKey$2$id-dana-data-profilemenu-repository-source-local-DefaultSettingsEntityData  reason: not valid java name */
    public /* synthetic */ SettingEntity m1606xe6121328(String str) throws Exception {
        JSONObject jSONObject = new JSONObject(JsonUtil.PlaceComponentResult(this.context, SETTING_JSON));
        if (!jSONObject.has(str)) {
            return SettingEntity.empty();
        }
        return (SettingEntity) this.serializer.deserialize(jSONObject.getString(str), SettingEntity.class);
    }

    @Override // id.dana.data.profilemenu.repository.source.SettingsEntityData
    public Observable<Boolean> isSettingSplitNeedtoMigrate() {
        return Observable.just(Boolean.FALSE);
    }
}
