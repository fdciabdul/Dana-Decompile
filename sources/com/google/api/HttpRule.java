package com.google.api;

import com.google.api.CustomHttpPattern;
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
public final class HttpRule extends GeneratedMessageLite<HttpRule, Builder> implements HttpRuleOrBuilder {
    public static final int ADDITIONAL_BINDINGS_FIELD_NUMBER = 11;
    public static final int BODY_FIELD_NUMBER = 7;
    public static final int CUSTOM_FIELD_NUMBER = 8;
    private static final HttpRule DEFAULT_INSTANCE;
    public static final int DELETE_FIELD_NUMBER = 5;
    public static final int GET_FIELD_NUMBER = 2;
    private static volatile Parser<HttpRule> PARSER = null;
    public static final int PATCH_FIELD_NUMBER = 6;
    public static final int POST_FIELD_NUMBER = 4;
    public static final int PUT_FIELD_NUMBER = 3;
    public static final int RESPONSE_BODY_FIELD_NUMBER = 12;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private Object pattern_;
    private int patternCase_ = 0;
    private String selector_ = "";
    private String body_ = "";
    private String responseBody_ = "";
    private Internal.ProtobufList<HttpRule> additionalBindings_ = emptyProtobufList();

    private HttpRule() {
    }

    /* loaded from: classes7.dex */
    public enum PatternCase {
        GET(2),
        PUT(3),
        POST(4),
        DELETE(5),
        PATCH(6),
        CUSTOM(8),
        PATTERN_NOT_SET(0);

        private final int value;

        PatternCase(int i) {
            this.value = i;
        }

        @Deprecated
        public static PatternCase valueOf(int i) {
            return forNumber(i);
        }

