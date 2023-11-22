package id.dana.feeds.domain.runner;

import id.dana.domain.social.FullSyncHasFinishedException;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u0003\u001a\u00020\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0004J\u0013\u0010\t\u001a\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0004J\u001f\u0010\u000e\u001a\u00020\r2\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0094@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u0002H\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/feeds/domain/runner/FullSyncContactRunner;", "Lid/dana/feeds/domain/runner/BaseSyncContactRunner;", "", "getAuthRequestContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lid/dana/feeds/domain/synccontact/model/FeedsContact;", "MyBillsEntityDataFactory", "", "PlaceComponentResult", "Ljava/lang/Exception;", "Lkotlin/Exception;", "p0", "Lid/dana/domain/social/Result$Error;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/domain/social/Result$Success;", "", "Lid/dana/domain/social/Result;", "Lid/dana/feeds/domain/synccontact/model/SyncResult;", "(Lid/dana/domain/social/Result$Success;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "Lid/dana/feeds/domain/synccontact/FeedsSyncContactRepository;", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "p1", "<init>", "(Lid/dana/feeds/domain/synccontact/FeedsSyncContactRepository;Lid/dana/feeds/domain/activation/FeedInitRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public class FullSyncContactRunner extends BaseSyncContactRunner {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private int BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.feeds.domain.runner.BaseSyncContactRunner
    public final Object KClassImpl$Data$declaredNonStaticMembers$2(Continuation<? super Unit> continuation) {
        return BuiltInFictitiousFunctionClassFactory(this, (Continuation) continuation);
    }

    @Override // id.dana.feeds.domain.runner.BaseSyncContactRunner
    public final Object MyBillsEntityDataFactory(Continuation<? super List<FeedsContact>> continuation) {
        return KClassImpl$Data$declaredNonStaticMembers$2(this, (Continuation) continuation);
    }

    @Override // id.dana.feeds.domain.runner.BaseSyncContactRunner
    public final Object getAuthRequestContext(Result.Success<Integer> success, Continuation<? super Result<SyncResult>> continuation) {
        return PlaceComponentResult(this, success, continuation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullSyncContactRunner(FeedsSyncContactRepository feedsSyncContactRepository, FeedInitRepository feedInitRepository) {
        super(feedsSyncContactRepository, feedInitRepository);
        Intrinsics.checkNotNullParameter(feedsSyncContactRepository, "");
        Intrinsics.checkNotNullParameter(feedInitRepository, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0097 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object BuiltInFictitiousFunctionClassFactory(id.dana.feeds.domain.runner.FullSyncContactRunner r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof id.dana.feeds.domain.runner.FullSyncContactRunner$onSyncStarting$1
            if (r0 == 0) goto L14
            r0 = r8
            id.dana.feeds.domain.runner.FullSyncContactRunner$onSyncStarting$1 r0 = (id.dana.feeds.domain.runner.FullSyncContactRunner$onSyncStarting$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 + r2
            r0.label = r8
            goto L19
        L14:
            id.dana.feeds.domain.runner.FullSyncContactRunner$onSyncStarting$1 r0 = new id.dana.feeds.domain.runner.FullSyncContactRunner$onSyncStarting$1
            r0.<init>(r7, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L53
            if (r2 == r6) goto L4b
            if (r2 == r5) goto L43
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            kotlin.ResultKt.throwOnFailure(r8)
            goto L98
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            java.lang.Object r7 = r0.L$0
            id.dana.feeds.domain.runner.FullSyncContactRunner r7 = (id.dana.feeds.domain.runner.FullSyncContactRunner) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L8c
        L43:
            java.lang.Object r7 = r0.L$0
            id.dana.feeds.domain.runner.FullSyncContactRunner r7 = (id.dana.feeds.domain.runner.FullSyncContactRunner) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6c
        L4b:
            java.lang.Object r7 = r0.L$0
            id.dana.feeds.domain.runner.FullSyncContactRunner r7 = (id.dana.feeds.domain.runner.FullSyncContactRunner) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L61
        L53:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r7
            r0.label = r6
            java.lang.Object r8 = r7.getAuthRequestContext(r0)
            if (r8 != r1) goto L61
            return r1
        L61:
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r8 = r7.PlaceComponentResult(r0)
            if (r8 != r1) goto L6c
            return r1
        L6c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L8c
            r0.L$0 = r7
            r0.label = r4
            id.dana.feeds.domain.activation.FeedInitRepository r8 = r7.getBuiltInFictitiousFunctionClassFactory()
            java.lang.Object r8 = r8.getAuthRequestContext(r0)
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r8 != r2) goto L87
            goto L89
        L87:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
        L89:
            if (r8 != r1) goto L8c
            return r1
        L8c:
            r8 = 0
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = super.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            if (r7 != r1) goto L98
            return r1
        L98:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.runner.FullSyncContactRunner.BuiltInFictitiousFunctionClassFactory(id.dana.feeds.domain.runner.FullSyncContactRunner, kotlin.coroutines.Continuation):java.lang.Object");
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
            boolean r0 = r5 instanceof id.dana.feeds.domain.runner.FullSyncContactRunner$needFirstTimeInitFeed$1
            if (r0 == 0) goto L14
            r0 = r5
            id.dana.feeds.domain.runner.FullSyncContactRunner$needFirstTimeInitFeed$1 r0 = (id.dana.feeds.domain.runner.FullSyncContactRunner$needFirstTimeInitFeed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 + r2
            r0.label = r5
            goto L19
        L14:
            id.dana.feeds.domain.runner.FullSyncContactRunner$needFirstTimeInitFeed$1 r0 = new id.dana.feeds.domain.runner.FullSyncContactRunner$needFirstTimeInitFeed$1
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
            java.lang.Object r5 = r5.NetworkUserEntityData$$ExternalSyntheticLambda1()
            if (r5 != r1) goto L42
            return r1
        L42:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            r5 = r5 ^ r3
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.runner.FullSyncContactRunner.PlaceComponentResult(kotlin.coroutines.Continuation):java.lang.Object");
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
    public final java.lang.Object getAuthRequestContext(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof id.dana.feeds.domain.runner.FullSyncContactRunner$cancelSyncIfFullSyncFinished$1
            if (r0 == 0) goto L14
            r0 = r5
            id.dana.feeds.domain.runner.FullSyncContactRunner$cancelSyncIfFullSyncFinished$1 r0 = (id.dana.feeds.domain.runner.FullSyncContactRunner$cancelSyncIfFullSyncFinished$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 + r2
            r0.label = r5
            goto L19
        L14:
            id.dana.feeds.domain.runner.FullSyncContactRunner$cancelSyncIfFullSyncFinished$1 r0 = new id.dana.feeds.domain.runner.FullSyncContactRunner$cancelSyncIfFullSyncFinished$1
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
            if (r5 != 0) goto L4d
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L4d:
            id.dana.domain.social.FullSyncHasFinishedException r5 = new id.dana.domain.social.FullSyncHasFinishedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.runner.FullSyncContactRunner.getAuthRequestContext(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object KClassImpl$Data$declaredNonStaticMembers$2(id.dana.feeds.domain.runner.FullSyncContactRunner r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof id.dana.feeds.domain.runner.FullSyncContactRunner$getContactToBeSynched$1
            if (r0 == 0) goto L14
            r0 = r8
            id.dana.feeds.domain.runner.FullSyncContactRunner$getContactToBeSynched$1 r0 = (id.dana.feeds.domain.runner.FullSyncContactRunner$getContactToBeSynched$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 + r2
            r0.label = r8
            goto L19
        L14:
            id.dana.feeds.domain.runner.FullSyncContactRunner$getContactToBeSynched$1 r0 = new id.dana.feeds.domain.runner.FullSyncContactRunner$getContactToBeSynched$1
            r0.<init>(r7, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L5c
            if (r2 == r5) goto L4d
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            int r7 = r0.I$0
            java.lang.Object r0 = r0.L$0
            id.dana.feeds.domain.runner.FullSyncContactRunner r0 = (id.dana.feeds.domain.runner.FullSyncContactRunner) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto La3
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            int r7 = r0.I$0
            java.lang.Object r2 = r0.L$1
            id.dana.feeds.domain.synccontact.FeedsSyncContactRepository r2 = (id.dana.feeds.domain.synccontact.FeedsSyncContactRepository) r2
            java.lang.Object r4 = r0.L$0
            id.dana.feeds.domain.runner.FullSyncContactRunner r4 = (id.dana.feeds.domain.runner.FullSyncContactRunner) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L8c
        L4d:
            java.lang.Object r7 = r0.L$1
            id.dana.feeds.domain.synccontact.FeedsSyncContactRepository r7 = (id.dana.feeds.domain.synccontact.FeedsSyncContactRepository) r7
            java.lang.Object r2 = r0.L$0
            id.dana.feeds.domain.runner.FullSyncContactRunner r2 = (id.dana.feeds.domain.runner.FullSyncContactRunner) r2
            kotlin.ResultKt.throwOnFailure(r8)
            r6 = r2
            r2 = r7
            r7 = r6
            goto L73
        L5c:
            kotlin.ResultKt.throwOnFailure(r8)
            id.dana.feeds.domain.synccontact.FeedsSyncContactRepository r8 = r7.getGetAuthRequestContext()
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r5
            java.lang.Object r2 = r8.lookAheadTest()
            if (r2 != r1) goto L70
            return r1
        L70:
            r6 = r2
            r2 = r8
            r8 = r6
        L73:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r0.L$0 = r7
            r0.L$1 = r2
            r0.I$0 = r8
            r0.label = r4
            java.lang.Object r4 = r2.getErrorConfigVersion()
            if (r4 != r1) goto L88
            return r1
        L88:
            r6 = r4
            r4 = r7
            r7 = r8
            r8 = r6
        L8c:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r0.L$0 = r4
            r5 = 0
            r0.L$1 = r5
            r0.I$0 = r7
            r0.label = r3
            java.lang.Object r8 = r2.BuiltInFictitiousFunctionClassFactory(r8, r7)
            if (r8 != r1) goto La2
            return r1
        La2:
            r0 = r4
        La3:
            java.util.List r8 = (java.util.List) r8
            int r1 = r8.size()
            int r7 = r7 + r1
            r0.BuiltInFictitiousFunctionClassFactory = r7
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.runner.FullSyncContactRunner.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.feeds.domain.runner.FullSyncContactRunner, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object PlaceComponentResult(id.dana.feeds.domain.runner.FullSyncContactRunner r5, id.dana.domain.social.Result.Success r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof id.dana.feeds.domain.runner.FullSyncContactRunner$onSyncContactSuccess$1
            if (r0 == 0) goto L14
            r0 = r7
            id.dana.feeds.domain.runner.FullSyncContactRunner$onSyncContactSuccess$1 r0 = (id.dana.feeds.domain.runner.FullSyncContactRunner$onSyncContactSuccess$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            id.dana.feeds.domain.runner.FullSyncContactRunner$onSyncContactSuccess$1 r0 = new id.dana.feeds.domain.runner.FullSyncContactRunner$onSyncContactSuccess$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r5 = r0.L$1
            id.dana.domain.social.Result$Success r5 = (id.dana.domain.social.Result.Success) r5
            java.lang.Object r6 = r0.L$0
            id.dana.feeds.domain.runner.FullSyncContactRunner r6 = (id.dana.feeds.domain.runner.FullSyncContactRunner) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L93
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            id.dana.domain.social.Result$Success r6 = (id.dana.domain.social.Result.Success) r6
            java.lang.Object r5 = r0.L$0
            id.dana.feeds.domain.runner.FullSyncContactRunner r5 = (id.dana.feeds.domain.runner.FullSyncContactRunner) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L69
        L4a:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            id.dana.feeds.domain.synccontact.FeedsSyncContactRepository r7 = r5.getGetAuthRequestContext()
            int r2 = r5.BuiltInFictitiousFunctionClassFactory
            java.lang.Object r7 = r7.getAuthRequestContext(r2)
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r7 != r2) goto L64
            goto L66
        L64:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
        L66:
            if (r7 != r1) goto L69
            return r1
        L69:
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r6.getData()
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            if (r7 != 0) goto L8d
            id.dana.feeds.domain.synccontact.FeedsSyncContactRepository r5 = r5.getGetAuthRequestContext()
            java.lang.Object r5 = r5.NetworkUserEntityData$$ExternalSyntheticLambda2()
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r5 != r7) goto L8a
            goto L8f
        L8a:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            goto L8f
        L8d:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
        L8f:
            if (r5 != r1) goto L92
            return r1
        L92:
            r5 = r6
        L93:
            java.lang.Object r5 = r5.getData()
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            if (r5 == 0) goto La0
            goto La1
        La0:
            r4 = 0
        La1:
            id.dana.domain.social.Result$Success r5 = new id.dana.domain.social.Result$Success
            id.dana.feeds.domain.synccontact.model.SyncResult r6 = new id.dana.feeds.domain.synccontact.model.SyncResult
            r6.<init>(r4)
            r5.<init>(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.runner.FullSyncContactRunner.PlaceComponentResult(id.dana.feeds.domain.runner.FullSyncContactRunner, id.dana.domain.social.Result$Success, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.feeds.domain.runner.BaseSyncContactRunner
    public final Object BuiltInFictitiousFunctionClassFactory(Exception exc, Continuation<? super Result.Error> continuation) {
        if (exc instanceof FullSyncHasFinishedException) {
            return new Result.Error(exc);
        }
        return super.BuiltInFictitiousFunctionClassFactory(exc, continuation);
    }
}
