package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class MenuPopupHelper implements MenuHelper {
    public PopupWindow.OnDismissListener BuiltInFictitiousFunctionClassFactory;
    private final int GetContactSyncConfig;
    private View KClassImpl$Data$declaredNonStaticMembers$2;
    public int MyBillsEntityDataFactory;
    private final int NetworkUserEntityData$$ExternalSyntheticLambda0;
    public boolean PlaceComponentResult;
    public MenuPresenter.Callback getAuthRequestContext;
    private final boolean getErrorConfigVersion;
    private final Context lookAheadTest;
    public MenuPopup mPopup;
    private final PopupWindow.OnDismissListener moveToNextValue;
    private final MenuBuilder scheduleImpl;

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i) {
        this(context, menuBuilder, view, z, i, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i, int i2) {
        this.MyBillsEntityDataFactory = 8388611;
        this.moveToNextValue = new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.view.menu.MenuPopupHelper.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                MenuPopupHelper.this.getAuthRequestContext();
            }
        };
        this.lookAheadTest = context;
        this.scheduleImpl = menuBuilder;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.getErrorConfigVersion = z;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
        this.GetContactSyncConfig = i2;
    }

    public final void getAuthRequestContext(View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    public final boolean MyBillsEntityDataFactory() {
        if (PlaceComponentResult()) {
            return true;
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            return false;
        }
        getAuthRequestContext(0, 0, false, false);
        return true;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        if (PlaceComponentResult()) {
            return true;
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            return false;
        }
        getAuthRequestContext(i, i2, true, true);
        return true;
    }

    public final MenuPopup BuiltInFictitiousFunctionClassFactory() {
        MenuPopup standardMenuPopup;
        Display defaultDisplay = ((WindowManager) this.lookAheadTest.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT < 17) {
            defaultDisplay.getSize(point);
        } else {
            defaultDisplay.getRealSize(point);
        }
        if (Math.min(point.x, point.y) >= this.lookAheadTest.getResources().getDimensionPixelSize(R.dimen.PlaceComponentResult)) {
            standardMenuPopup = new CascadingMenuPopup(this.lookAheadTest, this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.GetContactSyncConfig, this.getErrorConfigVersion);
        } else {
            standardMenuPopup = new StandardMenuPopup(this.lookAheadTest, this.scheduleImpl, this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.GetContactSyncConfig, this.getErrorConfigVersion);
        }
        standardMenuPopup.PlaceComponentResult(this.scheduleImpl);
        standardMenuPopup.MyBillsEntityDataFactory(this.moveToNextValue);
        standardMenuPopup.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
        standardMenuPopup.setCallback(this.getAuthRequestContext);
        standardMenuPopup.getAuthRequestContext(this.PlaceComponentResult);
        standardMenuPopup.PlaceComponentResult(this.MyBillsEntityDataFactory);
        return standardMenuPopup;
    }

    public void getAuthRequestContext() {
        this.mPopup = null;
        PopupWindow.OnDismissListener onDismissListener = this.BuiltInFictitiousFunctionClassFactory;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final boolean PlaceComponentResult() {
        MenuPopup menuPopup = this.mPopup;
        return menuPopup != null && menuPopup.PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api17Impl {
        private Api17Impl() {
        }
    }

    private void getAuthRequestContext(int i, int i2, boolean z, boolean z2) {
        if (this.mPopup == null) {
            this.mPopup = BuiltInFictitiousFunctionClassFactory();
        }
        MenuPopup menuPopup = this.mPopup;
        menuPopup.KClassImpl$Data$declaredNonStaticMembers$2(z2);
        if (z) {
            if ((GravityCompat.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, ViewCompat.initRecordTimeStamp(this.KClassImpl$Data$declaredNonStaticMembers$2)) & 7) == 5) {
                i -= this.KClassImpl$Data$declaredNonStaticMembers$2.getWidth();
            }
            menuPopup.BuiltInFictitiousFunctionClassFactory(i);
            menuPopup.KClassImpl$Data$declaredNonStaticMembers$2(i2);
            int i3 = (int) ((this.lookAheadTest.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            menuPopup.getErrorConfigVersion = new Rect(i - i3, i2 - i3, i + i3, i2 + i3);
        }
        menuPopup.a_();
    }
}
