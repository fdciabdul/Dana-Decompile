package com.alipay.zoloz.toyger.convert;

import android.graphics.Point;
import com.alipay.zoloz.toyger.blob.model.FaceInfo;
import com.zoloz.zcore.facade.common.Blob.FaceInfoPB;
import com.zoloz.zcore.facade.common.Blob.PointPB;
import com.zoloz.zcore.facade.common.Blob.RectPB;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class FaceInfoConverter implements IOriginalConverter<FaceInfoPB> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alipay.zoloz.toyger.convert.IOriginalConverter
    public FaceInfoPB converter(Object obj) {
        if (obj instanceof FaceInfo) {
            FaceInfo faceInfo = (FaceInfo) obj;
            FaceInfoPB faceInfoPB = new FaceInfoPB();
            if (faceInfo.rect != null) {
                RectPB rectPB = new RectPB();
                rectPB.top = Integer.valueOf(faceInfo.rect.top);
                rectPB.right = Integer.valueOf(faceInfo.rect.right);
                rectPB.bottom = Integer.valueOf(faceInfo.rect.bottom);
                rectPB.left = Integer.valueOf(faceInfo.rect.left);
                faceInfoPB.rect = rectPB;
            }
            if (faceInfo.points != null) {
                faceInfoPB.points = new ArrayList();
                for (Point point : faceInfo.points) {
                    PointPB pointPB = new PointPB();
                    pointPB.x = Integer.valueOf(point.x);
                    pointPB.y = Integer.valueOf(point.y);
                    faceInfoPB.points.add(pointPB);
                }
            }
            faceInfoPB.confidence = Float.valueOf(faceInfo.confidence);
            faceInfoPB.quality = Float.valueOf(faceInfo.quality);
            faceInfoPB.feature = faceInfo.feature;
            faceInfoPB.feaVersion = faceInfo.feaVersion;
            return faceInfoPB;
        }
        return null;
    }
}
