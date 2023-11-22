package com.alipay.zoloz.toyger.doc;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alipay.zoloz.toyger.IToygerDocDelegate;
import com.alipay.zoloz.toyger.ToygerService;
import com.alipay.zoloz.toyger.algorithm.TGFrame;
import com.alipay.zoloz.toyger.algorithm.ToygerDoc;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.alipay.zoloz.toyger.blob.model.BlobElem;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes7.dex */
public class ToygerScanDocService implements IToygerDocDelegate {
    private DocBlobManager mBlobManager;
    private ToygerDocBlobConfig mDocBlobConfig;
    private ToygerDocConfig mDocConfig;
    private Handler mProcessHandler;
    private HandlerThread mProcessThread;
    private ToygerDocCallback mToygerCallback;
    private final String TAG = ToygerScanDocService.class.getName();
    private Handler mMainHandler = new Handler(Looper.getMainLooper());
    private final AtomicBoolean isToygerReady = new AtomicBoolean(false);
    private List<BlobElem> mCacheData = new ArrayList();
    private final ReentrantLock mColorFrameQueueLock = new ReentrantLock();
    private final BlockingQueue<TGFrame> mFrameQueue = new LinkedBlockingDeque(1);

    @Override // com.alipay.zoloz.toyger.IToygerDocDelegate
    public void handleInfoReady(TGFrame tGFrame, ToygerDocAttr toygerDocAttr) {
    }

    private byte[] loadModel(Context context) {
        try {
            InputStream open = context.getAssets().open(ToygerService.ASSET_FACE);
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            return bArr;
        } catch (Exception unused) {
            return null;
        }
    }

    private String loadLicense(Context context) {
        try {
            InputStream open = context.getAssets().open(ToygerService.ASSET_LICENSE);
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            return new String(bArr);
        } catch (Exception unused) {
            return "";
        }
    }

    public boolean init(Context context, String str, ToygerDocCallback toygerDocCallback) {
        return init(context, str, toygerDocCallback, null);
    }

    public boolean init(Context context, String str, ToygerDocCallback toygerDocCallback, Map<String, Object> map) {
        this.mToygerCallback = toygerDocCallback;
        byte[] loadModel = loadModel(context);
        initThread();
        initBlobManager((map == null || !map.containsKey("meta_serializer")) ? 2 : Integer.parseInt(map.get("meta_serializer").toString()));
        if (TextUtils.isEmpty(str)) {
            str = loadLicense(context);
        }
        initToyger(context, loadModel, str);
        return true;
    }

    private void initThread() {
        HandlerThread handlerThread = new HandlerThread("ToygerProcessDocQueue");
        this.mProcessThread = handlerThread;
        handlerThread.start();
        this.mProcessHandler = new Handler(this.mProcessThread.getLooper());
    }

    private void initBlobManager(int i) {
        this.mBlobManager = new DocBlobManager(i);
    }

