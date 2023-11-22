package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Duration;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.type.TimeZone;
import com.iap.ac.android.loglite.core.AnalyticsContext;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public final class DateTime extends GeneratedMessageLite<DateTime, Builder> implements DateTimeOrBuilder {
    public static final int DAY_FIELD_NUMBER = 3;
    private static final DateTime DEFAULT_INSTANCE;
    public static final int HOURS_FIELD_NUMBER = 4;
    public static final int MINUTES_FIELD_NUMBER = 5;
    public static final int MONTH_FIELD_NUMBER = 2;
    public static final int NANOS_FIELD_NUMBER = 7;
    private static volatile Parser<DateTime> PARSER = null;
    public static final int SECONDS_FIELD_NUMBER = 6;
    public static final int TIME_ZONE_FIELD_NUMBER = 9;
    public static final int UTC_OFFSET_FIELD_NUMBER = 8;
    public static final int YEAR_FIELD_NUMBER = 1;
    private int day_;
    private int hours_;
    private int minutes_;
    private int month_;
    private int nanos_;
    private int seconds_;
    private int timeOffsetCase_ = 0;
    private Object timeOffset_;
    private int year_;

    private DateTime() {
    }

    /* loaded from: classes7.dex */
    public enum TimeOffsetCase {
        UTC_OFFSET(8),
        TIME_ZONE(9),
        TIMEOFFSET_NOT_SET(0);

        private final int value;

        TimeOffsetCase(int i) {
            this.value = i;
        }

        @Deprecated
        public static TimeOffsetCase valueOf(int i) {
            return forNumber(i);
        }

        public static TimeOffsetCase forNumber(int i) {
            if (i != 0) {
                if (i != 8) {
                    if (i != 9) {
                        return null;
                    }
                    return TIME_ZONE;
                }
                return UTC_OFFSET;
            }
            return TIMEOFFSET_NOT_SET;
        }

        public final int getNumber() {
            return this.value;
        }
    }

    @Override // com.google.type.DateTimeOrBuilder
    public final TimeOffsetCase getTimeOffsetCase() {
        return TimeOffsetCase.forNumber(this.timeOffsetCase_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimeOffset() {
        this.timeOffsetCase_ = 0;
        this.timeOffset_ = null;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public final int getYear() {
        return this.year_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setYear(int i) {
        this.year_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearYear() {
        this.year_ = 0;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public final int getMonth() {
        return this.month_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMonth(int i) {
        this.month_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMonth() {
        this.month_ = 0;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public final int getDay() {
        return this.day_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDay(int i) {
        this.day_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDay() {
        this.day_ = 0;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public final int getHours() {
        return this.hours_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHours(int i) {
        this.hours_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHours() {
        this.hours_ = 0;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public final int getMinutes() {
        return this.minutes_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMinutes(int i) {
        this.minutes_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMinutes() {
        this.minutes_ = 0;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public final int getSeconds() {
        return this.seconds_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSeconds(int i) {
        this.seconds_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSeconds() {
        this.seconds_ = 0;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public final int getNanos() {
        return this.nanos_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNanos(int i) {
        this.nanos_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNanos() {
        this.nanos_ = 0;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public final boolean hasUtcOffset() {
        return this.timeOffsetCase_ == 8;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public final Duration getUtcOffset() {
        if (this.timeOffsetCase_ == 8) {
            return (Duration) this.timeOffset_;
        }
        return Duration.getDefaultInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUtcOffset(Duration duration) {
        this.timeOffset_ = duration;
        this.timeOffsetCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUtcOffset(Duration duration) {
        if (this.timeOffsetCase_ == 8 && this.timeOffset_ != Duration.getDefaultInstance()) {
            this.timeOffset_ = Duration.newBuilder((Duration) this.timeOffset_).mergeFrom((Duration.Builder) duration).buildPartial();
        } else {
            this.timeOffset_ = duration;
        }
        this.timeOffsetCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUtcOffset() {
        if (this.timeOffsetCase_ == 8) {
            this.timeOffsetCase_ = 0;
            this.timeOffset_ = null;
        }
    }

    @Override // com.google.type.DateTimeOrBuilder
    public final boolean hasTimeZone() {
        return this.timeOffsetCase_ == 9;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public final TimeZone getTimeZone() {
        if (this.timeOffsetCase_ == 9) {
            return (TimeZone) this.timeOffset_;
        }
        return TimeZone.getDefaultInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeZone(TimeZone timeZone) {
        this.timeOffset_ = timeZone;
        this.timeOffsetCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTimeZone(TimeZone timeZone) {
        if (this.timeOffsetCase_ == 9 && this.timeOffset_ != TimeZone.getDefaultInstance()) {
            this.timeOffset_ = TimeZone.newBuilder((TimeZone) this.timeOffset_).mergeFrom((TimeZone.Builder) timeZone).buildPartial();
        } else {
            this.timeOffset_ = timeZone;
        }
        this.timeOffsetCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimeZone() {
        if (this.timeOffsetCase_ == 9) {
            this.timeOffsetCase_ = 0;
            this.timeOffset_ = null;
        }
    }

    public static DateTime parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (DateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static DateTime parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DateTime parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (DateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static DateTime parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DateTime parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (DateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DateTime parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static DateTime parseFrom(InputStream inputStream) throws IOException {
        return (DateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DateTime parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DateTime parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (DateTime) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DateTime parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DateTime) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DateTime parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (DateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DateTime parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(DateTime dateTime) {
        return DEFAULT_INSTANCE.createBuilder(dateTime);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<DateTime, Builder> implements DateTimeOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(DateTime.DEFAULT_INSTANCE);
        }

        @Override // com.google.type.DateTimeOrBuilder
        public final TimeOffsetCase getTimeOffsetCase() {
            return ((DateTime) this.instance).getTimeOffsetCase();
        }

        public final Builder clearTimeOffset() {
            copyOnWrite();
            ((DateTime) this.instance).clearTimeOffset();
            return this;
        }

        @Override // com.google.type.DateTimeOrBuilder
        public final int getYear() {
            return ((DateTime) this.instance).getYear();
        }

        public final Builder setYear(int i) {
            copyOnWrite();
            ((DateTime) this.instance).setYear(i);
            return this;
        }

        public final Builder clearYear() {
            copyOnWrite();
            ((DateTime) this.instance).clearYear();
            return this;
        }

        @Override // com.google.type.DateTimeOrBuilder
        public final int getMonth() {
            return ((DateTime) this.instance).getMonth();
        }

        public final Builder setMonth(int i) {
            copyOnWrite();
            ((DateTime) this.instance).setMonth(i);
            return this;
        }

        public final Builder clearMonth() {
            copyOnWrite();
            ((DateTime) this.instance).clearMonth();
            return this;
        }

        @Override // com.google.type.DateTimeOrBuilder
        public final int getDay() {
            return ((DateTime) this.instance).getDay();
        }

        public final Builder setDay(int i) {
            copyOnWrite();
            ((DateTime) this.instance).setDay(i);
            return this;
        }

        public final Builder clearDay() {
            copyOnWrite();
            ((DateTime) this.instance).clearDay();
            return this;
        }

        @Override // com.google.type.DateTimeOrBuilder
        public final int getHours() {
            return ((DateTime) this.instance).getHours();
        }

        public final Builder setHours(int i) {
            copyOnWrite();
            ((DateTime) this.instance).setHours(i);
            return this;
        }

        public final Builder clearHours() {
            copyOnWrite();
            ((DateTime) this.instance).clearHours();
            return this;
        }

        @Override // com.google.type.DateTimeOrBuilder
        public final int getMinutes() {
            return ((DateTime) this.instance).getMinutes();
        }

        public final Builder setMinutes(int i) {
            copyOnWrite();
            ((DateTime) this.instance).setMinutes(i);
            return this;
        }

        public final Builder clearMinutes() {
            copyOnWrite();
            ((DateTime) this.instance).clearMinutes();
            return this;
        }

        @Override // com.google.type.DateTimeOrBuilder
        public final int getSeconds() {
            return ((DateTime) this.instance).getSeconds();
        }

        public final Builder setSeconds(int i) {
            copyOnWrite();
            ((DateTime) this.instance).setSeconds(i);
            return this;
        }

        public final Builder clearSeconds() {
            copyOnWrite();
            ((DateTime) this.instance).clearSeconds();
            return this;
        }

        @Override // com.google.type.DateTimeOrBuilder
        public final int getNanos() {
            return ((DateTime) this.instance).getNanos();
        }

        public final Builder setNanos(int i) {
            copyOnWrite();
            ((DateTime) this.instance).setNanos(i);
            return this;
        }

        public final Builder clearNanos() {
            copyOnWrite();
            ((DateTime) this.instance).clearNanos();
            return this;
        }

        @Override // com.google.type.DateTimeOrBuilder
        public final boolean hasUtcOffset() {
            return ((DateTime) this.instance).hasUtcOffset();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public final Duration getUtcOffset() {
            return ((DateTime) this.instance).getUtcOffset();
        }

        public final Builder setUtcOffset(Duration duration) {
            copyOnWrite();
            ((DateTime) this.instance).setUtcOffset(duration);
            return this;
        }

        public final Builder setUtcOffset(Duration.Builder builder) {
            copyOnWrite();
            ((DateTime) this.instance).setUtcOffset(builder.build());
            return this;
        }

        public final Builder mergeUtcOffset(Duration duration) {
            copyOnWrite();
            ((DateTime) this.instance).mergeUtcOffset(duration);
            return this;
        }

        public final Builder clearUtcOffset() {
            copyOnWrite();
            ((DateTime) this.instance).clearUtcOffset();
            return this;
        }

        @Override // com.google.type.DateTimeOrBuilder
        public final boolean hasTimeZone() {
            return ((DateTime) this.instance).hasTimeZone();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public final TimeZone getTimeZone() {
            return ((DateTime) this.instance).getTimeZone();
        }

        public final Builder setTimeZone(TimeZone timeZone) {
            copyOnWrite();
            ((DateTime) this.instance).setTimeZone(timeZone);
            return this;
        }

        public final Builder setTimeZone(TimeZone.Builder builder) {
            copyOnWrite();
            ((DateTime) this.instance).setTimeZone(builder.build());
            return this;
        }

        public final Builder mergeTimeZone(TimeZone timeZone) {
            copyOnWrite();
            ((DateTime) this.instance).mergeTimeZone(timeZone);
            return this;
        }

        public final Builder clearTimeZone() {
            copyOnWrite();
            ((DateTime) this.instance).clearTimeZone();
            return this;
        }
    }

    /* renamed from: com.google.type.DateTime$1  reason: invalid class name */
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
                return new DateTime();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0001\u0000\u0001\t\t\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004\u0004\u0004\u0005\u0004\u0006\u0004\u0007\u0004\b<\u0000\t<\u0000", new Object[]{"timeOffset_", "timeOffsetCase_", "year_", AnalyticsContext.KEY_MONTH, "day_", "hours_", "minutes_", "seconds_", "nanos_", Duration.class, TimeZone.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<DateTime> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (DateTime.class) {
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
        DateTime dateTime = new DateTime();
        DEFAULT_INSTANCE = dateTime;
        GeneratedMessageLite.registerDefaultInstance(DateTime.class, dateTime);
    }

    public static DateTime getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<DateTime> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
