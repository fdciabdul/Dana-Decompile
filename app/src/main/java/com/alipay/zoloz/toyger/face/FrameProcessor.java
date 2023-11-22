package com.alipay.zoloz.toyger.face;

import android.graphics.Bitmap;
import android.os.Environment;
import com.alipay.zoloz.toyger.algorithm.TGFrame;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class FrameProcessor {
    public static final SimpleDateFormat DATE_FORMAT2 = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS", Locale.US);
    private static final boolean SAVE_BITMAP = false;
    private static final String TAG = "FrameProcessor";
    private TGFrame mTgFrame;

    static void saveBitmap(TGFrame tGFrame, ToygerFaceAttr toygerFaceAttr, String str) {
    }

    public static String getDetailDateFormat(long j) {
        String format;
        SimpleDateFormat simpleDateFormat = DATE_FORMAT2;
        synchronized (simpleDateFormat) {
            format = simpleDateFormat.format(new Date(j));
        }
        return format;
    }

    void initFame(TGFrame tGFrame) {
        this.mTgFrame = tGFrame;
    }

    public TGFrame getTgFrame() {
        return this.mTgFrame;
    }

    void saveBitmap(ToygerFaceAttr toygerFaceAttr, String str) {
        saveBitmap(this.mTgFrame, toygerFaceAttr, str);
    }

    public static void saveBitmap(Bitmap bitmap, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(getDetailDateFormat(System.currentTimeMillis()));
        sb.append("_");
        sb.append(str);
        sb.append(".png");
        String obj = sb.toString();
        File file = new File(Environment.getExternalStorageDirectory(), "Download");
        if (!file.exists() && !file.mkdirs()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to mkdirs: ");
            sb2.append(file);
            InstrumentInjector.log_w(TAG, sb2.toString());
        }
        File file2 = new File(file, obj);
        bitmap2File(bitmap, file2);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Save file : ");
        sb3.append(file2);
        InstrumentInjector.log_d(TAG, sb3.toString());
    }

    public static void bitmap2File(Bitmap bitmap, File file) {
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            InstrumentInjector.log_w(TAG, e);
        } catch (IOException e2) {
            InstrumentInjector.log_w(TAG, e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.OutputStream] */
    public static boolean save(File file, byte[] bArr) {
        boolean z;
        ?? r3;
        Throwable th;
        FileOutputStream fileOutputStream;
        IOException e;
        FileOutputStream fileOutputStream2;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream3;
        synchronized (FrameProcessor.class) {
            z = false;
            if (file != null && bArr != null) {
                if (file.exists()) {
                    file.delete();
                } else {
                    try {
                        file.createNewFile();
                    } catch (IOException e2) {
                        r3 = TAG;
                        InstrumentInjector.log_w(TAG, e2);
                    }
                }
                BufferedOutputStream bufferedOutputStream2 = null;
                try {
                    try {
                        fileOutputStream3 = new FileOutputStream(file);
                        try {
                            bufferedOutputStream = new BufferedOutputStream(fileOutputStream3);
                            try {
                                bufferedOutputStream.write(bArr);
                                bufferedOutputStream.flush();
                                close(bufferedOutputStream);
                                z = true;
                                r3 = fileOutputStream3;
                            } catch (IOException e3) {
                                e = e3;
                                bufferedOutputStream2 = bufferedOutputStream;
                                fileOutputStream2 = fileOutputStream3;
                                InstrumentInjector.log_w(TAG, e);
                                close(bufferedOutputStream2);
                                r3 = fileOutputStream2;
                                close(r3);
                                return z;
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedOutputStream2 = bufferedOutputStream;
                                fileOutputStream = fileOutputStream3;
                                close(bufferedOutputStream2);
                                close(fileOutputStream);
                                throw th;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            fileOutputStream2 = fileOutputStream3;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        fileOutputStream2 = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                        close(bufferedOutputStream2);
                        close(fileOutputStream);
                        throw th;
                    }
                    close(r3);
                } catch (Throwable th4) {
                    th = th4;
                    bufferedOutputStream = bufferedOutputStream2;
                    fileOutputStream3 = r3;
                }
            }
        }
        return z;
    }

    public static void close(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                InstrumentInjector.log_e(TAG, e.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearFrame() {
        this.mTgFrame = null;
    }

    public void saveTgFrame(String str) {
        File file = new File(Environment.getExternalStorageDirectory(), "Download");
        if (!file.exists() && !file.mkdirs()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to mkdirs: ");
            sb.append(file);
            InstrumentInjector.log_w(TAG, sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getDetailDateFormat(System.currentTimeMillis()));
        sb2.append("_");
        sb2.append(str);
        String obj = sb2.toString();
        byte[] bArr = this.mTgFrame.data;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(obj);
        sb3.append("_raw.bin");
        File file2 = new File(file, sb3.toString());
        save(file2, bArr);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Save file : ");
        sb4.append(file2);
        sb4.append(", tgFrame.width=");
        sb4.append(this.mTgFrame.width);
        sb4.append(", tgFrame.height=");
        sb4.append(this.mTgFrame.height);
        InstrumentInjector.log_d(TAG, sb4.toString());
    }

    public void saveTgDepthFrame(String str) {
        File file = new File(Environment.getExternalStorageDirectory(), "Download");
        if (!file.exists() && !file.mkdirs()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to mkdirs: ");
            sb.append(file);
            InstrumentInjector.log_w(TAG, sb.toString());
        }
        getDetailDateFormat(System.currentTimeMillis());
    }

    public static void clearOldBinFiles() {
        File file = new File(Environment.getExternalStorageDirectory(), "Download");
        if (file.exists()) {
            try {
                File[] listFiles = file.listFiles(new LogFileNameFilter());
                if (listFiles == null || listFiles.length <= 0) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                long millis = TimeUnit.DAYS.toMillis(3L);
                for (File file2 : listFiles) {
                    if (file2.lastModified() < currentTimeMillis - millis) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Delete File : ");
                        sb.append(file2);
                        InstrumentInjector.log_i(TAG, sb.toString());
                        if (file2.delete()) {
                            file2.deleteOnExit();
                        }
                    }
                }
            } catch (Throwable th) {
                InstrumentInjector.log_w(TAG, th);
            }
        }
    }

    /* loaded from: classes7.dex */
    static class LogFileNameFilter implements FilenameFilter {
        LogFileNameFilter() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".bin");
        }
    }
}
