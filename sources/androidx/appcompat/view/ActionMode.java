package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public abstract class ActionMode {
    Object KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean PlaceComponentResult;

    /* loaded from: classes.dex */
    public interface Callback {
        boolean BuiltInFictitiousFunctionClassFactory(ActionMode actionMode, Menu menu);

        void KClassImpl$Data$declaredNonStaticMembers$2(ActionMode actionMode);

        boolean getAuthRequestContext(ActionMode actionMode, Menu menu);

        boolean getAuthRequestContext(ActionMode actionMode, MenuItem menuItem);
    }

    public abstract void BuiltInFictitiousFunctionClassFactory();

    public abstract View KClassImpl$Data$declaredNonStaticMembers$2();

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence);

    public abstract MenuInflater MyBillsEntityDataFactory();

    public abstract void MyBillsEntityDataFactory(View view);

    public abstract void MyBillsEntityDataFactory(CharSequence charSequence);

    public abstract CharSequence NetworkUserEntityData$$ExternalSyntheticLambda0();

    public abstract Menu PlaceComponentResult();

    public abstract void PlaceComponentResult(int i);

    public abstract void getAuthRequestContext(int i);

    public abstract CharSequence getErrorConfigVersion();

    public abstract void lookAheadTest();

    public boolean scheduleImpl() {
        return false;
    }

    public void MyBillsEntityDataFactory(boolean z) {
        this.PlaceComponentResult = z;
    }

    public final boolean moveToNextValue() {
        return this.PlaceComponentResult;
    }
}
