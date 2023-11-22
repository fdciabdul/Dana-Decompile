package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class MultiDexExtractor implements Closeable {
    private final RandomAccessFile BuiltInFictitiousFunctionClassFactory;
    private final FileLock KClassImpl$Data$declaredNonStaticMembers$2;
    private final File MyBillsEntityDataFactory;
    private final FileChannel PlaceComponentResult;
    private final File getAuthRequestContext;
    private final long moveToNextValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ExtractedDex extends File {
        public long crc;

        public ExtractedDex(File file, String str) {
            super(file, str);
            this.crc = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiDexExtractor(File file, File file2) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiDexExtractor(");
        sb.append(file.getPath());
        sb.append(", ");
        sb.append(file2.getPath());
        sb.append(")");
        InstrumentInjector.log_i("MultiDex", sb.toString());
        this.getAuthRequestContext = file;
        this.MyBillsEntityDataFactory = file2;
        long MyBillsEntityDataFactory = ZipUtil.MyBillsEntityDataFactory(file);
        this.moveToNextValue = MyBillsEntityDataFactory == -1 ? MyBillsEntityDataFactory - 1 : MyBillsEntityDataFactory;
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.BuiltInFictitiousFunctionClassFactory = randomAccessFile;
        try {
            try {
                FileChannel channel = randomAccessFile.getChannel();
                this.PlaceComponentResult = channel;
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Blocking on lock ");
                    sb2.append(file3.getPath());
                    InstrumentInjector.log_i("MultiDex", sb2.toString());
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = channel.lock();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(file3.getPath());
                    sb3.append(" locked");
                    InstrumentInjector.log_i("MultiDex", sb3.toString());
                } catch (IOException e) {
                    e = e;
                    try {
                        this.PlaceComponentResult.close();
                    } catch (IOException e2) {
                        InstrumentInjector.log_w("MultiDex", "Failed to close resource", e2);
                    }
                    throw e;
                } catch (Error e3) {
                    e = e3;
                    this.PlaceComponentResult.close();
                    throw e;
                } catch (RuntimeException e4) {
                    e = e4;
                    this.PlaceComponentResult.close();
                    throw e;
                }
            } catch (Error e5) {
                e = e5;
                try {
                    this.BuiltInFictitiousFunctionClassFactory.close();
                } catch (IOException e6) {
                    InstrumentInjector.log_w("MultiDex", "Failed to close resource", e6);
                }
                throw e;
            } catch (RuntimeException e7) {
                e = e7;
                this.BuiltInFictitiousFunctionClassFactory.close();
                throw e;
            }
        } catch (IOException e8) {
            e = e8;
            this.BuiltInFictitiousFunctionClassFactory.close();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<? extends File> KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, boolean z) throws IOException {
        List<ExtractedDex> KClassImpl$Data$declaredNonStaticMembers$2;
        String str2;
        MultiDexExtractor multiDexExtractor = this;
        StringBuilder sb = new StringBuilder();
        sb.append("MultiDexExtractor.load(");
        sb.append(multiDexExtractor.getAuthRequestContext.getPath());
        sb.append(", ");
        sb.append(z);
        sb.append(", ");
        sb.append(str);
        sb.append(")");
        String str3 = "MultiDex";
        InstrumentInjector.log_i("MultiDex", sb.toString());
        if (!multiDexExtractor.KClassImpl$Data$declaredNonStaticMembers$2.isValid()) {
            throw new IllegalStateException("MultiDexExtractor was closed");
        }
        long j = 1;
        long j2 = -1;
        if (z || BuiltInFictitiousFunctionClassFactory(context, multiDexExtractor.getAuthRequestContext, multiDexExtractor.moveToNextValue, str)) {
            if (z) {
                InstrumentInjector.log_i("MultiDex", "Forced extraction must be performed.");
            } else {
                InstrumentInjector.log_i("MultiDex", "Detected that extraction must be performed.");
            }
            KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
            long lastModified = multiDexExtractor.getAuthRequestContext.lastModified();
            if (lastModified == -1) {
                lastModified--;
            }
            BuiltInFictitiousFunctionClassFactory(context, str, lastModified, multiDexExtractor.moveToNextValue, KClassImpl$Data$declaredNonStaticMembers$2);
        } else {
            try {
                InstrumentInjector.log_i("MultiDex", "loading existing secondary dex files");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(multiDexExtractor.getAuthRequestContext.getName());
                sb2.append(".classes");
                String obj = sb2.toString();
                SharedPreferences sharedPreferences = context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append("dex.number");
                int i = sharedPreferences.getInt(sb3.toString(), 1);
                KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList<>(i - 1);
                int i2 = 2;
                while (i2 <= i) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(obj);
                    sb4.append(i2);
                    sb4.append(".zip");
                    ExtractedDex extractedDex = new ExtractedDex(multiDexExtractor.MyBillsEntityDataFactory, sb4.toString());
                    if (!extractedDex.isFile()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Missing extracted secondary dex file '");
                        sb5.append(extractedDex.getPath());
                        sb5.append("'");
                        throw new IOException(sb5.toString());
                    }
                    long MyBillsEntityDataFactory = ZipUtil.MyBillsEntityDataFactory(extractedDex);
                    if (MyBillsEntityDataFactory == j2) {
                        MyBillsEntityDataFactory -= j;
                    }
                    extractedDex.crc = MyBillsEntityDataFactory;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str);
                    sb6.append("dex.crc.");
                    sb6.append(i2);
                    long j3 = sharedPreferences.getLong(sb6.toString(), j2);
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(str);
                    sb7.append("dex.time.");
                    sb7.append(i2);
                    String str4 = obj;
                    long j4 = sharedPreferences.getLong(sb7.toString(), j2);
                    long lastModified2 = extractedDex.lastModified();
                    if (j4 == lastModified2) {
                        SharedPreferences sharedPreferences2 = sharedPreferences;
                        str2 = str3;
                        try {
                            if (j3 == extractedDex.crc) {
                                KClassImpl$Data$declaredNonStaticMembers$2.add(extractedDex);
                                i2++;
                                obj = str4;
                                str3 = str2;
                                sharedPreferences = sharedPreferences2;
                                j = 1;
                                j2 = -1;
                                multiDexExtractor = this;
                            }
                        } catch (IOException e) {
                            e = e;
                            str3 = str2;
                            InstrumentInjector.log_w(str3, "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e);
                            KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
                            long lastModified3 = this.getAuthRequestContext.lastModified();
                            if (lastModified3 == -1) {
                                lastModified3--;
                            }
                            BuiltInFictitiousFunctionClassFactory(context, str, lastModified3, this.moveToNextValue, KClassImpl$Data$declaredNonStaticMembers$2);
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append("load found ");
                            sb8.append(KClassImpl$Data$declaredNonStaticMembers$2.size());
                            sb8.append(" secondary dex files");
                            InstrumentInjector.log_i(str3, sb8.toString());
                            return KClassImpl$Data$declaredNonStaticMembers$2;
                        }
                    }
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append("Invalid extracted dex: ");
                    sb9.append(extractedDex);
                    sb9.append(" (key \"");
                    sb9.append(str);
                    sb9.append("\"), expected modification time: ");
                    sb9.append(j4);
                    sb9.append(", modification time: ");
                    sb9.append(lastModified2);
                    sb9.append(", expected crc: ");
                    sb9.append(j3);
                    sb9.append(", file crc: ");
                    sb9.append(extractedDex.crc);
                    throw new IOException(sb9.toString());
                }
            } catch (IOException e2) {
                e = e2;
                str2 = str3;
            }
        }
        StringBuilder sb82 = new StringBuilder();
        sb82.append("load found ");
        sb82.append(KClassImpl$Data$declaredNonStaticMembers$2.size());
        sb82.append(" secondary dex files");
        InstrumentInjector.log_i(str3, sb82.toString());
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.KClassImpl$Data$declaredNonStaticMembers$2.release();
        this.PlaceComponentResult.close();
        this.BuiltInFictitiousFunctionClassFactory.close();
    }

    private List<ExtractedDex> KClassImpl$Data$declaredNonStaticMembers$2() throws IOException {
        ZipFile zipFile;
        Throwable th;
        ZipEntry entry;
        int i;
        ZipFile zipFile2;
        ZipEntry zipEntry;
        ArrayList arrayList;
        MultiDexExtractor multiDexExtractor = this;
        String str = ".zip";
        StringBuilder sb = new StringBuilder();
        sb.append(multiDexExtractor.getAuthRequestContext.getName());
        sb.append(".classes");
        String obj = sb.toString();
        File[] listFiles = multiDexExtractor.MyBillsEntityDataFactory.listFiles(new FileFilter() { // from class: androidx.multidex.MultiDexExtractor.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return !file.getName().equals("MultiDex.lock");
            }
        });
        if (listFiles == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to list secondary dex dir content (");
            sb2.append(multiDexExtractor.MyBillsEntityDataFactory.getPath());
            sb2.append(").");
            InstrumentInjector.log_w("MultiDex", sb2.toString());
        } else {
            for (File file : listFiles) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Trying to delete old file ");
                sb3.append(file.getPath());
                sb3.append(" of size ");
                sb3.append(file.length());
                InstrumentInjector.log_i("MultiDex", sb3.toString());
                if (!file.delete()) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Failed to delete old file ");
                    sb4.append(file.getPath());
                    InstrumentInjector.log_w("MultiDex", sb4.toString());
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Deleted old file ");
                    sb5.append(file.getPath());
                    InstrumentInjector.log_i("MultiDex", sb5.toString());
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ZipFile zipFile3 = new ZipFile(multiDexExtractor.getAuthRequestContext);
        try {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("classes");
            sb6.append(2);
            sb6.append(".dex");
            entry = zipFile3.getEntry(sb6.toString());
            i = 2;
        } catch (Throwable th2) {
            th = th2;
            zipFile = zipFile3;
        }
        while (entry != null) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(obj);
            sb7.append(i);
            sb7.append(str);
            ExtractedDex extractedDex = new ExtractedDex(multiDexExtractor.MyBillsEntityDataFactory, sb7.toString());
            arrayList2.add(extractedDex);
            StringBuilder sb8 = new StringBuilder();
            sb8.append("Extraction is needed for file ");
            sb8.append(extractedDex);
            InstrumentInjector.log_i("MultiDex", sb8.toString());
            boolean z = false;
            int i2 = 0;
            while (i2 < 3 && !z) {
                try {
                    InputStream inputStream = zipFile3.getInputStream(entry);
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append("tmp-");
                    sb9.append(obj);
                    File createTempFile = File.createTempFile(sb9.toString(), str, extractedDex.getParentFile());
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append("Extracting ");
                    sb10.append(createTempFile.getPath());
                    InstrumentInjector.log_i("MultiDex", sb10.toString());
                    try {
                        String str2 = str;
                        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
                        try {
                            zipEntry = new ZipEntry("classes.dex");
                            arrayList = arrayList2;
                            zipFile2 = zipFile3;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        try {
                            zipEntry.setTime(entry.getTime());
                            zipOutputStream.putNextEntry(zipEntry);
                            byte[] bArr = new byte[16384];
                            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                                zipOutputStream.write(bArr, 0, read);
                            }
                            zipOutputStream.closeEntry();
                            try {
                                zipOutputStream.close();
                                if (!createTempFile.setReadOnly()) {
                                    StringBuilder sb11 = new StringBuilder();
                                    sb11.append("Failed to mark readonly \"");
                                    sb11.append(createTempFile.getAbsolutePath());
                                    sb11.append("\" (tmp of \"");
                                    sb11.append(extractedDex.getAbsolutePath());
                                    sb11.append("\")");
                                    throw new IOException(sb11.toString());
                                }
                                StringBuilder sb12 = new StringBuilder();
                                sb12.append("Renaming to ");
                                sb12.append(extractedDex.getPath());
                                InstrumentInjector.log_i("MultiDex", sb12.toString());
                                if (!createTempFile.renameTo(extractedDex)) {
                                    StringBuilder sb13 = new StringBuilder();
                                    sb13.append("Failed to rename \"");
                                    sb13.append(createTempFile.getAbsolutePath());
                                    sb13.append("\" to \"");
                                    sb13.append(extractedDex.getAbsolutePath());
                                    sb13.append("\"");
                                    throw new IOException(sb13.toString());
                                }
                                try {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable th4) {
                                        th = th4;
                                        zipFile = zipFile2;
                                    }
                                } catch (IOException e) {
                                    InstrumentInjector.log_w("MultiDex", "Failed to close resource", e);
                                }
                                createTempFile.delete();
                                try {
                                    long MyBillsEntityDataFactory = ZipUtil.MyBillsEntityDataFactory(extractedDex);
                                    if (MyBillsEntityDataFactory == -1) {
                                        MyBillsEntityDataFactory--;
                                    }
                                    extractedDex.crc = MyBillsEntityDataFactory;
                                    z = true;
                                } catch (IOException e2) {
                                    StringBuilder sb14 = new StringBuilder();
                                    sb14.append("Failed to read crc from ");
                                    sb14.append(extractedDex.getAbsolutePath());
                                    InstrumentInjector.log_w("MultiDex", sb14.toString(), e2);
                                    z = false;
                                }
                                StringBuilder sb15 = new StringBuilder();
                                sb15.append("Extraction ");
                                sb15.append(z ? "succeeded" : "failed");
                                sb15.append(" '");
                                sb15.append(extractedDex.getAbsolutePath());
                                sb15.append("': length ");
                                ZipEntry zipEntry2 = entry;
                                sb15.append(extractedDex.length());
                                sb15.append(" - crc: ");
                                sb15.append(extractedDex.crc);
                                InstrumentInjector.log_i("MultiDex", sb15.toString());
                                if (!z) {
                                    extractedDex.delete();
                                    if (extractedDex.exists()) {
                                        StringBuilder sb16 = new StringBuilder();
                                        sb16.append("Failed to delete corrupted secondary dex '");
                                        sb16.append(extractedDex.getPath());
                                        sb16.append("'");
                                        InstrumentInjector.log_w("MultiDex", sb16.toString());
                                    }
                                }
                                i2++;
                                entry = zipEntry2;
                                zipFile3 = zipFile2;
                                arrayList2 = arrayList;
                                str = str2;
                            } catch (Throwable th5) {
                                th = th5;
                                Throwable th6 = th;
                                try {
                                    inputStream.close();
                                } catch (IOException e3) {
                                    InstrumentInjector.log_w("MultiDex", "Failed to close resource", e3);
                                }
                                createTempFile.delete();
                                throw th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            zipOutputStream.close();
                            throw th;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        zipFile2 = zipFile3;
                    }
                } catch (Throwable th9) {
                    th = th9;
                    zipFile = zipFile3;
                }
            }
            String str3 = str;
            ArrayList arrayList3 = arrayList2;
            ZipFile zipFile4 = zipFile3;
            if (!z) {
                zipFile = zipFile4;
                StringBuilder sb17 = new StringBuilder();
                sb17.append("Could not create zip file ");
                sb17.append(extractedDex.getAbsolutePath());
                sb17.append(" for secondary dex (");
                sb17.append(i);
                sb17.append(")");
                throw new IOException(sb17.toString());
            }
            i++;
            try {
                StringBuilder sb18 = new StringBuilder();
                sb18.append("classes");
                sb18.append(i);
                sb18.append(".dex");
                zipFile = zipFile4;
                try {
                    entry = zipFile.getEntry(sb18.toString());
                    zipFile3 = zipFile;
                    arrayList2 = arrayList3;
                    str = str3;
                    multiDexExtractor = this;
                } catch (Throwable th10) {
                    th = th10;
                }
            } catch (Throwable th11) {
                th = th11;
                zipFile = zipFile4;
            }
            th = th10;
            th = th;
            try {
                zipFile.close();
                throw th;
            } catch (IOException e4) {
                InstrumentInjector.log_w("MultiDex", "Failed to close resource", e4);
                throw th;
            }
        }
        ArrayList arrayList4 = arrayList2;
        try {
            zipFile3.close();
        } catch (IOException e5) {
            InstrumentInjector.log_w("MultiDex", "Failed to close resource", e5);
        }
        return arrayList4;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Context context, File file, long j, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("timestamp");
        long j2 = sharedPreferences.getLong(sb.toString(), -1L);
        long lastModified = file.lastModified();
        if (lastModified == -1) {
            lastModified--;
        }
        if (j2 == lastModified) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("crc");
            if (sharedPreferences.getLong(sb2.toString(), -1L) == j) {
                return false;
            }
        }
        return true;
    }

    private static void BuiltInFictitiousFunctionClassFactory(Context context, String str, long j, long j2, List<ExtractedDex> list) {
        SharedPreferences.Editor edit = context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4).edit();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("timestamp");
        edit.putLong(sb.toString(), j);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("crc");
        edit.putLong(sb2.toString(), j2);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append("dex.number");
        edit.putInt(sb3.toString(), list.size() + 1);
        int i = 2;
        for (ExtractedDex extractedDex : list) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append("dex.crc.");
            sb4.append(i);
            edit.putLong(sb4.toString(), extractedDex.crc);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append("dex.time.");
            sb5.append(i);
            edit.putLong(sb5.toString(), extractedDex.lastModified());
            i++;
        }
        edit.commit();
    }
}
