package com.google.firebase.perf.v1;

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
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class PerfSession extends GeneratedMessageLite<PerfSession, Builder> implements PerfSessionOrBuilder {
    private static final PerfSession DEFAULT_INSTANCE;
    private static volatile Parser<PerfSession> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    public static final int SESSION_VERBOSITY_FIELD_NUMBER = 2;
    private static final Internal.ListAdapter.Converter<Integer, SessionVerbosity> sessionVerbosity_converter_ = new Internal.ListAdapter.Converter<Integer, SessionVerbosity>() { // from class: com.google.firebase.perf.v1.PerfSession.1
        @Override // com.google.protobuf.Internal.ListAdapter.Converter
        public SessionVerbosity convert(Integer num) {
            SessionVerbosity forNumber = SessionVerbosity.forNumber(num.intValue());
            return forNumber == null ? SessionVerbosity.SESSION_VERBOSITY_NONE : forNumber;
        }
    };
    private int bitField0_;
    private String sessionId_ = "";
    private Internal.IntList sessionVerbosity_ = emptyIntList();

    private PerfSession() {
    }

    @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
    public final boolean hasSessionId() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
    public final String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
    public final ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionId(String str) {
        this.bitField0_ |= 1;
        this.sessionId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.bitField0_ &= -2;
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionIdBytes(ByteString byteString) {
        this.sessionId_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    static {
        PerfSession perfSession = new PerfSession();
        DEFAULT_INSTANCE = perfSession;
        GeneratedMessageLite.registerDefaultInstance(PerfSession.class, perfSession);
    }

    @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
    public final List<SessionVerbosity> getSessionVerbosityList() {
        return new Internal.ListAdapter(this.sessionVerbosity_, sessionVerbosity_converter_);
    }

    @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
    public final int getSessionVerbosityCount() {
        return this.sessionVerbosity_.size();
    }

    @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
    public final SessionVerbosity getSessionVerbosity(int i) {
        return sessionVerbosity_converter_.convert(Integer.valueOf(this.sessionVerbosity_.getInt(i)));
    }

    private void ensureSessionVerbosityIsMutable() {
        Internal.IntList intList = this.sessionVerbosity_;
        if (intList.isModifiable()) {
            return;
        }
        this.sessionVerbosity_ = GeneratedMessageLite.mutableCopy(intList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionVerbosity(int i, SessionVerbosity sessionVerbosity) {
        ensureSessionVerbosityIsMutable();
        this.sessionVerbosity_.setInt(i, sessionVerbosity.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSessionVerbosity(SessionVerbosity sessionVerbosity) {
        ensureSessionVerbosityIsMutable();
        this.sessionVerbosity_.addInt(sessionVerbosity.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSessionVerbosity(Iterable<? extends SessionVerbosity> iterable) {
        ensureSessionVerbosityIsMutable();
        Iterator<? extends SessionVerbosity> it = iterable.iterator();
        while (it.hasNext()) {
            this.sessionVerbosity_.addInt(it.next().getNumber());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionVerbosity() {
        this.sessionVerbosity_ = emptyIntList();
    }

    public static PerfSession parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (PerfSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static PerfSession parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PerfSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PerfSession parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (PerfSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PerfSession parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PerfSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PerfSession parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (PerfSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PerfSession parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PerfSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PerfSession parseFrom(InputStream inputStream) throws IOException {
        return (PerfSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PerfSession parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PerfSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PerfSession parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PerfSession) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PerfSession parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PerfSession) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PerfSession parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PerfSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PerfSession parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PerfSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(PerfSession perfSession) {
        return DEFAULT_INSTANCE.createBuilder(perfSession);
    }

    /* loaded from: classes.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<PerfSession, Builder> implements PerfSessionOrBuilder {
        private Builder() {
            super(PerfSession.DEFAULT_INSTANCE);
        }

        @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
        public final boolean hasSessionId() {
            return ((PerfSession) this.instance).hasSessionId();
        }

        @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
        public final String getSessionId() {
            return ((PerfSession) this.instance).getSessionId();
        }

        @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
        public final ByteString getSessionIdBytes() {
            return ((PerfSession) this.instance).getSessionIdBytes();
        }

        public final Builder setSessionId(String str) {
            copyOnWrite();
            ((PerfSession) this.instance).setSessionId(str);
            return this;
        }

        public final Builder clearSessionId() {
            copyOnWrite();
            ((PerfSession) this.instance).clearSessionId();
            return this;
        }

        public final Builder setSessionIdBytes(ByteString byteString) {
            copyOnWrite();
            ((PerfSession) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
        public final List<SessionVerbosity> getSessionVerbosityList() {
            return ((PerfSession) this.instance).getSessionVerbosityList();
        }

        @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
        public final int getSessionVerbosityCount() {
            return ((PerfSession) this.instance).getSessionVerbosityCount();
        }

        @Override // com.google.firebase.perf.v1.PerfSessionOrBuilder
        public final SessionVerbosity getSessionVerbosity(int i) {
            return ((PerfSession) this.instance).getSessionVerbosity(i);
        }

        public final Builder setSessionVerbosity(int i, SessionVerbosity sessionVerbosity) {
            copyOnWrite();
            ((PerfSession) this.instance).setSessionVerbosity(i, sessionVerbosity);
            return this;
        }

        public final Builder addSessionVerbosity(SessionVerbosity sessionVerbosity) {
            copyOnWrite();
            ((PerfSession) this.instance).addSessionVerbosity(sessionVerbosity);
            return this;
        }

        public final Builder addAllSessionVerbosity(Iterable<? extends SessionVerbosity> iterable) {
            copyOnWrite();
            ((PerfSession) this.instance).addAllSessionVerbosity(iterable);
            return this;
        }

        public final Builder clearSessionVerbosity() {
            copyOnWrite();
            ((PerfSession) this.instance).clearSessionVerbosity();
            return this;
        }
    }

    /* renamed from: com.google.firebase.perf.v1.PerfSession$2  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass2 {
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
        switch (AnonymousClass2.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PerfSession();
            case 2:
                return new Builder();
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001e", new Object[]{"bitField0_", "sessionId_", "sessionVerbosity_", SessionVerbosity.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PerfSession> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (PerfSession.class) {
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

    public static PerfSession getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<PerfSession> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
