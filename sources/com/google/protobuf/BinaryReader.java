package com.google.protobuf;

import com.google.common.base.Ascii;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class BinaryReader implements Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;

    public abstract int getTotalBytesRead();

    @Override // com.google.protobuf.Reader
    public boolean shouldDiscardUnknownFields() {
        return false;
    }

    /* synthetic */ BinaryReader(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static BinaryReader newInstance(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer.hasArray()) {
            return new SafeHeapReader(byteBuffer, z);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    private BinaryReader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class SafeHeapReader extends BinaryReader {
        private final byte[] buffer;
        private final boolean bufferIsImmutable;
        private int endGroupTag;
        private final int initialPos;
        private int limit;
        private int pos;
        private int tag;

        public SafeHeapReader(ByteBuffer byteBuffer, boolean z) {
            super(null);
            this.bufferIsImmutable = z;
            this.buffer = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            this.pos = arrayOffset;
            this.initialPos = arrayOffset;
            this.limit = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        private boolean isAtEnd() {
            return this.pos == this.limit;
        }

        @Override // com.google.protobuf.BinaryReader
        public final int getTotalBytesRead() {
            return this.pos - this.initialPos;
        }

        @Override // com.google.protobuf.Reader
        public final int getFieldNumber() throws IOException {
            if (isAtEnd()) {
                return Integer.MAX_VALUE;
            }
            int readVarint32 = readVarint32();
            this.tag = readVarint32;
            if (readVarint32 == this.endGroupTag) {
                return Integer.MAX_VALUE;
            }
            return WireFormat.getTagFieldNumber(readVarint32);
        }

        @Override // com.google.protobuf.Reader
        public final int getTag() {
            return this.tag;
        }

        @Override // com.google.protobuf.Reader
        public final boolean skipField() throws IOException {
            int i;
            if (isAtEnd() || (i = this.tag) == this.endGroupTag) {
                return false;
            }
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                skipVarint();
                return true;
            } else if (tagWireType == 1) {
                skipBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipBytes(readVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipGroup();
                return true;
            } else if (tagWireType == 5) {
                skipBytes(4);
                return true;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        @Override // com.google.protobuf.Reader
        public final double readDouble() throws IOException {
            requireWireType(1);
            return Double.longBitsToDouble(readLittleEndian64());
        }

        @Override // com.google.protobuf.Reader
        public final float readFloat() throws IOException {
            requireWireType(5);
            return Float.intBitsToFloat(readLittleEndian32());
        }

        @Override // com.google.protobuf.Reader
        public final long readUInt64() throws IOException {
            requireWireType(0);
            return readVarint64();
        }

        @Override // com.google.protobuf.Reader
        public final long readInt64() throws IOException {
            requireWireType(0);
            return readVarint64();
        }

        @Override // com.google.protobuf.Reader
        public final int readInt32() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.google.protobuf.Reader
        public final long readFixed64() throws IOException {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // com.google.protobuf.Reader
        public final int readFixed32() throws IOException {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // com.google.protobuf.Reader
        public final boolean readBool() throws IOException {
            requireWireType(0);
            return readVarint32() != 0;
        }

        @Override // com.google.protobuf.Reader
        public final String readString() throws IOException {
            return readStringInternal(false);
        }

        @Override // com.google.protobuf.Reader
        public final String readStringRequireUtf8() throws IOException {
            return readStringInternal(true);
        }

        public final String readStringInternal(boolean z) throws IOException {
            requireWireType(2);
            int readVarint32 = readVarint32();
            if (readVarint32 == 0) {
                return "";
            }
            requireBytes(readVarint32);
            if (z) {
                byte[] bArr = this.buffer;
                int i = this.pos;
                if (!Utf8.isValidUtf8(bArr, i, i + readVarint32)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
            }
            String str = new String(this.buffer, this.pos, readVarint32, Internal.UTF_8);
            this.pos += readVarint32;
            return str;
        }

        @Override // com.google.protobuf.Reader
        public final <T> T readMessage(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(2);
            return (T) readMessage(Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        @Override // com.google.protobuf.Reader
        public final <T> T readMessageBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(2);
            return (T) readMessage(schema, extensionRegistryLite);
        }

        private <T> T readMessage(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readVarint32 = readVarint32();
            requireBytes(readVarint32);
            int i = this.limit;
            int i2 = this.pos + readVarint32;
            this.limit = i2;
            try {
                T newInstance = schema.newInstance();
                schema.mergeFrom(newInstance, this, extensionRegistryLite);
                schema.makeImmutable(newInstance);
                if (this.pos == i2) {
                    return newInstance;
                }
                throw InvalidProtocolBufferException.parseFailure();
            } finally {
                this.limit = i;
            }
        }

        @Override // com.google.protobuf.Reader
        public final <T> T readGroup(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(3);
            return (T) readGroup(Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        @Override // com.google.protobuf.Reader
        public final <T> T readGroupBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(3);
            return (T) readGroup(schema, extensionRegistryLite);
        }

        private <T> T readGroup(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            try {
                T newInstance = schema.newInstance();
                schema.mergeFrom(newInstance, this, extensionRegistryLite);
                schema.makeImmutable(newInstance);
                if (this.tag == this.endGroupTag) {
                    return newInstance;
                }
                throw InvalidProtocolBufferException.parseFailure();
            } finally {
                this.endGroupTag = i;
            }
        }

        @Override // com.google.protobuf.Reader
        public final ByteString readBytes() throws IOException {
            ByteString copyFrom;
            requireWireType(2);
            int readVarint32 = readVarint32();
            if (readVarint32 == 0) {
                return ByteString.EMPTY;
            }
            requireBytes(readVarint32);
            if (this.bufferIsImmutable) {
                copyFrom = ByteString.wrap(this.buffer, this.pos, readVarint32);
            } else {
                copyFrom = ByteString.copyFrom(this.buffer, this.pos, readVarint32);
            }
            this.pos += readVarint32;
            return copyFrom;
        }

        @Override // com.google.protobuf.Reader
        public final int readUInt32() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.google.protobuf.Reader
        public final int readEnum() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.google.protobuf.Reader
        public final int readSFixed32() throws IOException {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // com.google.protobuf.Reader
        public final long readSFixed64() throws IOException {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // com.google.protobuf.Reader
        public final int readSInt32() throws IOException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag32(readVarint32());
        }

        @Override // com.google.protobuf.Reader
        public final long readSInt64() throws IOException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag64(readVarint64());
        }

        @Override // com.google.protobuf.Reader
        public final void readDoubleList(List<Double> list) throws IOException {
            int i;
            int i2;
            if (list instanceof DoubleArrayList) {
                DoubleArrayList doubleArrayList = (DoubleArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 1) {
                    if (tagWireType == 2) {
                        int readVarint32 = readVarint32();
                        verifyPackedFixed64Length(readVarint32);
                        int i3 = this.pos;
                        while (this.pos < i3 + readVarint32) {
                            doubleArrayList.addDouble(Double.longBitsToDouble(readLittleEndian64_NoCheck()));
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    doubleArrayList.addDouble(readDouble());
                    if (isAtEnd()) {
                        return;
                    }
                    i2 = this.pos;
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 1) {
                if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed64Length(readVarint322);
                    int i4 = this.pos;
                    while (this.pos < i4 + readVarint322) {
                        list.add(Double.valueOf(Double.longBitsToDouble(readLittleEndian64_NoCheck())));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Double.valueOf(readDouble()));
                if (isAtEnd()) {
                    return;
                }
                i = this.pos;
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // com.google.protobuf.Reader
        public final void readFloatList(List<Float> list) throws IOException {
            int i;
            int i2;
            if (list instanceof FloatArrayList) {
                FloatArrayList floatArrayList = (FloatArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed32Length(readVarint32);
                    int i3 = this.pos;
                    while (this.pos < i3 + readVarint32) {
                        floatArrayList.addFloat(Float.intBitsToFloat(readLittleEndian32_NoCheck()));
                    }
                    return;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    floatArrayList.addFloat(readFloat());
                    if (isAtEnd()) {
                        return;
                    }
                    i2 = this.pos;
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 == 2) {
                int readVarint322 = readVarint32();
                verifyPackedFixed32Length(readVarint322);
                int i4 = this.pos;
                while (this.pos < i4 + readVarint322) {
                    list.add(Float.valueOf(Float.intBitsToFloat(readLittleEndian32_NoCheck())));
                }
                return;
            }
            if (tagWireType2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Float.valueOf(readFloat()));
                if (isAtEnd()) {
                    return;
                }
                i = this.pos;
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // com.google.protobuf.Reader
        public final void readUInt64List(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int readVarint32 = this.pos + readVarint32();
                        while (this.pos < readVarint32) {
                            longArrayList.addLong(readVarint64());
                        }
                        requirePosition(readVarint32);
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    longArrayList.addLong(readUInt64());
                    if (isAtEnd()) {
                        return;
                    }
                    i2 = this.pos;
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Long.valueOf(readVarint64()));
                    }
                    requirePosition(readVarint322);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Long.valueOf(readUInt64()));
                if (isAtEnd()) {
                    return;
                }
                i = this.pos;
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // com.google.protobuf.Reader
        public final void readInt64List(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int readVarint32 = this.pos + readVarint32();
                        while (this.pos < readVarint32) {
                            longArrayList.addLong(readVarint64());
                        }
                        requirePosition(readVarint32);
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    longArrayList.addLong(readInt64());
                    if (isAtEnd()) {
                        return;
                    }
                    i2 = this.pos;
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Long.valueOf(readVarint64()));
                    }
                    requirePosition(readVarint322);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Long.valueOf(readInt64()));
                if (isAtEnd()) {
                    return;
                }
                i = this.pos;
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // com.google.protobuf.Reader
        public final void readInt32List(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int readVarint32 = this.pos + readVarint32();
                        while (this.pos < readVarint32) {
                            intArrayList.addInt(readVarint32());
                        }
                        requirePosition(readVarint32);
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    intArrayList.addInt(readInt32());
                    if (isAtEnd()) {
                        return;
                    }
                    i2 = this.pos;
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Integer.valueOf(readVarint32()));
                    }
                    requirePosition(readVarint322);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(readInt32()));
                if (isAtEnd()) {
                    return;
                }
                i = this.pos;
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // com.google.protobuf.Reader
        public final void readFixed64List(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 1) {
                    if (tagWireType == 2) {
                        int readVarint32 = readVarint32();
                        verifyPackedFixed64Length(readVarint32);
                        int i3 = this.pos;
                        while (this.pos < i3 + readVarint32) {
                            longArrayList.addLong(readLittleEndian64_NoCheck());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    longArrayList.addLong(readFixed64());
                    if (isAtEnd()) {
                        return;
                    }
                    i2 = this.pos;
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 1) {
                if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed64Length(readVarint322);
                    int i4 = this.pos;
                    while (this.pos < i4 + readVarint322) {
                        list.add(Long.valueOf(readLittleEndian64_NoCheck()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Long.valueOf(readFixed64()));
                if (isAtEnd()) {
                    return;
                }
                i = this.pos;
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // com.google.protobuf.Reader
        public final void readFixed32List(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed32Length(readVarint32);
                    int i3 = this.pos;
                    while (this.pos < i3 + readVarint32) {
                        intArrayList.addInt(readLittleEndian32_NoCheck());
                    }
                    return;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    intArrayList.addInt(readFixed32());
                    if (isAtEnd()) {
                        return;
                    }
                    i2 = this.pos;
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 == 2) {
                int readVarint322 = readVarint32();
                verifyPackedFixed32Length(readVarint322);
                int i4 = this.pos;
                while (this.pos < i4 + readVarint322) {
                    list.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                }
                return;
            }
            if (tagWireType2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(readFixed32()));
                if (isAtEnd()) {
                    return;
                }
                i = this.pos;
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // com.google.protobuf.Reader
        public final void readBoolList(List<Boolean> list) throws IOException {
            int i;
            int i2;
            if (list instanceof BooleanArrayList) {
                BooleanArrayList booleanArrayList = (BooleanArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int readVarint32 = this.pos + readVarint32();
                        while (this.pos < readVarint32) {
                            booleanArrayList.addBoolean(readVarint32() != 0);
                        }
                        requirePosition(readVarint32);
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    booleanArrayList.addBoolean(readBool());
                    if (isAtEnd()) {
                        return;
                    }
                    i2 = this.pos;
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Boolean.valueOf(readVarint32() != 0));
                    }
                    requirePosition(readVarint322);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Boolean.valueOf(readBool()));
                if (isAtEnd()) {
                    return;
                }
                i = this.pos;
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // com.google.protobuf.Reader
        public final void readStringList(List<String> list) throws IOException {
            readStringListInternal(list, false);
        }

        @Override // com.google.protobuf.Reader
        public final void readStringListRequireUtf8(List<String> list) throws IOException {
            readStringListInternal(list, true);
        }

        public final void readStringListInternal(List<String> list, boolean z) throws IOException {
            int i;
            int i2;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            if ((list instanceof LazyStringList) && !z) {
                LazyStringList lazyStringList = (LazyStringList) list;
                do {
                    lazyStringList.add(readBytes());
                    if (isAtEnd()) {
                        return;
                    }
                    i2 = this.pos;
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            do {
                list.add(readStringInternal(z));
                if (isAtEnd()) {
                    return;
                }
                i = this.pos;
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // com.google.protobuf.Reader
        public final <T> void readMessageList(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            readMessageList(list, Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Reader
        public final <T> void readMessageList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int i2 = this.tag;
            do {
                list.add(readMessage(schema, extensionRegistryLite));
                if (isAtEnd()) {
                    return;
                }
                i = this.pos;
            } while (readVarint32() == i2);
            this.pos = i;
        }

        @Override // com.google.protobuf.Reader
        public final <T> void readGroupList(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            readGroupList(list, Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Reader
        public final <T> void readGroupList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i;
            if (WireFormat.getTagWireType(this.tag) != 3) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int i2 = this.tag;
            do {
                list.add(readGroup(schema, extensionRegistryLite));
                if (isAtEnd()) {
                    return;
                }
                i = this.pos;
            } while (readVarint32() == i2);
            this.pos = i;
        }

        @Override // com.google.protobuf.Reader
        public final void readBytesList(List<ByteString> list) throws IOException {
            int i;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(readBytes());
                if (isAtEnd()) {
                    return;
                }
                i = this.pos;
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // com.google.protobuf.Reader
        public final void readUInt32List(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int readVarint32 = readVarint32();
                        int i3 = this.pos;
                        while (this.pos < i3 + readVarint32) {
                            intArrayList.addInt(readVarint32());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    intArrayList.addInt(readUInt32());
                    if (isAtEnd()) {
                        return;
                    }
                    i2 = this.pos;
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    int i4 = this.pos;
                    while (this.pos < i4 + readVarint322) {
                        list.add(Integer.valueOf(readVarint32()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(readUInt32()));
                if (isAtEnd()) {
                    return;
                }
                i = this.pos;
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // com.google.protobuf.Reader
        public final void readEnumList(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int readVarint32 = readVarint32();
                        int i3 = this.pos;
                        while (this.pos < i3 + readVarint32) {
                            intArrayList.addInt(readVarint32());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    intArrayList.addInt(readEnum());
                    if (isAtEnd()) {
                        return;
                    }
                    i2 = this.pos;
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    int i4 = this.pos;
                    while (this.pos < i4 + readVarint322) {
                        list.add(Integer.valueOf(readVarint32()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(readEnum()));
                if (isAtEnd()) {
                    return;
                }
                i = this.pos;
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // com.google.protobuf.Reader
        public final void readSFixed32List(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed32Length(readVarint32);
                    int i3 = this.pos;
                    while (this.pos < i3 + readVarint32) {
                        intArrayList.addInt(readLittleEndian32_NoCheck());
                    }
                    return;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    intArrayList.addInt(readSFixed32());
                    if (isAtEnd()) {
                        return;
                    }
                    i2 = this.pos;
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 == 2) {
                int readVarint322 = readVarint32();
                verifyPackedFixed32Length(readVarint322);
                int i4 = this.pos;
                while (this.pos < i4 + readVarint322) {
                    list.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                }
                return;
            }
            if (tagWireType2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(readSFixed32()));
                if (isAtEnd()) {
                    return;
                }
                i = this.pos;
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // com.google.protobuf.Reader
        public final void readSFixed64List(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 1) {
                    if (tagWireType == 2) {
                        int readVarint32 = readVarint32();
                        verifyPackedFixed64Length(readVarint32);
                        int i3 = this.pos;
                        while (this.pos < i3 + readVarint32) {
                            longArrayList.addLong(readLittleEndian64_NoCheck());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    longArrayList.addLong(readSFixed64());
                    if (isAtEnd()) {
                        return;
                    }
                    i2 = this.pos;
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 1) {
                if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed64Length(readVarint322);
                    int i4 = this.pos;
                    while (this.pos < i4 + readVarint322) {
                        list.add(Long.valueOf(readLittleEndian64_NoCheck()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Long.valueOf(readSFixed64()));
                if (isAtEnd()) {
                    return;
                }
                i = this.pos;
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // com.google.protobuf.Reader
        public final void readSInt32List(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int readVarint32 = readVarint32();
                        int i3 = this.pos;
                        while (this.pos < i3 + readVarint32) {
                            intArrayList.addInt(CodedInputStream.decodeZigZag32(readVarint32()));
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    intArrayList.addInt(readSInt32());
                    if (isAtEnd()) {
                        return;
                    }
                    i2 = this.pos;
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    int i4 = this.pos;
                    while (this.pos < i4 + readVarint322) {
                        list.add(Integer.valueOf(CodedInputStream.decodeZigZag32(readVarint32())));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(readSInt32()));
                if (isAtEnd()) {
                    return;
                }
                i = this.pos;
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // com.google.protobuf.Reader
        public final void readSInt64List(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int readVarint32 = readVarint32();
                        int i3 = this.pos;
                        while (this.pos < i3 + readVarint32) {
                            longArrayList.addLong(CodedInputStream.decodeZigZag64(readVarint64()));
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    longArrayList.addLong(readSInt64());
                    if (isAtEnd()) {
                        return;
                    }
                    i2 = this.pos;
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    int i4 = this.pos;
                    while (this.pos < i4 + readVarint322) {
                        list.add(Long.valueOf(CodedInputStream.decodeZigZag64(readVarint64())));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Long.valueOf(readSInt64()));
                if (isAtEnd()) {
                    return;
                }
                i = this.pos;
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Reader
        public final <K, V> void readMap(Map<K, V> map, MapEntryLite.Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(2);
            int readVarint32 = readVarint32();
            requireBytes(readVarint32);
            int i = this.limit;
            this.limit = this.pos + readVarint32;
            try {
                Object obj = metadata.defaultKey;
                Object obj2 = metadata.defaultValue;
                while (true) {
                    int fieldNumber = getFieldNumber();
                    if (fieldNumber == Integer.MAX_VALUE) {
                        map.put(obj, obj2);
                        return;
                    } else if (fieldNumber == 1) {
                        obj = readField(metadata.keyType, null, null);
                    } else if (fieldNumber == 2) {
                        obj2 = readField(metadata.valueType, metadata.defaultValue.getClass(), extensionRegistryLite);
                    } else {
                        try {
                            if (!skipField()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                                break;
                            }
                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                            if (!skipField()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                            }
                        }
                    }
                }
            } finally {
                this.limit = i;
            }
        }

        private Object readField(WireFormat.FieldType fieldType, Class<?> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
                case 1:
                    return Boolean.valueOf(readBool());
                case 2:
                    return readBytes();
                case 3:
                    return Double.valueOf(readDouble());
                case 4:
                    return Integer.valueOf(readEnum());
                case 5:
                    return Integer.valueOf(readFixed32());
                case 6:
                    return Long.valueOf(readFixed64());
                case 7:
                    return Float.valueOf(readFloat());
                case 8:
                    return Integer.valueOf(readInt32());
                case 9:
                    return Long.valueOf(readInt64());
                case 10:
                    return readMessage(cls, extensionRegistryLite);
                case 11:
                    return Integer.valueOf(readSFixed32());
                case 12:
                    return Long.valueOf(readSFixed64());
                case 13:
                    return Integer.valueOf(readSInt32());
                case 14:
                    return Long.valueOf(readSInt64());
                case 15:
                    return readStringRequireUtf8();
                case 16:
                    return Integer.valueOf(readUInt32());
                case 17:
                    return Long.valueOf(readUInt64());
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        private int readVarint32() throws IOException {
            int i;
            int i2 = this.pos;
            int i3 = this.limit;
            if (i3 == i2) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.pos = i4;
                return b;
            } else if (i3 - i4 < 9) {
                return (int) readVarint64SlowPath();
            } else {
                int i5 = i4 + 1;
                int i6 = b ^ (bArr[i4] << 7);
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i5 + 1;
                    int i8 = i6 ^ (bArr[i5] << 14);
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        i5 = i7 + 1;
                        int i9 = i8 ^ (bArr[i7] << Ascii.NAK);
                        if (i9 < 0) {
                            i = i9 ^ (-2080896);
                        } else {
                            i7 = i5 + 1;
                            byte b2 = bArr[i5];
                            i = (i9 ^ (b2 << Ascii.FS)) ^ 266354560;
                            if (b2 < 0) {
                                i5 = i7 + 1;
                                if (bArr[i7] < 0) {
                                    i7 = i5 + 1;
                                    if (bArr[i5] < 0) {
                                        i5 = i7 + 1;
                                        if (bArr[i7] < 0) {
                                            i7 = i5 + 1;
                                            if (bArr[i5] < 0) {
                                                i5 = i7 + 1;
                                                if (bArr[i7] < 0) {
                                                    throw InvalidProtocolBufferException.malformedVarint();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i5 = i7;
                }
                this.pos = i5;
                return i;
            }
        }

        public final long readVarint64() throws IOException {
            long j;
            long j2;
            long j3;
            long j4;
            long j5;
            int i;
            int i2 = this.pos;
            int i3 = this.limit;
            if (i3 == i2) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.pos = i4;
                return b;
            } else if (i3 - i4 < 9) {
                return readVarint64SlowPath();
            } else {
                int i5 = i4 + 1;
                int i6 = b ^ (bArr[i4] << 7);
                if (i6 >= 0) {
                    int i7 = i5 + 1;
                    int i8 = i6 ^ (bArr[i5] << 14);
                    if (i8 >= 0) {
                        j2 = i8 ^ 16256;
                    } else {
                        i5 = i7 + 1;
                        int i9 = i8 ^ (bArr[i7] << Ascii.NAK);
                        if (i9 >= 0) {
                            long j6 = i9;
                            int i10 = i5 + 1;
                            long j7 = j6 ^ (bArr[i5] << 28);
                            if (j7 < 0) {
                                i5 = i10 + 1;
                                long j8 = j7 ^ (bArr[i10] << 35);
                                if (j8 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i10 = i5 + 1;
                                    j7 = j8 ^ (bArr[i5] << 42);
                                    if (j7 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i5 = i10 + 1;
                                        j8 = j7 ^ (bArr[i10] << 49);
                                        if (j8 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            int i11 = i5 + 1;
                                            j = (j8 ^ (bArr[i5] << 56)) ^ 71499008037633920L;
                                            if (j < 0) {
                                                i5 = i11 + 1;
                                                if (bArr[i11] < 0) {
                                                    throw InvalidProtocolBufferException.malformedVarint();
                                                }
                                                j5 = j;
                                                this.pos = i5;
                                                return j5;
                                            }
                                            i7 = i11;
                                            j2 = j;
                                        }
                                    }
                                }
                                j = j8 ^ j3;
                                j5 = j;
                                this.pos = i5;
                                return j5;
                            }
                            j4 = 266354560;
                            j5 = j4 ^ j7;
                            i5 = i10;
                            this.pos = i5;
                            return j5;
                        }
                        i = i9 ^ (-2080896);
                    }
                    i5 = i7;
                    j5 = j2;
                    this.pos = i5;
                    return j5;
                }
                i = i6 ^ (-128);
                j5 = i;
                this.pos = i5;
                return j5;
            }
        }

        private long readVarint64SlowPath() throws IOException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                j |= (r3 & Byte.MAX_VALUE) << i;
                if ((readByte() & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private byte readByte() throws IOException {
            int i = this.pos;
            if (i == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }

        private int readLittleEndian32() throws IOException {
            requireBytes(4);
            return readLittleEndian32_NoCheck();
        }

        private long readLittleEndian64() throws IOException {
            requireBytes(8);
            return readLittleEndian64_NoCheck();
        }

        private int readLittleEndian32_NoCheck() {
            int i = this.pos;
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        private long readLittleEndian64_NoCheck() {
            int i = this.pos;
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }

        private void skipVarint() throws IOException {
            int i = this.limit;
            int i2 = this.pos;
            if (i - i2 >= 10) {
                byte[] bArr = this.buffer;
                int i3 = 0;
                while (i3 < 10) {
                    int i4 = i2 + 1;
                    if (bArr[i2] >= 0) {
                        this.pos = i4;
                        return;
                    } else {
                        i3++;
                        i2 = i4;
                    }
                }
            }
            skipVarintSlowPath();
        }

        private void skipVarintSlowPath() throws IOException {
            for (int i = 0; i < 10; i++) {
                if (readByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipBytes(int i) throws IOException {
            requireBytes(i);
            this.pos += i;
        }

        private void skipGroup() throws IOException {
            int i = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            while (getFieldNumber() != Integer.MAX_VALUE && skipField()) {
            }
            if (this.tag != this.endGroupTag) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            this.endGroupTag = i;
        }

        private void requireBytes(int i) throws IOException {
            if (i < 0 || i > this.limit - this.pos) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void requireWireType(int i) throws IOException {
            if (WireFormat.getTagWireType(this.tag) != i) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        private void verifyPackedFixed64Length(int i) throws IOException {
            requireBytes(i);
            if ((i & 7) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        private void verifyPackedFixed32Length(int i) throws IOException {
            requireBytes(i);
            if ((i & 3) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        private void requirePosition(int i) throws IOException {
            if (this.pos != i) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }
    }

    /* renamed from: com.google.protobuf.BinaryReader$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }
}
