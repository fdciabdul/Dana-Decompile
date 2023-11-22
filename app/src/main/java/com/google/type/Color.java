package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FloatValue;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public final class Color extends GeneratedMessageLite<Color, Builder> implements ColorOrBuilder {
    public static final int ALPHA_FIELD_NUMBER = 4;
    public static final int BLUE_FIELD_NUMBER = 3;
    private static final Color DEFAULT_INSTANCE;
    public static final int GREEN_FIELD_NUMBER = 2;
    private static volatile Parser<Color> PARSER = null;
    public static final int RED_FIELD_NUMBER = 1;
    private FloatValue alpha_;
    private float blue_;
    private float green_;
    private float red_;

    private Color() {
    }

    @Override // com.google.type.ColorOrBuilder
    public final float getRed() {
        return this.red_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRed(float f) {
        this.red_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRed() {
        this.red_ = 0.0f;
    }

    @Override // com.google.type.ColorOrBuilder
    public final float getGreen() {
        return this.green_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGreen(float f) {
        this.green_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGreen() {
        this.green_ = 0.0f;
    }

    @Override // com.google.type.ColorOrBuilder
    public final float getBlue() {
        return this.blue_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBlue(float f) {
        this.blue_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBlue() {
        this.blue_ = 0.0f;
    }

    @Override // com.google.type.ColorOrBuilder
    public final boolean hasAlpha() {
        return this.alpha_ != null;
    }

    @Override // com.google.type.ColorOrBuilder
    public final FloatValue getAlpha() {
        FloatValue floatValue = this.alpha_;
        return floatValue == null ? FloatValue.getDefaultInstance() : floatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlpha(FloatValue floatValue) {
        this.alpha_ = floatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAlpha(FloatValue floatValue) {
        FloatValue floatValue2 = this.alpha_;
        if (floatValue2 != null && floatValue2 != FloatValue.getDefaultInstance()) {
            this.alpha_ = FloatValue.newBuilder(this.alpha_).mergeFrom((FloatValue.Builder) floatValue).buildPartial();
        } else {
            this.alpha_ = floatValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAlpha() {
        this.alpha_ = null;
    }

    public static Color parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Color parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Color parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Color parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Color parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Color parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Color parseFrom(InputStream inputStream) throws IOException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Color parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Color parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Color) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Color parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Color) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Color parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Color parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Color color) {
        return DEFAULT_INSTANCE.createBuilder(color);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Color, Builder> implements ColorOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(Color.DEFAULT_INSTANCE);
        }

        @Override // com.google.type.ColorOrBuilder
        public final float getRed() {
            return ((Color) this.instance).getRed();
        }

        public final Builder setRed(float f) {
            copyOnWrite();
            ((Color) this.instance).setRed(f);
            return this;
        }

        public final Builder clearRed() {
            copyOnWrite();
            ((Color) this.instance).clearRed();
            return this;
        }

        @Override // com.google.type.ColorOrBuilder
        public final float getGreen() {
            return ((Color) this.instance).getGreen();
        }

        public final Builder setGreen(float f) {
            copyOnWrite();
            ((Color) this.instance).setGreen(f);
            return this;
        }

        public final Builder clearGreen() {
            copyOnWrite();
            ((Color) this.instance).clearGreen();
            return this;
        }

        @Override // com.google.type.ColorOrBuilder
        public final float getBlue() {
            return ((Color) this.instance).getBlue();
        }

        public final Builder setBlue(float f) {
            copyOnWrite();
            ((Color) this.instance).setBlue(f);
            return this;
        }

        public final Builder clearBlue() {
            copyOnWrite();
            ((Color) this.instance).clearBlue();
            return this;
        }

        @Override // com.google.type.ColorOrBuilder
        public final boolean hasAlpha() {
            return ((Color) this.instance).hasAlpha();
        }

        @Override // com.google.type.ColorOrBuilder
        public final FloatValue getAlpha() {
            return ((Color) this.instance).getAlpha();
        }

        public final Builder setAlpha(FloatValue floatValue) {
            copyOnWrite();
            ((Color) this.instance).setAlpha(floatValue);
            return this;
        }

        public final Builder setAlpha(FloatValue.Builder builder) {
            copyOnWrite();
            ((Color) this.instance).setAlpha(builder.build());
            return this;
        }

        public final Builder mergeAlpha(FloatValue floatValue) {
            copyOnWrite();
            ((Color) this.instance).mergeAlpha(floatValue);
            return this;
        }

        public final Builder clearAlpha() {
            copyOnWrite();
            ((Color) this.instance).clearAlpha();
            return this;
        }
    }

    /* renamed from: com.google.type.Color$1  reason: invalid class name */
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
                return new Color();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0001\u0002\u0001\u0003\u0001\u0004\t", new Object[]{"red_", "green_", "blue_", "alpha_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Color> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (Color.class) {
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
        Color color = new Color();
        DEFAULT_INSTANCE = color;
        GeneratedMessageLite.registerDefaultInstance(Color.class, color);
    }

    public static Color getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Color> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
