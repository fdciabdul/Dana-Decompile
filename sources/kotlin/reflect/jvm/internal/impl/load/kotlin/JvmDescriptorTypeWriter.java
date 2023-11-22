package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
public class JvmDescriptorTypeWriter<T> {
    private T jvmCurrentType;
    private int jvmCurrentTypeArrayLevel;
    private final JvmTypeFactory<T> jvmTypeFactory;

    public void writeArrayEnd() {
    }

    public void writeArrayType() {
        if (this.jvmCurrentType == null) {
            this.jvmCurrentTypeArrayLevel++;
        }
    }

    public void writeClass(T t) {
        Intrinsics.checkNotNullParameter(t, "");
        writeJvmTypeAsIs(t);
    }

    protected final void writeJvmTypeAsIs(T t) {
        Intrinsics.checkNotNullParameter(t, "");
        if (this.jvmCurrentType == null) {
            if (this.jvmCurrentTypeArrayLevel > 0) {
                JvmTypeFactory<T> jvmTypeFactory = this.jvmTypeFactory;
                StringBuilder sb = new StringBuilder();
                sb.append(StringsKt.repeat("[", this.jvmCurrentTypeArrayLevel));
                sb.append(this.jvmTypeFactory.toString(t));
                t = jvmTypeFactory.createFromString(sb.toString());
            }
            this.jvmCurrentType = t;
        }
    }

    public void writeTypeVariable(Name name, T t) {
        Intrinsics.checkNotNullParameter(name, "");
        Intrinsics.checkNotNullParameter(t, "");
        writeJvmTypeAsIs(t);
    }
}
