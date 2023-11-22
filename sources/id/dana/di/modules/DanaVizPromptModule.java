package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.danaviz.DanaVizPromptContract;
import id.dana.danaviz.DanaVizPromptPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u0005\u0010\bR\u0014\u0010\u0005\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/di/modules/DanaVizPromptModule;", "", "Lid/dana/danaviz/DanaVizPromptPresenter;", "p0", "Lid/dana/danaviz/DanaVizPromptContract$Presenter;", "MyBillsEntityDataFactory", "(Lid/dana/danaviz/DanaVizPromptPresenter;)Lid/dana/danaviz/DanaVizPromptContract$Presenter;", "Lid/dana/danaviz/DanaVizPromptContract$View;", "()Lid/dana/danaviz/DanaVizPromptContract$View;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/danaviz/DanaVizPromptContract$View;", "<init>", "(Lid/dana/danaviz/DanaVizPromptContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class DanaVizPromptModule {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final DanaVizPromptContract.View MyBillsEntityDataFactory;

    public DanaVizPromptModule(DanaVizPromptContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.MyBillsEntityDataFactory = view;
    }

    @Provides
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final DanaVizPromptContract.View getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Provides
    public final DanaVizPromptContract.Presenter MyBillsEntityDataFactory(DanaVizPromptPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
