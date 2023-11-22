package com.alipay.zoloz.toyger;

import android.content.Context;
import com.alipay.zoloz.toyger.ToygerAlgorithmConfig;
import com.alipay.zoloz.toyger.ToygerAttr;
import com.alipay.zoloz.toyger.ToygerBiometricInfo;
import com.alipay.zoloz.toyger.ToygerCallback;
import com.alipay.zoloz.toyger.ToygerState;
import com.alipay.zoloz.toyger.algorithm.IToygerDelegate;
import com.alipay.zoloz.toyger.algorithm.TGFrame;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public abstract class ToygerService<C extends ToygerCallback, State extends ToygerState, Attr extends ToygerAttr, Info extends ToygerBiometricInfo, AlgorithmConfig extends ToygerAlgorithmConfig> implements IToygerDelegate<State, Attr, Info> {
    public static final String ASSET_DOC = "toyger.doc.dat";
    public static final String ASSET_FACE = "toyger.face.dat";
    public static final String ASSET_LICENSE = "toyger.license";
    public static final String KEY_DOC_FRAME_POINTS = "docFramePoints";
    public static final String KEY_DOC_FRAME_RECT = "docFrameRect";
    public static final String KEY_IS_MIRROR = "is_mirror";
    public static final String KEY_META_SERIALIZER = "meta_serializer";
    public static final String KEY_PUBLIC_KEY = "pubkey";
    public static final String KEY_RES_9_CONTENT = "content";
    public static final String KEY_RES_9_IS_UTF8 = "isUTF8";
    public static final String KEY_RES_9_KEY = "key";
    public static final String KEY_ROI = "ROI";
    public static final String KEY_ROTATE_TIMES = "rotateTimes";
    public static final String TAG = "TOYGER";
    protected C mToygerCallback;

    public static boolean preLoad(Context context) {
        return false;
    }

    @Override // com.alipay.zoloz.toyger.algorithm.IToygerDelegate
    public abstract void handleFinished(int i, List<Info> list, Map<String, Object> map);

    @Override // com.alipay.zoloz.toyger.algorithm.IToygerDelegate
    public abstract void handleInfoReady(TGFrame tGFrame, Attr attr);

    @Override // com.alipay.zoloz.toyger.algorithm.IToygerDelegate
    public abstract void handleStateUpdated(State state, Attr attr);

    public abstract boolean init(Context context, String str, C c, String str2, String str3, Map<String, Object> map);

    public abstract boolean processImage(TGFrame tGFrame);

    public abstract void release();

    public abstract void reset();

    @Override // com.alipay.zoloz.toyger.algorithm.IToygerDelegate
    public void handleLog(int i, String str, byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleLog() logLevel=");
        sb.append(i);
        sb.append(", log=");
        sb.append(str);
        InstrumentInjector.log_i(TAG, sb.toString());
    }

    @Override // com.alipay.zoloz.toyger.algorithm.IToygerDelegate
    public void handleEventTriggered(int i, String str) {
        if (str == null) {
            this.mToygerCallback.onEvent(i, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("handleEventTriggered() eventCode=");
        sb.append(i);
        sb.append(", message=");
        sb.append(str);
        InstrumentInjector.log_i(TAG, sb.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("result", str);
        this.mToygerCallback.onEvent(i, hashMap);
    }
}
