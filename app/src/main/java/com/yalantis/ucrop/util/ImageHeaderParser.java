package com.yalantis.ucrop.util;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: classes8.dex */
public class ImageHeaderParser {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final int[] KClassImpl$Data$declaredNonStaticMembers$2;
    private static int MyBillsEntityDataFactory = 0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static final byte[] PlaceComponentResult;
    private static int getAuthRequestContext;
    private static int getErrorConfigVersion;
    private static int lookAheadTest;
    private static byte[] moveToNextValue;
    private static short[] scheduleImpl;
    private final Reader BuiltInFictitiousFunctionClassFactory;

    /* loaded from: classes8.dex */
    interface Reader {
        long BuiltInFictitiousFunctionClassFactory(long j) throws IOException;

        short BuiltInFictitiousFunctionClassFactory() throws IOException;

        int KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr, int i) throws IOException;

        int MyBillsEntityDataFactory() throws IOException;
    }

    static void PlaceComponentResult() {
        getAuthRequestContext = 1257195726;
        getErrorConfigVersion = -118694257;
        moveToNextValue = new byte[]{43, -40, TarHeader.LF_BLK, 33, 44};
        MyBillsEntityDataFactory = -1239766715;
    }

    private static int getAuthRequestContext(int i, int i2) {
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 79;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
        int i5 = i + 2 + (i2 * 12);
        int i6 = lookAheadTest + 39;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i6 % 128;
        if (!(i6 % 2 == 0)) {
            return i5;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        if (((r4 & 65496) != 65496) != true) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        if ((r4 | 65496) != 65496) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0026, code lost:
    
        if (r4 == 19789) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0028, code lost:
    
        r0 = com.yalantis.ucrop.util.ImageHeaderParser.NetworkUserEntityData$$ExternalSyntheticLambda0 + 71;
        com.yalantis.ucrop.util.ImageHeaderParser.lookAheadTest = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        if (r4 == 18761) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
    
        r4 = com.yalantis.ucrop.util.ImageHeaderParser.NetworkUserEntityData$$ExternalSyntheticLambda0 + 81;
        com.yalantis.ucrop.util.ImageHeaderParser.lookAheadTest = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean getAuthRequestContext(int r4) {
        /*
            int r0 = com.yalantis.ucrop.util.ImageHeaderParser.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 37
            int r1 = r0 % 128
            com.yalantis.ucrop.util.ImageHeaderParser.lookAheadTest = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r3 = 65496(0xffd8, float:9.178E-41)
            if (r0 == 0) goto L20
            r0 = r4 & r3
            if (r0 == r3) goto L1c
            r0 = 1
            goto L1d
        L1c:
            r0 = 0
        L1d:
            if (r0 == r2) goto L24
            goto L41
        L20:
            r0 = r4 | r3
            if (r0 == r3) goto L41
        L24:
            r0 = 19789(0x4d4d, float:2.773E-41)
            if (r4 == r0) goto L41
            int r0 = com.yalantis.ucrop.util.ImageHeaderParser.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 71
            int r3 = r0 % 128
            com.yalantis.ucrop.util.ImageHeaderParser.lookAheadTest = r3
            int r0 = r0 % 2
            r0 = 18761(0x4949, float:2.629E-41)
            if (r4 == r0) goto L41
            int r4 = com.yalantis.ucrop.util.ImageHeaderParser.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r4 = r4 + 81
            int r0 = r4 % 128
            com.yalantis.ucrop.util.ImageHeaderParser.lookAheadTest = r0
            int r4 = r4 % 2
            goto L42
        L41:
            r1 = 1
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.ImageHeaderParser.getAuthRequestContext(int):boolean");
    }

    static {
        PlaceComponentResult();
        Object[] objArr = new Object[1];
        a(Color.alpha(0) + 50994726, TextUtils.indexOf((CharSequence) "", '0', 0, 0) - 81, (short) Color.red(0), ((Process.getThreadPriority(0) + 20) >> 6) + 1308387909, (byte) (Drawable.resolveOpacity(0, 0) + 76), objArr);
        PlaceComponentResult = "Exif\u0000\u0000".getBytes(Charset.forName(((String) objArr[0]).intern()));
        KClassImpl$Data$declaredNonStaticMembers$2 = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 37;
        lookAheadTest = i % 128;
        int i2 = i % 2;
    }

    public ImageHeaderParser(InputStream inputStream) {
        try {
            this.BuiltInFictitiousFunctionClassFactory = new StreamReader(inputStream);
        } catch (Exception e) {
            throw e;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:22:0x0050
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public final int KClassImpl$Data$declaredNonStaticMembers$2() throws java.io.IOException {
        /*
            r6 = this;
            int r0 = com.yalantis.ucrop.util.ImageHeaderParser.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 75
            int r1 = r0 % 128
            com.yalantis.ucrop.util.ImageHeaderParser.lookAheadTest = r1
            int r0 = r0 % 2
            if (r0 == 0) goto Le
            r0 = 0
            goto L10
        Le:
            r0 = 36
        L10:
            r1 = 3
            r2 = -1
            java.lang.String r3 = "ImageHeaderParser"
            if (r0 == 0) goto L23
            com.yalantis.ucrop.util.ImageHeaderParser$Reader r0 = r6.BuiltInFictitiousFunctionClassFactory
            int r0 = r0.MyBillsEntityDataFactory()
            boolean r4 = getAuthRequestContext(r0)
            if (r4 != 0) goto L53
            goto L33
        L23:
            com.yalantis.ucrop.util.ImageHeaderParser$Reader r0 = r6.BuiltInFictitiousFunctionClassFactory
            int r0 = r0.MyBillsEntityDataFactory()
            boolean r4 = getAuthRequestContext(r0)
            r5 = 0
            r5.hashCode()     // Catch: java.lang.Throwable -> L76
            if (r4 != 0) goto L53
        L33:
            boolean r1 = android.util.Log.isLoggable(r3, r1)
            if (r1 == 0) goto L52
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "Parser doesn't handle magic number: "
            r1.append(r4)     // Catch: java.lang.Exception -> L4e
            r1.append(r0)     // Catch: java.lang.Exception -> L4e
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Exception -> L4e
            com.fullstory.instrumentation.InstrumentInjector.log_d(r3, r0)     // Catch: java.lang.Exception -> L4e
            goto L52
        L4e:
            r0 = move-exception
            throw r0
        L50:
            r0 = move-exception
            throw r0
        L52:
            return r2
        L53:
            int r0 = r6.BuiltInFictitiousFunctionClassFactory()
            if (r0 != r2) goto L6f
            boolean r0 = android.util.Log.isLoggable(r3, r1)
            if (r0 == 0) goto L6e
            java.lang.String r0 = "Failed to parse exif segment length, or exif segment not found"
            com.fullstory.instrumentation.InstrumentInjector.log_d(r3, r0)
            int r0 = com.yalantis.ucrop.util.ImageHeaderParser.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 77
            int r1 = r0 % 128
            com.yalantis.ucrop.util.ImageHeaderParser.lookAheadTest = r1
            int r0 = r0 % 2
        L6e:
            return r2
        L6f:
            byte[] r1 = new byte[r0]
            int r0 = r6.PlaceComponentResult(r1, r0)
            return r0
        L76:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.ImageHeaderParser.KClassImpl$Data$declaredNonStaticMembers$2():int");
    }

    private int PlaceComponentResult(byte[] bArr, int i) throws IOException {
        try {
            int KClassImpl$Data$declaredNonStaticMembers$22 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(bArr, i);
            if ((KClassImpl$Data$declaredNonStaticMembers$22 != i ? 'I' : 'G') == 'G') {
                if (BuiltInFictitiousFunctionClassFactory(bArr, i)) {
                    return PlaceComponentResult(new RandomAccessReader(bArr, i));
                }
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    InstrumentInjector.log_d("ImageHeaderParser", "Missing jpeg exif preamble");
                }
                return -1;
            }
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 41;
            lookAheadTest = i2 % 128;
            int i3 = i2 % 2;
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to read exif segment data, length: ");
                sb.append(i);
                sb.append(", actually read: ");
                sb.append(KClassImpl$Data$declaredNonStaticMembers$22);
                InstrumentInjector.log_d("ImageHeaderParser", sb.toString());
            }
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 47;
            lookAheadTest = i4 % 128;
            if ((i4 % 2 != 0 ? (char) 18 : (char) 27) != 27) {
                int i5 = 55 / 0;
                return -1;
            }
            return -1;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean BuiltInFictitiousFunctionClassFactory(byte[] r6, int r7) {
        /*
            int r0 = com.yalantis.ucrop.util.ImageHeaderParser.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 103
            int r1 = r0 % 128
            com.yalantis.ucrop.util.ImageHeaderParser.lookAheadTest = r1
            int r0 = r0 % 2
            r0 = 1
            r1 = 0
            if (r6 == 0) goto L1f
            int r2 = com.yalantis.ucrop.util.ImageHeaderParser.lookAheadTest
            int r2 = r2 + 95
            int r3 = r2 % 128
            com.yalantis.ucrop.util.ImageHeaderParser.NetworkUserEntityData$$ExternalSyntheticLambda0 = r3
            int r2 = r2 % 2
            byte[] r2 = com.yalantis.ucrop.util.ImageHeaderParser.PlaceComponentResult
            int r2 = r2.length
            if (r7 <= r2) goto L1f
            r7 = 1
            goto L20
        L1f:
            r7 = 0
        L20:
            r2 = 61
            if (r7 == 0) goto L27
            r3 = 61
            goto L29
        L27:
            r3 = 24
        L29:
            if (r3 == r2) goto L2c
            goto L37
        L2c:
            r2 = 0
        L2d:
            byte[] r3 = com.yalantis.ucrop.util.ImageHeaderParser.PlaceComponentResult
            int r4 = r3.length
            if (r2 >= r4) goto L34
            r4 = 0
            goto L35
        L34:
            r4 = 1
        L35:
            if (r4 == 0) goto L39
        L37:
            r1 = r7
            goto L53
        L39:
            int r4 = com.yalantis.ucrop.util.ImageHeaderParser.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r4 = r4 + 7
            int r5 = r4 % 128
            com.yalantis.ucrop.util.ImageHeaderParser.lookAheadTest = r5
            int r4 = r4 % 2
            r4 = r6[r2]
            r3 = r3[r2]
            if (r4 == r3) goto L58
            int r6 = com.yalantis.ucrop.util.ImageHeaderParser.lookAheadTest     // Catch: java.lang.Exception -> L56
            int r6 = r6 + 29
            int r7 = r6 % 128
            com.yalantis.ucrop.util.ImageHeaderParser.NetworkUserEntityData$$ExternalSyntheticLambda0 = r7     // Catch: java.lang.Exception -> L54
            int r6 = r6 % 2
        L53:
            return r1
        L54:
            r6 = move-exception
            throw r6
        L56:
            r6 = move-exception
            throw r6
        L58:
            int r2 = r2 + 1
            goto L2d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.ImageHeaderParser.BuiltInFictitiousFunctionClassFactory(byte[], int):boolean");
    }

    private int BuiltInFictitiousFunctionClassFactory() throws IOException {
        short BuiltInFictitiousFunctionClassFactory;
        int MyBillsEntityDataFactory2;
        long j;
        long BuiltInFictitiousFunctionClassFactory2;
        do {
            short BuiltInFictitiousFunctionClassFactory3 = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
            if (BuiltInFictitiousFunctionClassFactory3 != 255) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown segmentId=");
                    sb.append((int) BuiltInFictitiousFunctionClassFactory3);
                    InstrumentInjector.log_d("ImageHeaderParser", sb.toString());
                }
                return -1;
            }
            BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
            if (BuiltInFictitiousFunctionClassFactory == 218) {
                return -1;
            }
            if ((BuiltInFictitiousFunctionClassFactory == 217 ? (char) 15 : (char) 24) == 15) {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 27;
                lookAheadTest = i % 128;
                int i2 = i % 2;
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 43;
                    lookAheadTest = i3 % 128;
                    if (i3 % 2 != 0) {
                        InstrumentInjector.log_d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
                        int i4 = 52 / 0;
                    } else {
                        InstrumentInjector.log_d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
                    }
                }
                return -1;
            }
            MyBillsEntityDataFactory2 = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory() - 2;
            if ((BuiltInFictitiousFunctionClassFactory != 225 ? ';' : 'W') == 'W') {
                return MyBillsEntityDataFactory2;
            }
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 81;
            lookAheadTest = i5 % 128;
            int i6 = i5 % 2;
            j = MyBillsEntityDataFactory2;
            BuiltInFictitiousFunctionClassFactory2 = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(j);
        } while ((BuiltInFictitiousFunctionClassFactory2 != j ? '\f' : '2') != '\f');
        int i7 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 93;
        lookAheadTest = i7 % 128;
        int i8 = i7 % 2;
        if (Log.isLoggable("ImageHeaderParser", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to skip enough data, type: ");
            sb2.append((int) BuiltInFictitiousFunctionClassFactory);
            sb2.append(", wanted to skip: ");
            sb2.append(MyBillsEntityDataFactory2);
            sb2.append(", but actually skipped: ");
            sb2.append(BuiltInFictitiousFunctionClassFactory2);
            InstrumentInjector.log_d("ImageHeaderParser", sb2.toString());
        }
        int i9 = lookAheadTest + 49;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i9 % 128;
        int i10 = i9 % 2;
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int PlaceComponentResult(com.yalantis.ucrop.util.ImageHeaderParser.RandomAccessReader r14) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.ImageHeaderParser.PlaceComponentResult(com.yalantis.ucrop.util.ImageHeaderParser$RandomAccessReader):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class RandomAccessReader {
        final ByteBuffer KClassImpl$Data$declaredNonStaticMembers$2;

        public RandomAccessReader(byte[] bArr, int i) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        public final short BuiltInFictitiousFunctionClassFactory(int i) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getShort(i);
        }
    }

    /* loaded from: classes8.dex */
    static class StreamReader implements Reader {
        private final InputStream BuiltInFictitiousFunctionClassFactory;

        public StreamReader(InputStream inputStream) {
            this.BuiltInFictitiousFunctionClassFactory = inputStream;
        }

        @Override // com.yalantis.ucrop.util.ImageHeaderParser.Reader
        public final int MyBillsEntityDataFactory() throws IOException {
            return ((this.BuiltInFictitiousFunctionClassFactory.read() << 8) & 65280) | (this.BuiltInFictitiousFunctionClassFactory.read() & 255);
        }

        @Override // com.yalantis.ucrop.util.ImageHeaderParser.Reader
        public final short BuiltInFictitiousFunctionClassFactory() throws IOException {
            return (short) (this.BuiltInFictitiousFunctionClassFactory.read() & 255);
        }

        @Override // com.yalantis.ucrop.util.ImageHeaderParser.Reader
        public final long BuiltInFictitiousFunctionClassFactory(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.BuiltInFictitiousFunctionClassFactory.skip(j2);
                if (skip <= 0) {
                    if (this.BuiltInFictitiousFunctionClassFactory.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }

        @Override // com.yalantis.ucrop.util.ImageHeaderParser.Reader
        public final int KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr, int i) throws IOException {
            int i2 = i;
            while (i2 > 0) {
                int read = this.BuiltInFictitiousFunctionClassFactory.read(bArr, i - i2, i2);
                if (read == -1) {
                    break;
                }
                i2 -= read;
            }
            return i - i2;
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(ExifInterface exifInterface, int i, int i2, String str) {
        String[] strArr = {"FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "ISOSpeedRatings", "Make", "Model", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance"};
        try {
            ExifInterface exifInterface2 = new ExifInterface(str);
            int i3 = 0;
            while (true) {
                if (!(i3 >= 22)) {
                    String str2 = strArr[i3];
                    String attribute = exifInterface.getAttribute(str2);
                    if (!TextUtils.isEmpty(attribute)) {
                        try {
                            int i4 = lookAheadTest + 59;
                            try {
                                NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
                                if ((i4 % 2 == 0 ? (char) 15 : 'R') != 'R') {
                                    exifInterface2.setAttribute(str2, attribute);
                                    int i5 = 62 / 0;
                                } else {
                                    exifInterface2.setAttribute(str2, attribute);
                                }
                                int i6 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 9;
                                lookAheadTest = i6 % 128;
                                int i7 = i6 % 2;
                            } catch (Exception e) {
                                throw e;
                            }
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                    i3++;
                } else {
                    exifInterface2.setAttribute("ImageWidth", String.valueOf(i));
                    exifInterface2.setAttribute("ImageLength", String.valueOf(i2));
                    exifInterface2.setAttribute("Orientation", "0");
                    exifInterface2.saveAttributes();
                    return;
                }
            }
        } catch (IOException e3) {
            InstrumentInjector.log_d("ImageHeaderParser", e3.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a9, code lost:
    
        if (r3 != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b6, code lost:
    
        if (r3 != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b8, code lost:
    
        r3 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ba, code lost:
    
        r3 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r13, int r14, short r15, int r16, byte r17, java.lang.Object[] r18) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.ImageHeaderParser.a(int, int, short, int, byte, java.lang.Object[]):void");
    }
}
