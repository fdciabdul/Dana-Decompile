package com.afollestad.materialdialogs.files;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\f\u0012\b\u0012\u0006*\u00020\u00020\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Ljava/io/File;", BridgeDSL.INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1", f = "FileChooserAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class FileChooserAdapter$switchDirectory$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends File>>, Object> {
    int label;
    private CoroutineScope p$;
    final /* synthetic */ FileChooserAdapter$switchDirectory$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileChooserAdapter$switchDirectory$1$result$1(FileChooserAdapter$switchDirectory$1 fileChooserAdapter$switchDirectory$1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = fileChooserAdapter$switchDirectory$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "");
        FileChooserAdapter$switchDirectory$1$result$1 fileChooserAdapter$switchDirectory$1$result$1 = new FileChooserAdapter$switchDirectory$1$result$1(this.this$0, continuation);
        fileChooserAdapter$switchDirectory$1$result$1.p$ = (CoroutineScope) obj;
        return fileChooserAdapter$switchDirectory$1$result$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends File>> continuation) {
        return ((FileChooserAdapter$switchDirectory$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0064 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ac A[SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r8.label
            if (r0 != 0) goto Lcb
            kotlin.ResultKt.throwOnFailure(r9)
            com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1 r9 = r8.this$0
            java.io.File r9 = r9.$$directory
            java.io.File[] r9 = r9.listFiles()
            r0 = 0
            if (r9 != 0) goto L17
            java.io.File[] r9 = new java.io.File[r0]
        L17:
            com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1 r1 = r8.this$0
            com.afollestad.materialdialogs.files.FileChooserAdapter r1 = r1.this$0
            boolean r1 = com.afollestad.materialdialogs.files.FileChooserAdapter.access$getOnlyFolders$p(r1)
            java.lang.String r2 = ""
            r3 = 1
            if (r1 == 0) goto L77
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            int r4 = r9.length
            r5 = 0
        L2d:
            if (r5 >= r4) goto L67
            r6 = r9[r5]
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r2)
            boolean r7 = r6.isDirectory()
            if (r7 == 0) goto L56
            com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1 r7 = r8.this$0
            com.afollestad.materialdialogs.files.FileChooserAdapter r7 = r7.this$0
            kotlin.jvm.functions.Function1 r7 = com.afollestad.materialdialogs.files.FileChooserAdapter.access$getFilter$p(r7)
            if (r7 == 0) goto L51
            java.lang.Object r7 = r7.invoke(r6)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            if (r7 == 0) goto L51
            boolean r7 = r7.booleanValue()
            goto L52
        L51:
            r7 = 1
        L52:
            if (r7 == 0) goto L56
            r7 = 1
            goto L57
        L56:
            r7 = 0
        L57:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L64
            r1.add(r6)
        L64:
            int r5 = r5 + 1
            goto L2d
        L67:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1$invokeSuspend$$inlined$sortedBy$1 r9 = new com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1$invokeSuspend$$inlined$sortedBy$1
            r9.<init>()
            java.util.Comparator r9 = (java.util.Comparator) r9
            java.util.List r9 = kotlin.collections.CollectionsKt.sortedWith(r1, r9)
            goto Lca
        L77:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            int r4 = r9.length
            r5 = 0
        L80:
            if (r5 >= r4) goto Laf
            r6 = r9[r5]
            com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1 r7 = r8.this$0
            com.afollestad.materialdialogs.files.FileChooserAdapter r7 = r7.this$0
            kotlin.jvm.functions.Function1 r7 = com.afollestad.materialdialogs.files.FileChooserAdapter.access$getFilter$p(r7)
            if (r7 == 0) goto L9e
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r2)
            java.lang.Object r7 = r7.invoke(r6)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            if (r7 == 0) goto L9e
            boolean r7 = r7.booleanValue()
            goto L9f
        L9e:
            r7 = 1
        L9f:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto Lac
            r1.add(r6)
        Lac:
            int r5 = r5 + 1
            goto L80
        Laf:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            r9 = 2
            kotlin.jvm.functions.Function1[] r9 = new kotlin.jvm.functions.Function1[r9]
            com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1$4 r2 = new kotlin.jvm.functions.Function1<java.io.File, java.lang.Boolean>() { // from class: com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1.4
                static {
                    /*
                        com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1$4 r0 = new com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1$4
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1$4) com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1.4.INSTANCE com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1$4
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1.AnonymousClass4.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1.AnonymousClass4.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ java.lang.Boolean invoke(java.io.File r1) {
                    /*
                        r0 = this;
                        java.io.File r1 = (java.io.File) r1
                        boolean r1 = r0.invoke2(r1)
                        java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1.AnonymousClass4.invoke(java.lang.Object):java.lang.Object");
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final boolean invoke2(java.io.File r2) {
                    /*
                        r1 = this;
                        java.lang.String r0 = ""
                        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r0)
                        boolean r2 = r2.isDirectory()
                        r2 = r2 ^ 1
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1.AnonymousClass4.invoke2(java.io.File):boolean");
                }
            }
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r9[r0] = r2
            com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1$5 r0 = new kotlin.jvm.functions.Function1<java.io.File, java.lang.String>() { // from class: com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1.5
                static {
                    /*
                        com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1$5 r0 = new com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1$5
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1$5) com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1.5.INSTANCE com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1$5
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1.AnonymousClass5.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1.AnonymousClass5.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ java.lang.String invoke(java.io.File r1) {
                    /*
                        r0 = this;
                        java.io.File r1 = (java.io.File) r1
                        java.lang.String r1 = r0.invoke(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1.AnonymousClass5.invoke(java.lang.Object):java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function1
                public final java.lang.String invoke(java.io.File r3) {
                    /*
                        r2 = this;
                        java.lang.String r0 = ""
                        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r0)
                        java.lang.String r3 = kotlin.io.FilesKt.getNameWithoutExtension(r3)
                        java.util.Locale r1 = java.util.Locale.getDefault()
                        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r0)
                        if (r3 == 0) goto L1a
                        java.lang.String r3 = r3.toLowerCase(r1)
                        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r0)
                        return r3
                    L1a:
                        kotlin.TypeCastException r3 = new kotlin.TypeCastException
                        java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
                        r3.<init>(r0)
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1.AnonymousClass5.invoke(java.io.File):java.lang.String");
                }
            }
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r9[r3] = r0
            java.util.Comparator r9 = kotlin.comparisons.ComparisonsKt.compareBy(r9)
            java.util.List r9 = kotlin.collections.CollectionsKt.sortedWith(r1, r9)
        Lca:
            return r9
        Lcb:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            goto Ld4
        Ld3:
            throw r9
        Ld4:
            goto Ld3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1$result$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
