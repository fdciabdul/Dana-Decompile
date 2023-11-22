package com.alipay.multimedia.adjuster.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class FileUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final Log f7336a = Log.getLogger(com.alibaba.griver.image.framework.utils.FileUtils.TAG);

    public static boolean copyToFile(InputStream inputStream, File file) {
        try {
            a(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read >= 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return true;
                    }
                }
            } catch (Throwable th) {
                fileOutputStream.flush();
                fileOutputStream.close();
                throw th;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean safeCopyToFile(InputStream inputStream, File file) throws IOException {
        if (file == null) {
            return false;
        }
        a(file);
        File b = b(file);
        boolean copyToFile = copyToFile(inputStream, b);
        if (copyToFile) {
            a(file);
            boolean renameTo = b.renameTo(file);
            Log log = f7336a;
            StringBuilder sb = new StringBuilder();
            sb.append("safeCopyToFile tmpFile: ");
            sb.append(b);
            sb.append(", dstFile: ");
            sb.append(file);
            log.d(sb.toString(), new Object[0]);
            return renameTo;
        }
        return copyToFile;
    }

    private static void a(File file) throws IOException {
        boolean delete;
        if (file.exists() && file.isFile() && !(delete = file.delete())) {
            Log log = f7336a;
            StringBuilder sb = new StringBuilder();
            sb.append("deleteFile file: ");
            sb.append(file);
            sb.append(", ret? ");
            sb.append(delete);
            log.d(sb.toString(), new Object[0]);
            throw new IOException("delete dstFile failed!!");
        }
    }

    private static File b(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(file.getAbsolutePath());
        sb.append(".");
        sb.append(System.nanoTime());
        File file2 = new File(sb.toString());
        if (file2.exists()) {
            boolean delete = file2.delete();
            if (!delete) {
                Log log = f7336a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("createTmpFile del exists file: ");
                sb2.append(file2);
                sb2.append(", ret: ");
                sb2.append(delete);
                log.d(sb2.toString(), new Object[0]);
                throw new IOException("delete tmp file error!!!");
            }
        } else {
            file2.getParentFile().mkdirs();
        }
        file2.createNewFile();
        return file2;
    }

    public static boolean delete(File file) {
        if (file != null) {
            if (file.isFile() && file.exists()) {
                return file.delete();
            }
            if (file.isDirectory() && file.exists()) {
                File[] listFiles = file.listFiles();
                boolean z = true;
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        z &= delete(file2);
                    }
                }
                return file.delete() & z;
            }
        }
        return false;
    }

    public static void scanPictureAsync(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            if (PathUtils.isContentUriPath(str)) {
                intent.setData(Uri.parse(str));
            } else {
                intent.setData(Uri.fromFile(new File(str)));
            }
            context.sendBroadcast(intent);
        } catch (Exception e) {
            Log log = f7336a;
            StringBuilder sb = new StringBuilder();
            sb.append("scanPictureAsync exp: ");
            sb.append(e.toString());
            log.d(sb.toString(), new Object[0]);
        }
    }
}
