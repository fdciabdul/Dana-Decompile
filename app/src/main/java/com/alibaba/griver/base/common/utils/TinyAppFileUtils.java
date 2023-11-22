package com.alibaba.griver.base.common.utils;

import android.text.TextUtils;
import com.alibaba.griver.image.photo.PhotoContext;
import java.io.File;

/* loaded from: classes2.dex */
public final class TinyAppFileUtils {
    public static boolean containsRelativeParentPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("../") || str.endsWith("/..") || str.contains("/../");
    }

    public static boolean isLocalPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(PhotoContext.FILE_SCHEME) || str.startsWith(File.separator);
    }

    public static boolean checkFileType(String str, String str2) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (lastIndexOf = str2.lastIndexOf(46)) <= 0) {
            return false;
        }
        return TextUtils.equals(str, str2.substring(lastIndexOf + 1));
    }
}
