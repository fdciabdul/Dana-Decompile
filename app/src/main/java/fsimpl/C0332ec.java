package fsimpl;

import android.graphics.Bitmap;
import android.util.LongSparseArray;
import java.util.WeakHashMap;

/* renamed from: fsimpl.ec  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0332ec {

    /* renamed from: a  reason: collision with root package name */
    private LongSparseArray f7967a = new LongSparseArray();
    private WeakHashMap b = new WeakHashMap();
    private WeakHashMap c = new WeakHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(long j) {
        String str;
        synchronized (this) {
            str = (String) this.f7967a.get(j);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(Bitmap bitmap) {
        String str;
        synchronized (this) {
            str = (String) this.b.get(bitmap);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j, String str) {
        synchronized (this) {
            this.f7967a.put(j, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Bitmap bitmap, String str) {
        synchronized (this) {
            this.b.put(bitmap, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(long j) {
        synchronized (this) {
            this.f7967a.remove(j);
        }
    }

    public void putImageDecoder(Object obj, Long l) {
        synchronized (this) {
            if (l != null) {
                this.c.put(obj, l);
            }
        }
    }

    public Long removeImageDecoder(Object obj) {
        Long l;
        synchronized (this) {
            l = (Long) this.c.remove(obj);
        }
        return l;
    }
}
