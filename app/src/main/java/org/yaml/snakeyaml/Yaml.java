package org.yaml.snakeyaml;

import com.google.common.base.Ascii;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.yaml.snakeyaml.composer.Composer;
import org.yaml.snakeyaml.constructor.BaseConstructor;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.emitter.Emitable;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.parser.Parser;
import org.yaml.snakeyaml.parser.ParserImpl;
import org.yaml.snakeyaml.reader.StreamReader;
import org.yaml.snakeyaml.representer.Representer;
import org.yaml.snakeyaml.resolver.Resolver;

/* loaded from: classes6.dex */
public class Yaml {
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {8, 17, -121, -18, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int getErrorConfigVersion = 137;
    protected DumperOptions BuiltInFictitiousFunctionClassFactory;
    protected Representer KClassImpl$Data$declaredNonStaticMembers$2;
    protected BaseConstructor MyBillsEntityDataFactory;
    protected final Resolver PlaceComponentResult;
    protected LoaderOptions getAuthRequestContext;
    private String moveToNextValue;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0029 -> B:23:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 4
            int r8 = 16 - r8
            byte[] r0 = org.yaml.snakeyaml.Yaml.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r7 = r7 + 105
            int r6 = r6 * 15
            int r6 = r6 + 4
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r3 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L32:
            int r8 = r8 + r7
            int r7 = r8 + 2
            int r6 = r6 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.Yaml.a(short, int, int, java.lang.Object[]):void");
    }

    public Yaml() {
        this(new Constructor(new LoaderOptions()), new Representer(new DumperOptions()));
    }

    private Yaml(BaseConstructor baseConstructor, Representer representer, DumperOptions dumperOptions) {
        this(baseConstructor, representer, dumperOptions, baseConstructor.getAuthRequestContext(), new Resolver());
    }

    private Yaml(BaseConstructor baseConstructor, Representer representer, DumperOptions dumperOptions, LoaderOptions loaderOptions, Resolver resolver) {
        if (baseConstructor == null) {
            throw new NullPointerException("Constructor must be provided");
        }
        if (representer == null) {
            throw new NullPointerException("Representer must be provided");
        }
        if (dumperOptions == null) {
            throw new NullPointerException("DumperOptions must be provided");
        }
        if (loaderOptions == null) {
            throw new NullPointerException("LoaderOptions must be provided");
        }
        if (baseConstructor.MyBillsEntityDataFactory()) {
            if (!representer.getAuthRequestContext()) {
                if (baseConstructor.moveToNextValue == null) {
                    baseConstructor.moveToNextValue = new PropertyUtils();
                }
                representer.BuiltInFictitiousFunctionClassFactory(baseConstructor.moveToNextValue);
            }
        } else {
            if (representer.PlaceComponentResult == null) {
                representer.PlaceComponentResult = new PropertyUtils();
            }
            baseConstructor.BuiltInFictitiousFunctionClassFactory(representer.PlaceComponentResult);
        }
        this.MyBillsEntityDataFactory = baseConstructor;
        baseConstructor.MyBillsEntityDataFactory = loaderOptions.KClassImpl$Data$declaredNonStaticMembers$2();
        this.MyBillsEntityDataFactory.getErrorConfigVersion = loaderOptions.BuiltInFictitiousFunctionClassFactory();
        if (!dumperOptions.getAuthRequestContext() && dumperOptions.getAuthRequestContext <= dumperOptions.MyBillsEntityDataFactory) {
            throw new YAMLException("Indicator indent must be smaller then indent.");
        }
        representer.MyBillsEntityDataFactory(dumperOptions.PlaceComponentResult);
        representer.PlaceComponentResult(dumperOptions.BuiltInFictitiousFunctionClassFactory);
        if (representer.PlaceComponentResult == null) {
            representer.PlaceComponentResult = new PropertyUtils();
        }
        PropertyUtils propertyUtils = representer.PlaceComponentResult;
        boolean KClassImpl$Data$declaredNonStaticMembers$2 = dumperOptions.KClassImpl$Data$declaredNonStaticMembers$2();
        if (propertyUtils.PlaceComponentResult != KClassImpl$Data$declaredNonStaticMembers$2) {
            propertyUtils.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2;
            propertyUtils.MyBillsEntityDataFactory.clear();
        }
        representer.PlaceComponentResult(dumperOptions.moveToNextValue);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = representer;
        this.BuiltInFictitiousFunctionClassFactory = dumperOptions;
        this.getAuthRequestContext = loaderOptions;
        this.PlaceComponentResult = resolver;
        StringBuilder sb = new StringBuilder();
        sb.append("Yaml:");
        try {
            Object[] objArr = {this};
            byte b = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[5]);
            byte b2 = b;
            Object[] objArr2 = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b3 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[5] + 1);
            byte b4 = b3;
            Object[] objArr3 = new Object[1];
            a(b3, b4, b4, objArr3);
            sb.append(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue());
            this.moveToNextValue = sb.toString();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* loaded from: classes9.dex */
    static class SilentEmitter implements Emitable {
        private final List<Event> BuiltInFictitiousFunctionClassFactory = new ArrayList(100);

