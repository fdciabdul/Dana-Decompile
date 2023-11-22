package id.dana.data.holdlogin.v2.module;

import dagger.Binds;
import dagger.Module;
import id.dana.data.holdlogin.v2.HoldLoginFeatureFlag;
import id.dana.data.holdlogin.v2.engine.HoldLoginV2Engine;
import id.dana.data.holdlogin.v2.engine.HoldLoginV2EngineImpl;
import id.dana.data.holdlogin.v2.interceptor.HoldLoginV2InterceptorImpl;
import id.dana.utils.holdlogin.v2.HoldLoginConfig;
import id.dana.utils.holdlogin.v2.interceptor.HoldLoginV2Interceptor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/holdlogin/v2/module/HoldLoginV2Module;", "", "<init>", "()V", "Declarations"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {Declarations.class})
/* loaded from: classes2.dex */
public final class HoldLoginV2Module {
    public static final HoldLoginV2Module INSTANCE = new HoldLoginV2Module();

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/holdlogin/v2/module/HoldLoginV2Module$Declarations;", "", "Lid/dana/data/holdlogin/v2/HoldLoginFeatureFlag;", "p0", "Lid/dana/utils/holdlogin/v2/HoldLoginConfig;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/data/holdlogin/v2/HoldLoginFeatureFlag;)Lid/dana/utils/holdlogin/v2/HoldLoginConfig;", "Lid/dana/data/holdlogin/v2/engine/HoldLoginV2EngineImpl;", "Lid/dana/data/holdlogin/v2/engine/HoldLoginV2Engine;", "PlaceComponentResult", "(Lid/dana/data/holdlogin/v2/engine/HoldLoginV2EngineImpl;)Lid/dana/data/holdlogin/v2/engine/HoldLoginV2Engine;", "Lid/dana/data/holdlogin/v2/interceptor/HoldLoginV2InterceptorImpl;", "Lid/dana/utils/holdlogin/v2/interceptor/HoldLoginV2Interceptor;", "MyBillsEntityDataFactory", "(Lid/dana/data/holdlogin/v2/interceptor/HoldLoginV2InterceptorImpl;)Lid/dana/utils/holdlogin/v2/interceptor/HoldLoginV2Interceptor;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Module
    /* loaded from: classes8.dex */
    public interface Declarations {
        @Binds
        HoldLoginConfig KClassImpl$Data$declaredNonStaticMembers$2(HoldLoginFeatureFlag p0);

        @Binds
        HoldLoginV2Interceptor MyBillsEntityDataFactory(HoldLoginV2InterceptorImpl p0);

        @Binds
        HoldLoginV2Engine PlaceComponentResult(HoldLoginV2EngineImpl p0);
    }

    private HoldLoginV2Module() {
    }
}
