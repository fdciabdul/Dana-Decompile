package com.alibaba.ariver.kernel.common.io;

import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* loaded from: classes6.dex */
public class ProcessLock {
    public static final String TAG = "AriverKernelProcessLock";

    /* renamed from: a  reason: collision with root package name */
    private File f6126a;
    private RandomAccessFile b;
    private FileChannel c;
    private FileLock d;

    public ProcessLock(String str) {
        this.f6126a = new File(str);
    }

    public ProcessLock(File file) {
        this.f6126a = file;
    }

    public void lock() {
        try {
            if (this.b == null) {
                this.b = new RandomAccessFile(this.f6126a, "rw");
            }
            RandomAccessFile randomAccessFile = this.b;
            if (randomAccessFile == null || this.f6126a == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("lock error lockRaf = ");
                sb.append(this.b);
                sb.append(" lockFile = ");
                sb.append(this.f6126a);
                RVLogger.e(TAG, sb.toString());
                return;
            }
            this.c = randomAccessFile.getChannel();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Blocking on lock ");
            sb2.append(this.f6126a.getPath());
            RVLogger.d(TAG, sb2.toString());
            try {
                this.d = this.c.lock();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.f6126a.getPath());
                sb3.append(" locked");
                RVLogger.d(TAG, sb3.toString());
            } catch (IOException e) {
                RVLogger.e(TAG, "lock error ", e);
            }
        } catch (FileNotFoundException e2) {
            RVLogger.e(TAG, "ProcessLock error", e2);
        }
    }

    public void unlock() {
        FileLock fileLock = this.d;
        if (fileLock != null) {
            try {
                fileLock.release();
            } catch (IOException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to release lock on ");
                File file = this.f6126a;
                sb.append(file != null ? file.getPath() : "");
                RVLogger.e(TAG, sb.toString());
            }
        }
        IOUtils.closeQuietly(this.c);
        IOUtils.closeQuietly(this.b);
        if (this.f6126a != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f6126a.getPath());
            sb2.append(" unlocked");
            RVLogger.d(TAG, sb2.toString());
        }
    }

    public boolean tryLock() {
        try {
            if (this.b == null) {
                this.b = new RandomAccessFile(this.f6126a, "rw");
            }
            RandomAccessFile randomAccessFile = this.b;
            if (randomAccessFile == null || this.f6126a == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("tryLock error lockRaf = ");
                sb.append(this.b);
                sb.append(" lockFile = ");
                sb.append(this.f6126a);
                RVLogger.e(TAG, sb.toString());
                return false;
            }
            this.c = randomAccessFile.getChannel();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Blocking on tryLock ");
            sb2.append(this.f6126a.getPath());
            RVLogger.d(TAG, sb2.toString());
            try {
                try {
                    this.d = this.c.tryLock();
                } catch (IOException e) {
                    RVLogger.e(TAG, "TryLock error ", e);
                }
                IOUtils.closeQuietly(this.c);
                boolean z = this.d != null;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.f6126a.getPath());
                sb3.append("try locked: ");
                sb3.append(z);
                RVLogger.d(TAG, sb3.toString());
                return z;
            } catch (Throwable th) {
                IOUtils.closeQuietly(this.c);
                throw th;
            }
        } catch (FileNotFoundException e2) {
            RVLogger.e(TAG, "Process tryLock error", e2);
            return false;
        }
    }
}
