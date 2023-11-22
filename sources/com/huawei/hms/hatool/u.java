package com.huawei.hms.hatool;

import android.graphics.PointF;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import o.D;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class u {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
    private static long lookAheadTest = 4956913065516943071L;
    private static int scheduleImpl = 1;
    public String BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public List<q> PlaceComponentResult;
    public String getAuthRequestContext;

    public u(String str, String str2, String str3, List<q> list, String str4) {
        this.getAuthRequestContext = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.PlaceComponentResult = list;
        this.MyBillsEntityDataFactory = str4;
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        if ((q0.BuiltInFictitiousFunctionClassFactory(b.lookAheadTest(), "backup_event", 5242880) ? 'U' : (char) 2) == 'U') {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 87;
            scheduleImpl = i % 128;
            boolean z = i % 2 == 0;
            y.MyBillsEntityDataFactory("hmsSdk", "backup file reach max limited size, discard new event ");
            if (!z) {
                return;
            }
            Object obj = null;
            obj.hashCode();
            return;
        }
        JSONArray MyBillsEntityDataFactory = MyBillsEntityDataFactory();
        String BuiltInFictitiousFunctionClassFactory = u0.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory);
        StringBuilder sb = new StringBuilder();
        sb.append("Update data cached into backup,spKey: ");
        sb.append(BuiltInFictitiousFunctionClassFactory);
        y.BuiltInFictitiousFunctionClassFactory("hmsSdk", sb.toString());
        g0.getAuthRequestContext(b.lookAheadTest(), "backup_event", BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.toString());
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 11;
        scheduleImpl = i2 % 128;
        if ((i2 % 2 == 0 ? '2' : 'H') != '2') {
            return;
        }
        int i3 = 99 / 0;
    }

    private static String PlaceComponentResult(String str, String str2) {
        String scheduleImpl2 = c.scheduleImpl(str, str2);
        if (!(TextUtils.isEmpty(scheduleImpl2))) {
            String str3 = "{url}/common/hmshioperqrt";
            if (("oper".equals(str2) ? '\f' : (char) 27) != 27) {
                int i = scheduleImpl + 93;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                if (i % 2 != 0) {
                    int i2 = 40 / 0;
                }
            } else if ("maint".equals(str2)) {
                str3 = "{url}/common/hmshimaintqrt";
            } else if (!"diffprivacy".equals(str2)) {
                return "";
            } else {
                str3 = "{url}/common/common2";
            }
            return str3.replace("{url}", scheduleImpl2);
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 69;
        scheduleImpl = i3 % 128;
        if ((i3 % 2 == 0 ? 'J' : 'T') == 'J') {
            Object[] objArr = new Object[2];
            objArr[1] = str;
            objArr[1] = str2;
            y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "No report address,TAG : %s,TYPE: %s ", objArr);
            return "";
        }
        try {
            Object[] objArr2 = new Object[2];
            objArr2[0] = str;
            objArr2[1] = str2;
            try {
                y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "No report address,TAG : %s,TYPE: %s ", objArr2);
                return "";
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static byte[] PlaceComponentResult(C0220r c0220r) {
        String str;
        try {
            JSONObject PlaceComponentResult = c0220r.PlaceComponentResult();
            if ((PlaceComponentResult == null ? 'K' : 'A') == 'K') {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 79;
                scheduleImpl = i % 128;
                int i2 = i % 2;
                y.PlaceComponentResult("hmsSdk", "uploadEvents is null");
                byte[] bArr = new byte[0];
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 35;
                scheduleImpl = i3 % 128;
                int i4 = i3 % 2;
                return bArr;
            }
            String jSONObject = PlaceComponentResult.toString();
            Object[] objArr = new Object[1];
            a(1 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{11281, 52714, 3216, 11332, 1928, 50825, 6840, 9728, 245}, objArr);
            byte[] KClassImpl$Data$declaredNonStaticMembers$2 = t0.KClassImpl$Data$declaredNonStaticMembers$2(jSONObject.getBytes(((String) objArr[0]).intern()));
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 15;
            scheduleImpl = i5 % 128;
            if ((i5 % 2 == 0 ? 'E' : (char) 23) != 'E') {
                return KClassImpl$Data$declaredNonStaticMembers$2;
            }
            int i6 = 60 / 0;
            return KClassImpl$Data$declaredNonStaticMembers$2;
        } catch (UnsupportedEncodingException unused) {
            str = "sendData(): getBytes - Unsupported coding format!!";
            y.PlaceComponentResult("hmsSdk", str);
            return new byte[0];
        } catch (JSONException unused2) {
            str = "uploadEvents to json error";
            y.PlaceComponentResult("hmsSdk", str);
            return new byte[0];
        }
    }

    private C0220r getAuthRequestContext() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 43;
        scheduleImpl = i % 128;
        if (!(i % 2 != 0)) {
            int i2 = 92 / 0;
            return d1.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory);
        }
        try {
            return d1.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
    
        if ((!r0 ? '-' : 'Z') != '-') goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006b, code lost:
    
        if ("_openness_config_tag".equals(r10.getAuthRequestContext) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006d, code lost:
    
        BuiltInFictitiousFunctionClassFactory();
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        /*
            Method dump skipped, instructions count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.u.KClassImpl$Data$declaredNonStaticMembers$2():void");
    }

    private JSONArray MyBillsEntityDataFactory() {
        JSONArray jSONArray = new JSONArray();
        Iterator<q> it = this.PlaceComponentResult.iterator();
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 33;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        while (true) {
            if ((it.hasNext() ? 'P' : (char) 21) == 21) {
                return jSONArray;
            }
            try {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 85;
                try {
                    scheduleImpl = i3 % 128;
                    int i4 = i3 % 2;
                    q next = it.next();
                    try {
                        JSONObject PlaceComponentResult = next.PlaceComponentResult();
                        PlaceComponentResult.put("properties", d.KClassImpl$Data$declaredNonStaticMembers$2(next.KClassImpl$Data$declaredNonStaticMembers$2, d0.PlaceComponentResult().MyBillsEntityDataFactory()));
                        jSONArray.put(PlaceComponentResult);
                    } catch (JSONException unused) {
                        y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "handleEvents: json error,Abandon this data");
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(lookAheadTest ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (true) {
            if ((d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length ? 'c' : 'K') == 'K') {
                break;
            }
            int i2 = $11 + 103;
            $10 = i2 % 128;
            int i3 = i2 % 2;
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (lookAheadTest ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
        }
        String str = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
        int i4 = $11 + 15;
        $10 = i4 % 128;
        if ((i4 % 2 != 0 ? 'N' : '\f') == '\f') {
            objArr[0] = str;
            return;
        }
        Object obj = null;
        obj.hashCode();
        objArr[0] = str;
    }
}
