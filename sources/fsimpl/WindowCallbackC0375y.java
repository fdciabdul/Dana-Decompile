package fsimpl;

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
import java.lang.ref.WeakReference;

/* renamed from: fsimpl.y  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class WindowCallbackC0375y implements Window.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f8006a;
    private final Window.Callback b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WindowCallbackC0375y(Window window, Window.Callback callback) {
        this.f8006a = new WeakReference(window);
        this.b = callback;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        H a2;
        Window window = (Window) this.f8006a.get();
        if (window == null || (a2 = C0239aq.a()) == null) {
            Window.Callback callback = this.b;
            if (callback != null) {
                return callback.dispatchGenericMotionEvent(motionEvent);
            }
            return false;
        }
        return a2.a(motionEvent, I.MOTION, window, this.b);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        H a2;
        Window window = (Window) this.f8006a.get();
        if (window == null || (a2 = C0239aq.a()) == null) {
            Window.Callback callback = this.b;
            if (callback != null) {
                return callback.dispatchKeyEvent(keyEvent);
            }
            return false;
        }
        return a2.a(keyEvent, false, window, this.b);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        H a2;
        Window window = (Window) this.f8006a.get();
        if (window == null || (a2 = C0239aq.a()) == null) {
            Window.Callback callback = this.b;
            if (callback != null) {
                return callback.dispatchKeyShortcutEvent(keyEvent);
            }
            return false;
        }
        return a2.a(keyEvent, true, window, this.b);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Window.Callback callback = this.b;
        if (callback != null) {
            return callback.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        H a2;
        Window window = (Window) this.f8006a.get();
        if (window == null || (a2 = C0239aq.a()) == null) {
            Window.Callback callback = this.b;
            if (callback != null) {
                return callback.dispatchTouchEvent(motionEvent);
            }
            return false;
        }
        return a2.a(motionEvent, I.TOUCH, window, this.b);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        H a2;
        Window window = (Window) this.f8006a.get();
        if (window == null || (a2 = C0239aq.a()) == null) {
            Window.Callback callback = this.b;
            if (callback != null) {
                return callback.dispatchTrackballEvent(motionEvent);
            }
            return false;
        }
        return a2.a(motionEvent, I.TRACKBALL, window, this.b);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        Window.Callback callback = this.b;
        if (callback != null) {
            callback.onActionModeFinished(actionMode);
        }
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        Window.Callback callback = this.b;
        if (callback != null) {
            callback.onActionModeStarted(actionMode);
        }
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        Window.Callback callback = this.b;
        if (callback != null) {
            callback.onAttachedToWindow();
        }
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        Window.Callback callback = this.b;
        if (callback != null) {
            callback.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        Window.Callback callback = this.b;
        if (callback != null) {
            return callback.onCreatePanelMenu(i, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int i) {
        Window.Callback callback = this.b;
        if (callback != null) {
            return callback.onCreatePanelView(i);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        H a2 = C0239aq.a();
        if (a2 != null) {
            a2.a();
        }
        Window.Callback callback = this.b;
        if (callback != null) {
            callback.onDetachedFromWindow();
        }
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        Window.Callback callback = this.b;
        if (callback != null) {
            return callback.onMenuItemSelected(i, menuItem);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        Window.Callback callback = this.b;
        if (callback != null) {
            return callback.onMenuOpened(i, menu);
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        Window.Callback callback = this.b;
        if (callback != null) {
            callback.onPanelClosed(i, menu);
        }
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        Window.Callback callback = this.b;
        if (callback != null) {
            return callback.onPreparePanel(i, view, menu);
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        Window.Callback callback = this.b;
        if (callback != null) {
            return callback.onSearchRequested();
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        Window.Callback callback = this.b;
        if (callback != null) {
            return callback.onSearchRequested(searchEvent);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        Window.Callback callback = this.b;
        if (callback != null) {
            callback.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Window.Callback callback = this.b;
        if (callback != null) {
            callback.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        Window.Callback callback2 = this.b;
        if (callback2 != null) {
            return callback2.onWindowStartingActionMode(callback);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        Window.Callback callback2 = this.b;
        if (callback2 != null) {
            return callback2.onWindowStartingActionMode(callback, i);
        }
        return null;
    }
}
