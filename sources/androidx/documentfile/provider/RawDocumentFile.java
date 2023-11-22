package androidx.documentfile.provider;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.alipay.mobile.zebra.ZebraLoader;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class RawDocumentFile extends DocumentFile {
    private File PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RawDocumentFile(DocumentFile documentFile, File file) {
        super(documentFile);
        this.PlaceComponentResult = file;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final DocumentFile BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (extensionFromMimeType != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(".");
            sb.append(extensionFromMimeType);
            str2 = sb.toString();
        }
        File file = new File(this.PlaceComponentResult, str2);
        try {
            file.createNewFile();
            return new RawDocumentFile(this, file);
        } catch (IOException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to createFile: ");
            sb2.append(e);
            InstrumentInjector.log_w("DocumentFile", sb2.toString());
            return null;
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final DocumentFile getAuthRequestContext(String str) {
        File file = new File(this.PlaceComponentResult, str);
        if (file.isDirectory() || file.mkdir()) {
            return new RawDocumentFile(this, file);
        }
        return null;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final Uri getErrorConfigVersion() {
        return Uri.fromFile(this.PlaceComponentResult);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult.getName();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        if (this.PlaceComponentResult.isDirectory()) {
            return null;
        }
        String name = this.PlaceComponentResult.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(lastIndexOf + 1).toLowerCase());
            return mimeTypeFromExtension != null ? mimeTypeFromExtension : ZebraLoader.MIME_TYPE_STREAM;
        }
        return ZebraLoader.MIME_TYPE_STREAM;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean lookAheadTest() {
        return this.PlaceComponentResult.isDirectory();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean scheduleImpl() {
        return this.PlaceComponentResult.isFile();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final long moveToNextValue() {
        return this.PlaceComponentResult.length();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.PlaceComponentResult.canRead();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean PlaceComponentResult() {
        return this.PlaceComponentResult.canWrite();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean MyBillsEntityDataFactory() {
        getAuthRequestContext(this.PlaceComponentResult);
        return this.PlaceComponentResult.delete();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean getAuthRequestContext() {
        return this.PlaceComponentResult.exists();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final DocumentFile[] DatabaseTableConfigUtil() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = this.PlaceComponentResult.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                arrayList.add(new RawDocumentFile(this, file));
            }
        }
        return (DocumentFile[]) arrayList.toArray(new DocumentFile[arrayList.size()]);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        File file = new File(this.PlaceComponentResult.getParentFile(), str);
        if (this.PlaceComponentResult.renameTo(file)) {
            this.PlaceComponentResult = file;
            return true;
        }
        return false;
    }

    private static boolean getAuthRequestContext(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    z &= getAuthRequestContext(file2);
                }
                if (!file2.delete()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to delete ");
                    sb.append(file2);
                    InstrumentInjector.log_w("DocumentFile", sb.toString());
                    z = false;
                }
            }
        }
        return z;
    }
}
