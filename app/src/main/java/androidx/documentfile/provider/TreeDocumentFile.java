package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class TreeDocumentFile extends DocumentFile {
    private Context BuiltInFictitiousFunctionClassFactory;
    private Uri PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TreeDocumentFile(DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.PlaceComponentResult = uri;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final DocumentFile BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        Uri PlaceComponentResult = PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, str, str2);
        if (PlaceComponentResult != null) {
            return new TreeDocumentFile(this, this.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult);
        }
        return null;
    }

    private static Uri PlaceComponentResult(Context context, Uri uri, String str, String str2) {
        try {
            return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final DocumentFile getAuthRequestContext(String str) {
        Uri PlaceComponentResult = PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, "vnd.android.document/directory", str);
        if (PlaceComponentResult != null) {
            return new TreeDocumentFile(this, this.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult);
        }
        return null;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final Uri getErrorConfigVersion() {
        return this.PlaceComponentResult;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        return DocumentsContractApi19.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return DocumentsContractApi19.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean lookAheadTest() {
        return DocumentsContractApi19.getErrorConfigVersion(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean scheduleImpl() {
        return DocumentsContractApi19.moveToNextValue(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final long moveToNextValue() {
        return DocumentsContractApi19.NetworkUserEntityData$$ExternalSyntheticLambda0(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return DocumentsContractApi19.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean PlaceComponentResult() {
        return DocumentsContractApi19.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean MyBillsEntityDataFactory() {
        try {
            return DocumentsContract.deleteDocument(this.BuiltInFictitiousFunctionClassFactory.getContentResolver(), this.PlaceComponentResult);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean getAuthRequestContext() {
        return DocumentsContractApi19.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final DocumentFile[] DatabaseTableConfigUtil() {
        ContentResolver contentResolver = this.BuiltInFictitiousFunctionClassFactory.getContentResolver();
        Uri uri = this.PlaceComponentResult;
        Uri buildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = contentResolver.query(buildChildDocumentsUriUsingTree, new String[]{"document_id"}, null, null, null);
                while (cursor.moveToNext()) {
                    arrayList.add(DocumentsContract.buildDocumentUriUsingTree(this.PlaceComponentResult, cursor.getString(0)));
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed query: ");
                sb.append(e);
                InstrumentInjector.log_w("DocumentFile", sb.toString());
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception unused) {
                }
            }
            Uri[] uriArr = (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
            DocumentFile[] documentFileArr = new DocumentFile[uriArr.length];
            for (int i = 0; i < uriArr.length; i++) {
                documentFileArr[i] = new TreeDocumentFile(this, this.BuiltInFictitiousFunctionClassFactory, uriArr[i]);
            }
            return documentFileArr;
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (RuntimeException e3) {
                    throw e3;
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        try {
            Uri renameDocument = DocumentsContract.renameDocument(this.BuiltInFictitiousFunctionClassFactory.getContentResolver(), this.PlaceComponentResult, str);
            if (renameDocument != null) {
                this.PlaceComponentResult = renameDocument;
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
