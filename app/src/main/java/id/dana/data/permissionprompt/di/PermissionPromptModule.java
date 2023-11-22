package id.dana.data.permissionprompt.di;

import android.content.Context;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import id.dana.data.permissionprompt.PermissionPromptEntityRepository;
import id.dana.data.permissionprompt.repository.PermissionPromptEntityData;
import id.dana.data.permissionprompt.repository.source.local.LocalPermissionPromptEntityData;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.data.storage.SimpleSecureKeyPreference;
import id.dana.domain.permissionprompt.PermissionPromptRepository;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/data/permissionprompt/di/PermissionPromptModule;", "", "Landroid/content/Context;", "p0", "Lid/dana/data/storage/Serializer;", "p1", "Lid/dana/data/storage/PreferenceFacade;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)Lid/dana/data/storage/PreferenceFacade;", "<init>", "()V", "Declarations"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {Declarations.class})
/* loaded from: classes2.dex */
public final class PermissionPromptModule {
    public static final PermissionPromptModule INSTANCE = new PermissionPromptModule();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/permissionprompt/di/PermissionPromptModule$Declarations;", "", "Lid/dana/data/permissionprompt/repository/source/local/LocalPermissionPromptEntityData;", "p0", "Lid/dana/data/permissionprompt/repository/PermissionPromptEntityData;", "MyBillsEntityDataFactory", "(Lid/dana/data/permissionprompt/repository/source/local/LocalPermissionPromptEntityData;)Lid/dana/data/permissionprompt/repository/PermissionPromptEntityData;", "Lid/dana/data/permissionprompt/PermissionPromptEntityRepository;", "Lid/dana/domain/permissionprompt/PermissionPromptRepository;", "PlaceComponentResult", "(Lid/dana/data/permissionprompt/PermissionPromptEntityRepository;)Lid/dana/domain/permissionprompt/PermissionPromptRepository;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Module
    /* loaded from: classes8.dex */
    public interface Declarations {
        @Singleton
        @Binds
        PermissionPromptEntityData MyBillsEntityDataFactory(LocalPermissionPromptEntityData p0);

        @Singleton
        @Binds
        PermissionPromptRepository PlaceComponentResult(PermissionPromptEntityRepository p0);
    }

    private PermissionPromptModule() {
    }

    @Provides
    @PermissionPrompt
    @JvmStatic
    public static final PreferenceFacade BuiltInFictitiousFunctionClassFactory(Context p0, Serializer p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(p0).setPreferenceGroup("PermissionPromptPreferenceproduction").setUseDrutherPreference(true).setSerializerFacade(p1)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        return new SimpleSecureKeyPreference(createData2);
    }
}
