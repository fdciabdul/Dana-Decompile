package id.dana.data.registration.di;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import id.dana.data.registration.RegistrationEntityRepository;
import id.dana.data.registration.source.RegistrationEntityData;
import id.dana.data.registration.source.local.LocalRegistrationEntityData;
import id.dana.data.registration.source.network.NetworkRegistrationEntityData;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.data.storage.SimpleSecureKeyPreference;
import id.dana.domain.registration.RegistrationRepository;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/data/registration/di/RegistrationModule;", "", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/PreferenceFacade;", "provideSecureSharePreference", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)Lid/dana/data/storage/PreferenceFacade;", "<init>", "()V", "Declarations"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {Declarations.class})
/* loaded from: classes2.dex */
public final class RegistrationModule {
    public static final RegistrationModule INSTANCE = new RegistrationModule();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/registration/di/RegistrationModule$Declarations;", "", "Lid/dana/data/registration/source/local/LocalRegistrationEntityData;", "local", "Lid/dana/data/registration/source/RegistrationEntityData;", "bindsLocalRegistrationEntityData", "(Lid/dana/data/registration/source/local/LocalRegistrationEntityData;)Lid/dana/data/registration/source/RegistrationEntityData;", "Lid/dana/data/registration/source/network/NetworkRegistrationEntityData;", "network", "bindsNetworkRegistrationEntityData", "(Lid/dana/data/registration/source/network/NetworkRegistrationEntityData;)Lid/dana/data/registration/source/RegistrationEntityData;", "Lid/dana/data/registration/RegistrationEntityRepository;", "repository", "Lid/dana/domain/registration/RegistrationRepository;", "bindsRegistrationRepository", "(Lid/dana/data/registration/RegistrationEntityRepository;)Lid/dana/domain/registration/RegistrationRepository;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Module
    /* loaded from: classes8.dex */
    public interface Declarations {
        @Singleton
        @Binds
        RegistrationEntityData bindsLocalRegistrationEntityData(LocalRegistrationEntityData local);

        @Singleton
        @Binds
        RegistrationEntityData bindsNetworkRegistrationEntityData(NetworkRegistrationEntityData network);

        @Singleton
        @Binds
        RegistrationRepository bindsRegistrationRepository(RegistrationEntityRepository repository);
    }

    private RegistrationModule() {
    }

    @Provides
    @Registration
    @JvmStatic
    public static final PreferenceFacade provideSecureSharePreference(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("Registrationproduction").setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        return new SimpleSecureKeyPreference(createData2);
    }
}
