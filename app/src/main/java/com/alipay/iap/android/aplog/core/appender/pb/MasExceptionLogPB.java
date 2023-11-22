package com.alipay.iap.android.aplog.core.appender.pb;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import id.dana.danah5.customshareitem.ShareItemChannel;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;

/* loaded from: classes6.dex */
public final class MasExceptionLogPB {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_protocobuff_log_MasExceptionLog_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_protocobuff_log_MasExceptionLog_fieldAccessorTable;

    /* loaded from: classes6.dex */
    public interface MasExceptionLogOrBuilder extends MessageOrBuilder {
        String getAppID();

        ByteString getAppIDBytes();

        String getAppVersion();

        ByteString getAppVersionBytes();

        String getMessages();

        ByteString getMessagesBytes();

        boolean hasAppID();

        boolean hasAppVersion();

        boolean hasMessages();
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015MasExceptionLog.proto\u0012\u000fprotocobuff_log\"F\n\u000fMasExceptionLog\u0012\r\n\u0005appID\u0018\u0001 \u0002(\t\u0012\u0012\n\nappVersion\u0018\u0002 \u0001(\t\u0012\u0010\n\bmessages\u0018\u0003 \u0002(\tBB\n-com.alipay.iap.android.aplog.core.appender.pbB\u0011MasExceptionLogPB"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.1
            public final ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = MasExceptionLogPB.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.Descriptor descriptor2 = (Descriptors.Descriptor) getDescriptor().getMessageTypes().get(0);
        internal_static_protocobuff_log_MasExceptionLog_descriptor = descriptor2;
        internal_static_protocobuff_log_MasExceptionLog_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(descriptor2, new String[]{"AppID", "AppVersion", ShareItemChannel.MESSAGES});
    }

