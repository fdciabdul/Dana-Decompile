package com.splunk.rum;

import android.system.ErrnoException;
import android.system.Os;
import android.util.AtomicFile;
import com.fullstory.instrumentation.InstrumentInjector;
import j$.util.DesugarArrays;
import j$.util.Spliterators;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.stream.Stream;
import j$.util.stream.StreamSupport;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FileUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static File BuiltInFictitiousFunctionClassFactory(File file) {
        return new File(file, "spans");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getAuthRequestContext(File file, List<byte[]> list) throws IOException {
        AtomicFile atomicFile = new AtomicFile(file);
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            Iterator<byte[]> it = list.iterator();
            while (it.hasNext()) {
                startWrite.write(it.next());
                startWrite.write(10);
            }
            atomicFile.finishWrite(startWrite);
            if (startWrite != null) {
                startWrite.close();
            }
        } catch (Throwable th) {
            if (startWrite != null) {
                try {
                    startWrite.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<byte[]> moveToNextValue(File file) throws IOException {
        ArrayList arrayList = new ArrayList();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
        try {
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        arrayList.add(readLine.getBytes(StandardCharsets.UTF_8));
                    } else {
                        bufferedReader.close();
                        inputStreamReader.close();
                        return arrayList;
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            try {
                inputStreamReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Stream<File> scheduleImpl(File file) {
        Stream<File> PlaceComponentResult;
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            PlaceComponentResult = StreamSupport.PlaceComponentResult(Spliterators.MyBillsEntityDataFactory(), false);
            return PlaceComponentResult;
        }
        return DesugarArrays.MyBillsEntityDataFactory(listFiles);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Stream<File> lookAheadTest(File file) {
        Stream<File> PlaceComponentResult;
        Stream<File> PlaceComponentResult2;
        if (file == null) {
            PlaceComponentResult2 = StreamSupport.PlaceComponentResult(Spliterators.MyBillsEntityDataFactory(), false);
            return PlaceComponentResult2;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            PlaceComponentResult = StreamSupport.PlaceComponentResult(Spliterators.MyBillsEntityDataFactory(), false);
            return PlaceComponentResult;
        }
        return Stream.CC.getAuthRequestContext(Stream.CC.getAuthRequestContext(listFiles).getAuthRequestContext(new Predicate() { // from class: com.splunk.rum.FileUtils$$ExternalSyntheticLambda2
            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate negate() {
                return Predicate.CC.PlaceComponentResult(this);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final boolean test(Object obj) {
                return ((File) obj).isFile();
            }
        }), Stream.CC.getAuthRequestContext(listFiles).getAuthRequestContext(new FileUtils$$ExternalSyntheticLambda1()).getAuthRequestContext(new Function() { // from class: com.splunk.rum.FileUtils$$ExternalSyntheticLambda3
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return FileUtils.this.lookAheadTest((File) obj);
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Stream<File> getErrorConfigVersion(File file) {
        Stream<File> PlaceComponentResult;
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            PlaceComponentResult = StreamSupport.PlaceComponentResult(Spliterators.MyBillsEntityDataFactory(), false);
            return PlaceComponentResult;
        }
        return Stream.CC.getAuthRequestContext(listFiles).getAuthRequestContext(new FileUtils$$ExternalSyntheticLambda1());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long KClassImpl$Data$declaredNonStaticMembers$2(File file) {
        try {
            return Os.stat(file.getCanonicalPath()).st_size;
        } catch (ErrnoException | IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error getting file size for ");
            sb.append(file);
            InstrumentInjector.log_w("SplunkRum", sb.toString(), e);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long PlaceComponentResult(File file) {
        try {
            return Os.stat(file.getCanonicalPath()).st_mtime;
        } catch (ErrnoException | IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error getting file size for ");
            sb.append(file);
            InstrumentInjector.log_w("SplunkRum", sb.toString(), e);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean MyBillsEntityDataFactory(File file) {
        return file.isFile();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void initRecordTimeStamp(File file) {
        if (file.delete()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Error deleting file ");
        sb.append(file);
        InstrumentInjector.log_w("SplunkRum", sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Stream<File> NetworkUserEntityData$$ExternalSyntheticLambda0(File file) {
        Stream MyBillsEntityDataFactory;
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            MyBillsEntityDataFactory = StreamSupport.PlaceComponentResult(Spliterators.MyBillsEntityDataFactory(), false);
        } else {
            MyBillsEntityDataFactory = DesugarArrays.MyBillsEntityDataFactory(listFiles);
        }
        return MyBillsEntityDataFactory.getAuthRequestContext(new Predicate() { // from class: com.splunk.rum.FileUtils$$ExternalSyntheticLambda4
            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate negate() {
                return Predicate.CC.PlaceComponentResult(this);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final boolean test(Object obj) {
                return FileUtils.MyBillsEntityDataFactory((File) obj);
            }
        }).getAuthRequestContext(new Predicate() { // from class: com.splunk.rum.FileUtils$$ExternalSyntheticLambda5
            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate negate() {
                return Predicate.CC.PlaceComponentResult(this);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final boolean test(Object obj) {
                boolean endsWith;
                endsWith = ((File) obj).toString().endsWith(".spans");
                return endsWith;
            }
        });
    }
}
