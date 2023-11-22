package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.kybcpm.KybCpmContract;
import id.dana.kybcpm.KybCpmPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/di/modules/KybCpmModule;", "", "Lid/dana/kybcpm/KybCpmPresenter;", "p0", "Lid/dana/kybcpm/KybCpmContract$Presenter;", "MyBillsEntityDataFactory", "(Lid/dana/kybcpm/KybCpmPresenter;)Lid/dana/kybcpm/KybCpmContract$Presenter;", "Lid/dana/kybcpm/KybCpmContract$View;", "PlaceComponentResult", "()Lid/dana/kybcpm/KybCpmContract$View;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/kybcpm/KybCpmContract$View;", "getAuthRequestContext", "<init>", "(Lid/dana/kybcpm/KybCpmContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class KybCpmModule {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final KybCpmContract.View getAuthRequestContext;

    public KybCpmModule(KybCpmContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.getAuthRequestContext = view;
    }

    @Provides
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final KybCpmContract.View getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Provides
    public final KybCpmContract.Presenter MyBillsEntityDataFactory(KybCpmPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
