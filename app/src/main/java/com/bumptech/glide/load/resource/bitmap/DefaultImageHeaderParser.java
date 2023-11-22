package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import android.widget.ExpandableListView;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import kotlin.text.Typography;
import o.getOnBoardingScenario;

/* loaded from: classes3.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static final int[] KClassImpl$Data$declaredNonStaticMembers$2;
    private static long MyBillsEntityDataFactory = -5599725791937103335L;
    private static int PlaceComponentResult;
    static final byte[] getAuthRequestContext;

    private static int BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        int i3 = BuiltInFictitiousFunctionClassFactory + 103;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        int i5 = i + 2 + (i2 * 12);
        try {
            int i6 = PlaceComponentResult + 95;
            try {
                BuiltInFictitiousFunctionClassFactory = i6 % 128;
                if (i6 % 2 != 0) {
                    return i5;
                }
                int i7 = 14 / 0;
                return i5;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static boolean getAuthRequestContext(int i) {
        if (((i & 65496) != 65496 ? (char) 21 : '.') != '.') {
            int i2 = PlaceComponentResult + 53;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
            if ((i != 19789 ? (char) 6 : '\f') != '\f') {
                int i4 = PlaceComponentResult + 99;
                BuiltInFictitiousFunctionClassFactory = i4 % 128;
                if ((i4 % 2 == 0 ? '[' : '\r') == '\r' ? i != 18761 : i != 12089) {
                    return false;
                }
            }
        }
        return true;
    }

    static {
        Object[] objArr = new Object[1];
        a(53958 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), new char[]{11023, 63945, 36498, 21282, 24702}, objArr);
        getAuthRequestContext = "Exif\u0000\u0000".getBytes(Charset.forName(((String) objArr[0]).intern()));
        KClassImpl$Data$declaredNonStaticMembers$2 = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
        int i = PlaceComponentResult + 111;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? (char) 29 : 'Y') != 29) {
            return;
        }
        Object[] objArr2 = null;
        int length = objArr2.length;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final ImageHeaderParser.ImageType PlaceComponentResult(InputStream inputStream) throws IOException {
        try {
            try {
                ImageHeaderParser.ImageType KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(new StreamReader((InputStream) Preconditions.PlaceComponentResult(inputStream)));
                int i = BuiltInFictitiousFunctionClassFactory + 85;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                return KClassImpl$Data$declaredNonStaticMembers$22;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final ImageHeaderParser.ImageType PlaceComponentResult(ByteBuffer byteBuffer) throws IOException {
        ImageHeaderParser.ImageType KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(new ByteBufferReader((ByteBuffer) Preconditions.PlaceComponentResult(byteBuffer)));
        int i = BuiltInFictitiousFunctionClassFactory + 63;
        PlaceComponentResult = i % 128;
        if (i % 2 != 0) {
            int i2 = 46 / 0;
            return KClassImpl$Data$declaredNonStaticMembers$22;
        }
        return KClassImpl$Data$declaredNonStaticMembers$22;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final int MyBillsEntityDataFactory(InputStream inputStream, ArrayPool arrayPool) throws IOException {
        int MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(new StreamReader((InputStream) Preconditions.PlaceComponentResult(inputStream)), (ArrayPool) Preconditions.PlaceComponentResult(arrayPool));
        int i = PlaceComponentResult + 83;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        return MyBillsEntityDataFactory2;
    }

    private static ImageHeaderParser.ImageType KClassImpl$Data$declaredNonStaticMembers$2(Reader reader) throws IOException {
        int i = PlaceComponentResult + 27;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            int KClassImpl$Data$declaredNonStaticMembers$22 = reader.KClassImpl$Data$declaredNonStaticMembers$2();
            if (!(KClassImpl$Data$declaredNonStaticMembers$22 != 65496)) {
                ImageHeaderParser.ImageType imageType = ImageHeaderParser.ImageType.JPEG;
                int i3 = PlaceComponentResult + 47;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
                return imageType;
            }
            int authRequestContext = (KClassImpl$Data$declaredNonStaticMembers$22 << 8) | reader.getAuthRequestContext();
            if (authRequestContext == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int authRequestContext2 = (authRequestContext << 8) | reader.getAuthRequestContext();
            if (authRequestContext2 == -1991225785) {
                reader.PlaceComponentResult(21L);
                try {
                    if (reader.getAuthRequestContext() < 3) {
                        return ImageHeaderParser.ImageType.PNG;
                    }
                    return ImageHeaderParser.ImageType.PNG_A;
                } catch (Reader.EndOfFileException unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (!(authRequestContext2 == 1380533830)) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            reader.PlaceComponentResult(4L);
            if (((reader.KClassImpl$Data$declaredNonStaticMembers$2() << 16) | reader.KClassImpl$Data$declaredNonStaticMembers$2()) == 1464156752) {
                int KClassImpl$Data$declaredNonStaticMembers$23 = (reader.KClassImpl$Data$declaredNonStaticMembers$2() << 16) | reader.KClassImpl$Data$declaredNonStaticMembers$2();
                if ((KClassImpl$Data$declaredNonStaticMembers$23 & (-256)) != 1448097792) {
                    int i5 = BuiltInFictitiousFunctionClassFactory + 73;
                    PlaceComponentResult = i5 % 128;
                    int i6 = i5 % 2;
                    return ImageHeaderParser.ImageType.UNKNOWN;
                }
                int i7 = KClassImpl$Data$declaredNonStaticMembers$23 & 255;
                if (!(i7 == 88)) {
                    if (i7 == 76) {
                        reader.PlaceComponentResult(4L);
                        return ((reader.getAuthRequestContext() & 8) != 0 ? '\b' : 'F') != '\b' ? ImageHeaderParser.ImageType.WEBP : ImageHeaderParser.ImageType.WEBP_A;
                    }
                    return ImageHeaderParser.ImageType.WEBP;
                }
                int i8 = PlaceComponentResult + 113;
                BuiltInFictitiousFunctionClassFactory = i8 % 128;
                int i9 = i8 % 2;
                reader.PlaceComponentResult(4L);
                if ((reader.getAuthRequestContext() & 16) != 0) {
                    int i10 = BuiltInFictitiousFunctionClassFactory + 113;
                    PlaceComponentResult = i10 % 128;
                    int i11 = i10 % 2;
                    return ImageHeaderParser.ImageType.WEBP_A;
                }
                return ImageHeaderParser.ImageType.WEBP;
            }
            int i12 = BuiltInFictitiousFunctionClassFactory + 111;
            PlaceComponentResult = i12 % 128;
            if (i12 % 2 != 0) {
                ImageHeaderParser.ImageType imageType2 = ImageHeaderParser.ImageType.UNKNOWN;
                Object[] objArr = null;
                int length = objArr.length;
                return imageType2;
            }
            return ImageHeaderParser.ImageType.UNKNOWN;
        } catch (Reader.EndOfFileException unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    private static int MyBillsEntityDataFactory(Reader reader, ArrayPool arrayPool) throws IOException {
        int i = PlaceComponentResult + 81;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            int KClassImpl$Data$declaredNonStaticMembers$22 = reader.KClassImpl$Data$declaredNonStaticMembers$2();
            if ((!getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22) ? Typography.less : '\f') != '\f') {
                int i3 = BuiltInFictitiousFunctionClassFactory + 25;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Parser doesn't handle magic number: ");
                    sb.append(KClassImpl$Data$declaredNonStaticMembers$22);
                    InstrumentInjector.log_d("DfltImageHeaderParser", sb.toString());
                }
                return -1;
            }
            int PlaceComponentResult2 = PlaceComponentResult(reader);
            if ((PlaceComponentResult2 == -1 ? 'X' : (char) 23) != 23) {
                if (!(!Log.isLoggable("DfltImageHeaderParser", 3))) {
                    InstrumentInjector.log_d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) arrayPool.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2, byte[].class);
            try {
                return PlaceComponentResult(reader, bArr, PlaceComponentResult2);
            } finally {
                arrayPool.BuiltInFictitiousFunctionClassFactory((ArrayPool) bArr);
            }
        } catch (Reader.EndOfFileException unused) {
            return -1;
        }
    }

    private static int PlaceComponentResult(Reader reader, byte[] bArr, int i) throws IOException {
        int i2 = BuiltInFictitiousFunctionClassFactory + 123;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        try {
            int BuiltInFictitiousFunctionClassFactory2 = reader.BuiltInFictitiousFunctionClassFactory(bArr, i);
            if (BuiltInFictitiousFunctionClassFactory2 != i) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unable to read exif segment data, length: ");
                    sb.append(i);
                    sb.append(", actually read: ");
                    sb.append(BuiltInFictitiousFunctionClassFactory2);
                    InstrumentInjector.log_d("DfltImageHeaderParser", sb.toString());
                }
                return -1;
            }
            try {
                if (KClassImpl$Data$declaredNonStaticMembers$2(bArr, i)) {
                    return BuiltInFictitiousFunctionClassFactory(new RandomAccessReader(bArr, i));
                }
                if ((Log.isLoggable("DfltImageHeaderParser", 3) ? '(' : (char) 19) == '(') {
                    int i4 = BuiltInFictitiousFunctionClassFactory + 3;
                    PlaceComponentResult = i4 % 128;
                    int i5 = i4 % 2;
                    InstrumentInjector.log_d("DfltImageHeaderParser", "Missing jpeg exif preamble");
                    int i6 = PlaceComponentResult + 119;
                    BuiltInFictitiousFunctionClassFactory = i6 % 128;
                    int i7 = i6 % 2;
                }
                return -1;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
    
        if ((r6 != null ? ')' : 6) != 6) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0029, code lost:
    
        if ((r6 != null) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002e, code lost:
    
        if (r7 <= com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.getAuthRequestContext.length) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0030, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0032, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0033, code lost:
    
        if (r7 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0035, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0038, code lost:
    
        if (r0 == true) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003b, code lost:
    
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x003c, code lost:
    
        r1 = com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.getAuthRequestContext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003f, code lost:
    
        if (r0 >= r1.length) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0041, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0043, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0044, code lost:
    
        if (r4 == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0048, code lost:
    
        r4 = com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.BuiltInFictitiousFunctionClassFactory + 47;
        com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.PlaceComponentResult = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0052, code lost:
    
        if ((r4 % 2) == 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0054, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0056, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0057, code lost:
    
        if (r4 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0059, code lost:
    
        r4 = r6[r0];
        r1 = r1[r0];
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x005e, code lost:
    
        r5.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0063, code lost:
    
        if (r4 == r1) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0065, code lost:
    
        r1 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0068, code lost:
    
        r1 = '2';
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x006a, code lost:
    
        if (r1 == '2') goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0073, code lost:
    
        if (r6[r0] == r1[r0]) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0075, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0076, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0079, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x007a, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(byte[] r6, int r7) {
        /*
            int r0 = com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.PlaceComponentResult
            int r0 = r0 + 113
            int r1 = r0 % 128
            com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 68
            if (r0 != 0) goto L11
            r0 = 68
            goto L13
        L11:
            r0 = 27
        L13:
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L21
            r0 = 6
            if (r6 == 0) goto L1d
            r1 = 41
            goto L1e
        L1d:
            r1 = 6
        L1e:
            if (r1 == r0) goto L32
            goto L2b
        L21:
            r0 = 32
            int r0 = r0 / r3
            if (r6 == 0) goto L28
            r0 = 1
            goto L29
        L28:
            r0 = 0
        L29:
            if (r0 == 0) goto L32
        L2b:
            byte[] r0 = com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.getAuthRequestContext
            int r0 = r0.length
            if (r7 <= r0) goto L32
            r7 = 1
            goto L33
        L32:
            r7 = 0
        L33:
            if (r7 == 0) goto L37
            r0 = 1
            goto L38
        L37:
            r0 = 0
        L38:
            if (r0 == r2) goto L3b
            goto L46
        L3b:
            r0 = 0
        L3c:
            byte[] r1 = com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.getAuthRequestContext
            int r4 = r1.length
            if (r0 >= r4) goto L43
            r4 = 0
            goto L44
        L43:
            r4 = 1
        L44:
            if (r4 == 0) goto L48
        L46:
            r3 = r7
            goto L75
        L48:
            int r4 = com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L79
            int r4 = r4 + 47
            int r5 = r4 % 128
            com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.PlaceComponentResult = r5     // Catch: java.lang.Exception -> L79
            int r4 = r4 % 2
            if (r4 == 0) goto L56
            r4 = 1
            goto L57
        L56:
            r4 = 0
        L57:
            if (r4 == 0) goto L6f
            r4 = r6[r0]
            r1 = r1[r0]
            r5 = 0
            r5.hashCode()     // Catch: java.lang.Throwable -> L6d
            r5 = 50
            if (r4 == r1) goto L68
            r1 = 26
            goto L6a
        L68:
            r1 = 50
        L6a:
            if (r1 == r5) goto L76
            goto L75
        L6d:
            r6 = move-exception
            throw r6
        L6f:
            r4 = r6[r0]
            r1 = r1[r0]
            if (r4 == r1) goto L76
        L75:
            return r3
        L76:
            int r0 = r0 + 1
            goto L3c
        L79:
            r6 = move-exception
            throw r6
        L7b:
            r6 = move-exception
            goto L7e
        L7d:
            throw r6
        L7e:
            goto L7d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.KClassImpl$Data$declaredNonStaticMembers$2(byte[], int):boolean");
    }

    private static int PlaceComponentResult(Reader reader) throws IOException {
        short authRequestContext;
        int KClassImpl$Data$declaredNonStaticMembers$22;
        long j;
        long PlaceComponentResult2;
        do {
            short authRequestContext2 = reader.getAuthRequestContext();
            if (authRequestContext2 == 255) {
                authRequestContext = reader.getAuthRequestContext();
                if ((authRequestContext == 218 ? (char) 31 : 'D') == 31) {
                    int i = BuiltInFictitiousFunctionClassFactory + 21;
                    PlaceComponentResult = i % 128;
                    int i2 = i % 2;
                    return -1;
                } else if (authRequestContext == 217) {
                    if (!(Log.isLoggable("DfltImageHeaderParser", 3) ? false : true)) {
                        int i3 = BuiltInFictitiousFunctionClassFactory + 103;
                        PlaceComponentResult = i3 % 128;
                        int i4 = i3 % 2;
                        InstrumentInjector.log_d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                        if (i4 != 0) {
                            Object obj = null;
                            obj.hashCode();
                        }
                    }
                    return -1;
                } else {
                    KClassImpl$Data$declaredNonStaticMembers$22 = reader.KClassImpl$Data$declaredNonStaticMembers$2() - 2;
                    if (authRequestContext == 225) {
                        return KClassImpl$Data$declaredNonStaticMembers$22;
                    }
                    j = KClassImpl$Data$declaredNonStaticMembers$22;
                    PlaceComponentResult2 = reader.PlaceComponentResult(j);
                }
            } else {
                int i5 = BuiltInFictitiousFunctionClassFactory + 43;
                PlaceComponentResult = i5 % 128;
                if (i5 % 2 == 0 ? Log.isLoggable("DfltImageHeaderParser", 3) : Log.isLoggable("DfltImageHeaderParser", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown segmentId=");
                    sb.append((int) authRequestContext2);
                    InstrumentInjector.log_d("DfltImageHeaderParser", sb.toString());
                }
                return -1;
            }
        } while ((PlaceComponentResult2 != j ? '5' : '\n') == '\n');
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to skip enough data, type: ");
            sb2.append((int) authRequestContext);
            sb2.append(", wanted to skip: ");
            sb2.append(KClassImpl$Data$declaredNonStaticMembers$22);
            sb2.append(", but actually skipped: ");
            sb2.append(PlaceComponentResult2);
            InstrumentInjector.log_d("DfltImageHeaderParser", sb2.toString());
        }
        return -1;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r14v14 int, still in use, count: 2, list:
          (r14v14 int) from 0x00bd: PHI (r14v8 int) = (r14v7 int), (r14v14 int) binds: [B:42:0x00bb, B:39:0x00b2] A[DONT_GENERATE, DONT_INLINE]
          (r14v14 int) from 0x00a5: INVOKE (r16v0 com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$RandomAccessReader), (r14v14 int), (4 int) type: VIRTUAL call: com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.RandomAccessReader.PlaceComponentResult(int, int):boolean A[MD:(int, int):boolean (m), WRAPPED] (LINE:2408)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:152)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:117)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:114)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:45)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:35)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:33)
        	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:57)
        */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b2, code lost:
    
        if ((r16.PlaceComponentResult(r14, 4) ? 22 : 'G') != 'G') goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bb, code lost:
    
        if (r16.PlaceComponentResult(r14, 4) != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00bd, code lost:
    
        r6 = r16.PlaceComponentResult.getInt(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c4, code lost:
    
        r6 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0164, code lost:
    
        if (r6 >= 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x016a, code lost:
    
        if (r6 >= 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0173, code lost:
    
        if ((r6 + r10) > r16.PlaceComponentResult.remaining()) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0175, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0177, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0178, code lost:
    
        if (r6 == true) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x017f, code lost:
    
        return r16.KClassImpl$Data$declaredNonStaticMembers$2(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0184, code lost:
    
        if (android.util.Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0186, code lost:
    
        r6 = new java.lang.StringBuilder();
        r6.append("Illegal number of bytes for TI tag data tagType=");
        r6.append((int) r11);
        com.fullstory.instrumentation.InstrumentInjector.log_d("DfltImageHeaderParser", r6.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int BuiltInFictitiousFunctionClassFactory(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.RandomAccessReader r16) {
        /*
            Method dump skipped, instructions count: 481
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.BuiltInFictitiousFunctionClassFactory(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$RandomAccessReader):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class RandomAccessReader {
        final ByteBuffer PlaceComponentResult;

        RandomAccessReader(byte[] bArr, int i) {
            this.PlaceComponentResult = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        final short KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            if (PlaceComponentResult(i, 2)) {
                return this.PlaceComponentResult.getShort(i);
            }
            return (short) -1;
        }

        final boolean PlaceComponentResult(int i, int i2) {
            return this.PlaceComponentResult.remaining() - i >= i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface Reader {
        int BuiltInFictitiousFunctionClassFactory(byte[] bArr, int i) throws IOException;

        int KClassImpl$Data$declaredNonStaticMembers$2() throws IOException;

        long PlaceComponentResult(long j) throws IOException;

        short getAuthRequestContext() throws IOException;

        /* loaded from: classes3.dex */
        public static final class EndOfFileException extends IOException {
            private static final long serialVersionUID = 1;

            EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class ByteBufferReader implements Reader {
        private final ByteBuffer getAuthRequestContext;

        ByteBufferReader(ByteBuffer byteBuffer) {
            this.getAuthRequestContext = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public final short getAuthRequestContext() throws Reader.EndOfFileException {
            if (this.getAuthRequestContext.remaining() <= 0) {
                throw new Reader.EndOfFileException();
            }
            return (short) (this.getAuthRequestContext.get() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public final int KClassImpl$Data$declaredNonStaticMembers$2() throws Reader.EndOfFileException {
            return (getAuthRequestContext() << 8) | getAuthRequestContext();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public final int BuiltInFictitiousFunctionClassFactory(byte[] bArr, int i) {
            int min = Math.min(i, this.getAuthRequestContext.remaining());
            if (min == 0) {
                return -1;
            }
            this.getAuthRequestContext.get(bArr, 0, min);
            return min;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public final long PlaceComponentResult(long j) {
            int min = (int) Math.min(this.getAuthRequestContext.remaining(), j);
            ByteBuffer byteBuffer = this.getAuthRequestContext;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }
    }

    /* loaded from: classes3.dex */
    static final class StreamReader implements Reader {
        private final InputStream KClassImpl$Data$declaredNonStaticMembers$2;

        StreamReader(InputStream inputStream) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public final short getAuthRequestContext() throws IOException {
            int read = this.KClassImpl$Data$declaredNonStaticMembers$2.read();
            if (read != -1) {
                return (short) read;
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public final int KClassImpl$Data$declaredNonStaticMembers$2() throws IOException {
            return (getAuthRequestContext() << 8) | getAuthRequestContext();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public final int BuiltInFictitiousFunctionClassFactory(byte[] bArr, int i) throws IOException {
            int i2 = 0;
            int i3 = 0;
            while (i3 < i && (i2 = this.KClassImpl$Data$declaredNonStaticMembers$2.read(bArr, i3, i - i3)) != -1) {
                i3 += i2;
            }
            if (i3 == 0 && i2 == -1) {
                throw new Reader.EndOfFileException();
            }
            return i3;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public final long PlaceComponentResult(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.KClassImpl$Data$declaredNonStaticMembers$2.skip(j2);
                if (skip <= 0) {
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        try {
            getonboardingscenario.MyBillsEntityDataFactory = i;
            int length = cArr.length;
            long[] jArr = new long[length];
            getonboardingscenario.getAuthRequestContext = 0;
            int i2 = $11 + 57;
            $10 = i2 % 128;
            while (true) {
                int i3 = i2 % 2;
                if (getonboardingscenario.getAuthRequestContext >= cArr.length) {
                    break;
                }
                jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (MyBillsEntityDataFactory ^ 4796183387843776835L);
                getonboardingscenario.getAuthRequestContext++;
                i2 = $10 + 5;
                $11 = i2 % 128;
            }
            char[] cArr2 = new char[length];
            getonboardingscenario.getAuthRequestContext = 0;
            while (true) {
                if ((getonboardingscenario.getAuthRequestContext < cArr.length ? '4' : 'Z') != '4') {
                    String str = new String(cArr2);
                    int i4 = $10 + 119;
                    $11 = i4 % 128;
                    int i5 = i4 % 2;
                    objArr[0] = str;
                    return;
                }
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                getonboardingscenario.getAuthRequestContext++;
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
