package com.google.zxing.pdf417.encoder;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.griver.image.framework.utils.FileUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.alipay.iap.android.aplog.util.zip.LZMA_Base;
import com.google.zxing.WriterException;
import com.google.zxing.pdf417.PDF417Common;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
final class PDF417ErrorCorrection {
    private static final int[][] EC_COEFFICIENTS;

    static {
        int[] iArr = new int[512];
        int[] iArr2 = new int[512];
        ByteBuffer.wrap("\u0000\u0000\u0001`\u0000\u0000\u0000M\u0000\u0000\u0001u\u0000\u0000\u0001ø\u0000\u0000\u0000#\u0000\u0000\u0002W\u0000\u0000\u0001¬\u0000\u0000\u0000Ï\u0000\u0000\u0001\u0099\u0000\u0000\u0002>\u0000\u0000\u0000v\u0000\u0000\u0001ò\u0000\u0000\u0001\u001d\u0000\u0000\u0001|\u0000\u0000\u0001^\u0000\u0000\u0001ì\u0000\u0000\u0000Å\u0000\u0000\u0001\t\u0000\u0000\u0003\u0098\u0000\u0000\u0000\u009b\u0000\u0000\u0003\u0092\u0000\u0000\u0001+\u0000\u0000\u0000å\u0000\u0000\u0002\u0083\u0000\u0000\u0001&\u0000\u0000\u0003g\u0000\u0000\u00012\u0000\u0000\u0000X\u0000\u0000\u0000W\u0000\u0000\u0000Á\u0000\u0000\u0001`\u0000\u0000\u0003\r\u0000\u0000\u0003N\u0000\u0000\u0000K\u0000\u0000\u0001G\u0000\u0000\u0002\b\u0000\u0000\u0001³\u0000\u0000\u0002\u001f\u0000\u0000\u0000Ë\u0000\u0000\u0002\u009a\u0000\u0000\u0000ù\u0000\u0000\u0001Z\u0000\u0000\u0003\r\u0000\u0000\u0002m\u0000\u0000\u0002\u0080\u0000\u0000\u0001\f\u0000\u0000\u0003\u001a\u0000\u0000\u0002\u0016\u0000\u0000\u0002\u001b\u0000\u0000\u0003\r\u0000\u0000\u0001\u0098\u0000\u0000\u0001\u0086\u0000\u0000\u0002\u0084\u0000\u0000\u0000f\u0000\u0000\u0001Ü\u0000\u0000\u0001ó\u0000\u0000\u0001\"\u0000\u0000\u0002x\u0000\u0000\u0002!\u0000\u0000\u0000%\u0000\u0000\u0003Z\u0000\u0000\u0003\u0094\u0000\u0000\u0002(\u0000\u0000\u0000)\u0000\u0000\u0002\u001e\u0000\u0000\u0001!\u0000\u0000\u0000z\u0000\u0000\u0001\u0010\u0000\u0000\u0001\u007f\u0000\u0000\u0003 \u0000\u0000\u0001å\u0000\u0000\u0000b\u0000\u0000\u0002ð\u0000\u0000\u0001Ø\u0000\u0000\u0002ù\u0000\u0000\u0000k\u0000\u0000\u0003\u0010\u0000\u0000\u0003\\\u0000\u0000\u0002\u0092\u0000\u0000\u0002å\u0000\u0000\u0001\"\u0000\u0000\u0000Ì\u0000\u0000\u0002©\u0000\u0000\u0001\u0097\u0000\u0000\u0003W\u0000\u0000\u0000U\u0000\u0000\u0000c\u0000\u0000\u0000>\u0000\u0000\u0001â\u0000\u0000\u0000´\u0000\u0000\u0000\u0014\u0000\u0000\u0001)\u0000\u0000\u0001Ã\u0000\u0000\u0002Q\u0000\u0000\u0003\u0091\u0000\u0000\u0000\u008e\u0000\u0000\u0003(\u0000\u0000\u0002¬\u0000\u0000\u0001\u001f\u0000\u0000\u0002\u0018\u0000\u0000\u00021\u0000\u0000\u0000L\u0000\u0000\u0002\u008d\u0000\u0000\u0003\u0083\u0000\u0000\u0002Ù\u0000\u0000\u00027\u0000\u0000\u0002è\u0000\u0000\u0001\u0086\u0000\u0000\u0002\u0001\u0000\u0000\u0000À\u0000\u0000\u0002\u0004\u0000\u0000\u0001\u0002\u0000\u0000\u0000ð\u0000\u0000\u0002\u0006\u0000\u0000\u0003\u001a\u0000\u0000\u0001\u008b\u0000\u0000\u0003\u0000\u0000\u0000\u0003P\u0000\u0000\u00003\u0000\u0000\u0002b\u0000\u0000\u0001\u0080\u0000\u0000\u0000¨\u0000\u0000\u0000¾\u0000\u0000\u0003:\u0000\u0000\u0001H\u0000\u0000\u0002T\u0000\u0000\u0003\u0012\u0000\u0000\u0001/\u0000\u0000\u0002:\u0000\u0000\u0001}\u0000\u0000\u0001\u009f\u0000\u0000\u0002\u0081\u0000\u0000\u0000\u009c\u0000\u0000\u0000í\u0000\u0000\u0000\u0097\u0000\u0000\u0001\u00ad\u0000\u0000\u0002\u0013\u0000\u0000\u0000Ï\u0000\u0000\u0002¤\u0000\u0000\u0002Æ\u0000\u0000\u0000Y\u0000\u0000\u0000¨\u0000\u0000\u00010\u0000\u0000\u0001\u0092\u0000\u0000\u0000(\u0000\u0000\u0002Ä\u0000\u0000\u0002?\u0000\u0000\u0000¢\u0000\u0000\u0003`\u0000\u0000\u0000å\u0000\u0000\u0000A\u0000\u0000\u0003]\u0000\u0000\u0003I\u0000\u0000\u0002\u0000\u0000\u0000\u0000¤\u0000\u0000\u0001Ý\u0000\u0000\u0000Ý\u0000\u0000\u0000\\\u0000\u0000\u0001f\u0000\u0000\u0003\u0011\u0000\u0000\u0001 \u0000\u0000\u0001e\u0000\u0000\u0003R\u0000\u0000\u0003D\u0000\u0000\u0003;\u0000\u0000\u0002à\u0000\u0000\u0002Ã\u0000\u0000\u0000^\u0000\u0000\u0000\b\u0000\u0000\u0001î\u0000\u0000\u0000r\u0000\u0000\u0002\t\u0000\u0000\u0000\u0002\u0000\u0000\u0001ó\u0000\u0000\u0003S\u0000\u0000\u0002\u001f\u0000\u0000\u0000\u0098\u0000\u0000\u0002Ù\u0000\u0000\u0003\u0003\u0000\u0000\u0000_\u0000\u0000\u0000ø\u0000\u0000\u0001i\u0000\u0000\u0002B\u0000\u0000\u0001C\u0000\u0000\u0003X\u0000\u0000\u0003\u001d\u0000\u0000\u0001!\u0000\u0000\u00003\u0000\u0000\u0002¬\u0000\u0000\u0001Ò\u0000\u0000\u0002\u0015\u0000\u0000\u00034\u0000\u0000\u0002\u009d\u0000\u0000\u0000-\u0000\u0000\u0003\u0086\u0000\u0000\u0001Ä\u0000\u0000\u0000§\u0000\u0000\u0001V\u0000\u0000\u0000ô\u0000\u0000\u0000\u00ad\u0000\u0000\u0000#\u0000\u0000\u0001Ï\u0000\u0000\u0002\u008b\u0000\u0000\u00003\u0000\u0000\u0002»\u0000\u0000\u0002O\u0000\u0000\u0001Ä\u0000\u0000\u0002B\u0000\u0000\u0000%\u0000\u0000\u0000|\u0000\u0000\u0001*\u0000\u0000\u0001L\u0000\u0000\u0002(\u0000\u0000\u0000+\u0000\u0000\u0001«\u0000\u0000\u0000w\u0000\u0000\u0002\u0096\u0000\u0000\u0003\t\u0000\u0000\u0001Û\u0000\u0000\u0003R\u0000\u0000\u0002ü\u0000\u0000\u0001l\u0000\u0000\u0002B\u0000\u0000\u0003\u008f\u0000\u0000\u0001\u001b\u0000\u0000\u0002Ç\u0000\u0000\u0001Ø\u0000\u0000\u0001¤\u0000\u0000\u0000õ\u0000\u0000\u0001 \u0000\u0000\u0002R\u0000\u0000\u0001\u008a\u0000\u0000\u0001ÿ\u0000\u0000\u0001G\u0000\u0000\u0002M\u0000\u0000\u0003\t\u0000\u0000\u0002»\u0000\u0000\u0002°\u0000\u0000\u0000+\u0000\u0000\u0001\u0098\u0000\u0000\u0003J\u0000\u0000\u0001\u007f\u0000\u0000\u0002Ñ\u0000\u0000\u0002\t\u0000\u0000\u00020\u0000\u0000\u0002\u0084\u0000\u0000\u0002Ê\u0000\u0000\u0002/\u0000\u0000\u0000>\u0000\u0000\u0000\u0091\u0000\u0000\u0003i\u0000\u0000\u0002\u0097\u0000\u0000\u0002É\u0000\u0000\u0000\u009f\u0000\u0000\u0002 \u0000\u0000\u0002Ù\u0000\u0000\u0002p\u0000\u0000\u0000;\u0000\u0000\u0000Á\u0000\u0000\u0001¡\u0000\u0000\u0000\u009e\u0000\u0000\u0000Ñ\u0000\u0000\u00023\u0000\u0000\u00024\u0000\u0000\u0001W\u0000\u0000\u0002µ\u0000\u0000\u0000m\u0000\u0000\u0002`\u0000\u0000\u00023\u0000\u0000\u0001m\u0000\u0000\u0000µ\u0000\u0000\u0003\u0004\u0000\u0000\u0002¥\u0000\u0000\u00016\u0000\u0000\u0000ø\u0000\u0000\u0001a\u0000\u0000\u0002Ä\u0000\u0000\u0001\u009a\u0000\u0000\u0002C\u0000\u0000\u0003f\u0000\u0000\u0002i\u0000\u0000\u0003I\u0000\u0000\u0002x\u0000\u0000\u0003\\\u0000\u0000\u0001!\u0000\u0000\u0002\u0018\u0000\u0000\u0000#\u0000\u0000\u0003\t\u0000\u0000\u0002j\u0000\u0000\u0002J\u0000\u0000\u0001¨\u0000\u0000\u0003A\u0000\u0000\u0000M\u0000\u0000\u0002U\u0000\u0000\u0001Z\u0000\u0000\u0001\r\u0000\u0000\u0002õ\u0000\u0000\u0002x\u0000\u0000\u0002·\u0000\u0000\u0002ï\u0000\u0000\u0001K\u0000\u0000\u0000÷\u0000\u0000\u0000¸\u0000\u0000\u0000-\u0000\u0000\u0003\u0013\u0000\u0000\u0002¨\u0000\u0000\u0000\u0012\u0000\u0000\u0000B\u0000\u0000\u0001\u0097\u0000\u0000\u0001q\u0000\u0000\u00006\u0000\u0000\u0001ì\u0000\u0000\u0000ä\u0000\u0000\u0002e\u0000\u0000\u0003>\u0000\u0000\u0003\u009a\u0000\u0000\u0001µ\u0000\u0000\u0002\u0007\u0000\u0000\u0002\u0084\u0000\u0000\u0003\u0089\u0000\u0000\u0003\u0015\u0000\u0000\u0001¤\u0000\u0000\u00011\u0000\u0000\u0001¹\u0000\u0000\u0000Ï\u0000\u0000\u0001,\u0000\u0000\u0003|\u0000\u0000\u0003;\u0000\u0000\u0000\u008d\u0000\u0000\u0002\u0019\u0000\u0000\u0001}\u0000\u0000\u0002\u0096\u0000\u0000\u0002\u0001\u0000\u0000\u00008\u0000\u0000\u0000ü\u0000\u0000\u0001U\u0000\u0000\u0000ò\u0000\u0000\u0003\u001d\u0000\u0000\u0003F\u0000\u0000\u0003E\u0000\u0000\u0002Ð\u0000\u0000\u0000à\u0000\u0000\u00013\u0000\u0000\u0002w\u0000\u0000\u0000=\u0000\u0000\u0000W\u0000\u0000\u00020\u0000\u0000\u00016\u0000\u0000\u0002ô\u0000\u0000\u0002\u0099\u0000\u0000\u0001\u008d\u0000\u0000\u0003(\u0000\u0000\u0003S\u0000\u0000\u00015\u0000\u0000\u0001Ù\u0000\u0000\u0003\u001b\u0000\u0000\u0001z\u0000\u0000\u0000\u001f\u0000\u0000\u0002\u0087\u0000\u0000\u0003\u0093\u0000\u0000\u0001Ë\u0000\u0000\u0003&\u0000\u0000\u0002N\u0000\u0000\u0002Û\u0000\u0000\u0001©\u0000\u0000\u0000Ø\u0000\u0000\u0002$\u0000\u0000\u0000ù\u0000\u0000\u0001A\u0000\u0000\u0003q\u0000\u0000\u0002»\u0000\u0000\u0002\u0017\u0000\u0000\u0002¡\u0000\u0000\u0003\u000e\u0000\u0000\u0000Ò\u0000\u0000\u0003/\u0000\u0000\u0003\u0089\u0000\u0000\u0001/\u0000\u0000\u0003K\u0000\u0000\u0003\u009a\u0000\u0000\u0001\u0019\u0000\u0000\u0000I\u0000\u0000\u0001Õ\u0000\u0000\u0003\u0017\u0000\u0000\u0002\u0094\u0000\u0000\u0000¢\u0000\u0000\u0001ò\u0000\u0000\u00014\u0000\u0000\u0000\u009b\u0000\u0000\u0001¦\u0000\u0000\u0003\u008b\u0000\u0000\u00031\u0000\u0000\u0000»\u0000\u0000\u0000>\u0000\u0000\u0000\u0010\u0000\u0000\u0001©\u0000\u0000\u0002\u0017\u0000\u0000\u0001P\u0000\u0000\u0001\u001e\u0000\u0000\u0001µ\u0000\u0000\u0001w\u0000\u0000\u0001\u0011\u0000\u0000\u0002b\u0000\u0000\u0001(\u0000\u0000\u0000·\u0000\u0000\u0003\u009b\u0000\u0000\u0000t\u0000\u0000\u0002\u009b\u0000\u0000\u0002ï\u0000\u0000\u0001a\u0000\u0000\u0000>\u0000\u0000\u0001n\u0000\u0000\u0002³\u0000\u0000\u0001{\u0000\u0000\u0002¯\u0000\u0000\u0003J\u0000\u0000\u0000%\u0000\u0000\u0001e\u0000\u0000\u0002Ð\u0000\u0000\u0002æ\u0000\u0000\u0001J\u0000\u0000\u0000\u0005\u0000\u0000\u0000'\u0000\u0000\u0003\u009b\u0000\u0000\u00017\u0000\u0000\u0001¨\u0000\u0000\u0000ò\u0000\u0000\u0002í\u0000\u0000\u0001A\u0000\u0000\u00006\u0000\u0000\u0002\u009d\u0000\u0000\u0001<\u0000\u0000\u0001V\u0000\u0000\u0001+\u0000\u0000\u0002\u0016\u0000\u0000\u0000i\u0000\u0000\u0002\u009b\u0000\u0000\u0001è\u0000\u0000\u0002\u0080\u0000\u0000\u0002 \u0000\u0000\u0002@\u0000\u0000\u0002\u001c\u0000\u0000\u0001<\u0000\u0000\u0001æ\u0000\u0000\u0002Ñ\u0000\u0000\u0002b\u0000\u0000\u0000.\u0000\u0000\u0002\u0090\u0000\u0000\u0001¿\u0000\u0000\u0000«\u0000\u0000\u0002h\u0000\u0000\u0001Ð\u0000\u0000\u0000¾\u0000\u0000\u0002\u0013\u0000\u0000\u0001)\u0000\u0000\u0001A\u0000\u0000\u0002ú\u0000\u0000\u0002ð\u0000\u0000\u0002\u0015\u0000\u0000\u0000¯\u0000\u0000\u0000\u0086\u0000\u0000\u0000\u000e\u0000\u0000\u0001}\u0000\u0000\u0001±\u0000\u0000\u0002Í\u0000\u0000\u0000-\u0000\u0000\u0000o\u0000\u0000\u0000\u0014\u0000\u0000\u0002T\u0000\u0000\u0001\u001c\u0000\u0000\u0002à\u0000\u0000\u0000\u008a\u0000\u0000\u0002\u0086\u0000\u0000\u0001\u009b\u0000\u0000\u0003m\u0000\u0000\u0002\u009d\u0000\u0000\u0000\u008d\u0000\u0000\u0003\u0097\u0000\u0000\u0000-\u0000\u0000\u0003\f\u0000\u0000\u0001\u0097\u0000\u0000\u0000¤\u0000\u0000\u0001L\u0000\u0000\u0003\u0083\u0000\u0000\u0000¥\u0000\u0000\u0002Ö\u0000\u0000\u0002X\u0000\u0000\u0001E\u0000\u0000\u0001ò\u0000\u0000\u0002\u008f\u0000\u0000\u0001e\u0000\u0000\u0002ð\u0000\u0000\u0003\u0000\u0000\u0000\u0000ß\u0000\u0000\u0003Q\u0000\u0000\u0002\u0087\u0000\u0000\u0000?\u0000\u0000\u00016\u0000\u0000\u0003_\u0000\u0000\u0000û\u0000\u0000\u0001n\u0000\u0000\u00010\u0000\u0000\u0001\u001a\u0000\u0000\u0002â\u0000\u0000\u0002£\u0000\u0000\u0001\u009a\u0000\u0000\u0001\u0085\u0000\u0000\u0000ô\u0000\u0000\u0000\u001f\u0000\u0000\u0000y\u0000\u0000\u0001/\u0000\u0000\u0001\u0007".getBytes("ISO-8859-1")).asIntBuffer().get(iArr2, 0, 512);
        System.arraycopy(iArr2, 0, iArr, 0, 512);
        EC_COEFFICIENTS = new int[][]{new int[]{27, 917}, new int[]{522, 568, 723, 809}, new int[]{237, 308, 436, 284, 646, 653, 428, 379}, new int[]{274, 562, 232, 755, SecExceptionCode.SEC_ERROR_DYN_STORE_UNKNOWN_ERROR, 524, SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 132, 295, 116, 442, 428, 295, 42, 176, 65}, new int[]{361, 575, 922, 525, 176, 586, 640, 321, 536, 742, 677, 742, 687, 284, 193, DeepRecoverARiverProxy.TYPE_EXCEPTION_CANNOT_CRASH_APP, LZMA_Base.kMatchMaxLen, 494, 263, 147, 593, 800, 571, 320, SecExceptionCode.SEC_ERROR_PKG_VALID_NO_MEMORY, 133, 231, 390, 685, 330, 63, 410}, new int[]{539, SecExceptionCode.SEC_ERROR_DYN_ENC_DECRYPT_FAILED, 6, 93, 862, 771, 453, 106, SecExceptionCode.SEC_ERROR_SIGNATURE_INCORRECT_DATA_FILE_DATA, 287, 107, SecExceptionCode.SEC_ERROR_DYN_STORE_GET_ENCRYPT_KEY_FAILED, 733, 877, 381, SecExceptionCode.SEC_ERROR_SIGNATURE_ILLEGEL_KEY, 723, 476, 462, 172, 430, SecExceptionCode.SEC_ERROR_SIGNATURE_INCORRECT_DATA_FILE, 858, 822, 543, 376, 511, 400, 672, 762, 283, 184, 440, 35, 519, 31, 460, 594, 225, 535, DeepRecoverARiverProxy.TYPE_EXCEPTION_CANNOT_CRASH_APP, 352, SecExceptionCode.SEC_ERROR_SIGNATURE_CONFUSE_FAILED, 158, 651, 201, 488, 502, 648, 733, 717, 83, 404, 97, 280, 771, 840, 629, 4, 381, 843, 623, 264, 543}, new int[]{521, SecExceptionCode.SEC_ERROR_STA_INVALID_ENCRYPTED_DATA, 864, 547, 858, 580, 296, 379, 53, 779, 897, 444, 400, 925, 749, 415, 822, 93, FileUtils.JPEG_MARKER_EOI, 208, PDF417Common.MAX_CODEWORDS_IN_BARCODE, 244, 583, 620, 246, 148, 447, 631, 292, SecExceptionCode.SEC_ERROR_UMID_TIME_OUT, 490, SecExceptionCode.SEC_ERROR_STA_KEY_ENC_INVALID_ENCRYPTED_DATA, DeepRecoverARiverProxy.TYPE_EXCEPTION_CANNOT_CRASH_PAGE, DeepRecoverARiverProxy.TYPE_ENTITY_TEMPLATE, 457, SecExceptionCode.SEC_ERROR_UMID_NO_NETWORK_INIT, 594, 723, 674, 292, LZMA_Base.kNumLenSymbols, 96, 684, 432, 686, SecExceptionCode.SEC_ERROR_SIGNATURE_NO_SEEDSECRET, 860, 569, 193, 219, 129, 186, 236, 287, 192, 775, 278, 173, 40, 379, 712, 463, 646, 776, 171, 491, 297, 763, 156, 732, 95, 270, 447, 90, 507, 48, 228, 821, 808, 898, 784, 663, 627, 378, 382, 262, 380, SecExceptionCode.SEC_ERROR_SIGNATURE_NO_MEM, 754, 336, 89, SecExceptionCode.SEC_ERROR_SIGNATURE_BLOWFISH_FAILED, 87, 432, 670, 616, 157, 374, 242, 726, 600, 269, 375, 898, 845, 454, 354, 130, 814, 587, SecExceptionCode.SEC_ERROR_PKG_VALID_NO_CONFIG_FILE, 34, 211, 330, 539, 297, 827, 865, 37, DeepRecoverARiverProxy.TYPE_EXCEPTION_CANNOT_CRASH_APP, 834, 315, 550, 86, SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 4, 108, 539}, new int[]{524, 894, 75, 766, 882, 857, 74, 204, 82, 586, 708, 250, SecExceptionCode.SEC_ERROR_UMID_SERVER_RESP_INVALID, 786, 138, 720, 858, 194, SecExceptionCode.SEC_ERROR_STA_DECRYPT_MISMATCH_KEY_DATA, 913, 275, 190, 375, 850, 438, 733, 194, 280, 201, 280, 828, 757, 710, 814, 919, 89, 68, 569, 11, 204, 796, SecExceptionCode.SEC_ERROR_SIGNATURE_CONFUSE_FAILED, 540, 913, SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 700, SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 137, 439, 418, 592, 668, 353, 859, 370, 694, 325, 240, 216, DeepRecoverARiverProxy.TYPE_ENTITY_APP, 284, 549, 209, 884, 315, 70, 329, 793, 490, 274, 877, 162, 749, 812, 684, 461, 334, 376, 849, 521, 307, 291, SecExceptionCode.SEC_ERROR_PKG_VALID_NO_MEMORY, 712, 19, 358, SecExceptionCode.SEC_ERROR_STA_UNKNOWN_ERROR, SecExceptionCode.SEC_ERROR_UMID_TIME_OUT, 103, 511, 51, 8, DeepRecoverARiverProxy.TYPE_EXCEPTION_CANNOT_CRASH_APP, 225, 289, 470, 637, 731, 66, 255, 917, 269, 463, 830, 730, 433, 848, 585, 136, 538, SecExceptionCode.SEC_ERROR_UMID_ENVIRONMENT_CHANGED, 90, 2, 290, 743, SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, 655, SecExceptionCode.SEC_ERROR_UMID_GET_URL_ERROR, 329, 49, SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_JPG, 580, 355, 588, 188, 462, 10, 134, 628, 320, 479, 130, 739, 71, 263, 318, 374, SecExceptionCode.SEC_ERROR_SIGNATRUE_INVALID_INPUT, 192, SecExceptionCode.SEC_ERROR_SIGNATURE_CONFUSE_FAILED, 142, 673, 687, 234, 722, 384, 177, 752, SecExceptionCode.SEC_ERROR_SIGNATURE_DATA_FILE_MISMATCH, 640, 455, 193, 689, 707, SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_APK_PATH, 641, 48, 60, 732, 621, 895, 544, DeepRecoverARiverProxy.TYPE_ENTITY_ONLINE_PAGE, 852, 655, SecExceptionCode.SEC_ERROR_STA_NO_SUCH_INDEX, 697, 755, 756, 60, 231, 773, 434, 421, 726, 528, 503, 118, 49, 795, 32, 144, 500, 238, 836, 394, 280, 566, 319, 9, 647, 550, 73, 914, 342, 126, 32, 681, 331, 792, 620, 60, SecExceptionCode.SEC_ERROR_SIGNATURE_INCORRECT_DATA_FILE, 441, 180, 791, 893, 754, SecExceptionCode.SEC_ERROR_SIGNATURE_CONFUSE_FAILED, 383, 228, 749, 760, 213, 54, 297, 134, 54, 834, SecExceptionCode.SEC_ERROR_STA_STORE_UNKNOWN_ERROR, 922, 191, 910, 532, SecExceptionCode.SEC_ERROR_SIGNATURE_INCORRECT_DATA_FILE, 829, WSContextConstant.HANDSHAKE_SEND_SIZE, 20, 167, 29, 872, 449, 83, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY, 41, 656, SecExceptionCode.SEC_ERROR_DYN_STORE_GET_ENCRYPT_KEY_FAILED, 579, 481, 173, 404, 251, 688, 95, 497, 555, 642, 543, 307, 159, 924, 558, 648, 55, 497, 10}, iArr};
    }

