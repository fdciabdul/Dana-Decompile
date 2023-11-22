package com.anggrayudi.storage.file;

import android.content.Context;
import android.content.UriPermission;
import android.net.Uri;
import android.os.Build;
import androidx.documentfile.provider.DocumentFile;
import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import com.alipay.multimedia.adjuster.utils.PathUtils;
import com.anggrayudi.storage.FileWrapper;
import com.anggrayudi.storage.SimpleStorage;
import com.anggrayudi.storage.extension.ContextUtils;
import com.anggrayudi.storage.extension.TextUtils;
import com.anggrayudi.storage.extension.UriUtils;
import com.anggrayudi.storage.media.FileDescription;
import com.anggrayudi.storage.media.MediaFile;
import com.anggrayudi.storage.media.MediaStoreCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.promocenter.model.PromoActionType;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0011\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u0004H\u0007J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001fH\u0007J8\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u0018H\u0007J\u001a\u0010$\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001fH\u0007J\u0018\u0010%\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0004H\u0007J\u0018\u0010'\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0004H\u0007J:\u0010(\u001a\u0004\u0018\u00010!2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0018H\u0002J$\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040-2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040-H\u0007J$\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040-2\u0006\u0010\u0010\u001a\u00020\u00112\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000401H\u0007J$\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040-2\u0006\u0010\u0010\u001a\u00020\u00112\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000401H\u0007J8\u00103\u001a\u0004\u0018\u00010!2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u0018H\u0007J8\u00104\u001a\u0004\u0018\u00010!2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u0018H\u0007J8\u00105\u001a\u0004\u0018\u00010!2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u0018H\u0007JD\u00109\u001a\u0004\u0018\u00010!2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u0018H\u0007J\u001a\u0010:\u001a\u0004\u0018\u00010!2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u001cH\u0007J.\u0010<\u001a\u0004\u0018\u00010!2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u0018H\u0007J\u0018\u0010=\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0004H\u0007J\u001b\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00040-2\u0006\u0010?\u001a\u00020\u0004H\u0000¢\u0006\u0002\b@J\u001a\u0010A\u001a\u0004\u0018\u00010!2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u0010\u0010B\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u0004H\u0002J\u0010\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0004H\u0007J\u0018\u0010E\u001a\u00020F2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0012\u0010G\u001a\u0004\u0018\u00010\u00042\u0006\u0010?\u001a\u00020\u0004H\u0002J.\u0010H\u001a\u0004\u0018\u00010!2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u0018H\u0007J$\u0010I\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u0018H\u0007J\u0016\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040-2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010K\u001a\u00020F2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0018\u0010L\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0004H\u0007J\u0016\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00040-2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010N\u001a\u00020F2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0018\u0010O\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0010\u0010P\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010Q\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010R\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\u001cH\u0007J\"\u0010S\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u0004H\u0007J\u0018\u0010T\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u001cH\u0002J.\u0010U\u001a\u0004\u0018\u00010!2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u0018H\u0007J?\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0V2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040-2\b\b\u0002\u0010+\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010WJ*\u0010X\u001a\u0004\u0018\u00010!2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0018H\u0002J8\u0010Y\u001a\u0004\u0018\u00010!2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u0018H\u0007J\u0011\u0010Z\u001a\u00020\u0004*\u00020\u0004H\u0000¢\u0006\u0002\b[R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/anggrayudi/storage/file/DocumentFileCompat;", "", "()V", "DOCUMENTS_TREE_URI", "", "DOWNLOADS_FOLDER_AUTHORITY", "DOWNLOADS_TREE_URI", "EXTERNAL_STORAGE_AUTHORITY", "FILE_NAME_DUPLICATION_REGEX_WITHOUT_EXTENSION", "Lkotlin/text/Regex;", "getFILE_NAME_DUPLICATION_REGEX_WITHOUT_EXTENSION", "()Lkotlin/text/Regex;", "FILE_NAME_DUPLICATION_REGEX_WITH_EXTENSION", "getFILE_NAME_DUPLICATION_REGEX_WITH_EXTENSION", "MEDIA_FOLDER_AUTHORITY", "buildAbsolutePath", HummerConstants.CONTEXT, "Landroid/content/Context;", "simplePath", "storageId", "basePath", "buildSimplePath", "absolutePath", ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE, "", "file", "Ljava/io/File;", "createDocumentUri", "Landroid/net/Uri;", "createDownloadWithMediaStoreFallback", "Lcom/anggrayudi/storage/FileWrapper;", "Lcom/anggrayudi/storage/media/FileDescription;", "createFile", "Landroidx/documentfile/provider/DocumentFile;", "mimeType", "considerRawFile", "createPictureWithMediaStoreFallback", "delete", "fullPath", "doesExist", "exploreFile", "documentType", "Lcom/anggrayudi/storage/file/DocumentFileType;", "requiresWriteAccess", "findInaccessibleStorageLocations", "", "fullPaths", "findUniqueDeepestSubFolders", "folderFullPaths", "", "findUniqueParents", "fromFile", "fromFullPath", "fromPublicFolder", "type", "Lcom/anggrayudi/storage/file/PublicDirectory;", "subFile", "fromSimplePath", "fromUri", "uri", "getAccessibleRootDocumentFile", "getBasePath", "getDirectorySequence", "path", "getDirectorySequence$storage_release", "getDocumentFileForStorageInfo", "getFileNameFromPath", "getFileNameFromUrl", "url", "getFreeSpace", "", "getParentPath", "getRootDocumentFile", "getRootRawFile", "getSdCardIds", "getStorageCapacity", "getStorageId", "getStorageIds", "getUsedSpace", "isAccessGranted", "isDocumentsUriPermissionGranted", "isDownloadsUriPermissionGranted", "isRootUri", "isStorageUriPermissionGranted", "isUriPermissionGranted", "mkdirs", "", "(Landroid/content/Context;Ljava/util/List;ZZ)[Landroidx/documentfile/provider/DocumentFile;", "mkdirsParentDirectory", "recreate", "removeForbiddenCharsFromFilename", "removeForbiddenCharsFromFilename$storage_release", "storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class DocumentFileCompat {
    public static final DocumentFileCompat KClassImpl$Data$declaredNonStaticMembers$2 = new DocumentFileCompat();
    private static final Regex PlaceComponentResult = new Regex("(.*?) \\(\\d+\\)\\.[a-zA-Z0-9]+");
    private static final Regex MyBillsEntityDataFactory = new Regex("(.*?) \\(\\d+\\)");

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[PublicDirectory.values().length];
            iArr[PublicDirectory.DOWNLOADS.ordinal()] = 1;
            iArr[PublicDirectory.DOCUMENTS.ordinal()] = 2;
            getAuthRequestContext = iArr;
        }
    }

    private DocumentFileCompat() {
    }

    @JvmName(name = "getFILE_NAME_DUPLICATION_REGEX_WITH_EXTENSION")
    public static Regex PlaceComponentResult() {
        return PlaceComponentResult;
    }

    @JvmName(name = "getFILE_NAME_DUPLICATION_REGEX_WITHOUT_EXTENSION")
    public static Regex BuiltInFictitiousFunctionClassFactory() {
        return MyBillsEntityDataFactory;
    }

    @JvmStatic
    public static final boolean MyBillsEntityDataFactory(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "");
        String path = uri.getPath();
        return path != null && UriUtils.BuiltInFictitiousFunctionClassFactory(uri) && StringsKt.indexOf$default((CharSequence) path, ':', 0, false, 6, (Object) null) == path.length() - 1 && !StringsKt.startsWith$default(path, "/tree/home:", false, 2, (Object) null);
    }

    @JvmStatic
    private static String getErrorConfigVersion(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (StringsKt.startsWith$default((CharSequence) str, '/', false, 2, (Object) null)) {
            SimpleStorage.Companion companion = SimpleStorage.INSTANCE;
            if (StringsKt.startsWith$default(str, SimpleStorage.Companion.KClassImpl$Data$declaredNonStaticMembers$2(), false, 2, (Object) null)) {
                return PromoActionType.PRIMARY;
            }
            String path = FileUtils.MyBillsEntityDataFactory(context).getPath();
            Intrinsics.checkNotNullExpressionValue(path, "");
            return StringsKt.startsWith$default(str, path, false, 2, (Object) null) ? "data" : StringsKt.substringBefore$default(StringsKt.substringAfter(str, "/storage/", ""), '/', (String) null, 2, (Object) null);
        }
        return StringsKt.substringAfterLast$default(StringsKt.substringBefore(str, ':', ""), '/', (String) null, 2, (Object) null);
    }

    @JvmStatic
    private static String KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str) {
        String substringAfter;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (StringsKt.startsWith$default((CharSequence) str, '/', false, 2, (Object) null)) {
            String path = FileUtils.MyBillsEntityDataFactory(context).getPath();
            SimpleStorage.Companion companion = SimpleStorage.INSTANCE;
            String KClassImpl$Data$declaredNonStaticMembers$22 = SimpleStorage.Companion.KClassImpl$Data$declaredNonStaticMembers$2();
            if (StringsKt.startsWith$default(str, KClassImpl$Data$declaredNonStaticMembers$22, false, 2, (Object) null)) {
                substringAfter = StringsKt.substringAfter$default(str, KClassImpl$Data$declaredNonStaticMembers$22, (String) null, 2, (Object) null);
            } else {
                Intrinsics.checkNotNullExpressionValue(path, "");
                substringAfter = StringsKt.startsWith$default(str, path, false, 2, (Object) null) ? StringsKt.substringAfter$default(str, path, (String) null, 2, (Object) null) : StringsKt.substringAfter(StringsKt.substringAfter(str, "/storage/", ""), '/', "");
            }
        } else {
            substringAfter = StringsKt.substringAfter(str, ':', "");
        }
        String BuiltInFictitiousFunctionClassFactory = TextUtils.BuiltInFictitiousFunctionClassFactory(substringAfter);
        Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory, "");
        return TextUtils.BuiltInFictitiousFunctionClassFactory(StringsKt.replace$default(BuiltInFictitiousFunctionClassFactory, ":", "_", false, 4, (Object) null), "//", "/");
    }

    @JvmStatic
    public static final DocumentFile getAuthRequestContext(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(uri, "");
        if (!UriUtils.PlaceComponentResult(uri)) {
            if (UriUtils.MyBillsEntityDataFactory(uri)) {
                DocumentFile MyBillsEntityDataFactory2 = ContextUtils.MyBillsEntityDataFactory(context, uri);
                if (MyBillsEntityDataFactory2 == null) {
                    return null;
                }
                return DocumentFileUtils.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2) ? DocumentFileUtils.NetworkUserEntityData$$ExternalSyntheticLambda0(MyBillsEntityDataFactory2, context) : MyBillsEntityDataFactory2;
            }
            return ContextUtils.KClassImpl$Data$declaredNonStaticMembers$2(context, uri);
        }
        String path = uri.getPath();
        if (path == null) {
            return null;
        }
        File file = new File(path);
        if (file.canRead()) {
            return DocumentFile.KClassImpl$Data$declaredNonStaticMembers$2(file);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x006e, code lost:
    
        r5 = com.anggrayudi.storage.file.DocumentFileUtils.BuiltInFictitiousFunctionClassFactory(r6, r5, kotlin.text.StringsKt.substringAfter(r7, '/', ""), false);
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static androidx.documentfile.provider.DocumentFile getAuthRequestContext(android.content.Context r5, java.lang.String r6, java.lang.String r7, com.anggrayudi.storage.file.DocumentFileType r8, boolean r9, boolean r10) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r1 = "data"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r1)
            if (r1 == 0) goto L23
            java.io.File r5 = com.anggrayudi.storage.file.FileUtils.MyBillsEntityDataFactory(r5)
            java.io.File r5 = com.anggrayudi.storage.file.FileUtils.MyBillsEntityDataFactory(r5, r7)
            androidx.documentfile.provider.DocumentFile r5 = androidx.documentfile.provider.DocumentFile.KClassImpl$Data$declaredNonStaticMembers$2(r5)
            return r5
        L23:
            r1 = r7
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L30
            r1 = 1
            goto L31
        L30:
            r1 = 0
        L31:
            r4 = 0
            if (r1 == 0) goto L39
            androidx.documentfile.provider.DocumentFile r4 = PlaceComponentResult(r5, r6, r9, r10)
            goto L99
        L39:
            androidx.documentfile.provider.DocumentFile r9 = BuiltInFictitiousFunctionClassFactory(r5, r6, r7, r8, r9, r10)
            if (r9 != 0) goto L98
            java.lang.String r10 = android.os.Environment.DIRECTORY_DOWNLOADS
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)
            r1 = 2
            boolean r10 = kotlin.text.StringsKt.startsWith$default(r7, r10, r2, r1, r4)
            if (r10 == 0) goto L98
            java.lang.String r10 = "primary"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r10)
            if (r6 == 0) goto L98
            java.lang.String r6 = "content://com.android.providers.downloads.documents/tree/downloads"
            android.net.Uri r6 = android.net.Uri.parse(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            androidx.documentfile.provider.DocumentFile r6 = com.anggrayudi.storage.extension.ContextUtils.MyBillsEntityDataFactory(r5, r6)
            if (r6 != 0) goto L63
            goto L6a
        L63:
            boolean r9 = r6.BuiltInFictitiousFunctionClassFactory()
            if (r9 == 0) goto L6a
            goto L6b
        L6a:
            r6 = r4
        L6b:
            if (r6 != 0) goto L6e
            return r4
        L6e:
            r9 = 47
            java.lang.String r7 = kotlin.text.StringsKt.substringAfter(r7, r9, r0)
            androidx.documentfile.provider.DocumentFile r5 = com.anggrayudi.storage.file.DocumentFileUtils.PlaceComponentResult(r6, r5, r7)
            if (r5 != 0) goto L7b
            goto L99
        L7b:
            com.anggrayudi.storage.file.DocumentFileType r6 = com.anggrayudi.storage.file.DocumentFileType.ANY
            if (r8 == r6) goto L93
            com.anggrayudi.storage.file.DocumentFileType r6 = com.anggrayudi.storage.file.DocumentFileType.FILE
            if (r8 != r6) goto L89
            boolean r6 = r5.scheduleImpl()
            if (r6 != 0) goto L93
        L89:
            com.anggrayudi.storage.file.DocumentFileType r6 = com.anggrayudi.storage.file.DocumentFileType.FOLDER
            if (r8 != r6) goto L94
            boolean r6 = r5.lookAheadTest()
            if (r6 == 0) goto L94
        L93:
            r2 = 1
        L94:
            if (r2 == 0) goto L99
            r4 = r5
            goto L99
        L98:
            r4 = r9
        L99:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileCompat.getAuthRequestContext(android.content.Context, java.lang.String, java.lang.String, com.anggrayudi.storage.file.DocumentFileType, boolean, boolean):androidx.documentfile.provider.DocumentFile");
    }

    public static /* synthetic */ DocumentFile MyBillsEntityDataFactory(Context context, String str, DocumentFileType documentFileType, boolean z, boolean z2, int i) {
        DocumentFileType documentFileType2 = (i & 4) != 0 ? DocumentFileType.ANY : documentFileType;
        boolean z3 = (i & 8) != 0 ? false : z;
        boolean z4 = (i & 16) != 0 ? true : z2;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(documentFileType2, "");
        if (StringsKt.startsWith$default((CharSequence) str, '/', false, 2, (Object) null)) {
            File file = new File(str);
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(file, "");
            Intrinsics.checkNotNullParameter(documentFileType2, "");
            if (FileUtils.getAuthRequestContext(file, context, z3, z4)) {
                if (documentFileType2 != DocumentFileType.FILE || file.isFile()) {
                    if (documentFileType2 != DocumentFileType.FOLDER || file.isDirectory()) {
                        return DocumentFile.KClassImpl$Data$declaredNonStaticMembers$2(file);
                    }
                    return null;
                }
                return null;
            }
            String KClassImpl$Data$declaredNonStaticMembers$22 = FileUtils.KClassImpl$Data$declaredNonStaticMembers$2(file, context);
            Intrinsics.checkNotNullParameter(KClassImpl$Data$declaredNonStaticMembers$22, "");
            String BuiltInFictitiousFunctionClassFactory = TextUtils.BuiltInFictitiousFunctionClassFactory(TextUtils.BuiltInFictitiousFunctionClassFactory(StringsKt.replace$default(KClassImpl$Data$declaredNonStaticMembers$22, ":", "_", false, 4, (Object) null), "//", "/"));
            DocumentFile BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(context, FileUtils.getAuthRequestContext(file, context), BuiltInFictitiousFunctionClassFactory, documentFileType2, z3, z4);
            return BuiltInFictitiousFunctionClassFactory2 == null ? getAuthRequestContext(context, FileUtils.getAuthRequestContext(file, context), BuiltInFictitiousFunctionClassFactory, documentFileType2, z3, z4) : BuiltInFictitiousFunctionClassFactory2;
        }
        return getAuthRequestContext(context, StringsKt.substringBefore$default(str, ':', (String) null, 2, (Object) null), StringsKt.substringAfter$default(str, ':', (String) null, 2, (Object) null), documentFileType2, z3, z4);
    }

    public static /* synthetic */ DocumentFile KClassImpl$Data$declaredNonStaticMembers$2(Context context, PublicDirectory publicDirectory, String str, boolean z, boolean z2, int i) {
        if ((i & 4) != 0) {
            str = "";
        }
        if ((i & 8) != 0) {
            z = false;
        }
        if ((i & 16) != 0) {
            z2 = true;
        }
        return PlaceComponentResult(context, publicDirectory, str, z, z2);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.io.File] */
    /* JADX WARN: Type inference failed for: r5v3, types: [T, java.io.File] */
    @JvmStatic
    private static DocumentFile PlaceComponentResult(final Context context, PublicDirectory publicDirectory, final String str, final boolean z, boolean z2) {
        DocumentFile invoke;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(publicDirectory, "");
        Intrinsics.checkNotNullParameter(str, "");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = publicDirectory.getFile();
        boolean z3 = true;
        if (str.length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(objectRef.element);
            sb.append('/');
            sb.append(str);
            objectRef.element = new File(StringsKt.trimEnd(sb.toString(), '/'));
        }
        if (FileUtils.getAuthRequestContext((File) objectRef.element, context, z, z2)) {
            return DocumentFile.KClassImpl$Data$declaredNonStaticMembers$2((File) objectRef.element);
        }
        Function1<String, DocumentFile> function1 = new Function1<String, DocumentFile>() { // from class: com.anggrayudi.storage.file.DocumentFileCompat$fromPublicFolder$fileFromUriOrAbsolutePath$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DocumentFile invoke(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                Context context2 = context;
                Uri parse = Uri.parse(str2);
                Intrinsics.checkNotNullExpressionValue(parse, "");
                DocumentFile MyBillsEntityDataFactory2 = ContextUtils.MyBillsEntityDataFactory(context2, parse);
                if (MyBillsEntityDataFactory2 != null && MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory()) {
                    return DocumentFileUtils.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2, context, str, z);
                }
                Context context3 = context;
                String absolutePath = objectRef.element.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "");
                return DocumentFileCompat.MyBillsEntityDataFactory(context3, absolutePath, null, false, false, 12);
            }
        };
        int i = WhenMappings.getAuthRequestContext[publicDirectory.ordinal()];
        if (i == 1) {
            invoke = function1.invoke("content://com.android.providers.downloads.documents/tree/downloads");
        } else if (i == 2) {
            invoke = function1.invoke("content://com.android.externalstorage.documents/tree/home%3A");
        } else {
            String absolutePath = ((File) objectRef.element).getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "");
            invoke = MyBillsEntityDataFactory(context, absolutePath, null, false, false, 12);
        }
        if (invoke != null) {
            if (!invoke.BuiltInFictitiousFunctionClassFactory() || ((!z || !DocumentFileUtils.getErrorConfigVersion(invoke, context)) && z)) {
                z3 = false;
            }
            if (z3) {
                return invoke;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0028, code lost:
    
        if (r5 == null) goto L42;
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.documentfile.provider.DocumentFile PlaceComponentResult(android.content.Context r2, java.lang.String r3, boolean r4, boolean r5) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r1 = "data"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r1)
            if (r1 == 0) goto L19
            java.io.File r2 = com.anggrayudi.storage.file.FileUtils.MyBillsEntityDataFactory(r2)
            androidx.documentfile.provider.DocumentFile r2 = androidx.documentfile.provider.DocumentFile.KClassImpl$Data$declaredNonStaticMembers$2(r2)
            return r2
        L19:
            r1 = 0
            if (r5 == 0) goto L2a
            java.io.File r5 = getAuthRequestContext(r2, r3, r4)
            if (r5 != 0) goto L24
            r5 = r1
            goto L28
        L24:
            androidx.documentfile.provider.DocumentFile r5 = androidx.documentfile.provider.DocumentFile.KClassImpl$Data$declaredNonStaticMembers$2(r5)
        L28:
            if (r5 != 0) goto L32
        L2a:
            android.net.Uri r3 = MyBillsEntityDataFactory(r3, r0)
            androidx.documentfile.provider.DocumentFile r5 = com.anggrayudi.storage.extension.ContextUtils.MyBillsEntityDataFactory(r2, r3)
        L32:
            if (r5 != 0) goto L35
            goto L4b
        L35:
            boolean r3 = r5.BuiltInFictitiousFunctionClassFactory()
            if (r3 == 0) goto L47
            if (r4 == 0) goto L43
            boolean r2 = com.anggrayudi.storage.file.DocumentFileUtils.getErrorConfigVersion(r5, r2)
            if (r2 != 0) goto L45
        L43:
            if (r4 != 0) goto L47
        L45:
            r2 = 1
            goto L48
        L47:
            r2 = 0
        L48:
            if (r2 == 0) goto L4b
            r1 = r5
        L4b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileCompat.PlaceComponentResult(android.content.Context, java.lang.String, boolean, boolean):androidx.documentfile.provider.DocumentFile");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x003d, code lost:
    
        if (com.anggrayudi.storage.file.FileUtils.BuiltInFictitiousFunctionClassFactory(r4, r3) == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x003f, code lost:
    
        if (r5 == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0041, code lost:
    
        r3 = true;
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.io.File getAuthRequestContext(android.content.Context r3, java.lang.String r4, boolean r5) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r1 = "primary"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r1)
            if (r1 == 0) goto L15
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()
            goto L2e
        L15:
            java.lang.String r1 = "data"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r1)
            if (r1 == 0) goto L22
            java.io.File r4 = com.anggrayudi.storage.file.FileUtils.MyBillsEntityDataFactory(r3)
            goto L2e
        L22:
            java.io.File r1 = new java.io.File
            java.lang.String r2 = "/storage/"
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r4)
            r1.<init>(r4)
            r4 = r1
        L2e:
            boolean r1 = r4.canRead()
            if (r1 == 0) goto L43
            if (r5 == 0) goto L3f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            boolean r3 = com.anggrayudi.storage.file.FileUtils.BuiltInFictitiousFunctionClassFactory(r4, r3)
            if (r3 != 0) goto L41
        L3f:
            if (r5 != 0) goto L43
        L41:
            r3 = 1
            goto L44
        L43:
            r3 = 0
        L44:
            if (r3 != 0) goto L47
            r4 = 0
        L47:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileCompat.getAuthRequestContext(android.content.Context, java.lang.String, boolean):java.io.File");
    }

    @JvmStatic
    private static String MyBillsEntityDataFactory(Context context, String str, String str2) {
        String path;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str2, "");
        String BuiltInFictitiousFunctionClassFactory = TextUtils.BuiltInFictitiousFunctionClassFactory(StringsKt.replace$default(str2, ":", "_", false, 4, (Object) null), "//", "/");
        if (Intrinsics.areEqual(str, PromoActionType.PRIMARY)) {
            SimpleStorage.Companion companion = SimpleStorage.INSTANCE;
            path = SimpleStorage.Companion.KClassImpl$Data$declaredNonStaticMembers$2();
        } else {
            path = Intrinsics.areEqual(str, "data") ? FileUtils.MyBillsEntityDataFactory(context).getPath() : Intrinsics.stringPlus("/storage/", str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) path);
        sb.append('/');
        sb.append(BuiltInFictitiousFunctionClassFactory);
        return StringsKt.trimEnd(sb.toString(), '/');
    }

    @JvmStatic
    public static final String getAuthRequestContext(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        String trimEnd = StringsKt.trimEnd(str, '/');
        if (StringsKt.startsWith$default((CharSequence) trimEnd, '/', false, 2, (Object) null)) {
            Intrinsics.checkNotNullParameter(trimEnd, "");
            return TextUtils.BuiltInFictitiousFunctionClassFactory(StringsKt.replace$default(trimEnd, ":", "_", false, 4, (Object) null), "//", "/");
        }
        return MyBillsEntityDataFactory(context, getErrorConfigVersion(context, trimEnd), KClassImpl$Data$declaredNonStaticMembers$2(context, trimEnd));
    }

    @JvmStatic
    public static Uri MyBillsEntityDataFactory(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        StringBuilder sb = new StringBuilder();
        sb.append(PathUtils.CONTENT_SCHEMA);
        sb.append("com.android.externalstorage.documents");
        sb.append("/tree/");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(':');
        sb2.append(str2);
        sb.append((Object) Uri.encode(sb2.toString()));
        Uri parse = Uri.parse(sb.toString());
        Intrinsics.checkNotNullExpressionValue(parse, "");
        return parse;
    }

    @JvmStatic
    public static boolean BuiltInFictitiousFunctionClassFactory(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return MyBillsEntityDataFactory(context, MyBillsEntityDataFactory(str, str2));
    }

    private static boolean MyBillsEntityDataFactory(Context context, Uri uri) {
        List<UriPermission> persistedUriPermissions = context.getContentResolver().getPersistedUriPermissions();
        Intrinsics.checkNotNullExpressionValue(persistedUriPermissions, "");
        List<UriPermission> list = persistedUriPermissions;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (UriPermission uriPermission : list) {
            if (uriPermission.isReadPermission() && uriPermission.isWritePermission() && Intrinsics.areEqual(uriPermission.getUri(), uri)) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final FileWrapper MyBillsEntityDataFactory(Context context, FileDescription fileDescription) {
        DocumentFile MyBillsEntityDataFactory2;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(fileDescription, "");
        DocumentFile KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(context, PublicDirectory.DOWNLOADS, null, true, false, 20);
        if (KClassImpl$Data$declaredNonStaticMembers$22 == null && Build.VERSION.SDK_INT > 28) {
            MediaFile BuiltInFictitiousFunctionClassFactory = MediaStoreCompat.BuiltInFictitiousFunctionClassFactory(context, fileDescription);
            return BuiltInFictitiousFunctionClassFactory != null ? new FileWrapper.Media(BuiltInFictitiousFunctionClassFactory) : null;
        }
        if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
            String str = fileDescription.getAuthRequestContext;
            String str2 = fileDescription.BuiltInFictitiousFunctionClassFactory;
            if (str2 == null) {
                str2 = MimeType.getAuthRequestContext(fileDescription.getAuthRequestContext);
            }
            MyBillsEntityDataFactory2 = DocumentFileUtils.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$22, context, str, str2, CreateMode.CREATE_NEW);
            if (MyBillsEntityDataFactory2 != null) {
                r1 = new FileWrapper.Document(MyBillsEntityDataFactory2);
            }
        }
        return r1;
    }

    @JvmStatic
    public static final FileWrapper BuiltInFictitiousFunctionClassFactory(Context context, FileDescription fileDescription) {
        DocumentFile MyBillsEntityDataFactory2;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(fileDescription, "");
        DocumentFile KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(context, PublicDirectory.PICTURES, null, true, false, 20);
        if (KClassImpl$Data$declaredNonStaticMembers$22 == null && Build.VERSION.SDK_INT > 28) {
            MediaFile MyBillsEntityDataFactory3 = MediaStoreCompat.MyBillsEntityDataFactory(context, fileDescription);
            return MyBillsEntityDataFactory3 != null ? new FileWrapper.Media(MyBillsEntityDataFactory3) : null;
        }
        if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
            String str = fileDescription.getAuthRequestContext;
            String str2 = fileDescription.BuiltInFictitiousFunctionClassFactory;
            if (str2 == null) {
                str2 = MimeType.getAuthRequestContext(fileDescription.getAuthRequestContext);
            }
            MyBillsEntityDataFactory2 = DocumentFileUtils.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$22, context, str, str2, CreateMode.CREATE_NEW);
            if (MyBillsEntityDataFactory2 != null) {
                r1 = new FileWrapper.Document(MyBillsEntityDataFactory2);
            }
        }
        return r1;
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return TextUtils.BuiltInFictitiousFunctionClassFactory(StringsKt.replace$default(str, ":", "_", false, 4, (Object) null), "//", "/");
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x00b8 A[EDGE_INSN: B:153:0x00b8->B:126:0x00b8 BREAK  A[LOOP:0: B:113:0x0077->B:155:0x0077], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0077 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static androidx.documentfile.provider.DocumentFile BuiltInFictitiousFunctionClassFactory(android.content.Context r20, java.lang.String r21, java.lang.String r22, com.anggrayudi.storage.file.DocumentFileType r23, boolean r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileCompat.BuiltInFictitiousFunctionClassFactory(android.content.Context, java.lang.String, java.lang.String, com.anggrayudi.storage.file.DocumentFileType, boolean, boolean):androidx.documentfile.provider.DocumentFile");
    }

    public static List<String> PlaceComponentResult(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        List split$default = StringsKt.split$default((CharSequence) str, new char[]{'/'}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @JvmStatic
    public static final List<String> KClassImpl$Data$declaredNonStaticMembers$2(Context context, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(collection, "");
        Collection<String> collection2 = collection;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection2, 10));
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(getAuthRequestContext(context, (String) it.next()));
        }
        List distinct = CollectionsKt.distinct(arrayList);
        ArrayList arrayList2 = new ArrayList(distinct.size());
        List<String> list = distinct;
        for (String str : list) {
            boolean z = true;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (String str2 : list) {
                    if (!Intrinsics.areEqual(str2, str) && TextUtils.MyBillsEntityDataFactory(str, str2)) {
                        break;
                    }
                }
            }
            z = false;
            if (!z) {
                arrayList2.add(str);
            }
        }
        return arrayList2;
    }

    /* JADX WARN: Removed duplicated region for block: B:208:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x00b7 A[SYNTHETIC] */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long BuiltInFictitiousFunctionClassFactory(android.content.Context r16, java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 501
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileCompat.BuiltInFictitiousFunctionClassFactory(android.content.Context, java.lang.String):long");
    }
}
