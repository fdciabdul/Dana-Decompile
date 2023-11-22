package com.alipay.zoloz.toyger.doc;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.alipay.zoloz.toyger.algorithm.TGFrame;
import com.alipay.zoloz.toyger.blob.BlobManager;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.alipay.zoloz.toyger.blob.CryptoManager;
import com.alipay.zoloz.toyger.blob.model.Blob;
import com.alipay.zoloz.toyger.blob.model.BlobElem;
import com.alipay.zoloz.toyger.blob.model.Content;
import com.alipay.zoloz.toyger.blob.model.DocBlobElement;
import com.alipay.zoloz.toyger.blob.model.DocInfo;
import com.alipay.zoloz.toyger.blob.model.Meta;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes7.dex */
public class DocBlobManager extends BlobManager<ToygerDocInfo> {
    protected static final String INFO_DOC_TYPE = "docType";
    protected static final String INFO_PAGE_NUMBER = "pageNo";
    protected static final String INFO_PIC_SIZE = "picSize";
    protected Rect mCropRect;
    protected long picSize;

    @Override // com.alipay.zoloz.toyger.blob.BlobManager, com.alipay.zoloz.toyger.blob.IGenericBlobManager
    public boolean isUTF8() {
        return true;
    }

    public DocBlobManager(int i) {
        super(i);
        this.picSize = 0L;
    }

    public long getPicSize() {
        return this.picSize;
    }

    public void setBlobConfig(ToygerDocBlobConfig toygerDocBlobConfig) {
        this.config = toygerDocBlobConfig;
        if (this.crypto == null) {
            this.crypto = new CryptoManager(toygerDocBlobConfig.pubkey);
        }
    }

    public void setCropRect(Rect rect) {
        int width = (int) ((rect.width() * 0.5f) / 2.0f);
        int height = (int) ((rect.height() * 0.5f) / 2.0f);
        this.mCropRect = new Rect(rect.left - width, rect.top - height, rect.right + width, rect.bottom + height);
    }

    @Override // com.alipay.zoloz.toyger.blob.BlobManager
    public byte[] generateBlob(List<ToygerDocInfo> list, Map<String, Object> map) {
        ArrayList arrayList = new ArrayList();
        for (ToygerDocInfo toygerDocInfo : list) {
            DocBlobElement docBlobElement = new DocBlobElement();
            docBlobElement.type = "doc";
            if (toygerDocInfo.getBlobConfig() == null) {
                docBlobElement.subType = BlobStatic.SUB_TYPE_DOC_IMAGE;
            } else {
                docBlobElement.subType = toygerDocInfo.getBlobConfig().subType;
            }
            docBlobElement.version = "1.0";
            docBlobElement.idx = 0;
            docBlobElement.content = processFrame(toygerDocInfo.frame, this.mCropRect);
            if (docBlobElement.content != null) {
                this.picSize = docBlobElement.content.length;
            } else {
                this.picSize = 0L;
            }
            docBlobElement.docInfo = generateDocInfo(toygerDocInfo, map);
            arrayList.add(docBlobElement);
        }
        Blob blob = new Blob();
        blob.blobElem = arrayList;
        blob.blobVersion = "2.0";
        Meta generateMeta = generateMeta(list, map);
        Content content = new Content();
        content.blob = blob;
        content.meta = generateMeta;
        return convertData(content);
    }

    private byte[] convertData(Content content) {
        try {
            return this.crypto.encrypt(this.mConvertManager.convert(content));
        } catch (Exception unused) {
            return null;
        }
    }

    public byte[] generateScanBlob(List<BlobElem> list, Map<String, Object> map) {
        Blob blob = new Blob();
        blob.blobElem = list;
        blob.blobVersion = "2.0";
        Meta generateMeta = generateMeta(null, map);
        Content content = new Content();
        content.blob = blob;
        content.meta = generateMeta;
        return convertData(content);
    }

