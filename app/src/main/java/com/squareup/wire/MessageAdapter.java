package com.squareup.wire;

import com.squareup.wire.Message;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.text.Typography;
import o.D;
import okio.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class MessageAdapter<M extends Message> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static final String FULL_BLOCK = "█";
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static long MyBillsEntityDataFactory = 5835239203611052682L;
    private static final String REDACTED = "██";
    private final TagMap<FieldInfo> fieldInfoMap;
    private final Class<M> messageType;
    private final Map<String, Integer> tagMap = new LinkedHashMap();
    private final Wire wire;

    /* loaded from: classes3.dex */
    public static final class FieldInfo {
        private final Field builderField;
        final Message.Datatype datatype;
        EnumAdapter<? extends ProtoEnum> enumAdapter;
        final Class<? extends ProtoEnum> enumType;
        final Message.Label label;
        MessageAdapter<? extends Message> messageAdapter;
        private final Field messageField;
        final Class<? extends Message> messageType;
        final String name;
        final boolean redacted;
        final int tag;

        /* synthetic */ FieldInfo(int i, String str, Message.Datatype datatype, Message.Label label, boolean z, Class cls, Field field, Field field2, AnonymousClass1 anonymousClass1) {
            this(i, str, datatype, label, z, cls, field, field2);
        }

        static /* synthetic */ Field access$000(FieldInfo fieldInfo) {
            return fieldInfo.messageField;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private FieldInfo(int i, String str, Message.Datatype datatype, Message.Label label, boolean z, Class<?> cls, Field field, Field field2) {
            this.tag = i;
            this.name = str;
            this.datatype = datatype;
            this.label = label;
            this.redacted = z;
            if (datatype == Message.Datatype.ENUM) {
                this.enumType = cls;
                this.messageType = null;
            } else if (datatype == Message.Datatype.MESSAGE) {
                this.messageType = cls;
                this.enumType = null;
            } else {
                this.enumType = null;
                this.messageType = null;
            }
            this.messageField = field;
            this.builderField = field2;
        }
    }

    final Collection<FieldInfo> getFields() {
        int i = BuiltInFictitiousFunctionClassFactory + 103;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Collection<FieldInfo> values = this.fieldInfoMap.values();
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        return values;
    }

    final FieldInfo getField(String str) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 81;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            Integer num = this.tagMap.get(str);
            Object obj = null;
            if ((num != null ? (char) 5 : 'Q') != 5) {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 83;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    obj.hashCode();
                    return null;
                }
                return null;
            }
            return this.fieldInfoMap.get(num.intValue());
        } catch (Exception e) {
            throw e;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:34:0x0061
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    final java.lang.Object getFieldValue(M r4, com.squareup.wire.MessageAdapter.FieldInfo r5) {
        /*
            r3 = this;
            int r0 = com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 63
            int r1 = r0 % 128
            com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            java.lang.reflect.Field r0 = com.squareup.wire.MessageAdapter.FieldInfo.access$000(r5)
            r1 = 0
            if (r0 == 0) goto L13
            r0 = 0
            goto L14
        L13:
            r0 = 1
        L14:
            if (r0 != 0) goto L59
            int r0 = com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 111
            int r2 = r0 % 128
            com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r0 = r0 % 2
            if (r0 == 0) goto L2f
            java.lang.reflect.Field r5 = com.squareup.wire.MessageAdapter.FieldInfo.access$000(r5)     // Catch: java.lang.IllegalAccessException -> L52
            java.lang.Object r4 = r5.get(r4)     // Catch: java.lang.IllegalAccessException -> L52
            r5 = 0
            int r5 = r5.length     // Catch: java.lang.Throwable -> L2d
            goto L37
        L2d:
            r4 = move-exception
            throw r4
        L2f:
            java.lang.reflect.Field r5 = com.squareup.wire.MessageAdapter.FieldInfo.access$000(r5)     // Catch: java.lang.IllegalAccessException -> L52
            java.lang.Object r4 = r5.get(r4)     // Catch: java.lang.IllegalAccessException -> L52
        L37:
            int r5 = com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 17
            int r0 = r5 % 128
            com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory = r0
            int r5 = r5 % 2
            r0 = 75
            if (r5 != 0) goto L48
            r5 = 74
            goto L4a
        L48:
            r5 = 75
        L4a:
            if (r5 == r0) goto L51
            r5 = 3
            int r5 = r5 / r1
            return r4
        L4f:
            r4 = move-exception
            throw r4
        L51:
            return r4
        L52:
            r4 = move-exception
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>(r4)
            throw r5
        L59:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            java.lang.String r5 = "Field is not of type \"Message\""
            r4.<init>(r5)
            throw r4
        L61:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.MessageAdapter.getFieldValue(com.squareup.wire.Message, com.squareup.wire.MessageAdapter$FieldInfo):java.lang.Object");
    }

    public final void setBuilderField(M m, int i, Object obj) {
        int i2 = BuiltInFictitiousFunctionClassFactory + 65;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        try {
            this.fieldInfoMap.get(i).builderField.set(m, obj);
            int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
            BuiltInFictitiousFunctionClassFactory = i4 % 128;
            if ((i4 % 2 == 0 ? 'H' : Typography.amp) != 'H') {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MessageAdapter(com.squareup.wire.Wire r19, java.lang.Class<M> r20) {
        /*
            r18 = this;
            r1 = r18
            r18.<init>()
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            r1.tagMap = r0
            r0 = r19
            r1.wire = r0
            r0 = r20
            r1.messageType = r0
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            java.lang.reflect.Field[] r0 = r20.getDeclaredFields()
            int r3 = r0.length
            r4 = 0
        L1f:
            if (r4 >= r3) goto Lb5
            int r5 = com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 103
            int r6 = r5 % 128
            com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory = r6
            int r5 = r5 % 2
            r6 = 0
            if (r5 != 0) goto L42
            r5 = r0[r4]
            java.lang.Class<com.squareup.wire.ProtoField> r7 = com.squareup.wire.ProtoField.class
            java.lang.annotation.Annotation r7 = r5.getAnnotation(r7)
            com.squareup.wire.ProtoField r7 = (com.squareup.wire.ProtoField) r7
            r6.hashCode()     // Catch: java.lang.Throwable -> L3f
            if (r7 == 0) goto Laf
        L3d:
            r15 = r5
            goto L4f
        L3f:
            r0 = move-exception
            r2 = r0
            throw r2
        L42:
            r5 = r0[r4]
            java.lang.Class<com.squareup.wire.ProtoField> r7 = com.squareup.wire.ProtoField.class
            java.lang.annotation.Annotation r7 = r5.getAnnotation(r7)     // Catch: java.lang.Exception -> Lb3
            com.squareup.wire.ProtoField r7 = (com.squareup.wire.ProtoField) r7     // Catch: java.lang.Exception -> Lb3
            if (r7 == 0) goto Laf
            goto L3d
        L4f:
            int r9 = r7.tag()
            java.lang.String r10 = r15.getName()
            java.util.Map<java.lang.String, java.lang.Integer> r5 = r1.tagMap
            java.lang.Integer r8 = java.lang.Integer.valueOf(r9)
            r5.put(r10, r8)
            com.squareup.wire.Message$Datatype r11 = r7.type()
            com.squareup.wire.Message$Datatype r5 = com.squareup.wire.Message.Datatype.ENUM
            r8 = 56
            if (r11 != r5) goto L6d
            r5 = 30
            goto L6f
        L6d:
            r5 = 56
        L6f:
            if (r5 == r8) goto L77
            java.lang.Class r6 = r1.getEnumType(r15)
        L75:
            r14 = r6
            goto L94
        L77:
            com.squareup.wire.Message$Datatype r5 = com.squareup.wire.Message.Datatype.MESSAGE     // Catch: java.lang.Exception -> Lb3
            if (r11 != r5) goto L75
            int r5 = com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> Lb3
            int r5 = r5 + 85
            int r6 = r5 % 128
            com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory = r6
            int r5 = r5 % 2
            java.lang.Class r6 = r1.getMessageType(r15)
            int r5 = com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 17
            int r8 = r5 % 128
            com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory = r8
            int r5 = r5 % 2
            goto L75
        L94:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r9)
            com.squareup.wire.MessageAdapter$FieldInfo r6 = new com.squareup.wire.MessageAdapter$FieldInfo
            com.squareup.wire.Message$Label r12 = r7.label()
            boolean r13 = r7.redacted()
            java.lang.reflect.Field r16 = r1.getBuilderField(r10)
            r17 = 0
            r8 = r6
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r2.put(r5, r6)
        Laf:
            int r4 = r4 + 1
            goto L1f
        Lb3:
            r0 = move-exception
            throw r0
        Lb5:
            com.squareup.wire.TagMap r0 = com.squareup.wire.TagMap.of(r2)
            r1.fieldInfoMap = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.MessageAdapter.<init>(com.squareup.wire.Wire, java.lang.Class):void");
    }

    private Class<Message.Builder<M>> getBuilderType(Class<M> cls) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append("$Builder");
            Class<Message.Builder<M>> cls2 = (Class<Message.Builder<M>>) Class.forName(sb.toString(), true, cls.getClassLoader());
            int i = BuiltInFictitiousFunctionClassFactory + 69;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 != 0 ? 'M' : '=') != '=') {
                Object[] objArr = null;
                int length = objArr.length;
                return cls2;
            }
            return cls2;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No builder class found for message type ");
            sb2.append(cls.getName());
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    private Field getBuilderField(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 37;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        try {
            Field field = this.messageType.getField(str);
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 119;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return field;
        } catch (NoSuchFieldException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("No builder field ");
            sb.append(this.messageType.getName());
            sb.append(".");
            sb.append(str);
            throw new AssertionError(sb.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0074 A[PHI: r6
      0x0074: PHI (r6v9 java.lang.Class<com.squareup.wire.Message>) = (r6v7 java.lang.Class<com.squareup.wire.Message>), (r6v10 java.lang.Class<com.squareup.wire.Message>) binds: [B:25:0x005c, B:35:0x0071] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Class<com.squareup.wire.Message> getMessageType(java.lang.reflect.Field r6) {
        /*
            r5 = this;
            java.lang.Class r0 = r6.getType()
            java.lang.Class<com.squareup.wire.Message> r1 = com.squareup.wire.Message.class
            boolean r1 = r1.isAssignableFrom(r0)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L10
            r1 = 1
            goto L11
        L10:
            r1 = 0
        L11:
            if (r1 == 0) goto L1e
            int r6 = com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 + 101
            int r1 = r6 % 128
            com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory = r1
            int r6 = r6 % 2
            return r0
        L1e:
            java.lang.Class<java.util.List> r1 = java.util.List.class
            boolean r0 = r1.isAssignableFrom(r0)
            r1 = 36
            if (r0 == 0) goto L2b
            r0 = 36
            goto L2d
        L2b:
            r0 = 94
        L2d:
            r4 = 0
            if (r0 == r1) goto L31
            goto L77
        L31:
            java.lang.reflect.Type r6 = r6.getGenericType()
            java.lang.reflect.ParameterizedType r6 = (java.lang.reflect.ParameterizedType) r6
            java.lang.reflect.Type[] r6 = r6.getActualTypeArguments()
            r6 = r6[r2]
            boolean r0 = r6 instanceof java.lang.Class
            if (r0 == 0) goto L42
            goto L43
        L42:
            r2 = 1
        L43:
            if (r2 == r3) goto L77
            int r0 = com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L75
            int r0 = r0 + 17
            int r1 = r0 % 128
            com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> L75
            int r0 = r0 % 2
            if (r0 == 0) goto L63
            java.lang.Class r6 = (java.lang.Class) r6     // Catch: java.lang.Exception -> L61
            java.lang.Class<com.squareup.wire.Message> r0 = com.squareup.wire.Message.class
            boolean r0 = r0.isAssignableFrom(r6)     // Catch: java.lang.Exception -> L61
            r4.hashCode()     // Catch: java.lang.Throwable -> L5f
            if (r0 == 0) goto L77
            goto L74
        L5f:
            r6 = move-exception
            throw r6
        L61:
            r6 = move-exception
            throw r6
        L63:
            java.lang.Class r6 = (java.lang.Class) r6
            java.lang.Class<com.squareup.wire.Message> r0 = com.squareup.wire.Message.class
            boolean r0 = r0.isAssignableFrom(r6)
            if (r0 == 0) goto L6f
            r0 = 1
            goto L71
        L6f:
            r0 = 95
        L71:
            if (r0 == r3) goto L74
            goto L77
        L74:
            return r6
        L75:
            r6 = move-exception
            throw r6
        L77:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.MessageAdapter.getMessageType(java.lang.reflect.Field):java.lang.Class");
    }

    private Class<Enum> getEnumType(Field field) {
        Class type = field.getType();
        if (Enum.class.isAssignableFrom(type)) {
            try {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                return type;
            } catch (Exception e) {
                throw e;
            }
        }
        if (List.class.isAssignableFrom(type)) {
            int i3 = BuiltInFictitiousFunctionClassFactory + 55;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            Type type2 = ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                Class<Enum> cls = (Class) type2;
                if (Enum.class.isAssignableFrom(cls)) {
                    int i5 = BuiltInFictitiousFunctionClassFactory + 117;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                    if ((i5 % 2 != 0 ? Typography.greater : 'E') != 'E') {
                        int i6 = 52 / 0;
                        return cls;
                    }
                    return cls;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ab, code lost:
    
        if (r0.extensionMap != null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b4, code lost:
    
        if (r1 != null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b6, code lost:
    
        r3 = r3 + getExtensionsSerializedSize(r0.extensionMap);
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int getSerializedSize(M r11) {
        /*
            Method dump skipped, instructions count: 199
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.MessageAdapter.getSerializedSize(com.squareup.wire.Message):int");
    }

    private <T extends ExtendableMessage<?>> int getExtensionsSerializedSize(ExtensionMap<T> extensionMap) {
        int repeatedSize;
        int i = BuiltInFictitiousFunctionClassFactory + 105;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        int i3 = 0;
        for (int i4 = 0; i4 < extensionMap.size(); i4++) {
            try {
                Extension<T, ?> extension = extensionMap.getExtension(i4);
                Object extensionValue = extensionMap.getExtensionValue(i4);
                int tag = extension.getTag();
                Message.Datatype datatype = extension.getDatatype();
                Message.Label label = extension.getLabel();
                if (!label.isRepeated()) {
                    repeatedSize = getSerializedSize(tag, extensionValue, datatype);
                } else if (label.isPacked()) {
                    int i5 = BuiltInFictitiousFunctionClassFactory + 5;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                    if (!(i5 % 2 != 0)) {
                        try {
                            repeatedSize = getPackedSize((List) extensionValue, tag, datatype);
                        } catch (Exception e) {
                            throw e;
                        }
                    } else {
                        repeatedSize = getPackedSize((List) extensionValue, tag, datatype);
                        Object[] objArr = null;
                        int length = objArr.length;
                    }
                } else {
                    repeatedSize = getRepeatedSize((List) extensionValue, tag, datatype);
                }
                i3 += repeatedSize;
            } catch (Exception e2) {
                throw e2;
            }
        }
        return i3;
    }

    private int getRepeatedSize(List<?> list, int i, Message.Datatype datatype) {
        Iterator<?> it;
        int i2;
        int i3 = BuiltInFictitiousFunctionClassFactory + 61;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 != 0 ? 'H' : 'Z') != 'Z') {
            it = list.iterator();
            i2 = 1;
        } else {
            try {
                it = list.iterator();
                i2 = 0;
            } catch (Exception e) {
                throw e;
            }
        }
        while (true) {
            if (!it.hasNext()) {
                return i2;
            }
            try {
                int i4 = BuiltInFictitiousFunctionClassFactory + 21;
                KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                int i5 = i4 % 2;
                i2 += getSerializedSize(i, it.next(), datatype);
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private int getPackedSize(List<?> list, int i, Message.Datatype datatype) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 97;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        if (i2 % 2 == 0) {
        }
        Iterator<?> it = list.iterator();
        int i3 = 0;
        while (true) {
            try {
                if (!it.hasNext()) {
                    break;
                }
                i3 += getSerializedSizeNoTag(it.next(), datatype);
            } catch (Exception e) {
                throw e;
            }
        }
        int varint32Size = WireOutput.varint32Size(WireOutput.makeTag(i, WireType.LENGTH_DELIMITED)) + WireOutput.varint32Size(i3) + i3;
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 107;
        BuiltInFictitiousFunctionClassFactory = i4 % 128;
        if (!(i4 % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
            return varint32Size;
        }
        return varint32Size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x007d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0077 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void write(M r10, com.squareup.wire.WireOutput r11) throws java.io.IOException {
        /*
            r9 = this;
            int r0 = com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> La8
            int r0 = r0 + 93
            int r1 = r0 % 128
            com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> La8
            int r0 = r0 % 2
            java.util.Collection r0 = r9.getFields()
            java.util.Iterator r0 = r0.iterator()
        L12:
            boolean r1 = r0.hasNext()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L87
            int r1 = com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> La8
            int r1 = r1 + 103
            int r4 = r1 % 128
            com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory = r4     // Catch: java.lang.Exception -> La8
            int r1 = r1 % 2
            java.lang.Object r1 = r0.next()
            com.squareup.wire.MessageAdapter$FieldInfo r1 = (com.squareup.wire.MessageAdapter.FieldInfo) r1
            java.lang.Object r4 = r9.getFieldValue(r10, r1)
            r5 = 12
            if (r4 == 0) goto L35
            r6 = 17
            goto L37
        L35:
            r6 = 12
        L37:
            if (r6 == r5) goto L12
            int r5 = com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory
            int r5 = r5 + 49
            int r6 = r5 % 128
            com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r6
            int r5 = r5 % 2
            if (r5 == 0) goto L58
            int r5 = r1.tag
            com.squareup.wire.Message$Datatype r6 = r1.datatype
            com.squareup.wire.Message$Label r1 = r1.label
            boolean r7 = r1.isRepeated()
            r8 = 0
            r8.hashCode()     // Catch: java.lang.Throwable -> L56
            if (r7 == 0) goto L83
            goto L64
        L56:
            r10 = move-exception
            throw r10
        L58:
            int r5 = r1.tag
            com.squareup.wire.Message$Datatype r6 = r1.datatype
            com.squareup.wire.Message$Label r1 = r1.label
            boolean r7 = r1.isRepeated()
            if (r7 == 0) goto L83
        L64:
            int r7 = com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = r7 + 19
            int r8 = r7 % 128
            com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory = r8
            int r7 = r7 % 2
            boolean r1 = r1.isPacked()
            if (r1 == 0) goto L75
            r2 = 1
        L75:
            if (r2 == r3) goto L7d
            java.util.List r4 = (java.util.List) r4
            r9.writeRepeated(r11, r4, r5, r6)
            goto L12
        L7d:
            java.util.List r4 = (java.util.List) r4
            r9.writePacked(r11, r4, r5, r6)
            goto L12
        L83:
            r9.writeValue(r11, r5, r4, r6)
            goto L12
        L87:
            boolean r0 = r10 instanceof com.squareup.wire.ExtendableMessage
            if (r0 == 0) goto La4
            int r0 = com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 7
            int r1 = r0 % 128
            com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r0 = r10
            com.squareup.wire.ExtendableMessage r0 = (com.squareup.wire.ExtendableMessage) r0     // Catch: java.lang.Exception -> La8
            com.squareup.wire.ExtensionMap<T extends com.squareup.wire.ExtendableMessage<?>> r1 = r0.extensionMap
            if (r1 == 0) goto L9d
            r2 = 1
        L9d:
            if (r2 == 0) goto La4
            com.squareup.wire.ExtensionMap<T extends com.squareup.wire.ExtendableMessage<?>> r0 = r0.extensionMap
            r9.writeExtensions(r11, r0)
        La4:
            r10.writeUnknownFieldMap(r11)
            return
        La8:
            r10 = move-exception
            goto Lab
        Laa:
            throw r10
        Lab:
            goto Laa
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.MessageAdapter.write(com.squareup.wire.Message, com.squareup.wire.WireOutput):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
    
        if ((r2.isRepeated()) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005c, code lost:
    
        if ((r3 ? 'H' : '0') != 'H') goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
    
        writeValue(r9, r5, r4, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
    
        r3 = com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory + 87;
        com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
    
        if (r2.isPacked() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0074, code lost:
    
        r2 = ';';
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0077, code lost:
    
        r2 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0079, code lost:
    
        if (r2 == 30) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007b, code lost:
    
        writePacked(r9, (java.util.List) r4, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0081, code lost:
    
        writeRepeated(r9, (java.util.List) r4, r5, r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T extends com.squareup.wire.ExtendableMessage<?>> void writeExtensions(com.squareup.wire.WireOutput r9, com.squareup.wire.ExtensionMap<T> r10) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
        L2:
            int r2 = r10.size()     // Catch: java.lang.Exception -> L8d
            if (r1 >= r2) goto L8c
            int r2 = com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r2 = r2 + 79
            int r3 = r2 % 128
            com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory = r3
            int r2 = r2 % 2
            r3 = 1
            if (r2 != 0) goto L17
            r2 = 0
            goto L18
        L17:
            r2 = 1
        L18:
            if (r2 == 0) goto L39
            com.squareup.wire.Extension r2 = r10.getExtension(r1)
            java.lang.Object r4 = r10.getExtensionValue(r1)
            int r5 = r2.getTag()
            com.squareup.wire.Message$Datatype r6 = r2.getDatatype()
            com.squareup.wire.Message$Label r2 = r2.getLabel()
            boolean r7 = r2.isRepeated()
            if (r7 == 0) goto L35
            goto L36
        L35:
            r3 = 0
        L36:
            if (r3 == 0) goto L5e
            goto L62
        L39:
            com.squareup.wire.Extension r2 = r10.getExtension(r1)
            java.lang.Object r4 = r10.getExtensionValue(r1)
            int r5 = r2.getTag()
            com.squareup.wire.Message$Datatype r6 = r2.getDatatype()
            com.squareup.wire.Message$Label r2 = r2.getLabel()
            boolean r3 = r2.isRepeated()
            r7 = 0
            int r7 = r7.length     // Catch: java.lang.Throwable -> L8a
            r7 = 72
            if (r3 == 0) goto L5a
            r3 = 72
            goto L5c
        L5a:
            r3 = 48
        L5c:
            if (r3 == r7) goto L62
        L5e:
            r8.writeValue(r9, r5, r4, r6)
            goto L86
        L62:
            int r3 = com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory
            int r3 = r3 + 87
            int r7 = r3 % 128
            com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r7
            int r3 = r3 % 2
            boolean r2 = r2.isPacked()
            r3 = 30
            if (r2 == 0) goto L77
            r2 = 59
            goto L79
        L77:
            r2 = 30
        L79:
            if (r2 == r3) goto L81
            java.util.List r4 = (java.util.List) r4     // Catch: java.lang.Exception -> L8d
            r8.writePacked(r9, r4, r5, r6)     // Catch: java.lang.Exception -> L8d
            goto L86
        L81:
            java.util.List r4 = (java.util.List) r4
            r8.writeRepeated(r9, r4, r5, r6)
        L86:
            int r1 = r1 + 1
            goto L2
        L8a:
            r9 = move-exception
            throw r9
        L8c:
            return
        L8d:
            r9 = move-exception
            goto L90
        L8f:
            throw r9
        L90:
            goto L8f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.MessageAdapter.writeExtensions(com.squareup.wire.WireOutput, com.squareup.wire.ExtensionMap):void");
    }

    private void writeRepeated(WireOutput wireOutput, List<?> list, int i, Message.Datatype datatype) throws IOException {
        Iterator<?> it;
        int i2 = BuiltInFictitiousFunctionClassFactory + 29;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if (i2 % 2 != 0) {
            it = list.iterator();
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            it = list.iterator();
        }
        while (true) {
            if ((it.hasNext() ? 'U' : '7') != 'U') {
                return;
            }
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 89;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            try {
                writeValue(wireOutput, i, it.next(), datatype);
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private void writePacked(WireOutput wireOutput, List<?> list, int i, Message.Datatype datatype) throws IOException {
        int i2 = BuiltInFictitiousFunctionClassFactory + 33;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        Iterator<?> it = list.iterator();
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
        BuiltInFictitiousFunctionClassFactory = i4 % 128;
        int i5 = i4 % 2;
        int i6 = 0;
        while (true) {
            if (!(it.hasNext())) {
                break;
            }
            int i7 = KClassImpl$Data$declaredNonStaticMembers$2 + 65;
            BuiltInFictitiousFunctionClassFactory = i7 % 128;
            int i8 = i7 % 2;
            i6 += getSerializedSizeNoTag(it.next(), datatype);
            int i9 = BuiltInFictitiousFunctionClassFactory + 101;
            KClassImpl$Data$declaredNonStaticMembers$2 = i9 % 128;
            int i10 = i9 % 2;
        }
        wireOutput.writeTag(i, WireType.LENGTH_DELIMITED);
        wireOutput.writeVarint32(i6);
        Iterator<?> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                return;
            }
            writeValueNoTag(wireOutput, it2.next(), datatype);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] toByteArray(M m) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            byte[] bArr = new byte[getSerializedSize(m)];
            try {
                write(m, WireOutput.newInstance(bArr));
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 63;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    return bArr;
                }
                Object[] objArr = null;
                int length = objArr.length;
                return bArr;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String toString(M m) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.messageType.getSimpleName());
        sb.append("{");
        Iterator<FieldInfo> it = getFields().iterator();
        String str = "";
        while (true) {
            if ((it.hasNext() ? (char) 25 : (char) 11) != 25) {
                break;
            }
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 115;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            FieldInfo next = it.next();
            Object fieldValue = getFieldValue(m, next);
            if (fieldValue != null) {
                sb.append(str);
                sb.append(next.name);
                sb.append("=");
                if (!(next.redacted ? false : true)) {
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 97;
                    BuiltInFictitiousFunctionClassFactory = i3 % 128;
                    int i4 = i3 % 2;
                    fieldValue = REDACTED;
                }
                sb.append(fieldValue);
                str = ", ";
            }
        }
        if (!(m instanceof ExtendableMessage ? false : true)) {
            try {
                sb.append(str);
                sb.append("{extensions=");
                sb.append(((ExtendableMessage) m).extensionsToString());
                sb.append("}");
                int i5 = BuiltInFictitiousFunctionClassFactory + 107;
                KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                int i6 = i5 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        sb.append("}");
        return sb.toString();
    }

    private int getSerializedSize(int i, Object obj, Message.Datatype datatype) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 45;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        if (i2 % 2 == 0) {
        }
        int varintTagSize = WireOutput.varintTagSize(i) + getSerializedSizeNoTag(obj, datatype);
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 105;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return varintTagSize;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int getSerializedSizeNoTag(Object obj, Message.Datatype datatype) {
        int utf8Length;
        int varint32Size;
        try {
            switch (AnonymousClass1.$SwitchMap$com$squareup$wire$Message$Datatype[datatype.ordinal()]) {
                case 1:
                    return WireOutput.int32Size(((Integer) obj).intValue());
                case 2:
                case 3:
                    return WireOutput.varint64Size(((Long) obj).longValue());
                case 4:
                    return WireOutput.varint32Size(((Integer) obj).intValue());
                case 5:
                    int varint32Size2 = WireOutput.varint32Size(WireOutput.zigZag32(((Integer) obj).intValue()));
                    int i = BuiltInFictitiousFunctionClassFactory + 85;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                    if (!(i % 2 != 0)) {
                        return varint32Size2;
                    }
                    int i2 = 77 / 0;
                    return varint32Size2;
                case 6:
                    return WireOutput.varint64Size(WireOutput.zigZag64(((Long) obj).longValue()));
                case 7:
                    return 1;
                case 8:
                    return getEnumSize((ProtoEnum) obj);
                case 9:
                    utf8Length = utf8Length((String) obj);
                    varint32Size = WireOutput.varint32Size(utf8Length);
                    break;
                case 10:
                    utf8Length = ((ByteString) obj).size();
                    varint32Size = WireOutput.varint32Size(utf8Length);
                    break;
                case 11:
                    int messageSize = getMessageSize((Message) obj);
                    int i3 = BuiltInFictitiousFunctionClassFactory + 41;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    if (!(i3 % 2 != 0)) {
                        return messageSize;
                    }
                    int i4 = 99 / 0;
                    return messageSize;
                case 12:
                case 13:
                case 14:
                    int i5 = BuiltInFictitiousFunctionClassFactory + 87;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                    if ((i5 % 2 != 0 ? (char) 30 : 'a') != 'a') {
                        int i6 = 47 / 0;
                        return 4;
                    }
                    return 4;
                case 15:
                case 16:
                case 17:
                    return 8;
                default:
                    throw new RuntimeException();
            }
            return varint32Size + utf8Length;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
    
        if (r4 <= 'S') goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0047, code lost:
    
        if ((r4 > 127) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004b, code lost:
    
        if (r4 > 2047) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004d, code lost:
    
        r7 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0050, code lost:
    
        r7 = 27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0052, code lost:
    
        if (r7 == 15) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005a, code lost:
    
        if (java.lang.Character.isHighSurrogate(r4) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005c, code lost:
    
        r4 = '\t';
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005f, code lost:
    
        r4 = ':';
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0061, code lost:
    
        if (r4 == '\t') goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0063, code lost:
    
        r3 = r3 + 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0066, code lost:
    
        r3 = r3 + 4;
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x006b, code lost:
    
        r3 = r3 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006e, code lost:
    
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int utf8Length(java.lang.String r9) {
        /*
            r8 = this;
            int r0 = r9.length()
            r1 = 0
            r2 = 0
            r3 = 0
        L7:
            r4 = 8
            if (r2 >= r0) goto Le
            r5 = 8
            goto L10
        Le:
            r5 = 16
        L10:
            r6 = 15
            if (r5 == r4) goto L26
            int r9 = com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory
            int r9 = r9 + r6
            int r0 = r9 % 128
            com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r9 = r9 % 2
            if (r9 == 0) goto L25
            r9 = 93
            int r9 = r9 / r1
            return r3
        L23:
            r9 = move-exception
            throw r9
        L25:
            return r3
        L26:
            int r4 = com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L72
            int r4 = r4 + 85
            int r5 = r4 % 128
            com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory = r5     // Catch: java.lang.Exception -> L72
            int r4 = r4 % 2
            r5 = 1
            if (r4 != 0) goto L3c
            char r4 = r9.charAt(r2)
            r7 = 83
            if (r4 > r7) goto L49
            goto L6e
        L3c:
            char r4 = r9.charAt(r2)     // Catch: java.lang.Exception -> L72
            r7 = 127(0x7f, float:1.78E-43)
            if (r4 > r7) goto L46
            r7 = 0
            goto L47
        L46:
            r7 = 1
        L47:
            if (r7 == 0) goto L6e
        L49:
            r7 = 2047(0x7ff, float:2.868E-42)
            if (r4 > r7) goto L50
            r7 = 15
            goto L52
        L50:
            r7 = 27
        L52:
            if (r7 == r6) goto L6b
            boolean r4 = java.lang.Character.isHighSurrogate(r4)
            r6 = 9
            if (r4 == 0) goto L5f
            r4 = 9
            goto L61
        L5f:
            r4 = 58
        L61:
            if (r4 == r6) goto L66
            int r3 = r3 + 3
            goto L70
        L66:
            int r3 = r3 + 4
            int r2 = r2 + 1
            goto L70
        L6b:
            int r3 = r3 + 2
            goto L70
        L6e:
            int r3 = r3 + 1
        L70:
            int r2 = r2 + r5
            goto L7
        L72:
            r9 = move-exception
            goto L75
        L74:
            throw r9
        L75:
            goto L74
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.MessageAdapter.utf8Length(java.lang.String):int");
    }

    private <E extends ProtoEnum> int getEnumSize(E e) {
        int i = BuiltInFictitiousFunctionClassFactory + 43;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 == 0)) {
            int varint32Size = WireOutput.varint32Size(this.wire.enumAdapter(e.getClass()).toInt(e));
            Object obj = null;
            obj.hashCode();
            return varint32Size;
        }
        return WireOutput.varint32Size(this.wire.enumAdapter(e.getClass()).toInt(e));
    }

    private <M extends Message> int getMessageSize(M m) {
        int varint32Size;
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 19;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 != 0 ? '*' : '0') != '*') {
                int serializedSize = m.getSerializedSize();
                varint32Size = WireOutput.varint32Size(serializedSize) + serializedSize;
            } else {
                int serializedSize2 = m.getSerializedSize();
                varint32Size = WireOutput.varint32Size(serializedSize2) % serializedSize2;
            }
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
            return varint32Size;
        } catch (Exception e) {
            throw e;
        }
    }

    private void writeValue(WireOutput wireOutput, int i, Object obj, Message.Datatype datatype) throws IOException {
        try {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            if ((i2 % 2 == 0 ? 'F' : ']') != ']') {
                wireOutput.writeTag(i, datatype.wireType());
                writeValueNoTag(wireOutput, obj, datatype);
                int i3 = 18 / 0;
            } else {
                wireOutput.writeTag(i, datatype.wireType());
                writeValueNoTag(wireOutput, obj, datatype);
            }
            int i4 = BuiltInFictitiousFunctionClassFactory + 83;
            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void writeValueNoTag(com.squareup.wire.WireOutput r5, java.lang.Object r6, com.squareup.wire.Message.Datatype r7) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 377
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.MessageAdapter.writeValueNoTag(com.squareup.wire.WireOutput, java.lang.Object, com.squareup.wire.Message$Datatype):void");
    }

    private <M extends Message> void writeMessage(M m, WireOutput wireOutput) throws IOException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            wireOutput.writeVarint32(m.getSerializedSize());
            this.wire.messageAdapter(m.getClass()).write(m, wireOutput);
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 16 : (char) 17) != 16) {
                return;
            }
            int i4 = 65 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    private <E extends ProtoEnum> void writeEnum(E e, WireOutput wireOutput) throws IOException {
        int i = BuiltInFictitiousFunctionClassFactory + 5;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        wireOutput.writeVarint32(this.wire.enumAdapter(e.getClass()).toInt(e));
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 95;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.squareup.wire.MessageAdapter$1] */
    /* JADX WARN: Type inference failed for: r4v24 */
    public final M read(WireInput wireInput) throws IOException {
        int intValue;
        Message.Label label;
        Message.Datatype datatype;
        Extension<ExtendableMessage<?>, ?> extension;
        Storage storage;
        long j;
        try {
            M newInstance = this.messageType.newInstance();
            Object[] objArr = 0;
            Storage storage2 = new Storage(objArr);
            while (true) {
                int readTag = wireInput.readTag();
                int i = readTag >> 3;
                WireType valueOf = WireType.valueOf(readTag);
                if (i == 0) {
                    Iterator<Integer> it = storage2.getTags().iterator();
                    while (it.hasNext()) {
                        int i2 = BuiltInFictitiousFunctionClassFactory + 49;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                        if (i2 % 2 != 0) {
                            intValue = it.next().intValue();
                            boolean containsKey = this.fieldInfoMap.containsKey(intValue);
                            int length = objArr.length;
                            if (containsKey) {
                                setBuilderField(newInstance, intValue, storage2.get(intValue));
                            } else {
                                setExtension((ExtendableMessage) newInstance, getExtension(intValue), storage2.get(intValue));
                            }
                        } else {
                            intValue = it.next().intValue();
                            if ((this.fieldInfoMap.containsKey(intValue) ? (char) 2 : '\b') != 2) {
                                setExtension((ExtendableMessage) newInstance, getExtension(intValue), storage2.get(intValue));
                            } else {
                                setBuilderField(newInstance, intValue, storage2.get(intValue));
                            }
                        }
                    }
                    return newInstance;
                }
                FieldInfo fieldInfo = this.fieldInfoMap.get(i);
                if (fieldInfo != null) {
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
                    BuiltInFictitiousFunctionClassFactory = i3 % 128;
                    int i4 = i3 % 2;
                    Message.Datatype datatype2 = fieldInfo.datatype;
                    label = fieldInfo.label;
                    datatype = datatype2;
                    extension = objArr;
                } else {
                    Extension<ExtendableMessage<?>, ?> extension2 = getExtension(i);
                    if (extension2 == null) {
                        try {
                            int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
                            BuiltInFictitiousFunctionClassFactory = i5 % 128;
                            int i6 = i5 % 2;
                            readUnknownField(newInstance, wireInput, i, valueOf);
                        } catch (Exception e) {
                            throw e;
                        }
                    } else {
                        Message.Datatype datatype3 = extension2.getDatatype();
                        extension = extension2;
                        label = extension2.getLabel();
                        datatype = datatype3;
                    }
                }
                if (label.isPacked()) {
                    if ((valueOf == WireType.LENGTH_DELIMITED ? '*' : 'W') != 'W') {
                        int readVarint32 = wireInput.readVarint32();
                        long position = wireInput.getPosition();
                        int pushLimit = wireInput.pushLimit(readVarint32);
                        while (true) {
                            storage = storage2;
                            j = readVarint32 + position;
                            if (wireInput.getPosition() >= j) {
                                break;
                            }
                            Object readValue = readValue(wireInput, i, datatype);
                            if (datatype == Message.Datatype.ENUM && (readValue instanceof Integer)) {
                                try {
                                    int i7 = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
                                    BuiltInFictitiousFunctionClassFactory = i7 % 128;
                                    if ((i7 % 2 == 0 ? '-' : '_') != '-') {
                                        newInstance.addVarint(i, ((Integer) readValue).intValue());
                                    } else {
                                        newInstance.addVarint(i, ((Integer) readValue).intValue());
                                        int i8 = 61 / 0;
                                    }
                                } catch (Exception e2) {
                                    throw e2;
                                }
                            } else {
                                storage.add(i, readValue);
                            }
                            storage2 = storage;
                        }
                        wireInput.popLimit(pushLimit);
                        if (wireInput.getPosition() != j) {
                            throw new IOException("Packed data had wrong length!");
                        }
                        storage2 = storage;
                        objArr = 0;
                    }
                }
                storage = storage2;
                Object readValue2 = readValue(wireInput, i, datatype);
                if (!(datatype != Message.Datatype.ENUM)) {
                    if (readValue2 instanceof Integer) {
                        newInstance.addVarint(i, ((Integer) readValue2).intValue());
                        storage2 = storage;
                        objArr = 0;
                    }
                }
                if ((label.isRepeated() ? '6' : '\\') != '\\') {
                    storage.add(i, readValue2);
                    int i9 = BuiltInFictitiousFunctionClassFactory + 3;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i9 % 128;
                    int i10 = i9 % 2;
                } else if (extension != null) {
                    setExtension((ExtendableMessage) newInstance, extension, readValue2);
                } else {
                    setBuilderField(newInstance, i, readValue2);
                }
                storage2 = storage;
                objArr = 0;
            }
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        } catch (InstantiationException e4) {
            throw new RuntimeException(e4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d A[Catch: Exception -> 0x006f, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x006f, blocks: (B:19:0x004d, B:25:0x006a, B:39:0x0090, B:41:0x0096), top: B:57:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006a A[Catch: Exception -> 0x006f, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x006f, blocks: (B:19:0x004d, B:25:0x006a, B:39:0x0090, B:41:0x0096), top: B:57:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object readValue(com.squareup.wire.WireInput r3, int r4, com.squareup.wire.Message.Datatype r5) throws java.io.IOException {
        /*
            r2 = this;
            int r0 = com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 27
            int r1 = r0 % 128
            com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L1d
            int[] r0 = com.squareup.wire.MessageAdapter.AnonymousClass1.$SwitchMap$com$squareup$wire$Message$Datatype
            int r5 = r5.ordinal()
            r5 = r0[r5]
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L1b
            switch(r5) {
                case 1: goto Lc5;
                case 2: goto Lbc;
                case 3: goto Lbc;
                case 4: goto Lc5;
                case 5: goto Laf;
                case 6: goto La2;
                case 7: goto L83;
                case 8: goto L71;
                case 9: goto L6a;
                case 10: goto L5b;
                case 11: goto L56;
                case 12: goto L4d;
                case 13: goto L4d;
                case 14: goto L40;
                case 15: goto L37;
                case 16: goto L37;
                case 17: goto L2a;
                default: goto L19;
            }
        L19:
            goto Lce
        L1b:
            r3 = move-exception
            throw r3
        L1d:
            int[] r0 = com.squareup.wire.MessageAdapter.AnonymousClass1.$SwitchMap$com$squareup$wire$Message$Datatype
            int r5 = r5.ordinal()
            r5 = r0[r5]
            switch(r5) {
                case 1: goto Lc5;
                case 2: goto Lbc;
                case 3: goto Lbc;
                case 4: goto Lc5;
                case 5: goto Laf;
                case 6: goto La2;
                case 7: goto L83;
                case 8: goto L71;
                case 9: goto L6a;
                case 10: goto L5b;
                case 11: goto L56;
                case 12: goto L4d;
                case 13: goto L4d;
                case 14: goto L40;
                case 15: goto L37;
                case 16: goto L37;
                case 17: goto L2a;
                default: goto L28;
            }
        L28:
            goto Lce
        L2a:
            long r3 = r3.readFixed64()
            double r3 = java.lang.Double.longBitsToDouble(r3)
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            return r3
        L37:
            long r3 = r3.readFixed64()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            return r3
        L40:
            int r3 = r3.readFixed32()
            float r3 = java.lang.Float.intBitsToFloat(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            return r3
        L4d:
            int r3 = r3.readFixed32()     // Catch: java.lang.Exception -> L6f
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Exception -> L6f
            return r3
        L56:
            com.squareup.wire.Message r3 = r2.readMessage(r3, r4)
            return r3
        L5b:
            okio.ByteString r3 = r3.readBytes()
            int r4 = com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory
            int r4 = r4 + 43
            int r5 = r4 % 128
            com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r5
            int r4 = r4 % 2
            return r3
        L6a:
            java.lang.String r3 = r3.readString()     // Catch: java.lang.Exception -> L6f
            return r3
        L6f:
            r3 = move-exception
            goto L9b
        L71:
            com.squareup.wire.EnumAdapter r4 = r2.getEnumAdapter(r4)
            int r3 = r3.readVarint32()
            com.squareup.wire.ProtoEnum r3 = r4.fromInt(r3)     // Catch: java.lang.IllegalArgumentException -> L7e
            return r3
        L7e:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            return r3
        L83:
            int r3 = r3.readVarint32()
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L8d
            r3 = 1
            goto L8e
        L8d:
            r3 = 0
        L8e:
            if (r3 == 0) goto L9c
            int r3 = com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L6f
            int r3 = r3 + 59
            int r5 = r3 % 128
            com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory = r5     // Catch: java.lang.Exception -> L6f
            int r3 = r3 % 2
            goto L9d
        L9b:
            throw r3
        L9c:
            r4 = 0
        L9d:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r4)
            return r3
        La2:
            long r3 = r3.readVarint64()
            long r3 = com.squareup.wire.WireInput.decodeZigZag64(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            return r3
        Laf:
            int r3 = r3.readVarint32()
            int r3 = com.squareup.wire.WireInput.decodeZigZag32(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            return r3
        Lbc:
            long r3 = r3.readVarint64()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            return r3
        Lc5:
            int r3 = r3.readVarint32()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            return r3
        Lce:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            r3.<init>()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.MessageAdapter.readValue(com.squareup.wire.WireInput, int, com.squareup.wire.Message$Datatype):java.lang.Object");
    }

    private Message readMessage(WireInput wireInput, int i) throws IOException {
        int pushLimit;
        Message read;
        int i2;
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 17;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        int readVarint32 = wireInput.readVarint32();
        if ((wireInput.recursionDepth < 64 ? Typography.greater : 'a') != '>') {
            throw new IOException("Wire recursion limit exceeded");
        }
        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 13;
        BuiltInFictitiousFunctionClassFactory = i5 % 128;
        if ((i5 % 2 == 0 ? (char) 31 : 'O') != 31) {
            pushLimit = wireInput.pushLimit(readVarint32);
            wireInput.recursionDepth++;
            read = getMessageAdapter(i).read(wireInput);
            wireInput.checkLastTagWas(0);
            i2 = wireInput.recursionDepth - 1;
        } else {
            pushLimit = wireInput.pushLimit(readVarint32);
            wireInput.recursionDepth /= 1;
            read = getMessageAdapter(i).read(wireInput);
            wireInput.checkLastTagWas(1);
            i2 = wireInput.recursionDepth / 1;
        }
        wireInput.recursionDepth = i2;
        wireInput.popLimit(pushLimit);
        return read;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private MessageAdapter<? extends Message> getMessageAdapter(int i) {
        FieldInfo fieldInfo = this.fieldInfoMap.get(i);
        if (fieldInfo != null) {
            if (!(fieldInfo.messageAdapter == null)) {
                MessageAdapter<? extends Message> messageAdapter = fieldInfo.messageAdapter;
                int i2 = BuiltInFictitiousFunctionClassFactory + 45;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                int i3 = i2 % 2;
                return messageAdapter;
            }
        }
        MessageAdapter<? extends Message> messageAdapter2 = this.wire.messageAdapter(getMessageClass(i));
        if ((fieldInfo != null ? '#' : '9') == '#') {
            fieldInfo.messageAdapter = messageAdapter2;
        }
        int i4 = BuiltInFictitiousFunctionClassFactory + 61;
        KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
        int i5 = i4 % 2;
        return messageAdapter2;
    }

    private EnumAdapter<? extends ProtoEnum> getEnumAdapter(int i) {
        FieldInfo fieldInfo = this.fieldInfoMap.get(i);
        if (!(fieldInfo == null)) {
            int i2 = BuiltInFictitiousFunctionClassFactory + 33;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            if (fieldInfo.enumAdapter != null) {
                EnumAdapter<? extends ProtoEnum> enumAdapter = fieldInfo.enumAdapter;
                try {
                    int i4 = BuiltInFictitiousFunctionClassFactory + 25;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                    int i5 = i4 % 2;
                    return enumAdapter;
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        try {
            EnumAdapter<? extends ProtoEnum> enumAdapter2 = this.wire.enumAdapter(getEnumClass(i));
            if (fieldInfo != null) {
                int i6 = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
                BuiltInFictitiousFunctionClassFactory = i6 % 128;
                if ((i6 % 2 == 0 ? '2' : 'L') != '2') {
                    fieldInfo.enumAdapter = enumAdapter2;
                } else {
                    fieldInfo.enumAdapter = enumAdapter2;
                    Object[] objArr = null;
                    int length = objArr.length;
                }
            }
            int i7 = KClassImpl$Data$declaredNonStaticMembers$2 + 109;
            BuiltInFictitiousFunctionClassFactory = i7 % 128;
            int i8 = i7 % 2;
            return enumAdapter2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Class<Message> getMessageClass(int i) {
        Class cls;
        try {
            int i2 = BuiltInFictitiousFunctionClassFactory + 107;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            FieldInfo fieldInfo = this.fieldInfoMap.get(i);
            if (fieldInfo == null) {
                cls = null;
            } else {
                try {
                    cls = fieldInfo.messageType;
                } catch (Exception e) {
                    throw e;
                }
            }
            if (cls == null) {
                Extension<ExtendableMessage<?>, ?> extension = getExtension(i);
                if ((extension != null ? '6' : '/') != '/') {
                    cls = extension.getMessageType();
                    int i4 = BuiltInFictitiousFunctionClassFactory + 99;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                    int i5 = i4 % 2;
                }
            }
            return cls;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.squareup.wire.MessageAdapter$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$wire$Message$Datatype;
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
            try {
                $SwitchMap$com$squareup$wire$WireType[WireType.START_GROUP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$squareup$wire$WireType[WireType.END_GROUP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[Message.Datatype.values().length];
            $SwitchMap$com$squareup$wire$Message$Datatype = iArr2;
            try {
                iArr2[Message.Datatype.INT32.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Message.Datatype.INT64.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Message.Datatype.UINT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Message.Datatype.UINT32.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Message.Datatype.SINT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Message.Datatype.SINT64.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Message.Datatype.BOOL.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Message.Datatype.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Message.Datatype.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Message.Datatype.BYTES.ordinal()] = 10;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Message.Datatype.MESSAGE.ordinal()] = 11;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Message.Datatype.FIXED32.ordinal()] = 12;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Message.Datatype.SFIXED32.ordinal()] = 13;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Message.Datatype.FLOAT.ordinal()] = 14;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Message.Datatype.FIXED64.ordinal()] = 15;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Message.Datatype.SFIXED64.ordinal()] = 16;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$squareup$wire$Message$Datatype[Message.Datatype.DOUBLE.ordinal()] = 17;
            } catch (NoSuchFieldError unused23) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0067 A[Catch: Exception -> 0x009e, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x009e, blocks: (B:29:0x0067, B:35:0x008c, B:36:0x009d), top: B:43:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void readUnknownField(com.squareup.wire.Message r6, com.squareup.wire.WireInput r7, int r8, com.squareup.wire.WireType r9) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 67
            int r1 = r0 % 128
            com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            r3 = 0
            if (r0 == r2) goto L20
            int[] r0 = com.squareup.wire.MessageAdapter.AnonymousClass1.$SwitchMap$com$squareup$wire$WireType
            int r4 = r9.ordinal()
            r0 = r0[r4]
            switch(r0) {
                case 1: goto L77;
                case 2: goto L67;
                case 3: goto L57;
                case 4: goto L31;
                case 5: goto L2d;
                case 6: goto L86;
                default: goto L1f;
            }
        L1f:
            goto L87
        L20:
            int[] r0 = com.squareup.wire.MessageAdapter.AnonymousClass1.$SwitchMap$com$squareup$wire$WireType
            int r4 = r9.ordinal()
            r0 = r0[r4]
            int r4 = r3.length     // Catch: java.lang.Throwable -> La0
            switch(r0) {
                case 1: goto L77;
                case 2: goto L67;
                case 3: goto L57;
                case 4: goto L31;
                case 5: goto L2d;
                case 6: goto L86;
                default: goto L2c;
            }
        L2c:
            goto L87
        L2d:
            r7.skipGroup()
            return
        L31:
            int r9 = r7.readVarint32()
            com.squareup.wire.UnknownFieldMap r6 = r6.ensureUnknownFieldMap()
            okio.ByteString r7 = r7.readBytes(r9)
            r6.addLengthDelimited(r8, r7)
            int r6 = com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 + 61
            int r7 = r6 % 128
            com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r7
            int r6 = r6 % 2
            if (r6 == 0) goto L4d
            goto L4e
        L4d:
            r1 = 1
        L4e:
            if (r1 == r2) goto L56
            r3.hashCode()     // Catch: java.lang.Throwable -> L54
            return
        L54:
            r6 = move-exception
            throw r6
        L56:
            return
        L57:
            com.squareup.wire.UnknownFieldMap r6 = r6.ensureUnknownFieldMap()
            long r0 = r7.readFixed64()
            java.lang.Long r7 = java.lang.Long.valueOf(r0)
            r6.addFixed64(r8, r7)
            return
        L67:
            com.squareup.wire.UnknownFieldMap r6 = r6.ensureUnknownFieldMap()     // Catch: java.lang.Exception -> L9e
            int r7 = r7.readFixed32()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6.addFixed32(r8, r7)
            return
        L77:
            com.squareup.wire.UnknownFieldMap r6 = r6.ensureUnknownFieldMap()
            long r0 = r7.readVarint64()
            java.lang.Long r7 = java.lang.Long.valueOf(r0)
            r6.addVarint(r8, r7)
        L86:
            return
        L87:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Unsupported wire type: "
            r6.append(r7)     // Catch: java.lang.Exception -> L9e
            r6.append(r9)     // Catch: java.lang.Exception -> L9e
            java.lang.RuntimeException r7 = new java.lang.RuntimeException     // Catch: java.lang.Exception -> L9e
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L9e
            r7.<init>(r6)     // Catch: java.lang.Exception -> L9e
            throw r7     // Catch: java.lang.Exception -> L9e
        L9e:
            r6 = move-exception
            throw r6
        La0:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.MessageAdapter.readUnknownField(com.squareup.wire.Message, com.squareup.wire.WireInput, int, com.squareup.wire.WireType):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Storage {
        private Map<Integer, ImmutableList<Object>> map;

        private Storage() {
        }

        /* synthetic */ Storage(AnonymousClass1 anonymousClass1) {
            this();
        }

        void add(int i, Object obj) {
            Map<Integer, ImmutableList<Object>> map = this.map;
            ImmutableList<Object> immutableList = map == null ? null : map.get(Integer.valueOf(i));
            if (immutableList == null) {
                immutableList = new ImmutableList<>();
                if (this.map == null) {
                    this.map = new LinkedHashMap();
                }
                this.map.put(Integer.valueOf(i), immutableList);
            }
            ((ImmutableList) immutableList).list.add(obj);
        }

        Set<Integer> getTags() {
            Map<Integer, ImmutableList<Object>> map = this.map;
            return map == null ? Collections.emptySet() : map.keySet();
        }

        List<Object> get(int i) {
            Map<Integer, ImmutableList<Object>> map = this.map;
            if (map == null) {
                return null;
            }
            return map.get(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001a, code lost:
    
        if ((r0 != null) != true) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0023, code lost:
    
        if (r0 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0026, code lost:
    
        r1 = r0.getExtension(r4.messageType, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002e, code lost:
    
        r5 = com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 + 71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0032, code lost:
    
        com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
    
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0036, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.squareup.wire.Extension<com.squareup.wire.ExtendableMessage<?>, ?> getExtension(int r5) {
        /*
            r4 = this;
            int r0 = com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L39
            int r0 = r0 + 13
            int r1 = r0 % 128
            com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory = r1     // Catch: java.lang.Exception -> L39
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L1f
            com.squareup.wire.Wire r0 = r4.wire
            com.squareup.wire.ExtensionRegistry r0 = r0.registry
            r1.hashCode()     // Catch: java.lang.Throwable -> L1d
            r2 = 1
            if (r0 != 0) goto L19
            r3 = 0
            goto L1a
        L19:
            r3 = 1
        L1a:
            if (r3 == r2) goto L26
            goto L36
        L1d:
            r5 = move-exception
            throw r5
        L1f:
            com.squareup.wire.Wire r0 = r4.wire     // Catch: java.lang.Exception -> L37
            com.squareup.wire.ExtensionRegistry r0 = r0.registry
            if (r0 != 0) goto L26
            goto L36
        L26:
            java.lang.Class<M extends com.squareup.wire.Message> r1 = r4.messageType
            com.squareup.wire.Extension r1 = r0.getExtension(r1, r5)
            int r5 = com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L37
            int r5 = r5 + 71
            int r0 = r5 % 128
            com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory = r0     // Catch: java.lang.Exception -> L39
            int r5 = r5 % 2
        L36:
            return r1
        L37:
            r5 = move-exception
            throw r5
        L39:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.MessageAdapter.getExtension(int):com.squareup.wire.Extension");
    }

    final Extension<ExtendableMessage<?>, ?> getExtension(String str) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 77;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            ExtensionRegistry extensionRegistry = this.wire.registry;
            if ((extensionRegistry == null ? '0' : ')') != ')') {
                int i3 = BuiltInFictitiousFunctionClassFactory + 25;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                return null;
            }
            return extensionRegistry.getExtension(this.messageType, str);
        } catch (Exception e) {
            throw e;
        }
    }

    private void setExtension(ExtendableMessage extendableMessage, Extension<?, ?> extension, Object obj) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 11;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        extendableMessage.setExtension(extension, obj);
        try {
            int i3 = BuiltInFictitiousFunctionClassFactory + 13;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
    
        if (r0 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        r0 = r0.enumType;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if ((r0 != null) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Class<? extends com.squareup.wire.ProtoEnum> getEnumClass(int r5) {
        /*
            r4 = this;
            int r0 = com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 59
            int r1 = r0 % 128
            com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L22
            com.squareup.wire.TagMap<com.squareup.wire.MessageAdapter$FieldInfo> r0 = r4.fieldInfoMap
            java.lang.Object r0 = r0.get(r5)
            com.squareup.wire.MessageAdapter$FieldInfo r0 = (com.squareup.wire.MessageAdapter.FieldInfo) r0
            r1.hashCode()     // Catch: java.lang.Throwable -> L20
            if (r0 != 0) goto L1c
            r2 = 0
            goto L1d
        L1c:
            r2 = 1
        L1d:
            if (r2 == 0) goto L2c
            goto L2e
        L20:
            r5 = move-exception
            throw r5
        L22:
            com.squareup.wire.TagMap<com.squareup.wire.MessageAdapter$FieldInfo> r0 = r4.fieldInfoMap
            java.lang.Object r0 = r0.get(r5)
            com.squareup.wire.MessageAdapter$FieldInfo r0 = (com.squareup.wire.MessageAdapter.FieldInfo) r0
            if (r0 != 0) goto L2e
        L2c:
            r0 = r1
            goto L30
        L2e:
            java.lang.Class<? extends com.squareup.wire.ProtoEnum> r0 = r0.enumType
        L30:
            r2 = 40
            if (r0 != 0) goto L37
            r3 = 53
            goto L39
        L37:
            r3 = 40
        L39:
            if (r3 == r2) goto L51
            com.squareup.wire.Extension r5 = r4.getExtension(r5)
            r2 = 41
            if (r5 == 0) goto L46
            r3 = 41
            goto L47
        L46:
            r3 = 5
        L47:
            if (r3 == r2) goto L4a
            goto L51
        L4a:
            java.lang.Class r0 = r5.getEnumType()     // Catch: java.lang.Exception -> L4f
            goto L51
        L4f:
            r5 = move-exception
            throw r5
        L51:
            int r5 = com.squareup.wire.MessageAdapter.BuiltInFictitiousFunctionClassFactory
            int r5 = r5 + 103
            int r2 = r5 % 128
            com.squareup.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r5 = r5 % 2
            if (r5 == 0) goto L61
            int r5 = r1.length     // Catch: java.lang.Throwable -> L5f
            return r0
        L5f:
            r5 = move-exception
            throw r5
        L61:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.MessageAdapter.getEnumClass(int):java.lang.Class");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ImmutableList<T> extends AbstractList<T> implements Cloneable, RandomAccess, Serializable {
        private final List<T> list = new ArrayList();

        public Object clone() {
            return this;
        }

        ImmutableList() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.list.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            return this.list.get(i);
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        try {
            char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory ^ 3919452569568103912L, cArr, i);
            d.MyBillsEntityDataFactory = 4;
            int i2 = $10 + 115;
            $11 = i2 % 128;
            int i3 = i2 % 2;
            while (true) {
                if ((d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$22.length ? '_' : Typography.amp) == '_') {
                    int i4 = $10 + 73;
                    $11 = i4 % 128;
                    int i5 = i4 % 2;
                    d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                    KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (MyBillsEntityDataFactory ^ 3919452569568103912L)));
                    d.MyBillsEntityDataFactory++;
                } else {
                    objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
                    return;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
