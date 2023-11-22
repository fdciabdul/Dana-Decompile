package com.google.firebase.crashlytics.internal.metadata;

import android.graphics.Color;
import android.view.KeyEvent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.metadata.QueueFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;
import kotlin.text.Typography;
import o.getCallingPid;

/* loaded from: classes.dex */
class QueueFileLogStore implements FileLogStore {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static char[] MyBillsEntityDataFactory = null;
    private static int PlaceComponentResult = 1;
    private static final Charset UTF_8;
    private static char getAuthRequestContext;
    private QueueFile logFile;
    private final int maxLogSize;
    private final File workingFile;

    static void BuiltInFictitiousFunctionClassFactory() {
        getAuthRequestContext = (char) 42070;
        MyBillsEntityDataFactory = new char[]{42071, 37257, 37274, 37275, 42068, 42065, 42070, 37346, 37367};
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        Object[] objArr = new Object[1];
        a(new char[]{0, 5, 4, 1, 13769}, (byte) (38 - ((byte) KeyEvent.getModifierMetaStateMask())), Color.rgb(0, 0, 0) + 16777221, objArr);
        UTF_8 = Charset.forName(((String) objArr[0]).intern());
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 119;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class LogBytes {
        public final byte[] bytes;
        public final int offset;

        LogBytes(byte[] bArr, int i) {
            this.bytes = bArr;
            this.offset = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueueFileLogStore(File file, int i) {
        try {
            this.workingFile = file;
            this.maxLogSize = i;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public void writeToLog(long j, String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 87;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        openLogFile();
        doWriteToLog(j, str);
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 97;
            PlaceComponentResult = i3 % 128;
            if (i3 % 2 == 0) {
                int i4 = 94 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public byte[] getLogAsBytes() {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            LogBytes logBytes = getLogBytes();
            if ((logBytes == null ? (char) 2 : '9') == 2) {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 21;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
                return null;
            }
            byte[] bArr = new byte[logBytes.offset];
            System.arraycopy(logBytes.bytes, 0, bArr, 0, logBytes.offset);
            return bArr;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public String getLogAsString() {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 81;
            try {
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                byte[] logAsBytes = getLogAsBytes();
                Object obj = null;
                String str = logAsBytes != null ? new String(logAsBytes, UTF_8) : null;
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 5;
                PlaceComponentResult = i3 % 128;
                if ((i3 % 2 == 0 ? (char) 16 : '_') != '_') {
                    obj.hashCode();
                    return str;
                }
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private LogBytes getLogBytes() {
        Object[] objArr = null;
        if (this.workingFile.exists()) {
            openLogFile();
            try {
                QueueFile queueFile = this.logFile;
                if ((queueFile == null ? '(' : 'a') == 'a') {
                    final int[] iArr = {0};
                    final byte[] bArr = new byte[queueFile.usedBytes()];
                    try {
                        this.logFile.forEach(new QueueFile.ElementReader() { // from class: com.google.firebase.crashlytics.internal.metadata.QueueFileLogStore.1
                            @Override // com.google.firebase.crashlytics.internal.metadata.QueueFile.ElementReader
                            public void read(InputStream inputStream, int i) throws IOException {
                                try {
                                    inputStream.read(bArr, iArr[0], i);
                                    int[] iArr2 = iArr;
                                    iArr2[0] = iArr2[0] + i;
                                } finally {
                                    inputStream.close();
                                }
                            }
                        });
                    } catch (IOException e) {
                        Logger.getLogger().e("A problem occurred while reading the Crashlytics log file.", e);
                    }
                    LogBytes logBytes = new LogBytes(bArr, iArr[0]);
                    int i = PlaceComponentResult + 35;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                    if ((i % 2 != 0 ? 'Q' : Typography.amp) != '&') {
                        int length = objArr.length;
                        return logBytes;
                    }
                    return logBytes;
                }
                int i2 = PlaceComponentResult + 35;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                if ((i2 % 2 != 0 ? 'O' : ']') != ']') {
                    objArr.hashCode();
                    return null;
                }
                return null;
            } catch (Exception e2) {
                throw e2;
            }
        }
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public void closeLogFile() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        CommonUtils.closeOrLog(this.logFile, "There was a problem closing the Crashlytics log file.");
        Object[] objArr = null;
        this.logFile = null;
        int i3 = PlaceComponentResult + 31;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 19 : Typography.less) != 19) {
            return;
        }
        int length = objArr.length;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public void deleteLogFile() {
        try {
            int i = PlaceComponentResult + 87;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 != 0 ? (char) 7 : 'L') != 7) {
                closeLogFile();
                this.workingFile.delete();
                return;
            }
            closeLogFile();
            this.workingFile.delete();
            int i2 = 0 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    private void openLogFile() {
        try {
            if (this.logFile == null) {
                try {
                    this.logFile = new QueueFile(this.workingFile);
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 23;
                    PlaceComponentResult = i % 128;
                    int i2 = i % 2;
                    return;
                } catch (IOException e) {
                    Logger logger = Logger.getLogger();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Could not open log file: ");
                    sb.append(this.workingFile);
                    logger.e(sb.toString(), e);
                }
            }
            try {
                int i3 = PlaceComponentResult + 55;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    private void doWriteToLog(long j, String str) {
        if (this.logFile == null) {
            return;
        }
        if (str == null) {
            int i = PlaceComponentResult + 17;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 != 0 ? 'L' : '7') != '7') {
                Object[] objArr = null;
                int length = objArr.length;
            }
            str = "null";
        }
        try {
            int i2 = this.maxLogSize / 4;
            if (str.length() > i2) {
                StringBuilder sb = new StringBuilder();
                sb.append("...");
                sb.append(str.substring(str.length() - i2));
                str = sb.toString();
            }
            this.logFile.add(String.format(Locale.US, "%d %s%n", Long.valueOf(j), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(UTF_8));
            while (true) {
                if (this.logFile.isEmpty()) {
                    return;
                }
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 37;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
                if (this.logFile.usedBytes() <= this.maxLogSize) {
                    return;
                }
                try {
                    int i5 = PlaceComponentResult + 51;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                    int i6 = i5 % 2;
                    this.logFile.remove();
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (IOException e2) {
            Logger.getLogger().e("There was a problem writing to the Crashlytics log.", e2);
        }
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = MyBillsEntityDataFactory;
        if (cArr2 != null) {
            int i3 = $11 + 111;
            $10 = i3 % 128;
            int i4 = i3 % 2;
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i5 = $11 + 83;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            int i7 = 0;
            while (true) {
                if ((i7 < length ? (char) 25 : 'E') == 'E') {
                    try {
                        break;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                cArr3[i7] = (char) (cArr2[i7] ^ (-1549216646985767851L));
                i7++;
            }
            int i8 = $11 + 15;
            $10 = i8 % 128;
            int i9 = i8 % 2;
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ getAuthRequestContext);
        char[] cArr4 = new char[i];
        if ((i % 2 != 0 ? Typography.amp : (char) 31) != '&') {
            i2 = i;
        } else {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        }
        if (i2 > 1) {
            getcallingpid.getAuthRequestContext = 0;
            while (true) {
                if (!(getcallingpid.getAuthRequestContext < i2)) {
                    break;
                }
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                    cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                } else {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if (!(getcallingpid.scheduleImpl != getcallingpid.lookAheadTest)) {
                        int i10 = $10 + 103;
                        $11 = i10 % 128;
                        int i11 = i10 % 2;
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                        int i12 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i13 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i12];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i13];
                    } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                        try {
                            getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                            getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                            int i14 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i15 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i14];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i15];
                        } catch (Exception e2) {
                            throw e2;
                        }
                    } else {
                        int i16 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                        int i17 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i16];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i17];
                    }
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        for (int i18 = 0; i18 < i; i18++) {
            int i19 = $10 + 105;
            $11 = i19 % 128;
            int i20 = i19 % 2;
            cArr4[i18] = (char) (cArr4[i18] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }
}
