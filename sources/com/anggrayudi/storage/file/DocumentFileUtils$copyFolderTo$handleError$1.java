package com.anggrayudi.storage.file;

import com.anggrayudi.storage.callback.FolderCallback;
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
final class DocumentFileUtils$copyFolderTo$handleError$1 extends Lambda implements Function1<Exception, Boolean> {
    final /* synthetic */ FolderCallback $callback;
    final /* synthetic */ Function1<FolderCallback.ErrorCode, Unit> $notifyCanceled;
    final /* synthetic */ Ref.ObjectRef<Job> $timer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DocumentFileUtils$copyFolderTo$handleError$1(Function1<? super FolderCallback.ErrorCode, Unit> function1, Ref.ObjectRef<Job> objectRef, FolderCallback folderCallback) {
        super(1);
        this.$notifyCanceled = function1;
        this.$timer = objectRef;
        this.$callback = folderCallback;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "");
        FolderCallback.ErrorCode KClassImpl$Data$declaredNonStaticMembers$2 = DocumentFileUtils.KClassImpl$Data$declaredNonStaticMembers$2(exc);
        boolean z = true;
        if (KClassImpl$Data$declaredNonStaticMembers$2 == FolderCallback.ErrorCode.CANCELED || KClassImpl$Data$declaredNonStaticMembers$2 == FolderCallback.ErrorCode.UNKNOWN_IO_ERROR) {
            this.$notifyCanceled.invoke(KClassImpl$Data$declaredNonStaticMembers$2);
        } else {
            Job job = this.$timer.element;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, null, 1, null);
            }
            BuildersKt__Builders_commonKt.launch$default(this.$callback.PlaceComponentResult, Dispatchers.getMain(), null, new DocumentFileUtils$copyFolderTo$handleError$1$invoke$$inlined$postToUi$1(null, this.$callback, KClassImpl$Data$declaredNonStaticMembers$2), 2, null);
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
