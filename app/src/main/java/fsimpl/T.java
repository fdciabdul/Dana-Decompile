package fsimpl;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class T implements View.OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    private boolean f7814a;

    private T() {
        this.f7814a = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ T(R r) {
        this();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
    
        if (r0.top != 0) goto L10;
     */
    @Override // android.view.View.OnApplyWindowInsetsListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.WindowInsets onApplyWindowInsets(android.view.View r5, android.view.WindowInsets r6) {
        /*
            r4 = this;
            int r0 = android.view.WindowInsets.Type.statusBars()
            int r1 = android.view.WindowInsets.Type.displayCutout()
            r0 = r0 | r1
            android.graphics.Insets r0 = r6.getInsets(r0)
            android.view.ViewGroup$LayoutParams r1 = r5.getLayoutParams()
            android.view.WindowManager$LayoutParams r1 = (android.view.WindowManager.LayoutParams) r1
            boolean r2 = r4.f7814a
            r3 = 0
            if (r2 != 0) goto L20
            int r2 = r0.top
            if (r2 != 0) goto L26
            r5 = 1
            r4.f7814a = r5
            return r6
        L20:
            r4.f7814a = r3
            int r2 = r0.top
            if (r2 == 0) goto L2c
        L26:
            int r2 = r1.y
            int r0 = r0.top
            int r3 = r2 + r0
        L2c:
            r1.y = r3
            android.content.Context r0 = r5.getContext()
            java.lang.Class<android.view.WindowManager> r2 = android.view.WindowManager.class
            java.lang.Object r0 = r0.getSystemService(r2)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            r0.updateViewLayout(r5, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.T.onApplyWindowInsets(android.view.View, android.view.WindowInsets):android.view.WindowInsets");
    }
}
