package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyField;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>> {
    private static final FieldSet DEFAULT_INSTANCE = new FieldSet(true);
    private boolean isImmutable;
    private boolean hasLazyField = false;
    private final SmallSortedMap<FieldDescriptorType, Object> fields = SmallSortedMap.newFieldMap(16);

    /* loaded from: classes.dex */
    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite);

        boolean isPacked();

        boolean isRepeated();
    }

    private FieldSet() {
    }

    private FieldSet(boolean z) {
        makeImmutable();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet<>();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return DEFAULT_INSTANCE;
    }

    public final void makeImmutable() {
        if (this.isImmutable) {
            return;
        }
        this.fields.makeImmutable();
        this.isImmutable = true;
    }

    public final FieldSet<FieldDescriptorType> clone() {
        FieldSet<FieldDescriptorType> newFieldSet = newFieldSet();
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            Map.Entry<FieldDescriptorType, Object> arrayEntryAt = this.fields.getArrayEntryAt(i);
            newFieldSet.setField(arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
            newFieldSet.setField(entry.getKey(), entry.getValue());
        }
        newFieldSet.hasLazyField = this.hasLazyField;
        return newFieldSet;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        if (this.hasLazyField) {
            return new LazyField.LazyIterator(this.fields.entrySet().iterator());
        }
        return this.fields.entrySet().iterator();
    }

    public final boolean hasField(FieldDescriptorType fielddescriptortype) {
        if (fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.fields.get(fielddescriptortype) != null;
    }

    public final Object getField(FieldDescriptorType fielddescriptortype) {
        Object obj = this.fields.get(fielddescriptortype);
        return obj instanceof LazyField ? ((LazyField) obj).getValue() : obj;
    }

    public final void setField(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.isRepeated()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                verifyType(fielddescriptortype.getLiteType(), it.next());
            }
            obj = arrayList;
        } else {
            verifyType(fielddescriptortype.getLiteType(), obj);
        }
        if (obj instanceof LazyField) {
            this.hasLazyField = true;
        }
        this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) obj);
    }

    public final int getRepeatedFieldCount(FieldDescriptorType fielddescriptortype) {
        if (!fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object field = getField(fielddescriptortype);
        if (field == null) {
            return 0;
        }
        return ((List) field).size();
    }

    public final Object getRepeatedField(FieldDescriptorType fielddescriptortype, int i) {
        if (!fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object field = getField(fielddescriptortype);
        if (field == null) {
            throw new IndexOutOfBoundsException();
        }
        return ((List) field).get(i);
    }

    public final void addRepeatedField(FieldDescriptorType fielddescriptortype, Object obj) {
        List list;
        if (!fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        verifyType(fielddescriptortype.getLiteType(), obj);
        Object field = getField(fielddescriptortype);
        if (field == null) {
            list = new ArrayList();
            this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) list);
        } else {
            list = (List) field;
        }
        list.add(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
    
        if ((r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
    
        if ((r3 instanceof byte[]) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        if ((r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.LazyField) == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void verifyType(kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType r2, java.lang.Object r3) {
        /*
            int[] r0 = kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType
            kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$JavaType r2 = r2.getJavaType()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 0
            r1 = 1
            switch(r2) {
                case 1: goto L3d;
                case 2: goto L3a;
                case 3: goto L37;
                case 4: goto L34;
                case 5: goto L31;
                case 6: goto L2e;
                case 7: goto L24;
                case 8: goto L1b;
                case 9: goto L12;
                default: goto L11;
            }
        L11:
            goto L3f
        L12:
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            if (r2 != 0) goto L2c
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.LazyField
            if (r2 == 0) goto L3f
            goto L2c
        L1b:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L2c
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            if (r2 == 0) goto L3f
            goto L2c
        L24:
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.ByteString
            if (r2 != 0) goto L2c
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L3f
        L2c:
            r0 = 1
            goto L3f
        L2e:
            boolean r0 = r3 instanceof java.lang.String
            goto L3f
        L31:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L3f
        L34:
            boolean r0 = r3 instanceof java.lang.Double
            goto L3f
        L37:
            boolean r0 = r3 instanceof java.lang.Float
            goto L3f
        L3a:
            boolean r0 = r3 instanceof java.lang.Long
            goto L3f
        L3d:
            boolean r0 = r3 instanceof java.lang.Integer
        L3f:
            if (r0 == 0) goto L42
            return
        L42:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.verifyType(kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType, java.lang.Object):void");
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            if (!isInitialized(this.fields.getArrayEntryAt(i))) {
                return false;
            }
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            if (!isInitialized(it.next())) {
                return false;
            }
        }
        return true;
    }

    private boolean isInitialized(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            if (key.isRepeated()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((MessageLite) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof MessageLite) {
                    if (!((MessageLite) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof LazyField) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getWireFormatForFieldType(WireFormat.FieldType fieldType, boolean z) {
        if (z) {
            return 2;
        }
        return fieldType.getWireType();
    }

    public final void mergeFrom(FieldSet<FieldDescriptorType> fieldSet) {
        for (int i = 0; i < fieldSet.fields.getNumArrayEntries(); i++) {
            mergeFromField(fieldSet.fields.getArrayEntryAt(i));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = fieldSet.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            mergeFromField(it.next());
        }
    }

    private Object cloneIfMutable(Object obj) {
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return obj;
    }

    private void mergeFromField(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).getValue();
        }
        if (key.isRepeated()) {
            Object field = getField(key);
            if (field == null) {
                field = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) field).add(cloneIfMutable(it.next()));
            }
            this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) key, (FieldDescriptorType) field);
        } else if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            Object field2 = getField(key);
            if (field2 == null) {
                this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) key, (FieldDescriptorType) cloneIfMutable(value));
                return;
            }
            this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) key, (FieldDescriptorType) key.internalMergeFrom(((MessageLite) field2).toBuilder(), (MessageLite) value).build());
        } else {
            this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) key, (FieldDescriptorType) cloneIfMutable(value));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.FieldSet$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = iArr2;
            try {
                iArr2[WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    public static Object readPrimitiveField(CodedInputStream codedInputStream, WireFormat.FieldType fieldType, boolean z) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                return Double.valueOf(codedInputStream.readDouble());
            case 2:
                return Float.valueOf(codedInputStream.readFloat());
            case 3:
                return Long.valueOf(codedInputStream.readInt64());
            case 4:
                return Long.valueOf(codedInputStream.readUInt64());
            case 5:
                return Integer.valueOf(codedInputStream.readInt32());
            case 6:
                return Long.valueOf(codedInputStream.readFixed64());
            case 7:
                return Integer.valueOf(codedInputStream.readFixed32());
            case 8:
                return Boolean.valueOf(codedInputStream.readBool());
            case 9:
                if (z) {
                    return codedInputStream.readStringRequireUtf8();
                }
                return codedInputStream.readString();
            case 10:
                return codedInputStream.readBytes();
            case 11:
                return Integer.valueOf(codedInputStream.readUInt32());
            case 12:
                return Integer.valueOf(codedInputStream.readSFixed32());
            case 13:
                return Long.valueOf(codedInputStream.readSFixed64());
            case 14:
                return Integer.valueOf(codedInputStream.readSInt32());
            case 15:
                return Long.valueOf(codedInputStream.readSInt64());
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static void writeElement(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.writeGroup(i, (MessageLite) obj);
            return;
        }
        codedOutputStream.writeTag(i, getWireFormatForFieldType(fieldType, false));
        writeElementNoTag(codedOutputStream, fieldType, obj);
    }

    private static void writeElementNoTag(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.writeDoubleNoTag(((Double) obj).doubleValue());
                return;
            case 2:
                codedOutputStream.writeFloatNoTag(((Float) obj).floatValue());
                return;
            case 3:
                codedOutputStream.writeInt64NoTag(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.writeUInt64NoTag(((Long) obj).longValue());
                return;
            case 5:
                codedOutputStream.writeInt32NoTag(((Integer) obj).intValue());
                return;
            case 6:
                codedOutputStream.writeFixed64NoTag(((Long) obj).longValue());
                return;
            case 7:
                codedOutputStream.writeFixed32NoTag(((Integer) obj).intValue());
                return;
            case 8:
                codedOutputStream.writeBoolNoTag(((Boolean) obj).booleanValue());
                return;
            case 9:
                codedOutputStream.writeStringNoTag((String) obj);
                return;
            case 10:
                if (obj instanceof ByteString) {
                    codedOutputStream.writeBytesNoTag((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.writeByteArrayNoTag((byte[]) obj);
                    return;
                }
            case 11:
                codedOutputStream.writeUInt32NoTag(((Integer) obj).intValue());
                return;
            case 12:
                codedOutputStream.writeSFixed32NoTag(((Integer) obj).intValue());
                return;
            case 13:
                codedOutputStream.writeSFixed64NoTag(((Long) obj).longValue());
                return;
            case 14:
                codedOutputStream.writeSInt32NoTag(((Integer) obj).intValue());
                return;
            case 15:
                codedOutputStream.writeSInt64NoTag(((Long) obj).longValue());
                return;
            case 16:
                codedOutputStream.writeGroupNoTag((MessageLite) obj);
                return;
            case 17:
                codedOutputStream.writeMessageNoTag((MessageLite) obj);
                return;
            case 18:
                if (obj instanceof Internal.EnumLite) {
                    codedOutputStream.writeEnumNoTag(((Internal.EnumLite) obj).getNumber());
                    return;
                } else {
                    codedOutputStream.writeEnumNoTag(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static void writeField(FieldDescriptorLite<?> fieldDescriptorLite, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (fieldDescriptorLite.isRepeated()) {
            List list = (List) obj;
            if (fieldDescriptorLite.isPacked()) {
                codedOutputStream.writeTag(number, 2);
                int i = 0;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    i += computeElementSizeNoTag(liteType, it.next());
                }
                codedOutputStream.writeRawVarint32(i);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    writeElementNoTag(codedOutputStream, liteType, it2.next());
                }
                return;
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                writeElement(codedOutputStream, liteType, number, it3.next());
            }
        } else if (obj instanceof LazyField) {
            writeElement(codedOutputStream, liteType, number, ((LazyField) obj).getValue());
        } else {
            writeElement(codedOutputStream, liteType, number, obj);
        }
    }

    public final int getSerializedSize() {
        int i = 0;
        for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); i2++) {
            Map.Entry<FieldDescriptorType, Object> arrayEntryAt = this.fields.getArrayEntryAt(i2);
            i += computeFieldSize(arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
            i += computeFieldSize(entry.getKey(), entry.getValue());
        }
        return i;
    }

    private static int computeElementSize(WireFormat.FieldType fieldType, int i, Object obj) {
        int computeTagSize = CodedOutputStream.computeTagSize(i);
        if (fieldType == WireFormat.FieldType.GROUP) {
            computeTagSize *= 2;
        }
        return computeTagSize + computeElementSizeNoTag(fieldType, obj);
    }

    private static int computeElementSizeNoTag(WireFormat.FieldType fieldType, Object obj) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.computeDoubleSizeNoTag(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.computeFloatSizeNoTag(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.computeInt64SizeNoTag(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.computeFixed64SizeNoTag(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.computeFixed32SizeNoTag(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.computeBoolSizeNoTag(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.computeStringSizeNoTag((String) obj);
            case 10:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
                }
                return CodedOutputStream.computeByteArraySizeNoTag((byte[]) obj);
            case 11:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) obj).intValue());
            case 12:
                return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) obj).intValue());
            case 13:
                return CodedOutputStream.computeSFixed64SizeNoTag(((Long) obj).longValue());
            case 14:
                return CodedOutputStream.computeSInt32SizeNoTag(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.computeSInt64SizeNoTag(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite) obj);
            case 17:
                if (obj instanceof LazyField) {
                    return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) obj);
                }
                return CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
            case 18:
                if (obj instanceof Internal.EnumLite) {
                    return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) obj).getNumber());
                }
                return CodedOutputStream.computeEnumSizeNoTag(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int computeFieldSize(FieldDescriptorLite<?> fieldDescriptorLite, Object obj) {
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (fieldDescriptorLite.isRepeated()) {
            int i = 0;
            if (fieldDescriptorLite.isPacked()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i += computeElementSizeNoTag(liteType, it.next());
                }
                return CodedOutputStream.computeTagSize(number) + i + CodedOutputStream.computeRawVarint32Size(i);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                i += computeElementSize(liteType, number, it2.next());
            }
            return i;
        }
        return computeElementSize(liteType, number, obj);
    }
}
