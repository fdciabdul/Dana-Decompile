package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes7.dex */
public final class Endpoint extends GeneratedMessageLite<Endpoint, Builder> implements EndpointOrBuilder {
    public static final int ALIASES_FIELD_NUMBER = 2;
    public static final int ALLOW_CORS_FIELD_NUMBER = 5;
    private static final Endpoint DEFAULT_INSTANCE;
    public static final int FEATURES_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Endpoint> PARSER = null;
    public static final int TARGET_FIELD_NUMBER = 101;
    private boolean allowCors_;
    private String name_ = "";
    private Internal.ProtobufList<String> aliases_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<String> features_ = GeneratedMessageLite.emptyProtobufList();
    private String target_ = "";

    private Endpoint() {
    }

    @Override // com.google.api.EndpointOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.api.EndpointOrBuilder
    public final ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.EndpointOrBuilder
    @Deprecated
    public final List<String> getAliasesList() {
        return this.aliases_;
    }

    @Override // com.google.api.EndpointOrBuilder
    @Deprecated
    public final int getAliasesCount() {
        return this.aliases_.size();
    }

    @Override // com.google.api.EndpointOrBuilder
    @Deprecated
    public final String getAliases(int i) {
        return this.aliases_.get(i);
    }

    @Override // com.google.api.EndpointOrBuilder
    @Deprecated
    public final ByteString getAliasesBytes(int i) {
        return ByteString.copyFromUtf8(this.aliases_.get(i));
    }

