package com.alipay.zoloz.toyger.h5;

import android.graphics.Rect;
import com.alibaba.fastjson.JSON;
import com.alipay.zoloz.toyger.blob.BlobManager;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.alipay.zoloz.toyger.blob.CryptoManager;
import com.alipay.zoloz.toyger.blob.model.Blob;
import com.alipay.zoloz.toyger.blob.model.Content;
import com.alipay.zoloz.toyger.blob.model.FaceBlobElement;
import com.alipay.zoloz.toyger.blob.model.Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class H5BlobManager extends BlobManager<ToygerH5Info> {
    protected Rect mCropRect;

    @Override // com.alipay.zoloz.toyger.blob.BlobManager, com.alipay.zoloz.toyger.blob.IGenericBlobManager
    public boolean isUTF8() {
        return true;
    }

    public H5BlobManager(int i) {
        super(i);
    }

    public void setCropRect(Rect rect) {
        this.mCropRect = rect;
    }

    public void setBlobConfig(ToygerH5BlobConfig toygerH5BlobConfig) {
        this.config = toygerH5BlobConfig;
        this.crypto = new CryptoManager(this.config.pubkey);
    }

    @Override // com.alipay.zoloz.toyger.blob.BlobManager, com.alipay.zoloz.toyger.blob.IGenericBlobManager
    public byte[] getKey() {
        return this.crypto.getAESCypher();
    }

    @Override // com.alipay.zoloz.toyger.blob.BlobManager
    public byte[] generateBlob(List<ToygerH5Info> list, Map<String, Object> map) {
        ArrayList arrayList = new ArrayList();
        for (ToygerH5Info toygerH5Info : list) {
            FaceBlobElement faceBlobElement = new FaceBlobElement();
            faceBlobElement.type = "face";
            faceBlobElement.subType = BlobStatic.SUB_TYPE_PANO;
            faceBlobElement.version = "1.0";
            faceBlobElement.idx = 0;
            if (this.mCropRect != null) {
                faceBlobElement.content = processFrame(toygerH5Info.frame, this.mCropRect);
            } else {
                faceBlobElement.content = processFrame(toygerH5Info.frame);
            }
            faceBlobElement.content = this.crypto.encrypt(faceBlobElement.content);
            faceBlobElement.faceInfos = new ArrayList();
            arrayList.add(faceBlobElement);
        }
        Blob blob = new Blob();
        blob.blobElem = arrayList;
        blob.blobVersion = "2.0";
        Content content = new Content();
        content.blob = blob;
        content.meta = generateMeta(list, map);
        return JSON.toJSONString(content).getBytes();
    }

    @Override // com.alipay.zoloz.toyger.blob.BlobManager
    public Meta generateMeta(List<ToygerH5Info> list, Map<String, Object> map) {
        Meta meta = new Meta();
        meta.type = BlobStatic.META_TYPE_FACE;
        meta.serialize = 1;
        meta.score = map;
        return meta;
    }
}
