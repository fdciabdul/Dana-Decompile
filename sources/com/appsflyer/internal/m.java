package com.appsflyer.internal;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;
import o.E;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class m implements Runnable {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = -956812108;
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = 4360990799332652212L;
    private static char MyBillsEntityDataFactory = 3402;
    private static int PlaceComponentResult = 1;
    private static int getAuthRequestContext;
    private final bf AFKeystoreWrapper;

    public m() {
    }

    public static JSONObject AFInAppEventType(Map<String, ?> map) {
        JSONObject jSONObject = new JSONObject();
        Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
        int i = getAuthRequestContext + 45;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        while (true) {
            if ((it.hasNext() ? '?' : 'Z') == 'Z') {
                return jSONObject;
            }
            int i3 = getAuthRequestContext + 11;
            PlaceComponentResult = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 25 : Typography.amp) != '&') {
                try {
                    Map.Entry<String, ?> next = it.next();
                    try {
                        jSONObject.put(next.getKey(), valueOf(next.getValue()));
                        Object[] objArr = null;
                        int length = objArr.length;
                    } catch (JSONException unused) {
                    }
                } catch (Exception e) {
                    throw e;
                }
            } else {
                Map.Entry<String, ?> next2 = it.next();
                jSONObject.put(next2.getKey(), valueOf(next2.getValue()));
            }
        }
    }

    private static Object valueOf(Object obj) {
        try {
            if (obj == null) {
                return JSONObject.NULL;
            }
            if (obj instanceof JSONArray) {
                return obj;
            }
            if ((obj instanceof JSONObject ? 'J' : '?') != '?') {
                return obj;
            }
            if (obj.equals(JSONObject.NULL)) {
                int i = getAuthRequestContext + 27;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                return obj;
            }
            try {
                try {
                    if (obj instanceof Collection) {
                        JSONArray jSONArray = new JSONArray();
                        Iterator it = ((Collection) obj).iterator();
                        while (it.hasNext()) {
                            jSONArray.put(valueOf(it.next()));
                        }
                        return jSONArray;
                    }
                    if (obj.getClass().isArray()) {
                        int length = Array.getLength(obj);
                        JSONArray jSONArray2 = new JSONArray();
                        for (int i3 = 0; i3 < length; i3++) {
                            jSONArray2.put(valueOf(Array.get(obj, i3)));
                        }
                        int i4 = getAuthRequestContext + 69;
                        PlaceComponentResult = i4 % 128;
                        if (!(i4 % 2 == 0)) {
                            return jSONArray2;
                        }
                        Object[] objArr = null;
                        int length2 = objArr.length;
                        return jSONArray2;
                    }
                    if (!(obj instanceof Map)) {
                        if (obj instanceof Boolean) {
                            return obj;
                        }
                        int i5 = getAuthRequestContext + 17;
                        PlaceComponentResult = i5 % 128;
                        if (i5 % 2 == 0) {
                            int i6 = 18 / 0;
                            if (obj instanceof Byte) {
                                return obj;
                            }
                        } else if (obj instanceof Byte) {
                            return obj;
                        }
                        if ((obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float)) {
                            return obj;
                        }
                        int i7 = PlaceComponentResult + 87;
                        getAuthRequestContext = i7 % 128;
                        int i8 = i7 % 2;
                        if ((obj instanceof Integer) || (obj instanceof Long)) {
                            return obj;
                        }
                        if (obj instanceof Short) {
                            return obj;
                        }
                        int i9 = PlaceComponentResult + 27;
                        getAuthRequestContext = i9 % 128;
                        int i10 = i9 % 2;
                        if (obj instanceof String) {
                            int i11 = getAuthRequestContext + 43;
                            PlaceComponentResult = i11 % 128;
                            int i12 = i11 % 2;
                            return obj;
                        }
                        return obj.toString();
                    }
                    return AFInAppEventType((Map) obj);
                } catch (Exception unused) {
                    return JSONObject.NULL;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static Map<String, Object> AFInAppEventType(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (true) {
            try {
                if ((keys.hasNext() ? (char) 2 : '-') != 2) {
                    return hashMap;
                }
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if ((obj instanceof JSONArray ? Typography.amp : '\\') != '\\') {
                    int i = getAuthRequestContext + 11;
                    PlaceComponentResult = i % 128;
                    int i2 = i % 2;
                    obj = AFInAppEventType((JSONArray) obj);
                    int i3 = PlaceComponentResult + 83;
                    getAuthRequestContext = i3 % 128;
                    int i4 = i3 % 2;
                } else {
                    if ((obj instanceof JSONObject ? '`' : (char) 7) != 7) {
                        try {
                            obj = AFInAppEventType((JSONObject) obj);
                            int i5 = PlaceComponentResult + 9;
                            getAuthRequestContext = i5 % 128;
                            int i6 = i5 % 2;
                        } catch (Exception e) {
                            throw e;
                        }
                    } else {
                        continue;
                    }
                }
                hashMap.put(next, obj);
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x0021, code lost:
    
        if (r4 != false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0032, code lost:
    
        if ((!(r3 instanceof org.json.JSONArray)) != true) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0034, code lost:
    
        r3 = AFInAppEventType((org.json.JSONArray) r3);
        r4 = com.appsflyer.internal.m.PlaceComponentResult + 113;
        com.appsflyer.internal.m.getAuthRequestContext = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0049, code lost:
    
        if ((r3 instanceof org.json.JSONObject) == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x004b, code lost:
    
        r4 = 27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x004e, code lost:
    
        r4 = '\\';
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0050, code lost:
    
        if (r4 == '\\') goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0052, code lost:
    
        r3 = AFInAppEventType((org.json.JSONObject) r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<java.lang.Object> AFInAppEventType(org.json.JSONArray r6) throws org.json.JSONException {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = 0
        L7:
            int r3 = r6.length()
            if (r2 >= r3) goto L60
            int r3 = com.appsflyer.internal.m.PlaceComponentResult     // Catch: java.lang.Exception -> L5e
            int r3 = r3 + 79
            int r4 = r3 % 128
            com.appsflyer.internal.m.getAuthRequestContext = r4     // Catch: java.lang.Exception -> L5e
            int r3 = r3 % 2
            if (r3 == 0) goto L26
            java.lang.Object r3 = r6.get(r2)
            boolean r4 = r3 instanceof org.json.JSONArray
            r5 = 0
            int r5 = r5.length     // Catch: java.lang.Throwable -> L24
            if (r4 == 0) goto L45
            goto L34
        L24:
            r6 = move-exception
            throw r6
        L26:
            java.lang.Object r3 = r6.get(r2)
            boolean r4 = r3 instanceof org.json.JSONArray
            r5 = 1
            if (r4 == 0) goto L31
            r4 = 0
            goto L32
        L31:
            r4 = 1
        L32:
            if (r4 == r5) goto L45
        L34:
            org.json.JSONArray r3 = (org.json.JSONArray) r3
            java.util.List r3 = AFInAppEventType(r3)
            int r4 = com.appsflyer.internal.m.PlaceComponentResult
            int r4 = r4 + 113
            int r5 = r4 % 128
            com.appsflyer.internal.m.getAuthRequestContext = r5
            int r4 = r4 % 2
            goto L58
        L45:
            boolean r4 = r3 instanceof org.json.JSONObject
            r5 = 92
            if (r4 == 0) goto L4e
            r4 = 27
            goto L50
        L4e:
            r4 = 92
        L50:
            if (r4 == r5) goto L58
            org.json.JSONObject r3 = (org.json.JSONObject) r3
            java.util.Map r3 = AFInAppEventType(r3)
        L58:
            r0.add(r3)     // Catch: java.lang.Exception -> L5e
            int r2 = r2 + 1
            goto L7
        L5e:
            r6 = move-exception
            throw r6
        L60:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.m.AFInAppEventType(org.json.JSONArray):java.util.List");
    }

    public m(bf bfVar) {
        this.AFKeystoreWrapper = bfVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:264:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0251  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.net.HttpURLConnection AFInAppEventType() {
        /*
            Method dump skipped, instructions count: 614
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.m.AFInAppEventType():java.net.HttpURLConnection");
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x001d, code lost:
    
        if (r0 != null) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x002b, code lost:
    
        if ((r0 == null) != false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x002e, code lost:
    
        r1 = com.appsflyer.internal.m.PlaceComponentResult + 9;
        com.appsflyer.internal.m.getAuthRequestContext = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x003a, code lost:
    
        if ((r1 % 2) == 0) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x003c, code lost:
    
        r1 = '4';
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x003f, code lost:
    
        r1 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0041, code lost:
    
        if (r1 == 30) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0043, code lost:
    
        r0.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0046, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x004c, code lost:
    
        r0.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x005a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x005b, code lost:
    
        throw r0;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r4 = this;
            int r0 = com.appsflyer.internal.m.PlaceComponentResult     // Catch: java.lang.Exception -> L5c
            int r0 = r0 + 57
            int r1 = r0 % 128
            com.appsflyer.internal.m.getAuthRequestContext = r1     // Catch: java.lang.Exception -> L5c
            int r0 = r0 % 2
            r1 = 94
            if (r0 == 0) goto L11
            r0 = 70
            goto L13
        L11:
            r0 = 94
        L13:
            r2 = 0
            if (r0 == r1) goto L22
            java.net.HttpURLConnection r0 = r4.AFInAppEventType()
            r2.hashCode()     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L4f
            goto L2e
        L20:
            r0 = move-exception
            throw r0
        L22:
            java.net.HttpURLConnection r0 = r4.AFInAppEventType()
            if (r0 == 0) goto L2a
            r1 = 0
            goto L2b
        L2a:
            r1 = 1
        L2b:
            if (r1 == 0) goto L2e
            goto L4f
        L2e:
            int r1 = com.appsflyer.internal.m.PlaceComponentResult
            int r1 = r1 + 9
            int r3 = r1 % 128
            com.appsflyer.internal.m.getAuthRequestContext = r3
            int r1 = r1 % 2
            r3 = 30
            if (r1 == 0) goto L3f
            r1 = 52
            goto L41
        L3f:
            r1 = 30
        L41:
            if (r1 == r3) goto L4c
            r0.disconnect()
            r2.hashCode()     // Catch: java.lang.Throwable -> L4a
            goto L4f
        L4a:
            r0 = move-exception
            throw r0
        L4c:
            r0.disconnect()     // Catch: java.lang.Exception -> L5a
        L4f:
            int r0 = com.appsflyer.internal.m.getAuthRequestContext
            int r0 = r0 + 89
            int r1 = r0 % 128
            com.appsflyer.internal.m.PlaceComponentResult = r1
            int r0 = r0 % 2
            return
        L5a:
            r0 = move-exception
            throw r0
        L5c:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.m.run():void");
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
            if ((e.KClassImpl$Data$declaredNonStaticMembers$2 < length3 ? 'V' : ':') != 'V') {
                break;
            }
            int i2 = $11 + 101;
            $10 = i2 % 128;
            int i3 = i2 % 2;
            int i4 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i5 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i4]) % 65535);
            cArr5[i5] = (char) (((cArr4[i5] * 32718) + cArr5[i4]) / 65535);
            cArr4[i5] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i5] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L)) ^ ((int) (BuiltInFictitiousFunctionClassFactory ^ 4360990799332652212L))) ^ ((char) (MyBillsEntityDataFactory ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        String str = new String(cArr6);
        int i6 = $11 + 97;
        $10 = i6 % 128;
        if (i6 % 2 == 0) {
            objArr[0] = str;
            return;
        }
        Object obj = null;
        obj.hashCode();
        objArr[0] = str;
    }
}
