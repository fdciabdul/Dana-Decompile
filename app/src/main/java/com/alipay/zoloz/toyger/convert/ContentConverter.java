package com.alipay.zoloz.toyger.convert;

import com.alipay.zoloz.toyger.blob.model.Content;
import com.zoloz.zhub.endpoint.gwfacade.zhubalipay.empty.UnifiedContentPbPB;

/* loaded from: classes7.dex */
public class ContentConverter implements IOriginalConverter<UnifiedContentPbPB> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alipay.zoloz.toyger.convert.IOriginalConverter
    public UnifiedContentPbPB converter(Object obj) {
        if (obj instanceof Content) {
            Content content = (Content) obj;
            UnifiedContentPbPB unifiedContentPbPB = new UnifiedContentPbPB();
            unifiedContentPbPB.fillTagValue(2, ObjectConvertTools.convert(content.blob));
            unifiedContentPbPB.fillTagValue(1, ObjectConvertTools.convert(content.meta));
            return unifiedContentPbPB;
        }
        return null;
    }
}
