package id.dana.sync_engine.di;

import android.content.Context;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.data.storage.SimpleSecureKeyPreference;
import id.dana.sync_engine.data.ContactEntityRepository;
import id.dana.sync_engine.domain.ContactRepository;
import id.dana.sync_engine.domain.engine.DefaultSyncContactEngine;
import id.dana.sync_engine.domain.engine.SyncContactEngine;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/sync_engine/di/SyncEngineModule;", "", "Landroid/content/Context;", "p0", "Lid/dana/data/storage/Serializer;", "p1", "Lid/dana/data/storage/PreferenceFacade;", "MyBillsEntityDataFactory", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)Lid/dana/data/storage/PreferenceFacade;", "<init>", "()V", "Declarations"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {Declarations.class})
/* loaded from: classes2.dex */
public final class SyncEngineModule {
    public static final SyncEngineModule INSTANCE = new SyncEngineModule();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\u0005\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sync_engine/di/SyncEngineModule$Declarations;", "", "Lid/dana/sync_engine/data/ContactEntityRepository;", "p0", "Lid/dana/sync_engine/domain/ContactRepository;", "PlaceComponentResult", "(Lid/dana/sync_engine/data/ContactEntityRepository;)Lid/dana/sync_engine/domain/ContactRepository;", "Lid/dana/sync_engine/domain/engine/SyncContactEngine;", "Lid/dana/sync_engine/domain/engine/DefaultSyncContactEngine;", "(Lid/dana/sync_engine/domain/engine/SyncContactEngine;)Lid/dana/sync_engine/domain/engine/DefaultSyncContactEngine;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Module
    /* loaded from: classes9.dex */
    public interface Declarations {
        @Binds
        ContactRepository PlaceComponentResult(ContactEntityRepository p0);

        @Binds
        DefaultSyncContactEngine PlaceComponentResult(SyncContactEngine p0);
    }

    private SyncEngineModule() {
    }

    @Provides
    @SyncEngine
    @JvmStatic
    public static final PreferenceFacade MyBillsEntityDataFactory(Context p0, Serializer p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(p0).setPreferenceGroup("SyncEngineproduction").setUseDrutherPreference(true).setSerializerFacade(p1)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        return new SimpleSecureKeyPreference(createData2);
    }
}
