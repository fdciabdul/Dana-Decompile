package com.alibaba.exthub.config;

import com.alibaba.exthub.common.ExtHubLogger;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* loaded from: classes6.dex */
public class ProcessLock {
    public static final String TAG = "ProcessLock";

    /* renamed from: a  reason: collision with root package name */
    private File f6267a;
    private RandomAccessFile b;
    private FileChannel c;
    private FileLock d;

    public ProcessLock(String str) {
        this.f6267a = new File(str);
    }

    public ProcessLock(File file) {
        this.f6267a = file;
    }

    public void lock() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.f6267a, "rw");
            this.b = randomAccessFile;
            if (this.f6267a == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("lock error lockRaf = ");
                sb.append(this.b);
                sb.append(" lockFile = ");
                sb.append(this.f6267a);
                ExtHubLogger.e(TAG, sb.toString());
                return;
            }
            this.c = randomAccessFile.getChannel();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Blocking on lock ");
            sb2.append(this.f6267a.getPath());
            ExtHubLogger.d(TAG, sb2.toString());
            try {
                this.d = this.c.lock();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.f6267a.getPath());
                sb3.append(" locked");
                ExtHubLogger.d(TAG, sb3.toString());
            } catch (IOException e) {
                ExtHubLogger.e(TAG, "lock error ", e);
            }
        } catch (FileNotFoundException e2) {
            ExtHubLogger.e(TAG, "ProcessLock error", e2);
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
                File file = this.f6267a;
                sb.append(file != null ? file.getPath() : "");
                ExtHubLogger.e(TAG, sb.toString());
            }
        }
        a(this.c);
        a(this.b);
        if (this.f6267a != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f6267a.getPath());
            sb2.append(" unlocked");
            ExtHubLogger.d(TAG, sb2.toString());
        }
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                ExtHubLogger.e(TAG, e);
            }
        }
    }
}
