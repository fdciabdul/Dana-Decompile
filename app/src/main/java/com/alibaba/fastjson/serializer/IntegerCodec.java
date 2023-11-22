package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* loaded from: classes3.dex */
public final class IntegerCodec implements ObjectSerializer, ObjectDeserializer {
    public static IntegerCodec instance = new IntegerCodec();

    private IntegerCodec() {
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        Number number = (Number) obj;
        if (number == null) {
            if ((serializeWriter.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
                serializeWriter.write(48);
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        if (obj instanceof Long) {
            serializeWriter.writeLong(number.longValue());
        } else {
            serializeWriter.writeInt(number.intValue());
        }
        if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
            Class<?> cls = number.getClass();
            if (cls == Byte.class) {
                serializeWriter.write(66);
            } else if (cls == Short.class) {
                serializeWriter.write(83);
            } else if (cls == Long.class) {
                long longValue = number.longValue();
                if (longValue > 2147483647L || longValue < -2147483648L || type == Long.class) {
                    return;
                }
                serializeWriter.write(76);
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public final <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        T t;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 8) {
            jSONLexer.nextToken(16);
            return null;
        } else if (i == 2) {
            if (type == Long.TYPE || type == Long.class) {
                t = (T) Long.valueOf(jSONLexer.longValue());
            } else {
                try {
                    t = (T) Integer.valueOf(jSONLexer.intValue());
                } catch (NumberFormatException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("int value overflow, field : ");
                    sb.append(obj);
                    throw new JSONException(sb.toString(), e);
                }
            }
            jSONLexer.nextToken(16);
            return t;
        } else if (i == 3) {
            BigDecimal decimalValue = jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            if (type == Long.TYPE || type == Long.class) {
                return (T) Long.valueOf(decimalValue.longValue());
            }
            return (T) Integer.valueOf(decimalValue.intValue());
        } else {
            T t2 = (T) defaultJSONParser.parse();
            try {
                if (type != Long.TYPE && type != Long.class) {
                    t2 = (T) TypeUtils.castToInt(t2);
                    return t2;
                }
                t2 = (T) TypeUtils.castToLong(t2);
                return t2;
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("cast error, field : ");
                sb2.append(obj);
                sb2.append(", value ");
                sb2.append(t2);
                throw new JSONException(sb2.toString(), e2);
            }
        }
    }
}
