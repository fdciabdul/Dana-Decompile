package com.otaliastudios.cameraview.video.encoding;

import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.internal.utils.WorkerHandler;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes8.dex */
public class MediaEncoderEngine {
    public static final CameraLogger KClassImpl$Data$declaredNonStaticMembers$2 = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("MediaEncoderEngine");
    private final Object BuiltInFictitiousFunctionClassFactory;
    private int DatabaseTableConfigUtil;
    public final List<MediaEncoder> MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final WorkerHandler PlaceComponentResult;
    private final Controller getAuthRequestContext;
    private boolean getErrorConfigVersion;
    private int initRecordTimeStamp;
    private Listener lookAheadTest;
    private MediaMuxer moveToNextValue;
    private int scheduleImpl;

    /* loaded from: classes8.dex */
    public interface Listener {
        void MyBillsEntityDataFactory();

        void PlaceComponentResult(int i, Exception exc);
    }

    static /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(MediaEncoderEngine mediaEncoderEngine) {
        mediaEncoderEngine.getErrorConfigVersion = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int getAuthRequestContext(MediaEncoderEngine mediaEncoderEngine) {
        int i = mediaEncoderEngine.DatabaseTableConfigUtil + 1;
        mediaEncoderEngine.DatabaseTableConfigUtil = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int moveToNextValue(MediaEncoderEngine mediaEncoderEngine) {
        int i = mediaEncoderEngine.initRecordTimeStamp - 1;
        mediaEncoderEngine.initRecordTimeStamp = i;
        return i;
    }

    static /* synthetic */ int scheduleImpl(MediaEncoderEngine mediaEncoderEngine) {
        int i = mediaEncoderEngine.initRecordTimeStamp + 1;
        mediaEncoderEngine.initRecordTimeStamp = i;
        return i;
    }

    public MediaEncoderEngine(File file, VideoMediaEncoder videoMediaEncoder, AudioMediaEncoder audioMediaEncoder, int i, long j, Listener listener) {
        ArrayList arrayList = new ArrayList();
        this.MyBillsEntityDataFactory = arrayList;
        this.initRecordTimeStamp = 0;
        this.DatabaseTableConfigUtil = 0;
        this.getErrorConfigVersion = false;
        this.getAuthRequestContext = new Controller();
        this.PlaceComponentResult = WorkerHandler.BuiltInFictitiousFunctionClassFactory("EncoderEngine");
        this.BuiltInFictitiousFunctionClassFactory = new Object();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
        this.lookAheadTest = listener;
        arrayList.add(videoMediaEncoder);
        if (audioMediaEncoder != null) {
            arrayList.add(audioMediaEncoder);
        }
        try {
            this.moveToNextValue = new MediaMuxer(file.toString(), 0);
            Iterator it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                i2 += ((MediaEncoder) it.next()).KClassImpl$Data$declaredNonStaticMembers$2();
            }
            long j2 = (j / (i2 / 8)) * 1000 * 1000;
            long j3 = i * 1000;
            if (j > 0 && i > 0) {
                this.scheduleImpl = j2 < j3 ? 2 : 1;
                j2 = Math.min(j2, j3);
            } else if (j > 0) {
                this.scheduleImpl = 2;
            } else if (i > 0) {
                this.scheduleImpl = 1;
                j2 = j3;
            } else {
                j2 = LongCompanionObject.MAX_VALUE;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(2, "Computed a max duration of", Float.valueOf(((float) j2) / 1000000.0f));
            Iterator<MediaEncoder> it2 = this.MyBillsEntityDataFactory.iterator();
            while (it2.hasNext()) {
                it2.next().MyBillsEntityDataFactory(this.getAuthRequestContext, j2);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public final void PlaceComponentResult(String str, Object obj) {
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(0, "Passing event to encoders:", str);
        Iterator<MediaEncoder> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            it.next().KClassImpl$Data$declaredNonStaticMembers$2(str, obj);
        }
    }

    public final void MyBillsEntityDataFactory() {
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "Passing event to encoders:", "STOP");
        Iterator<MediaEncoder> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            it.next().GetContactSyncConfig();
        }
        Listener listener = this.lookAheadTest;
        if (listener != null) {
            listener.MyBillsEntityDataFactory();
        }
    }

    /* loaded from: classes8.dex */
    public class Controller {
        Map<Integer, Integer> KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap();

        public Controller() {
        }

        public final int PlaceComponentResult(MediaFormat mediaFormat) {
            int addTrack;
            synchronized (MediaEncoderEngine.this.BuiltInFictitiousFunctionClassFactory) {
                if (!MediaEncoderEngine.this.getErrorConfigVersion) {
                    addTrack = MediaEncoderEngine.this.moveToNextValue.addTrack(mediaFormat);
                    MediaEncoderEngine.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(2, "notifyStarted:", "Assigned track", Integer.valueOf(addTrack), "to format", mediaFormat.getString("mime"));
                    if (MediaEncoderEngine.scheduleImpl(MediaEncoderEngine.this) == MediaEncoderEngine.this.MyBillsEntityDataFactory.size()) {
                        MediaEncoderEngine.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(2, "notifyStarted:", "All encoders have started.", "Starting muxer and dispatching onEncodingStart().");
                        MediaEncoderEngine.this.PlaceComponentResult.MyBillsEntityDataFactory(new Runnable() { // from class: com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Controller.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MediaEncoderEngine.this.moveToNextValue.start();
                                MediaEncoderEngine.BuiltInFictitiousFunctionClassFactory(MediaEncoderEngine.this);
                                if (MediaEncoderEngine.this.lookAheadTest != null) {
                                    Listener unused = MediaEncoderEngine.this.lookAheadTest;
                                }
                            }
                        });
                    }
                } else {
                    throw new IllegalStateException("Trying to start but muxer started already");
                }
            }
            return addTrack;
        }

        public final boolean BuiltInFictitiousFunctionClassFactory() {
            boolean z;
            synchronized (MediaEncoderEngine.this.BuiltInFictitiousFunctionClassFactory) {
                z = MediaEncoderEngine.this.getErrorConfigVersion;
            }
            return z;
        }
    }

    static /* synthetic */ void PlaceComponentResult(MediaEncoderEngine mediaEncoderEngine) {
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "end:", "Releasing muxer after all encoders have been released.");
        MediaMuxer mediaMuxer = mediaEncoderEngine.moveToNextValue;
        if (mediaMuxer != null) {
            try {
                mediaMuxer.stop();
                e = null;
            } catch (Exception e) {
                e = e;
            }
            try {
                mediaEncoderEngine.moveToNextValue.release();
            } catch (Exception e2) {
                if (e == null) {
                    e = e2;
                }
            }
            mediaEncoderEngine.moveToNextValue = null;
        } else {
            e = null;
        }
        CameraLogger cameraLogger = KClassImpl$Data$declaredNonStaticMembers$2;
        cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(2, "end:", "Dispatching end to listener - reason:", Integer.valueOf(mediaEncoderEngine.NetworkUserEntityData$$ExternalSyntheticLambda0), "error:", e);
        Listener listener = mediaEncoderEngine.lookAheadTest;
        if (listener != null) {
            listener.PlaceComponentResult(mediaEncoderEngine.NetworkUserEntityData$$ExternalSyntheticLambda0, e);
            mediaEncoderEngine.lookAheadTest = null;
        }
        mediaEncoderEngine.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
        mediaEncoderEngine.initRecordTimeStamp = 0;
        mediaEncoderEngine.DatabaseTableConfigUtil = 0;
        mediaEncoderEngine.getErrorConfigVersion = false;
        mediaEncoderEngine.PlaceComponentResult.MyBillsEntityDataFactory();
        cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "end:", "Completed.");
    }
}
