package fsimpl;

import android.graphics.Bitmap;
import com.fullstory.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: fsimpl.by  reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C0274by {

    /* renamed from: a  reason: collision with root package name */
    private final Object f7897a = new Object();
    private List b = new ArrayList();
    private Set c = new HashSet();
    private int d = 0;
    private final int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0274by(int i) {
        this.e = i;
    }

    private void b(Bitmap bitmap) {
        if (this.c.contains(bitmap)) {
            this.c.remove(bitmap);
            if (this.b.size() < 2) {
                this.b.add(bitmap);
            } else {
                bitmap.recycle();
            }
        }
    }

    public int a() {
        return this.e;
    }

    public Bitmap a(String str, boolean z) {
        Bitmap bitmap;
        synchronized (this.f7897a) {
            if (this.b.size() == 0) {
                bitmap = Bitmap.createBitmap(a(), a(), Bitmap.Config.ARGB_8888);
                int size = this.b.size() + this.c.size();
                if (size > this.d) {
                    if (size / 10 != this.d / 10) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("New high-water mark for pool: ");
                        sb.append(size);
                        Log.d(sb.toString());
                    }
                    this.d = size;
                }
            } else {
                Bitmap bitmap2 = (Bitmap) this.b.remove(this.b.size() - 1);
                if (z) {
                    bitmap2.eraseColor(0);
                }
                bitmap = bitmap2;
            }
            this.c.add(bitmap);
        }
        return bitmap;
    }

    public void a(Bitmap bitmap) {
        synchronized (this.f7897a) {
            b(bitmap);
        }
    }

    public void a(Collection collection) {
        synchronized (this.f7897a) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                b((Bitmap) it.next());
            }
        }
    }
}
