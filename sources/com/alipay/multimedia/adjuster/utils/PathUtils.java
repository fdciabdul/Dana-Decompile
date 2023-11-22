package com.alipay.multimedia.adjuster.utils;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes7.dex */
public class PathUtils {
    public static final String CONTENT_SCHEMA = "content://";

    /* renamed from: a  reason: collision with root package name */
    private static final String f7338a;

    /* renamed from: com.alipay.multimedia.adjuster.utils.PathUtils$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
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
            return (i == 2 || i == 3) ? a(str) : str;
        }
        String crop = Scheme.FILE.crop(str);
        if (TextUtils.isEmpty(crop)) {
            return crop;
        }
        String str2 = f7338a;
        return crop.startsWith(str2) ? crop.substring(str2.length()) : crop;
    }

    private static String a(String str) {
        return ZURLEncodedUtil.urlEncode(str);
    }

    public static boolean isLocalFile(String str) {
        return (!TextUtils.isEmpty(str) && (str.startsWith("/") || isLocalFile(Uri.parse(str)))) || str.startsWith("local");
    }

    public static boolean isLocalFile(Uri uri) {
        return (uri == null || !"file".equalsIgnoreCase(uri.getScheme()) || hasHost(uri)) ? false : true;
    }

    public static boolean hasHost(Uri uri) {
        String host = uri.getHost();
        return (host == null || "".equals(host)) ? false : true;
    }

    public static boolean isContentUriPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(CONTENT_SCHEMA);
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(File.separator);
        sb.append("[asset]");
        sb.append(File.separator);
        f7338a = sb.toString();
    }
}
