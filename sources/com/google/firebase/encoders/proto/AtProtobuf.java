package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.proto.Protobuf;
import java.lang.annotation.Annotation;

/* loaded from: classes7.dex */
public final class AtProtobuf {
    private Protobuf.IntEncoding intEncoding = Protobuf.IntEncoding.DEFAULT;
    private int tag;

    public final AtProtobuf tag(int i) {
        this.tag = i;
        return this;
    }

    public final AtProtobuf intEncoding(Protobuf.IntEncoding intEncoding) {
        this.intEncoding = intEncoding;
        return this;
    }

    public static AtProtobuf builder() {
        return new AtProtobuf();
    }

    public final Protobuf build() {
        return new ProtobufImpl(this.tag, this.intEncoding);
    }

    /* loaded from: classes7.dex */
    static final class ProtobufImpl implements Protobuf {
        private final Protobuf.IntEncoding intEncoding;
        private final int tag;

        ProtobufImpl(int i, Protobuf.IntEncoding intEncoding) {
            this.tag = i;
            this.intEncoding = intEncoding;
        }

        @Override // java.lang.annotation.Annotation
        public final Class<? extends Annotation> annotationType() {
            return Protobuf.class;
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public final int tag() {
            return this.tag;
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public final Protobuf.IntEncoding intEncoding() {
            return this.intEncoding;
        }

        @Override // java.lang.annotation.Annotation
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Protobuf) {
                Protobuf protobuf = (Protobuf) obj;
                return this.tag == protobuf.tag() && this.intEncoding.equals(protobuf.intEncoding());
            }
            return false;
        }

        @Override // java.lang.annotation.Annotation
        public final int hashCode() {
            return (this.tag ^ 14552422) + (this.intEncoding.hashCode() ^ 2041407134);
        }

        @Override // java.lang.annotation.Annotation
        public final String toString() {
            StringBuilder sb = new StringBuilder("@com.google.firebase.encoders.proto.Protobuf");
            sb.append('(');
            sb.append("tag=");
            sb.append(this.tag);
            sb.append("intEncoding=");
            sb.append(this.intEncoding);
            sb.append(')');
            return sb.toString();
        }
    }
}
