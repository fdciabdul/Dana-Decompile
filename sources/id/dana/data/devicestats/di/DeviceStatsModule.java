package id.dana.data.devicestats.di;

import android.content.Context;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import id.dana.data.devicestats.DeviceStatsAnalyticsEntityData;
import id.dana.data.devicestats.DeviceStatsConfigEntityData;
import id.dana.data.devicestats.DeviceStatsPreferenceEntityData;
import id.dana.data.devicestats.FileSystemStatsRepository;
import id.dana.data.devicestats.entity.MixpanelDeviceStatsAnalyticsEntityData;
import id.dana.data.devicestats.entity.SecurePrefDeviceStatsPreferenceEntityData;
import id.dana.data.devicestats.entity.SplitDeviceStatsConfigEntityData;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.SimpleSecureKeyPreference;
import id.dana.domain.devicestats.storage.FileDirectoriesSizeRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/data/devicestats/di/DeviceStatsModule;", "", "Landroid/content/Context;", "p0", "Lid/dana/data/devicestats/DeviceStatsAnalyticsEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;)Lid/dana/data/devicestats/DeviceStatsAnalyticsEntityData;", "Lid/dana/data/devicestats/DeviceStatsPreferenceEntityData;", "PlaceComponentResult", "(Landroid/content/Context;)Lid/dana/data/devicestats/DeviceStatsPreferenceEntityData;", "<init>", "()V", "Declarations"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {Declarations.class})
/* loaded from: classes2.dex */
public final class DeviceStatsModule {
    public static final DeviceStatsModule INSTANCE = new DeviceStatsModule();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/devicestats/di/DeviceStatsModule$Declarations;", "", "Lid/dana/data/devicestats/entity/SplitDeviceStatsConfigEntityData;", "p0", "Lid/dana/data/devicestats/DeviceStatsConfigEntityData;", "getAuthRequestContext", "(Lid/dana/data/devicestats/entity/SplitDeviceStatsConfigEntityData;)Lid/dana/data/devicestats/DeviceStatsConfigEntityData;", "Lid/dana/data/devicestats/FileSystemStatsRepository;", "Lid/dana/domain/devicestats/storage/FileDirectoriesSizeRepository;", "MyBillsEntityDataFactory", "(Lid/dana/data/devicestats/FileSystemStatsRepository;)Lid/dana/domain/devicestats/storage/FileDirectoriesSizeRepository;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Module
    /* loaded from: classes8.dex */
    public interface Declarations {
        @Binds
        FileDirectoriesSizeRepository MyBillsEntityDataFactory(FileSystemStatsRepository p0);

        @Binds
        DeviceStatsConfigEntityData getAuthRequestContext(SplitDeviceStatsConfigEntityData p0);
    }

    private DeviceStatsModule() {
    }

    @Provides
    public final DeviceStatsPreferenceEntityData PlaceComponentResult(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(p0).setPreferenceGroup("DeviceStatsPreference").setUseDrutherPreference(true)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        return new SecurePrefDeviceStatsPreferenceEntityData(new SimpleSecureKeyPreference(createData2));
    }

    @Provides
    public final DeviceStatsAnalyticsEntityData KClassImpl$Data$declaredNonStaticMembers$2(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new MixpanelDeviceStatsAnalyticsEntityData(p0);
    }
}
