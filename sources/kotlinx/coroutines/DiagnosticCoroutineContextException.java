package kotlinx.coroutines;

import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.common.base.Ascii;
import java.lang.reflect.Array;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lkotlinx/coroutines/DiagnosticCoroutineContextException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "fillInStackTrace", "()Ljava/lang/Throwable;", "", "getLocalizedMessage", "()Ljava/lang/String;", "Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
final class DiagnosticCoroutineContextException extends RuntimeException {
    private final CoroutineContext context;
    public static final byte[] MyBillsEntityDataFactory = {83, 16, 71, 115, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -34, 37, -9, 6, -10, 7, 4};
    public static final int BuiltInFictitiousFunctionClassFactory = 211;

    public DiagnosticCoroutineContextException(CoroutineContext coroutineContext) {
        this.context = coroutineContext;
    }

    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return this.context.toString();
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        byte[] bArr = MyBillsEntityDataFactory;
        byte b = bArr[16];
        byte b2 = b;
        int i = 106 - (b * 4);
        int i2 = (b2 * 3) + 27;
        int i3 = (b2 * 2) + 4;
        byte[] bArr2 = new byte[i2];
        int i4 = -1;
        int i5 = i2 - 1;
        if (bArr == null) {
            i3++;
            int i6 = i5 + i3 + 2;
            i5 = i5;
            i = i6;
        }
        while (true) {
            i4++;
            bArr2[i4] = (byte) i;
            if (i4 == i5) {
                setStackTrace((StackTraceElement[]) ((Object[]) Array.newInstance(Class.forName(new String(bArr2, 0)), 0)));
                return this;
            }
            int i7 = bArr[i3];
            i3++;
            i5 = i5;
            i = i + i7 + 2;
        }
    }
}
