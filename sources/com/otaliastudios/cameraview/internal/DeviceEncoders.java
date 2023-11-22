package com.otaliastudios.cameraview.internal;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.util.Range;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.size.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class DeviceEncoders {
    static boolean BuiltInFictitiousFunctionClassFactory = false;
    private static final CameraLogger PlaceComponentResult = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("DeviceEncoders");
    public final MediaCodecInfo KClassImpl$Data$declaredNonStaticMembers$2;
    public final MediaCodecInfo MyBillsEntityDataFactory;
    private final MediaCodecInfo.AudioCapabilities getAuthRequestContext;
    private final MediaCodecInfo.VideoCapabilities lookAheadTest;

    static {
        BuiltInFictitiousFunctionClassFactory = Build.VERSION.SDK_INT >= 21;
    }

    /* loaded from: classes8.dex */
    public class VideoException extends RuntimeException {
        private VideoException(String str) {
            super(str);
        }
    }

    /* loaded from: classes8.dex */
    public class AudioException extends RuntimeException {
        private AudioException(String str) {
            super(str);
        }
    }

    public DeviceEncoders(int i, String str, String str2, int i2, int i3) {
        if (!BuiltInFictitiousFunctionClassFactory) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            this.MyBillsEntityDataFactory = null;
            this.lookAheadTest = null;
            this.getAuthRequestContext = null;
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, "Disabled.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
            if (mediaCodecInfo.isEncoder()) {
                arrayList.add(mediaCodecInfo);
            }
        }
        MediaCodecInfo authRequestContext = getAuthRequestContext(arrayList, str, i, i2);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext;
        CameraLogger cameraLogger = PlaceComponentResult;
        cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "Enabled. Found video encoder:", authRequestContext.getName());
        MediaCodecInfo authRequestContext2 = getAuthRequestContext(arrayList, str2, i, i3);
        this.MyBillsEntityDataFactory = authRequestContext2;
        cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "Enabled. Found audio encoder:", authRequestContext2.getName());
        this.lookAheadTest = authRequestContext.getCapabilitiesForType(str).getVideoCapabilities();
        this.getAuthRequestContext = authRequestContext2.getCapabilitiesForType(str2).getAudioCapabilities();
    }

    static boolean MyBillsEntityDataFactory(String str) {
        String lowerCase = str.toLowerCase();
        return !(lowerCase.startsWith("omx.google.") || lowerCase.startsWith("c2.android.") || !(lowerCase.startsWith("omx.") || lowerCase.startsWith("c2.")));
    }

    private MediaCodecInfo getAuthRequestContext(List<MediaCodecInfo> list, String str, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        Iterator<MediaCodecInfo> it = list.iterator();
        while (true) {
            int i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            MediaCodecInfo next = it.next();
            String[] supportedTypes = next.getSupportedTypes();
            int length = supportedTypes.length;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (supportedTypes[i3].equalsIgnoreCase(str)) {
                    arrayList.add(next);
                    break;
                } else {
                    i3++;
                }
            }
        }
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, "findDeviceEncoder -", "type:", str, "encoders:", Integer.valueOf(arrayList.size()));
        if (i == 1) {
            Collections.sort(arrayList, new Comparator<MediaCodecInfo>() { // from class: com.otaliastudios.cameraview.internal.DeviceEncoders.1
                @Override // java.util.Comparator
                public /* synthetic */ int compare(MediaCodecInfo mediaCodecInfo, MediaCodecInfo mediaCodecInfo2) {
                    return Boolean.compare(DeviceEncoders.MyBillsEntityDataFactory(mediaCodecInfo2.getName()), DeviceEncoders.MyBillsEntityDataFactory(mediaCodecInfo.getName()));
                }
            });
        }
        if (arrayList.size() < i2 + 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("No encoders for type:");
            sb.append(str);
            throw new RuntimeException(sb.toString());
        }
        return (MediaCodecInfo) arrayList.get(i2);
    }

    public final Size PlaceComponentResult(Size size) {
        if (BuiltInFictitiousFunctionClassFactory) {
            int i = size.BuiltInFictitiousFunctionClassFactory;
            int i2 = size.getAuthRequestContext;
            double d = i;
            double d2 = i2;
            Double.isNaN(d);
            Double.isNaN(d2);
            double d3 = d / d2;
            CameraLogger cameraLogger = PlaceComponentResult;
            cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "getSupportedVideoSize - started. width:", Integer.valueOf(i), "height:", Integer.valueOf(i2));
            if (this.lookAheadTest.getSupportedWidths().getUpper().intValue() < i) {
                i = this.lookAheadTest.getSupportedWidths().getUpper().intValue();
                double d4 = i;
                Double.isNaN(d4);
                i2 = (int) Math.round(d4 / d3);
                cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "getSupportedVideoSize - exceeds maxWidth! width:", Integer.valueOf(i), "height:", Integer.valueOf(i2));
            }
            if (this.lookAheadTest.getSupportedHeights().getUpper().intValue() < i2) {
                i2 = this.lookAheadTest.getSupportedHeights().getUpper().intValue();
                double d5 = i2;
                Double.isNaN(d5);
                i = (int) Math.round(d5 * d3);
                cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "getSupportedVideoSize - exceeds maxHeight! width:", Integer.valueOf(i), "height:", Integer.valueOf(i2));
            }
            while (i % this.lookAheadTest.getWidthAlignment() != 0) {
                i--;
            }
            while (i2 % this.lookAheadTest.getHeightAlignment() != 0) {
                i2--;
            }
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, "getSupportedVideoSize - aligned. width:", Integer.valueOf(i), "height:", Integer.valueOf(i2));
            if (!this.lookAheadTest.getSupportedWidths().contains((Range<Integer>) Integer.valueOf(i))) {
                StringBuilder sb = new StringBuilder();
                sb.append("Width not supported after adjustment. Desired:");
                sb.append(i);
                sb.append(" Range:");
                sb.append(this.lookAheadTest.getSupportedWidths());
                throw new VideoException(sb.toString());
            } else if (!this.lookAheadTest.getSupportedHeights().contains((Range<Integer>) Integer.valueOf(i2))) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Height not supported after adjustment. Desired:");
                sb2.append(i2);
                sb2.append(" Range:");
                sb2.append(this.lookAheadTest.getSupportedHeights());
                throw new VideoException(sb2.toString());
            } else {
                try {
                    if (!this.lookAheadTest.getSupportedHeightsFor(i).contains((Range<Integer>) Integer.valueOf(i2))) {
                        int intValue = this.lookAheadTest.getSupportedWidths().getLower().intValue();
                        int widthAlignment = this.lookAheadTest.getWidthAlignment();
                        int i3 = i;
                        while (i3 >= intValue) {
                            i3 -= 32;
                            while (i3 % widthAlignment != 0) {
                                i3--;
                            }
                            double d6 = i3;
                            Double.isNaN(d6);
                            int round = (int) Math.round(d6 / d3);
                            if (this.lookAheadTest.getSupportedHeightsFor(i3).contains((Range<Integer>) Integer.valueOf(round))) {
                                PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(2, "getSupportedVideoSize - restarting with smaller size.");
                                return PlaceComponentResult(new Size(i3, round));
                            }
                        }
                    }
                } catch (IllegalArgumentException unused) {
                }
                if (!this.lookAheadTest.isSizeSupported(i, i2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Size not supported for unknown reason. Might be an aspect ratio issue. Desired size:");
                    sb3.append(new Size(i, i2));
                    throw new VideoException(sb3.toString());
                }
                return new Size(i, i2);
            }
        }
        return size;
    }

    public final int BuiltInFictitiousFunctionClassFactory(int i) {
        if (BuiltInFictitiousFunctionClassFactory) {
            int intValue = this.lookAheadTest.getBitrateRange().clamp(Integer.valueOf(i)).intValue();
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, "getSupportedVideoBitRate -", "inputRate:", Integer.valueOf(i), "adjustedRate:", Integer.valueOf(intValue));
            return intValue;
        }
        return i;
    }

    public final int BuiltInFictitiousFunctionClassFactory(Size size, int i) {
        if (BuiltInFictitiousFunctionClassFactory) {
            int doubleValue = (int) this.lookAheadTest.getSupportedFrameRatesFor(size.BuiltInFictitiousFunctionClassFactory, size.getAuthRequestContext).clamp(Double.valueOf(i)).doubleValue();
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, "getSupportedVideoFrameRate -", "inputRate:", Integer.valueOf(i), "adjustedRate:", Integer.valueOf(doubleValue));
            return doubleValue;
        }
        return i;
    }

    public final int PlaceComponentResult(int i) {
        if (BuiltInFictitiousFunctionClassFactory) {
            int intValue = this.getAuthRequestContext.getBitrateRange().clamp(Integer.valueOf(i)).intValue();
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, "getSupportedAudioBitRate -", "inputRate:", Integer.valueOf(i), "adjustedRate:", Integer.valueOf(intValue));
            return intValue;
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.otaliastudios.cameraview.internal.DeviceEncoders$1] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext(java.lang.String r3, com.otaliastudios.cameraview.size.Size r4, int r5, int r6) {
        /*
            r2 = this;
            android.media.MediaCodecInfo r0 = r2.KClassImpl$Data$declaredNonStaticMembers$2
            if (r0 == 0) goto L61
            r0 = 0
            int r1 = r4.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            int r4 = r4.getAuthRequestContext     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            android.media.MediaFormat r3 = android.media.MediaFormat.createVideoFormat(r3, r1, r4)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            java.lang.String r4 = "color-format"
            r1 = 2130708361(0x7f000789, float:1.701803E38)
            r3.setInteger(r4, r1)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            java.lang.String r4 = "bitrate"
            r3.setInteger(r4, r6)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            java.lang.String r4 = "frame-rate"
            r3.setInteger(r4, r5)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            java.lang.String r4 = "i-frame-interval"
            r5 = 1
            r3.setInteger(r4, r5)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            android.media.MediaCodecInfo r4 = r2.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            java.lang.String r4 = r4.getName()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            android.media.MediaCodec r4 = android.media.MediaCodec.createByCodecName(r4)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r4.configure(r3, r0, r0, r5)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L59
            if (r4 == 0) goto L61
            r4.release()     // Catch: java.lang.Exception -> L37
        L37:
            return
        L38:
            r3 = move-exception
            goto L3e
        L3a:
            r3 = move-exception
            goto L5b
        L3c:
            r3 = move-exception
            r4 = r0
        L3e:
            com.otaliastudios.cameraview.internal.DeviceEncoders$VideoException r5 = new com.otaliastudios.cameraview.internal.DeviceEncoders$VideoException     // Catch: java.lang.Throwable -> L59
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59
            r6.<init>()     // Catch: java.lang.Throwable -> L59
            java.lang.String r1 = "Failed to configure video codec: "
            r6.append(r1)     // Catch: java.lang.Throwable -> L59
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Throwable -> L59
            r6.append(r3)     // Catch: java.lang.Throwable -> L59
            java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L59
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L59
            throw r5     // Catch: java.lang.Throwable -> L59
        L59:
            r3 = move-exception
            r0 = r4
        L5b:
            if (r0 == 0) goto L60
            r0.release()     // Catch: java.lang.Exception -> L60
        L60:
            throw r3
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.internal.DeviceEncoders.getAuthRequestContext(java.lang.String, com.otaliastudios.cameraview.size.Size, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.otaliastudios.cameraview.internal.DeviceEncoders$1] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void MyBillsEntityDataFactory(java.lang.String r3, int r4, int r5, int r6) {
        /*
            r2 = this;
            android.media.MediaCodecInfo r0 = r2.MyBillsEntityDataFactory
            if (r0 == 0) goto L58
            r0 = 0
            android.media.MediaFormat r3 = android.media.MediaFormat.createAudioFormat(r3, r5, r6)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            r5 = 2
            if (r6 != r5) goto Lf
            r5 = 12
            goto L11
        Lf:
            r5 = 16
        L11:
            java.lang.String r6 = "channel-mask"
            r3.setInteger(r6, r5)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            java.lang.String r5 = "bitrate"
            r3.setInteger(r5, r4)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            android.media.MediaCodecInfo r4 = r2.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            java.lang.String r4 = r4.getName()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            android.media.MediaCodec r4 = android.media.MediaCodec.createByCodecName(r4)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            r5 = 1
            r4.configure(r3, r0, r0, r5)     // Catch: java.lang.Exception -> L2f java.lang.Throwable -> L50
            if (r4 == 0) goto L58
            r4.release()     // Catch: java.lang.Exception -> L2e
        L2e:
            return
        L2f:
            r3 = move-exception
            goto L35
        L31:
            r3 = move-exception
            goto L52
        L33:
            r3 = move-exception
            r4 = r0
        L35:
            com.otaliastudios.cameraview.internal.DeviceEncoders$AudioException r5 = new com.otaliastudios.cameraview.internal.DeviceEncoders$AudioException     // Catch: java.lang.Throwable -> L50
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50
            r6.<init>()     // Catch: java.lang.Throwable -> L50
            java.lang.String r1 = "Failed to configure video audio: "
            r6.append(r1)     // Catch: java.lang.Throwable -> L50
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Throwable -> L50
            r6.append(r3)     // Catch: java.lang.Throwable -> L50
            java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L50
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L50
            throw r5     // Catch: java.lang.Throwable -> L50
        L50:
            r3 = move-exception
            r0 = r4
        L52:
            if (r0 == 0) goto L57
            r0.release()     // Catch: java.lang.Exception -> L57
        L57:
            throw r3
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.internal.DeviceEncoders.MyBillsEntityDataFactory(java.lang.String, int, int, int):void");
    }
}
