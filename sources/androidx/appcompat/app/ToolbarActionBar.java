package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ToolbarActionBar extends ActionBar {
    boolean BuiltInFictitiousFunctionClassFactory;
    final DecorToolbar KClassImpl$Data$declaredNonStaticMembers$2;
    final AppCompatDelegateImpl.ActionBarMenuCallback MyBillsEntityDataFactory;
    final Window.Callback PlaceComponentResult;
    private boolean getAuthRequestContext;
    private boolean getErrorConfigVersion;
    private final Toolbar.OnMenuItemClickListener moveToNextValue;
    private ArrayList<ActionBar.OnMenuVisibilityListener> scheduleImpl = new ArrayList<>();
    private final Runnable lookAheadTest = new Runnable() { // from class: androidx.appcompat.app.ToolbarActionBar.1
        @Override // java.lang.Runnable
        public void run() {
            ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
            Menu NetworkUserEntityData$$ExternalSyntheticLambda2 = toolbarActionBar.NetworkUserEntityData$$ExternalSyntheticLambda2();
            MenuBuilder menuBuilder = NetworkUserEntityData$$ExternalSyntheticLambda2 instanceof MenuBuilder ? (MenuBuilder) NetworkUserEntityData$$ExternalSyntheticLambda2 : null;
            if (menuBuilder != null) {
                menuBuilder.stopDispatchingItemsChanged();
            }
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda2.clear();
                if (!toolbarActionBar.PlaceComponentResult.onCreatePanelMenu(0, NetworkUserEntityData$$ExternalSyntheticLambda2) || !toolbarActionBar.PlaceComponentResult.onPreparePanel(0, null, NetworkUserEntityData$$ExternalSyntheticLambda2)) {
                    NetworkUserEntityData$$ExternalSyntheticLambda2.clear();
                }
            } finally {
                if (menuBuilder != null) {
                    menuBuilder.startDispatchingItemsChanged();
                }
            }
        }
    };

    @Override // androidx.appcompat.app.ActionBar
    public final void BuiltInFictitiousFunctionClassFactory(boolean z) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void getAuthRequestContext(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ToolbarActionBar(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        Toolbar.OnMenuItemClickListener onMenuItemClickListener = new Toolbar.OnMenuItemClickListener() { // from class: androidx.appcompat.app.ToolbarActionBar.2
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2(MenuItem menuItem) {
                return ToolbarActionBar.this.PlaceComponentResult.onMenuItemSelected(0, menuItem);
            }
        };
        this.moveToNextValue = onMenuItemClickListener;
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(toolbar);
        ToolbarWidgetWrapper toolbarWidgetWrapper = new ToolbarWidgetWrapper(toolbar, false);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = toolbarWidgetWrapper;
        this.PlaceComponentResult = (Window.Callback) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(callback);
        toolbarWidgetWrapper.getAuthRequestContext(callback);
        toolbar.setOnMenuItemClickListener(onMenuItemClickListener);
        toolbarWidgetWrapper.getAuthRequestContext(charSequence);
        this.MyBillsEntityDataFactory = new ToolbarMenuCallback();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final Context BuiltInFictitiousFunctionClassFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Drawable drawable) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(i);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void PlaceComponentResult(Configuration configuration) {
        super.PlaceComponentResult(configuration);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void BuiltInFictitiousFunctionClassFactory(CharSequence charSequence) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final int getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void scheduleImpl() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(8);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean moveToNextValue() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda7();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean PlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean lookAheadTest() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion().removeCallbacks(this.lookAheadTest);
        ViewCompat.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion(), this.lookAheadTest);
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean MyBillsEntityDataFactory() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil()) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean MyBillsEntityDataFactory(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            moveToNextValue();
        }
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, KeyEvent keyEvent) {
        Menu NetworkUserEntityData$$ExternalSyntheticLambda2 = NetworkUserEntityData$$ExternalSyntheticLambda2();
        if (NetworkUserEntityData$$ExternalSyntheticLambda2 != null) {
            NetworkUserEntityData$$ExternalSyntheticLambda2.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            return NetworkUserEntityData$$ExternalSyntheticLambda2.performShortcut(i, keyEvent, 0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.app.ActionBar
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion().removeCallbacks(this.lookAheadTest);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void PlaceComponentResult(boolean z) {
        if (z == this.getAuthRequestContext) {
            return;
        }
        this.getAuthRequestContext = z;
        int size = this.scheduleImpl.size();
        for (int i = 0; i < size; i++) {
            this.scheduleImpl.get(i);
        }
    }

    /* loaded from: classes.dex */
    class ToolbarMenuCallback implements AppCompatDelegateImpl.ActionBarMenuCallback {
        ToolbarMenuCallback() {
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.ActionBarMenuCallback
        public boolean PlaceComponentResult(int i) {
            if (i != 0 || ToolbarActionBar.this.BuiltInFictitiousFunctionClassFactory) {
                return false;
            }
            ToolbarActionBar.this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8();
            ToolbarActionBar.this.BuiltInFictitiousFunctionClassFactory = true;
            return false;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.ActionBarMenuCallback
        public View MyBillsEntityDataFactory(int i) {
            if (i == 0) {
                return new View(ToolbarActionBar.this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory());
            }
            return null;
        }
    }

    final Menu NetworkUserEntityData$$ExternalSyntheticLambda2() {
        if (!this.getErrorConfigVersion) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(new ActionMenuPresenterCallback(), new MenuBuilderCallback());
            this.getErrorConfigVersion = true;
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        private boolean KClassImpl$Data$declaredNonStaticMembers$2;

        ActionMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final boolean getAuthRequestContext(MenuBuilder menuBuilder) {
            ToolbarActionBar.this.PlaceComponentResult.onMenuOpened(108, menuBuilder);
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final void MyBillsEntityDataFactory(MenuBuilder menuBuilder, boolean z) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            ToolbarActionBar.this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
            ToolbarActionBar.this.PlaceComponentResult.onPanelClosed(108, menuBuilder);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class MenuBuilderCallback implements MenuBuilder.Callback {
        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }

        MenuBuilderCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public final void onMenuModeChange(MenuBuilder menuBuilder) {
            if (ToolbarActionBar.this.KClassImpl$Data$declaredNonStaticMembers$2.newProxyInstance()) {
                ToolbarActionBar.this.PlaceComponentResult.onPanelClosed(108, menuBuilder);
            } else if (ToolbarActionBar.this.PlaceComponentResult.onPreparePanel(0, null, menuBuilder)) {
                ToolbarActionBar.this.PlaceComponentResult.onMenuOpened(108, menuBuilder);
            }
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(((z ? 4 : 0) & 4) | (this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2() & (-5)));
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void getErrorConfigVersion() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext((this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2() & (-9)) | 0);
    }
}
