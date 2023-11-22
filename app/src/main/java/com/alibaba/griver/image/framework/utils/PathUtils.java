package com.alibaba.griver.image.framework.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.griver.image.framework.encode.APEncodeOptions;
import com.alibaba.griver.image.framework.meta.Size;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.WheelView;
import com.alipay.multimedia.adjuster.utils.Scheme;
import com.alipay.multimedia.adjuster.utils.ZURLEncodedUtil;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.File;

/* loaded from: classes6.dex */
public class PathUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6593a;
    private static final int[] b;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(File.separator);
        sb.append("[asset]");
        sb.append(File.separator);
        f6593a = sb.toString();
        b = new int[]{16, 24, 32, 40, 50, 64, 72, 80, 90, 100, 110, 120, 130, 140, 150, BlobStatic.MONITOR_IMAGE_WIDTH, 170, 180, 190, 200, WheelView.DIVIDER_ALPHA, 240, 250, 270, 290, 300, SecExceptionCode.SEC_ERROR_STA_LOW_VERSION_DATA_FILE, 320, AUScreenAdaptTool.WIDTH_BASE, 375, 400, 430, 438, 460, 480, 500, 540, 560, 580, 600, 640, 670, 720, 760, 800, 960, 1024, 1136, APEncodeOptions.DEFAULT_MAX_LEN};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.griver.image.framework.utils.PathUtils$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alipay$multimedia$adjuster$utils$Scheme;

        static {
            int[] iArr = new int[Scheme.values().length];
            $SwitchMap$com$alipay$multimedia$adjuster$utils$Scheme = iArr;
            try {
                iArr[Scheme.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alipay$multimedia$adjuster$utils$Scheme[Scheme.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alipay$multimedia$adjuster$utils$Scheme[Scheme.HTTPS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alipay$multimedia$adjuster$utils$Scheme[Scheme.CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alipay$multimedia$adjuster$utils$Scheme[Scheme.DRAWABLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$alipay$multimedia$adjuster$utils$Scheme[Scheme.ASSETS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$alipay$multimedia$adjuster$utils$Scheme[Scheme.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static String extractPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = AnonymousClass1.$SwitchMap$com$alipay$multimedia$adjuster$utils$Scheme[Scheme.ofUri(str).ordinal()];
        if (i != 1) {
            return (i == 2 || i == 3) ? urlEncode(str) : str;
        }
        String crop = Scheme.FILE.crop(str);
        if (TextUtils.isEmpty(crop)) {
            return crop;
        }
        String str2 = f6593a;
        return crop.startsWith(str2) ? crop.substring(str2.length()) : crop;
    }

    public static File extractFile(String str) {
        File file;
        if (!TextUtils.isEmpty(str)) {
            try {
                Uri parse = Uri.parse(str);
                if (isLocalFile(parse)) {
                    file = new File(extractPath(str));
                } else if (!isHttp(parse)) {
                    file = new File(str);
                }
            } catch (Exception unused) {
                file = new File(str);
            }
            if (file != null || (file.exists() && file.isFile())) {
                return file;
            }
            return null;
        }
        file = null;
        if (file != null) {
        }
        return file;
    }

    public static boolean isLocalFile(Uri uri) {
        return (uri == null || !"file".equalsIgnoreCase(uri.getScheme()) || hasHost(uri)) ? false : true;
    }

    public static boolean isHttp(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        return ("https".equalsIgnoreCase(scheme) || SemanticAttributes.FaasTriggerValues.HTTP.equalsIgnoreCase(scheme)) && hasHost(uri);
    }

    public static boolean hasHost(Uri uri) {
        String host = uri.getHost();
        return (host == null || "".equals(host)) ? false : true;
    }

    public static Size getDjangoNearestImageSize(Size size) {
        int[] iArr = b;
        int i = iArr[a(iArr, Math.max(size.getWidth(), size.getHeight()), false)];
        return new Size(i, i);
    }

    private static int a(int[] iArr, int i, boolean z) {
        int i2;
        int i3;
        int length = iArr.length - 1;
        int i4 = 0;
        while (i4 <= length) {
            int i5 = (i4 + length) / 2;
            int i6 = iArr[i5];
            if (i == i6) {
                return i5;
            }
            if (i < i6) {
                length = i5 - 1;
            } else {
                i4 = i5 + 1;
            }
        }
        if (length < 0) {
            return 0;
        }
        return z ? (i <= iArr[length] || (i3 = length + 1) > iArr.length + (-1)) ? length : i3 : (i >= iArr[length] || (i2 = length + (-1)) < 0) ? length : i2;
    }

    public static String urlEncode(String str) {
        return ZURLEncodedUtil.urlEncode(str);
    }
}
