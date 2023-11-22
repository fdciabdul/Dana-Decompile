package kotlin.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a#\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\u0004H\u0000¢\u0006\u0004\b\n\u0010\u000b\"\u0015\u0010\r\u001a\u00020\f*\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0018\u0010\u0011\u001a\u00020\u0004*\u00020\u00048AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0018\u0010\u0014\u001a\u00020\u0000*\u00020\u00048AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013"}, d2 = {"", "", "getRootLength$FilesKt__FilePathComponentsKt", "(Ljava/lang/String;)I", "Ljava/io/File;", "beginIndex", "endIndex", "subPath", "(Ljava/io/File;II)Ljava/io/File;", "Lkotlin/io/FilePathComponents;", "toComponents", "(Ljava/io/File;)Lkotlin/io/FilePathComponents;", "", "isRooted", "(Ljava/io/File;)Z", "getRoot", "(Ljava/io/File;)Ljava/io/File;", "root", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "rootName"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/io/FilesKt")
/* loaded from: classes3.dex */
public class FilesKt__FilePathComponentsKt {
    private static final int getRootLength$FilesKt__FilePathComponentsKt(String str) {
        int indexOf$default;
        String str2 = str;
        int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str2, File.separatorChar, 0, false, 4, (Object) null);
        if (indexOf$default2 == 0) {
            if (str.length() <= 1 || str.charAt(1) != File.separatorChar || (indexOf$default = StringsKt.indexOf$default((CharSequence) str2, File.separatorChar, 2, false, 4, (Object) null)) < 0) {
                return 1;
            }
            int indexOf$default3 = StringsKt.indexOf$default((CharSequence) str2, File.separatorChar, indexOf$default + 1, false, 4, (Object) null);
            return indexOf$default3 >= 0 ? indexOf$default3 + 1 : str.length();
        } else if (indexOf$default2 <= 0 || str.charAt(indexOf$default2 - 1) != ':') {
            if (indexOf$default2 == -1 && StringsKt.endsWith$default((CharSequence) str2, ':', false, 2, (Object) null)) {
                return str.length();
            }
            return 0;
        } else {
            return indexOf$default2 + 1;
        }
    }

    @JvmName(name = "getRootName")
    public static final String getRootName(File file) {
        Intrinsics.checkNotNullParameter(file, "");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "");
        String path2 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "");
        String substring = path.substring(0, getRootLength$FilesKt__FilePathComponentsKt(path2));
        Intrinsics.checkNotNullExpressionValue(substring, "");
        return substring;
    }

    @JvmName(name = "getRoot")
    public static final File getRoot(File file) {
        Intrinsics.checkNotNullParameter(file, "");
        return new File(FilesKt.getRootName(file));
    }

    @JvmName(name = "isRooted")
    public static final boolean isRooted(File file) {
        Intrinsics.checkNotNullParameter(file, "");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "");
        return getRootLength$FilesKt__FilePathComponentsKt(path) > 0;
    }

    public static final FilePathComponents toComponents(File file) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(file, "");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "");
        int rootLength$FilesKt__FilePathComponentsKt = getRootLength$FilesKt__FilePathComponentsKt(path);
        String substring = path.substring(0, rootLength$FilesKt__FilePathComponentsKt);
        Intrinsics.checkNotNullExpressionValue(substring, "");
        String substring2 = path.substring(rootLength$FilesKt__FilePathComponentsKt);
        Intrinsics.checkNotNullExpressionValue(substring2, "");
        String str = substring2;
        if (str.length() == 0) {
            arrayList = CollectionsKt.emptyList();
        } else {
            List split$default = StringsKt.split$default((CharSequence) str, new char[]{File.separatorChar}, false, 0, 6, (Object) null);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                arrayList2.add(new File((String) it.next()));
            }
            arrayList = arrayList2;
        }
        return new FilePathComponents(new File(substring), arrayList);
    }

    public static final File subPath(File file, int i, int i2) {
        Intrinsics.checkNotNullParameter(file, "");
        return FilesKt.toComponents(file).subPath(i, i2);
    }
}
