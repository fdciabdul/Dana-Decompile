package androidx.core.util;

import com.fullstory.instrumentation.InstrumentInjector;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes6.dex */
public class AtomicFile {
    public final File MyBillsEntityDataFactory;
    public final File PlaceComponentResult;
    private final File getAuthRequestContext;

    public AtomicFile(File file) {
        this.PlaceComponentResult = file;
        StringBuilder sb = new StringBuilder();
        sb.append(file.getPath());
        sb.append(".new");
        this.MyBillsEntityDataFactory = new File(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(file.getPath());
        sb2.append(".bak");
        this.getAuthRequestContext = new File(sb2.toString());
    }

    public final FileOutputStream getAuthRequestContext() throws IOException {
        if (this.getAuthRequestContext.exists()) {
            PlaceComponentResult(this.getAuthRequestContext, this.PlaceComponentResult);
        }
        try {
            return new FileOutputStream(this.MyBillsEntityDataFactory);
        } catch (FileNotFoundException unused) {
            if (!this.MyBillsEntityDataFactory.getParentFile().mkdirs()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to create directory for ");
                sb.append(this.MyBillsEntityDataFactory);
                throw new IOException(sb.toString());
            }
            try {
                return new FileOutputStream(this.MyBillsEntityDataFactory);
            } catch (FileNotFoundException e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to create new file ");
                sb2.append(this.MyBillsEntityDataFactory);
                throw new IOException(sb2.toString(), e);
            }
        }
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(FileOutputStream fileOutputStream) {
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static void PlaceComponentResult(File file, File file2) {
        if (file2.isDirectory() && !file2.delete()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to delete file which is a directory ");
            sb.append(file2);
            InstrumentInjector.log_e("AtomicFile", sb.toString());
        }
        if (file.renameTo(file2)) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Failed to rename ");
        sb2.append(file);
        sb2.append(" to ");
        sb2.append(file2);
        InstrumentInjector.log_e("AtomicFile", sb2.toString());
    }
}
