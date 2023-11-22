package com.alipay.zoloz.toyger.convert;

import android.graphics.Point;
import com.alipay.zoloz.toyger.blob.model.DocFieldInfo;
import com.alipay.zoloz.toyger.blob.model.DocInfo;
import com.zoloz.zcore.facade.common.Blob.DocFieldInfoPB;
import com.zoloz.zcore.facade.common.Blob.DocInfoPB;
import com.zoloz.zcore.facade.common.Blob.PointPB;
import com.zoloz.zcore.facade.common.Blob.RectPB;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class DocInfoConverter implements IOriginalConverter<DocInfoPB> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alipay.zoloz.toyger.convert.IOriginalConverter
    public DocInfoPB converter(Object obj) {
        if (obj instanceof DocInfo) {
            DocInfoPB docInfoPB = new DocInfoPB();
            DocInfo docInfo = (DocInfo) obj;
            docInfoPB.docType = docInfo.docType;
            docInfoPB.pageNo = Integer.valueOf(docInfo.pageNo);
            if (docInfo.faceRect != null) {
                RectPB rectPB = new RectPB();
                rectPB.top = Integer.valueOf(docInfo.faceRect.top);
                rectPB.right = Integer.valueOf(docInfo.faceRect.right);
                rectPB.bottom = Integer.valueOf(docInfo.faceRect.bottom);
                rectPB.left = Integer.valueOf(docInfo.faceRect.left);
                docInfoPB.faceRect = rectPB;
            }
            if (docInfo.region != null) {
                docInfoPB.region = new ArrayList();
                for (Point point : docInfo.region) {
                    PointPB pointPB = new PointPB();
                    pointPB.x = Integer.valueOf(point.x);
                    pointPB.y = Integer.valueOf(point.y);
                    docInfoPB.region.add(pointPB);
                }
            }
            if (docInfo.fields != null) {
                docInfoPB.fields = new ArrayList();
                for (DocFieldInfo docFieldInfo : docInfo.fields) {
                    DocFieldInfoPB docFieldInfoPB = new DocFieldInfoPB();
                    docFieldInfoPB.name = docFieldInfo.name;
                    docFieldInfoPB.value = docFieldInfo.value;
                    docFieldInfoPB.feature = docFieldInfo.feature;
                    docFieldInfoPB.feaVer = docFieldInfo.feaVersion;
                    docInfoPB.fields.add(docFieldInfoPB);
                }
            }
            return docInfoPB;
        }
        return null;
    }
}
