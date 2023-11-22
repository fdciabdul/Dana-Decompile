package j$.util.stream;

import j$.util.Map;
import j$.util.Spliterator;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'DISTINCT' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class StreamOpFlag {
    private static final /* synthetic */ StreamOpFlag[] $VALUES;
    public static final StreamOpFlag DISTINCT;
    private static final int FLAG_MASK;
    private static final int FLAG_MASK_IS;
    private static final int FLAG_MASK_NOT;
    static final int INITIAL_OPS_VALUE;
    static final int IS_DISTINCT;
    static final int IS_ORDERED;
    static final int IS_SHORT_CIRCUIT;
    static final int IS_SIZED;
    static final int IS_SORTED;
    static final int NOT_DISTINCT;
    static final int NOT_ORDERED;
    static final int NOT_SIZED;
    static final int NOT_SORTED;
    static final int OP_MASK;
    public static final StreamOpFlag ORDERED;
    public static final StreamOpFlag SHORT_CIRCUIT;
    public static final StreamOpFlag SIZED;
    public static final StreamOpFlag SORTED;
    static final int SPLITERATOR_CHARACTERISTICS_MASK;
    static final int STREAM_MASK;
    private final int bitPosition;
    private final int clear;
    private final Map maskTable;
    private final int preserve;
    private final int set;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class MaskBuilder {
        final Map getAuthRequestContext;

        MaskBuilder(EnumMap enumMap) {
            this.getAuthRequestContext = enumMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum Type {
        SPLITERATOR,
        STREAM,
        OP,
        TERMINAL_OP,
        UPSTREAM_TERMINAL_OP
    }

    private StreamOpFlag(String str, int i, int i2, MaskBuilder maskBuilder) {
        for (Type type : Type.values()) {
            Map.EL.PlaceComponentResult(maskBuilder.getAuthRequestContext, type, 0);
        }
        this.maskTable = maskBuilder.getAuthRequestContext;
        int i3 = i2 * 2;
        this.bitPosition = i3;
        this.set = 1 << i3;
        this.clear = 2 << i3;
        this.preserve = 3 << i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int combineOpFlags(int i, int i2) {
        return i | (i2 & (i == 0 ? FLAG_MASK : ((((FLAG_MASK_IS & i) << 1) | i) | ((FLAG_MASK_NOT & i) >> 1)) ^ (-1)));
    }

    private static int createMask(Type type) {
        int i = 0;
        for (StreamOpFlag streamOpFlag : values()) {
            i |= ((Integer) streamOpFlag.maskTable.get(type)).intValue() << streamOpFlag.bitPosition;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int fromCharacteristics(Spliterator spliterator) {
        int BuiltInFictitiousFunctionClassFactory = spliterator.BuiltInFictitiousFunctionClassFactory();
        return ((BuiltInFictitiousFunctionClassFactory & 4) == 0 || spliterator.getAuthRequestContext() == null) ? SPLITERATOR_CHARACTERISTICS_MASK & BuiltInFictitiousFunctionClassFactory : SPLITERATOR_CHARACTERISTICS_MASK & BuiltInFictitiousFunctionClassFactory & (-5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int toStreamFlags(int i) {
        return i & ((i ^ (-1)) >> 1) & FLAG_MASK_IS;
    }

    public static StreamOpFlag valueOf(String str) {
        return (StreamOpFlag) Enum.valueOf(StreamOpFlag.class, str);
    }

    public static StreamOpFlag[] values() {
        return (StreamOpFlag[]) $VALUES.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isKnown(int i) {
        return (i & this.preserve) == this.set;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isPreserved(int i) {
        int i2 = this.preserve;
        return (i & i2) == i2;
    }

    static {
        Type type = Type.SPLITERATOR;
        MaskBuilder maskBuilder = set(type);
        Type type2 = Type.STREAM;
        maskBuilder.getAuthRequestContext.put(type2, 1);
        Type type3 = Type.OP;
        maskBuilder.getAuthRequestContext.put(type3, 3);
        StreamOpFlag streamOpFlag = new StreamOpFlag("DISTINCT", 0, 0, maskBuilder);
        DISTINCT = streamOpFlag;
        MaskBuilder maskBuilder2 = set(type);
        maskBuilder2.getAuthRequestContext.put(type2, 1);
        maskBuilder2.getAuthRequestContext.put(type3, 3);
        StreamOpFlag streamOpFlag2 = new StreamOpFlag("SORTED", 1, 1, maskBuilder2);
        SORTED = streamOpFlag2;
        MaskBuilder maskBuilder3 = set(type);
        maskBuilder3.getAuthRequestContext.put(type2, 1);
        maskBuilder3.getAuthRequestContext.put(type3, 3);
        Type type4 = Type.TERMINAL_OP;
        maskBuilder3.getAuthRequestContext.put(type4, 2);
        Type type5 = Type.UPSTREAM_TERMINAL_OP;
        maskBuilder3.getAuthRequestContext.put(type5, 2);
        StreamOpFlag streamOpFlag3 = new StreamOpFlag("ORDERED", 2, 2, maskBuilder3);
        ORDERED = streamOpFlag3;
        MaskBuilder maskBuilder4 = set(type);
        maskBuilder4.getAuthRequestContext.put(type2, 1);
        maskBuilder4.getAuthRequestContext.put(type3, 2);
        StreamOpFlag streamOpFlag4 = new StreamOpFlag("SIZED", 3, 3, maskBuilder4);
        SIZED = streamOpFlag4;
        MaskBuilder maskBuilder5 = set(type3);
        maskBuilder5.getAuthRequestContext.put(type4, 1);
        StreamOpFlag streamOpFlag5 = new StreamOpFlag("SHORT_CIRCUIT", 4, 12, maskBuilder5);
        SHORT_CIRCUIT = streamOpFlag5;
        $VALUES = new StreamOpFlag[]{streamOpFlag, streamOpFlag2, streamOpFlag3, streamOpFlag4, streamOpFlag5};
        SPLITERATOR_CHARACTERISTICS_MASK = createMask(type);
        STREAM_MASK = createMask(type2);
        OP_MASK = createMask(type3);
        createMask(type4);
        createMask(type5);
        int i = 0;
        for (StreamOpFlag streamOpFlag6 : values()) {
            i |= streamOpFlag6.preserve;
        }
        FLAG_MASK = i;
        int i2 = STREAM_MASK;
        FLAG_MASK_IS = i2;
        int i3 = i2 << 1;
        FLAG_MASK_NOT = i3;
        INITIAL_OPS_VALUE = i2 | i3;
        StreamOpFlag streamOpFlag7 = DISTINCT;
        IS_DISTINCT = streamOpFlag7.set;
        NOT_DISTINCT = streamOpFlag7.clear;
        StreamOpFlag streamOpFlag8 = SORTED;
        IS_SORTED = streamOpFlag8.set;
        NOT_SORTED = streamOpFlag8.clear;
        StreamOpFlag streamOpFlag9 = ORDERED;
        IS_ORDERED = streamOpFlag9.set;
        NOT_ORDERED = streamOpFlag9.clear;
        StreamOpFlag streamOpFlag10 = SIZED;
        IS_SIZED = streamOpFlag10.set;
        NOT_SIZED = streamOpFlag10.clear;
        IS_SHORT_CIRCUIT = SHORT_CIRCUIT.set;
    }

    private static MaskBuilder set(Type type) {
        MaskBuilder maskBuilder = new MaskBuilder(new EnumMap(Type.class));
        maskBuilder.getAuthRequestContext.put(type, 1);
        return maskBuilder;
    }
}
