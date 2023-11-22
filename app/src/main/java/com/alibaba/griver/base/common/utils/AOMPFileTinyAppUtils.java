package com.alibaba.griver.base.common.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.proxy.LocalIdTool;
import com.alibaba.griver.base.common.proxy.RVFileAbilityProxy;
import com.alibaba.griver.image.photo.PhotoContext;

/* loaded from: classes2.dex */
public class AOMPFileTinyAppUtils {
    public static String getUserId() {
        RVFileAbilityProxy rVFileAbilityProxy = (RVFileAbilityProxy) RVProxy.get(RVFileAbilityProxy.class);
        if (rVFileAbilityProxy == null) {
            RVLogger.e("AOMPFileTinyAppUtils", "provider ==null ");
            return null;
        }
        return rVFileAbilityProxy.getUserId();
    }

    public static String encodeToLocalId(String str) {
        return LocalIdTool.get().encodeToLocalId(str);
    }

    public static String transferApPathToLocalPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String localPathFromId = getLocalPathFromId(str);
        return (TextUtils.isEmpty(localPathFromId) || !localPathFromId.startsWith(PhotoContext.FILE_SCHEME)) ? localPathFromId : localPathFromId.replaceAll(PhotoContext.FILE_SCHEME, "");
    }

    public static String getLocalPathFromId(String str) {
        String matchLocalId;
        String decodeToPath;
        if (str.endsWith("image")) {
            matchLocalId = matchLocalId(str, "image");
            if (!TextUtils.isEmpty(matchLocalId)) {
                str = decodeToPath(matchLocalId);
            }
        } else if (str.endsWith("video")) {
            matchLocalId = matchLocalId(str, "video");
            if (!TextUtils.isEmpty(matchLocalId)) {
                str = decodeToPath(matchLocalId);
            }
        } else if (str.endsWith(H5ResourceHandlerUtil.AUDIO)) {
            matchLocalId = matchLocalId(str, H5ResourceHandlerUtil.AUDIO);
            if (!TextUtils.isEmpty(matchLocalId)) {
                str = decodeToPath(matchLocalId);
            }
        } else if (str.endsWith(OfficeFileType.Pdf.fileType())) {
            matchLocalId = matchLocalId(str, OfficeFileType.Pdf.fileType());
            if (!TextUtils.isEmpty(matchLocalId)) {
                str = decodeToPath(matchLocalId);
            }
        } else if (str.endsWith(OfficeFileType.Doc.fileType())) {
            matchLocalId = matchLocalId(str, OfficeFileType.Doc.fileType());
            if (!TextUtils.isEmpty(matchLocalId)) {
                str = decodeToPath(matchLocalId);
            }
        } else if (str.endsWith(OfficeFileType.Docx.fileType())) {
            matchLocalId = matchLocalId(str, OfficeFileType.Docx.fileType());
            if (!TextUtils.isEmpty(matchLocalId)) {
                str = decodeToPath(matchLocalId);
            }
        } else if (str.endsWith(OfficeFileType.Xls.fileType())) {
            matchLocalId = matchLocalId(str, OfficeFileType.Xls.fileType());
            if (!TextUtils.isEmpty(matchLocalId)) {
                str = decodeToPath(matchLocalId);
            }
        } else if (str.endsWith(OfficeFileType.Xlsx.fileType())) {
            matchLocalId = matchLocalId(str, OfficeFileType.Xlsx.fileType());
            if (!TextUtils.isEmpty(matchLocalId)) {
                str = decodeToPath(matchLocalId);
            }
        } else if (str.endsWith(OfficeFileType.PPt.fileType())) {
            matchLocalId = matchLocalId(str, OfficeFileType.PPt.fileType());
            if (!TextUtils.isEmpty(matchLocalId)) {
                str = decodeToPath(matchLocalId);
            }
        } else if (str.endsWith(OfficeFileType.PPtx.fileType())) {
            matchLocalId = matchLocalId(str, OfficeFileType.PPtx.fileType());
            if (!TextUtils.isEmpty(matchLocalId)) {
                str = decodeToPath(matchLocalId);
            }
        } else {
            matchLocalId = matchLocalId(str, "other");
            if (!TextUtils.isEmpty(matchLocalId)) {
                str = decodeToPath(matchLocalId);
            } else if (!TextUtils.isEmpty(str) && str.startsWith(LocalIdTool.PREFIX)) {
                decodeToPath = decodeToPath(str);
                StringBuilder sb = new StringBuilder();
                sb.append("id:");
                sb.append(str);
                sb.append(" filePath:");
                sb.append(decodeToPath);
                RVLogger.d("AOMPFileTinyAppUtils", sb.toString());
                return decodeToPath;
            }
        }
        String str2 = matchLocalId;
        decodeToPath = str;
        str = str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("id:");
        sb2.append(str);
        sb2.append(" filePath:");
        sb2.append(decodeToPath);
        RVLogger.d("AOMPFileTinyAppUtils", sb2.toString());
        return decodeToPath;
    }

    public static String matchLocalId(String str, String str2) {
        Uri parseUrl;
        String[] split;
        if (str == null || !str.startsWith(H5ResourceHandlerUtil.RESOURCE) || !str.endsWith(str2) || (parseUrl = H5UrlHelper.parseUrl(str)) == null || TextUtils.isEmpty(parseUrl.getPath()) || (split = parseUrl.getPath().replace("/", "").split("\\.")) == null || split.length <= 1) {
            return null;
        }
        String str3 = split[0];
        try {
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            return str3;
        } catch (Exception e) {
            RVLogger.e("AOMPFileTinyAppUtils", e);
            return null;
        }
    }

    public static String decodeToPath(String str) {
        return LocalIdTool.get().decodeToPath(str);
    }

    public static String getTypeFromMimeType(String str) {
        if (str == null) {
            return "other";
        }
        if (str.contains("image")) {
            return "image";
        }
        if (str.contains("video")) {
            return "video";
        }
        if (str.contains(H5ResourceHandlerUtil.AUDIO)) {
            return H5ResourceHandlerUtil.AUDIO;
        }
        if (str.contains(OfficeFileType.Pdf.fileType())) {
            return OfficeFileType.Pdf.fileType();
        }
        if (str.contains(OfficeFileType.Doc.fileType())) {
            return OfficeFileType.Doc.fileType();
        }
        if (str.contains(OfficeFileType.Docx.fileType())) {
            return OfficeFileType.Docx.fileType();
        }
        if (str.contains(OfficeFileType.Xls.fileType())) {
            return OfficeFileType.Xls.fileType();
        }
        if (str.contains(OfficeFileType.Xlsx.fileType())) {
            return OfficeFileType.Xlsx.fileType();
        }
        if (str.contains(OfficeFileType.PPt.fileType())) {
            return OfficeFileType.PPt.fileType();
        }
        return str.contains(OfficeFileType.PPtx.fileType()) ? OfficeFileType.PPtx.fileType() : "other";
    }
}
