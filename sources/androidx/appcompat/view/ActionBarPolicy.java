package androidx.appcompat.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ViewConfiguration;
import androidx.appcompat.R;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* loaded from: classes.dex */
public class ActionBarPolicy {
    public static final byte[] MyBillsEntityDataFactory = {79, Ascii.DC4, Ascii.EM, -22, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4, 6, Ascii.ETB, -43, TarHeader.LF_CONTIG, 8, 4, 5, 2, 6, Ascii.ESC, -3, 14, 7, -29, 45, 0, 17};
    public static final int getAuthRequestContext = 229;
    public Context PlaceComponentResult;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 6
            int r8 = r8 + 97
            int r9 = r9 * 22
            int r9 = 25 - r9
            byte[] r0 = androidx.appcompat.view.ActionBarPolicy.MyBillsEntityDataFactory
            int r7 = r7 * 5
            int r7 = r7 + 18
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L33
        L19:
            r3 = 0
        L1a:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            int r9 = r9 + 1
            r1[r3] = r5
            if (r4 != r7) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r9]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L33:
            int r8 = r8 + r9
            int r8 = r8 + (-8)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.ActionBarPolicy.a(byte, byte, short, java.lang.Object[]):void");
    }

    public static ActionBarPolicy PlaceComponentResult(Context context) {
        return new ActionBarPolicy(context);
    }

    private ActionBarPolicy(Context context) {
        this.PlaceComponentResult = context;
    }

    public final int getAuthRequestContext() {
        Configuration configuration = this.PlaceComponentResult.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600) {
            return 5;
        }
        if (i <= 960 || i2 <= 720) {
            if (i <= 720 || i2 <= 960) {
                if (i < 500) {
                    if (i <= 640 || i2 <= 480) {
                        if (i <= 480 || i2 <= 640) {
                            return i >= 360 ? 3 : 2;
                        }
                        return 4;
                    }
                    return 4;
                }
                return 4;
            }
            return 5;
        }
        return 5;
    }

    public final boolean MyBillsEntityDataFactory() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.PlaceComponentResult).hasPermanentMenuKey();
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult.getResources().getBoolean(R.bool.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public final int PlaceComponentResult() {
        TypedArray obtainStyledAttributes = this.PlaceComponentResult.obtainStyledAttributes(null, R.styleable.KClassImpl$Data$declaredNonStaticMembers$2, R.attr.KClassImpl$Data$declaredNonStaticMembers$2, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda1, 0);
        Resources resources = this.PlaceComponentResult.getResources();
        if (!KClassImpl$Data$declaredNonStaticMembers$2()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R.dimen.getAuthRequestContext));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        Context context = this.PlaceComponentResult;
        try {
            byte b = (byte) (getAuthRequestContext & 3);
            byte b2 = MyBillsEntityDataFactory[41];
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 + 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = MyBillsEntityDataFactory[41];
            Object[] objArr2 = new Object[1];
            a(b3, (byte) (b3 + 1), MyBillsEntityDataFactory[41], objArr2);
            return ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).targetSdkVersion < 14;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
