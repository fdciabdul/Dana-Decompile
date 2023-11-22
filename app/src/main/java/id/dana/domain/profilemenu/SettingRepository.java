package id.dana.domain.profilemenu;

import id.dana.domain.profilemenu.model.PaymentSecurityInit;
import id.dana.domain.profilemenu.model.PaymentSecuritySwitch;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.profilemenu.model.UserConfigProfileNewFlag;
import id.dana.domain.profilemenu.settingconfig.RawSettingJsonMapper;
import id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface SettingRepository {
    Observable<Long> getLastHideSettingRedDotTimestamp(String str);

    Observable<PaymentSecurityInit> getPaymentSecurityInit();

    Observable<PaymentSecuritySwitch> getPaymentSecuritySwitch(boolean z, String str, String str2, String str3, String str4);

    Observable<SettingModel> getSettingByKey(String str);

    Observable<List<SettingModel>> getSettings(List<SettingConfigurationRunner> list, String str, RawSettingJsonMapper rawSettingJsonMapper);

    Observable<UserConfigProfileNewFlag> getUserConfigProfileNewFlag();

    void saveLastHideSettingRedDotTimestamp(String str);

    Observable<Boolean> saveUserConfigProfileNewFlag(UserConfigProfileNewFlag userConfigProfileNewFlag);
}
