package androidx.transition;

import android.view.View;
import android.view.WindowId;

/* loaded from: classes.dex */
class WindowIdApi18 implements WindowIdImpl {
    private final WindowId MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WindowIdApi18(View view) {
        this.MyBillsEntityDataFactory = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi18) && ((WindowIdApi18) obj).MyBillsEntityDataFactory.equals(this.MyBillsEntityDataFactory);
    }

    public int hashCode() {
        return this.MyBillsEntityDataFactory.hashCode();
    }
}
