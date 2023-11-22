package fsimpl;

import com.fullstory.util.Log;
import java.io.File;

/* renamed from: fsimpl.di  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0312di {

    /* renamed from: a  reason: collision with root package name */
    private Thread f7935a;
    private C0376z b;

    public C0312di(C0376z c0376z) {
        this.b = c0376z;
    }

    private int a(File file, int i) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected error reading directory ");
            sb.append(file.getAbsolutePath());
            Log.e(sb.toString());
            return i;
        }
        for (File file2 : listFiles) {
            i++;
            if (i % 100 == 0) {
                Thread.sleep(1000L);
            }
            if (file2.isDirectory()) {
                i = a(file2, i);
            }
            if (!file2.delete()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unexpectedly unable to remove file ");
                sb2.append(file2.getAbsolutePath());
                Log.e(sb2.toString());
                file2.deleteOnExit();
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        while (true) {
            int i = 0;
            while (!Thread.interrupted()) {
                try {
                    a(this.b.b(), 0);
                    try {
                        Thread.sleep(10000L);
                    } catch (InterruptedException unused) {
                    }
                } catch (Throwable unused2) {
                    i++;
                    if (i > 3) {
                        try {
                            Thread.sleep(10000L);
                            return;
                        } catch (InterruptedException unused3) {
                            return;
                        }
                    }
                    try {
                        Thread.sleep(10000L);
                    } catch (InterruptedException unused4) {
                    }
                }
            }
            return;
        }
    }

    public void a() {
        eN eNVar = new eN(new RunnableC0313dj(this), "fs-deleter");
        this.f7935a = eNVar;
        eNVar.start();
    }
}
