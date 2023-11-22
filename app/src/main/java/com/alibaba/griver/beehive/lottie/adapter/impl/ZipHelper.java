package com.alibaba.griver.beehive.lottie.adapter.impl;

import com.alibaba.griver.base.common.logger.GriverLogger;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes6.dex */
public class ZipHelper {
    private static final String TAG = "ZipHelper";

    public static boolean unZip(InputStream inputStream, String str) {
        ZipInputStream zipInputStream;
        byte[] bArr = new byte[8192];
        ZipInputStream zipInputStream2 = null;
        try {
            try {
                zipInputStream = new ZipInputStream(new BufferedInputStream(inputStream));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry != null) {
                            if (isSafeName(nextEntry.getName())) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(str);
                                sb.append(nextEntry.getName());
                                File file = new File(sb.toString());
                                if (nextEntry.isDirectory()) {
                                    file.mkdirs();
                                } else {
                                    File parentFile = file.getParentFile();
                                    if (!parentFile.exists()) {
                                        parentFile.mkdirs();
                                    }
                                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                                    while (true) {
                                        int read = zipInputStream.read(bArr);
                                        if (read <= 0) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                    }
                                    close(fileOutputStream);
                                }
                            }
                        } else {
                            try {
                                zipInputStream.closeEntry();
                                zipInputStream.close();
                                return true;
                            } catch (IOException e) {
                                GriverLogger.e(TAG, "unZip IO failed", e);
                                return true;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        zipInputStream2 = zipInputStream;
                        GriverLogger.e(TAG, "unZip failed", e);
                        if (zipInputStream2 != null) {
                            try {
                                zipInputStream2.closeEntry();
                                zipInputStream2.close();
                            } catch (IOException e3) {
                                GriverLogger.e(TAG, "unZip IO failed", e3);
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        if (zipInputStream != null) {
                            try {
                                zipInputStream.closeEntry();
                                zipInputStream.close();
                            } catch (IOException e4) {
                                GriverLogger.e(TAG, "unZip IO failed", e4);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                zipInputStream = zipInputStream2;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    private static boolean isSafeName(String str) {
        if (str == null) {
            return true;
        }
        return (str.contains("..") || str.contains("\\") || str.contains("%")) ? false : true;
    }

    static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                GriverLogger.e(TAG, "close IO failed", e);
            }
        }
    }

    public static boolean unZip(String str, String str2) {
        try {
            return unZip(new FileInputStream(str), str2);
        } catch (FileNotFoundException e) {
            GriverLogger.e(TAG, "unZip failed", e);
            return false;
        }
    }
}
