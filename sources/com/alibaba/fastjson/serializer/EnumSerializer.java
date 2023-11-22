package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class EnumSerializer implements ObjectSerializer {
    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
            String obj3 = ((Enum) obj).toString();
            if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                serializeWriter.writeStringWithSingleQuote(obj3);
                return;
            } else {
                serializeWriter.writeStringWithDoubleQuote(obj3, (char) 0, false);
                return;
            }
        }
        serializeWriter.writeInt(((Enum) obj).ordinal());
    }
}
