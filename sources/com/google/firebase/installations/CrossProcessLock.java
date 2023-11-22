package com.google.firebase.installations;

import com.fullstory.instrumentation.InstrumentInjector;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* loaded from: classes3.dex */
class CrossProcessLock {
    private static final String TAG = "CrossProcessLock";
    private final FileChannel channel;
    private final FileLock lock;

    private CrossProcessLock(FileChannel fileChannel, FileLock fileLock) {
        this.channel = fileChannel;
        this.lock = fileLock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.firebase.installations.CrossProcessLock acquire(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.nio.channels.OverlappingFileLockException -> L2e java.lang.Error -> L30 java.io.IOException -> L32
            java.io.File r4 = r4.getFilesDir()     // Catch: java.nio.channels.OverlappingFileLockException -> L2e java.lang.Error -> L30 java.io.IOException -> L32
            r1.<init>(r4, r5)     // Catch: java.nio.channels.OverlappingFileLockException -> L2e java.lang.Error -> L30 java.io.IOException -> L32
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch: java.nio.channels.OverlappingFileLockException -> L2e java.lang.Error -> L30 java.io.IOException -> L32
            java.lang.String r5 = "rw"
            r4.<init>(r1, r5)     // Catch: java.nio.channels.OverlappingFileLockException -> L2e java.lang.Error -> L30 java.io.IOException -> L32
            java.nio.channels.FileChannel r4 = r4.getChannel()     // Catch: java.nio.channels.OverlappingFileLockException -> L2e java.lang.Error -> L30 java.io.IOException -> L32
            java.nio.channels.FileLock r5 = r4.lock()     // Catch: java.nio.channels.OverlappingFileLockException -> L26 java.lang.Error -> L28 java.io.IOException -> L2a
            com.google.firebase.installations.CrossProcessLock r1 = new com.google.firebase.installations.CrossProcessLock     // Catch: java.nio.channels.OverlappingFileLockException -> L20 java.lang.Error -> L22 java.io.IOException -> L24
            r1.<init>(r4, r5)     // Catch: java.nio.channels.OverlappingFileLockException -> L20 java.lang.Error -> L22 java.io.IOException -> L24
            return r1
        L20:
            r1 = move-exception
            goto L36
        L22:
            r1 = move-exception
            goto L36
        L24:
            r1 = move-exception
            goto L36
        L26:
            r5 = move-exception
            goto L2b
        L28:
            r5 = move-exception
            goto L2b
        L2a:
            r5 = move-exception
        L2b:
            r1 = r5
            r5 = r0
            goto L36
        L2e:
            r4 = move-exception
            goto L33
        L30:
            r4 = move-exception
            goto L33
        L32:
            r4 = move-exception
        L33:
            r1 = r4
            r4 = r0
            r5 = r4
        L36:
            java.lang.String r2 = "CrossProcessLock"
            java.lang.String r3 = "encountered error while creating and acquiring the lock, ignoring"
            com.fullstory.instrumentation.InstrumentInjector.log_e(r2, r3, r1)
            if (r5 == 0) goto L44
            r5.release()     // Catch: java.io.IOException -> L43
            goto L44
        L43:
        L44:
            if (r4 == 0) goto L49
            r4.close()     // Catch: java.io.IOException -> L49
        L49:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.CrossProcessLock.acquire(android.content.Context, java.lang.String):com.google.firebase.installations.CrossProcessLock");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void releaseAndClose() {
        try {
            this.lock.release();
            this.channel.close();
        } catch (IOException e) {
            InstrumentInjector.log_e(TAG, "encountered error while releasing, ignoring", e);
        }
    }
}
