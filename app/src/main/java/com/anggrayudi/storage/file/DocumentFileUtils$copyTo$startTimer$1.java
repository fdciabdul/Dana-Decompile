package com.anggrayudi.storage.file;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.anggrayudi.storage.callback.MultipleFileCallback;
import com.anggrayudi.storage.extension.CoroutineExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "start", "", BridgeDSL.INVOKE, "(Z)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes7.dex */
final class DocumentFileUtils$copyTo$startTimer$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Ref.LongRef $$bytesMoved;
    final /* synthetic */ MultipleFileCallback $$callback;
    final /* synthetic */ long $$reportInterval;
    final /* synthetic */ Ref.ObjectRef<Job> $$timer;
    final /* synthetic */ Ref.IntRef $$totalCopiedFiles;
    final /* synthetic */ long $$totalSizeToCopy;
    final /* synthetic */ Ref.IntRef $$writeSpeed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$copyTo$startTimer$1(long j, Ref.ObjectRef<Job> objectRef, Ref.LongRef longRef, long j2, Ref.IntRef intRef, Ref.IntRef intRef2, MultipleFileCallback multipleFileCallback) {
        super(1);
        this.$$reportInterval = j;
        this.$$timer = objectRef;
        this.$$bytesMoved = longRef;
        this.$$totalSizeToCopy = j2;
        this.$$writeSpeed = intRef;
        this.$$totalCopiedFiles = intRef2;
        this.$$callback = multipleFileCallback;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, kotlinx.coroutines.Job] */
    public final void invoke(boolean z) {
        if (z) {
            long j = this.$$reportInterval;
            if (j > 0) {
                Ref.ObjectRef<Job> objectRef = this.$$timer;
                final Ref.LongRef longRef = this.$$bytesMoved;
                final long j2 = this.$$totalSizeToCopy;
                final Ref.IntRef intRef = this.$$writeSpeed;
                final Ref.IntRef intRef2 = this.$$totalCopiedFiles;
                final MultipleFileCallback multipleFileCallback = this.$$callback;
                objectRef.element = CoroutineExtKt.getAuthRequestContext(j, new Function0<Unit>() { // from class: com.anggrayudi.storage.file.DocumentFileUtils$copyTo$startTimer$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        MultipleFileCallback.Report report = new MultipleFileCallback.Report((((float) Ref.LongRef.this.element) * 100.0f) / ((float) j2), Ref.LongRef.this.element, intRef.element, intRef2.element);
                        BuildersKt__Builders_commonKt.launch$default(multipleFileCallback.PlaceComponentResult, Dispatchers.getMain(), null, new DocumentFileUtils$copyTo$startTimer$1$1$invoke$$inlined$postToUi$1(null, multipleFileCallback, report), 2, null);
                        intRef.element = 0;
                    }
                });
            }
        }
    }
}
