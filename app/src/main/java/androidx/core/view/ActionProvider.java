package androidx.core.view;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes.dex */
public abstract class ActionProvider {
    private VisibilityListener BuiltInFictitiousFunctionClassFactory;
    private final Context MyBillsEntityDataFactory;
    private SubUiVisibilityListener getAuthRequestContext;

    /* loaded from: classes.dex */
    public interface SubUiVisibilityListener {
        void MyBillsEntityDataFactory(boolean z);
    }

    /* loaded from: classes.dex */
    public interface VisibilityListener {
        void MyBillsEntityDataFactory();
    }

    public boolean BuiltInFictitiousFunctionClassFactory() {
        return true;
    }

    public boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return false;
    }

    public void MyBillsEntityDataFactory(SubMenu subMenu) {
    }

    public boolean MyBillsEntityDataFactory() {
        return false;
    }

    public boolean PlaceComponentResult() {
        return false;
    }

    public abstract View getAuthRequestContext();

    public ActionProvider(Context context) {
        this.MyBillsEntityDataFactory = context;
    }

    public View KClassImpl$Data$declaredNonStaticMembers$2(MenuItem menuItem) {
        return getAuthRequestContext();
    }

    public void BuiltInFictitiousFunctionClassFactory(boolean z) {
        SubUiVisibilityListener subUiVisibilityListener = this.getAuthRequestContext;
        if (subUiVisibilityListener != null) {
            subUiVisibilityListener.MyBillsEntityDataFactory(z);
        }
    }

    public void BuiltInFictitiousFunctionClassFactory(SubUiVisibilityListener subUiVisibilityListener) {
        this.getAuthRequestContext = subUiVisibilityListener;
    }

    public void PlaceComponentResult(VisibilityListener visibilityListener) {
        if (this.BuiltInFictitiousFunctionClassFactory != null && visibilityListener != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            sb.append(getClass().getSimpleName());
            sb.append(" instance while it is still in use somewhere else?");
            InstrumentInjector.log_w("ActionProvider(support)", sb.toString());
        }
        this.BuiltInFictitiousFunctionClassFactory = visibilityListener;
    }

    public void moveToNextValue() {
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.getAuthRequestContext = null;
    }
}