    private void initToyger(final Context context, final byte[] bArr, final String str) {
        this.mProcessHandler.post(new Runnable() { // from class: com.alipay.zoloz.toyger.doc.ToygerScanDocService.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put("StateSignature", ToygerDocState.class.getName().replace(".", "/"));
                hashMap.put("AttrSignature", ToygerDocAttr.class.getName().replace(".", "/"));
                hashMap.put("FrameSignature", TGFrame.class.getName().replace(".", "/"));
                hashMap.put("Algorithm", "Doc");
                Context context2 = context;
                if (ToygerDoc.init(context2, bArr, str, context2.getPackageName(), hashMap)) {
                    ToygerScanDocService.this.mToygerCallback.onEvent(1, null);
                } else {
                    ToygerScanDocService.this.mToygerCallback.onEvent(-4, null);
                }
            }
        });
    }

    public void config(final String str, final String str2, final Map<String, Object> map) {
        InstrumentInjector.log_d(this.TAG, "config is execute");
        this.mProcessHandler.post(new Runnable() { // from class: com.alipay.zoloz.toyger.doc.ToygerScanDocService.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ToygerScanDocService.this.mColorFrameQueueLock.lock();
                    ToygerDoc.reset();
                    ToygerScanDocService.this.mDocBlobConfig = (ToygerDocBlobConfig) JSON.parseObject(str2, ToygerDocBlobConfig.class);
                    ToygerScanDocService.this.mBlobManager.setBlobConfig(ToygerScanDocService.this.mDocBlobConfig);
                    ToygerScanDocService.this.mDocConfig = (ToygerDocConfig) JSON.parseObject(str, ToygerDocConfig.class);
                    ToygerScanDocService.this.mDocConfig.docType = ToygerScanDocService.this.mDocBlobConfig.docType;
                    ToygerScanDocService.this.mDocConfig.pageNo = ToygerScanDocService.this.mDocBlobConfig.pageNo;
                    Map map2 = map;
                    if (map2 != null && map2.containsKey(ToygerService.KEY_ROTATE_TIMES)) {
                        Integer num = (Integer) map.get(ToygerService.KEY_ROTATE_TIMES);
                    }
                    Map map3 = map;
                    float[] fArr = (map3 == null || !map3.containsKey(ToygerService.KEY_DOC_FRAME_POINTS)) ? null : (float[]) map.get(ToygerService.KEY_DOC_FRAME_POINTS);
                    if (fArr == null) {
                        ToygerScanDocService.this.mToygerCallback.onEvent(-8, null);
                    } else {
                        Map map4 = map;
                        Rect rect = (map4 == null || !map4.containsKey(ToygerService.KEY_DOC_FRAME_RECT)) ? null : (Rect) map.get(ToygerService.KEY_DOC_FRAME_RECT);
                        if (rect == null) {
                            ToygerScanDocService.this.mToygerCallback.onEvent(-8, null);
                        } else {
                            ToygerScanDocService.this.mDocConfig.points = fArr;
                            ToygerScanDocService.this.mDocConfig.rect = rect;
                            ToygerScanDocService toygerScanDocService = ToygerScanDocService.this;
                            ToygerDoc.config(toygerScanDocService, toygerScanDocService.mDocConfig);
                            ToygerScanDocService.this.isToygerReady.set(true);
                        }
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    ToygerScanDocService.this.mColorFrameQueueLock.unlock();
                    throw th;
                }
                ToygerScanDocService.this.mColorFrameQueueLock.unlock();
            }
        });
    }

    public void scan(TGFrame tGFrame) {
        TGFrame deepCopy;
        if (!this.isToygerReady.get() || tGFrame == null || this.mFrameQueue.remainingCapacity() <= 0 || (deepCopy = tGFrame.deepCopy()) == null) {
            return;
        }
        this.mFrameQueue.offer(deepCopy);
        this.mProcessHandler.post(new Runnable() { // from class: com.alipay.zoloz.toyger.doc.ToygerScanDocService.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InstrumentInjector.log_i("zolozTime", "toyger service process frame");
                    TGFrame tGFrame2 = (TGFrame) ToygerScanDocService.this.mFrameQueue.poll(1L, TimeUnit.SECONDS);
                    ToygerScanDocService.this.mColorFrameQueueLock.lock();
                    if (tGFrame2 != null) {
                        ToygerDoc.processImage(tGFrame2);
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        });
    }

    public void reset() {
        this.isToygerReady.set(true);
        ToygerDoc.reset();
        this.mFrameQueue.clear();
    }

    public void reset(boolean z) {
        if (z) {
            this.mCacheData.clear();
        }
        reset();
    }

    public void release() {
        this.mCacheData.clear();
        this.mToygerCallback = null;
        ToygerDoc.release();
    }

    @Override // com.alipay.zoloz.toyger.IToygerDocDelegate
    public void handleStateUpdated(final ToygerDocState toygerDocState, final ToygerDocAttr toygerDocAttr) {
        this.mMainHandler.post(new Runnable() { // from class: com.alipay.zoloz.toyger.doc.ToygerScanDocService.4
            @Override // java.lang.Runnable
            public void run() {
                ToygerScanDocService.this.mToygerCallback.onStateUpdated(toygerDocState, toygerDocAttr, null);
            }
        });
    }

    @Override // com.alipay.zoloz.toyger.IToygerDocDelegate
    public void handleLog(int i, String str, byte[] bArr) {
        String str2 = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("handleLog() logLevel=");
        sb.append(i);
        sb.append(", log=");
        sb.append(str);
        InstrumentInjector.log_i(str2, sb.toString());
    }

    public void handleUpdate(final ToygerDocState toygerDocState, final ToygerDocAttr toygerDocAttr) {
        this.mMainHandler.post(new Runnable() { // from class: com.alipay.zoloz.toyger.doc.ToygerScanDocService.5
            @Override // java.lang.Runnable
            public void run() {
                ToygerScanDocService.this.mToygerCallback.onStateUpdated(toygerDocState, toygerDocAttr, null);
            }
        });
    }

    @Override // com.alipay.zoloz.toyger.IToygerDocDelegate
    public void handleFinish(final int i, final ToygerDocInfo toygerDocInfo) {
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("handleFinish:");
        sb.append(i);
        InstrumentInjector.log_d(str, sb.toString());
        if (i == 0) {
            this.mCacheData.add(this.mBlobManager.generateBlobElem(toygerDocInfo, this.mDocBlobConfig, this.mDocConfig));
        }
        this.mMainHandler.post(new Runnable() { // from class: com.alipay.zoloz.toyger.doc.ToygerScanDocService.6
            @Override // java.lang.Runnable
            public void run() {
                ToygerScanDocService.this.isToygerReady.set(false);
                int i2 = i;
                if (i2 == 0) {
                    ToygerScanDocService.this.mToygerCallback.onComplete(i, toygerDocInfo.frame);
                } else if (i2 == 1) {
                    ToygerScanDocService.this.mToygerCallback.onEvent(-9, null);
                } else {
                    ToygerScanDocService.this.mToygerCallback.onEvent(-8, null);
                }
            }
        });
    }

    public void handleEvent(int i, String str) {
        this.mToygerCallback.onEvent(i, null);
    }

    @Override // com.alipay.zoloz.toyger.IToygerDocDelegate
    public void handleEventTriggered(int i, String str) {
        this.mToygerCallback.onEvent(i, null);
    }

    public Map<String, Object> generateScanBlob(String str, int i, Map<String, Object> map) {
        map.put("bis_token", str);
        map.put(BlobStatic.BLOB_META_INVTP_TYPE, "normal");
        map.put(BlobStatic.BLOB_META_RETRY, Integer.valueOf(i));
        List<BlobElem> list = this.mCacheData;
        if (list == null || list.size() <= 0) {
            return null;
        }
        byte[] generateScanBlob = this.mBlobManager.generateScanBlob(this.mCacheData, map);
        this.mCacheData.clear();
        HashMap hashMap = new HashMap();
        hashMap.put("content", generateScanBlob);
        hashMap.put("key", this.mBlobManager.getKey());
        hashMap.put(ToygerService.KEY_RES_9_IS_UTF8, Boolean.TRUE);
        return hashMap;
    }
}
