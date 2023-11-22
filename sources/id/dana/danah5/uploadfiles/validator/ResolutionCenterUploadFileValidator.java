package id.dana.danah5.uploadfiles.validator;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.iap.ac.android.region.cdp.model.CdpContentInfo;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.domain.uploadfiles.UploadFilesEntity;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0006\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b0\u00101J#\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001aR\u0014\u0010!\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u001aR\u0014\u0010\"\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0014\u0010#\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u001aR\u0014\u0010%\u001a\u00020$8\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010\u001aR\u0014\u0010*\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010\u001aR\u0014\u0010+\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010\u001aR\u0014\u0010,\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010\u001aR\u0014\u0010-\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010\u001aR\u0014\u0010.\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u0010\u001aR\u0014\u0010/\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010\u001a"}, d2 = {"Lid/dana/danah5/uploadfiles/validator/ResolutionCenterUploadFileValidator;", "", "", "Lid/dana/domain/uploadfiles/UploadFilesEntity;", "files", "newFile", "", "checkFileCount", "(Ljava/util/List;Lid/dana/domain/uploadfiles/UploadFilesEntity;)Z", "Landroid/content/Context;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/net/Uri;", "uri", "", "checkFileSize", "(Landroid/content/Context;Landroid/net/Uri;)I", "", "mimeType", "getFileCategory", "(Ljava/lang/String;)Ljava/lang/String;", "getFileFormat", "isFileFormatAllowed", "(Ljava/lang/String;)Z", "isFileSizeAllowed", "(Landroid/content/Context;Landroid/net/Uri;)Z", "AVI", "Ljava/lang/String;", "DOC", "DOCUMENT", "DOCX", "FILE_FORMAT_LIST", "Ljava/util/List;", "GIF", "HEIC", CdpContentInfo.CONTENT_TYPE_IMAGE, "JPG", "", "MAXIMUM_FILE_SIZE", SummaryActivity.DAYS, "MAX_FILE_PER_TYPE", "I", "MOV", "MP4", "PDF", "PNG", "TXT", "VIDEO", "X_MSVIDEO", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ResolutionCenterUploadFileValidator {
    private static final String DOC = "msword";
    public static final String DOCUMENT = "document";
    private static final String DOCX = "vnd.openxmlformats-officedocument.wordprocessingml.document";
    private static final String GIF = "gif";
    public static final String IMAGE = "image";
    public static final double MAXIMUM_FILE_SIZE = 3.145728E7d;
    public static final int MAX_FILE_PER_TYPE = 3;
    private static final String PNG = "png";
    private static final String TXT = "plain";
    public static final String VIDEO = "video";
    public static final ResolutionCenterUploadFileValidator INSTANCE = new ResolutionCenterUploadFileValidator();
    private static final String JPG = "jpeg";
    private static final String HEIC = "heic";
    private static final String MP4 = "mp4";
    private static final String MOV = "quicktime";
    private static final String AVI = "avi";
    private static final String X_MSVIDEO = "x-msvideo";
    private static final String PDF = "pdf";
    private static final List<String> FILE_FORMAT_LIST = CollectionsKt.listOf((Object[]) new String[]{JPG, "png", "gif", HEIC, MP4, MOV, AVI, X_MSVIDEO, PDF});

    private ResolutionCenterUploadFileValidator() {
    }

    public final boolean isFileFormatAllowed(String mimeType) {
        Intrinsics.checkNotNullParameter(mimeType, "");
        return FILE_FORMAT_LIST.contains(getFileFormat(mimeType));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0059 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0064 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0078 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getFileCategory(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r3 = r2.getFileFormat(r3)
            int r1 = r3.hashCode()
            switch(r1) {
                case -1064529488: goto L70;
                case -417226990: goto L67;
                case 96980: goto L5c;
                case 102340: goto L51;
                case 108273: goto L48;
                case 110834: goto L3f;
                case 111145: goto L36;
                case 3268712: goto L2d;
                case 106748362: goto L24;
                case 329091648: goto L1b;
                case 1301723706: goto L12;
                default: goto L10;
            }
        L10:
            goto L7a
        L12:
            java.lang.String r1 = "quicktime"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L64
            goto L7a
        L1b:
            java.lang.String r1 = "x-msvideo"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L64
            goto L7a
        L24:
            java.lang.String r1 = "plain"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L78
            goto L7a
        L2d:
            java.lang.String r1 = "jpeg"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L59
            goto L7a
        L36:
            java.lang.String r1 = "png"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L59
            goto L7a
        L3f:
            java.lang.String r1 = "pdf"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L78
            goto L7a
        L48:
            java.lang.String r1 = "mp4"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L64
            goto L7a
        L51:
            java.lang.String r1 = "gif"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L7a
        L59:
            java.lang.String r0 = "image"
            goto L7a
        L5c:
            java.lang.String r1 = "avi"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L7a
        L64:
            java.lang.String r0 = "video"
            goto L7a
        L67:
            java.lang.String r1 = "vnd.openxmlformats-officedocument.wordprocessingml.document"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L78
            goto L7a
        L70:
            java.lang.String r1 = "msword"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L7a
        L78:
            java.lang.String r0 = "document"
        L7a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.uploadfiles.validator.ResolutionCenterUploadFileValidator.getFileCategory(java.lang.String):java.lang.String");
    }

    private final String getFileFormat(String mimeType) {
        return StringsKt.substringAfterLast$default(mimeType, "/", (String) null, 2, (Object) null);
    }

    public final boolean isFileSizeAllowed(Context activity, Uri uri) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(uri, "");
        return ((double) checkFileSize(activity, uri)) <= 3.145728E7d;
    }

    public final int checkFileSize(Context activity, Uri uri) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(uri, "");
        Cursor query = activity.getContentResolver().query(uri, null, null, null, null);
        if (query != null) {
            Cursor cursor = query;
            try {
                Cursor cursor2 = cursor;
                int columnIndex = cursor2.getColumnIndex("_size");
                cursor2.moveToFirst();
                int i = cursor2.getInt(columnIndex);
                CloseableKt.closeFinally(cursor, null);
                return i;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursor, th);
                    throw th2;
                }
            }
        }
        return 0;
    }

    public final boolean checkFileCount(List<UploadFilesEntity> files, UploadFilesEntity newFile) {
        Intrinsics.checkNotNullParameter(files, "");
        Intrinsics.checkNotNullParameter(newFile, "");
        String substringBeforeLast$default = StringsKt.substringBeforeLast$default(newFile.getContentType(), '/', (String) null, 2, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : files) {
            if (Intrinsics.areEqual(StringsKt.substringBeforeLast$default(((UploadFilesEntity) obj).getContentType(), '/', (String) null, 2, (Object) null), substringBeforeLast$default)) {
                arrayList.add(obj);
            }
        }
        return arrayList.size() <= 3;
    }
}
