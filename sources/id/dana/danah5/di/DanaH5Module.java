package id.dana.danah5.di;

import dagger.Binds;
import dagger.Module;
import id.dana.danah5.DanaH5Impl;
import id.dana.utils.danah5.DanaH5Facade;
import javax.inject.Singleton;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danah5/di/DanaH5Module;", "", "<init>", "()V", "Declarations"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {Declarations.class})
/* loaded from: classes.dex */
public final class DanaH5Module {
    public static final DanaH5Module INSTANCE = new DanaH5Module();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/danah5/di/DanaH5Module$Declarations;", "", "Lid/dana/danah5/DanaH5Impl;", "danaH5Impl", "Lid/dana/utils/danah5/DanaH5Facade;", "bindsDanaH5Facade", "(Lid/dana/danah5/DanaH5Impl;)Lid/dana/utils/danah5/DanaH5Facade;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Module
    /* loaded from: classes8.dex */
    public interface Declarations {
        @Singleton
        @Binds
        DanaH5Facade bindsDanaH5Facade(DanaH5Impl danaH5Impl);
    }

    private DanaH5Module() {
    }
}
