package com.uc.crashsdk.a;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public final class b {
    public static void a(File file, File file2, byte[] bArr) {
        FileInputStream fileInputStream = new FileInputStream(file);
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file2.isDirectory()) {
            file2 = new File(file2, file.getName());
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        while (true) {
            try {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        return;
                    }
                    fileOutputStream.write(bArr, 0, read);
                } catch (IOException e) {
                    throw e;
                }
            } finally {
                fileInputStream.close();
                fileOutputStream.close();
            }
        }
    }

    public static boolean a(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static String b(File file) {
        FileInputStream fileInputStream;
        String str = "";
        if (file.exists()) {
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                a.a(th2, false);
            }
            try {
                byte[] bArr = new byte[256];
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    stringBuffer.append(new String(bArr, 0, read));
                }
                str = stringBuffer.toString();
                fileInputStream.close();
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = fileInputStream;
                try {
                    a.a(th, false);
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    return str;
                } catch (Throwable th4) {
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Throwable th5) {
                            a.a(th5, false);
                        }
                    }
                    throw th4;
                }
            }
            return str;
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0024, code lost:
    
        if (r6 == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0046, code lost:
    
        if (r6 != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0049, code lost:
    
        com.uc.crashsdk.a.a.a(r4, false);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.io.File r4, int r5, boolean r6) {
        /*
            r0 = 0
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L29
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L29
            byte[] r4 = new byte[r5]     // Catch: java.lang.Throwable -> L27
            int r5 = r2.read(r4)     // Catch: java.lang.Throwable -> L27
            if (r5 <= 0) goto L1f
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Throwable -> L27
            r3.<init>(r4, r1, r5)     // Catch: java.lang.Throwable -> L27
            r2.close()     // Catch: java.lang.Throwable -> L18
            goto L1e
        L18:
            r4 = move-exception
            if (r6 == 0) goto L1e
            com.uc.crashsdk.a.a.a(r4, r1)
        L1e:
            return r3
        L1f:
            r2.close()     // Catch: java.lang.Throwable -> L23
            goto L4c
        L23:
            r4 = move-exception
            if (r6 == 0) goto L4c
            goto L49
        L27:
            r4 = move-exception
            goto L2b
        L29:
            r4 = move-exception
            r2 = r0
        L2b:
            if (r6 == 0) goto L3f
            com.uc.crashsdk.a.a.a(r4, r1)     // Catch: java.lang.Throwable -> L31
            goto L3f
        L31:
            r4 = move-exception
            if (r2 == 0) goto L3e
            r2.close()     // Catch: java.lang.Throwable -> L38
            goto L3e
        L38:
            r5 = move-exception
            if (r6 == 0) goto L3e
            com.uc.crashsdk.a.a.a(r5, r1)
        L3e:
            throw r4
        L3f:
            if (r2 == 0) goto L4c
            r2.close()     // Catch: java.lang.Throwable -> L45
            goto L4c
        L45:
            r4 = move-exception
            if (r6 != 0) goto L49
            goto L4c
        L49:
            com.uc.crashsdk.a.a.a(r4, r1)
        L4c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.b.a(java.io.File, int, boolean):java.lang.String");
    }

    public static ArrayList<String> a(File file, int i) {
        Throwable th;
        BufferedReader bufferedReader;
        ArrayList<String> arrayList = new ArrayList<>();
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader2, 512);
                int i2 = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(readLine);
                        i2++;
                        if (i > 0 && i2 >= i) {
                            break;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileReader = fileReader2;
                        try {
                            a.a(th, false);
                            a(fileReader);
                            a(bufferedReader);
                            return arrayList;
                        } catch (Throwable th3) {
                            a(fileReader);
                            a(bufferedReader);
                            throw th3;
                        }
                    }
                }
                a(fileReader2);
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
        }
        a(bufferedReader);
        return arrayList;
    }

    public static boolean a(File file, byte[] bArr) {
        FileOutputStream fileOutputStream;
        boolean z = false;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                z = true;
            } catch (Throwable th) {
                th = th;
                try {
                    a.a(th, false);
                    return z;
                } finally {
                    a(fileOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        return z;
    }

    public static boolean a(File file, String str) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
        } catch (Throwable th) {
            th = th;
            fileWriter = null;
        }
        try {
            fileWriter.write(str, 0, str.length());
            try {
                fileWriter.close();
            } catch (Throwable th2) {
                a.a(th2, false);
            }
            return true;
        } catch (Throwable th3) {
            th = th3;
            try {
                a.a(th, false);
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                        return false;
                    } catch (Throwable th4) {
                        a.a(th4, false);
                        return false;
                    }
                }
                return false;
            } catch (Throwable th5) {
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (Throwable th6) {
                        a.a(th6, false);
                    }
                }
                throw th5;
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                a.a(th, true);
            }
        }
    }
}
