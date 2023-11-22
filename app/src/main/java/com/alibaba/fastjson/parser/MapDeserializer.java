package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class MapDeserializer implements ObjectDeserializer {
    public static MapDeserializer instance = new MapDeserializer();

    MapDeserializer() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (type == JSONObject.class && defaultJSONParser.fieldTypeResolver == null) {
            return (T) defaultJSONParser.parseObject();
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        Map<?, ?> createMap = createMap(type);
        ParseContext parseContext = defaultJSONParser.contex;
        try {
            defaultJSONParser.setContext(parseContext, createMap, obj);
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type type2 = parameterizedType.getActualTypeArguments()[0];
                Type type3 = parameterizedType.getActualTypeArguments()[1];
                if (String.class == type2) {
                    return (T) parseMap(defaultJSONParser, createMap, type3, obj);
                }
                return (T) parseMap(defaultJSONParser, createMap, type2, type3, obj);
            }
            return (T) defaultJSONParser.parseObject(createMap, obj);
        } finally {
            defaultJSONParser.setContext(parseContext);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0129, code lost:
    
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map parseMap(com.alibaba.fastjson.parser.DefaultJSONParser r9, java.util.Map<java.lang.String, java.lang.Object> r10, java.lang.reflect.Type r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.MapDeserializer.parseMap(com.alibaba.fastjson.parser.DefaultJSONParser, java.util.Map, java.lang.reflect.Type, java.lang.Object):java.util.Map");
    }

    public static Object parseMap(DefaultJSONParser defaultJSONParser, Map<Object, Object> map, Type type, Type type2, Object obj) {
        Object obj2;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token;
        int i2 = 16;
        if (i != 12 && i != 16) {
            StringBuilder sb = new StringBuilder();
            sb.append("syntax error, expect {, actual ");
            sb.append(JSONToken.name(i));
            throw new JSONException(sb.toString());
        }
        ObjectDeserializer deserializer = defaultJSONParser.config.getDeserializer(type);
        ObjectDeserializer deserializer2 = defaultJSONParser.config.getDeserializer(type2);
        jSONLexer.nextToken();
        ParseContext parseContext = defaultJSONParser.contex;
        while (true) {
            try {
                int i3 = jSONLexer.token;
                if (i3 == 13) {
                    jSONLexer.nextToken(i2);
                    return map;
                } else if (i3 == 4 && jSONLexer.sp == 4 && jSONLexer.text.startsWith("$ref", jSONLexer.np + 1) && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                    jSONLexer.nextTokenWithChar(':');
                    if (jSONLexer.token != 4) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("illegal ref, ");
                        sb2.append(JSONToken.name(i3));
                        throw new JSONException(sb2.toString());
                    }
                    String stringVal = jSONLexer.stringVal();
                    if ("..".equals(stringVal)) {
                        obj2 = parseContext.parent.object;
                    } else if ("$".equals(stringVal)) {
                        ParseContext parseContext2 = parseContext;
                        while (parseContext2.parent != null) {
                            parseContext2 = parseContext2.parent;
                        }
                        obj2 = parseContext2.object;
                    } else {
                        defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parseContext, stringVal));
                        defaultJSONParser.resolveStatus = 1;
                        obj2 = null;
                    }
                    jSONLexer.nextToken(13);
                    if (jSONLexer.token == 13) {
                        jSONLexer.nextToken(16);
                        return obj2;
                    }
                    throw new JSONException("illegal ref");
                } else {
                    if (map.size() == 0 && i3 == 4 && JSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal()) && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                        jSONLexer.nextTokenWithChar(':');
                        jSONLexer.nextToken(16);
                        if (jSONLexer.token == 13) {
                            jSONLexer.nextToken();
                            return map;
                        }
                        jSONLexer.nextToken();
                    }
                    Object deserialze = deserializer.deserialze(defaultJSONParser, type, null);
                    if (jSONLexer.token != 17) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("syntax error, expect :, actual ");
                        sb3.append(jSONLexer.token);
                        throw new JSONException(sb3.toString());
                    }
                    jSONLexer.nextToken();
                    Object deserialze2 = deserializer2.deserialze(defaultJSONParser, type2, deserialze);
                    if (defaultJSONParser.resolveStatus == 1) {
                        defaultJSONParser.checkMapResolve(map, deserialze);
                    }
                    map.put(deserialze, deserialze2);
                    if (jSONLexer.token == 16) {
                        jSONLexer.nextToken();
                    }
                    i2 = 16;
                }
            } finally {
                defaultJSONParser.setContext(parseContext);
            }
        }
    }

    protected Map<?, ?> createMap(Type type) {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type == SortedMap.class || type == TreeMap.class) {
            return new TreeMap();
        }
        if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
            return new ConcurrentHashMap();
        }
        if (type == Map.class || type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type == JSONObject.class) {
            return new JSONObject();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            if (EnumMap.class.equals(rawType)) {
                return new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]);
            }
            return createMap(rawType);
        }
        Class cls = (Class) type;
        if (cls.isInterface()) {
            StringBuilder sb = new StringBuilder();
            sb.append("unsupport type ");
            sb.append(type);
            throw new JSONException(sb.toString());
        }
        try {
            return (Map) cls.newInstance();
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("unsupport type ");
            sb2.append(type);
            throw new JSONException(sb2.toString(), e);
        }
    }
}
