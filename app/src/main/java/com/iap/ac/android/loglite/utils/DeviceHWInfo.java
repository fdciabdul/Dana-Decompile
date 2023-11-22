package com.iap.ac.android.loglite.utils;

import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes3.dex */
public class DeviceHWInfo {

    /* renamed from: a  reason: collision with root package name */
    public static final FileFilter f7602a = new a();
    public static int b = -100;
    public static long c = -100;
    public static int d = -100;

    /* loaded from: classes3.dex */
    public static final class a implements FileFilter {
        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            String name = file.getName();
            if (name.startsWith("cpu")) {
                for (int i = 3; i < name.length(); i++) {
                    if (!Character.isDigit(name.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    }

    public static int a() {
        int i = d;
        if (i == -1) {
            return i;
        }
        if (i == -100) {
            synchronized (DeviceHWInfo.class) {
                if (Build.VERSION.SDK_INT <= 10) {
                    d = 1;
                    return 1;
                }
                try {
                    int a2 = a("/sys/devices/system/cpu/possible");
                    d = a2;
                    if (a2 == -1) {
                        d = a("/sys/devices/system/cpu/present");
                    }
                    if (d == -1) {
                        d = new File("/sys/devices/system/cpu/").listFiles(f7602a).length;
                    }
                } catch (Throwable unused) {
                    d = -1;
                }
            }
        }
        return d;
    }

    public static int a(String str) {
        Throwable th;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        int i = -1;
        BufferedReader bufferedReader2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            } catch (IOException unused) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused2) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null && readLine.matches("0-[\\d]+$")) {
                i = Integer.valueOf(readLine.substring(2)).intValue() + 1;
            }
            try {
                bufferedReader.close();
            } catch (IOException unused3) {
            }
            try {
                fileInputStream.close();
            } catch (IOException unused4) {
            }
            return i;
        } catch (IOException unused5) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused6) {
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused7) {
                }
            }
            return -1;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused8) {
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    throw th;
                } catch (IOException unused9) {
                    throw th;
                }
            }
            throw th;
        }
    }

    public static int a(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i = 0;
            while (i < read) {
                byte b2 = bArr[i];
                if (b2 == 10 || i == 0) {
                    if (b2 == 10) {
                        i++;
                    }
                    for (int i2 = i; i2 < read; i2++) {
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            break;
                        } else if (i3 == str.length() - 1) {
                            return a(bArr, i2);
                        }
                    }
                }
                i++;
            }
            return -1;
        } catch (IOException | NumberFormatException unused) {
            return -1;
        }
    }

    public static int a(byte[] bArr, int i) {
        byte b2;
        while (i < bArr.length && (b2 = bArr[i]) != 10) {
            if (Character.isDigit(b2)) {
                int i2 = i + 1;
                while (i2 < bArr.length && Character.isDigit(bArr[i2])) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }
}
