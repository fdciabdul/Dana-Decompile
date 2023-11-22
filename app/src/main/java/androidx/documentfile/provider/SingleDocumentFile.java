package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class SingleDocumentFile extends DocumentFile {
    private Context BuiltInFictitiousFunctionClassFactory;
    private Uri KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleDocumentFile(Context context, Uri uri) {
        super(null);
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = uri;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final DocumentFile BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final DocumentFile getAuthRequestContext(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final Uri getErrorConfigVersion() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        return DocumentsContractApi19.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return DocumentsContractApi19.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean lookAheadTest() {
        return DocumentsContractApi19.getErrorConfigVersion(this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean scheduleImpl() {
        return DocumentsContractApi19.moveToNextValue(this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final long moveToNextValue() {
        return DocumentsContractApi19.NetworkUserEntityData$$ExternalSyntheticLambda0(this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return DocumentsContractApi19.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean PlaceComponentResult() {
        return DocumentsContractApi19.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean MyBillsEntityDataFactory() {
        try {
            return DocumentsContract.deleteDocument(this.BuiltInFictitiousFunctionClassFactory.getContentResolver(), this.KClassImpl$Data$declaredNonStaticMembers$2);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean getAuthRequestContext() {
        return DocumentsContractApi19.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final DocumentFile[] DatabaseTableConfigUtil() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        throw new UnsupportedOperationException();
    }
}
