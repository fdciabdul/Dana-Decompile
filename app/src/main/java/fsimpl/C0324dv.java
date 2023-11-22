package fsimpl;

import com.fullstory.util.Log;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: fsimpl.dv  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0324dv implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    dH f7948a;
    File b;
    File c;
    FileChannel d;
    FileLock e;
    String f;
    long g;
    long h;
    dF i;
    URL j;
    String k;
    boolean l;
    boolean m;
    String n;

    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    public int compareTo(C0324dv c0324dv) {
        if (c0324dv != null) {
            int compareTo = this.f7948a.compareTo(c0324dv.f7948a);
            if (compareTo != 0) {
                return -compareTo;
            }
            int compareTo2 = this.i.compareTo(c0324dv.i);
            if (compareTo2 != 0) {
                return -compareTo2;
            }
            int i = (this.g > c0324dv.g ? 1 : (this.g == c0324dv.g ? 0 : -1));
            return i != 0 ? i : this.f.compareTo(c0324dv.f);
        }
        throw new IllegalArgumentException("Null comparable");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        b();
        if (!this.b.delete()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpectedly unable to delete ");
            sb.append(this.b.getAbsolutePath());
            Log.e(sb.toString());
        }
        if (this.c.delete()) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unexpectedly unable to delete ");
        sb2.append(this.c.getAbsolutePath());
        Log.e(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        synchronized (this) {
            if (this.e != null) {
                try {
                    this.e.release();
                } catch (IOException e) {
                    Log.e("Unexpectedly couldn't release file lock", e);
                }
                this.e = null;
            }
            if (this.d != null) {
                eI.a(this.d);
                this.d = null;
            }
        }
    }
}
