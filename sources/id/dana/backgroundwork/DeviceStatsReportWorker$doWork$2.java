package id.dana.backgroundwork;

import androidx.work.ListenableWorker;
import id.dana.DanaApplication;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.devicestats.storage.FileDirectorySizeReportExecutor;
import id.dana.domain.social.Result;
import id.dana.util.AndroidComponentUtilsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroidx/work/ListenableWorker$Result;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.backgroundwork.DeviceStatsReportWorker$doWork$2", f = "DeviceStatsReportWorker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class DeviceStatsReportWorker$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {
    int label;
    final /* synthetic */ DeviceStatsReportWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceStatsReportWorker$doWork$2(DeviceStatsReportWorker deviceStatsReportWorker, Continuation<? super DeviceStatsReportWorker$doWork$2> continuation) {
        super(2, continuation);
        this.this$0 = deviceStatsReportWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceStatsReportWorker$doWork$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ListenableWorker.Result> continuation) {
        return ((DeviceStatsReportWorker$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DanaApplication BuiltInFictitiousFunctionClassFactory = AndroidComponentUtilsKt.BuiltInFictitiousFunctionClassFactory(this.this$0);
            FileDirectorySizeReportExecutor fileDirectorySizeReportExecutor = null;
            ApplicationComponent applicationComponent = BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory.getApplicationComponent() : null;
            if (applicationComponent == null) {
                return ListenableWorker.Result.getAuthRequestContext();
            }
            applicationComponent.PlaceComponentResult(this.this$0);
            try {
                FileDirectorySizeReportExecutor fileDirectorySizeReportExecutor2 = this.this$0.postInstallAppSizeExecutor;
                if (fileDirectorySizeReportExecutor2 != null) {
                    fileDirectorySizeReportExecutor = fileDirectorySizeReportExecutor2;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                return fileDirectorySizeReportExecutor.invoke() instanceof Result.Success ? ListenableWorker.Result.BuiltInFictitiousFunctionClassFactory() : ListenableWorker.Result.getAuthRequestContext();
            } catch (Exception unused) {
                return ListenableWorker.Result.getAuthRequestContext();
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
