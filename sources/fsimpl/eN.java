package fsimpl;

import android.os.Process;

/* loaded from: classes.dex */
public class eN extends Thread {
    public eN(Runnable runnable, String str) {
        super(runnable, str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(11);
        super.run();
    }
}
