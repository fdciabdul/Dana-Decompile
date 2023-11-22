package io.branch.referral;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import o.A;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class BranchPreinstall {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int MyBillsEntityDataFactory = 0;
    private static int PlaceComponentResult = 1;
    private static int getAuthRequestContext = 269894700;

    BranchPreinstall() {
    }

    public static void BuiltInFictitiousFunctionClassFactory(Branch branch, Context context) {
        String BuiltInFictitiousFunctionClassFactory;
        int i = MyBillsEntityDataFactory + 67;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        if (branch != null) {
            int i3 = PlaceComponentResult + 73;
            MyBillsEntityDataFactory = i3 % 128;
            if (i3 % 2 != 0) {
                try {
                    BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
                    boolean isEmpty = TextUtils.isEmpty(BuiltInFictitiousFunctionClassFactory);
                    Object obj = null;
                    obj.hashCode();
                    if (!(!isEmpty)) {
                        return;
                    }
                } catch (Exception e) {
                    throw e;
                }
            } else {
                BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
                if ((!TextUtils.isEmpty(BuiltInFictitiousFunctionClassFactory) ? (char) 24 : 'c') == 'c') {
                    return;
                }
            }
            try {
                BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, branch, context);
                int i4 = PlaceComponentResult + 13;
                MyBillsEntityDataFactory = i4 % 128;
                int i5 = i4 % 2;
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private static String BuiltInFictitiousFunctionClassFactory() {
        Object invoke;
        int i = PlaceComponentResult + 93;
        MyBillsEntityDataFactory = i % 128;
        try {
            if (!(i % 2 == 0)) {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                Class<?>[] clsArr = new Class[0];
                clsArr[0] = String.class;
                Method method = cls.getMethod("get", clsArr);
                Object[] objArr = new Object[0];
                objArr[1] = "io.branch.preinstall.apps.path";
                invoke = method.invoke(null, objArr);
            } else {
                invoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, "io.branch.preinstall.apps.path");
            }
            return (String) invoke;
        } catch (Exception unused) {
            return null;
        }
    }

    private static void BuiltInFictitiousFunctionClassFactory(final String str, final Branch branch, final Context context) {
        new Thread(new Runnable() { // from class: io.branch.referral.BranchPreinstall.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(str)));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    bufferedReader.close();
                    JSONObject jSONObject = new JSONObject(sb.toString().trim());
                    if (!TextUtils.isEmpty(jSONObject.toString())) {
                        BranchPreinstall.getAuthRequestContext(jSONObject, branch, context);
                        return;
                    }
                    throw new FileNotFoundException();
                } catch (FileNotFoundException | IOException | JSONException unused) {
                }
            }
        }).start();
        try {
            int i = PlaceComponentResult + 123;
            MyBillsEntityDataFactory = i % 128;
            if ((i % 2 != 0 ? '1' : (char) 5) != 5) {
                int i2 = 72 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x014a A[Catch: JSONException -> 0x0180, TryCatch #3 {JSONException -> 0x0180, blocks: (B:14:0x0035, B:20:0x007c, B:22:0x0084, B:31:0x00a7, B:32:0x00b7, B:38:0x00cc, B:45:0x00e4, B:47:0x00f6, B:59:0x013e, B:61:0x014a, B:63:0x015e, B:64:0x0171, B:55:0x010f, B:58:0x012c, B:53:0x00fd, B:37:0x00bc), top: B:78:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0123 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0171 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x013e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void getAuthRequestContext(org.json.JSONObject r16, io.branch.referral.Branch r17, android.content.Context r18) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.BranchPreinstall.getAuthRequestContext(org.json.JSONObject, io.branch.referral.Branch, android.content.Context):void");
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        int i4;
        A a2 = new A();
        char[] cArr2 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        int i5 = $10 + 99;
        $11 = i5 % 128;
        int i6 = i5 % 2;
        while (a2.MyBillsEntityDataFactory < i2) {
            try {
                int i7 = $11 + 93;
                $10 = i7 % 128;
                int i8 = i7 % 2;
                a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                int i9 = a2.MyBillsEntityDataFactory;
                cArr2[i9] = (char) (cArr2[i9] - ((int) (getAuthRequestContext ^ (-5694784870793460699L))));
                a2.MyBillsEntityDataFactory++;
            } catch (Exception e) {
                throw e;
            }
        }
        if ((i3 > 0 ? (char) 14 : '^') == 14) {
            int i10 = $10 + 115;
            $11 = i10 % 128;
            int i11 = i10 % 2;
            a2.BuiltInFictitiousFunctionClassFactory = i3;
            char[] cArr3 = new char[i2];
            System.arraycopy(cArr2, 0, cArr3, 0, i2);
            System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z) {
            int i12 = $10 + 63;
            $11 = i12 % 128;
            int i13 = i12 % 2;
            char[] cArr4 = new char[i2];
            a2.MyBillsEntityDataFactory = 0;
            while (true) {
                if (a2.MyBillsEntityDataFactory >= i2) {
                    break;
                }
                int i14 = $10 + 119;
                $11 = i14 % 128;
                if (i14 % 2 != 0) {
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                    i4 = a2.MyBillsEntityDataFactory + 1;
                } else {
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 >> a2.MyBillsEntityDataFactory) % 0];
                    i4 = a2.MyBillsEntityDataFactory % 1;
                }
                a2.MyBillsEntityDataFactory = i4;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
