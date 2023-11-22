package com.mixpanel.android.mpmetrics;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.j256.ormlite.stmt.query.SimpleComparison;
import id.dana.data.config.source.amcs.result.OTCAcceptExpiryTimeConfigResult;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class SelectorEvaluator {
    private static Calendar MyBillsEntityDataFactory;
    private final JSONObject getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum PropertyType {
        Array,
        Boolean,
        Datetime,
        Null,
        Number,
        Object,
        String,
        Unknown
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SelectorEvaluator(JSONObject jSONObject) throws IllegalArgumentException {
        if (!jSONObject.has("operator") || !jSONObject.has("children")) {
            throw new IllegalArgumentException("Missing required keys: operator children");
        }
        this.getAuthRequestContext = jSONObject;
    }

    private static PropertyType BuiltInFictitiousFunctionClassFactory(Object obj) {
        if (obj == null || obj.equals(JSONObject.NULL)) {
            return PropertyType.Null;
        }
        if (obj instanceof String) {
            return PropertyType.String;
        }
        if (obj instanceof JSONArray) {
            return PropertyType.Array;
        }
        if (obj instanceof JSONObject) {
            return PropertyType.Object;
        }
        if ((obj instanceof Double) || (obj instanceof Integer) || (obj instanceof Number)) {
            return PropertyType.Number;
        }
        if (obj instanceof Boolean) {
            return PropertyType.Boolean;
        }
        if (obj instanceof Date) {
            return PropertyType.Datetime;
        }
        return PropertyType.Unknown;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mixpanel.android.mpmetrics.SelectorEvaluator$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[PropertyType.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[PropertyType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[PropertyType.Datetime.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[PropertyType.Boolean.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[PropertyType.Number.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[PropertyType.String.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[PropertyType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[PropertyType.Object.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static Double PlaceComponentResult(Object obj) {
        int i = AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[BuiltInFictitiousFunctionClassFactory(obj).ordinal()];
        if (i == 2) {
            if (((Date) obj).getTime() > 0) {
                return new Double(r6.getTime());
            }
            return null;
        }
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (i == 3) {
            if (((Boolean) obj).booleanValue()) {
                d = 1.0d;
            }
            return Double.valueOf(d);
        }
        if (i != 4) {
            if (i != 5) {
                return null;
            }
        } else if (obj instanceof Double) {
            return (Double) obj;
        } else {
            if (obj instanceof Integer) {
                return Double.valueOf(((Integer) obj).doubleValue());
            }
            if (obj instanceof Number) {
                return Double.valueOf(((Number) obj).doubleValue());
            }
        }
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            return Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
    }

    private static Boolean MyBillsEntityDataFactory(Object obj) {
        int i = AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[BuiltInFictitiousFunctionClassFactory(obj).ordinal()];
        Boolean bool = Boolean.FALSE;
        switch (i) {
            case 2:
                return Boolean.valueOf(((Date) obj).getTime() > 0);
            case 3:
                return (Boolean) obj;
            case 4:
                return Boolean.valueOf(PlaceComponentResult(obj).doubleValue() != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            case 5:
                return Boolean.valueOf(((String) obj).length() > 0);
            case 6:
                return Boolean.valueOf(((JSONArray) obj).length() > 0);
            case 7:
                return Boolean.valueOf(((JSONObject) obj).length() > 0);
            default:
                return bool;
        }
    }

    private static Double GetContactSyncConfig(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Object DatabaseTableConfigUtil;
        if (!jSONObject.has("operator") || !jSONObject.getString("operator").equals("number") || jSONObject.optJSONArray("children") == null || jSONObject.getJSONArray("children").length() != 1) {
            throw new IllegalArgumentException("Invalid node for cast operator: number");
        }
        JSONObject jSONObject3 = jSONObject.getJSONArray("children").getJSONObject(0);
        if (jSONObject3.has("property")) {
            DatabaseTableConfigUtil = NetworkUserEntityData$$ExternalSyntheticLambda2(jSONObject3, jSONObject2);
        } else {
            DatabaseTableConfigUtil = DatabaseTableConfigUtil(jSONObject3, jSONObject2);
        }
        return PlaceComponentResult(DatabaseTableConfigUtil);
    }

    private static Boolean PlaceComponentResult(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Object DatabaseTableConfigUtil;
        if (!jSONObject.has("operator") || !jSONObject.getString("operator").equals("boolean") || jSONObject.optJSONArray("children") == null || jSONObject.getJSONArray("children").length() != 1) {
            throw new IllegalArgumentException("Invalid node for cast operator: boolean");
        }
        JSONObject jSONObject3 = jSONObject.getJSONArray("children").getJSONObject(0);
        if (jSONObject3.has("property")) {
            DatabaseTableConfigUtil = NetworkUserEntityData$$ExternalSyntheticLambda2(jSONObject3, jSONObject2);
        } else {
            DatabaseTableConfigUtil = DatabaseTableConfigUtil(jSONObject3, jSONObject2);
        }
        return MyBillsEntityDataFactory(DatabaseTableConfigUtil);
    }

    private static Date KClassImpl$Data$declaredNonStaticMembers$2(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Object DatabaseTableConfigUtil;
        if (!jSONObject.has("operator") || !jSONObject.getString("operator").equals("datetime") || jSONObject.optJSONArray("children") == null || jSONObject.getJSONArray("children").length() != 1) {
            throw new IllegalArgumentException("Invalid node for cast operator: datetime");
        }
        JSONObject jSONObject3 = jSONObject.getJSONArray("children").getJSONObject(0);
        if (jSONObject3.has("property")) {
            DatabaseTableConfigUtil = NetworkUserEntityData$$ExternalSyntheticLambda2(jSONObject3, jSONObject2);
        } else {
            DatabaseTableConfigUtil = DatabaseTableConfigUtil(jSONObject3, jSONObject2);
        }
        int i = AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil).ordinal()];
        if (i != 2) {
            if (i != 4) {
                if (i != 5) {
                    return null;
                }
                try {
                    return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US).parse((String) DatabaseTableConfigUtil);
                } catch (ParseException unused) {
                    return null;
                }
            }
            return new Date(PlaceComponentResult(DatabaseTableConfigUtil).longValue());
        }
        return (Date) DatabaseTableConfigUtil;
    }

    private static JSONArray NetworkUserEntityData$$ExternalSyntheticLambda0(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Object DatabaseTableConfigUtil;
        if (!jSONObject.has("operator") || !jSONObject.getString("operator").equals("list") || jSONObject.optJSONArray("children") == null || jSONObject.getJSONArray("children").length() != 1) {
            throw new IllegalArgumentException("Invalid node for cast operator: list");
        }
        JSONObject jSONObject3 = jSONObject.getJSONArray("children").getJSONObject(0);
        if (jSONObject3.has("property")) {
            DatabaseTableConfigUtil = NetworkUserEntityData$$ExternalSyntheticLambda2(jSONObject3, jSONObject2);
        } else {
            DatabaseTableConfigUtil = DatabaseTableConfigUtil(jSONObject3, jSONObject2);
        }
        if (BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil) == PropertyType.Array) {
            return (JSONArray) DatabaseTableConfigUtil;
        }
        return null;
    }

    private static String PrepareContext(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Object DatabaseTableConfigUtil;
        if (!jSONObject.has("operator") || !jSONObject.getString("operator").equals("string") || jSONObject.optJSONArray("children") == null || jSONObject.getJSONArray("children").length() != 1) {
            throw new IllegalArgumentException("Invalid node for cast operator: string");
        }
        JSONObject jSONObject3 = jSONObject.getJSONArray("children").getJSONObject(0);
        if (jSONObject3.has("property")) {
            DatabaseTableConfigUtil = NetworkUserEntityData$$ExternalSyntheticLambda2(jSONObject3, jSONObject2);
        } else {
            DatabaseTableConfigUtil = DatabaseTableConfigUtil(jSONObject3, jSONObject2);
        }
        if (BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil) == PropertyType.Datetime) {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US).format((Date) DatabaseTableConfigUtil);
        }
        if (DatabaseTableConfigUtil != null) {
            return DatabaseTableConfigUtil.toString();
        }
        return null;
    }

    private static Boolean getAuthRequestContext(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Object DatabaseTableConfigUtil;
        Object DatabaseTableConfigUtil2;
        if (!jSONObject.has("operator") || !jSONObject.getString("operator").equals("and") || jSONObject.optJSONArray("children") == null || jSONObject.getJSONArray("children").length() != 2) {
            throw new IllegalArgumentException("Invalid node for operator: and");
        }
        JSONArray jSONArray = jSONObject.getJSONArray("children");
        boolean z = false;
        JSONObject jSONObject3 = jSONArray.getJSONObject(0);
        if (jSONObject3.has("property")) {
            DatabaseTableConfigUtil = NetworkUserEntityData$$ExternalSyntheticLambda2(jSONObject3, jSONObject2);
        } else {
            DatabaseTableConfigUtil = DatabaseTableConfigUtil(jSONObject3, jSONObject2);
        }
        if (MyBillsEntityDataFactory(DatabaseTableConfigUtil).booleanValue()) {
            JSONObject jSONObject4 = jSONArray.getJSONObject(1);
            if (jSONObject4.has("property")) {
                DatabaseTableConfigUtil2 = NetworkUserEntityData$$ExternalSyntheticLambda2(jSONObject4, jSONObject2);
            } else {
                DatabaseTableConfigUtil2 = DatabaseTableConfigUtil(jSONObject4, jSONObject2);
            }
            if (MyBillsEntityDataFactory(DatabaseTableConfigUtil2).booleanValue()) {
                z = true;
            }
        }
        return Boolean.valueOf(z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0067, code lost:
    
        if (MyBillsEntityDataFactory(r4).booleanValue() != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Boolean NetworkUserEntityData$$ExternalSyntheticLambda1(org.json.JSONObject r4, org.json.JSONObject r5) throws org.json.JSONException {
        /*
            java.lang.String r0 = "operator"
            boolean r1 = r4.has(r0)
            if (r1 == 0) goto L6f
            java.lang.String r0 = r4.getString(r0)
            java.lang.String r1 = "or"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L6f
            java.lang.String r0 = "children"
            org.json.JSONArray r1 = r4.optJSONArray(r0)
            if (r1 == 0) goto L6f
            org.json.JSONArray r1 = r4.getJSONArray(r0)
            int r1 = r1.length()
            r2 = 2
            if (r1 != r2) goto L6f
            org.json.JSONArray r4 = r4.getJSONArray(r0)
            r0 = 0
            org.json.JSONObject r1 = r4.getJSONObject(r0)
            java.lang.String r2 = "property"
            boolean r3 = r1.has(r2)
            if (r3 == 0) goto L3d
            java.lang.Object r1 = NetworkUserEntityData$$ExternalSyntheticLambda2(r1, r5)
            goto L41
        L3d:
            java.lang.Object r1 = DatabaseTableConfigUtil(r1, r5)
        L41:
            java.lang.Boolean r1 = MyBillsEntityDataFactory(r1)
            boolean r1 = r1.booleanValue()
            r3 = 1
            if (r1 != 0) goto L69
            org.json.JSONObject r4 = r4.getJSONObject(r3)
            boolean r1 = r4.has(r2)
            if (r1 == 0) goto L5b
            java.lang.Object r4 = NetworkUserEntityData$$ExternalSyntheticLambda2(r4, r5)
            goto L5f
        L5b:
            java.lang.Object r4 = DatabaseTableConfigUtil(r4, r5)
        L5f:
            java.lang.Boolean r4 = MyBillsEntityDataFactory(r4)
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L6a
        L69:
            r0 = 1
        L6a:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
            return r4
        L6f:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Invalid node for operator: or"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.SelectorEvaluator.NetworkUserEntityData$$ExternalSyntheticLambda1(org.json.JSONObject, org.json.JSONObject):java.lang.Boolean");
    }

    private static Boolean moveToNextValue(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Object DatabaseTableConfigUtil;
        Object DatabaseTableConfigUtil2;
        if (!jSONObject.has("operator") || ((!jSONObject.getString("operator").equals("in") && !jSONObject.getString("operator").equals("not in")) || jSONObject.optJSONArray("children") == null || jSONObject.getJSONArray("children").length() != 2)) {
            throw new IllegalArgumentException("Invalid node for operator: (not) in");
        }
        JSONArray jSONArray = jSONObject.getJSONArray("children");
        boolean z = false;
        JSONObject jSONObject3 = jSONArray.getJSONObject(0);
        if (jSONObject3.has("property")) {
            DatabaseTableConfigUtil = NetworkUserEntityData$$ExternalSyntheticLambda2(jSONObject3, jSONObject2);
        } else {
            DatabaseTableConfigUtil = DatabaseTableConfigUtil(jSONObject3, jSONObject2);
        }
        JSONObject jSONObject4 = jSONArray.getJSONObject(1);
        if (jSONObject4.has("property")) {
            DatabaseTableConfigUtil2 = NetworkUserEntityData$$ExternalSyntheticLambda2(jSONObject4, jSONObject2);
        } else {
            DatabaseTableConfigUtil2 = DatabaseTableConfigUtil(jSONObject4, jSONObject2);
        }
        Boolean bool = Boolean.FALSE;
        String obj = DatabaseTableConfigUtil.toString();
        int i = AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil2).ordinal()];
        if (i == 5) {
            bool = Boolean.valueOf(((String) DatabaseTableConfigUtil2).contains(obj));
        } else if (i == 6) {
            JSONArray jSONArray2 = (JSONArray) DatabaseTableConfigUtil2;
            int i2 = 0;
            while (true) {
                if (i2 >= jSONArray2.length()) {
                    break;
                } else if (obj.equals(jSONArray2.getString(i2))) {
                    bool = Boolean.TRUE;
                    break;
                } else {
                    i2++;
                }
            }
        }
        if (jSONObject.getString("operator").equals("in")) {
            z = bool.booleanValue();
        } else if (!bool.booleanValue()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    private static Object initRecordTimeStamp(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Object DatabaseTableConfigUtil;
        Object DatabaseTableConfigUtil2;
        if (!jSONObject.has("operator") || !jSONObject.getString("operator").equals("+") || jSONObject.optJSONArray("children") == null || jSONObject.getJSONArray("children").length() != 2) {
            throw new IllegalArgumentException("Invalid node for operator: +");
        }
        JSONArray jSONArray = jSONObject.getJSONArray("children");
        JSONObject jSONObject3 = jSONArray.getJSONObject(0);
        if (jSONObject3.has("property")) {
            DatabaseTableConfigUtil = NetworkUserEntityData$$ExternalSyntheticLambda2(jSONObject3, jSONObject2);
        } else {
            DatabaseTableConfigUtil = DatabaseTableConfigUtil(jSONObject3, jSONObject2);
        }
        JSONObject jSONObject4 = jSONArray.getJSONObject(1);
        if (jSONObject4.has("property")) {
            DatabaseTableConfigUtil2 = NetworkUserEntityData$$ExternalSyntheticLambda2(jSONObject4, jSONObject2);
        } else {
            DatabaseTableConfigUtil2 = DatabaseTableConfigUtil(jSONObject4, jSONObject2);
        }
        if (BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil) == PropertyType.Number && BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil2) == PropertyType.Number) {
            return Double.valueOf(PlaceComponentResult(DatabaseTableConfigUtil).doubleValue() + PlaceComponentResult(DatabaseTableConfigUtil2).doubleValue());
        }
        if (BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil) == PropertyType.String && BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil2) == PropertyType.String) {
            StringBuilder sb = new StringBuilder();
            sb.append(DatabaseTableConfigUtil);
            sb.append((String) DatabaseTableConfigUtil2);
            return sb.toString();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d4, code lost:
    
        if (r14.equals("%") != false) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Double MyBillsEntityDataFactory(org.json.JSONObject r14, org.json.JSONObject r15) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.SelectorEvaluator.MyBillsEntityDataFactory(org.json.JSONObject, org.json.JSONObject):java.lang.Double");
    }

    private static boolean getAuthRequestContext(Object obj, Object obj2) {
        if (BuiltInFictitiousFunctionClassFactory(obj) == BuiltInFictitiousFunctionClassFactory(obj2)) {
            switch (AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[BuiltInFictitiousFunctionClassFactory(obj).ordinal()]) {
                case 1:
                    return true;
                case 2:
                case 5:
                case 6:
                    return obj.equals(obj2);
                case 3:
                    return MyBillsEntityDataFactory(obj).equals(MyBillsEntityDataFactory(obj2));
                case 4:
                    return PlaceComponentResult(obj).equals(PlaceComponentResult(obj2));
                default:
                    return false;
            }
        }
        return false;
    }

    private static Boolean getErrorConfigVersion(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Object DatabaseTableConfigUtil;
        Object DatabaseTableConfigUtil2;
        if (!jSONObject.has("operator") || ((!jSONObject.getString("operator").equals("==") && !jSONObject.getString("operator").equals("!=")) || jSONObject.optJSONArray("children") == null || jSONObject.getJSONArray("children").length() != 2)) {
            throw new IllegalArgumentException("Invalid node for equality operator");
        }
        JSONArray jSONArray = jSONObject.getJSONArray("children");
        boolean z = false;
        JSONObject jSONObject3 = jSONArray.getJSONObject(0);
        if (jSONObject3.has("property")) {
            DatabaseTableConfigUtil = NetworkUserEntityData$$ExternalSyntheticLambda2(jSONObject3, jSONObject2);
        } else {
            DatabaseTableConfigUtil = DatabaseTableConfigUtil(jSONObject3, jSONObject2);
        }
        JSONObject jSONObject4 = jSONArray.getJSONObject(1);
        if (jSONObject4.has("property")) {
            DatabaseTableConfigUtil2 = NetworkUserEntityData$$ExternalSyntheticLambda2(jSONObject4, jSONObject2);
        } else {
            DatabaseTableConfigUtil2 = DatabaseTableConfigUtil(jSONObject4, jSONObject2);
        }
        Boolean bool = Boolean.FALSE;
        if (BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil) == BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil2)) {
            if (AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil).ordinal()] == 7) {
                JSONObject jSONObject5 = (JSONObject) DatabaseTableConfigUtil;
                JSONObject jSONObject6 = (JSONObject) DatabaseTableConfigUtil2;
                if (jSONObject5.length() == jSONObject6.length()) {
                    bool = Boolean.TRUE;
                    Iterator<String> keys = jSONObject5.keys();
                    while (true) {
                        if (!keys.hasNext()) {
                            break;
                        }
                        String next = keys.next();
                        if (!getAuthRequestContext(jSONObject5.get(next), jSONObject6.opt(next))) {
                            bool = Boolean.FALSE;
                            break;
                        }
                    }
                }
            } else {
                bool = Boolean.valueOf(getAuthRequestContext(DatabaseTableConfigUtil, DatabaseTableConfigUtil2));
            }
        }
        if (!jSONObject.getString("operator").equals("!=")) {
            z = bool.booleanValue();
        } else if (!bool.booleanValue()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    private static Boolean BuiltInFictitiousFunctionClassFactory(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Object DatabaseTableConfigUtil;
        Object DatabaseTableConfigUtil2;
        char c;
        char c2;
        if (!jSONObject.has("operator") || ((!jSONObject.getString("operator").equals(SimpleComparison.GREATER_THAN_OPERATION) && !jSONObject.getString("operator").equals(SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION) && !jSONObject.getString("operator").equals(SimpleComparison.LESS_THAN_OPERATION) && !jSONObject.getString("operator").equals(SimpleComparison.LESS_THAN_EQUAL_TO_OPERATION)) || jSONObject.optJSONArray("children") == null || jSONObject.getJSONArray("children").length() != 2)) {
            throw new IllegalArgumentException("Invalid node for comparison operator");
        }
        JSONArray jSONArray = jSONObject.getJSONArray("children");
        JSONObject jSONObject3 = jSONArray.getJSONObject(0);
        if (jSONObject3.has("property")) {
            DatabaseTableConfigUtil = NetworkUserEntityData$$ExternalSyntheticLambda2(jSONObject3, jSONObject2);
        } else {
            DatabaseTableConfigUtil = DatabaseTableConfigUtil(jSONObject3, jSONObject2);
        }
        JSONObject jSONObject4 = jSONArray.getJSONObject(1);
        if (jSONObject4.has("property")) {
            DatabaseTableConfigUtil2 = NetworkUserEntityData$$ExternalSyntheticLambda2(jSONObject4, jSONObject2);
        } else {
            DatabaseTableConfigUtil2 = DatabaseTableConfigUtil(jSONObject4, jSONObject2);
        }
        if (BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil) == BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil2)) {
            if (BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil) == PropertyType.Number || BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil) == PropertyType.Datetime) {
                Double PlaceComponentResult = PlaceComponentResult(DatabaseTableConfigUtil);
                Double PlaceComponentResult2 = PlaceComponentResult(DatabaseTableConfigUtil2);
                String string = jSONObject.getString("operator");
                string.hashCode();
                int hashCode = string.hashCode();
                if (hashCode == 60) {
                    if (string.equals(SimpleComparison.LESS_THAN_OPERATION)) {
                        c = 0;
                    }
                    c = 65535;
                } else if (hashCode == 62) {
                    if (string.equals(SimpleComparison.GREATER_THAN_OPERATION)) {
                        c = 1;
                    }
                    c = 65535;
                } else if (hashCode != 1921) {
                    if (hashCode == 1983 && string.equals(SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION)) {
                        c = 3;
                    }
                    c = 65535;
                } else {
                    if (string.equals(SimpleComparison.LESS_THAN_EQUAL_TO_OPERATION)) {
                        c = 2;
                    }
                    c = 65535;
                }
                if (c == 0) {
                    return Boolean.valueOf(PlaceComponentResult.doubleValue() < PlaceComponentResult2.doubleValue());
                } else if (c == 1) {
                    return Boolean.valueOf(PlaceComponentResult.doubleValue() > PlaceComponentResult2.doubleValue());
                } else if (c == 2) {
                    return Boolean.valueOf(PlaceComponentResult.doubleValue() <= PlaceComponentResult2.doubleValue());
                } else if (c != 3) {
                    return null;
                } else {
                    return Boolean.valueOf(PlaceComponentResult.doubleValue() >= PlaceComponentResult2.doubleValue());
                }
            } else if (BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil) == PropertyType.String) {
                int compareTo = ((String) DatabaseTableConfigUtil).compareTo((String) DatabaseTableConfigUtil2);
                String string2 = jSONObject.getString("operator");
                string2.hashCode();
                int hashCode2 = string2.hashCode();
                if (hashCode2 == 60) {
                    if (string2.equals(SimpleComparison.LESS_THAN_OPERATION)) {
                        c2 = 0;
                    }
                    c2 = 65535;
                } else if (hashCode2 == 62) {
                    if (string2.equals(SimpleComparison.GREATER_THAN_OPERATION)) {
                        c2 = 1;
                    }
                    c2 = 65535;
                } else if (hashCode2 != 1921) {
                    if (hashCode2 == 1983 && string2.equals(SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION)) {
                        c2 = 3;
                    }
                    c2 = 65535;
                } else {
                    if (string2.equals(SimpleComparison.LESS_THAN_EQUAL_TO_OPERATION)) {
                        c2 = 2;
                    }
                    c2 = 65535;
                }
                if (c2 == 0) {
                    return Boolean.valueOf(compareTo < 0);
                } else if (c2 == 1) {
                    return Boolean.valueOf(compareTo > 0);
                } else if (c2 == 2) {
                    return Boolean.valueOf(compareTo <= 0);
                } else if (c2 != 3) {
                    return null;
                } else {
                    return Boolean.valueOf(compareTo >= 0);
                }
            } else {
                return null;
            }
        }
        return null;
    }

    private static Boolean scheduleImpl(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Object DatabaseTableConfigUtil;
        if (jSONObject.has("operator") && ((jSONObject.getString("operator").equals("defined") || jSONObject.getString("operator").equals("not defined")) && jSONObject.optJSONArray("children") != null)) {
            boolean z = true;
            if (jSONObject.getJSONArray("children").length() == 1) {
                JSONObject jSONObject3 = jSONObject.getJSONArray("children").getJSONObject(0);
                if (jSONObject3.has("property")) {
                    DatabaseTableConfigUtil = NetworkUserEntityData$$ExternalSyntheticLambda2(jSONObject3, jSONObject2);
                } else {
                    DatabaseTableConfigUtil = DatabaseTableConfigUtil(jSONObject3, jSONObject2);
                }
                boolean z2 = DatabaseTableConfigUtil != null;
                if (jSONObject.getString("operator").equals("defined")) {
                    z = z2;
                } else if (z2) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }
        throw new IllegalArgumentException("Invalid node for (not) defined operator");
    }

    private static Boolean lookAheadTest(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Object DatabaseTableConfigUtil;
        if (!jSONObject.has("operator") || !jSONObject.getString("operator").equals("not") || jSONObject.optJSONArray("children") == null || jSONObject.getJSONArray("children").length() != 1) {
            throw new IllegalArgumentException("Invalid node for operator: not");
        }
        JSONObject jSONObject3 = jSONObject.getJSONArray("children").getJSONObject(0);
        if (jSONObject3.has("property")) {
            DatabaseTableConfigUtil = NetworkUserEntityData$$ExternalSyntheticLambda2(jSONObject3, jSONObject2);
        } else {
            DatabaseTableConfigUtil = DatabaseTableConfigUtil(jSONObject3, jSONObject2);
        }
        int i = AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil).ordinal()];
        if (i != 1) {
            if (i != 3) {
                return null;
            }
            return Boolean.valueOf(!MyBillsEntityDataFactory(DatabaseTableConfigUtil).booleanValue());
        }
        return Boolean.TRUE;
    }

    private static Date getAuthRequestContext(JSONObject jSONObject) throws JSONException {
        Calendar calendar;
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null || !optJSONObject.has("value") || !optJSONObject.has(OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid window specification for value key ");
            sb.append(jSONObject.toString());
            throw new IllegalArgumentException(sb.toString());
        }
        Calendar calendar2 = MyBillsEntityDataFactory;
        if (calendar2 == null) {
            calendar = Calendar.getInstance();
            calendar.setTime(new Date());
        } else {
            calendar = (Calendar) calendar2.clone();
        }
        char c = 65535;
        Integer valueOf = Integer.valueOf(optJSONObject.getInt("value") * (-1));
        String string = optJSONObject.getString(OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT);
        string.hashCode();
        switch (string.hashCode()) {
            case 99228:
                if (string.equals("day")) {
                    c = 0;
                    break;
                }
                break;
            case 3208676:
                if (string.equals("hour")) {
                    c = 1;
                    break;
                }
                break;
            case 3645428:
                if (string.equals("week")) {
                    c = 2;
                    break;
                }
                break;
            case 104080000:
                if (string.equals("month")) {
                    c = 3;
                    break;
                }
                break;
        }
        if (c == 0) {
            calendar.add(6, valueOf.intValue());
        } else if (c == 1) {
            calendar.add(10, valueOf.intValue());
        } else if (c == 2) {
            calendar.add(6, valueOf.intValue() * 7);
        } else if (c == 3) {
            calendar.add(6, valueOf.intValue() * 30);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid unit specification for window ");
            sb2.append(optJSONObject.getString(OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT));
            throw new IllegalArgumentException(sb2.toString());
        }
        return calendar.getTime();
    }

    private static Object NetworkUserEntityData$$ExternalSyntheticLambda2(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (!jSONObject.has("property") || !jSONObject.has("value")) {
            throw new IllegalArgumentException("Missing required keys: property/value");
        }
        String string = jSONObject.getString("property");
        string.hashCode();
        if (string.equals("event")) {
            return jSONObject2.opt(jSONObject.getString("value"));
        }
        if (string.equals("literal")) {
            if (BuiltInFictitiousFunctionClassFactory(jSONObject.get("value")) == PropertyType.String && jSONObject.getString("value").equalsIgnoreCase("now")) {
                return new Date();
            }
            Object obj = jSONObject.get("value");
            return AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[BuiltInFictitiousFunctionClassFactory(obj).ordinal()] != 7 ? obj : getAuthRequestContext((JSONObject) obj);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid operand: Invalid property type: ");
        sb.append(jSONObject.getString("property"));
        throw new IllegalArgumentException(sb.toString());
    }

    private static Object DatabaseTableConfigUtil(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (!jSONObject.has("operator")) {
            throw new IllegalArgumentException("Missing required keys: operator");
        }
        String string = jSONObject.getString("operator");
        string.hashCode();
        char c = 65535;
        switch (string.hashCode()) {
            case -1039759982:
                if (string.equals("not in")) {
                    c = 0;
                    break;
                }
                break;
            case -1034364087:
                if (string.equals("number")) {
                    c = 1;
                    break;
                }
                break;
            case -891985903:
                if (string.equals("string")) {
                    c = 2;
                    break;
                }
                break;
            case 37:
                if (string.equals("%")) {
                    c = 3;
                    break;
                }
                break;
            case 42:
                if (string.equals("*")) {
                    c = 4;
                    break;
                }
                break;
            case 43:
                if (string.equals("+")) {
                    c = 5;
                    break;
                }
                break;
            case 45:
                if (string.equals("-")) {
                    c = 6;
                    break;
                }
                break;
            case 47:
                if (string.equals("/")) {
                    c = 7;
                    break;
                }
                break;
            case 60:
                if (string.equals(SimpleComparison.LESS_THAN_OPERATION)) {
                    c = '\b';
                    break;
                }
                break;
            case 62:
                if (string.equals(SimpleComparison.GREATER_THAN_OPERATION)) {
                    c = '\t';
                    break;
                }
                break;
            case 1084:
                if (string.equals("!=")) {
                    c = '\n';
                    break;
                }
                break;
            case 1921:
                if (string.equals(SimpleComparison.LESS_THAN_EQUAL_TO_OPERATION)) {
                    c = 11;
                    break;
                }
                break;
            case 1952:
                if (string.equals("==")) {
                    c = '\f';
                    break;
                }
                break;
            case 1983:
                if (string.equals(SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION)) {
                    c = '\r';
                    break;
                }
                break;
            case 3365:
                if (string.equals("in")) {
                    c = 14;
                    break;
                }
                break;
            case 3555:
                if (string.equals("or")) {
                    c = 15;
                    break;
                }
                break;
            case 96727:
                if (string.equals("and")) {
                    c = 16;
                    break;
                }
                break;
            case 109267:
                if (string.equals("not")) {
                    c = 17;
                    break;
                }
                break;
            case 3322014:
                if (string.equals("list")) {
                    c = 18;
                    break;
                }
                break;
            case 64711720:
                if (string.equals("boolean")) {
                    c = 19;
                    break;
                }
                break;
            case 1545035273:
                if (string.equals("defined")) {
                    c = 20;
                    break;
                }
                break;
            case 1793702779:
                if (string.equals("datetime")) {
                    c = 21;
                    break;
                }
                break;
            case 1834754492:
                if (string.equals("not defined")) {
                    c = 22;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 14:
                return moveToNextValue(jSONObject, jSONObject2);
            case 1:
                return GetContactSyncConfig(jSONObject, jSONObject2);
            case 2:
                return PrepareContext(jSONObject, jSONObject2);
            case 3:
            case 4:
            case 6:
            case 7:
                return MyBillsEntityDataFactory(jSONObject, jSONObject2);
            case 5:
                return initRecordTimeStamp(jSONObject, jSONObject2);
            case '\b':
            case '\t':
            case 11:
            case '\r':
                return BuiltInFictitiousFunctionClassFactory(jSONObject, jSONObject2);
            case '\n':
            case '\f':
                return getErrorConfigVersion(jSONObject, jSONObject2);
            case 15:
                return NetworkUserEntityData$$ExternalSyntheticLambda1(jSONObject, jSONObject2);
            case 16:
                return getAuthRequestContext(jSONObject, jSONObject2);
            case 17:
                return lookAheadTest(jSONObject, jSONObject2);
            case 18:
                return NetworkUserEntityData$$ExternalSyntheticLambda0(jSONObject, jSONObject2);
            case 19:
                return PlaceComponentResult(jSONObject, jSONObject2);
            case 20:
            case 22:
                return scheduleImpl(jSONObject, jSONObject2);
            case 21:
                return KClassImpl$Data$declaredNonStaticMembers$2(jSONObject, jSONObject2);
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown operator: ");
                sb.append(jSONObject.getString("operator"));
                throw new IllegalArgumentException(sb.toString());
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(JSONObject jSONObject) throws JSONException {
        return MyBillsEntityDataFactory(DatabaseTableConfigUtil(this.getAuthRequestContext, jSONObject)).booleanValue();
    }
}
