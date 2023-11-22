package com.alipay.alipaysecuritysdk.rds.v2.face;

import android.content.Context;
import android.view.View;
import com.alibaba.griver.core.jsapi.actionsheet.ActionSheetItem;
import com.alipay.alipaysecuritysdk.apdid.bridge.JNIBridge;
import com.alipay.alipaysecuritysdk.apdid.face.APSecuritySdk;
import com.alipay.alipaysecuritysdk.common.c.b;
import com.alipay.alipaysecuritysdk.common.e.f;
import com.alipay.alipaysecuritysdk.rds.constant.DictionaryKeys;
import com.alipay.alipaysecuritysdk.rds.v2.a.a;
import com.alipay.alipaysecuritysdk.rds.v2.b.a.e;
import com.alipay.alipaysecuritysdk.rds.v2.b.c;
import com.alipay.alipaysecuritysdk.rds.v2.b.d;
import com.alipay.alipaysecuritysdk.rds.v2.b.g;
import com.alipay.alipaysecuritysdk.rds.v2.b.h;
import com.alipay.alipaysecuritysdk.rds.v2.b.j;
import com.alipay.alipaysecuritysdk.rds.v2.b.k;
import java.util.Map;
import o.D;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class RDSClient {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static long MyBillsEntityDataFactory = 0;
    private static final String RDS_VERSION = "1";
    private static final String RDS_ZIP_VERSION = "2";
    private static Context context;
    private static boolean debug;
    private static int getAuthRequestContext;
    private a manager;

    static {
        getAuthRequestContext();
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    static void getAuthRequestContext() {
        MyBillsEntityDataFactory = 5212905720118939702L;
    }

    public static void init(final Context context2) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            if (context2 != null) {
                isDebug();
                f.a().b(new Runnable() { // from class: com.alipay.alipaysecuritysdk.rds.v2.face.RDSClient.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            JNIBridge.getNativeProp(context2, "AD104", "");
                            JNIBridge.getNativeProp(context2, "AD107", "");
                        } catch (Throwable th) {
                            b.a("SEC_SDK-rds", th);
                        }
                    }
                });
                return;
            }
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
            getAuthRequestContext = i3 % 128;
            if (i3 % 2 != 0) {
                int i4 = 18 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean onPage(Context context2, Map<String, String> map, boolean z) {
        String str;
        APSecuritySdk.TokenResult tokenResult;
        synchronized (this) {
            if (context2 == null) {
                return false;
            }
            setContext(context2);
            String str2 = "";
            try {
                tokenResult = APSecuritySdk.getInstance(context2).getTokenResult();
            } catch (Throwable th) {
                b.a("SEC_SDK-rds", th);
            }
            if (tokenResult != null) {
                str2 = tokenResult.apdid;
                str = tokenResult.apdidToken;
                String str3 = str2;
                String str4 = map.get("umidToken");
                String str5 = map.get("utdid");
                String str6 = map.get("tid");
                String str7 = map.get("appver");
                String str8 = map.get("user");
                String str9 = map.get("appname");
                String str10 = map.get("appkey");
                String str11 = map.get(DictionaryKeys.V2_PACKAGENAME);
                String str12 = map.get(DictionaryKeys.V2_PAGENAME);
                String str13 = map.get(DictionaryKeys.V2_REFPAGENAME);
                a aVar = new a(context2, str3, str4, str5, str6, str, str7, str8, str9, str10, str11, z);
                this.manager = aVar;
                j jVar = aVar.f;
                jVar.c.incrementAndGet();
                e eVar = new e(str12, "1", jVar.d.incrementAndGet());
                eVar.a(str13);
                jVar.e.a(eVar);
                jVar.f = eVar;
                return true;
            }
            str = "";
            String str32 = str2;
            String str42 = map.get("umidToken");
            String str52 = map.get("utdid");
            String str62 = map.get("tid");
            String str72 = map.get("appver");
            String str82 = map.get("user");
            String str92 = map.get("appname");
            String str102 = map.get("appkey");
            String str112 = map.get(DictionaryKeys.V2_PACKAGENAME);
            String str122 = map.get(DictionaryKeys.V2_PAGENAME);
            String str132 = map.get(DictionaryKeys.V2_REFPAGENAME);
            a aVar2 = new a(context2, str32, str42, str52, str62, str, str72, str82, str92, str102, str112, z);
            this.manager = aVar2;
            j jVar2 = aVar2.f;
            jVar2.c.incrementAndGet();
            e eVar2 = new e(str122, "1", jVar2.d.incrementAndGet());
            eVar2.a(str132);
            jVar2.e.a(eVar2);
            jVar2.f = eVar2;
            return true;
        }
    }

    public String onPageEndAndZip(Context context2, String str) {
        String onPageEndAndZip;
        synchronized (this) {
            onPageEndAndZip = onPageEndAndZip(context2, str, true);
        }
        return onPageEndAndZip;
    }

    public String onPageEnd(Context context2, String str) {
        String onPageEndAndZip;
        synchronized (this) {
            onPageEndAndZip = onPageEndAndZip(context2, str, false);
        }
        return onPageEndAndZip;
    }

    private String onPageEndAndZip(Context context2, String str, boolean z) {
        String str2;
        String str3;
        a aVar = this.manager;
        Object[] objArr = null;
        if (aVar == null) {
            b.b("SEC_SDK-rds", "onPageEndAndZip manager is null");
            return null;
        }
        aVar.g.b.put("user", str);
        j jVar = this.manager.f;
        int i = jVar.c.get();
        if (jVar.f != null) {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 91;
            getAuthRequestContext = i2 % 128;
            int i3 = i2 % 2;
            jVar.b.put(ActionSheetItem.BadgeInfo.TYPE_NUM, String.valueOf(Integer.valueOf(i)));
            jVar.f = null;
        }
        if ((getContext() == null ? (char) 20 : (char) 11) != 11) {
            int i4 = getAuthRequestContext + 47;
            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
            if (!(i4 % 2 != 0)) {
                int length = objArr.length;
            }
            int i5 = getAuthRequestContext + 33;
            KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
            int i6 = i5 % 2;
            return null;
        }
        a aVar2 = this.manager;
        c cVar = aVar2.f6874a;
        com.alipay.alipaysecuritysdk.rds.v2.b.e eVar = aVar2.c;
        d dVar = aVar2.b;
        k kVar = aVar2.g;
        h hVar = aVar2.e;
        j jVar2 = aVar2.f;
        g gVar = aVar2.d;
        cVar.b = hVar;
        cVar.c.put("sensor", cVar.b);
        kVar.c = jVar2;
        kVar.b.put("ua", kVar.c);
        gVar.c = cVar;
        gVar.d = eVar;
        gVar.e = dVar;
        gVar.f = kVar;
        gVar.b.put("dev", gVar.c);
        gVar.b.put("loc", gVar.d);
        gVar.b.put("env", gVar.e);
        gVar.b.put("usr", gVar.f);
        String jSONObject = gVar.a().toString();
        if (z) {
            str2 = "2";
        } else {
            int i7 = getAuthRequestContext + 27;
            KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
            int i8 = i7 % 2;
            str2 = "1";
        }
        try {
            byte[] zipAndEncryptData = JNIBridge.zipAndEncryptData(getContext(), jSONObject);
            Object[] objArr2 = new Object[1];
            a(View.MeasureSpec.makeMeasureSpec(0, 0), new char[]{26660, 26737, 54604, 52490, 49554, 2246, 8036, 30448, 22565}, objArr2);
            str3 = new String(zipAndEncryptData, ((String) objArr2[0]).intern());
            int i9 = getAuthRequestContext + 117;
            KClassImpl$Data$declaredNonStaticMembers$2 = i9 % 128;
            int i10 = i9 % 2;
        } catch (Throwable th) {
            b.a("SEC_SDK-rds", th);
            str3 = "";
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("version", str2);
            jSONObject2.put("data", str3);
            return jSONObject2.toString();
        } catch (JSONException e) {
            b.a("SEC_SDK-rds", e);
            return "";
        }
    }

    public void onControlClick(String str, String str2) {
        synchronized (this) {
            a aVar = this.manager;
            if (aVar == null) {
                b.b("SEC_SDK-rds", "onControlClick manager is null");
            } else {
                aVar.f.a(str, str2);
            }
        }
    }

    public void onKeyDown(String str, String str2, String str3) {
        synchronized (this) {
            a aVar = this.manager;
            if (aVar == null) {
                b.b("SEC_SDK-rds", "onKeyDown manager is null");
            } else {
                aVar.f.a(str, str2, str3);
            }
        }
    }

    public void onGetFocus(String str, String str2) {
        synchronized (this) {
            a aVar = this.manager;
            if (aVar != null) {
                aVar.a(str, str2, true);
            } else {
                b.b("SEC_SDK-rds", "onGetFocus manager is null");
            }
        }
    }

    public void onLostFocus(String str, String str2) {
        synchronized (this) {
            a aVar = this.manager;
            if (aVar != null) {
                aVar.a(str, str2, false);
            } else {
                b.b("SEC_SDK-rds", "onLostFocus manager is null");
            }
        }
    }

    public void onLostFocus(String str, String str2, boolean z) {
        synchronized (this) {
            a aVar = this.manager;
            if (aVar != null) {
                aVar.a(str, str2, z);
            } else {
                b.b("SEC_SDK-rds", "onLostFocus manager is null");
            }
        }
    }

    public void onTouchScreen(String str, String str2, double d, double d2) {
        synchronized (this) {
            a aVar = this.manager;
            if (aVar == null) {
                b.b("SEC_SDK-rds", "onTouchScreen manager is null");
                return;
            }
            j jVar = aVar.f;
            String b = j.b(str, str2);
            jVar.c.incrementAndGet();
            if (jVar.f != null) {
                if (jVar.f instanceof com.alipay.alipaysecuritysdk.rds.v2.b.a.f) {
                    jVar.e.a("", false, d);
                    return;
                }
                com.alipay.alipaysecuritysdk.rds.v2.b.a.f fVar = new com.alipay.alipaysecuritysdk.rds.v2.b.a.f(str, str2, b, jVar.d.incrementAndGet());
                fVar.b(d);
                jVar.e.a(fVar);
                jVar.f = fVar;
            }
        }
    }

    public static void enableLog() {
        synchronized (RDSClient.class) {
            debug = true;
        }
    }

    public static Context getContext() {
        try {
            int i = getAuthRequestContext + 51;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 == 0 ? 'T' : '2') != 'T') {
                return context;
            }
            Context context2 = context;
            Object[] objArr = null;
            int length = objArr.length;
            return context2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void setContext(Context context2) {
        int i = getAuthRequestContext + 51;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 != 0)) {
            try {
                context = context2;
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } else {
            context = context2;
        }
        int i2 = getAuthRequestContext + 89;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
    }

    public static boolean isDebug() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 95;
        getAuthRequestContext = i % 128;
        if (i % 2 == 0) {
            try {
                return debug;
            } catch (Exception e) {
                throw e;
            }
        }
        boolean z = debug;
        Object[] objArr = null;
        int length = objArr.length;
        return z;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        try {
            char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory ^ 3919452569568103912L, cArr, i);
            d.MyBillsEntityDataFactory = 4;
            while (true) {
                if (!(d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$22.length)) {
                    break;
                }
                int i2 = $10 + 93;
                $11 = i2 % 128;
                int i3 = i2 % 2;
                d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (MyBillsEntityDataFactory ^ 3919452569568103912L)));
                d.MyBillsEntityDataFactory++;
            }
            String str = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
            int i4 = $11 + 101;
            $10 = i4 % 128;
            if ((i4 % 2 != 0 ? '*' : '!') == '!') {
                objArr[0] = str;
                return;
            }
            int i5 = 89 / 0;
            objArr[0] = str;
        } catch (Exception e) {
            throw e;
        }
    }
}
