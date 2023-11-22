package kotlin.reflect.jvm.internal.impl.protobuf;

import android.view.View;
import android.view.ViewConfiguration;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import kotlin.text.Typography;
import o.A;

/* loaded from: classes.dex */
public class Internal {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer EMPTY_BYTE_BUFFER;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int getAuthRequestContext = 1;

    /* loaded from: classes.dex */
    public interface EnumLite {
        int getNumber();
    }

    /* loaded from: classes.dex */
    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int i);
    }

    static void PlaceComponentResult() {
        KClassImpl$Data$declaredNonStaticMembers$2 = 269894737;
    }

    public static boolean isValidUtf8(byte[] bArr) {
        int i = getAuthRequestContext + 91;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        boolean isValidUtf8 = Utf8.isValidUtf8(bArr);
        int i3 = getAuthRequestContext + 37;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        return isValidUtf8;
    }

    public static String toStringUtf8(byte[] bArr) {
        try {
            Object[] objArr = new Object[1];
            a(new char[]{65524, 17, 16, 2, 65513}, 184 - (ViewConfiguration.getScrollBarSize() >> 8), 5 + View.resolveSizeAndState(0, 0, 0), false, (ViewConfiguration.getEdgeSlop() >> 16) + 1, objArr);
            String str = new String(bArr, ((String) objArr[0]).intern());
            int i = BuiltInFictitiousFunctionClassFactory + 25;
            getAuthRequestContext = i % 128;
            if ((i % 2 == 0 ? '2' : Typography.quote) != '\"') {
                Object[] objArr2 = null;
                int length = objArr2.length;
                return str;
            }
            return str;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    static {
        PlaceComponentResult();
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(bArr);
        int i = BuiltInFictitiousFunctionClassFactory + 47;
        getAuthRequestContext = i % 128;
        if (!(i % 2 == 0)) {
            return;
        }
        int i2 = 46 / 0;
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i2) {
            try {
                a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                int i4 = a2.MyBillsEntityDataFactory;
                cArr2[i4] = (char) (cArr2[i4] - ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ (-5694784870793460699L))));
                a2.MyBillsEntityDataFactory++;
            } catch (Exception e) {
                throw e;
            }
        }
        if (!(i3 <= 0)) {
            try {
                int i5 = $11 + 67;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                a2.BuiltInFictitiousFunctionClassFactory = i3;
                char[] cArr3 = new char[i2];
                System.arraycopy(cArr2, 0, cArr3, 0, i2);
                System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
            } catch (Exception e2) {
                throw e2;
            }
        }
        if (z) {
            char[] cArr4 = new char[i2];
            a2.MyBillsEntityDataFactory = 0;
            while (true) {
                if ((a2.MyBillsEntityDataFactory < i2 ? (char) 29 : (char) 4) == 4) {
                    break;
                }
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
            }
            cArr2 = cArr4;
        }
        String str = new String(cArr2);
        int i7 = $10 + 79;
        $11 = i7 % 128;
        int i8 = i7 % 2;
        objArr[0] = str;
    }
}
