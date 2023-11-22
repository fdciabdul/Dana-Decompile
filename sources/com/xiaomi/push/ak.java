package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.alibaba.griver.base.common.utils.FileCache;
import com.xiaomi.channel.commonutils.android.Region;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.geocode.mapper.GeocoderResultMapperKt;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class ak {
    private static int $10 = 0;
    private static int $11 = 1;
    protected static final Map<String, ag> BuiltInFictitiousFunctionClassFactory;
    protected static boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;
    private static a NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
    private static int[] NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
    protected static Context PlaceComponentResult = null;
    private static int PrepareContext = 0;
    private static ak getErrorConfigVersion = null;
    private static String lookAheadTest = null;
    private static int newProxyInstance = 1;
    private static String scheduleImpl;
    private final long DatabaseTableConfigUtil;
    private String GetContactSyncConfig;
    protected b MyBillsEntityDataFactory;
    private String NetworkUserEntityData$$ExternalSyntheticLambda1;
    private aj NetworkUserEntityData$$ExternalSyntheticLambda2;
    protected final Map<String, ah> getAuthRequestContext;
    private long initRecordTimeStamp;
    private long moveToNextValue;

    /* loaded from: classes8.dex */
    public interface a {
        ak BuiltInFictitiousFunctionClassFactory(Context context, b bVar, String str);
    }

    /* loaded from: classes8.dex */
    public interface b {
        String BuiltInFictitiousFunctionClassFactory(String str);
    }

    static {
        NetworkUserEntityData$$ExternalSyntheticLambda0();
        BuiltInFictitiousFunctionClassFactory = new HashMap();
        KClassImpl$Data$declaredNonStaticMembers$2 = false;
        int i = PrepareContext + 41;
        newProxyInstance = i % 128;
        int i2 = i % 2;
    }

    public ak(Context context, aj ajVar, b bVar, String str) {
        this(context, ajVar, bVar, str, null, null);
    }

    private ak(Context context, aj ajVar, b bVar, String str, String str2, String str3) {
        this.getAuthRequestContext = new HashMap();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = "0";
        this.moveToNextValue = 0L;
        this.DatabaseTableConfigUtil = 15L;
        this.initRecordTimeStamp = 0L;
        this.GetContactSyncConfig = "isp_prov_city_country_ip";
        this.MyBillsEntityDataFactory = bVar;
        if (ajVar == null) {
            ajVar = new al(this);
            try {
                int i = newProxyInstance + 103;
                PrepareContext = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = ajVar;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str;
        scheduleImpl = (str2 == null ? (char) 5 : ']') == 5 ? context.getPackageName() : str2;
        lookAheadTest = (str3 == null ? '0' : '1') == '0' ? NetworkUserEntityData$$ExternalSyntheticLambda2() : str3;
        int i3 = PrepareContext + 123;
        newProxyInstance = i3 % 128;
        int i4 = i3 % 2;
    }

    public static ag BuiltInFictitiousFunctionClassFactory(String str) {
        ag agVar;
        Map<String, ag> map = BuiltInFictitiousFunctionClassFactory;
        synchronized (map) {
            agVar = map.get(str);
        }
        return agVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String BuiltInFictitiousFunctionClassFactory() {
        Context context = PlaceComponentResult;
        if ((context == null ? '\b' : '%') != '\b') {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    int i = newProxyInstance + 49;
                    PrepareContext = i % 128;
                    int i2 = i % 2;
                    return "unknown";
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return "unknown";
                }
                if (activeNetworkInfo.getType() != 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(activeNetworkInfo.getTypeName());
                    sb.append("-");
                    sb.append(activeNetworkInfo.getSubtypeName());
                    return sb.toString();
                }
                int i3 = PrepareContext + 85;
                newProxyInstance = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                int i4 = PrepareContext + 67;
                newProxyInstance = i4 % 128;
                int i5 = i4 % 2;
                return "WIFI-UNKNOWN";
            } catch (Throwable unused) {
            }
        }
        return "unknown";
    }

    private static String DatabaseTableConfigUtil() {
        String KClassImpl$Data$declaredNonStaticMembers$22 = com.xiaomi.push.service.a.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult).KClassImpl$Data$declaredNonStaticMembers$2();
        if (TextUtils.isEmpty(KClassImpl$Data$declaredNonStaticMembers$22)) {
            int i = PrepareContext + 123;
            newProxyInstance = i % 128;
            if ((i % 2 == 0 ? '%' : '/') != '/') {
                int i2 = 73 / 0;
                return "resolver.msg.global.xiaomi.net";
            }
            return "resolver.msg.global.xiaomi.net";
        }
        try {
            if ((Region.Global.name().equals(KClassImpl$Data$declaredNonStaticMembers$22) ? 'U' : (char) 0) != 0) {
                int i3 = newProxyInstance + 109;
                PrepareContext = i3 % 128;
                int i4 = i3 % 2;
                return "resolver.msg.global.xiaomi.net";
            } else if (!Region.Europe.name().equals(KClassImpl$Data$declaredNonStaticMembers$22)) {
                if ((Region.Russia.name().equals(KClassImpl$Data$declaredNonStaticMembers$22) ? (char) 18 : '3') != 18) {
                    return Region.India.name().equals(KClassImpl$Data$declaredNonStaticMembers$22) ? "mb.resolver.msg.global.xiaomi.net" : "resolver.msg.global.xiaomi.net";
                }
                int i5 = newProxyInstance + 53;
                PrepareContext = i5 % 128;
                int i6 = i5 % 2;
                return "ru.resolver.msg.global.xiaomi.net";
            } else {
                int i7 = newProxyInstance + 109;
                PrepareContext = i7 % 128;
                if (i7 % 2 != 0) {
                    Object obj = null;
                    obj.hashCode();
                    return "fr.resolver.msg.global.xiaomi.net";
                }
                return "fr.resolver.msg.global.xiaomi.net";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private boolean GetContactSyncConfig() {
        synchronized (this.getAuthRequestContext) {
            if (KClassImpl$Data$declaredNonStaticMembers$2) {
                return true;
            }
            KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.getAuthRequestContext.clear();
            try {
                String PrepareContext2 = PrepareContext();
                if (!TextUtils.isEmpty(PrepareContext2)) {
                    getErrorConfigVersion(PrepareContext2);
                    com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("load bucket failure: ");
                sb.append(th.getMessage());
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            }
            return false;
        }
    }

    public static ak MyBillsEntityDataFactory() {
        ak akVar;
        synchronized (ak.class) {
            akVar = getErrorConfigVersion;
            if (akVar == null) {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
        }
        return akVar;
    }

    public static void MyBillsEntityDataFactory(String str, String str2) {
        Map<String, ag> map = BuiltInFictitiousFunctionClassFactory;
        ag agVar = map.get(str);
        synchronized (map) {
            if (agVar == null) {
                ag agVar2 = new ag(str);
                agVar2.getAuthRequestContext(FileCache.EXPIRE_TIME);
                agVar2.KClassImpl$Data$declaredNonStaticMembers$2(str2);
                map.put(str, agVar2);
            } else {
                agVar.KClassImpl$Data$declaredNonStaticMembers$2(str2);
            }
        }
    }

    static void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        NetworkUserEntityData$$ExternalSyntheticLambda7 = new int[]{1185414404, 1385734899, 63031689, -2112591817, -1283227450, 774702545, 1059548996, -1444831641, 287641145, -1704738872, -916481237, -483467468, 2046076757, -714985075, -1652355414, 1210352104, -698701735, 440357939};
    }

    private static void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        Map<String, ag> map = BuiltInFictitiousFunctionClassFactory;
        synchronized (map) {
            map.clear();
        }
    }

    private static String NetworkUserEntityData$$ExternalSyntheticLambda2() {
        PackageInfo packageInfo;
        int i = PrepareContext + 65;
        newProxyInstance = i % 128;
        try {
            if (i % 2 == 0) {
                packageInfo = PlaceComponentResult.getPackageManager().getPackageInfo(PlaceComponentResult.getPackageName(), 9487);
                if ((packageInfo != null ? 'c' : Typography.dollar) == '$') {
                    return "0";
                }
            } else {
                packageInfo = PlaceComponentResult.getPackageManager().getPackageInfo(PlaceComponentResult.getPackageName(), 16384);
                if ((packageInfo != null ? (char) 7 : '4') == '4') {
                    return "0";
                }
            }
            String str = packageInfo.versionName;
            int i2 = newProxyInstance + 103;
            PrepareContext = i2 % 128;
            if (!(i2 % 2 != 0)) {
                return str;
            }
            Object obj = null;
            obj.hashCode();
            return str;
        } catch (Exception unused) {
            return "0";
        }
    }

    private static String NetworkUserEntityData$$ExternalSyntheticLambda7() {
        if (!(!"com.xiaomi.xmsf".equals(scheduleImpl))) {
            int i = PrepareContext + 105;
            newProxyInstance = i % 128;
            boolean z = i % 2 != 0;
            String str = scheduleImpl;
            if (z) {
                return str;
            }
            int i2 = 76 / 0;
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(scheduleImpl);
        sb.append(":pushservice");
        String obj = sb.toString();
        try {
            int i3 = newProxyInstance + 109;
            PrepareContext = i3 % 128;
            if (i3 % 2 != 0) {
                int i4 = 81 / 0;
                return obj;
            }
            return obj;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void PlaceComponentResult() {
        int i = newProxyInstance + 79;
        PrepareContext = i % 128;
        int i2 = i % 2;
        ak MyBillsEntityDataFactory = MyBillsEntityDataFactory();
        NetworkUserEntityData$$ExternalSyntheticLambda1();
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        MyBillsEntityDataFactory.scheduleImpl();
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("region changed so clear cached hosts");
        int i3 = PrepareContext + 15;
        newProxyInstance = i3 % 128;
        int i4 = i3 % 2;
    }

    public static void PlaceComponentResult(a aVar) {
        synchronized (ak.class) {
            NetworkUserEntityData$$ExternalSyntheticLambda0 = aVar;
            getErrorConfigVersion = null;
        }
    }

    private static String PrepareContext() {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        File file;
        try {
            file = new File(PlaceComponentResult.getFilesDir(), moveToNextValue());
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
            fileInputStream = null;
        }
        if (!file.isFile()) {
            try {
                h.MyBillsEntityDataFactory((Closeable) null);
                h.MyBillsEntityDataFactory((Closeable) null);
                int i = PrepareContext + 115;
                newProxyInstance = i % 128;
                int i2 = i % 2;
                return null;
            } catch (Exception e) {
                throw e;
            }
        }
        fileInputStream = new FileInputStream(file);
        try {
            bufferedInputStream = new BufferedInputStream(fileInputStream);
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
        }
        try {
            String str = new String(com.xiaomi.channel.commonutils.android.b.BuiltInFictitiousFunctionClassFactory(lookAheadTest(), h.MyBillsEntityDataFactory((InputStream) bufferedInputStream)), StandardCharsets.UTF_8);
            StringBuilder sb = new StringBuilder();
            sb.append("load host fallbacks = ");
            sb.append(str);
            com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory(sb.toString());
            try {
                int i3 = newProxyInstance + 69;
                PrepareContext = i3 % 128;
                int i4 = i3 % 2;
                return str;
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Throwable th4) {
            th = th4;
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("load host exception ");
                sb2.append(th.getMessage());
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
                return null;
            } finally {
                h.MyBillsEntityDataFactory((Closeable) bufferedInputStream);
                h.MyBillsEntityDataFactory((Closeable) fileInputStream);
            }
        }
    }

    private static String getAuthRequestContext(String str) {
        int i = PrepareContext + 93;
        newProxyInstance = i % 128;
        int i2 = i % 2;
        try {
            int length = str.length();
            Object[] objArr = new Object[1];
            a((ViewConfiguration.getTapTimeout() >> 16) + 5, new int[]{-317422460, 1114703282, 446062894, -1660923525}, objArr);
            byte[] bytes = str.getBytes(((String) objArr[0]).intern());
            int i3 = 0;
            while (true) {
                if ((i3 < bytes.length ? 'D' : (char) 21) == 21) {
                    return new String(bytes);
                }
                byte b2 = bytes[i3];
                int i4 = b2 & 240;
                if ((i4 != 240 ? 'U' : InputCardNumberView.DIVIDER) != ' ') {
                    int i5 = PrepareContext + 53;
                    newProxyInstance = i5 % 128;
                    if (!(i5 % 2 == 0)) {
                        bytes[i3] = (byte) ((((byte) (((b2 >> 4) + length) & 15)) ^ (b2 & 15)) | i4);
                    } else {
                        bytes[i3] = (byte) (((byte) (((b2 << 5) >>> length) & 109)) & b2 & 68 & i4);
                    }
                }
                i3++;
                int i6 = PrepareContext + 95;
                newProxyInstance = i6 % 128;
                int i7 = i6 % 2;
            }
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static void getAuthRequestContext(Context context, b bVar, String str, String str2, String str3) {
        synchronized (ak.class) {
            Context applicationContext = context.getApplicationContext();
            PlaceComponentResult = applicationContext;
            if (applicationContext == null) {
                PlaceComponentResult = context;
            }
            if (getErrorConfigVersion == null) {
                a aVar = NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (aVar == null) {
                    getErrorConfigVersion = new ak(context, null, bVar, str, str2, str3);
                } else {
                    getErrorConfigVersion = aVar.BuiltInFictitiousFunctionClassFactory(context, bVar, str);
                }
            }
        }
    }

    private void getAuthRequestContext(String str, ag agVar) {
        if (TextUtils.isEmpty(str) || agVar == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("the argument is invalid ");
            sb.append(str);
            sb.append(", ");
            sb.append(agVar);
            throw new IllegalArgumentException(sb.toString());
        }
        synchronized (this.getAuthRequestContext) {
            GetContactSyncConfig();
            if (this.getAuthRequestContext.containsKey(str)) {
                this.getAuthRequestContext.get(str).KClassImpl$Data$declaredNonStaticMembers$2(agVar);
            } else {
                ah ahVar = new ah(str);
                ahVar.KClassImpl$Data$declaredNonStaticMembers$2(agVar);
                this.getAuthRequestContext.put(str, ahVar);
            }
        }
    }

    public static void getErrorConfigVersion() {
        String str;
        try {
            String NetworkUserEntityData$$ExternalSyntheticLambda72 = NetworkUserEntityData$$ExternalSyntheticLambda7();
            try {
                File file = new File(PlaceComponentResult.getFilesDir(), NetworkUserEntityData$$ExternalSyntheticLambda72);
                if (!file.exists()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Old host fallbacks file ");
                    sb.append(NetworkUserEntityData$$ExternalSyntheticLambda72);
                    sb.append(" does not exist.");
                    com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory(sb.toString());
                    return;
                }
                boolean delete = file.delete();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Delete old host fallbacks file ");
                sb2.append(NetworkUserEntityData$$ExternalSyntheticLambda72);
                if (delete) {
                    int i = PrepareContext + 43;
                    newProxyInstance = i % 128;
                    int i2 = i % 2;
                    str = " successful.";
                } else {
                    str = " failed.";
                    int i3 = newProxyInstance + 51;
                    PrepareContext = i3 % 128;
                    int i4 = i3 % 2;
                }
                sb2.append(str);
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
            } catch (Exception e) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Delete old host fallbacks file ");
                sb3.append(NetworkUserEntityData$$ExternalSyntheticLambda72);
                sb3.append(" error: ");
                sb3.append(e.getMessage());
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb3.toString());
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private JSONObject initRecordTimeStamp() {
        JSONObject jSONObject;
        synchronized (this.getAuthRequestContext) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            Iterator<ah> it = this.getAuthRequestContext.values().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().BuiltInFictitiousFunctionClassFactory());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            Iterator<ag> it2 = BuiltInFictitiousFunctionClassFactory.values().iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next().PlaceComponentResult());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }

    private ag lookAheadTest(String str) {
        if (System.currentTimeMillis() - this.initRecordTimeStamp > this.moveToNextValue * 60 * 1000) {
            this.initRecordTimeStamp = System.currentTimeMillis();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            ag agVar = KClassImpl$Data$declaredNonStaticMembers$2(arrayList).get(0);
            if (agVar != null) {
                int i = newProxyInstance + 77;
                PrepareContext = i % 128;
                if (i % 2 != 0) {
                    this.moveToNextValue = 1L;
                } else {
                    this.moveToNextValue = 0L;
                }
                return agVar;
            }
            long j = this.moveToNextValue;
            if ((j < 15 ? 'T' : 'V') != 'V') {
                int i2 = PrepareContext + 33;
                newProxyInstance = i2 % 128;
                int i3 = i2 % 2;
                this.moveToNextValue = j + 1;
                return null;
            }
            return null;
        }
        return null;
    }

    private static byte[] lookAheadTest() {
        StringBuilder sb = new StringBuilder();
        sb.append(PlaceComponentResult.getPackageName());
        sb.append("_key_salt");
        byte[] authRequestContext = ac.getAuthRequestContext(sb.toString());
        int i = newProxyInstance + 21;
        PrepareContext = i % 128;
        if ((i % 2 != 0 ? 'W' : '0') != '0') {
            Object[] objArr = null;
            int length = objArr.length;
            return authRequestContext;
        }
        return authRequestContext;
    }

    private static String moveToNextValue() {
        int i = PrepareContext + 57;
        newProxyInstance = i % 128;
        if (!(i % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
        }
        try {
            int i2 = PrepareContext + 109;
            newProxyInstance = i2 % 128;
            int i3 = i2 % 2;
            return "host_fallbacks";
        } catch (Exception e) {
            throw e;
        }
    }

    private ag scheduleImpl(String str) {
        ah ahVar;
        ag PlaceComponentResult2;
        synchronized (this.getAuthRequestContext) {
            GetContactSyncConfig();
            ahVar = this.getAuthRequestContext.get(str);
        }
        if (ahVar == null || (PlaceComponentResult2 = ahVar.PlaceComponentResult()) == null) {
            return null;
        }
        return PlaceComponentResult2;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        synchronized (this.getAuthRequestContext) {
            this.getAuthRequestContext.clear();
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        int i = newProxyInstance + 37;
        PrepareContext = i % 128;
        if (i % 2 == 0) {
            try {
                this.GetContactSyncConfig = str;
            } catch (Exception e) {
                throw e;
            }
        } else {
            this.GetContactSyncConfig = str;
            int i2 = 43 / 0;
        }
        int i3 = newProxyInstance + 107;
        PrepareContext = i3 % 128;
        int i4 = i3 % 2;
    }

    public final ag MyBillsEntityDataFactory(String str) {
        int i = newProxyInstance + 3;
        PrepareContext = i % 128;
        int i2 = i % 2;
        try {
            ag MyBillsEntityDataFactory = MyBillsEntityDataFactory(str, true);
            int i3 = newProxyInstance + 103;
            PrepareContext = i3 % 128;
            if ((i3 % 2 != 0 ? 'a' : 'H') != 'a') {
                return MyBillsEntityDataFactory;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return MyBillsEntityDataFactory;
        } catch (Exception e) {
            throw e;
        }
    }

    public final ag MyBillsEntityDataFactory(String str, boolean z) {
        try {
            if (!(TextUtils.isEmpty(str))) {
                ag scheduleImpl2 = scheduleImpl(str);
                if ((scheduleImpl2 != null ? 'C' : InputCardNumberView.DIVIDER) == 'C' && scheduleImpl2.getAuthRequestContext()) {
                    try {
                        int i = newProxyInstance + 53;
                        PrepareContext = i % 128;
                        int i2 = i % 2;
                        return scheduleImpl2;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                if (z && y.MyBillsEntityDataFactory(PlaceComponentResult)) {
                    int i3 = PrepareContext + 11;
                    newProxyInstance = i3 % 128;
                    int i4 = i3 % 2;
                    ag lookAheadTest2 = lookAheadTest(str);
                    if (lookAheadTest2 != null) {
                        return lookAheadTest2;
                    }
                }
                return new am(this, str, scheduleImpl2);
            }
            throw new IllegalArgumentException("the host is empty");
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String MyBillsEntityDataFactory(ArrayList<String> arrayList, String str, String str2, boolean z) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<x> arrayList3 = new ArrayList();
        if (str.equals("wap")) {
            arrayList3.add(new v("conpt", getAuthRequestContext(y.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult))));
        }
        if (z) {
            arrayList3.add(new v("reserved", "1"));
        }
        arrayList3.add(new v("list", ad.PlaceComponentResult(arrayList, ",")));
        arrayList3.add(new v("countrycode", com.xiaomi.push.service.a.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult).PlaceComponentResult()));
        arrayList3.add(new v("push_sdk_vc", "50011"));
        ag scheduleImpl2 = scheduleImpl(DatabaseTableConfigUtil());
        String format = String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", DatabaseTableConfigUtil());
        if (scheduleImpl2 == null) {
            arrayList2.add(format);
            Map<String, ag> map = BuiltInFictitiousFunctionClassFactory;
            synchronized (map) {
                ag agVar = map.get(DatabaseTableConfigUtil());
                if (agVar != null) {
                    Iterator<String> it = agVar.PlaceComponentResult(true).iterator();
                    while (it.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", it.next()));
                    }
                }
            }
        } else {
            arrayList2 = scheduleImpl2.MyBillsEntityDataFactory(format);
        }
        Iterator<String> it2 = arrayList2.iterator();
        IOException e = null;
        while (it2.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it2.next()).buildUpon();
            for (x xVar : arrayList3) {
                buildUpon.appendQueryParameter(xVar.KClassImpl$Data$declaredNonStaticMembers$2(), xVar.PlaceComponentResult());
            }
            try {
                b bVar = this.MyBillsEntityDataFactory;
                return bVar == null ? y.getAuthRequestContext(PlaceComponentResult, new URL(buildUpon.toString())) : bVar.BuiltInFictitiousFunctionClassFactory(buildUpon.toString());
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("network exception: ");
        sb.append(e.getMessage());
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        throw e;
    }

    public final ag PlaceComponentResult(String str) {
        int i = PrepareContext + 119;
        newProxyInstance = i % 128;
        int i2 = i % 2;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty");
        }
        ag MyBillsEntityDataFactory = MyBillsEntityDataFactory(new URL(str).getHost(), true);
        int i3 = PrepareContext + 27;
        newProxyInstance = i3 % 128;
        int i4 = i3 % 2;
        return MyBillsEntityDataFactory;
    }

    public final void getAuthRequestContext() {
        ArrayList<String> arrayList;
        synchronized (this.getAuthRequestContext) {
            GetContactSyncConfig();
            arrayList = new ArrayList<>(this.getAuthRequestContext.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ah ahVar = this.getAuthRequestContext.get(arrayList.get(size));
                if (ahVar != null && ahVar.PlaceComponentResult() != null) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<ag> KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (KClassImpl$Data$declaredNonStaticMembers$22.get(i) != null) {
                getAuthRequestContext(arrayList.get(i), KClassImpl$Data$declaredNonStaticMembers$22.get(i));
            }
        }
    }

    public final void scheduleImpl() {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        synchronized (this.getAuthRequestContext) {
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                String jSONObject = initRecordTimeStamp().toString();
                StringBuilder sb = new StringBuilder();
                sb.append("persist host fallbacks = ");
                sb.append(jSONObject);
                com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory(sb.toString());
                if (TextUtils.isEmpty(jSONObject)) {
                    fileOutputStream = null;
                } else {
                    fileOutputStream = PlaceComponentResult.openFileOutput(moveToNextValue(), 0);
                    try {
                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    } catch (Exception e) {
                        e = e;
                    } catch (Throwable th2) {
                        th = th2;
                        h.MyBillsEntityDataFactory(bufferedOutputStream2);
                        h.MyBillsEntityDataFactory(fileOutputStream);
                        throw th;
                    }
                    try {
                        bufferedOutputStream.write(com.xiaomi.channel.commonutils.android.b.MyBillsEntityDataFactory(lookAheadTest(), jSONObject.getBytes(StandardCharsets.UTF_8)));
                        bufferedOutputStream.flush();
                        bufferedOutputStream2 = bufferedOutputStream;
                    } catch (Exception e2) {
                        e = e2;
                        bufferedOutputStream2 = bufferedOutputStream;
                        try {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("persist bucket failure: ");
                            sb2.append(e.getMessage());
                            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
                            h.MyBillsEntityDataFactory(bufferedOutputStream2);
                            h.MyBillsEntityDataFactory(fileOutputStream);
                        } catch (Throwable th3) {
                            bufferedOutputStream = bufferedOutputStream2;
                            th = th3;
                            th = th;
                            bufferedOutputStream2 = bufferedOutputStream;
                            h.MyBillsEntityDataFactory(bufferedOutputStream2);
                            h.MyBillsEntityDataFactory(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        th = th;
                        bufferedOutputStream2 = bufferedOutputStream;
                        h.MyBillsEntityDataFactory(bufferedOutputStream2);
                        h.MyBillsEntityDataFactory(fileOutputStream);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
            }
            h.MyBillsEntityDataFactory(bufferedOutputStream2);
            h.MyBillsEntityDataFactory(fileOutputStream);
        }
    }

    private ArrayList<ag> KClassImpl$Data$declaredNonStaticMembers$2(ArrayList<String> arrayList) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        isLayoutRequested();
        synchronized (this.getAuthRequestContext) {
            GetContactSyncConfig();
            for (String str : this.getAuthRequestContext.keySet()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        Map<String, ag> map = BuiltInFictitiousFunctionClassFactory;
        synchronized (map) {
            for (Object obj : map.values().toArray()) {
                ag agVar = (ag) obj;
                if (!agVar.getAuthRequestContext()) {
                    BuiltInFictitiousFunctionClassFactory.remove(agVar.KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
        }
        if (!arrayList.contains(DatabaseTableConfigUtil())) {
            arrayList.add(DatabaseTableConfigUtil());
        }
        ArrayList<ag> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(null);
        }
        try {
            String str2 = y.getAuthRequestContext(PlaceComponentResult) ? "wifi" : "wap";
            String MyBillsEntityDataFactory = MyBillsEntityDataFactory(arrayList, str2, this.NetworkUserEntityData$$ExternalSyntheticLambda1, true);
            if (!TextUtils.isEmpty(MyBillsEntityDataFactory)) {
                JSONObject jSONObject3 = new JSONObject(MyBillsEntityDataFactory);
                com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory(MyBillsEntityDataFactory);
                if ("OK".equalsIgnoreCase(jSONObject3.getString("S"))) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                    String string = jSONObject4.getString("province");
                    String string2 = jSONObject4.getString("city");
                    String string3 = jSONObject4.getString("isp");
                    String string4 = jSONObject4.getString(SemanticAttributes.NetTransportValues.IP);
                    String string5 = jSONObject4.getString(GeocoderResultMapperKt.COUNTRY);
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("get bucket: net=");
                    sb.append(string3);
                    sb.append(", hosts=");
                    sb.append(jSONObject5.toString());
                    com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb.toString());
                    int i2 = 0;
                    while (i2 < arrayList.size()) {
                        String str3 = arrayList.get(i2);
                        JSONArray optJSONArray = jSONObject5.optJSONArray(str3);
                        if (optJSONArray == null) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("no bucket found for ");
                            sb2.append(str3);
                            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
                            jSONObject = jSONObject5;
                        } else {
                            ag agVar2 = new ag(str3);
                            int i3 = 0;
                            while (i3 < optJSONArray.length()) {
                                String string6 = optJSONArray.getString(i3);
                                if (TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                } else {
                                    jSONObject2 = jSONObject5;
                                    agVar2.MyBillsEntityDataFactory(new ap(string6, optJSONArray.length() - i3));
                                }
                                i3++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList2.set(i2, agVar2);
                            agVar2.NetworkUserEntityData$$ExternalSyntheticLambda0 = string5;
                            agVar2.MyBillsEntityDataFactory = string;
                            agVar2.lookAheadTest = string3;
                            agVar2.moveToNextValue = string4;
                            agVar2.PlaceComponentResult = string2;
                            if (jSONObject4.has("stat-percent")) {
                                agVar2.getAuthRequestContext = jSONObject4.getDouble("stat-percent");
                            }
                            if (jSONObject4.has("stat-domain")) {
                                agVar2.getErrorConfigVersion = jSONObject4.getString("stat-domain");
                            }
                            if (jSONObject4.has("ttl")) {
                                agVar2.getAuthRequestContext(jSONObject4.getInt("ttl") * 1000);
                            }
                            KClassImpl$Data$declaredNonStaticMembers$2(agVar2.MyBillsEntityDataFactory());
                        }
                        i2++;
                        jSONObject5 = jSONObject;
                    }
                    JSONObject optJSONObject = jSONObject4.optJSONObject("reserved");
                    if (optJSONObject != null) {
                        long j = FileCache.EXPIRE_TIME;
                        if (jSONObject4.has("reserved-ttl")) {
                            j = jSONObject4.getInt("reserved-ttl") * 1000;
                        }
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                            if (optJSONArray2 == null) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("no bucket found for ");
                                sb3.append(next);
                                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb3.toString());
                            } else {
                                ag agVar3 = new ag(next);
                                agVar3.getAuthRequestContext(j);
                                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                    String string7 = optJSONArray2.getString(i4);
                                    if (!TextUtils.isEmpty(string7)) {
                                        agVar3.MyBillsEntityDataFactory(new ap(string7, optJSONArray2.length() - i4));
                                    }
                                }
                                Map<String, ag> map2 = BuiltInFictitiousFunctionClassFactory;
                                synchronized (map2) {
                                    map2.put(next, agVar3);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("failed to get bucket ");
            sb4.append(e.getMessage());
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb4.toString());
        }
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            ag agVar4 = arrayList2.get(i5);
            if (agVar4 != null) {
                getAuthRequestContext(arrayList.get(i5), agVar4);
            }
        }
        scheduleImpl();
        return arrayList2;
    }

    private void getErrorConfigVersion(String str) {
        synchronized (this.getAuthRequestContext) {
            this.getAuthRequestContext.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") != 2) {
                throw new JSONException("Bad version");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    ah BuiltInFictitiousFunctionClassFactory2 = new ah().BuiltInFictitiousFunctionClassFactory(optJSONArray.getJSONObject(i));
                    this.getAuthRequestContext.put(BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory, BuiltInFictitiousFunctionClassFactory2);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("reserved");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                    String optString = jSONObject2.optString("host");
                    if (!TextUtils.isEmpty(optString)) {
                        try {
                            ag PlaceComponentResult2 = new ag(optString).PlaceComponentResult(jSONObject2);
                            BuiltInFictitiousFunctionClassFactory.put(PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult2);
                            StringBuilder sb = new StringBuilder();
                            sb.append("load local reserved host for ");
                            sb.append(PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2);
                            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                        } catch (JSONException unused) {
                            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("parse reserved host fail.");
                        }
                    }
                }
            }
        }
    }

    private void isLayoutRequested() {
        String next;
        synchronized (this.getAuthRequestContext) {
            Iterator<ah> it = this.getAuthRequestContext.values().iterator();
            while (it.hasNext()) {
                it.next().getAuthRequestContext();
            }
            while (true) {
                for (boolean z = false; !z; z = true) {
                    Iterator<String> it2 = this.getAuthRequestContext.keySet().iterator();
                    while (it2.hasNext()) {
                        next = it2.next();
                        if (this.getAuthRequestContext.get(next).PlaceComponentResult.isEmpty()) {
                            break;
                        }
                    }
                }
                this.getAuthRequestContext.remove(next);
            }
        }
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        int length;
        int[] iArr2;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr3 = NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (iArr3 != null) {
            try {
                int i2 = $11 + 3;
                try {
                    $10 = i2 % 128;
                    if (i2 % 2 != 0) {
                        length = iArr3.length;
                        iArr2 = new int[length];
                    } else {
                        length = iArr3.length;
                        iArr2 = new int[length];
                    }
                    int i3 = 0;
                    while (true) {
                        if ((i3 < length ? InputCardNumberView.DIVIDER : '1') != ' ') {
                            break;
                        }
                        iArr2[i3] = (int) (iArr3[i3] ^ (-3152031022165484798L));
                        i3++;
                    }
                    iArr3 = iArr2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int length2 = iArr3.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i4 = 0;
            while (i4 < length3) {
                iArr6[i4] = (int) (iArr5[i4] ^ (-3152031022165484798L));
                i4++;
                length3 = length3;
            }
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        int i5 = $10 + 45;
        $11 = i5 % 128;
        int i6 = i5 % 2;
        while (true) {
            if (!(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length)) {
                break;
            }
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            for (int i7 = 0; i7 < 16; i7++) {
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i7];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                int i8 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i8;
            }
            int i9 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i9;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
            int i10 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i11 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
            cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
            cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
        }
        String str = new String(cArr2, 0, i);
        int i12 = $10 + 51;
        $11 = i12 % 128;
        if (i12 % 2 != 0) {
            objArr[0] = str;
            return;
        }
        Object obj = null;
        obj.hashCode();
        objArr[0] = str;
    }
}
