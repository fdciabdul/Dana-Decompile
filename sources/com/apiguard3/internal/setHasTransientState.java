package com.apiguard3.internal;

import android.content.Context;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.apiguard3.internal.setPressed;
import com.google.common.base.Ascii;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes7.dex */
public final class setHasTransientState implements setPressed.values {
    private static int APIGuard = 0;
    private static int valueOf = 1;
    public static final byte[] getAuthRequestContext = {75, 108, -123, 87, 15, -8, 16, -1, -4, -3, -52, TarHeader.LF_CONTIG, 14, 1, 8, -13, 11, 8, -68, Ascii.ETB, 46, 1, 8, -13, Ascii.NAK, -2, -2, 8, -1, -13, 4, -31, 39, 11, 0, 17, -49, TarHeader.LF_LINK, 2, -2, -1, -4, 0, Ascii.NAK, -9, 8, 1, -35, 39, -6, 11, 15, -8, 16, -1, -4, -3, -52, TarHeader.LF_CONTIG, 14, 1, 8, -13, 11, 8, -68, 68, -1, -61, Ascii.NAK, TarHeader.LF_LINK, 2, -2, -1, -4, 0, Ascii.NAK, -9, 8, 1, -35, 39, -6, 11};
    public static final int PlaceComponentResult = 171;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 6
            int r6 = r6 + 97
            int r8 = 34 - r8
            int r7 = r7 + 4
            byte[] r0 = com.apiguard3.internal.setHasTransientState.getAuthRequestContext
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L32
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r7 = r7 + 1
            int r3 = r3 + 1
            if (r3 != r8) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L32:
            int r6 = r6 + r7
            int r6 = r6 + (-2)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setHasTransientState.a(short, int, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0066, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 21) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b2, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 62) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b6, code lost:
    
        if (r13.splitSourceDirs == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b8, code lost:
    
        r0 = com.apiguard3.internal.setHasTransientState.APIGuard + 31;
        com.apiguard3.internal.setHasTransientState.valueOf = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00c2, code lost:
    
        if ((r0 % 2) == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c7, code lost:
    
        if (r13.splitSourceDirs.length == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c9, code lost:
    
        r0 = new java.lang.String[r13.splitSourceDirs.length + 1];
        r1 = com.apiguard3.internal.setHasTransientState.getAuthRequestContext;
        r6 = new java.lang.Object[1];
        a(r1[34], r1[20], r1[34], r6);
        r1 = java.lang.Class.forName((java.lang.String) r6[0]);
        r4 = com.apiguard3.internal.setHasTransientState.getAuthRequestContext;
        r3 = (byte) (-r4[9]);
        r2 = r4[24];
        r5 = new java.lang.Object[1];
        a(r3, r2, (byte) (r2 + 4), r5);
        r0[0] = r1.getField((java.lang.String) r5[0]).get(r13);
        java.lang.System.arraycopy(r13.splitSourceDirs, 0, r0, 1, r13.splitSourceDirs.length);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x010e, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x010f, code lost:
    
        r13 = r13.splitSourceDirs.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0117, code lost:
    
        throw new java.lang.NullPointerException();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String[] AGState(android.content.Context r13) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setHasTransientState.AGState(android.content.Context):java.lang.String[]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class AGState {
        public ZipEntry APIGuard;
        public ZipFile values;

        public AGState(ZipFile zipFile, ZipEntry zipEntry) {
            this.values = zipFile;
            this.APIGuard = zipEntry;
        }
    }

    private static AGState getSharedInstance(Context context, String[] strArr, String str) {
        String[] AGState2 = AGState(context);
        int length = AGState2.length;
        int i = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i >= length) {
                return null;
            }
            String str2 = AGState2[i];
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    break;
                }
                try {
                    ZipFile zipFile2 = new ZipFile(new File(str2), 1);
                    APIGuard = (valueOf + 7) % 128;
                    zipFile = zipFile2;
                    break;
                } catch (IOException unused) {
                    i2++;
                }
            }
            if (zipFile != null) {
                valueOf = (APIGuard + 21) % 128;
                int i3 = 0;
                while (true) {
                    if (i3 < 5) {
                        int length2 = strArr.length;
                        APIGuard = (valueOf + 107) % 128;
                        int i4 = 0;
                        while (i4 < length2) {
                            String str3 = strArr[i4];
                            StringBuilder sb = new StringBuilder("lib");
                            sb.append(File.separatorChar);
                            sb.append(str3);
                            sb.append(File.separatorChar);
                            sb.append(str);
                            ZipEntry entry = zipFile.getEntry(sb.toString());
                            if (entry == null) {
                                i4++;
                                valueOf = (APIGuard + 81) % 128;
                            } else {
                                return new AGState(zipFile, entry);
                            }
                        }
                        APIGuard = (valueOf + 61) % 128;
                        i3++;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i++;
        }
    }

    private static String[] APIGuard(Context context, String str) {
        ZipFile zipFile;
        int i;
        StringBuilder sb = new StringBuilder("lib");
        sb.append(File.separatorChar);
        sb.append("([^\\");
        sb.append(File.separatorChar);
        sb.append("]*)");
        sb.append(File.separatorChar);
        sb.append(str);
        Pattern compile = Pattern.compile(sb.toString());
        HashSet hashSet = new HashSet();
        String[] AGState2 = AGState(context);
        APIGuard = (valueOf + 73) % 128;
        for (String str2 : AGState2) {
            try {
                zipFile = new ZipFile(new File(str2), 1);
                i = APIGuard + 71;
                valueOf = i % 128;
            } catch (IOException unused) {
            }
            if (i % 2 == 0) {
                zipFile.entries();
                throw new ArithmeticException();
            }
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while ((!entries.hasMoreElements()) != true) {
                int i2 = valueOf + 51;
                APIGuard = i2 % 128;
                if (i2 % 2 == 0) {
                    Matcher matcher = compile.matcher(entries.nextElement().getName());
                    if ((matcher.matches() ? (char) 29 : 'O') == 29) {
                        hashSet.add(matcher.group(1));
                    }
                } else {
                    compile.matcher(entries.nextElement().getName()).matches();
                    throw null;
                }
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:(2:94|95)|(4:97|29|30|(3:32|33|34))|35|36|37|38|39|40|41|(8:46|47|48|(3:50|(1:52)|(1:54))(2:75|(1:77))|55|(1:57)(1:74)|58|(2:60|(2:62|63)(1:64))(4:65|66|67|68))|43|44|45|34) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
    
        if ((!r13.exists()) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e9, code lost:
    
        r10 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00eb, code lost:
    
        r10 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ec, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00ed, code lost:
    
        r14 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ef, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f1, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00f3, code lost:
    
        r10 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00f4, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f5, code lost:
    
        AGState(r14);
        AGState(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00fb, code lost:
    
        throw r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00fc, code lost:
    
        r11 = null;
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00ff, code lost:
    
        r11 = null;
        r3 = null;
     */
    @Override // com.apiguard3.internal.setPressed.values
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void AGState(android.content.Context r10, java.lang.String[] r11, java.lang.String r12, java.io.File r13, com.apiguard3.internal.setFilterTouchesWhenObscured r14) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setHasTransientState.AGState(android.content.Context, java.lang.String[], java.lang.String, java.io.File, com.apiguard3.internal.setFilterTouchesWhenObscured):void");
    }

    private static long values(InputStream inputStream, OutputStream outputStream) throws IOException {
        int i = (valueOf + 89) % 128;
        APIGuard = i;
        byte[] bArr = new byte[4096];
        valueOf = (i + 107) % 128;
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if ((read != -1 ? 'E' : 'R') != 'R') {
                outputStream.write(bArr, 0, read);
                j += read;
            } else {
                outputStream.flush();
                return j;
            }
        }
    }

    private static void AGState(Closeable closeable) {
        int i = APIGuard + 61;
        int i2 = i % 128;
        valueOf = i2;
        try {
            if (!(i % 2 != 0)) {
                throw new NullPointerException();
            }
            if ((closeable != null ? (char) 11 : (char) 23) != 23) {
                int i3 = i2 + 93;
                APIGuard = i3 % 128;
                if (i3 % 2 != 0) {
                    closeable.close();
                    throw new NullPointerException();
                }
                closeable.close();
            }
            APIGuard = (valueOf + 101) % 128;
        } catch (IOException unused) {
        }
    }
}
