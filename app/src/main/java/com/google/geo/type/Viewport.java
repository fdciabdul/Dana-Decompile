package com.google.geo.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.type.LatLng;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public final class Viewport extends GeneratedMessageLite<Viewport, Builder> implements ViewportOrBuilder {
    private static final Viewport DEFAULT_INSTANCE;
    public static final int HIGH_FIELD_NUMBER = 2;
    public static final int LOW_FIELD_NUMBER = 1;
    private static volatile Parser<Viewport> PARSER;
    private LatLng high_;
    private LatLng low_;

    private Viewport() {
    }

    @Override // com.google.geo.type.ViewportOrBuilder
    public final boolean hasLow() {
        return this.low_ != null;
    }

    @Override // com.google.geo.type.ViewportOrBuilder
    public final LatLng getLow() {
        LatLng latLng = this.low_;
        return latLng == null ? LatLng.getDefaultInstance() : latLng;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLow(LatLng latLng) {
        this.low_ = latLng;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLow(LatLng latLng) {
        LatLng latLng2 = this.low_;
        if (latLng2 != null && latLng2 != LatLng.getDefaultInstance()) {
            this.low_ = LatLng.newBuilder(this.low_).mergeFrom((LatLng.Builder) latLng).buildPartial();
        } else {
            this.low_ = latLng;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLow() {
        this.low_ = null;
    }

    @Override // com.google.geo.type.ViewportOrBuilder
    public final boolean hasHigh() {
        return this.high_ != null;
    }

    @Override // com.google.geo.type.ViewportOrBuilder
    public final LatLng getHigh() {
        LatLng latLng = this.high_;
        return latLng == null ? LatLng.getDefaultInstance() : latLng;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHigh(LatLng latLng) {
        this.high_ = latLng;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeHigh(LatLng latLng) {
        LatLng latLng2 = this.high_;
        if (latLng2 != null && latLng2 != LatLng.getDefaultInstance()) {
            this.high_ = LatLng.newBuilder(this.high_).mergeFrom((LatLng.Builder) latLng).buildPartial();
        } else {
            this.high_ = latLng;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHigh() {
        this.high_ = null;
    }

    public static Viewport parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Viewport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Viewport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Viewport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Viewport parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Viewport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Viewport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Viewport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Viewport parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Viewport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Viewport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Viewport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Viewport parseFrom(InputStream inputStream) throws IOException {
        return (Viewport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Viewport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Viewport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Viewport parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Viewport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Viewport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Viewport) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Viewport parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Viewport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Viewport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Viewport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Viewport viewport) {
        return DEFAULT_INSTANCE.createBuilder(viewport);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Viewport, Builder> implements ViewportOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(Viewport.DEFAULT_INSTANCE);
        }

        @Override // com.google.geo.type.ViewportOrBuilder
        public final boolean hasLow() {
            return ((Viewport) this.instance).hasLow();
        }

        @Override // com.google.geo.type.ViewportOrBuilder
        public final LatLng getLow() {
            return ((Viewport) this.instance).getLow();
        }

        public final Builder setLow(LatLng latLng) {
            copyOnWrite();
            ((Viewport) this.instance).setLow(latLng);
            return this;
        }

        public final Builder setLow(LatLng.Builder builder) {
            copyOnWrite();
            ((Viewport) this.instance).setLow(builder.build());
            return this;
        }

        public final Builder mergeLow(LatLng latLng) {
            copyOnWrite();
            ((Viewport) this.instance).mergeLow(latLng);
            return this;
        }

        public final Builder clearLow() {
            copyOnWrite();
            ((Viewport) this.instance).clearLow();
            return this;
        }

        @Override // com.google.geo.type.ViewportOrBuilder
        public final boolean hasHigh() {
            return ((Viewport) this.instance).hasHigh();
        }

        @Override // com.google.geo.type.ViewportOrBuilder
        public final LatLng getHigh() {
            return ((Viewport) this.instance).getHigh();
        }

        public final Builder setHigh(LatLng latLng) {
            copyOnWrite();
            ((Viewport) this.instance).setHigh(latLng);
            return this;
        }

        public final Builder setHigh(LatLng.Builder builder) {
            copyOnWrite();
            ((Viewport) this.instance).setHigh(builder.build());
            return this;
        }

        public final Builder mergeHigh(LatLng latLng) {
            copyOnWrite();
            ((Viewport) this.instance).mergeHigh(latLng);
            return this;
        }

        public final Builder clearHigh() {
            copyOnWrite();
            ((Viewport) this.instance).clearHigh();
            return this;
        }
    }

    /* renamed from: com.google.geo.type.Viewport$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser parser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Viewport();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"low_", "high_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Viewport> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (Viewport.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                }
                return parser2;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        Viewport viewport = new Viewport();
        DEFAULT_INSTANCE = viewport;
        GeneratedMessageLite.registerDefaultInstance(Viewport.class, viewport);
    }

    public static Viewport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Viewport> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
