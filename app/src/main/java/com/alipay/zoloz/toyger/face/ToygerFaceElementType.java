package com.alipay.zoloz.toyger.face;

import com.alipay.zoloz.toyger.blob.BlobStatic;

/* loaded from: classes7.dex */
public class ToygerFaceElementType {
    public static String getBlobElemType(ToygerFaceInfo toygerFaceInfo) {
        int i = toygerFaceInfo.frame.frameType;
        return i != 0 ? i != 1 ? i != 2 ? "" : BlobStatic.SUB_TYPE_NANO : BlobStatic.SUB_TYPE_DARK : BlobStatic.SUB_TYPE_PANO;
    }
}
