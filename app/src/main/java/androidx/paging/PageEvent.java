package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.TransformablePage;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.google.common.net.HttpHeaders;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b0\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0003\u000f\u0010\u0011B\t\b\u0004¢\u0006\u0004\b\r\u0010\u000eJ=\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJM\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\t*\u00020\u00012(\u0010\u0006\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\bJG\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\t*\u00020\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\b\u0082\u0001\u0003\u0012\u0013\u0014\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/PageEvent;", "", "T", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "p0", "MyBillsEntityDataFactory", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V", "Drop", "Insert", "LoadStateUpdate", "Landroidx/paging/PageEvent$Insert;", "Landroidx/paging/PageEvent$Drop;", "Landroidx/paging/PageEvent$LoadStateUpdate;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class PageEvent<T> {
    public /* synthetic */ PageEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public <R> Object BuiltInFictitiousFunctionClassFactory(Function2<? super T, ? super Continuation<? super Iterable<? extends R>>, ? extends Object> function2, Continuation<? super PageEvent<R>> continuation) {
        return this;
    }

    public <R> Object KClassImpl$Data$declaredNonStaticMembers$2(Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super PageEvent<R>> continuation) {
        return this;
    }

    public Object MyBillsEntityDataFactory(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super PageEvent<T>> continuation) {
        return this;
    }

    private PageEvent() {
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u0000 (*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003:\u0001(BI\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0016\u0012\u0012\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001b0\u001a\u0012\u0006\u0010\"\u001a\u00020\u000f\u0012\u0006\u0010#\u001a\u00020\u000f\u0012\u0006\u0010$\u001a\u00020\u0018\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b&\u0010'J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J=\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJM\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\b\b\u0002\u0010\f*\u00020\u00012(\u0010\u0004\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\r0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011JG\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\b\b\u0002\u0010\f*\u00020\u00012\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0016X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0017R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0018X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001b0\u001aX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0012\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0011\u0010 \u001a\u00020\u0018X\u0006¢\u0006\u0006\n\u0004\b \u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/PageEvent$Insert;", "", "T", "Landroidx/paging/PageEvent;", "p0", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "MyBillsEntityDataFactory", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "", "BuiltInFictitiousFunctionClassFactory", "", "hashCode", "()I", "KClassImpl$Data$declaredNonStaticMembers$2", "", "toString", "()Ljava/lang/String;", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadStates;", "Landroidx/paging/LoadStates;", "", "Landroidx/paging/TransformablePage;", "Ljava/util/List;", "getAuthRequestContext", "I", "PlaceComponentResult", "getErrorConfigVersion", "p1", "p2", "p3", "p4", "p5", "<init>", "(Landroidx/paging/LoadType;Ljava/util/List;IILandroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* data */ class Insert<T> extends PageEvent<T> {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Insert<Object> moveToNextValue;
        final LoadStates BuiltInFictitiousFunctionClassFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final LoadType MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final List<TransformablePage<T>> getAuthRequestContext;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final int KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final int PlaceComponentResult;
        final LoadStates getErrorConfigVersion;

        public /* synthetic */ Insert(LoadType loadType, List list, int i, int i2, LoadStates loadStates, LoadStates loadStates2, DefaultConstructorMarker defaultConstructorMarker) {
            this(loadType, list, i, i2, loadStates, loadStates2);
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Insert) {
                Insert insert = (Insert) p0;
                return this.MyBillsEntityDataFactory == insert.MyBillsEntityDataFactory && Intrinsics.areEqual(this.getAuthRequestContext, insert.getAuthRequestContext) && this.KClassImpl$Data$declaredNonStaticMembers$2 == insert.KClassImpl$Data$declaredNonStaticMembers$2 && this.PlaceComponentResult == insert.PlaceComponentResult && Intrinsics.areEqual(this.getErrorConfigVersion, insert.getErrorConfigVersion) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, insert.BuiltInFictitiousFunctionClassFactory);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.MyBillsEntityDataFactory.hashCode();
            int hashCode2 = this.getAuthRequestContext.hashCode();
            int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int i2 = this.PlaceComponentResult;
            int hashCode3 = this.getErrorConfigVersion.hashCode();
            LoadStates loadStates = this.BuiltInFictitiousFunctionClassFactory;
            return (((((((((hashCode * 31) + hashCode2) * 31) + i) * 31) + i2) * 31) + hashCode3) * 31) + (loadStates == null ? 0 : loadStates.hashCode());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Insert(MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", getErrorConfigVersion=");
            sb.append(this.getErrorConfigVersion);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(')');
            return sb.toString();
        }

        private Insert(LoadType loadType, List<TransformablePage<T>> list, int i, int i2, LoadStates loadStates, LoadStates loadStates2) {
            super(null);
            this.MyBillsEntityDataFactory = loadType;
            this.getAuthRequestContext = list;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.PlaceComponentResult = i2;
            this.getErrorConfigVersion = loadStates;
            this.BuiltInFictitiousFunctionClassFactory = loadStates2;
            if (!(loadType == LoadType.APPEND || i >= 0)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Prepend insert defining placeholdersBefore must be > 0, but was ", Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2)).toString());
            }
            if (!(loadType == LoadType.PREPEND || i2 >= 0)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Append insert defining placeholdersAfter must be > 0, but was ", Integer.valueOf(this.PlaceComponentResult)).toString());
            }
            if (!(loadType != LoadType.REFRESH || (list.isEmpty() ^ true))) {
                throw new IllegalArgumentException("Cannot create a REFRESH Insert event with no TransformablePages as this could permanently stall pagination. Note that this check does not prevent empty LoadResults and is instead usually an indication of an internal error in Paging itself.".toString());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00b8  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00ee  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0102  */
        /* JADX WARN: Type inference failed for: r13v9, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r4v10, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r7v11, types: [java.util.Collection] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0091 -> B:18:0x00b2). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00dc -> B:24:0x00e4). Please submit an issue!!! */
        @Override // androidx.paging.PageEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final <R> java.lang.Object KClassImpl$Data$declaredNonStaticMembers$2(kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> r19, kotlin.coroutines.Continuation<? super androidx.paging.PageEvent<R>> r20) {
            /*
                Method dump skipped, instructions count: 277
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.Insert.KClassImpl$Data$declaredNonStaticMembers$2(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0128 A[LOOP:0: B:32:0x011e->B:34:0x0128, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x013b  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x014e  */
        /* JADX WARN: Type inference failed for: r10v7, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r11v7, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r14v6, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r7v8, types: [java.util.Collection] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0099 -> B:18:0x00c0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00fa -> B:27:0x0109). Please submit an issue!!! */
        @Override // androidx.paging.PageEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final <R> java.lang.Object BuiltInFictitiousFunctionClassFactory(kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Iterable<? extends R>>, ? extends java.lang.Object> r19, kotlin.coroutines.Continuation<? super androidx.paging.PageEvent<R>> r20) {
            /*
                Method dump skipped, instructions count: 354
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.Insert.BuiltInFictitiousFunctionClassFactory(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0103  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0127  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0139  */
        /* JADX WARN: Type inference failed for: r10v7, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r11v8, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r14v3, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r7v8, types: [java.util.Collection] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0096 -> B:18:0x00bd). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00f2 -> B:27:0x00fb). Please submit an issue!!! */
        @Override // androidx.paging.PageEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object MyBillsEntityDataFactory(kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> r19, kotlin.coroutines.Continuation<? super androidx.paging.PageEvent<T>> r20) {
            /*
                Method dump skipped, instructions count: 333
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.Insert.MyBillsEntityDataFactory(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004\"\b\b\u0002\u0010\b*\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fJF\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004\"\b\b\u0002\u0010\b*\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u000b0\n2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fJN\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004\"\b\b\u0002\u0010\b*\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u000b0\n2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Landroidx/paging/PageEvent$Insert$Companion;", "", "()V", "EMPTY_REFRESH_LOCAL", "Landroidx/paging/PageEvent$Insert;", "getEMPTY_REFRESH_LOCAL", "()Landroidx/paging/PageEvent$Insert;", "Append", "T", SecurityConstants.KEY_PAGES, "", "Landroidx/paging/TransformablePage;", "placeholdersAfter", "", "sourceLoadStates", "Landroidx/paging/LoadStates;", "mediatorLoadStates", "Prepend", "placeholdersBefore", HttpHeaders.REFRESH, "paging-common"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static <T> Insert<T> KClassImpl$Data$declaredNonStaticMembers$2(List<TransformablePage<T>> list, int i, int i2, LoadStates loadStates, LoadStates loadStates2) {
                Intrinsics.checkNotNullParameter(list, "");
                Intrinsics.checkNotNullParameter(loadStates, "");
                return new Insert<>(LoadType.REFRESH, list, i, i2, loadStates, loadStates2, null);
            }

            public static <T> Insert<T> KClassImpl$Data$declaredNonStaticMembers$2(List<TransformablePage<T>> list, int i, LoadStates loadStates, LoadStates loadStates2) {
                Intrinsics.checkNotNullParameter(list, "");
                Intrinsics.checkNotNullParameter(loadStates, "");
                return new Insert<>(LoadType.PREPEND, list, i, -1, loadStates, loadStates2, null);
            }

            public static <T> Insert<T> PlaceComponentResult(List<TransformablePage<T>> list, int i, LoadStates loadStates, LoadStates loadStates2) {
                Intrinsics.checkNotNullParameter(list, "");
                Intrinsics.checkNotNullParameter(loadStates, "");
                return new Insert<>(LoadType.APPEND, list, -1, i, loadStates, loadStates2, null);
            }

            @JvmName(name = "getEMPTY_REFRESH_LOCAL")
            public static Insert<Object> getAuthRequestContext() {
                return Insert.moveToNextValue;
            }
        }

        static {
            TransformablePage<Object> transformablePage;
            LoadState.NotLoading notLoading;
            TransformablePage.Companion companion = TransformablePage.INSTANCE;
            transformablePage = TransformablePage.BuiltInFictitiousFunctionClassFactory;
            List listOf = CollectionsKt.listOf(transformablePage);
            LoadState.NotLoading.Companion companion2 = LoadState.NotLoading.INSTANCE;
            notLoading = LoadState.NotLoading.getAuthRequestContext;
            LoadState.NotLoading.Companion companion3 = LoadState.NotLoading.INSTANCE;
            LoadState.NotLoading BuiltInFictitiousFunctionClassFactory = LoadState.NotLoading.Companion.BuiltInFictitiousFunctionClassFactory();
            LoadState.NotLoading.Companion companion4 = LoadState.NotLoading.INSTANCE;
            moveToNextValue = Companion.KClassImpl$Data$declaredNonStaticMembers$2(listOf, 0, 0, new LoadStates(notLoading, BuiltInFictitiousFunctionClassFactory, LoadState.NotLoading.Companion.BuiltInFictitiousFunctionClassFactory()), null);
        }

        public static /* synthetic */ Insert MyBillsEntityDataFactory(Insert insert, LoadStates loadStates, LoadStates loadStates2) {
            LoadType loadType = insert.MyBillsEntityDataFactory;
            List<TransformablePage<T>> list = insert.getAuthRequestContext;
            int i = insert.KClassImpl$Data$declaredNonStaticMembers$2;
            int i2 = insert.PlaceComponentResult;
            Intrinsics.checkNotNullParameter(loadType, "");
            Intrinsics.checkNotNullParameter(list, "");
            Intrinsics.checkNotNullParameter(loadStates, "");
            return new Insert(loadType, list, i, i2, loadStates, loadStates2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0011\u001a\u00020\u000eX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000f\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0012\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0013"}, d2 = {"Landroidx/paging/PageEvent$Drop;", "", "T", "Landroidx/paging/PageEvent;", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroidx/paging/LoadType;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/paging/LoadType;", "PlaceComponentResult", "getAuthRequestContext", "I", "BuiltInFictitiousFunctionClassFactory", "p1", "p2", "p3", "<init>", "(Landroidx/paging/LoadType;III)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* data */ class Drop<T> extends PageEvent<T> {
        final int BuiltInFictitiousFunctionClassFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final LoadType PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final int getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final int KClassImpl$Data$declaredNonStaticMembers$2;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Drop) {
                Drop drop = (Drop) p0;
                return this.PlaceComponentResult == drop.PlaceComponentResult && this.BuiltInFictitiousFunctionClassFactory == drop.BuiltInFictitiousFunctionClassFactory && this.KClassImpl$Data$declaredNonStaticMembers$2 == drop.KClassImpl$Data$declaredNonStaticMembers$2 && this.getAuthRequestContext == drop.getAuthRequestContext;
            }
            return false;
        }

        public final int hashCode() {
            return (((((this.PlaceComponentResult.hashCode() * 31) + this.BuiltInFictitiousFunctionClassFactory) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2) * 31) + this.getAuthRequestContext;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Drop(PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Drop(LoadType loadType, int i, int i2, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(loadType, "");
            this.PlaceComponentResult = loadType;
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            this.getAuthRequestContext = i3;
            if (!(loadType != LoadType.REFRESH)) {
                throw new IllegalArgumentException("Drop load type must be PREPEND or APPEND".toString());
            }
            if (!((this.KClassImpl$Data$declaredNonStaticMembers$2 - this.BuiltInFictitiousFunctionClassFactory) + 1 > 0)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Drop count must be > 0, but was ", Integer.valueOf((this.KClassImpl$Data$declaredNonStaticMembers$2 - this.BuiltInFictitiousFunctionClassFactory) + 1)).toString());
            }
            if (!(i3 >= 0)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Invalid placeholdersRemaining ", Integer.valueOf(this.getAuthRequestContext)).toString());
            }
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u000eX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010"}, d2 = {"Landroidx/paging/PageEvent$LoadStateUpdate;", "", "T", "Landroidx/paging/PageEvent;", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroidx/paging/LoadStates;", "MyBillsEntityDataFactory", "Landroidx/paging/LoadStates;", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "p1", "<init>", "(Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* data */ class LoadStateUpdate<T> extends PageEvent<T> {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final LoadStates BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final LoadStates KClassImpl$Data$declaredNonStaticMembers$2;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof LoadStateUpdate) {
                LoadStateUpdate loadStateUpdate = (LoadStateUpdate) p0;
                return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, loadStateUpdate.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, loadStateUpdate.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.BuiltInFictitiousFunctionClassFactory.hashCode();
            LoadStates loadStates = this.KClassImpl$Data$declaredNonStaticMembers$2;
            return (hashCode * 31) + (loadStates == null ? 0 : loadStates.hashCode());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LoadStateUpdate(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(')');
            return sb.toString();
        }

        public /* synthetic */ LoadStateUpdate(LoadStates loadStates, LoadStates loadStates2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(loadStates, (i & 2) != 0 ? null : loadStates2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoadStateUpdate(LoadStates loadStates, LoadStates loadStates2) {
            super(null);
            Intrinsics.checkNotNullParameter(loadStates, "");
            this.BuiltInFictitiousFunctionClassFactory = loadStates;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = loadStates2;
        }
    }
}
