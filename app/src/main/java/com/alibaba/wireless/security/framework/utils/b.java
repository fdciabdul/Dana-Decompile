package com.alibaba.wireless.security.framework.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/* loaded from: classes.dex */
public class b {
    public static String a(File file) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        bufferedReader.close();
                        return sb.toString();
                    }
                    sb.append(readLine);
                }
            } catch (Exception unused) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                        return null;
                    } catch (Exception unused2) {
                        return null;
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception unused4) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean a(File file, String str) {
        BufferedWriter bufferedWriter;
        if (file == null || str == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(file.getAbsolutePath());
        sb.append(".tmp");
        File file2 = new File(sb.toString());
        BufferedWriter bufferedWriter2 = null;
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            bufferedWriter = new BufferedWriter(new FileWriter(file2, false));
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            return file2.renameTo(file);
        } catch (Exception unused2) {
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                    return false;
                } catch (Exception unused3) {
                    return false;
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }

    public static boolean a(String str) {
        return (str.contains("..") || str.contains("\\") || str.contains("%")) ? false : true;
    }
}
