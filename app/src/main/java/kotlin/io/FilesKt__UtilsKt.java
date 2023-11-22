package kotlin.io;

import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.exthub.config.ExtHubMetaInfoParser;
import com.alipay.mobile.zebra.data.BoxData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a1\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a1\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\u0006\u001a?\u0010\u000f\u001a\u00020\t*\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\t2\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u000f\u0010\u0010\u001a-\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0011\u0010\u0015\u001a\u00020\t*\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0018\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0019\u0010\u0018\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u001a\u001a\u0011\u0010\u001b\u001a\u00020\u0003*\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d*\b\u0012\u0004\u0012\u00020\u00030\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0013\u0010\u001e\u001a\u00020 *\u00020 H\u0002¢\u0006\u0004\b\u001e\u0010!\u001a\u0019\u0010#\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003¢\u0006\u0004\b#\u0010$\u001a\u001b\u0010%\u001a\u0004\u0018\u00010\u0003*\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003¢\u0006\u0004\b%\u0010$\u001a\u0019\u0010&\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003¢\u0006\u0004\b&\u0010$\u001a\u0019\u0010(\u001a\u00020\u0003*\u00020\u00032\u0006\u0010'\u001a\u00020\u0003¢\u0006\u0004\b(\u0010$\u001a\u0019\u0010(\u001a\u00020\u0003*\u00020\u00032\u0006\u0010'\u001a\u00020\u0000¢\u0006\u0004\b(\u0010)\u001a\u0019\u0010*\u001a\u00020\u0003*\u00020\u00032\u0006\u0010'\u001a\u00020\u0003¢\u0006\u0004\b*\u0010$\u001a\u0019\u0010*\u001a\u00020\u0003*\u00020\u00032\u0006\u0010'\u001a\u00020\u0000¢\u0006\u0004\b*\u0010)\u001a\u0019\u0010+\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b+\u0010\u0019\u001a\u0019\u0010+\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0000¢\u0006\u0004\b+\u0010\u001a\u001a\u0019\u0010,\u001a\u00020\u0000*\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003¢\u0006\u0004\b,\u0010-\u001a\u001d\u0010.\u001a\u0004\u0018\u00010\u0000*\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0002¢\u0006\u0004\b.\u0010-\"\u0015\u00101\u001a\u00020\u0000*\u00020\u00038G¢\u0006\u0006\u001a\u0004\b/\u00100\"\u0015\u00103\u001a\u00020\u0000*\u00020\u00038G¢\u0006\u0006\u001a\u0004\b2\u00100\"\u0015\u00105\u001a\u00020\u0000*\u00020\u00038G¢\u0006\u0006\u001a\u0004\b4\u00100"}, d2 = {"", "prefix", "suffix", "Ljava/io/File;", "directory", "createTempDir", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;", "createTempFile", "target", "", "overwrite", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "copyRecursively", "(Ljava/io/File;Ljava/io/File;ZLkotlin/jvm/functions/Function2;)Z", "", "bufferSize", "copyTo", "(Ljava/io/File;Ljava/io/File;ZI)Ljava/io/File;", "deleteRecursively", "(Ljava/io/File;)Z", "other", "endsWith", "(Ljava/io/File;Ljava/io/File;)Z", "(Ljava/io/File;Ljava/lang/String;)Z", "normalize", "(Ljava/io/File;)Ljava/io/File;", "", "normalize$FilesKt__UtilsKt", "(Ljava/util/List;)Ljava/util/List;", "Lkotlin/io/FilePathComponents;", "(Lkotlin/io/FilePathComponents;)Lkotlin/io/FilePathComponents;", "base", "relativeTo", "(Ljava/io/File;Ljava/io/File;)Ljava/io/File;", "relativeToOrNull", "relativeToOrSelf", BoxData.LAYOUT_RELATIVE, "resolve", "(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;", "resolveSibling", "startsWith", "toRelativeString", "(Ljava/io/File;Ljava/io/File;)Ljava/lang/String;", "toRelativeStringOrNull$FilesKt__UtilsKt", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", ExtHubMetaInfoParser.KEY_EXTENSION_INFO, "getInvariantSeparatorsPath", "invariantSeparatorsPath", "getNameWithoutExtension", "nameWithoutExtension"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/io/FilesKt")
/* loaded from: classes3.dex */
public class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    public static /* synthetic */ File createTempDir$default(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "tmp";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return FilesKt.createTempDir(str, str2, file);
    }

    @Deprecated(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    public static final File createTempDir(String str, String str2, File file) {
        Intrinsics.checkNotNullParameter(str, "");
        File createTempFile = File.createTempFile(str, str2, file);
        createTempFile.delete();
        if (createTempFile.mkdir()) {
            Intrinsics.checkNotNullExpressionValue(createTempFile, "");
            return createTempFile;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to create temporary directory ");
        sb.append(createTempFile);
        sb.append('.');
        throw new IOException(sb.toString());
    }

    public static /* synthetic */ File createTempFile$default(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "tmp";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return FilesKt.createTempFile(str, str2, file);
    }

    @Deprecated(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    public static final File createTempFile(String str, String str2, File file) {
        Intrinsics.checkNotNullParameter(str, "");
        File createTempFile = File.createTempFile(str, str2, file);
        Intrinsics.checkNotNullExpressionValue(createTempFile, "");
        return createTempFile;
    }

    @JvmName(name = "getExtension")
    public static final String getExtension(File file) {
        Intrinsics.checkNotNullParameter(file, "");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "");
        return StringsKt.substringAfterLast(name, '.', "");
    }

    @JvmName(name = "getInvariantSeparatorsPath")
    public static final String getInvariantSeparatorsPath(File file) {
        Intrinsics.checkNotNullParameter(file, "");
        if (File.separatorChar != '/') {
            String path = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "");
            return StringsKt.replace$default(path, File.separatorChar, '/', false, 4, (Object) null);
        }
        String path2 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "");
        return path2;
    }

    @JvmName(name = "getNameWithoutExtension")
    public static final String getNameWithoutExtension(File file) {
        Intrinsics.checkNotNullParameter(file, "");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "");
        return StringsKt.substringBeforeLast$default(name, ".", (String) null, 2, (Object) null);
    }

    public static final String toRelativeString(File file, File file2) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(file2, "");
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, file2);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            return relativeStringOrNull$FilesKt__UtilsKt;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("this and base files have different roots: ");
        sb.append(file);
        sb.append(" and ");
        sb.append(file2);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }

    public static final File relativeTo(File file, File file2) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(file2, "");
        return new File(FilesKt.toRelativeString(file, file2));
    }

    public static final File relativeToOrSelf(File file, File file2) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(file2, "");
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, file2);
        return relativeStringOrNull$FilesKt__UtilsKt != null ? new File(relativeStringOrNull$FilesKt__UtilsKt) : file;
    }

    public static final File relativeToOrNull(File file, File file2) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(file2, "");
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, file2);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            return new File(relativeStringOrNull$FilesKt__UtilsKt);
        }
        return null;
    }

    private static final String toRelativeStringOrNull$FilesKt__UtilsKt(File file, File file2) {
        FilePathComponents normalize$FilesKt__UtilsKt = normalize$FilesKt__UtilsKt(FilesKt.toComponents(file));
        FilePathComponents normalize$FilesKt__UtilsKt2 = normalize$FilesKt__UtilsKt(FilesKt.toComponents(file2));
        if (Intrinsics.areEqual(normalize$FilesKt__UtilsKt.getRoot(), normalize$FilesKt__UtilsKt2.getRoot())) {
            int size = normalize$FilesKt__UtilsKt2.getSize();
            int size2 = normalize$FilesKt__UtilsKt.getSize();
            int i = 0;
            int min = Math.min(size2, size);
            while (i < min && Intrinsics.areEqual(normalize$FilesKt__UtilsKt.getSegments().get(i), normalize$FilesKt__UtilsKt2.getSegments().get(i))) {
                i++;
            }
            StringBuilder sb = new StringBuilder();
            int i2 = size - 1;
            if (i <= i2) {
                while (!Intrinsics.areEqual(normalize$FilesKt__UtilsKt2.getSegments().get(i2).getName(), "..")) {
                    sb.append("..");
                    if (i2 != i) {
                        sb.append(File.separatorChar);
                    }
                    if (i2 != i) {
                        i2--;
                    }
                }
                return null;
            }
            if (i < size2) {
                if (i < size) {
                    sb.append(File.separatorChar);
                }
                String str = File.separator;
                Intrinsics.checkNotNullExpressionValue(str, "");
                CollectionsKt.joinTo$default(CollectionsKt.drop(normalize$FilesKt__UtilsKt.getSegments(), i), sb, str, null, null, 0, null, null, 124, null);
            }
            return sb.toString();
        }
        return null;
    }

    public static /* synthetic */ File copyTo$default(File file, File file2, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 8192;
        }
        return FilesKt.copyTo(file, file2, z, i);
    }

    public static final File copyTo(File file, File file2, boolean z, int i) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(file2, "");
        if (!file.exists()) {
            throw new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null);
        }
        if (file2.exists()) {
            if (!z) {
                throw new FileAlreadyExistsException(file, file2, "The destination file already exists.");
            }
            if (!file2.delete()) {
                throw new FileAlreadyExistsException(file, file2, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (file.isDirectory()) {
            if (!file2.mkdirs()) {
                throw new FileSystemException(file, file2, "Failed to create target directory.");
            }
        } else {
            File parentFile = file2.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileOutputStream fileInputStream = new FileInputStream(file);
            try {
                FileInputStream fileInputStream2 = fileInputStream;
                fileInputStream = new FileOutputStream(file2);
                try {
                    ByteStreamsKt.copyTo(fileInputStream2, fileInputStream, i);
                    CloseableKt.closeFinally(fileInputStream, null);
                    CloseableKt.closeFinally(fileInputStream, null);
                } finally {
                }
            } finally {
            }
        }
        return file2;
    }

    public static /* synthetic */ boolean copyRecursively$default(File file, File file2, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function2 = new Function2() { // from class: kotlin.io.FilesKt__UtilsKt$copyRecursively$1
                @Override // kotlin.jvm.functions.Function2
                public final Void invoke(File file3, IOException iOException) {
                    Intrinsics.checkNotNullParameter(file3, "");
                    Intrinsics.checkNotNullParameter(iOException, "");
                    throw iOException;
                }
            };
        }
        return FilesKt.copyRecursively(file, file2, z, function2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0093, code lost:
    
        if (r5.delete() == false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00aa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean copyRecursively(java.io.File r11, java.io.File r12, boolean r13, final kotlin.jvm.functions.Function2<? super java.io.File, ? super java.io.IOException, ? extends kotlin.io.OnErrorAction> r14) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            boolean r0 = r11.exists()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L2a
            kotlin.io.NoSuchFileException r12 = new kotlin.io.NoSuchFileException
            r5 = 0
            r7 = 2
            r8 = 0
            java.lang.String r6 = "The source file doesn't exist."
            r3 = r12
            r4 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            java.lang.Object r11 = r14.invoke(r11, r12)
            kotlin.io.OnErrorAction r12 = kotlin.io.OnErrorAction.TERMINATE
            if (r11 == r12) goto L28
            goto L29
        L28:
            r1 = 0
        L29:
            return r1
        L2a:
            kotlin.io.FileTreeWalk r0 = kotlin.io.FilesKt.walkTopDown(r11)     // Catch: kotlin.io.TerminateException -> Lda
            kotlin.io.FilesKt__UtilsKt$copyRecursively$2 r3 = new kotlin.io.FilesKt__UtilsKt$copyRecursively$2     // Catch: kotlin.io.TerminateException -> Lda
            r3.<init>()     // Catch: kotlin.io.TerminateException -> Lda
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3     // Catch: kotlin.io.TerminateException -> Lda
            kotlin.io.FileTreeWalk r0 = r0.onFail(r3)     // Catch: kotlin.io.TerminateException -> Lda
            java.util.Iterator r0 = r0.iterator()     // Catch: kotlin.io.TerminateException -> Lda
        L3d:
            boolean r3 = r0.hasNext()     // Catch: kotlin.io.TerminateException -> Lda
            if (r3 == 0) goto Ld9
            java.lang.Object r3 = r0.next()     // Catch: kotlin.io.TerminateException -> Lda
            java.io.File r3 = (java.io.File) r3     // Catch: kotlin.io.TerminateException -> Lda
            boolean r4 = r3.exists()     // Catch: kotlin.io.TerminateException -> Lda
            if (r4 != 0) goto L64
            kotlin.io.NoSuchFileException r10 = new kotlin.io.NoSuchFileException     // Catch: kotlin.io.TerminateException -> Lda
            r6 = 0
            java.lang.String r7 = "The source file doesn't exist."
            r8 = 2
            r9 = 0
            r4 = r10
            r5 = r3
            r4.<init>(r5, r6, r7, r8, r9)     // Catch: kotlin.io.TerminateException -> Lda
            java.lang.Object r3 = r14.invoke(r3, r10)     // Catch: kotlin.io.TerminateException -> Lda
            kotlin.io.OnErrorAction r4 = kotlin.io.OnErrorAction.TERMINATE     // Catch: kotlin.io.TerminateException -> Lda
            if (r3 != r4) goto L3d
            return r2
        L64:
            java.lang.String r4 = kotlin.io.FilesKt.toRelativeString(r3, r11)     // Catch: kotlin.io.TerminateException -> Lda
            java.io.File r5 = new java.io.File     // Catch: kotlin.io.TerminateException -> Lda
            r5.<init>(r12, r4)     // Catch: kotlin.io.TerminateException -> Lda
            boolean r4 = r5.exists()     // Catch: kotlin.io.TerminateException -> Lda
            if (r4 == 0) goto Laa
            boolean r4 = r3.isDirectory()     // Catch: kotlin.io.TerminateException -> Lda
            if (r4 == 0) goto L7f
            boolean r4 = r5.isDirectory()     // Catch: kotlin.io.TerminateException -> Lda
            if (r4 != 0) goto Laa
        L7f:
            if (r13 != 0) goto L82
            goto L95
        L82:
            boolean r4 = r5.isDirectory()     // Catch: kotlin.io.TerminateException -> Lda
            if (r4 == 0) goto L8f
            boolean r4 = kotlin.io.FilesKt.deleteRecursively(r5)     // Catch: kotlin.io.TerminateException -> Lda
            if (r4 != 0) goto L97
            goto L95
        L8f:
            boolean r4 = r5.delete()     // Catch: kotlin.io.TerminateException -> Lda
            if (r4 != 0) goto L97
        L95:
            r4 = 1
            goto L98
        L97:
            r4 = 0
        L98:
            if (r4 == 0) goto Laa
            kotlin.io.FileAlreadyExistsException r4 = new kotlin.io.FileAlreadyExistsException     // Catch: kotlin.io.TerminateException -> Lda
            java.lang.String r6 = "The destination file already exists."
            r4.<init>(r3, r5, r6)     // Catch: kotlin.io.TerminateException -> Lda
            java.lang.Object r3 = r14.invoke(r5, r4)     // Catch: kotlin.io.TerminateException -> Lda
            kotlin.io.OnErrorAction r4 = kotlin.io.OnErrorAction.TERMINATE     // Catch: kotlin.io.TerminateException -> Lda
            if (r3 != r4) goto L3d
            return r2
        Laa:
            boolean r4 = r3.isDirectory()     // Catch: kotlin.io.TerminateException -> Lda
            if (r4 == 0) goto Lb4
            r5.mkdirs()     // Catch: kotlin.io.TerminateException -> Lda
            goto L3d
        Lb4:
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r3
            r6 = r13
            java.io.File r4 = kotlin.io.FilesKt.copyTo$default(r4, r5, r6, r7, r8, r9)     // Catch: kotlin.io.TerminateException -> Lda
            long r4 = r4.length()     // Catch: kotlin.io.TerminateException -> Lda
            long r6 = r3.length()     // Catch: kotlin.io.TerminateException -> Lda
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L3d
            java.io.IOException r4 = new java.io.IOException     // Catch: kotlin.io.TerminateException -> Lda
            java.lang.String r5 = "Source file wasn't copied completely, length of destination file differs."
            r4.<init>(r5)     // Catch: kotlin.io.TerminateException -> Lda
            java.lang.Object r3 = r14.invoke(r3, r4)     // Catch: kotlin.io.TerminateException -> Lda
            kotlin.io.OnErrorAction r4 = kotlin.io.OnErrorAction.TERMINATE     // Catch: kotlin.io.TerminateException -> Lda
            if (r3 != r4) goto L3d
            return r2
        Ld9:
            return r1
        Lda:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__UtilsKt.copyRecursively(java.io.File, java.io.File, boolean, kotlin.jvm.functions.Function2):boolean");
    }

    public static final boolean deleteRecursively(File file) {
        Intrinsics.checkNotNullParameter(file, "");
        while (true) {
            boolean z = true;
            for (File file2 : FilesKt.walkBottomUp(file)) {
                if (file2.delete() || !file2.exists()) {
                    if (!z) {
                    }
                }
                z = false;
            }
            return z;
        }
    }

    public static final boolean startsWith(File file, File file2) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(file2, "");
        FilePathComponents components = FilesKt.toComponents(file);
        FilePathComponents components2 = FilesKt.toComponents(file2);
        if (Intrinsics.areEqual(components.getRoot(), components2.getRoot()) && components.getSize() >= components2.getSize()) {
            return components.getSegments().subList(0, components2.getSize()).equals(components2.getSegments());
        }
        return false;
    }

    public static final boolean startsWith(File file, String str) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(str, "");
        return FilesKt.startsWith(file, new File(str));
    }

    public static final boolean endsWith(File file, File file2) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(file2, "");
        FilePathComponents components = FilesKt.toComponents(file);
        FilePathComponents components2 = FilesKt.toComponents(file2);
        if (components2.isRooted()) {
            return Intrinsics.areEqual(file, file2);
        }
        int size = components.getSize() - components2.getSize();
        if (size < 0) {
            return false;
        }
        return components.getSegments().subList(size, components.getSize()).equals(components2.getSegments());
    }

    public static final boolean endsWith(File file, String str) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(str, "");
        return FilesKt.endsWith(file, new File(str));
    }

    public static final File normalize(File file) {
        Intrinsics.checkNotNullParameter(file, "");
        FilePathComponents components = FilesKt.toComponents(file);
        File root = components.getRoot();
        List<File> normalize$FilesKt__UtilsKt = normalize$FilesKt__UtilsKt(components.getSegments());
        String str = File.separator;
        Intrinsics.checkNotNullExpressionValue(str, "");
        return FilesKt.resolve(root, CollectionsKt.joinToString$default(normalize$FilesKt__UtilsKt, str, null, null, 0, null, null, 62, null));
    }

    private static final FilePathComponents normalize$FilesKt__UtilsKt(FilePathComponents filePathComponents) {
        return new FilePathComponents(filePathComponents.getRoot(), normalize$FilesKt__UtilsKt(filePathComponents.getSegments()));
    }

    private static final List<File> normalize$FilesKt__UtilsKt(List<? extends File> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (!Intrinsics.areEqual(name, ".")) {
                if (!Intrinsics.areEqual(name, "..")) {
                    arrayList.add(file);
                } else if (arrayList.isEmpty() || Intrinsics.areEqual(((File) CollectionsKt.last((List) arrayList)).getName(), "..")) {
                    arrayList.add(file);
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        return arrayList;
    }

    public static final File resolve(File file, File file2) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(file2, "");
        if (FilesKt.isRooted(file2)) {
            return file2;
        }
        String obj = file.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        String str = obj;
        if ((str.length() == 0) || StringsKt.endsWith$default((CharSequence) str, File.separatorChar, false, 2, (Object) null)) {
            StringBuilder sb = new StringBuilder();
            sb.append(obj);
            sb.append(file2);
            return new File(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(obj);
        sb2.append(File.separatorChar);
        sb2.append(file2);
        return new File(sb2.toString());
    }

    public static final File resolve(File file, String str) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(str, "");
        return FilesKt.resolve(file, new File(str));
    }

    public static final File resolveSibling(File file, File file2) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(file2, "");
        FilePathComponents components = FilesKt.toComponents(file);
        return FilesKt.resolve(FilesKt.resolve(components.getRoot(), components.getSize() == 0 ? new File("..") : components.subPath(0, components.getSize() - 1)), file2);
    }

    public static final File resolveSibling(File file, String str) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(str, "");
        return FilesKt.resolveSibling(file, new File(str));
    }
}
