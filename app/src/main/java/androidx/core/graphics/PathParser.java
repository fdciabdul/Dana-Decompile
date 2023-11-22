package androidx.core.graphics;

import android.graphics.Path;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PathParser {
    static float[] KClassImpl$Data$declaredNonStaticMembers$2(float[] fArr, int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i2 = i - 0;
        int min = Math.min(i2, length - 0);
        float[] fArr2 = new float[i2];
        System.arraycopy(fArr, 0, fArr2, 0, min);
        return fArr2;
    }

    public static Path MyBillsEntityDataFactory(String str) {
        Path path = new Path();
        PathDataNode[] KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(str);
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            try {
                PathDataNode.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2, path);
                return path;
            } catch (RuntimeException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error in parsing ");
                sb.append(str);
                throw new RuntimeException(sb.toString(), e);
            }
        }
        return null;
    }

    public static PathDataNode[] KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                    break;
                }
                i++;
            }
            String trim = str.substring(i2, i).trim();
            if (trim.length() > 0) {
                arrayList.add(new PathDataNode(trim.charAt(0), getAuthRequestContext(trim)));
            }
            i2 = i;
            i++;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            arrayList.add(new PathDataNode(str.charAt(i2), new float[0]));
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[arrayList.size()]);
    }

    public static PathDataNode[] PlaceComponentResult(PathDataNode[] pathDataNodeArr) {
        if (pathDataNodeArr == null) {
            return null;
        }
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr2[i] = new PathDataNode(pathDataNodeArr[i]);
        }
        return pathDataNodeArr2;
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            if (pathDataNodeArr[i].getAuthRequestContext != pathDataNodeArr2[i].getAuthRequestContext || pathDataNodeArr[i].BuiltInFictitiousFunctionClassFactory.length != pathDataNodeArr2[i].BuiltInFictitiousFunctionClassFactory.length) {
                return false;
            }
        }
        return true;
    }

    public static void BuiltInFictitiousFunctionClassFactory(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i = 0; i < pathDataNodeArr2.length; i++) {
            pathDataNodeArr[i].getAuthRequestContext = pathDataNodeArr2[i].getAuthRequestContext;
            for (int i2 = 0; i2 < pathDataNodeArr2[i].BuiltInFictitiousFunctionClassFactory.length; i2++) {
                pathDataNodeArr[i].BuiltInFictitiousFunctionClassFactory[i2] = pathDataNodeArr2[i].BuiltInFictitiousFunctionClassFactory[i2];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ExtractFloatResult {
        int MyBillsEntityDataFactory;
        boolean getAuthRequestContext;

        ExtractFloatResult() {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005b A[Catch: NumberFormatException -> 0x007e, LOOP:1: B:9:0x002b->B:29:0x005b, LOOP_END, TryCatch #0 {NumberFormatException -> 0x007e, blocks: (B:6:0x0011, B:8:0x0025, B:9:0x002b, B:11:0x0031, B:17:0x0041, B:29:0x005b, B:21:0x0049, B:24:0x0050, B:30:0x005e, B:32:0x0064, B:33:0x0070, B:36:0x0076, B:37:0x0079), top: B:44:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0064 A[Catch: NumberFormatException -> 0x007e, TryCatch #0 {NumberFormatException -> 0x007e, blocks: (B:6:0x0011, B:8:0x0025, B:9:0x002b, B:11:0x0031, B:17:0x0041, B:29:0x005b, B:21:0x0049, B:24:0x0050, B:30:0x005e, B:32:0x0064, B:33:0x0070, B:36:0x0076, B:37:0x0079), top: B:44:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0076 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0074 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x005e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static float[] getAuthRequestContext(java.lang.String r13) {
        /*
            r0 = 0
            char r1 = r13.charAt(r0)
            r2 = 122(0x7a, float:1.71E-43)
            if (r1 == r2) goto L9b
            char r1 = r13.charAt(r0)
            r2 = 90
            if (r1 == r2) goto L9b
            int r1 = r13.length()     // Catch: java.lang.NumberFormatException -> L7e
            float[] r1 = new float[r1]     // Catch: java.lang.NumberFormatException -> L7e
            androidx.core.graphics.PathParser$ExtractFloatResult r2 = new androidx.core.graphics.PathParser$ExtractFloatResult     // Catch: java.lang.NumberFormatException -> L7e
            r2.<init>()     // Catch: java.lang.NumberFormatException -> L7e
            int r3 = r13.length()     // Catch: java.lang.NumberFormatException -> L7e
            r4 = 1
            r5 = 1
            r6 = 0
        L23:
            if (r5 >= r3) goto L79
            r2.getAuthRequestContext = r0     // Catch: java.lang.NumberFormatException -> L7e
            r7 = r5
            r8 = 0
            r9 = 0
            r10 = 0
        L2b:
            int r11 = r13.length()     // Catch: java.lang.NumberFormatException -> L7e
            if (r7 >= r11) goto L5e
            char r11 = r13.charAt(r7)     // Catch: java.lang.NumberFormatException -> L7e
            r12 = 32
            if (r11 == r12) goto L57
            r12 = 69
            if (r11 == r12) goto L55
            r12 = 101(0x65, float:1.42E-43)
            if (r11 == r12) goto L55
            switch(r11) {
                case 44: goto L57;
                case 45: goto L4c;
                case 46: goto L45;
                default: goto L44;
            }     // Catch: java.lang.NumberFormatException -> L7e
        L44:
            goto L53
        L45:
            if (r8 != 0) goto L49
            r8 = 1
            goto L53
        L49:
            r2.getAuthRequestContext = r4     // Catch: java.lang.NumberFormatException -> L7e
            goto L57
        L4c:
            if (r7 == r5) goto L53
            if (r9 != 0) goto L53
            r2.getAuthRequestContext = r4     // Catch: java.lang.NumberFormatException -> L7e
            goto L57
        L53:
            r9 = 0
            goto L59
        L55:
            r9 = 1
            goto L59
        L57:
            r9 = 0
            r10 = 1
        L59:
            if (r10 != 0) goto L5e
            int r7 = r7 + 1
            goto L2b
        L5e:
            r2.MyBillsEntityDataFactory = r7     // Catch: java.lang.NumberFormatException -> L7e
            int r7 = r2.MyBillsEntityDataFactory     // Catch: java.lang.NumberFormatException -> L7e
            if (r5 >= r7) goto L70
            java.lang.String r5 = r13.substring(r5, r7)     // Catch: java.lang.NumberFormatException -> L7e
            float r5 = java.lang.Float.parseFloat(r5)     // Catch: java.lang.NumberFormatException -> L7e
            r1[r6] = r5     // Catch: java.lang.NumberFormatException -> L7e
            int r6 = r6 + 1
        L70:
            boolean r5 = r2.getAuthRequestContext     // Catch: java.lang.NumberFormatException -> L7e
            if (r5 == 0) goto L76
            r5 = r7
            goto L23
        L76:
            int r5 = r7 + 1
            goto L23
        L79:
            float[] r13 = KClassImpl$Data$declaredNonStaticMembers$2(r1, r6)     // Catch: java.lang.NumberFormatException -> L7e
            return r13
        L7e:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "error in parsing \""
            r1.append(r2)
            r1.append(r13)
            java.lang.String r13 = "\""
            r1.append(r13)
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r1 = r1.toString()
            r13.<init>(r1, r0)
            throw r13
        L9b:
            float[] r13 = new float[r0]
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.getAuthRequestContext(java.lang.String):float[]");
    }

    /* loaded from: classes.dex */
    public static class PathDataNode {
        public float[] BuiltInFictitiousFunctionClassFactory;
        public char getAuthRequestContext;

        PathDataNode(char c, float[] fArr) {
            this.getAuthRequestContext = c;
            this.BuiltInFictitiousFunctionClassFactory = fArr;
        }

        PathDataNode(PathDataNode pathDataNode) {
            this.getAuthRequestContext = pathDataNode.getAuthRequestContext;
            float[] fArr = pathDataNode.BuiltInFictitiousFunctionClassFactory;
            this.BuiltInFictitiousFunctionClassFactory = PathParser.KClassImpl$Data$declaredNonStaticMembers$2(fArr, fArr.length);
        }

        public static void MyBillsEntityDataFactory(PathDataNode[] pathDataNodeArr, Path path) {
            int i;
            int i2;
            float[] fArr;
            char c;
            int i3;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            float f18;
            PathDataNode[] pathDataNodeArr2 = pathDataNodeArr;
            float[] fArr2 = new float[6];
            char c2 = 'm';
            char c3 = 0;
            char c4 = 'm';
            int i4 = 0;
            while (i4 < pathDataNodeArr2.length) {
                PathDataNode pathDataNode = pathDataNodeArr2[i4];
                char c5 = pathDataNode.getAuthRequestContext;
                float[] fArr3 = pathDataNode.BuiltInFictitiousFunctionClassFactory;
                float f19 = fArr2[c3];
                float f20 = fArr2[1];
                float f21 = fArr2[2];
                float f22 = fArr2[3];
                float f23 = fArr2[4];
                float f24 = fArr2[5];
                switch (c5) {
                    case 'A':
                    case 'a':
                        i = 7;
                        break;
                    case 'C':
                    case 'c':
                        i = 6;
                        break;
                    case 'H':
                    case 'V':
                    case 'h':
                    case 'v':
                        i = 1;
                        break;
                    case 'Q':
                    case 'S':
                    case 'q':
                    case 's':
                        i = 4;
                        break;
                    case 'Z':
                    case 'z':
                        path.close();
                        path.moveTo(f23, f24);
                        f19 = f23;
                        f21 = f19;
                        f20 = f24;
                        f22 = f20;
                    default:
                        i = 2;
                        break;
                }
                float f25 = f23;
                float f26 = f24;
                float f27 = f19;
                float f28 = f20;
                int i5 = 0;
                while (i5 < fArr3.length) {
                    if (c5 != 'A') {
                        if (c5 != 'C') {
                            if (c5 == 'H') {
                                i2 = i5;
                                fArr = fArr3;
                                c = c5;
                                i3 = i4;
                                int i6 = i2 + 0;
                                path.lineTo(fArr[i6], f28);
                                f27 = fArr[i6];
                            } else if (c5 == 'Q') {
                                i2 = i5;
                                fArr = fArr3;
                                c = c5;
                                i3 = i4;
                                int i7 = i2 + 0;
                                int i8 = i2 + 1;
                                int i9 = i2 + 2;
                                int i10 = i2 + 3;
                                path.quadTo(fArr[i7], fArr[i8], fArr[i9], fArr[i10]);
                                f = fArr[i7];
                                f2 = fArr[i8];
                                f27 = fArr[i9];
                                f28 = fArr[i10];
                            } else if (c5 == 'V') {
                                i2 = i5;
                                fArr = fArr3;
                                c = c5;
                                i3 = i4;
                                int i11 = i2 + 0;
                                path.lineTo(f27, fArr[i11]);
                                f28 = fArr[i11];
                            } else if (c5 != 'a') {
                                if (c5 != 'c') {
                                    if (c5 == 'h') {
                                        i2 = i5;
                                        int i12 = i2 + 0;
                                        path.rLineTo(fArr3[i12], 0.0f);
                                        f27 += fArr3[i12];
                                    } else if (c5 != 'q') {
                                        if (c5 == 'v') {
                                            i2 = i5;
                                            f9 = f28;
                                            int i13 = i2 + 0;
                                            path.rLineTo(0.0f, fArr3[i13]);
                                            f10 = fArr3[i13];
                                        } else if (c5 == 'L') {
                                            i2 = i5;
                                            int i14 = i2 + 0;
                                            int i15 = i2 + 1;
                                            path.lineTo(fArr3[i14], fArr3[i15]);
                                            f27 = fArr3[i14];
                                            f28 = fArr3[i15];
                                        } else if (c5 == 'M') {
                                            i2 = i5;
                                            f27 = fArr3[i2 + 0];
                                            f28 = fArr3[i2 + 1];
                                            if (i2 > 0) {
                                                path.lineTo(f27, f28);
                                            } else {
                                                path.moveTo(f27, f28);
                                                f26 = f28;
                                                f25 = f27;
                                            }
                                        } else if (c5 == 'S') {
                                            i2 = i5;
                                            float f29 = f28;
                                            float f30 = f27;
                                            if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                                f11 = (f29 * 2.0f) - f22;
                                                f12 = (f30 * 2.0f) - f21;
                                            } else {
                                                f12 = f30;
                                                f11 = f29;
                                            }
                                            int i16 = i2 + 0;
                                            int i17 = i2 + 1;
                                            int i18 = i2 + 2;
                                            int i19 = i2 + 3;
                                            path.cubicTo(f12, f11, fArr3[i16], fArr3[i17], fArr3[i18], fArr3[i19]);
                                            f8 = fArr3[i16];
                                            f7 = fArr3[i17];
                                            f27 = fArr3[i18];
                                            f28 = fArr3[i19];
                                            f21 = f8;
                                            f22 = f7;
                                        } else if (c5 == 'T') {
                                            i2 = i5;
                                            float f31 = f28;
                                            float f32 = f27;
                                            if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                                f13 = (f32 * 2.0f) - f21;
                                                f14 = (f31 * 2.0f) - f22;
                                            } else {
                                                f13 = f32;
                                                f14 = f31;
                                            }
                                            int i20 = i2 + 0;
                                            int i21 = i2 + 1;
                                            path.quadTo(f13, f14, fArr3[i20], fArr3[i21]);
                                            f22 = f14;
                                            f21 = f13;
                                            fArr = fArr3;
                                            c = c5;
                                            i3 = i4;
                                            f27 = fArr3[i20];
                                            f28 = fArr3[i21];
                                        } else if (c5 == 'l') {
                                            i2 = i5;
                                            f9 = f28;
                                            int i22 = i2 + 0;
                                            int i23 = i2 + 1;
                                            path.rLineTo(fArr3[i22], fArr3[i23]);
                                            f27 += fArr3[i22];
                                            f10 = fArr3[i23];
                                        } else if (c5 == c2) {
                                            i2 = i5;
                                            float f33 = fArr3[i2 + 0];
                                            f27 += f33;
                                            float f34 = fArr3[i2 + 1];
                                            f28 += f34;
                                            if (i2 > 0) {
                                                path.rLineTo(f33, f34);
                                            } else {
                                                path.rMoveTo(f33, f34);
                                                f26 = f28;
                                                f25 = f27;
                                            }
                                        } else if (c5 == 's') {
                                            if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                                f15 = f27 - f21;
                                                f16 = f28 - f22;
                                            } else {
                                                f15 = 0.0f;
                                                f16 = 0.0f;
                                            }
                                            int i24 = i5 + 0;
                                            int i25 = i5 + 1;
                                            int i26 = i5 + 2;
                                            int i27 = i5 + 3;
                                            i2 = i5;
                                            f3 = f28;
                                            float f35 = f27;
                                            path.rCubicTo(f15, f16, fArr3[i24], fArr3[i25], fArr3[i26], fArr3[i27]);
                                            f4 = fArr3[i24] + f35;
                                            f5 = fArr3[i25] + f3;
                                            f27 = f35 + fArr3[i26];
                                            f6 = fArr3[i27];
                                        } else if (c5 == 't') {
                                            if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                                f17 = f27 - f21;
                                                f18 = f28 - f22;
                                            } else {
                                                f18 = 0.0f;
                                                f17 = 0.0f;
                                            }
                                            int i28 = i5 + 0;
                                            int i29 = i5 + 1;
                                            path.rQuadTo(f17, f18, fArr3[i28], fArr3[i29]);
                                            float f36 = fArr3[i28] + f27;
                                            float f37 = fArr3[i29] + f28;
                                            float f38 = f17 + f27;
                                            f22 = f18 + f28;
                                            f27 = f36;
                                            i2 = i5;
                                            f28 = f37;
                                            fArr = fArr3;
                                            c = c5;
                                            i3 = i4;
                                            f21 = f38;
                                        } else {
                                            i2 = i5;
                                        }
                                        f28 = f9 + f10;
                                    } else {
                                        i2 = i5;
                                        f3 = f28;
                                        float f39 = f27;
                                        int i30 = i2 + 0;
                                        int i31 = i2 + 1;
                                        int i32 = i2 + 2;
                                        int i33 = i2 + 3;
                                        path.rQuadTo(fArr3[i30], fArr3[i31], fArr3[i32], fArr3[i33]);
                                        f4 = fArr3[i30] + f39;
                                        f5 = fArr3[i31] + f3;
                                        float f40 = f39 + fArr3[i32];
                                        float f41 = fArr3[i33];
                                        f27 = f40;
                                        f6 = f41;
                                    }
                                    fArr = fArr3;
                                    c = c5;
                                    i3 = i4;
                                } else {
                                    i2 = i5;
                                    f3 = f28;
                                    float f42 = f27;
                                    int i34 = i2 + 2;
                                    int i35 = i2 + 3;
                                    int i36 = i2 + 4;
                                    int i37 = i2 + 5;
                                    path.rCubicTo(fArr3[i2 + 0], fArr3[i2 + 1], fArr3[i34], fArr3[i35], fArr3[i36], fArr3[i37]);
                                    f4 = fArr3[i34] + f42;
                                    f5 = fArr3[i35] + f3;
                                    f27 = f42 + fArr3[i36];
                                    f6 = fArr3[i37];
                                }
                                f28 = f3 + f6;
                                f8 = f4;
                                f7 = f5;
                                f21 = f8;
                                f22 = f7;
                                fArr = fArr3;
                                c = c5;
                                i3 = i4;
                            } else {
                                i2 = i5;
                                float f43 = f28;
                                float f44 = f27;
                                int i38 = i2 + 5;
                                int i39 = i2 + 6;
                                fArr = fArr3;
                                c = c5;
                                i3 = i4;
                                BuiltInFictitiousFunctionClassFactory(path, f44, f43, fArr3[i38] + f44, fArr3[i39] + f43, fArr3[i2 + 0], fArr3[i2 + 1], fArr3[i2 + 2], fArr3[i2 + 3] != 0.0f, fArr3[i2 + 4] != 0.0f);
                                f27 = f44 + fArr[i38];
                                f28 = f43 + fArr[i39];
                            }
                            i5 = i2 + i;
                            c2 = 'm';
                            c4 = c;
                            c5 = c4;
                            fArr3 = fArr;
                            i4 = i3;
                        } else {
                            i2 = i5;
                            fArr = fArr3;
                            c = c5;
                            i3 = i4;
                            int i40 = i2 + 2;
                            int i41 = i2 + 3;
                            int i42 = i2 + 4;
                            int i43 = i2 + 5;
                            path.cubicTo(fArr[i2 + 0], fArr[i2 + 1], fArr[i40], fArr[i41], fArr[i42], fArr[i43]);
                            f27 = fArr[i42];
                            f28 = fArr[i43];
                            f = fArr[i40];
                            f2 = fArr[i41];
                        }
                        f21 = f;
                        f22 = f2;
                        i5 = i2 + i;
                        c2 = 'm';
                        c4 = c;
                        c5 = c4;
                        fArr3 = fArr;
                        i4 = i3;
                    } else {
                        i2 = i5;
                        fArr = fArr3;
                        c = c5;
                        i3 = i4;
                        int i44 = i2 + 5;
                        int i45 = i2 + 6;
                        BuiltInFictitiousFunctionClassFactory(path, f27, f28, fArr[i44], fArr[i45], fArr[i2 + 0], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3] != 0.0f, fArr[i2 + 4] != 0.0f);
                        f27 = fArr[i44];
                        f28 = fArr[i45];
                    }
                    f22 = f28;
                    f21 = f27;
                    i5 = i2 + i;
                    c2 = 'm';
                    c4 = c;
                    c5 = c4;
                    fArr3 = fArr;
                    i4 = i3;
                }
                int i46 = i4;
                fArr2[0] = f27;
                fArr2[1] = f28;
                fArr2[2] = f21;
                fArr2[3] = f22;
                fArr2[4] = f25;
                fArr2[5] = f26;
                i4 = i46 + 1;
                c4 = pathDataNodeArr[i46].getAuthRequestContext;
                c2 = 'm';
                c3 = 0;
                pathDataNodeArr2 = pathDataNodeArr;
            }
        }

        private static void BuiltInFictitiousFunctionClassFactory(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            float f8 = f;
            float f9 = f3;
            float f10 = f5;
            float f11 = f6;
            float f12 = f7;
            while (true) {
                double radians = Math.toRadians(f12);
                double cos = Math.cos(radians);
                double sin = Math.sin(radians);
                double d3 = f8;
                double d4 = f2;
                double d5 = f10;
                Double.isNaN(d3);
                Double.isNaN(d4);
                Double.isNaN(d5);
                double d6 = ((d3 * cos) + (d4 * sin)) / d5;
                double d7 = d3;
                double d8 = -f8;
                float f13 = f10;
                double d9 = f11;
                Double.isNaN(d8);
                Double.isNaN(d4);
                Double.isNaN(d9);
                double d10 = ((d8 * sin) + (d4 * cos)) / d9;
                double d11 = d4;
                double d12 = f9;
                double d13 = f4;
                Double.isNaN(d12);
                Double.isNaN(d13);
                Double.isNaN(d5);
                double d14 = ((d12 * cos) + (d13 * sin)) / d5;
                double d15 = -f9;
                Double.isNaN(d15);
                Double.isNaN(d13);
                Double.isNaN(d9);
                double d16 = ((d15 * sin) + (d13 * cos)) / d9;
                double d17 = d6 - d14;
                double d18 = d10 - d16;
                double d19 = (d6 + d14) / 2.0d;
                double d20 = (d10 + d16) / 2.0d;
                double d21 = (d17 * d17) + (d18 * d18);
                if (d21 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    InstrumentInjector.log_w("PathParser", " Points are coincident");
                    return;
                }
                double d22 = (1.0d / d21) - 0.25d;
                if (d22 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Points are too far apart ");
                    sb.append(d21);
                    InstrumentInjector.log_w("PathParser", sb.toString());
                    float sqrt = (float) (Math.sqrt(d21) / 1.99999d);
                    f10 = f13 * sqrt;
                    f11 *= sqrt;
                    f8 = f;
                    f9 = f3;
                    f12 = f7;
                } else {
                    double sqrt2 = Math.sqrt(d22);
                    double d23 = d17 * sqrt2;
                    double d24 = sqrt2 * d18;
                    if (z == z2) {
                        d = d19 - d24;
                        d2 = d20 + d23;
                    } else {
                        d = d19 + d24;
                        d2 = d20 - d23;
                    }
                    double atan2 = Math.atan2(d10 - d2, d6 - d);
                    double atan22 = Math.atan2(d16 - d2, d14 - d) - atan2;
                    if (z2 != (atan22 >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
                        atan22 = atan22 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
                    }
                    Double.isNaN(d5);
                    double d25 = d * d5;
                    Double.isNaN(d9);
                    double d26 = d2 * d9;
                    double d27 = (d25 * cos) - (d26 * sin);
                    double d28 = (d25 * sin) + (d26 * cos);
                    int ceil = (int) Math.ceil(Math.abs((atan22 * 4.0d) / 3.141592653589793d));
                    double cos2 = Math.cos(radians);
                    double sin2 = Math.sin(radians);
                    double cos3 = Math.cos(atan2);
                    double sin3 = Math.sin(atan2);
                    Double.isNaN(d5);
                    double d29 = -d5;
                    double d30 = d29 * cos2;
                    Double.isNaN(d9);
                    double d31 = d9 * sin2;
                    double d32 = d29 * sin2;
                    Double.isNaN(d9);
                    double d33 = d9 * cos2;
                    double d34 = ceil;
                    Double.isNaN(d34);
                    double d35 = atan22 / d34;
                    double d36 = (sin3 * d32) + (cos3 * d33);
                    double d37 = (sin3 * d30) - (cos3 * d31);
                    double d38 = d36;
                    int i = 0;
                    while (i < ceil) {
                        double d39 = atan2 + d35;
                        double sin4 = Math.sin(d39);
                        double cos4 = Math.cos(d39);
                        Double.isNaN(d5);
                        double d40 = d35;
                        double d41 = (d27 + ((d5 * cos2) * cos4)) - (d31 * sin4);
                        Double.isNaN(d5);
                        double d42 = cos2;
                        double d43 = d28 + (d5 * sin2 * cos4) + (d33 * sin4);
                        double d44 = (d30 * sin4) - (d31 * cos4);
                        double d45 = (sin4 * d32) + (cos4 * d33);
                        double d46 = d39 - atan2;
                        double tan = Math.tan(d46 / 2.0d);
                        double sin5 = (Math.sin(d46) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                        path.rLineTo(0.0f, 0.0f);
                        path.cubicTo((float) (d7 + (d37 * sin5)), (float) (d11 + (d38 * sin5)), (float) (d41 - (sin5 * d44)), (float) (d43 - (sin5 * d45)), (float) d41, (float) d43);
                        i++;
                        d32 = d32;
                        d7 = d41;
                        ceil = ceil;
                        d11 = d43;
                        atan2 = d39;
                        d38 = d45;
                        d37 = d44;
                        d35 = d40;
                        cos2 = d42;
                    }
                    return;
                }
            }
        }
    }

    private PathParser() {
    }
}
