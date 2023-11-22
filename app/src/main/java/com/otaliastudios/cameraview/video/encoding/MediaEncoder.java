package com.otaliastudios.cameraview.video.encoding;

import android.media.MediaCodec;
import android.os.Build;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.internal.utils.WorkerHandler;
import com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine;
import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes8.dex */
public abstract class MediaEncoder {
    private static final CameraLogger MyBillsEntityDataFactory = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("MediaEncoder");
    private OutputBufferPool DatabaseTableConfigUtil;
    private final String GetContactSyncConfig;
    protected WorkerHandler KClassImpl$Data$declaredNonStaticMembers$2;
    private MediaCodec.BufferInfo NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda8;
    protected MediaCodec PlaceComponentResult;
    long getAuthRequestContext;
    private MediaEncoderEngine.Controller getErrorConfigVersion;
    private MediaCodecBuffers scheduleImpl;
    private int isLayoutRequested = 0;
    private final Map<String, AtomicInteger> NetworkUserEntityData$$ExternalSyntheticLambda2 = new HashMap();
    long BuiltInFictitiousFunctionClassFactory = 0;
    private long lookAheadTest = Long.MIN_VALUE;
    private long initRecordTimeStamp = 0;
    private long moveToNextValue = Long.MIN_VALUE;

    protected abstract void BuiltInFictitiousFunctionClassFactory();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int KClassImpl$Data$declaredNonStaticMembers$2();

    protected abstract void KClassImpl$Data$declaredNonStaticMembers$2(MediaEncoderEngine.Controller controller, long j);

    protected abstract void getAuthRequestContext();

