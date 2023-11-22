package com.zoloz.wire;

import android.view.ViewConfiguration;
import com.alibaba.fastjson.parser.JSONLexer;
import com.zoloz.wire.Message;
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
/* loaded from: classes8.dex */
public final class MessageAdapter<M extends Message> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long BuiltInFictitiousFunctionClassFactory = 2645520953040285859L;
    private static final String FULL_BLOCK = "█";
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static int PlaceComponentResult = 0;
    private static final String REDACTED = "██";
    private final TagMap<FieldInfo> fieldInfoMap;
    private final Class<M> messageType;
    private final Map<String, Integer> tagMap = new LinkedHashMap();
    private final Wire wire;

    /* loaded from: classes8.dex */
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
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Collection<FieldInfo> values = this.fieldInfoMap.values();
        int i3 = PlaceComponentResult + 123;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return values;
    }

    final FieldInfo getField(String str) {
        Integer num = this.tagMap.get(str);
        if ((num == null ? 'I' : (char) 25) != 25) {
            int i = PlaceComponentResult + 25;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            return null;
        }
        FieldInfo fieldInfo = this.fieldInfoMap.get(num.intValue());
        int i3 = PlaceComponentResult + 33;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return fieldInfo;
    }

    final Object getFieldValue(M m, FieldInfo fieldInfo) {
        if ((fieldInfo.messageField != null ? '7' : '[') != '[') {
            try {
                int i = PlaceComponentResult + 97;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                try {
                    Object obj = fieldInfo.messageField.get(m);
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 17;
                    PlaceComponentResult = i3 % 128;
                    if ((i3 % 2 != 0 ? (char) 0 : (char) 31) != 31) {
                        Object[] objArr = null;
                        int length = objArr.length;
                        return obj;
                    }
                    return obj;
                } catch (IllegalAccessException e) {
                    throw new AssertionError(e);
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        throw new AssertionError("Field is not of type \"Message\"");
    }

    public final void setBuilderField(M m, int i, Object obj) {
        int i2 = PlaceComponentResult + 61;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                this.fieldInfoMap.get(i).builderField.set(m, obj);
                int i3 = 61 / 0;
                return;
            }
            this.fieldInfoMap.get(i).builderField.set(m, obj);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageAdapter(Wire wire, Class<M> cls) {
        this.wire = wire;
        this.messageType = cls;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Field field : cls.getDeclaredFields()) {
            ProtoField protoField = (ProtoField) field.getAnnotation(ProtoField.class);
            if ((protoField != null ? '3' : 'X') == '3') {
                try {
                    int i = PlaceComponentResult + 75;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                    int i2 = i % 2;
                    int tag = protoField.tag();
                    String name = field.getName();
                    this.tagMap.put(name, Integer.valueOf(tag));
                    Class cls2 = null;
                    Message.Datatype type = protoField.type();
                    if (type == Message.Datatype.ENUM) {
                        cls2 = getEnumType(field);
                    } else if (!(type != Message.Datatype.MESSAGE)) {
                        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
                        PlaceComponentResult = i3 % 128;
                        int i4 = i3 % 2;
                        cls2 = getMessageType(field);
                    }
                    linkedHashMap.put(Integer.valueOf(tag), new FieldInfo(tag, name, type, protoField.label(), protoField.redacted(), cls2, field, getBuilderField(name), null));
                    int i5 = PlaceComponentResult + 43;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                    int i6 = i5 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        this.fieldInfoMap = TagMap.of(linkedHashMap);
    }

    private Class<Message.Builder<M>> getBuilderType(Class<M> cls) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append("$Builder");
            Class<Message.Builder<M>> cls2 = (Class<Message.Builder<M>>) Class.forName(sb.toString(), true, cls.getClassLoader());
            try {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 39;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                return cls2;
            } catch (Exception e) {
                throw e;
            }
        } catch (ClassNotFoundException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No builder class found for message type ");
            sb2.append(cls.getName());
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    private Field getBuilderField(String str) {
        try {
            int i = PlaceComponentResult + 17;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            try {
                if ((i % 2 == 0 ? JSONLexer.EOI : 'L') != 'L') {
                    int i2 = 25 / 0;
                    return this.messageType.getField(str);
                }
                return this.messageType.getField(str);
            } catch (NoSuchFieldException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("No builder field ");
                sb.append(this.messageType.getName());
                sb.append(".");
                sb.append(str);
                throw new AssertionError(sb.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private Class<Message> getMessageType(Field field) {
        Class type = field.getType();
        if (!Message.class.isAssignableFrom(type)) {
            Object[] objArr = null;
            if (List.class.isAssignableFrom(type)) {
                Type type2 = ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
                if (!(!(type2 instanceof Class))) {
                    try {
                        Class<Message> cls = (Class) type2;
                        if (Message.class.isAssignableFrom(cls)) {
                            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 115;
                            PlaceComponentResult = i % 128;
                            if (!(i % 2 != 0)) {
                                return cls;
                            }
                            int length = objArr.length;
                            return cls;
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
            int i2 = PlaceComponentResult + 113;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            return null;
        }
        return type;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
    
        if ((java.lang.Enum.class.isAssignableFrom(r5) ? kotlin.text.Typography.greater : 27) != 27) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:
    
        if (java.lang.Enum.class.isAssignableFrom(r5) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Class<java.lang.Enum> getEnumType(java.lang.reflect.Field r5) {
        /*
            r4 = this;
            java.lang.Class r0 = r5.getType()
            java.lang.Class<java.lang.Enum> r1 = java.lang.Enum.class
            boolean r1 = r1.isAssignableFrom(r0)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L10
            r1 = 0
            goto L11
        L10:
            r1 = 1
        L11:
            if (r1 == 0) goto L71
            java.lang.Class<java.util.List> r1 = java.util.List.class
            boolean r0 = r1.isAssignableFrom(r0)     // Catch: java.lang.Exception -> L6f
            if (r0 == 0) goto L5d
            java.lang.reflect.Type r5 = r5.getGenericType()
            java.lang.reflect.ParameterizedType r5 = (java.lang.reflect.ParameterizedType) r5
            java.lang.reflect.Type[] r5 = r5.getActualTypeArguments()
            r5 = r5[r3]
            boolean r0 = r5 instanceof java.lang.Class
            if (r0 == 0) goto L5d
            int r0 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 125
            int r1 = r0 % 128
            com.zoloz.wire.MessageAdapter.PlaceComponentResult = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L38
            r2 = 0
        L38:
            if (r2 == 0) goto L4e
            java.lang.Class r5 = (java.lang.Class) r5
            java.lang.Class<java.lang.Enum> r0 = java.lang.Enum.class
            boolean r0 = r0.isAssignableFrom(r5)
            r1 = 27
            if (r0 == 0) goto L49
            r0 = 62
            goto L4b
        L49:
            r0 = 27
        L4b:
            if (r0 == r1) goto L5d
            goto L5a
        L4e:
            java.lang.Class r5 = (java.lang.Class) r5
            java.lang.Class<java.lang.Enum> r0 = java.lang.Enum.class
            boolean r0 = r0.isAssignableFrom(r5)
            r1 = 2
            int r1 = r1 / r3
            if (r0 == 0) goto L5d
        L5a:
            return r5
        L5b:
            r5 = move-exception
            throw r5
        L5d:
            int r5 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 15
            int r0 = r5 % 128
            com.zoloz.wire.MessageAdapter.PlaceComponentResult = r0
            int r5 = r5 % 2
            r0 = 0
            if (r5 == 0) goto L6e
            int r5 = r0.length     // Catch: java.lang.Throwable -> L6c
            return r0
        L6c:
            r5 = move-exception
            throw r5
        L6e:
            return r0
        L6f:
            r5 = move-exception
            throw r5
        L71:
            int r5 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 79
            int r1 = r5 % 128
            com.zoloz.wire.MessageAdapter.PlaceComponentResult = r1
            int r5 = r5 % 2
            if (r5 == 0) goto L83
            r5 = 21
            int r5 = r5 / r3
            return r0
        L81:
            r5 = move-exception
            throw r5
        L83:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zoloz.wire.MessageAdapter.getEnumType(java.lang.reflect.Field):java.lang.Class");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:
    
        if (r7 != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
    
        if (r3.isRepeated() != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005b, code lost:
    
        r7 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 + 83;
        com.zoloz.wire.MessageAdapter.PlaceComponentResult = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006b, code lost:
    
        if (r3.isPacked() == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
    
        r3 = 31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
    
        r3 = '4';
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0072, code lost:
    
        if (r3 == '4') goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0074, code lost:
    
        r3 = com.zoloz.wire.MessageAdapter.PlaceComponentResult + 43;
        com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r3 % 128;
        r3 = r3 % 2;
        r3 = getPackedSize((java.util.List) r4, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0085, code lost:
    
        r3 = getRepeatedSize((java.util.List) r4, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008c, code lost:
    
        r3 = getSerializedSize(r5, r4, r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int getSerializedSize(M r10) {
        /*
            r9 = this;
            int r0 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 93
            int r1 = r0 % 128
            com.zoloz.wire.MessageAdapter.PlaceComponentResult = r1
            int r0 = r0 % 2
            java.util.Collection r0 = r9.getFields()
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
            r2 = 0
        L14:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L94
            int r3 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r3 = r3 + 37
            int r4 = r3 % 128
            com.zoloz.wire.MessageAdapter.PlaceComponentResult = r4
            int r3 = r3 % 2
            java.lang.Object r3 = r0.next()
            com.zoloz.wire.MessageAdapter$FieldInfo r3 = (com.zoloz.wire.MessageAdapter.FieldInfo) r3
            java.lang.Object r4 = r9.getFieldValue(r10, r3)
            if (r4 == 0) goto L14
            int r5 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L92
            int r5 = r5 + 11
            int r6 = r5 % 128
            com.zoloz.wire.MessageAdapter.PlaceComponentResult = r6     // Catch: java.lang.Exception -> L92
            int r5 = r5 % 2
            if (r5 == 0) goto L4f
            int r5 = r3.tag
            com.zoloz.wire.Message$Datatype r6 = r3.datatype
            com.zoloz.wire.Message$Label r3 = r3.label
            boolean r7 = r3.isRepeated()
            r8 = 0
            r8.hashCode()     // Catch: java.lang.Throwable -> L4d
            if (r7 == 0) goto L8c
            goto L5b
        L4d:
            r10 = move-exception
            throw r10
        L4f:
            int r5 = r3.tag
            com.zoloz.wire.Message$Datatype r6 = r3.datatype
            com.zoloz.wire.Message$Label r3 = r3.label
            boolean r7 = r3.isRepeated()
            if (r7 == 0) goto L8c
        L5b:
            int r7 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = r7 + 83
            int r8 = r7 % 128
            com.zoloz.wire.MessageAdapter.PlaceComponentResult = r8
            int r7 = r7 % 2
            boolean r3 = r3.isPacked()
            r7 = 52
            if (r3 == 0) goto L70
            r3 = 31
            goto L72
        L70:
            r3 = 52
        L72:
            if (r3 == r7) goto L85
            int r3 = com.zoloz.wire.MessageAdapter.PlaceComponentResult
            int r3 = r3 + 43
            int r7 = r3 % 128
            com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r7
            int r3 = r3 % 2
            java.util.List r4 = (java.util.List) r4
            int r3 = r9.getPackedSize(r4, r5, r6)
            goto L90
        L85:
            java.util.List r4 = (java.util.List) r4
            int r3 = r9.getRepeatedSize(r4, r5, r6)
            goto L90
        L8c:
            int r3 = r9.getSerializedSize(r5, r4, r6)
        L90:
            int r2 = r2 + r3
            goto L14
        L92:
            r10 = move-exception
            goto Lc0
        L94:
            boolean r0 = r10 instanceof com.zoloz.wire.ExtendableMessage
            r3 = 1
            if (r0 == 0) goto L9b
            r0 = 1
            goto L9c
        L9b:
            r0 = 0
        L9c:
            if (r0 == r3) goto L9f
            goto Lba
        L9f:
            int r0 = com.zoloz.wire.MessageAdapter.PlaceComponentResult
            int r0 = r0 + 111
            int r4 = r0 % 128
            com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r0 = r0 % 2
            r0 = r10
            com.zoloz.wire.ExtendableMessage r0 = (com.zoloz.wire.ExtendableMessage) r0
            com.zoloz.wire.ExtensionMap<T extends com.zoloz.wire.ExtendableMessage<?>> r4 = r0.extensionMap
            if (r4 == 0) goto Lb1
            r1 = 1
        Lb1:
            if (r1 == 0) goto Lba
            com.zoloz.wire.ExtensionMap<T extends com.zoloz.wire.ExtendableMessage<?>> r0 = r0.extensionMap
            int r0 = r9.getExtensionsSerializedSize(r0)
            int r2 = r2 + r0
        Lba:
            int r10 = r10.getUnknownFieldsSerializedSize()     // Catch: java.lang.Exception -> L92
            int r2 = r2 + r10
            return r2
        Lc0:
            goto Lc2
        Lc1:
            throw r10
        Lc2:
            goto Lc1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zoloz.wire.MessageAdapter.getSerializedSize(com.zoloz.wire.Message):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
    
        if (r3.isPacked() != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
    
        if ((r3.isPacked() ? 15 : 19) != 15) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        r3 = getRepeatedSize((java.util.List) r4, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0064, code lost:
    
        r4 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 + 109;
        com.zoloz.wire.MessageAdapter.PlaceComponentResult = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006f, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0070, code lost:
    
        throw r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0071, code lost:
    
        r3 = getPackedSize((java.util.List) r4, r5, r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T extends com.zoloz.wire.ExtendableMessage<?>> int getExtensionsSerializedSize(com.zoloz.wire.ExtensionMap<T> r10) {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            r2 = 0
        L3:
            int r3 = r10.size()
            if (r1 >= r3) goto L7d
            int r3 = com.zoloz.wire.MessageAdapter.PlaceComponentResult     // Catch: java.lang.Exception -> L7b
            int r3 = r3 + 81
            int r4 = r3 % 128
            com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r3 = r3 % 2
            com.zoloz.wire.Extension r3 = r10.getExtension(r1)
            java.lang.Object r4 = r10.getExtensionValue(r1)
            int r5 = r3.getTag()
            com.zoloz.wire.Message$Datatype r6 = r3.getDatatype()
            com.zoloz.wire.Message$Label r3 = r3.getLabel()
            boolean r7 = r3.isRepeated()
            if (r7 == 0) goto L2f
            r7 = 0
            goto L30
        L2f:
            r7 = 1
        L30:
            if (r7 == 0) goto L37
            int r3 = r9.getSerializedSize(r5, r4, r6)
            goto L77
        L37:
            int r7 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = r7 + 87
            int r8 = r7 % 128
            com.zoloz.wire.MessageAdapter.PlaceComponentResult = r8
            int r7 = r7 % 2
            if (r7 == 0) goto L4f
            boolean r3 = r3.isPacked()
            r7 = 39
            int r7 = r7 / r0
            if (r3 == 0) goto L5e
            goto L71
        L4d:
            r10 = move-exception
            throw r10
        L4f:
            boolean r3 = r3.isPacked()     // Catch: java.lang.Exception -> L7b
            r7 = 15
            if (r3 == 0) goto L5a
            r3 = 15
            goto L5c
        L5a:
            r3 = 19
        L5c:
            if (r3 == r7) goto L71
        L5e:
            java.util.List r4 = (java.util.List) r4     // Catch: java.lang.Exception -> L6f
            int r3 = r9.getRepeatedSize(r4, r5, r6)     // Catch: java.lang.Exception -> L6f
            int r4 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L7b
            int r4 = r4 + 109
            int r5 = r4 % 128
            com.zoloz.wire.MessageAdapter.PlaceComponentResult = r5     // Catch: java.lang.Exception -> L7b
            int r4 = r4 % 2
            goto L77
        L6f:
            r10 = move-exception
            throw r10
        L71:
            java.util.List r4 = (java.util.List) r4
            int r3 = r9.getPackedSize(r4, r5, r6)
        L77:
            int r2 = r2 + r3
            int r1 = r1 + 1
            goto L3
        L7b:
            r10 = move-exception
            throw r10
        L7d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zoloz.wire.MessageAdapter.getExtensionsSerializedSize(com.zoloz.wire.ExtensionMap):int");
    }

    private int getRepeatedSize(List<?> list, int i, Message.Datatype datatype) {
        Iterator<?> it = list.iterator();
        int i2 = 0;
        while (true) {
            if (!(it.hasNext())) {
                try {
                    break;
                } catch (Exception e) {
                    throw e;
                }
            }
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 63;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            i2 += getSerializedSize(i, it.next(), datatype);
        }
        int i5 = PlaceComponentResult + 69;
        try {
            KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
            if ((i5 % 2 == 0 ? (char) 31 : '\n') != '\n') {
                Object obj = null;
                obj.hashCode();
                return i2;
            }
            return i2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private int getPackedSize(List<?> list, int i, Message.Datatype datatype) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 91;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        Iterator<?> it = list.iterator();
        int i4 = 0;
        while (true) {
            if (!(!it.hasNext())) {
                try {
                    int i5 = PlaceComponentResult + 115;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                    i4 = i5 % 2 == 0 ? i4 << getSerializedSizeNoTag(it.next(), datatype) : i4 + getSerializedSizeNoTag(it.next(), datatype);
                } catch (Exception e) {
                    throw e;
                }
            } else {
                return WireOutput.varint32Size(WireOutput.makeTag(i, WireType.LENGTH_DELIMITED)) + WireOutput.varint32Size(i4) + i4;
            }
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void write(M m, WireOutput wireOutput) throws IOException {
        for (FieldInfo fieldInfo : getFields()) {
            try {
                try {
                    int i = PlaceComponentResult + 123;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                    int i2 = i % 2;
                    Object fieldValue = getFieldValue(m, fieldInfo);
                    if (fieldValue != null) {
                        int i3 = fieldInfo.tag;
                        Message.Datatype datatype = fieldInfo.datatype;
                        Message.Label label = fieldInfo.label;
                        if (!label.isRepeated()) {
                            writeValue(wireOutput, i3, fieldValue, datatype);
                        } else if ((label.isPacked() ? (char) 11 : Typography.amp) != 11) {
                            writeRepeated(wireOutput, (List) fieldValue, i3, datatype);
                        } else {
                            int i4 = PlaceComponentResult + 107;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                            if (i4 % 2 == 0) {
                                writePacked(wireOutput, (List) fieldValue, i3, datatype);
                                Object[] objArr = null;
                                int length = objArr.length;
                            } else {
                                writePacked(wireOutput, (List) fieldValue, i3, datatype);
                            }
                            int i5 = PlaceComponentResult + 65;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                            int i6 = i5 % 2;
                        }
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        if (!(!(m instanceof ExtendableMessage))) {
            ExtendableMessage extendableMessage = (ExtendableMessage) m;
            if (extendableMessage.extensionMap != null) {
                writeExtensions(wireOutput, extendableMessage.extensionMap);
            }
        }
        m.writeUnknownFieldMap(wireOutput);
    }

    private <T extends ExtendableMessage<?>> void writeExtensions(WireOutput wireOutput, ExtensionMap<T> extensionMap) throws IOException {
        int i = 0;
        while (true) {
            try {
                if ((i < extensionMap.size() ? (char) 6 : 'B') != 6) {
                    return;
                }
                int i2 = PlaceComponentResult + 75;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                int i3 = i2 % 2;
                Extension<T, ?> extension = extensionMap.getExtension(i);
                Object extensionValue = extensionMap.getExtensionValue(i);
                int tag = extension.getTag();
                Message.Datatype datatype = extension.getDatatype();
                Message.Label label = extension.getLabel();
                if (label.isRepeated()) {
                    if (!(!label.isPacked())) {
                        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 113;
                        PlaceComponentResult = i4 % 128;
                        int i5 = i4 % 2;
                        writePacked(wireOutput, (List) extensionValue, tag, datatype);
                        if (i5 != 0) {
                            Object obj = null;
                            obj.hashCode();
                        } else {
                            continue;
                        }
                    } else {
                        writeRepeated(wireOutput, (List) extensionValue, tag, datatype);
                    }
                } else {
                    writeValue(wireOutput, tag, extensionValue, datatype);
                    int i6 = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
                    PlaceComponentResult = i6 % 128;
                    int i7 = i6 % 2;
                }
                i++;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private void writeRepeated(WireOutput wireOutput, List<?> list, int i, Message.Datatype datatype) throws IOException {
        Iterator<?> it = list.iterator();
        while (true) {
            if (!(it.hasNext())) {
                break;
            }
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
            writeValue(wireOutput, i, it.next(), datatype);
        }
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
        PlaceComponentResult = i4 % 128;
        if ((i4 % 2 != 0 ? 'S' : '1') != 'S') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    private void writePacked(WireOutput wireOutput, List<?> list, int i, Message.Datatype datatype) throws IOException {
        int i2 = PlaceComponentResult + 111;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        Iterator<?> it = list.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 37;
            PlaceComponentResult = i5 % 128;
            int i6 = i5 % 2;
            i4 += getSerializedSizeNoTag(it.next(), datatype);
        }
        try {
            wireOutput.writeTag(i, WireType.LENGTH_DELIMITED);
            wireOutput.writeVarint32(i4);
            Iterator<?> it2 = list.iterator();
            int i7 = PlaceComponentResult + 67;
            KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
            int i8 = i7 % 2;
            while (true) {
                if (!it2.hasNext()) {
                    return;
                }
                int i9 = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
                PlaceComponentResult = i9 % 128;
                if ((i9 % 2 != 0 ? Typography.quote : 'P') != 'P') {
                    writeValueNoTag(wireOutput, it2.next(), datatype);
                    int i10 = 95 / 0;
                } else {
                    writeValueNoTag(wireOutput, it2.next(), datatype);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] toByteArray(M m) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        byte[] bArr = new byte[getSerializedSize(m)];
        try {
            write(m, WireOutput.newInstance(bArr));
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 1;
            PlaceComponentResult = i3 % 128;
            if (i3 % 2 == 0) {
                return bArr;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String toString(M r7) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Class<M extends com.zoloz.wire.Message> r1 = r6.messageType
            java.lang.String r1 = r1.getSimpleName()
            r0.append(r1)
            java.lang.String r1 = "{"
            r0.append(r1)
            java.util.Collection r1 = r6.getFields()
            java.util.Iterator r1 = r1.iterator()
            int r2 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r2 = r2 + 23
            int r3 = r2 % 128
            com.zoloz.wire.MessageAdapter.PlaceComponentResult = r3
            int r2 = r2 % 2
            java.lang.String r2 = ""
        L27:
            boolean r3 = r1.hasNext()
            r4 = 96
            if (r3 == 0) goto L31
            r3 = 3
            goto L33
        L31:
            r3 = 96
        L33:
            if (r3 == r4) goto L91
            int r3 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r3 = r3 + 73
            int r4 = r3 % 128
            com.zoloz.wire.MessageAdapter.PlaceComponentResult = r4
            int r3 = r3 % 2
            if (r3 == 0) goto L54
            java.lang.Object r3 = r1.next()
            com.zoloz.wire.MessageAdapter$FieldInfo r3 = (com.zoloz.wire.MessageAdapter.FieldInfo) r3
            java.lang.Object r4 = r6.getFieldValue(r7, r3)
            r5 = 77
            int r5 = r5 / 0
            if (r4 == 0) goto L27
            goto L60
        L52:
            r7 = move-exception
            throw r7
        L54:
            java.lang.Object r3 = r1.next()
            com.zoloz.wire.MessageAdapter$FieldInfo r3 = (com.zoloz.wire.MessageAdapter.FieldInfo) r3
            java.lang.Object r4 = r6.getFieldValue(r7, r3)
            if (r4 == 0) goto L27
        L60:
            r0.append(r2)     // Catch: java.lang.Exception -> L8f
            java.lang.String r2 = r3.name     // Catch: java.lang.Exception -> L8d
            r0.append(r2)     // Catch: java.lang.Exception -> L8d
            java.lang.String r2 = "="
            r0.append(r2)     // Catch: java.lang.Exception -> L8f
            boolean r2 = r3.redacted     // Catch: java.lang.Exception -> L8f
            r3 = 51
            if (r2 == 0) goto L76
            r2 = 51
            goto L78
        L76:
            r2 = 68
        L78:
            if (r2 == r3) goto L7b
            goto L87
        L7b:
            int r2 = com.zoloz.wire.MessageAdapter.PlaceComponentResult
            int r2 = r2 + 69
            int r3 = r2 % 128
            com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r2 = r2 % 2
            java.lang.String r4 = "██"
        L87:
            r0.append(r4)
            java.lang.String r2 = ", "
            goto L27
        L8d:
            r7 = move-exception
            throw r7
        L8f:
            r7 = move-exception
            throw r7
        L91:
            boolean r1 = r7 instanceof com.zoloz.wire.ExtendableMessage
            java.lang.String r3 = "}"
            if (r1 == 0) goto Lab
            com.zoloz.wire.ExtendableMessage r7 = (com.zoloz.wire.ExtendableMessage) r7
            r0.append(r2)
            java.lang.String r1 = "{extensions="
            r0.append(r1)
            java.lang.String r7 = r7.extensionsToString()
            r0.append(r7)
            r0.append(r3)
        Lab:
            r0.append(r3)
            java.lang.String r7 = r0.toString()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zoloz.wire.MessageAdapter.toString(com.zoloz.wire.Message):java.lang.String");
    }

    private int getSerializedSize(int i, Object obj, Message.Datatype datatype) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        try {
            int varintTagSize = WireOutput.varintTagSize(i) + getSerializedSizeNoTag(obj, datatype);
            int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 113;
            PlaceComponentResult = i4 % 128;
            int i5 = i4 % 2;
            return varintTagSize;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int getSerializedSizeNoTag(java.lang.Object r4, com.zoloz.wire.Message.Datatype r5) {
        /*
            r3 = this;
            int r0 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 67
            int r1 = r0 % 128
            com.zoloz.wire.MessageAdapter.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == r2) goto L20
            int[] r0 = com.zoloz.wire.MessageAdapter.AnonymousClass1.$SwitchMap$com$squareup$wire$Message$Datatype
            int r5 = r5.ordinal()
            r5 = r0[r5]
            switch(r5) {
                case 1: goto Lbc;
                case 2: goto Lb1;
                case 3: goto Lb1;
                case 4: goto La4;
                case 5: goto L95;
                case 6: goto L86;
                case 7: goto L85;
                case 8: goto L7e;
                case 9: goto L72;
                case 10: goto L65;
                case 11: goto L54;
                case 12: goto L3d;
                case 13: goto L3d;
                case 14: goto L3d;
                case 15: goto L30;
                case 16: goto L30;
                case 17: goto L30;
                default: goto L1e;
            }
        L1e:
            goto Lc7
        L20:
            int[] r0 = com.zoloz.wire.MessageAdapter.AnonymousClass1.$SwitchMap$com$squareup$wire$Message$Datatype
            int r5 = r5.ordinal()
            r5 = r0[r5]
            r0 = 90
            int r0 = r0 / r1
            switch(r5) {
                case 1: goto Lbc;
                case 2: goto Lb1;
                case 3: goto Lb1;
                case 4: goto La4;
                case 5: goto L95;
                case 6: goto L86;
                case 7: goto L85;
                case 8: goto L7e;
                case 9: goto L72;
                case 10: goto L65;
                case 11: goto L54;
                case 12: goto L3d;
                case 13: goto L3d;
                case 14: goto L3d;
                case 15: goto L30;
                case 16: goto L30;
                case 17: goto L30;
                default: goto L2e;
            }
        L2e:
            goto Lc7
        L30:
            r4 = 8
            int r5 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 109
            int r0 = r5 % 128
            com.zoloz.wire.MessageAdapter.PlaceComponentResult = r0
            int r5 = r5 % 2
            return r4
        L3d:
            r4 = 4
            int r5 = com.zoloz.wire.MessageAdapter.PlaceComponentResult
            int r5 = r5 + 85
            int r0 = r5 % 128
            com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r5 = r5 % 2
            if (r5 != 0) goto L4b
            goto L4c
        L4b:
            r1 = 1
        L4c:
            if (r1 == r2) goto L53
            r5 = 0
            int r5 = r5.length     // Catch: java.lang.Throwable -> L51
            return r4
        L51:
            r4 = move-exception
            throw r4
        L53:
            return r4
        L54:
            com.zoloz.wire.Message r4 = (com.zoloz.wire.Message) r4
            int r4 = r3.getMessageSize(r4)
            int r5 = com.zoloz.wire.MessageAdapter.PlaceComponentResult
            int r5 = r5 + 19
            int r0 = r5 % 128
            com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r5 = r5 % 2
            return r4
        L65:
            okio.ByteString r4 = (okio.ByteString) r4     // Catch: java.lang.Exception -> L70
            int r4 = r4.size()     // Catch: java.lang.Exception -> L70
            int r5 = com.zoloz.wire.WireOutput.varint32Size(r4)     // Catch: java.lang.Exception -> L70
            goto L7c
        L70:
            r4 = move-exception
            throw r4
        L72:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = r3.utf8Length(r4)
            int r5 = com.zoloz.wire.WireOutput.varint32Size(r4)
        L7c:
            int r5 = r5 + r4
            return r5
        L7e:
            com.zoloz.wire.ProtoEnum r4 = (com.zoloz.wire.ProtoEnum) r4
            int r4 = r3.getEnumSize(r4)
            return r4
        L85:
            return r2
        L86:
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            long r4 = com.zoloz.wire.WireOutput.zigZag64(r4)
            int r4 = com.zoloz.wire.WireOutput.varint64Size(r4)
            return r4
        L95:
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            int r4 = com.zoloz.wire.WireOutput.zigZag32(r4)
            int r4 = com.zoloz.wire.WireOutput.varint32Size(r4)
            return r4
        La4:
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Exception -> Laf
            int r4 = r4.intValue()     // Catch: java.lang.Exception -> Laf
            int r4 = com.zoloz.wire.WireOutput.varint32Size(r4)     // Catch: java.lang.Exception -> Laf
            return r4
        Laf:
            r4 = move-exception
            throw r4
        Lb1:
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            int r4 = com.zoloz.wire.WireOutput.varint64Size(r4)
            return r4
        Lbc:
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            int r4 = com.zoloz.wire.WireOutput.int32Size(r4)
            return r4
        Lc7:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            r4.<init>()
            throw r4
        Lcd:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zoloz.wire.MessageAdapter.getSerializedSizeNoTag(java.lang.Object, com.zoloz.wire.Message$Datatype):int");
    }

    private int utf8Length(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                return i2;
            }
            char charAt = str.charAt(i);
            if (charAt <= 127) {
                i2++;
            } else {
                if (charAt > 2047) {
                    if ((Character.isHighSurrogate(charAt) ? (char) 4 : '=') != '=') {
                        i2 += 4;
                        i++;
                    } else {
                        i2 += 3;
                    }
                } else {
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
                    PlaceComponentResult = i3 % 128;
                    int i4 = i3 % 2;
                    i2 += 2;
                }
            }
            i++;
            try {
                int i5 = PlaceComponentResult + 109;
                try {
                    KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                    int i6 = i5 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private <E extends ProtoEnum> int getEnumSize(E e) {
        int i = PlaceComponentResult + 45;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        int varint32Size = WireOutput.varint32Size(this.wire.enumAdapter(e.getClass()).toInt(e));
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 7;
            PlaceComponentResult = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return varint32Size;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return varint32Size;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private <M extends Message> int getMessageSize(M m) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 91;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        int serializedSize = m.getSerializedSize();
        int varint32Size = WireOutput.varint32Size(serializedSize) + serializedSize;
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 89;
        PlaceComponentResult = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 4 : Typography.dollar) != 4) {
            return varint32Size;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return varint32Size;
    }

    private void writeValue(WireOutput wireOutput, int i, Object obj, Message.Datatype datatype) throws IOException {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 3;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        wireOutput.writeTag(i, datatype.wireType());
        writeValueNoTag(wireOutput, obj, datatype);
        try {
            int i4 = PlaceComponentResult + 15;
            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeValueNoTag(WireOutput wireOutput, Object obj, Message.Datatype datatype) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$squareup$wire$Message$Datatype[datatype.ordinal()]) {
            case 1:
                wireOutput.writeSignedVarint32(((Integer) obj).intValue());
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 111;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                return;
            case 2:
            case 3:
                wireOutput.writeVarint64(((Long) obj).longValue());
                return;
            case 4:
                wireOutput.writeVarint32(((Integer) obj).intValue());
                return;
            case 5:
                wireOutput.writeVarint32(WireOutput.zigZag32(((Integer) obj).intValue()));
                int i3 = PlaceComponentResult + 81;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    int i4 = 61 / 0;
                    return;
                }
                return;
            case 6:
                wireOutput.writeVarint64(WireOutput.zigZag64(((Long) obj).longValue()));
                int i5 = PlaceComponentResult + 117;
                KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                int i6 = i5 % 2;
                return;
            case 7:
                wireOutput.writeRawByte(((Boolean) obj).booleanValue() ? 1 : 0);
                return;
            case 8:
                writeEnum((ProtoEnum) obj, wireOutput);
                return;
            case 9:
                Object[] objArr = new Object[1];
                a(1 - (ViewConfiguration.getJumpTapTimeout() >> 16), new char[]{43706, 39179, 43759, 17333, 25620, 47461, 42317, 21121, 24494}, objArr);
                byte[] bytes = ((String) obj).getBytes(((String) objArr[0]).intern());
                wireOutput.writeVarint32(bytes.length);
                wireOutput.writeRawBytes(bytes);
                return;
            case 10:
                ByteString byteString = (ByteString) obj;
                wireOutput.writeVarint32(byteString.size());
                wireOutput.writeRawBytes(byteString.toByteArray());
                return;
            case 11:
                writeMessage((Message) obj, wireOutput);
                return;
            case 12:
            case 13:
                wireOutput.writeFixed32(((Integer) obj).intValue());
                return;
            case 14:
                wireOutput.writeFixed32(Float.floatToIntBits(((Float) obj).floatValue()));
                return;
            case 15:
            case 16:
                wireOutput.writeFixed64(((Long) obj).longValue());
                return;
            case 17:
                wireOutput.writeFixed64(Double.doubleToLongBits(((Double) obj).doubleValue()));
                return;
            default:
                throw new RuntimeException();
        }
    }

    private <M extends Message> void writeMessage(M m, WireOutput wireOutput) throws IOException {
        int i = PlaceComponentResult + 121;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        wireOutput.writeVarint32(m.getSerializedSize());
        this.wire.messageAdapter(m.getClass()).write(m, wireOutput);
        int i3 = PlaceComponentResult + 47;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    private <E extends ProtoEnum> void writeEnum(E e, WireOutput wireOutput) throws IOException {
        int i = PlaceComponentResult + 123;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        wireOutput.writeVarint32(this.wire.enumAdapter(e.getClass()).toInt(e));
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 51;
        PlaceComponentResult = i3 % 128;
        if (i3 % 2 != 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, com.zoloz.wire.MessageAdapter$1] */
    public final M read(WireInput wireInput) throws IOException {
        Message.Datatype datatype;
        Message.Label label;
        Message.Datatype datatype2;
        Extension<?, ?> extension;
        char c;
        char c2;
        long j;
        try {
            M newInstance = this.messageType.newInstance();
            ?? r4 = 0;
            Storage storage = new Storage(r4);
            while (true) {
                int readTag = wireInput.readTag();
                int i = readTag >> 3;
                WireType valueOf = WireType.valueOf(readTag);
                if (i == 0) {
                    Iterator<Integer> it = storage.getTags().iterator();
                    int i2 = PlaceComponentResult + 83;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                    int i3 = i2 % 2;
                    while (true) {
                        if ((it.hasNext() ? JSONLexer.EOI : '(') == '(') {
                            return newInstance;
                        }
                        int intValue = it.next().intValue();
                        if (this.fieldInfoMap.containsKey(intValue)) {
                            setBuilderField(newInstance, intValue, storage.get(intValue));
                        } else {
                            setExtension((ExtendableMessage) newInstance, getExtension(intValue), storage.get(intValue));
                        }
                    }
                } else {
                    FieldInfo fieldInfo = this.fieldInfoMap.get(i);
                    if (fieldInfo != null) {
                        int i4 = PlaceComponentResult + 103;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                        if (i4 % 2 == 0) {
                            datatype = fieldInfo.datatype;
                            label = fieldInfo.label;
                            r4.hashCode();
                        } else {
                            datatype = fieldInfo.datatype;
                            label = fieldInfo.label;
                        }
                        datatype2 = datatype;
                        extension = null;
                    } else {
                        Extension<?, ?> extension2 = getExtension(i);
                        if (extension2 != null) {
                            Message.Datatype datatype3 = extension2.getDatatype();
                            extension = extension2;
                            label = extension2.getLabel();
                            datatype2 = datatype3;
                        } else {
                            readUnknownField(newInstance, wireInput, i, valueOf);
                        }
                    }
                    if (label.isPacked()) {
                        if ((valueOf == WireType.LENGTH_DELIMITED ? '\n' : (char) 23) != 23) {
                            int readVarint32 = wireInput.readVarint32();
                            long position = wireInput.getPosition();
                            int pushLimit = wireInput.pushLimit(readVarint32);
                            while (true) {
                                j = readVarint32 + position;
                                if (wireInput.getPosition() >= j) {
                                    break;
                                }
                                Object readValue = readValue(wireInput, i, datatype2);
                                if (datatype2 == Message.Datatype.ENUM) {
                                    int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 23;
                                    PlaceComponentResult = i5 % 128;
                                    if ((i5 % 2 != 0 ? 'U' : 'X') != 'X') {
                                        boolean z = readValue instanceof Integer;
                                        r4.hashCode();
                                        if (z) {
                                            newInstance.addVarint(i, ((Integer) readValue).intValue());
                                        }
                                    } else if (readValue instanceof Integer) {
                                        newInstance.addVarint(i, ((Integer) readValue).intValue());
                                    }
                                }
                                storage.add(i, readValue);
                            }
                            wireInput.popLimit(pushLimit);
                            if (wireInput.getPosition() != j) {
                                throw new IOException("Packed data had wrong length!");
                            }
                        }
                    }
                    Object readValue2 = readValue(wireInput, i, datatype2);
                    if (datatype2 == Message.Datatype.ENUM) {
                        try {
                            int i6 = PlaceComponentResult + 63;
                            try {
                                KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                                if (!(i6 % 2 == 0)) {
                                    if (readValue2 instanceof Integer) {
                                        c2 = 'X';
                                        c = 'X';
                                    } else {
                                        c = '7';
                                        c2 = 'X';
                                    }
                                    if (c == c2) {
                                        int i7 = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
                                        PlaceComponentResult = i7 % 128;
                                        int i8 = i7 % 2;
                                        newInstance.addVarint(i, ((Integer) readValue2).intValue());
                                    }
                                } else {
                                    boolean z2 = readValue2 instanceof Integer;
                                    int length = r4.length;
                                    if ((z2 ? '*' : '2') != '2') {
                                        int i72 = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
                                        PlaceComponentResult = i72 % 128;
                                        int i82 = i72 % 2;
                                        newInstance.addVarint(i, ((Integer) readValue2).intValue());
                                    }
                                }
                            } catch (Exception e) {
                                throw e;
                            }
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                    if (label.isRepeated()) {
                        storage.add(i, readValue2);
                    } else if (extension != null) {
                        setExtension((ExtendableMessage) newInstance, extension, readValue2);
                    } else {
                        setBuilderField(newInstance, i, readValue2);
                    }
                }
            }
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        } catch (InstantiationException e4) {
            throw new RuntimeException(e4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c A[Catch: Exception -> 0x003b, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x003b, blocks: (B:13:0x002c, B:43:0x0089), top: B:71:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object readValue(com.zoloz.wire.WireInput r4, int r5, com.zoloz.wire.Message.Datatype r6) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zoloz.wire.MessageAdapter.readValue(com.zoloz.wire.WireInput, int, com.zoloz.wire.Message$Datatype):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if (r6.recursionDepth < 64) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
    
        r3 = com.zoloz.wire.MessageAdapter.PlaceComponentResult + 15;
        com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r3 % 128;
        r3 = r3 % 2;
        r0 = r6.pushLimit(r0);
        r6.recursionDepth++;
        r7 = getMessageAdapter(r7).read(r6);
        r6.checkLastTagWas(0);
        r6.recursionDepth--;
        r6.popLimit(r0);
        r6 = com.zoloz.wire.MessageAdapter.PlaceComponentResult + 11;
        com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005a, code lost:
    
        if ((r6 % 2) != 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005c, code lost:
    
        r6 = 'B';
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005f, code lost:
    
        r6 = '\b';
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
    
        if (r6 == 'B') goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0065, code lost:
    
        r6.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0068, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0072, code lost:
    
        throw new java.io.IOException("Wire recursion limit exceeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
    
        if ((r6.recursionDepth >= 51) != true) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.zoloz.wire.Message readMessage(com.zoloz.wire.WireInput r6, int r7) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = com.zoloz.wire.MessageAdapter.PlaceComponentResult
            int r0 = r0 + 105
            int r1 = r0 % 128
            com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L1e
            int r0 = r6.readVarint32()
            int r3 = r6.recursionDepth
            r4 = 51
            if (r3 >= r4) goto L1a
            r3 = 0
            goto L1b
        L1a:
            r3 = 1
        L1b:
            if (r3 == r2) goto L6b
            goto L28
        L1e:
            int r0 = r6.readVarint32()
            int r3 = r6.recursionDepth
            r4 = 64
            if (r3 >= r4) goto L6b
        L28:
            int r3 = com.zoloz.wire.MessageAdapter.PlaceComponentResult
            int r3 = r3 + 15
            int r4 = r3 % 128
            com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r3 = r3 % 2
            int r0 = r6.pushLimit(r0)
            int r3 = r6.recursionDepth
            int r3 = r3 + r2
            r6.recursionDepth = r3
            com.zoloz.wire.MessageAdapter r7 = r5.getMessageAdapter(r7)
            com.zoloz.wire.Message r7 = r7.read(r6)
            r6.checkLastTagWas(r1)
            int r1 = r6.recursionDepth
            int r1 = r1 - r2
            r6.recursionDepth = r1
            r6.popLimit(r0)
            int r6 = com.zoloz.wire.MessageAdapter.PlaceComponentResult
            int r6 = r6 + 11
            int r0 = r6 % 128
            com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r6 = r6 % 2
            r0 = 66
            if (r6 != 0) goto L5f
            r6 = 66
            goto L61
        L5f:
            r6 = 8
        L61:
            if (r6 == r0) goto L64
            return r7
        L64:
            r6 = 0
            r6.hashCode()     // Catch: java.lang.Throwable -> L69
            return r7
        L69:
            r6 = move-exception
            throw r6
        L6b:
            java.io.IOException r6 = new java.io.IOException
            java.lang.String r7 = "Wire recursion limit exceeded"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zoloz.wire.MessageAdapter.readMessage(com.zoloz.wire.WireInput, int):com.zoloz.wire.Message");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private MessageAdapter<? extends Message> getMessageAdapter(int i) {
        FieldInfo fieldInfo = this.fieldInfoMap.get(i);
        try {
            if (fieldInfo != null) {
                if ((fieldInfo.messageAdapter != null ? 'P' : (char) 22) != 22) {
                    int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
                    PlaceComponentResult = i2 % 128;
                    int i3 = i2 % 2;
                    MessageAdapter<? extends Message> messageAdapter = fieldInfo.messageAdapter;
                    int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 15;
                    PlaceComponentResult = i4 % 128;
                    int i5 = i4 % 2;
                    return messageAdapter;
                }
            }
            MessageAdapter<? extends Message> messageAdapter2 = this.wire.messageAdapter(getMessageClass(i));
            if ((fieldInfo != null ? 'T' : '(') == 'T') {
                int i6 = PlaceComponentResult + 113;
                KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                if (i6 % 2 == 0) {
                    fieldInfo.messageAdapter = messageAdapter2;
                    Object obj = null;
                    obj.hashCode();
                } else {
                    fieldInfo.messageAdapter = messageAdapter2;
                }
            }
            int i7 = PlaceComponentResult + 41;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
                int i8 = i7 % 2;
                return messageAdapter2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        if ((r0 != null) != true) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if (r0 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        if (r0.enumAdapter == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        if (r1 == true) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003d, code lost:
    
        return r0.enumAdapter;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0040, code lost:
    
        r5 = r4.wire.enumAdapter(getEnumClass(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004a, code lost:
    
        if (r0 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004e, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004f, code lost:
    
        if (r1 == true) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0052, code lost:
    
        r1 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 + 59;
        com.zoloz.wire.MessageAdapter.PlaceComponentResult = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005c, code lost:
    
        if ((r1 % 2) == 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005e, code lost:
    
        r0.enumAdapter = r5;
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0061, code lost:
    
        r0.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0067, code lost:
    
        r0.enumAdapter = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0069, code lost:
    
        r0 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 + 105;
        com.zoloz.wire.MessageAdapter.PlaceComponentResult = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0073, code lost:
    
        if ((r0 % 2) == 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0077, code lost:
    
        r0 = 28 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0078, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x007b, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.zoloz.wire.EnumAdapter<? extends com.zoloz.wire.ProtoEnum> getEnumAdapter(int r5) {
        /*
            r4 = this;
            int r0 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 5
            int r1 = r0 % 128
            com.zoloz.wire.MessageAdapter.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 7
            if (r0 == 0) goto Lf
            r0 = 7
            goto L11
        Lf:
            r0 = 50
        L11:
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L25
            com.zoloz.wire.TagMap<com.zoloz.wire.MessageAdapter$FieldInfo> r0 = r4.fieldInfoMap
            java.lang.Object r0 = r0.get(r5)
            com.zoloz.wire.MessageAdapter$FieldInfo r0 = (com.zoloz.wire.MessageAdapter.FieldInfo) r0
            if (r0 == 0) goto L21
            r1 = 1
            goto L22
        L21:
            r1 = 0
        L22:
            if (r1 == r3) goto L32
            goto L40
        L25:
            com.zoloz.wire.TagMap<com.zoloz.wire.MessageAdapter$FieldInfo> r0 = r4.fieldInfoMap     // Catch: java.lang.Exception -> L7e
            java.lang.Object r0 = r0.get(r5)     // Catch: java.lang.Exception -> L7e
            com.zoloz.wire.MessageAdapter$FieldInfo r0 = (com.zoloz.wire.MessageAdapter.FieldInfo) r0     // Catch: java.lang.Exception -> L7e
            r1 = 52
            int r1 = r1 / r2
            if (r0 == 0) goto L40
        L32:
            com.zoloz.wire.EnumAdapter<? extends com.zoloz.wire.ProtoEnum> r1 = r0.enumAdapter
            if (r1 == 0) goto L38
            r1 = 0
            goto L39
        L38:
            r1 = 1
        L39:
            if (r1 == r3) goto L40
            com.zoloz.wire.EnumAdapter<? extends com.zoloz.wire.ProtoEnum> r5 = r0.enumAdapter     // Catch: java.lang.Exception -> L3e
            return r5
        L3e:
            r5 = move-exception
            throw r5
        L40:
            com.zoloz.wire.Wire r1 = r4.wire     // Catch: java.lang.Exception -> L7e
            java.lang.Class r5 = r4.getEnumClass(r5)     // Catch: java.lang.Exception -> L7e
            com.zoloz.wire.EnumAdapter r5 = r1.enumAdapter(r5)     // Catch: java.lang.Exception -> L7e
            if (r0 == 0) goto L4e
            r1 = 1
            goto L4f
        L4e:
            r1 = 0
        L4f:
            if (r1 == r3) goto L52
            goto L69
        L52:
            int r1 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r1 = r1 + 59
            int r3 = r1 % 128
            com.zoloz.wire.MessageAdapter.PlaceComponentResult = r3
            int r1 = r1 % 2
            if (r1 == 0) goto L67
            r0.enumAdapter = r5
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L65
            goto L69
        L65:
            r5 = move-exception
            throw r5
        L67:
            r0.enumAdapter = r5     // Catch: java.lang.Exception -> L7e
        L69:
            int r0 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 105
            int r1 = r0 % 128
            com.zoloz.wire.MessageAdapter.PlaceComponentResult = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L7b
            r0 = 28
            int r0 = r0 / r2
            return r5
        L79:
            r5 = move-exception
            throw r5
        L7b:
            return r5
        L7c:
            r5 = move-exception
            throw r5
        L7e:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zoloz.wire.MessageAdapter.getEnumAdapter(int):com.zoloz.wire.EnumAdapter");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
    
        if (r0 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        r1 = com.zoloz.wire.MessageAdapter.PlaceComponentResult + 103;
        com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        r0 = r0.messageType;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        if (r0 == null) goto L14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Class<com.zoloz.wire.Message> getMessageClass(int r5) {
        /*
            r4 = this;
            int r0 = com.zoloz.wire.MessageAdapter.PlaceComponentResult
            int r0 = r0 + 13
            int r1 = r0 % 128
            com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 75
            if (r0 != 0) goto L11
            r0 = 75
            goto L13
        L11:
            r0 = 78
        L13:
            r2 = 0
            if (r0 == r1) goto L21
            com.zoloz.wire.TagMap<com.zoloz.wire.MessageAdapter$FieldInfo> r0 = r4.fieldInfoMap
            java.lang.Object r0 = r0.get(r5)
            com.zoloz.wire.MessageAdapter$FieldInfo r0 = (com.zoloz.wire.MessageAdapter.FieldInfo) r0
            if (r0 != 0) goto L3a
            goto L2e
        L21:
            com.zoloz.wire.TagMap<com.zoloz.wire.MessageAdapter$FieldInfo> r0 = r4.fieldInfoMap
            java.lang.Object r0 = r0.get(r5)
            com.zoloz.wire.MessageAdapter$FieldInfo r0 = (com.zoloz.wire.MessageAdapter.FieldInfo) r0
            r1 = 72
            int r1 = r1 / r2
            if (r0 != 0) goto L3a
        L2e:
            r0 = 0
            int r1 = com.zoloz.wire.MessageAdapter.PlaceComponentResult     // Catch: java.lang.Exception -> L61
            int r1 = r1 + 103
            int r3 = r1 % 128
            com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r3     // Catch: java.lang.Exception -> L61
            int r1 = r1 % 2
            goto L3c
        L3a:
            java.lang.Class<? extends com.zoloz.wire.Message> r0 = r0.messageType     // Catch: java.lang.Exception -> L61
        L3c:
            if (r0 != 0) goto L40
            r2 = 32
        L40:
            if (r2 == 0) goto L56
            com.zoloz.wire.Extension r5 = r4.getExtension(r5)
            r1 = 35
            if (r5 == 0) goto L4d
            r2 = 35
            goto L4f
        L4d:
            r2 = 27
        L4f:
            if (r2 == r1) goto L52
            goto L56
        L52:
            java.lang.Class r0 = r5.getMessageType()
        L56:
            int r5 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 63
            int r1 = r5 % 128
            com.zoloz.wire.MessageAdapter.PlaceComponentResult = r1
            int r5 = r5 % 2
            return r0
        L61:
            r5 = move-exception
            throw r5
        L63:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zoloz.wire.MessageAdapter.getMessageClass(int):java.lang.Class");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.zoloz.wire.MessageAdapter$1  reason: invalid class name */
    /* loaded from: classes8.dex */
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

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f A[Catch: Exception -> 0x00a1, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x00a1, blocks: (B:16:0x002f, B:37:0x008f, B:38:0x00a0), top: B:45:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void readUnknownField(com.zoloz.wire.Message r5, com.zoloz.wire.WireInput r6, int r7, com.zoloz.wire.WireType r8) throws java.io.IOException {
        /*
            r4 = this;
            int r0 = com.zoloz.wire.MessageAdapter.PlaceComponentResult
            int r0 = r0 + 7
            int r1 = r0 % 128
            com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == r2) goto L23
            int[] r0 = com.zoloz.wire.MessageAdapter.AnonymousClass1.$SwitchMap$com$squareup$wire$WireType
            int r3 = r8.ordinal()
            r0 = r0[r3]
            r3 = 1
            int r3 = r3 / r1
            switch(r0) {
                case 1: goto L7a;
                case 2: goto L6a;
                case 3: goto L5a;
                case 4: goto L4a;
                case 5: goto L2f;
                case 6: goto L89;
                default: goto L20;
            }
        L20:
            goto L8a
        L21:
            r5 = move-exception
            throw r5
        L23:
            int[] r0 = com.zoloz.wire.MessageAdapter.AnonymousClass1.$SwitchMap$com$squareup$wire$WireType
            int r1 = r8.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L7a;
                case 2: goto L6a;
                case 3: goto L5a;
                case 4: goto L4a;
                case 5: goto L2f;
                case 6: goto L89;
                default: goto L2e;
            }
        L2e:
            goto L8a
        L2f:
            r6.skipGroup()     // Catch: java.lang.Exception -> La1
            int r5 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 97
            int r6 = r5 % 128
            com.zoloz.wire.MessageAdapter.PlaceComponentResult = r6
            int r5 = r5 % 2
            if (r5 == 0) goto L41
            r5 = 28
            goto L42
        L41:
            r5 = 1
        L42:
            if (r5 == r2) goto L49
            r5 = 0
            int r5 = r5.length     // Catch: java.lang.Throwable -> L47
            return
        L47:
            r5 = move-exception
            throw r5
        L49:
            return
        L4a:
            int r8 = r6.readVarint32()
            com.zoloz.wire.UnknownFieldMap r5 = r5.ensureUnknownFieldMap()
            okio.ByteString r6 = r6.readBytes(r8)
            r5.addLengthDelimited(r7, r6)
            return
        L5a:
            com.zoloz.wire.UnknownFieldMap r5 = r5.ensureUnknownFieldMap()
            long r0 = r6.readFixed64()
            java.lang.Long r6 = java.lang.Long.valueOf(r0)
            r5.addFixed64(r7, r6)
            return
        L6a:
            com.zoloz.wire.UnknownFieldMap r5 = r5.ensureUnknownFieldMap()
            int r6 = r6.readFixed32()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r5.addFixed32(r7, r6)
            return
        L7a:
            com.zoloz.wire.UnknownFieldMap r5 = r5.ensureUnknownFieldMap()
            long r0 = r6.readVarint64()
            java.lang.Long r6 = java.lang.Long.valueOf(r0)
            r5.addVarint(r7, r6)
        L89:
            return
        L8a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Unsupported wire type: "
            r5.append(r6)     // Catch: java.lang.Exception -> La1
            r5.append(r8)     // Catch: java.lang.Exception -> La1
            java.lang.RuntimeException r6 = new java.lang.RuntimeException     // Catch: java.lang.Exception -> La1
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> La1
            r6.<init>(r5)     // Catch: java.lang.Exception -> La1
            throw r6     // Catch: java.lang.Exception -> La1
        La1:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zoloz.wire.MessageAdapter.readUnknownField(com.zoloz.wire.Message, com.zoloz.wire.WireInput, int, com.zoloz.wire.WireType):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
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

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        if (r0 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
    
        r2 = r0.getExtension(r3.messageType, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        r4 = com.zoloz.wire.MessageAdapter.PlaceComponentResult + 97;
        com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if ((r4 % 2) != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        r4 = 'T';
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
    
        r4 = '\'';
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
    
        if (r4 == '\'') goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0044, code lost:
    
        r4 = 42 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
    
        if (r0 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.zoloz.wire.Extension<com.zoloz.wire.ExtendableMessage<?>, ?> getExtension(int r4) {
        /*
            r3 = this;
            int r0 = com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L4c
            int r0 = r0 + 95
            int r1 = r0 % 128
            com.zoloz.wire.MessageAdapter.PlaceComponentResult = r1     // Catch: java.lang.Exception -> L4c
            int r0 = r0 % 2
            r1 = 20
            if (r0 == 0) goto L11
            r0 = 20
            goto L13
        L11:
            r0 = 18
        L13:
            r2 = 0
            if (r0 == r1) goto L1d
            com.zoloz.wire.Wire r0 = r3.wire     // Catch: java.lang.Exception -> L4c
            com.zoloz.wire.ExtensionRegistry r0 = r0.registry     // Catch: java.lang.Exception -> L4c
            if (r0 != 0) goto L27
            goto L2d
        L1d:
            com.zoloz.wire.Wire r0 = r3.wire
            com.zoloz.wire.ExtensionRegistry r0 = r0.registry
            r2.hashCode()     // Catch: java.lang.Throwable -> L4a
            if (r0 != 0) goto L27
            goto L2d
        L27:
            java.lang.Class<M extends com.zoloz.wire.Message> r1 = r3.messageType
            com.zoloz.wire.Extension r2 = r0.getExtension(r1, r4)
        L2d:
            int r4 = com.zoloz.wire.MessageAdapter.PlaceComponentResult     // Catch: java.lang.Exception -> L4c
            int r4 = r4 + 97
            int r0 = r4 % 128
            com.zoloz.wire.MessageAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = r0     // Catch: java.lang.Exception -> L4c
            int r4 = r4 % 2
            r0 = 39
            if (r4 != 0) goto L3e
            r4 = 84
            goto L40
        L3e:
            r4 = 39
        L40:
            if (r4 == r0) goto L49
            r4 = 42
            int r4 = r4 / 0
            return r2
        L47:
            r4 = move-exception
            throw r4
        L49:
            return r2
        L4a:
            r4 = move-exception
            throw r4
        L4c:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zoloz.wire.MessageAdapter.getExtension(int):com.zoloz.wire.Extension");
    }

    final Extension<ExtendableMessage<?>, ?> getExtension(String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 119;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            try {
                ExtensionRegistry extensionRegistry = this.wire.registry;
                if (extensionRegistry == null) {
                    return null;
                }
                Extension<ExtendableMessage<?>, ?> extension = extensionRegistry.getExtension(this.messageType, str);
                int i3 = PlaceComponentResult + 87;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                return extension;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void setExtension(ExtendableMessage extendableMessage, Extension<?, ?> extension, Object obj) {
        try {
            int i = PlaceComponentResult + 111;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            boolean z = i % 2 == 0;
            extendableMessage.setExtension(extension, obj);
            if (!z) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    private Class<? extends ProtoEnum> getEnumClass(int i) {
        Class<? extends ProtoEnum> cls;
        Extension<ExtendableMessage<?>, ?> extension;
        FieldInfo fieldInfo = this.fieldInfoMap.get(i);
        if (!(fieldInfo == null)) {
            cls = fieldInfo.enumType;
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 123;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
        } else {
            cls = null;
        }
        if (cls == null && (extension = getExtension(i)) != null) {
            cls = extension.getEnumType();
        }
        try {
            int i4 = PlaceComponentResult + 103;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                if ((i4 % 2 == 0 ? (char) 1 : 'U') != 1) {
                    return cls;
                }
                int i5 = 44 / 0;
                return cls;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
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
        char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        int i2 = $11 + 111;
        $10 = i2 % 128;
        while (true) {
            int i3 = i2 % 2;
            if (d.MyBillsEntityDataFactory >= KClassImpl$Data$declaredNonStaticMembers$22.length) {
                objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
                return;
            }
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (BuiltInFictitiousFunctionClassFactory ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
            try {
                i2 = $10 + 13;
                $11 = i2 % 128;
            } catch (Exception e) {
                throw e;
            }
        }
    }
}
