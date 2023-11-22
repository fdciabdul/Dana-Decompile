package com.alipay.plus.security.lite.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.AudioTrack;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.iap.ac.android.common.utils.resource.ConfigResourceUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import kotlin.text.Typography;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;
import o.getCallingPid;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] BuiltInFictitiousFunctionClassFactory = {42065, 37275, 37257, 37367, 42068, 37346, 37274, 42070, 42071};
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static int PlaceComponentResult = 0;

    /* renamed from: a  reason: collision with root package name */
    public static final String f7407a = "b";
    private static char getAuthRequestContext = 42070;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00e9: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:50:0x00e7 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.content.res.AssetManager] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v19, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v21, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.io.Closeable, java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.Closeable] */
    public static String a(Context context, String str) {
        ?? r9;
        Closeable closeable;
        Exception e;
        BufferedReader bufferedReader;
        ?? assets = context.getAssets();
        Closeable closeable2 = null;
        try {
            try {
                ?? r2 = {assets, str};
                Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                if (obj == null) {
                    obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (TextUtils.lastIndexOf("", '0', 0, 0) + 58134), ViewConfiguration.getDoubleTapTimeout() >> 16, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 49)).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                    NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                }
                assets = (InputStream) ((Method) obj).invoke(null, r2);
                try {
                    r9 = new InputStreamReader(assets);
                    try {
                        bufferedReader = new BufferedReader(r9);
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader = null;
                    } catch (Throwable th) {
                        th = th;
                        a(closeable2);
                        a(r9);
                        a(assets);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    assets = assets;
                    r9 = 0;
                    bufferedReader = null;
                    String str2 = f7407a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("ConfigResourceUtils readConfigFromAsset failed: ");
                    sb.append(e);
                    d.a(str2, sb.toString());
                    a(bufferedReader);
                    a(r9);
                    a(assets);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    assets = assets;
                    r9 = 0;
                    a(closeable2);
                    a(r9);
                    a(assets);
                    throw th;
                }
                try {
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if ((readLine != null ? ')' : 'V') != 'V') {
                            try {
                                int i = PlaceComponentResult + 73;
                                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                                int i2 = i % 2;
                                sb2.append(readLine);
                            } catch (Exception e4) {
                                throw e4;
                            }
                        } else {
                            String obj2 = sb2.toString();
                            a(bufferedReader);
                            a(r9);
                            a(assets);
                            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 81;
                            PlaceComponentResult = i3 % 128;
                            int i4 = i3 % 2;
                            return obj2;
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    String str22 = f7407a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("ConfigResourceUtils readConfigFromAsset failed: ");
                    sb3.append(e);
                    d.a(str22, sb3.toString());
                    a(bufferedReader);
                    a(r9);
                    a(assets);
                    return null;
                }
            } catch (Throwable th3) {
                try {
                    Throwable cause = th3.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th3;
                } catch (Exception e6) {
                    e = e6;
                    assets = 0;
                    r9 = 0;
                    bufferedReader = null;
                    String str222 = f7407a;
                    StringBuilder sb32 = new StringBuilder();
                    sb32.append("ConfigResourceUtils readConfigFromAsset failed: ");
                    sb32.append(e);
                    d.a(str222, sb32.toString());
                    a(bufferedReader);
                    a(r9);
                    a(assets);
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    assets = 0;
                    r9 = 0;
                    a(closeable2);
                    a(r9);
                    a(assets);
                    throw th;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            r9 = str;
            closeable2 = closeable;
        }
    }

    public static String b(Context context, String str) {
        int i = PlaceComponentResult + 105;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        String a2 = a(context, ConfigResourceUtils.PRESET_CONFIG_FILE_NAME);
        if ((TextUtils.isEmpty(a2) ? '\f' : (char) 19) != 19) {
            return null;
        }
        Object[] objArr = new Object[1];
        c(new char[]{7, 0, 5, '\b', 13731}, (byte) (1 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), 5 - View.MeasureSpec.getMode(0), objArr);
        byte[] decode = Base64.decode(a2.getBytes(Charset.forName(((String) objArr[0]).intern())), 0);
        if (decode != null) {
            try {
                String optString = new JSONObject(new String(decode)).optString(str, "");
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
                return optString;
            } catch (JSONException e) {
                String str2 = f7407a;
                StringBuilder sb = new StringBuilder();
                sb.append("ConfigResourceUtils parse config failed: ");
                sb.append(e);
                d.a(str2, sb.toString());
            }
        }
        int i5 = PlaceComponentResult + 111;
        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
        int i6 = i5 % 2;
        return null;
    }

    public static void a(Closeable closeable) {
        int i = PlaceComponentResult + 55;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        if ((closeable != null ? ']' : Typography.greater) != '>') {
            try {
                closeable.close();
                return;
            } catch (IOException e) {
                String str = f7407a;
                StringBuilder sb = new StringBuilder();
                sb.append("ConfigResourceUtils readConfigFromAsset failed: ");
                sb.append(e);
                d.a(str, sb.toString());
            }
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
    }

    private static void c(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        try {
            char[] cArr2 = BuiltInFictitiousFunctionClassFactory;
            if ((cArr2 != null ? (char) 17 : '\\') != '\\') {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i3 = 0;
                while (true) {
                    if (!(i3 < length)) {
                        break;
                    }
                    cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
                    i3++;
                }
                cArr2 = cArr3;
            }
            char c = (char) (getAuthRequestContext ^ (-1549216646985767851L));
            char[] cArr4 = new char[i];
            if (!(i % 2 == 0)) {
                i2 = i - 1;
                cArr4[i2] = (char) (cArr[i2] - b);
            } else {
                i2 = i;
            }
            if (i2 > 1) {
                int i4 = $10 + 37;
                $11 = i4 % 128;
                if (i4 % 2 == 0) {
                    getcallingpid.getAuthRequestContext = 1;
                } else {
                    getcallingpid.getAuthRequestContext = 0;
                }
                while (getcallingpid.getAuthRequestContext < i2) {
                    getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                    getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                    if ((getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult ? '\t' : (char) 14) != '\t') {
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                        getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                        getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                        if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                            getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                            getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                            int i5 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i6 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i5];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i6];
                        } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                            getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                            getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                            int i7 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i8 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i7];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i8];
                        } else {
                            int i9 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                            int i10 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i9];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i10];
                        }
                    } else {
                        cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                        cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                        int i11 = $11 + 77;
                        $10 = i11 % 128;
                        int i12 = i11 % 2;
                    }
                    try {
                        getcallingpid.getAuthRequestContext += 2;
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
            for (int i13 = 0; i13 < i; i13++) {
                int i14 = $11 + 11;
                $10 = i14 % 128;
                int i15 = i14 % 2;
                cArr4[i13] = (char) (cArr4[i13] ^ 13722);
            }
            objArr[0] = new String(cArr4);
        } catch (Exception e2) {
            throw e2;
        }
    }
}