        private SilentEmitter() {
        }
    }

    public final Object getAuthRequestContext(StreamReader streamReader, Class<?> cls) {
        this.MyBillsEntityDataFactory.getAuthRequestContext(new Composer(new ParserImpl(streamReader, this.getAuthRequestContext), this.PlaceComponentResult, this.getAuthRequestContext));
        return this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(cls);
    }

    /* renamed from: org.yaml.snakeyaml.Yaml$1 */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements Iterator<Object>, j$.util.Iterator {
        final /* synthetic */ Yaml KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super Object> consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.PlaceComponentResult();
        }

        @Override // java.util.Iterator
        public Object next() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes9.dex */
    static class YamlIterable implements Iterable<Object> {
        private final java.util.Iterator<Object> MyBillsEntityDataFactory;

        @Override // java.lang.Iterable
        public java.util.Iterator<Object> iterator() {
            return this.MyBillsEntityDataFactory;
        }
    }

    /* renamed from: org.yaml.snakeyaml.Yaml$2 */
    /* loaded from: classes6.dex */
    class AnonymousClass2 implements java.util.Iterator<Node>, j$.util.Iterator {
        final /* synthetic */ Composer BuiltInFictitiousFunctionClassFactory;

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super Node> consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public /* synthetic */ Node next() {
            Node authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
            if (authRequestContext != null) {
                return authRequestContext;
            }
            throw new NoSuchElementException("No Node is available.");
        }
    }

    /* loaded from: classes9.dex */
    static class NodeIterable implements Iterable<Node> {
        private final java.util.Iterator<Node> KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // java.lang.Iterable
        public java.util.Iterator<Node> iterator() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    public String toString() {
        return this.moveToNextValue;
    }

    /* renamed from: org.yaml.snakeyaml.Yaml$3 */
    /* loaded from: classes6.dex */
    class AnonymousClass3 implements java.util.Iterator<Event>, j$.util.Iterator {
        final /* synthetic */ Parser BuiltInFictitiousFunctionClassFactory;

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super Event> consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult() != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public /* synthetic */ Event next() {
            Event KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
            if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                return KClassImpl$Data$declaredNonStaticMembers$2;
            }
            throw new NoSuchElementException("No Event is available.");
        }
    }

    /* loaded from: classes9.dex */
    static class EventIterable implements Iterable<Event> {
        private final java.util.Iterator<Event> PlaceComponentResult;

        @Override // java.lang.Iterable
        public java.util.Iterator<Event> iterator() {
            return this.PlaceComponentResult;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private Yaml(org.yaml.snakeyaml.constructor.BaseConstructor r3, org.yaml.snakeyaml.representer.Representer r4) {
        /*
            r2 = this;
            org.yaml.snakeyaml.DumperOptions r0 = new org.yaml.snakeyaml.DumperOptions
            r0.<init>()
            org.yaml.snakeyaml.DumperOptions$FlowStyle r1 = r4.KClassImpl$Data$declaredNonStaticMembers$2()
            if (r1 == 0) goto L3a
            r0.PlaceComponentResult = r1
            org.yaml.snakeyaml.DumperOptions$ScalarStyle r1 = r4.BuiltInFictitiousFunctionClassFactory()
            if (r1 == 0) goto L32
            r0.BuiltInFictitiousFunctionClassFactory = r1
            org.yaml.snakeyaml.introspector.PropertyUtils r1 = r4.PlaceComponentResult
            if (r1 != 0) goto L20
            org.yaml.snakeyaml.introspector.PropertyUtils r1 = new org.yaml.snakeyaml.introspector.PropertyUtils
            r1.<init>()
            r4.PlaceComponentResult = r1
        L20:
            org.yaml.snakeyaml.introspector.PropertyUtils r1 = r4.PlaceComponentResult
            boolean r1 = r1.KClassImpl$Data$declaredNonStaticMembers$2()
            r0.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            java.util.TimeZone r1 = r4.MyBillsEntityDataFactory()
            r0.moveToNextValue = r1
            r2.<init>(r3, r4, r0)
            return
        L32:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "Use ScalarStyle enum."
            r3.<init>(r4)
            throw r3
        L3a:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "Use FlowStyle enum."
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.Yaml.<init>(org.yaml.snakeyaml.constructor.BaseConstructor, org.yaml.snakeyaml.representer.Representer):void");
    }
}
