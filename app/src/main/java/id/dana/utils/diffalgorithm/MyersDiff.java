package id.dana.utils.diffalgorithm;

import com.google.common.net.HttpHeaders;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u000e\u000f\u0010\u0011B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJG\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022&\u0010\b\u001a\"\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\u0006\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/utils/diffalgorithm/MyersDiff;", "", "", "p0", "p1", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "", "p2", "Lid/dana/utils/diffalgorithm/MyersDiff$DiffResult;", "BuiltInFictitiousFunctionClassFactory", "(IILkotlin/jvm/functions/Function2;)Lid/dana/utils/diffalgorithm/MyersDiff$DiffResult;", "<init>", "()V", "Change", "DiffResult", HttpHeaders.RANGE, "Snake"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyersDiff {
    public static final MyersDiff INSTANCE = new MyersDiff();

    private MyersDiff() {
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0013\u0010\u0014J(\u0010\u0007\u001a\u00020\u00052\u0019\u0010\u0006\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\u0004\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/utils/diffalgorithm/MyersDiff$DiffResult;", "", "Lkotlin/Function1;", "Lid/dana/utils/diffalgorithm/MyersDiff$Change;", "Lkotlin/ParameterName;", "", "p0", "PlaceComponentResult", "(Lkotlin/jvm/functions/Function1;)V", "", "MyBillsEntityDataFactory", "I", "BuiltInFictitiousFunctionClassFactory", "", "Lid/dana/utils/diffalgorithm/MyersDiff$Snake;", "getAuthRequestContext", "Ljava/util/List;", "p1", "p2", "<init>", "(IILjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DiffResult {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final int MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private final int BuiltInFictitiousFunctionClassFactory;
        private final List<Snake> getAuthRequestContext;

        public DiffResult(int i, int i2, List<Snake> list) {
            Intrinsics.checkNotNullParameter(list, "");
            this.MyBillsEntityDataFactory = i;
            this.BuiltInFictitiousFunctionClassFactory = i2;
            this.getAuthRequestContext = list;
        }

        public final void PlaceComponentResult(Function1<? super Change, Unit> p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            MyersDiff myersDiff = MyersDiff.INSTANCE;
            List<Snake> list = this.getAuthRequestContext;
            int i = this.MyBillsEntityDataFactory;
            int i2 = this.BuiltInFictitiousFunctionClassFactory;
            for (Snake snake : CollectionsKt.asReversed(list)) {
                int i3 = snake.getAuthRequestContext;
                int i4 = snake.KClassImpl$Data$declaredNonStaticMembers$2 + i3;
                int i5 = snake.PlaceComponentResult + i3;
                if (i4 < i) {
                    p0.invoke(new Change.Remove(i4, i - i4));
                }
                if (i5 < i2) {
                    p0.invoke(new Change.Insert(i4, i5, i2 - i5));
                }
                i = snake.KClassImpl$Data$declaredNonStaticMembers$2;
                i2 = snake.PlaceComponentResult;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007"}, d2 = {"Lid/dana/utils/diffalgorithm/MyersDiff$Change;", "", "<init>", "()V", "Insert", "Remove", "Lid/dana/utils/diffalgorithm/MyersDiff$Change$Insert;", "Lid/dana/utils/diffalgorithm/MyersDiff$Change$Remove;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static abstract class Change {
        public /* synthetic */ Change(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004"}, d2 = {"Lid/dana/utils/diffalgorithm/MyersDiff$Change$Insert;", "Lid/dana/utils/diffalgorithm/MyersDiff$Change;", "", "getAuthRequestContext", "I", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "p2", "<init>", "(III)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Insert extends Change {
            public final int BuiltInFictitiousFunctionClassFactory;
            public final int KClassImpl$Data$declaredNonStaticMembers$2;

            /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
            public final int MyBillsEntityDataFactory;

            public Insert(int i, int i2, int i3) {
                super(null);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
                this.BuiltInFictitiousFunctionClassFactory = i2;
                this.MyBillsEntityDataFactory = i3;
            }
        }

        private Change() {
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/utils/diffalgorithm/MyersDiff$Change$Remove;", "Lid/dana/utils/diffalgorithm/MyersDiff$Change;", "", "getAuthRequestContext", "I", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Remove extends Change {

            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
            public final int MyBillsEntityDataFactory;

            /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
            public final int BuiltInFictitiousFunctionClassFactory;

            public Remove(int i, int i2) {
                super(null);
                this.MyBillsEntityDataFactory = i;
                this.BuiltInFictitiousFunctionClassFactory = i2;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0005\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\u0006\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\t\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\u0006\u0010\nR\u0012\u0010\u0003\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u0004"}, d2 = {"Lid/dana/utils/diffalgorithm/MyersDiff$Snake;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "PlaceComponentResult", "getAuthRequestContext", "", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "MyBillsEntityDataFactory", "p0", "p1", "p2", "p3", "p4", "<init>", "(IIIZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Snake {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        int KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        int PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private final boolean BuiltInFictitiousFunctionClassFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final int getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final boolean MyBillsEntityDataFactory;

        public Snake(int i, int i2, int i3, boolean z, boolean z2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.PlaceComponentResult = i2;
            this.getAuthRequestContext = i3;
            this.MyBillsEntityDataFactory = z;
            this.BuiltInFictitiousFunctionClassFactory = z2;
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final boolean getMyBillsEntityDataFactory() {
            return this.MyBillsEntityDataFactory;
        }

        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0012\u0010\u0005\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0007\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0012\u0010\u0003\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0012\u0010\u0006\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\u0004"}, d2 = {"Lid/dana/utils/diffalgorithm/MyersDiff$Range;", "", "", "MyBillsEntityDataFactory", "I", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "p2", "p3", "<init>", "(IIII)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    static final class Range {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        int KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        int PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        int getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        int MyBillsEntityDataFactory;

        public Range() {
            this(0, 0, 0, 0, 15, null);
        }

        public Range(int i, int i2, int i3, int i4) {
            this.PlaceComponentResult = i;
            this.getAuthRequestContext = i2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i3;
            this.MyBillsEntityDataFactory = i4;
        }

        public /* synthetic */ Range(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4);
        }
    }

    public static /* synthetic */ int getAuthRequestContext(Snake snake, Snake snake2) {
        int i = snake.KClassImpl$Data$declaredNonStaticMembers$2 - snake2.KClassImpl$Data$declaredNonStaticMembers$2;
        return i == 0 ? snake.PlaceComponentResult - snake2.PlaceComponentResult : i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a6, code lost:
    
        if (r9[r20 - 1] >= r9[r20 + 1]) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0129, code lost:
    
        r22 = r5;
        r21 = r10;
        r23 = r13;
        r24 = r15;
        r5 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0132, code lost:
    
        if (r5 > r1) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0134, code lost:
    
        r7 = r5 + r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0138, code lost:
    
        if (r7 == (r1 + r16)) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x013c, code lost:
    
        if (r7 == (r4 + r16)) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x013e, code lost:
    
        r10 = r6 + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x014a, code lost:
    
        if (r8[r10 - 1] < r8[r10 + 1]) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x014f, code lost:
    
        r10 = r8[(r6 + r7) + 1] - 1;
        r29 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x015c, code lost:
    
        r10 = r8[(r6 + r7) - 1];
        r29 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0164, code lost:
    
        r13 = r10 - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0166, code lost:
    
        if (r10 <= 0) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0168, code lost:
    
        if (r13 <= 0) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x016a, code lost:
    
        r25 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0186, code lost:
    
        if (r33.invoke(java.lang.Integer.valueOf((r12 + r10) - 1), java.lang.Integer.valueOf((r14 + r13) - 1)).booleanValue() == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0188, code lost:
    
        r10 = r10 - 1;
        r13 = r13 - 1;
        r12 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0191, code lost:
    
        r25 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0193, code lost:
    
        r12 = r6 + r7;
        r8[r12] = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0197, code lost:
    
        if (r0 != false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0199, code lost:
    
        if (r7 < r4) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x019b, code lost:
    
        if (r7 > r1) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x019d, code lost:
    
        r12 = r9[r12];
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019f, code lost:
    
        if (r12 < r10) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01a1, code lost:
    
        r0 = new id.dana.utils.diffalgorithm.MyersDiff.Snake(r10, r10 - r7, r12 - r10, r29, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01b1, code lost:
    
        r5 = r5 + 2;
        r12 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01b7, code lost:
    
        r1 = r1 + 1;
        r7 = r17;
        r10 = r21;
        r5 = r22;
        r13 = r23;
        r15 = r24;
     */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00f7 A[EDGE_INSN: B:129:0x00f7->B:39:0x00f7 BREAK  A[LOOP:5: B:33:0x00ca->B:37:0x00ea], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ea A[LOOP:5: B:33:0x00ca->B:37:0x00ea, LOOP_END] */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final id.dana.utils.diffalgorithm.MyersDiff.DiffResult BuiltInFictitiousFunctionClassFactory(int r31, int r32, kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Integer, java.lang.Boolean> r33) {
        /*
            Method dump skipped, instructions count: 726
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.utils.diffalgorithm.MyersDiff.BuiltInFictitiousFunctionClassFactory(int, int, kotlin.jvm.functions.Function2):id.dana.utils.diffalgorithm.MyersDiff$DiffResult");
    }
}
