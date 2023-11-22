package com.alibaba.griver.image.framework.utils;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.env.GriverEnv;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class FileUtils {
    public static final int JPEG_MARKER_EOI = 217;
    public static final int JPEG_MARKER_FIRST_BYTE = 255;
    public static final String TAG = "FileUtils";

    /* renamed from: a  reason: collision with root package name */
    private static final String f6591a;
    public static final HashMap<String, String> mFileTypes;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(File.separator);
        sb.append("alipay");
        f6591a = sb.toString();
        HashMap<String, String> hashMap = new HashMap<>();
        mFileTypes = hashMap;
        hashMap.put("FFD8FFE0", ".jpg");
        hashMap.put("FFD8FFE1", ".jpg");
        hashMap.put("89504E47", ".png");
        hashMap.put("47494638", Format.SUFFIX_GIF);
        hashMap.put("49492A00", ".tif");
    }

    public static boolean safeCopyToFile(byte[] bArr, File file) throws IOException {
        if (bArr == null) {
            return false;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            return safeCopyToFile(byteArrayInputStream, file);
        } finally {
            IOUtils.closeQuietly(byteArrayInputStream);
        }
    }

    public static boolean safeCopyToFile(InputStream inputStream, File file) throws IOException {
        return BFileUtils.safeCopyToFile(inputStream, file);
    }

    public static boolean checkFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return checkFile(new File(str));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("checkFile exp path: ");
            sb.append(str);
            RVLogger.e(TAG, sb.toString(), e);
            return false;
        }
    }

    public static boolean checkFile(File file) {
        return BFileUtils.checkFile(file);
    }

    public static boolean mkdirs(File file) {
        return BFileUtils.mkdirs(file);
    }

    public static boolean delete(File file) {
        return BFileUtils.delete(file);
    }

    public static File makeTakenPicturePath() {
        File file = new File(GriverEnv.getApplicationContext().getExternalCacheDir(), "griver/pictures");
        StringBuilder sb = new StringBuilder();
        sb.append(getCurrentDateFormat());
        sb.append(".jpg");
        File file2 = new File(file, sb.toString());
        try {
            mkdirs(file);
            file2.createNewFile();
        } catch (IOException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("makeTakenPicturePath createNewFile error, ");
            sb2.append(file2);
            RVLogger.e(TAG, sb2.toString(), e);
        }
        return file2;
    }

    public static File makeTakenPicturePrivatePath() {
        Application applicationContext = GriverEnv.getApplicationContext();
        StringBuilder sb = new StringBuilder();
        sb.append(applicationContext.getExternalCacheDir());
        sb.append(File.separator);
        sb.append("mm/pictures");
        File file = new File(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getCurrentDateFormat());
        sb2.append(".jpg");
        File file2 = new File(file, sb2.toString());
        try {
            mkdirs(file);
            File file3 = new File(file, ".nomedia");
            if (!file3.exists()) {
                file3.createNewFile();
            }
            file2.createNewFile();
        } catch (IOException e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("makeTakenPicturePath createNewFile error, ");
            sb3.append(file2);
            RVLogger.e(TAG, sb3.toString(), e);
        }
        return file2;
    }

    public static String getCurrentDateFormat() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    }

    public static boolean isAnimationFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ImageType.isAnimation(new File(str));
    }
}
