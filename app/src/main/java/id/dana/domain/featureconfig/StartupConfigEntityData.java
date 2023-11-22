package id.dana.domain.featureconfig;

import id.dana.domain.featureconfig.model.AnbuConfig;
import id.dana.domain.featureconfig.model.DiagnosticLogConfig;
import id.dana.domain.featureconfig.model.QueryUserDataConfig;
import id.dana.domain.featureconfig.model.StartupConfig;
import id.dana.domain.version.Version;
import id.dana.utils.holdlogin.v2.model.FeatureHoldLoginConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0002H&¢\u0006\u0004\b\u001b\u0010\u0014J\u000f\u0010\u001c\u001a\u00020\u0002H&¢\u0006\u0004\b\u001c\u0010\u0014J\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0007H&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\nH&¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0010H&¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0002H&¢\u0006\u0004\b'\u0010\u0006J\u0017\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015H&¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0018H&¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0002H&¢\u0006\u0004\b.\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/featureconfig/StartupConfigEntityData;", "", "", "b", "", "cancelAllWorkDone", "(Z)V", "Lid/dana/domain/featureconfig/model/AnbuConfig;", "getAnbuConfig", "()Lid/dana/domain/featureconfig/model/AnbuConfig;", "Lid/dana/domain/version/Version;", "getAppVersion", "()Lid/dana/domain/version/Version;", "Lid/dana/domain/featureconfig/model/DiagnosticLogConfig;", "getDiagnosticLog", "()Lid/dana/domain/featureconfig/model/DiagnosticLogConfig;", "Lid/dana/utils/holdlogin/v2/model/FeatureHoldLoginConfig;", "getHoldLoginConfig", "()Lid/dana/utils/holdlogin/v2/model/FeatureHoldLoginConfig;", "getMixpanelEnable", "()Z", "Lid/dana/domain/featureconfig/model/QueryUserDataConfig;", "getQueryUserDataConfig", "()Lid/dana/domain/featureconfig/model/QueryUserDataConfig;", "Lid/dana/domain/featureconfig/model/StartupConfig;", "getStartupConfig", "()Lid/dana/domain/featureconfig/model/StartupConfig;", "getWarmStartTrackingEnable", "isCancelAllWorkDone", "it", "saveAnbuConfig", "(Lid/dana/domain/featureconfig/model/AnbuConfig;)V", "version", "setAppVersion", "(Lid/dana/domain/version/Version;)V", "featureHoldLoginConfig", "setHoldLoginConfig", "(Lid/dana/utils/holdlogin/v2/model/FeatureHoldLoginConfig;)V", "enable", "setMixpanelEnable", "queryUserDataConfig", "setQueryUserDataConfig", "(Lid/dana/domain/featureconfig/model/QueryUserDataConfig;)V", "startupConfig", "setStartupConfig", "(Lid/dana/domain/featureconfig/model/StartupConfig;)V", "setWarmStartTrackingEnable"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface StartupConfigEntityData {
    void cancelAllWorkDone(boolean b);

    AnbuConfig getAnbuConfig();

    Version getAppVersion();

    DiagnosticLogConfig getDiagnosticLog();

    FeatureHoldLoginConfig getHoldLoginConfig();

    boolean getMixpanelEnable();

    QueryUserDataConfig getQueryUserDataConfig();

    StartupConfig getStartupConfig();

    boolean getWarmStartTrackingEnable();

    boolean isCancelAllWorkDone();

    void saveAnbuConfig(AnbuConfig it);

    void setAppVersion(Version version);

    void setHoldLoginConfig(FeatureHoldLoginConfig featureHoldLoginConfig);

    void setMixpanelEnable(boolean enable);

    void setQueryUserDataConfig(QueryUserDataConfig queryUserDataConfig);

    void setStartupConfig(StartupConfig startupConfig);

    void setWarmStartTrackingEnable(boolean enable);
}
