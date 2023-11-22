package io.opentelemetry.instrumentation.api.instrumenter.util;

/* loaded from: classes9.dex */
final class AutoValue_ClassAndMethod extends ClassAndMethod {
    private final Class<?> declaringClass;
    private final String methodName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ClassAndMethod(Class<?> cls, String str) {
        if (cls == null) {
            throw new NullPointerException("Null declaringClass");
        }
        this.declaringClass = cls;
        if (str == null) {
            throw new NullPointerException("Null methodName");
        }
        this.methodName = str;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.util.ClassAndMethod
    public final Class<?> declaringClass() {
        return this.declaringClass;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.util.ClassAndMethod
    public final String methodName() {
        return this.methodName;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ClassAndMethod{declaringClass=");
        sb.append(this.declaringClass);
        sb.append(", methodName=");
        sb.append(this.methodName);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ClassAndMethod) {
            ClassAndMethod classAndMethod = (ClassAndMethod) obj;
            return this.declaringClass.equals(classAndMethod.declaringClass()) && this.methodName.equals(classAndMethod.methodName());
        }
        return false;
    }

    public final int hashCode() {
        return ((this.declaringClass.hashCode() ^ 1000003) * 1000003) ^ this.methodName.hashCode();
    }
}
