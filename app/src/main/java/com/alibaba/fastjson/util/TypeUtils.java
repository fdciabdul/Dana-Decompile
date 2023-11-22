package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.sendmoney.summary.SummaryActivity;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes3.dex */
public class TypeUtils {
    public static boolean compatibleWithJavaBean = false;
    private static volatile Map<Class, String[]> kotlinIgnores = null;
    private static volatile boolean kotlinIgnores_error = false;
    private static volatile boolean kotlin_class_klass_error = false;
    private static volatile boolean kotlin_error = false;
    private static volatile Constructor kotlin_kclass_constructor = null;
    private static volatile Method kotlin_kclass_getConstructors = null;
    private static volatile Method kotlin_kfunction_getParameters = null;
    private static volatile Method kotlin_kparameter_getName = null;
    private static volatile Class kotlin_metadata = null;
    private static volatile boolean kotlin_metadata_error = false;
    private static final ConcurrentMap<String, Class<?>> mappings;
    private static boolean setAccessibleEnable = true;
    public static final byte[] getAuthRequestContext = {116, -27, -60, 115, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -34, 37, -9, 6, -10, 7, 4};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 0;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 13
            int r6 = r6 * 7
            int r6 = r6 + 99
            byte[] r0 = com.alibaba.fastjson.util.TypeUtils.getAuthRequestContext
            int r8 = r8 + 4
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L31
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r8 = r8 + 1
            r3 = r0[r8]
            r5 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L31:
            int r6 = r6 + r8
            int r6 = r6 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.a(int, short, short, java.lang.Object[]):void");
    }

    public static boolean isKotlin(Class cls) {
        if (kotlin_metadata == null && !kotlin_metadata_error) {
            try {
                kotlin_metadata = Class.forName("kotlin.Metadata");
            } catch (Throwable unused) {
                kotlin_metadata_error = true;
            }
        }
        if (kotlin_metadata == null) {
            return false;
        }
        return cls.isAnnotationPresent(kotlin_metadata);
    }

    private static boolean isKotlinIgnore(Class cls, String str) {
        String[] strArr;
        if (kotlinIgnores == null && !kotlinIgnores_error) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(Class.forName("kotlin.ranges.CharRange"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.ranges.IntRange"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.ranges.LongRange"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.ranges.ClosedFloatRange"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.ranges.ClosedDoubleRange"), new String[]{"getEndInclusive", "isEmpty"});
                kotlinIgnores = hashMap;
            } catch (Throwable unused) {
                kotlinIgnores_error = true;
            }
        }
        return (kotlinIgnores == null || (strArr = kotlinIgnores.get(cls)) == null || Arrays.binarySearch(strArr, str) < 0) ? false : true;
    }

    public static String[] getKoltinConstructorParameters(Class cls) {
        if (kotlin_kclass_constructor == null && !kotlin_class_klass_error) {
            try {
                Class<?> cls2 = Class.forName("kotlin.reflect.jvm.internal.KClassImpl");
                kotlin_kclass_constructor = cls2.getConstructor(Class.class);
                kotlin_kclass_getConstructors = cls2.getMethod("getConstructors", new Class[0]);
                kotlin_kfunction_getParameters = Class.forName("kotlin.reflect.KFunction").getMethod("getParameters", new Class[0]);
                kotlin_kparameter_getName = Class.forName("kotlin.reflect.KParameter").getMethod("getName", new Class[0]);
            } catch (Throwable unused) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kclass_constructor == null || kotlin_error) {
            return null;
        }
        try {
            Iterator it = ((Iterable) kotlin_kclass_getConstructors.invoke(kotlin_kclass_constructor.newInstance(cls), new Object[0])).iterator();
            Object obj = null;
            while (it.hasNext()) {
                Object next = it.next();
                List list = (List) kotlin_kfunction_getParameters.invoke(next, new Object[0]);
                if (obj == null || list.size() != 0) {
                    obj = next;
                }
                it.hasNext();
            }
            List list2 = (List) kotlin_kfunction_getParameters.invoke(obj, new Object[0]);
            String[] strArr = new String[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                strArr[i] = (String) kotlin_kparameter_getName.invoke(list2.get(i), new Object[0]);
            }
            return strArr;
        } catch (Throwable unused2) {
            kotlin_error = true;
            return null;
        }
    }

    public static final String castToString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static final Byte castToByte(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            return Byte.valueOf(Byte.parseByte(str));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("can not cast to byte, value : ");
        sb.append(obj);
        throw new JSONException(sb.toString());
    }

    public static final Character castToChar(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            if (str.length() != 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("can not cast to byte, value : ");
                sb.append(obj);
                throw new JSONException(sb.toString());
            }
            return Character.valueOf(str.charAt(0));
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("can not cast to byte, value : ");
        sb2.append(obj);
        throw new JSONException(sb2.toString());
    }

    public static final Short castToShort(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            return Short.valueOf(Short.parseShort(str));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("can not cast to short, value : ");
        sb.append(obj);
        throw new JSONException(sb.toString());
    }

    public static final BigDecimal castToBigDecimal(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || "null".equals(obj2)) {
            return null;
        }
        return new BigDecimal(obj2);
    }

    public static final BigInteger castToBigInteger(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || "null".equals(obj2)) {
            return null;
        }
        return new BigInteger(obj2);
    }

    public static final Float castToFloat(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2)) {
                return null;
            }
            return Float.valueOf(Float.parseFloat(obj2));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("can not cast to float, value : ");
        sb.append(obj);
        throw new JSONException(sb.toString());
    }

    public static final Double castToDouble(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(obj2));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("can not cast to double, value : ");
        sb.append(obj);
        throw new JSONException(sb.toString());
    }

    public static final Date castToDate(Object obj) {
        String str;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        long longValue = obj instanceof Number ? ((Number) obj).longValue() : -1L;
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.indexOf(45) != -1) {
                if (str2.length() == JSON.DEFFAULT_DATE_FORMAT.length()) {
                    str = JSON.DEFFAULT_DATE_FORMAT;
                } else if (str2.length() == 10) {
                    str = "yyyy-MM-dd";
                } else if (str2.length() == 19) {
                    str = "yyyy-MM-dd HH:mm:ss";
                } else {
                    str = (str2.length() == 29 && str2.charAt(26) == ':' && str2.charAt(28) == '0') ? "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" : "yyyy-MM-dd HH:mm:ss.SSS";
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, JSON.defaultLocale);
                simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
                try {
                    return simpleDateFormat.parse(str2);
                } catch (ParseException unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("can not cast to Date, value : ");
                    sb.append(str2);
                    throw new JSONException(sb.toString());
                }
            } else if (str2.length() == 0 || "null".equals(str2)) {
                return null;
            } else {
                longValue = Long.parseLong(str2);
            }
        }
        if (longValue < 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("can not cast to Date, value : ");
            sb2.append(obj);
            throw new JSONException(sb2.toString());
        }
        return new Date(longValue);
    }

    public static final Long castToLong(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                JSONLexer jSONLexer = new JSONLexer(str);
                Calendar calendar = jSONLexer.scanISO8601DateIfMatch(false) ? jSONLexer.calendar : null;
                jSONLexer.close();
                if (calendar != null) {
                    return Long.valueOf(calendar.getTimeInMillis());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("can not cast to long, value : ");
        sb.append(obj);
        throw new JSONException(sb.toString());
    }

    public static final Integer castToInt(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(str));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("can not cast to int, value : ");
        sb.append(obj);
        throw new JSONException(sb.toString());
    }

    public static final byte[] castToBytes(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return JSONLexer.decodeFast(str, 0, str.length());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("can not cast to int, value : ");
        sb.append(obj);
        throw new JSONException(sb.toString());
    }

    public static final Boolean castToBoolean(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            return Boolean.valueOf(((Number) obj).intValue() == 1);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            if (SummaryActivity.CHECKED.equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str) || "0".equals(str)) {
                return Boolean.FALSE;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("can not cast to int, value : ");
        sb.append(obj);
        throw new JSONException(sb.toString());
    }

    public static final <T> T castToJavaBean(Object obj, Class<T> cls) {
        return (T) cast(obj, (Class) cls, ParserConfig.global);
    }

    public static final <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig) {
        return (T) cast(obj, cls, parserConfig, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig, int i) {
        T t;
        if (obj == 0) {
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        }
        if (cls == obj.getClass()) {
            return obj;
        }
        if (obj instanceof Map) {
            if (cls == Map.class) {
                return obj;
            }
            Map map = (Map) obj;
            return (cls != Object.class || map.containsKey(JSON.DEFAULT_TYPE_KEY)) ? (T) castToJavaBean(map, cls, parserConfig, i) : obj;
        }
        int i2 = 0;
        if (cls.isArray()) {
            if (obj instanceof Collection) {
                Collection collection = (Collection) obj;
                T t2 = (T) Array.newInstance(cls.getComponentType(), collection.size());
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    Array.set(t2, i2, cast(it.next(), (Class) cls.getComponentType(), parserConfig));
                    i2++;
                }
                return t2;
            } else if (cls == byte[].class) {
                return (T) castToBytes(obj);
            }
        }
        if (cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return (T) castToBoolean(obj);
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            return (T) castToByte(obj);
        }
        if ((cls == Character.TYPE || cls == Character.class) && (obj instanceof String)) {
            String str = (String) obj;
            if (str.length() == 1) {
                return (T) Character.valueOf(str.charAt(0));
            }
        }
        if (cls == Short.TYPE || cls == Short.class) {
            return (T) castToShort(obj);
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            return (T) castToInt(obj);
        }
        if (cls == Long.TYPE || cls == Long.class) {
            return (T) castToLong(obj);
        }
        if (cls == Float.TYPE || cls == Float.class) {
            return (T) castToFloat(obj);
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return (T) castToDouble(obj);
        }
        if (cls == String.class) {
            return (T) castToString(obj);
        }
        if (cls == BigDecimal.class) {
            return (T) castToBigDecimal(obj);
        }
        if (cls == BigInteger.class) {
            return (T) castToBigInteger(obj);
        }
        if (cls == Date.class) {
            return (T) castToDate(obj);
        }
        if (cls.isEnum()) {
            return (T) castToEnum(obj, cls, parserConfig);
        }
        if (Calendar.class.isAssignableFrom(cls)) {
            Date castToDate = castToDate(obj);
            if (cls == Calendar.class) {
                t = (T) Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
            } else {
                try {
                    t = (T) ((Calendar) cls.newInstance());
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("can not cast to : ");
                    sb.append(cls.getName());
                    throw new JSONException(sb.toString(), e);
                }
            }
            ((Calendar) t).setTime(castToDate);
            return t;
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.length() == 0 || "null".equals(str2)) {
                return null;
            }
            if (cls == Currency.class) {
                return (T) Currency.getInstance(str2);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("can not cast to : ");
        sb2.append(cls.getName());
        throw new JSONException(sb2.toString());
    }

    public static final <T> T castToEnum(Object obj, Class<T> cls, ParserConfig parserConfig) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                return (T) Enum.valueOf(cls, str);
            }
            if (obj instanceof Number) {
                int intValue = ((Number) obj).intValue();
                T[] enumConstants = cls.getEnumConstants();
                if (intValue < enumConstants.length) {
                    return enumConstants[intValue];
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("can not cast to : ");
            sb.append(cls.getName());
            throw new JSONException(sb.toString());
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("can not cast to : ");
            sb2.append(cls.getName());
            throw new JSONException(sb2.toString(), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T cast(Object obj, Type type, ParserConfig parserConfig) {
        if (obj == 0) {
            return null;
        }
        if (type instanceof Class) {
            return (T) cast(obj, (Class) type, parserConfig);
        }
        if (type instanceof ParameterizedType) {
            return (T) cast(obj, (ParameterizedType) type, parserConfig);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("can not cast to : ");
        sb.append(type);
        throw new JSONException(sb.toString());
    }

    /* JADX WARN: Type inference failed for: r7v8, types: [T, java.util.Map, java.util.HashMap] */
    public static final <T> T cast(Object obj, ParameterizedType parameterizedType, ParserConfig parserConfig) {
        T t;
        Type rawType = parameterizedType.getRawType();
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                if (rawType == Set.class || rawType == HashSet.class) {
                    t = (T) new HashSet();
                } else if (rawType == TreeSet.class) {
                    t = (T) new TreeSet();
                } else {
                    t = (T) new ArrayList();
                }
                Iterator<T> it = ((Iterable) obj).iterator();
                while (it.hasNext()) {
                    ((Collection) t).add(cast(it.next(), type, parserConfig));
                }
                return t;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                ?? r7 = (T) new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    r7.put(cast(entry.getKey(), type2, parserConfig), cast(entry.getValue(), type3, parserConfig));
                }
                return r7;
            }
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
        }
        if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return (T) cast(obj, rawType, parserConfig);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("can not cast to : ");
        sb.append(parameterizedType);
        throw new JSONException(sb.toString());
    }

    public static final <T> T castToJavaBean(Map<String, Object> map, Class<T> cls, ParserConfig parserConfig) {
        return (T) castToJavaBean(map, cls, parserConfig, 0);
    }

    public static final <T> T castToJavaBean(Map<String, Object> map, Class<T> cls, ParserConfig parserConfig, int i) {
        JSONObject jSONObject;
        try {
            Object[] objArr = new Object[1];
            a(getAuthRequestContext[15], (byte) (KClassImpl$Data$declaredNonStaticMembers$2 | 14), (byte) (KClassImpl$Data$declaredNonStaticMembers$2 | 26), objArr);
            int i2 = 0;
            if (cls == Class.forName((String) objArr[0])) {
                String str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                if (number != null) {
                    i2 = number.intValue();
                }
                return (T) new StackTraceElement(str, str2, str3, i2);
            }
            Object obj = map.get(JSON.DEFAULT_TYPE_KEY);
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (parserConfig == null) {
                    parserConfig = ParserConfig.global;
                }
                Class<?> checkAutoType = parserConfig.checkAutoType(str4, null, i);
                if (checkAutoType == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str4);
                    sb.append(" not found");
                    throw new ClassNotFoundException(sb.toString());
                } else if (!checkAutoType.equals(cls)) {
                    return (T) castToJavaBean(map, checkAutoType, parserConfig, i);
                }
            }
            if (cls.isInterface()) {
                if (map instanceof JSONObject) {
                    jSONObject = (JSONObject) map;
                } else {
                    jSONObject = new JSONObject(map);
                }
                if (parserConfig == null) {
                    parserConfig = ParserConfig.getGlobalInstance();
                }
                if (parserConfig.getDeserializer(cls) != null) {
                    return (T) JSON.parseObject(JSON.toJSONString(jSONObject), cls);
                }
                try {
                    byte b = getAuthRequestContext[15];
                    Object[] objArr2 = new Object[1];
                    a(b, (byte) (b + 2), getAuthRequestContext[22], objArr2);
                    Class<?> cls2 = Class.forName((String) objArr2[0]);
                    byte b2 = (byte) KClassImpl$Data$declaredNonStaticMembers$2;
                    Object[] objArr3 = new Object[1];
                    a(b2, b2, (byte) (-getAuthRequestContext[15]), objArr3);
                    return (T) Proxy.newProxyInstance(((Thread) cls2.getMethod((String) objArr3[0], null).invoke(null, null)).getContextClassLoader(), new Class[]{cls}, jSONObject);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } else if (cls == String.class && (map instanceof JSONObject)) {
                return (T) map.toString();
            } else {
                if (parserConfig == null) {
                    parserConfig = ParserConfig.global;
                }
                ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
                JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
                if (javaBeanDeserializer == null) {
                    throw new JSONException("can not get javaBeanDeserializer");
                }
                return (T) javaBeanDeserializer.createInstance(map, parserConfig);
            }
        } catch (Exception e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(36, 0.75f, 1);
        mappings = concurrentHashMap;
        concurrentHashMap.put("byte", Byte.TYPE);
        concurrentHashMap.put("short", Short.TYPE);
        concurrentHashMap.put("int", Integer.TYPE);
        concurrentHashMap.put("long", Long.TYPE);
        concurrentHashMap.put("float", Float.TYPE);
        concurrentHashMap.put("double", Double.TYPE);
        concurrentHashMap.put("boolean", Boolean.TYPE);
        concurrentHashMap.put("char", Character.TYPE);
        concurrentHashMap.put("[byte", byte[].class);
        concurrentHashMap.put("[short", short[].class);
        concurrentHashMap.put("[int", int[].class);
        concurrentHashMap.put("[long", long[].class);
        concurrentHashMap.put("[float", float[].class);
        concurrentHashMap.put("[double", double[].class);
        concurrentHashMap.put("[boolean", boolean[].class);
        concurrentHashMap.put("[char", char[].class);
        concurrentHashMap.put("[B", byte[].class);
        concurrentHashMap.put("[S", short[].class);
        concurrentHashMap.put("[I", int[].class);
        concurrentHashMap.put("[J", long[].class);
        concurrentHashMap.put("[F", float[].class);
        concurrentHashMap.put("[D", double[].class);
        concurrentHashMap.put("[C", char[].class);
        concurrentHashMap.put("[Z", boolean[].class);
        concurrentHashMap.put("java.util.HashMap", HashMap.class);
        concurrentHashMap.put("java.util.TreeMap", TreeMap.class);
        concurrentHashMap.put("java.util.Date", Date.class);
        concurrentHashMap.put("com.alibaba.fastjson.JSONObject", JSONObject.class);
        concurrentHashMap.put("java.util.concurrent.ConcurrentHashMap", ConcurrentHashMap.class);
        concurrentHashMap.put("java.text.SimpleDateFormat", SimpleDateFormat.class);
        byte b = getAuthRequestContext[15];
        int i = KClassImpl$Data$declaredNonStaticMembers$2;
        Object[] objArr = new Object[1];
        a(b, (byte) (i | 14), (byte) (i | 26), objArr);
        concurrentHashMap.put("java.lang.StackTraceElement", Class.forName((String) objArr[0]));
        concurrentHashMap.put("java.lang.RuntimeException", RuntimeException.class);
    }

    public static Class<?> getClassFromMapping(String str) {
        return mappings.get(str);
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader) {
        return loadClass(str, classLoader, false);
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader, boolean z) {
        while (str != null && str.length() != 0) {
            if (str.length() >= 256) {
                StringBuilder sb = new StringBuilder();
                sb.append("className too long. ");
                sb.append(str);
                throw new JSONException(sb.toString());
            }
            ConcurrentMap<String, Class<?>> concurrentMap = mappings;
            Class<?> cls = concurrentMap.get(str);
            if (cls != null) {
                return cls;
            }
            if (str.charAt(0) == '[') {
                Class<?> loadClass = loadClass(str.substring(1), classLoader, false);
                if (loadClass == null) {
                    return null;
                }
                return Array.newInstance(loadClass, 0).getClass();
            } else if (str.startsWith("L") && str.endsWith(";")) {
                str = str.substring(1, str.length() - 1);
                z = false;
            } else {
                if (classLoader != null) {
                    try {
                        cls = classLoader.loadClass(str);
                        if (z) {
                            concurrentMap.put(str, cls);
                        }
                        return cls;
                    } catch (Exception unused) {
                    }
                }
                try {
                    try {
                        byte b = getAuthRequestContext[15];
                        Object[] objArr = new Object[1];
                        a(b, (byte) (b + 2), getAuthRequestContext[22], objArr);
                        Class<?> cls2 = Class.forName((String) objArr[0]);
                        byte b2 = (byte) KClassImpl$Data$declaredNonStaticMembers$2;
                        Object[] objArr2 = new Object[1];
                        a(b2, b2, (byte) (-getAuthRequestContext[15]), objArr2);
                        ClassLoader contextClassLoader = ((Thread) cls2.getMethod((String) objArr2[0], null).invoke(null, null)).getContextClassLoader();
                        if (contextClassLoader != null && contextClassLoader != classLoader) {
                            Class<?> loadClass2 = contextClassLoader.loadClass(str);
                            if (z) {
                                mappings.put(str, loadClass2);
                            }
                            return loadClass2;
                        }
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                }
                try {
                    cls = Class.forName(str);
                    mappings.put(str, cls);
                    return cls;
                } catch (Exception unused3) {
                    return cls;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:284:0x05e1  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x05f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.alibaba.fastjson.util.FieldInfo> computeGetters(java.lang.Class<?> r43, int r44, boolean r45, com.alibaba.fastjson.annotation.JSONType r46, java.util.Map<java.lang.String, java.lang.String> r47, boolean r48, boolean r49, boolean r50, com.alibaba.fastjson.PropertyNamingStrategy r51) {
        /*
            Method dump skipped, instructions count: 1553
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.computeGetters(java.lang.Class, int, boolean, com.alibaba.fastjson.annotation.JSONType, java.util.Map, boolean, boolean, boolean, com.alibaba.fastjson.PropertyNamingStrategy):java.util.List");
    }

    public static JSONField getSupperMethodAnnotation(Class<?> cls, Method method) {
        boolean z;
        JSONField jSONField;
        boolean z2;
        JSONField jSONField2;
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Method method2 : cls2.getMethods()) {
                if (method2.getName().equals(method.getName())) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    Class<?>[] parameterTypes2 = method.getParameterTypes();
                    if (parameterTypes.length == parameterTypes2.length) {
                        int i = 0;
                        while (true) {
                            if (i >= parameterTypes.length) {
                                z2 = true;
                                break;
                            } else if (!parameterTypes[i].equals(parameterTypes2[i])) {
                                z2 = false;
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (z2 && (jSONField2 = (JSONField) method2.getAnnotation(JSONField.class)) != null) {
                            return jSONField2;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
            Class<?>[] parameterTypes3 = method.getParameterTypes();
            for (Method method3 : superclass.getMethods()) {
                Class<?>[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= parameterTypes3.length) {
                            z = true;
                            break;
                        } else if (!parameterTypes4[i2].equals(parameterTypes3[i2])) {
                            z = false;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z && (jSONField = (JSONField) method3.getAnnotation(JSONField.class)) != null) {
                        return jSONField;
                    }
                }
            }
        }
        return null;
    }

    private static boolean isJSONTypeIgnore(Class<?> cls, JSONType jSONType, String str) {
        if (jSONType != null && jSONType.ignores() != null) {
            for (String str2 : jSONType.ignores()) {
                if (str.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        return (superclass == Object.class || superclass == null || !isJSONTypeIgnore(superclass, (JSONType) superclass.getAnnotation(JSONType.class), str)) ? false : true;
    }

    public static boolean isGenericParamType(Type type) {
        Type genericSuperclass;
        if (type instanceof ParameterizedType) {
            return true;
        }
        return (type instanceof Class) && (genericSuperclass = ((Class) type).getGenericSuperclass()) != Object.class && isGenericParamType(genericSuperclass);
    }

    public static Type getGenericParamType(Type type) {
        return type instanceof Class ? getGenericParamType(((Class) type).getGenericSuperclass()) : type;
    }

    public static Class<?> getClass(Type type) {
        while (type.getClass() != Class.class) {
            if (type instanceof ParameterizedType) {
                type = ((ParameterizedType) type).getRawType();
            } else if (type instanceof TypeVariable) {
                return (Class) ((TypeVariable) type).getBounds()[0];
            } else {
                if (type instanceof WildcardType) {
                    Type[] upperBounds = ((WildcardType) type).getUpperBounds();
                    if (upperBounds.length == 1) {
                        type = upperBounds[0];
                    } else {
                        return Object.class;
                    }
                } else {
                    return Object.class;
                }
            }
        }
        return (Class) type;
    }

    public static String decapitalize(String str) {
        if (str == null || str.length() == 0 || (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0)))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static boolean setAccessible(Class<?> cls, Member member, int i) {
        if (member != null && setAccessibleEnable) {
            Class<? super Object> superclass = cls.getSuperclass();
            if ((superclass == null || superclass == Object.class) && (member.getModifiers() & 1) != 0 && (i & 1) != 0) {
                return false;
            }
            try {
                ((AccessibleObject) member).setAccessible(true);
                return true;
            } catch (AccessControlException unused) {
                setAccessibleEnable = false;
            }
        }
        return false;
    }

    public static Field getField(Class<?> cls, String str, Field[] fieldArr) {
        return getField(cls, str, fieldArr, null);
    }

    public static Field getField(Class<?> cls, String str, Field[] fieldArr, Map<Class<?>, Field[]> map) {
        Field field0 = getField0(cls, str, fieldArr, map);
        if (field0 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("_");
            sb.append(str);
            field0 = getField0(cls, sb.toString(), fieldArr, map);
        }
        if (field0 == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("m_");
            sb2.append(str);
            field0 = getField0(cls, sb2.toString(), fieldArr, map);
        }
        if (field0 == null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("m");
            sb3.append(str.substring(0, 1).toUpperCase());
            sb3.append(str.substring(1));
            return getField0(cls, sb3.toString(), fieldArr, map);
        }
        return field0;
    }

    private static Field getField0(Class<?> cls, String str, Field[] fieldArr, Map<Class<?>, Field[]> map) {
        char charAt;
        char charAt2;
        for (Field field : fieldArr) {
            String name = field.getName();
            if (str.equals(name)) {
                return field;
            }
            if (str.length() > 2 && (charAt = str.charAt(0)) >= 'a' && charAt <= 'z' && (charAt2 = str.charAt(1)) >= 'A' && charAt2 <= 'Z' && str.equalsIgnoreCase(name)) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        Field[] fieldArr2 = map != null ? map.get(superclass) : null;
        if (fieldArr2 == null) {
            fieldArr2 = superclass.getDeclaredFields();
            if (map != null) {
                map.put(superclass, fieldArr2);
            }
        }
        return getField(superclass, str, fieldArr2, map);
    }

    public static Type getCollectionItemType(Type type) {
        Type type2;
        if (type instanceof ParameterizedType) {
            type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                if (upperBounds.length == 1) {
                    type2 = upperBounds[0];
                }
            }
        } else {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (!cls.getName().startsWith("java.")) {
                    type2 = getCollectionItemType(cls.getGenericSuperclass());
                }
            }
            type2 = null;
        }
        return type2 == null ? Object.class : type2;
    }

    public static Object defaultValue(Class<?> cls) {
        if (cls == Byte.TYPE) {
            return (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (short) 0;
        }
        if (cls == Integer.TYPE) {
            return 0;
        }
        if (cls == Long.TYPE) {
            return 0L;
        }
        if (cls == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (cls == Double.TYPE) {
            return Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
        if (cls == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        return cls == Character.TYPE ? '0' : null;
    }

    public static boolean getArgument(Type[] typeArr, TypeVariable[] typeVariableArr, Type[] typeArr2) {
        if (typeArr2 == null || typeVariableArr.length == 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < typeArr.length; i++) {
            Type type = typeArr[i];
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (getArgument(actualTypeArguments, typeVariableArr, typeArr2)) {
                    typeArr[i] = new ParameterizedTypeImpl(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType());
                    z = true;
                }
            } else if (type instanceof TypeVariable) {
                for (int i2 = 0; i2 < typeVariableArr.length; i2++) {
                    if (type.equals(typeVariableArr[i2])) {
                        typeArr[i] = typeArr2[i2];
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public static long fnv_64_lower(String str) {
        long j = -3750763034362895579L;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != '_' && charAt != '-') {
                if (charAt >= 'A' && charAt <= 'Z') {
                    charAt = (char) (charAt + InputCardNumberView.DIVIDER);
                }
                j = (j ^ charAt) * 1099511628211L;
            }
        }
        return j;
    }

    public static void addMapping(String str, Class<?> cls) {
        mappings.put(str, cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Class] */
    public static Type checkPrimitiveArray(GenericArrayType genericArrayType) {
        Type genericComponentType = genericArrayType.getGenericComponentType();
        String str = "[";
        while (genericComponentType instanceof GenericArrayType) {
            genericComponentType = ((GenericArrayType) genericComponentType).getGenericComponentType();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str);
            str = sb.toString();
        }
        if (genericComponentType instanceof Class) {
            Class cls = (Class) genericComponentType;
            if (cls.isPrimitive()) {
                try {
                    if (cls == Boolean.TYPE) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append("Z");
                        genericArrayType = Class.forName(sb2.toString());
                    } else if (cls == Character.TYPE) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str);
                        sb3.append("C");
                        genericArrayType = Class.forName(sb3.toString());
                    } else if (cls == Byte.TYPE) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(str);
                        sb4.append(DiskFormatter.B);
                        genericArrayType = Class.forName(sb4.toString());
                    } else if (cls == Short.TYPE) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str);
                        sb5.append("S");
                        genericArrayType = Class.forName(sb5.toString());
                    } else if (cls == Integer.TYPE) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(str);
                        sb6.append("I");
                        genericArrayType = Class.forName(sb6.toString());
                    } else if (cls == Long.TYPE) {
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(str);
                        sb7.append("J");
                        genericArrayType = Class.forName(sb7.toString());
                    } else if (cls == Float.TYPE) {
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append(str);
                        sb8.append(LogConstants.RESULT_FALSE);
                        genericArrayType = Class.forName(sb8.toString());
                    } else {
                        genericArrayType = genericArrayType;
                        if (cls == Double.TYPE) {
                            StringBuilder sb9 = new StringBuilder();
                            sb9.append(str);
                            sb9.append(SummaryActivity.DAYS);
                            genericArrayType = Class.forName(sb9.toString());
                        }
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
        }
        return genericArrayType;
    }
}
