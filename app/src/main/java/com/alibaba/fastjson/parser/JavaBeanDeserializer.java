package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import kotlin.text.Typography;

/* loaded from: classes3.dex */
public class JavaBeanDeserializer implements ObjectDeserializer {
    private final Map<String, FieldDeserializer> alterNameFieldDeserializers;
    public final JavaBeanInfo beanInfo;
    protected final Class<?> clazz;
    private ConcurrentMap<String, Object> extraFieldDeserializers;
    private final FieldDeserializer[] fieldDeserializers;
    private transient long[] smartMatchHashArray;
    private transient int[] smartMatchHashArrayMapping;
    private final FieldDeserializer[] sortedFieldDeserializers;
    public static final byte[] getAuthRequestContext = {39, -116, 116, Byte.MAX_VALUE, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 202;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002d -> B:23:0x003a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 12
            int r8 = 15 - r8
            int r7 = r7 * 7
            int r7 = 106 - r7
            int r6 = r6 * 3
            int r6 = 16 - r6
            byte[] r0 = com.alibaba.fastjson.parser.JavaBeanDeserializer.getAuthRequestContext
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1d
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L3a
        L1d:
            r3 = 0
        L1e:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r8 = r8 + 1
            if (r3 != r6) goto L2d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2d:
            r4 = r0[r8]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L3a:
            int r8 = r8 + r6
            int r6 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JavaBeanDeserializer.a(int, short, short, java.lang.Object[]):void");
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, cls, type, JavaBeanInfo.build(cls, cls.getModifiers(), type, false, true, true, true, parserConfig.propertyNamingStrategy));
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type, JavaBeanInfo javaBeanInfo) {
        this.clazz = cls;
        this.beanInfo = javaBeanInfo;
        this.sortedFieldDeserializers = new FieldDeserializer[javaBeanInfo.sortedFields.length];
        int length = javaBeanInfo.sortedFields.length;
        HashMap hashMap = null;
        for (int i = 0; i < length; i++) {
            FieldInfo fieldInfo = javaBeanInfo.sortedFields[i];
            FieldDeserializer createFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, cls, fieldInfo);
            this.sortedFieldDeserializers[i] = createFieldDeserializer;
            for (String str : fieldInfo.alternateNames) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(str, createFieldDeserializer);
            }
        }
        this.alterNameFieldDeserializers = hashMap;
        this.fieldDeserializers = new FieldDeserializer[javaBeanInfo.fields.length];
        int length2 = javaBeanInfo.fields.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.fieldDeserializers[i2] = getFieldDeserializer(javaBeanInfo.fields[i2].name);
        }
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        Object newInstance;
        if ((type instanceof Class) && this.clazz.isInterface()) {
            Class cls = (Class) type;
            try {
                byte b = (byte) (getAuthRequestContext[15] - 1);
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls2 = Class.forName((String) objArr[0]);
                byte b3 = getAuthRequestContext[15];
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                return Proxy.newProxyInstance(((Thread) cls2.getMethod((String) objArr2[0], null).invoke(null, null)).getContextClassLoader(), new Class[]{cls}, new JSONObject((defaultJSONParser.lexer.features & Feature.OrderedField.mask) != 0));
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } else if (this.beanInfo.defaultConstructor == null && this.beanInfo.factoryMethod == null) {
            return null;
        } else {
            if (this.beanInfo.factoryMethod == null || this.beanInfo.defaultConstructorParameterSize <= 0) {
                try {
                    Constructor<?> constructor = this.beanInfo.defaultConstructor;
                    if (this.beanInfo.defaultConstructorParameterSize != 0) {
                        newInstance = constructor.newInstance(defaultJSONParser.contex.object);
                    } else if (constructor != null) {
                        newInstance = constructor.newInstance(new Object[0]);
                    } else {
                        newInstance = this.beanInfo.factoryMethod.invoke(null, new Object[0]);
                    }
                    if (defaultJSONParser != null && (defaultJSONParser.lexer.features & Feature.InitStringFieldAsEmpty.mask) != 0) {
                        for (FieldInfo fieldInfo : this.beanInfo.fields) {
                            if (fieldInfo.fieldClass == String.class) {
                                fieldInfo.set(newInstance, "");
                            }
                        }
                    }
                    return newInstance;
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("create instance error, class ");
                    sb.append(this.clazz.getName());
                    throw new JSONException(sb.toString(), e);
                }
            }
            return null;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null);
    }

    private <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        Enum r8;
        String str;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        T t = (T) createInstance(defaultJSONParser, type);
        int length = this.sortedFieldDeserializers.length;
        int i = 0;
        while (i < length) {
            char c = i == length + (-1) ? ']' : ',';
            FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i];
            FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
            Class<?> cls = fieldInfo.fieldClass;
            try {
                if (cls == Integer.TYPE) {
                    int scanLongValue = (int) jSONLexer.scanLongValue();
                    if (fieldInfo.fieldAccess) {
                        fieldInfo.field.setInt(t, scanLongValue);
                    } else {
                        fieldDeserializer.setValue(t, new Integer(scanLongValue));
                    }
                    if (jSONLexer.ch == ',') {
                        int i2 = jSONLexer.bp + 1;
                        jSONLexer.bp = i2;
                        jSONLexer.ch = i2 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i2);
                        jSONLexer.token = 16;
                    } else if (jSONLexer.ch == ']') {
                        int i3 = jSONLexer.bp + 1;
                        jSONLexer.bp = i3;
                        jSONLexer.ch = i3 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i3);
                        jSONLexer.token = 15;
                    } else {
                        jSONLexer.nextToken();
                    }
                } else if (cls == String.class) {
                    if (jSONLexer.ch == '\"') {
                        str = jSONLexer.scanStringValue(Typography.quote);
                    } else if (jSONLexer.ch == 'n' && jSONLexer.text.startsWith("null", jSONLexer.bp)) {
                        jSONLexer.bp += 4;
                        jSONLexer.ch = jSONLexer.bp >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(jSONLexer.bp);
                        str = null;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("not match string. feild : ");
                        sb.append(obj);
                        throw new JSONException(sb.toString());
                    }
                    if (fieldInfo.fieldAccess) {
                        fieldInfo.field.set(t, str);
                    } else {
                        fieldDeserializer.setValue(t, str);
                    }
                    if (jSONLexer.ch == ',') {
                        int i4 = jSONLexer.bp + 1;
                        jSONLexer.bp = i4;
                        jSONLexer.ch = i4 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i4);
                        jSONLexer.token = 16;
                    } else if (jSONLexer.ch == ']') {
                        int i5 = jSONLexer.bp + 1;
                        jSONLexer.bp = i5;
                        jSONLexer.ch = i5 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i5);
                        jSONLexer.token = 15;
                    } else {
                        jSONLexer.nextToken();
                    }
                } else {
                    if (cls == Long.TYPE) {
                        long scanLongValue2 = jSONLexer.scanLongValue();
                        if (fieldInfo.fieldAccess) {
                            fieldInfo.field.setLong(t, scanLongValue2);
                        } else {
                            fieldDeserializer.setValue(t, new Long(scanLongValue2));
                        }
                        if (jSONLexer.ch == ',') {
                            int i6 = jSONLexer.bp + 1;
                            jSONLexer.bp = i6;
                            jSONLexer.ch = i6 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i6);
                            jSONLexer.token = 16;
                        } else if (jSONLexer.ch == ']') {
                            int i7 = jSONLexer.bp + 1;
                            jSONLexer.bp = i7;
                            jSONLexer.ch = i7 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i7);
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else if (cls == Boolean.TYPE) {
                        boolean scanBoolean = jSONLexer.scanBoolean();
                        if (fieldInfo.fieldAccess) {
                            fieldInfo.field.setBoolean(t, scanBoolean);
                        } else {
                            fieldDeserializer.setValue(t, Boolean.valueOf(scanBoolean));
                        }
                        if (jSONLexer.ch == ',') {
                            int i8 = jSONLexer.bp + 1;
                            jSONLexer.bp = i8;
                            jSONLexer.ch = i8 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i8);
                            jSONLexer.token = 16;
                        } else if (jSONLexer.ch == ']') {
                            int i9 = jSONLexer.bp + 1;
                            jSONLexer.bp = i9;
                            jSONLexer.ch = i9 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i9);
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else if (cls.isEnum()) {
                        char c2 = jSONLexer.ch;
                        if (c2 == '\"') {
                            String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.symbolTable);
                            r8 = scanSymbol == null ? null : Enum.valueOf(cls, scanSymbol);
                        } else if (c2 >= '0' && c2 <= '9') {
                            r8 = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.config)).ordinalEnums[(int) jSONLexer.scanLongValue()];
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("illegal enum.");
                            sb2.append(jSONLexer.info());
                            throw new JSONException(sb2.toString());
                        }
                        fieldDeserializer.setValue(t, r8);
                        if (jSONLexer.ch == ',') {
                            int i10 = jSONLexer.bp + 1;
                            jSONLexer.bp = i10;
                            jSONLexer.ch = i10 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i10);
                            jSONLexer.token = 16;
                        } else if (jSONLexer.ch == ']') {
                            int i11 = jSONLexer.bp + 1;
                            jSONLexer.bp = i11;
                            jSONLexer.ch = i11 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i11);
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else if (cls == Date.class && jSONLexer.ch == '1') {
                        fieldDeserializer.setValue(t, new Date(jSONLexer.scanLongValue()));
                        if (jSONLexer.ch == ',') {
                            int i12 = jSONLexer.bp + 1;
                            jSONLexer.bp = i12;
                            jSONLexer.ch = i12 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i12);
                            jSONLexer.token = 16;
                        } else if (jSONLexer.ch == ']') {
                            int i13 = jSONLexer.bp + 1;
                            jSONLexer.bp = i13;
                            jSONLexer.ch = i13 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i13);
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else {
                        if (jSONLexer.ch == '[') {
                            int i14 = jSONLexer.bp + 1;
                            jSONLexer.bp = i14;
                            jSONLexer.ch = i14 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i14);
                            jSONLexer.token = 14;
                        } else if (jSONLexer.ch == '{') {
                            int i15 = jSONLexer.bp + 1;
                            jSONLexer.bp = i15;
                            jSONLexer.ch = i15 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i15);
                            jSONLexer.token = 12;
                        } else {
                            jSONLexer.nextToken();
                        }
                        fieldDeserializer.parseField(defaultJSONParser, t, fieldInfo.fieldType, null);
                        if (c == ']') {
                            if (jSONLexer.token != 15) {
                                throw new JSONException("syntax error");
                            }
                        } else if (c == ',' && jSONLexer.token != 16) {
                            throw new JSONException("syntax error");
                        }
                    }
                    i++;
                }
                i++;
            } catch (IllegalAccessException e) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("set ");
                sb3.append(fieldInfo.name);
                sb3.append("error");
                throw new JSONException(sb3.toString(), e);
            }
        }
        if (jSONLexer.ch == ',') {
            int i16 = jSONLexer.bp + 1;
            jSONLexer.bp = i16;
            jSONLexer.ch = i16 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i16);
            jSONLexer.token = 16;
        } else {
            jSONLexer.nextToken();
        }
        return t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:1072:0x06d7, code lost:
    
        r1 = new java.lang.StringBuilder();
        r1.append("syntax error, unexpect token ");
        r1.append(com.alibaba.fastjson.parser.JSONToken.name(r10.token));
     */
    /* JADX WARN: Code restructure failed: missing block: B:1073:0x06f4, code lost:
    
        throw new com.alibaba.fastjson.JSONException(r1.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:808:0x02e1, code lost:
    
        r10.nextTokenWithChar(':');
        r0 = r10.token;
     */
    /* JADX WARN: Code restructure failed: missing block: B:809:0x02e7, code lost:
    
        if (r0 != 4) goto L845;
     */
    /* JADX WARN: Code restructure failed: missing block: B:810:0x02e9, code lost:
    
        r0 = r10.stringVal();
     */
    /* JADX WARN: Code restructure failed: missing block: B:811:0x02f3, code lost:
    
        if (com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool.PREFIX_ID.equals(r0) == false) goto L814;
     */
    /* JADX WARN: Code restructure failed: missing block: B:812:0x02f5, code lost:
    
        r1 = (T) r14.object;
     */
    /* JADX WARN: Code restructure failed: missing block: B:815:0x02fe, code lost:
    
        if ("..".equals(r0) == false) goto L821;
     */
    /* JADX WARN: Code restructure failed: missing block: B:816:0x0300, code lost:
    
        r2 = r14.parent;
     */
    /* JADX WARN: Code restructure failed: missing block: B:817:0x0304, code lost:
    
        if (r2.object == null) goto L819;
     */
    /* JADX WARN: Code restructure failed: missing block: B:818:0x0306, code lost:
    
        r1 = (T) r2.object;
     */
    /* JADX WARN: Code restructure failed: missing block: B:819:0x0309, code lost:
    
        r36.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r2, r0));
        r36.resolveStatus = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:822:0x031b, code lost:
    
        if ("$".equals(r0) == false) goto L833;
     */
    /* JADX WARN: Code restructure failed: missing block: B:823:0x031d, code lost:
    
        r2 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:825:0x0320, code lost:
    
        if (r2.parent == null) goto L1137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:826:0x0322, code lost:
    
        r2 = r2.parent;
     */
    /* JADX WARN: Code restructure failed: missing block: B:828:0x0327, code lost:
    
        if (r2.object == null) goto L830;
     */
    /* JADX WARN: Code restructure failed: missing block: B:829:0x0329, code lost:
    
        r1 = (T) r2.object;
     */
    /* JADX WARN: Code restructure failed: missing block: B:830:0x032c, code lost:
    
        r36.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r2, r0));
        r36.resolveStatus = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:833:0x033c, code lost:
    
        r36.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r14, r0));
        r36.resolveStatus = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:834:0x0347, code lost:
    
        r10.nextToken(13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:835:0x034e, code lost:
    
        if (r10.token != 13) goto L842;
     */
    /* JADX WARN: Code restructure failed: missing block: B:836:0x0350, code lost:
    
        r10.nextToken(16);
        r36.setContext(r14, r1, r38);
     */
    /* JADX WARN: Code restructure failed: missing block: B:837:0x0358, code lost:
    
        r2 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:838:0x035a, code lost:
    
        if (r2 == null) goto L840;
     */
    /* JADX WARN: Code restructure failed: missing block: B:839:0x035c, code lost:
    
        r2.object = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:840:0x035e, code lost:
    
        r36.setContext(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:841:0x0361, code lost:
    
        return (T) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:844:0x036b, code lost:
    
        throw new com.alibaba.fastjson.JSONException("illegal ref");
     */
    /* JADX WARN: Code restructure failed: missing block: B:845:0x036c, code lost:
    
        r4 = new java.lang.StringBuilder();
        r4.append("illegal ref, ");
        r4.append(com.alibaba.fastjson.parser.JSONToken.name(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:846:0x0388, code lost:
    
        throw new com.alibaba.fastjson.JSONException(r4.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:847:0x0389, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:848:0x038a, code lost:
    
        r12 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:866:0x03c8, code lost:
    
        r13 = r21;
        r34 = r15;
        r15 = (T) r1;
        r1 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:868:0x03dd, code lost:
    
        r4 = getSeeAlso(r36.config, r35.beanInfo, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:869:0x03e5, code lost:
    
        if (r4 != null) goto L880;
     */
    /* JADX WARN: Code restructure failed: missing block: B:870:0x03e7, code lost:
    
        r4 = r36.config.checkAutoType(r2, r35.clazz, r10.features);
        r0 = com.alibaba.fastjson.util.TypeUtils.getClass(r37);
     */
    /* JADX WARN: Code restructure failed: missing block: B:871:0x03f5, code lost:
    
        if (r0 == null) goto L878;
     */
    /* JADX WARN: Code restructure failed: missing block: B:872:0x03f7, code lost:
    
        if (r4 == null) goto L876;
     */
    /* JADX WARN: Code restructure failed: missing block: B:874:0x03fd, code lost:
    
        if (r0.isAssignableFrom(r4) == false) goto L876;
     */
    /* JADX WARN: Code restructure failed: missing block: B:877:0x0408, code lost:
    
        throw new com.alibaba.fastjson.JSONException("type not match");
     */
    /* JADX WARN: Code restructure failed: missing block: B:879:0x040f, code lost:
    
        r4 = r36.config.getDeserializer(r4);
        r0 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:880:0x0415, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:882:0x0418, code lost:
    
        if ((r4 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer) == false) goto L886;
     */
    /* JADX WARN: Code restructure failed: missing block: B:883:0x041a, code lost:
    
        r4 = r4;
        r0 = (T) r4.deserialze(r36, r0, r38, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:884:0x0421, code lost:
    
        if (r3 == null) goto L887;
     */
    /* JADX WARN: Code restructure failed: missing block: B:885:0x0423, code lost:
    
        r4.getFieldDeserializer(r3).setValue(r0, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:886:0x042b, code lost:
    
        r0 = (T) r4.deserialze(r36, r0, r38);
     */
    /* JADX WARN: Code restructure failed: missing block: B:887:0x042f, code lost:
    
        if (r15 == null) goto L889;
     */
    /* JADX WARN: Code restructure failed: missing block: B:888:0x0431, code lost:
    
        r15.object = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:889:0x0433, code lost:
    
        r36.setContext(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:890:0x0436, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:1009:0x05c9  */
    /* JADX WARN: Removed duplicated region for block: B:1010:0x05ca A[Catch: all -> 0x06fe, TryCatch #10 {all -> 0x06fe, blocks: (B:913:0x0483, B:1007:0x05c3, B:1010:0x05ca, B:1012:0x05d0, B:1067:0x06b9, B:1069:0x06bf, B:1072:0x06d7, B:1073:0x06f4, B:915:0x048b, B:920:0x0494, B:925:0x049d, B:930:0x04a6, B:940:0x04c5, B:994:0x057d, B:936:0x04b2, B:937:0x04b7, B:938:0x04bc, B:939:0x04c1, B:944:0x04d2, B:949:0x04dc, B:954:0x04e5, B:959:0x04ee, B:964:0x04f7, B:965:0x04fe, B:967:0x0502, B:969:0x0506, B:970:0x050d, B:971:0x0518, B:973:0x051c, B:975:0x0520, B:976:0x0526, B:977:0x0531, B:979:0x0535, B:981:0x0539, B:982:0x053f, B:983:0x0549, B:985:0x054d, B:987:0x0551, B:988:0x0555, B:993:0x0578, B:991:0x055e, B:992:0x0577, B:998:0x0591, B:1000:0x05ac, B:1002:0x05b2, B:1005:0x05bd, B:1074:0x06f5, B:1075:0x06fd), top: B:1102:0x0483, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:1082:0x070b  */
    /* JADX WARN: Removed duplicated region for block: B:1104:0x0437 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1105:0x0448 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:606:0x0058 A[Catch: all -> 0x0703, TRY_LEAVE, TryCatch #4 {all -> 0x0703, blocks: (B:589:0x002e, B:591:0x0033, B:598:0x0043, B:600:0x0049, B:606:0x0058, B:612:0x0067, B:617:0x0073, B:619:0x007d, B:622:0x0084, B:625:0x009a, B:626:0x00a2, B:627:0x00ab, B:628:0x00ac, B:630:0x00b1, B:632:0x00b7), top: B:1094:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:651:0x010d A[Catch: all -> 0x00e3, TryCatch #3 {all -> 0x00e3, blocks: (B:636:0x00ce, B:638:0x00d4, B:646:0x00ef, B:651:0x010d, B:656:0x011e, B:663:0x012c, B:797:0x02bc, B:799:0x02c4, B:812:0x02f5, B:816:0x0300, B:818:0x0306, B:819:0x0309, B:824:0x031e, B:826:0x0322, B:827:0x0325, B:829:0x0329, B:830:0x032c, B:666:0x0136, B:668:0x013a, B:671:0x0142, B:674:0x014c, B:676:0x0150, B:677:0x0154, B:682:0x015e, B:687:0x0168, B:692:0x0172, B:694:0x0176, B:696:0x0180, B:698:0x0188, B:699:0x018e, B:701:0x0192, B:705:0x019d, B:708:0x01a7, B:710:0x01ab, B:713:0x01b3, B:716:0x01bd, B:718:0x01c1, B:721:0x01c9, B:724:0x01d3, B:726:0x01d7, B:729:0x01df, B:732:0x01e9, B:734:0x01ed, B:737:0x01f5, B:740:0x01fe, B:742:0x0202, B:743:0x0206, B:747:0x0215, B:750:0x0221, B:752:0x0225, B:753:0x0229, B:756:0x0234, B:758:0x0238, B:761:0x0246, B:764:0x0255, B:766:0x0259, B:768:0x025f, B:771:0x026a, B:773:0x026e, B:776:0x027c, B:779:0x0287, B:781:0x028b, B:647:0x0100), top: B:1093:0x00ce }] */
    /* JADX WARN: Removed duplicated region for block: B:786:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:793:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:858:0x03a5 A[Catch: all -> 0x0476, TRY_LEAVE, TryCatch #6 {all -> 0x0476, blocks: (B:851:0x0391, B:856:0x039d, B:858:0x03a5, B:861:0x03b2, B:863:0x03bf, B:865:0x03c5, B:868:0x03dd, B:870:0x03e7, B:873:0x03f9, B:876:0x0400, B:877:0x0408, B:878:0x0409, B:883:0x041a, B:885:0x0423, B:886:0x042b, B:891:0x0437, B:892:0x043f, B:900:0x0455, B:902:0x045b, B:905:0x046c), top: B:1097:0x0391 }] */
    /* JADX WARN: Removed duplicated region for block: B:899:0x0453 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:912:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:998:0x0591 A[Catch: all -> 0x06fe, TryCatch #10 {all -> 0x06fe, blocks: (B:913:0x0483, B:1007:0x05c3, B:1010:0x05ca, B:1012:0x05d0, B:1067:0x06b9, B:1069:0x06bf, B:1072:0x06d7, B:1073:0x06f4, B:915:0x048b, B:920:0x0494, B:925:0x049d, B:930:0x04a6, B:940:0x04c5, B:994:0x057d, B:936:0x04b2, B:937:0x04b7, B:938:0x04bc, B:939:0x04c1, B:944:0x04d2, B:949:0x04dc, B:954:0x04e5, B:959:0x04ee, B:964:0x04f7, B:965:0x04fe, B:967:0x0502, B:969:0x0506, B:970:0x050d, B:971:0x0518, B:973:0x051c, B:975:0x0520, B:976:0x0526, B:977:0x0531, B:979:0x0535, B:981:0x0539, B:982:0x053f, B:983:0x0549, B:985:0x054d, B:987:0x0551, B:988:0x0555, B:993:0x0578, B:991:0x055e, B:992:0x0577, B:998:0x0591, B:1000:0x05ac, B:1002:0x05b2, B:1005:0x05bd, B:1074:0x06f5, B:1075:0x06fd), top: B:1102:0x0483, inners: #8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r36, java.lang.reflect.Type r37, java.lang.Object r38, java.lang.Object r39) {
        /*
            Method dump skipped, instructions count: 1814
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JavaBeanDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    protected FieldDeserializer getFieldDeserializerByHash(long j) {
        int i = 0;
        while (true) {
            FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
            if (i >= fieldDeserializerArr.length) {
                return null;
            }
            FieldDeserializer fieldDeserializer = fieldDeserializerArr[i];
            if (fieldDeserializer.fieldInfo.nameHashCode == j) {
                return fieldDeserializer;
            }
            i++;
        }
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        if (!this.beanInfo.ordered) {
            int length = this.sortedFieldDeserializers.length - 1;
            while (i <= length) {
                int i2 = (i + length) >>> 1;
                int compareTo = this.sortedFieldDeserializers[i2].fieldInfo.name.compareTo(str);
                if (compareTo < 0) {
                    i = i2 + 1;
                } else if (compareTo <= 0) {
                    return this.sortedFieldDeserializers[i2];
                } else {
                    length = i2 - 1;
                }
            }
            Map<String, FieldDeserializer> map = this.alterNameFieldDeserializers;
            if (map != null) {
                return map.get(str);
            }
            return null;
        }
        while (true) {
            FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
            if (i >= fieldDeserializerArr.length) {
                return null;
            }
            FieldDeserializer fieldDeserializer = fieldDeserializerArr[i];
            if (fieldDeserializer.fieldInfo.name.equalsIgnoreCase(str)) {
                return fieldDeserializer;
            }
            i++;
        }
    }

    private boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        boolean z;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str);
        if (fieldDeserializer == null) {
            long fnv_64_lower = TypeUtils.fnv_64_lower(str);
            if (this.smartMatchHashArray == null) {
                long[] jArr = new long[this.sortedFieldDeserializers.length];
                int i = 0;
                while (true) {
                    FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                    if (i >= fieldDeserializerArr.length) {
                        break;
                    }
                    jArr[i] = TypeUtils.fnv_64_lower(fieldDeserializerArr[i].fieldInfo.name);
                    i++;
                }
                Arrays.sort(jArr);
                this.smartMatchHashArray = jArr;
            }
            int binarySearch = Arrays.binarySearch(this.smartMatchHashArray, fnv_64_lower);
            if (binarySearch < 0) {
                z = str.startsWith("is");
                if (z) {
                    binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv_64_lower(str.substring(2)));
                }
            } else {
                z = false;
            }
            if (binarySearch >= 0) {
                if (this.smartMatchHashArrayMapping == null) {
                    int[] iArr = new int[this.smartMatchHashArray.length];
                    Arrays.fill(iArr, -1);
                    int i2 = 0;
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                        if (i2 >= fieldDeserializerArr2.length) {
                            break;
                        }
                        int binarySearch2 = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv_64_lower(fieldDeserializerArr2[i2].fieldInfo.name));
                        if (binarySearch2 >= 0) {
                            iArr[binarySearch2] = i2;
                        }
                        i2++;
                    }
                    this.smartMatchHashArrayMapping = iArr;
                }
                int i3 = this.smartMatchHashArrayMapping[binarySearch];
                if (i3 != -1) {
                    fieldDeserializer = this.sortedFieldDeserializers[i3];
                    Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
                    if (z && cls != Boolean.TYPE && cls != Boolean.class) {
                        fieldDeserializer = null;
                    }
                }
            }
        }
        int i4 = Feature.SupportNonPublicField.mask;
        if (fieldDeserializer == null && ((defaultJSONParser.lexer.features & i4) != 0 || (i4 & this.beanInfo.parserFeatures) != 0)) {
            if (this.extraFieldDeserializers == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(1, 0.75f, 1);
                for (Class<?> cls2 = this.clazz; cls2 != null && cls2 != Object.class; cls2 = cls2.getSuperclass()) {
                    for (Field field : cls2.getDeclaredFields()) {
                        String name = field.getName();
                        if (getFieldDeserializer(name) == null) {
                            int modifiers = field.getModifiers();
                            if ((modifiers & 16) == 0 && (modifiers & 8) == 0) {
                                concurrentHashMap.put(name, field);
                            }
                        }
                    }
                }
                this.extraFieldDeserializers = concurrentHashMap;
            }
            Object obj2 = this.extraFieldDeserializers.get(str);
            if (obj2 != null) {
                if (obj2 instanceof FieldDeserializer) {
                    fieldDeserializer = (FieldDeserializer) obj2;
                } else {
                    Field field2 = (Field) obj2;
                    field2.setAccessible(true);
                    fieldDeserializer = new DefaultFieldDeserializer(defaultJSONParser.config, this.clazz, new FieldInfo(str, field2.getDeclaringClass(), field2.getType(), field2.getGenericType(), field2, 0, 0));
                    this.extraFieldDeserializers.put(str, fieldDeserializer);
                }
            }
        }
        if (fieldDeserializer == null) {
            parseExtra(defaultJSONParser, obj, str);
            return false;
        }
        jSONLexer.nextTokenWithChar(':');
        fieldDeserializer.parseField(defaultJSONParser, obj, type, map);
        return true;
    }

    void parseExtra(DefaultJSONParser defaultJSONParser, Object obj, String str) {
        Object parseObject;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if ((defaultJSONParser.lexer.features & Feature.IgnoreNotMatch.mask) == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("setter not found, class ");
            sb.append(this.clazz.getName());
            sb.append(", property ");
            sb.append(str);
            throw new JSONException(sb.toString());
        }
        jSONLexer.nextTokenWithChar(':');
        List<ExtraTypeProvider> list = defaultJSONParser.extraTypeProviders;
        Type type = null;
        if (list != null) {
            Iterator<ExtraTypeProvider> it = list.iterator();
            while (it.hasNext()) {
                type = it.next().getExtraType(obj, str);
            }
        }
        if (type == null) {
            parseObject = defaultJSONParser.parse();
        } else {
            parseObject = defaultJSONParser.parseObject(type);
        }
        if (obj instanceof ExtraProcessable) {
            ((ExtraProcessable) obj).processExtra(str, parseObject);
            return;
        }
        List<ExtraProcessor> list2 = defaultJSONParser.extraProcessors;
        if (list2 != null) {
            Iterator<ExtraProcessor> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().processExtra(obj, str, parseObject);
            }
        }
    }

    public Object createInstance(Map<String, Object> map, ParserConfig parserConfig) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object cast;
        if (this.beanInfo.creatorConstructor == null) {
            Object createInstance = createInstance((DefaultJSONParser) null, this.clazz);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                FieldDeserializer fieldDeserializer = getFieldDeserializer(entry.getKey());
                if (fieldDeserializer != null) {
                    Object value = entry.getValue();
                    Method method = fieldDeserializer.fieldInfo.method;
                    if (method != null) {
                        method.invoke(createInstance, TypeUtils.cast(value, method.getGenericParameterTypes()[0], parserConfig));
                    } else {
                        Field field = fieldDeserializer.fieldInfo.field;
                        Type type = fieldDeserializer.fieldInfo.fieldType;
                        String str = fieldDeserializer.fieldInfo.format;
                        if (str != null && type == Date.class && (value instanceof String)) {
                            try {
                                cast = new SimpleDateFormat(str).parse((String) value);
                            } catch (ParseException unused) {
                                cast = null;
                            }
                        } else {
                            cast = TypeUtils.cast(value, type, parserConfig);
                        }
                        field.set(createInstance, cast);
                    }
                }
            }
            return createInstance;
        }
        FieldInfo[] fieldInfoArr = this.beanInfo.fields;
        int length = fieldInfoArr.length;
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            FieldInfo fieldInfo = fieldInfoArr[i];
            Object obj = map.get(fieldInfo.name);
            if (obj == null) {
                obj = TypeUtils.defaultValue(fieldInfo.fieldClass);
            }
            objArr[i] = obj;
        }
        if (this.beanInfo.creatorConstructor != null) {
            try {
                return this.beanInfo.creatorConstructor.newInstance(objArr);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("create instance error, ");
                sb.append(this.beanInfo.creatorConstructor.toGenericString());
                throw new JSONException(sb.toString(), e);
            }
        }
        return null;
    }

    protected JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        if (javaBeanInfo.jsonType == null) {
            return null;
        }
        for (Class<?> cls : javaBeanInfo.jsonType.seeAlso()) {
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            if (deserializer instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (javaBeanInfo2.typeName.equals(str)) {
                    return javaBeanDeserializer;
                }
                JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }
}
