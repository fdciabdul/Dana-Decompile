package io.split.android.client.common;

import io.split.android.client.utils.CompressionUtil;
import io.split.android.client.utils.Gzip;
import io.split.android.client.utils.Zlib;
import io.split.android.client.utils.logger.Logger;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class CompressionUtilProvider {
    Map<CompressionType, CompressionUtil> mCompressionUtils = new ConcurrentHashMap();

    public CompressionUtil get(CompressionType compressionType) {
        CompressionUtil compressionUtil = this.mCompressionUtils.get(compressionType);
        return compressionUtil != null ? compressionUtil : create(compressionType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.split.android.client.common.CompressionUtilProvider$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$common$CompressionType;

        static {
            int[] iArr = new int[CompressionType.values().length];
            $SwitchMap$io$split$android$client$common$CompressionType = iArr;
            try {
                iArr[CompressionType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$common$CompressionType[CompressionType.GZIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$common$CompressionType[CompressionType.ZLIB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private CompressionUtil create(CompressionType compressionType) {
        int i = AnonymousClass2.$SwitchMap$io$split$android$client$common$CompressionType[compressionType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return new Zlib();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Unavailable compression algorithm: ");
                sb.append(compressionType);
                Logger.d(sb.toString());
                return null;
            }
            return new Gzip();
        }
        return new CompressionUtil() { // from class: io.split.android.client.common.CompressionUtilProvider.1
            @Override // io.split.android.client.utils.CompressionUtil
            public byte[] decompress(byte[] bArr) {
                return bArr;
            }
        };
    }
}
