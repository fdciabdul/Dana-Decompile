package com.otaliastudios.cameraview.video.encoding;

import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes8.dex */
public class AudioMediaEncoder extends MediaEncoder {
    private static final CameraLogger MyBillsEntityDataFactory = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("AudioMediaEncoder");
    private Map<Long, Long> DatabaseTableConfigUtil;
    private long GetContactSyncConfig;
    private AudioNoise NetworkUserEntityData$$ExternalSyntheticLambda0;
    private InputBufferPool NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final LinkedBlockingQueue<InputBuffer> NetworkUserEntityData$$ExternalSyntheticLambda8;
    private ByteBufferPool getErrorConfigVersion;
    private AudioEncodingThread initRecordTimeStamp;
    private final AudioTimestamp isLayoutRequested;
    private long lookAheadTest;
    private AudioConfig moveToNextValue;
    private AudioRecordingThread newProxyInstance;
    private int scheduleImpl;

    public AudioMediaEncoder(AudioConfig audioConfig) {
        super("AudioEncoder");
        byte b = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new InputBufferPool();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new LinkedBlockingQueue<>();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
        this.scheduleImpl = 0;
        this.GetContactSyncConfig = 0L;
        this.lookAheadTest = 0L;
        this.DatabaseTableConfigUtil = new HashMap();
        AudioConfig audioConfig2 = new AudioConfig();
        audioConfig2.getAuthRequestContext = audioConfig.getAuthRequestContext;
        audioConfig2.MyBillsEntityDataFactory = audioConfig.MyBillsEntityDataFactory;
        audioConfig2.PlaceComponentResult = audioConfig.PlaceComponentResult;
        audioConfig2.getErrorConfigVersion = audioConfig.getErrorConfigVersion;
        audioConfig2.NetworkUserEntityData$$ExternalSyntheticLambda0 = audioConfig.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.moveToNextValue = audioConfig2;
        this.isLayoutRequested = new AudioTimestamp(audioConfig2.KClassImpl$Data$declaredNonStaticMembers$2 * audioConfig2.MyBillsEntityDataFactory);
        this.initRecordTimeStamp = new AudioEncodingThread(this, b);
        this.newProxyInstance = new AudioRecordingThread(this, b);
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(MediaEncoderEngine.Controller controller, long j) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(this.moveToNextValue.getErrorConfigVersion, this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0, this.moveToNextValue.MyBillsEntityDataFactory);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", this.moveToNextValue.BuiltInFictitiousFunctionClassFactory());
        createAudioFormat.setInteger("bitrate", this.moveToNextValue.getAuthRequestContext);
        try {
            if (this.moveToNextValue.PlaceComponentResult != null) {
                this.PlaceComponentResult = MediaCodec.createByCodecName(this.moveToNextValue.PlaceComponentResult);
            } else {
                this.PlaceComponentResult = MediaCodec.createEncoderByType(this.moveToNextValue.getErrorConfigVersion);
            }
            this.PlaceComponentResult.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
            this.PlaceComponentResult.start();
            this.getErrorConfigVersion = new ByteBufferPool(this.moveToNextValue.MyBillsEntityDataFactory * 1024, AudioConfig.KClassImpl$Data$declaredNonStaticMembers$2());
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new AudioNoise(this.moveToNextValue);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    protected final void getAuthRequestContext() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
        this.newProxyInstance.start();
        this.initRecordTimeStamp.start();
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    protected final void BuiltInFictitiousFunctionClassFactory() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    protected final void PlaceComponentResult() {
        super.PlaceComponentResult();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
        this.initRecordTimeStamp = null;
        this.newProxyInstance = null;
        ByteBufferPool byteBufferPool = this.getErrorConfigVersion;
        if (byteBufferPool != null) {
            synchronized (byteBufferPool.MyBillsEntityDataFactory) {
                byteBufferPool.getAuthRequestContext.clear();
            }
            this.getErrorConfigVersion = null;
        }
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    protected final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue.getAuthRequestContext;
    }

    /* loaded from: classes8.dex */
    class AudioRecordingThread extends Thread {
        private ByteBuffer KClassImpl$Data$declaredNonStaticMembers$2;
        private long MyBillsEntityDataFactory;
        private int PlaceComponentResult;
        private AudioRecord getAuthRequestContext;
        private long scheduleImpl;

        /* synthetic */ AudioRecordingThread(AudioMediaEncoder audioMediaEncoder, byte b) {
            this();
        }

        private AudioRecordingThread() {
            this.MyBillsEntityDataFactory = Long.MIN_VALUE;
            setPriority(10);
            int i = AudioMediaEncoder.this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int BuiltInFictitiousFunctionClassFactory = AudioMediaEncoder.this.moveToNextValue.BuiltInFictitiousFunctionClassFactory();
            AudioConfig unused = AudioMediaEncoder.this.moveToNextValue;
            int minBufferSize = AudioRecord.getMinBufferSize(i, BuiltInFictitiousFunctionClassFactory, 2);
            int i2 = AudioMediaEncoder.this.moveToNextValue.MyBillsEntityDataFactory * 1024;
            AudioConfig unused2 = AudioMediaEncoder.this.moveToNextValue;
            int authRequestContext = i2 * AudioConfig.getAuthRequestContext();
            while (authRequestContext < minBufferSize) {
                authRequestContext += AudioMediaEncoder.this.moveToNextValue.MyBillsEntityDataFactory * 1024;
            }
            int i3 = AudioMediaEncoder.this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int BuiltInFictitiousFunctionClassFactory2 = AudioMediaEncoder.this.moveToNextValue.BuiltInFictitiousFunctionClassFactory();
            AudioConfig unused3 = AudioMediaEncoder.this.moveToNextValue;
            this.getAuthRequestContext = new AudioRecord(5, i3, BuiltInFictitiousFunctionClassFactory2, 2, authRequestContext);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            boolean z;
            this.getAuthRequestContext.startRecording();
            while (true) {
                z = false;
                if (AudioMediaEncoder.this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
                    break;
                } else if (!AudioMediaEncoder.this.moveToNextValue()) {
                    getAuthRequestContext(false);
                }
            }
            AudioMediaEncoder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(2, "Stop was requested. We're out of the loop. Will post an endOfStream.");
            while (!z) {
                z = getAuthRequestContext(true);
            }
            this.getAuthRequestContext.stop();
            this.getAuthRequestContext.release();
            this.getAuthRequestContext = null;
        }

        private boolean getAuthRequestContext(boolean z) {
            ByteBuffer KClassImpl$Data$declaredNonStaticMembers$2 = AudioMediaEncoder.this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2;
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                if (z) {
                    AudioMediaEncoder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(0, "read thread - eos: true - No buffer, retrying.");
                } else {
                    AudioMediaEncoder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(2, "read thread - eos: false - Skipping audio frame,", "encoding is too slow.");
                    AudioMediaEncoder.BuiltInFictitiousFunctionClassFactory(AudioMediaEncoder.this, 6);
                }
                return false;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.clear();
            this.PlaceComponentResult = this.getAuthRequestContext.read(this.KClassImpl$Data$declaredNonStaticMembers$2, AudioMediaEncoder.this.moveToNextValue.MyBillsEntityDataFactory * 1024);
            AudioMediaEncoder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(0, "read thread - eos:", Boolean.valueOf(z), "- Read new audio frame. Bytes:", Integer.valueOf(this.PlaceComponentResult));
            int i = this.PlaceComponentResult;
            if (i <= 0) {
                if (i == -3) {
                    AudioMediaEncoder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(3, "read thread - eos:", Boolean.valueOf(z), "- Got AudioRecord.ERROR_INVALID_OPERATION");
                    return true;
                } else if (i == -2) {
                    AudioMediaEncoder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(3, "read thread - eos:", Boolean.valueOf(z), "- Got AudioRecord.ERROR_BAD_VALUE");
                    return true;
                } else {
                    return true;
                }
            }
            AudioTimestamp audioTimestamp = AudioMediaEncoder.this.isLayoutRequested;
            long j = i;
            long MyBillsEntityDataFactory = AudioTimestamp.MyBillsEntityDataFactory(j, audioTimestamp.BuiltInFictitiousFunctionClassFactory);
            long nanoTime = (System.nanoTime() / 1000) - MyBillsEntityDataFactory;
            long j2 = audioTimestamp.getAuthRequestContext;
            if (j2 == 0) {
                audioTimestamp.KClassImpl$Data$declaredNonStaticMembers$2 = nanoTime;
            }
            long MyBillsEntityDataFactory2 = audioTimestamp.KClassImpl$Data$declaredNonStaticMembers$2 + AudioTimestamp.MyBillsEntityDataFactory(j2, audioTimestamp.BuiltInFictitiousFunctionClassFactory);
            long j3 = nanoTime - MyBillsEntityDataFactory2;
            if (j3 >= MyBillsEntityDataFactory * 2) {
                audioTimestamp.KClassImpl$Data$declaredNonStaticMembers$2 = nanoTime;
                audioTimestamp.getAuthRequestContext = j;
                audioTimestamp.MyBillsEntityDataFactory = j3;
            } else {
                audioTimestamp.MyBillsEntityDataFactory = 0L;
                audioTimestamp.getAuthRequestContext += j;
                nanoTime = MyBillsEntityDataFactory2;
            }
            this.scheduleImpl = nanoTime;
            if (this.MyBillsEntityDataFactory == Long.MIN_VALUE) {
                this.MyBillsEntityDataFactory = nanoTime;
                AudioMediaEncoder audioMediaEncoder = AudioMediaEncoder.this;
                long currentTimeMillis = System.currentTimeMillis();
                AudioConfig audioConfig = AudioMediaEncoder.this.moveToNextValue;
                audioMediaEncoder.BuiltInFictitiousFunctionClassFactory = currentTimeMillis - AudioTimestamp.getAuthRequestContext(j, audioConfig.KClassImpl$Data$declaredNonStaticMembers$2 * audioConfig.MyBillsEntityDataFactory);
            }
            if (!AudioMediaEncoder.this.moveToNextValue()) {
                if ((this.scheduleImpl - this.MyBillsEntityDataFactory > AudioMediaEncoder.this.getAuthRequestContext) && !z) {
                    AudioMediaEncoder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(2, "read thread - this frame reached the maxLength! deltaUs:", Long.valueOf(this.scheduleImpl - this.MyBillsEntityDataFactory));
                    AudioMediaEncoder.this.scheduleImpl();
                }
            }
            AudioTimestamp audioTimestamp2 = AudioMediaEncoder.this.isLayoutRequested;
            int MyBillsEntityDataFactory3 = audioTimestamp2.MyBillsEntityDataFactory == 0 ? 0 : (int) (audioTimestamp2.MyBillsEntityDataFactory / AudioTimestamp.MyBillsEntityDataFactory(AudioMediaEncoder.this.moveToNextValue.MyBillsEntityDataFactory * 1024, audioTimestamp2.BuiltInFictitiousFunctionClassFactory));
            if (MyBillsEntityDataFactory3 > 0) {
                long j4 = this.scheduleImpl - AudioMediaEncoder.this.isLayoutRequested.MyBillsEntityDataFactory;
                long j5 = AudioMediaEncoder.this.moveToNextValue.MyBillsEntityDataFactory * 1024;
                AudioConfig audioConfig2 = AudioMediaEncoder.this.moveToNextValue;
                long MyBillsEntityDataFactory4 = AudioTimestamp.MyBillsEntityDataFactory(j5, audioConfig2.KClassImpl$Data$declaredNonStaticMembers$2 * audioConfig2.MyBillsEntityDataFactory);
                int i2 = 8;
                AudioMediaEncoder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(2, "read thread - GAPS: trying to add", Integer.valueOf(MyBillsEntityDataFactory3), "noise buffers. PERFORMANCE_MAX_GAPS:", 8);
                int i3 = 0;
                while (true) {
                    if (i3 >= Math.min(MyBillsEntityDataFactory3, i2)) {
                        break;
                    }
                    ByteBuffer KClassImpl$Data$declaredNonStaticMembers$22 = AudioMediaEncoder.this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2();
                    if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
                        KClassImpl$Data$declaredNonStaticMembers$22.clear();
                        AudioNoise audioNoise = AudioMediaEncoder.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        audioNoise.BuiltInFictitiousFunctionClassFactory.clear();
                        if (audioNoise.BuiltInFictitiousFunctionClassFactory.capacity() == KClassImpl$Data$declaredNonStaticMembers$22.remaining()) {
                            audioNoise.BuiltInFictitiousFunctionClassFactory.position(0);
                        } else {
                            ByteBuffer byteBuffer = audioNoise.BuiltInFictitiousFunctionClassFactory;
                            byteBuffer.position(AudioNoise.PlaceComponentResult.nextInt(byteBuffer.capacity() - KClassImpl$Data$declaredNonStaticMembers$22.remaining()));
                        }
                        ByteBuffer byteBuffer2 = audioNoise.BuiltInFictitiousFunctionClassFactory;
                        byteBuffer2.limit(byteBuffer2.position() + KClassImpl$Data$declaredNonStaticMembers$22.remaining());
                        KClassImpl$Data$declaredNonStaticMembers$22.put(audioNoise.BuiltInFictitiousFunctionClassFactory);
                        KClassImpl$Data$declaredNonStaticMembers$22.rewind();
                        MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$22, j4, false);
                        j4 += MyBillsEntityDataFactory4;
                        i3++;
                        i2 = 8;
                    } else {
                        AudioMediaEncoder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(3, "read thread - GAPS: aborting because we have no free buffer.");
                        break;
                    }
                }
            }
            AudioMediaEncoder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(0, "read thread - eos:", Boolean.valueOf(z), "- mLastTimeUs:", Long.valueOf(this.scheduleImpl));
            this.KClassImpl$Data$declaredNonStaticMembers$2.limit(this.PlaceComponentResult);
            MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.scheduleImpl, z);
            return true;
        }

