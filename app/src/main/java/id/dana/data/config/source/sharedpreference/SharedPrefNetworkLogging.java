package id.dana.data.config.source.sharedpreference;

import id.dana.utils.config.entity.NetworkLoggingConfiguration;
import id.dana.utils.config.model.NetworkLoggingConfig;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/data/config/source/sharedpreference/SharedPrefNetworkLogging;", "Lid/dana/utils/config/entity/NetworkLoggingConfiguration;", "Lid/dana/utils/config/model/NetworkLoggingConfig;", "getNetworkLogging", "()Lid/dana/utils/config/model/NetworkLoggingConfig;", "Lid/dana/data/config/source/sharedpreference/SharedPrefStartupConfig;", "sharedPrefStartupConfig", "Lid/dana/data/config/source/sharedpreference/SharedPrefStartupConfig;", "<init>", "(Lid/dana/data/config/source/sharedpreference/SharedPrefStartupConfig;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SharedPrefNetworkLogging implements NetworkLoggingConfiguration {
    private final SharedPrefStartupConfig sharedPrefStartupConfig;

    @Inject
    public SharedPrefNetworkLogging(SharedPrefStartupConfig sharedPrefStartupConfig) {
        Intrinsics.checkNotNullParameter(sharedPrefStartupConfig, "");
        this.sharedPrefStartupConfig = sharedPrefStartupConfig;
    }

    @Override // id.dana.utils.config.entity.NetworkLoggingConfiguration
    public final NetworkLoggingConfig getNetworkLogging() {
        return this.sharedPrefStartupConfig.getNetworkLogging();
    }
}
