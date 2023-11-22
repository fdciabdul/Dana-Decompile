package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SupportActionModeWrapper extends android.view.ActionMode {
    final Context KClassImpl$Data$declaredNonStaticMembers$2;
    final ActionMode getAuthRequestContext;

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.getAuthRequestContext = actionMode;
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = obj;
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.getAuthRequestContext.MyBillsEntityDataFactory(charSequence);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(charSequence);
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.getAuthRequestContext.lookAheadTest();
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new MenuWrapperICS(this.KClassImpl$Data$declaredNonStaticMembers$2, (SupportMenu) this.getAuthRequestContext.PlaceComponentResult());
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.getAuthRequestContext.getErrorConfigVersion();
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.getAuthRequestContext.PlaceComponentResult(i);
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.getAuthRequestContext.getAuthRequestContext(i);
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.getAuthRequestContext.MyBillsEntityDataFactory(view);
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.getAuthRequestContext.MyBillsEntityDataFactory();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.getAuthRequestContext.moveToNextValue();
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.getAuthRequestContext.MyBillsEntityDataFactory(z);
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.getAuthRequestContext.scheduleImpl();
    }

    /* loaded from: classes.dex */
    public static class CallbackWrapper implements ActionMode.Callback {
        final Context KClassImpl$Data$declaredNonStaticMembers$2;
        final ActionMode.Callback MyBillsEntityDataFactory;
        final ArrayList<SupportActionModeWrapper> BuiltInFictitiousFunctionClassFactory = new ArrayList<>();
        final SimpleArrayMap<Menu, Menu> getAuthRequestContext = new SimpleArrayMap<>();

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
            this.MyBillsEntityDataFactory = callback;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean getAuthRequestContext(ActionMode actionMode, Menu menu) {
            return this.MyBillsEntityDataFactory.onCreateActionMode(MyBillsEntityDataFactory(actionMode), BuiltInFictitiousFunctionClassFactory(menu));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean BuiltInFictitiousFunctionClassFactory(ActionMode actionMode, Menu menu) {
            return this.MyBillsEntityDataFactory.onPrepareActionMode(MyBillsEntityDataFactory(actionMode), BuiltInFictitiousFunctionClassFactory(menu));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean getAuthRequestContext(ActionMode actionMode, MenuItem menuItem) {
            return this.MyBillsEntityDataFactory.onActionItemClicked(MyBillsEntityDataFactory(actionMode), new MenuItemWrapperICS(this.KClassImpl$Data$declaredNonStaticMembers$2, (SupportMenuItem) menuItem));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void KClassImpl$Data$declaredNonStaticMembers$2(ActionMode actionMode) {
            this.MyBillsEntityDataFactory.onDestroyActionMode(MyBillsEntityDataFactory(actionMode));
        }

        private Menu BuiltInFictitiousFunctionClassFactory(Menu menu) {
            Menu menu2 = this.getAuthRequestContext.get(menu);
            if (menu2 == null) {
                MenuWrapperICS menuWrapperICS = new MenuWrapperICS(this.KClassImpl$Data$declaredNonStaticMembers$2, (SupportMenu) menu);
                this.getAuthRequestContext.put(menu, menuWrapperICS);
                return menuWrapperICS;
            }
            return menu2;
        }

        public final android.view.ActionMode MyBillsEntityDataFactory(ActionMode actionMode) {
            int size = this.BuiltInFictitiousFunctionClassFactory.size();
            for (int i = 0; i < size; i++) {
                SupportActionModeWrapper supportActionModeWrapper = this.BuiltInFictitiousFunctionClassFactory.get(i);
                if (supportActionModeWrapper != null && supportActionModeWrapper.getAuthRequestContext == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.KClassImpl$Data$declaredNonStaticMembers$2, actionMode);
            this.BuiltInFictitiousFunctionClassFactory.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }
    }
}
