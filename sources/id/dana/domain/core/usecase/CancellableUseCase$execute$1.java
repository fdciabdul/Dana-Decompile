package id.dana.domain.core.usecase;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"T", "Params", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.domain.core.usecase.CancellableUseCase$execute$1", f = "CancellableUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class CancellableUseCase$execute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onCancel;
    final /* synthetic */ Function1<Throwable, Unit> $onError;
    final /* synthetic */ Function1<T, Unit> $onSuccess;
    final /* synthetic */ Params $params;
    int label;
    final /* synthetic */ CancellableUseCase<T, Params> this$0;
    public static final byte[] PlaceComponentResult = {96, 83, 72, -80, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int BuiltInFictitiousFunctionClassFactory = 17;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CancellableUseCase$execute$1(CancellableUseCase<T, Params> cancellableUseCase, Params params, Function1<? super T, Unit> function1, Function0<Unit> function0, Function1<? super Throwable, Unit> function12, Continuation<? super CancellableUseCase$execute$1> continuation) {
        super(2, continuation);
        this.this$0 = cancellableUseCase;
        this.$params = params;
        this.$onSuccess = function1;
        this.$onCancel = function0;
        this.$onError = function12;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002f -> B:11:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 12
            int r6 = 15 - r6
            int r7 = r7 * 7
            int r7 = r7 + 99
            int r8 = r8 * 3
            int r8 = r8 + 13
            byte[] r0 = id.dana.domain.core.usecase.CancellableUseCase$execute$1.PlaceComponentResult
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L39
        L1c:
            r3 = 0
            r5 = r7
            r7 = r6
            r6 = r5
        L20:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L2f
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2f:
            int r7 = r7 + 1
            r3 = r0[r7]
            r5 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L39:
            int r8 = -r8
            int r6 = r6 + r8
            int r6 = r6 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L20
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.core.usecase.CancellableUseCase$execute$1.a(byte, int, short, java.lang.Object[]):void");
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CancellableUseCase$execute$1(this.this$0, this.$params, this.$onSuccess, this.$onCancel, this.$onError, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CancellableUseCase$execute$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CancellableUseCase<T, Params> cancellableUseCase = this.this$0;
            try {
                byte b = (byte) (PlaceComponentResult[15] + 1);
                byte b2 = (byte) (-PlaceComponentResult[15]);
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-PlaceComponentResult[15]);
                byte b4 = (byte) (b3 - 1);
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                ((CancellableUseCase) cancellableUseCase).observableWorkerThread = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
                CancellableUseCase<T, Params> cancellableUseCase2 = this.this$0;
                Observable buildUseCase = cancellableUseCase2.buildUseCase(this.$params);
                final CancellableUseCase<T, Params> cancellableUseCase3 = this.this$0;
                final Function1<T, Unit> function1 = this.$onSuccess;
                Consumer consumer = new Consumer() { // from class: id.dana.domain.core.usecase.CancellableUseCase$execute$1$$ExternalSyntheticLambda0
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj2) {
                        CancellableUseCase$execute$1.m2272invokeSuspend$lambda0(CancellableUseCase.this, function1, obj2);
                    }
                };
                final CancellableUseCase<T, Params> cancellableUseCase4 = this.this$0;
                final Function0<Unit> function0 = this.$onCancel;
                final Function1<Throwable, Unit> function12 = this.$onError;
                Consumer<? super Throwable> consumer2 = new Consumer() { // from class: id.dana.domain.core.usecase.CancellableUseCase$execute$1$$ExternalSyntheticLambda1
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj2) {
                        CancellableUseCase$execute$1.m2273invokeSuspend$lambda1(CancellableUseCase.this, function0, function12, (Throwable) obj2);
                    }
                };
                final CancellableUseCase<T, Params> cancellableUseCase5 = this.this$0;
                ((CancellableUseCase) cancellableUseCase2).disposable = buildUseCase.subscribe(consumer, consumer2, new Action() { // from class: id.dana.domain.core.usecase.CancellableUseCase$execute$1$$ExternalSyntheticLambda2
                    @Override // io.reactivex.functions.Action
                    public final void run() {
                        CancellableUseCase.access$dispose(CancellableUseCase.this);
                    }
                });
                return Unit.INSTANCE;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m2272invokeSuspend$lambda0(CancellableUseCase cancellableUseCase, Function1 function1, Object obj) {
        CoroutineScope coroutineScope;
        coroutineScope = cancellableUseCase.uiScope;
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CancellableUseCase$execute$1$1$1(function1, obj, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-1  reason: not valid java name */
    public static final void m2273invokeSuspend$lambda1(CancellableUseCase cancellableUseCase, Function0 function0, Function1 function1, Throwable th) {
        CoroutineScope coroutineScope;
        CoroutineScope coroutineScope2;
        if (th instanceof InterruptedException) {
            coroutineScope2 = cancellableUseCase.uiScope;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new CancellableUseCase$execute$1$2$1(function0, null), 3, null);
        } else {
            coroutineScope = cancellableUseCase.uiScope;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CancellableUseCase$execute$1$2$2(function1, th, null), 3, null);
        }
        cancellableUseCase.dispose();
    }
}
