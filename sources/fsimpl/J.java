package fsimpl;

import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.fullstory.rust.RustInterface;

/* loaded from: classes.dex */
public class J implements H {

    /* renamed from: a  reason: collision with root package name */
    private final C f7805a;
    private final C0366p b;
    private final RustInterface c;

    public J(RustInterface rustInterface, C c, C0366p c0366p) {
        this.c = rustInterface;
        this.f7805a = c;
        this.b = c0366p;
    }

    private boolean a(float f, float f2) {
        C0366p c0366p = this.b;
        return c0366p == null || !c0366p.a((int) f, (int) f2);
    }

    @Override // fsimpl.H
    public void a() {
        this.c.h();
    }

    @Override // fsimpl.H
    public boolean a(KeyEvent keyEvent, boolean z, Window window, Window.Callback callback) {
        boolean superDispatchKeyShortcutEvent = callback == null ? z ? window.superDispatchKeyShortcutEvent(keyEvent) : window.superDispatchKeyEvent(keyEvent) : z ? callback.dispatchKeyShortcutEvent(keyEvent) : callback.dispatchKeyEvent(keyEvent);
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 4 || keyCode == 82 || keyCode == 84 || keyCode == 24 || keyCode == 25 || keyCode == 164) {
            this.c.a(keyCode, keyEvent.getAction());
        }
        return superDispatchKeyShortcutEvent;
    }

    @Override // fsimpl.H
    public boolean a(MotionEvent motionEvent, I i, Window window, Window.Callback callback) {
        int i2;
        int i3;
        int actionMasked = motionEvent.getActionMasked();
        boolean a2 = this.f7805a.a(motionEvent, i, window, callback, actionMasked);
        View peekDecorView = window != null ? window.peekDecorView() : null;
        int i4 = 0;
        if (peekDecorView != null) {
            int[] iArr = new int[2];
            peekDecorView.getLocationOnScreen(iArr);
            i2 = iArr[0];
            i3 = iArr[1];
        } else {
            i2 = 0;
            i3 = 0;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    while (i4 < motionEvent.getPointerCount()) {
                        int pointerId = motionEvent.getPointerId(i4);
                        float x = i2 + motionEvent.getX(i4);
                        float y = i3 + motionEvent.getY(i4);
                        if (a(x, y)) {
                            this.c.a(pointerId, x, y);
                        }
                        i4++;
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked != 5) {
                        if (actionMasked == 6) {
                            int actionIndex = motionEvent.getActionIndex();
                            int pointerId2 = motionEvent.getPointerId(actionIndex);
                            float x2 = i2 + motionEvent.getX(actionIndex);
                            float y2 = i3 + motionEvent.getY(actionIndex);
                            if (a(x2, y2)) {
                                this.c.b(pointerId2, x2, y2);
                            } else {
                                this.c.b(pointerId2);
                            }
                        }
                    }
                }
                return a2;
            }
            while (i4 < motionEvent.getPointerCount()) {
                int pointerId3 = motionEvent.getPointerId(i4);
                float x3 = i2 + motionEvent.getX(i4);
                float y3 = i3 + motionEvent.getY(i4);
                if (a(x3, y3)) {
                    this.c.a(pointerId3, x3, y3);
                }
                i4++;
            }
            this.c.h();
            return a2;
        }
        int actionIndex2 = motionEvent.getActionIndex();
        int pointerId4 = motionEvent.getPointerId(actionIndex2);
        float x4 = i2 + motionEvent.getX(actionIndex2);
        float y4 = i3 + motionEvent.getY(actionIndex2);
        if (a(x4, y4)) {
            this.c.a(pointerId4, x4, y4);
        }
        return a2;
    }

    public void b() {
        C0239aq.a(this);
    }

    public void c() {
        C0239aq.a((H) null);
    }
}