    public BlobElem generateBlobElem(ToygerDocInfo toygerDocInfo, ToygerDocBlobConfig toygerDocBlobConfig, ToygerDocConfig toygerDocConfig) {
        if (toygerDocInfo == null) {
            return null;
        }
        DocBlobElement docBlobElement = new DocBlobElement();
        docBlobElement.type = "doc";
        docBlobElement.subType = toygerDocBlobConfig.subType;
        docBlobElement.version = "1.0";
        docBlobElement.idx = 0;
        float[] fArr = toygerDocConfig.points;
        PointF pointF = new PointF(fArr[0], fArr[1]);
        PointF pointF2 = new PointF(fArr[2], fArr[3]);
        PointF pointF3 = new PointF(fArr[4], fArr[5]);
        PointF pointF4 = new PointF(fArr[6], fArr[7]);
        setCropRect(toygerDocConfig.rect);
        docBlobElement.content = processFrame(toygerDocInfo.frame, this.mCropRect);
        if (docBlobElement.content == null) {
            return null;
        }
        this.picSize = docBlobElement.content.length;
        DocInfo docInfo = new DocInfo();
        docInfo.docType = getDocType();
        docInfo.pageNo = getPageNum();
        docInfo.region = new ArrayList();
        int i = toygerDocInfo.frame.width;
        int i2 = toygerDocInfo.frame.height;
        if (i > i2) {
            i = i2;
            i2 = i;
        }
        Rect rect = new Rect(this.mCropRect.left < 0 ? 0 : this.mCropRect.left, this.mCropRect.top >= 0 ? this.mCropRect.top : 0, this.mCropRect.right > i ? i : this.mCropRect.right, this.mCropRect.bottom > i2 ? i2 : this.mCropRect.bottom);
        rect.width();
        rect.height();
        float f = i;
        float f2 = i2;
        docInfo.region.add(new Point((int) ((pointF.x * f) - rect.left), (int) ((pointF.y * f2) - rect.top)));
        docInfo.region.add(new Point((int) ((pointF2.x * f) - rect.left), (int) ((pointF2.y * f2) - rect.top)));
        docInfo.region.add(new Point((int) ((pointF3.x * f) - rect.left), (int) ((pointF3.y * f2) - rect.top)));
        docInfo.region.add(new Point((int) ((pointF4.x * f) - rect.left), (int) ((pointF4.y * f2) - rect.top)));
        docBlobElement.docInfo = docInfo;
        return docBlobElement;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void saveImageToFile(com.alipay.zoloz.toyger.algorithm.TGFrame r17, android.graphics.Rect r18, android.graphics.Point r19, android.graphics.Point r20, android.graphics.Point r21, android.graphics.Point r22) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.zoloz.toyger.doc.DocBlobManager.saveImageToFile(com.alipay.zoloz.toyger.algorithm.TGFrame, android.graphics.Rect, android.graphics.Point, android.graphics.Point, android.graphics.Point, android.graphics.Point):void");
    }

    public static String saveBitmap(Bitmap bitmap) {
        File file = new File("/sdcard/doc_scan/");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("/sdcard/doc_scan/");
            sb.append(generateFileName());
            sb.append(".jpg");
            File file2 = new File(sb.toString());
            if (!file2.exists()) {
                file2.getParentFile().mkdirs();
                file2.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return file2.getAbsolutePath();
        } catch (IOException unused) {
            return null;
        }
    }

    private static String generateFileName() {
        return UUID.randomUUID().toString();
    }

    public Rect convertRectByPoints(TGFrame tGFrame, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        int i = tGFrame.rotation % 180 == 0 ? tGFrame.width : tGFrame.height;
        int i2 = i == tGFrame.width ? tGFrame.height : tGFrame.width;
        float min = (Math.min(pointF.y, pointF2.y) + Math.max(pointF3.y, pointF4.y)) / 2.0f;
        Rect rect = new Rect();
        rect.left = 0;
        rect.right = i;
        float f = min * i2;
        float f2 = i / 2;
        rect.top = (int) (f - f2);
        rect.bottom = (int) (f + f2);
        return rect;
    }

    private float[] getMinMax(float[] fArr) {
        float f = fArr[1];
        float f2 = f;
        for (int i = 1; i < fArr.length; i += 2) {
            float f3 = fArr[i];
            if (f > f3) {
                f = f3;
            }
            if (f2 < f3) {
                f2 = f3;
            }
        }
        return new float[]{f, f2};
    }

    private DocInfo generateDocInfo(ToygerDocInfo toygerDocInfo, Map<String, Object> map) {
        DocInfo docInfo = new DocInfo();
        docInfo.docType = getDocType();
        docInfo.pageNo = getPageNum();
        return docInfo;
    }

    @Override // com.alipay.zoloz.toyger.blob.BlobManager
    public Meta generateMeta(List<ToygerDocInfo> list, Map<String, Object> map) {
        Meta generateMeta = super.generateMeta(list, map);
        generateMeta.type = BlobStatic.META_TYPE_DOC;
        generateMeta.serialize = this.metaSerializer;
        generateMeta.collectInfo = new HashMap();
        generateMeta.collectInfo.put("docType", getDocType());
        generateMeta.collectInfo.put(INFO_PAGE_NUMBER, Integer.valueOf(getPageNum()));
        generateMeta.collectInfo.put(INFO_PIC_SIZE, Long.valueOf(this.picSize));
        if (map != null && map.size() > 0) {
            generateMeta.collectInfo.putAll(map);
        }
        return generateMeta;
    }

    @Override // com.alipay.zoloz.toyger.blob.BlobManager, com.alipay.zoloz.toyger.blob.IGenericBlobManager
    public byte[] getKey() {
        return this.crypto.getAESCypher();
    }

    protected String getDocType() {
        return ((ToygerDocBlobConfig) this.config).docType;
    }

    protected int getPageNum() {
        return ((ToygerDocBlobConfig) this.config).pageNo;
    }
}
