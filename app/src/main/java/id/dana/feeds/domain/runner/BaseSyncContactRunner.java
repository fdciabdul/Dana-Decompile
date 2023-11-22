package id.dana.feeds.domain.runner;

import id.dana.domain.social.InitStatus;
import id.dana.domain.social.Result;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.feeds.domain.synccontact.FeedsSyncContactRepository;
import id.dana.feeds.domain.synccontact.SyncRunner;
import id.dana.feeds.domain.synccontact.model.FeedsContact;
import id.dana.feeds.domain.synccontact.model.SyncResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u0019¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u0003\u001a\u00020\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\bJ\u0013\u0010\u0007\u001a\u00020\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\tJ\u0013\u0010\n\u001a\u00020\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\bJ\u001f\u0010\u000f\u001a\u00020\u000e2\n\u0010\r\u001a\u00060\u000bj\u0002`\fH\u0094@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H¦@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0015J\u0013\u0010\u0017\u001a\u00020\u0016H\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\bJ!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\r\u001a\u00020\u0012H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\bJ'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u00198\u0005X\u0084\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u000f\u0010\u001bR\u001a\u0010\n\u001a\u00020\u001c8\u0005X\u0085\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\n\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/feeds/domain/runner/BaseSyncContactRunner;", "Lid/dana/feeds/domain/synccontact/SyncRunner;", "", "PlaceComponentResult", "()Z", "", "Lid/dana/feeds/domain/synccontact/model/FeedsContact;", "MyBillsEntityDataFactory", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "()Ljava/lang/Object;", "getAuthRequestContext", "Ljava/lang/Exception;", "Lkotlin/Exception;", "p0", "Lid/dana/domain/social/Result$Error;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/domain/social/Result$Success;", "", "Lid/dana/domain/social/Result;", "Lid/dana/feeds/domain/synccontact/model/SyncResult;", "(Lid/dana/domain/social/Result$Success;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "()Lid/dana/feeds/domain/activation/FeedInitRepository;", "Lid/dana/feeds/domain/synccontact/FeedsSyncContactRepository;", "Lid/dana/feeds/domain/synccontact/FeedsSyncContactRepository;", "()Lid/dana/feeds/domain/synccontact/FeedsSyncContactRepository;", "p1", "<init>", "(Lid/dana/feeds/domain/synccontact/FeedsSyncContactRepository;Lid/dana/feeds/domain/activation/FeedInitRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseSyncContactRunner implements SyncRunner {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final FeedsSyncContactRepository getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FeedInitRepository BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.feeds.domain.synccontact.SyncRunner
    public final Object BuiltInFictitiousFunctionClassFactory(Continuation<? super Result<SyncResult>> p0) {
        return BuiltInFictitiousFunctionClassFactory(this, p0);
    }

    public abstract Object MyBillsEntityDataFactory(Continuation<? super List<FeedsContact>> continuation);

    public abstract Object getAuthRequestContext(Result.Success<Integer> success, Continuation<? super Result<SyncResult>> continuation);

    public BaseSyncContactRunner(FeedsSyncContactRepository feedsSyncContactRepository, FeedInitRepository feedInitRepository) {
        Intrinsics.checkNotNullParameter(feedsSyncContactRepository, "");
        Intrinsics.checkNotNullParameter(feedInitRepository, "");
        this.getAuthRequestContext = feedsSyncContactRepository;
        this.BuiltInFictitiousFunctionClassFactory = feedInitRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final FeedsSyncContactRepository getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final FeedInitRepository getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|63|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d7, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d8, code lost:
    
        r2 = r7;
        r7 = r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0089 A[Catch: Exception -> 0x00d7, TryCatch #2 {Exception -> 0x00d7, blocks: (B:14:0x0036, B:53:0x00cc, B:27:0x0066, B:41:0x0095, B:30:0x006e, B:36:0x0081, B:38:0x0089, B:55:0x00d1, B:56:0x00d6, B:33:0x0075), top: B:68:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ca A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d1 A[Catch: Exception -> 0x00d7, TryCatch #2 {Exception -> 0x00d7, blocks: (B:14:0x0036, B:53:0x00cc, B:27:0x0066, B:41:0x0095, B:30:0x006e, B:36:0x0081, B:38:0x0089, B:55:0x00d1, B:56:0x00d6, B:33:0x0075), top: B:68:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e9 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object BuiltInFictitiousFunctionClassFactory(id.dana.feeds.domain.runner.BaseSyncContactRunner r7, kotlin.coroutines.Continuation r8) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.runner.BaseSyncContactRunner.BuiltInFictitiousFunctionClassFactory(id.dana.feeds.domain.runner.BaseSyncContactRunner, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAuthRequestContext(java.util.List<id.dana.feeds.domain.synccontact.model.FeedsContact> r7, kotlin.coroutines.Continuation<? super id.dana.domain.social.Result.Success<java.lang.Integer>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof id.dana.feeds.domain.runner.BaseSyncContactRunner$syncContacts$1
            if (r0 == 0) goto L14
            r0 = r8
            id.dana.feeds.domain.runner.BaseSyncContactRunner$syncContacts$1 r0 = (id.dana.feeds.domain.runner.BaseSyncContactRunner$syncContacts$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 + r2
            r0.label = r8
            goto L19
        L14:
            id.dana.feeds.domain.runner.BaseSyncContactRunner$syncContacts$1 r0 = new id.dana.feeds.domain.runner.BaseSyncContactRunner$syncContacts$1
            r0.<init>(r6, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6f
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            java.lang.Object r7 = r0.L$0
            id.dana.feeds.domain.synccontact.FeedsSyncContactRepository r7 = (id.dana.feeds.domain.synccontact.FeedsSyncContactRepository) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L61
        L3d:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = r7.isEmpty()
            if (r8 == 0) goto L51
            id.dana.domain.social.Result$Success r7 = new id.dana.domain.social.Result$Success
            r8 = 0
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            r7.<init>(r8)
            return r7
        L51:
            id.dana.feeds.domain.synccontact.FeedsSyncContactRepository r8 = r6.getAuthRequestContext
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r7 = r8.MyBillsEntityDataFactory(r7, r0)
            if (r7 != r1) goto L5e
            return r1
        L5e:
            r5 = r8
            r8 = r7
            r7 = r5
        L61:
            java.util.List r8 = (java.util.List) r8
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r8 = r7.BuiltInFictitiousFunctionClassFactory(r8, r0)
            if (r8 != r1) goto L6f
            return r1
        L6f:
            id.dana.domain.social.Result$Success r7 = new id.dana.domain.social.Result$Success
            r7.<init>(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.runner.BaseSyncContactRunner.getAuthRequestContext(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAuthRequestContext(kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof id.dana.feeds.domain.runner.BaseSyncContactRunner$isUnableToSync$1
            if (r0 == 0) goto L14
            r0 = r6
            id.dana.feeds.domain.runner.BaseSyncContactRunner$isUnableToSync$1 r0 = (id.dana.feeds.domain.runner.BaseSyncContactRunner$isUnableToSync$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            id.dana.feeds.domain.runner.BaseSyncContactRunner$isUnableToSync$1 r0 = new id.dana.feeds.domain.runner.BaseSyncContactRunner$isUnableToSync$1
            r0.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r6)
            goto L66
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            java.lang.Object r2 = r0.L$0
            id.dana.feeds.domain.runner.BaseSyncContactRunner r2 = (id.dana.feeds.domain.runner.BaseSyncContactRunner) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L52
        L3d:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5.PlaceComponentResult()
            if (r6 != 0) goto L67
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.PlaceComponentResult(r0)
            if (r6 != r1) goto L51
            return r1
        L51:
            r2 = r5
        L52:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L67
            r6 = 0
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r6 = r2.MyBillsEntityDataFactory()
            if (r6 != r1) goto L66
            return r1
        L66:
            return r6
        L67:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.runner.BaseSyncContactRunner.getAuthRequestContext(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object PlaceComponentResult(kotlin.coroutines.Continuation<? super java.lang.Boolean> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof id.dana.feeds.domain.runner.BaseSyncContactRunner$isContactSyncConfigDisabled$1
            if (r0 == 0) goto L14
            r0 = r5
            id.dana.feeds.domain.runner.BaseSyncContactRunner$isContactSyncConfigDisabled$1 r0 = (id.dana.feeds.domain.runner.BaseSyncContactRunner$isContactSyncConfigDisabled$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 + r2
            r0.label = r5
            goto L19
        L14:
            id.dana.feeds.domain.runner.BaseSyncContactRunner$isContactSyncConfigDisabled$1 r0 = new id.dana.feeds.domain.runner.BaseSyncContactRunner$isContactSyncConfigDisabled$1
            r0.<init>(r4, r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L40
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            id.dana.feeds.domain.synccontact.FeedsSyncContactRepository r5 = r4.getAuthRequestContext
            r0.label = r3
            java.lang.Object r5 = r5.MyBillsEntityDataFactory(r0)
            if (r5 != r1) goto L40
            return r1
        L40:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            r5 = r5 ^ r3
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.runner.BaseSyncContactRunner.PlaceComponentResult(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object MyBillsEntityDataFactory() {
        return Boxing.boxBoolean(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0().blockingFirst().getStatus() != InitStatus.FINISH);
    }

    private final boolean PlaceComponentResult() {
        return !this.getAuthRequestContext.scheduleImpl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object BuiltInFictitiousFunctionClassFactory(Exception exc, Continuation<? super Result.Error> continuation) {
        return new Result.Error(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object KClassImpl$Data$declaredNonStaticMembers$2(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}