    private void ensureAliasesIsMutable() {
        Internal.ProtobufList<String> protobufList = this.aliases_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.aliases_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAliases(int i, String str) {
        ensureAliasesIsMutable();
        this.aliases_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAliases(String str) {
        ensureAliasesIsMutable();
        this.aliases_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAliases(Iterable<String> iterable) {
        ensureAliasesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.aliases_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAliases() {
        this.aliases_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAliasesBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        ensureAliasesIsMutable();
        this.aliases_.add(byteString.toStringUtf8());
    }

    @Override // com.google.api.EndpointOrBuilder
    public final List<String> getFeaturesList() {
        return this.features_;
    }

    @Override // com.google.api.EndpointOrBuilder
    public final int getFeaturesCount() {
        return this.features_.size();
    }

    @Override // com.google.api.EndpointOrBuilder
    public final String getFeatures(int i) {
        return this.features_.get(i);
    }

    @Override // com.google.api.EndpointOrBuilder
    public final ByteString getFeaturesBytes(int i) {
        return ByteString.copyFromUtf8(this.features_.get(i));
    }

    private void ensureFeaturesIsMutable() {
        Internal.ProtobufList<String> protobufList = this.features_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.features_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFeatures(int i, String str) {
        ensureFeaturesIsMutable();
        this.features_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFeatures(String str) {
        ensureFeaturesIsMutable();
        this.features_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllFeatures(Iterable<String> iterable) {
        ensureFeaturesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.features_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFeatures() {
        this.features_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFeaturesBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        ensureFeaturesIsMutable();
        this.features_.add(byteString.toStringUtf8());
    }

    @Override // com.google.api.EndpointOrBuilder
    public final String getTarget() {
        return this.target_;
    }

    @Override // com.google.api.EndpointOrBuilder
    public final ByteString getTargetBytes() {
        return ByteString.copyFromUtf8(this.target_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTarget(String str) {
        this.target_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTarget() {
        this.target_ = getDefaultInstance().getTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.target_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.EndpointOrBuilder
    public final boolean getAllowCors() {
        return this.allowCors_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAllowCors(boolean z) {
        this.allowCors_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAllowCors() {
        this.allowCors_ = false;
    }

    public static Endpoint parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Endpoint parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Endpoint parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Endpoint parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Endpoint parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Endpoint parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Endpoint parseFrom(InputStream inputStream) throws IOException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Endpoint parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Endpoint parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Endpoint) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Endpoint parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Endpoint) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Endpoint parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Endpoint parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Endpoint endpoint) {
        return DEFAULT_INSTANCE.createBuilder(endpoint);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Endpoint, Builder> implements EndpointOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(Endpoint.DEFAULT_INSTANCE);
        }

        @Override // com.google.api.EndpointOrBuilder
        public final String getName() {
            return ((Endpoint) this.instance).getName();
        }

        @Override // com.google.api.EndpointOrBuilder
        public final ByteString getNameBytes() {
            return ((Endpoint) this.instance).getNameBytes();
        }

        public final Builder setName(String str) {
            copyOnWrite();
            ((Endpoint) this.instance).setName(str);
            return this;
        }

        public final Builder clearName() {
            copyOnWrite();
            ((Endpoint) this.instance).clearName();
            return this;
        }

        public final Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((Endpoint) this.instance).setNameBytes(byteString);
            return this;
        }

        @Override // com.google.api.EndpointOrBuilder
        @Deprecated
        public final List<String> getAliasesList() {
            return Collections.unmodifiableList(((Endpoint) this.instance).getAliasesList());
        }

        @Override // com.google.api.EndpointOrBuilder
        @Deprecated
        public final int getAliasesCount() {
            return ((Endpoint) this.instance).getAliasesCount();
        }

        @Override // com.google.api.EndpointOrBuilder
        @Deprecated
        public final String getAliases(int i) {
            return ((Endpoint) this.instance).getAliases(i);
        }

        @Override // com.google.api.EndpointOrBuilder
        @Deprecated
        public final ByteString getAliasesBytes(int i) {
            return ((Endpoint) this.instance).getAliasesBytes(i);
        }

        @Deprecated
        public final Builder setAliases(int i, String str) {
            copyOnWrite();
            ((Endpoint) this.instance).setAliases(i, str);
            return this;
        }

        @Deprecated
        public final Builder addAliases(String str) {
            copyOnWrite();
            ((Endpoint) this.instance).addAliases(str);
            return this;
        }

        @Deprecated
        public final Builder addAllAliases(Iterable<String> iterable) {
            copyOnWrite();
            ((Endpoint) this.instance).addAllAliases(iterable);
            return this;
        }

        @Deprecated
        public final Builder clearAliases() {
            copyOnWrite();
            ((Endpoint) this.instance).clearAliases();
            return this;
        }

        @Deprecated
        public final Builder addAliasesBytes(ByteString byteString) {
            copyOnWrite();
            ((Endpoint) this.instance).addAliasesBytes(byteString);
            return this;
        }

        @Override // com.google.api.EndpointOrBuilder
        public final List<String> getFeaturesList() {
            return Collections.unmodifiableList(((Endpoint) this.instance).getFeaturesList());
        }

        @Override // com.google.api.EndpointOrBuilder
        public final int getFeaturesCount() {
            return ((Endpoint) this.instance).getFeaturesCount();
        }

        @Override // com.google.api.EndpointOrBuilder
        public final String getFeatures(int i) {
            return ((Endpoint) this.instance).getFeatures(i);
        }

        @Override // com.google.api.EndpointOrBuilder
        public final ByteString getFeaturesBytes(int i) {
            return ((Endpoint) this.instance).getFeaturesBytes(i);
        }

        public final Builder setFeatures(int i, String str) {
            copyOnWrite();
            ((Endpoint) this.instance).setFeatures(i, str);
            return this;
        }

        public final Builder addFeatures(String str) {
            copyOnWrite();
            ((Endpoint) this.instance).addFeatures(str);
            return this;
        }

        public final Builder addAllFeatures(Iterable<String> iterable) {
            copyOnWrite();
            ((Endpoint) this.instance).addAllFeatures(iterable);
            return this;
        }

        public final Builder clearFeatures() {
            copyOnWrite();
            ((Endpoint) this.instance).clearFeatures();
            return this;
        }

        public final Builder addFeaturesBytes(ByteString byteString) {
            copyOnWrite();
            ((Endpoint) this.instance).addFeaturesBytes(byteString);
            return this;
        }

        @Override // com.google.api.EndpointOrBuilder
        public final String getTarget() {
            return ((Endpoint) this.instance).getTarget();
        }

        @Override // com.google.api.EndpointOrBuilder
        public final ByteString getTargetBytes() {
            return ((Endpoint) this.instance).getTargetBytes();
        }

        public final Builder setTarget(String str) {
            copyOnWrite();
            ((Endpoint) this.instance).setTarget(str);
            return this;
        }

        public final Builder clearTarget() {
            copyOnWrite();
            ((Endpoint) this.instance).clearTarget();
            return this;
        }

        public final Builder setTargetBytes(ByteString byteString) {
            copyOnWrite();
            ((Endpoint) this.instance).setTargetBytes(byteString);
            return this;
        }

        @Override // com.google.api.EndpointOrBuilder
        public final boolean getAllowCors() {
            return ((Endpoint) this.instance).getAllowCors();
        }

        public final Builder setAllowCors(boolean z) {
            copyOnWrite();
            ((Endpoint) this.instance).setAllowCors(z);
            return this;
        }

        public final Builder clearAllowCors() {
            copyOnWrite();
            ((Endpoint) this.instance).clearAllowCors();
            return this;
        }
    }

    /* renamed from: com.google.api.Endpoint$1  reason: invalid class name */
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
                return new Endpoint();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001e\u0005\u0000\u0002\u0000\u0001Ȉ\u0002Ț\u0004Ț\u0005\u0007eȈ", new Object[]{"name_", "aliases_", "features_", "allowCors_", "target_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Endpoint> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (Endpoint.class) {
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
        Endpoint endpoint = new Endpoint();
        DEFAULT_INSTANCE = endpoint;
        GeneratedMessageLite.registerDefaultInstance(Endpoint.class, endpoint);
    }

    public static Endpoint getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Endpoint> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
