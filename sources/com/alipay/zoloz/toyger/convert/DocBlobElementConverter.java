package com.alipay.zoloz.toyger.convert;

import com.alipay.zoloz.toyger.blob.model.DocBlobElement;
import com.zoloz.zcore.facade.common.Blob.BlobElemPB;

/* loaded from: classes7.dex */
public class DocBlobElementConverter extends BlobElemConverter {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alipay.zoloz.toyger.convert.BlobElemConverter, com.alipay.zoloz.toyger.convert.IOriginalConverter
    public BlobElemPB converter(Object obj) {
        BlobElemPB converter = super.converter(obj);
        if (converter == null) {
            return null;
        }
        if (obj instanceof DocBlobElement) {
            converter.fillTagValue(7, ObjectConvertTools.convert(((DocBlobElement) obj).docInfo));
        }
        return converter;
    }
}
