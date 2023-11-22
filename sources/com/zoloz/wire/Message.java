package com.zoloz.wire;

import com.zoloz.wire.MessageAdapter;
import com.zoloz.wire.UnknownFieldMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* loaded from: classes2.dex */
public abstract class Message {
    private static final Wire WIRE = new Wire(new Class[0]);
    private transient int cachedSerializedSize;
    protected transient int hashCode = 0;
    private transient boolean haveCachedSerializedSize;
    private transient UnknownFieldMap unknownFields;

    /* loaded from: classes2.dex */
    public enum Datatype {
        INT32(1),
        INT64(2),
        UINT32(3),
        UINT64(4),
        SINT32(5),
        SINT64(6),
        BOOL(7),
        ENUM(8),
        STRING(9),
        BYTES(10),
        MESSAGE(11),
        FIXED32(12),
        SFIXED32(13),
        FIXED64(14),
        SFIXED64(15),
        FLOAT(16),
        DOUBLE(17);

        public static final Comparator<Datatype> ORDER_BY_NAME;
        private static final Map<String, Datatype> TYPES_BY_NAME;
        private final int value;

        static {
            Datatype datatype = INT32;
            Datatype datatype2 = INT64;
            Datatype datatype3 = UINT32;
            Datatype datatype4 = UINT64;
            Datatype datatype5 = SINT32;
            Datatype datatype6 = SINT64;
            Datatype datatype7 = BOOL;
            Datatype datatype8 = ENUM;
            Datatype datatype9 = STRING;
            Datatype datatype10 = BYTES;
            Datatype datatype11 = MESSAGE;
            Datatype datatype12 = FIXED32;
            Datatype datatype13 = SFIXED32;
            Datatype datatype14 = FIXED64;
            Datatype datatype15 = SFIXED64;
            Datatype datatype16 = FLOAT;
            Datatype datatype17 = DOUBLE;
            ORDER_BY_NAME = new Comparator<Datatype>() { // from class: com.zoloz.wire.Message.Datatype.1
                @Override // java.util.Comparator
                public final int compare(Datatype datatype18, Datatype datatype19) {
                    return datatype18.name().compareTo(datatype19.name());
                }
            };
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            TYPES_BY_NAME = linkedHashMap;
            linkedHashMap.put("int32", datatype);
            linkedHashMap.put("int64", datatype2);
            linkedHashMap.put("uint32", datatype3);
            linkedHashMap.put("uint64", datatype4);
            linkedHashMap.put("sint32", datatype5);
            linkedHashMap.put("sint64", datatype6);
            linkedHashMap.put("bool", datatype7);
            linkedHashMap.put("enum", datatype8);
            linkedHashMap.put("string", datatype9);
            linkedHashMap.put("bytes", datatype10);
            linkedHashMap.put("message", datatype11);
            linkedHashMap.put("fixed32", datatype12);
            linkedHashMap.put("sfixed32", datatype13);
            linkedHashMap.put("fixed64", datatype14);
            linkedHashMap.put("sfixed64", datatype15);
            linkedHashMap.put("float", datatype16);
            linkedHashMap.put("double", datatype17);
        }

        Datatype(int i) {
            this.value = i;
        }

        public final int value() {
            return this.value;
        }

        public final WireType wireType() {
            switch (AnonymousClass1.$SwitchMap$com$squareup$wire$Message$Datatype[ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    return WireType.VARINT;
                case 9:
                case 10:
                case 11:
                    return WireType.FIXED32;
                case 12:
                case 13:
                case 14:
                    return WireType.FIXED64;
                case 15:
                case 16:
                case 17:
                    return WireType.LENGTH_DELIMITED;
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("No wiretype for datatype ");
                    sb.append(this);
                    throw new AssertionError(sb.toString());
            }
        }

        public static Datatype of(String str) {
            return TYPES_BY_NAME.get(str);
        }
    }

