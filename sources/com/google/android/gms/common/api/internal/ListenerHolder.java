package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import com.google.common.base.Ascii;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class ListenerHolder<L> {
    private final Executor zaa;
    private volatile L zab;
    private volatile ListenerKey<L> zac;

    /* loaded from: classes3.dex */
    public static final class ListenerKey<L> {
        public static final byte[] BuiltInFictitiousFunctionClassFactory = {116, 15, TarHeader.LF_BLK, -20, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
        public static final int PlaceComponentResult = 236;
        private final L zaa;
        private final String zab;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ListenerKey(L l, String str) {
            this.zaa = l;
            this.zab = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0032). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(short r7, byte r8, int r9, java.lang.Object[] r10) {
            /*
                int r7 = r7 + 105
                int r9 = r9 * 3
                int r9 = 16 - r9
                int r8 = r8 * 15
                int r8 = 19 - r8
                byte[] r0 = com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey.BuiltInFictitiousFunctionClassFactory
                byte[] r1 = new byte[r9]
                r2 = 0
                if (r0 != 0) goto L18
                r7 = r8
                r3 = r1
                r5 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                goto L32
            L18:
                r3 = 0
            L19:
                byte r4 = (byte) r7
                int r5 = r3 + 1
                r1[r3] = r4
                if (r5 != r9) goto L28
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L28:
                r3 = r0[r8]
                r6 = r9
                r9 = r7
                r7 = r8
                r8 = r3
                r3 = r1
                r1 = r0
                r0 = r10
                r10 = r6
            L32:
                int r9 = r9 + r8
                int r8 = r7 + 1
                int r7 = r9 + 2
                r9 = r10
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r5
                goto L19
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey.a(short, byte, int, java.lang.Object[]):void");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ListenerKey) {
                ListenerKey listenerKey = (ListenerKey) obj;
                return this.zaa == listenerKey.zaa && this.zab.equals(listenerKey.zab);
            }
            return false;
        }

        public final int hashCode() {
            try {
                Object[] objArr = {this.zaa};
                byte b = (byte) (-BuiltInFictitiousFunctionClassFactory[5]);
                byte b2 = (byte) (b - 1);
                Object[] objArr2 = new Object[1];
                a(b, b2, b2, objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
                byte b4 = (byte) (-BuiltInFictitiousFunctionClassFactory[5]);
                Object[] objArr3 = new Object[1];
                a(b3, b4, (byte) (b4 - 1), objArr3);
                return (((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue() * 31) + this.zab.hashCode();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }

        public final String toIdString() {
            String str = this.zab;
            try {
                Object[] objArr = {this.zaa};
                byte b = (byte) (-BuiltInFictitiousFunctionClassFactory[5]);
                byte b2 = (byte) (b - 1);
                Object[] objArr2 = new Object[1];
                a(b, b2, b2, objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
                byte b4 = (byte) (-BuiltInFictitiousFunctionClassFactory[5]);
                Object[] objArr3 = new Object[1];
                a(b3, b4, (byte) (b4 - 1), objArr3);
                int intValue = ((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue();
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(str);
                sb.append(AUScreenAdaptTool.PREFIX_ID);
                sb.append(intValue);
                return sb.toString();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface Notifier<L> {
        void notifyListener(L l);

        void onNotifyListenerFailed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListenerHolder(Looper looper, L l, String str) {
        this.zaa = new HandlerExecutor(looper);
        this.zab = (L) Preconditions.checkNotNull(l, "Listener must not be null");
        this.zac = new ListenerKey<>(l, Preconditions.checkNotEmpty(str));
    }

    public final void clear() {
        this.zab = null;
        this.zac = null;
    }

    public final ListenerKey<L> getListenerKey() {
        return this.zac;
    }

    public final boolean hasListener() {
        return this.zab != null;
    }

    public final void notifyListener(final Notifier<? super L> notifier) {
        Preconditions.checkNotNull(notifier, "Notifier must not be null");
        this.zaa.execute(new Runnable() { // from class: com.google.android.gms.common.api.internal.zacb
            @Override // java.lang.Runnable
            public final void run() {
                ListenerHolder.this.zaa(notifier);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zaa(Notifier<? super L> notifier) {
        Object obj = (L) this.zab;
        if (obj == null) {
            notifier.onNotifyListenerFailed();
            return;
        }
        try {
            notifier.notifyListener(obj);
        } catch (RuntimeException e) {
            notifier.onNotifyListenerFailed();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListenerHolder(Executor executor, L l, String str) {
        this.zaa = (Executor) Preconditions.checkNotNull(executor, "Executor must not be null");
        this.zab = (L) Preconditions.checkNotNull(l, "Listener must not be null");
        this.zac = new ListenerKey<>(l, Preconditions.checkNotEmpty(str));
    }
}
