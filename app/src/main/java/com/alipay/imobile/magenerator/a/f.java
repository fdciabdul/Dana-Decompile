package com.alipay.imobile.magenerator.a;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.google.zxing.common.StringUtils;
import java.util.HashMap;
import java.util.Map;
import o.A;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'w' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class f {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final f A;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static final Map D;
    private static final Map E;
    private static final /* synthetic */ f[] F;
    private static int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: a  reason: collision with root package name */
    public static final f f7010a;
    public static final f b;
    public static final f c;
    public static final f d;
    public static final f e;
    public static final f f;
    public static final f g;
    private static int getAuthRequestContext;
    public static final f h;
    public static final f i;
    public static final f j;
    public static final f k;
    public static final f l;
    public static final f m;
    public static final f n;

    /* renamed from: o  reason: collision with root package name */
    public static final f f7011o;
    public static final f p;
    public static final f q;
    public static final f r;
    public static final f s;
    public static final f t;
    public static final f u;
    public static final f v;
    public static final f w;
    public static final f x;
    public static final f y;
    public static final f z;
    private final int[] B;
    private final String[] C;

    static {
        BuiltInFictitiousFunctionClassFactory();
        f fVar = new f("Cp437", 0, new int[]{0, 2}, new String[0]);
        f7010a = fVar;
        f fVar2 = new f("ISO8859_1", 1, new int[]{1, 3}, "ISO-8859-1");
        b = fVar2;
        f fVar3 = new f("ISO8859_2", 2, 4, "ISO-8859-2");
        c = fVar3;
        f fVar4 = new f("ISO8859_3", 3, 5, "ISO-8859-3");
        d = fVar4;
        f fVar5 = new f("ISO8859_4", 4, 6, "ISO-8859-4");
        e = fVar5;
        f fVar6 = new f("ISO8859_5", 5, 7, "ISO-8859-5");
        f = fVar6;
        f fVar7 = new f("ISO8859_6", 6, 8, "ISO-8859-6");
        g = fVar7;
        f fVar8 = new f("ISO8859_7", 7, 9, "ISO-8859-7");
        h = fVar8;
        f fVar9 = new f("ISO8859_8", 8, 10, "ISO-8859-8");
        i = fVar9;
        f fVar10 = new f("ISO8859_9", 9, 11, "ISO-8859-9");
        j = fVar10;
        f fVar11 = new f("ISO8859_10", 10, 12, "ISO-8859-10");
        k = fVar11;
        f fVar12 = new f("ISO8859_11", 11, 13, "ISO-8859-11");
        l = fVar12;
        f fVar13 = new f("ISO8859_13", 12, 15, "ISO-8859-13");
        m = fVar13;
        f fVar14 = new f("ISO8859_14", 13, 16, "ISO-8859-14");
        n = fVar14;
        f fVar15 = new f("ISO8859_15", 14, 17, "ISO-8859-15");
        f7011o = fVar15;
        f fVar16 = new f("ISO8859_16", 15, 18, "ISO-8859-16");
        p = fVar16;
        f fVar17 = new f(StringUtils.SHIFT_JIS, 16, 20, "Shift_JIS");
        q = fVar17;
        f fVar18 = new f("Cp1250", 17, 21, "windows-1250");
        r = fVar18;
        f fVar19 = new f("Cp1251", 18, 22, "windows-1251");
        s = fVar19;
        f fVar20 = new f("Cp1252", 19, 23, "windows-1252");
        t = fVar20;
        f fVar21 = new f("Cp1256", 20, 24, "windows-1256");
        u = fVar21;
        f fVar22 = new f("UnicodeBigUnmarked", 21, 25, "UTF-16BE", "UnicodeBig");
        v = fVar22;
        Object[] objArr = new Object[1];
        G(new char[]{65513, 65524, 17, 16, 2}, 93 - View.MeasureSpec.getSize(0), 5 - TextUtils.getOffsetBefore("", 0), false, 2 - Color.red(0), objArr);
        f fVar23 = new f("UTF8", 22, 26, ((String) objArr[0]).intern());
        w = fVar23;
        f fVar24 = new f("ASCII", 23, new int[]{27, 170}, "US-ASCII");
        x = fVar24;
        f fVar25 = new f("Big5", 24, 28);
        y = fVar25;
        f fVar26 = new f("GB18030", 25, 29, StringUtils.GB2312, "EUC_CN", "GBK");
        z = fVar26;
        f fVar27 = new f("EUC_KR", 26, 30, "EUC-KR");
        A = fVar27;
        F = new f[]{fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7, fVar8, fVar9, fVar10, fVar11, fVar12, fVar13, fVar14, fVar15, fVar16, fVar17, fVar18, fVar19, fVar20, fVar21, fVar22, fVar23, fVar24, fVar25, fVar26, fVar27};
        D = new HashMap();
        E = new HashMap();
        f[] values = values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                return;
            }
            int i3 = getAuthRequestContext + 43;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            f fVar28 = values[i2];
            int[] iArr = fVar28.B;
            int length2 = iArr.length;
            int i5 = 0;
            while (true) {
                if (!(i5 < length2)) {
                    break;
                }
                D.put(Integer.valueOf(iArr[i5]), fVar28);
                i5++;
            }
            E.put(fVar28.name(), fVar28);
            String[] strArr = fVar28.C;
            int length3 = strArr.length;
            int i6 = 0;
            while (true) {
                if (!(i6 >= length3)) {
                    E.put(strArr[i6], fVar28);
                    i6++;
                    int i7 = getAuthRequestContext + 111;
                    BuiltInFictitiousFunctionClassFactory = i7 % 128;
                    int i8 = i7 % 2;
                }
            }
            i2++;
        }
    }

    private f(String str, int i2, int i3) {
        this(str, i2, new int[]{i3}, new String[0]);
    }

    private f(String str, int i2, int i3, String... strArr) {
        try {
            this.B = new int[]{i3};
            this.C = strArr;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private f(String str, int i2, int[] iArr, String... strArr) {
        this.B = iArr;
        this.C = strArr;
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        KClassImpl$Data$declaredNonStaticMembers$2 = 269894716;
    }

    public static f a(String str) {
        try {
            int i2 = BuiltInFictitiousFunctionClassFactory + 111;
            getAuthRequestContext = i2 % 128;
            int i3 = i2 % 2;
            try {
                f fVar = (f) E.get(str);
                int i4 = BuiltInFictitiousFunctionClassFactory + 37;
                getAuthRequestContext = i4 % 128;
                int i5 = i4 % 2;
                return fVar;
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    public static f valueOf(String str) {
        try {
            int i2 = getAuthRequestContext + 21;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
            f fVar = (f) Enum.valueOf(f.class, str);
            int i4 = getAuthRequestContext + 115;
            BuiltInFictitiousFunctionClassFactory = i4 % 128;
            int i5 = i4 % 2;
            return fVar;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static f[] values() {
        int i2 = BuiltInFictitiousFunctionClassFactory + 5;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        f[] fVarArr = (f[]) F.clone();
        int i4 = BuiltInFictitiousFunctionClassFactory + 73;
        getAuthRequestContext = i4 % 128;
        if ((i4 % 2 != 0 ? 'R' : '9') != 'R') {
            return fVarArr;
        }
        Object obj = null;
        obj.hashCode();
        return fVarArr;
    }

    public final int a() {
        int i2 = BuiltInFictitiousFunctionClassFactory + 95;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        int i4 = this.B[0];
        int i5 = getAuthRequestContext + 57;
        BuiltInFictitiousFunctionClassFactory = i5 % 128;
        if (i5 % 2 == 0) {
            Object[] objArr = null;
            int length = objArr.length;
            return i4;
        }
        return i4;
    }

    private static void G(char[] cArr, int i2, int i3, boolean z2, int i4, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i3];
        a2.MyBillsEntityDataFactory = 0;
        while (true) {
            if ((a2.MyBillsEntityDataFactory < i3 ? '\t' : (char) 19) != '\t') {
                break;
            }
            int i5 = $11 + 1;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            try {
                a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i2);
                int i7 = a2.MyBillsEntityDataFactory;
                cArr2[i7] = (char) (cArr2[i7] - ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ (-5694784870793460699L))));
                a2.MyBillsEntityDataFactory++;
            } catch (Exception e2) {
                throw e2;
            }
        }
        if ((i4 > 0 ? (char) 21 : (char) 15) == 21) {
            a2.BuiltInFictitiousFunctionClassFactory = i4;
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, 0, cArr3, 0, i3);
            System.arraycopy(cArr3, 0, cArr2, i3 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i3 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z2) {
            char[] cArr4 = new char[i3];
            a2.MyBillsEntityDataFactory = 0;
            int i8 = $11 + 47;
            $10 = i8 % 128;
            int i9 = i8 % 2;
            while (true) {
                if (!(a2.MyBillsEntityDataFactory < i3)) {
                    break;
                }
                int i10 = $11 + 5;
                $10 = i10 % 128;
                int i11 = i10 % 2;
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i3 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
