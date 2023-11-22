package kotlin.reflect.jvm.internal.impl.descriptors;

/* loaded from: classes.dex */
public interface SourceFile {
    public static final SourceFile NO_SOURCE_FILE = new SourceFile() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.SourceFile.1
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceFile
        public final String getName() {
            return null;
        }
    };

    String getName();
}
