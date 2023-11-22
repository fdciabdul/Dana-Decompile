package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.util.IdentityHashMap;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class SerializeConfig {
    public static final SerializeConfig globalInstance = new SerializeConfig();
    public PropertyNamingStrategy propertyNamingStrategy;
    private final IdentityHashMap<ObjectSerializer> serializers;
    protected String typeKey = JSON.DEFAULT_TYPE_KEY;

    public static final SerializeConfig getGlobalInstance() {
        return globalInstance;
    }

    public ObjectSerializer registerIfNotExists(Class<?> cls) {
        return registerIfNotExists(cls, cls.getModifiers(), false, true, true, true);
    }

    public ObjectSerializer registerIfNotExists(Class<?> cls, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        ObjectSerializer objectSerializer = this.serializers.get(cls);
        if (objectSerializer == null) {
            JavaBeanSerializer javaBeanSerializer = new JavaBeanSerializer(cls, i, null, z, z2, z3, z4, this.propertyNamingStrategy);
            this.serializers.put(cls, javaBeanSerializer);
            return javaBeanSerializer;
        }
        return objectSerializer;
    }

    public SerializeConfig() {
        IdentityHashMap<ObjectSerializer> identityHashMap = new IdentityHashMap<>(1024);
        this.serializers = identityHashMap;
        identityHashMap.put(Boolean.class, BooleanCodec.instance);
        identityHashMap.put(Character.class, MiscCodec.instance);
        identityHashMap.put(Byte.class, IntegerCodec.instance);
        identityHashMap.put(Short.class, IntegerCodec.instance);
        identityHashMap.put(Integer.class, IntegerCodec.instance);
        identityHashMap.put(Long.class, IntegerCodec.instance);
        identityHashMap.put(Float.class, NumberCodec.instance);
        identityHashMap.put(Double.class, NumberCodec.instance);
        identityHashMap.put(Number.class, NumberCodec.instance);
        identityHashMap.put(BigDecimal.class, BigDecimalCodec.instance);
        identityHashMap.put(BigInteger.class, BigDecimalCodec.instance);
        identityHashMap.put(String.class, StringCodec.instance);
        identityHashMap.put(Object[].class, ArrayCodec.instance);
        identityHashMap.put(Class.class, MiscCodec.instance);
        identityHashMap.put(SimpleDateFormat.class, MiscCodec.instance);
        identityHashMap.put(Locale.class, MiscCodec.instance);
        identityHashMap.put(Currency.class, MiscCodec.instance);
        identityHashMap.put(TimeZone.class, MiscCodec.instance);
        identityHashMap.put(UUID.class, MiscCodec.instance);
        identityHashMap.put(URI.class, MiscCodec.instance);
        identityHashMap.put(URL.class, MiscCodec.instance);
        identityHashMap.put(Pattern.class, MiscCodec.instance);
        identityHashMap.put(Charset.class, MiscCodec.instance);
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alibaba.fastjson.serializer.ObjectSerializer get(java.lang.Class<?> r9) {
        /*
            Method dump skipped, instructions count: 419
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeConfig.get(java.lang.Class):com.alibaba.fastjson.serializer.ObjectSerializer");
    }

    public boolean put(Type type, ObjectSerializer objectSerializer) {
        return this.serializers.put(type, objectSerializer);
    }

    public String getTypeKey() {
        return this.typeKey;
    }

    public void setTypeKey(String str) {
        this.typeKey = str;
    }
}
