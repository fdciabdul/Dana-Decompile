package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* loaded from: classes3.dex */
public final class Downsampler {
    public static final Option<Boolean> BuiltInFictitiousFunctionClassFactory;
    private static final Set<ImageHeaderParser.ImageType> GetContactSyncConfig;
    public static final Option<Boolean> MyBillsEntityDataFactory;
    private static final Queue<BitmapFactory.Options> NetworkUserEntityData$$ExternalSyntheticLambda1;
    static final DecodeCallbacks PlaceComponentResult;
    private static final Set<String> initRecordTimeStamp;
    private final DisplayMetrics DatabaseTableConfigUtil;
    private final BitmapPool NetworkUserEntityData$$ExternalSyntheticLambda2;
    final List<ImageHeaderParser> getErrorConfigVersion;
    private final HardwareConfigState isLayoutRequested = HardwareConfigState.PlaceComponentResult();
    final ArrayPool scheduleImpl;
    public static final byte[] moveToNextValue = {56, -13, -61, 104, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int lookAheadTest = 64;
    public static final Option<DecodeFormat> KClassImpl$Data$declaredNonStaticMembers$2 = Option.PlaceComponentResult("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    public static final Option<PreferredColorSpace> NetworkUserEntityData$$ExternalSyntheticLambda0 = Option.PlaceComponentResult("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);
    @Deprecated
    public static final Option<DownsampleStrategy> getAuthRequestContext = DownsampleStrategy.scheduleImpl;

    /* loaded from: classes3.dex */
    public interface DecodeCallbacks {
        void PlaceComponentResult(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;

        void getAuthRequestContext();
    }

    public static boolean BuiltInFictitiousFunctionClassFactory() {
        return true;
    }

    private static boolean MyBillsEntityDataFactory(int i) {
        return i == 90 || i == 270;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 12
            int r6 = r6 + 4
            int r8 = r8 * 3
            int r8 = r8 + 13
            byte[] r0 = com.bumptech.glide.load.resource.bitmap.Downsampler.moveToNextValue
            int r7 = r7 * 7
            int r7 = r7 + 99
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L38
        L1a:
            r3 = 0
            r5 = r8
            r8 = r7
        L1d:
            r7 = r5
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L2d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2d:
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L38:
            int r6 = -r6
            int r9 = r9 + r6
            int r6 = r9 + 2
            int r7 = r7 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.a(short, short, byte, java.lang.Object[]):void");
    }

    public static boolean getAuthRequestContext() {
        return true;
    }

    static {
        Boolean bool = Boolean.FALSE;
        BuiltInFictitiousFunctionClassFactory = Option.PlaceComponentResult("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        MyBillsEntityDataFactory = Option.PlaceComponentResult("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        initRecordTimeStamp = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        PlaceComponentResult = new DecodeCallbacks() { // from class: com.bumptech.glide.load.resource.bitmap.Downsampler.1
            @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
            public final void PlaceComponentResult(BitmapPool bitmapPool, Bitmap bitmap) {
            }

            @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
            public final void getAuthRequestContext() {
            }
        };
        GetContactSyncConfig = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        NetworkUserEntityData$$ExternalSyntheticLambda1 = Util.BuiltInFictitiousFunctionClassFactory(0);
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.getErrorConfigVersion = list;
        this.DatabaseTableConfigUtil = (DisplayMetrics) Preconditions.PlaceComponentResult(displayMetrics);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = (BitmapPool) Preconditions.PlaceComponentResult(bitmapPool);
        this.scheduleImpl = (ArrayPool) Preconditions.PlaceComponentResult(arrayPool);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(27:1|(1:3)(1:268)|4|(1:6)(1:267)|7|(1:9)(1:266)|10|(1:12)(1:265)|13|(1:15)(1:264)|16|(20:(4:18|(1:20)(1:262)|21|(33:23|24|25|(26:29|30|(2:32|(1:34)(1:256))(1:258)|(3:251|252|(1:254)(1:255))(1:36)|37|38|39|(3:241|(1:243)(1:245)|244)(4:42|(1:44)(1:240)|45|(2:47|(16:49|50|(1:52)(1:235)|53|(3:229|(1:233)|234)(1:57)|58|(2:60|(1:62))(3:209|(1:228)(2:213|(2:223|(1:225)(1:226))(2:217|(1:222)(1:221)))|227)|63|64|65|(10:67|(1:69)(1:207)|70|71|72|73|74|(1:76)(1:206)|77|78)(1:208)|79|(1:81)(1:205)|82|(1:84)(1:204)|85)(2:236|237))(2:238|239))|86|87|(2:89|(1:108)(5:94|95|(1:97)(1:101)|98|(1:100)))|109|(1:111)(1:190)|112|(12:(1:115)|116|117|(4:119|(1:159)(1:125)|(1:127)(1:158)|128)(2:160|(1:162))|129|(4:131|132|133|134)|(2:143|(1:145))|146|147|613|152|153)|163|(15:165|(10:171|(4:174|(2:176|(1:178))(1:182)|(1:180)|181)|117|(0)(0)|129|(0)|(0)|146|147|613)|183|(1:185)(1:189)|186|(1:188)|(4:174|(0)(0)|(0)|181)|117|(0)(0)|129|(0)|(0)|146|147|613)|116|117|(0)(0)|129|(0)|(0)|146|147|613)|259|30|(0)(0)|(0)(0)|37|38|39|(0)|241|(0)(0)|244|86|87|(0)|109|(0)(0)|112|(0)|163|(0)|116|117|(0)(0)|129|(0)|(0)|146|147|613))|(29:29|30|(0)(0)|(0)(0)|37|38|39|(0)|241|(0)(0)|244|86|87|(0)|109|(0)(0)|112|(0)|163|(0)|116|117|(0)(0)|129|(0)|(0)|146|147|613)|86|87|(0)|109|(0)(0)|112|(0)|163|(0)|116|117|(0)(0)|129|(0)|(0)|146|147|613)|263|24|25|259|30|(0)(0)|(0)(0)|37|38|39|(0)|241|(0)(0)|244|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0626, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0627, code lost:
    
        r4 = r38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x062f, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0630, code lost:
    
        r4 = r38;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0366 A[Catch: all -> 0x0626, TRY_LEAVE, TryCatch #5 {all -> 0x0626, blocks: (B:55:0x0102, B:59:0x0115, B:61:0x011f, B:64:0x0147, B:66:0x014f, B:68:0x0158, B:70:0x015e, B:79:0x0181, B:81:0x0187, B:83:0x01a0, B:105:0x0201, B:113:0x0221, B:115:0x0248, B:121:0x0259, B:123:0x0262, B:125:0x0268, B:127:0x0273, B:129:0x027c, B:126:0x026d, B:85:0x01a7, B:87:0x01ab, B:89:0x01af, B:91:0x01b3, B:93:0x01b7, B:95:0x01bb, B:97:0x01bf, B:98:0x01c4, B:99:0x01d0, B:101:0x01d6, B:102:0x01e2, B:104:0x01ff, B:103:0x01f1, B:73:0x016a, B:75:0x0177, B:77:0x017e, B:67:0x0154, B:132:0x0301, B:133:0x0308, B:134:0x0309, B:135:0x0351, B:136:0x0352, B:138:0x0366), top: B:271:0x00fe }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03b0 A[Catch: all -> 0x0624, TryCatch #4 {all -> 0x0624, blocks: (B:142:0x0397, B:144:0x03b0, B:146:0x03b6, B:149:0x03bc, B:157:0x03e8, B:159:0x03ed, B:161:0x03f5, B:158:0x03eb, B:152:0x03c6, B:154:0x03cf, B:162:0x03f8, B:163:0x03fc, B:167:0x0405, B:199:0x04d7, B:201:0x04dd, B:203:0x04e3, B:205:0x04e7, B:210:0x04f4, B:212:0x04f9, B:216:0x050c, B:218:0x0522, B:220:0x05c6, B:222:0x05e4, B:224:0x05ea, B:225:0x05eb, B:227:0x05ee, B:229:0x0603, B:230:0x0608, B:211:0x04f7, B:213:0x0500, B:215:0x0504, B:172:0x0413, B:190:0x04bd, B:192:0x04c3, B:194:0x04c9, B:197:0x04cf, B:198:0x04d1, B:181:0x0428, B:183:0x042e, B:185:0x043b, B:187:0x0465, B:219:0x0592), top: B:270:0x0397, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x04c3 A[Catch: all -> 0x0624, TryCatch #4 {all -> 0x0624, blocks: (B:142:0x0397, B:144:0x03b0, B:146:0x03b6, B:149:0x03bc, B:157:0x03e8, B:159:0x03ed, B:161:0x03f5, B:158:0x03eb, B:152:0x03c6, B:154:0x03cf, B:162:0x03f8, B:163:0x03fc, B:167:0x0405, B:199:0x04d7, B:201:0x04dd, B:203:0x04e3, B:205:0x04e7, B:210:0x04f4, B:212:0x04f9, B:216:0x050c, B:218:0x0522, B:220:0x05c6, B:222:0x05e4, B:224:0x05ea, B:225:0x05eb, B:227:0x05ee, B:229:0x0603, B:230:0x0608, B:211:0x04f7, B:213:0x0500, B:215:0x0504, B:172:0x0413, B:190:0x04bd, B:192:0x04c3, B:194:0x04c9, B:197:0x04cf, B:198:0x04d1, B:181:0x0428, B:183:0x042e, B:185:0x043b, B:187:0x0465, B:219:0x0592), top: B:270:0x0397, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x04cf A[Catch: all -> 0x0624, TryCatch #4 {all -> 0x0624, blocks: (B:142:0x0397, B:144:0x03b0, B:146:0x03b6, B:149:0x03bc, B:157:0x03e8, B:159:0x03ed, B:161:0x03f5, B:158:0x03eb, B:152:0x03c6, B:154:0x03cf, B:162:0x03f8, B:163:0x03fc, B:167:0x0405, B:199:0x04d7, B:201:0x04dd, B:203:0x04e3, B:205:0x04e7, B:210:0x04f4, B:212:0x04f9, B:216:0x050c, B:218:0x0522, B:220:0x05c6, B:222:0x05e4, B:224:0x05ea, B:225:0x05eb, B:227:0x05ee, B:229:0x0603, B:230:0x0608, B:211:0x04f7, B:213:0x0500, B:215:0x0504, B:172:0x0413, B:190:0x04bd, B:192:0x04c3, B:194:0x04c9, B:197:0x04cf, B:198:0x04d1, B:181:0x0428, B:183:0x042e, B:185:0x043b, B:187:0x0465, B:219:0x0592), top: B:270:0x0397, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x04dd A[Catch: all -> 0x0624, TryCatch #4 {all -> 0x0624, blocks: (B:142:0x0397, B:144:0x03b0, B:146:0x03b6, B:149:0x03bc, B:157:0x03e8, B:159:0x03ed, B:161:0x03f5, B:158:0x03eb, B:152:0x03c6, B:154:0x03cf, B:162:0x03f8, B:163:0x03fc, B:167:0x0405, B:199:0x04d7, B:201:0x04dd, B:203:0x04e3, B:205:0x04e7, B:210:0x04f4, B:212:0x04f9, B:216:0x050c, B:218:0x0522, B:220:0x05c6, B:222:0x05e4, B:224:0x05ea, B:225:0x05eb, B:227:0x05ee, B:229:0x0603, B:230:0x0608, B:211:0x04f7, B:213:0x0500, B:215:0x0504, B:172:0x0413, B:190:0x04bd, B:192:0x04c3, B:194:0x04c9, B:197:0x04cf, B:198:0x04d1, B:181:0x0428, B:183:0x042e, B:185:0x043b, B:187:0x0465, B:219:0x0592), top: B:270:0x0397, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0500 A[Catch: all -> 0x0624, TryCatch #4 {all -> 0x0624, blocks: (B:142:0x0397, B:144:0x03b0, B:146:0x03b6, B:149:0x03bc, B:157:0x03e8, B:159:0x03ed, B:161:0x03f5, B:158:0x03eb, B:152:0x03c6, B:154:0x03cf, B:162:0x03f8, B:163:0x03fc, B:167:0x0405, B:199:0x04d7, B:201:0x04dd, B:203:0x04e3, B:205:0x04e7, B:210:0x04f4, B:212:0x04f9, B:216:0x050c, B:218:0x0522, B:220:0x05c6, B:222:0x05e4, B:224:0x05ea, B:225:0x05eb, B:227:0x05ee, B:229:0x0603, B:230:0x0608, B:211:0x04f7, B:213:0x0500, B:215:0x0504, B:172:0x0413, B:190:0x04bd, B:192:0x04c3, B:194:0x04c9, B:197:0x04cf, B:198:0x04d1, B:181:0x0428, B:183:0x042e, B:185:0x043b, B:187:0x0465, B:219:0x0592), top: B:270:0x0397, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0522 A[Catch: all -> 0x0624, TRY_LEAVE, TryCatch #4 {all -> 0x0624, blocks: (B:142:0x0397, B:144:0x03b0, B:146:0x03b6, B:149:0x03bc, B:157:0x03e8, B:159:0x03ed, B:161:0x03f5, B:158:0x03eb, B:152:0x03c6, B:154:0x03cf, B:162:0x03f8, B:163:0x03fc, B:167:0x0405, B:199:0x04d7, B:201:0x04dd, B:203:0x04e3, B:205:0x04e7, B:210:0x04f4, B:212:0x04f9, B:216:0x050c, B:218:0x0522, B:220:0x05c6, B:222:0x05e4, B:224:0x05ea, B:225:0x05eb, B:227:0x05ee, B:229:0x0603, B:230:0x0608, B:211:0x04f7, B:213:0x0500, B:215:0x0504, B:172:0x0413, B:190:0x04bd, B:192:0x04c3, B:194:0x04c9, B:197:0x04cf, B:198:0x04d1, B:181:0x0428, B:183:0x042e, B:185:0x043b, B:187:0x0465, B:219:0x0592), top: B:270:0x0397, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x05ee A[Catch: all -> 0x0624, TryCatch #4 {all -> 0x0624, blocks: (B:142:0x0397, B:144:0x03b0, B:146:0x03b6, B:149:0x03bc, B:157:0x03e8, B:159:0x03ed, B:161:0x03f5, B:158:0x03eb, B:152:0x03c6, B:154:0x03cf, B:162:0x03f8, B:163:0x03fc, B:167:0x0405, B:199:0x04d7, B:201:0x04dd, B:203:0x04e3, B:205:0x04e7, B:210:0x04f4, B:212:0x04f9, B:216:0x050c, B:218:0x0522, B:220:0x05c6, B:222:0x05e4, B:224:0x05ea, B:225:0x05eb, B:227:0x05ee, B:229:0x0603, B:230:0x0608, B:211:0x04f7, B:213:0x0500, B:215:0x0504, B:172:0x0413, B:190:0x04bd, B:192:0x04c3, B:194:0x04c9, B:197:0x04cf, B:198:0x04d1, B:181:0x0428, B:183:0x042e, B:185:0x043b, B:187:0x0465, B:219:0x0592), top: B:270:0x0397, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0614 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0637 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d6 A[Catch: all -> 0x062f, TRY_LEAVE, TryCatch #7 {all -> 0x062f, blocks: (B:32:0x00ab, B:38:0x00c4, B:40:0x00d6), top: B:274:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0100 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r43v0, types: [com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> PlaceComponentResult(com.bumptech.glide.load.resource.bitmap.ImageReader r39, int r40, int r41, com.bumptech.glide.load.Options r42, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r43) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1607
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.PlaceComponentResult(com.bumptech.glide.load.resource.bitmap.ImageReader, int, int, com.bumptech.glide.load.Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks):com.bumptech.glide.load.engine.Resource");
    }

    private static boolean getAuthRequestContext(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return GetContactSyncConfig.contains(imageType);
    }

    private static int[] BuiltInFictitiousFunctionClassFactory(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) throws IOException {
        options.inJustDecodeBounds = true;
        MyBillsEntityDataFactory(imageReader, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap MyBillsEntityDataFactory(com.bumptech.glide.load.resource.bitmap.ImageReader r7, android.graphics.BitmapFactory.Options r8, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r9, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r10) throws java.io.IOException {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r8.inJustDecodeBounds
            if (r1 != 0) goto Lc
            r9.getAuthRequestContext()
            r7.getAuthRequestContext()
        Lc:
            int r1 = r8.outWidth
            int r2 = r8.outHeight
            java.lang.String r3 = r8.outMimeType
            java.util.concurrent.locks.Lock r4 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.MyBillsEntityDataFactory()
            r4.lock()
            android.graphics.Bitmap r7 = r7.KClassImpl$Data$declaredNonStaticMembers$2(r8)     // Catch: java.lang.Throwable -> L25 java.lang.IllegalArgumentException -> L27
        L1d:
            java.util.concurrent.locks.Lock r8 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.MyBillsEntityDataFactory()
            r8.unlock()
            return r7
        L25:
            r7 = move-exception
            goto L7b
        L27:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L25
            r5.<init>()     // Catch: java.lang.Throwable -> L25
            java.lang.String r6 = "Exception decoding bitmap, outWidth: "
            r5.append(r6)     // Catch: java.lang.Throwable -> L25
            r5.append(r1)     // Catch: java.lang.Throwable -> L25
            java.lang.String r1 = ", outHeight: "
            r5.append(r1)     // Catch: java.lang.Throwable -> L25
            r5.append(r2)     // Catch: java.lang.Throwable -> L25
            java.lang.String r1 = ", outMimeType: "
            r5.append(r1)     // Catch: java.lang.Throwable -> L25
            r5.append(r3)     // Catch: java.lang.Throwable -> L25
            java.lang.String r1 = ", inBitmap: "
            r5.append(r1)     // Catch: java.lang.Throwable -> L25
            android.graphics.Bitmap r1 = r8.inBitmap     // Catch: java.lang.Throwable -> L25
            java.lang.String r1 = MyBillsEntityDataFactory(r1)     // Catch: java.lang.Throwable -> L25
            r5.append(r1)     // Catch: java.lang.Throwable -> L25
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L25
            java.lang.String r2 = r5.toString()     // Catch: java.lang.Throwable -> L25
            r1.<init>(r2, r4)     // Catch: java.lang.Throwable -> L25
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L68
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            com.fullstory.instrumentation.InstrumentInjector.log_d(r0, r2, r1)     // Catch: java.lang.Throwable -> L25
        L68:
            android.graphics.Bitmap r0 = r8.inBitmap     // Catch: java.lang.Throwable -> L25
            if (r0 == 0) goto L7a
            android.graphics.Bitmap r0 = r8.inBitmap     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L79
            r10.PlaceComponentResult(r0)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L79
            r0 = 0
            r8.inBitmap = r0     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L79
            android.graphics.Bitmap r7 = MyBillsEntityDataFactory(r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L79
            goto L1d
        L79:
            throw r1     // Catch: java.lang.Throwable -> L25
        L7a:
            throw r1     // Catch: java.lang.Throwable -> L25
        L7b:
            java.util.concurrent.locks.Lock r8 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.MyBillsEntityDataFactory()
            r8.unlock()
            goto L84
        L83:
            throw r7
        L84:
            goto L83
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.MyBillsEntityDataFactory(com.bumptech.glide.load.resource.bitmap.ImageReader, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    private static boolean getAuthRequestContext(BitmapFactory.Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    private static String MyBillsEntityDataFactory(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            StringBuilder sb = new StringBuilder();
            sb.append(" (");
            sb.append(bitmap.getAllocationByteCount());
            sb.append(")");
            str = sb.toString();
        } else {
            str = "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        sb2.append(bitmap.getWidth());
        sb2.append("x");
        sb2.append(bitmap.getHeight());
        sb2.append("] ");
        sb2.append(bitmap.getConfig());
        sb2.append(str);
        return sb2.toString();
    }

    private static BitmapFactory.Options MyBillsEntityDataFactory() {
        BitmapFactory.Options poll;
        synchronized (Downsampler.class) {
            Queue<BitmapFactory.Options> queue = NetworkUserEntityData$$ExternalSyntheticLambda1;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                KClassImpl$Data$declaredNonStaticMembers$2(poll);
            }
        }
        return poll;
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }
}
