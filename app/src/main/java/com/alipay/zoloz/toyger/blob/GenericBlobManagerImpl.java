package com.alipay.zoloz.toyger.blob;

import android.graphics.Rect;
import com.alipay.zoloz.toyger.algorithm.TGFrame;
import com.alipay.zoloz.toyger.blob.model.Blob;
import com.alipay.zoloz.toyger.blob.model.BlobElem;
import com.alipay.zoloz.toyger.blob.model.Content;
import com.alipay.zoloz.toyger.blob.model.Meta;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class GenericBlobManagerImpl extends BlobManager implements IGenericBlobManager {
    private List<BlobElem> mCacheBlobElem;
    private String mType;

    @Override // com.alipay.zoloz.toyger.blob.BlobManager, com.alipay.zoloz.toyger.blob.IGenericBlobManager
    public boolean isUTF8() {
        return false;
    }

    public GenericBlobManagerImpl(int i, String str, String str2) {
        super(i);
        this.mType = str;
        this.crypto = new CryptoManager(str2);
        this.mCacheBlobElem = new ArrayList();
    }

    @Override // com.alipay.zoloz.toyger.blob.IGenericBlobManager
    public void addMonitorFrame(TGFrame tGFrame) {
        this.mCacheBlobElem.add(generateMonitorBlobElem(tGFrame));
    }

    @Override // com.alipay.zoloz.toyger.blob.IGenericBlobManager
    public byte[] generateMonitorBlob(String str) {
        if (this.mCacheBlobElem.size() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(BlobStatic.BLOB_META_INVTP_TYPE, BlobStatic.INVTP_TYPE_MONITOR);
        hashMap.put("bis_token", str);
        hashMap.put(BlobStatic.BLOB_META_RETRY, "0");
        Meta generateMeta = generateMeta(null, hashMap);
        Blob blob = new Blob();
        blob.blobElem = this.mCacheBlobElem;
        blob.blobVersion = "2.0";
        Content content = new Content();
        content.blob = blob;
        content.meta = generateMeta;
        try {
            return this.crypto.encrypt(this.mConvertManager.convert(content));
        } catch (Exception unused) {
            return null;
        } finally {
            this.mCacheBlobElem.clear();
        }
    }

    @Override // com.alipay.zoloz.toyger.blob.BlobManager
    public byte[] generateBlob(List list, Map map) {
        throw new RuntimeException("method is not implemented");
    }

    @Override // com.alipay.zoloz.toyger.blob.BlobManager, com.alipay.zoloz.toyger.blob.IGenericBlobManager
    public byte[] getKey() {
        return this.crypto.getAESCypher();
    }

    @Override // com.alipay.zoloz.toyger.blob.IGenericBlobManager
    public void cleanAllData() {
        this.mCacheBlobElem.clear();
    }

    private BlobElem generateMonitorBlobElem(TGFrame tGFrame) {
        byte[] processFrame = processFrame(tGFrame, BlobStatic.MONITOR_IMAGE_WIDTH, 15, new Rect());
        if (processFrame == null) {
            InstrumentInjector.log_e(BlobManager.TAG, "failed to generate element content");
            return null;
        }
        BlobElem blobElem = new BlobElem();
        if ("face".equals(this.mType)) {
            blobElem.type = "face";
        } else {
            blobElem.type = "doc";
        }
        blobElem.subType = BlobStatic.SUB_TYPE_SURVEILLANCE;
        blobElem.version = "1.0";
        blobElem.idx = this.mCacheBlobElem.size();
        blobElem.content = processFrame;
        StringBuilder sb = new StringBuilder();
        sb.append("monitor image length:");
        sb.append(blobElem.content.length);
        InstrumentInjector.log_i(BlobManager.TAG, sb.toString());
        return blobElem;
    }

    private Meta generateMeta() {
        Meta meta = new Meta();
        if ("face".equals(this.mType)) {
            meta.type = BlobStatic.META_TYPE_FACE;
        } else {
            meta.type = BlobStatic.META_TYPE_DOC;
        }
        meta.serialize = this.metaSerializer;
        meta.collectInfo = new HashMap();
        return meta;
    }
}
