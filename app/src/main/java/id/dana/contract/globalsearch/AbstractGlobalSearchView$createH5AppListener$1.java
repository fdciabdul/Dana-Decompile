package id.dana.contract.globalsearch;

import android.os.Bundle;
import id.dana.danah5.DanaH5;
import id.dana.utils.danah5.DanaH5Listener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/contract/globalsearch/AbstractGlobalSearchView$createH5AppListener$1;", "Lid/dana/utils/danah5/DanaH5Listener;", "Landroid/os/Bundle;", "p0", "", "onContainerDestroyed", "(Landroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AbstractGlobalSearchView$createH5AppListener$1 implements DanaH5Listener {
    final /* synthetic */ AbstractGlobalSearchView<V> getAuthRequestContext;

    @Override // id.dana.utils.danah5.DanaH5Listener
    public final /* synthetic */ void onContainerCreated(Bundle bundle) {
        DanaH5Listener.CC.getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractGlobalSearchView$createH5AppListener$1(AbstractGlobalSearchView<V> abstractGlobalSearchView) {
        this.getAuthRequestContext = abstractGlobalSearchView;
    }

    @Override // id.dana.utils.danah5.DanaH5Listener
    public final void onContainerDestroyed(Bundle p0) {
        boolean z;
        this.getAuthRequestContext.h_().BuiltInFictitiousFunctionClassFactory();
        DanaH5.dispose();
        z = ((AbstractGlobalSearchView) this.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory;
        if (z) {
            this.getAuthRequestContext.j_().PlaceComponentResult();
        }
    }
}
