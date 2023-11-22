package kotlin.io;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0011\u0010\u001f\u001a\u00020\u00178G¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0019R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\u0007R\u0011\u0010#\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\"\u0010\u0012"}, d2 = {"Lkotlin/io/FilePathComponents;", "", "Ljava/io/File;", "component1", "()Ljava/io/File;", "", "component2", "()Ljava/util/List;", "root", "segments", "copy", "(Ljava/io/File;Ljava/util/List;)Lkotlin/io/FilePathComponents;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "beginIndex", "endIndex", "subPath", "(II)Ljava/io/File;", "", "toString", "()Ljava/lang/String;", "isRooted", "()Z", "Ljava/io/File;", "getRoot", "getRootName", "rootName", "Ljava/util/List;", "getSegments", "getSize", GriverMonitorConstants.KEY_SIZE, "<init>", "(Ljava/io/File;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FilePathComponents {
    private final File root;
    private final List<File> segments;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FilePathComponents copy$default(FilePathComponents filePathComponents, File file, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            file = filePathComponents.root;
        }
        if ((i & 2) != 0) {
            list = filePathComponents.segments;
        }
        return filePathComponents.copy(file, list);
    }

    /* renamed from: component1  reason: from getter */
    public final File getRoot() {
        return this.root;
    }

    public final List<File> component2() {
        return this.segments;
    }

    public final FilePathComponents copy(File root, List<? extends File> segments) {
        Intrinsics.checkNotNullParameter(root, "");
        Intrinsics.checkNotNullParameter(segments, "");
        return new FilePathComponents(root, segments);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FilePathComponents) {
            FilePathComponents filePathComponents = (FilePathComponents) other;
            return Intrinsics.areEqual(this.root, filePathComponents.root) && Intrinsics.areEqual(this.segments, filePathComponents.segments);
        }
        return false;
    }

    public final int hashCode() {
        return (this.root.hashCode() * 31) + this.segments.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FilePathComponents(root=");
        sb.append(this.root);
        sb.append(", segments=");
        sb.append(this.segments);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FilePathComponents(File file, List<? extends File> list) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.root = file;
        this.segments = list;
    }

    @JvmName(name = "getRoot")
    public final File getRoot() {
        return this.root;
    }

    @JvmName(name = "getSegments")
    public final List<File> getSegments() {
        return this.segments;
    }

    @JvmName(name = "getRootName")
    public final String getRootName() {
        String path = this.root.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "");
        return path;
    }

    @JvmName(name = "isRooted")
    public final boolean isRooted() {
        String path = this.root.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "");
        return path.length() > 0;
    }

    @JvmName(name = "getSize")
    public final int getSize() {
        return this.segments.size();
    }

    public final File subPath(int beginIndex, int endIndex) {
        if (beginIndex < 0 || beginIndex > endIndex || endIndex > getSize()) {
            throw new IllegalArgumentException();
        }
        List<File> subList = this.segments.subList(beginIndex, endIndex);
        String str = File.separator;
        Intrinsics.checkNotNullExpressionValue(str, "");
        return new File(CollectionsKt.joinToString$default(subList, str, null, null, 0, null, null, 62, null));
    }
}