    private MasExceptionLogPB() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    /* loaded from: classes6.dex */
    public static final class MasExceptionLog extends GeneratedMessage implements MasExceptionLogOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        public static final int APPVERSION_FIELD_NUMBER = 2;
        public static final int MESSAGES_FIELD_NUMBER = 3;
        public static Parser<MasExceptionLog> PARSER = new AbstractParser<MasExceptionLog>() { // from class: com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLog.1
            @Override // com.google.protobuf.Parser
            public final MasExceptionLog parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new MasExceptionLog(codedInputStream, extensionRegistryLite);
            }
        };
        private static final MasExceptionLog defaultInstance;
        private static final long serialVersionUID = 0;
        private Object appID_;
        private Object appVersion_;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object messages_;
        private final UnknownFieldSet unknownFields;

        static {
            MasExceptionLog masExceptionLog = new MasExceptionLog(true);
            defaultInstance = masExceptionLog;
            masExceptionLog.initFields();
        }

        private MasExceptionLog(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MasExceptionLog(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private MasExceptionLog(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                ByteString readBytes = codedInputStream.readBytes();
                                this.bitField0_ |= 1;
                                this.appID_ = readBytes;
                            } else if (readTag == 18) {
                                ByteString readBytes2 = codedInputStream.readBytes();
                                this.bitField0_ |= 2;
                                this.appVersion_ = readBytes2;
                            } else if (readTag != 26) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                ByteString readBytes3 = codedInputStream.readBytes();
                                this.bitField0_ |= 4;
                                this.messages_ = readBytes3;
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static MasExceptionLog getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MasExceptionLogPB.internal_static_protocobuff_log_MasExceptionLog_descriptor;
        }

        public static MasExceptionLog parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static MasExceptionLog parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static MasExceptionLog parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static MasExceptionLog parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static MasExceptionLog parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static MasExceptionLog parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static MasExceptionLog parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static MasExceptionLog parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static MasExceptionLog parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static MasExceptionLog parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$300();
        }

        public static Builder newBuilder(MasExceptionLog masExceptionLog) {
            return newBuilder().mergeFrom(masExceptionLog);
        }

        /* renamed from: getDefaultInstanceForType  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public final MasExceptionLog m52getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        protected final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MasExceptionLogPB.internal_static_protocobuff_log_MasExceptionLog_fieldAccessorTable.ensureFieldAccessorsInitialized(MasExceptionLog.class, Builder.class);
        }

        public final Parser<MasExceptionLog> getParserForType() {
            return PARSER;
        }

        @Override // com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLogOrBuilder
        public final boolean hasAppID() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLogOrBuilder
        public final String getAppID() {
            Object obj = this.appID_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.appID_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLogOrBuilder
        public final ByteString getAppIDBytes() {
            Object obj = this.appID_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.appID_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLogOrBuilder
        public final boolean hasAppVersion() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLogOrBuilder
        public final String getAppVersion() {
            Object obj = this.appVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.appVersion_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLogOrBuilder
        public final ByteString getAppVersionBytes() {
            Object obj = this.appVersion_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.appVersion_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLogOrBuilder
        public final boolean hasMessages() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLogOrBuilder
        public final String getMessages() {
            Object obj = this.messages_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.messages_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLogOrBuilder
        public final ByteString getMessagesBytes() {
            Object obj = this.messages_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.messages_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        private void initFields() {
            this.appID_ = "";
            this.appVersion_ = "";
            this.messages_ = "";
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if (!hasAppID()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!hasMessages()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBytes(1, getAppIDBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getAppVersionBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, getMessagesBytes());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getAppIDBytes()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, getAppVersionBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, getMessagesBytes());
            }
            int serializedSize = computeBytesSize + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        protected final Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        /* renamed from: newBuilderForType  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public final Builder m55newBuilderForType() {
            return newBuilder();
        }

        /* renamed from: toBuilder  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public final Builder m57toBuilder() {
            return newBuilder(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType  reason: merged with bridge method [inline-methods] */
        public final Builder m54newBuilderForType(GeneratedMessage.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MasExceptionLogOrBuilder {
            private Object appID_;
            private Object appVersion_;
            private int bitField0_;
            private Object messages_;

            static /* synthetic */ Builder access$300() {
                return create();
            }

            private Builder() {
                this.appID_ = "";
                this.appVersion_ = "";
                this.messages_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                this.appID_ = "";
                this.appVersion_ = "";
                this.messages_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MasExceptionLogPB.internal_static_protocobuff_log_MasExceptionLog_descriptor;
            }

            private static Builder create() {
                return new Builder();
            }

            protected final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MasExceptionLogPB.internal_static_protocobuff_log_MasExceptionLog_fieldAccessorTable.ensureFieldAccessorsInitialized(MasExceptionLog.class, Builder.class);
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = MasExceptionLog.alwaysUseFieldBuilders;
            }

            /* renamed from: clear  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m65clear() {
                super.clear();
                this.appID_ = "";
                int i = this.bitField0_;
                this.appVersion_ = "";
                this.messages_ = "";
                this.bitField0_ = i & (-2) & (-3) & (-5);
                return this;
            }

            /* renamed from: clone  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m71clone() {
                return create().mergeFrom(m61buildPartial());
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return MasExceptionLogPB.internal_static_protocobuff_log_MasExceptionLog_descriptor;
            }

            /* renamed from: getDefaultInstanceForType  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final MasExceptionLog m73getDefaultInstanceForType() {
                return MasExceptionLog.getDefaultInstance();
            }

            /* renamed from: build  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final MasExceptionLog m59build() {
                MasExceptionLog m61buildPartial = m61buildPartial();
                if (m61buildPartial.isInitialized()) {
                    return m61buildPartial;
                }
                throw newUninitializedMessageException(m61buildPartial);
            }

            /* renamed from: buildPartial  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final MasExceptionLog m61buildPartial() {
                MasExceptionLog masExceptionLog = new MasExceptionLog(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                masExceptionLog.appID_ = this.appID_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                masExceptionLog.appVersion_ = this.appVersion_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                masExceptionLog.messages_ = this.messages_;
                masExceptionLog.bitField0_ = i2;
                onBuilt();
                return masExceptionLog;
            }

            /* renamed from: mergeFrom  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m78mergeFrom(Message message) {
                if (message instanceof MasExceptionLog) {
                    return mergeFrom((MasExceptionLog) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(MasExceptionLog masExceptionLog) {
                if (masExceptionLog == MasExceptionLog.getDefaultInstance()) {
                    return this;
                }
                if (masExceptionLog.hasAppID()) {
                    this.bitField0_ |= 1;
                    this.appID_ = masExceptionLog.appID_;
                    onChanged();
                }
                if (masExceptionLog.hasAppVersion()) {
                    this.bitField0_ |= 2;
                    this.appVersion_ = masExceptionLog.appVersion_;
                    onChanged();
                }
                if (masExceptionLog.hasMessages()) {
                    this.bitField0_ |= 4;
                    this.messages_ = masExceptionLog.messages_;
                    onChanged();
                }
                mergeUnknownFields(masExceptionLog.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return hasAppID() && hasMessages();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            /* renamed from: mergeFrom  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLog.Builder m79mergeFrom(com.google.protobuf.CodedInputStream r2, com.google.protobuf.ExtensionRegistryLite r3) throws java.io.IOException {
                /*
                    r1 = this;
                    com.google.protobuf.Parser<com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB$MasExceptionLog> r0 = com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLog.PARSER     // Catch: java.lang.Throwable -> Le com.google.protobuf.InvalidProtocolBufferException -> L10
                    java.lang.Object r2 = r0.parsePartialFrom(r2, r3)     // Catch: java.lang.Throwable -> Le com.google.protobuf.InvalidProtocolBufferException -> L10
                    com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB$MasExceptionLog r2 = (com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLog) r2     // Catch: java.lang.Throwable -> Le com.google.protobuf.InvalidProtocolBufferException -> L10
                    if (r2 == 0) goto Ld
                    r1.mergeFrom(r2)
                Ld:
                    return r1
                Le:
                    r2 = move-exception
                    goto L1a
                L10:
                    r2 = move-exception
                    com.google.protobuf.MessageLite r3 = r2.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Le
                    com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB$MasExceptionLog r3 = (com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLog) r3     // Catch: java.lang.Throwable -> Le
                    throw r2     // Catch: java.lang.Throwable -> L18
                L18:
                    r2 = move-exception
                    goto L1b
                L1a:
                    r3 = 0
                L1b:
                    if (r3 == 0) goto L20
                    r1.mergeFrom(r3)
                L20:
                    throw r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLog.Builder.m79mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB$MasExceptionLog$Builder");
            }

            @Override // com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLogOrBuilder
            public final boolean hasAppID() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLogOrBuilder
            public final String getAppID() {
                Object obj = this.appID_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.appID_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            public final Builder setAppID(String str) {
                this.bitField0_ |= 1;
                this.appID_ = str;
                onChanged();
                return this;
            }

            @Override // com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLogOrBuilder
            public final ByteString getAppIDBytes() {
                Object obj = this.appID_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.appID_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public final Builder setAppIDBytes(ByteString byteString) {
                this.bitField0_ |= 1;
                this.appID_ = byteString;
                onChanged();
                return this;
            }

            public final Builder clearAppID() {
                this.bitField0_ &= -2;
                this.appID_ = MasExceptionLog.getDefaultInstance().getAppID();
                onChanged();
                return this;
            }

            @Override // com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLogOrBuilder
            public final boolean hasAppVersion() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLogOrBuilder
            public final String getAppVersion() {
                Object obj = this.appVersion_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.appVersion_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            public final Builder setAppVersion(String str) {
                this.bitField0_ |= 2;
                this.appVersion_ = str;
                onChanged();
                return this;
            }

            @Override // com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLogOrBuilder
            public final ByteString getAppVersionBytes() {
                Object obj = this.appVersion_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.appVersion_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public final Builder setAppVersionBytes(ByteString byteString) {
                this.bitField0_ |= 2;
                this.appVersion_ = byteString;
                onChanged();
                return this;
            }

            public final Builder clearAppVersion() {
                this.bitField0_ &= -3;
                this.appVersion_ = MasExceptionLog.getDefaultInstance().getAppVersion();
                onChanged();
                return this;
            }

            @Override // com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLogOrBuilder
            public final boolean hasMessages() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLogOrBuilder
            public final String getMessages() {
                Object obj = this.messages_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.messages_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            public final Builder setMessages(String str) {
                this.bitField0_ |= 4;
                this.messages_ = str;
                onChanged();
                return this;
            }

            @Override // com.alipay.iap.android.aplog.core.appender.pb.MasExceptionLogPB.MasExceptionLogOrBuilder
            public final ByteString getMessagesBytes() {
                Object obj = this.messages_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.messages_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public final Builder setMessagesBytes(ByteString byteString) {
                this.bitField0_ |= 4;
                this.messages_ = byteString;
                onChanged();
                return this;
            }

            public final Builder clearMessages() {
                this.bitField0_ &= -5;
                this.messages_ = MasExceptionLog.getDefaultInstance().getMessages();
                onChanged();
                return this;
            }
        }
    }
}
