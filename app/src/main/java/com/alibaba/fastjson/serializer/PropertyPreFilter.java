package com.alibaba.fastjson.serializer;

/* loaded from: classes3.dex */
public interface PropertyPreFilter extends SerializeFilter {
    boolean apply(JSONSerializer jSONSerializer, Object obj, String str);
}
