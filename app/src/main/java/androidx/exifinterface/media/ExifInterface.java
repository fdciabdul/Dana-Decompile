package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.base.resource.cache.CacheTypeDef;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.aplog.util.zip.LZMA_Base;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import id.dana.domain.model.KycStatus;
import j$.util.DesugarTimeZone;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* loaded from: classes3.dex */
public class ExifInterface {
    private static final ExifTag[] FragmentBottomSheetPaymentSettingBinding;
    private static final HashMap<Integer, ExifTag>[] J;
    private static SimpleDateFormat L;
    private static final HashMap<String, ExifTag>[] M;
    private static final ExifTag[] NetworkUserEntityData$$ExternalSyntheticLambda3;
    private static final ExifTag[] NetworkUserEntityData$$ExternalSyntheticLambda4;
    private static final ExifTag NetworkUserEntityData$$ExternalSyntheticLambda5;
    private static final ExifTag NetworkUserEntityData$$ExternalSyntheticLambda6;
    private static final ExifTag[] NetworkUserEntityData$$ExternalSyntheticLambda8;
    private static final HashSet<String> P;
    static final Charset PlaceComponentResult;
    private static final ExifTag[] PrepareContext;
    private static final Pattern Q;
    private static final ExifTag[] SubSequence;
    private static final Pattern SummaryVoucherView$$ExternalSyntheticLambda0;
    static final ExifTag[][] getErrorConfigVersion;
    private static final HashMap<Integer, Integer> getNameOrBuilderList;
    private static final ExifTag getOnBoardingScenario;
    private static final ExifTag[] getSupportButtonTintMode;
    private static final ExifTag[] initRecordTimeStamp;
    private static final ExifTag[] isLayoutRequested;
    static final byte[] lookAheadTest;
    private static final byte[] newProxyInstance;
    private static final ExifTag[] whenAvailable;
    private AssetManager.AssetInputStream N;
    private boolean O;
    private int QrExpiredActivity;
    private int R;
    private String S;
    private ByteOrder SummaryVoucherView$$ExternalSyntheticLambda1;
    private Set<Integer> SummaryVoucherView$$ExternalSyntheticLambda2;
    private boolean T;
    private int U;
    private boolean V;
    private boolean W;
    private boolean X;
    private int Y;
    private int Z;

