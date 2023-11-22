package com.alipay.zoloz.toyger.face;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.alipay.zoloz.toyger.ToygerService;
import com.alipay.zoloz.toyger.algorithm.TGFrame;
import com.alipay.zoloz.toyger.algorithm.Toyger;
import com.alipay.zoloz.toyger.algorithm.ToygerConfig;
import com.alipay.zoloz.toyger.blob.BitmapHelper;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes7.dex */
public class ToygerFaceService extends ToygerService<ToygerFaceCallback, ToygerFaceState, ToygerFaceAttr, ToygerFaceInfo, ToygerFaceAlgorithmConfig> {
    public static final String KEY_TOYGER_DEPTH_FRAME = "toyger_depth_frame";
    public static final String KEY_TOYGER_FRAME = "toyger_frame";
    public static final String KEY_TOYGER_TIME_CONSUMING = "toygerTimeConsuming";
    private static final int QUEUE_LENGTH = 1;
    private static short[] depthCache;
    private static String licenses;
    private static byte[] model;
    private static byte[] yuvCache;
    private FaceBlobManager blobManager;
    private ToygerFaceAlgorithmConfig faceAlgConfig;
    private String mBisToken;
    private FaceDetector mFaceDetector;
    private HandlerThread mProcessThread;
    private Handler mProcessThreadHandler;
    boolean needFppPreprocess;
    private final BlockingQueue<TGFrame> mFrameQueue = new LinkedBlockingDeque(1);
    private final FrameProcessor mFrameProcessor = new FrameProcessor();
    private final AtomicBoolean mRunning = new AtomicBoolean(false);
    private final ReentrantLock mColorFrameQueueLock = new ReentrantLock();
    private boolean isMirror = false;
    private int mRetryTimes = 0;

    private byte[] generateNormalImg(List<ToygerFaceInfo> list, Map<String, Object> map) {
        return null;
    }

    @Override // com.alipay.zoloz.toyger.ToygerService
    public /* bridge */ /* synthetic */ boolean init(Context context, String str, ToygerFaceCallback toygerFaceCallback, String str2, String str3, Map map) {
        return init2(context, str, toygerFaceCallback, str2, str3, (Map<String, Object>) map);
    }

    public void setBisToken(String str) {
        this.mBisToken = str;
    }

    public void setRetryTimes(int i) {
        this.mRetryTimes = i;
    }

    private static boolean load(Context context) {
        try {
            InputStream open = context.getAssets().open(ToygerService.ASSET_FACE);
            byte[] bArr = new byte[open.available()];
            model = bArr;
            open.read(bArr);
            if (model == null) {
                InstrumentInjector.log_e(ToygerService.TAG, "fail to read model file");
                return false;
            }
            try {
                InputStream open2 = context.getAssets().open(ToygerService.ASSET_LICENSE);
                byte[] bArr2 = new byte[open2.available()];
                open2.read(bArr2);
                licenses = new String(bArr2);
                return true;
            } catch (IOException e) {
                InstrumentInjector.log_w(ToygerService.TAG, e);
                return true;
            }
        } catch (IOException e2) {
            InstrumentInjector.log_w(ToygerService.TAG, e2);
            return false;
        }
    }

    public static boolean preLoad(Context context) {
        if (model != null) {
            InstrumentInjector.log_i(ToygerService.TAG, "ToygerFaceService.preLoad(): model is already loaded");
            return true;
        }
        boolean load = load(context);
        StringBuilder sb = new StringBuilder();
        sb.append("ToygerFaceService.preLoad() : bRet=");
        sb.append(load);
        InstrumentInjector.log_i(ToygerService.TAG, sb.toString());
        return load;
    }

