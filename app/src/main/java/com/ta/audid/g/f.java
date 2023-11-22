package com.ta.audid.g;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static FileChannel f7683a;

    /* renamed from: a  reason: collision with other field name */
    private static FileLock f53a;
    private static File b;

    /* renamed from: b  reason: collision with other field name */
    private static FileChannel f54b;

    /* renamed from: b  reason: collision with other field name */
    private static FileLock f55b;
    private static File c;

    public static void g() {
        synchronized (f.class) {
            m.d();
            if (b == null) {
                b = new File(com.ta.audid.f.e.P());
            }
            if (!b.exists()) {
                try {
                    b.createNewFile();
                } catch (Exception unused) {
                    return;
                }
            }
            if (f7683a == null) {
                try {
                    f7683a = new RandomAccessFile(b, "rw").getChannel();
                } catch (Exception unused2) {
                    return;
                }
            }
            try {
                f53a = f7683a.lock();
            } catch (Throwable unused3) {
            }
        }
    }

    public static void h() {
        synchronized (f.class) {
            m.d();
            FileLock fileLock = f53a;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (Exception unused) {
                } catch (Throwable th) {
                    f53a = null;
                    throw th;
                }
                f53a = null;
            }
            FileChannel fileChannel = f7683a;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (Exception unused2) {
                } catch (Throwable th2) {
                    f7683a = null;
                    throw th2;
                }
                f7683a = null;
            }
        }
    }

    public static boolean d() {
        synchronized (f.class) {
            m.d();
            if (c == null) {
                c = new File(com.ta.audid.f.e.Q());
            }
            if (!c.exists()) {
                try {
                    c.createNewFile();
                } catch (Exception unused) {
                    return false;
                }
            }
            if (f54b == null) {
                try {
                    f54b = new RandomAccessFile(c, "rw").getChannel();
                } catch (Exception unused2) {
                    return false;
                }
            }
            try {
                FileLock tryLock = f54b.tryLock();
                if (tryLock != null) {
                    f55b = tryLock;
                    return true;
                }
            } catch (Throwable unused3) {
            }
            return false;
        }
    }

    public static void i() {
        synchronized (f.class) {
            m.d();
            FileLock fileLock = f55b;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (Exception unused) {
                } catch (Throwable th) {
                    f55b = null;
                    throw th;
                }
                f55b = null;
            }
            FileChannel fileChannel = f54b;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (Exception unused2) {
                } catch (Throwable th2) {
                    f54b = null;
                    throw th2;
                }
                f54b = null;
            }
        }
    }
}
