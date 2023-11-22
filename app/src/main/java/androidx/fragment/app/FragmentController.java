package androidx.fragment.app;

import android.view.MenuItem;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public class FragmentController {
    final FragmentHostCallback<?> getAuthRequestContext;

    public static FragmentController MyBillsEntityDataFactory(FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController((FragmentHostCallback) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(fragmentHostCallback, "callbacks == null"));
    }

    private FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.getAuthRequestContext = fragmentHostCallback;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(MenuItem menuItem) {
        return this.getAuthRequestContext.PlaceComponentResult.dispatchContextItemSelected(menuItem);
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.getAuthRequestContext.PlaceComponentResult.execPendingActions(true);
    }
}