    private PDF417ErrorCorrection() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getErrorCorrectionCodewordCount(int i) {
        if (i < 0 || i > 8) {
            throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
        }
        return 1 << (i + 1);
    }

    static int getRecommendedMinimumErrorCorrectionLevel(int i) throws WriterException {
        if (i > 0) {
            if (i <= 40) {
                return 2;
            }
            if (i <= 160) {
                return 3;
            }
            if (i <= 320) {
                return 4;
            }
            if (i <= 863) {
                return 5;
            }
            throw new WriterException("No recommendation possible");
        }
        throw new IllegalArgumentException("n must be > 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String generateErrorCorrection(CharSequence charSequence, int i) {
        int errorCorrectionCodewordCount = getErrorCorrectionCodewordCount(i);
        char[] cArr = new char[errorCorrectionCodewordCount];
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = errorCorrectionCodewordCount - 1;
            int charAt = (charSequence.charAt(i2) + cArr[i3]) % PDF417Common.NUMBER_OF_CODEWORDS;
            while (i3 > 0) {
                cArr[i3] = (char) ((cArr[i3 - 1] + (929 - ((EC_COEFFICIENTS[i][i3] * charAt) % PDF417Common.NUMBER_OF_CODEWORDS))) % PDF417Common.NUMBER_OF_CODEWORDS);
                i3--;
            }
            cArr[0] = (char) ((929 - ((charAt * EC_COEFFICIENTS[i][0]) % PDF417Common.NUMBER_OF_CODEWORDS)) % PDF417Common.NUMBER_OF_CODEWORDS);
        }
        StringBuilder sb = new StringBuilder(errorCorrectionCodewordCount);
        for (int i4 = errorCorrectionCodewordCount - 1; i4 >= 0; i4--) {
            char c = cArr[i4];
            if (c != 0) {
                cArr[i4] = (char) (929 - c);
            }
            sb.append(cArr[i4]);
        }
        return sb.toString();
    }
}
