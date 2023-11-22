package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter;

/* loaded from: classes.dex */
class MenuDialogHelper implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, MenuPresenter.Callback {
    ListMenuPresenter BuiltInFictitiousFunctionClassFactory;
    private MenuPresenter.Callback KClassImpl$Data$declaredNonStaticMembers$2;
    AlertDialog MyBillsEntityDataFactory;
    MenuBuilder PlaceComponentResult;

    public MenuDialogHelper(MenuBuilder menuBuilder) {
        this.PlaceComponentResult = menuBuilder;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.MyBillsEntityDataFactory.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.MyBillsEntityDataFactory.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.PlaceComponentResult.close(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.PlaceComponentResult.performShortcut(i, keyEvent, 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.BuiltInFictitiousFunctionClassFactory.onCloseMenu(this.PlaceComponentResult, true);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public void MyBillsEntityDataFactory(MenuBuilder menuBuilder, boolean z) {
        AlertDialog alertDialog;
        if ((z || menuBuilder == this.PlaceComponentResult) && (alertDialog = this.MyBillsEntityDataFactory) != null) {
            alertDialog.dismiss();
        }
        MenuPresenter.Callback callback = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (callback != null) {
            callback.MyBillsEntityDataFactory(menuBuilder, z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public boolean getAuthRequestContext(MenuBuilder menuBuilder) {
        MenuPresenter.Callback callback = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (callback != null) {
            return callback.getAuthRequestContext(menuBuilder);
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        MenuBuilder menuBuilder = this.PlaceComponentResult;
        ListMenuPresenter listMenuPresenter = this.BuiltInFictitiousFunctionClassFactory;
        if (listMenuPresenter.PlaceComponentResult == null) {
            listMenuPresenter.PlaceComponentResult = new ListMenuPresenter.MenuAdapter();
        }
        menuBuilder.performItemAction((MenuItemImpl) listMenuPresenter.PlaceComponentResult.getItem(i), 0);
    }
}