    /* renamed from: com.zoloz.wire.Message$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$wire$Message$Datatype;

        static {
            int[] iArr = new int[Datatype.values().length];
            $SwitchMap$com$squareup$wire$Message$Datatype = iArr;
            try {
                iArr[Datatype.INT32.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Datatype.INT64.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Datatype.UINT32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Datatype.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Datatype.SINT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Datatype.SINT64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Datatype.BOOL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Datatype.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Datatype.FIXED32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Datatype.SFIXED32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Datatype.FLOAT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Datatype.FIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Datatype.SFIXED64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Datatype.DOUBLE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Datatype.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Datatype.BYTES.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Datatype.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum Label {
        REQUIRED(32),
        OPTIONAL(64),
        REPEATED(128),
        PACKED(256);

        public static final Comparator<Label> ORDER_BY_NAME = new Comparator<Label>() { // from class: com.zoloz.wire.Message.Label.1
            @Override // java.util.Comparator
            public final int compare(Label label, Label label2) {
                return label.name().compareTo(label2.name());
            }
        };
        private final int value;

        Label(int i) {
            this.value = i;
        }

        public final int value() {
            return this.value;
        }

        public final boolean isRepeated() {
            return this == REPEATED || this == PACKED;
        }

        public final boolean isPacked() {
            return this == PACKED;
        }
    }

    public Message(Message message) {
        UnknownFieldMap unknownFieldMap;
        if (message == null || (unknownFieldMap = message.unknownFields) == null) {
            return;
        }
        this.unknownFields = new UnknownFieldMap(unknownFieldMap);
    }

    public Message() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setBuilder(Builder builder) {
        if (builder.unknownFieldMap != null) {
            this.unknownFields = new UnknownFieldMap(builder.unknownFieldMap);
        }
    }

    protected Collection<List<UnknownFieldMap.FieldValue>> unknownFields() {
        UnknownFieldMap unknownFieldMap = this.unknownFields;
        return unknownFieldMap == null ? Collections.emptySet() : unknownFieldMap.fieldMap.values();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> List<T> copyOf(List<T> list) {
        if (list == null) {
            return null;
        }
        return new ArrayList(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> List<T> immutableCopyOf(List<T> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return list instanceof MessageAdapter.ImmutableList ? list : Collections.unmodifiableList(new ArrayList(list));
    }

    public static <E extends Enum & ProtoEnum> int intFromEnum(E e) {
        return WIRE.enumAdapter(e.getClass()).toInt(e);
    }

    public static <E extends Enum & ProtoEnum> E enumFromInt(Class<E> cls, int i) {
        return (E) ((Enum) WIRE.enumAdapter(cls).fromInt(i));
    }

    public byte[] toByteArray() {
        checkAvailability();
        return WIRE.messageAdapter(getClass()).toByteArray(this);
    }

    public void writeTo(byte[] bArr) {
        checkAvailability();
        writeTo(bArr, 0, bArr.length);
    }

    public void writeTo(byte[] bArr, int i, int i2) {
        checkAvailability();
        write(WireOutput.newInstance(bArr, i, i2));
    }

    private void write(WireOutput wireOutput) {
        try {
            WIRE.messageAdapter(getClass()).write(this, wireOutput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeUnknownFieldMap(WireOutput wireOutput) throws IOException {
        UnknownFieldMap unknownFieldMap = this.unknownFields;
        if (unknownFieldMap != null) {
            unknownFieldMap.write(wireOutput);
        }
    }

    public int getSerializedSize() {
        if (!this.haveCachedSerializedSize) {
            this.cachedSerializedSize = WIRE.messageAdapter(getClass()).getSerializedSize(this);
            this.haveCachedSerializedSize = true;
        }
        return this.cachedSerializedSize;
    }

    public int getUnknownFieldsSerializedSize() {
        UnknownFieldMap unknownFieldMap = this.unknownFields;
        if (unknownFieldMap == null) {
            return 0;
        }
        return unknownFieldMap.getSerializedSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean equals(List<?> list, List<?> list2) {
        if (list != null && list.isEmpty()) {
            list = null;
        }
        if (list2 != null && list2.isEmpty()) {
            list2 = null;
        }
        return list == list2 || (list != null && list.equals(list2));
    }

    public String toString() {
        return WIRE.messageAdapter(getClass()).toString(this);
    }

    public void addVarint(int i, long j) {
        try {
            ensureUnknownFieldMap().addVarint(i, Long.valueOf(j));
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void addFixed32(int i, int i2) {
        try {
            ensureUnknownFieldMap().addFixed32(i, Integer.valueOf(i2));
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void addFixed64(int i, long j) {
        try {
            ensureUnknownFieldMap().addFixed64(i, Long.valueOf(j));
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void addLengthDelimited(int i, ByteString byteString) {
        try {
            ensureUnknownFieldMap().addLengthDelimited(i, byteString);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnknownFieldMap ensureUnknownFieldMap() {
        if (this.unknownFields == null) {
            this.unknownFields = new UnknownFieldMap();
        }
        return this.unknownFields;
    }

    public void checkAvailability() {
        AvailabilityChecker availabilityChecker = WIRE.availabilityChecker(getClass());
        availabilityChecker.checkRequiredFields(this);
        availabilityChecker.checkForNulls(this);
    }

    public void invalidCachedSerializedSize() {
        this.haveCachedSerializedSize = false;
    }

    /* loaded from: classes8.dex */
    public static abstract class Builder<T extends Message> {
        UnknownFieldMap unknownFieldMap;

        public abstract T build();

        public Builder() {
        }

        public Builder(Message message) {
            if (message == null || message.unknownFields == null) {
                return;
            }
            this.unknownFieldMap = new UnknownFieldMap(message.unknownFields);
        }

        public void addVarint(int i, long j) {
            try {
                ensureUnknownFieldMap().addVarint(i, Long.valueOf(j));
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }

        public void addFixed32(int i, int i2) {
            try {
                ensureUnknownFieldMap().addFixed32(i, Integer.valueOf(i2));
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }

        public void addFixed64(int i, long j) {
            try {
                ensureUnknownFieldMap().addFixed64(i, Long.valueOf(j));
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }

        public void addLengthDelimited(int i, ByteString byteString) {
            try {
                ensureUnknownFieldMap().addLengthDelimited(i, byteString);
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }

        UnknownFieldMap ensureUnknownFieldMap() {
            if (this.unknownFieldMap == null) {
                this.unknownFieldMap = new UnknownFieldMap();
            }
            return this.unknownFieldMap;
        }

        public void checkRequiredFields() {
            Message.WIRE.builderAdapter(getClass()).checkRequiredFields(this);
        }

        protected static <T> List<T> checkForNulls(List<T> list) {
            if (list != null && !list.isEmpty()) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (list.get(i) == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Element at index ");
                        sb.append(i);
                        sb.append(" is null");
                        throw new NullPointerException(sb.toString());
                    }
                }
            }
            return list;
        }
    }
}
