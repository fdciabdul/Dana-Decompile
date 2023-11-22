package com.alipay.zoloz.toyger.convert;

import com.alipay.zoloz.toyger.blob.model.FaceBlobElement;
import com.alipay.zoloz.toyger.blob.model.FaceInfo;
import com.zoloz.zcore.facade.common.Blob.BlobElemPB;
import com.zoloz.zcore.facade.common.Blob.FaceInfoPB;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class FaceBlobElementConverter extends BlobElemConverter {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alipay.zoloz.toyger.convert.BlobElemConverter, com.alipay.zoloz.toyger.convert.IOriginalConverter
    public BlobElemPB converter(Object obj) {
        BlobElemPB converter = super.converter(obj);
        if (converter == null) {
            return null;
        }
        if (obj instanceof FaceBlobElement) {
            converter.faceInfos = new ArrayList();
            Iterator<FaceInfo> it = ((FaceBlobElement) obj).faceInfos.iterator();
            while (it.hasNext()) {
                Object convert = ObjectConvertTools.convert(it.next());
                if (convert != null && (convert instanceof FaceInfoPB)) {
                    converter.faceInfos.add((FaceInfoPB) convert);
                }
            }
        }
        return converter;
    }
}