        private void MyBillsEntityDataFactory(ByteBuffer byteBuffer, long j, boolean z) {
            int remaining = byteBuffer.remaining();
            InputBuffer KClassImpl$Data$declaredNonStaticMembers$2 = AudioMediaEncoder.this.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = byteBuffer;
            KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = j;
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = remaining;
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = z;
            AudioMediaEncoder.this.NetworkUserEntityData$$ExternalSyntheticLambda8.add(KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    /* loaded from: classes8.dex */
    class AudioEncodingThread extends Thread {
        /* synthetic */ AudioEncodingThread(AudioMediaEncoder audioMediaEncoder, byte b) {
            this();
        }

        private AudioEncodingThread() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0000, code lost:
        
            continue;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r6 = this;
            L0:
                com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder r0 = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this
                java.util.concurrent.LinkedBlockingQueue r0 = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.scheduleImpl(r0)
                boolean r0 = r0.isEmpty()
                r1 = 3
                if (r0 == 0) goto L13
                com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder r0 = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this
                com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.BuiltInFictitiousFunctionClassFactory(r0, r1)
                goto L0
            L13:
                com.otaliastudios.cameraview.CameraLogger r0 = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.MyBillsEntityDataFactory()
                java.lang.Object[] r2 = new java.lang.Object[r1]
                java.lang.String r3 = "encoding thread - performing"
                r4 = 0
                r2[r4] = r3
                r3 = 1
                com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder r5 = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this
                java.util.concurrent.LinkedBlockingQueue r5 = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.scheduleImpl(r5)
                int r5 = r5.size()
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                r2[r3] = r5
                r3 = 2
                java.lang.String r5 = "pending operations."
                r2[r3] = r5
                r0.KClassImpl$Data$declaredNonStaticMembers$2(r4, r2)
            L37:
                com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder r0 = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this
                java.util.concurrent.LinkedBlockingQueue r0 = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.scheduleImpl(r0)
                java.lang.Object r0 = r0.peek()
                com.otaliastudios.cameraview.video.encoding.InputBuffer r0 = (com.otaliastudios.cameraview.video.encoding.InputBuffer) r0
                if (r0 == 0) goto L0
                boolean r2 = r0.BuiltInFictitiousFunctionClassFactory
                if (r2 == 0) goto L64
                com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder r1 = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this
                r1.KClassImpl$Data$declaredNonStaticMembers$2(r0)
                r6.BuiltInFictitiousFunctionClassFactory(r0)
                com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder r0 = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this
                com.otaliastudios.cameraview.video.encoding.InputBufferPool r0 = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.moveToNextValue(r0)
                java.lang.Object r1 = r0.MyBillsEntityDataFactory
                monitor-enter(r1)
                java.util.concurrent.LinkedBlockingQueue<T> r0 = r0.getAuthRequestContext     // Catch: java.lang.Throwable -> L61
                r0.clear()     // Catch: java.lang.Throwable -> L61
                monitor-exit(r1)
                return
            L61:
                r0 = move-exception
                monitor-exit(r1)
                throw r0
            L64:
                com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder r2 = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this
                boolean r2 = r2.MyBillsEntityDataFactory(r0)
                if (r2 == 0) goto L70
                r6.BuiltInFictitiousFunctionClassFactory(r0)
                goto L37
            L70:
                com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder r0 = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this
                com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.BuiltInFictitiousFunctionClassFactory(r0, r1)
                goto L37
            */
            throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.AudioEncodingThread.run():void");
        }

        private void BuiltInFictitiousFunctionClassFactory(InputBuffer inputBuffer) {
            long nanoTime = System.nanoTime() / 1000000;
            AudioMediaEncoder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(0, "encoding thread - performing pending operation for timestamp:", Long.valueOf(inputBuffer.moveToNextValue), "- encoding.");
            inputBuffer.MyBillsEntityDataFactory.put(inputBuffer.PlaceComponentResult);
            AudioMediaEncoder.this.getErrorConfigVersion.MyBillsEntityDataFactory(inputBuffer.PlaceComponentResult);
            AudioMediaEncoder.this.NetworkUserEntityData$$ExternalSyntheticLambda8.remove(inputBuffer);
            AudioMediaEncoder.this.getAuthRequestContext(inputBuffer);
            boolean z = inputBuffer.BuiltInFictitiousFunctionClassFactory;
            AudioMediaEncoder.this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory(inputBuffer);
            AudioMediaEncoder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(0, "encoding thread - performing pending operation for timestamp:", Long.valueOf(inputBuffer.moveToNextValue), "- draining.");
            AudioMediaEncoder.this.KClassImpl$Data$declaredNonStaticMembers$2(z);
        }
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(AudioMediaEncoder audioMediaEncoder, int i) {
        try {
            long j = audioMediaEncoder.moveToNextValue.MyBillsEntityDataFactory * 1024 * i;
            AudioConfig audioConfig = audioMediaEncoder.moveToNextValue;
            Thread.sleep(AudioTimestamp.getAuthRequestContext(j, audioConfig.KClassImpl$Data$declaredNonStaticMembers$2 * audioConfig.MyBillsEntityDataFactory));
        } catch (InterruptedException unused) {
        }
    }
}
