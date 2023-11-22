package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import java.io.File;

/* loaded from: classes3.dex */
public abstract class DocumentFile {
    static final String TAG = "DocumentFile";
    public final DocumentFile mParent;

    public abstract DocumentFile BuiltInFictitiousFunctionClassFactory(String str, String str2);

    public abstract boolean BuiltInFictitiousFunctionClassFactory();

    public abstract DocumentFile[] DatabaseTableConfigUtil();

    public abstract String KClassImpl$Data$declaredNonStaticMembers$2();

    public abstract boolean KClassImpl$Data$declaredNonStaticMembers$2(String str);

    public abstract boolean MyBillsEntityDataFactory();

    public abstract String NetworkUserEntityData$$ExternalSyntheticLambda0();

    public abstract boolean PlaceComponentResult();

    public abstract DocumentFile getAuthRequestContext(String str);

    public abstract boolean getAuthRequestContext();

    public abstract Uri getErrorConfigVersion();

    public abstract boolean lookAheadTest();

    public abstract long moveToNextValue();

    public abstract boolean scheduleImpl();

    /* JADX INFO: Access modifiers changed from: package-private */
    public DocumentFile(DocumentFile documentFile) {
        this.mParent = documentFile;
    }

    public static DocumentFile KClassImpl$Data$declaredNonStaticMembers$2(File file) {
        return new RawDocumentFile(null, file);
    }

    public static DocumentFile MyBillsEntityDataFactory(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT >= 19) {
            return new SingleDocumentFile(context, uri);
        }
        return null;
    }

    public static DocumentFile getAuthRequestContext(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT >= 21) {
            String treeDocumentId = DocumentsContract.getTreeDocumentId(uri);
            if (DocumentsContract.isDocumentUri(context, uri)) {
                treeDocumentId = DocumentsContract.getDocumentId(uri);
            }
            return new TreeDocumentFile(null, context, DocumentsContract.buildDocumentUriUsingTree(uri, treeDocumentId));
        }
        return null;
    }
}
