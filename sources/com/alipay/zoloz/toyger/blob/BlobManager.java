package com.alipay.zoloz.toyger.blob;

import android.graphics.Rect;
import android.text.TextUtils;
import com.alipay.zoloz.toyger.algorithm.TGFrame;
import com.alipay.zoloz.toyger.algorithm.ToygerBlobConfig;
import com.alipay.zoloz.toyger.blob.model.Meta;
import com.alipay.zoloz.toyger.convert.ConvertManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public abstract class BlobManager<Info> {
    public static final String TAG = "BlobManager";
    protected ToygerBlobConfig config;
    protected CryptoManager crypto;
    protected String mBisToken;
    protected ConvertManager mConvertManager;
    protected String mInvokeType;
    public int metaSerializer;

    public abstract byte[] generateBlob(List<Info> list, Map<String, Object> map);

    public abstract byte[] getKey();

    public abstract boolean isUTF8();

    public BlobManager(int i) {
        this.metaSerializer = i;
        this.mConvertManager = new ConvertManager(i);
    }

    public void setInvokeType(String str) {
        this.mInvokeType = str;
    }

    public void setBisToken(String str) {
        this.mBisToken = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] processFrame(TGFrame tGFrame) {
        return processFrame(tGFrame, this.config.getDesiredWidth().intValue(), (int) (this.config.getCompressRate() * 100.0f), new Rect(0, 0, 0, 0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] processFrame(TGFrame tGFrame, Rect rect) {
        if (rect == null) {
            rect = new Rect(0, 0, 0, 0);
        }
        return processFrame(tGFrame, this.config.getDesiredWidth().intValue(), (int) (this.config.getCompressRate() * 100.0f), rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0105  */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r11v3, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] processFrame(com.alipay.zoloz.toyger.algorithm.TGFrame r9, int r10, int r11, android.graphics.Rect r12) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.zoloz.toyger.blob.BlobManager.processFrame(com.alipay.zoloz.toyger.algorithm.TGFrame, int, int, android.graphics.Rect):byte[]");
    }

    public Meta generateMeta(List<Info> list, Map<String, Object> map) {
        Meta meta = new Meta();
        String string = getString(map, BlobStatic.BLOB_META_INVTP_TYPE);
        String string2 = getString(map, "bis_token");
        meta.invtpType = string;
        meta.bisToken = string2;
        meta.extInfo = new HashMap();
        String string3 = getString(map, BlobStatic.BLOB_META_RETRY);
        if (TextUtils.isEmpty(string3)) {
            string3 = "0";
        }
        meta.extInfo.put("retry", string3);
        return meta;
    }

    private String getString(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        if (obj == null) {
            return null;
        }
        return String.valueOf(obj);
    }

    private int getFrameMode(TGFrame tGFrame) {
        int i = tGFrame.frameMode;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return i != 4 ? -1 : 4;
                    }
                    return 3;
                }
                return 2;
            }
            return 1;
        }
        return 0;
    }
}
