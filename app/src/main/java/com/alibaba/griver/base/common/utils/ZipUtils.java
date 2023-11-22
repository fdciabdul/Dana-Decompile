package com.alibaba.griver.base.common.utils;

import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import id.dana.lib.gcontainer.app.bridge.constant.BridgeKey;
import io.split.android.client.service.ServiceConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* loaded from: classes3.dex */
public class ZipUtils {
    public static final String TAG = "AriverRes:ZipUtils";

    public static boolean unZip(ZipFile zipFile, String str) {
        FileOutputStream fileOutputStream;
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel;
        MappedByteBuffer mappedByteBuffer;
        byte[] buf = IOUtils.getBuf(8192);
        try {
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                FileOutputStream fileOutputStream2 = null;
                InputStream inputStream = null;
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    String name = nextElement.getName();
                    if (!name.contains("../") && !name.contains("\\") && !name.contains("%")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(name);
                        File file = new File(sb.toString());
                        if (nextElement.isDirectory()) {
                            file.mkdirs();
                        } else {
                            File parentFile = file.getParentFile();
                            if (!parentFile.exists()) {
                                parentFile.mkdirs();
                            }
                            if (nextElement.getSize() >= 65536 && nextElement.getSize() <= ServiceConstants.MAX_EVENTS_SIZE_BYTES) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("unzip ");
                                sb2.append(file.getName());
                                RVLogger.d("AriverRes:ZipUtils", sb2.toString());
                                try {
                                    randomAccessFile = new RandomAccessFile(file, "rw");
                                } catch (Throwable th) {
                                    th = th;
                                    randomAccessFile = null;
                                }
                                try {
                                    fileChannel = randomAccessFile.getChannel();
                                    try {
                                        mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, nextElement.getSize());
                                    } catch (Throwable th2) {
                                        th = th2;
                                        mappedByteBuffer = null;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileChannel = null;
                                    mappedByteBuffer = null;
                                    try {
                                        RVLogger.e("AriverRes:ZipUtils", th);
                                        IOUtils.freeMappedBuffer(mappedByteBuffer);
                                        IOUtils.closeQuietly(fileChannel);
                                        IOUtils.closeQuietly(randomAccessFile);
                                        IOUtils.closeQuietly(inputStream);
                                    } catch (Throwable th4) {
                                        IOUtils.freeMappedBuffer(mappedByteBuffer);
                                        IOUtils.closeQuietly(fileChannel);
                                        IOUtils.closeQuietly(randomAccessFile);
                                        IOUtils.closeQuietly(inputStream);
                                        throw th4;
                                    }
                                }
                                try {
                                    inputStream = zipFile.getInputStream(nextElement);
                                    if (nextElement.getSize() > 0 && mappedByteBuffer != null && inputStream != null) {
                                        while (true) {
                                            int read = inputStream.read(buf);
                                            if (read <= 0) {
                                                break;
                                            }
                                            mappedByteBuffer.put(buf, 0, read);
                                        }
                                    } else {
                                        RVLogger.w("AriverRes:ZipUtils", " invalid ZipEntry size or mapped buffer!");
                                    }
                                    IOUtils.freeMappedBuffer(mappedByteBuffer);
                                    IOUtils.closeQuietly(fileChannel);
                                } catch (Throwable th5) {
                                    th = th5;
                                    RVLogger.e("AriverRes:ZipUtils", th);
                                    IOUtils.freeMappedBuffer(mappedByteBuffer);
                                    IOUtils.closeQuietly(fileChannel);
                                    IOUtils.closeQuietly(randomAccessFile);
                                    IOUtils.closeQuietly(inputStream);
                                }
                                IOUtils.closeQuietly(randomAccessFile);
                                IOUtils.closeQuietly(inputStream);
                            }
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("file size: ");
                            sb3.append(nextElement.getSize());
                            RVLogger.d("AriverRes:ZipUtils", sb3.toString());
                            try {
                                fileOutputStream = new FileOutputStream(file);
                            } catch (Throwable th6) {
                                th = th6;
                            }
                            try {
                                inputStream = zipFile.getInputStream(nextElement);
                                while (true) {
                                    int read2 = inputStream.read(buf);
                                    if (read2 <= 0) {
                                        break;
                                    }
                                    fileOutputStream.write(buf, 0, read2);
                                }
                                IOUtils.closeQuietly(fileOutputStream);
                                IOUtils.closeQuietly(inputStream);
                            } catch (Throwable th7) {
                                th = th7;
                                fileOutputStream2 = fileOutputStream;
                                IOUtils.closeQuietly(fileOutputStream2);
                                IOUtils.closeQuietly(inputStream);
                                throw th;
                            }
                        }
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("entryName ");
                    sb4.append(name);
                    sb4.append(" not safe!");
                    RVLogger.d("AriverRes:ZipUtils", sb4.toString());
                }
                IOUtils.returnBuf(buf);
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e) {
                        RVLogger.e("AriverRes:ZipUtils", "unzip Exception!", e);
                    }
                }
                return true;
            } catch (Exception e2) {
                RVLogger.e("AriverRes:ZipUtils", e2);
                IOUtils.returnBuf(buf);
                if (zipFile != null) {
                    try {
                        zipFile.close();
                        return false;
                    } catch (IOException e3) {
                        RVLogger.e("AriverRes:ZipUtils", "unzip Exception!", e3);
                        return false;
                    }
                }
                return false;
            }
        } catch (Throwable th8) {
            IOUtils.returnBuf(buf);
            if (zipFile != null) {
                try {
                    zipFile.close();
                    throw th8;
                } catch (IOException e4) {
                    RVLogger.e("AriverRes:ZipUtils", "unzip Exception!", e4);
                    throw th8;
                }
            }
            throw th8;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v16, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    public static boolean unZip(InputStream inputStream, String str) {
        ZipInputStream zipInputStream;
        byte[] buf = IOUtils.getBuf(2048);
        ZipInputStream zipInputStream2 = null;
        try {
            try {
                zipInputStream = new ZipInputStream(new BufferedInputStream(inputStream));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry != null) {
                            String name = nextEntry.getName();
                            if (!name.contains("../") && !name.contains("\\") && !name.contains("%")) {
                                File file = new File(str, name);
                                if (nextEntry.isDirectory()) {
                                    file.mkdirs();
                                } else {
                                    File parentFile = file.getParentFile();
                                    if (!parentFile.exists()) {
                                        parentFile.mkdirs();
                                    }
                                    try {
                                        ?? fileOutputStream = new FileOutputStream(file);
                                        while (true) {
                                            try {
                                                int read = zipInputStream.read(buf);
                                                if (read <= 0) {
                                                    break;
                                                }
                                                fileOutputStream.write(buf, 0, read);
                                            } catch (Throwable th) {
                                                zipInputStream2 = fileOutputStream;
                                                th = th;
                                                IOUtils.closeQuietly(zipInputStream2);
                                                throw th;
                                            }
                                        }
                                        IOUtils.closeQuietly(fileOutputStream);
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("entryName ");
                            sb.append(name);
                            sb.append(" not safe!");
                            RVLogger.d("AriverRes:ZipUtils", sb.toString());
                        } else {
                            IOUtils.returnBuf(buf);
                            IOUtils.closeQuietly(zipInputStream);
                            return true;
                        }
                    } catch (Exception e) {
                        e = e;
                        zipInputStream2 = zipInputStream;
                        RVLogger.e("AriverRes:ZipUtils", "unZip exception", e);
                        GriverMonitor.error(GriverMonitorConstants.ERROR_UNZIP_DETAIL_FAIL, "GriverAppContainer", new MonitorMap.Builder().message("unzip flow fail").append(BridgeKey.FILE_PATH, str).exception(e).build());
                        IOUtils.returnBuf(buf);
                        IOUtils.closeQuietly(zipInputStream2);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        IOUtils.returnBuf(buf);
                        IOUtils.closeQuietly(zipInputStream);
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                zipInputStream = zipInputStream2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static boolean unZip(String str, String str2) {
        try {
            return unZip(new FileInputStream(str), str2);
        } catch (FileNotFoundException e) {
            RVLogger.e("AriverRes:ZipUtils", "exception", e);
            GriverMonitor.error(GriverMonitorConstants.ERROR_UNZIP_DETAIL_FAIL, "GriverAppContainer", new MonitorMap.Builder().append("fileName", str).append(BridgeKey.FILE_PATH, str2).message("unzip file exception").exception(e).build());
            return false;
        }
    }
}
