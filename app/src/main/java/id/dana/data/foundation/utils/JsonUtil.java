package id.dana.data.foundation.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Process;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import id.dana.data.foundation.RpcException;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class JsonUtil {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static final String MyBillsEntityDataFactory;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
    private static boolean PlaceComponentResult = false;
    private static boolean getAuthRequestContext = false;
    private static int moveToNextValue = 1;

    static {
        getAuthRequestContext();
        Object[] objArr = new Object[1];
        a(126 - Process.getGidForName(""), new byte[]{-123, -124, -125, -126, -127}, null, null, objArr);
        MyBillsEntityDataFactory = ((String) objArr[0]).intern();
        int i = moveToNextValue + 57;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 != 0 ? 'E' : (char) 17) != 'E') {
            return;
        }
        int i2 = 95 / 0;
    }

    static void getAuthRequestContext() {
        KClassImpl$Data$declaredNonStaticMembers$2 = new char[]{39923, 39922, 39808, 39835, 39822};
        getAuthRequestContext = true;
        PlaceComponentResult = true;
        BuiltInFictitiousFunctionClassFactory = 909155142;
    }

    public static <T> T BuiltInFictitiousFunctionClassFactory(String str, TypeReference<T> typeReference) throws RpcException {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 45;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        try {
            T t = (T) JSON.parseObject(str, typeReference, new Feature[0]);
            int i3 = moveToNextValue + 109;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
            return t;
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory("JsonUtil", e.getMessage());
            throw new RpcException("013");
        }
    }

    public static JSONObject MyBillsEntityDataFactory(org.json.JSONObject jSONObject) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 53;
        moveToNextValue = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? 'J' : 'E') != 'J') {
            if ((jSONObject != null ? '(' : '^') != '(') {
                return null;
            }
        } else {
            int length = objArr.length;
            if (jSONObject == null) {
                return null;
            }
        }
        int i2 = moveToNextValue + 123;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
        try {
            return JSON.parseObject(jSONObject.toString());
        } catch (Exception e) {
            throw e;
        }
    }

    public static org.json.JSONObject getAuthRequestContext(JSONObject jSONObject) throws JSONException {
        org.json.JSONObject jSONObject2 = new org.json.JSONObject(jSONObject.toJSONString());
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 115;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        return jSONObject2;
    }

    public static String getAuthRequestContext(Object obj) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 29;
        moveToNextValue = i % 128;
        if (i % 2 != 0) {
            return JSON.toJSONString(obj);
        }
        try {
            String jSONString = JSON.toJSONString(obj);
            Object[] objArr = null;
            int length = objArr.length;
            return jSONString;
        } catch (Exception e) {
            throw e;
        }
    }

    public static String PlaceComponentResult(Context context, String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 41;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        Object[] objArr = null;
        try {
            try {
                Object[] objArr2 = {context.getAssets(), str};
                Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                if (obj == null) {
                    obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (58133 - View.MeasureSpec.getMode(0)), ViewConfiguration.getMaximumDrawingCacheSize() >> 24, ExpandableListView.getPackedPositionType(0L) + 49)).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                    NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                }
                String MyBillsEntityDataFactory2 = MyBillsEntityDataFactory((InputStream) ((Method) obj).invoke(null, objArr2));
                try {
                    int i3 = moveToNextValue + 37;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                    if ((i3 % 2 != 0 ? JSONLexer.EOI : 'E') != 26) {
                        return MyBillsEntityDataFactory2;
                    }
                    int length = objArr.length;
                    return MyBillsEntityDataFactory2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public static String MyBillsEntityDataFactory(Context context, String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 27;
        moveToNextValue = i % 128;
        try {
            if (!(i % 2 != 0)) {
                String MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(context.openFileInput(str));
                int i2 = 39 / 0;
                return MyBillsEntityDataFactory2;
            }
            return MyBillsEntityDataFactory(context.openFileInput(str));
        } catch (IOException unused) {
            return null;
        }
    }

    private static String MyBillsEntityDataFactory(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 95;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if ((readLine != null ? 'M' : (char) 27) != 27) {
                    int i3 = moveToNextValue + 1;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                    if (i3 % 2 != 0) {
                        sb.append(readLine);
                        sb.append('X');
                    } else {
                        sb.append(readLine);
                        sb.append('\n');
                    }
                } else {
                    inputStream.close();
                    return sb.toString();
                }
            } catch (IOException unused) {
                return null;
            }
        }
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        int i2;
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
        if (!(cArr2 == null)) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        int i4 = (int) (4571606982258105150L ^ BuiltInFictitiousFunctionClassFactory);
        try {
            if (!PlaceComponentResult) {
                if (!getAuthRequestContext) {
                    bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                    char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                    while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                        int i5 = $10 + 91;
                        $11 = i5 % 128;
                        if (i5 % 2 == 0) {
                            cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult + 0) >>> bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] * i4);
                            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory /= 1;
                        } else {
                            cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i4);
                            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                        }
                    }
                    objArr[0] = new String(cArr4);
                    return;
                }
                int i6 = $10 + 107;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    int i8 = $10 + 111;
                    $11 = i8 % 128;
                    if (i8 % 2 == 0) {
                        cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult << 0) % bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] >> i4);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory - 0;
                    } else {
                        cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i4);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
                    }
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i2;
                }
                objArr[0] = new String(cArr5);
                return;
            }
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (true) {
                if (!(bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult)) {
                    objArr[0] = new String(cArr6);
                    return;
                } else {
                    cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i4);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
