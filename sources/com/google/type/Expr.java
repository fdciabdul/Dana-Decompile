package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public final class Expr extends GeneratedMessageLite<Expr, Builder> implements ExprOrBuilder {
    private static final Expr DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int EXPRESSION_FIELD_NUMBER = 1;
    public static final int LOCATION_FIELD_NUMBER = 4;
    private static volatile Parser<Expr> PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 2;
    private String expression_ = "";
    private String title_ = "";
    private String description_ = "";
    private String location_ = "";

    private Expr() {
    }

    @Override // com.google.type.ExprOrBuilder
    public final String getExpression() {
        return this.expression_;
    }

    @Override // com.google.type.ExprOrBuilder
    public final ByteString getExpressionBytes() {
        return ByteString.copyFromUtf8(this.expression_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExpression(String str) {
        this.expression_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExpression() {
        this.expression_ = getDefaultInstance().getExpression();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExpressionBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.expression_ = byteString.toStringUtf8();
    }

    @Override // com.google.type.ExprOrBuilder
    public final String getTitle() {
        return this.title_;
    }

    @Override // com.google.type.ExprOrBuilder
    public final ByteString getTitleBytes() {
        return ByteString.copyFromUtf8(this.title_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitle(String str) {
        this.title_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitleBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.title_ = byteString.toStringUtf8();
    }

    @Override // com.google.type.ExprOrBuilder
    public final String getDescription() {
        return this.description_;
    }

    @Override // com.google.type.ExprOrBuilder
    public final ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescription(String str) {
        this.description_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescriptionBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.description_ = byteString.toStringUtf8();
    }

    @Override // com.google.type.ExprOrBuilder
    public final String getLocation() {
        return this.location_;
    }

    @Override // com.google.type.ExprOrBuilder
    public final ByteString getLocationBytes() {
        return ByteString.copyFromUtf8(this.location_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocation(String str) {
        this.location_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLocation() {
        this.location_ = getDefaultInstance().getLocation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocationBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.location_ = byteString.toStringUtf8();
    }

    public static Expr parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Expr) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Expr parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Expr) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Expr parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Expr) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Expr parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Expr) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Expr parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Expr) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Expr parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Expr) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Expr parseFrom(InputStream inputStream) throws IOException {
        return (Expr) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Expr parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Expr) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Expr parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Expr) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Expr parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Expr) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Expr parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Expr) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Expr parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Expr) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Expr expr) {
        return DEFAULT_INSTANCE.createBuilder(expr);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Expr, Builder> implements ExprOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(Expr.DEFAULT_INSTANCE);
        }

        @Override // com.google.type.ExprOrBuilder
        public final String getExpression() {
            return ((Expr) this.instance).getExpression();
        }

        @Override // com.google.type.ExprOrBuilder
        public final ByteString getExpressionBytes() {
            return ((Expr) this.instance).getExpressionBytes();
        }

        public final Builder setExpression(String str) {
            copyOnWrite();
            ((Expr) this.instance).setExpression(str);
            return this;
        }

        public final Builder clearExpression() {
            copyOnWrite();
            ((Expr) this.instance).clearExpression();
            return this;
        }

        public final Builder setExpressionBytes(ByteString byteString) {
            copyOnWrite();
            ((Expr) this.instance).setExpressionBytes(byteString);
            return this;
        }

        @Override // com.google.type.ExprOrBuilder
        public final String getTitle() {
            return ((Expr) this.instance).getTitle();
        }

        @Override // com.google.type.ExprOrBuilder
        public final ByteString getTitleBytes() {
            return ((Expr) this.instance).getTitleBytes();
        }

        public final Builder setTitle(String str) {
            copyOnWrite();
            ((Expr) this.instance).setTitle(str);
            return this;
        }

        public final Builder clearTitle() {
            copyOnWrite();
            ((Expr) this.instance).clearTitle();
            return this;
        }

        public final Builder setTitleBytes(ByteString byteString) {
            copyOnWrite();
            ((Expr) this.instance).setTitleBytes(byteString);
            return this;
        }

        @Override // com.google.type.ExprOrBuilder
        public final String getDescription() {
            return ((Expr) this.instance).getDescription();
        }

        @Override // com.google.type.ExprOrBuilder
        public final ByteString getDescriptionBytes() {
            return ((Expr) this.instance).getDescriptionBytes();
        }

        public final Builder setDescription(String str) {
            copyOnWrite();
            ((Expr) this.instance).setDescription(str);
            return this;
        }

        public final Builder clearDescription() {
            copyOnWrite();
            ((Expr) this.instance).clearDescription();
            return this;
        }

        public final Builder setDescriptionBytes(ByteString byteString) {
            copyOnWrite();
            ((Expr) this.instance).setDescriptionBytes(byteString);
            return this;
        }

        @Override // com.google.type.ExprOrBuilder
        public final String getLocation() {
            return ((Expr) this.instance).getLocation();
        }

        @Override // com.google.type.ExprOrBuilder
        public final ByteString getLocationBytes() {
            return ((Expr) this.instance).getLocationBytes();
        }

        public final Builder setLocation(String str) {
            copyOnWrite();
            ((Expr) this.instance).setLocation(str);
            return this;
        }

        public final Builder clearLocation() {
            copyOnWrite();
            ((Expr) this.instance).clearLocation();
            return this;
        }

        public final Builder setLocationBytes(ByteString byteString) {
            copyOnWrite();
            ((Expr) this.instance).setLocationBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.type.Expr$1  reason: invalid class name */
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
                return new Expr();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ", new Object[]{"expression_", "title_", "description_", "location_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Expr> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (Expr.class) {
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
        Expr expr = new Expr();
        DEFAULT_INSTANCE = expr;
        GeneratedMessageLite.registerDefaultInstance(Expr.class, expr);
    }

    public static Expr getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Expr> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
