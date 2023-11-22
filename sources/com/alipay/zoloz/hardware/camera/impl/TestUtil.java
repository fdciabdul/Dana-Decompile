package com.alipay.zoloz.hardware.camera.impl;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.alipay.zoloz.config.ConfigCenter;
import com.alipay.zoloz.config.util.FileUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes7.dex */
public class TestUtil {
    public static final String DATA_CAPTURE_MODE_COLLECT = "collect";
    public static final String DATA_CAPTURE_MODE_MOCK = "mock";
    public static String dataCaptureMode = null;
    private static int frameIndex = 0;
    public static String isRunOnTestKey = "zoloz.test.autoRun";
    public static String testModeKey = "zoloz.test.auto.mode";

    public static boolean isDebug(Context context) {
        try {
            return (context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isRunTest() {
        Boolean bool = (Boolean) ConfigCenter.getInstance().getFrameworkValue(isRunOnTestKey);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean isCaptureMode() {
        if (TextUtils.equals((String) ConfigCenter.getInstance().getFrameworkValue(testModeKey), "collect")) {
            dataCaptureMode = "collect";
            return true;
        }
        return false;
    }

    public static void saveFrame(byte[] bArr) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        StringBuilder sb = new StringBuilder();
        sb.append("smatch_test_");
        sb.append(dataCaptureMode);
        File file = new File(externalStorageDirectory, sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("camera_data");
        sb2.append(frameIndex);
        sb2.append(".dat");
        File file2 = new File(file, sb2.toString());
        BufferedOutputStream bufferedOutputStream3 = null;
        try {
            try {
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    BufferedOutputStream bufferedOutputStream4 = new BufferedOutputStream(fileOutputStream);
                    try {
                        bufferedOutputStream4.write(bArr);
                        bufferedOutputStream4.flush();
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused) {
                        }
                        bufferedOutputStream4.close();
                    } catch (Exception unused2) {
                        bufferedOutputStream3 = bufferedOutputStream4;
                        bufferedOutputStream2 = bufferedOutputStream3;
                        bufferedOutputStream3 = fileOutputStream;
                        if (bufferedOutputStream3 != null) {
                            try {
                                bufferedOutputStream3.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (bufferedOutputStream2 != null) {
                            bufferedOutputStream2.close();
                        }
                        frameIndex++;
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream3 = bufferedOutputStream4;
                        bufferedOutputStream = bufferedOutputStream3;
                        bufferedOutputStream3 = fileOutputStream;
                        if (bufferedOutputStream3 != null) {
                            try {
                                bufferedOutputStream3.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                                throw th;
                            } catch (Exception unused5) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused6) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception unused7) {
                bufferedOutputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
            }
        } catch (Exception unused8) {
            frameIndex++;
        }
    }

    public static byte[] readFrame() {
        if (new File(Environment.getExternalStorageDirectory(), "smatch_test").listFiles() != null) {
            if (frameIndex > r0.listFiles().length - 1) {
                frameIndex = 0;
            }
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            StringBuilder sb = new StringBuilder();
            sb.append("smatch_test");
            sb.append(File.separator);
            sb.append("camera_data");
            sb.append(frameIndex);
            sb.append(".dat");
            byte[] readFile = readFile(new File(externalStorageDirectory, sb.toString()));
            if (readFile != null) {
                frameIndex++;
                return readFile;
            }
            return null;
        }
        return null;
    }

    private static byte[] readFile(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            return bArr;
        } catch (Exception unused) {
            return null;
        }
    }

    public static int getWidth() {
        return ((Integer) ConfigCenter.getInstance().getFrameworkValue("testWidth")).intValue();
    }

    public static int getHeight() {
        return ((Integer) ConfigCenter.getInstance().getFrameworkValue("testHeight")).intValue();
    }

    public static boolean isMockMode() {
        if (TextUtils.equals((String) ConfigCenter.getInstance().getFrameworkValue(testModeKey), "mock")) {
            dataCaptureMode = "mock";
            return true;
        }
        return false;
    }

    public static void reset() {
        frameIndex = 0;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        StringBuilder sb = new StringBuilder();
        sb.append("smatch_test_");
        sb.append(dataCaptureMode);
        FileUtil.delete(new File(externalStorageDirectory, sb.toString()));
    }
}
