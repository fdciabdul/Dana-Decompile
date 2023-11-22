package id.dana.core.ui.util;

import android.os.Looper;
import android.widget.EditText;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003*\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/core/ui/util/FlowViewUtil;", "", "Landroid/widget/EditText;", "Lkotlinx/coroutines/flow/Flow;", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/widget/EditText;)Lkotlinx/coroutines/flow/Flow;", "", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FlowViewUtil {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {TarHeader.LF_DIR, -98, 98, -100, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int MyBillsEntityDataFactory = 182;
    public static final FlowViewUtil INSTANCE = new FlowViewUtil();

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 12
            int r7 = 15 - r7
            int r8 = r8 * 7
            int r8 = 106 - r8
            byte[] r0 = id.dana.core.ui.util.FlowViewUtil.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 * 3
            int r6 = r6 + 13
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L18
            r8 = r7
            r4 = r8
            r3 = 0
            r7 = r6
            goto L30
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            int r7 = r7 + 1
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L30:
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + 2
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.core.ui.util.FlowViewUtil.a(int, byte, short, java.lang.Object[]):void");
    }

    private FlowViewUtil() {
    }

    public static Flow<CharSequence> PlaceComponentResult(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "");
        return FlowKt.onStart(FlowKt.callbackFlow(new FlowViewUtil$textChanges$1(editText, null)), new FlowViewUtil$textChanges$2(editText, null));
    }

    public static Flow<Boolean> BuiltInFictitiousFunctionClassFactory(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "");
        return FlowKt.onStart(FlowKt.callbackFlow(new FlowViewUtil$onFocusChanges$1(editText, null)), new FlowViewUtil$onFocusChanges$2(editText, null));
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected to be called on the main thread but was ");
        try {
            byte b = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory[15] + 1);
            byte b4 = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
            throw new IllegalStateException(sb.toString().toString());
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }
}
