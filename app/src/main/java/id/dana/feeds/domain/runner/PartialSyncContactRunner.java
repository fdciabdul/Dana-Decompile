package id.dana.feeds.domain.runner;

import id.dana.domain.social.FullSyncNotFinishedException;
import id.dana.domain.social.Result;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.feeds.domain.synccontact.FeedsSyncContactRepository;
import id.dana.feeds.domain.synccontact.model.FeedsContact;
import id.dana.feeds.domain.synccontact.model.SyncResult;
import java.util.List;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u0003\u001a\u00020\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0004J\u0013\u0010\b\u001a\u00020\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0003\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\n\u0010\r\u001a\u00060\u000bj\u0002`\fH\u0094@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0096@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u0002H\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0004R\u0016\u0010\u0003\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u000f\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0016\u0010\b\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0016\u0010\u0016\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/feeds/domain/runner/PartialSyncContactRunner;", "Lid/dana/feeds/domain/runner/BaseSyncContactRunner;", "", "PlaceComponentResult", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lid/dana/feeds/domain/synccontact/model/FeedsContact;", "MyBillsEntityDataFactory", "getAuthRequestContext", "", "()Z", "Ljava/lang/Exception;", "Lkotlin/Exception;", "p0", "Lid/dana/domain/social/Result$Error;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/domain/social/Result$Success;", "", "Lid/dana/domain/social/Result;", "Lid/dana/feeds/domain/synccontact/model/SyncResult;", "(Lid/dana/domain/social/Result$Success;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "", "Ljava/lang/String;", "Lid/dana/feeds/domain/synccontact/FeedsSyncContactRepository;", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "p1", "<init>", "(Lid/dana/feeds/domain/synccontact/FeedsSyncContactRepository;Lid/dana/feeds/domain/activation/FeedInitRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public class PartialSyncContactRunner extends BaseSyncContactRunner {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private int PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.feeds.domain.runner.BaseSyncContactRunner
    public final Object KClassImpl$Data$declaredNonStaticMembers$2(Continuation<? super Unit> continuation) {
        return PlaceComponentResult(this, (Continuation) continuation);
    }

    @Override // id.dana.feeds.domain.runner.BaseSyncContactRunner
    public final Object MyBillsEntityDataFactory(Continuation<? super List<FeedsContact>> continuation) {
        return getAuthRequestContext(this, (Continuation) continuation);
    }

    @Override // id.dana.feeds.domain.runner.BaseSyncContactRunner
    public final Object getAuthRequestContext(Result.Success<Integer> success, Continuation<? super Result<SyncResult>> continuation) {
        return KClassImpl$Data$declaredNonStaticMembers$2(this, success, continuation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PartialSyncContactRunner(FeedsSyncContactRepository feedsSyncContactRepository, FeedInitRepository feedInitRepository) {
        super(feedsSyncContactRepository, feedInitRepository);
        Intrinsics.checkNotNullParameter(feedsSyncContactRepository, "");
        Intrinsics.checkNotNullParameter(feedInitRepository, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 50;
        this.getAuthRequestContext = "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object PlaceComponentResult(id.dana.feeds.domain.runner.PartialSyncContactRunner r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof id.dana.feeds.domain.runner.PartialSyncContactRunner$onSyncStarting$1
            if (r0 == 0) goto L14
            r0 = r7
            id.dana.feeds.domain.runner.PartialSyncContactRunner$onSyncStarting$1 r0 = (id.dana.feeds.domain.runner.PartialSyncContactRunner$onSyncStarting$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            id.dana.feeds.domain.runner.PartialSyncContactRunner$onSyncStarting$1 r0 = new id.dana.feeds.domain.runner.PartialSyncContactRunner$onSyncStarting$1
            r0.<init>(r6, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L48
            if (r2 == r5) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6d
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.L$0
            id.dana.feeds.domain.runner.PartialSyncContactRunner r6 = (id.dana.feeds.domain.runner.PartialSyncContactRunner) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L61
        L40:
            java.lang.Object r6 = r0.L$0
            id.dana.feeds.domain.runner.PartialSyncContactRunner r6 = (id.dana.feeds.domain.runner.PartialSyncContactRunner) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L56
        L48:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r7 = super.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            if (r7 != r1) goto L56
            return r1
        L56:
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r6.PlaceComponentResult(r0)
            if (r7 != r1) goto L61
            return r1
        L61:
            r7 = 0
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r6 = r6.getAuthRequestContext(r0)
            if (r6 != r1) goto L6d
            return r1
        L6d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.runner.PartialSyncContactRunner.PlaceComponentResult(id.dana.feeds.domain.runner.PartialSyncContactRunner, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object PlaceComponentResult(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof id.dana.feeds.domain.runner.PartialSyncContactRunner$cancelSyncIfFullSyncNotFinished$1
            if (r0 == 0) goto L14
            r0 = r5
            id.dana.feeds.domain.runner.PartialSyncContactRunner$cancelSyncIfFullSyncNotFinished$1 r0 = (id.dana.feeds.domain.runner.PartialSyncContactRunner$cancelSyncIfFullSyncNotFinished$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 + r2
            r0.label = r5
            goto L19
        L14:
            id.dana.feeds.domain.runner.PartialSyncContactRunner$cancelSyncIfFullSyncNotFinished$1 r0 = new id.dana.feeds.domain.runner.PartialSyncContactRunner$cancelSyncIfFullSyncNotFinished$1
            r0.<init>(r4, r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L42
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            id.dana.feeds.domain.synccontact.FeedsSyncContactRepository r5 = r4.getGetAuthRequestContext()
            r0.label = r3
            java.lang.Object r5 = r5.BuiltInFictitiousFunctionClassFactory()
            if (r5 != r1) goto L42
            return r1
        L42:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L4d
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L4d:
            id.dana.domain.social.FullSyncNotFinishedException r5 = new id.dana.domain.social.FullSyncNotFinishedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.runner.PartialSyncContactRunner.PlaceComponentResult(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAuthRequestContext(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof id.dana.feeds.domain.runner.PartialSyncContactRunner$getLastSyncTimeAndItsContactOffsetForCurrentSync$1
            if (r0 == 0) goto L14
            r0 = r8
            id.dana.feeds.domain.runner.PartialSyncContactRunner$getLastSyncTimeAndItsContactOffsetForCurrentSync$1 r0 = (id.dana.feeds.domain.runner.PartialSyncContactRunner$getLastSyncTimeAndItsContactOffsetForCurrentSync$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 + r2
            r0.label = r8
            goto L19
        L14:
            id.dana.feeds.domain.runner.PartialSyncContactRunner$getLastSyncTimeAndItsContactOffsetForCurrentSync$1 r0 = new id.dana.feeds.domain.runner.PartialSyncContactRunner$getLastSyncTimeAndItsContactOffsetForCurrentSync$1
            r0.<init>(r7, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L5d
            if (r2 == r5) goto L4d
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r0 = r0.L$0
            id.dana.feeds.domain.runner.PartialSyncContactRunner r0 = (id.dana.feeds.domain.runner.PartialSyncContactRunner) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto La8
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3d:
            java.lang.Object r2 = r0.L$2
            id.dana.feeds.domain.runner.PartialSyncContactRunner r2 = (id.dana.feeds.domain.runner.PartialSyncContactRunner) r2
            java.lang.Object r4 = r0.L$1
            id.dana.feeds.domain.synccontact.FeedsSyncContactRepository r4 = (id.dana.feeds.domain.synccontact.FeedsSyncContactRepository) r4
            java.lang.Object r5 = r0.L$0
            id.dana.feeds.domain.runner.PartialSyncContactRunner r5 = (id.dana.feeds.domain.runner.PartialSyncContactRunner) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L8f
        L4d:
            java.lang.Object r2 = r0.L$2
            id.dana.feeds.domain.runner.PartialSyncContactRunner r2 = (id.dana.feeds.domain.runner.PartialSyncContactRunner) r2
            java.lang.Object r5 = r0.L$1
            id.dana.feeds.domain.synccontact.FeedsSyncContactRepository r5 = (id.dana.feeds.domain.synccontact.FeedsSyncContactRepository) r5
            java.lang.Object r6 = r0.L$0
            id.dana.feeds.domain.runner.PartialSyncContactRunner r6 = (id.dana.feeds.domain.runner.PartialSyncContactRunner) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L77
        L5d:
            kotlin.ResultKt.throwOnFailure(r8)
            id.dana.feeds.domain.synccontact.FeedsSyncContactRepository r8 = r7.getGetAuthRequestContext()
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r7
            r0.label = r5
            java.lang.Object r2 = r8.moveToNextValue()
            if (r2 != r1) goto L73
            return r1
        L73:
            r6 = r7
            r5 = r8
            r8 = r2
            r2 = r6
        L77:
            java.lang.String r8 = (java.lang.String) r8
            r2.getAuthRequestContext = r8
            java.lang.String r8 = r6.getAuthRequestContext
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r4
            java.lang.Object r8 = r5.MyBillsEntityDataFactory(r8)
            if (r8 != r1) goto L8c
            return r1
        L8c:
            r4 = r5
            r2 = r6
            r5 = r2
        L8f:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r2.BuiltInFictitiousFunctionClassFactory = r8
            r0.L$0 = r5
            r8 = 0
            r0.L$1 = r8
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r8 = r4.getErrorConfigVersion()
            if (r8 != r1) goto La7
            return r1
        La7:
            r0 = r5
        La8:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r0.KClassImpl$Data$declaredNonStaticMembers$2 = r8
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.runner.PartialSyncContactRunner.getAuthRequestContext(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object getAuthRequestContext(id.dana.feeds.domain.runner.PartialSyncContactRunner r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof id.dana.feeds.domain.runner.PartialSyncContactRunner$getContactToBeSynched$1
            if (r0 == 0) goto L14
            r0 = r7
            id.dana.feeds.domain.runner.PartialSyncContactRunner$getContactToBeSynched$1 r0 = (id.dana.feeds.domain.runner.PartialSyncContactRunner$getContactToBeSynched$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            id.dana.feeds.domain.runner.PartialSyncContactRunner$getContactToBeSynched$1 r0 = new id.dana.feeds.domain.runner.PartialSyncContactRunner$getContactToBeSynched$1
            r0.<init>(r6, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r6 = r0.L$0
            id.dana.feeds.domain.runner.PartialSyncContactRunner r6 = (id.dana.feeds.domain.runner.PartialSyncContactRunner) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4e
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            kotlin.ResultKt.throwOnFailure(r7)
            id.dana.feeds.domain.synccontact.FeedsSyncContactRepository r7 = r6.getGetAuthRequestContext()
            int r2 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            int r4 = r6.BuiltInFictitiousFunctionClassFactory
            java.lang.String r5 = r6.getAuthRequestContext
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.getAuthRequestContext(r2, r4, r5)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            java.util.List r7 = (java.util.List) r7
            int r0 = r7.size()
            r6.PlaceComponentResult = r0
            int r1 = r6.BuiltInFictitiousFunctionClassFactory
            int r1 = r1 + r0
            r6.MyBillsEntityDataFactory = r1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.runner.PartialSyncContactRunner.getAuthRequestContext(id.dana.feeds.domain.runner.PartialSyncContactRunner, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object KClassImpl$Data$declaredNonStaticMembers$2(id.dana.feeds.domain.runner.PartialSyncContactRunner r7, id.dana.domain.social.Result.Success r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof id.dana.feeds.domain.runner.PartialSyncContactRunner$onSyncContactSuccess$1
            if (r0 == 0) goto L14
            r0 = r9
            id.dana.feeds.domain.runner.PartialSyncContactRunner$onSyncContactSuccess$1 r0 = (id.dana.feeds.domain.runner.PartialSyncContactRunner$onSyncContactSuccess$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 + r2
            r0.label = r9
            goto L19
        L14:
            id.dana.feeds.domain.runner.PartialSyncContactRunner$onSyncContactSuccess$1 r0 = new id.dana.feeds.domain.runner.PartialSyncContactRunner$onSyncContactSuccess$1
            r0.<init>(r7, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r7 = r0.L$1
            id.dana.domain.social.Result$Success r7 = (id.dana.domain.social.Result.Success) r7
            java.lang.Object r8 = r0.L$0
            id.dana.feeds.domain.runner.PartialSyncContactRunner r8 = (id.dana.feeds.domain.runner.PartialSyncContactRunner) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L99
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            java.lang.Object r7 = r0.L$1
            r8 = r7
            id.dana.domain.social.Result$Success r8 = (id.dana.domain.social.Result.Success) r8
            java.lang.Object r7 = r0.L$0
            id.dana.feeds.domain.runner.PartialSyncContactRunner r7 = (id.dana.feeds.domain.runner.PartialSyncContactRunner) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L6b
        L4a:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            id.dana.feeds.domain.synccontact.FeedsSyncContactRepository r9 = r7.getGetAuthRequestContext()
            int r2 = r7.MyBillsEntityDataFactory
            java.lang.String r5 = r7.getAuthRequestContext
            java.lang.Object r9 = r9.BuiltInFictitiousFunctionClassFactory(r2, r5)
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r9 != r2) goto L66
            goto L68
        L66:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
        L68:
            if (r9 != r1) goto L6b
            return r1
        L6b:
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            id.dana.feeds.domain.synccontact.FeedsSyncContactRepository r9 = r7.getGetAuthRequestContext()
            boolean r0 = r7.PlaceComponentResult()
            if (r0 == 0) goto L84
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r0 = java.lang.String.valueOf(r2)
            goto L86
        L84:
            java.lang.String r0 = r7.getAuthRequestContext
        L86:
            java.lang.Object r9 = r9.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r9 != r0) goto L91
            goto L93
        L91:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
        L93:
            if (r9 != r1) goto L96
            return r1
        L96:
            r6 = r8
            r8 = r7
            r7 = r6
        L99:
            java.lang.Object r7 = r7.getData()
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            int r8 = r8.KClassImpl$Data$declaredNonStaticMembers$2
            if (r7 < r8) goto La8
            goto La9
        La8:
            r4 = 0
        La9:
            id.dana.domain.social.Result$Success r7 = new id.dana.domain.social.Result$Success
            id.dana.feeds.domain.synccontact.model.SyncResult r8 = new id.dana.feeds.domain.synccontact.model.SyncResult
            r8.<init>(r4)
            r7.<init>(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.runner.PartialSyncContactRunner.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.feeds.domain.runner.PartialSyncContactRunner, id.dana.domain.social.Result$Success, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean PlaceComponentResult() {
        return this.PlaceComponentResult == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.feeds.domain.runner.BaseSyncContactRunner
    public final Object BuiltInFictitiousFunctionClassFactory(Exception exc, Continuation<? super Result.Error> continuation) {
        if (exc instanceof FullSyncNotFinishedException) {
            return new Result.Error(exc);
        }
        return super.BuiltInFictitiousFunctionClassFactory(exc, continuation);
    }
}
