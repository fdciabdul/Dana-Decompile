package fsimpl;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.FS;
import com.fullstory.rust.RustInterface;
import com.fullstory.util.Log;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: fsimpl.bh  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0257bh extends FragmentManager.FragmentLifecycleCallbacks {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {114, -124, TarHeader.LF_CONTIG, 72, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int MyBillsEntityDataFactory = 105;

    /* renamed from: a  reason: collision with root package name */
    private final RustInterface f7890a;
    private final aA b;
    private final List c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0257bh(RustInterface rustInterface, aA aAVar) {
        this.f7890a = rustInterface;
        this.b = aAVar;
    }

    private void a(Fragment fragment, short s) {
        String name = fragment.getClass().getName();
        this.f7890a.a((short) 0, s, name);
        if (Log.isLogcatLoggable(FS.LogLevel.DEBUG)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[fragment] onFragmentChangeEvent: ");
            sb.append(name);
            sb.append(" - ");
            sb.append(C0277ca.a(s));
            Log.d(sb.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(short r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = fsimpl.C0257bh.KClassImpl$Data$declaredNonStaticMembers$2
            int r9 = r9 * 15
            int r9 = 18 - r9
            int r7 = r7 * 3
            int r7 = 16 - r7
            int r8 = r8 + 105
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L35
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            int r9 = r9 + 1
            r3 = r0[r9]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L35:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r8
            r8 = r7
            r7 = r6
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.C0257bh.d(short, short, int, java.lang.Object[]):void");
    }

    public List getResumedFragmentViewHashes() {
        return this.c;
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        a(fragment, (short) 0);
        View view = fragment.getView();
        if (view != null) {
            List list = this.c;
            try {
                Object[] objArr = {view};
                byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                Object[] objArr2 = new Object[1];
                d(b, b2, (byte) (b2 - 1), objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                Object[] objArr3 = new Object[1];
                d(b3, b3, KClassImpl$Data$declaredNonStaticMembers$2[5], objArr3);
                list.remove(Integer.valueOf(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue()));
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        a(fragment, (short) 1);
        View view = fragment.getView();
        if (view != null) {
            this.b.a(view, "fragment", fragment.getClass().getSimpleName());
            List list = this.c;
            try {
                Object[] objArr = {view};
                byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                Object[] objArr2 = new Object[1];
                d(b, b2, (byte) (b2 - 1), objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                Object[] objArr3 = new Object[1];
                d(b3, b3, KClassImpl$Data$declaredNonStaticMembers$2[5], objArr3);
                list.add(Integer.valueOf(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue()));
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }
}
