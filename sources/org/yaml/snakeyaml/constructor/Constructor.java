package org.yaml.snakeyaml.constructor;

import com.google.common.base.Ascii;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.nodes.CollectionNode;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes6.dex */
public class Constructor extends SafeConstructor {
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda1 = {125, -100, 71, Ascii.FS, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int NetworkUserEntityData$$ExternalSyntheticLambda2 = 249;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 12
            int r8 = 15 - r8
            int r7 = r7 * 7
            int r7 = r7 + 99
            int r9 = r9 * 3
            int r9 = 16 - r9
            byte[] r0 = org.yaml.snakeyaml.constructor.Constructor.NetworkUserEntityData$$ExternalSyntheticLambda1
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L34
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r9) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            int r8 = r8 + 1
            r3 = r0[r8]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L34:
            int r9 = r9 + r7
            int r7 = r9 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.constructor.Constructor.a(short, short, byte, java.lang.Object[]):void");
    }

    public Constructor(LoaderOptions loaderOptions) {
        this(Object.class, loaderOptions);
    }

    private Constructor(Class<? extends Object> cls, LoaderOptions loaderOptions) {
        this(new TypeDescription(cls), loaderOptions);
    }

    private Constructor(TypeDescription typeDescription, LoaderOptions loaderOptions) {
        super(loaderOptions);
        this.initRecordTimeStamp.put(null, new ConstructYamlObject());
        if (!Object.class.equals(typeDescription.scheduleImpl)) {
            this.lookAheadTest = new Tag(typeDescription.scheduleImpl);
        }
        this.DatabaseTableConfigUtil.put(NodeId.scalar, new ConstructScalar());
        this.DatabaseTableConfigUtil.put(NodeId.mapping, new ConstructMapping());
        this.DatabaseTableConfigUtil.put(NodeId.sequence, new ConstructSequence());
        getAuthRequestContext(typeDescription);
    }

    /* loaded from: classes6.dex */
    public class ConstructMapping implements Construct {
        public ConstructMapping() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object getAuthRequestContext(Node node) {
            MappingNode mappingNode = (MappingNode) node;
            if (Map.class.isAssignableFrom(node.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                if (node.MyBillsEntityDataFactory()) {
                    return Constructor.this.BuiltInFictitiousFunctionClassFactory(mappingNode);
                }
                return Constructor.this.getAuthRequestContext(mappingNode);
            } else if (Collection.class.isAssignableFrom(node.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                if (node.MyBillsEntityDataFactory()) {
                    return Constructor.this.BuiltInFictitiousFunctionClassFactory((CollectionNode<?>) mappingNode);
                }
                return Constructor.this.PlaceComponentResult(mappingNode);
            } else {
                Object PlaceComponentResult = Constructor.this.PlaceComponentResult((Node) mappingNode);
                if (PlaceComponentResult != BaseConstructor.KClassImpl$Data$declaredNonStaticMembers$2) {
                    return node.MyBillsEntityDataFactory() ? PlaceComponentResult : PlaceComponentResult(mappingNode, PlaceComponentResult);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Can't create an instance for ");
                sb.append(mappingNode.NetworkUserEntityData$$ExternalSyntheticLambda2);
                throw new ConstructorException(null, null, sb.toString(), node.initRecordTimeStamp);
            }
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public void getAuthRequestContext(Node node, Object obj) {
            if (Map.class.isAssignableFrom(node.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                Constructor.this.PlaceComponentResult((MappingNode) node, (Map) obj);
            } else if (Set.class.isAssignableFrom(node.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                Constructor.this.BuiltInFictitiousFunctionClassFactory((MappingNode) node, (Set) obj);
            } else {
                PlaceComponentResult((MappingNode) node, obj);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0123 A[Catch: Exception -> 0x0197, DuplicateKeyException -> 0x01c1, TryCatch #2 {DuplicateKeyException -> 0x01c1, Exception -> 0x0197, blocks: (B:6:0x002e, B:8:0x003a, B:10:0x0040, B:11:0x0047, B:13:0x0054, B:15:0x005a, B:17:0x0066, B:18:0x0068, B:20:0x0070, B:22:0x0076, B:24:0x0079, B:26:0x0082, B:27:0x008d, B:29:0x0093, B:31:0x00a1, B:32:0x00a4, B:34:0x00ae, B:35:0x00bb, B:37:0x00c1, B:39:0x00d3, B:40:0x00d5, B:42:0x00df, B:44:0x00e5, B:56:0x0123, B:58:0x0130, B:60:0x0138, B:65:0x014e, B:67:0x0156, B:71:0x0164, B:72:0x016c, B:64:0x0144, B:57:0x012a, B:45:0x00eb, B:47:0x00f7, B:48:0x0102, B:50:0x0108, B:52:0x0118, B:53:0x011b, B:73:0x0174, B:74:0x0196, B:12:0x0050), top: B:81:0x002e }] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x012a A[Catch: Exception -> 0x0197, DuplicateKeyException -> 0x01c1, TryCatch #2 {DuplicateKeyException -> 0x01c1, Exception -> 0x0197, blocks: (B:6:0x002e, B:8:0x003a, B:10:0x0040, B:11:0x0047, B:13:0x0054, B:15:0x005a, B:17:0x0066, B:18:0x0068, B:20:0x0070, B:22:0x0076, B:24:0x0079, B:26:0x0082, B:27:0x008d, B:29:0x0093, B:31:0x00a1, B:32:0x00a4, B:34:0x00ae, B:35:0x00bb, B:37:0x00c1, B:39:0x00d3, B:40:0x00d5, B:42:0x00df, B:44:0x00e5, B:56:0x0123, B:58:0x0130, B:60:0x0138, B:65:0x014e, B:67:0x0156, B:71:0x0164, B:72:0x016c, B:64:0x0144, B:57:0x012a, B:45:0x00eb, B:47:0x00f7, B:48:0x0102, B:50:0x0108, B:52:0x0118, B:53:0x011b, B:73:0x0174, B:74:0x0196, B:12:0x0050), top: B:81:0x002e }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object PlaceComponentResult(org.yaml.snakeyaml.nodes.MappingNode r18, java.lang.Object r19) {
            /*
                Method dump skipped, instructions count: 452
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.constructor.Constructor.ConstructMapping.PlaceComponentResult(org.yaml.snakeyaml.nodes.MappingNode, java.lang.Object):java.lang.Object");
        }
    }

    /* loaded from: classes6.dex */
    protected class ConstructYamlObject implements Construct {
        protected ConstructYamlObject() {
        }

        private Construct KClassImpl$Data$declaredNonStaticMembers$2(Node node) {
            Class authRequestContext = Constructor.this.getAuthRequestContext(node);
            if (!authRequestContext.isAssignableFrom(node.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                node.NetworkUserEntityData$$ExternalSyntheticLambda1 = authRequestContext;
            }
            return Constructor.this.DatabaseTableConfigUtil.get(node.KClassImpl$Data$declaredNonStaticMembers$2());
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public final Object getAuthRequestContext(Node node) {
            try {
                return KClassImpl$Data$declaredNonStaticMembers$2(node).getAuthRequestContext(node);
            } catch (ConstructorException e) {
                throw e;
            } catch (Exception e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Can't construct a java object for ");
                sb.append(node.NetworkUserEntityData$$ExternalSyntheticLambda2);
                sb.append("; exception=");
                sb.append(e2.getMessage());
                throw new ConstructorException(null, null, sb.toString(), node.initRecordTimeStamp, e2);
            }
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public final void getAuthRequestContext(Node node, Object obj) {
            try {
                KClassImpl$Data$declaredNonStaticMembers$2(node).getAuthRequestContext(node, obj);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Can't construct a second step for a java object for ");
                sb.append(node.NetworkUserEntityData$$ExternalSyntheticLambda2);
                sb.append("; exception=");
                sb.append(e.getMessage());
                throw new ConstructorException(null, null, sb.toString(), node.initRecordTimeStamp, e);
            }
        }
    }

    /* loaded from: classes6.dex */
    protected class ConstructScalar extends AbstractConstruct {
        protected ConstructScalar() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public final Object getAuthRequestContext(Node node) {
            Object obj;
            ScalarNode scalarNode = (ScalarNode) node;
            Class<? extends Object> cls = scalarNode.NetworkUserEntityData$$ExternalSyntheticLambda1;
            Object MyBillsEntityDataFactory = Constructor.this.MyBillsEntityDataFactory((Class<?>) cls, (Node) scalarNode, false);
            if (MyBillsEntityDataFactory != BaseConstructor.KClassImpl$Data$declaredNonStaticMembers$2) {
                return MyBillsEntityDataFactory;
            }
            if (cls.isPrimitive() || cls == String.class || Number.class.isAssignableFrom(cls) || cls == Boolean.class || Date.class.isAssignableFrom(cls) || cls == Character.class || cls == BigInteger.class || cls == BigDecimal.class || Enum.class.isAssignableFrom(cls) || Tag.MyBillsEntityDataFactory.equals(scalarNode.NetworkUserEntityData$$ExternalSyntheticLambda2) || Calendar.class.isAssignableFrom(cls) || cls == UUID.class) {
                return MyBillsEntityDataFactory(cls, scalarNode);
            }
            java.lang.reflect.Constructor<? extends Object> constructor = null;
            int i = 0;
            for (java.lang.reflect.Constructor<?> constructor2 : cls.getDeclaredConstructors()) {
                if (constructor2.getParameterTypes().length == 1) {
                    i++;
                    constructor = constructor2;
                }
            }
            if (constructor == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("No single argument constructor found for ");
                sb.append(cls);
                throw new YAMLException(sb.toString());
            }
            if (i == 1) {
                obj = MyBillsEntityDataFactory(constructor.getParameterTypes()[0], scalarNode);
            } else {
                String authRequestContext = Constructor.getAuthRequestContext(scalarNode);
                try {
                    constructor = cls.getDeclaredConstructor(String.class);
                    obj = authRequestContext;
                } catch (Exception e) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Can't construct a java object for scalar ");
                    sb2.append(scalarNode.NetworkUserEntityData$$ExternalSyntheticLambda2);
                    sb2.append("; No String constructor found. Exception=");
                    sb2.append(e.getMessage());
                    throw new YAMLException(sb2.toString(), e);
                }
            }
            try {
                constructor.setAccessible(true);
                return constructor.newInstance(obj);
            } catch (Exception e2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Can't construct a java object for scalar ");
                sb3.append(scalarNode.NetworkUserEntityData$$ExternalSyntheticLambda2);
                sb3.append("; exception=");
                sb3.append(e2.getMessage());
                throw new ConstructorException(null, null, sb3.toString(), scalarNode.initRecordTimeStamp, e2);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:103:0x0202, code lost:
        
            if (r6 == java.lang.Float.TYPE) goto L104;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v49, types: [java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r6v51, types: [java.lang.Enum] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.Object MyBillsEntityDataFactory(java.lang.Class r6, org.yaml.snakeyaml.nodes.ScalarNode r7) {
            /*
                Method dump skipped, instructions count: 620
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.constructor.Constructor.ConstructScalar.MyBillsEntityDataFactory(java.lang.Class, org.yaml.snakeyaml.nodes.ScalarNode):java.lang.Object");
        }
    }

    /* loaded from: classes6.dex */
    protected class ConstructSequence implements Construct {
        protected ConstructSequence() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.yaml.snakeyaml.constructor.Construct
        public final Object getAuthRequestContext(Node node) {
            boolean z;
            SequenceNode sequenceNode = (SequenceNode) node;
            if (Set.class.isAssignableFrom(node.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                if (node.MyBillsEntityDataFactory()) {
                    throw new YAMLException("Set cannot be recursive.");
                }
                return Constructor.this.MyBillsEntityDataFactory(sequenceNode);
            } else if (Collection.class.isAssignableFrom(node.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                if (node.MyBillsEntityDataFactory()) {
                    return Constructor.this.PlaceComponentResult(sequenceNode);
                }
                return Constructor.this.getAuthRequestContext(sequenceNode);
            } else if (node.NetworkUserEntityData$$ExternalSyntheticLambda1.isArray()) {
                if (node.MyBillsEntityDataFactory()) {
                    return Constructor.MyBillsEntityDataFactory(node.NetworkUserEntityData$$ExternalSyntheticLambda1, sequenceNode.KClassImpl$Data$declaredNonStaticMembers$2.size());
                }
                return Constructor.this.KClassImpl$Data$declaredNonStaticMembers$2(sequenceNode);
            } else {
                ArrayList<java.lang.reflect.Constructor> arrayList = new ArrayList(sequenceNode.KClassImpl$Data$declaredNonStaticMembers$2.size());
                int i = 0;
                for (java.lang.reflect.Constructor<?> constructor : node.NetworkUserEntityData$$ExternalSyntheticLambda1.getDeclaredConstructors()) {
                    if (sequenceNode.KClassImpl$Data$declaredNonStaticMembers$2.size() == constructor.getParameterTypes().length) {
                        arrayList.add(constructor);
                    }
                }
                if (!arrayList.isEmpty()) {
                    if (arrayList.size() == 1) {
                        Object[] objArr = new Object[sequenceNode.KClassImpl$Data$declaredNonStaticMembers$2.size()];
                        java.lang.reflect.Constructor constructor2 = (java.lang.reflect.Constructor) arrayList.get(0);
                        for (Node node2 : sequenceNode.KClassImpl$Data$declaredNonStaticMembers$2) {
                            Class<? extends Object> cls = constructor2.getParameterTypes()[i];
                            if (!cls.isAssignableFrom(node2.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                                node2.NetworkUserEntityData$$ExternalSyntheticLambda1 = cls;
                            }
                            objArr[i] = Constructor.this.BuiltInFictitiousFunctionClassFactory(node2);
                            i++;
                        }
                        try {
                            constructor2.setAccessible(true);
                            return constructor2.newInstance(objArr);
                        } catch (Exception e) {
                            throw new YAMLException(e);
                        }
                    }
                    List<? extends Object> authRequestContext = Constructor.this.getAuthRequestContext(sequenceNode);
                    Class<?>[] clsArr = new Class[authRequestContext.size()];
                    Iterator<? extends Object> it = authRequestContext.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        clsArr[i2] = it.next().getClass();
                        i2++;
                    }
                    for (java.lang.reflect.Constructor constructor3 : arrayList) {
                        Class<?>[] parameterTypes = constructor3.getParameterTypes();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= parameterTypes.length) {
                                z = true;
                                break;
                            }
                            Class<?> cls2 = parameterTypes[i3];
                            if (cls2.isPrimitive()) {
                                if (cls2 == Integer.TYPE) {
                                    cls2 = Integer.class;
                                } else if (cls2 == Float.TYPE) {
                                    cls2 = Float.class;
                                } else if (cls2 == Double.TYPE) {
                                    cls2 = Double.class;
                                } else if (cls2 == Boolean.TYPE) {
                                    cls2 = Boolean.class;
                                } else if (cls2 == Long.TYPE) {
                                    cls2 = Long.class;
                                } else if (cls2 == Character.TYPE) {
                                    cls2 = Character.class;
                                } else if (cls2 == Short.TYPE) {
                                    cls2 = Short.class;
                                } else if (cls2 == Byte.TYPE) {
                                    cls2 = Byte.class;
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("Unexpected primitive ");
                                    sb.append(cls2);
                                    throw new YAMLException(sb.toString());
                                }
                            }
                            if (!cls2.isAssignableFrom(clsArr[i3])) {
                                z = false;
                                break;
                            }
                            i3++;
                        }
                        if (z) {
                            try {
                                constructor3.setAccessible(true);
                                return constructor3.newInstance(authRequestContext.toArray());
                            } catch (Exception e2) {
                                throw new YAMLException(e2);
                            }
                        }
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("No suitable constructor with ");
                sb2.append(sequenceNode.KClassImpl$Data$declaredNonStaticMembers$2.size());
                sb2.append(" arguments found for ");
                sb2.append(node.NetworkUserEntityData$$ExternalSyntheticLambda1);
                throw new YAMLException(sb2.toString());
            }
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public final void getAuthRequestContext(Node node, Object obj) {
            SequenceNode sequenceNode = (SequenceNode) node;
            if (List.class.isAssignableFrom(node.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                Constructor.this.PlaceComponentResult(sequenceNode, (Collection<Object>) ((List) obj));
            } else if (node.NetworkUserEntityData$$ExternalSyntheticLambda1.isArray()) {
                Constructor.this.getAuthRequestContext(sequenceNode, obj);
            } else {
                throw new YAMLException("Immutable objects cannot be recursive.");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final Class<?> getAuthRequestContext(Node node) {
        Class<? extends Object> cls = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(node.NetworkUserEntityData$$ExternalSyntheticLambda2);
        if (cls == null) {
            String MyBillsEntityDataFactory = node.NetworkUserEntityData$$ExternalSyntheticLambda2.MyBillsEntityDataFactory();
            try {
                Class<?> MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(MyBillsEntityDataFactory);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.put(node.NetworkUserEntityData$$ExternalSyntheticLambda2, MyBillsEntityDataFactory2);
                return MyBillsEntityDataFactory2;
            } catch (ClassNotFoundException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("Class not found: ");
                sb.append(MyBillsEntityDataFactory);
                throw new YAMLException(sb.toString());
            }
        }
        return cls;
    }

    public Class<?> MyBillsEntityDataFactory(String str) throws ClassNotFoundException {
        try {
            try {
                byte b = NetworkUserEntityData$$ExternalSyntheticLambda1[15];
                byte b2 = (byte) (b - 1);
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda1[15] - 1);
                byte b4 = NetworkUserEntityData$$ExternalSyntheticLambda1[15];
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                return Class.forName(str, true, ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getContextClassLoader());
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (ClassNotFoundException unused) {
            return Class.forName(str);
        }
    }
}
