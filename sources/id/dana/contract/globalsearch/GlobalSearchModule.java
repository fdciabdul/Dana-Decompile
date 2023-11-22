package id.dana.contract.globalsearch;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import id.dana.contract.globalsearch.GlobalSearchContract;
import id.dana.di.PerActivity;
import id.dana.globalsearch.tracker.GlobalSearchAnalyticTracker;
import id.dana.globalsearch.tracker.GlobalSearchMixpanelTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\t\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\t\u0010\fR\u0014\u0010\u0005\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\r"}, d2 = {"Lid/dana/contract/globalsearch/GlobalSearchModule;", "", "Landroid/content/Context;", "p0", "Lid/dana/globalsearch/tracker/GlobalSearchAnalyticTracker;", "getAuthRequestContext", "(Landroid/content/Context;)Lid/dana/globalsearch/tracker/GlobalSearchAnalyticTracker;", "Lid/dana/contract/globalsearch/GlobalSearchPresenter;", "Lid/dana/contract/globalsearch/GlobalSearchContract$Presenter;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/contract/globalsearch/GlobalSearchPresenter;)Lid/dana/contract/globalsearch/GlobalSearchContract$Presenter;", "Lid/dana/contract/globalsearch/GlobalSearchContract$View;", "()Lid/dana/contract/globalsearch/GlobalSearchContract$View;", "Lid/dana/contract/globalsearch/GlobalSearchContract$View;", "<init>", "(Lid/dana/contract/globalsearch/GlobalSearchContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class GlobalSearchModule {
    private final GlobalSearchContract.View getAuthRequestContext;

    public GlobalSearchModule(GlobalSearchContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.getAuthRequestContext = view;
    }

    @Provides
    @PerActivity
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final GlobalSearchContract.View getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Provides
    @PerActivity
    public final GlobalSearchContract.Presenter BuiltInFictitiousFunctionClassFactory(GlobalSearchPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    public final GlobalSearchAnalyticTracker getAuthRequestContext(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new GlobalSearchMixpanelTracker(p0);
    }
}
