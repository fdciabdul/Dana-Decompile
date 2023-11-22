package id.dana.data.di;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import id.dana.data.base.BasePersistenceDao;
import id.dana.data.base.DbFactory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.config.source.sharedpreference.SharedPrefNetworkLogging;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.storage.AppInfoPreference;
import id.dana.data.utdid.UtdidFacade;
import id.dana.utils.config.DeviceInformation;
import id.dana.utils.config.entity.NetworkLoggingConfiguration;
import id.dana.utils.foundation.facede.ApSecurity;
import id.dana.utils.storage.AppInfo;
import id.dana.utils.storage.UTDidInfo;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/di/DataModule;", "", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/data/base/BasePersistenceDao;", "provideDatabase", "(Landroid/content/Context;)Lid/dana/data/base/BasePersistenceDao;", "<init>", "()V", "Declarations"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {BranchModule.class, ApiModule.class, NetworkModule.class, Declarations.class})
/* loaded from: classes2.dex */
public final class DataModule {
    public static final DataModule INSTANCE = new DataModule();

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0019\u0010\u001aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/di/DataModule$Declarations;", "", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "appSecurityFacade", "Lid/dana/utils/foundation/facede/ApSecurity;", "bindsApSecurity", "(Lid/dana/data/foundation/facade/ApSecurityFacade;)Lid/dana/utils/foundation/facede/ApSecurity;", "Lid/dana/data/storage/AppInfoPreference;", "appInfoPreference", "Lid/dana/utils/storage/AppInfo;", "bindsAppInfo", "(Lid/dana/data/storage/AppInfoPreference;)Lid/dana/utils/storage/AppInfo;", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/utils/config/DeviceInformation;", "bindsDeviceInformation", "(Lid/dana/data/config/DeviceInformationProvider;)Lid/dana/utils/config/DeviceInformation;", "Lid/dana/data/config/source/sharedpreference/SharedPrefNetworkLogging;", "sharedPrefNetworkLogging", "Lid/dana/utils/config/entity/NetworkLoggingConfiguration;", "bindsNetworkLoggingConfigEntityData", "(Lid/dana/data/config/source/sharedpreference/SharedPrefNetworkLogging;)Lid/dana/utils/config/entity/NetworkLoggingConfiguration;", "Lid/dana/data/utdid/UtdidFacade;", "utdidFacade", "Lid/dana/utils/storage/UTDidInfo;", "bindsUtDidInfo", "(Lid/dana/data/utdid/UtdidFacade;)Lid/dana/utils/storage/UTDidInfo;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Module
    /* loaded from: classes8.dex */
    public interface Declarations {
        @Singleton
        @Binds
        ApSecurity bindsApSecurity(ApSecurityFacade appSecurityFacade);

        @Singleton
        @Binds
        AppInfo bindsAppInfo(AppInfoPreference appInfoPreference);

        @Singleton
        @Binds
        DeviceInformation bindsDeviceInformation(DeviceInformationProvider deviceInformationProvider);

        @Binds
        NetworkLoggingConfiguration bindsNetworkLoggingConfigEntityData(SharedPrefNetworkLogging sharedPrefNetworkLogging);

        @Singleton
        @Binds
        UTDidInfo bindsUtDidInfo(UtdidFacade utdidFacade);
    }

    private DataModule() {
    }

    @Provides
    @Singleton
    public final BasePersistenceDao provideDatabase(Context context) {
        Intrinsics.checkNotNull(context);
        return DbFactory.create(context);
    }
}
