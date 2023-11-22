package io.split.android.client.utils;

import android.graphics.Color;
import android.graphics.PointF;
import android.view.KeyEvent;
import io.split.android.client.utils.logger.Logger;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;
import o.A;

/* loaded from: classes6.dex */
public class StringHelper {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 269894698;
    private static int PlaceComponentResult = 1;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r1v2 */
    public static Charset defaultCharset() {
        Charset charset;
        String str;
        int i = PlaceComponentResult + 125;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        ?? r0 = i % 2 != 0 ? 0 : 1;
        try {
            if (r0 != 0) {
                Charset.defaultCharset();
                Object[] objArr = new Object[1];
                a(new char[]{65513, 2, 16, 17, 65524}, 83 - KeyEvent.getDeadChar(0, 0), Color.blue(0) + 5, true, 4 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr);
                str = (String) objArr[0];
            } else {
                Charset.defaultCharset();
                Object[] objArr2 = new Object[1];
                a(new char[]{65513, 2, 16, 17, 65524}, 45 / KeyEvent.getDeadChar(1, 1), Color.blue(0) * 4, false, (PointF.length(1.0f, 0.0f) > 2.0f ? 1 : (PointF.length(1.0f, 0.0f) == 2.0f ? 0 : -1)) * 2, objArr2);
                str = (String) objArr2[0];
            }
            charset = Charset.forName(str.intern());
        } catch (Exception unused) {
            Logger.e("UTF-8 charset not available");
            charset = r0;
        }
        int i2 = PlaceComponentResult + 95;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return charset;
        }
        ?? r1 = 0;
        int length = r1.length;
        return charset;
    }

    public static String stringFromBytes(byte[] bArr) {
        String str = new String(bArr, 0, bArr.length, defaultCharset());
        int i = PlaceComponentResult + 11;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        return str;
    }

    public String join(String str, List<String> list) {
        int i = PlaceComponentResult + 19;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 == 0)) {
            Object obj = null;
            obj.hashCode();
            if (list == null) {
                return "";
            }
        } else if (list == null) {
            return "";
        }
        try {
            if (list.size() == 0) {
                return "";
            }
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 65;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
            if (str == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder(list.get(0));
            int i4 = 1;
            while (true) {
                if ((i4 < list.size() ? '7' : (char) 30) != '7') {
                    return sb.toString();
                }
                try {
                    int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 35;
                    PlaceComponentResult = i5 % 128;
                    if (i5 % 2 == 0) {
                        sb.append(str);
                        sb.append(list.get(i4));
                        i4 += 99;
                    } else {
                        sb.append(str);
                        sb.append(list.get(i4));
                        i4++;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String join(String str, Iterable<String> iterable) {
        if ((iterable != null ? '\f' : Typography.greater) != '>') {
            if (str != null) {
                int i = PlaceComponentResult + 101;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                Iterator<String> it = iterable.iterator();
                if ((!it.hasNext() ? (char) 14 : Typography.quote) == '\"') {
                    try {
                        StringBuilder sb = new StringBuilder(it.next().toString());
                        while (it.hasNext()) {
                            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 111;
                            PlaceComponentResult = i3 % 128;
                            int i4 = i3 % 2;
                            sb.append(str);
                            sb.append(it.next().toString());
                        }
                        return sb.toString();
                    } catch (Exception e) {
                        throw e;
                    }
                }
                int i5 = PlaceComponentResult + 59;
                KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                if (i5 % 2 != 0) {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return "";
                }
                return "";
            }
        }
        return "";
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i2) {
            int i4 = $10 + 119;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i6 = a2.MyBillsEntityDataFactory;
            cArr2[i6] = (char) (cArr2[i6] - ((int) (MyBillsEntityDataFactory ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
            int i7 = $10 + 89;
            $11 = i7 % 128;
            int i8 = i7 % 2;
        }
        if (i3 > 0) {
            try {
                a2.BuiltInFictitiousFunctionClassFactory = i3;
                char[] cArr3 = new char[i2];
                System.arraycopy(cArr2, 0, cArr3, 0, i2);
                System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
            } catch (Exception e) {
                throw e;
            }
        }
        if (!(!z)) {
            char[] cArr4 = new char[i2];
            a2.MyBillsEntityDataFactory = 0;
            while (true) {
                if ((a2.MyBillsEntityDataFactory < i2 ? '=' : Typography.less) != '=') {
                    break;
                }
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
                int i9 = $11 + 111;
                $10 = i9 % 128;
                int i10 = i9 % 2;
            }
            int i11 = $11 + 51;
            $10 = i11 % 128;
            int i12 = i11 % 2;
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
