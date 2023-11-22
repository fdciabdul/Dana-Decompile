package androidx.core.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* loaded from: classes6.dex */
public final /* synthetic */ class WindowInsetsControllerCompat$Impl20$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ View MyBillsEntityDataFactory;

    @Override // java.lang.Runnable
    public final void run() {
        ((InputMethodManager) r0.getContext().getSystemService("input_method")).showSoftInput(this.MyBillsEntityDataFactory, 0);
    }
}
