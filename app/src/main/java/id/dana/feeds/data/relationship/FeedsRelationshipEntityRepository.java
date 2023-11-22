package id.dana.feeds.data.relationship;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.social.repository.source.persistence.entity.FollowerEntity;
import id.dana.data.social.repository.source.persistence.entity.FollowerItemEntity;
import id.dana.data.social.repository.source.persistence.entity.FollowingEntity;
import id.dana.data.social.repository.source.persistence.entity.FollowingItemEntity;
import id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.feeds.data.mapper.ContactDeviceNameMapper;
import id.dana.feeds.data.mapper.ContactDeviceNameMapper$mapPhoneNumberToDeviceContactNameForRelationshipItem$1;
import id.dana.feeds.data.relationship.mapper.FollowerMapperKt;
import id.dana.feeds.data.relationship.mapper.FollowingMapperKt;
import id.dana.feeds.data.relationship.source.FeedsRelationshipDataFactory;
import id.dana.feeds.data.relationship.source.RemoteRelationshipEntityData;
import id.dana.feeds.data.relationship.source.network.NetworkRelationshipEntityData;
import id.dana.feeds.data.relationship.source.network.response.FollowerResponse;
import id.dana.feeds.data.relationship.source.network.response.FollowingResponse;
import id.dana.feeds.data.storage.persistence.PersistenceRelationshipEntityData;
import id.dana.feeds.data.storage.preferences.SocialPreferences;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import id.dana.feeds.domain.relationship.model.Follower;
import id.dana.feeds.domain.relationship.model.Following;
import id.dana.feeds.domain.relationship.model.RelationshipItem;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.ObservableKt;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020>\u0012\u0006\u0010&\u001a\u000208\u0012\u0006\u0010-\u001a\u00020@\u0012\u0006\u0010B\u001a\u000206\u0012\u0006\u0010C\u001a\u00020:¢\u0006\u0004\bD\u0010EJ\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\f0\u0005H\u0016¢\u0006\u0004\b\t\u0010\u000eJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\u0011J\u000f\u0010\u000b\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u000b\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0013J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u000eJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u0011J\u000f\u0010\u001c\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001c\u0010\u0013J\u0019\u0010\u0019\u001a\u00020\u001d2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0019\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001f\u0010\u0013J\u000f\u0010 \u001a\u00020\u0018H\u0016¢\u0006\u0004\b \u0010\u001aJ\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0016¢\u0006\u0004\b!\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0010\u0010\"J\u0017\u0010\t\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\t\u0010\"J\u0017\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0007\u0010#J\u0017\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u000b\u0010#J\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0016¢\u0006\u0004\b$\u0010\u000eJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00140\u00052\u0006\u0010\u0004\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u000b\u0010%J%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020'0\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\bJ%\u0010\r\u001a\b\u0012\u0004\u0012\u00020'0\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010(J%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010)J%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010)J%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010)J%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010)JM\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032&\u0010-\u001a\"\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b+\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b+\u0012\u0004\u0012\u00020,0*H\u0002¢\u0006\u0004\b\r\u0010.J\u000f\u0010/\u001a\u00020,H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020,H\u0002¢\u0006\u0004\b1\u00100J\u000f\u00102\u001a\u00020,H\u0016¢\u0006\u0004\b2\u00100J\u000f\u00103\u001a\u00020,H\u0016¢\u0006\u0004\b3\u00100J\u000f\u00104\u001a\u00020,H\u0016¢\u0006\u0004\b4\u00100J\u000f\u00105\u001a\u00020,H\u0016¢\u0006\u0004\b5\u00100R\u0014\u0010\u0007\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u00107R\u0014\u0010\t\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u00109R\u0014\u0010\u0010\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010;R\u0013\u0010\r\u001a\u00020<X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\t\u0010=R\u0014\u0010\u000b\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010?R\u0014\u0010\u001c\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010A"}, d2 = {"Lid/dana/feeds/data/relationship/FeedsRelationshipEntityRepository;", "Lid/dana/feeds/domain/relationship/FeedsRelationshipRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "", "p0", "Lio/reactivex/Observable;", "", "PlaceComponentResult", "(Ljava/lang/String;)Lio/reactivex/Observable;", "getAuthRequestContext", "(Ljava/lang/String;)Ljava/lang/String;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/relationship/model/Follower;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lio/reactivex/Observable;", "Lid/dana/feeds/domain/relationship/model/Following;", "BuiltInFictitiousFunctionClassFactory", "()Z", "", "()I", "Lid/dana/data/social/repository/source/persistence/entity/FollowerItemEntity;", "lookAheadTest", "(Ljava/lang/String;)Lid/dana/data/social/repository/source/persistence/entity/FollowerItemEntity;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "getErrorConfigVersion", "()J", "scheduleImpl", "moveToNextValue", "Lid/dana/data/social/repository/source/persistence/entity/FollowingItemEntity;", "(Ljava/lang/String;)Lid/dana/data/social/repository/source/persistence/entity/FollowingItemEntity;", "DatabaseTableConfigUtil", "initRecordTimeStamp", "GetContactSyncConfig", "(I)Lid/dana/feeds/domain/relationship/model/Follower;", "(I)Lid/dana/feeds/domain/relationship/model/Following;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "(Lid/dana/data/social/repository/source/persistence/entity/FollowerItemEntity;)Lio/reactivex/Observable;", "p1", "Lid/dana/feeds/domain/relationship/model/RelationshipItem;", "(Ljava/lang/String;Z)Lio/reactivex/Observable;", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "", "p2", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)Lio/reactivex/Observable;", "newProxyInstance", "()V", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda7", "NetworkUserEntityData$$ExternalSyntheticLambda8", "isLayoutRequested", "Lid/dana/feeds/data/mapper/ContactDeviceNameMapper;", "Lid/dana/feeds/data/mapper/ContactDeviceNameMapper;", "Lid/dana/feeds/data/relationship/source/FeedsRelationshipDataFactory;", "Lid/dana/feeds/data/relationship/source/FeedsRelationshipDataFactory;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/feeds/data/relationship/source/RemoteRelationshipEntityData;", "Lkotlin/Lazy;", "Lid/dana/feeds/data/storage/persistence/PersistenceRelationshipEntityData;", "Lid/dana/feeds/data/storage/persistence/PersistenceRelationshipEntityData;", "Lid/dana/feeds/data/storage/preferences/SocialPreferences;", "Lid/dana/feeds/data/storage/preferences/SocialPreferences;", "p3", "p4", "<init>", "(Lid/dana/feeds/data/storage/persistence/PersistenceRelationshipEntityData;Lid/dana/feeds/data/relationship/source/FeedsRelationshipDataFactory;Lid/dana/feeds/data/storage/preferences/SocialPreferences;Lid/dana/feeds/data/mapper/ContactDeviceNameMapper;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeedsRelationshipEntityRepository implements FeedsRelationshipRepository, HoldLoginV1Repository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final ContactDeviceNameMapper PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final FeedsRelationshipDataFactory getAuthRequestContext;
    private final PersistenceRelationshipEntityData MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final HoldLoginV1EntityRepository BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final SocialPreferences moveToNextValue;

    @Inject
    public FeedsRelationshipEntityRepository(PersistenceRelationshipEntityData persistenceRelationshipEntityData, FeedsRelationshipDataFactory feedsRelationshipDataFactory, SocialPreferences socialPreferences, ContactDeviceNameMapper contactDeviceNameMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(persistenceRelationshipEntityData, "");
        Intrinsics.checkNotNullParameter(feedsRelationshipDataFactory, "");
        Intrinsics.checkNotNullParameter(socialPreferences, "");
        Intrinsics.checkNotNullParameter(contactDeviceNameMapper, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.MyBillsEntityDataFactory = persistenceRelationshipEntityData;
        this.getAuthRequestContext = feedsRelationshipDataFactory;
        this.moveToNextValue = socialPreferences;
        this.PlaceComponentResult = contactDeviceNameMapper;
        this.BuiltInFictitiousFunctionClassFactory = holdLoginV1EntityRepository;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<RemoteRelationshipEntityData>() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$networkRelationshipEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RemoteRelationshipEntityData invoke() {
                FeedsRelationshipDataFactory feedsRelationshipDataFactory2;
                feedsRelationshipDataFactory2 = FeedsRelationshipEntityRepository.this.getAuthRequestContext;
                return new NetworkRelationshipEntityData(feedsRelationshipDataFactory2.BuiltInFictitiousFunctionClassFactory, feedsRelationshipDataFactory2.PlaceComponentResult, feedsRelationshipDataFactory2.getAuthRequestContext, feedsRelationshipDataFactory2.MyBillsEntityDataFactory);
            }
        });
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final boolean PlaceComponentResult() {
        return this.moveToNextValue.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final Observable<Follower> getAuthRequestContext() {
        if (PlaceComponentResult()) {
            newProxyInstance();
        }
        Subject subject = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
        Object blockingFirst = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory().flatMap(new FeedsRelationshipEntityRepository$$ExternalSyntheticLambda26(this)).blockingFirst();
        PlaceComponentResult(this, ((FollowerEntity) blockingFirst).getFollowerList());
        subject.onNext(blockingFirst);
        Observable map = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.map(new Function() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsRelationshipEntityRepository.PlaceComponentResult((FollowerEntity) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final Observable<Follower> KClassImpl$Data$declaredNonStaticMembers$2() {
        if (PlaceComponentResult()) {
            newProxyInstance();
        }
        Observable<Follower> map = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory.flatMap(new FeedsRelationshipEntityRepository$$ExternalSyntheticLambda26(this)).map(new Function() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsRelationshipEntityRepository.BuiltInFictitiousFunctionClassFactory(FeedsRelationshipEntityRepository.this, (FollowerEntity) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final Follower getAuthRequestContext(int p0) {
        SocialPreferences socialPreferences = this.moveToNextValue;
        RemoteRelationshipEntityData remoteRelationshipEntityData = (RemoteRelationshipEntityData) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        Long l = socialPreferences.MyBillsEntityDataFactory.getLong("follower_partial_sync_modified_time");
        FollowerResponse blockingFirst = remoteRelationshipEntityData.MyBillsEntityDataFactory(l == null ? 0L : l.longValue(), p0).blockingFirst();
        PersistenceRelationshipEntityData persistenceRelationshipEntityData = this.MyBillsEntityDataFactory;
        List<FollowerItemEntity> authRequestContext = FollowerMapperKt.getAuthRequestContext(blockingFirst.getFollowerList());
        Intrinsics.checkNotNullParameter(authRequestContext, "");
        persistenceRelationshipEntityData.getDb().followerDao().insertFollowerItemList(authRequestContext);
        this.moveToNextValue.BuiltInFictitiousFunctionClassFactory(blockingFirst.getPaginator().getPage());
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        return FollowerMapperKt.BuiltInFictitiousFunctionClassFactory(blockingFirst);
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final void NetworkUserEntityData$$ExternalSyntheticLambda7() {
        this.moveToNextValue.MyBillsEntityDataFactory(System.currentTimeMillis());
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final long getErrorConfigVersion() {
        Long l = this.moveToNextValue.MyBillsEntityDataFactory.getLong("follower_partial_sync_modified_time");
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        SocialPreferences socialPreferences = this.moveToNextValue;
        socialPreferences.getErrorConfigVersion();
        socialPreferences.MyBillsEntityDataFactory(System.currentTimeMillis());
        newProxyInstance();
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final int MyBillsEntityDataFactory() {
        Integer integer = this.moveToNextValue.MyBillsEntityDataFactory.getInteger("follower_full_sync_last_page");
        if (integer == null) {
            return 0;
        }
        return integer.intValue();
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final int NetworkUserEntityData$$ExternalSyntheticLambda0() {
        SocialPreferences socialPreferences = this.moveToNextValue;
        StringBuilder sb = new StringBuilder();
        sb.append("follower_partial_sync_last_page");
        Long l = socialPreferences.MyBillsEntityDataFactory.getLong("follower_partial_sync_modified_time");
        sb.append(l == null ? 0L : l.longValue());
        Integer integer = socialPreferences.MyBillsEntityDataFactory.getInteger(sb.toString());
        if (integer == null) {
            return 0;
        }
        return integer.intValue();
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final Observable<Boolean> MyBillsEntityDataFactory(final String p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Observable<Boolean> doOnError = KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, new FeedsRelationshipEntityRepository$modifyFollowerRelationship$1(this)).doOnError(new Consumer() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Throwable th = (Throwable) obj;
                FeedsRelationshipEntityRepository.PlaceComponentResult(FeedsRelationshipEntityRepository.this);
            }
        });
        final Function1<Boolean, Boolean> function1 = new Function1<Boolean, Boolean>() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$doSecondaryOperationAfterFirstOperation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Boolean invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }

            public final Boolean invoke(boolean z) {
                String authRequestContext;
                if (z) {
                    if (p1.length() > 0) {
                        FeedsRelationshipEntityRepository feedsRelationshipEntityRepository = this;
                        String str = p0;
                        authRequestContext = FeedsRelationshipEntityRepository.getAuthRequestContext(p1);
                        FeedsRelationshipEntityRepository.MyBillsEntityDataFactory(feedsRelationshipEntityRepository, str, authRequestContext);
                        this.PrepareContext();
                    }
                }
                return Boolean.valueOf(z);
            }
        };
        Observable map = doOnError.map(new Function() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsRelationshipEntityRepository.getAuthRequestContext(Function1.this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final Observable<Boolean> getAuthRequestContext(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Observable<Boolean> doOnNext = MyBillsEntityDataFactory(p0, p1).doOnNext(new Consumer() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda23
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Boolean bool = (Boolean) obj;
                FeedsRelationshipEntityRepository.getAuthRequestContext(FeedsRelationshipEntityRepository.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnNext, "");
        return doOnNext;
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final Observable<RelationshipItem> BuiltInFictitiousFunctionClassFactory(final String str) {
        Intrinsics.checkNotNullParameter(str, "");
        Observable fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FeedsRelationshipEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(FeedsRelationshipEntityRepository.this, str);
            }
        });
        PersistenceRelationshipEntityData persistenceRelationshipEntityData = this.MyBillsEntityDataFactory;
        final boolean z = false;
        Intrinsics.checkNotNullParameter(str, "");
        Observable flatMap = persistenceRelationshipEntityData.getDb().followerDao().getSelectedFollower(str).flatMap(new Function() { // from class: id.dana.feeds.data.storage.persistence.PersistenceRelationshipEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PersistenceRelationshipEntityData.MyBillsEntityDataFactory((List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        List listOf = CollectionsKt.listOf((Object[]) new Observable[]{persistenceRelationshipEntityData.MyBillsEntityDataFactory, flatMap});
        final FeedsRelationshipEntityRepository$takeFollowerItemFromSecondSource$1 feedsRelationshipEntityRepository$takeFollowerItemFromSecondSource$1 = new Function1<Object[], FollowerItemEntity>() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$takeFollowerItemFromSecondSource$1
            @Override // kotlin.jvm.functions.Function1
            public final FollowerItemEntity invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "");
                return (FollowerItemEntity) objArr[1];
            }
        };
        Observable flatMap2 = fromCallable.onErrorResumeNext(Observable.combineLatest(listOf, new Function() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsRelationshipEntityRepository.MyBillsEntityDataFactory(Function1.this, (Object[]) obj);
            }
        })).flatMap(new Function() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Observable MyBillsEntityDataFactory;
                MyBillsEntityDataFactory = FeedsRelationshipEntityRepository.this.MyBillsEntityDataFactory((FollowerItemEntity) obj);
                return MyBillsEntityDataFactory;
            }
        });
        final Function1<FollowerItemEntity, RelationshipItem> function1 = new Function1<FollowerItemEntity, RelationshipItem>() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$getSelectedFollowerIfStatusEmpty$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final RelationshipItem invoke(FollowerItemEntity followerItemEntity) {
                FollowerItemEntity lookAheadTest;
                Intrinsics.checkNotNullParameter(followerItemEntity, "");
                FeedsRelationshipEntityRepository feedsRelationshipEntityRepository = FeedsRelationshipEntityRepository.this;
                String str2 = str;
                boolean z2 = z;
                if (followerItemEntity.getStatus().length() == 0) {
                    lookAheadTest = feedsRelationshipEntityRepository.lookAheadTest(str2);
                    followerItemEntity.setStatus(lookAheadTest.getStatus());
                }
                FeedsRelationshipEntityRepository.BuiltInFictitiousFunctionClassFactory(feedsRelationshipEntityRepository, CollectionsKt.listOf(followerItemEntity), z2);
                return FollowerMapperKt.MyBillsEntityDataFactory(followerItemEntity);
            }
        };
        Observable<RelationshipItem> map = flatMap2.map(new Function() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsRelationshipEntityRepository.MyBillsEntityDataFactory(Function1.this, (FollowerItemEntity) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final boolean scheduleImpl() {
        return this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final Observable<Following> GetContactSyncConfig() {
        if (scheduleImpl()) {
            PrepareContext();
        }
        BehaviorSubject<FollowingEntity> behaviorSubject = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        FollowingEntity blockingSingle = this.MyBillsEntityDataFactory.getAuthRequestContext().blockingSingle();
        ContactDeviceNameMapper.PlaceComponentResult(this.PlaceComponentResult, blockingSingle.getFollowingList(), null, null, 6);
        behaviorSubject.onNext(blockingSingle);
        Observable map = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.map(new Function() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsRelationshipEntityRepository.BuiltInFictitiousFunctionClassFactory((FollowingEntity) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final Observable<Following> BuiltInFictitiousFunctionClassFactory() {
        if (scheduleImpl()) {
            PrepareContext();
        }
        Observable map = this.MyBillsEntityDataFactory.PlaceComponentResult.map(new Function() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsRelationshipEntityRepository.PlaceComponentResult((FollowingEntity) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final Following MyBillsEntityDataFactory(int p0) {
        SocialPreferences socialPreferences = this.moveToNextValue;
        RemoteRelationshipEntityData remoteRelationshipEntityData = (RemoteRelationshipEntityData) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        Long l = socialPreferences.MyBillsEntityDataFactory.getLong("following_partial_sync_modified_time");
        FollowingResponse BuiltInFictitiousFunctionClassFactory = remoteRelationshipEntityData.BuiltInFictitiousFunctionClassFactory(l == null ? 0L : l.longValue(), p0);
        PersistenceRelationshipEntityData persistenceRelationshipEntityData = this.MyBillsEntityDataFactory;
        List<FollowingItemEntity> MyBillsEntityDataFactory = FollowingMapperKt.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory.getFollowingList());
        Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory, "");
        persistenceRelationshipEntityData.getDb().followingDao().insertFollowingItemList(MyBillsEntityDataFactory);
        this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getPaginator().getPage());
        return FollowingMapperKt.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory);
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final void isLayoutRequested() {
        this.moveToNextValue.getAuthRequestContext(System.currentTimeMillis());
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final long initRecordTimeStamp() {
        Long l = this.moveToNextValue.MyBillsEntityDataFactory.getLong("following_partial_sync_modified_time");
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        SocialPreferences socialPreferences = this.moveToNextValue;
        socialPreferences.NetworkUserEntityData$$ExternalSyntheticLambda0();
        socialPreferences.getAuthRequestContext(System.currentTimeMillis());
        PrepareContext();
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final int moveToNextValue() {
        Integer integer = this.moveToNextValue.MyBillsEntityDataFactory.getInteger("following_full_sync_last_page");
        if (integer == null) {
            return 0;
        }
        return integer.intValue();
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final int DatabaseTableConfigUtil() {
        SocialPreferences socialPreferences = this.moveToNextValue;
        StringBuilder sb = new StringBuilder();
        sb.append("following_partial_sync_last_page");
        Long l = socialPreferences.MyBillsEntityDataFactory.getLong("following_partial_sync_modified_time");
        sb.append(l == null ? 0L : l.longValue());
        Integer integer = socialPreferences.MyBillsEntityDataFactory.getInteger(sb.toString());
        if (integer == null) {
            return 0;
        }
        return integer.intValue();
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final Observable<Boolean> PlaceComponentResult(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Observable<Boolean> doOnError = KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, new FeedsRelationshipEntityRepository$modifyFollowingRelationship$1(this)).doOnError(new Consumer() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda22
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Throwable th = (Throwable) obj;
                FeedsRelationshipEntityRepository.BuiltInFictitiousFunctionClassFactory(FeedsRelationshipEntityRepository.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnError, "");
        return doOnError;
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final Observable<RelationshipItem> KClassImpl$Data$declaredNonStaticMembers$2(final String p0, final boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda12
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FeedsRelationshipEntityRepository.BuiltInFictitiousFunctionClassFactory(FeedsRelationshipEntityRepository.this, p0);
            }
        });
        PersistenceRelationshipEntityData persistenceRelationshipEntityData = this.MyBillsEntityDataFactory;
        List listOf = CollectionsKt.listOf((Object[]) new Observable[]{persistenceRelationshipEntityData.PlaceComponentResult, persistenceRelationshipEntityData.BuiltInFictitiousFunctionClassFactory(p0)});
        final FeedsRelationshipEntityRepository$takeFollowingItemFromSecondSource$1 feedsRelationshipEntityRepository$takeFollowingItemFromSecondSource$1 = new Function1<Object[], FollowingItemEntity>() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$takeFollowingItemFromSecondSource$1
            @Override // kotlin.jvm.functions.Function1
            public final FollowingItemEntity invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "");
                return (FollowingItemEntity) objArr[1];
            }
        };
        Observable onErrorReturn = fromCallable.onErrorResumeNext(Observable.combineLatest(listOf, new Function() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsRelationshipEntityRepository.BuiltInFictitiousFunctionClassFactory(Function1.this, (Object[]) obj);
            }
        })).onErrorReturn(new Function() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsRelationshipEntityRepository.PlaceComponentResult(FeedsRelationshipEntityRepository.this, p0, (Throwable) obj);
            }
        });
        final Function1<FollowingItemEntity, RelationshipItem> function1 = new Function1<FollowingItemEntity, RelationshipItem>() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$getSelectedFollowingIfStatusEmpty$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final RelationshipItem invoke(FollowingItemEntity followingItemEntity) {
                FollowingItemEntity errorConfigVersion;
                Intrinsics.checkNotNullParameter(followingItemEntity, "");
                FeedsRelationshipEntityRepository feedsRelationshipEntityRepository = FeedsRelationshipEntityRepository.this;
                String str = p0;
                boolean z = p1;
                if (followingItemEntity.getStatus().length() == 0) {
                    errorConfigVersion = feedsRelationshipEntityRepository.getErrorConfigVersion(str);
                    followingItemEntity.setStatus(errorConfigVersion.getStatus());
                }
                FeedsRelationshipEntityRepository.BuiltInFictitiousFunctionClassFactory(feedsRelationshipEntityRepository, CollectionsKt.listOf(followingItemEntity), z);
                return FollowingMapperKt.getAuthRequestContext(followingItemEntity);
            }
        };
        Observable<RelationshipItem> map = onErrorReturn.map(new Function() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsRelationshipEntityRepository.PlaceComponentResult(Function1.this, (FollowingItemEntity) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final Observable<Boolean> BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Observable<Boolean> doOnNext = PlaceComponentResult(p0, p1).doOnNext(new Consumer() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda25
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Boolean bool = (Boolean) obj;
                FeedsRelationshipEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(FeedsRelationshipEntityRepository.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnNext, "");
        return doOnNext;
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final Observable<Integer> lookAheadTest() {
        Observable<Integer> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FeedsRelationshipEntityRepository.MyBillsEntityDataFactory(FeedsRelationshipEntityRepository.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final Observable<Following> NetworkUserEntityData$$ExternalSyntheticLambda2() {
        if (scheduleImpl()) {
            PrepareContext();
        }
        Observable map = this.MyBillsEntityDataFactory.PlaceComponentResult.map(new Function() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsRelationshipEntityRepository.MyBillsEntityDataFactory((FollowingEntity) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observable<FollowerItemEntity> MyBillsEntityDataFactory(final FollowerItemEntity p0) {
        Observable<FollowerItemEntity> onErrorResumeNext = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(p0.getUserId()).map(new Function() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsRelationshipEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(FollowerItemEntity.this, (FollowingItemEntity) obj);
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda21
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsRelationshipEntityRepository.getAuthRequestContext(FollowerItemEntity.this, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getAuthRequestContext(String p0) {
        return Intrinsics.areEqual(p0, ModifyRelationOperationType.BLOCK.getOperationType()) ? "BLOCKING" : Intrinsics.areEqual(p0, ModifyRelationOperationType.MUTE.getOperationType()) ? "MUTE" : "ACTIVE";
    }

    public static /* synthetic */ Boolean KClassImpl$Data$declaredNonStaticMembers$2(BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        return Boolean.valueOf(baseRpcResult.success);
    }

    public static /* synthetic */ Integer MyBillsEntityDataFactory(FeedsRelationshipEntityRepository feedsRelationshipEntityRepository) {
        Intrinsics.checkNotNullParameter(feedsRelationshipEntityRepository, "");
        return Integer.valueOf(((RemoteRelationshipEntityData) feedsRelationshipEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).BuiltInFictitiousFunctionClassFactory(0L, 1).getPaginator().getItems());
    }

    public static /* synthetic */ Boolean getAuthRequestContext(Function1 function1, Boolean bool) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (Boolean) function1.invoke(bool);
    }

    public static /* synthetic */ FollowingItemEntity BuiltInFictitiousFunctionClassFactory(FeedsRelationshipEntityRepository feedsRelationshipEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(feedsRelationshipEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        return feedsRelationshipEntityRepository.getErrorConfigVersion(str);
    }

    public static /* synthetic */ FollowingItemEntity BuiltInFictitiousFunctionClassFactory(Function1 function1, Object[] objArr) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (FollowingItemEntity) function1.invoke(objArr);
    }

    public static /* synthetic */ RelationshipItem PlaceComponentResult(Function1 function1, FollowingItemEntity followingItemEntity) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (RelationshipItem) function1.invoke(followingItemEntity);
    }

    public static /* synthetic */ Observable PlaceComponentResult(FeedsRelationshipEntityRepository feedsRelationshipEntityRepository, final FollowerEntity followerEntity) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = followerEntity.getFollowerList().iterator();
        while (it.hasNext()) {
            ObservableSource map = feedsRelationshipEntityRepository.MyBillsEntityDataFactory((FollowerItemEntity) it.next()).map(new Function() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda7
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return FeedsRelationshipEntityRepository.PlaceComponentResult(FollowerEntity.this, (FollowerItemEntity) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(map, "");
            arrayList.add(map);
        }
        if (arrayList.isEmpty()) {
            Observable just = Observable.just(followerEntity);
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }
        return ObservableKt.getAuthRequestContext(arrayList);
    }

    public static /* synthetic */ Following PlaceComponentResult(FollowingEntity followingEntity) {
        Intrinsics.checkNotNullParameter(followingEntity, "");
        Following authRequestContext = FollowingMapperKt.getAuthRequestContext(followingEntity);
        List<RelationshipItem> followingItemList = authRequestContext.getFollowingItemList();
        ArrayList arrayList = new ArrayList();
        for (Object obj : followingItemList) {
            if (Intrinsics.areEqual(((RelationshipItem) obj).getStatus(), "ACTIVE")) {
                arrayList.add(obj);
            }
        }
        authRequestContext.setFollowingItemList(arrayList);
        return authRequestContext;
    }

    public static /* synthetic */ Follower PlaceComponentResult(FollowerEntity followerEntity) {
        Intrinsics.checkNotNullParameter(followerEntity, "");
        Follower authRequestContext = FollowerMapperKt.getAuthRequestContext(followerEntity);
        List<RelationshipItem> followerItemList = authRequestContext.getFollowerItemList();
        ArrayList arrayList = new ArrayList();
        for (Object obj : followerItemList) {
            if (Intrinsics.areEqual(((RelationshipItem) obj).getStatus(), "BLOCKING")) {
                arrayList.add(obj);
            }
        }
        authRequestContext.setFollowerItemList(arrayList);
        return authRequestContext;
    }

    public static /* synthetic */ Boolean PlaceComponentResult(Function2 function2, String str, FeedsRelationshipEntityRepository feedsRelationshipEntityRepository, String str2, BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(function2, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(feedsRelationshipEntityRepository, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        if (baseRpcResult.success) {
            function2.invoke(str, getAuthRequestContext(str2));
        }
        return Boolean.valueOf(baseRpcResult.success);
    }

    public static /* synthetic */ FollowerItemEntity KClassImpl$Data$declaredNonStaticMembers$2(FeedsRelationshipEntityRepository feedsRelationshipEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(feedsRelationshipEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        return feedsRelationshipEntityRepository.lookAheadTest(str);
    }

    public static /* synthetic */ RelationshipItem MyBillsEntityDataFactory(Function1 function1, FollowerItemEntity followerItemEntity) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (RelationshipItem) function1.invoke(followerItemEntity);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(FeedsRelationshipEntityRepository feedsRelationshipEntityRepository) {
        Intrinsics.checkNotNullParameter(feedsRelationshipEntityRepository, "");
        feedsRelationshipEntityRepository.PrepareContext();
    }

    public static /* synthetic */ FollowerEntity PlaceComponentResult(FollowerEntity followerEntity, FollowerItemEntity followerItemEntity) {
        Intrinsics.checkNotNullParameter(followerEntity, "");
        Intrinsics.checkNotNullParameter(followerItemEntity, "");
        return followerEntity;
    }

    public static /* synthetic */ FollowingItemEntity PlaceComponentResult(FeedsRelationshipEntityRepository feedsRelationshipEntityRepository, String str, Throwable th) {
        Intrinsics.checkNotNullParameter(feedsRelationshipEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(th, "");
        return feedsRelationshipEntityRepository.getErrorConfigVersion(str);
    }

    public static /* synthetic */ void PlaceComponentResult(FeedsRelationshipEntityRepository feedsRelationshipEntityRepository) {
        Intrinsics.checkNotNullParameter(feedsRelationshipEntityRepository, "");
        feedsRelationshipEntityRepository.newProxyInstance();
    }

    public static /* synthetic */ Follower MyBillsEntityDataFactory(FollowerEntity followerEntity) {
        Intrinsics.checkNotNullParameter(followerEntity, "");
        return FollowerMapperKt.getAuthRequestContext(followerEntity);
    }

    public static /* synthetic */ Follower BuiltInFictitiousFunctionClassFactory(FeedsRelationshipEntityRepository feedsRelationshipEntityRepository, FollowerEntity followerEntity) {
        Intrinsics.checkNotNullParameter(feedsRelationshipEntityRepository, "");
        Intrinsics.checkNotNullParameter(followerEntity, "");
        List<FollowerItemEntity> followerList = followerEntity.getFollowerList();
        ContactDeviceNameMapper contactDeviceNameMapper = feedsRelationshipEntityRepository.PlaceComponentResult;
        Intrinsics.checkNotNullParameter(followerList, "");
        ContactDeviceNameMapper.PlaceComponentResult(contactDeviceNameMapper, followerList, new ContactDeviceNameMapper$mapPhoneNumberToDeviceContactNameForRelationshipItem$1(contactDeviceNameMapper, followerList), null, 4);
        Follower authRequestContext = FollowerMapperKt.getAuthRequestContext(followerEntity);
        List<RelationshipItem> followerItemList = authRequestContext.getFollowerItemList();
        ArrayList arrayList = new ArrayList();
        for (Object obj : followerItemList) {
            if (Intrinsics.areEqual(((RelationshipItem) obj).getStatus(), "ACTIVE")) {
                arrayList.add(obj);
            }
        }
        authRequestContext.setFollowerItemList(arrayList);
        return authRequestContext;
    }

    public static /* synthetic */ void getAuthRequestContext(FeedsRelationshipEntityRepository feedsRelationshipEntityRepository) {
        Intrinsics.checkNotNullParameter(feedsRelationshipEntityRepository, "");
        feedsRelationshipEntityRepository.newProxyInstance();
    }

    public static /* synthetic */ Following MyBillsEntityDataFactory(FollowingEntity followingEntity) {
        Intrinsics.checkNotNullParameter(followingEntity, "");
        Following authRequestContext = FollowingMapperKt.getAuthRequestContext(followingEntity);
        List<RelationshipItem> followingItemList = authRequestContext.getFollowingItemList();
        ArrayList arrayList = new ArrayList();
        for (Object obj : followingItemList) {
            RelationshipItem relationshipItem = (RelationshipItem) obj;
            if (Intrinsics.areEqual(relationshipItem.getStatus(), "ACTIVE") || Intrinsics.areEqual(relationshipItem.getStatus(), "MUTE")) {
                arrayList.add(obj);
            }
        }
        authRequestContext.setFollowingItemList(arrayList);
        return authRequestContext;
    }

    public static /* synthetic */ FollowerItemEntity MyBillsEntityDataFactory(Function1 function1, Object[] objArr) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (FollowerItemEntity) function1.invoke(objArr);
    }

    public static /* synthetic */ Boolean getAuthRequestContext(BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        return Boolean.valueOf(baseRpcResult.success);
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(FollowerItemEntity followerItemEntity, Throwable th) {
        Intrinsics.checkNotNullParameter(followerItemEntity, "");
        Intrinsics.checkNotNullParameter(th, "");
        return Observable.just(followerItemEntity);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FeedsRelationshipEntityRepository feedsRelationshipEntityRepository) {
        Intrinsics.checkNotNullParameter(feedsRelationshipEntityRepository, "");
        feedsRelationshipEntityRepository.PrepareContext();
    }

    public static /* synthetic */ FollowerItemEntity KClassImpl$Data$declaredNonStaticMembers$2(FollowerItemEntity followerItemEntity, FollowingItemEntity followingItemEntity) {
        Intrinsics.checkNotNullParameter(followerItemEntity, "");
        Intrinsics.checkNotNullParameter(followingItemEntity, "");
        followerItemEntity.setNickName(followingItemEntity.getNickName());
        return followerItemEntity;
    }

    public static /* synthetic */ Following KClassImpl$Data$declaredNonStaticMembers$2(FollowingEntity followingEntity) {
        Intrinsics.checkNotNullParameter(followingEntity, "");
        return FollowingMapperKt.getAuthRequestContext(followingEntity);
    }

    public static /* synthetic */ Following BuiltInFictitiousFunctionClassFactory(FollowingEntity followingEntity) {
        Intrinsics.checkNotNullParameter(followingEntity, "");
        Following authRequestContext = FollowingMapperKt.getAuthRequestContext(followingEntity);
        List<RelationshipItem> followingItemList = authRequestContext.getFollowingItemList();
        ArrayList arrayList = new ArrayList();
        for (Object obj : followingItemList) {
            if (Intrinsics.areEqual(((RelationshipItem) obj).getStatus(), "MUTE")) {
                arrayList.add(obj);
            }
        }
        authRequestContext.setFollowingItemList(arrayList);
        return authRequestContext;
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(FeedsRelationshipEntityRepository feedsRelationshipEntityRepository, final List list, boolean z) {
        if (z) {
            ContactDeviceNameMapper contactDeviceNameMapper = feedsRelationshipEntityRepository.PlaceComponentResult;
            Intrinsics.checkNotNullParameter(list, "");
            ContactDeviceNameMapper.PlaceComponentResult(contactDeviceNameMapper, list, new ContactDeviceNameMapper$mapPhoneNumberToDeviceContactNameForRelationshipItem$1(contactDeviceNameMapper, list), null, 4);
            return;
        }
        final ContactDeviceNameMapper contactDeviceNameMapper2 = feedsRelationshipEntityRepository.PlaceComponentResult;
        Intrinsics.checkNotNullParameter(list, "");
        contactDeviceNameMapper2.BuiltInFictitiousFunctionClassFactory(list, new Function0<Unit>() { // from class: id.dana.feeds.data.mapper.ContactDeviceNameMapper$mapPhoneNumberToDeviceContactNameNotUsername$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                ContactDeviceNameMapper.MyBillsEntityDataFactory(list);
            }
        }, new Function1<List<? extends PhoneNumberToContactNameMappable>, Unit>() { // from class: id.dana.feeds.data.mapper.ContactDeviceNameMapper$mapPhoneNumberToDeviceContactNameNotUsername$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends PhoneNumberToContactNameMappable> list2) {
                Intrinsics.checkNotNullParameter(list2, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends PhoneNumberToContactNameMappable> list2) {
                invoke2(list2);
                return Unit.INSTANCE;
            }
        });
    }

    public static final /* synthetic */ void PlaceComponentResult(FeedsRelationshipEntityRepository feedsRelationshipEntityRepository, String str, String str2) {
        PersistenceRelationshipEntityData persistenceRelationshipEntityData = feedsRelationshipEntityRepository.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        persistenceRelationshipEntityData.getDb().followerDao().updateModifiedRelation(str, str2);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(FeedsRelationshipEntityRepository feedsRelationshipEntityRepository, String str, String str2) {
        PersistenceRelationshipEntityData persistenceRelationshipEntityData = feedsRelationshipEntityRepository.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        persistenceRelationshipEntityData.getDb().followingDao().updateModifiedRelation(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FollowerItemEntity lookAheadTest(String p0) {
        List<FollowerItemEntity> authRequestContext = FollowerMapperKt.getAuthRequestContext(((RemoteRelationshipEntityData) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).MyBillsEntityDataFactory((Integer) 1, p0).getFollowerList());
        PersistenceRelationshipEntityData persistenceRelationshipEntityData = this.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(authRequestContext, "");
        persistenceRelationshipEntityData.getDb().followerDao().insertFollowerItemList(authRequestContext);
        return authRequestContext.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FollowingItemEntity getErrorConfigVersion(String p0) {
        List<FollowingItemEntity> MyBillsEntityDataFactory = FollowingMapperKt.MyBillsEntityDataFactory(((RemoteRelationshipEntityData) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).KClassImpl$Data$declaredNonStaticMembers$2((Integer) 1, p0).getFollowingList());
        PersistenceRelationshipEntityData persistenceRelationshipEntityData = this.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory, "");
        persistenceRelationshipEntityData.getDb().followingDao().insertFollowingItemList(MyBillsEntityDataFactory);
        return MyBillsEntityDataFactory.get(0);
    }

    private static /* synthetic */ void PlaceComponentResult(FeedsRelationshipEntityRepository feedsRelationshipEntityRepository, List list) {
        ContactDeviceNameMapper contactDeviceNameMapper = feedsRelationshipEntityRepository.PlaceComponentResult;
        Intrinsics.checkNotNullParameter(list, "");
        ContactDeviceNameMapper.PlaceComponentResult(contactDeviceNameMapper, list, new ContactDeviceNameMapper$mapPhoneNumberToDeviceContactNameForRelationshipItem$1(contactDeviceNameMapper, list), null, 4);
    }

    private final Observable<Boolean> KClassImpl$Data$declaredNonStaticMembers$2(final String p0, final String p1, final Function2<? super String, ? super String, Unit> p2) {
        Observable map = ((RemoteRelationshipEntityData) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(p0, p1).map(new Function() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsRelationshipEntityRepository.PlaceComponentResult(Function2.this, p0, this, p1, (BaseRpcResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    private final void newProxyInstance() {
        try {
            BehaviorSubject<FollowerEntity> behaviorSubject = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory;
            FollowerEntity blockingFirst = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory().blockingFirst();
            PlaceComponentResult(this, blockingFirst.getFollowerList());
            behaviorSubject.onNext(blockingFirst);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PrepareContext() {
        BehaviorSubject<FollowingEntity> behaviorSubject = this.MyBillsEntityDataFactory.PlaceComponentResult;
        FollowingEntity blockingSingle = this.MyBillsEntityDataFactory.getAuthRequestContext().blockingSingle();
        ContactDeviceNameMapper.PlaceComponentResult(this.PlaceComponentResult, blockingSingle.getFollowingList(), null, null, 6);
        behaviorSubject.onNext(blockingSingle);
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final Observable<Boolean> PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable map = ((RemoteRelationshipEntityData) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).BuiltInFictitiousFunctionClassFactory(p0).map(new Function() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsRelationshipEntityRepository.getAuthRequestContext((BaseRpcResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final Observable<Boolean> MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable map = ((RemoteRelationshipEntityData) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).getAuthRequestContext(p0).map(new Function() { // from class: id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsRelationshipEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((BaseRpcResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final Follower BuiltInFictitiousFunctionClassFactory(int p0) {
        FollowerResponse blockingFirst = ((RemoteRelationshipEntityData) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).PlaceComponentResult(p0).blockingFirst();
        PersistenceRelationshipEntityData persistenceRelationshipEntityData = this.MyBillsEntityDataFactory;
        List<FollowerItemEntity> authRequestContext = FollowerMapperKt.getAuthRequestContext(blockingFirst.getFollowerList());
        Intrinsics.checkNotNullParameter(authRequestContext, "");
        persistenceRelationshipEntityData.getDb().followerDao().insertFollowerItemList(authRequestContext);
        this.moveToNextValue.MyBillsEntityDataFactory(blockingFirst.getPaginator().getPage());
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        return FollowerMapperKt.BuiltInFictitiousFunctionClassFactory(blockingFirst);
    }

    @Override // id.dana.feeds.domain.relationship.FeedsRelationshipRepository
    public final Following PlaceComponentResult(int p0) {
        FollowingResponse KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = ((RemoteRelationshipEntityData) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(Integer.valueOf(p0), (String) null);
        PersistenceRelationshipEntityData persistenceRelationshipEntityData = this.MyBillsEntityDataFactory;
        List<FollowingItemEntity> MyBillsEntityDataFactory = FollowingMapperKt.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getFollowingList());
        Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory, "");
        persistenceRelationshipEntityData.getDb().followingDao().insertFollowingItemList(MyBillsEntityDataFactory);
        this.moveToNextValue.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2.getPaginator().getPage());
        return FollowingMapperKt.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
