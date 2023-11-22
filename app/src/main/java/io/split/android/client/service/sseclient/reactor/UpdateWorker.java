package io.split.android.client.service.sseclient.reactor;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import io.split.android.client.utils.logger.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public abstract class UpdateWorker {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {TarHeader.LF_CHR, 112, -114, 9, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int PlaceComponentResult = 64;
    private static final int SHUTDOWN_WAIT_TIME = 30;
    private final ExecutorService mExecutorService = Executors.newSingleThreadExecutor();

    private static void a(short s, short s2, int i, Object[] objArr) {
        byte[] bArr = BuiltInFictitiousFunctionClassFactory;
        int i2 = (i * 12) + 4;
        int i3 = 106 - (s2 * 7);
        int i4 = (s * 3) + 13;
        byte[] bArr2 = new byte[i4];
        int i5 = -1;
        int i6 = i4 - 1;
        if (bArr == null) {
            i3 = i3 + (-i2) + 2;
            i2++;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
        }
        while (true) {
            int i7 = i5 + 1;
            bArr2[i7] = (byte) i3;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            Object[] objArr2 = objArr;
            int i8 = i2;
            byte[] bArr3 = bArr2;
            byte[] bArr4 = bArr;
            i3 = i3 + (-bArr[i2]) + 2;
            i2 = i8 + 1;
            objArr = objArr2;
            bArr = bArr4;
            bArr2 = bArr3;
            i5 = i7;
        }
    }

    protected abstract void onWaitForNotificationLoop() throws InterruptedException;

    public void start() {
        waitForNotifications();
    }

    public void stop() {
        if (this.mExecutorService.isShutdown()) {
            return;
        }
        try {
            this.mExecutorService.shutdownNow();
            if (this.mExecutorService.awaitTermination(30L, TimeUnit.SECONDS)) {
                return;
            }
            Logger.e("Update worker did not terminate");
        } catch (InterruptedException unused) {
            this.mExecutorService.shutdownNow();
            try {
                byte b = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
                Object[] objArr = new Object[1];
                a(b, (byte) (b - 1), (byte) (-BuiltInFictitiousFunctionClassFactory[15]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b2 = (byte) (BuiltInFictitiousFunctionClassFactory[15] + 1);
                byte b3 = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
                Object[] objArr2 = new Object[1];
                a(b2, b3, (byte) (b3 - 1), objArr2);
                ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    private void waitForNotifications() {
        this.mExecutorService.execute(new Runnable() { // from class: io.split.android.client.service.sseclient.reactor.UpdateWorker.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        UpdateWorker.this.onWaitForNotificationLoop();
                    } catch (InterruptedException unused) {
                        return;
                    }
                }
            }
        });
    }
}
