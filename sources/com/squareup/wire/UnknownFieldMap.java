package com.squareup.wire;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import okio.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class UnknownFieldMap {
    Map<Integer, List<FieldValue>> fieldMap;

    /* loaded from: classes8.dex */
    enum UnknownFieldType {
        VARINT,
        FIXED32,
        FIXED64,
        LENGTH_DELIMITED;

        public static UnknownFieldType of(String str) {
            if ("varint".equals(str)) {
                return VARINT;
            }
            if ("fixed32".equals(str)) {
                return FIXED32;
            }
            if ("fixed64".equals(str)) {
                return FIXED64;
            }
            if ("length-delimited".equals(str)) {
                return LENGTH_DELIMITED;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown type ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static abstract class FieldValue {
        private final int tag;
        private final WireType wireType;

        public abstract int getSerializedSize();

        public abstract void write(int i, WireOutput wireOutput) throws IOException;

        public FieldValue(int i, WireType wireType) {
            this.tag = i;
            this.wireType = wireType;
        }

        public static VarintFieldValue varint(int i, Long l) {
            return new VarintFieldValue(i, l);
        }

        public static Fixed32FieldValue fixed32(int i, Integer num) {
            return new Fixed32FieldValue(i, num);
        }

        public static Fixed64FieldValue fixed64(int i, Long l) {
            return new Fixed64FieldValue(i, l);
        }

        public static LengthDelimitedFieldValue lengthDelimited(int i, ByteString byteString) {
            return new LengthDelimitedFieldValue(i, byteString);
        }

        public int getTag() {
            return this.tag;
        }

        public WireType getWireType() {
            return this.wireType;
        }

        public Integer getAsInteger() {
            throw new IllegalStateException();
        }

        public Long getAsLong() {
            throw new IllegalStateException();
        }

        public ByteString getAsBytes() {
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class VarintFieldValue extends FieldValue {
        private final Long value;

        public VarintFieldValue(int i, Long l) {
            super(i, WireType.VARINT);
            this.value = l;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public final int getSerializedSize() {
            return WireOutput.varint64Size(this.value.longValue());
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public final void write(int i, WireOutput wireOutput) throws IOException {
            wireOutput.writeTag(i, WireType.VARINT);
            wireOutput.writeVarint64(this.value.longValue());
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public final Long getAsLong() {
            return this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Fixed32FieldValue extends FieldValue {
        private final Integer value;

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public final int getSerializedSize() {
            return 4;
        }

        public Fixed32FieldValue(int i, Integer num) {
            super(i, WireType.FIXED32);
            this.value = num;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public final void write(int i, WireOutput wireOutput) throws IOException {
            wireOutput.writeTag(i, WireType.FIXED32);
            wireOutput.writeFixed32(this.value.intValue());
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public final Integer getAsInteger() {
            return this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Fixed64FieldValue extends FieldValue {
        private final Long value;

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public final int getSerializedSize() {
            return 8;
        }

        public Fixed64FieldValue(int i, Long l) {
            super(i, WireType.FIXED64);
            this.value = l;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public final void write(int i, WireOutput wireOutput) throws IOException {
            wireOutput.writeTag(i, WireType.FIXED64);
            wireOutput.writeFixed64(this.value.longValue());
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public final Long getAsLong() {
            return this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class LengthDelimitedFieldValue extends FieldValue {
        private final ByteString value;

        public LengthDelimitedFieldValue(int i, ByteString byteString) {
            super(i, WireType.LENGTH_DELIMITED);
            this.value = byteString;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public final int getSerializedSize() {
            return WireOutput.varint32Size(this.value.size()) + this.value.size();
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public final void write(int i, WireOutput wireOutput) throws IOException {
            wireOutput.writeTag(i, WireType.LENGTH_DELIMITED);
            wireOutput.writeVarint32(this.value.size());
            wireOutput.writeRawBytes(this.value.toByteArray());
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public final ByteString getAsBytes() {
            return this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnknownFieldMap() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnknownFieldMap(UnknownFieldMap unknownFieldMap) {
        if (unknownFieldMap.fieldMap != null) {
            ensureFieldMap().putAll(unknownFieldMap.fieldMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void addVarint(int i, Long l) throws IOException {
        addElement(ensureFieldMap(), i, l, WireType.VARINT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void addFixed32(int i, Integer num) throws IOException {
        addElement(ensureFieldMap(), i, num, WireType.FIXED32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void addFixed64(int i, Long l) throws IOException {
        addElement(ensureFieldMap(), i, l, WireType.FIXED64);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void addLengthDelimited(int i, ByteString byteString) throws IOException {
        addElement(ensureFieldMap(), i, byteString, WireType.LENGTH_DELIMITED);
    }

    private Map<Integer, List<FieldValue>> ensureFieldMap() {
        if (this.fieldMap == null) {
            this.fieldMap = new TreeMap();
        }
        return this.fieldMap;
    }

    private <T> void addElement(Map<Integer, List<FieldValue>> map, int i, T t, WireType wireType) throws IOException {
        FieldValue varint;
        List<FieldValue> list = map.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList<>();
            map.put(Integer.valueOf(i), list);
        }
        int i2 = AnonymousClass1.$SwitchMap$com$squareup$wire$WireType[wireType.ordinal()];
        if (i2 == 1) {
            varint = FieldValue.varint(i, (Long) t);
        } else if (i2 == 2) {
            varint = FieldValue.fixed32(i, (Integer) t);
        } else if (i2 == 3) {
            varint = FieldValue.fixed64(i, (Long) t);
        } else if (i2 == 4) {
            varint = FieldValue.lengthDelimited(i, (ByteString) t);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unsupported wireType = ");
            sb.append(wireType);
            throw new IllegalArgumentException(sb.toString());
        }
        if (list.size() > 0 && list.get(0).getWireType() != varint.getWireType()) {
            throw new IOException(String.format("Wire type %s differs from previous type %s for tag %s", varint.getWireType(), list.get(0).getWireType(), Integer.valueOf(i)));
        }
        list.add(varint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.squareup.wire.UnknownFieldMap$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$wire$WireType;

        static {
            int[] iArr = new int[WireType.values().length];
            $SwitchMap$com$squareup$wire$WireType = iArr;
            try {
                iArr[WireType.VARINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$squareup$wire$WireType[WireType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$squareup$wire$WireType[WireType.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$squareup$wire$WireType[WireType.LENGTH_DELIMITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getSerializedSize() {
        Map<Integer, List<FieldValue>> map = this.fieldMap;
        int i = 0;
        if (map != null) {
            for (Map.Entry<Integer, List<FieldValue>> entry : map.entrySet()) {
                Iterator<FieldValue> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    i = i + WireOutput.varintTagSize(entry.getKey().intValue()) + it.next().getSerializedSize();
                }
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void write(WireOutput wireOutput) throws IOException {
        Map<Integer, List<FieldValue>> map = this.fieldMap;
        if (map != null) {
            for (Map.Entry<Integer, List<FieldValue>> entry : map.entrySet()) {
                int intValue = entry.getKey().intValue();
                Iterator<FieldValue> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    it.next().write(intValue, wireOutput);
                }
            }
        }
    }
}