    /* renamed from: init  reason: avoid collision after fix types in other method */
    public boolean init2(final Context context, final String str, ToygerFaceCallback toygerFaceCallback, String str2, String str3, final Map<String, Object> map) {
        String str4;
        String str5;
        String str6;
        String str7;
        this.mToygerCallback = toygerFaceCallback;
        HashMap hashMap = new HashMap();
        hashMap.put("seed", "ztech_enter");
        hashMap.put("module", "toyger");
        ((ToygerFaceCallback) this.mToygerCallback).onEvent(-7, hashMap);
        if (model == null) {
            load(context);
        }
        if (this.mProcessThread == null) {
            HandlerThread handlerThread = new HandlerThread("ToygerProcessQueue");
            this.mProcessThread = handlerThread;
            handlerThread.start();
        }
        if (this.mProcessThreadHandler == null) {
            this.mProcessThreadHandler = new Handler(this.mProcessThread.getLooper());
        }
        if (map == null || !map.containsKey(ToygerService.KEY_PUBLIC_KEY)) {
            str4 = str3;
            str5 = null;
        } else {
            str5 = map.get(ToygerService.KEY_PUBLIC_KEY).toString();
            str4 = str3;
        }
        ToygerFaceBlobConfig from = ToygerFaceBlobConfig.from(str4, str5);
        if (from == null) {
            InstrumentInjector.log_e(ToygerService.TAG, "fail to parse upload config");
            return false;
        }
        if (map != null && map.containsKey(ToygerService.KEY_IS_MIRROR)) {
            this.isMirror = Boolean.parseBoolean(map.get(ToygerService.KEY_IS_MIRROR).toString());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("isMirror=");
        sb.append(this.isMirror);
        InstrumentInjector.log_i(ToygerService.TAG, sb.toString());
        int i = 2;
        if (map != null && map.containsKey("meta_serializer")) {
            i = Integer.parseInt(map.get("meta_serializer").toString());
        }
        this.blobManager = new FaceBlobManager(i, from);
        this.faceAlgConfig = ToygerFaceAlgorithmConfig.from(str2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Toyger mocked protocol:");
        sb2.append(this.faceAlgConfig);
        InstrumentInjector.log_i(ToygerService.TAG, sb2.toString());
        if (this.faceAlgConfig == null) {
            InstrumentInjector.log_e(ToygerService.TAG, "fail to parse algorithm config, load default config");
            this.faceAlgConfig = new ToygerFaceAlgorithmConfig();
        }
        for (String str8 : this.faceAlgConfig.liveness_combination) {
            if (str8.contains("fpp") || "BlinkLiveness".equalsIgnoreCase(str8)) {
                this.needFppPreprocess = true;
                break;
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("need fpp preprocess: ");
        sb3.append(this.needFppPreprocess);
        InstrumentInjector.log_i(ToygerService.TAG, sb3.toString());
        final ToygerConfig toygerConfig = this.faceAlgConfig.toToygerConfig(this.needFppPreprocess);
        String str9 = "";
        if (from.collection != null) {
            str6 = "";
            for (int i2 = 0; i2 < from.collection.size(); i2++) {
                if (str6.length() > 0) {
                    str6 = str6.concat("#").concat(from.collection.get(i2));
                } else {
                    str6 = from.collection.get(i2);
                }
            }
        } else {
            str6 = "";
        }
        toygerConfig.livenessConfig.collection = str6;
        for (int i3 = 0; i3 < this.faceAlgConfig.liveness_combination.size(); i3++) {
            if (str9.length() > 0) {
                str7 = str9.concat("#").concat(this.faceAlgConfig.liveness_combination.get(i3));
            } else {
                str7 = this.faceAlgConfig.liveness_combination.get(i3);
            }
            str9 = str7;
        }
        toygerConfig.livenessConfig.livenessCombinations = str9;
        Map<String, List<Float>> map2 = this.faceAlgConfig.threshold;
        if (map2 != null) {
            List<Float> list = map2.get(ToygerFaceAlgorithmConfig.DRAGONFLY_LIVENESS);
            List<Float> list2 = list instanceof List ? list : null;
            if (list2 != null) {
                for (int i4 = 0; i4 < list2.size(); i4++) {
                    float floatValue = list2.get(i4).floatValue();
                    if (i4 == 0) {
                        toygerConfig.livenessConfig.dragonflyMin = floatValue;
                    } else if (i4 == 1) {
                        toygerConfig.livenessConfig.dragonflyMax = floatValue;
                    }
                }
            }
            List<Float> list3 = map2.get(ToygerFaceAlgorithmConfig.GEMINI_LIVENESS);
            List<Float> list4 = list3 instanceof List ? list3 : null;
            if (list4 != null) {
                for (int i5 = 0; i5 < list4.size(); i5++) {
                    float floatValue2 = list4.get(i5).floatValue();
                    if (i5 == 0) {
                        toygerConfig.livenessConfig.geminiMin = floatValue2;
                    } else if (i5 == 1) {
                        toygerConfig.livenessConfig.geminiMax = floatValue2;
                    }
                }
            }
            List<Float> list5 = map2.get(ToygerFaceAlgorithmConfig.BAT_LIVENESS);
            List<Float> list6 = list5 instanceof List ? list5 : null;
            if (list6 != null && list6.size() > 0) {
                toygerConfig.livenessConfig.batLivenessThreshold = list6.get(0).floatValue();
            }
            List<Float> list7 = map2.get("zfaceBlinkLiveness");
            if (list7 != null) {
                if (list7.size() > 0) {
                    toygerConfig.qualityConfig.blinkOpenness = list7.get(0).floatValue();
                }
                if (list7.size() > 1) {
                    toygerConfig.qualityConfig.diffThreshold = list7.get(1).floatValue();
                }
            }
            List<Float> list8 = map2.get("ZisaBlinkLiveness");
            if (list8 != null) {
                if (list8.size() > 0) {
                    toygerConfig.qualityConfig.blinkOpenness = list8.get(0).floatValue();
                }
                if (list8.size() > 1) {
                    toygerConfig.qualityConfig.diffThreshold = list8.get(1).floatValue();
                }
            }
        }
        final ToygerFaceCallback toygerFaceCallback2 = (ToygerFaceCallback) this.mToygerCallback;
        this.mProcessThreadHandler.post(new Runnable() { // from class: com.alipay.zoloz.toyger.face.ToygerFaceService.1
            @Override // java.lang.Runnable
            public void run() {
                Rect rect;
                HashMap hashMap2 = new HashMap();
                hashMap2.put("StateSignature", ToygerFaceState.class.getName().replace(".", "/"));
                hashMap2.put("AttrSignature", ToygerFaceAttr.class.getName().replace(".", "/"));
                hashMap2.put("FrameSignature", TGFrame.class.getName().replace(".", "/"));
                hashMap2.put("Algorithm", "Face");
                Map map3 = map;
                if (map3 != null && (rect = (Rect) map3.get(ToygerService.KEY_ROI)) != null) {
                    toygerConfig.cameraConfig.roiRect = rect;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("run: setRoi top ");
                    sb4.append(rect.top);
                    sb4.append("left ");
                    sb4.append(rect.left);
                    sb4.append("right");
                    sb4.append(rect.right);
                    sb4.append("bottom ");
                    sb4.append(rect.bottom);
                    InstrumentInjector.log_d(ToygerService.TAG, sb4.toString());
                }
                String str10 = str;
                if (TextUtils.isEmpty(str10)) {
                    str10 = ToygerFaceService.licenses;
                }
                boolean init = Toyger.init(context, ToygerFaceService.model, str10, context.getPackageName(), hashMap2);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Toyger.init() return : initResult=");
                sb5.append(init);
                InstrumentInjector.log_e(ToygerService.TAG, sb5.toString());
                byte[] unused = ToygerFaceService.model = null;
                if (init) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("toygerConfig=");
                    sb6.append(toygerConfig);
                    InstrumentInjector.log_d(ToygerService.TAG, sb6.toString());
                    Toyger.config(this, toygerConfig);
                    ToygerFaceService.this.mRunning.set(true);
                    toygerFaceCallback2.onEvent(1, null);
                    return;
                }
                toygerFaceCallback2.onEvent(-4, null);
            }
        });
        return true;
    }

    @Override // com.alipay.zoloz.toyger.ToygerService
    public boolean processImage(TGFrame tGFrame) {
        if (this.mFrameQueue.remainingCapacity() > 0) {
            this.mFrameQueue.offer(tGFrame.deepCopy());
            Handler handler = this.mProcessThreadHandler;
            if (handler == null) {
                InstrumentInjector.log_i(ToygerService.TAG, "ToygerFaceService.processImage(), processThreadHandler is null, return false");
                return false;
            }
            handler.post(new Runnable() { // from class: com.alipay.zoloz.toyger.face.ToygerFaceService.2
                @Override // java.lang.Runnable
                public void run() {
                    ReentrantLock reentrantLock;
                    try {
                        if (ToygerFaceService.this.mRunning.get()) {
                            TGFrame tGFrame2 = (TGFrame) ToygerFaceService.this.mFrameQueue.poll(1L, TimeUnit.SECONDS);
                            try {
                                InstrumentInjector.log_i("zolozTime", "toyger service process frame");
                                ToygerFaceService.this.mColorFrameQueueLock.lock();
                                if (tGFrame2 != null) {
                                    if (ToygerFaceService.this.isMirror) {
                                        tGFrame2.data = ToygerFaceService.mirrorYUV420(tGFrame2.data, tGFrame2.width, tGFrame2.height);
                                    }
                                    Toyger.processImage(tGFrame2);
                                }
                                ToygerFaceService.this.mFrameProcessor.clearFrame();
                                reentrantLock = ToygerFaceService.this.mColorFrameQueueLock;
                            } catch (Throwable th) {
                                try {
                                    InstrumentInjector.log_e(ToygerService.TAG, "Failed to processImage().", th);
                                    ToygerFaceService.this.mFrameProcessor.clearFrame();
                                    reentrantLock = ToygerFaceService.this.mColorFrameQueueLock;
                                } catch (Throwable th2) {
                                    ToygerFaceService.this.mFrameProcessor.clearFrame();
                                    ToygerFaceService.this.mColorFrameQueueLock.unlock();
                                    InstrumentInjector.log_i("zolozTime", "toyger service process frame end");
                                    throw th2;
                                }
                            }
                            reentrantLock.unlock();
                            InstrumentInjector.log_i("zolozTime", "toyger service process frame end");
                        }
                    } catch (Throwable th3) {
                        InstrumentInjector.log_e(ToygerService.TAG, "Failed to processImage", th3);
                    }
                }
            });
            return true;
        }
        return true;
    }

    @Override // com.alipay.zoloz.toyger.ToygerService
    public void reset() {
        Iterator it = this.mFrameQueue.iterator();
        while (it.hasNext()) {
            try {
                this.mColorFrameQueueLock.lock();
                ((TGFrame) it.next()).recycle();
                this.mColorFrameQueueLock.unlock();
                it.remove();
            } catch (Throwable th) {
                InstrumentInjector.log_e(ToygerService.TAG, th.toString());
            }
        }
        this.mProcessThreadHandler.post(new Runnable() { // from class: com.alipay.zoloz.toyger.face.ToygerFaceService.3
            @Override // java.lang.Runnable
            public void run() {
                Toyger.reset();
                InstrumentInjector.log_i(ToygerService.TAG, "toyger is reset");
            }
        });
    }

    @Override // com.alipay.zoloz.toyger.ToygerService
    public void release() {
        this.mRunning.set(false);
        HashMap hashMap = new HashMap();
        hashMap.put("seed", "ztech_exit");
        hashMap.put("module", "toyger");
        ((ToygerFaceCallback) this.mToygerCallback).onEvent(-7, hashMap);
        reset();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.mProcessThreadHandler.post(new Runnable() { // from class: com.alipay.zoloz.toyger.face.ToygerFaceService.4
            @Override // java.lang.Runnable
            public void run() {
                InstrumentInjector.log_i(ToygerService.TAG, "before releasing toyger");
                Toyger.release();
                countDownLatch.countDown();
                InstrumentInjector.log_i(ToygerService.TAG, "toyger is released");
            }
        });
        try {
            countDownLatch.await(1L, TimeUnit.SECONDS);
            if (this.mProcessThread != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    this.mProcessThread.quitSafely();
                    InstrumentInjector.log_i(ToygerService.TAG, "toyger thread quited");
                } else {
                    this.mProcessThread.quit();
                    InstrumentInjector.log_i(ToygerService.TAG, "toyger thread quited");
                }
            }
            this.mProcessThread = null;
            this.mProcessThreadHandler.removeCallbacksAndMessages(null);
            this.mProcessThreadHandler = null;
        } catch (InterruptedException e) {
            InstrumentInjector.log_e(ToygerService.TAG, e.toString());
        }
        yuvCache = null;
        depthCache = null;
    }

    @Override // com.alipay.zoloz.toyger.ToygerService, com.alipay.zoloz.toyger.algorithm.IToygerDelegate
    public void handleEventTriggered(int i, String str) {
        super.handleEventTriggered(i, str);
    }

    @Override // com.alipay.zoloz.toyger.ToygerService, com.alipay.zoloz.toyger.algorithm.IToygerDelegate
    public void handleStateUpdated(ToygerFaceState toygerFaceState, ToygerFaceAttr toygerFaceAttr) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleStateUpdated(): state=");
        sb.append(toygerFaceState);
        sb.append(", attr=");
        sb.append(toygerFaceAttr);
        InstrumentInjector.log_d(ToygerService.TAG, sb.toString());
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_TOYGER_FRAME, this.mFrameProcessor.getTgFrame());
        ((ToygerFaceCallback) this.mToygerCallback).onStateUpdated(toygerFaceState, toygerFaceAttr, hashMap);
    }

