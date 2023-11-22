package fsimpl;

import android.util.LruCache;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: fsimpl.dn  reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C0317dn implements dC {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int[] f7940a;
    final /* synthetic */ HashMap b;
    final /* synthetic */ ArrayList c;
    final /* synthetic */ C0315dl d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0317dn(C0315dl c0315dl, int[] iArr, HashMap hashMap, ArrayList arrayList) {
        this.d = c0315dl;
        this.f7940a = iArr;
        this.b = hashMap;
        this.c = arrayList;
    }

    @Override // fsimpl.dC
    public dD a(String str, String str2) {
        LruCache lruCache;
        int[] iArr = this.f7940a;
        iArr[5] = iArr[5] + 1;
        lruCache = this.d.k;
        if (lruCache.put(str2, Boolean.TRUE) != null) {
            int[] iArr2 = this.f7940a;
            iArr2[2] = iArr2[2] + 1;
        } else if (this.b.put(str2, str) == null) {
            int[] iArr3 = this.f7940a;
            iArr3[0] = iArr3[0] + 1;
            this.c.add(str2);
            return this.c.size() < 20 ? dD.CONTINUE : dD.END;
        } else {
            int[] iArr4 = this.f7940a;
            iArr4[1] = iArr4[1] + 1;
        }
        return dD.DELETE_CONTINUE;
    }
}
