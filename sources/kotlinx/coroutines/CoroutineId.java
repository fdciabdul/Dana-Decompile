package kotlinx.coroutines;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.common.base.Ascii;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\b\u0080\b\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001dB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÖ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00168\u0007¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a"}, d2 = {"Lkotlinx/coroutines/CoroutineId;", "Lkotlinx/coroutines/ThreadContextElement;", "", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "oldState", "", "restoreThreadContext", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "updateThreadContext", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "", "id", "J", "getId", "()J", "<init>", "(J)V", "Key"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class CoroutineId extends AbstractCoroutineContextElement implements ThreadContextElement<String> {
    private final long id;
    public static final byte[] MyBillsEntityDataFactory = {Ascii.EM, 16, -94, Ascii.FS, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int BuiltInFictitiousFunctionClassFactory = 194;

    /* renamed from: Key  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = r6 + 13
            int r7 = r7 * 12
            int r7 = 16 - r7
            byte[] r0 = kotlinx.coroutines.CoroutineId.MyBillsEntityDataFactory
            int r8 = r8 * 7
            int r8 = 106 - r8
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r4 = r8
            r3 = 0
            r8 = r7
            goto L2e
        L19:
            r3 = 0
            r5 = r8
            r8 = r7
            r7 = r5
        L1d:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r8]
        L2e:
            int r4 = -r4
            int r7 = r7 + r4
            int r8 = r8 + 1
            int r7 = r7 + 2
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.CoroutineId.a(short, int, int, java.lang.Object[]):void");
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CoroutineId) && this.id == ((CoroutineId) other).id;
    }

    public final int hashCode() {
        return Cbor$Arg$$ExternalSyntheticBackport0.m(this.id);
    }

    @JvmName(name = "getId")
    public final long getId() {
        return this.id;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineId$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineId;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.CoroutineId$Key  reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion implements CoroutineContext.Key<CoroutineId> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public CoroutineId(long j) {
        super(INSTANCE);
        this.id = j;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CoroutineId(");
        sb.append(this.id);
        sb.append(')');
        return sb.toString();
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public final String updateThreadContext(CoroutineContext context) {
        String str;
        CoroutineName coroutineName = (CoroutineName) context.get(CoroutineName.INSTANCE);
        if (coroutineName == null || (str = coroutineName.getName()) == null) {
            str = "coroutine";
        }
        try {
            byte b = (byte) (-MyBillsEntityDataFactory[15]);
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (MyBillsEntityDataFactory[15] + 1);
            byte b4 = (byte) (-MyBillsEntityDataFactory[15]);
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            Thread thread = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
            String name = thread.getName();
            int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) name, " @", 0, false, 6, (Object) null);
            if (lastIndexOf$default < 0) {
                lastIndexOf$default = name.length();
            }
            StringBuilder sb = new StringBuilder(str.length() + lastIndexOf$default + 10);
            String substring = name.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "");
            sb.append(substring);
            sb.append(" @");
            sb.append(str);
            sb.append('#');
            sb.append(this.id);
            String obj = sb.toString();
            Intrinsics.checkNotNullExpressionValue(obj, "");
            thread.setName(obj);
            return name;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public final void restoreThreadContext(CoroutineContext context, String oldState) {
        try {
            byte b = (byte) (-MyBillsEntityDataFactory[15]);
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (MyBillsEntityDataFactory[15] + 1);
            byte b4 = (byte) (-MyBillsEntityDataFactory[15]);
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).setName(oldState);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }
}
