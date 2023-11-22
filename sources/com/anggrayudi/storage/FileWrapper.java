package com.anggrayudi.storage;

import android.content.Context;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import com.alibaba.exthub.config.ExtHubMetaInfoParser;
import com.anggrayudi.storage.file.DocumentFileUtils;
import com.anggrayudi.storage.media.MediaFile;
import com.ap.zoloz.hummer.biz.HummerConstants;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0002\u001d\u001eJ\b\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0013\u001a\u00020\u0014H'J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001c\u001a\u00020\u0011H'R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0001"}, d2 = {"Lcom/anggrayudi/storage/FileWrapper;", "", "baseName", "", "getBaseName", "()Ljava/lang/String;", ExtHubMetaInfoParser.KEY_EXTENSION_INFO, "getExtension", "mimeType", "getMimeType", "name", "getName", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "delete", "", "getAbsolutePath", HummerConstants.CONTEXT, "Landroid/content/Context;", "getBasePath", "getRelativePath", "isEmpty", "openInputStream", "Ljava/io/InputStream;", "openOutputStream", "Ljava/io/OutputStream;", "append", "Document", "Media", "storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface FileWrapper {
    boolean BuiltInFictitiousFunctionClassFactory();

    Uri PlaceComponentResult();

    OutputStream PlaceComponentResult(Context context);

    /* renamed from: com.anggrayudi.storage.FileWrapper$-CC */
    /* loaded from: classes3.dex */
    public final /* synthetic */ class CC {
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\f\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000e8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000f"}, d2 = {"Lcom/anggrayudi/storage/FileWrapper$Media;", "Lcom/anggrayudi/storage/FileWrapper;", "", "BuiltInFictitiousFunctionClassFactory", "()Z", "Landroid/content/Context;", "p0", "p1", "Ljava/io/OutputStream;", "PlaceComponentResult", "(Landroid/content/Context;)Ljava/io/OutputStream;", "Lcom/anggrayudi/storage/media/MediaFile;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/anggrayudi/storage/media/MediaFile;", "Landroid/net/Uri;", "()Landroid/net/Uri;", "MyBillsEntityDataFactory", "<init>", "(Lcom/anggrayudi/storage/media/MediaFile;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Media implements FileWrapper {
        public final MediaFile KClassImpl$Data$declaredNonStaticMembers$2;

        public Media(MediaFile mediaFile) {
            Intrinsics.checkNotNullParameter(mediaFile, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = mediaFile;
        }

        @Override // com.anggrayudi.storage.FileWrapper
        @JvmName(name = "PlaceComponentResult")
        public final Uri PlaceComponentResult() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue;
        }

        @Override // com.anggrayudi.storage.FileWrapper
        public final OutputStream PlaceComponentResult(Context context) {
            Intrinsics.checkNotNullParameter(context, "");
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(true);
        }

        @Override // com.anggrayudi.storage.FileWrapper
        public final boolean BuiltInFictitiousFunctionClassFactory() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\t\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000e8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000f"}, d2 = {"Lcom/anggrayudi/storage/FileWrapper$Document;", "Lcom/anggrayudi/storage/FileWrapper;", "", "BuiltInFictitiousFunctionClassFactory", "()Z", "Landroid/content/Context;", "p0", "p1", "Ljava/io/OutputStream;", "PlaceComponentResult", "(Landroid/content/Context;)Ljava/io/OutputStream;", "Landroidx/documentfile/provider/DocumentFile;", "MyBillsEntityDataFactory", "Landroidx/documentfile/provider/DocumentFile;", "Landroid/net/Uri;", "()Landroid/net/Uri;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Landroidx/documentfile/provider/DocumentFile;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Document implements FileWrapper {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final DocumentFile PlaceComponentResult;

        public Document(DocumentFile documentFile) {
            Intrinsics.checkNotNullParameter(documentFile, "");
            this.PlaceComponentResult = documentFile;
        }

        @Override // com.anggrayudi.storage.FileWrapper
        @JvmName(name = "PlaceComponentResult")
        public final Uri PlaceComponentResult() {
            Uri errorConfigVersion = this.PlaceComponentResult.getErrorConfigVersion();
            Intrinsics.checkNotNullExpressionValue(errorConfigVersion, "");
            return errorConfigVersion;
        }

        @Override // com.anggrayudi.storage.FileWrapper
        public final OutputStream PlaceComponentResult(Context context) {
            Intrinsics.checkNotNullParameter(context, "");
            return DocumentFileUtils.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, context, true);
        }

        @Override // com.anggrayudi.storage.FileWrapper
        public final boolean BuiltInFictitiousFunctionClassFactory() {
            return this.PlaceComponentResult.MyBillsEntityDataFactory();
        }
    }
}
