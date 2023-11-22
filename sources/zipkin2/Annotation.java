package zipkin2;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/* loaded from: classes6.dex */
public final class Annotation implements Comparable<Annotation>, Serializable {
    private static final long serialVersionUID = 0;
    final long timestamp;
    final String value;

    public static Annotation create(long j, String str) {
        if (str == null) {
            throw new NullPointerException("value == null");
        }
        return new Annotation(j, str);
    }

    public final long timestamp() {
        return this.timestamp;
    }

    public final String value() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Annotation annotation) {
        int i = 0;
        if (this == annotation) {
            return 0;
        }
        if (timestamp() < annotation.timestamp()) {
            i = -1;
        } else if (timestamp() != annotation.timestamp()) {
            i = 1;
        }
        return i != 0 ? i : value().compareTo(annotation.value());
    }

    Annotation(long j, String str) {
        this.timestamp = j;
        this.value = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Annotation{timestamp=");
        sb.append(this.timestamp);
        sb.append(", value=");
        sb.append(this.value);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Annotation) {
            Annotation annotation = (Annotation) obj;
            return this.timestamp == annotation.timestamp() && this.value.equals(annotation.value());
        }
        return false;
    }

    public final int hashCode() {
        long j = this.timestamp;
        return this.value.hashCode() ^ ((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003);
    }

    final Object writeReplace() throws ObjectStreamException {
        return new SerializedForm(this);
    }

    /* loaded from: classes9.dex */
    static final class SerializedForm implements Serializable {
        static final long serialVersionUID = 0;
        final long timestamp;
        final String value;

        SerializedForm(Annotation annotation) {
            this.timestamp = annotation.timestamp;
            this.value = annotation.value;
        }

        final Object readResolve() throws ObjectStreamException {
            try {
                return Annotation.create(this.timestamp, this.value);
            } catch (IllegalArgumentException e) {
                throw new StreamCorruptedException(e.getMessage());
            }
        }
    }
}
