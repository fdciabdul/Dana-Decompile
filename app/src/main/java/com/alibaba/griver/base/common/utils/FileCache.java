package com.alibaba.griver.base.common.utils;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.a.b;
import java.io.File;
import java.security.MessageDigest;
import java.util.Stack;

/* loaded from: classes2.dex */
public class FileCache {
    public static final long EXPIRE_TIME = 604800000;
    public static final String TAG = "FileCache";

    /* renamed from: a  reason: collision with root package name */
    private String f6309a;

    public FileCache(Context context) {
        clearExpired(context);
    }

    public FileCache(final Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("/");
            sb.append(getMD5(str2));
            this.f6309a = sb.toString();
        } else {
            this.f6309a = str;
        }
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.IO).execute(new Runnable() { // from class: com.alibaba.griver.base.common.utils.FileCache.1
            @Override // java.lang.Runnable
            public void run() {
                FileCache.this.clearExpired(context);
            }
        });
    }

    public static String getMD5(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MD5Util.ALGORIGTHM_MD5);
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            byte[] digest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i2 = b & 255;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean containCachePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("/h5/download/temp") || str.contains("/h5/download/cache");
    }

    public String getCachePath(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(b.b(str));
        sb.append(".");
        sb.append(H5FileUtil.getExtension(str));
        String obj = sb.toString();
        String str2 = "/h5/download/cache/";
        if (!TextUtils.isEmpty(this.f6309a)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("/h5/download/cache/");
            sb2.append(this.f6309a);
            sb2.append("/");
            str2 = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str2);
        sb3.append(obj);
        return DiskUtil.getSubDir(context, sb3.toString());
    }

    public String getCacheDir(Context context) {
        String str = "/h5/download/cache/";
        if (!TextUtils.isEmpty(this.f6309a)) {
            StringBuilder sb = new StringBuilder();
            sb.append("/h5/download/cache/");
            sb.append(this.f6309a);
            sb.append("/");
            str = sb.toString();
        }
        return DiskUtil.getSubDir(context, str);
    }

    public String getTempPath(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(b.b(str));
        sb.append(".");
        sb.append(H5FileUtil.getExtension(str));
        String obj = sb.toString();
        String str2 = "/h5/download/temp/";
        if (!TextUtils.isEmpty(this.f6309a)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("/h5/download/temp/");
            sb2.append(this.f6309a);
            sb2.append("/");
            str2 = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str2);
        sb3.append(obj);
        String subDir = DiskUtil.getSubDir(context, sb3.toString());
        if (!H5FileUtil.exists(subDir)) {
            H5FileUtil.create(subDir);
        }
        return subDir;
    }

    public String getTempPath(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(b.b(str));
        sb.append(".");
        sb.append(str2);
        String obj = sb.toString();
        String str3 = "/h5/download/temp/";
        if (!TextUtils.isEmpty(this.f6309a)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("/h5/download/temp/");
            sb2.append(this.f6309a);
            sb2.append("/");
            str3 = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str3);
        sb3.append(obj);
        String subDir = DiskUtil.getSubDir(context, sb3.toString());
        if (!H5FileUtil.exists(subDir)) {
            H5FileUtil.create(subDir);
        }
        return subDir;
    }

    public void clearExpired(Context context) {
        String subDir;
        String subDir2;
        if (context == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(this.f6309a)) {
                StringBuilder sb = new StringBuilder();
                sb.append("/h5/download/temp/");
                sb.append(this.f6309a);
                subDir = DiskUtil.getSubDir(context, sb.toString());
            } else {
                subDir = DiskUtil.getSubDir(context, "/h5/download/temp");
            }
            if (H5FileUtil.exists(subDir)) {
                a(subDir);
            }
            if (!TextUtils.isEmpty(this.f6309a)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("/h5/download/cache/");
                sb2.append(this.f6309a);
                subDir2 = DiskUtil.getSubDir(context, sb2.toString());
            } else {
                subDir2 = DiskUtil.getSubDir(context, "/h5/download/cache");
            }
            if (H5FileUtil.exists(subDir2)) {
                a(subDir2);
            }
        } catch (Exception e) {
            RVLogger.e(TAG, e);
        }
    }

    public void clearTempPath(Context context) {
        String subDir;
        if (!TextUtils.isEmpty(this.f6309a)) {
            StringBuilder sb = new StringBuilder();
            sb.append("/h5/download/temp/");
            sb.append(this.f6309a);
            subDir = DiskUtil.getSubDir(context, sb.toString());
        } else {
            subDir = DiskUtil.getSubDir(context, "/h5/download/temp");
        }
        H5FileUtil.delete(new File(subDir));
    }

    private void a(String str) {
        File[] listFiles;
        if (H5FileUtil.exists(str)) {
            Stack stack = new Stack();
            stack.push(str);
            long currentTimeMillis = System.currentTimeMillis();
            while (!stack.isEmpty()) {
                File file = new File((String) stack.pop());
                if (currentTimeMillis - file.lastModified() > EXPIRE_TIME) {
                    H5FileUtil.delete(file);
                } else if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        stack.push(file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public String getSubPath() {
        return this.f6309a;
    }
}
