package com.anggrayudi.storage.file;

import com.anggrayudi.storage.callback.MultipleFileCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0004\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes7.dex */
final class DocumentFileUtils$copyTo$handleError$1 extends Lambda implements Function1<Exception, Boolean> {
    final /* synthetic */ MultipleFileCallback $callback;
    final /* synthetic */ Function1<MultipleFileCallback.ErrorCode, Unit> $notifyCanceled;
    final /* synthetic */ Ref.ObjectRef<Job> $timer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DocumentFileUtils$copyTo$handleError$1(Function1<? super MultipleFileCallback.ErrorCode, Unit> function1, Ref.ObjectRef<Job> objectRef, MultipleFileCallback multipleFileCallback) {
        super(1);
        this.$notifyCanceled = function1;
        this.$timer = objectRef;
        this.$callback = multipleFileCallback;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "");
        MultipleFileCallback.ErrorCode BuiltInFictitiousFunctionClassFactory = DocumentFileUtils.BuiltInFictitiousFunctionClassFactory(exc);
        boolean z = true;
        if (BuiltInFictitiousFunctionClassFactory == MultipleFileCallback.ErrorCode.CANCELED || BuiltInFictitiousFunctionClassFactory == MultipleFileCallback.ErrorCode.UNKNOWN_IO_ERROR) {
            this.$notifyCanceled.invoke(BuiltInFictitiousFunctionClassFactory);
        } else {
            Job job = this.$timer.element;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, null, 1, null);
            }
            BuildersKt__Builders_commonKt.launch$default(this.$callback.PlaceComponentResult, Dispatchers.getMain(), null, new DocumentFileUtils$copyTo$handleError$1$invoke$$inlined$postToUi$1(null, this.$callback, BuiltInFictitiousFunctionClassFactory), 2, null);
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
