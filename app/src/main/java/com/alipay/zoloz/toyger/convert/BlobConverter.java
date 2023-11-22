package com.alipay.zoloz.toyger.convert;

import com.alipay.zoloz.toyger.blob.model.Blob;
import com.alipay.zoloz.toyger.blob.model.BlobElem;
import com.zoloz.zcore.facade.common.Blob.BlobElemPB;
import com.zoloz.zcore.facade.common.BlobPB;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class BlobConverter implements IOriginalConverter<BlobPB> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alipay.zoloz.toyger.convert.IOriginalConverter
    public BlobPB converter(Object obj) {
        if (obj instanceof Blob) {
            Blob blob = (Blob) obj;
            BlobPB blobPB = new BlobPB();
            blobPB.blobVersion = blob.blobVersion;
            blobPB.blobElem = new ArrayList();
            Iterator<BlobElem> it = blob.blobElem.iterator();
            while (it.hasNext()) {
                Object convert = ObjectConvertTools.convert(it.next());
                if (convert != null) {
                    blobPB.blobElem.add((BlobElemPB) convert);
                }
            }
            return blobPB;
        }
        return null;
    }
}
