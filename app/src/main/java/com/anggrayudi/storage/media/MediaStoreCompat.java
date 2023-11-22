package com.anggrayudi.storage.media;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.documentfile.provider.DocumentFile;
import com.alipay.mobile.zebra.ZebraLoader;
import com.anggrayudi.storage.extension.IOUtils;
import com.anggrayudi.storage.extension.TextUtils;
import com.anggrayudi.storage.file.CreateMode;
import com.anggrayudi.storage.file.DocumentFileCompat;
import com.anggrayudi.storage.file.DocumentFileType;
import com.anggrayudi.storage.file.DocumentFileUtils;
import com.anggrayudi.storage.file.FileUtils;
import com.anggrayudi.storage.file.MimeType;
import com.j256.ormlite.field.FieldType;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J9\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\r\u0010\u0010R\u0011\u0010\u000f\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014"}, d2 = {"Lcom/anggrayudi/storage/media/MediaStoreCompat;", "", "Landroid/content/Context;", "p0", "Lcom/anggrayudi/storage/media/MediaType;", "p1", "", "p2", "Lcom/anggrayudi/storage/media/FileDescription;", "p3", "Lcom/anggrayudi/storage/file/CreateMode;", "p4", "Lcom/anggrayudi/storage/media/MediaFile;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Lcom/anggrayudi/storage/media/MediaType;Ljava/lang/String;Lcom/anggrayudi/storage/media/FileDescription;Lcom/anggrayudi/storage/file/CreateMode;)Lcom/anggrayudi/storage/media/MediaFile;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Lcom/anggrayudi/storage/media/MediaType;Ljava/lang/String;)Lcom/anggrayudi/storage/media/MediaFile;", "", "MyBillsEntityDataFactory", "(Landroid/content/Context;Lcom/anggrayudi/storage/media/MediaType;Ljava/lang/String;)Ljava/util/List;", "()Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class MediaStoreCompat {
    public static final MediaStoreCompat INSTANCE = new MediaStoreCompat();

    private MediaStoreCompat() {
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public static final String MyBillsEntityDataFactory() {
        return Build.VERSION.SDK_INT < 29 ? "external" : "external_primary";
    }

    public static /* synthetic */ MediaFile BuiltInFictitiousFunctionClassFactory(Context context, FileDescription fileDescription) {
        CreateMode createMode = CreateMode.CREATE_NEW;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(fileDescription, "");
        Intrinsics.checkNotNullParameter(createMode, "");
        MediaType mediaType = MediaType.DOWNLOADS;
        String str = Environment.DIRECTORY_DOWNLOADS;
        Intrinsics.checkNotNullExpressionValue(str, "");
        return KClassImpl$Data$declaredNonStaticMembers$2(context, mediaType, str, fileDescription, createMode);
    }

    public static /* synthetic */ MediaFile MyBillsEntityDataFactory(Context context, FileDescription fileDescription) {
        ImageMediaDirectory imageMediaDirectory = ImageMediaDirectory.PICTURES;
        CreateMode createMode = CreateMode.CREATE_NEW;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(fileDescription, "");
        Intrinsics.checkNotNullParameter(imageMediaDirectory, "");
        Intrinsics.checkNotNullParameter(createMode, "");
        return KClassImpl$Data$declaredNonStaticMembers$2(context, MediaType.IMAGE, imageMediaDirectory.getFolderName(), fileDescription, createMode);
    }

    private static MediaFile KClassImpl$Data$declaredNonStaticMembers$2(Context p0, MediaType p1, String p2, FileDescription p3, CreateMode p4) {
        MediaFile mediaFile;
        Object obj;
        if (Build.VERSION.SDK_INT < 29) {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(p2);
            Intrinsics.checkNotNullExpressionValue(externalStoragePublicDirectory, "");
            if (FileUtils.MyBillsEntityDataFactory(externalStoragePublicDirectory, p0)) {
                String str = p3.getAuthRequestContext;
                String str2 = p3.BuiltInFictitiousFunctionClassFactory;
                if (str2 == null) {
                    str2 = MimeType.getAuthRequestContext(p3.getAuthRequestContext);
                }
                String MyBillsEntityDataFactory = MimeType.MyBillsEntityDataFactory(str, str2);
                StringBuilder sb = new StringBuilder();
                sb.append(externalStoragePublicDirectory);
                sb.append('/');
                sb.append(p3.PlaceComponentResult);
                File file = new File(sb.toString(), MyBillsEntityDataFactory);
                File parentFile = file.getParentFile();
                if (parentFile == null) {
                    return null;
                }
                parentFile.mkdirs();
                if (file.exists() && p4 == CreateMode.CREATE_NEW) {
                    file = FileUtils.MyBillsEntityDataFactory(parentFile, FileUtils.KClassImpl$Data$declaredNonStaticMembers$2(parentFile, MyBillsEntityDataFactory));
                }
                if ((p4 != CreateMode.REPLACE || FileUtils.BuiltInFictitiousFunctionClassFactory(file)) && FileUtils.PlaceComponentResult(file) && file.canRead()) {
                    return new MediaFile(p0, file);
                }
                return null;
            }
            return null;
        }
        String str3 = p3.getAuthRequestContext;
        String str4 = p3.BuiltInFictitiousFunctionClassFactory;
        if (str4 == null) {
            str4 = MimeType.getAuthRequestContext(p3.getAuthRequestContext);
        }
        String MyBillsEntityDataFactory2 = MimeType.MyBillsEntityDataFactory(str3, str4);
        String str5 = p3.BuiltInFictitiousFunctionClassFactory;
        if (str5 == null) {
            str5 = MimeType.getAuthRequestContext(p3.getAuthRequestContext);
        }
        String BuiltInFictitiousFunctionClassFactory = MimeType.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2);
        final String MyBillsEntityDataFactory3 = MimeType.MyBillsEntityDataFactory(MyBillsEntityDataFactory2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", Intrinsics.areEqual(str5, ZebraLoader.MIME_TYPE_STREAM) ? MyBillsEntityDataFactory2 : BuiltInFictitiousFunctionClassFactory);
        contentValues.put("mime_type", str5);
        long currentTimeMillis = System.currentTimeMillis();
        contentValues.put("date_added", Long.valueOf(currentTimeMillis));
        contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(p2);
        sb2.append('/');
        sb2.append(p3.PlaceComponentResult);
        final String KClassImpl$Data$declaredNonStaticMembers$2 = TextUtils.KClassImpl$Data$declaredNonStaticMembers$2(sb2.toString());
        contentValues.put("owner_package_name", p0.getPackageName());
        if ((!StringsKt.isBlank(KClassImpl$Data$declaredNonStaticMembers$2)) != false) {
            contentValues.put("relative_path", KClassImpl$Data$declaredNonStaticMembers$2);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(KClassImpl$Data$declaredNonStaticMembers$2);
        sb3.append('/');
        sb3.append(MyBillsEntityDataFactory2);
        MediaFile BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(p0, p1, sb3.toString());
        if (BuiltInFictitiousFunctionClassFactory2 != null && BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory()) {
            return BuiltInFictitiousFunctionClassFactory2;
        }
        if (BuiltInFictitiousFunctionClassFactory2 != null) {
            if (p4 == CreateMode.REUSE) {
                return BuiltInFictitiousFunctionClassFactory2;
            }
            if (p4 == CreateMode.REPLACE) {
                BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2();
                ContentResolver contentResolver = p0.getContentResolver();
                Uri writeUri = p1.getWriteUri();
                Intrinsics.checkNotNull(writeUri);
                Uri insert = contentResolver.insert(writeUri, contentValues);
                if (insert == null) {
                    return null;
                }
                return new MediaFile(p0, insert);
            }
            if (Build.VERSION.SDK_INT == 29) {
                final String stringPlus = Intrinsics.stringPlus(BuiltInFictitiousFunctionClassFactory, " (");
                Iterator it = SequencesKt.filter(SequencesKt.filter(CollectionsKt.asSequence(MyBillsEntityDataFactory(p0, p1, BuiltInFictitiousFunctionClassFactory)), new Function1<MediaFile, Boolean>() { // from class: com.anggrayudi.storage.media.MediaStoreCompat$createMedia$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(MediaFile mediaFile2) {
                        Intrinsics.checkNotNullParameter(mediaFile2, "");
                        return Boolean.valueOf(StringsKt.isBlank(KClassImpl$Data$declaredNonStaticMembers$2) || Intrinsics.areEqual(KClassImpl$Data$declaredNonStaticMembers$2, StringsKt.removeSuffix(mediaFile2.BuiltInFictitiousFunctionClassFactory(), (CharSequence) "/")));
                    }
                }), new Function1<MediaFile, Boolean>() { // from class: com.anggrayudi.storage.media.MediaStoreCompat$createMedia$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
                    
                        if (com.anggrayudi.storage.file.DocumentFileCompat.BuiltInFictitiousFunctionClassFactory().matches(r0) != false) goto L17;
                     */
                    @Override // kotlin.jvm.functions.Function1
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Boolean invoke(com.anggrayudi.storage.media.MediaFile r7) {
                        /*
                            r6 = this;
                            java.lang.String r0 = ""
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                            java.lang.String r7 = r7.PlaceComponentResult()
                            r0 = r7
                            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                            r1 = 0
                            r2 = 1
                            if (r0 == 0) goto L18
                            int r3 = r0.length()
                            if (r3 == 0) goto L18
                            r3 = 0
                            goto L19
                        L18:
                            r3 = 1
                        L19:
                            if (r3 != 0) goto L4a
                            java.lang.String r3 = com.anggrayudi.storage.file.MimeType.MyBillsEntityDataFactory(r7)
                            java.lang.String r4 = r1
                            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
                            if (r3 == 0) goto L4a
                            java.lang.String r3 = r2
                            r4 = 2
                            r5 = 0
                            boolean r7 = kotlin.text.StringsKt.startsWith$default(r7, r3, r1, r4, r5)
                            if (r7 == 0) goto L4a
                            com.anggrayudi.storage.file.DocumentFileCompat r7 = com.anggrayudi.storage.file.DocumentFileCompat.KClassImpl$Data$declaredNonStaticMembers$2
                            kotlin.text.Regex r7 = com.anggrayudi.storage.file.DocumentFileCompat.PlaceComponentResult()
                            boolean r7 = r7.matches(r0)
                            if (r7 != 0) goto L49
                            com.anggrayudi.storage.file.DocumentFileCompat r7 = com.anggrayudi.storage.file.DocumentFileCompat.KClassImpl$Data$declaredNonStaticMembers$2
                            kotlin.text.Regex r7 = com.anggrayudi.storage.file.DocumentFileCompat.BuiltInFictitiousFunctionClassFactory()
                            boolean r7 = r7.matches(r0)
                            if (r7 == 0) goto L4a
                        L49:
                            r1 = 1
                        L4a:
                            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r1)
                            return r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.media.MediaStoreCompat$createMedia$3.invoke(com.anggrayudi.storage.media.MediaFile):java.lang.Boolean");
                    }
                }).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((MediaFile) obj).getAuthRequestContext()) {
                        break;
                    }
                }
                MediaFile mediaFile2 = (MediaFile) obj;
                if (mediaFile2 != null) {
                    return mediaFile2;
                }
            }
            ContentResolver contentResolver2 = p0.getContentResolver();
            Uri writeUri2 = p1.getWriteUri();
            Intrinsics.checkNotNull(writeUri2);
            Uri insert2 = contentResolver2.insert(writeUri2, contentValues);
            if (insert2 == null) {
                return null;
            }
            mediaFile = new MediaFile(p0, insert2);
        } else {
            ContentResolver contentResolver3 = p0.getContentResolver();
            Uri writeUri3 = p1.getWriteUri();
            Intrinsics.checkNotNull(writeUri3);
            Uri insert3 = contentResolver3.insert(writeUri3, contentValues);
            if (insert3 == null) {
                return null;
            }
            mediaFile = new MediaFile(p0, insert3);
        }
        return mediaFile;
    }

    @JvmStatic
    private static MediaFile KClassImpl$Data$declaredNonStaticMembers$2(Context p0, MediaType p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Uri writeUri = p1.getWriteUri();
        if (writeUri == null) {
            return null;
        }
        Uri build = writeUri.buildUpon().appendPath(p2).build();
        Intrinsics.checkNotNullExpressionValue(build, "");
        return new MediaFile(p0, build);
    }

    @JvmStatic
    private static MediaFile BuiltInFictitiousFunctionClassFactory(Context p0, MediaType p1, String p2) {
        Cursor query;
        MediaFile mediaFile;
        String BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        DocumentFileCompat documentFileCompat = DocumentFileCompat.KClassImpl$Data$declaredNonStaticMembers$2;
        String BuiltInFictitiousFunctionClassFactory2 = TextUtils.BuiltInFictitiousFunctionClassFactory(DocumentFileCompat.KClassImpl$Data$declaredNonStaticMembers$2(p2));
        if (Build.VERSION.SDK_INT < 29) {
            File file = new File(Environment.getExternalStorageDirectory(), BuiltInFictitiousFunctionClassFactory2);
            if (file.isFile() && file.canRead()) {
                return new MediaFile(p0, file);
            }
            return null;
        }
        String substringBeforeLast = StringsKt.substringBeforeLast(BuiltInFictitiousFunctionClassFactory2, '/', "");
        if (substringBeforeLast.length() == 0) {
            return null;
        }
        String substringAfterLast$default = StringsKt.substringAfterLast$default(BuiltInFictitiousFunctionClassFactory2, '/', (String) null, 2, (Object) null);
        ContentResolver contentResolver = p0.getContentResolver();
        Uri readUri = p1.getReadUri();
        if (readUri == null || (query = contentResolver.query(readUri, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX}, "_display_name = ? AND relative_path = ?", new String[]{substringAfterLast$default, Intrinsics.stringPlus(substringBeforeLast, "/")}, null)) == null) {
            return null;
        }
        Cursor cursor = query;
        try {
            Cursor cursor2 = cursor;
            if (cursor2.moveToFirst() && (BuiltInFictitiousFunctionClassFactory = IOUtils.BuiltInFictitiousFunctionClassFactory(cursor2, FieldType.FOREIGN_ID_FIELD_SUFFIX)) != null) {
                mediaFile = KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, BuiltInFictitiousFunctionClassFactory);
                CloseableKt.closeFinally(cursor, null);
                return mediaFile;
            }
            mediaFile = null;
            CloseableKt.closeFinally(cursor, null);
            return mediaFile;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursor, th);
                throw th2;
            }
        }
    }

    @JvmStatic
    private static List<MediaFile> MyBillsEntityDataFactory(Context p0, MediaType p1, String p2) {
        ArrayList emptyList;
        MediaFile KClassImpl$Data$declaredNonStaticMembers$2;
        List KClassImpl$Data$declaredNonStaticMembers$22;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        if (Build.VERSION.SDK_INT < 29) {
            List<File> directories = p1.getDirectories();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(directories, 10));
            Iterator<T> it = directories.iterator();
            while (it.hasNext()) {
                DocumentFile KClassImpl$Data$declaredNonStaticMembers$23 = DocumentFile.KClassImpl$Data$declaredNonStaticMembers$2((File) it.next());
                StringBuilder sb = new StringBuilder();
                sb.append("^.*");
                sb.append(p2);
                sb.append(".*$");
                Regex regex = new Regex(sb.toString());
                String[] strArr = {p1.getMimeType()};
                Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$23, "");
                KClassImpl$Data$declaredNonStaticMembers$22 = DocumentFileUtils.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$23, DocumentFileType.ANY, strArr, "", regex);
                List list = KClassImpl$Data$declaredNonStaticMembers$22;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    String path = ((DocumentFile) it2.next()).getErrorConfigVersion().getPath();
                    Intrinsics.checkNotNull(path);
                    arrayList2.add(new MediaFile(p0, new File(path)));
                }
                arrayList.add(arrayList2);
            }
            return CollectionsKt.flatten(arrayList);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("_display_name LIKE '%");
        sb2.append(p2);
        sb2.append("%'");
        String obj = sb2.toString();
        ContentResolver contentResolver = p0.getContentResolver();
        Uri readUri = p1.getReadUri();
        if (readUri == null) {
            return CollectionsKt.emptyList();
        }
        Cursor query = contentResolver.query(readUri, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX}, obj, null, null);
        List<MediaFile> list2 = null;
        if (query != null) {
            Cursor cursor = query;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToFirst()) {
                    ArrayList arrayList3 = new ArrayList(cursor2.getCount());
                    do {
                        String BuiltInFictitiousFunctionClassFactory = IOUtils.BuiltInFictitiousFunctionClassFactory(cursor2, FieldType.FOREIGN_ID_FIELD_SUFFIX);
                        if (BuiltInFictitiousFunctionClassFactory != null && (KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, BuiltInFictitiousFunctionClassFactory)) != null) {
                            arrayList3.add(KClassImpl$Data$declaredNonStaticMembers$2);
                        }
                    } while (cursor2.moveToNext());
                    emptyList = arrayList3;
                } else {
                    emptyList = CollectionsKt.emptyList();
                }
                CloseableKt.closeFinally(cursor, null);
                list2 = emptyList;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursor, th);
                    throw th2;
                }
            }
        }
        return list2 == null ? CollectionsKt.emptyList() : list2;
    }
}
