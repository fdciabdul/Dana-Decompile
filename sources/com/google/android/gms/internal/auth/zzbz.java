package com.google.android.gms.internal.auth;

import android.graphics.Color;
import android.text.TextUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import id.dana.kyb.constant.KybServiceRedirectType;
import java.io.UnsupportedEncodingException;
import o.A;

/* loaded from: classes7.dex */
public abstract class zzbz extends FastSafeParcelableJsonResponse {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int PlaceComponentResult = 0;
    private static int getAuthRequestContext = 269894821;

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final byte[] toByteArray() {
        String zzbzVar;
        String intern;
        int i = PlaceComponentResult + 107;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        try {
            if ((i % 2 == 0 ? '%' : 'G') != '%') {
                zzbzVar = toString();
                Object[] objArr = new Object[1];
                a(new char[]{2, 65513, 65524, 17, 16}, (-16777020) - Color.rgb(0, 0, 0), 5 - Color.red(0), false, 2 - TextUtils.indexOf((CharSequence) "", '0'), objArr);
                intern = ((String) objArr[0]).intern();
            } else {
                zzbzVar = toString();
                Object[] objArr2 = new Object[1];
                a(new char[]{2, 65513, 65524, 17, 16}, (-16777020) - Color.rgb(1, 0, 1), 2 << Color.red(1), true, 4 % TextUtils.indexOf((CharSequence) "", (char) 18), objArr2);
                intern = ((String) objArr2[0]).intern();
            }
            byte[] bytes = zzbzVar.getBytes(intern);
            int i2 = BuiltInFictitiousFunctionClassFactory + 93;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
            return bytes;
        } catch (UnsupportedEncodingException e) {
            InstrumentInjector.log_e(KybServiceRedirectType.AUTH, "Error serializing object.", e);
            return null;
        }
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        char[] cArr2;
        A a2 = new A();
        char[] cArr3 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i2) {
            int i4 = $10 + 57;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            try {
                a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                cArr3[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                int i6 = a2.MyBillsEntityDataFactory;
                cArr3[i6] = (char) (cArr3[i6] - ((int) (getAuthRequestContext ^ (-5694784870793460699L))));
                a2.MyBillsEntityDataFactory++;
            } catch (Exception e) {
                throw e;
            }
        }
        if (i3 > 0) {
            int i7 = $10 + 121;
            $11 = i7 % 128;
            int i8 = i7 % 2;
            a2.BuiltInFictitiousFunctionClassFactory = i3;
            char[] cArr4 = new char[i2];
            System.arraycopy(cArr3, 0, cArr4, 0, i2);
            System.arraycopy(cArr4, 0, cArr3, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr4, a2.BuiltInFictitiousFunctionClassFactory, cArr3, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (!(!z)) {
            int i9 = $11 + 67;
            $10 = i9 % 128;
            if (!(i9 % 2 == 0)) {
                cArr2 = new char[i2];
                a2.MyBillsEntityDataFactory = 1;
            } else {
                cArr2 = new char[i2];
                a2.MyBillsEntityDataFactory = 0;
            }
            while (a2.MyBillsEntityDataFactory < i2) {
                cArr2[a2.MyBillsEntityDataFactory] = cArr3[(i2 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
            }
            cArr3 = cArr2;
        }
        objArr[0] = new String(cArr3);
    }
}
