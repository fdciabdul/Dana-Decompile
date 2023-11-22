package fsimpl;

import com.fullstory.util.Log;

/* renamed from: fsimpl.db  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0305db {
    public static C0304da a(C0311dh c0311dh, Object obj, C0248az c0248az, C0304da[] c0304daArr) {
        for (C0304da c0304da : c0304daArr) {
            if (a(c0311dh, obj, c0304da.f7930a, c0248az)) {
                if (!Log.DISABLE_LOGGING) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Matched ");
                    sb.append(obj.getClass());
                    sb.append(" from selector ");
                    sb.append(c0304da.a());
                    Log.i(sb.toString());
                }
                return c0304da;
            }
        }
        return null;
    }

    private static String a(String str, String str2) {
        return str == null ? str2 : str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0094, code lost:
    
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[LOOP:3: B:48:0x00a7->B:110:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x013a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(fsimpl.C0311dh r16, java.lang.Object r17, fsimpl.C0306dc r18, fsimpl.C0248az r19) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.C0305db.a(fsimpl.dh, java.lang.Object, fsimpl.dc, fsimpl.az):boolean");
    }

    private static boolean a(String str, String str2, Byte b) {
        if (str == null || b == null) {
            return false;
        }
        switch (b.byteValue()) {
            case 0:
                return str.equals(str2);
            case 1:
                return true;
            case 2:
                return str.contains(str2);
            case 3:
                return str.startsWith(str2);
            case 4:
                return str.endsWith(str2);
            case 5:
                if (str.equals(str2)) {
                    return true;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(" ");
                if (!str.startsWith(sb.toString())) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(" ");
                    sb2.append(str2);
                    if (!str.endsWith(sb2.toString())) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(" ");
                        sb3.append(str2);
                        sb3.append(" ");
                        return str.contains(sb3.toString());
                    }
                }
                return true;
            case 6:
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str2);
                sb4.append("-");
                return str.startsWith(sb4.toString()) || str.equals(str2);
            default:
                return false;
        }
    }
}
