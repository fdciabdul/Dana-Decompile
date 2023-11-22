package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0004"}, d2 = {"Lid/dana/di/modules/CoroutinesModule;", "", "Lkotlinx/coroutines/CoroutineDispatcher;", "PlaceComponentResult", "()Lkotlinx/coroutines/CoroutineDispatcher;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes2.dex */
public final class CoroutinesModule {
    public static final CoroutinesModule INSTANCE = new CoroutinesModule();

    private CoroutinesModule() {
    }

    @Provides
    @JvmStatic
    public static final CoroutineDispatcher PlaceComponentResult() {
        return Dispatchers.getDefault();
    }

    @Provides
    @JvmStatic
    public static final CoroutineDispatcher BuiltInFictitiousFunctionClassFactory() {
        return Dispatchers.getIO();
    }

    @Provides
    @JvmStatic
    public static final CoroutineDispatcher MyBillsEntityDataFactory() {
        return Dispatchers.getMain();
    }
}
