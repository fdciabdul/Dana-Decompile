package id.dana.domain.profilemenu.settingconfig;

import id.dana.domain.profilemenu.model.SettingModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public interface RawSettingJsonMapper {
    List<SettingModel> apply(Map.Entry<String, LinkedHashMap<String, SettingModel>> entry);
}