    /* renamed from: a  reason: collision with root package name */
    private boolean f5953a;
    private int b;
    private int c;
    private byte[] d;
    private int flip;
    private final HashMap<String, ExifAttribute>[] isAuth;
    private int isAuto;
    private FileDescriptor shouldRecycleViewType;
    private static final boolean NetworkUserEntityData$$ExternalSyntheticLambda1 = Log.isLoggable("ExifInterface", 3);
    private static final List<Integer> B = Arrays.asList(1, 6, 3, 8);
    private static final List<Integer> DatabaseTableConfigUtil = Arrays.asList(2, 7, 4, 5);
    public static final int[] KClassImpl$Data$declaredNonStaticMembers$2 = {8, 8, 8};
    public static final int[] BuiltInFictitiousFunctionClassFactory = {4};
    public static final int[] MyBillsEntityDataFactory = {8};
    static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {-1, -40, -1};
    private static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda7 = {102, 116, 121, 112};
    private static final byte[] GetContactSyncConfig = {109, 105, 102, TarHeader.LF_LINK};
    private static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda2 = {104, 101, 105, 99};
    private static final byte[] getCallingPid = {79, 76, 89, 77, 80, 0};
    private static final byte[] readMicros = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final byte[] VerifyPinStateManager$executeRiskChallenge$2$1 = {-119, 80, 78, 71, 13, 10, Ascii.SUB, 10};
    private static final byte[] C = {101, 88, 73, 102};
    private static final byte[] A = {73, 72, 68, 82};
    private static final byte[] BottomSheetCardBindingView$watcherCardNumberView$1 = {73, 69, 78, 68};
    private static final byte[] H = {82, 73, 70, 70};
    private static final byte[] F = {87, 69, 66, 80};
    private static final byte[] D = {69, 88, 73, 70};
    private static final byte[] K = {-99, 1, 42};
    private static final byte[] I = "VP8X".getBytes(Charset.defaultCharset());
    private static final byte[] AppCompatEmojiTextHelper = "VP8L".getBytes(Charset.defaultCharset());
    private static final byte[] VerifyPinStateManager$executeRiskChallenge$2$2 = "VP8 ".getBytes(Charset.defaultCharset());
    private static final byte[] getValueOfTouchPositionAbsolute = "ANIM".getBytes(Charset.defaultCharset());
    private static final byte[] E = "ANMF".getBytes(Charset.defaultCharset());
    private static final byte[] G = "XMP ".getBytes(Charset.defaultCharset());
    static final String[] scheduleImpl = {"", "BYTE", CacheTypeDef.CACHE_TYPE_STRING, "USHORT", "ULONG", "URATIONAL", "SBYTE", KycStatus.UNDEFINED, "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int[] moveToNextValue = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] getAuthRequestContext = {65, 83, 67, 73, 73, 0, 0, 0};

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ExifStreamType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface IfdType {
    }

    static {
        ExifTag[] exifTagArr = {new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", 255, 4), new ExifTag("ImageWidth", 256), new ExifTag("ImageLength", DeepRecoverARiverProxy.TYPE_ENTITY_APP), new ExifTag("BitsPerSample", DeepRecoverARiverProxy.TYPE_ENTITY_TEMPLATE, 3), new ExifTag("Compression", DeepRecoverARiverProxy.TYPE_ENTITY_PLUGIN, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", LZMA_Base.kNumLenSymbols, 2), new ExifTag("StripOffsets", LZMA_Base.kMatchMaxLen), new ExifTag("Orientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278), new ExifTag("StripByteCounts", 279), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", SecExceptionCode.SEC_ERROR_STA_INCORRECT_DATA_FILE_DATA, 2), new ExifTag("DateTime", SecExceptionCode.SEC_ERROR_STA_KEY_NOT_EXISTED, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag("JPEGInterchangeFormat", DeepRecoverARiverProxy.TYPE_EXCEPTION_WHITE_SCREEN, 4), new ExifTag("JPEGInterchangeFormatLength", DeepRecoverARiverProxy.TYPE_EXCEPTION_CANNOT_OPEN_APP, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", 532, 5), new ExifTag("Copyright", 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("SensorTopBorder", 4, 4), new ExifTag("SensorLeftBorder", 5, 4), new ExifTag("SensorBottomBorder", 6, 4), new ExifTag("SensorRightBorder", 7, 4), new ExifTag("ISO", 23, 3), new ExifTag("JpgFromRaw", 46, 7), new ExifTag("Xmp", 700, 1)};
        NetworkUserEntityData$$ExternalSyntheticLambda4 = exifTagArr;
        ExifTag[] exifTagArr2 = {new ExifTag("ExposureTime", 33434, 5), new ExifTag("FNumber", 33437, 5), new ExifTag("ExposureProgram", 34850, 3), new ExifTag("SpectralSensitivity", 34852, 2), new ExifTag("PhotographicSensitivity", 34855, 3), new ExifTag("OECF", 34856, 7), new ExifTag("SensitivityType", 34864, 3), new ExifTag("StandardOutputSensitivity", 34865, 4), new ExifTag("RecommendedExposureIndex", 34866, 4), new ExifTag("ISOSpeed", 34867, 4), new ExifTag("ISOSpeedLatitudeyyy", 34868, 4), new ExifTag("ISOSpeedLatitudezzz", 34869, 4), new ExifTag("ExifVersion", 36864, 2), new ExifTag("DateTimeOriginal", 36867, 2), new ExifTag("DateTimeDigitized", 36868, 2), new ExifTag("OffsetTime", 36880, 2), new ExifTag("OffsetTimeOriginal", 36881, 2), new ExifTag("OffsetTimeDigitized", 36882, 2), new ExifTag("ComponentsConfiguration", 37121, 7), new ExifTag("CompressedBitsPerPixel", 37122, 5), new ExifTag("ShutterSpeedValue", 37377, 10), new ExifTag("ApertureValue", 37378, 5), new ExifTag("BrightnessValue", 37379, 10), new ExifTag("ExposureBiasValue", 37380, 10), new ExifTag("MaxApertureValue", 37381, 5), new ExifTag("SubjectDistance", 37382, 5), new ExifTag("MeteringMode", 37383, 3), new ExifTag("LightSource", 37384, 3), new ExifTag("Flash", 37385, 3), new ExifTag("FocalLength", 37386, 5), new ExifTag("SubjectArea", 37396, 3), new ExifTag("MakerNote", 37500, 7), new ExifTag("UserComment", 37510, 7), new ExifTag("SubSecTime", 37520, 2), new ExifTag("SubSecTimeOriginal", 37521, 2), new ExifTag("SubSecTimeDigitized", 37522, 2), new ExifTag("FlashpixVersion", 40960, 7), new ExifTag("ColorSpace", 40961, 3), new ExifTag("PixelXDimension", 40962), new ExifTag("PixelYDimension", 40963), new ExifTag("RelatedSoundFile", 40964, 2), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("FlashEnergy", 41483, 5), new ExifTag("SpatialFrequencyResponse", 41484, 7), new ExifTag("FocalPlaneXResolution", 41486, 5), new ExifTag("FocalPlaneYResolution", 41487, 5), new ExifTag("FocalPlaneResolutionUnit", 41488, 3), new ExifTag("SubjectLocation", 41492, 3), new ExifTag("ExposureIndex", 41493, 5), new ExifTag("SensingMethod", 41495, 3), new ExifTag("FileSource", 41728, 7), new ExifTag("SceneType", 41729, 7), new ExifTag("CFAPattern", 41730, 7), new ExifTag("CustomRendered", 41985, 3), new ExifTag("ExposureMode", 41986, 3), new ExifTag("WhiteBalance", 41987, 3), new ExifTag("DigitalZoomRatio", 41988, 5), new ExifTag("FocalLengthIn35mmFilm", 41989, 3), new ExifTag("SceneCaptureType", 41990, 3), new ExifTag("GainControl", 41991, 3), new ExifTag("Contrast", 41992, 3), new ExifTag("Saturation", 41993, 3), new ExifTag("Sharpness", 41994, 3), new ExifTag("DeviceSettingDescription", 41995, 7), new ExifTag("SubjectDistanceRange", 41996, 3), new ExifTag("ImageUniqueID", 42016, 2), new ExifTag("CameraOwnerName", 42032, 2), new ExifTag("BodySerialNumber", 42033, 2), new ExifTag("LensSpecification", 42034, 5), new ExifTag("LensMake", 42035, 2), new ExifTag("LensModel", 42036, 2), new ExifTag("Gamma", 42240, 5), new ExifTag("DNGVersion", 50706, 1), new ExifTag("DefaultCropSize", 50720)};
        isLayoutRequested = exifTagArr2;
        ExifTag[] exifTagArr3 = {new ExifTag("GPSVersionID", 0, 1), new ExifTag("GPSLatitudeRef", 1, 2), new ExifTag("GPSLatitude", 2, 5), new ExifTag("GPSLongitudeRef", 3, 2), new ExifTag("GPSLongitude", 4, 5), new ExifTag("GPSAltitudeRef", 5, 1), new ExifTag("GPSAltitude", 6, 5), new ExifTag("GPSTimeStamp", 7, 5), new ExifTag("GPSSatellites", 8, 2), new ExifTag("GPSStatus", 9, 2), new ExifTag("GPSMeasureMode", 10, 2), new ExifTag("GPSDOP", 11, 5), new ExifTag("GPSSpeedRef", 12, 2), new ExifTag("GPSSpeed", 13, 5), new ExifTag("GPSTrackRef", 14, 2), new ExifTag("GPSTrack", 15, 5), new ExifTag("GPSImgDirectionRef", 16, 2), new ExifTag("GPSImgDirection", 17, 5), new ExifTag("GPSMapDatum", 18, 2), new ExifTag("GPSDestLatitudeRef", 19, 2), new ExifTag("GPSDestLatitude", 20, 5), new ExifTag("GPSDestLongitudeRef", 21, 2), new ExifTag("GPSDestLongitude", 22, 5), new ExifTag("GPSDestBearingRef", 23, 2), new ExifTag("GPSDestBearing", 24, 5), new ExifTag("GPSDestDistanceRef", 25, 2), new ExifTag("GPSDestDistance", 26, 5), new ExifTag("GPSProcessingMethod", 27, 7), new ExifTag("GPSAreaInformation", 28, 7), new ExifTag("GPSDateStamp", 29, 2), new ExifTag("GPSDifferential", 30, 3), new ExifTag("GPSHPositioningError", 31, 5)};
        NetworkUserEntityData$$ExternalSyntheticLambda8 = exifTagArr3;
        ExifTag[] exifTagArr4 = {new ExifTag("InteroperabilityIndex", 1, 2)};
        PrepareContext = exifTagArr4;
        ExifTag[] exifTagArr5 = {new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", 255, 4), new ExifTag("ThumbnailImageWidth", 256), new ExifTag("ThumbnailImageLength", DeepRecoverARiverProxy.TYPE_ENTITY_APP), new ExifTag("BitsPerSample", DeepRecoverARiverProxy.TYPE_ENTITY_TEMPLATE, 3), new ExifTag("Compression", DeepRecoverARiverProxy.TYPE_ENTITY_PLUGIN, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", LZMA_Base.kNumLenSymbols, 2), new ExifTag("StripOffsets", LZMA_Base.kMatchMaxLen), new ExifTag("ThumbnailOrientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278), new ExifTag("StripByteCounts", 279), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", SecExceptionCode.SEC_ERROR_STA_INCORRECT_DATA_FILE_DATA, 2), new ExifTag("DateTime", SecExceptionCode.SEC_ERROR_STA_KEY_NOT_EXISTED, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag("JPEGInterchangeFormat", DeepRecoverARiverProxy.TYPE_EXCEPTION_WHITE_SCREEN, 4), new ExifTag("JPEGInterchangeFormatLength", DeepRecoverARiverProxy.TYPE_EXCEPTION_CANNOT_OPEN_APP, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", 532, 5), new ExifTag("Copyright", 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("DNGVersion", 50706, 1), new ExifTag("DefaultCropSize", 50720)};
        FragmentBottomSheetPaymentSettingBinding = exifTagArr5;
        getOnBoardingScenario = new ExifTag("StripOffsets", LZMA_Base.kMatchMaxLen, 3);
        ExifTag[] exifTagArr6 = {new ExifTag("ThumbnailImage", 256, 7), new ExifTag("CameraSettingsIFDPointer", 8224, 4), new ExifTag("ImageProcessingIFDPointer", 8256, 4)};
        SubSequence = exifTagArr6;
        ExifTag[] exifTagArr7 = {new ExifTag("PreviewImageStart", DeepRecoverARiverProxy.TYPE_ENTITY_APP, 4), new ExifTag("PreviewImageLength", DeepRecoverARiverProxy.TYPE_ENTITY_TEMPLATE, 4)};
        NetworkUserEntityData$$ExternalSyntheticLambda3 = exifTagArr7;
        ExifTag[] exifTagArr8 = {new ExifTag("AspectFrame", 4371, 3)};
        whenAvailable = exifTagArr8;
        ExifTag[] exifTagArr9 = {new ExifTag("ColorSpace", 55, 3)};
        getSupportButtonTintMode = exifTagArr9;
        getErrorConfigVersion = new ExifTag[][]{exifTagArr, exifTagArr2, exifTagArr3, exifTagArr4, exifTagArr5, exifTagArr, exifTagArr6, exifTagArr7, exifTagArr8, exifTagArr9};
        initRecordTimeStamp = new ExifTag[]{new ExifTag("SubIFDPointer", 330, 4), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("CameraSettingsIFDPointer", 8224, 1), new ExifTag("ImageProcessingIFDPointer", 8256, 1)};
        NetworkUserEntityData$$ExternalSyntheticLambda6 = new ExifTag("JPEGInterchangeFormat", DeepRecoverARiverProxy.TYPE_EXCEPTION_WHITE_SCREEN, 4);
        NetworkUserEntityData$$ExternalSyntheticLambda5 = new ExifTag("JPEGInterchangeFormatLength", DeepRecoverARiverProxy.TYPE_EXCEPTION_CANNOT_OPEN_APP, 4);
        J = new HashMap[10];
        M = new HashMap[10];
        P = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        getNameOrBuilderList = new HashMap<>();
        Charset forName = Charset.forName("US-ASCII");
        PlaceComponentResult = forName;
        lookAheadTest = "Exif\u0000\u0000".getBytes(forName);
        newProxyInstance = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        L = simpleDateFormat;
        simpleDateFormat.setTimeZone(DesugarTimeZone.BuiltInFictitiousFunctionClassFactory("UTC"));
        int i = 0;
        while (true) {
            ExifTag[][] exifTagArr10 = getErrorConfigVersion;
            if (i < exifTagArr10.length) {
                J[i] = new HashMap<>();
                M[i] = new HashMap<>();
                for (ExifTag exifTag : exifTagArr10[i]) {
                    J[i].put(Integer.valueOf(exifTag.BuiltInFictitiousFunctionClassFactory), exifTag);
                    M[i].put(exifTag.KClassImpl$Data$declaredNonStaticMembers$2, exifTag);
                }
                i++;
            } else {
                HashMap<Integer, Integer> hashMap = getNameOrBuilderList;
                ExifTag[] exifTagArr11 = initRecordTimeStamp;
                hashMap.put(Integer.valueOf(exifTagArr11[0].BuiltInFictitiousFunctionClassFactory), 5);
                hashMap.put(Integer.valueOf(exifTagArr11[1].BuiltInFictitiousFunctionClassFactory), 1);
                hashMap.put(Integer.valueOf(exifTagArr11[2].BuiltInFictitiousFunctionClassFactory), 2);
                hashMap.put(Integer.valueOf(exifTagArr11[3].BuiltInFictitiousFunctionClassFactory), 3);
                hashMap.put(Integer.valueOf(exifTagArr11[4].BuiltInFictitiousFunctionClassFactory), 7);
                hashMap.put(Integer.valueOf(exifTagArr11[5].BuiltInFictitiousFunctionClassFactory), 8);
                Q = Pattern.compile(".*[1-9].*");
                SummaryVoucherView$$ExternalSyntheticLambda0 = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Rational {
        public final long BuiltInFictitiousFunctionClassFactory;
        public final long getAuthRequestContext;

        Rational(long j, long j2) {
            if (j2 == 0) {
                this.BuiltInFictitiousFunctionClassFactory = 0L;
                this.getAuthRequestContext = 1L;
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = j;
            this.getAuthRequestContext = j2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append("/");
            sb.append(this.getAuthRequestContext);
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ExifAttribute {
        public final byte[] BuiltInFictitiousFunctionClassFactory;
        public final long MyBillsEntityDataFactory;
        public final int PlaceComponentResult;
        public final int getAuthRequestContext;

        private ExifAttribute(int i, int i2, byte[] bArr) {
            this(i, i2, -1L, bArr);
        }

        ExifAttribute(int i, int i2, long j, byte[] bArr) {
            this.getAuthRequestContext = i;
            this.PlaceComponentResult = i2;
            this.MyBillsEntityDataFactory = j;
            this.BuiltInFictitiousFunctionClassFactory = bArr;
        }

        public static ExifAttribute BuiltInFictitiousFunctionClassFactory(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append((char) 0);
            byte[] bytes = sb.toString().getBytes(ExifInterface.PlaceComponentResult);
            return new ExifAttribute(2, bytes.length, bytes);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(ExifInterface.scheduleImpl[this.getAuthRequestContext]);
            sb.append(", data length:");
            sb.append(this.BuiltInFictitiousFunctionClassFactory.length);
            sb.append(")");
            return sb.toString();
        }

        /* JADX WARN: Not initialized variable reg: 3, insn: 0x018f: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:137:0x018f */
        /* JADX WARN: Removed duplicated region for block: B:168:0x01a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final java.lang.Object KClassImpl$Data$declaredNonStaticMembers$2(java.nio.ByteOrder r13) {
            /*
                Method dump skipped, instructions count: 464
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.ExifAttribute.KClassImpl$Data$declaredNonStaticMembers$2(java.nio.ByteOrder):java.lang.Object");
        }

        public final int getAuthRequestContext(ByteOrder byteOrder) {
            Object KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(byteOrder);
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (KClassImpl$Data$declaredNonStaticMembers$2 instanceof String) {
                return Integer.parseInt((String) KClassImpl$Data$declaredNonStaticMembers$2);
            }
            if (KClassImpl$Data$declaredNonStaticMembers$2 instanceof long[]) {
                long[] jArr = (long[]) KClassImpl$Data$declaredNonStaticMembers$2;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            } else if (KClassImpl$Data$declaredNonStaticMembers$2 instanceof int[]) {
                int[] iArr = (int[]) KClassImpl$Data$declaredNonStaticMembers$2;
                if (iArr.length == 1) {
                    return iArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            } else {
                throw new NumberFormatException("Couldn't find a integer value");
            }
        }

        public final String MyBillsEntityDataFactory(ByteOrder byteOrder) {
            Object KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(byteOrder);
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                return null;
            }
            if (KClassImpl$Data$declaredNonStaticMembers$2 instanceof String) {
                return (String) KClassImpl$Data$declaredNonStaticMembers$2;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (KClassImpl$Data$declaredNonStaticMembers$2 instanceof long[]) {
                long[] jArr = (long[]) KClassImpl$Data$declaredNonStaticMembers$2;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (KClassImpl$Data$declaredNonStaticMembers$2 instanceof int[]) {
                int[] iArr = (int[]) KClassImpl$Data$declaredNonStaticMembers$2;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (KClassImpl$Data$declaredNonStaticMembers$2 instanceof double[]) {
                double[] dArr = (double[]) KClassImpl$Data$declaredNonStaticMembers$2;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (KClassImpl$Data$declaredNonStaticMembers$2 instanceof Rational[]) {
                Rational[] rationalArr = (Rational[]) KClassImpl$Data$declaredNonStaticMembers$2;
                while (i < rationalArr.length) {
                    sb.append(rationalArr[i].BuiltInFictitiousFunctionClassFactory);
                    sb.append('/');
                    sb.append(rationalArr[i].getAuthRequestContext);
                    i++;
                    if (i != rationalArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else {
                return null;
            }
        }

        public static ExifAttribute BuiltInFictitiousFunctionClassFactory(long j, ByteOrder byteOrder) {
            long[] jArr = {j};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.moveToNextValue[4] * 1]);
            wrap.order(byteOrder);
            for (int i = 0; i <= 0; i++) {
                wrap.putInt((int) jArr[0]);
            }
            return new ExifAttribute(4, 1, wrap.array());
        }

        public static ExifAttribute KClassImpl$Data$declaredNonStaticMembers$2(Rational rational, ByteOrder byteOrder) {
            Rational[] rationalArr = {rational};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.moveToNextValue[5] * 1]);
            wrap.order(byteOrder);
            for (int i = 0; i <= 0; i++) {
                Rational rational2 = rationalArr[0];
                wrap.putInt((int) rational2.BuiltInFictitiousFunctionClassFactory);
                wrap.putInt((int) rational2.getAuthRequestContext);
            }
            return new ExifAttribute(5, 1, wrap.array());
        }

        public static ExifAttribute getAuthRequestContext(int i, ByteOrder byteOrder) {
            int[] iArr = {i};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.moveToNextValue[3] * 1]);
            wrap.order(byteOrder);
            for (int i2 = 0; i2 <= 0; i2++) {
                wrap.putShort((short) iArr[0]);
            }
            return new ExifAttribute(3, 1, wrap.array());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ExifTag {
        public final int BuiltInFictitiousFunctionClassFactory;
        public final String KClassImpl$Data$declaredNonStaticMembers$2;
        public final int PlaceComponentResult;
        public final int getAuthRequestContext;

        ExifTag(String str, int i, int i2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.PlaceComponentResult = i2;
            this.getAuthRequestContext = -1;
        }

        ExifTag(String str, int i) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.PlaceComponentResult = 3;
            this.getAuthRequestContext = 4;
        }

        final boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            int i2;
            int i3 = this.PlaceComponentResult;
            if (i3 == 7 || i == 7 || i3 == i || (i2 = this.getAuthRequestContext) == i) {
                return true;
            }
            if ((i3 == 4 || i2 == 4) && i == 3) {
                return true;
            }
            if ((i3 == 9 || i2 == 9) && i == 8) {
                return true;
            }
            return (i3 == 12 || i2 == 12) && i == 11;
        }
    }

    public ExifInterface(InputStream inputStream) throws IOException {
        this(inputStream, (byte) 0);
    }

    private ExifInterface(InputStream inputStream, byte b) throws IOException {
        int i;
        int i2;
        int i3;
        String str;
        String str2;
        String str3;
        int i4;
        BufferedInputStream bufferedInputStream = inputStream;
        ExifTag[][] exifTagArr = getErrorConfigVersion;
        this.isAuth = new HashMap[exifTagArr.length];
        this.SummaryVoucherView$$ExternalSyntheticLambda2 = new HashSet(exifTagArr.length);
        this.SummaryVoucherView$$ExternalSyntheticLambda1 = ByteOrder.BIG_ENDIAN;
        if (bufferedInputStream == null) {
            throw new NullPointerException("inputStream cannot be null");
        }
        this.S = null;
        if (bufferedInputStream instanceof AssetManager.AssetInputStream) {
            this.N = (AssetManager.AssetInputStream) bufferedInputStream;
            this.shouldRecycleViewType = null;
        } else {
            if (bufferedInputStream instanceof FileInputStream) {
                FileInputStream fileInputStream = (FileInputStream) bufferedInputStream;
                if (PlaceComponentResult(fileInputStream.getFD())) {
                    this.N = null;
                    this.shouldRecycleViewType = fileInputStream.getFD();
                }
            }
            this.N = null;
            this.shouldRecycleViewType = null;
        }
        if (bufferedInputStream == null) {
            throw new NullPointerException("inputstream shouldn't be null");
        }
        for (int i5 = 0; i5 < getErrorConfigVersion.length; i5++) {
            try {
                try {
                    this.isAuth[i5] = new HashMap<>();
                } finally {
                }
            } catch (IOException e) {
                this.W = false;
                boolean z = NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (z) {
                    InstrumentInjector.log_w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                }
                MyBillsEntityDataFactory();
                if (!z) {
                    return;
                }
            }
        }
        if (!this.V) {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(bufferedInputStream, 5000);
            BufferedInputStream bufferedInputStream3 = bufferedInputStream2;
            bufferedInputStream2.mark(5000);
            byte[] bArr = new byte[5000];
            bufferedInputStream2.read(bArr);
            bufferedInputStream2.reset();
            if (MyBillsEntityDataFactory(bArr)) {
                i4 = 4;
            } else if (lookAheadTest(bArr)) {
                i4 = 9;
            } else if (getAuthRequestContext(bArr)) {
                i4 = 12;
            } else if (BuiltInFictitiousFunctionClassFactory(bArr)) {
                i4 = 7;
            } else if (scheduleImpl(bArr)) {
                i4 = 10;
            } else if (PlaceComponentResult(bArr)) {
                i4 = 13;
            } else {
                i4 = NetworkUserEntityData$$ExternalSyntheticLambda0(bArr) ? 14 : 0;
            }
            this.U = i4;
            bufferedInputStream = bufferedInputStream2;
        }
        final ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bufferedInputStream);
        if (!this.V) {
            switch (this.U) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 5:
                case 6:
                case 8:
                case 11:
                    BuiltInFictitiousFunctionClassFactory(byteOrderedDataInputStream);
                    break;
                case 4:
                    PlaceComponentResult(byteOrderedDataInputStream, 0, 0);
                    break;
                case 7:
                    BuiltInFictitiousFunctionClassFactory(byteOrderedDataInputStream);
                    ExifAttribute exifAttribute = this.isAuth[1].get("MakerNote");
                    if (exifAttribute != null) {
                        ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute.BuiltInFictitiousFunctionClassFactory);
                        byteOrderedDataInputStream2.getAuthRequestContext = this.SummaryVoucherView$$ExternalSyntheticLambda1;
                        byte[] bArr2 = getCallingPid;
                        byte[] bArr3 = new byte[bArr2.length];
                        byteOrderedDataInputStream2.readFully(bArr3);
                        byteOrderedDataInputStream2.KClassImpl$Data$declaredNonStaticMembers$2(0L);
                        byte[] bArr4 = readMicros;
                        byte[] bArr5 = new byte[bArr4.length];
                        byteOrderedDataInputStream2.readFully(bArr5);
                        if (Arrays.equals(bArr3, bArr2)) {
                            byteOrderedDataInputStream2.KClassImpl$Data$declaredNonStaticMembers$2(8L);
                        } else if (Arrays.equals(bArr5, bArr4)) {
                            byteOrderedDataInputStream2.KClassImpl$Data$declaredNonStaticMembers$2(12L);
                        }
                        BuiltInFictitiousFunctionClassFactory(byteOrderedDataInputStream2, 6);
                        ExifAttribute exifAttribute2 = this.isAuth[7].get("PreviewImageStart");
                        ExifAttribute exifAttribute3 = this.isAuth[7].get("PreviewImageLength");
                        if (exifAttribute2 != null && exifAttribute3 != null) {
                            this.isAuth[5].put("JPEGInterchangeFormat", exifAttribute2);
                            this.isAuth[5].put("JPEGInterchangeFormatLength", exifAttribute3);
                        }
                        ExifAttribute exifAttribute4 = this.isAuth[8].get("AspectFrame");
                        if (exifAttribute4 != null) {
                            int[] iArr = (int[]) exifAttribute4.KClassImpl$Data$declaredNonStaticMembers$2(this.SummaryVoucherView$$ExternalSyntheticLambda1);
                            if (iArr == null || iArr.length != 4) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Invalid aspect frame values. frame=");
                                sb.append(Arrays.toString(iArr));
                                InstrumentInjector.log_w("ExifInterface", sb.toString());
                                break;
                            } else {
                                int i6 = iArr[2];
                                int i7 = iArr[0];
                                if (i6 > i7 && (i2 = iArr[3]) > (i3 = iArr[1])) {
                                    int i8 = (i6 - i7) + 1;
                                    int i9 = (i2 - i3) + 1;
                                    if (i8 < i9) {
                                        int i10 = i8 + i9;
                                        i9 = i10 - i9;
                                        i8 = i10 - i9;
                                    }
                                    ExifAttribute authRequestContext = ExifAttribute.getAuthRequestContext(i8, this.SummaryVoucherView$$ExternalSyntheticLambda1);
                                    ExifAttribute authRequestContext2 = ExifAttribute.getAuthRequestContext(i9, this.SummaryVoucherView$$ExternalSyntheticLambda1);
                                    this.isAuth[0].put("ImageWidth", authRequestContext);
                                    this.isAuth[0].put("ImageLength", authRequestContext2);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 9:
                    byteOrderedDataInputStream.skipBytes(84);
                    byte[] bArr6 = new byte[4];
                    byte[] bArr7 = new byte[4];
                    byteOrderedDataInputStream.read(bArr6);
                    byteOrderedDataInputStream.skipBytes(4);
                    byteOrderedDataInputStream.read(bArr7);
                    int i11 = ByteBuffer.wrap(bArr6).getInt();
                    int i12 = ByteBuffer.wrap(bArr7).getInt();
                    PlaceComponentResult(byteOrderedDataInputStream, i11, 5);
                    byteOrderedDataInputStream.KClassImpl$Data$declaredNonStaticMembers$2(i12);
                    byteOrderedDataInputStream.getAuthRequestContext = ByteOrder.BIG_ENDIAN;
                    int readInt = byteOrderedDataInputStream.readInt();
                    if (NetworkUserEntityData$$ExternalSyntheticLambda1) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("numberOfDirectoryEntry: ");
                        sb2.append(readInt);
                        InstrumentInjector.log_d("ExifInterface", sb2.toString());
                    }
                    int i13 = 0;
                    while (true) {
                        if (i13 >= readInt) {
                            break;
                        } else {
                            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
                            int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
                            if (readUnsignedShort == getOnBoardingScenario.BuiltInFictitiousFunctionClassFactory) {
                                short readShort = byteOrderedDataInputStream.readShort();
                                short readShort2 = byteOrderedDataInputStream.readShort();
                                ExifAttribute authRequestContext3 = ExifAttribute.getAuthRequestContext(readShort, this.SummaryVoucherView$$ExternalSyntheticLambda1);
                                ExifAttribute authRequestContext4 = ExifAttribute.getAuthRequestContext(readShort2, this.SummaryVoucherView$$ExternalSyntheticLambda1);
                                this.isAuth[0].put("ImageLength", authRequestContext3);
                                this.isAuth[0].put("ImageWidth", authRequestContext4);
                                if (NetworkUserEntityData$$ExternalSyntheticLambda1) {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("Updated to length: ");
                                    sb3.append((int) readShort);
                                    sb3.append(", width: ");
                                    sb3.append((int) readShort2);
                                    InstrumentInjector.log_d("ExifInterface", sb3.toString());
                                    break;
                                }
                            } else {
                                byteOrderedDataInputStream.skipBytes(readUnsignedShort2);
                                i13++;
                            }
                        }
                    }
                    break;
                case 10:
                    BuiltInFictitiousFunctionClassFactory(byteOrderedDataInputStream);
                    if (this.isAuth[0].get("JpgFromRaw") != null) {
                        PlaceComponentResult(byteOrderedDataInputStream, this.flip, 5);
                    }
                    ExifAttribute exifAttribute5 = this.isAuth[0].get("ISO");
                    ExifAttribute exifAttribute6 = this.isAuth[1].get("PhotographicSensitivity");
                    if (exifAttribute5 != null && exifAttribute6 == null) {
                        this.isAuth[1].put("PhotographicSensitivity", exifAttribute5);
                        break;
                    }
                    break;
                case 12:
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        if (Build.VERSION.SDK_INT >= 23) {
                            mediaMetadataRetriever.setDataSource(new MediaDataSource() { // from class: androidx.exifinterface.media.ExifInterface.1
                                long BuiltInFictitiousFunctionClassFactory;

                                @Override // java.io.Closeable, java.lang.AutoCloseable
                                public void close() throws IOException {
                                }

                                @Override // android.media.MediaDataSource
                                public long getSize() throws IOException {
                                    return -1L;
                                }

                                @Override // android.media.MediaDataSource
                                public int readAt(long j, byte[] bArr8, int i14, int i15) throws IOException {
                                    if (i15 == 0) {
                                        return 0;
                                    }
                                    if (j < 0) {
                                        return -1;
                                    }
                                    try {
                                        long j2 = this.BuiltInFictitiousFunctionClassFactory;
                                        if (j2 != j) {
                                            if (j2 >= 0 && j >= j2 + byteOrderedDataInputStream.available()) {
                                                return -1;
                                            }
                                            byteOrderedDataInputStream.KClassImpl$Data$declaredNonStaticMembers$2(j);
                                            this.BuiltInFictitiousFunctionClassFactory = j;
                                        }
                                        if (i15 > byteOrderedDataInputStream.available()) {
                                            i15 = byteOrderedDataInputStream.available();
                                        }
                                        int read = byteOrderedDataInputStream.read(bArr8, i14, i15);
                                        if (read >= 0) {
                                            this.BuiltInFictitiousFunctionClassFactory += read;
                                            return read;
                                        }
                                    } catch (IOException unused) {
                                    }
                                    this.BuiltInFictitiousFunctionClassFactory = -1L;
                                    return -1;
                                }
                            });
                        } else {
                            FileDescriptor fileDescriptor = this.shouldRecycleViewType;
                            if (fileDescriptor != null) {
                                mediaMetadataRetriever.setDataSource(fileDescriptor);
                            } else {
                                String str4 = this.S;
                                if (str4 != null) {
                                    mediaMetadataRetriever.setDataSource(str4);
                                }
                                mediaMetadataRetriever.release();
                                break;
                            }
                        }
                        String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
                        String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
                        String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
                        String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
                        if ("yes".equals(extractMetadata3)) {
                            str = mediaMetadataRetriever.extractMetadata(29);
                            str2 = mediaMetadataRetriever.extractMetadata(30);
                            str3 = mediaMetadataRetriever.extractMetadata(31);
                        } else if ("yes".equals(extractMetadata4)) {
                            str = mediaMetadataRetriever.extractMetadata(18);
                            str2 = mediaMetadataRetriever.extractMetadata(19);
                            str3 = mediaMetadataRetriever.extractMetadata(24);
                        } else {
                            str = null;
                            str2 = null;
                            str3 = null;
                        }
                        if (str != null) {
                            this.isAuth[0].put("ImageWidth", ExifAttribute.getAuthRequestContext(Integer.parseInt(str), this.SummaryVoucherView$$ExternalSyntheticLambda1));
                        }
                        if (str2 != null) {
                            this.isAuth[0].put("ImageLength", ExifAttribute.getAuthRequestContext(Integer.parseInt(str2), this.SummaryVoucherView$$ExternalSyntheticLambda1));
                        }
                        if (str3 != null) {
                            int parseInt = Integer.parseInt(str3);
                            this.isAuth[0].put("Orientation", ExifAttribute.getAuthRequestContext(parseInt != 90 ? parseInt != 180 ? parseInt == 270 ? 8 : 1 : 3 : 6, this.SummaryVoucherView$$ExternalSyntheticLambda1));
                        }
                        if (extractMetadata != null && extractMetadata2 != null) {
                            int parseInt2 = Integer.parseInt(extractMetadata);
                            int parseInt3 = Integer.parseInt(extractMetadata2);
                            if (parseInt3 <= 6) {
                                throw new IOException("Invalid exif length");
                            }
                            byteOrderedDataInputStream.KClassImpl$Data$declaredNonStaticMembers$2(parseInt2);
                            byte[] bArr8 = new byte[6];
                            if (byteOrderedDataInputStream.read(bArr8) != 6) {
                                throw new IOException("Can't read identifier");
                            }
                            int i14 = parseInt3 - 6;
                            if (!Arrays.equals(bArr8, lookAheadTest)) {
                                throw new IOException("Invalid identifier");
                            }
                            byte[] bArr9 = new byte[i14];
                            if (byteOrderedDataInputStream.read(bArr9) != i14) {
                                throw new IOException("Can't read exif");
                            }
                            this.R = parseInt2 + 6;
                            ByteOrderedDataInputStream byteOrderedDataInputStream3 = new ByteOrderedDataInputStream(bArr9);
                            KClassImpl$Data$declaredNonStaticMembers$2(byteOrderedDataInputStream3, i14);
                            BuiltInFictitiousFunctionClassFactory(byteOrderedDataInputStream3, 0);
                        }
                        if (NetworkUserEntityData$$ExternalSyntheticLambda1) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("Heif meta: ");
                            sb4.append(str);
                            sb4.append("x");
                            sb4.append(str2);
                            sb4.append(", rotation ");
                            sb4.append(str3);
                            InstrumentInjector.log_d("ExifInterface", sb4.toString());
                        }
                        mediaMetadataRetriever.release();
                    } catch (Throwable th) {
                        mediaMetadataRetriever.release();
                        throw th;
                    }
                case 13:
                    if (NetworkUserEntityData$$ExternalSyntheticLambda1) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("getPngAttributes starting with: ");
                        sb5.append(byteOrderedDataInputStream);
                        InstrumentInjector.log_d("ExifInterface", sb5.toString());
                    }
                    byteOrderedDataInputStream.getAuthRequestContext = ByteOrder.BIG_ENDIAN;
                    byte[] bArr10 = VerifyPinStateManager$executeRiskChallenge$2$1;
                    byteOrderedDataInputStream.skipBytes(bArr10.length);
                    int length = bArr10.length + 0;
                    while (true) {
                        try {
                            int readInt2 = byteOrderedDataInputStream.readInt();
                            byte[] bArr11 = new byte[4];
                            if (byteOrderedDataInputStream.read(bArr11) != 4) {
                                throw new IOException("Encountered invalid length while parsing PNG chunktype");
                            }
                            int i15 = length + 4 + 4;
                            if (i15 == 16 && !Arrays.equals(bArr11, A)) {
                                throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                            }
                            if (Arrays.equals(bArr11, BottomSheetCardBindingView$watcherCardNumberView$1)) {
                                break;
                            } else if (Arrays.equals(bArr11, C)) {
                                byte[] bArr12 = new byte[readInt2];
                                if (byteOrderedDataInputStream.read(bArr12) != readInt2) {
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append("Failed to read given length for given PNG chunk type: ");
                                    sb6.append(KClassImpl$Data$declaredNonStaticMembers$2(bArr11));
                                    throw new IOException(sb6.toString());
                                }
                                int readInt3 = byteOrderedDataInputStream.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr11);
                                crc32.update(bArr12);
                                if (((int) crc32.getValue()) != readInt3) {
                                    StringBuilder sb7 = new StringBuilder();
                                    sb7.append("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: ");
                                    sb7.append(readInt3);
                                    sb7.append(", calculated CRC value: ");
                                    sb7.append(crc32.getValue());
                                    throw new IOException(sb7.toString());
                                }
                                this.R = i15;
                                ByteOrderedDataInputStream byteOrderedDataInputStream4 = new ByteOrderedDataInputStream(bArr12);
                                KClassImpl$Data$declaredNonStaticMembers$2(byteOrderedDataInputStream4, readInt2);
                                BuiltInFictitiousFunctionClassFactory(byteOrderedDataInputStream4, 0);
                                BuiltInFictitiousFunctionClassFactory();
                                break;
                            } else {
                                int i16 = readInt2 + 4;
                                byteOrderedDataInputStream.skipBytes(i16);
                                length = i15 + i16;
                            }
                        } catch (EOFException unused) {
                            throw new IOException("Encountered corrupt PNG file.");
                        }
                    }
                    break;
                case 14:
                    if (NetworkUserEntityData$$ExternalSyntheticLambda1) {
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("getWebpAttributes starting with: ");
                        sb8.append(byteOrderedDataInputStream);
                        InstrumentInjector.log_d("ExifInterface", sb8.toString());
                    }
                    byteOrderedDataInputStream.getAuthRequestContext = ByteOrder.LITTLE_ENDIAN;
                    byteOrderedDataInputStream.skipBytes(H.length);
                    int readInt4 = byteOrderedDataInputStream.readInt() + 8;
                    int skipBytes = byteOrderedDataInputStream.skipBytes(F.length) + 8;
                    while (true) {
                        try {
                            byte[] bArr13 = new byte[4];
                            if (byteOrderedDataInputStream.read(bArr13) != 4) {
                                throw new IOException("Encountered invalid length while parsing WebP chunktype");
                            }
                            int readInt5 = byteOrderedDataInputStream.readInt();
                            int i17 = skipBytes + 4 + 4;
                            if (Arrays.equals(D, bArr13)) {
                                byte[] bArr14 = new byte[readInt5];
                                if (byteOrderedDataInputStream.read(bArr14) != readInt5) {
                                    StringBuilder sb9 = new StringBuilder();
                                    sb9.append("Failed to read given length for given PNG chunk type: ");
                                    sb9.append(KClassImpl$Data$declaredNonStaticMembers$2(bArr13));
                                    throw new IOException(sb9.toString());
                                }
                                this.R = i17;
                                ByteOrderedDataInputStream byteOrderedDataInputStream5 = new ByteOrderedDataInputStream(bArr14);
                                KClassImpl$Data$declaredNonStaticMembers$2(byteOrderedDataInputStream5, readInt5);
                                BuiltInFictitiousFunctionClassFactory(byteOrderedDataInputStream5, 0);
                                this.R = i17;
                                break;
                            } else {
                                readInt5 = readInt5 % 2 == 1 ? readInt5 + 1 : readInt5;
                                int i18 = i17 + readInt5;
                                if (i18 == readInt4) {
                                    break;
                                } else if (i18 > readInt4) {
                                    throw new IOException("Encountered WebP file with invalid chunk size");
                                } else {
                                    int skipBytes2 = byteOrderedDataInputStream.skipBytes(readInt5);
                                    if (skipBytes2 != readInt5) {
                                        throw new IOException("Encountered WebP file with invalid chunk size");
                                    }
                                    skipBytes = i17 + skipBytes2;
                                }
                            }
                        } catch (EOFException unused2) {
                            throw new IOException("Encountered corrupt WebP file.");
                        }
                    }
            }
        } else {
            byte[] bArr15 = lookAheadTest;
            byteOrderedDataInputStream.skipBytes(bArr15.length);
            int available = byteOrderedDataInputStream.available();
            byte[] bArr16 = new byte[available];
            byteOrderedDataInputStream.readFully(bArr16);
            this.R = bArr15.length;
            ByteOrderedDataInputStream byteOrderedDataInputStream6 = new ByteOrderedDataInputStream(bArr16);
            KClassImpl$Data$declaredNonStaticMembers$2(byteOrderedDataInputStream6, available);
            BuiltInFictitiousFunctionClassFactory(byteOrderedDataInputStream6, 0);
        }
        HashMap<String, ExifAttribute> hashMap = this.isAuth[4];
        ExifAttribute exifAttribute7 = hashMap.get("Compression");
        if (exifAttribute7 != null) {
            int authRequestContext5 = exifAttribute7.getAuthRequestContext(this.SummaryVoucherView$$ExternalSyntheticLambda1);
            this.b = authRequestContext5;
            if (authRequestContext5 != 1) {
                if (authRequestContext5 == 6) {
                    getAuthRequestContext(byteOrderedDataInputStream, hashMap);
                } else if (authRequestContext5 != 7) {
                }
            }
            if (getAuthRequestContext((HashMap) hashMap)) {
                ExifAttribute exifAttribute8 = hashMap.get("StripOffsets");
                ExifAttribute exifAttribute9 = hashMap.get("StripByteCounts");
                if (exifAttribute8 != null && exifAttribute9 != null) {
                    long[] authRequestContext6 = getAuthRequestContext(exifAttribute8.KClassImpl$Data$declaredNonStaticMembers$2(this.SummaryVoucherView$$ExternalSyntheticLambda1));
                    long[] authRequestContext7 = getAuthRequestContext(exifAttribute9.KClassImpl$Data$declaredNonStaticMembers$2(this.SummaryVoucherView$$ExternalSyntheticLambda1));
                    if (authRequestContext6 == null || authRequestContext6.length == 0) {
                        InstrumentInjector.log_w("ExifInterface", "stripOffsets should not be null or have zero length.");
                    } else if (authRequestContext7 == null || authRequestContext7.length == 0) {
                        InstrumentInjector.log_w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                    } else if (authRequestContext6.length != authRequestContext7.length) {
                        InstrumentInjector.log_w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                    } else {
                        long j = 0;
                        for (long j2 : authRequestContext7) {
                            j += j2;
                        }
                        int i19 = (int) j;
                        byte[] bArr17 = new byte[i19];
                        this.O = true;
                        this.T = true;
                        this.X = true;
                        int i20 = 0;
                        int i21 = 0;
                        for (int i22 = 0; i22 < authRequestContext6.length; i22++) {
                            int i23 = (int) authRequestContext6[i22];
                            int i24 = (int) authRequestContext7[i22];
                            if (i22 < authRequestContext6.length - 1) {
                                i = i24;
                                if (i23 + i24 != authRequestContext6[i22 + 1]) {
                                    this.O = false;
                                }
                            } else {
                                i = i24;
                            }
                            int i25 = i23 - i20;
                            if (i25 < 0) {
                                InstrumentInjector.log_d("ExifInterface", "Invalid strip offset value");
                            }
                            byteOrderedDataInputStream.KClassImpl$Data$declaredNonStaticMembers$2(i25);
                            int i26 = i;
                            byte[] bArr18 = new byte[i26];
                            byteOrderedDataInputStream.read(bArr18);
                            i20 = i20 + i25 + i26;
                            System.arraycopy(bArr18, 0, bArr17, i21, i26);
                            i21 += i26;
                        }
                        this.d = bArr17;
                        if (this.O) {
                            this.QrExpiredActivity = ((int) authRequestContext6[0]) + this.R;
                            this.c = i19;
                        }
                    }
                }
            }
        } else {
            this.b = 6;
            getAuthRequestContext(byteOrderedDataInputStream, hashMap);
        }
        this.W = true;
        MyBillsEntityDataFactory();
        if (!NetworkUserEntityData$$ExternalSyntheticLambda1) {
            return;
        }
        getAuthRequestContext();
    }

    private ExifAttribute MyBillsEntityDataFactory(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if ("ISOSpeedRatings".equals(str)) {
            if (NetworkUserEntityData$$ExternalSyntheticLambda1) {
                InstrumentInjector.log_d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i = 0; i < getErrorConfigVersion.length; i++) {
            ExifAttribute exifAttribute = this.isAuth[i].get(str);
            if (exifAttribute != null) {
                return exifAttribute;
            }
        }
        return null;
    }

    private String BuiltInFictitiousFunctionClassFactory(String str) {
        double d;
        ExifAttribute MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(str);
        if (MyBillsEntityDataFactory2 != null) {
            if (!P.contains(str)) {
                return MyBillsEntityDataFactory2.MyBillsEntityDataFactory(this.SummaryVoucherView$$ExternalSyntheticLambda1);
            }
            if (str.equals("GPSTimeStamp")) {
                if (MyBillsEntityDataFactory2.getAuthRequestContext != 5 && MyBillsEntityDataFactory2.getAuthRequestContext != 10) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("GPS Timestamp format is not rational. format=");
                    sb.append(MyBillsEntityDataFactory2.getAuthRequestContext);
                    InstrumentInjector.log_w("ExifInterface", sb.toString());
                    return null;
                }
                Rational[] rationalArr = (Rational[]) MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2(this.SummaryVoucherView$$ExternalSyntheticLambda1);
                if (rationalArr == null || rationalArr.length != 3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid GPS Timestamp array. array=");
                    sb2.append(Arrays.toString(rationalArr));
                    InstrumentInjector.log_w("ExifInterface", sb2.toString());
                    return null;
                }
                return String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) rationalArr[0].BuiltInFictitiousFunctionClassFactory) / ((float) rationalArr[0].getAuthRequestContext))), Integer.valueOf((int) (((float) rationalArr[1].BuiltInFictitiousFunctionClassFactory) / ((float) rationalArr[1].getAuthRequestContext))), Integer.valueOf((int) (((float) rationalArr[2].BuiltInFictitiousFunctionClassFactory) / ((float) rationalArr[2].getAuthRequestContext))));
            }
            try {
                Object KClassImpl$Data$declaredNonStaticMembers$22 = MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2(this.SummaryVoucherView$$ExternalSyntheticLambda1);
                if (KClassImpl$Data$declaredNonStaticMembers$22 == null) {
                    throw new NumberFormatException("NULL can't be converted to a double value");
                }
                if (KClassImpl$Data$declaredNonStaticMembers$22 instanceof String) {
                    d = Double.parseDouble((String) KClassImpl$Data$declaredNonStaticMembers$22);
                } else if (KClassImpl$Data$declaredNonStaticMembers$22 instanceof long[]) {
                    long[] jArr = (long[]) KClassImpl$Data$declaredNonStaticMembers$22;
                    if (jArr.length == 1) {
                        d = jArr[0];
                    } else {
                        throw new NumberFormatException("There are more than one component");
                    }
                } else if (KClassImpl$Data$declaredNonStaticMembers$22 instanceof int[]) {
                    int[] iArr = (int[]) KClassImpl$Data$declaredNonStaticMembers$22;
                    if (iArr.length == 1) {
                        d = iArr[0];
                    } else {
                        throw new NumberFormatException("There are more than one component");
                    }
                } else if (KClassImpl$Data$declaredNonStaticMembers$22 instanceof double[]) {
                    double[] dArr = (double[]) KClassImpl$Data$declaredNonStaticMembers$22;
                    if (dArr.length == 1) {
                        d = dArr[0];
                    } else {
                        throw new NumberFormatException("There are more than one component");
                    }
                } else if (KClassImpl$Data$declaredNonStaticMembers$22 instanceof Rational[]) {
                    Rational[] rationalArr2 = (Rational[]) KClassImpl$Data$declaredNonStaticMembers$22;
                    if (rationalArr2.length == 1) {
                        Rational rational = rationalArr2[0];
                        double d2 = rational.BuiltInFictitiousFunctionClassFactory;
                        double d3 = rational.getAuthRequestContext;
                        Double.isNaN(d2);
                        Double.isNaN(d3);
                        d = d2 / d3;
                    } else {
                        throw new NumberFormatException("There are more than one component");
                    }
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
                return Double.toString(d);
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final int getAuthRequestContext(String str) {
        ExifAttribute MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(str);
        if (MyBillsEntityDataFactory2 == null) {
            return 1;
        }
        try {
            return MyBillsEntityDataFactory2.getAuthRequestContext(this.SummaryVoucherView$$ExternalSyntheticLambda1);
        } catch (NumberFormatException unused) {
            return 1;
        }
    }

    private static boolean PlaceComponentResult(FileDescriptor fileDescriptor) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Os.lseek(fileDescriptor, 0L, OsConstants.SEEK_CUR);
                return true;
            } catch (Exception unused) {
                if (NetworkUserEntityData$$ExternalSyntheticLambda1) {
                    InstrumentInjector.log_d("ExifInterface", "The file descriptor for the given input is not seekable");
                    return false;
                }
                return false;
            }
        }
        return false;
    }

    private void getAuthRequestContext() {
        for (int i = 0; i < this.isAuth.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("The size of tag group[");
            sb.append(i);
            sb.append("]: ");
            sb.append(this.isAuth[i].size());
            InstrumentInjector.log_d("ExifInterface", sb.toString());
            for (Map.Entry<String, ExifAttribute> entry : this.isAuth[i].entrySet()) {
                ExifAttribute value = entry.getValue();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("tagName: ");
                sb2.append(entry.getKey());
                sb2.append(", tagType: ");
                sb2.append(value.toString());
                sb2.append(", tagValue: '");
                sb2.append(value.MyBillsEntityDataFactory(this.SummaryVoucherView$$ExternalSyntheticLambda1));
                sb2.append("'");
                InstrumentInjector.log_d("ExifInterface", sb2.toString());
            }
        }
    }

    private static boolean MyBillsEntityDataFactory(byte[] bArr) throws IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    private static boolean lookAheadTest(byte[] bArr) throws IOException {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i = 0; i < bytes.length; i++) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean getAuthRequestContext(byte[] bArr) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream;
        long readInt;
        byte[] bArr2;
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = null;
        try {
            try {
                byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
                try {
                    readInt = byteOrderedDataInputStream.readInt();
                    bArr2 = new byte[4];
                    byteOrderedDataInputStream.read(bArr2);
                } catch (Exception e) {
                    e = e;
                    byteOrderedDataInputStream2 = byteOrderedDataInputStream;
                    if (NetworkUserEntityData$$ExternalSyntheticLambda1) {
                        InstrumentInjector.log_d("ExifInterface", "Exception parsing HEIF file type box.", e);
                    }
                    if (byteOrderedDataInputStream2 != null) {
                        byteOrderedDataInputStream2.close();
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    if (byteOrderedDataInputStream != null) {
                        byteOrderedDataInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                byteOrderedDataInputStream = byteOrderedDataInputStream2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        if (!Arrays.equals(bArr2, NetworkUserEntityData$$ExternalSyntheticLambda7)) {
            byteOrderedDataInputStream.close();
            return false;
        }
        long j = 16;
        if (readInt == 1) {
            readInt = byteOrderedDataInputStream.readLong();
            if (readInt < 16) {
                byteOrderedDataInputStream.close();
                return false;
            }
        } else {
            j = 8;
        }
        int length = bArr.length;
        if (readInt > RangedBeacon.DEFAULT_MAX_TRACKING_AGE) {
            int length2 = bArr.length;
            readInt = 5000;
        }
        long j2 = readInt - j;
        if (j2 < 8) {
            byteOrderedDataInputStream.close();
            return false;
        }
        byte[] bArr3 = new byte[4];
        boolean z = false;
        boolean z2 = false;
        for (long j3 = 0; j3 < j2 / 4; j3++) {
            if (byteOrderedDataInputStream.read(bArr3) != 4) {
                byteOrderedDataInputStream.close();
                return false;
            }
            if (j3 != 1) {
                if (Arrays.equals(bArr3, GetContactSyncConfig)) {
                    z2 = true;
                } else if (Arrays.equals(bArr3, NetworkUserEntityData$$ExternalSyntheticLambda2)) {
                    z = true;
                }
                if (z2 && z) {
                    byteOrderedDataInputStream.close();
                    return true;
                }
            }
        }
        byteOrderedDataInputStream.close();
        return false;
    }

    private boolean BuiltInFictitiousFunctionClassFactory(byte[] bArr) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream;
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = null;
        try {
            byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            ByteOrder MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(byteOrderedDataInputStream);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = MyBillsEntityDataFactory2;
            byteOrderedDataInputStream.getAuthRequestContext = MyBillsEntityDataFactory2;
            short readShort = byteOrderedDataInputStream.readShort();
            boolean z = readShort == 20306 || readShort == 21330;
            byteOrderedDataInputStream.close();
            return z;
        } catch (Exception unused2) {
            byteOrderedDataInputStream2 = byteOrderedDataInputStream;
            if (byteOrderedDataInputStream2 != null) {
                byteOrderedDataInputStream2.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            byteOrderedDataInputStream2 = byteOrderedDataInputStream;
            if (byteOrderedDataInputStream2 != null) {
                byteOrderedDataInputStream2.close();
            }
            throw th;
        }
    }

    private boolean scheduleImpl(byte[] bArr) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream;
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = null;
        try {
            byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            ByteOrder MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(byteOrderedDataInputStream);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = MyBillsEntityDataFactory2;
            byteOrderedDataInputStream.getAuthRequestContext = MyBillsEntityDataFactory2;
            boolean z = byteOrderedDataInputStream.readShort() == 85;
            byteOrderedDataInputStream.close();
            return z;
        } catch (Exception unused2) {
            byteOrderedDataInputStream2 = byteOrderedDataInputStream;
            if (byteOrderedDataInputStream2 != null) {
                byteOrderedDataInputStream2.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            byteOrderedDataInputStream2 = byteOrderedDataInputStream;
            if (byteOrderedDataInputStream2 != null) {
                byteOrderedDataInputStream2.close();
            }
            throw th;
        }
    }

    private static boolean PlaceComponentResult(byte[] bArr) throws IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = VerifyPinStateManager$executeRiskChallenge$2$1;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda0(byte[] bArr) throws IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = H;
            if (i >= bArr2.length) {
                int i2 = 0;
                while (true) {
                    byte[] bArr3 = F;
                    if (i2 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[H.length + i2 + 4] != bArr3[i2]) {
                        return false;
                    }
                    i2++;
                }
            } else if (bArr[i] != bArr2[i]) {
                return false;
            } else {
                i++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x01a7, code lost:
    
        r21.getAuthRequestContext = r20.SummaryVoucherView$$ExternalSyntheticLambda1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01ab, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bc A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0198 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void PlaceComponentResult(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r21, int r22, int r23) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 556
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.PlaceComponentResult(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int, int):void");
    }

    private void BuiltInFictitiousFunctionClassFactory(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        ExifAttribute exifAttribute;
        KClassImpl$Data$declaredNonStaticMembers$2(byteOrderedDataInputStream, byteOrderedDataInputStream.available());
        BuiltInFictitiousFunctionClassFactory(byteOrderedDataInputStream, 0);
        MyBillsEntityDataFactory(byteOrderedDataInputStream, 0);
        MyBillsEntityDataFactory(byteOrderedDataInputStream, 5);
        MyBillsEntityDataFactory(byteOrderedDataInputStream, 4);
        BuiltInFictitiousFunctionClassFactory();
        if (this.U != 8 || (exifAttribute = this.isAuth[1].get("MakerNote")) == null) {
            return;
        }
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute.BuiltInFictitiousFunctionClassFactory);
        byteOrderedDataInputStream2.getAuthRequestContext = this.SummaryVoucherView$$ExternalSyntheticLambda1;
        byteOrderedDataInputStream2.KClassImpl$Data$declaredNonStaticMembers$2(6L);
        BuiltInFictitiousFunctionClassFactory(byteOrderedDataInputStream2, 9);
        ExifAttribute exifAttribute2 = this.isAuth[9].get("ColorSpace");
        if (exifAttribute2 != null) {
            this.isAuth[1].put("ColorSpace", exifAttribute2);
        }
    }

    private void MyBillsEntityDataFactory() {
        String BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory("DateTimeOriginal");
        if (BuiltInFictitiousFunctionClassFactory2 != null && BuiltInFictitiousFunctionClassFactory("DateTime") == null) {
            this.isAuth[0].put("DateTime", ExifAttribute.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2));
        }
        if (BuiltInFictitiousFunctionClassFactory("ImageWidth") == null) {
            this.isAuth[0].put("ImageWidth", ExifAttribute.BuiltInFictitiousFunctionClassFactory(0L, this.SummaryVoucherView$$ExternalSyntheticLambda1));
        }
        if (BuiltInFictitiousFunctionClassFactory("ImageLength") == null) {
            this.isAuth[0].put("ImageLength", ExifAttribute.BuiltInFictitiousFunctionClassFactory(0L, this.SummaryVoucherView$$ExternalSyntheticLambda1));
        }
        if (BuiltInFictitiousFunctionClassFactory("Orientation") == null) {
            this.isAuth[0].put("Orientation", ExifAttribute.BuiltInFictitiousFunctionClassFactory(0L, this.SummaryVoucherView$$ExternalSyntheticLambda1));
        }
        if (BuiltInFictitiousFunctionClassFactory("LightSource") == null) {
            this.isAuth[1].put("LightSource", ExifAttribute.BuiltInFictitiousFunctionClassFactory(0L, this.SummaryVoucherView$$ExternalSyntheticLambda1));
        }
    }

    private static ByteOrder MyBillsEntityDataFactory(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        short readShort = byteOrderedDataInputStream.readShort();
        if (readShort == 18761) {
            if (NetworkUserEntityData$$ExternalSyntheticLambda1) {
                InstrumentInjector.log_d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        } else if (readShort == 19789) {
            if (NetworkUserEntityData$$ExternalSyntheticLambda1) {
                InstrumentInjector.log_d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid byte order: ");
            sb.append(Integer.toHexString(readShort));
            throw new IOException(sb.toString());
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(ByteOrderedDataInputStream byteOrderedDataInputStream, int i) throws IOException {
        ByteOrder MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(byteOrderedDataInputStream);
        this.SummaryVoucherView$$ExternalSyntheticLambda1 = MyBillsEntityDataFactory2;
        byteOrderedDataInputStream.getAuthRequestContext = MyBillsEntityDataFactory2;
        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
        int i2 = this.U;
        if (i2 != 7 && i2 != 10 && readUnsignedShort != 42) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid start code: ");
            sb.append(Integer.toHexString(readUnsignedShort));
            throw new IOException(sb.toString());
        }
        int readInt = byteOrderedDataInputStream.readInt();
        if (readInt < 8 || readInt >= i) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid first Ifd offset: ");
            sb2.append(readInt);
            throw new IOException(sb2.toString());
        }
        int i3 = readInt - 8;
        if (i3 <= 0 || byteOrderedDataInputStream.skipBytes(i3) == i3) {
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Couldn't jump to first Ifd: ");
        sb3.append(i3);
        throw new IOException(sb3.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:152:0x0401, code lost:
    
        if (r3 == false) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0403, code lost:
    
        r1 = new java.lang.StringBuilder();
        r1.append("Stop reading file since a wrong offset may cause an infinite loop: ");
        r1.append(r2);
        com.fullstory.instrumentation.InstrumentInjector.log_d("ExifInterface", r1.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0417, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:?, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void BuiltInFictitiousFunctionClassFactory(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r32, int r33) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1048
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.BuiltInFictitiousFunctionClassFactory(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int):void");
    }

    private void PlaceComponentResult(ByteOrderedDataInputStream byteOrderedDataInputStream, int i) throws IOException {
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2 = this.isAuth[i].get("ImageLength");
        ExifAttribute exifAttribute3 = this.isAuth[i].get("ImageWidth");
        if ((exifAttribute2 == null || exifAttribute3 == null) && (exifAttribute = this.isAuth[i].get("JPEGInterchangeFormat")) != null) {
            PlaceComponentResult(byteOrderedDataInputStream, exifAttribute.getAuthRequestContext(this.SummaryVoucherView$$ExternalSyntheticLambda1), i);
        }
    }

    private void getAuthRequestContext(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get("JPEGInterchangeFormat");
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("JPEGInterchangeFormatLength");
        if (exifAttribute == null || exifAttribute2 == null) {
            return;
        }
        int authRequestContext = exifAttribute.getAuthRequestContext(this.SummaryVoucherView$$ExternalSyntheticLambda1);
        int authRequestContext2 = exifAttribute2.getAuthRequestContext(this.SummaryVoucherView$$ExternalSyntheticLambda1);
        if (this.U == 7) {
            authRequestContext += this.isAuto;
        }
        int min = Math.min(authRequestContext2, byteOrderedDataInputStream.KClassImpl$Data$declaredNonStaticMembers$2 - authRequestContext);
        if (authRequestContext > 0 && min > 0) {
            this.X = true;
            int i = this.R + authRequestContext;
            this.QrExpiredActivity = i;
            this.c = min;
            if (this.S == null && this.N == null && this.shouldRecycleViewType == null) {
                byte[] bArr = new byte[min];
                byteOrderedDataInputStream.KClassImpl$Data$declaredNonStaticMembers$2(i);
                byteOrderedDataInputStream.readFully(bArr);
                this.d = bArr;
            }
        }
        if (NetworkUserEntityData$$ExternalSyntheticLambda1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Setting thumbnail attributes with offset: ");
            sb.append(authRequestContext);
            sb.append(", length: ");
            sb.append(min);
            InstrumentInjector.log_d("ExifInterface", sb.toString());
        }
    }

    private boolean getAuthRequestContext(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute;
        int authRequestContext;
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("BitsPerSample");
        if (exifAttribute2 != null) {
            int[] iArr = (int[]) exifAttribute2.KClassImpl$Data$declaredNonStaticMembers$2(this.SummaryVoucherView$$ExternalSyntheticLambda1);
            int[] iArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.U == 3 && (exifAttribute = (ExifAttribute) hashMap.get("PhotometricInterpretation")) != null && (((authRequestContext = exifAttribute.getAuthRequestContext(this.SummaryVoucherView$$ExternalSyntheticLambda1)) == 1 && Arrays.equals(iArr, MyBillsEntityDataFactory)) || (authRequestContext == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (NetworkUserEntityData$$ExternalSyntheticLambda1) {
            InstrumentInjector.log_d("ExifInterface", "Unsupported data type value");
            return false;
        }
        return false;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get("ImageLength");
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            return false;
        }
        return exifAttribute.getAuthRequestContext(this.SummaryVoucherView$$ExternalSyntheticLambda1) <= 512 && exifAttribute2.getAuthRequestContext(this.SummaryVoucherView$$ExternalSyntheticLambda1) <= 512;
    }

    private void BuiltInFictitiousFunctionClassFactory() throws IOException {
        PlaceComponentResult(0, 5);
        PlaceComponentResult(0, 4);
        PlaceComponentResult(5, 4);
        ExifAttribute exifAttribute = this.isAuth[1].get("PixelXDimension");
        ExifAttribute exifAttribute2 = this.isAuth[1].get("PixelYDimension");
        if (exifAttribute != null && exifAttribute2 != null) {
            this.isAuth[0].put("ImageWidth", exifAttribute);
            this.isAuth[0].put("ImageLength", exifAttribute2);
        }
        if (this.isAuth[4].isEmpty() && KClassImpl$Data$declaredNonStaticMembers$2(this.isAuth[5])) {
            HashMap<String, ExifAttribute>[] hashMapArr = this.isAuth;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2(this.isAuth[4])) {
            return;
        }
        InstrumentInjector.log_d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
    }

    private void MyBillsEntityDataFactory(ByteOrderedDataInputStream byteOrderedDataInputStream, int i) throws IOException {
        ExifAttribute authRequestContext;
        ExifAttribute authRequestContext2;
        ExifAttribute exifAttribute = this.isAuth[i].get("DefaultCropSize");
        ExifAttribute exifAttribute2 = this.isAuth[i].get("SensorTopBorder");
        ExifAttribute exifAttribute3 = this.isAuth[i].get("SensorLeftBorder");
        ExifAttribute exifAttribute4 = this.isAuth[i].get("SensorBottomBorder");
        ExifAttribute exifAttribute5 = this.isAuth[i].get("SensorRightBorder");
        if (exifAttribute == null) {
            if (exifAttribute2 != null && exifAttribute3 != null && exifAttribute4 != null && exifAttribute5 != null) {
                int authRequestContext3 = exifAttribute2.getAuthRequestContext(this.SummaryVoucherView$$ExternalSyntheticLambda1);
                int authRequestContext4 = exifAttribute4.getAuthRequestContext(this.SummaryVoucherView$$ExternalSyntheticLambda1);
                int authRequestContext5 = exifAttribute5.getAuthRequestContext(this.SummaryVoucherView$$ExternalSyntheticLambda1);
                int authRequestContext6 = exifAttribute3.getAuthRequestContext(this.SummaryVoucherView$$ExternalSyntheticLambda1);
                if (authRequestContext4 <= authRequestContext3 || authRequestContext5 <= authRequestContext6) {
                    return;
                }
                ExifAttribute authRequestContext7 = ExifAttribute.getAuthRequestContext(authRequestContext4 - authRequestContext3, this.SummaryVoucherView$$ExternalSyntheticLambda1);
                ExifAttribute authRequestContext8 = ExifAttribute.getAuthRequestContext(authRequestContext5 - authRequestContext6, this.SummaryVoucherView$$ExternalSyntheticLambda1);
                this.isAuth[i].put("ImageLength", authRequestContext7);
                this.isAuth[i].put("ImageWidth", authRequestContext8);
                return;
            }
            PlaceComponentResult(byteOrderedDataInputStream, i);
            return;
        }
        if (exifAttribute.getAuthRequestContext == 5) {
            Rational[] rationalArr = (Rational[]) exifAttribute.KClassImpl$Data$declaredNonStaticMembers$2(this.SummaryVoucherView$$ExternalSyntheticLambda1);
            if (rationalArr == null || rationalArr.length != 2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid crop size values. cropSize=");
                sb.append(Arrays.toString(rationalArr));
                InstrumentInjector.log_w("ExifInterface", sb.toString());
                return;
            }
            authRequestContext = ExifAttribute.KClassImpl$Data$declaredNonStaticMembers$2(rationalArr[0], this.SummaryVoucherView$$ExternalSyntheticLambda1);
            authRequestContext2 = ExifAttribute.KClassImpl$Data$declaredNonStaticMembers$2(rationalArr[1], this.SummaryVoucherView$$ExternalSyntheticLambda1);
        } else {
            int[] iArr = (int[]) exifAttribute.KClassImpl$Data$declaredNonStaticMembers$2(this.SummaryVoucherView$$ExternalSyntheticLambda1);
            if (iArr == null || iArr.length != 2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Invalid crop size values. cropSize=");
                sb2.append(Arrays.toString(iArr));
                InstrumentInjector.log_w("ExifInterface", sb2.toString());
                return;
            }
            authRequestContext = ExifAttribute.getAuthRequestContext(iArr[0], this.SummaryVoucherView$$ExternalSyntheticLambda1);
            authRequestContext2 = ExifAttribute.getAuthRequestContext(iArr[1], this.SummaryVoucherView$$ExternalSyntheticLambda1);
        }
        this.isAuth[i].put("ImageWidth", authRequestContext);
        this.isAuth[i].put("ImageLength", authRequestContext2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ByteOrderedDataInputStream extends InputStream implements DataInput {
        int BuiltInFictitiousFunctionClassFactory;
        final int KClassImpl$Data$declaredNonStaticMembers$2;
        private DataInputStream NetworkUserEntityData$$ExternalSyntheticLambda0;
        ByteOrder getAuthRequestContext;
        private static final ByteOrder PlaceComponentResult = ByteOrder.LITTLE_ENDIAN;
        private static final ByteOrder MyBillsEntityDataFactory = ByteOrder.BIG_ENDIAN;

        public ByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        private ByteOrderedDataInputStream(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            this.getAuthRequestContext = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = dataInputStream;
            int available = dataInputStream.available();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = available;
            this.BuiltInFictitiousFunctionClassFactory = 0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.mark(available);
            this.getAuthRequestContext = byteOrder;
        }

        public ByteOrderedDataInputStream(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr));
        }

        public final void KClassImpl$Data$declaredNonStaticMembers$2(long j) throws IOException {
            long j2 = this.BuiltInFictitiousFunctionClassFactory;
            if (j2 > j) {
                this.BuiltInFictitiousFunctionClassFactory = 0;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.reset();
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.mark(this.KClassImpl$Data$declaredNonStaticMembers$2);
            } else {
                j -= j2;
            }
            int i = (int) j;
            if (skipBytes(i) != i) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0.available();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            this.BuiltInFictitiousFunctionClassFactory++;
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = this.NetworkUserEntityData$$ExternalSyntheticLambda0.read(bArr, i, i2);
            this.BuiltInFictitiousFunctionClassFactory += read;
            return read;
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            this.BuiltInFictitiousFunctionClassFactory++;
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            InstrumentInjector.log_d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            this.BuiltInFictitiousFunctionClassFactory++;
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0.readBoolean();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            this.BuiltInFictitiousFunctionClassFactory += 2;
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0.readChar();
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            this.BuiltInFictitiousFunctionClassFactory += 2;
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0.readUTF();
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.BuiltInFictitiousFunctionClassFactory + i2;
            this.BuiltInFictitiousFunctionClassFactory = i3;
            if (i3 > this.KClassImpl$Data$declaredNonStaticMembers$2) {
                throw new EOFException();
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.read(bArr, i, i2) != i2) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            int length = this.BuiltInFictitiousFunctionClassFactory + bArr.length;
            this.BuiltInFictitiousFunctionClassFactory = length;
            if (length > this.KClassImpl$Data$declaredNonStaticMembers$2) {
                throw new EOFException();
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            int i = this.BuiltInFictitiousFunctionClassFactory + 1;
            this.BuiltInFictitiousFunctionClassFactory = i;
            if (i > this.KClassImpl$Data$declaredNonStaticMembers$2) {
                throw new EOFException();
            }
            int read = this.NetworkUserEntityData$$ExternalSyntheticLambda0.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            int i = this.BuiltInFictitiousFunctionClassFactory + 2;
            this.BuiltInFictitiousFunctionClassFactory = i;
            if (i > this.KClassImpl$Data$declaredNonStaticMembers$2) {
                throw new EOFException();
            }
            int read = this.NetworkUserEntityData$$ExternalSyntheticLambda0.read();
            int read2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.getAuthRequestContext;
            if (byteOrder == PlaceComponentResult) {
                return (short) ((read2 << 8) + read);
            }
            if (byteOrder == MyBillsEntityDataFactory) {
                return (short) ((read << 8) + read2);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid byte order: ");
            sb.append(this.getAuthRequestContext);
            throw new IOException(sb.toString());
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            int i = this.BuiltInFictitiousFunctionClassFactory + 4;
            this.BuiltInFictitiousFunctionClassFactory = i;
            if (i > this.KClassImpl$Data$declaredNonStaticMembers$2) {
                throw new EOFException();
            }
            int read = this.NetworkUserEntityData$$ExternalSyntheticLambda0.read();
            int read2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.read();
            int read3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.read();
            int read4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.read();
            if ((read | read2 | read3 | read4) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.getAuthRequestContext;
            if (byteOrder == PlaceComponentResult) {
                return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == MyBillsEntityDataFactory) {
                return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid byte order: ");
            sb.append(this.getAuthRequestContext);
            throw new IOException(sb.toString());
        }

        @Override // java.io.DataInput
        public int skipBytes(int i) throws IOException {
            int min = Math.min(i, this.KClassImpl$Data$declaredNonStaticMembers$2 - this.BuiltInFictitiousFunctionClassFactory);
            int i2 = 0;
            while (i2 < min) {
                i2 += this.NetworkUserEntityData$$ExternalSyntheticLambda0.skipBytes(min - i2);
            }
            this.BuiltInFictitiousFunctionClassFactory += i2;
            return i2;
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            int i = this.BuiltInFictitiousFunctionClassFactory + 2;
            this.BuiltInFictitiousFunctionClassFactory = i;
            if (i > this.KClassImpl$Data$declaredNonStaticMembers$2) {
                throw new EOFException();
            }
            int read = this.NetworkUserEntityData$$ExternalSyntheticLambda0.read();
            int read2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.getAuthRequestContext;
            if (byteOrder == PlaceComponentResult) {
                return (read2 << 8) + read;
            }
            if (byteOrder == MyBillsEntityDataFactory) {
                return (read << 8) + read2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid byte order: ");
            sb.append(this.getAuthRequestContext);
            throw new IOException(sb.toString());
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            int i = this.BuiltInFictitiousFunctionClassFactory + 8;
            this.BuiltInFictitiousFunctionClassFactory = i;
            if (i > this.KClassImpl$Data$declaredNonStaticMembers$2) {
                throw new EOFException();
            }
            int read = this.NetworkUserEntityData$$ExternalSyntheticLambda0.read();
            int read2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.read();
            int read3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.read();
            int read4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.read();
            int read5 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.read();
            int read6 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.read();
            int read7 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.read();
            int read8 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.getAuthRequestContext;
            if (byteOrder == PlaceComponentResult) {
                return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == MyBillsEntityDataFactory) {
                return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid byte order: ");
            sb.append(this.getAuthRequestContext);
            throw new IOException(sb.toString());
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }
    }

    /* loaded from: classes6.dex */
    static class ByteOrderedDataOutputStream extends FilterOutputStream {
        final OutputStream getAuthRequestContext;

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.getAuthRequestContext.write(bArr);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.getAuthRequestContext.write(bArr, i, i2);
        }
    }

    private void PlaceComponentResult(int i, int i2) throws IOException {
        if (this.isAuth[i].isEmpty() || this.isAuth[i2].isEmpty()) {
            if (NetworkUserEntityData$$ExternalSyntheticLambda1) {
                InstrumentInjector.log_d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        ExifAttribute exifAttribute = this.isAuth[i].get("ImageLength");
        ExifAttribute exifAttribute2 = this.isAuth[i].get("ImageWidth");
        ExifAttribute exifAttribute3 = this.isAuth[i2].get("ImageLength");
        ExifAttribute exifAttribute4 = this.isAuth[i2].get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            if (NetworkUserEntityData$$ExternalSyntheticLambda1) {
                InstrumentInjector.log_d("ExifInterface", "First image does not contain valid size information");
            }
        } else if (exifAttribute3 == null || exifAttribute4 == null) {
            if (NetworkUserEntityData$$ExternalSyntheticLambda1) {
                InstrumentInjector.log_d("ExifInterface", "Second image does not contain valid size information");
            }
        } else {
            int authRequestContext = exifAttribute.getAuthRequestContext(this.SummaryVoucherView$$ExternalSyntheticLambda1);
            int authRequestContext2 = exifAttribute2.getAuthRequestContext(this.SummaryVoucherView$$ExternalSyntheticLambda1);
            int authRequestContext3 = exifAttribute3.getAuthRequestContext(this.SummaryVoucherView$$ExternalSyntheticLambda1);
            int authRequestContext4 = exifAttribute4.getAuthRequestContext(this.SummaryVoucherView$$ExternalSyntheticLambda1);
            if (authRequestContext >= authRequestContext3 || authRequestContext2 >= authRequestContext4) {
                return;
            }
            HashMap<String, ExifAttribute>[] hashMapArr = this.isAuth;
            HashMap<String, ExifAttribute> hashMap = hashMapArr[i];
            hashMapArr[i] = hashMapArr[i2];
            hashMapArr[i2] = hashMap;
        }
    }

    private static long[] getAuthRequestContext(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                jArr[i] = iArr[i];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }

    private static boolean MyBillsEntityDataFactory(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(8);
        for (byte b : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }
}
