package fsimpl;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class aZ {

    /* renamed from: a  reason: collision with root package name */
    private Map f7840a = new HashMap();
    private aJ b;

    public aZ(aJ aJVar) {
        this.b = aJVar;
    }

    public int a(Bitmap bitmap) {
        int a2 = this.b.a();
        this.f7840a.put(Integer.valueOf(a2), bitmap);
        return a2;
    }

    public Map a() {
        if (this.f7840a.size() == 0) {
            return null;
        }
        Map map = this.f7840a;
        this.f7840a = new HashMap();
        return map;
    }
}
