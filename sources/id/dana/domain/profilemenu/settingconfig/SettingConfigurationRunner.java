package id.dana.domain.profilemenu.settingconfig;

import id.dana.domain.profilemenu.model.SettingModel;
import io.reactivex.Observable;

/* loaded from: classes4.dex */
public interface SettingConfigurationRunner {
    String getSettingName();

    Observable<SettingModel> performConfiguration(SettingModel settingModel);
}