    protected void getAuthRequestContext(String str, Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MediaEncoder(String str) {
        this.GetContactSyncConfig = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PlaceComponentResult(int i) {
        if (this.moveToNextValue == Long.MIN_VALUE) {
            this.moveToNextValue = System.currentTimeMillis();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.moveToNextValue;
        this.moveToNextValue = System.currentTimeMillis();
        String str = null;
        switch (i) {
            case 0:
                str = "NONE";
                break;
            case 1:
                str = "PREPARING";
                break;
            case 2:
                str = "PREPARED";
                break;
            case 3:
                str = "STARTING";
                break;
            case 4:
                str = "STARTED";
                break;
            case 5:
                str = "LIMIT_REACHED";
                break;
            case 6:
                str = "STOPPING";
                break;
            case 7:
                str = "STOPPED";
                break;
        }
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(2, this.GetContactSyncConfig, "setState:", str, "millisSinceLastState:", Long.valueOf(currentTimeMillis - j));
        this.isLayoutRequested = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(final MediaEncoderEngine.Controller controller, final long j) {
        int i = this.isLayoutRequested;
        if (i <= 0) {
            this.getErrorConfigVersion = controller;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new MediaCodec.BufferInfo();
            this.getAuthRequestContext = j;
            WorkerHandler BuiltInFictitiousFunctionClassFactory = WorkerHandler.BuiltInFictitiousFunctionClassFactory(this.GetContactSyncConfig);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setPriority(10);
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, this.GetContactSyncConfig, "Prepare was called. Posting.");
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.post(new Runnable() { // from class: com.otaliastudios.cameraview.video.encoding.MediaEncoder.1
                @Override // java.lang.Runnable
                public void run() {
                    MediaEncoder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, MediaEncoder.this.GetContactSyncConfig, "Prepare was called. Executing.");
                    MediaEncoder.this.PlaceComponentResult(1);
                    MediaEncoder.this.KClassImpl$Data$declaredNonStaticMembers$2(controller, j);
                    MediaEncoder.this.PlaceComponentResult(2);
                }
            });
            return;
        }
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(3, this.GetContactSyncConfig, "Wrong state while preparing. Aborting.", Integer.valueOf(i));
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(2, this.GetContactSyncConfig, "Start was called. Posting.");
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.post(new Runnable() { // from class: com.otaliastudios.cameraview.video.encoding.MediaEncoder.2
            @Override // java.lang.Runnable
            public void run() {
                if (MediaEncoder.this.isLayoutRequested >= 2 && MediaEncoder.this.isLayoutRequested < 3) {
                    MediaEncoder.this.PlaceComponentResult(3);
                    MediaEncoder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(2, MediaEncoder.this.GetContactSyncConfig, "Start was called. Executing.");
                    MediaEncoder.this.getAuthRequestContext();
                    return;
                }
                MediaEncoder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(3, MediaEncoder.this.GetContactSyncConfig, "Wrong state while starting. Aborting.", Integer.valueOf(MediaEncoder.this.isLayoutRequested));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String str, final Object obj) {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda2.containsKey(str)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.put(str, new AtomicInteger(0));
        }
        final AtomicInteger atomicInteger = this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(str);
        atomicInteger.incrementAndGet();
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(0, this.GetContactSyncConfig, "Notify was called. Posting. pendingEvents:", Integer.valueOf(atomicInteger.intValue()));
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.post(new Runnable() { // from class: com.otaliastudios.cameraview.video.encoding.MediaEncoder.3
            @Override // java.lang.Runnable
            public void run() {
                MediaEncoder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(0, MediaEncoder.this.GetContactSyncConfig, "Notify was called. Executing. pendingEvents:", Integer.valueOf(atomicInteger.intValue()));
                MediaEncoder.this.getAuthRequestContext(str, obj);
                atomicInteger.decrementAndGet();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void GetContactSyncConfig() {
        int i = this.isLayoutRequested;
        if (i < 6) {
            PlaceComponentResult(6);
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(2, this.GetContactSyncConfig, "Stop was called. Posting.");
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.post(new Runnable() { // from class: com.otaliastudios.cameraview.video.encoding.MediaEncoder.4
                @Override // java.lang.Runnable
                public void run() {
                    MediaEncoder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(2, MediaEncoder.this.GetContactSyncConfig, "Stop was called. Executing.");
                    MediaEncoder.this.BuiltInFictitiousFunctionClassFactory();
                }
            });
            return;
        }
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(3, this.GetContactSyncConfig, "Wrong state while stopping. Aborting.", Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void PlaceComponentResult() {
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(2, this.GetContactSyncConfig, "is being released. Notifying controller and releasing codecs.");
        final MediaEncoderEngine.Controller controller = this.getErrorConfigVersion;
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        synchronized (MediaEncoderEngine.this.BuiltInFictitiousFunctionClassFactory) {
            MediaEncoderEngine.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(2, "notifyStopped:", "Called for track", Integer.valueOf(i));
            if (MediaEncoderEngine.getAuthRequestContext(MediaEncoderEngine.this) == MediaEncoderEngine.this.MyBillsEntityDataFactory.size()) {
                MediaEncoderEngine.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(2, "requestStop:", "All encoders have been stopped.", "Stopping the muxer.");
                MediaEncoderEngine.this.PlaceComponentResult.MyBillsEntityDataFactory(new Runnable() { // from class: com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Controller.3
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaEncoderEngine.PlaceComponentResult(MediaEncoderEngine.this);
                    }
                });
            }
        }
        this.PlaceComponentResult.stop();
        this.PlaceComponentResult.release();
        this.PlaceComponentResult = null;
        OutputBufferPool outputBufferPool = this.DatabaseTableConfigUtil;
        synchronized (outputBufferPool.MyBillsEntityDataFactory) {
            outputBufferPool.getAuthRequestContext.clear();
        }
        this.DatabaseTableConfigUtil = null;
        this.scheduleImpl = null;
        PlaceComponentResult(7);
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean MyBillsEntityDataFactory(InputBuffer inputBuffer) {
        ByteBuffer byteBuffer;
        if (this.scheduleImpl == null) {
            this.scheduleImpl = new MediaCodecBuffers(this.PlaceComponentResult);
        }
        int dequeueInputBuffer = this.PlaceComponentResult.dequeueInputBuffer(0L);
        if (dequeueInputBuffer < 0) {
            return false;
        }
        inputBuffer.KClassImpl$Data$declaredNonStaticMembers$2 = dequeueInputBuffer;
        MediaCodecBuffers mediaCodecBuffers = this.scheduleImpl;
        if (Build.VERSION.SDK_INT >= 21) {
            byteBuffer = mediaCodecBuffers.BuiltInFictitiousFunctionClassFactory.getInputBuffer(dequeueInputBuffer);
        } else {
            byteBuffer = mediaCodecBuffers.MyBillsEntityDataFactory[dequeueInputBuffer];
            byteBuffer.clear();
        }
        inputBuffer.MyBillsEntityDataFactory = byteBuffer;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(InputBuffer inputBuffer) {
        do {
        } while (!MyBillsEntityDataFactory(inputBuffer));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getAuthRequestContext(InputBuffer inputBuffer) {
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(0, this.GetContactSyncConfig, "ENCODING - Buffer:", Integer.valueOf(inputBuffer.KClassImpl$Data$declaredNonStaticMembers$2), "Bytes:", Integer.valueOf(inputBuffer.getAuthRequestContext), "Presentation:", Long.valueOf(inputBuffer.moveToNextValue));
        if (inputBuffer.BuiltInFictitiousFunctionClassFactory) {
            this.PlaceComponentResult.queueInputBuffer(inputBuffer.KClassImpl$Data$declaredNonStaticMembers$2, 0, 0, inputBuffer.moveToNextValue, 4);
        } else {
            this.PlaceComponentResult.queueInputBuffer(inputBuffer.KClassImpl$Data$declaredNonStaticMembers$2, 0, inputBuffer.getAuthRequestContext, inputBuffer.moveToNextValue, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        ByteBuffer byteBuffer;
        CameraLogger cameraLogger = MyBillsEntityDataFactory;
        cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, this.GetContactSyncConfig, "DRAINING - EOS:", Boolean.valueOf(z));
        MediaCodec mediaCodec = this.PlaceComponentResult;
        if (mediaCodec != null) {
            if (this.scheduleImpl == null) {
                this.scheduleImpl = new MediaCodecBuffers(mediaCodec);
            }
            while (true) {
                int dequeueOutputBuffer = this.PlaceComponentResult.dequeueOutputBuffer(this.NetworkUserEntityData$$ExternalSyntheticLambda0, 0L);
                CameraLogger cameraLogger2 = MyBillsEntityDataFactory;
                cameraLogger2.KClassImpl$Data$declaredNonStaticMembers$2(1, this.GetContactSyncConfig, "DRAINING - Got status:", Integer.valueOf(dequeueOutputBuffer));
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        return;
                    }
                } else if (dequeueOutputBuffer == -3) {
                    MediaCodecBuffers mediaCodecBuffers = this.scheduleImpl;
                    if (Build.VERSION.SDK_INT < 21) {
                        mediaCodecBuffers.KClassImpl$Data$declaredNonStaticMembers$2 = mediaCodecBuffers.BuiltInFictitiousFunctionClassFactory.getOutputBuffers();
                    }
                } else if (dequeueOutputBuffer == -2) {
                    if (this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory()) {
                        throw new RuntimeException("MediaFormat changed twice.");
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda8 = this.getErrorConfigVersion.PlaceComponentResult(this.PlaceComponentResult.getOutputFormat());
                    PlaceComponentResult(4);
                    this.DatabaseTableConfigUtil = new OutputBufferPool(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
                } else if (dequeueOutputBuffer < 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected result from dequeueOutputBuffer: ");
                    sb.append(dequeueOutputBuffer);
                    cameraLogger2.KClassImpl$Data$declaredNonStaticMembers$2(3, sb.toString());
                } else {
                    MediaCodecBuffers mediaCodecBuffers2 = this.scheduleImpl;
                    if (Build.VERSION.SDK_INT >= 21) {
                        byteBuffer = mediaCodecBuffers2.BuiltInFictitiousFunctionClassFactory.getOutputBuffer(dequeueOutputBuffer);
                    } else {
                        byteBuffer = mediaCodecBuffers2.KClassImpl$Data$declaredNonStaticMembers$2[dequeueOutputBuffer];
                    }
                    if (!((this.NetworkUserEntityData$$ExternalSyntheticLambda0.flags & 2) != 0) && this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory() && this.NetworkUserEntityData$$ExternalSyntheticLambda0.size != 0) {
                        byteBuffer.position(this.NetworkUserEntityData$$ExternalSyntheticLambda0.offset);
                        byteBuffer.limit(this.NetworkUserEntityData$$ExternalSyntheticLambda0.offset + this.NetworkUserEntityData$$ExternalSyntheticLambda0.size);
                        if (this.lookAheadTest == Long.MIN_VALUE) {
                            long j = this.NetworkUserEntityData$$ExternalSyntheticLambda0.presentationTimeUs;
                            this.lookAheadTest = j;
                            cameraLogger2.KClassImpl$Data$declaredNonStaticMembers$2(2, this.GetContactSyncConfig, "DRAINING - Got the first presentation time:", Long.valueOf(j));
                        }
                        long j2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.presentationTimeUs;
                        this.initRecordTimeStamp = j2;
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.presentationTimeUs = ((this.BuiltInFictitiousFunctionClassFactory * 1000) + j2) - this.lookAheadTest;
                        cameraLogger2.KClassImpl$Data$declaredNonStaticMembers$2(0, this.GetContactSyncConfig, "DRAINING - About to write(). Adjusted presentation:", Long.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0.presentationTimeUs));
                        OutputBuffer KClassImpl$Data$declaredNonStaticMembers$2 = this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2();
                        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = byteBuffer;
                        MyBillsEntityDataFactory(this.DatabaseTableConfigUtil, KClassImpl$Data$declaredNonStaticMembers$2);
                    }
                    this.PlaceComponentResult.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if (!z && !this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                        long j3 = this.lookAheadTest;
                        if (j3 != Long.MIN_VALUE) {
                            long j4 = this.initRecordTimeStamp;
                            if (j4 - j3 > this.getAuthRequestContext) {
                                cameraLogger2.KClassImpl$Data$declaredNonStaticMembers$2(2, this.GetContactSyncConfig, "DRAINING - Reached maxLength! mLastTimeUs:", Long.valueOf(j4), "mStartTimeUs:", Long.valueOf(this.lookAheadTest), "mDeltaUs:", Long.valueOf(this.initRecordTimeStamp - this.lookAheadTest), "mMaxLengthUs:", Long.valueOf(this.getAuthRequestContext));
                                scheduleImpl();
                                return;
                            }
                        }
                    }
                    if ((this.NetworkUserEntityData$$ExternalSyntheticLambda0.flags & 4) != 0) {
                        cameraLogger2.KClassImpl$Data$declaredNonStaticMembers$2(2, this.GetContactSyncConfig, "DRAINING - Got EOS. Releasing the codec.");
                        PlaceComponentResult();
                        return;
                    }
                }
            }
        } else {
            cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(3, "drain() was called before prepare() or after releasing.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void MyBillsEntityDataFactory(OutputBufferPool outputBufferPool, OutputBuffer outputBuffer) {
        int intValue;
        MediaEncoderEngine.Controller controller = this.getErrorConfigVersion;
        Integer num = controller.KClassImpl$Data$declaredNonStaticMembers$2.get(Integer.valueOf(outputBuffer.BuiltInFictitiousFunctionClassFactory));
        Map<Integer, Integer> map = controller.KClassImpl$Data$declaredNonStaticMembers$2;
        int i = outputBuffer.BuiltInFictitiousFunctionClassFactory;
        if (num == null) {
            intValue = 1;
        } else {
            num = Integer.valueOf(num.intValue() + 1);
            intValue = num.intValue();
        }
        map.put(Integer.valueOf(i), Integer.valueOf(intValue));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(outputBuffer.KClassImpl$Data$declaredNonStaticMembers$2.presentationTimeUs / 1000);
        CameraLogger cameraLogger = MediaEncoderEngine.KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append(calendar.get(13));
        sb.append(":");
        sb.append(calendar.get(14));
        cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(0, "write:", "Writing into muxer -", "track:", Integer.valueOf(outputBuffer.BuiltInFictitiousFunctionClassFactory), "presentation:", Long.valueOf(outputBuffer.KClassImpl$Data$declaredNonStaticMembers$2.presentationTimeUs), "readable:", sb.toString(), "count:", num);
        MediaEncoderEngine.this.moveToNextValue.writeSampleData(outputBuffer.BuiltInFictitiousFunctionClassFactory, outputBuffer.getAuthRequestContext, outputBuffer.KClassImpl$Data$declaredNonStaticMembers$2);
        outputBufferPool.MyBillsEntityDataFactory(outputBuffer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getErrorConfigVersion() {
        scheduleImpl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean moveToNextValue() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void scheduleImpl() {
        int i;
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            int i2 = this.isLayoutRequested;
            if (i2 >= 5) {
                MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(2, this.GetContactSyncConfig, "onMaxLengthReached: Reached in wrong state. Aborting.", Integer.valueOf(i2));
                return;
            }
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(2, this.GetContactSyncConfig, "onMaxLengthReached: Requesting a stop.");
            PlaceComponentResult(5);
            final MediaEncoderEngine.Controller controller = this.getErrorConfigVersion;
            int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            synchronized (MediaEncoderEngine.this.BuiltInFictitiousFunctionClassFactory) {
                MediaEncoderEngine.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(2, "requestStop:", "Called for track", Integer.valueOf(i3));
                if (MediaEncoderEngine.moveToNextValue(MediaEncoderEngine.this) == 0) {
                    MediaEncoderEngine.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(2, "requestStop:", "All encoders have requested a stop.", "Stopping them.");
                    MediaEncoderEngine mediaEncoderEngine = MediaEncoderEngine.this;
                    i = mediaEncoderEngine.scheduleImpl;
                    mediaEncoderEngine.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
                    MediaEncoderEngine.this.PlaceComponentResult.MyBillsEntityDataFactory(new Runnable() { // from class: com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Controller.2
                        @Override // java.lang.Runnable
                        public void run() {
                            MediaEncoderEngine.this.MyBillsEntityDataFactory();
                        }
                    });
                }
            }
            return;
        }
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(2, this.GetContactSyncConfig, "onMaxLengthReached: Called twice.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int MyBillsEntityDataFactory(String str) {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(str).intValue();
    }
}
