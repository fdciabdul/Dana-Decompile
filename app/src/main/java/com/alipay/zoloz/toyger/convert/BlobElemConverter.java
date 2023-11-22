package com.alipay.zoloz.toyger.convert;

import com.alipay.zoloz.toyger.blob.model.BlobElem;
import com.zoloz.zcore.facade.common.Blob.BlobElemPB;
import okio.ByteString;

/* loaded from: classes7.dex */
class BlobElemConverter implements IOriginalConverter<BlobElemPB> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alipay.zoloz.toyger.convert.IOriginalConverter
    public BlobElemPB converter(Object obj) {
        if (obj instanceof BlobElem) {
            BlobElem blobElem = (BlobElem) obj;
            BlobElemPB blobElemPB = new BlobElemPB();
            blobElemPB.type = blobElem.type;
            blobElemPB.subType = blobElem.subType;
            blobElemPB.idx = Integer.valueOf(blobElem.idx);
            blobElemPB.version = blobElem.version;
            if (blobElem.content != null) {
                blobElemPB.content = ByteString.of(blobElem.content);
            }
            return blobElemPB;
        }
        return null;
    }
}