        public static PatternCase forNumber(int i) {
            if (i != 0) {
                if (i != 8) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    if (i != 6) {
                                        return null;
                                    }
                                    return PATCH;
                                }
                                return DELETE;
                            }
                            return POST;
                        }
                        return PUT;
                    }
                    return GET;
                }
                return CUSTOM;
            }
            return PATTERN_NOT_SET;
        }

        public final int getNumber() {
            return this.value;
        }
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final PatternCase getPatternCase() {
        return PatternCase.forNumber(this.patternCase_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPattern() {
        this.patternCase_ = 0;
        this.pattern_ = null;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final String getSelector() {
        return this.selector_;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final ByteString getSelectorBytes() {
        return ByteString.copyFromUtf8(this.selector_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelector(String str) {
        this.selector_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelector() {
        this.selector_ = getDefaultInstance().getSelector();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectorBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.selector_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final String getGet() {
        return this.patternCase_ == 2 ? (String) this.pattern_ : "";
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final ByteString getGetBytes() {
        return ByteString.copyFromUtf8(this.patternCase_ == 2 ? (String) this.pattern_ : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGet(String str) {
        this.patternCase_ = 2;
        this.pattern_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGet() {
        if (this.patternCase_ == 2) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGetBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.pattern_ = byteString.toStringUtf8();
        this.patternCase_ = 2;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final String getPut() {
        return this.patternCase_ == 3 ? (String) this.pattern_ : "";
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final ByteString getPutBytes() {
        return ByteString.copyFromUtf8(this.patternCase_ == 3 ? (String) this.pattern_ : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPut(String str) {
        this.patternCase_ = 3;
        this.pattern_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPut() {
        if (this.patternCase_ == 3) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPutBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.pattern_ = byteString.toStringUtf8();
        this.patternCase_ = 3;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final String getPost() {
        return this.patternCase_ == 4 ? (String) this.pattern_ : "";
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final ByteString getPostBytes() {
        return ByteString.copyFromUtf8(this.patternCase_ == 4 ? (String) this.pattern_ : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPost(String str) {
        this.patternCase_ = 4;
        this.pattern_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPost() {
        if (this.patternCase_ == 4) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPostBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.pattern_ = byteString.toStringUtf8();
        this.patternCase_ = 4;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final String getDelete() {
        return this.patternCase_ == 5 ? (String) this.pattern_ : "";
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final ByteString getDeleteBytes() {
        return ByteString.copyFromUtf8(this.patternCase_ == 5 ? (String) this.pattern_ : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDelete(String str) {
        this.patternCase_ = 5;
        this.pattern_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDelete() {
        if (this.patternCase_ == 5) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeleteBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.pattern_ = byteString.toStringUtf8();
        this.patternCase_ = 5;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final String getPatch() {
        return this.patternCase_ == 6 ? (String) this.pattern_ : "";
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final ByteString getPatchBytes() {
        return ByteString.copyFromUtf8(this.patternCase_ == 6 ? (String) this.pattern_ : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPatch(String str) {
        this.patternCase_ = 6;
        this.pattern_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPatch() {
        if (this.patternCase_ == 6) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPatchBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.pattern_ = byteString.toStringUtf8();
        this.patternCase_ = 6;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final boolean hasCustom() {
        return this.patternCase_ == 8;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final CustomHttpPattern getCustom() {
        if (this.patternCase_ == 8) {
            return (CustomHttpPattern) this.pattern_;
        }
        return CustomHttpPattern.getDefaultInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCustom(CustomHttpPattern customHttpPattern) {
        this.pattern_ = customHttpPattern;
        this.patternCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCustom(CustomHttpPattern customHttpPattern) {
        if (this.patternCase_ == 8 && this.pattern_ != CustomHttpPattern.getDefaultInstance()) {
            this.pattern_ = CustomHttpPattern.newBuilder((CustomHttpPattern) this.pattern_).mergeFrom((CustomHttpPattern.Builder) customHttpPattern).buildPartial();
        } else {
            this.pattern_ = customHttpPattern;
        }
        this.patternCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCustom() {
        if (this.patternCase_ == 8) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final String getBody() {
        return this.body_;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final ByteString getBodyBytes() {
        return ByteString.copyFromUtf8(this.body_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBody(String str) {
        this.body_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBody() {
        this.body_ = getDefaultInstance().getBody();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBodyBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.body_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final String getResponseBody() {
        return this.responseBody_;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final ByteString getResponseBodyBytes() {
        return ByteString.copyFromUtf8(this.responseBody_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseBody(String str) {
        this.responseBody_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseBody() {
        this.responseBody_ = getDefaultInstance().getResponseBody();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseBodyBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.responseBody_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final List<HttpRule> getAdditionalBindingsList() {
        return this.additionalBindings_;
    }

    public final List<? extends HttpRuleOrBuilder> getAdditionalBindingsOrBuilderList() {
        return this.additionalBindings_;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final int getAdditionalBindingsCount() {
        return this.additionalBindings_.size();
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public final HttpRule getAdditionalBindings(int i) {
        return this.additionalBindings_.get(i);
    }

    public final HttpRuleOrBuilder getAdditionalBindingsOrBuilder(int i) {
        return this.additionalBindings_.get(i);
    }

    private void ensureAdditionalBindingsIsMutable() {
        Internal.ProtobufList<HttpRule> protobufList = this.additionalBindings_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.additionalBindings_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdditionalBindings(int i, HttpRule httpRule) {
        ensureAdditionalBindingsIsMutable();
        this.additionalBindings_.set(i, httpRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAdditionalBindings(HttpRule httpRule) {
        ensureAdditionalBindingsIsMutable();
        this.additionalBindings_.add(httpRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAdditionalBindings(int i, HttpRule httpRule) {
        ensureAdditionalBindingsIsMutable();
        this.additionalBindings_.add(i, httpRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAdditionalBindings(Iterable<? extends HttpRule> iterable) {
        ensureAdditionalBindingsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.additionalBindings_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdditionalBindings() {
        this.additionalBindings_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAdditionalBindings(int i) {
        ensureAdditionalBindingsIsMutable();
        this.additionalBindings_.remove(i);
    }

    public static HttpRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (HttpRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static HttpRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HttpRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HttpRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HttpRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HttpRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HttpRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HttpRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HttpRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HttpRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HttpRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HttpRule parseFrom(InputStream inputStream) throws IOException {
        return (HttpRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HttpRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HttpRule parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HttpRule) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HttpRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpRule) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HttpRule parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HttpRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HttpRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(HttpRule httpRule) {
        return DEFAULT_INSTANCE.createBuilder(httpRule);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<HttpRule, Builder> implements HttpRuleOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(HttpRule.DEFAULT_INSTANCE);
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final PatternCase getPatternCase() {
            return ((HttpRule) this.instance).getPatternCase();
        }

        public final Builder clearPattern() {
            copyOnWrite();
            ((HttpRule) this.instance).clearPattern();
            return this;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final String getSelector() {
            return ((HttpRule) this.instance).getSelector();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final ByteString getSelectorBytes() {
            return ((HttpRule) this.instance).getSelectorBytes();
        }

        public final Builder setSelector(String str) {
            copyOnWrite();
            ((HttpRule) this.instance).setSelector(str);
            return this;
        }

        public final Builder clearSelector() {
            copyOnWrite();
            ((HttpRule) this.instance).clearSelector();
            return this;
        }

        public final Builder setSelectorBytes(ByteString byteString) {
            copyOnWrite();
            ((HttpRule) this.instance).setSelectorBytes(byteString);
            return this;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final String getGet() {
            return ((HttpRule) this.instance).getGet();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final ByteString getGetBytes() {
            return ((HttpRule) this.instance).getGetBytes();
        }

        public final Builder setGet(String str) {
            copyOnWrite();
            ((HttpRule) this.instance).setGet(str);
            return this;
        }

        public final Builder clearGet() {
            copyOnWrite();
            ((HttpRule) this.instance).clearGet();
            return this;
        }

        public final Builder setGetBytes(ByteString byteString) {
            copyOnWrite();
            ((HttpRule) this.instance).setGetBytes(byteString);
            return this;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final String getPut() {
            return ((HttpRule) this.instance).getPut();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final ByteString getPutBytes() {
            return ((HttpRule) this.instance).getPutBytes();
        }

        public final Builder setPut(String str) {
            copyOnWrite();
            ((HttpRule) this.instance).setPut(str);
            return this;
        }

        public final Builder clearPut() {
            copyOnWrite();
            ((HttpRule) this.instance).clearPut();
            return this;
        }

        public final Builder setPutBytes(ByteString byteString) {
            copyOnWrite();
            ((HttpRule) this.instance).setPutBytes(byteString);
            return this;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final String getPost() {
            return ((HttpRule) this.instance).getPost();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final ByteString getPostBytes() {
            return ((HttpRule) this.instance).getPostBytes();
        }

        public final Builder setPost(String str) {
            copyOnWrite();
            ((HttpRule) this.instance).setPost(str);
            return this;
        }

        public final Builder clearPost() {
            copyOnWrite();
            ((HttpRule) this.instance).clearPost();
            return this;
        }

        public final Builder setPostBytes(ByteString byteString) {
            copyOnWrite();
            ((HttpRule) this.instance).setPostBytes(byteString);
            return this;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final String getDelete() {
            return ((HttpRule) this.instance).getDelete();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final ByteString getDeleteBytes() {
            return ((HttpRule) this.instance).getDeleteBytes();
        }

        public final Builder setDelete(String str) {
            copyOnWrite();
            ((HttpRule) this.instance).setDelete(str);
            return this;
        }

        public final Builder clearDelete() {
            copyOnWrite();
            ((HttpRule) this.instance).clearDelete();
            return this;
        }

        public final Builder setDeleteBytes(ByteString byteString) {
            copyOnWrite();
            ((HttpRule) this.instance).setDeleteBytes(byteString);
            return this;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final String getPatch() {
            return ((HttpRule) this.instance).getPatch();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final ByteString getPatchBytes() {
            return ((HttpRule) this.instance).getPatchBytes();
        }

        public final Builder setPatch(String str) {
            copyOnWrite();
            ((HttpRule) this.instance).setPatch(str);
            return this;
        }

        public final Builder clearPatch() {
            copyOnWrite();
            ((HttpRule) this.instance).clearPatch();
            return this;
        }

        public final Builder setPatchBytes(ByteString byteString) {
            copyOnWrite();
            ((HttpRule) this.instance).setPatchBytes(byteString);
            return this;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final boolean hasCustom() {
            return ((HttpRule) this.instance).hasCustom();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final CustomHttpPattern getCustom() {
            return ((HttpRule) this.instance).getCustom();
        }

        public final Builder setCustom(CustomHttpPattern customHttpPattern) {
            copyOnWrite();
            ((HttpRule) this.instance).setCustom(customHttpPattern);
            return this;
        }

        public final Builder setCustom(CustomHttpPattern.Builder builder) {
            copyOnWrite();
            ((HttpRule) this.instance).setCustom(builder.build());
            return this;
        }

        public final Builder mergeCustom(CustomHttpPattern customHttpPattern) {
            copyOnWrite();
            ((HttpRule) this.instance).mergeCustom(customHttpPattern);
            return this;
        }

        public final Builder clearCustom() {
            copyOnWrite();
            ((HttpRule) this.instance).clearCustom();
            return this;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final String getBody() {
            return ((HttpRule) this.instance).getBody();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final ByteString getBodyBytes() {
            return ((HttpRule) this.instance).getBodyBytes();
        }

        public final Builder setBody(String str) {
            copyOnWrite();
            ((HttpRule) this.instance).setBody(str);
            return this;
        }

        public final Builder clearBody() {
            copyOnWrite();
            ((HttpRule) this.instance).clearBody();
            return this;
        }

        public final Builder setBodyBytes(ByteString byteString) {
            copyOnWrite();
            ((HttpRule) this.instance).setBodyBytes(byteString);
            return this;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final String getResponseBody() {
            return ((HttpRule) this.instance).getResponseBody();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final ByteString getResponseBodyBytes() {
            return ((HttpRule) this.instance).getResponseBodyBytes();
        }

        public final Builder setResponseBody(String str) {
            copyOnWrite();
            ((HttpRule) this.instance).setResponseBody(str);
            return this;
        }

        public final Builder clearResponseBody() {
            copyOnWrite();
            ((HttpRule) this.instance).clearResponseBody();
            return this;
        }

        public final Builder setResponseBodyBytes(ByteString byteString) {
            copyOnWrite();
            ((HttpRule) this.instance).setResponseBodyBytes(byteString);
            return this;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final List<HttpRule> getAdditionalBindingsList() {
            return Collections.unmodifiableList(((HttpRule) this.instance).getAdditionalBindingsList());
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final int getAdditionalBindingsCount() {
            return ((HttpRule) this.instance).getAdditionalBindingsCount();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public final HttpRule getAdditionalBindings(int i) {
            return ((HttpRule) this.instance).getAdditionalBindings(i);
        }

        public final Builder setAdditionalBindings(int i, HttpRule httpRule) {
            copyOnWrite();
            ((HttpRule) this.instance).setAdditionalBindings(i, httpRule);
            return this;
        }

        public final Builder setAdditionalBindings(int i, Builder builder) {
            copyOnWrite();
            ((HttpRule) this.instance).setAdditionalBindings(i, builder.build());
            return this;
        }

        public final Builder addAdditionalBindings(HttpRule httpRule) {
            copyOnWrite();
            ((HttpRule) this.instance).addAdditionalBindings(httpRule);
            return this;
        }

        public final Builder addAdditionalBindings(int i, HttpRule httpRule) {
            copyOnWrite();
            ((HttpRule) this.instance).addAdditionalBindings(i, httpRule);
            return this;
        }

        public final Builder addAdditionalBindings(Builder builder) {
            copyOnWrite();
            ((HttpRule) this.instance).addAdditionalBindings(builder.build());
            return this;
        }

        public final Builder addAdditionalBindings(int i, Builder builder) {
            copyOnWrite();
            ((HttpRule) this.instance).addAdditionalBindings(i, builder.build());
            return this;
        }

        public final Builder addAllAdditionalBindings(Iterable<? extends HttpRule> iterable) {
            copyOnWrite();
            ((HttpRule) this.instance).addAllAdditionalBindings(iterable);
            return this;
        }

        public final Builder clearAdditionalBindings() {
            copyOnWrite();
            ((HttpRule) this.instance).clearAdditionalBindings();
            return this;
        }

        public final Builder removeAdditionalBindings(int i) {
            copyOnWrite();
            ((HttpRule) this.instance).removeAdditionalBindings(i);
            return this;
        }
    }

    /* renamed from: com.google.api.HttpRule$1  reason: invalid class name */
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
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new HttpRule();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0001\u0000\u0001\f\n\u0000\u0001\u0000\u0001Ȉ\u0002Ȼ\u0000\u0003Ȼ\u0000\u0004Ȼ\u0000\u0005Ȼ\u0000\u0006Ȼ\u0000\u0007Ȉ\b<\u0000\u000b\u001b\fȈ", new Object[]{"pattern_", "patternCase_", "selector_", "body_", CustomHttpPattern.class, "additionalBindings_", HttpRule.class, "responseBody_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HttpRule> parser = PARSER;
                if (parser == null) {
                    synchronized (HttpRule.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        HttpRule httpRule = new HttpRule();
        DEFAULT_INSTANCE = httpRule;
        GeneratedMessageLite.registerDefaultInstance(HttpRule.class, httpRule);
    }

    public static HttpRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<HttpRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
