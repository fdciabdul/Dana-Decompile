package id.dana.data.profilemenu.repository.source;

import id.dana.data.profilemenu.model.SettingEntity;
import io.reactivex.Observable;
import java.util.LinkedHashMap;

/* loaded from: classes2.dex */
public interface SettingsEntityData {
    Observable<SettingEntity> getSettingByKey(String str);

    Observable<LinkedHashMap<String, LinkedHashMap<String, SettingEntity>>> getSettingCollection(String str);

    Observable<LinkedHashMap<String, SettingEntity>> getSettingKeyByCategoryKey(String str);

    Observable<Boolean> isSettingSplitNeedtoMigrate();
}
