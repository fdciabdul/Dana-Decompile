package com.alibaba.fastjson.parser;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.ArrayCodec;
import com.alibaba.fastjson.serializer.CollectionCodec;
import com.alibaba.fastjson.serializer.MiscCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.TypeUtils;
import com.google.common.base.Ascii;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class ParserConfig {
    public boolean autoTypeSupport;
    public ClassLoader defaultClassLoader;
    private final IdentityHashMap<ObjectDeserializer> deserializers;
    public PropertyNamingStrategy propertyNamingStrategy;
    public final SymbolTable symbolTable;
    public static final byte[] PlaceComponentResult = {95, 85, -94, TarHeader.LF_SYMLINK, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -34, 37, -9, 6, -10, 7, 4};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 8;
    private static long[] denyList = {-7600952144447537354L, -4082057040235125754L, -2364987994247679115L, -676156662527871184L, -254670111376247151L, 1502845958873959152L, 4147696707147271408L, 5347909877633654828L, 5751393439502795295L, 7702607466162283393L};
    public static ParserConfig global = new ParserConfig();

    public static ParserConfig getGlobalInstance() {
        return global;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01a4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x01a4 -> B:23:0x01ac). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ParserConfig() {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.ParserConfig.<init>():void");
    }

    public ObjectDeserializer getDeserializer(Type type) {
        ObjectDeserializer objectDeserializer = this.deserializers.get(type);
        if (objectDeserializer != null) {
            return objectDeserializer;
        }
        if (type instanceof Class) {
            return getDeserializer((Class) type, type);
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return getDeserializer((Class) rawType, type);
            }
            return getDeserializer(rawType);
        }
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            if (upperBounds.length == 1) {
                return getDeserializer(upperBounds[0]);
            }
        }
        return JavaObjectDeserializer.instance;
    }

    public ObjectDeserializer getDeserializer(Class<?> cls, Type type) {
        ObjectDeserializer objectDeserializer;
        JSONType jSONType;
        Class<?> mappingTo;
        ObjectDeserializer objectDeserializer2 = this.deserializers.get(type);
        if (objectDeserializer2 != null) {
            return objectDeserializer2;
        }
        if (type == null) {
            type = cls;
        }
        ObjectDeserializer objectDeserializer3 = this.deserializers.get(type);
        if (objectDeserializer3 != null) {
            return objectDeserializer3;
        }
        if (!isPrimitive(cls) && (jSONType = (JSONType) cls.getAnnotation(JSONType.class)) != null && (mappingTo = jSONType.mappingTo()) != Void.class) {
            return getDeserializer(mappingTo, mappingTo);
        }
        if ((type instanceof WildcardType) || (type instanceof TypeVariable) || (type instanceof ParameterizedType)) {
            objectDeserializer3 = this.deserializers.get(cls);
        }
        if (objectDeserializer3 != null) {
            return objectDeserializer3;
        }
        ObjectDeserializer objectDeserializer4 = this.deserializers.get(type);
        if (objectDeserializer4 != null) {
            return objectDeserializer4;
        }
        if (cls.isEnum()) {
            objectDeserializer = new EnumDeserializer(cls);
        } else if (cls.isArray()) {
            objectDeserializer = ArrayCodec.instance;
        } else if (cls == Set.class || cls == HashSet.class || cls == Collection.class || cls == List.class || cls == ArrayList.class || Collection.class.isAssignableFrom(cls)) {
            objectDeserializer = CollectionCodec.instance;
        } else if (Map.class.isAssignableFrom(cls)) {
            objectDeserializer = MapDeserializer.instance;
        } else if (Throwable.class.isAssignableFrom(cls)) {
            objectDeserializer = new ThrowableDeserializer(this, cls);
        } else if (cls.getName().equals("android.net.Uri")) {
            objectDeserializer = MiscCodec.instance;
        } else {
            objectDeserializer = new JavaBeanDeserializer(this, cls, type);
        }
        putDeserializer(type, objectDeserializer);
        return objectDeserializer;
    }

    public ObjectDeserializer registerIfNotExists(Class<?> cls) {
        return registerIfNotExists(cls, cls.getModifiers(), false, true, true, true);
    }

    public ObjectDeserializer registerIfNotExists(Class<?> cls, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        ObjectDeserializer objectDeserializer = this.deserializers.get(cls);
        if (objectDeserializer != null) {
            return objectDeserializer;
        }
        JavaBeanDeserializer javaBeanDeserializer = new JavaBeanDeserializer(this, cls, cls, JavaBeanInfo.build(cls, i, cls, z, z2, z3, z4, this.propertyNamingStrategy));
        putDeserializer(cls, javaBeanDeserializer);
        return javaBeanDeserializer;
    }

    public boolean containsKey(Class cls) {
        return this.deserializers.get(cls) != null;
    }

    public FieldDeserializer createFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        Class<?> cls2 = fieldInfo.fieldClass;
        if (cls2 == List.class || cls2 == ArrayList.class || (cls2.isArray() && !cls2.getComponentType().isPrimitive())) {
            return new ListTypeFieldDeserializer(parserConfig, cls, fieldInfo);
        }
        return new DefaultFieldDeserializer(parserConfig, cls, fieldInfo);
    }

    public void putDeserializer(Type type, ObjectDeserializer objectDeserializer) {
        this.deserializers.put(type, objectDeserializer);
    }

    public static boolean isPrimitive(Class<?> cls) {
        return cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == Date.class || cls == java.sql.Date.class || cls == Time.class || cls == Timestamp.class;
    }

    public Class<?> checkAutoType(String str, Class<?> cls, int i) {
        if (str == null) {
            return null;
        }
        if (str.length() < 128) {
            if (str.length() >= 3) {
                long charAt = (str.charAt(0) ^ (-3750763034362895579L)) * 1099511628211L;
                if (charAt == -5808493101479473382L) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("autoType is not support. ");
                    sb.append(str);
                    throw new JSONException(sb.toString());
                } else if ((charAt ^ str.charAt(str.length() - 1)) * 1099511628211L == 655701488918567152L) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("autoType is not support. ");
                    sb2.append(str);
                    throw new JSONException(sb2.toString());
                } else {
                    long charAt2 = (((((str.charAt(0) ^ (-3750763034362895579L)) * 1099511628211L) ^ str.charAt(1)) * 1099511628211L) ^ str.charAt(2)) * 1099511628211L;
                    for (int i2 = 3; i2 < str.length(); i2++) {
                        charAt2 = (charAt2 ^ str.charAt(i2)) * 1099511628211L;
                        if (Arrays.binarySearch(denyList, charAt2) >= 0 && TypeUtils.getClassFromMapping(str) == null) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("autoType is not support. ");
                            sb3.append(str);
                            throw new JSONException(sb3.toString());
                        }
                    }
                    Class<?> classFromMapping = TypeUtils.getClassFromMapping(str);
                    if (classFromMapping != null) {
                        return classFromMapping;
                    }
                    Class<?> findClass = this.deserializers.findClass(str);
                    if (findClass != null) {
                        return findClass;
                    }
                    Class<?> loadClass = TypeUtils.loadClass(str, this.defaultClassLoader, false);
                    if (loadClass != null && cls != null && loadClass != HashMap.class) {
                        if (cls.isAssignableFrom(loadClass)) {
                            TypeUtils.addMapping(str, loadClass);
                            return loadClass;
                        }
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("type not match. ");
                        sb4.append(str);
                        sb4.append(" -> ");
                        sb4.append(cls.getName());
                        throw new JSONException(sb4.toString());
                    } else if (loadClass.isAnnotationPresent(JSONType.class)) {
                        TypeUtils.addMapping(str, loadClass);
                        return loadClass;
                    } else {
                        int i3 = Feature.SupportAutoType.mask;
                        if ((i & i3) == 0 && (i3 & JSON.DEFAULT_PARSER_FEATURE) == 0 && !this.autoTypeSupport) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("autoType is not support : ");
                            sb5.append(str);
                            throw new JSONException(sb5.toString());
                        }
                        TypeUtils.addMapping(str, loadClass);
                        return loadClass;
                    }
                }
            }
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("autoType is not support. ");
        sb6.append(str);
        throw new JSONException(sb6.toString());
    }
}
