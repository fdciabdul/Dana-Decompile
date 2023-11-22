package com.alipay.zoloz.toyger.convert;

import com.alibaba.fastjson.JSON;
import com.alipay.zoloz.toyger.blob.model.Content;

/* loaded from: classes7.dex */
public class JsonContentConverter implements IContentConvert {
    @Override // com.alipay.zoloz.toyger.convert.IContentConvert
    public byte[] convert(Content content) {
        return JSON.toJSONString(content).getBytes();
    }
}
