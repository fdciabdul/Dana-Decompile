package com.google.firebase.encoders.proto;

import android.widget.ExpandableListView;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.proto.Protobuf;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;
import o.D;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class ProtobufDataEncoderContext implements ObjectEncoderContext {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final ObjectEncoder<Map.Entry<Object, Object>> DEFAULT_MAP_ENCODER;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static final FieldDescriptor MAP_KEY_DESC;
    private static final FieldDescriptor MAP_VALUE_DESC;
    private static int PlaceComponentResult = 1;
    private static final Charset UTF_8;
    private static long getAuthRequestContext;
    private final ObjectEncoder<Object> fallbackEncoder;
    private final Map<Class<?>, ObjectEncoder<?>> objectEncoders;
    private OutputStream output;
    private final ProtobufValueEncoderContext valueEncoderContext = new ProtobufValueEncoderContext(this);
    private final Map<Class<?>, ValueEncoder<?>> valueEncoders;

    static void BuiltInFictitiousFunctionClassFactory() {
        getAuthRequestContext = -8683903705643917649L;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final /* bridge */ /* synthetic */ ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i) throws IOException {
        try {
            int i2 = PlaceComponentResult + 61;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            try {
                ProtobufDataEncoderContext add = add(fieldDescriptor, i);
                int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 39;
                PlaceComponentResult = i4 % 128;
                if (i4 % 2 != 0) {
                    return add;
                }
                Object[] objArr = null;
                int length = objArr.length;
                return add;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final /* bridge */ /* synthetic */ ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j) throws IOException {
        int i = PlaceComponentResult + 89;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        boolean z = i % 2 != 0;
        ProtobufDataEncoderContext add = add(fieldDescriptor, j);
        if (z) {
            int i2 = 52 / 0;
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 49;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return add;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final /* synthetic */ ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z) throws IOException {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 27;
            PlaceComponentResult = i % 128;
            char c = i % 2 == 0 ? 'M' : (char) 1;
            ProtobufDataEncoderContext add = add(fieldDescriptor, z);
            if (c != 1) {
                Object obj = null;
                obj.hashCode();
            }
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
            return add;
        } catch (Exception e) {
            throw e;
        }
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        Object[] objArr = new Object[1];
        a(1 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), new char[]{'n', 7125, 3399, ';', 2246, 11151, 62785, 52409, 19786}, objArr);
        UTF_8 = Charset.forName(((String) objArr[0]).intern());
        MAP_KEY_DESC = FieldDescriptor.builder("key").withProperty(AtProtobuf.builder().tag(1).build()).build();
        MAP_VALUE_DESC = FieldDescriptor.builder("value").withProperty(AtProtobuf.builder().tag(2).build()).build();
        DEFAULT_MAP_ENCODER = new ObjectEncoder() { // from class: com.google.firebase.encoders.proto.ProtobufDataEncoderContext$$ExternalSyntheticLambda0
            @Override // com.google.firebase.encoders.Encoder
            public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
                ProtobufDataEncoderContext.lambda$static$0((Map.Entry) obj, objectEncoderContext);
            }
        };
        int i = PlaceComponentResult + 49;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? 'A' : 'I') != 'A') {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$static$0(Map.Entry entry, ObjectEncoderContext objectEncoderContext) throws IOException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        objectEncoderContext.add(MAP_KEY_DESC, entry.getKey());
        objectEncoderContext.add(MAP_VALUE_DESC, entry.getValue());
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 59;
            try {
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtobufDataEncoderContext(OutputStream outputStream, Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder) {
        this.output = outputStream;
        this.objectEncoders = map;
        this.valueEncoders = map2;
        this.fallbackEncoder = objectEncoder;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, Object obj) throws IOException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 11;
        PlaceComponentResult = i % 128;
        if ((i % 2 == 0 ? (char) 30 : (char) 2) != 30) {
            return add(FieldDescriptor.of(str), obj);
        }
        try {
            ObjectEncoderContext add = add(FieldDescriptor.of(str), obj);
            int i2 = 63 / 0;
            return add;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, double d) throws IOException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 != 0;
        Object[] objArr = null;
        ObjectEncoderContext add = add(FieldDescriptor.of(str), d);
        if (!z) {
            objArr.hashCode();
        }
        int i2 = PlaceComponentResult + 21;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if (!(i2 % 2 == 0)) {
            int length = objArr.length;
            return add;
        }
        return add;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, int i) throws IOException {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 51;
        PlaceComponentResult = i2 % 128;
        char c = i2 % 2 == 0 ? 'V' : 'W';
        ProtobufDataEncoderContext add = add(FieldDescriptor.of(str), i);
        if (c == 'V') {
            Object obj = null;
            obj.hashCode();
        }
        return add;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, long j) throws IOException {
        int i = PlaceComponentResult + 25;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        ProtobufDataEncoderContext add = add(FieldDescriptor.of(str), j);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 59;
        PlaceComponentResult = i3 % 128;
        if (i3 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
            return add;
        }
        return add;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, boolean z) throws IOException {
        try {
            int i = PlaceComponentResult + 65;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                ProtobufDataEncoderContext add = add(FieldDescriptor.of(str), z);
                int i3 = PlaceComponentResult + 69;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                return add;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) throws IOException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 21;
        PlaceComponentResult = i % 128;
        ObjectEncoderContext add = (i % 2 == 0 ? '?' : '\t') != '?' ? add(fieldDescriptor, obj, true) : add(fieldDescriptor, obj, false);
        int i2 = PlaceComponentResult + 65;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return add;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return add;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj, boolean z) throws IOException {
        Iterator it;
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return this;
            }
            writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(UTF_8);
            writeVarInt32(bytes.length);
            this.output.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator it2 = ((Collection) obj).iterator();
            while (true) {
                if ((it2.hasNext() ? 'I' : '.') == '.') {
                    return this;
                }
                int i = PlaceComponentResult + 99;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if (i % 2 != 0) {
                    add(fieldDescriptor, it2.next(), true);
                } else {
                    add(fieldDescriptor, it2.next(), false);
                }
                int i2 = PlaceComponentResult + 65;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                int i3 = i2 % 2;
            }
        } else if (!(obj instanceof Map)) {
            if (obj instanceof Double) {
                int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 41;
                PlaceComponentResult = i4 % 128;
                int i5 = i4 % 2;
                return add(fieldDescriptor, ((Double) obj).doubleValue(), z);
            } else if (obj instanceof Float) {
                return add(fieldDescriptor, ((Float) obj).floatValue(), z);
            } else {
                if (obj instanceof Number) {
                    return add(fieldDescriptor, ((Number) obj).longValue(), z);
                }
                if (obj instanceof Boolean) {
                    int i6 = PlaceComponentResult + 5;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                    if (i6 % 2 != 0) {
                        ProtobufDataEncoderContext add = add(fieldDescriptor, ((Boolean) obj).booleanValue(), z);
                        int i7 = 40 / 0;
                        return add;
                    }
                    return add(fieldDescriptor, ((Boolean) obj).booleanValue(), z);
                } else if (!(obj instanceof byte[])) {
                    try {
                        ObjectEncoder<?> objectEncoder = this.objectEncoders.get(obj.getClass());
                        if (objectEncoder == null) {
                            ValueEncoder<?> valueEncoder = this.valueEncoders.get(obj.getClass());
                            if (valueEncoder != null) {
                                return doEncode((ValueEncoder<FieldDescriptor>) valueEncoder, fieldDescriptor, (FieldDescriptor) obj, z);
                            }
                            if (obj instanceof ProtoEnum) {
                                return add(fieldDescriptor, ((ProtoEnum) obj).getNumber());
                            }
                            return obj instanceof Enum ? add(fieldDescriptor, ((Enum) obj).ordinal()) : doEncode((ObjectEncoder<FieldDescriptor>) this.fallbackEncoder, fieldDescriptor, (FieldDescriptor) obj, z);
                        }
                        int i8 = KClassImpl$Data$declaredNonStaticMembers$2 + 17;
                        PlaceComponentResult = i8 % 128;
                        if (i8 % 2 == 0) {
                            ProtobufDataEncoderContext doEncode = doEncode((ObjectEncoder<FieldDescriptor>) objectEncoder, fieldDescriptor, (FieldDescriptor) obj, z);
                            int i9 = 43 / 0;
                            return doEncode;
                        }
                        return doEncode((ObjectEncoder<FieldDescriptor>) objectEncoder, fieldDescriptor, (FieldDescriptor) obj, z);
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    byte[] bArr = (byte[]) obj;
                    if (z) {
                        try {
                            int i10 = PlaceComponentResult + 27;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i10 % 128;
                            int i11 = i10 % 2;
                            if (bArr.length == 0) {
                                int i12 = PlaceComponentResult + 57;
                                KClassImpl$Data$declaredNonStaticMembers$2 = i12 % 128;
                                if (i12 % 2 != 0) {
                                    Object[] objArr = null;
                                    int length = objArr.length;
                                    return this;
                                }
                                return this;
                            }
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                    writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
                    writeVarInt32(bArr.length);
                    this.output.write(bArr);
                    return this;
                }
            }
        } else {
            int i13 = KClassImpl$Data$declaredNonStaticMembers$2 + 51;
            PlaceComponentResult = i13 % 128;
            if ((i13 % 2 == 0 ? '\b' : '?') != '\b') {
                it = ((Map) obj).entrySet().iterator();
            } else {
                it = ((Map) obj).entrySet().iterator();
                int i14 = 30 / 0;
            }
            while (true) {
                if ((it.hasNext() ? (char) 16 : 'I') != 16) {
                    return this;
                }
                doEncode((ObjectEncoder<FieldDescriptor>) DEFAULT_MAP_ENCODER, fieldDescriptor, (FieldDescriptor) ((Map.Entry) it.next()), false);
            }
        }
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d) throws IOException {
        int i = PlaceComponentResult + 123;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 == 0) {
            return add(fieldDescriptor, d, true);
        }
        try {
            return add(fieldDescriptor, d, true);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        if ((r6 == com.google.firebase.remoteconfig.FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? '.' : ',') != '.') goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
    
        if ((r6 == 1.0d) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
    
        r5 = com.google.firebase.encoders.proto.ProtobufDataEncoderContext.PlaceComponentResult + 125;
        com.google.firebase.encoders.proto.ProtobufDataEncoderContext.KClassImpl$Data$declaredNonStaticMembers$2 = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.firebase.encoders.ObjectEncoderContext add(com.google.firebase.encoders.FieldDescriptor r5, double r6, boolean r8) throws java.io.IOException {
        /*
            r4 = this;
            r0 = 1
            if (r8 == 0) goto L39
            int r8 = com.google.firebase.encoders.proto.ProtobufDataEncoderContext.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 + 3
            int r1 = r8 % 128
            com.google.firebase.encoders.proto.ProtobufDataEncoderContext.PlaceComponentResult = r1
            int r8 = r8 % 2
            r1 = 0
            if (r8 != 0) goto L12
            r8 = 1
            goto L13
        L12:
            r8 = 0
        L13:
            if (r8 == r0) goto L25
            r1 = 0
            r8 = 46
            int r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r3 != 0) goto L20
            r1 = 46
            goto L22
        L20:
            r1 = 44
        L22:
            if (r1 == r8) goto L2e
            goto L39
        L25:
            r2 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 != 0) goto L2c
            r1 = 1
        L2c:
            if (r1 == 0) goto L39
        L2e:
            int r5 = com.google.firebase.encoders.proto.ProtobufDataEncoderContext.PlaceComponentResult
            int r5 = r5 + 125
            int r6 = r5 % 128
            com.google.firebase.encoders.proto.ProtobufDataEncoderContext.KClassImpl$Data$declaredNonStaticMembers$2 = r6
            int r5 = r5 % 2
            return r4
        L39:
            int r5 = getTag(r5)     // Catch: java.lang.Exception -> L57
            int r5 = r5 << 3
            r5 = r5 | r0
            r4.writeVarInt32(r5)     // Catch: java.lang.Exception -> L57
            java.io.OutputStream r5 = r4.output     // Catch: java.lang.Exception -> L57
            r8 = 8
            java.nio.ByteBuffer r8 = allocateBuffer(r8)     // Catch: java.lang.Exception -> L57
            java.nio.ByteBuffer r6 = r8.putDouble(r6)     // Catch: java.lang.Exception -> L57
            byte[] r6 = r6.array()     // Catch: java.lang.Exception -> L57
            r5.write(r6)     // Catch: java.lang.Exception -> L57
            return r4
        L57:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.encoders.proto.ProtobufDataEncoderContext.add(com.google.firebase.encoders.FieldDescriptor, double, boolean):com.google.firebase.encoders.ObjectEncoderContext");
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f) throws IOException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 37;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
        }
        ObjectEncoderContext add = add(fieldDescriptor, f, true);
        int i2 = PlaceComponentResult + 51;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if ((i2 % 2 != 0 ? 'F' : (char) 25) != 25) {
            int i3 = 11 / 0;
            return add;
        }
        return add;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f, boolean z) throws IOException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        if ((z ? Typography.greater : 'c') == '>') {
            try {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
                if (!(f != 0.0f)) {
                    return this;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        writeVarInt32((getTag(fieldDescriptor) << 3) | 5);
        this.output.write(allocateBuffer(4).putFloat(f).array());
        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 49;
        PlaceComponentResult = i5 % 128;
        if (i5 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
            return this;
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, int i) throws IOException {
        try {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
            ProtobufDataEncoderContext add = add(fieldDescriptor, i, true);
            int i4 = PlaceComponentResult + 69;
            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
            int i5 = i4 % 2;
            return add;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.encoders.proto.ProtobufDataEncoderContext$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding;

        static {
            int[] iArr = new int[Protobuf.IntEncoding.values().length];
            $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding = iArr;
            try {
                iArr[Protobuf.IntEncoding.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[Protobuf.IntEncoding.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[Protobuf.IntEncoding.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0059, code lost:
    
        if ((r9 == 3) != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005c, code lost:
    
        if (r9 != 2) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005e, code lost:
    
        r0 = com.google.firebase.encoders.proto.ProtobufDataEncoderContext.PlaceComponentResult + 65;
        com.google.firebase.encoders.proto.ProtobufDataEncoderContext.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0067, code lost:
    
        if ((r0 % 2) == 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0069, code lost:
    
        if (r9 != 2) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x006c, code lost:
    
        if (r9 != 3) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x006e, code lost:
    
        writeVarInt32((r7.tag() << 3) | 5);
        r6.output.write(allocateBuffer(4).putInt(r8).array());
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008b, code lost:
    
        writeVarInt32(r7.tag() << 3);
        writeVarInt32((r8 << 1) ^ (r8 >> 31));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.firebase.encoders.proto.ProtobufDataEncoderContext add(com.google.firebase.encoders.FieldDescriptor r7, int r8, boolean r9) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 2
            r2 = 1
            if (r9 == 0) goto L33
            if (r8 != 0) goto L9
            r9 = 1
            goto La
        L9:
            r9 = 0
        La:
            if (r9 == r2) goto Ld
            goto L33
        Ld:
            int r7 = com.google.firebase.encoders.proto.ProtobufDataEncoderContext.PlaceComponentResult
            int r7 = r7 + 53
            int r8 = r7 % 128
            com.google.firebase.encoders.proto.ProtobufDataEncoderContext.KClassImpl$Data$declaredNonStaticMembers$2 = r8
            int r7 = r7 % r1
            if (r7 == 0) goto L1e
            r7 = 60
            int r7 = r7 / r0
            goto L1e
        L1c:
            r7 = move-exception
            throw r7
        L1e:
            int r7 = com.google.firebase.encoders.proto.ProtobufDataEncoderContext.PlaceComponentResult
            int r7 = r7 + 63
            int r8 = r7 % 128
            com.google.firebase.encoders.proto.ProtobufDataEncoderContext.KClassImpl$Data$declaredNonStaticMembers$2 = r8
            int r7 = r7 % r1
            if (r7 == 0) goto L2a
            r2 = 0
        L2a:
            if (r2 == 0) goto L2d
            return r6
        L2d:
            r7 = 17
            int r7 = r7 / r0
            return r6
        L31:
            r7 = move-exception
            throw r7
        L33:
            com.google.firebase.encoders.proto.Protobuf r7 = getProtobuf(r7)
            int[] r9 = com.google.firebase.encoders.proto.ProtobufDataEncoderContext.AnonymousClass1.$SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding
            com.google.firebase.encoders.proto.Protobuf$IntEncoding r3 = r7.intEncoding()
            int r3 = r3.ordinal()
            r9 = r9[r3]
            r3 = 3
            if (r9 == r2) goto L9c
            int r4 = com.google.firebase.encoders.proto.ProtobufDataEncoderContext.KClassImpl$Data$declaredNonStaticMembers$2
            int r4 = r4 + r3
            int r5 = r4 % 128
            com.google.firebase.encoders.proto.ProtobufDataEncoderContext.PlaceComponentResult = r5
            int r4 = r4 % r1
            if (r4 != 0) goto L52
            r4 = 1
            goto L53
        L52:
            r4 = 0
        L53:
            if (r4 == 0) goto L5c
            if (r9 == r3) goto L58
            goto L59
        L58:
            r0 = 1
        L59:
            if (r0 == 0) goto L5e
            goto L8b
        L5c:
            if (r9 == r1) goto L8b
        L5e:
            int r0 = com.google.firebase.encoders.proto.ProtobufDataEncoderContext.PlaceComponentResult
            int r0 = r0 + 65
            int r2 = r0 % 128
            com.google.firebase.encoders.proto.ProtobufDataEncoderContext.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r0 = r0 % r1
            if (r0 == 0) goto L6c
            if (r9 != r1) goto La7
            goto L6e
        L6c:
            if (r9 != r3) goto La7
        L6e:
            int r7 = r7.tag()
            int r7 = r7 << r3
            r7 = r7 | 5
            r6.writeVarInt32(r7)
            java.io.OutputStream r7 = r6.output
            r9 = 4
            java.nio.ByteBuffer r9 = allocateBuffer(r9)
            java.nio.ByteBuffer r8 = r9.putInt(r8)
            byte[] r8 = r8.array()
            r7.write(r8)
            goto La7
        L8b:
            int r7 = r7.tag()
            int r7 = r7 << r3
            r6.writeVarInt32(r7)
            int r7 = r8 << 1
            int r8 = r8 >> 31
            r7 = r7 ^ r8
            r6.writeVarInt32(r7)
            goto La7
        L9c:
            int r7 = r7.tag()
            int r7 = r7 << r3
            r6.writeVarInt32(r7)
            r6.writeVarInt32(r8)
        La7:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.encoders.proto.ProtobufDataEncoderContext.add(com.google.firebase.encoders.FieldDescriptor, int, boolean):com.google.firebase.encoders.proto.ProtobufDataEncoderContext");
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, long j) throws IOException {
        int i = PlaceComponentResult + 13;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 != 0)) {
            return add(fieldDescriptor, j, true);
        }
        try {
            return add(fieldDescriptor, j, true);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
    
        if (r7 == 1) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0025, code lost:
    
        if ((r7 != 0) != true) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0027, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.firebase.encoders.proto.ProtobufDataEncoderContext add(com.google.firebase.encoders.FieldDescriptor r6, long r7, boolean r9) throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            r1 = 1
            if (r9 == 0) goto L6
            r9 = 0
            goto L7
        L6:
            r9 = 1
        L7:
            r2 = 2
            if (r9 == 0) goto Lb
            goto L28
        Lb:
            int r9 = com.google.firebase.encoders.proto.ProtobufDataEncoderContext.KClassImpl$Data$declaredNonStaticMembers$2
            int r9 = r9 + 69
            int r3 = r9 % 128
            com.google.firebase.encoders.proto.ProtobufDataEncoderContext.PlaceComponentResult = r3
            int r9 = r9 % r2
            if (r9 != 0) goto L1d
            r3 = 1
            int r9 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r9 != 0) goto L28
            goto L27
        L1d:
            r3 = 0
            int r9 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r9 != 0) goto L24
            goto L25
        L24:
            r0 = 1
        L25:
            if (r0 == r1) goto L28
        L27:
            return r5
        L28:
            com.google.firebase.encoders.proto.Protobuf r6 = getProtobuf(r6)     // Catch: java.lang.Exception -> L93
            int[] r9 = com.google.firebase.encoders.proto.ProtobufDataEncoderContext.AnonymousClass1.$SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding     // Catch: java.lang.Exception -> L93
            com.google.firebase.encoders.proto.Protobuf$IntEncoding r0 = r6.intEncoding()     // Catch: java.lang.Exception -> L93
            int r0 = r0.ordinal()     // Catch: java.lang.Exception -> L93
            r9 = r9[r0]     // Catch: java.lang.Exception -> L93
            r0 = 3
            if (r9 == r1) goto L87
            int r3 = com.google.firebase.encoders.proto.ProtobufDataEncoderContext.PlaceComponentResult
            int r3 = r3 + 117
            int r4 = r3 % 128
            com.google.firebase.encoders.proto.ProtobufDataEncoderContext.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r3 = r3 % r2
            if (r9 == r2) goto L74
            int r3 = com.google.firebase.encoders.proto.ProtobufDataEncoderContext.PlaceComponentResult
            int r3 = r3 + 53
            int r4 = r3 % 128
            com.google.firebase.encoders.proto.ProtobufDataEncoderContext.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r3 = r3 % r2
            if (r3 == 0) goto L55
            r2 = 5
            if (r9 != r2) goto L92
            goto L57
        L55:
            if (r9 != r0) goto L92
        L57:
            int r6 = r6.tag()
            int r6 = r6 << r0
            r6 = r6 | r1
            r5.writeVarInt32(r6)
            java.io.OutputStream r6 = r5.output
            r9 = 8
            java.nio.ByteBuffer r9 = allocateBuffer(r9)
            java.nio.ByteBuffer r7 = r9.putLong(r7)
            byte[] r7 = r7.array()
            r6.write(r7)
            goto L92
        L74:
            int r6 = r6.tag()
            int r6 = r6 << r0
            r5.writeVarInt32(r6)
            r6 = 63
            long r2 = r7 >> r6
            long r6 = r7 << r1
            long r6 = r6 ^ r2
            r5.writeVarInt64(r6)
            goto L92
        L87:
            int r6 = r6.tag()
            int r6 = r6 << r0
            r5.writeVarInt32(r6)
            r5.writeVarInt64(r7)
        L92:
            return r5
        L93:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.encoders.proto.ProtobufDataEncoderContext.add(com.google.firebase.encoders.FieldDescriptor, long, boolean):com.google.firebase.encoders.proto.ProtobufDataEncoderContext");
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, boolean z) throws IOException {
        int i = PlaceComponentResult + 119;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? 'R' : (char) 31) != 31) {
            return add(fieldDescriptor, z, true);
        }
        try {
            return add(fieldDescriptor, z, true);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, boolean z, boolean z2) throws IOException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 37;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        ProtobufDataEncoderContext add = add(fieldDescriptor, z ? 1 : 0, z2);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 81;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return add;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext inline(Object obj) throws IOException {
        try {
            int i = PlaceComponentResult + 93;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            ProtobufDataEncoderContext encode = encode(obj);
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 109;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return encode;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ProtobufDataEncoderContext encode(Object obj) throws IOException {
        if ((obj == null ? 'L' : 'a') != 'a') {
            int i = PlaceComponentResult + 75;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            return this;
        }
        try {
            try {
                ObjectEncoder<?> objectEncoder = this.objectEncoders.get(obj.getClass());
                if (objectEncoder != null) {
                    int i3 = PlaceComponentResult + 47;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    int i4 = i3 % 2;
                    objectEncoder.encode(obj, this);
                    return this;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("No encoder for ");
                sb.append(obj.getClass());
                throw new EncodingException(sb.toString());
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext nested(String str) throws IOException {
        ObjectEncoderContext nested;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
        PlaceComponentResult = i % 128;
        Object obj = null;
        if ((i % 2 == 0 ? (char) 3 : '5') != '5') {
            try {
                nested = nested(FieldDescriptor.of(str));
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } else {
            nested = nested(FieldDescriptor.of(str));
        }
        int i2 = PlaceComponentResult + 109;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if (!(i2 % 2 == 0)) {
            obj.hashCode();
            return nested;
        }
        return nested;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext nested(FieldDescriptor fieldDescriptor) throws IOException {
        throw new EncodingException("nested() is not implemented for protobuf encoding.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
    
        if ((r0 == 0) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
    
        if (r0 == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0037, code lost:
    
        return r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T> com.google.firebase.encoders.proto.ProtobufDataEncoderContext doEncode(com.google.firebase.encoders.ObjectEncoder<T> r8, com.google.firebase.encoders.FieldDescriptor r9, T r10, boolean r11) throws java.io.IOException {
        /*
            r7 = this;
            long r0 = r7.determineSize(r8, r10)
            r2 = 76
            if (r11 == 0) goto Lb
            r11 = 76
            goto Ld
        Lb:
            r11 = 91
        Ld:
            r3 = 0
            r4 = 1
            if (r11 == r2) goto L12
            goto L38
        L12:
            int r11 = com.google.firebase.encoders.proto.ProtobufDataEncoderContext.KClassImpl$Data$declaredNonStaticMembers$2
            int r11 = r11 + 55
            int r2 = r11 % 128
            com.google.firebase.encoders.proto.ProtobufDataEncoderContext.PlaceComponentResult = r2
            int r11 = r11 % 2
            r2 = 65
            if (r11 != 0) goto L23
            r11 = 65
            goto L25
        L23:
            r11 = 71
        L25:
            r5 = 0
            if (r11 == r2) goto L33
            int r11 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r11 != 0) goto L2f
            r11 = 1
            goto L30
        L2f:
            r11 = 0
        L30:
            if (r11 == 0) goto L38
            goto L37
        L33:
            int r11 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r11 != 0) goto L38
        L37:
            return r7
        L38:
            int r9 = getTag(r9)
            int r9 = r9 << 3
            r9 = r9 | 2
            r7.writeVarInt32(r9)
            r7.writeVarInt64(r0)
            r8.encode(r10, r7)
            int r8 = com.google.firebase.encoders.proto.ProtobufDataEncoderContext.PlaceComponentResult
            int r8 = r8 + 9
            int r9 = r8 % 128
            com.google.firebase.encoders.proto.ProtobufDataEncoderContext.KClassImpl$Data$declaredNonStaticMembers$2 = r9
            int r8 = r8 % 2
            if (r8 == 0) goto L56
            r3 = 1
        L56:
            if (r3 == r4) goto L59
            return r7
        L59:
            r8 = 0
            r8.hashCode()     // Catch: java.lang.Throwable -> L5e
            return r7
        L5e:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.encoders.proto.ProtobufDataEncoderContext.doEncode(com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.FieldDescriptor, java.lang.Object, boolean):com.google.firebase.encoders.proto.ProtobufDataEncoderContext");
    }

    private <T> long determineSize(ObjectEncoder<T> objectEncoder, T t) throws IOException {
        LengthCountingOutputStream lengthCountingOutputStream = new LengthCountingOutputStream();
        try {
            OutputStream outputStream = this.output;
            this.output = lengthCountingOutputStream;
            try {
                objectEncoder.encode(t, this);
                this.output = outputStream;
                long length = lengthCountingOutputStream.getLength();
                try {
                    lengthCountingOutputStream.close();
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 93;
                    PlaceComponentResult = i % 128;
                    int i2 = i % 2;
                    return length;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Throwable th) {
                this.output = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                lengthCountingOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    private <T> ProtobufDataEncoderContext doEncode(ValueEncoder<T> valueEncoder, FieldDescriptor fieldDescriptor, T t, boolean z) throws IOException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
        PlaceComponentResult = i % 128;
        if ((i % 2 == 0 ? (char) 22 : '.') != 22) {
            this.valueEncoderContext.resetContext(fieldDescriptor, z);
            valueEncoder.encode(t, this.valueEncoderContext);
        } else {
            try {
                this.valueEncoderContext.resetContext(fieldDescriptor, z);
                valueEncoder.encode(t, this.valueEncoderContext);
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
        PlaceComponentResult = i2 % 128;
        if (i2 % 2 == 0) {
            int i3 = 3 / 0;
            return this;
        }
        return this;
    }

    private static ByteBuffer allocateBuffer(int i) {
        int i2 = PlaceComponentResult + 99;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        ByteBuffer order = ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
        try {
            int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
            PlaceComponentResult = i4 % 128;
            if (!(i4 % 2 != 0)) {
                Object obj = null;
                obj.hashCode();
                return order;
            }
            return order;
        } catch (Exception e) {
            throw e;
        }
    }

    private static int getTag(FieldDescriptor fieldDescriptor) {
        int i = PlaceComponentResult + 41;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Protobuf protobuf = (Protobuf) fieldDescriptor.getProperty(Protobuf.class);
        if (protobuf == null) {
            throw new EncodingException("Field has no @Protobuf config");
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
        PlaceComponentResult = i3 % 128;
        boolean z = i3 % 2 == 0;
        int tag = protobuf.tag();
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return tag;
    }

    private static Protobuf getProtobuf(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.getProperty(Protobuf.class);
        if ((protobuf != null ? 'T' : ')') == 'T') {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            try {
                int i3 = PlaceComponentResult + 7;
                try {
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    int i4 = i3 % 2;
                    return protobuf;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private void writeVarInt32(int i) throws IOException {
        while (true) {
            if (((long) (i & (-128))) == 0) {
                this.output.write(i & 127);
                int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 91;
                PlaceComponentResult = i2 % 128;
                int i3 = i2 % 2;
                return;
            }
            int i4 = PlaceComponentResult + 23;
            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
            if ((i4 % 2 != 0 ? (char) 16 : '8') != '8') {
                this.output.write((i & 64) ^ 292);
                i *= 46;
            } else {
                try {
                    try {
                        this.output.write((i & 127) | 128);
                        i >>>= 7;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
            throw e;
        }
    }

    private void writeVarInt64(long j) throws IOException {
        char c;
        while (true) {
            if ((((-128) & j) != 0 ? '\'' : Typography.amp) != '&') {
                int i = PlaceComponentResult + 19;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if (i % 2 != 0) {
                    this.output.write(((int) j) | 90 | 21420);
                    c = 24;
                } else {
                    this.output.write((((int) j) & 127) | 128);
                    c = 7;
                }
                j >>>= c;
            } else {
                this.output.write(((int) j) & 127);
                int i2 = PlaceComponentResult + 123;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                int i3 = i2 % 2;
                return;
            }
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(getAuthRequestContext ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (true) {
            if (!(d.MyBillsEntityDataFactory >= KClassImpl$Data$declaredNonStaticMembers$22.length)) {
                int i2 = $11 + 29;
                $10 = i2 % 128;
                int i3 = i2 % 2;
                try {
                    d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                    KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (getAuthRequestContext ^ 3919452569568103912L)));
                    d.MyBillsEntityDataFactory++;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                String str = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
                int i4 = $10 + 39;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                objArr[0] = str;
                return;
            }
        }
    }
}
