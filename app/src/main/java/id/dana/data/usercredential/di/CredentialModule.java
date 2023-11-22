package id.dana.data.usercredential.di;

import android.content.Context;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.data.storage.SimpleSecureKeyPreference;
import id.dana.data.usercredential.CredentialEntityRepository;
import id.dana.data.usercredential.repository.CredentialEntityData;
import id.dana.data.usercredential.repository.source.local.LocalCredentialEntityData;
import id.dana.data.usercredential.repository.source.network.NetworkCredentialEntityData;
import id.dana.domain.usercredential.CredentialRepository;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/data/usercredential/di/CredentialModule;", "", "Landroid/content/Context;", "p0", "Lid/dana/data/storage/Serializer;", "p1", "Lid/dana/data/storage/PreferenceFacade;", "getAuthRequestContext", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)Lid/dana/data/storage/PreferenceFacade;", "<init>", "()V", "Declarations"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {Declarations.class})
/* loaded from: classes2.dex */
public final class CredentialModule {
    public static final CredentialModule INSTANCE = new CredentialModule();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\u0005\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/usercredential/di/CredentialModule$Declarations;", "", "Lid/dana/data/usercredential/CredentialEntityRepository;", "p0", "Lid/dana/domain/usercredential/CredentialRepository;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/data/usercredential/CredentialEntityRepository;)Lid/dana/domain/usercredential/CredentialRepository;", "Lid/dana/data/usercredential/repository/source/local/LocalCredentialEntityData;", "Lid/dana/data/usercredential/repository/CredentialEntityData;", "getAuthRequestContext", "(Lid/dana/data/usercredential/repository/source/local/LocalCredentialEntityData;)Lid/dana/data/usercredential/repository/CredentialEntityData;", "Lid/dana/data/usercredential/repository/source/network/NetworkCredentialEntityData;", "(Lid/dana/data/usercredential/repository/source/network/NetworkCredentialEntityData;)Lid/dana/data/usercredential/repository/CredentialEntityData;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Module
    /* loaded from: classes8.dex */
    public interface Declarations {
        @Singleton
        @Binds
        CredentialEntityData BuiltInFictitiousFunctionClassFactory(NetworkCredentialEntityData p0);

        @Singleton
        @Binds
        CredentialRepository BuiltInFictitiousFunctionClassFactory(CredentialEntityRepository p0);

        @Singleton
        @Binds
        CredentialEntityData getAuthRequestContext(LocalCredentialEntityData p0);
    }

    private CredentialModule() {
    }

    @Provides
    @JvmStatic
    @Credential
    public static final PreferenceFacade getAuthRequestContext(Context p0, Serializer p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(p0).setPreferenceGroup("CredentialPreferenceproduction").setUseDrutherPreference(true).setSerializerFacade(p1)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        return new SimpleSecureKeyPreference(createData2);
    }
}
