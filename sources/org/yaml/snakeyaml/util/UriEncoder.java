package org.yaml.snakeyaml.util;

import android.text.TextUtils;
import android.view.View;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import o.whenAvailable;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.external.com.google.gdata.util.common.base.Escaper;
import org.yaml.snakeyaml.external.com.google.gdata.util.common.base.PercentEscaper;

/* loaded from: classes6.dex */
public abstract class UriEncoder {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final CharsetDecoder BuiltInFictitiousFunctionClassFactory;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static char[] MyBillsEntityDataFactory = null;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static final Escaper PlaceComponentResult;
    private static long getAuthRequestContext;

    static void PlaceComponentResult() {
        MyBillsEntityDataFactory = new char[]{62235, 51172, 39668, 28057, 8334};
        getAuthRequestContext = 7903134486126184368L;
    }

    static {
        try {
            PlaceComponentResult();
            try {
                BuiltInFictitiousFunctionClassFactory = StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT);
                PlaceComponentResult = new PercentEscaper("-_.!~*'()@:$&,;=[]/");
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 11;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                if ((i % 2 == 0 ? 'M' : (char) 22) != 22) {
                    Object obj = null;
                    obj.hashCode();
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 93;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            String authRequestContext = PlaceComponentResult.getAuthRequestContext(str);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 69;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if ((i3 % 2 != 0 ? '*' : ';') != '*') {
                return authRequestContext;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return authRequestContext;
        } catch (Exception e) {
            throw e;
        }
    }

    public static String MyBillsEntityDataFactory(ByteBuffer byteBuffer) throws CharacterCodingException {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 63;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
            String obj = BuiltInFictitiousFunctionClassFactory.decode(byteBuffer).toString();
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 115;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if (i3 % 2 == 0) {
                return obj;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return obj;
        } catch (Exception e) {
            throw e;
        }
    }

    public static String getAuthRequestContext(String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 5;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        try {
            Object[] objArr = new Object[1];
            a(View.MeasureSpec.getMode(0), 5 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) TextUtils.getCapsMode("", 0, 0), objArr);
            String decode = URLDecoder.decode(str, ((String) objArr[0]).intern());
            try {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 7;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if ((i3 % 2 != 0 ? (char) 16 : '%') != '%') {
                    int i4 = 67 / 0;
                    return decode;
                }
                return decode;
            } catch (Exception e) {
                throw e;
            }
        } catch (UnsupportedEncodingException e2) {
            throw new YAMLException(e2);
        }
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        int i3 = $10 + 39;
        $11 = i3 % 128;
        int i4 = i3 % 2;
        while (true) {
            try {
                if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? '@' : 'X') != '@') {
                    break;
                }
                int i5 = $10 + 67;
                try {
                    $11 = i5 % 128;
                    int i6 = i5 % 2;
                    jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (MyBillsEntityDataFactory[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ getAuthRequestContext))) ^ c;
                    whenavailable.BuiltInFictitiousFunctionClassFactory++;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        char[] cArr = new char[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i2) {
            cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        objArr[0] = new String(cArr);
    }
}
