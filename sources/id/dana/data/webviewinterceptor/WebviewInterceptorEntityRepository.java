package id.dana.data.webviewinterceptor;

import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.webviewinterceptor.model.WebviewInterceptorEntityKt;
import id.dana.domain.webviewinterceptor.WebviewInterceptorRepository;
import id.dana.domain.webviewinterceptor.model.WebviewInterceptorData;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0017\u0010\f\u001a\u0006*\u00020\u000b0\u000bX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/data/webviewinterceptor/WebviewInterceptorEntityRepository;", "Lid/dana/domain/webviewinterceptor/WebviewInterceptorRepository;", "Lio/reactivex/Observable;", "", "Lid/dana/domain/webviewinterceptor/model/WebviewInterceptorData;", "getWebviewInterceptorDataConfig", "()Lio/reactivex/Observable;", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "PlaceComponentResult", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "getAuthRequestContext", "Lid/dana/data/config/source/ConfigEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Lazy;", "p0", "<init>", "(Lid/dana/data/config/source/ConfigEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WebviewInterceptorEntityRepository implements WebviewInterceptorRepository {
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private ConfigEntityDataFactory getAuthRequestContext;

    @Inject
    public WebviewInterceptorEntityRepository(ConfigEntityDataFactory configEntityDataFactory) {
        Intrinsics.checkNotNullParameter(configEntityDataFactory, "");
        this.getAuthRequestContext = configEntityDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<ConfigEntityData>() { // from class: id.dana.data.webviewinterceptor.WebviewInterceptorEntityRepository$splitConfigEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConfigEntityData invoke() {
                ConfigEntityDataFactory configEntityDataFactory2;
                configEntityDataFactory2 = WebviewInterceptorEntityRepository.this.getAuthRequestContext;
                return configEntityDataFactory2.createData2("split");
            }
        });
    }

    public static /* synthetic */ List PlaceComponentResult(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return WebviewInterceptorEntityKt.BuiltInFictitiousFunctionClassFactory(list);
    }

    @Override // id.dana.domain.webviewinterceptor.WebviewInterceptorRepository
    public final Observable<List<WebviewInterceptorData>> getWebviewInterceptorDataConfig() {
        Observable map = ((ConfigEntityData) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).getWebviewInterceptorConfig().map(new Function() { // from class: id.dana.data.webviewinterceptor.WebviewInterceptorEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return WebviewInterceptorEntityRepository.PlaceComponentResult((List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }
}
