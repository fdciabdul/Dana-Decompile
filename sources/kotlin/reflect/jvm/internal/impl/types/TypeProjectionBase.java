package kotlin.reflect.jvm.internal.impl.types;

/* loaded from: classes.dex */
public abstract class TypeProjectionBase implements TypeProjection {
    public String toString() {
        if (isStarProjection()) {
            return "*";
        }
        if (getProjectionKind() == Variance.INVARIANT) {
            return getType().toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getProjectionKind());
        sb.append(" ");
        sb.append(getType());
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TypeProjection) {
            TypeProjection typeProjection = (TypeProjection) obj;
            return isStarProjection() == typeProjection.isStarProjection() && getProjectionKind() == typeProjection.getProjectionKind() && getType().equals(typeProjection.getType());
        }
        return false;
    }

    public int hashCode() {
        int hashCode = getProjectionKind().hashCode();
        if (TypeUtils.noExpectedType(getType())) {
            return (hashCode * 31) + 19;
        }
        return (hashCode * 31) + (isStarProjection() ? 17 : getType().hashCode());
    }
}
