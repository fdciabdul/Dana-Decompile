package com.akamai.botman;

import android.os.Handler;
import android.os.HandlerThread;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.Objects;
import java.util.Observable;

/* loaded from: classes3.dex */
public final class u extends Observable implements Window.Callback {
    private static final HandlerThread BuiltInFictitiousFunctionClassFactory = new HandlerThread("CYFTouchManager");
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;
    private final Window.Callback PlaceComponentResult;

    public u(Window.Callback callback) {
        this.PlaceComponentResult = callback;
        if (KClassImpl$Data$declaredNonStaticMembers$2) {
            HandlerThread handlerThread = BuiltInFictitiousFunctionClassFactory;
            if (handlerThread.isAlive()) {
                return;
            }
            Objects.toString(handlerThread);
            handlerThread.start();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.PlaceComponentResult.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        return this.PlaceComponentResult.onWindowStartingActionMode(callback, i);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return this.PlaceComponentResult.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.PlaceComponentResult.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            getAuthRequestContext(motionEvent, 2);
            return this.PlaceComponentResult.dispatchTouchEvent(motionEvent);
        } else if (action == 1) {
            getAuthRequestContext(motionEvent, 3);
            return this.PlaceComponentResult.dispatchTouchEvent(motionEvent);
        } else if (action == 2) {
            getAuthRequestContext(motionEvent, 1);
            return this.PlaceComponentResult.dispatchTouchEvent(motionEvent);
        } else if (action == 5) {
            getAuthRequestContext(motionEvent, 2);
            return this.PlaceComponentResult.dispatchTouchEvent(motionEvent);
        } else if (action == 6) {
            getAuthRequestContext(motionEvent, 3);
            return this.PlaceComponentResult.dispatchTouchEvent(motionEvent);
        } else {
            return this.PlaceComponentResult.dispatchTouchEvent(motionEvent);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.PlaceComponentResult.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.PlaceComponentResult.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.PlaceComponentResult.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i) {
        return this.PlaceComponentResult.onCreatePanelView(i);
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        return this.PlaceComponentResult.onCreatePanelMenu(i, menu);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        return this.PlaceComponentResult.onPreparePanel(i, view, menu);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) {
        return this.PlaceComponentResult.onMenuOpened(i, menu);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.PlaceComponentResult.onMenuItemSelected(i, menuItem);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.PlaceComponentResult.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        this.PlaceComponentResult.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        this.PlaceComponentResult.onWindowFocusChanged(z);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.PlaceComponentResult.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.PlaceComponentResult.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        this.PlaceComponentResult.onPanelClosed(i, menu);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.PlaceComponentResult.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.PlaceComponentResult.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.PlaceComponentResult.onActionModeStarted(actionMode);
    }

    public static boolean MyBillsEntityDataFactory() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    private void getAuthRequestContext(final MotionEvent motionEvent, final int i) {
        try {
            if (KClassImpl$Data$declaredNonStaticMembers$2) {
                HandlerThread handlerThread = BuiltInFictitiousFunctionClassFactory;
                if (handlerThread.isAlive()) {
                    new Handler(handlerThread.getLooper()).post(new Runnable() { // from class: com.akamai.botman.u.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.MyBillsEntityDataFactory = 1;
                            d.BuiltInFictitiousFunctionClassFactory = 1;
                            u.this.setChanged();
                            u uVar = u.this;
                            MotionEvent motionEvent2 = motionEvent;
                            int i2 = i;
                            uVar.notifyObservers(new w(motionEvent2, i2 != 1 ? 0 : 1, i2));
                        }
                    });
                    return;
                }
            }
            d.MyBillsEntityDataFactory = 1;
            d.BuiltInFictitiousFunctionClassFactory = 1;
            setChanged();
            notifyObservers(new w(motionEvent, i != 1 ? 0 : 1, i));
        } catch (Exception e) {
            f.KClassImpl$Data$declaredNonStaticMembers$2(e);
        }
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.PlaceComponentResult.onActionModeFinished(actionMode);
    }
}
