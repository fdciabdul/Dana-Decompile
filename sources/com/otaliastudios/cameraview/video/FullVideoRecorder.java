package com.otaliastudios.cameraview.video;

import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.VideoResult;
import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.controls.VideoCodec;
import com.otaliastudios.cameraview.internal.DeviceEncoders;
import com.otaliastudios.cameraview.size.Size;
import com.otaliastudios.cameraview.video.VideoRecorder;
import id.dana.data.foundation.logger.log.LoginTrackingConstants;

/* loaded from: classes8.dex */
public abstract class FullVideoRecorder extends VideoRecorder {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private CamcorderProfile NetworkUserEntityData$$ExternalSyntheticLambda0;
    protected MediaRecorder getAuthRequestContext;
    public static final byte[] MyBillsEntityDataFactory = {SignedBytes.MAX_POWER_OF_TWO, 19, 79, -17, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 121;
    protected static final CameraLogger PlaceComponentResult = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("FullVideoRecorder");

    private static void a(int i, short s, int i2, Object[] objArr) {
        int i3 = 16 - (i2 * 3);
        byte[] bArr = MyBillsEntityDataFactory;
        int i4 = s + 4;
        int i5 = 106 - (i * 7);
        byte[] bArr2 = new byte[i3];
        int i6 = -1;
        int i7 = i3 - 1;
        if (bArr == null) {
            i5 = i4 + i5 + 2;
            i4 = i4;
            i7 = i7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = -1;
        }
        while (true) {
            int i8 = i6 + 1;
            int i9 = i4 + 1;
            bArr2[i8] = (byte) i5;
            if (i8 == i7) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i5 = i5 + bArr[i9] + 2;
            i4 = i9;
            i7 = i7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = i8;
        }
    }

    protected abstract CamcorderProfile KClassImpl$Data$declaredNonStaticMembers$2(VideoResult.Stub stub);

    protected abstract void MyBillsEntityDataFactory(MediaRecorder mediaRecorder);

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullVideoRecorder(VideoRecorder.VideoResultListener videoResultListener) {
        super(videoResultListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean MyBillsEntityDataFactory(VideoResult.Stub stub) {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            return true;
        }
        return KClassImpl$Data$declaredNonStaticMembers$2(stub, true);
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(VideoResult.Stub stub, boolean z) {
        int i;
        boolean z2;
        int i2;
        int i3;
        String str;
        String str2;
        String str3;
        boolean z3 = z;
        while (true) {
            CameraLogger cameraLogger = PlaceComponentResult;
            Object[] objArr = new Object[3];
            objArr[0] = "prepareMediaRecorder:";
            int i4 = 1;
            objArr[1] = "Preparing on thread";
            try {
                Object[] objArr2 = new Object[1];
                a((byte) (MyBillsEntityDataFactory[15] - 1), MyBillsEntityDataFactory[22], (byte) (MyBillsEntityDataFactory[15] - 1), objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b = MyBillsEntityDataFactory[15];
                Object[] objArr3 = new Object[1];
                a(b, (byte) (-b), MyBillsEntityDataFactory[15], objArr3);
                char c = 2;
                objArr[2] = cls.getMethod((String) objArr3[0], null).invoke(null, null);
                cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, objArr);
                this.getAuthRequestContext = new MediaRecorder();
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = KClassImpl$Data$declaredNonStaticMembers$2(stub);
                MyBillsEntityDataFactory(this.getAuthRequestContext);
                if (stub.BuiltInFictitiousFunctionClassFactory == Audio.ON) {
                    i = this.NetworkUserEntityData$$ExternalSyntheticLambda0.audioChannels;
                } else if (stub.BuiltInFictitiousFunctionClassFactory == Audio.MONO) {
                    i = 1;
                } else {
                    i = stub.BuiltInFictitiousFunctionClassFactory == Audio.STEREO ? 2 : 0;
                }
                z2 = i > 0;
                if (z2) {
                    this.getAuthRequestContext.setAudioSource(0);
                }
                if (stub.NetworkUserEntityData$$ExternalSyntheticLambda2 == VideoCodec.H_264) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.videoCodec = 2;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.fileFormat = 2;
                } else if (stub.NetworkUserEntityData$$ExternalSyntheticLambda2 == VideoCodec.H_263) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.videoCodec = 1;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.fileFormat = 2;
                }
                this.getAuthRequestContext.setOutputFormat(this.NetworkUserEntityData$$ExternalSyntheticLambda0.fileFormat);
                if (stub.NetworkUserEntityData$$ExternalSyntheticLambda1 <= 0) {
                    stub.NetworkUserEntityData$$ExternalSyntheticLambda1 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.videoFrameRate;
                }
                if (stub.GetContactSyncConfig <= 0) {
                    stub.GetContactSyncConfig = this.NetworkUserEntityData$$ExternalSyntheticLambda0.videoBitRate;
                }
                if (stub.KClassImpl$Data$declaredNonStaticMembers$2 <= 0 && z2) {
                    stub.KClassImpl$Data$declaredNonStaticMembers$2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.audioBitRate;
                }
                if (!z3) {
                    break;
                }
                int i5 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.audioCodec;
                int i6 = 6;
                String str4 = i5 != 2 ? (i5 == 3 || i5 == 4 || i5 == 5) ? "audio/mp4a-latm" : i5 != 6 ? "audio/3gpp" : "audio/vorbis" : "audio/amr-wb";
                int i7 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.videoCodec;
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 == 3) {
                            str = "video/mp4v-es";
                        } else if (i7 == 4) {
                            str = "video/x-vnd.on2.vp8";
                        } else if (i7 == 5) {
                            str = "video/hevc";
                        }
                    }
                    str = "video/avc";
                } else {
                    str = "video/3gpp";
                }
                String str5 = str;
                boolean z4 = stub.initRecordTimeStamp % 180 != 0;
                if (z4) {
                    Size size = stub.DatabaseTableConfigUtil;
                    stub.DatabaseTableConfigUtil = new Size(size.getAuthRequestContext, size.BuiltInFictitiousFunctionClassFactory);
                }
                boolean z5 = false;
                Size size2 = null;
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                int i11 = 0;
                int i12 = 0;
                while (!z5) {
                    CameraLogger cameraLogger2 = PlaceComponentResult;
                    Object[] objArr4 = new Object[i6];
                    objArr4[0] = "prepareMediaRecorder:";
                    objArr4[i4] = "Checking DeviceEncoders...";
                    objArr4[c] = "videoOffset:";
                    objArr4[3] = Integer.valueOf(i11);
                    objArr4[4] = "audioOffset:";
                    objArr4[5] = Integer.valueOf(i12);
                    cameraLogger2.KClassImpl$Data$declaredNonStaticMembers$2(i4, objArr4);
                    try {
                        String str6 = str5;
                        String str7 = str4;
                        DeviceEncoders deviceEncoders = new DeviceEncoders(0, str6, str7, i11, i12);
                        try {
                            size2 = deviceEncoders.PlaceComponentResult(stub.DatabaseTableConfigUtil);
                            int BuiltInFictitiousFunctionClassFactory = deviceEncoders.BuiltInFictitiousFunctionClassFactory(stub.GetContactSyncConfig);
                            try {
                                int BuiltInFictitiousFunctionClassFactory2 = deviceEncoders.BuiltInFictitiousFunctionClassFactory(size2, stub.NetworkUserEntityData$$ExternalSyntheticLambda1);
                                str2 = str6;
                                try {
                                    deviceEncoders.getAuthRequestContext(str2, size2, BuiltInFictitiousFunctionClassFactory2, BuiltInFictitiousFunctionClassFactory);
                                    if (z2) {
                                        int PlaceComponentResult2 = deviceEncoders.PlaceComponentResult(stub.KClassImpl$Data$declaredNonStaticMembers$2);
                                        try {
                                            str3 = str7;
                                            try {
                                                deviceEncoders.MyBillsEntityDataFactory(str3, PlaceComponentResult2, this.NetworkUserEntityData$$ExternalSyntheticLambda0.audioSampleRate, i);
                                                i9 = PlaceComponentResult2;
                                            } catch (DeviceEncoders.AudioException e) {
                                                e = e;
                                                i8 = BuiltInFictitiousFunctionClassFactory;
                                                i9 = PlaceComponentResult2;
                                                i10 = BuiltInFictitiousFunctionClassFactory2;
                                                PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, "prepareMediaRecorder:", "Got AudioException:", e.getMessage());
                                                i12++;
                                                str5 = str2;
                                                c = 2;
                                                i6 = 6;
                                                str4 = str3;
                                                i4 = 1;
                                            } catch (DeviceEncoders.VideoException e2) {
                                                e = e2;
                                                i8 = BuiltInFictitiousFunctionClassFactory;
                                                i9 = PlaceComponentResult2;
                                                i10 = BuiltInFictitiousFunctionClassFactory2;
                                                PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, "prepareMediaRecorder:", "Got VideoException:", e.getMessage());
                                                i11++;
                                                str5 = str2;
                                                c = 2;
                                                i6 = 6;
                                                str4 = str3;
                                                i4 = 1;
                                            }
                                        } catch (DeviceEncoders.AudioException e3) {
                                            e = e3;
                                            str3 = str7;
                                        } catch (DeviceEncoders.VideoException e4) {
                                            e = e4;
                                            str3 = str7;
                                        }
                                    } else {
                                        str3 = str7;
                                    }
                                    i8 = BuiltInFictitiousFunctionClassFactory;
                                    i10 = BuiltInFictitiousFunctionClassFactory2;
                                    str5 = str2;
                                    z5 = true;
                                } catch (DeviceEncoders.AudioException e5) {
                                    e = e5;
                                    str3 = str7;
                                    i8 = BuiltInFictitiousFunctionClassFactory;
                                } catch (DeviceEncoders.VideoException e6) {
                                    e = e6;
                                    str3 = str7;
                                    i8 = BuiltInFictitiousFunctionClassFactory;
                                }
                            } catch (DeviceEncoders.AudioException e7) {
                                e = e7;
                                str2 = str6;
                                str3 = str7;
                                i8 = BuiltInFictitiousFunctionClassFactory;
                            } catch (DeviceEncoders.VideoException e8) {
                                e = e8;
                                str2 = str6;
                                str3 = str7;
                                i8 = BuiltInFictitiousFunctionClassFactory;
                            }
                        } catch (DeviceEncoders.AudioException e9) {
                            e = e9;
                            str2 = str6;
                            str3 = str7;
                        } catch (DeviceEncoders.VideoException e10) {
                            e = e10;
                            str2 = str6;
                            str3 = str7;
                        }
                        c = 2;
                        i6 = 6;
                        str4 = str3;
                        i4 = 1;
                    } catch (RuntimeException unused) {
                        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(2, "prepareMediaRecorder:", "Could not respect encoders parameters.", "Trying again without checking encoders.");
                        z3 = false;
                    }
                }
                stub.DatabaseTableConfigUtil = size2;
                stub.GetContactSyncConfig = i8;
                stub.KClassImpl$Data$declaredNonStaticMembers$2 = i9;
                stub.NetworkUserEntityData$$ExternalSyntheticLambda1 = i10;
                if (z4) {
                    Size size3 = stub.DatabaseTableConfigUtil;
                    stub.DatabaseTableConfigUtil = new Size(size3.getAuthRequestContext, size3.BuiltInFictitiousFunctionClassFactory);
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        boolean z6 = stub.initRecordTimeStamp % 180 != 0;
        MediaRecorder mediaRecorder = this.getAuthRequestContext;
        if (z6) {
            i2 = stub.DatabaseTableConfigUtil.getAuthRequestContext;
        } else {
            i2 = stub.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory;
        }
        if (z6) {
            i3 = stub.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory;
        } else {
            i3 = stub.DatabaseTableConfigUtil.getAuthRequestContext;
        }
        mediaRecorder.setVideoSize(i2, i3);
        this.getAuthRequestContext.setVideoFrameRate(stub.NetworkUserEntityData$$ExternalSyntheticLambda1);
        this.getAuthRequestContext.setVideoEncoder(this.NetworkUserEntityData$$ExternalSyntheticLambda0.videoCodec);
        this.getAuthRequestContext.setVideoEncodingBitRate(stub.GetContactSyncConfig);
        if (z2) {
            this.getAuthRequestContext.setAudioChannels(i);
            this.getAuthRequestContext.setAudioSamplingRate(this.NetworkUserEntityData$$ExternalSyntheticLambda0.audioSampleRate);
            this.getAuthRequestContext.setAudioEncoder(this.NetworkUserEntityData$$ExternalSyntheticLambda0.audioCodec);
            this.getAuthRequestContext.setAudioEncodingBitRate(stub.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        if (stub.getErrorConfigVersion != null) {
            this.getAuthRequestContext.setLocation((float) stub.getErrorConfigVersion.getLatitude(), (float) stub.getErrorConfigVersion.getLongitude());
        }
        if (stub.MyBillsEntityDataFactory != null) {
            this.getAuthRequestContext.setOutputFile(stub.MyBillsEntityDataFactory.getAbsolutePath());
        } else if (stub.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            this.getAuthRequestContext.setOutputFile(stub.NetworkUserEntityData$$ExternalSyntheticLambda0);
        } else {
            throw new IllegalStateException("file and fileDescriptor are both null.");
        }
        this.getAuthRequestContext.setOrientationHint(stub.initRecordTimeStamp);
        MediaRecorder mediaRecorder2 = this.getAuthRequestContext;
        long j = stub.moveToNextValue;
        long j2 = stub.moveToNextValue;
        if (j > 0) {
            double d = j2;
            Double.isNaN(d);
            j2 = Math.round(d / 0.9d);
        }
        mediaRecorder2.setMaxFileSize(j2);
        CameraLogger cameraLogger3 = PlaceComponentResult;
        double d2 = stub.moveToNextValue;
        Double.isNaN(d2);
        cameraLogger3.KClassImpl$Data$declaredNonStaticMembers$2(1, "prepareMediaRecorder:", "Increased max size from", Long.valueOf(stub.moveToNextValue), LoginTrackingConstants.LoginParam.TO, Long.valueOf(Math.round(d2 / 0.9d)));
        this.getAuthRequestContext.setMaxDuration(stub.lookAheadTest);
        this.getAuthRequestContext.setOnInfoListener(new MediaRecorder.OnInfoListener() { // from class: com.otaliastudios.cameraview.video.FullVideoRecorder.1
            public static final byte[] PlaceComponentResult = {56, -13, -61, 104, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
            public static final int BuiltInFictitiousFunctionClassFactory = 48;

            /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002c). Please submit an issue!!! */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private static void a(byte r6, byte r7, int r8, java.lang.Object[] r9) {
                /*
                    int r7 = r7 + 4
                    byte[] r0 = com.otaliastudios.cameraview.video.FullVideoRecorder.AnonymousClass1.PlaceComponentResult
                    int r6 = r6 * 3
                    int r6 = r6 + 13
                    int r8 = r8 * 7
                    int r8 = 106 - r8
                    byte[] r1 = new byte[r6]
                    r2 = 0
                    if (r0 != 0) goto L15
                    r4 = r8
                    r3 = 0
                    r8 = r7
                    goto L2c
                L15:
                    r3 = 0
                L16:
                    int r7 = r7 + 1
                    byte r4 = (byte) r8
                    r1[r3] = r4
                    int r3 = r3 + 1
                    if (r3 != r6) goto L27
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r1, r2)
                    r9[r2] = r6
                    return
                L27:
                    r4 = r0[r7]
                    r5 = r8
                    r8 = r7
                    r7 = r5
                L2c:
                    int r4 = -r4
                    int r7 = r7 + r4
                    int r7 = r7 + 2
                    r5 = r8
                    r8 = r7
                    r7 = r5
                    goto L16
                */
                throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.video.FullVideoRecorder.AnonymousClass1.a(byte, byte, int, java.lang.Object[]):void");
            }

            @Override // android.media.MediaRecorder.OnInfoListener
            public void onInfo(MediaRecorder mediaRecorder3, int i13, int i14) {
                boolean z7;
                CameraLogger cameraLogger4 = FullVideoRecorder.PlaceComponentResult;
                Object[] objArr5 = new Object[6];
                objArr5[0] = "OnInfoListener:";
                objArr5[1] = "Received info";
                objArr5[2] = Integer.valueOf(i13);
                objArr5[3] = Integer.valueOf(i14);
                objArr5[4] = "Thread: ";
                try {
                    Object[] objArr6 = new Object[1];
                    a((byte) (-PlaceComponentResult[15]), PlaceComponentResult[16], (byte) (PlaceComponentResult[15] + 1), objArr6);
                    Class<?> cls2 = Class.forName((String) objArr6[0]);
                    byte b2 = (byte) (PlaceComponentResult[15] + 1);
                    byte b3 = PlaceComponentResult[15];
                    Object[] objArr7 = new Object[1];
                    a(b2, b3, (byte) (-b3), objArr7);
                    objArr5[5] = cls2.getMethod((String) objArr7[0], null).invoke(null, null);
                    cameraLogger4.KClassImpl$Data$declaredNonStaticMembers$2(1, objArr5);
                    switch (i13) {
                        case 800:
                            FullVideoRecorder.this.scheduleImpl.getAuthRequestContext = 2;
                            z7 = true;
                            break;
                        case SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM /* 801 */:
                        case SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_JPG /* 802 */:
                            FullVideoRecorder.this.scheduleImpl.getAuthRequestContext = 1;
                            z7 = true;
                            break;
                        default:
                            z7 = false;
                            break;
                    }
                    if (z7) {
                        FullVideoRecorder.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, "OnInfoListener:", "Stopping");
                        FullVideoRecorder.this.MyBillsEntityDataFactory(false);
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
        });
        this.getAuthRequestContext.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.otaliastudios.cameraview.video.FullVideoRecorder.2
            @Override // android.media.MediaRecorder.OnErrorListener
            public void onError(MediaRecorder mediaRecorder3, int i13, int i14) {
                FullVideoRecorder.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(3, "OnErrorListener: got error", Integer.valueOf(i13), Integer.valueOf(i14), ". Stopping.");
                FullVideoRecorder.this.scheduleImpl = null;
                FullVideoRecorder fullVideoRecorder = FullVideoRecorder.this;
                StringBuilder sb = new StringBuilder();
                sb.append("MediaRecorder error: ");
                sb.append(i13);
                sb.append(" ");
                sb.append(i14);
                fullVideoRecorder.lookAheadTest = new RuntimeException(sb.toString());
                FullVideoRecorder.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, "OnErrorListener:", "Stopping");
                FullVideoRecorder.this.MyBillsEntityDataFactory(false);
            }
        });
        try {
            this.getAuthRequestContext.prepare();
            this.BuiltInFictitiousFunctionClassFactory = true;
            this.lookAheadTest = null;
            return true;
        } catch (Exception e11) {
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(2, "prepareMediaRecorder:", "Error while preparing media recorder.", e11);
            this.BuiltInFictitiousFunctionClassFactory = false;
            this.lookAheadTest = e11;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.otaliastudios.cameraview.video.VideoRecorder
    public void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (!MyBillsEntityDataFactory(this.scheduleImpl)) {
            this.scheduleImpl = null;
            MyBillsEntityDataFactory(false);
            return;
        }
        try {
            this.getAuthRequestContext.start();
            scheduleImpl();
        } catch (Exception e) {
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(2, "start:", "Error while starting media recorder.", e);
            this.scheduleImpl = null;
            this.lookAheadTest = e;
            MyBillsEntityDataFactory(false);
        }
    }

    @Override // com.otaliastudios.cameraview.video.VideoRecorder
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        if (this.getAuthRequestContext != null) {
            getAuthRequestContext();
            try {
                CameraLogger cameraLogger = PlaceComponentResult;
                cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "stop:", "Stopping MediaRecorder...");
                this.getAuthRequestContext.stop();
                cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "stop:", "Stopped MediaRecorder.");
            } catch (Exception e) {
                this.scheduleImpl = null;
                if (this.lookAheadTest == null) {
                    PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(2, "stop:", "Error while closing media recorder.", e);
                    this.lookAheadTest = e;
                }
            }
            try {
                CameraLogger cameraLogger2 = PlaceComponentResult;
                cameraLogger2.KClassImpl$Data$declaredNonStaticMembers$2(1, "stop:", "Releasing MediaRecorder...");
                this.getAuthRequestContext.release();
                cameraLogger2.KClassImpl$Data$declaredNonStaticMembers$2(1, "stop:", "Released MediaRecorder.");
            } catch (Exception e2) {
                this.scheduleImpl = null;
                if (this.lookAheadTest == null) {
                    PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(2, "stop:", "Error while releasing media recorder.", e2);
                    this.lookAheadTest = e2;
                }
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        this.getAuthRequestContext = null;
        this.BuiltInFictitiousFunctionClassFactory = false;
        PlaceComponentResult();
    }
}
