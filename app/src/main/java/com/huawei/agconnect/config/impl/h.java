package com.huawei.agconnect.config.impl;

import java.io.InputStream;
import java.util.Iterator;
import o.E;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class h implements d {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 13492;
    private static int MyBillsEntityDataFactory = -956812108;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static int PlaceComponentResult = 0;
    private static long getAuthRequestContext = 7884532185879898686L;
    private final JSONObject KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(InputStream inputStream) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(InputStream inputStream, String str) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory(inputStream);
        BuiltInFictitiousFunctionClassFactory(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void BuiltInFictitiousFunctionClassFactory(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.config.impl.h.BuiltInFictitiousFunctionClassFactory(java.lang.String):void");
    }

    private JSONObject KClassImpl$Data$declaredNonStaticMembers$2(String str) throws JSONException {
        JSONArray jSONArray = this.KClassImpl$Data$declaredNonStaticMembers$2.getJSONArray("appInfos");
        int i = 0;
        while (true) {
            Object[] objArr = null;
            if ((i < jSONArray.length() ? '6' : '0') != '6') {
                return null;
            }
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject.getString("package_name").equals(str)) {
                int i2 = PlaceComponentResult + 39;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
                if ((i2 % 2 == 0 ? 'V' : '+') != '+') {
                    int length = objArr.length;
                    return jSONObject;
                }
                return jSONObject;
            }
            i++;
            int i3 = PlaceComponentResult + 85;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(String str, Object obj, JSONObject jSONObject) throws JSONException {
        if ((str != null) && obj != null) {
            int i = PlaceComponentResult + 31;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            if (i % 2 == 0) {
                int i2 = 75 / 0;
                if ((jSONObject != null ? '\f' : 'J') != '\f') {
                    return;
                }
            } else {
                if ((jSONObject != null ? '\r' : (char) 28) != '\r') {
                    return;
                }
            }
            try {
                if (!(obj instanceof JSONObject)) {
                    jSONObject.put(str, obj);
                    int i3 = PlaceComponentResult + 89;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                    int i4 = i3 % 2;
                    return;
                }
                JSONObject jSONObject2 = (JSONObject) obj;
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    KClassImpl$Data$declaredNonStaticMembers$2(next, jSONObject2.get(next), jSONObject.getJSONObject(str));
                    int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 5;
                    PlaceComponentResult = i5 % 128;
                    int i6 = i5 % 2;
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
    
        if (r12 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
    
        r3 = new java.lang.Object[1];
        a(new char[]{30825, 50200, 45725, 47834, 17711}, new char[]{55615, 49592, 4624, 8204}, (char) (3090 - android.text.TextUtils.getOffsetBefore("", 0)), new char[]{24202, 31097, 9785, 20974}, 281131224 - android.text.TextUtils.indexOf((java.lang.CharSequence) "", '0', 0), r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x008d, code lost:
    
        return new org.json.JSONObject(com.huawei.agconnect.config.impl.Utils.getAuthRequestContext(r12, ((java.lang.String) r3[0]).intern()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x008e, code lost:
    
        r12 = "JSONException when reading the 'Config' from InputStream.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0091, code lost:
    
        r12 = "IOException when reading the 'Config' from InputStream.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0093, code lost:
    
        com.fullstory.instrumentation.InstrumentInjector.log_e("InputStreamReader", r12);
        r12 = com.huawei.agconnect.config.impl.h.NetworkUserEntityData$$ExternalSyntheticLambda0 + 101;
        com.huawei.agconnect.config.impl.h.PlaceComponentResult = r12 % 128;
        r12 = r12 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
    
        if (r12 != null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.json.JSONObject MyBillsEntityDataFactory(java.io.InputStream r12) {
        /*
            java.lang.String r0 = ""
            int r1 = com.huawei.agconnect.config.impl.h.PlaceComponentResult
            int r1 = r1 + 31
            int r2 = r1 % 128
            com.huawei.agconnect.config.impl.h.NetworkUserEntityData$$ExternalSyntheticLambda0 = r2
            r2 = 2
            int r1 = r1 % r2
            r3 = 1
            r4 = 0
            if (r1 != 0) goto L12
            r1 = 0
            goto L13
        L12:
            r1 = 1
        L13:
            if (r1 == 0) goto L18
            if (r12 == 0) goto La1
            goto L1e
        L18:
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> La7
            if (r12 == 0) goto La1
        L1e:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            r5 = 5
            char[] r6 = new char[r5]     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            r5 = 30825(0x7869, float:4.3195E-41)
            r6[r4] = r5     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            r5 = 50200(0xc418, float:7.0345E-41)
            r6[r3] = r5     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            r5 = 45725(0xb29d, float:6.4074E-41)
            r6[r2] = r5     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            r5 = 47834(0xbada, float:6.703E-41)
            r7 = 3
            r6[r7] = r5     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            r5 = 17711(0x452f, float:2.4818E-41)
            r8 = 4
            r6[r8] = r5     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            char[] r5 = new char[r8]     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            r9 = 55615(0xd93f, float:7.7933E-41)
            r5[r4] = r9     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            r9 = 49592(0xc1b8, float:6.9493E-41)
            r5[r3] = r9     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            r9 = 4624(0x1210, float:6.48E-42)
            r5[r2] = r9     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            r9 = 8204(0x200c, float:1.1496E-41)
            r5[r7] = r9     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            int r9 = android.text.TextUtils.getOffsetBefore(r0, r4)     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            int r9 = 3090 - r9
            char r9 = (char) r9     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            char[] r10 = new char[r8]     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            r8 = 24202(0x5e8a, float:3.3914E-41)
            r10[r4] = r8     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            r8 = 31097(0x7979, float:4.3576E-41)
            r10[r3] = r8     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            r8 = 9785(0x2639, float:1.3712E-41)
            r10[r2] = r8     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            r8 = 20974(0x51ee, float:2.9391E-41)
            r10[r7] = r8     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            r7 = 281131224(0x10c1b8d8, float:7.6409874E-29)
            r8 = 48
            int r0 = android.text.TextUtils.indexOf(r0, r8, r4)     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            int r0 = r7 - r0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            r7 = r5
            r8 = r9
            r9 = r10
            r10 = r0
            r11 = r3
            a(r6, r7, r8, r9, r10, r11)     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            r0 = r3[r4]     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            java.lang.String r0 = (java.lang.String) r0     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            java.lang.String r0 = r0.intern()     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            java.lang.String r12 = com.huawei.agconnect.config.impl.Utils.getAuthRequestContext(r12, r0)     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            r1.<init>(r12)     // Catch: org.json.JSONException -> L8e java.io.IOException -> L91
            return r1
        L8e:
            java.lang.String r12 = "JSONException when reading the 'Config' from InputStream."
            goto L93
        L91:
            java.lang.String r12 = "IOException when reading the 'Config' from InputStream."
        L93:
            java.lang.String r0 = "InputStreamReader"
            com.fullstory.instrumentation.InstrumentInjector.log_e(r0, r12)
            int r12 = com.huawei.agconnect.config.impl.h.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r12 = r12 + 101
            int r0 = r12 % 128
            com.huawei.agconnect.config.impl.h.PlaceComponentResult = r0
            int r12 = r12 % r2
        La1:
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            return r12
        La7:
            r12 = move-exception
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.config.impl.h.MyBillsEntityDataFactory(java.io.InputStream):org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        if (r7.endsWith("/") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0033, code lost:
    
        if ((r7.endsWith("/") ? '-' : kotlin.text.Typography.quote) != '\"') goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0035, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0036, code lost:
    
        r0 = r7.split("/");
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003a, code lost:
    
        r1 = r6.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        r2 = com.huawei.agconnect.config.impl.h.PlaceComponentResult + 103;
        com.huawei.agconnect.config.impl.h.NetworkUserEntityData$$ExternalSyntheticLambda0 = r2 % 128;
        r2 = r2 % 2;
        r3 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0049, code lost:
    
        if (r3 >= r0.length) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004b, code lost:
    
        r4 = com.huawei.agconnect.config.impl.h.PlaceComponentResult + 107;
        com.huawei.agconnect.config.impl.h.NetworkUserEntityData$$ExternalSyntheticLambda0 = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
    
        if (r3 != (r0.length - 1)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0059, code lost:
    
        r7 = r1.get(r0[r3]).toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0064, code lost:
    
        r1 = r1.getJSONObject(r0[r3]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006a, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006d, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append("JSONException when reading 'path': ");
        r0.append(r7);
        com.fullstory.instrumentation.InstrumentInjector.log_w("InputStreamReader", r0.toString());
     */
    @Override // com.huawei.agconnect.config.impl.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String BuiltInFictitiousFunctionClassFactory(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            int r0 = com.huawei.agconnect.config.impl.h.PlaceComponentResult     // Catch: java.lang.Exception -> L84
            int r0 = r0 + 39
            int r1 = r0 % 128
            com.huawei.agconnect.config.impl.h.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1
            int r0 = r0 % 2
            r1 = 65
            if (r0 != 0) goto L11
            r0 = 43
            goto L13
        L11:
            r0 = 65
        L13:
            java.lang.String r2 = "/"
            if (r0 == r1) goto L26
            boolean r0 = r7.endsWith(r2)     // Catch: java.lang.Exception -> L24
            r1 = 64
            int r1 = r1 / 0
            if (r0 == 0) goto L36
            goto L35
        L22:
            r7 = move-exception
            throw r7
        L24:
            r7 = move-exception
            throw r7
        L26:
            boolean r0 = r7.endsWith(r2)     // Catch: java.lang.Exception -> L84
            r1 = 34
            if (r0 == 0) goto L31
            r0 = 45
            goto L33
        L31:
            r0 = 34
        L33:
            if (r0 == r1) goto L36
        L35:
            return r8
        L36:
            java.lang.String[] r0 = r7.split(r2)
            org.json.JSONObject r1 = r6.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: org.json.JSONException -> L6d
            int r2 = com.huawei.agconnect.config.impl.h.PlaceComponentResult
            int r2 = r2 + 103
            int r3 = r2 % 128
            com.huawei.agconnect.config.impl.h.NetworkUserEntityData$$ExternalSyntheticLambda0 = r3
            int r2 = r2 % 2
            r2 = 1
            r3 = 1
        L48:
            int r4 = r0.length     // Catch: org.json.JSONException -> L6d
            if (r3 >= r4) goto L83
            int r4 = com.huawei.agconnect.config.impl.h.PlaceComponentResult
            int r4 = r4 + 107
            int r5 = r4 % 128
            com.huawei.agconnect.config.impl.h.NetworkUserEntityData$$ExternalSyntheticLambda0 = r5
            int r4 = r4 % 2
            int r4 = r0.length     // Catch: org.json.JSONException -> L6d
            int r4 = r4 - r2
            if (r3 != r4) goto L64
            r0 = r0[r3]     // Catch: org.json.JSONException -> L6d
            java.lang.Object r0 = r1.get(r0)     // Catch: org.json.JSONException -> L6d
            java.lang.String r7 = r0.toString()     // Catch: org.json.JSONException -> L6d
            return r7
        L64:
            r4 = r0[r3]     // Catch: org.json.JSONException -> L6d
            org.json.JSONObject r1 = r1.getJSONObject(r4)     // Catch: org.json.JSONException -> L6d
            int r3 = r3 + 1
            goto L48
        L6d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "JSONException when reading 'path': "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.String r0 = "InputStreamReader"
            com.fullstory.instrumentation.InstrumentInjector.log_w(r0, r7)
        L83:
            return r8
        L84:
            r7 = move-exception
            goto L87
        L86:
            throw r7
        L87:
            goto L86
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.config.impl.h.BuiltInFictitiousFunctionClassFactory(java.lang.String, java.lang.String):java.lang.String");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("InputStreamReader{config=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2.toString().hashCode());
            sb.append('}');
            String obj = sb.toString();
            int i = PlaceComponentResult + 17;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
            return obj;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (true) {
            if (!(e.KClassImpl$Data$declaredNonStaticMembers$2 >= length3)) {
                int i2 = $11 + 11;
                $10 = i2 % 128;
                int i3 = i2 % 2;
                int i4 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i5 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i4]) % 65535);
                cArr5[i5] = (char) (((cArr4[i5] * 32718) + cArr5[i4]) / 65535);
                cArr4[i5] = e.MyBillsEntityDataFactory;
                cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i5] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (getAuthRequestContext ^ 4360990799332652212L)) ^ ((int) (MyBillsEntityDataFactory ^ 4360990799332652212L))) ^ ((char) (BuiltInFictitiousFunctionClassFactory ^ 4360990799332652212L)));
                e.KClassImpl$Data$declaredNonStaticMembers$2++;
            } else {
                String str = new String(cArr6);
                int i6 = $11 + 111;
                $10 = i6 % 128;
                int i7 = i6 % 2;
                objArr[0] = str;
                return;
            }
        }
    }
}
