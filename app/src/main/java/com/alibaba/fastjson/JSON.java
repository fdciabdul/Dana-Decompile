package com.alibaba.fastjson;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import com.alibaba.fastjson.serializer.AfterFilter;
import com.alibaba.fastjson.serializer.BeforeFilter;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.util.TypeUtils;
import id.dana.cashier.view.InputCardNumberView;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import kotlin.text.Typography;
import o.B;

/* loaded from: classes.dex */
public abstract class JSON implements JSONStreamAware, JSONAware {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    public static int DEFAULT_GENERATE_FEATURE = 0;
    public static int DEFAULT_PARSER_FEATURE = 0;
    public static final String DEFAULT_TYPE_KEY = "@type";
    public static String DEFFAULT_DATE_FORMAT = null;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 0;
    private static byte[] PlaceComponentResult = null;
    public static final String VERSION = "1.1.70";
    public static Locale defaultLocale = null;
    public static TimeZone defaultTimeZone = null;
    private static short[] getAuthRequestContext = null;
    private static int getErrorConfigVersion = 1;
    private static int scheduleImpl;

    static void PlaceComponentResult() {
        BuiltInFictitiousFunctionClassFactory = 1257195648;
        MyBillsEntityDataFactory = -324410153;
        PlaceComponentResult = new byte[]{121, -35, -127, -74, -87};
        KClassImpl$Data$declaredNonStaticMembers$2 = -1568336881;
    }

    static {
        PlaceComponentResult();
        defaultTimeZone = TimeZone.getDefault();
        defaultLocale = Locale.getDefault();
        int i = Feature.UseBigDecimal.mask;
        DEFAULT_PARSER_FEATURE = i | 0 | Feature.SortFeidFastMatch.mask | Feature.IgnoreNotMatch.mask;
        DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        int i2 = SerializerFeature.QuoteFieldNames.mask;
        int i3 = SerializerFeature.SkipTransientField.mask;
        DEFAULT_GENERATE_FEATURE = i2 | 0 | i3 | SerializerFeature.WriteEnumUsingToString.mask | SerializerFeature.SortField.mask;
        int i4 = scheduleImpl + 35;
        getErrorConfigVersion = i4 % 128;
        int i5 = i4 % 2;
    }

