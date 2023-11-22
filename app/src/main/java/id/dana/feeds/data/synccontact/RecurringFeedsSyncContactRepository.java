package id.dana.feeds.data.synccontact;

import dagger.Lazy;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.feeds.data.activation.source.FeedInitEntityDataFactory;
import id.dana.feeds.data.config.FeedsConfigEntityRepository;
import id.dana.feeds.data.config.source.FeedsConfigData;
import id.dana.feeds.data.synccontact.source.FeedsLocalSyncEntityDataFactory;
import id.dana.feeds.data.synccontact.source.FeedsSyncProcessEntityDataFactory;
import id.dana.feeds.domain.synccontact.model.FeedsContact;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0018\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010$\u001a\u00020\r¢\u0006\u0004\b%\u0010&J'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0005\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\bJ\u0013\u0010\t\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ!\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0015X\u0094D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0005\u0010\u0013R\u001a\u0010\f\u001a\u00020\u00108\u0015X\u0095D¢\u0006\f\n\u0004\b\u0014\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00108\u0015X\u0095D¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u00108\u0015X\u0095D¢\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u000e\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u00108\u0015X\u0095D¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/feeds/data/synccontact/RecurringFeedsSyncContactRepository;", "Lid/dana/feeds/data/synccontact/FeedsSyncContactEntityRepository;", "", "Lid/dana/feeds/domain/synccontact/model/FeedsContact;", "p0", "MyBillsEntityDataFactory", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "()Ljava/lang/Object;", "", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/feeds/data/config/FeedsConfigEntityRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/data/config/FeedsConfigEntityRepository;", "", "getAuthRequestContext", "Ljava/lang/String;", "()Ljava/lang/String;", "PlaceComponentResult", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "Lid/dana/feeds/data/synccontact/FeedsContactProvider;", "Ldagger/Lazy;", "Lid/dana/data/config/source/split/SplitConfigEntityData;", "p1", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "p2", "Lid/dana/feeds/data/synccontact/source/FeedsLocalSyncEntityDataFactory;", "p3", "Lid/dana/feeds/data/synccontact/source/FeedsSyncProcessEntityDataFactory;", "p4", "Lid/dana/feeds/data/activation/source/FeedInitEntityDataFactory;", "p5", "p6", "<init>", "(Lid/dana/feeds/data/synccontact/FeedsContactProvider;Ldagger/Lazy;Lid/dana/data/account/repository/source/AccountEntityDataFactory;Lid/dana/feeds/data/synccontact/source/FeedsLocalSyncEntityDataFactory;Lid/dana/feeds/data/synccontact/source/FeedsSyncProcessEntityDataFactory;Lid/dana/feeds/data/activation/source/FeedInitEntityDataFactory;Lid/dana/feeds/data/config/FeedsConfigEntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RecurringFeedsSyncContactRepository extends FeedsSyncContactEntityRepository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final String MyBillsEntityDataFactory;
    private final FeedsConfigEntityRepository KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final String PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final String BuiltInFictitiousFunctionClassFactory;
    private final String getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final String getErrorConfigVersion;

    @Override // id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository, id.dana.feeds.domain.synccontact.FeedsSyncContactRepository
    public final Object MyBillsEntityDataFactory(List<FeedsContact> list, Continuation<? super List<FeedsContact>> continuation) {
        return list;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public RecurringFeedsSyncContactRepository(FeedsContactProvider feedsContactProvider, Lazy<SplitConfigEntityData> lazy, AccountEntityDataFactory accountEntityDataFactory, FeedsLocalSyncEntityDataFactory feedsLocalSyncEntityDataFactory, FeedsSyncProcessEntityDataFactory feedsSyncProcessEntityDataFactory, FeedInitEntityDataFactory feedInitEntityDataFactory, FeedsConfigEntityRepository feedsConfigEntityRepository) {
        super(feedsContactProvider, lazy, accountEntityDataFactory, feedsLocalSyncEntityDataFactory, feedsSyncProcessEntityDataFactory, feedInitEntityDataFactory, feedsConfigEntityRepository);
        Intrinsics.checkNotNullParameter(feedsContactProvider, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(feedsLocalSyncEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(feedsSyncProcessEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(feedInitEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(feedsConfigEntityRepository, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = feedsConfigEntityRepository;
        this.getAuthRequestContext = "save_contact_first_time_init_feed";
        this.getErrorConfigVersion = "save_contact_offset_at_specific_sync_time";
        this.MyBillsEntityDataFactory = "save_contact_last_sync_contact_time";
        this.PlaceComponentResult = "save_contact_last_offset_sync_contact";
        this.BuiltInFictitiousFunctionClassFactory = "save_contact_fullsync_finished";
    }

    @Override // id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository
    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    protected final String getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Override // id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository
    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from getter */
    protected final String getGetErrorConfigVersion() {
        return this.getErrorConfigVersion;
    }

    @Override // id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    protected final String getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository
    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    protected final String getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository
    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    protected final String getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository, id.dana.feeds.domain.synccontact.FeedsSyncContactRepository
    public final Object BuiltInFictitiousFunctionClassFactory(List<FeedsContact> list, Continuation<? super Integer> continuation) {
        list.size();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            FeedsContact feedsContact = list.get(i);
            feedsContact.getDisplayName();
            feedsContact.getPhoneNumber();
        }
        return Boxing.boxInt(list.size());
    }

    @Override // id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository, id.dana.feeds.domain.synccontact.FeedsSyncContactRepository
    public final Object MyBillsEntityDataFactory(Continuation<? super Boolean> continuation) {
        Boolean blockingFirst = ((FeedsConfigData) this.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.getValue()).moveToNextValue().blockingFirst();
        return Boxing.boxBoolean(blockingFirst == null ? false : blockingFirst.booleanValue());
    }

    @Override // id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository, id.dana.feeds.domain.synccontact.FeedsSyncContactRepository
    public final Object NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return Boxing.boxBoolean(true);
    }
}
