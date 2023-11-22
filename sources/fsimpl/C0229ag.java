package fsimpl;

import com.fullstory.util.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: fsimpl.ag  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0229ag {

    /* renamed from: a  reason: collision with root package name */
    private final bG f7849a;

    public C0229ag(bG bGVar) {
        this.f7849a = bGVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0187  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private fsimpl.C0230ah a(fsimpl.bG r20, java.nio.ByteBuffer r21) {
        /*
            Method dump skipped, instructions count: 744
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.C0229ag.a(fsimpl.bG, java.nio.ByteBuffer):fsimpl.ah");
    }

    private static C0307dd a(ArrayList[] arrayListArr) {
        return C0310dg.a(arrayListArr[0], arrayListArr[1], arrayListArr[2]);
    }

    private static void a(String str, C0307dd c0307dd) {
        a(str, "active", c0307dd.a());
        a(str, "activeWhenConsented", c0307dd.b());
        a(str, "activeWhenNotConsented", c0307dd.c());
    }

    private static void a(String str, String str2, C0304da[] c0304daArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("Selector name=");
        sb.append(str);
        sb.append("; type=");
        sb.append(str2);
        sb.append("; length=");
        sb.append(c0304daArr.length);
        Log.d(sb.toString());
        for (C0304da c0304da : c0304daArr) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("    ");
            sb2.append(c0304da);
            Log.d(sb2.toString());
        }
    }

    private static void a(List list, bU bUVar) {
        if (bUVar == null || a(list, bUVar.a())) {
            return;
        }
        Log.e("Failed to parse block rule");
    }

    private static void a(List list, C0296ct c0296ct) {
        if (c0296ct == null || a(list, c0296ct.b())) {
            return;
        }
        Log.e("Failed to parse keep rule");
    }

    private static boolean a(List list, bY bYVar) {
        try {
            C0304da a2 = C0304da.a(bYVar);
            if (a2 != null) {
                list.add(a2);
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to parse selector ");
            sb.append(bYVar);
            Log.e(sb.toString());
            return false;
        } catch (IllegalArgumentException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Exception parsing selector ");
            sb2.append(bYVar);
            Log.e(sb2.toString(), e);
            return false;
        }
    }

    private static ArrayList[] a() {
        return new ArrayList[]{new ArrayList(), new ArrayList(), new ArrayList()};
    }

    private static C0307dd b(ArrayList[] arrayListArr) {
        return C0310dg.b(arrayListArr[0], arrayListArr[1], arrayListArr[2]);
    }

    private static C0307dd c(ArrayList[] arrayListArr) {
        return C0310dg.c(arrayListArr[0], arrayListArr[1], arrayListArr[2]);
    }

    private static C0307dd d(ArrayList[] arrayListArr) {
        return C0310dg.d(arrayListArr[0], arrayListArr[1], arrayListArr[2]);
    }

    private static C0307dd e(ArrayList[] arrayListArr) {
        return C0310dg.e(arrayListArr[0], arrayListArr[1], arrayListArr[2]);
    }

    private static C0307dd f(ArrayList[] arrayListArr) {
        return C0310dg.f(arrayListArr[0], arrayListArr[1], arrayListArr[2]);
    }

    public C0230ah a(ByteBuffer byteBuffer) {
        if (byteBuffer == null || byteBuffer.capacity() == 0) {
            return new C0230ah(this.f7849a);
        }
        try {
            C0230ah a2 = a(this.f7849a, byteBuffer);
            if (a2 == null) {
                Log.logAlways("Invalid session response, disabling session");
                return new C0230ah(this.f7849a);
            }
            Log.logAlways(a2.e() ? "FullStory session started" : "FullStory session disabled");
            return a2;
        } catch (Throwable th) {
            Log.logAlways("Failed to parse session data, disabling session");
            Log.e("Failed to parse session data, disabling session", th);
            return new C0230ah(this.f7849a);
        }
    }

    public C0230ah a(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? new C0230ah(this.f7849a) : a(ByteBuffer.wrap(bArr));
    }
}