    public static final Object parse(String str) {
        Object parse;
        int i = scheduleImpl + 93;
        getErrorConfigVersion = i % 128;
        if (!(i % 2 == 0)) {
            parse = parse(str, DEFAULT_PARSER_FEATURE);
        } else {
            parse = parse(str, DEFAULT_PARSER_FEATURE);
            Object obj = null;
            obj.hashCode();
        }
        try {
            int i2 = scheduleImpl + 41;
            getErrorConfigVersion = i2 % 128;
            if ((i2 % 2 == 0 ? ';' : (char) 19) != ';') {
                return parse;
            }
            int i3 = 28 / 0;
            return parse;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final Object parse(String str, int i) {
        Object obj = null;
        if ((str == null ? ':' : 'M') == 'M') {
            DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, ParserConfig.global, i);
            Object parse = defaultJSONParser.parse(null);
            defaultJSONParser.handleResovleTask(parse);
            defaultJSONParser.close();
            int i2 = scheduleImpl + 7;
            getErrorConfigVersion = i2 % 128;
            if ((i2 % 2 == 0 ? '\b' : '^') != '\b') {
                return parse;
            }
            obj.hashCode();
            return parse;
        }
        int i3 = getErrorConfigVersion + 21;
        scheduleImpl = i3 % 128;
        int i4 = i3 % 2;
        return null;
    }

    public static final Object parse(byte[] bArr, Feature... featureArr) {
        try {
            Object[] objArr = new Object[1];
            a(395682672 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (-32) - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (short) ((-55) - View.MeasureSpec.getSize(0)), View.MeasureSpec.makeMeasureSpec(0, 0) + 1505317901, (byte) Drawable.resolveOpacity(0, 0), objArr);
            JSONObject parseObject = parseObject(new String(bArr, ((String) objArr[0]).intern()), featureArr);
            int i = scheduleImpl + 27;
            getErrorConfigVersion = i % 128;
            if (i % 2 != 0) {
                return parseObject;
            }
            Object obj = null;
            obj.hashCode();
            return parseObject;
        } catch (UnsupportedEncodingException e) {
            throw new JSONException("UTF-8 not support", e);
        }
    }

    public static final Object parse(String str, Feature... featureArr) {
        int i = scheduleImpl + 47;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        int i3 = DEFAULT_PARSER_FEATURE;
        int length = featureArr.length;
        int i4 = 0;
        int i5 = getErrorConfigVersion + 35;
        scheduleImpl = i5 % 128;
        int i6 = i5 % 2;
        while (true) {
            if ((i4 < length ? InputCardNumberView.DIVIDER : (char) 19) == ' ') {
                try {
                    i3 |= featureArr[i4].mask;
                    i4++;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                return parse(str, i3);
            }
        }
    }

    public static final JSONObject parseObject(String str, Feature... featureArr) {
        boolean z;
        int length;
        Object parse = parse(str, featureArr);
        Object[] objArr = null;
        if ((parse instanceof JSONObject ? (char) 14 : (char) 0) == 14) {
            int i = scheduleImpl + 101;
            getErrorConfigVersion = i % 128;
            if (i % 2 == 0) {
                JSONObject jSONObject = (JSONObject) parse;
                int length2 = objArr.length;
                return jSONObject;
            }
            return (JSONObject) parse;
        }
        try {
            JSONObject jSONObject2 = (JSONObject) toJSON(parse);
            if ((DEFAULT_PARSER_FEATURE & Feature.SupportAutoType.mask) == 0) {
                z = false;
            } else {
                int i2 = scheduleImpl + 91;
                getErrorConfigVersion = i2 % 128;
                int i3 = i2 % 2;
                z = true;
            }
            if (!z) {
                int i4 = getErrorConfigVersion + 41;
                scheduleImpl = i4 % 128;
                if (i4 % 2 != 0) {
                    length = featureArr.length;
                    int length3 = objArr.length;
                } else {
                    length = featureArr.length;
                }
                for (int i5 = 0; i5 < length; i5++) {
                    int i6 = getErrorConfigVersion + 79;
                    scheduleImpl = i6 % 128;
                    int i7 = i6 % 2;
                    if (featureArr[i5] == Feature.SupportAutoType) {
                        z = true;
                    }
                }
            }
            if (!(z ? false : true)) {
                int i8 = scheduleImpl + 87;
                getErrorConfigVersion = i8 % 128;
                if (i8 % 2 == 0) {
                    jSONObject2.put(DEFAULT_TYPE_KEY, (Object) parse.getClass().getName());
                    objArr.hashCode();
                } else {
                    jSONObject2.put(DEFAULT_TYPE_KEY, (Object) parse.getClass().getName());
                }
            }
            return jSONObject2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
    
        if ((r5 != null) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        if ((r5 != null ? kotlin.text.Typography.amp : com.alibaba.fastjson.parser.JSONLexer.EOI) != '&') goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        r0 = (com.alibaba.fastjson.JSONObject) toJSON(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        if ((com.alibaba.fastjson.JSON.DEFAULT_PARSER_FEATURE & com.alibaba.fastjson.parser.Feature.SupportAutoType.mask) == 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        r3 = kotlin.text.Typography.dollar;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
    
        r3 = kotlin.text.Typography.greater;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0050, code lost:
    
        if (r3 == '$') goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
    
        if (r1 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
    
        r0.put(com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY, (java.lang.Object) r5.getClass().getName());
        r5 = com.alibaba.fastjson.JSON.getErrorConfigVersion + 31;
        com.alibaba.fastjson.JSON.scheduleImpl = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.alibaba.fastjson.JSONObject parseObject(java.lang.String r5) {
        /*
            int r0 = com.alibaba.fastjson.JSON.scheduleImpl
            int r0 = r0 + 91
            int r1 = r0 % 128
            com.alibaba.fastjson.JSON.getErrorConfigVersion = r1
            int r0 = r0 % 2
            java.lang.Object r5 = parse(r5)
            boolean r0 = r5 instanceof com.alibaba.fastjson.JSONObject
            if (r0 != 0) goto L6d
            int r0 = com.alibaba.fastjson.JSON.scheduleImpl
            int r0 = r0 + 81
            int r1 = r0 % 128
            com.alibaba.fastjson.JSON.getErrorConfigVersion = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L2e
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L2c
            if (r5 == 0) goto L28
            r0 = 1
            goto L29
        L28:
            r0 = 0
        L29:
            if (r0 == 0) goto L6d
            goto L3a
        L2c:
            r5 = move-exception
            throw r5
        L2e:
            r0 = 38
            if (r5 == 0) goto L35
            r3 = 38
            goto L37
        L35:
            r3 = 26
        L37:
            if (r3 == r0) goto L3a
            goto L6d
        L3a:
            java.lang.Object r0 = toJSON(r5)
            com.alibaba.fastjson.JSONObject r0 = (com.alibaba.fastjson.JSONObject) r0
            int r3 = com.alibaba.fastjson.JSON.DEFAULT_PARSER_FEATURE
            com.alibaba.fastjson.parser.Feature r4 = com.alibaba.fastjson.parser.Feature.SupportAutoType
            int r4 = r4.mask
            r3 = r3 & r4
            r4 = 36
            if (r3 == 0) goto L4e
            r3 = 36
            goto L50
        L4e:
            r3 = 62
        L50:
            if (r3 == r4) goto L53
            r1 = 0
        L53:
            if (r1 == 0) goto L6c
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getName()
            java.lang.String r1 = "@type"
            r0.put(r1, r5)
            int r5 = com.alibaba.fastjson.JSON.getErrorConfigVersion
            int r5 = r5 + 31
            int r1 = r5 % 128
            com.alibaba.fastjson.JSON.scheduleImpl = r1
            int r5 = r5 % 2
        L6c:
            return r0
        L6d:
            com.alibaba.fastjson.JSONObject r5 = (com.alibaba.fastjson.JSONObject) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSON.parseObject(java.lang.String):com.alibaba.fastjson.JSONObject");
    }

    public static final <T> T parseObject(String str, TypeReference<T> typeReference, Feature... featureArr) {
        int i = getErrorConfigVersion + 65;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        T t = (T) parseObject(str, typeReference.type, ParserConfig.global, DEFAULT_PARSER_FEATURE, featureArr);
        int i3 = scheduleImpl + 25;
        getErrorConfigVersion = i3 % 128;
        if ((i3 % 2 == 0 ? '%' : 'c') != '%') {
            return t;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return t;
    }

    public static final <T> T parseObject(String str, Class<T> cls, Feature... featureArr) {
        try {
            int i = scheduleImpl + 69;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            T t = (T) parseObject(str, cls, ParserConfig.global, DEFAULT_PARSER_FEATURE, featureArr);
            try {
                int i3 = getErrorConfigVersion + 101;
                scheduleImpl = i3 % 128;
                int i4 = i3 % 2;
                return t;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final <T> T parseObject(String str, Class<T> cls, ParseProcess parseProcess, Feature... featureArr) {
        int i = scheduleImpl + 99;
        getErrorConfigVersion = i % 128;
        if ((i % 2 == 0 ? 'C' : '!') != '!') {
            T t = (T) parseObject(str, cls, ParserConfig.global, parseProcess, DEFAULT_PARSER_FEATURE, featureArr);
            int i2 = 36 / 0;
            return t;
        }
        return (T) parseObject(str, cls, ParserConfig.global, parseProcess, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static final <T> T parseObject(String str, Type type, Feature... featureArr) {
        T t;
        int i = scheduleImpl + 51;
        getErrorConfigVersion = i % 128;
        if (!(i % 2 != 0)) {
            try {
                t = (T) parseObject(str, type, ParserConfig.global, DEFAULT_PARSER_FEATURE, featureArr);
                int i2 = 92 / 0;
            } catch (Exception e) {
                throw e;
            }
        } else {
            t = (T) parseObject(str, type, ParserConfig.global, DEFAULT_PARSER_FEATURE, featureArr);
        }
        int i3 = scheduleImpl + 13;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
        return t;
    }

    public static final <T> T parseObject(String str, Type type, ParseProcess parseProcess, Feature... featureArr) {
        T t;
        int i = getErrorConfigVersion + 101;
        scheduleImpl = i % 128;
        try {
            if (!(i % 2 == 0)) {
                try {
                    t = (T) parseObject(str, type, ParserConfig.global, parseProcess, DEFAULT_PARSER_FEATURE, featureArr);
                    Object obj = null;
                    obj.hashCode();
                } catch (Exception e) {
                    throw e;
                }
            } else {
                t = (T) parseObject(str, type, ParserConfig.global, parseProcess, DEFAULT_PARSER_FEATURE, featureArr);
            }
            int i2 = scheduleImpl + 117;
            getErrorConfigVersion = i2 % 128;
            if (i2 % 2 != 0) {
                return t;
            }
            int i3 = 80 / 0;
            return t;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
    
        if (r4 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        r4 = com.alibaba.fastjson.JSON.scheduleImpl + 89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
    
        com.alibaba.fastjson.JSON.getErrorConfigVersion = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        if ((r4 % 2) != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
    
        r4 = 'O';
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        r4 = 19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        if (r4 == 'O') goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0036, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        r4 = 9 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003a, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003d, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003e, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x003f, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0040, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0041, code lost:
    
        r0 = r7.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0042, code lost:
    
        if (r2 >= r0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0044, code lost:
    
        r6 = r6 | r7[r2].mask;
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004c, code lost:
    
        r7 = new com.alibaba.fastjson.parser.DefaultJSONParser(r4, com.alibaba.fastjson.parser.ParserConfig.global, r6);
        r4 = (T) r7.parseObject(r5);
        r7.handleResovleTask(r4);
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005d, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
    
        if (r4 == null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> T parseObject(java.lang.String r4, java.lang.reflect.Type r5, int r6, com.alibaba.fastjson.parser.Feature... r7) {
        /*
            int r0 = com.alibaba.fastjson.JSON.getErrorConfigVersion
            int r0 = r0 + 7
            int r1 = r0 % 128
            com.alibaba.fastjson.JSON.scheduleImpl = r1
            int r0 = r0 % 2
            r1 = 29
            if (r0 == 0) goto L11
            r0 = 25
            goto L13
        L11:
            r0 = 29
        L13:
            r2 = 0
            r3 = 0
            if (r0 == r1) goto L1f
            r3.hashCode()     // Catch: java.lang.Throwable -> L1d
            if (r4 != 0) goto L41
            goto L21
        L1d:
            r4 = move-exception
            throw r4
        L1f:
            if (r4 != 0) goto L41
        L21:
            int r4 = com.alibaba.fastjson.JSON.scheduleImpl     // Catch: java.lang.Exception -> L3f
            int r4 = r4 + 89
            int r5 = r4 % 128
            com.alibaba.fastjson.JSON.getErrorConfigVersion = r5     // Catch: java.lang.Exception -> L3d
            int r4 = r4 % 2
            r5 = 79
            if (r4 != 0) goto L32
            r4 = 79
            goto L34
        L32:
            r4 = 19
        L34:
            if (r4 == r5) goto L37
            return r3
        L37:
            r4 = 9
            int r4 = r4 / r2
            return r3
        L3b:
            r4 = move-exception
            throw r4
        L3d:
            r4 = move-exception
            throw r4
        L3f:
            r4 = move-exception
            throw r4
        L41:
            int r0 = r7.length
        L42:
            if (r2 >= r0) goto L4c
            r1 = r7[r2]
            int r1 = r1.mask
            r6 = r6 | r1
            int r2 = r2 + 1
            goto L42
        L4c:
            com.alibaba.fastjson.parser.DefaultJSONParser r7 = new com.alibaba.fastjson.parser.DefaultJSONParser
            com.alibaba.fastjson.parser.ParserConfig r0 = com.alibaba.fastjson.parser.ParserConfig.global
            r7.<init>(r4, r0, r6)
            java.lang.Object r4 = r7.parseObject(r5)
            r7.handleResovleTask(r4)
            r7.close()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSON.parseObject(java.lang.String, java.lang.reflect.Type, int, com.alibaba.fastjson.parser.Feature[]):java.lang.Object");
    }

    public static final <T> T parseObject(String str, Type type, ParserConfig parserConfig, int i, Feature... featureArr) {
        try {
            int i2 = scheduleImpl + 97;
            getErrorConfigVersion = i2 % 128;
            if ((i2 % 2 == 0 ? '(' : (char) 3) != '(') {
                return (T) parseObject(str, type, parserConfig, null, i, featureArr);
            }
            T t = (T) parseObject(str, type, parserConfig, null, i, featureArr);
            int i3 = 89 / 0;
            return t;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final <T> T parseObject(String str, Type type, ParserConfig parserConfig, ParseProcess parseProcess, int i, Feature... featureArr) {
        Object obj = null;
        if (str == null) {
            return null;
        }
        int length = featureArr.length;
        int i2 = 0;
        while (true) {
            if ((i2 < length ? (char) 11 : 'S') == 'S') {
                break;
            }
            i |= featureArr[i2].mask;
            i2++;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig, i);
        if (!(parseProcess instanceof ExtraTypeProvider ? false : true)) {
            int i3 = scheduleImpl + 25;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
            try {
                defaultJSONParser.getExtraTypeProviders().add((ExtraTypeProvider) parseProcess);
            } catch (Exception e) {
                throw e;
            }
        }
        if ((parseProcess instanceof ExtraProcessor ? '7' : '1') != '1') {
            int i5 = scheduleImpl + 55;
            getErrorConfigVersion = i5 % 128;
            if ((i5 % 2 == 0 ? 'c' : (char) 22) != 'c') {
                defaultJSONParser.getExtraProcessors().add((ExtraProcessor) parseProcess);
            } else {
                defaultJSONParser.getExtraProcessors().add((ExtraProcessor) parseProcess);
                obj.hashCode();
            }
        }
        if (parseProcess instanceof FieldTypeResolver) {
            defaultJSONParser.fieldTypeResolver = (FieldTypeResolver) parseProcess;
        }
        T t = (T) defaultJSONParser.parseObject(type);
        defaultJSONParser.handleResovleTask(t);
        defaultJSONParser.close();
        return t;
    }

    public static final <T> T parseObject(byte[] bArr, Type type, Feature... featureArr) {
        try {
            Object[] objArr = new Object[1];
            a(395682672 - TextUtils.getOffsetAfter("", 0), (-33) - ExpandableListView.getPackedPositionChild(0L), (short) ((-54) - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), 1505317902 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (byte) Gravity.getAbsoluteGravity(0, 0), objArr);
            T t = (T) parseObject(new String(bArr, ((String) objArr[0]).intern()), type, featureArr);
            int i = getErrorConfigVersion + 37;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            return t;
        } catch (UnsupportedEncodingException unused) {
            throw new JSONException("UTF-8 not support");
        }
    }

    public static final <T> T parseObject(char[] cArr, int i, Type type, Feature... featureArr) {
        if (cArr != null) {
            if (!(cArr.length == 0)) {
                try {
                    int i2 = DEFAULT_PARSER_FEATURE;
                    for (Feature feature : featureArr) {
                        int i3 = getErrorConfigVersion + 97;
                        scheduleImpl = i3 % 128;
                        int i4 = i3 % 2;
                        i2 |= feature.mask;
                    }
                    DefaultJSONParser defaultJSONParser = new DefaultJSONParser(cArr, i, ParserConfig.global, i2);
                    T t = (T) defaultJSONParser.parseObject(type);
                    defaultJSONParser.handleResovleTask(t);
                    defaultJSONParser.close();
                    try {
                        int i5 = getErrorConfigVersion + 41;
                        scheduleImpl = i5 % 128;
                        if ((i5 % 2 != 0 ? '\t' : '9') != '\t') {
                            return t;
                        }
                        int i6 = 20 / 0;
                        return t;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
            return null;
        }
        return null;
    }

    public static final <T> T parseObject(String str, Class<T> cls) {
        try {
            int i = getErrorConfigVersion + 13;
            scheduleImpl = i % 128;
            T t = i % 2 == 0 ? (T) parseObject(str, (Class) cls, new Feature[0]) : (T) parseObject(str, (Class) cls, new Feature[1]);
            int i2 = getErrorConfigVersion + 85;
            scheduleImpl = i2 % 128;
            int i3 = i2 % 2;
            return t;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final JSONArray parseArray(String str) {
        try {
            int i = scheduleImpl + 21;
            getErrorConfigVersion = i % 128;
            return i % 2 == 0 ? parseArray(str, new Feature[0]) : parseArray(str, new Feature[0]);
        } catch (Exception e) {
            throw e;
        }
    }

    public static final JSONArray parseArray(String str, Feature... featureArr) {
        JSONArray jSONArray = null;
        if ((str == null ? 'S' : '\f') != '\f') {
            return null;
        }
        int i = DEFAULT_PARSER_FEATURE;
        int i2 = 0;
        while (true) {
            if ((i2 < featureArr.length ? Typography.greater : 'L') == 'L') {
                break;
            }
            try {
                int i3 = getErrorConfigVersion + 35;
                scheduleImpl = i3 % 128;
                int i4 = i3 % 2;
                try {
                    i |= featureArr[i2].mask;
                    i2++;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
            throw e2;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, ParserConfig.global, i);
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i5 = jSONLexer.token();
        if (i5 == 8) {
            int i6 = scheduleImpl + 121;
            getErrorConfigVersion = i6 % 128;
            int i7 = i6 % 2;
            jSONLexer.nextToken();
        } else {
            if (i5 == 20) {
                int i8 = getErrorConfigVersion + 43;
                scheduleImpl = i8 % 128;
                int i9 = i8 % 2;
            } else {
                jSONArray = new JSONArray();
                defaultJSONParser.parseArray(jSONArray);
                defaultJSONParser.handleResovleTask(jSONArray);
            }
        }
        defaultJSONParser.close();
        return jSONArray;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        if ((r7.isBlankInput()) != false) goto L42;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Collection, java.lang.Object, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List<T>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.util.List<T> parseArray(java.lang.String r7, java.lang.Class<T> r8) {
        /*
            r0 = 0
            r1 = 1
            if (r7 != 0) goto L6
            r2 = 1
            goto L7
        L6:
            r2 = 0
        L7:
            r3 = 0
            if (r2 == r1) goto L56
            com.alibaba.fastjson.parser.DefaultJSONParser r2 = new com.alibaba.fastjson.parser.DefaultJSONParser
            com.alibaba.fastjson.parser.ParserConfig r4 = com.alibaba.fastjson.parser.ParserConfig.global
            r2.<init>(r7, r4)
            com.alibaba.fastjson.parser.JSONLexer r7 = r2.lexer
            int r4 = r7.token()
            r5 = 8
            if (r4 != r5) goto L2e
            int r8 = com.alibaba.fastjson.JSON.getErrorConfigVersion
            int r8 = r8 + 11
            int r0 = r8 % 128
            com.alibaba.fastjson.JSON.scheduleImpl = r0
            int r8 = r8 % 2
            r7.nextToken()
            if (r8 == 0) goto L50
            int r7 = r3.length     // Catch: java.lang.Throwable -> L2c
            goto L50
        L2c:
            r7 = move-exception
            throw r7
        L2e:
            r5 = 20
            r6 = 23
            if (r4 != r5) goto L37
            r4 = 14
            goto L39
        L37:
            r4 = 23
        L39:
            if (r4 == r6) goto L45
            boolean r7 = r7.isBlankInput()
            if (r7 == 0) goto L42
            r0 = 1
        L42:
            if (r0 == 0) goto L45
            goto L50
        L45:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r2.parseArray(r8, r3)
            r2.handleResovleTask(r3)
        L50:
            r2.close()     // Catch: java.lang.Exception -> L54
            return r3
        L54:
            r7 = move-exception
            throw r7
        L56:
            int r7 = com.alibaba.fastjson.JSON.getErrorConfigVersion
            int r7 = r7 + 71
            int r8 = r7 % 128
            com.alibaba.fastjson.JSON.scheduleImpl = r8
            int r7 = r7 % 2
            if (r7 == 0) goto L63
            r0 = 1
        L63:
            if (r0 == r1) goto L66
            return r3
        L66:
            int r7 = r3.length     // Catch: java.lang.Throwable -> L68
            return r3
        L68:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSON.parseArray(java.lang.String, java.lang.Class):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
    
        if ((r5 == null) != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:
    
        r0 = new com.alibaba.fastjson.parser.DefaultJSONParser(r5, com.alibaba.fastjson.parser.ParserConfig.global);
        r5 = r0.parseArray(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0028, code lost:
    
        if (r5 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        if (r1 == true) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002f, code lost:
    
        r3 = java.util.Arrays.asList(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
    
        r0.handleResovleTask(r3);
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003b, code lost:
    
        r5 = com.alibaba.fastjson.JSON.scheduleImpl + 65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003f, code lost:
    
        com.alibaba.fastjson.JSON.getErrorConfigVersion = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0041, code lost:
    
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0044, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0045, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0047, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
    
        if (r5 == null) goto L13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.alibaba.fastjson.parser.DefaultJSONParser] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, java.util.List<java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.List<java.lang.Object> parseArray(java.lang.String r5, java.lang.reflect.Type[] r6) {
        /*
            int r0 = com.alibaba.fastjson.JSON.scheduleImpl
            int r0 = r0 + 21
            int r1 = r0 % 128
            com.alibaba.fastjson.JSON.getErrorConfigVersion = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L15
            int r0 = r3.length     // Catch: java.lang.Throwable -> L13
            if (r5 != 0) goto L1d
            goto L1c
        L13:
            r5 = move-exception
            throw r5
        L15:
            if (r5 != 0) goto L19
            r0 = 1
            goto L1a
        L19:
            r0 = 0
        L1a:
            if (r0 == 0) goto L1d
        L1c:
            return r3
        L1d:
            com.alibaba.fastjson.parser.DefaultJSONParser r0 = new com.alibaba.fastjson.parser.DefaultJSONParser
            com.alibaba.fastjson.parser.ParserConfig r4 = com.alibaba.fastjson.parser.ParserConfig.global     // Catch: java.lang.Exception -> L46
            r0.<init>(r5, r4)     // Catch: java.lang.Exception -> L46
            java.lang.Object[] r5 = r0.parseArray(r6)     // Catch: java.lang.Exception -> L46
            if (r5 != 0) goto L2b
            goto L2c
        L2b:
            r1 = 1
        L2c:
            if (r1 == r2) goto L2f
            goto L33
        L2f:
            java.util.List r3 = java.util.Arrays.asList(r5)
        L33:
            r0.handleResovleTask(r3)
            r0.close()
            int r5 = com.alibaba.fastjson.JSON.scheduleImpl     // Catch: java.lang.Exception -> L46
            int r5 = r5 + 65
            int r6 = r5 % 128
            com.alibaba.fastjson.JSON.getErrorConfigVersion = r6     // Catch: java.lang.Exception -> L44
            int r5 = r5 % 2
            return r3
        L44:
            r5 = move-exception
            throw r5
        L46:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSON.parseArray(java.lang.String, java.lang.reflect.Type[]):java.util.List");
    }

    public static Object parse(String str, ParserConfig parserConfig) {
        int i = scheduleImpl + 89;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        Object parse = parse(str, parserConfig, DEFAULT_PARSER_FEATURE);
        int i3 = scheduleImpl + 91;
        getErrorConfigVersion = i3 % 128;
        if ((i3 % 2 == 0 ? 'D' : (char) 19) != 'D') {
            return parse;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return parse;
    }

    public static Object parse(String str, ParserConfig parserConfig, Feature... featureArr) {
        int i;
        int i2 = scheduleImpl + 85;
        getErrorConfigVersion = i2 % 128;
        if (i2 % 2 != 0) {
            i = DEFAULT_PARSER_FEATURE;
        } else {
            try {
                i = DEFAULT_PARSER_FEATURE;
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = 0;
        while (true) {
            if (!(i3 >= featureArr.length)) {
                int i4 = scheduleImpl + 63;
                getErrorConfigVersion = i4 % 128;
                if (i4 % 2 == 0) {
                    i ^= featureArr[i3].mask;
                    i3 += 108;
                } else {
                    i |= featureArr[i3].mask;
                    i3++;
                }
            } else {
                return parse(str, parserConfig, i);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
    
        if ((r3 == null) != true) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002b, code lost:
    
        if ((r3 == null ? '1' : 'H') != 'H') goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        r3 = com.alibaba.fastjson.JSON.scheduleImpl + 57;
        com.alibaba.fastjson.JSON.getErrorConfigVersion = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0037, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0038, code lost:
    
        r0 = new com.alibaba.fastjson.parser.DefaultJSONParser(r3, r4, r5);
        r3 = r0.parse();
        r0.handleResovleTask(r3);
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object parse(java.lang.String r3, com.alibaba.fastjson.parser.ParserConfig r4, int r5) {
        /*
            int r0 = com.alibaba.fastjson.JSON.scheduleImpl
            int r0 = r0 + 103
            int r1 = r0 % 128
            com.alibaba.fastjson.JSON.getErrorConfigVersion = r1
            int r0 = r0 % 2
            r1 = 71
            if (r0 != 0) goto L11
            r0 = 32
            goto L13
        L11:
            r0 = 71
        L13:
            r2 = 0
            if (r0 == r1) goto L22
            int r0 = r2.length     // Catch: java.lang.Throwable -> L20
            r0 = 1
            if (r3 != 0) goto L1c
            r1 = 1
            goto L1d
        L1c:
            r1 = 0
        L1d:
            if (r1 == r0) goto L2d
            goto L38
        L20:
            r3 = move-exception
            throw r3
        L22:
            r0 = 72
            if (r3 != 0) goto L29
            r1 = 49
            goto L2b
        L29:
            r1 = 72
        L2b:
            if (r1 == r0) goto L38
        L2d:
            int r3 = com.alibaba.fastjson.JSON.scheduleImpl
            int r3 = r3 + 57
            int r4 = r3 % 128
            com.alibaba.fastjson.JSON.getErrorConfigVersion = r4
            int r3 = r3 % 2
            return r2
        L38:
            com.alibaba.fastjson.parser.DefaultJSONParser r0 = new com.alibaba.fastjson.parser.DefaultJSONParser
            r0.<init>(r3, r4, r5)
            java.lang.Object r3 = r0.parse()
            r0.handleResovleTask(r3)
            r0.close()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSON.parse(java.lang.String, com.alibaba.fastjson.parser.ParserConfig, int):java.lang.Object");
    }

    public static final String toJSONString(Object obj) {
        try {
            int i = scheduleImpl + 53;
            getErrorConfigVersion = i % 128;
            String jSONString = !(i % 2 == 0) ? toJSONString(obj, SerializeConfig.globalInstance, null, null, DEFAULT_GENERATE_FEATURE, new SerializerFeature[0]) : toJSONString(obj, SerializeConfig.globalInstance, null, null, DEFAULT_GENERATE_FEATURE, new SerializerFeature[1]);
            int i2 = getErrorConfigVersion + 119;
            scheduleImpl = i2 % 128;
            if (i2 % 2 == 0) {
                return jSONString;
            }
            Object obj2 = null;
            obj2.hashCode();
            return jSONString;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final String toJSONString(Object obj, SerializerFeature... serializerFeatureArr) {
        try {
            int i = scheduleImpl + 65;
            try {
                getErrorConfigVersion = i % 128;
                int i2 = i % 2;
                String jSONString = toJSONString(obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
                int i3 = getErrorConfigVersion + 105;
                scheduleImpl = i3 % 128;
                int i4 = i3 % 2;
                return jSONString;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final String toJSONString(Object obj, int i, SerializerFeature... serializerFeatureArr) {
        try {
            int i2 = getErrorConfigVersion + 103;
            scheduleImpl = i2 % 128;
            if (!(i2 % 2 != 0)) {
                return toJSONString(obj, SerializeConfig.globalInstance, null, null, i, serializerFeatureArr);
            }
            try {
                String jSONString = toJSONString(obj, SerializeConfig.globalInstance, null, null, i, serializerFeatureArr);
                Object[] objArr = null;
                int length = objArr.length;
                return jSONString;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final String toJSONStringWithDateFormat(Object obj, String str, SerializerFeature... serializerFeatureArr) {
        int i = scheduleImpl + 87;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        String jSONString = toJSONString(obj, SerializeConfig.globalInstance, null, str, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
        int i3 = scheduleImpl + 115;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
        return jSONString;
    }

    public static final String toJSONString(Object obj, SerializeFilter serializeFilter, SerializerFeature... serializerFeatureArr) {
        int i = getErrorConfigVersion + 113;
        scheduleImpl = i % 128;
        if (i % 2 == 0) {
            return toJSONString(obj, SerializeConfig.globalInstance, new SerializeFilter[]{serializeFilter}, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
        }
        try {
            SerializeConfig serializeConfig = SerializeConfig.globalInstance;
            try {
                SerializeFilter[] serializeFilterArr = new SerializeFilter[0];
                serializeFilterArr[1] = serializeFilter;
                return toJSONString(obj, serializeConfig, serializeFilterArr, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final String toJSONString(Object obj, SerializeFilter[] serializeFilterArr, SerializerFeature... serializerFeatureArr) {
        int i = getErrorConfigVersion + 13;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        String jSONString = toJSONString(obj, SerializeConfig.globalInstance, serializeFilterArr, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
        int i3 = scheduleImpl + 65;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
        return jSONString;
    }

    public static final byte[] toJSONBytes(Object obj, SerializerFeature... serializerFeatureArr) {
        Object[] objArr = null;
        SerializeWriter serializeWriter = new SerializeWriter(null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
        try {
            new JSONSerializer(serializeWriter, SerializeConfig.globalInstance).write(obj);
            Object[] objArr2 = new Object[1];
            a(View.resolveSize(0, 0) + 395682672, TextUtils.indexOf((CharSequence) "", '0', 0, 0) - 31, (short) ((-55) - View.resolveSize(0, 0)), Color.rgb(0, 0, 0) + 1522095117, (byte) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), objArr2);
            byte[] bytes = serializeWriter.toBytes(((String) objArr2[0]).intern());
            serializeWriter.close();
            int i = scheduleImpl + 1;
            getErrorConfigVersion = i % 128;
            if ((i % 2 == 0 ? 'K' : '\\') != 'K') {
                return bytes;
            }
            int length = objArr.length;
            return bytes;
        } catch (Throwable th) {
            serializeWriter.close();
            throw th;
        }
    }

    public static final String toJSONString(Object obj, SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        int i = scheduleImpl + 39;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        String jSONString = toJSONString(obj, serializeConfig, null, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
        int i3 = getErrorConfigVersion + 53;
        scheduleImpl = i3 % 128;
        int i4 = i3 % 2;
        return jSONString;
    }

    public static final String toJSONString(Object obj, SerializeConfig serializeConfig, SerializeFilter serializeFilter, SerializerFeature... serializerFeatureArr) {
        int i = getErrorConfigVersion + 115;
        scheduleImpl = i % 128;
        String jSONString = i % 2 != 0 ? toJSONString(obj, serializeConfig, new SerializeFilter[]{serializeFilter}, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr) : toJSONString(obj, serializeConfig, new SerializeFilter[]{serializeFilter}, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
        int i2 = scheduleImpl + 79;
        getErrorConfigVersion = i2 % 128;
        int i3 = i2 % 2;
        return jSONString;
    }

    public static final String toJSONString(Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, SerializerFeature... serializerFeatureArr) {
        int i = getErrorConfigVersion + 125;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        String jSONString = toJSONString(obj, serializeConfig, serializeFilterArr, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
        int i3 = scheduleImpl + 95;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
        return jSONString;
    }

    public static final String toJSONStringZ(Object obj, SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        String jSONString;
        int i = getErrorConfigVersion + 125;
        scheduleImpl = i % 128;
        if (i % 2 == 0) {
            jSONString = toJSONString(obj, SerializeConfig.globalInstance, null, null, 0, serializerFeatureArr);
        } else {
            try {
                jSONString = toJSONString(obj, SerializeConfig.globalInstance, null, null, 1, serializerFeatureArr);
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = getErrorConfigVersion + 123;
        scheduleImpl = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return jSONString;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return jSONString;
    }

    public static final byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        Object obj2 = null;
        SerializeWriter serializeWriter = new SerializeWriter(null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
        try {
            new JSONSerializer(serializeWriter, serializeConfig).write(obj);
            Object[] objArr = new Object[1];
            a(395682672 - (ViewConfiguration.getFadingEdgeLength() >> 16), (-32) - (ViewConfiguration.getLongPressTimeout() >> 16), (short) ((-55) - Color.argb(0, 0, 0, 0)), ((Process.getThreadPriority(0) + 20) >> 6) + 1505317901, (byte) TextUtils.indexOf("", "", 0, 0), objArr);
            byte[] bytes = serializeWriter.toBytes(((String) objArr[0]).intern());
            serializeWriter.close();
            int i = getErrorConfigVersion + 17;
            scheduleImpl = i % 128;
            if (!(i % 2 != 0)) {
                return bytes;
            }
            obj2.hashCode();
            return bytes;
        } catch (Throwable th) {
            serializeWriter.close();
            throw th;
        }
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, int i, SerializerFeature... serializerFeatureArr) {
        int i2 = getErrorConfigVersion + 65;
        scheduleImpl = i2 % 128;
        int i3 = i2 % 2;
        try {
            byte[] jSONBytes = toJSONBytes(obj, serializeConfig, new SerializeFilter[0], i, serializerFeatureArr);
            int i4 = getErrorConfigVersion + 55;
            scheduleImpl = i4 % 128;
            int i5 = i4 % 2;
            return jSONBytes;
        } catch (Exception e) {
            throw e;
        }
    }

    public static byte[] toJSONBytes(Object obj, SerializeFilter[] serializeFilterArr, SerializerFeature... serializerFeatureArr) {
        int i = scheduleImpl + 61;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        byte[] jSONBytes = toJSONBytes(obj, SerializeConfig.globalInstance, serializeFilterArr, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
        int i3 = getErrorConfigVersion + 57;
        scheduleImpl = i3 % 128;
        if ((i3 % 2 != 0 ? Typography.dollar : '(') != '(') {
            Object[] objArr = null;
            int length = objArr.length;
            return jSONBytes;
        }
        return jSONBytes;
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, int i, SerializerFeature... serializerFeatureArr) {
        Object obj2 = null;
        SerializeWriter serializeWriter = new SerializeWriter(null, i, serializerFeatureArr);
        try {
            JSONSerializer jSONSerializer = new JSONSerializer(serializeWriter, serializeConfig);
            if (serializeFilterArr != null) {
                int i2 = getErrorConfigVersion + 33;
                scheduleImpl = i2 % 128;
                int i3 = i2 % 2;
                int length = serializeFilterArr.length;
                int i4 = 0;
                while (i4 < length) {
                    SerializeFilter serializeFilter = serializeFilterArr[i4];
                    if (serializeFilter != null) {
                        if (!(!(serializeFilter instanceof PropertyPreFilter))) {
                            int i5 = scheduleImpl + 47;
                            getErrorConfigVersion = i5 % 128;
                            if (i5 % 2 == 0) {
                                jSONSerializer.getPropertyPreFilters().add((PropertyPreFilter) serializeFilter);
                                obj2.hashCode();
                            } else {
                                jSONSerializer.getPropertyPreFilters().add((PropertyPreFilter) serializeFilter);
                            }
                        }
                        if (serializeFilter instanceof NameFilter) {
                            jSONSerializer.getNameFilters().add((NameFilter) serializeFilter);
                        }
                        if (!(!(serializeFilter instanceof ValueFilter))) {
                            int i6 = getErrorConfigVersion + 27;
                            scheduleImpl = i6 % 128;
                            int i7 = i6 % 2;
                            jSONSerializer.getValueFilters().add((ValueFilter) serializeFilter);
                        }
                        if (serializeFilter instanceof PropertyFilter) {
                            jSONSerializer.getPropertyFilters().add((PropertyFilter) serializeFilter);
                        }
                        if ((serializeFilter instanceof BeforeFilter ? '#' : 'E') == '#') {
                            jSONSerializer.getBeforeFilters().add((BeforeFilter) serializeFilter);
                        }
                        if ((serializeFilter instanceof AfterFilter ? '\f' : (char) 22) != 22) {
                            jSONSerializer.getAfterFilters().add((AfterFilter) serializeFilter);
                        }
                    }
                    i4++;
                    int i8 = scheduleImpl + 117;
                    getErrorConfigVersion = i8 % 128;
                    int i9 = i8 % 2;
                }
            }
            jSONSerializer.write(obj);
            Object[] objArr = new Object[1];
            a((ViewConfiguration.getJumpTapTimeout() >> 16) + 395682672, (-32) - TextUtils.indexOf("", ""), (short) (TextUtils.indexOf((CharSequence) "", '0') - 54), ExpandableListView.getPackedPositionGroup(0L) + 1505317901, (byte) (ViewConfiguration.getWindowTouchSlop() >> 8), objArr);
            return serializeWriter.toBytes(((String) objArr[0]).intern());
        } finally {
            serializeWriter.close();
        }
    }

    public static final String toJSONString(Object obj, boolean z) {
        if ((!z ? '[' : (char) 23) != 23) {
            int i = scheduleImpl + 43;
            getErrorConfigVersion = i % 128;
            if (i % 2 == 0) {
                int i2 = 33 / 0;
                return toJSONString(obj);
            }
            return toJSONString(obj);
        }
        String jSONString = toJSONString(obj, SerializerFeature.PrettyFormat);
        int i3 = scheduleImpl + 35;
        getErrorConfigVersion = i3 % 128;
        if ((i3 % 2 == 0 ? 'Y' : (char) 14) != 14) {
            int i4 = 39 / 0;
            return jSONString;
        }
        return jSONString;
    }

    public static final void writeJSONStringTo(Object obj, Writer writer, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter(writer, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
        try {
            new JSONSerializer(serializeWriter, SerializeConfig.globalInstance).write(obj);
            serializeWriter.close();
            int i = scheduleImpl + 55;
            getErrorConfigVersion = i % 128;
            if (i % 2 == 0) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Throwable th) {
            serializeWriter.close();
            throw th;
        }
    }

    public String toString() {
        int i = getErrorConfigVersion + 9;
        scheduleImpl = i % 128;
        if (i % 2 != 0) {
            String jSONString = toJSONString();
            Object obj = null;
            obj.hashCode();
            return jSONString;
        }
        return toJSONString();
    }

    @Override // com.alibaba.fastjson.JSONAware
    public String toJSONString() {
        SerializeWriter serializeWriter = new SerializeWriter(null, DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
        try {
            new JSONSerializer(serializeWriter, SerializeConfig.globalInstance).write(this);
            String obj = serializeWriter.toString();
            serializeWriter.close();
            int i = scheduleImpl + 1;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            return obj;
        } catch (Throwable th) {
            serializeWriter.close();
            throw th;
        }
    }

    @Override // com.alibaba.fastjson.JSONStreamAware
    public void writeJSONString(Appendable appendable) {
        try {
            Object[] objArr = null;
            SerializeWriter serializeWriter = new SerializeWriter(null, DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
            try {
                try {
                    new JSONSerializer(serializeWriter, SerializeConfig.globalInstance).write(this);
                    appendable.append(serializeWriter.toString());
                    int i = scheduleImpl + 97;
                    getErrorConfigVersion = i % 128;
                    if ((i % 2 == 0 ? '/' : 'N') != 'N') {
                        int length = objArr.length;
                    }
                } finally {
                    serializeWriter.close();
                }
            } catch (IOException e) {
                throw new JSONException(e.getMessage(), e);
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final Object toJSON(Object obj) {
        try {
            int i = scheduleImpl + 107;
            getErrorConfigVersion = i % 128;
            if ((i % 2 != 0 ? 'U' : (char) 2) != 'U') {
                try {
                    Object json = toJSON(obj, SerializeConfig.globalInstance);
                    Object[] objArr = null;
                    int length = objArr.length;
                    return json;
                } catch (Exception e) {
                    throw e;
                }
            }
            return toJSON(obj, SerializeConfig.globalInstance);
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Deprecated
    public static final Object toJSON(Object obj, ParserConfig parserConfig) {
        int i = getErrorConfigVersion + 51;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        Object json = toJSON(obj, SerializeConfig.globalInstance);
        int i3 = getErrorConfigVersion + 3;
        scheduleImpl = i3 % 128;
        int i4 = i3 % 2;
        return json;
    }

    public static Object toJSON(Object obj, SerializeConfig serializeConfig) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof JSON) {
            return (JSON) obj;
        }
        int i = 0;
        if (obj instanceof Map) {
            int i2 = getErrorConfigVersion + 3;
            scheduleImpl = i2 % 128;
            int i3 = i2 % 2;
            Map map = (Map) obj;
            int size = map.size();
            JSONObject jSONObject = new JSONObject(map instanceof LinkedHashMap ? new LinkedHashMap(size) : map instanceof TreeMap ? new TreeMap() : new HashMap(size));
            for (Map.Entry entry : map.entrySet()) {
                try {
                    jSONObject.put(TypeUtils.castToString(entry.getKey()), toJSON(entry.getValue()));
                } catch (Exception e) {
                    throw e;
                }
            }
            return jSONObject;
        } else if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            JSONArray jSONArray = new JSONArray(collection.size());
            Iterator it = collection.iterator();
            int i4 = getErrorConfigVersion + 67;
            scheduleImpl = i4 % 128;
            int i5 = i4 % 2;
            while (it.hasNext()) {
                jSONArray.add(toJSON(it.next()));
            }
            return jSONArray;
        } else {
            Class<?> cls = obj.getClass();
            if (cls.isEnum()) {
                int i6 = getErrorConfigVersion + 121;
                scheduleImpl = i6 % 128;
                int i7 = i6 % 2;
                return ((Enum) obj).name();
            } else if (cls.isArray()) {
                int length = Array.getLength(obj);
                JSONArray jSONArray2 = new JSONArray(length);
                while (i < length) {
                    int i8 = scheduleImpl + 77;
                    getErrorConfigVersion = i8 % 128;
                    if ((i8 % 2 == 0 ? ';' : (char) 3) != ';') {
                        jSONArray2.add(toJSON(Array.get(obj, i)));
                        i++;
                    } else {
                        jSONArray2.add(toJSON(Array.get(obj, i)));
                        i += 24;
                    }
                }
                int i9 = getErrorConfigVersion + 53;
                scheduleImpl = i9 % 128;
                int i10 = i9 % 2;
                return jSONArray2;
            } else if (ParserConfig.isPrimitive(cls)) {
                return obj;
            } else {
                ObjectSerializer objectSerializer = serializeConfig.get(cls);
                if (!(objectSerializer instanceof JavaBeanSerializer)) {
                    return null;
                }
                JavaBeanSerializer javaBeanSerializer = (JavaBeanSerializer) objectSerializer;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    Iterator<Map.Entry<String, Object>> it2 = javaBeanSerializer.getFieldValuesMap(obj).entrySet().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            return jSONObject2;
                        }
                        int i11 = scheduleImpl + 117;
                        getErrorConfigVersion = i11 % 128;
                        if (!(i11 % 2 == 0)) {
                            Map.Entry<String, Object> next = it2.next();
                            jSONObject2.put(next.getKey(), toJSON(next.getValue()));
                        } else {
                            Map.Entry<String, Object> next2 = it2.next();
                            jSONObject2.put(next2.getKey(), toJSON(next2.getValue()));
                            int i12 = 72 / 0;
                        }
                    }
                } catch (Exception e2) {
                    throw new JSONException("toJSON error", e2);
                }
            }
        }
    }

    public static final <T> T toJavaObject(JSON json, Class<T> cls) {
        int i = getErrorConfigVersion + 117;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        T t = (T) TypeUtils.cast((Object) json, (Class) cls, ParserConfig.global);
        int i3 = getErrorConfigVersion + 49;
        scheduleImpl = i3 % 128;
        int i4 = i3 % 2;
        return t;
    }

    public <T> T toJavaObject(Class<T> cls) {
        int i = getErrorConfigVersion + 47;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        try {
            T t = (T) TypeUtils.cast((Object) this, (Class) cls, ParserConfig.getGlobalInstance());
            int i3 = getErrorConfigVersion + 59;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
            return t;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
    
        if (r9.length() != 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String toJSONString(java.lang.Object r6, com.alibaba.fastjson.serializer.SerializeConfig r7, com.alibaba.fastjson.serializer.SerializeFilter[] r8, java.lang.String r9, int r10, com.alibaba.fastjson.serializer.SerializerFeature... r11) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSON.toJSONString(java.lang.Object, com.alibaba.fastjson.serializer.SerializeConfig, com.alibaba.fastjson.serializer.SerializeFilter[], java.lang.String, int, com.alibaba.fastjson.serializer.SerializerFeature[]):java.lang.String");
    }

    private static void a(int i, int i2, short s, int i3, byte b, Object[] objArr) {
        boolean z;
        int length;
        byte[] bArr;
        int i4;
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i5 = i2 + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L));
        if (i5 == -1) {
            int i6 = $10 + 119;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            z = true;
        } else {
            z = false;
        }
        if ((z ? '?' : 'K') == '?') {
            byte[] bArr2 = PlaceComponentResult;
            if (bArr2 != null) {
                int length2 = bArr2.length;
                byte[] bArr3 = new byte[length2];
                for (int i8 = 0; i8 < length2; i8++) {
                    bArr3[i8] = (byte) (bArr2[i8] ^ 3097486228508854431L);
                }
                bArr2 = bArr3;
            }
            i5 = (bArr2 == null ? (char) 22 : '?') != 22 ? (byte) (((byte) (PlaceComponentResult[i + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L))) : (short) (((short) (getAuthRequestContext[i + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L)));
        }
        if (!(i5 <= 0)) {
            b2.getAuthRequestContext = ((i + i5) - 2) + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L)) + (z ? 1 : 0);
            b2.MyBillsEntityDataFactory = (char) (i3 + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr4 = PlaceComponentResult;
            if ((bArr4 != null ? '0' : (char) 21) == '0') {
                try {
                    int i9 = $11 + 45;
                    $10 = i9 % 128;
                    if (!(i9 % 2 != 0)) {
                        length = bArr4.length;
                        bArr = new byte[length];
                        i4 = 0;
                    } else {
                        length = bArr4.length;
                        bArr = new byte[length];
                        i4 = 1;
                    }
                    while (i4 < length) {
                        bArr[i4] = (byte) (bArr4[i4] ^ 3097486228508854431L);
                        i4++;
                    }
                    bArr4 = bArr;
                } catch (Exception e) {
                    throw e;
                }
            }
            boolean z2 = bArr4 != null;
            b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            int i10 = $10 + 3;
            $11 = i10 % 128;
            int i11 = i10 % 2;
            while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i5) {
                if (z2) {
                    byte[] bArr5 = PlaceComponentResult;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = getAuthRequestContext;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                }
                sb.append(b2.MyBillsEntityDataFactory);
                b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                b2.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
        }
        objArr[0] = sb.toString();
    }
}