    @Override // com.alipay.zoloz.toyger.ToygerService, com.alipay.zoloz.toyger.algorithm.IToygerDelegate
    public void handleInfoReady(TGFrame tGFrame, ToygerFaceAttr toygerFaceAttr) {
        if (2 == this.faceAlgConfig.log_level) {
            FrameProcessor.clearOldBinFiles();
            int i = tGFrame.rotation % 180 == 0 ? tGFrame.width : tGFrame.height;
            Rect convertFaceRegion = FaceBlobManager.convertFaceRegion(toygerFaceAttr.faceRegion, i, i == tGFrame.width ? tGFrame.height : tGFrame.width, tGFrame.rotation, false);
            StringBuilder sb = new StringBuilder();
            sb.append(convertFaceRegion.left);
            sb.append("_");
            sb.append(convertFaceRegion.top);
            sb.append("_");
            sb.append(convertFaceRegion.right);
            sb.append("_");
            sb.append(convertFaceRegion.bottom);
            String obj = sb.toString();
            this.mFrameProcessor.saveTgFrame(obj);
            this.mFrameProcessor.saveTgDepthFrame(obj);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("handleInfoReady(): frame=");
        sb2.append(tGFrame);
        sb2.append(", attr=");
        sb2.append(toygerFaceAttr);
        InstrumentInjector.log_d(ToygerService.TAG, sb2.toString());
        Bitmap rotateBitmap = BitmapHelper.rotateBitmap(BitmapHelper.bytes2Bitmap(tGFrame.data, tGFrame.width, tGFrame.height, tGFrame.frameMode), tGFrame.rotation);
        ((ToygerFaceCallback) this.mToygerCallback).onHighQualityFrame(BitmapHelper.reverseBitmap(rotateBitmap, 0), toygerFaceAttr);
        if (rotateBitmap != null) {
            rotateBitmap.recycle();
        }
    }

    private void onHighQuallity(ToygerFaceInfo toygerFaceInfo) {
        TGFrame tGFrame = toygerFaceInfo.frame;
        ToygerFaceAttr toygerFaceAttr = (ToygerFaceAttr) toygerFaceInfo.attr;
        ((ToygerFaceCallback) this.mToygerCallback).onHighQualityFrame(BitmapHelper.reverseBitmap(BitmapHelper.rotateBitmap(BitmapHelper.bytes2Bitmap(tGFrame.data, tGFrame.width, tGFrame.height, tGFrame.frameMode), tGFrame.rotation), 0), toygerFaceAttr);
    }

    @Override // com.alipay.zoloz.toyger.ToygerService, com.alipay.zoloz.toyger.algorithm.IToygerDelegate
    public void handleFinished(int i, List<ToygerFaceInfo> list, Map<String, Object> map) {
        map.put("bis_token", this.mBisToken);
        map.put(BlobStatic.BLOB_META_RETRY, Integer.valueOf(this.mRetryTimes));
        if (i != 0) {
            if (i == 1) {
                HashMap hashMap = new HashMap();
                map.put(BlobStatic.BLOB_META_INVTP_TYPE, BlobStatic.INVTP_TYPE_ASYNC_UPLOAD);
                map.put(BlobStatic.DRAGONFLY_PASS, 0);
                for (ToygerFaceInfo toygerFaceInfo : list) {
                    if (ToygerFaceElementType.getBlobElemType(toygerFaceInfo).equals(BlobStatic.SUB_TYPE_PANO)) {
                        hashMap.put("data", this.blobManager.generateBlob(Arrays.asList(toygerFaceInfo), map));
                    }
                }
                hashMap.put("key", this.blobManager.getKey());
                hashMap.put("utf8", Boolean.valueOf(this.blobManager.isUTF8()));
                ((ToygerFaceCallback) this.mToygerCallback).onEvent(-3, hashMap);
                return;
            }
            ((ToygerFaceCallback) this.mToygerCallback).onEvent(-8, null);
            return;
        }
        map.put(BlobStatic.DRAGONFLY_PASS, 1);
        InstrumentInjector.log_d("TAG", "handle Finished");
        ArrayList arrayList = new ArrayList();
        onHighQuallity(list.get(0));
        for (int i2 = 0; i2 < list.size() - 1; i2++) {
            map.put(BlobStatic.BLOB_META_INVTP_TYPE, BlobStatic.INVTP_TYPE_ASYNC_UPLOAD);
            ToygerFaceInfo toygerFaceInfo2 = list.get(i2);
            if (toygerFaceInfo2 != null) {
                arrayList.add(this.blobManager.generateBlob(Arrays.asList(toygerFaceInfo2), map));
            }
        }
        if (list.size() > 0) {
            map.put(BlobStatic.BLOB_META_INVTP_TYPE, "normal");
            ToygerFaceInfo toygerFaceInfo3 = list.get(list.size() - 1);
            if (toygerFaceInfo3 != null) {
                arrayList.add(this.blobManager.generateBlob(Arrays.asList(toygerFaceInfo3), map));
            }
        }
        InstrumentInjector.log_d("TAG", "generate content success");
        byte[] key = this.blobManager.getKey();
        StringBuilder sb = new StringBuilder();
        sb.append("handleFinished(): result=");
        sb.append(i);
        sb.append(", infos=");
        sb.append(list);
        sb.append(", extIno=");
        sb.append(map);
        sb.append(", key:");
        sb.append(key.length);
        InstrumentInjector.log_d(ToygerService.TAG, sb.toString());
        ((ToygerFaceCallback) this.mToygerCallback).onComplete(i, arrayList, key, this.blobManager.isUTF8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] mirrorYUV420(byte[] bArr, int i, int i2) {
        if (yuvCache == null) {
            yuvCache = new byte[((i * i2) * 3) / 2];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = i - 1; i5 >= 0; i5--) {
                yuvCache[i3] = bArr[(i4 * i) + i5];
                i3++;
            }
        }
        for (int i6 = i2; i6 < (i2 * 3) / 2; i6++) {
            for (int i7 = i - 2; i7 >= 0; i7 -= 2) {
                byte[] bArr2 = yuvCache;
                int i8 = (i6 * i) + i7;
                bArr2[i3] = bArr[i8];
                int i9 = i3 + 1;
                bArr2[i9] = bArr[i8 + 1];
                i3 = i9 + 1;
            }
        }
        byte[] bArr3 = yuvCache;
        System.arraycopy(bArr3, 0, bArr, 0, bArr3.length);
        return bArr;
    }

    public List<LivenessAction> getLivenessActions() {
        ToygerFaceAlgorithmConfig toygerFaceAlgorithmConfig = this.faceAlgConfig;
        if (toygerFaceAlgorithmConfig != null) {
            return toygerFaceAlgorithmConfig.liveness_action_combination;
        }
        return null;
    }
}
