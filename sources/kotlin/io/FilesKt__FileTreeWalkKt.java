package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0007"}, d2 = {"Ljava/io/File;", "Lkotlin/io/FileWalkDirection;", "direction", "Lkotlin/io/FileTreeWalk;", "walk", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)Lkotlin/io/FileTreeWalk;", "walkBottomUp", "(Ljava/io/File;)Lkotlin/io/FileTreeWalk;", "walkTopDown"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/io/FilesKt")
/* loaded from: classes3.dex */
class FilesKt__FileTreeWalkKt extends FilesKt__FileReadWriteKt {
    public static /* synthetic */ FileTreeWalk walk$default(File file, FileWalkDirection fileWalkDirection, int i, Object obj) {
        if ((i & 1) != 0) {
            fileWalkDirection = FileWalkDirection.TOP_DOWN;
        }
        return FilesKt.walk(file, fileWalkDirection);
    }

    public static final FileTreeWalk walk(File file, FileWalkDirection fileWalkDirection) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(fileWalkDirection, "");
        return new FileTreeWalk(file, fileWalkDirection);
    }

    public static final FileTreeWalk walkTopDown(File file) {
        Intrinsics.checkNotNullParameter(file, "");
        return FilesKt.walk(file, FileWalkDirection.TOP_DOWN);
    }

    public static final FileTreeWalk walkBottomUp(File file) {
        Intrinsics.checkNotNullParameter(file, "");
        return FilesKt.walk(file, FileWalkDirection.BOTTOM_UP);
    }
}
