package androidx.transition;

import android.os.IBinder;

/* loaded from: classes.dex */
class WindowIdApi14 implements WindowIdImpl {
    private final IBinder getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WindowIdApi14(IBinder iBinder) {
        this.getAuthRequestContext = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi14) && ((WindowIdApi14) obj).getAuthRequestContext.equals(this.getAuthRequestContext);
    }

    public int hashCode() {
        return this.getAuthRequestContext.hashCode();
    }
}
