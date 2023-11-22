package com.alipay.zoloz.toyger.convert;

import com.alipay.zoloz.toyger.blob.model.Content;
import com.zoloz.wire.Message;

/* loaded from: classes7.dex */
public class PBContentConvert implements IContentConvert {
    @Override // com.alipay.zoloz.toyger.convert.IContentConvert
    public byte[] convert(Content content) {
        return ((Message) ObjectConvertTools.convert(content)).toByteArray();
    }
}
