package id.dana.feeds.data.synccontact;

import android.database.Cursor;
import android.provider.ContactsContract;
import id.dana.data.account.AccountEntity;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.social.common.CursorExtensionKt;
import id.dana.data.social.model.FeedsContactEntity;
import id.dana.feeds.data.activation.source.FeedInitEntityData;
import id.dana.feeds.data.activation.source.FeedInitEntityDataFactory;
import id.dana.feeds.data.config.FeedsConfigEntityRepository;
import id.dana.feeds.data.config.source.FeedsConfigData;
import id.dana.feeds.data.mapper.SocialContactEntityMapperKt;
import id.dana.feeds.data.synccontact.source.FeedsLocalSyncEntityData;
import id.dana.feeds.data.synccontact.source.FeedsLocalSyncEntityDataFactory;
import id.dana.feeds.data.synccontact.source.FeedsSyncProcessEntityData;
import id.dana.feeds.data.synccontact.source.FeedsSyncProcessEntityDataFactory;
import id.dana.feeds.data.synccontact.source.network.NetworkSocialSyncProcessEntityData;
import id.dana.feeds.domain.synccontact.FeedsSyncContactRepository;
import id.dana.feeds.domain.synccontact.model.FeedsContact;
import id.dana.sendmoney.contact.provider.ContactProvider;
import io.reactivex.functions.Function;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\"\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020706\u0012\u0006\u0010\u0010\u001a\u00020 \u0012\u0006\u0010:\u001a\u00020)\u0012\u0006\u0010;\u001a\u000204\u0012\u0006\u0010<\u001a\u00020$\u0012\u0006\u0010=\u001a\u00020'¢\u0006\u0004\b>\u0010?J'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\t\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\fJ\u0013\u0010\u000e\u001a\u00020\rH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\fJ\u0013\u0010\u000f\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\fJ1\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\rH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\rH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\fJ\u0013\u0010\u0015\u001a\u0006*\u00020\r0\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0005\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\fJ\u001b\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\fJ\u001b\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\rH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013J#\u0010\t\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\rH\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u001eJ\u001b\u0010\u0011\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u001fJ!\u0010\t\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0006R\u0014\u0010\u001d\u001a\u00020 8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010!R\u0014\u0010\u0011\u001a\u00020\"8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010\t\u001a\u00020'8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010(R\u0014\u0010\u0005\u001a\u00020)8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010*R\u001a\u0010\u000f\u001a\u00020\r8\u0015X\u0095D¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b\u0005\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\r8\u0015X\u0095D¢\u0006\f\n\u0004\b\u0014\u0010,\u001a\u0004\b\u0011\u0010\u0016R\u001a\u0010+\u001a\u00020\r8\u0015X\u0095D¢\u0006\f\n\u0004\b\u000e\u0010,\u001a\u0004\b%\u0010\u0016R\u001a\u0010\u000e\u001a\u00020\r8\u0015X\u0095D¢\u0006\f\n\u0004\b\u000f\u0010,\u001a\u0004\b\u001d\u0010\u0016R\u0017\u0010\u0014\u001a\u0006*\u00020-0-X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010.R\u0013\u00100\u001a\u00020/X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010.R\u0013\u0010\u001c\u001a\u000201X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b2\u0010.R\u0013\u00102\u001a\u000203X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010.R\u001a\u0010\u001a\u001a\u00020\r8\u0015X\u0095D¢\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b+\u0010\u0016R\u0014\u0010\u0015\u001a\u0002048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001c\u00105R\u001a\u00108\u001a\b\u0012\u0004\u0012\u000207068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b8\u00109\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/feeds/data/synccontact/FeedsSyncContactEntityRepository;", "Lid/dana/feeds/domain/synccontact/FeedsSyncContactRepository;", "", "Lid/dana/feeds/domain/synccontact/model/FeedsContact;", "p0", "MyBillsEntityDataFactory", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "p1", "BuiltInFictitiousFunctionClassFactory", "(II)Ljava/lang/Object;", "", "()Ljava/lang/Object;", "", "moveToNextValue", "getErrorConfigVersion", "p2", "getAuthRequestContext", "(IILjava/lang/String;)Ljava/lang/Object;", "(Ljava/lang/String;)Ljava/lang/Object;", "lookAheadTest", "GetContactSyncConfig", "()Ljava/lang/String;", "scheduleImpl", "()Z", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "", "NetworkUserEntityData$$ExternalSyntheticLambda2", "KClassImpl$Data$declaredNonStaticMembers$2", "(ILjava/lang/String;)Ljava/lang/Object;", "(I)Ljava/lang/Object;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/feeds/data/synccontact/FeedsContactProvider;", "Lid/dana/feeds/data/synccontact/FeedsContactProvider;", "Lid/dana/feeds/data/activation/source/FeedInitEntityDataFactory;", "PlaceComponentResult", "Lid/dana/feeds/data/activation/source/FeedInitEntityDataFactory;", "Lid/dana/feeds/data/config/FeedsConfigEntityRepository;", "Lid/dana/feeds/data/config/FeedsConfigEntityRepository;", "Lid/dana/feeds/data/synccontact/source/FeedsLocalSyncEntityDataFactory;", "Lid/dana/feeds/data/synccontact/source/FeedsLocalSyncEntityDataFactory;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/String;", "Lid/dana/data/account/repository/source/AccountEntityData;", "Lkotlin/Lazy;", "Lid/dana/feeds/data/activation/source/FeedInitEntityData;", "initRecordTimeStamp", "Lid/dana/feeds/data/synccontact/source/FeedsLocalSyncEntityData;", "DatabaseTableConfigUtil", "Lid/dana/feeds/data/synccontact/source/FeedsSyncProcessEntityData;", "Lid/dana/feeds/data/synccontact/source/FeedsSyncProcessEntityDataFactory;", "Lid/dana/feeds/data/synccontact/source/FeedsSyncProcessEntityDataFactory;", "Ldagger/Lazy;", "Lid/dana/data/config/source/split/SplitConfigEntityData;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Ldagger/Lazy;", "p3", "p4", "p5", "p6", "<init>", "(Lid/dana/feeds/data/synccontact/FeedsContactProvider;Ldagger/Lazy;Lid/dana/data/account/repository/source/AccountEntityDataFactory;Lid/dana/feeds/data/synccontact/source/FeedsLocalSyncEntityDataFactory;Lid/dana/feeds/data/synccontact/source/FeedsSyncProcessEntityDataFactory;Lid/dana/feeds/data/activation/source/FeedInitEntityDataFactory;Lid/dana/feeds/data/config/FeedsConfigEntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public class FeedsSyncContactEntityRepository implements FeedsSyncContactRepository {
    private final FeedsConfigEntityRepository BuiltInFictitiousFunctionClassFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy DatabaseTableConfigUtil;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final FeedsLocalSyncEntityDataFactory MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final AccountEntityDataFactory KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final String getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Lazy initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final FeedsSyncProcessEntityDataFactory GetContactSyncConfig;
    private final dagger.Lazy<SplitConfigEntityData> NetworkUserEntityData$$ExternalSyntheticLambda8;
    private final FeedInitEntityDataFactory PlaceComponentResult;
    private final FeedsContactProvider getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final String moveToNextValue;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final String scheduleImpl;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy lookAheadTest;

    @Override // id.dana.feeds.domain.synccontact.FeedsSyncContactRepository
    public Object BuiltInFictitiousFunctionClassFactory(List<FeedsContact> list, Continuation<? super Integer> continuation) {
        return MyBillsEntityDataFactory(this, list, continuation);
    }

    @Override // id.dana.feeds.domain.synccontact.FeedsSyncContactRepository
    public Object MyBillsEntityDataFactory(List<FeedsContact> list, Continuation<? super List<FeedsContact>> continuation) {
        return KClassImpl$Data$declaredNonStaticMembers$2(this, list, continuation);
    }

    @Inject
    public FeedsSyncContactEntityRepository(FeedsContactProvider feedsContactProvider, dagger.Lazy<SplitConfigEntityData> lazy, AccountEntityDataFactory accountEntityDataFactory, FeedsLocalSyncEntityDataFactory feedsLocalSyncEntityDataFactory, FeedsSyncProcessEntityDataFactory feedsSyncProcessEntityDataFactory, FeedInitEntityDataFactory feedInitEntityDataFactory, FeedsConfigEntityRepository feedsConfigEntityRepository) {
        Intrinsics.checkNotNullParameter(feedsContactProvider, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(feedsLocalSyncEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(feedsSyncProcessEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(feedInitEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(feedsConfigEntityRepository, "");
        this.getAuthRequestContext = feedsContactProvider;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = lazy;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = accountEntityDataFactory;
        this.MyBillsEntityDataFactory = feedsLocalSyncEntityDataFactory;
        this.GetContactSyncConfig = feedsSyncProcessEntityDataFactory;
        this.PlaceComponentResult = feedInitEntityDataFactory;
        this.BuiltInFictitiousFunctionClassFactory = feedsConfigEntityRepository;
        this.getErrorConfigVersion = "first_time_init_feed";
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = "offset_at_specific_sync_time";
        this.moveToNextValue = "last_sync_contact_time";
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = "last_offset_sync_contact";
        this.scheduleImpl = "fullsync_finished";
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = LazyKt.lazy(new Function0<FeedsLocalSyncEntityData>() { // from class: id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository$localSocialSyncEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FeedsLocalSyncEntityData invoke() {
                FeedsLocalSyncEntityDataFactory feedsLocalSyncEntityDataFactory2;
                feedsLocalSyncEntityDataFactory2 = FeedsSyncContactEntityRepository.this.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullParameter("local", "");
                return feedsLocalSyncEntityDataFactory2.MyBillsEntityDataFactory;
            }
        });
        this.DatabaseTableConfigUtil = LazyKt.lazy(new Function0<FeedsSyncProcessEntityData>() { // from class: id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository$networkSocialSyncProcessEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FeedsSyncProcessEntityData invoke() {
                FeedsSyncProcessEntityDataFactory feedsSyncProcessEntityDataFactory2;
                feedsSyncProcessEntityDataFactory2 = FeedsSyncContactEntityRepository.this.GetContactSyncConfig;
                return new NetworkSocialSyncProcessEntityData(feedsSyncProcessEntityDataFactory2.getAuthRequestContext, feedsSyncProcessEntityDataFactory2.BuiltInFictitiousFunctionClassFactory, feedsSyncProcessEntityDataFactory2.PlaceComponentResult);
            }
        });
        this.lookAheadTest = LazyKt.lazy(new Function0<AccountEntityData>() { // from class: id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository$localAccountEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AccountEntityData invoke() {
                AccountEntityDataFactory accountEntityDataFactory2;
                accountEntityDataFactory2 = FeedsSyncContactEntityRepository.this.KClassImpl$Data$declaredNonStaticMembers$2;
                return accountEntityDataFactory2.createData2("local");
            }
        });
        this.initRecordTimeStamp = LazyKt.lazy(new Function0<FeedInitEntityData>() { // from class: id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository$localFeedInitEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FeedInitEntityData invoke() {
                FeedInitEntityDataFactory feedInitEntityDataFactory2;
                feedInitEntityDataFactory2 = FeedsSyncContactEntityRepository.this.PlaceComponentResult;
                return feedInitEntityDataFactory2.createData2("local");
            }
        });
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    protected String getGetErrorConfigVersion() {
        return this.getErrorConfigVersion;
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from getter */
    protected String getNetworkUserEntityData$$ExternalSyntheticLambda1() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    protected String getMoveToNextValue() {
        return this.moveToNextValue;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    protected String getNetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    protected String getScheduleImpl() {
        return this.scheduleImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object KClassImpl$Data$declaredNonStaticMembers$2(id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository r13, final java.util.List r14, kotlin.coroutines.Continuation r15) {
        /*
            boolean r0 = r15 instanceof id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository$filterDanaUser$1
            if (r0 == 0) goto L14
            r0 = r15
            id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository$filterDanaUser$1 r0 = (id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository$filterDanaUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r15 = r0.label
            int r15 = r15 + r2
            r0.label = r15
            goto L19
        L14:
            id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository$filterDanaUser$1 r0 = new id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository$filterDanaUser$1
            r0.<init>(r13, r15)
        L19:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r13 = r0.L$1
            r14 = r13
            java.util.List r14 = (java.util.List) r14
            java.lang.Object r13 = r0.L$0
            id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository r13 = (id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository) r13
            kotlin.ResultKt.throwOnFailure(r15)
            goto Ldc
        L34:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L3c:
            kotlin.ResultKt.throwOnFailure(r15)
            dagger.Lazy<id.dana.data.config.source.split.SplitConfigEntityData> r15 = r13.NetworkUserEntityData$$ExternalSyntheticLambda8
            java.lang.Object r15 = r15.get()
            id.dana.data.config.source.split.SplitConfigEntityData r15 = (id.dana.data.config.source.split.SplitConfigEntityData) r15
            io.reactivex.Observable r15 = r15.getSyncContactWithNameConfig()
            java.lang.Object r15 = r15.blockingFirst()
            id.dana.domain.synccontact.model.SyncContactSplitConfigModel r15 = (id.dana.domain.synccontact.model.SyncContactSplitConfigModel) r15
            boolean r2 = r15.getFeedSync()
            r4 = 10
            if (r2 == 0) goto L5e
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            goto L87
        L5e:
            r2 = r14
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r5 = new java.util.ArrayList
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r4)
            r5.<init>(r6)
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r2 = r2.iterator()
        L70:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L84
            java.lang.Object r6 = r2.next()
            id.dana.feeds.domain.synccontact.model.FeedsContact r6 = (id.dana.feeds.domain.synccontact.model.FeedsContact) r6
            java.lang.String r6 = r6.getPhoneNumber()
            r5.add(r6)
            goto L70
        L84:
            r2 = r5
            java.util.List r2 = (java.util.List) r2
        L87:
            boolean r15 = r15.getFeedSync()
            if (r15 == 0) goto Lc3
            r15 = r14
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.ArrayList r5 = new java.util.ArrayList
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r15, r4)
            r5.<init>(r4)
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r15 = r15.iterator()
        L9f:
            boolean r4 = r15.hasNext()
            if (r4 == 0) goto Lc0
            java.lang.Object r4 = r15.next()
            id.dana.feeds.domain.synccontact.model.FeedsContact r4 = (id.dana.feeds.domain.synccontact.model.FeedsContact) r4
            id.dana.domain.sendmoney.model.UserContact r12 = new id.dana.domain.sendmoney.model.UserContact
            java.lang.String r7 = r4.getPhoneNumber()
            java.lang.String r8 = r4.getDisplayName()
            r9 = 0
            r10 = 4
            r11 = 0
            r6 = r12
            r6.<init>(r7, r8, r9, r10, r11)
            r5.add(r12)
            goto L9f
        Lc0:
            java.util.List r5 = (java.util.List) r5
            goto Lc7
        Lc3:
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
        Lc7:
            kotlin.Lazy r15 = r13.DatabaseTableConfigUtil
            java.lang.Object r15 = r15.getValue()
            id.dana.feeds.data.synccontact.source.FeedsSyncProcessEntityData r15 = (id.dana.feeds.data.synccontact.source.FeedsSyncProcessEntityData) r15
            r0.L$0 = r13
            r0.L$1 = r14
            r0.label = r3
            java.lang.Object r15 = r15.getAuthRequestContext(r2, r5, r0)
            if (r15 != r1) goto Ldc
            return r1
        Ldc:
            id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository$filterContactToDanaUserOnly$1 r13 = new id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository$filterContactToDanaUserOnly$1
            r13.<init>()
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            java.lang.Object r13 = r13.invoke(r15)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object MyBillsEntityDataFactory(id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository r4, java.util.List r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository$syncContacts$1
            if (r0 == 0) goto L14
            r0 = r6
            id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository$syncContacts$1 r0 = (id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository$syncContacts$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository$syncContacts$1 r0 = new id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository$syncContacts$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.L$0
            r5 = r4
            java.util.List r5 = (java.util.List) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L69
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Lazy r6 = r4.lookAheadTest
            java.lang.Object r6 = r6.getValue()
            id.dana.data.account.repository.source.AccountEntityData r6 = (id.dana.data.account.repository.source.AccountEntityData) r6
            io.reactivex.Observable r6 = r6.hasAccount()
            java.lang.Object r6 = r6.blockingSingle()
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L80
            kotlin.Lazy r4 = r4.DatabaseTableConfigUtil
            java.lang.Object r4 = r4.getValue()
            id.dana.feeds.data.synccontact.source.FeedsSyncProcessEntityData r4 = (id.dana.feeds.data.synccontact.source.FeedsSyncProcessEntityData) r4
            java.util.List r6 = id.dana.feeds.data.mapper.SocialContactEntityMapperKt.PlaceComponentResult(r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.KClassImpl$Data$declaredNonStaticMembers$2(r6, r0)
            if (r6 != r1) goto L69
            return r1
        L69:
            id.dana.feeds.data.synccontact.source.network.response.FeedsSyncResponse r6 = (id.dana.feeds.data.synccontact.source.network.response.FeedsSyncResponse) r6
            boolean r4 = r6.success
            if (r4 == 0) goto L78
            int r4 = r5.size()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            return r4
        L78:
            id.dana.network.exception.NetworkException r4 = new id.dana.network.exception.NetworkException
            com.alipayplus.mobile.component.domain.model.result.BaseRpcResult r6 = (com.alipayplus.mobile.component.domain.model.result.BaseRpcResult) r6
            r4.<init>(r6)
            throw r4
        L80:
            id.dana.feeds.data.synccontact.exception.UserAccountNotFoundException r4 = new id.dana.feeds.data.synccontact.exception.UserAccountNotFoundException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository.MyBillsEntityDataFactory(id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // id.dana.feeds.domain.synccontact.FeedsSyncContactRepository
    public final boolean scheduleImpl() {
        return this.getAuthRequestContext.PlaceComponentResult();
    }

    public static /* synthetic */ String getAuthRequestContext(AccountEntity accountEntity) {
        Intrinsics.checkNotNullParameter(accountEntity, "");
        return accountEntity.getPhoneNumber();
    }

    private final String GetContactSyncConfig() {
        return (String) ((AccountEntityData) this.lookAheadTest.getValue()).getAccount().map(new Function() { // from class: id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsSyncContactEntityRepository.getAuthRequestContext((AccountEntity) obj);
            }
        }).blockingFirst();
    }

    @Override // id.dana.feeds.domain.synccontact.FeedsSyncContactRepository
    public final Object BuiltInFictitiousFunctionClassFactory(int p0, int p1) {
        List<FeedsContactEntity> emptyList;
        FeedsContactProvider feedsContactProvider = this.getAuthRequestContext;
        if (!feedsContactProvider.PlaceComponentResult() || FeedsContactProvider.KClassImpl$Data$declaredNonStaticMembers$2(p0)) {
            emptyList = CollectionsKt.emptyList();
        } else {
            String[] MyBillsEntityDataFactory = SocialSyncConstantKt.MyBillsEntityDataFactory();
            String[] strArr = {ContactProvider.Column.MIMETYPE_PHONENUMBER, "628%", "+628%", "08%"};
            String format = String.format(ContactProvider.SortOrder.SORT_ORDER_ASCENDING_WITH_LIMIT, Arrays.copyOf(new Object[]{ContactProvider.Column.CONTACT_RAW_ID, Integer.valueOf(p0), Integer.valueOf(p1)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "");
            Cursor query = feedsContactProvider.PlaceComponentResult.query(ContactsContract.Data.CONTENT_URI, MyBillsEntityDataFactory, "mimetype = ? AND (data1 LIKE ? OR data1 LIKE ? OR data1 LIKE ?)", strArr, format);
            if (query == null || (emptyList = CursorExtensionKt.getContactListFromCursor(query)) == null) {
                emptyList = CollectionsKt.emptyList();
            }
        }
        return SocialContactEntityMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(emptyList);
    }

    @Override // id.dana.feeds.domain.synccontact.FeedsSyncContactRepository
    public final Object BuiltInFictitiousFunctionClassFactory() {
        FeedsLocalSyncEntityData feedsLocalSyncEntityData = (FeedsLocalSyncEntityData) this.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue();
        String GetContactSyncConfig = GetContactSyncConfig();
        Intrinsics.checkNotNullExpressionValue(GetContactSyncConfig, "");
        return feedsLocalSyncEntityData.PlaceComponentResult(GetContactSyncConfig, getScheduleImpl());
    }

    @Override // id.dana.feeds.domain.synccontact.FeedsSyncContactRepository
    public final Object moveToNextValue() {
        FeedsLocalSyncEntityData feedsLocalSyncEntityData = (FeedsLocalSyncEntityData) this.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue();
        String GetContactSyncConfig = GetContactSyncConfig();
        Intrinsics.checkNotNullExpressionValue(GetContactSyncConfig, "");
        return feedsLocalSyncEntityData.BuiltInFictitiousFunctionClassFactory(GetContactSyncConfig, getMoveToNextValue());
    }

    @Override // id.dana.feeds.domain.synccontact.FeedsSyncContactRepository
    public final Object getErrorConfigVersion() {
        Integer blockingFirst = ((FeedsConfigData) this.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion.getValue()).KClassImpl$Data$declaredNonStaticMembers$2().blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        return blockingFirst;
    }

    @Override // id.dana.feeds.domain.synccontact.FeedsSyncContactRepository
    public final Object getAuthRequestContext(int p0, int p1, String p2) {
        List<FeedsContactEntity> emptyList;
        FeedsContactProvider feedsContactProvider = this.getAuthRequestContext;
        Intrinsics.checkNotNullParameter(p2, "");
        if (!feedsContactProvider.PlaceComponentResult() || FeedsContactProvider.KClassImpl$Data$declaredNonStaticMembers$2(p0, p2)) {
            emptyList = CollectionsKt.emptyList();
        } else {
            String[] MyBillsEntityDataFactory = SocialSyncConstantKt.MyBillsEntityDataFactory();
            String[] strArr = {ContactProvider.Column.MIMETYPE_PHONENUMBER, p2, "628%", "+628%", "08%"};
            String format = String.format(ContactProvider.SortOrder.SORT_ORDER_ASCENDING_WITH_LIMIT, Arrays.copyOf(new Object[]{ContactProvider.ColumnSpecial.LAST_UPDATED_TIME, Integer.valueOf(p0), Integer.valueOf(p1)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "");
            Cursor query = feedsContactProvider.PlaceComponentResult.query(ContactsContract.Data.CONTENT_URI, MyBillsEntityDataFactory, "mimetype = ? AND contact_last_updated_timestamp > ? AND (data1 LIKE ? OR data1 LIKE ? OR data1 LIKE ?)", strArr, format);
            if (query == null || (emptyList = CursorExtensionKt.getContactListFromCursor(query)) == null) {
                emptyList = CollectionsKt.emptyList();
            }
        }
        return SocialContactEntityMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(emptyList);
    }

    @Override // id.dana.feeds.domain.synccontact.FeedsSyncContactRepository
    public final Object MyBillsEntityDataFactory(String p0) {
        FeedsLocalSyncEntityData feedsLocalSyncEntityData = (FeedsLocalSyncEntityData) this.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue();
        String GetContactSyncConfig = GetContactSyncConfig();
        Intrinsics.checkNotNullExpressionValue(GetContactSyncConfig, "");
        return feedsLocalSyncEntityData.getAuthRequestContext(p0, GetContactSyncConfig, getNetworkUserEntityData$$ExternalSyntheticLambda1());
    }

    @Override // id.dana.feeds.domain.synccontact.FeedsSyncContactRepository
    public final Object lookAheadTest() {
        FeedsLocalSyncEntityData feedsLocalSyncEntityData = (FeedsLocalSyncEntityData) this.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue();
        String GetContactSyncConfig = GetContactSyncConfig();
        Intrinsics.checkNotNullExpressionValue(GetContactSyncConfig, "");
        return feedsLocalSyncEntityData.MyBillsEntityDataFactory(GetContactSyncConfig, getNetworkUserEntityData$$ExternalSyntheticLambda0());
    }

    @Override // id.dana.feeds.domain.synccontact.FeedsSyncContactRepository
    public Object MyBillsEntityDataFactory(Continuation<? super Boolean> continuation) {
        return this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(continuation);
    }

    @Override // id.dana.feeds.domain.synccontact.FeedsSyncContactRepository
    public Object NetworkUserEntityData$$ExternalSyntheticLambda1() {
        FeedInitEntityData feedInitEntityData = (FeedInitEntityData) this.initRecordTimeStamp.getValue();
        String GetContactSyncConfig = GetContactSyncConfig();
        Intrinsics.checkNotNullExpressionValue(GetContactSyncConfig, "");
        return Boxing.boxBoolean(feedInitEntityData.getAuthRequestContext(GetContactSyncConfig, getGetErrorConfigVersion()));
    }

    @Override // id.dana.feeds.domain.synccontact.FeedsSyncContactRepository
    public final Object NetworkUserEntityData$$ExternalSyntheticLambda2() {
        FeedsLocalSyncEntityData feedsLocalSyncEntityData = (FeedsLocalSyncEntityData) this.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue();
        String GetContactSyncConfig = GetContactSyncConfig();
        Intrinsics.checkNotNullExpressionValue(GetContactSyncConfig, "");
        Object authRequestContext = feedsLocalSyncEntityData.getAuthRequestContext(GetContactSyncConfig, getScheduleImpl());
        return authRequestContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? authRequestContext : Unit.INSTANCE;
    }

    @Override // id.dana.feeds.domain.synccontact.FeedsSyncContactRepository
    public final Object KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        FeedsLocalSyncEntityData feedsLocalSyncEntityData = (FeedsLocalSyncEntityData) this.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue();
        String GetContactSyncConfig = GetContactSyncConfig();
        Intrinsics.checkNotNullExpressionValue(GetContactSyncConfig, "");
        Object KClassImpl$Data$declaredNonStaticMembers$2 = feedsLocalSyncEntityData.KClassImpl$Data$declaredNonStaticMembers$2(p0, GetContactSyncConfig, getMoveToNextValue());
        return KClassImpl$Data$declaredNonStaticMembers$2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? KClassImpl$Data$declaredNonStaticMembers$2 : Unit.INSTANCE;
    }

    @Override // id.dana.feeds.domain.synccontact.FeedsSyncContactRepository
    public final Object BuiltInFictitiousFunctionClassFactory(int p0, String p1) {
        FeedsLocalSyncEntityData feedsLocalSyncEntityData = (FeedsLocalSyncEntityData) this.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue();
        String GetContactSyncConfig = GetContactSyncConfig();
        Intrinsics.checkNotNullExpressionValue(GetContactSyncConfig, "");
        Object MyBillsEntityDataFactory = feedsLocalSyncEntityData.MyBillsEntityDataFactory(p0, p1, GetContactSyncConfig, getNetworkUserEntityData$$ExternalSyntheticLambda1());
        return MyBillsEntityDataFactory == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? MyBillsEntityDataFactory : Unit.INSTANCE;
    }

    @Override // id.dana.feeds.domain.synccontact.FeedsSyncContactRepository
    public final Object getAuthRequestContext(int p0) {
        FeedsLocalSyncEntityData feedsLocalSyncEntityData = (FeedsLocalSyncEntityData) this.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue();
        String GetContactSyncConfig = GetContactSyncConfig();
        Intrinsics.checkNotNullExpressionValue(GetContactSyncConfig, "");
        Object authRequestContext = feedsLocalSyncEntityData.getAuthRequestContext(p0, GetContactSyncConfig, getNetworkUserEntityData$$ExternalSyntheticLambda0());
        return authRequestContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? authRequestContext : Unit.INSTANCE;
    }
}
