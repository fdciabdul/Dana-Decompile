package id.dana.feeds.data.detail;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import dagger.Lazy;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable;
import id.dana.domain.util.StringUtil;
import id.dana.feeds.data.detail.source.FeedsDetailDataFactory;
import id.dana.feeds.data.detail.source.network.response.AddActivityCommentResponse;
import id.dana.feeds.data.detail.source.network.response.CommentResponse;
import id.dana.feeds.data.detail.source.network.response.FetchActivityCommentsResponse;
import id.dana.feeds.data.mapper.ContactDeviceNameMapper;
import id.dana.feeds.data.storage.preferences.LocalSocialPreferencesData;
import id.dana.feeds.data.storage.preferences.SocialPreferencesDataFactory;
import id.dana.feeds.domain.detail.FeedsDetailRepository;
import id.dana.feeds.domain.detail.model.AddActivityCommentInfo;
import id.dana.feeds.domain.detail.model.Comment;
import id.dana.feeds.domain.detail.model.FeedCommentResult;
import id.dana.network.exception.NetworkException;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BI\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0014\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\u001f\u0010 J7\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ7\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\n\u0010\u0011J-\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00180\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0017R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00190\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001cR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0017"}, d2 = {"Lid/dana/feeds/data/detail/FeedsDetailEntityRepository;", "Lid/dana/feeds/domain/detail/FeedsDetailRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "", "p0", "p1", "p2", "p3", "Lio/reactivex/Observable;", "Lid/dana/feeds/domain/detail/model/AddActivityCommentInfo;", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "Lid/dana/feeds/domain/detail/model/FeedCommentResult;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Observable;", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Ldagger/Lazy;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "getAuthRequestContext", "Ldagger/Lazy;", "Lid/dana/feeds/data/mapper/ContactDeviceNameMapper;", "Lid/dana/feeds/data/detail/source/FeedsDetailDataFactory;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/feeds/data/storage/preferences/SocialPreferencesDataFactory;", "p4", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeedsDetailEntityRepository implements FeedsDetailRepository, HoldLoginV1Repository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy<SocialPreferencesDataFactory> getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy<FeedsDetailDataFactory> PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final HoldLoginV1EntityRepository KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy<ContactDeviceNameMapper> MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<AccountEntityDataFactory> BuiltInFictitiousFunctionClassFactory;

    @Inject
    public FeedsDetailEntityRepository(Lazy<FeedsDetailDataFactory> lazy, Lazy<AccountEntityDataFactory> lazy2, Lazy<ContactDeviceNameMapper> lazy3, Lazy<SocialPreferencesDataFactory> lazy4, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.PlaceComponentResult = lazy;
        this.BuiltInFictitiousFunctionClassFactory = lazy2;
        this.MyBillsEntityDataFactory = lazy3;
        this.getAuthRequestContext = lazy4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = holdLoginV1EntityRepository;
    }

    public static /* synthetic */ Boolean BuiltInFictitiousFunctionClassFactory(BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        return Boolean.valueOf(baseRpcResult.success);
    }

    public static /* synthetic */ FetchActivityCommentsResponse MyBillsEntityDataFactory(Function1 function1, FetchActivityCommentsResponse fetchActivityCommentsResponse) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (FetchActivityCommentsResponse) function1.invoke(fetchActivityCommentsResponse);
    }

    public static /* synthetic */ Boolean KClassImpl$Data$declaredNonStaticMembers$2(BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        return Boolean.valueOf(baseRpcResult.success);
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        if (th instanceof NetworkException) {
            NetworkException networkException = (NetworkException) th;
            if (Intrinsics.areEqual(networkException.getErrorCode(), "AE15001958019001")) {
                BaseRpcResult baseRpcResult = new BaseRpcResult();
                baseRpcResult.errorCode = networkException.getErrorCode();
                baseRpcResult.errorMessage = th.getMessage();
                baseRpcResult.success = true;
                return Observable.just(baseRpcResult);
            }
        }
        return Observable.error(th);
    }

    public static /* synthetic */ void PlaceComponentResult(FeedsDetailEntityRepository feedsDetailEntityRepository, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(feedsDetailEntityRepository, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullExpressionValue(str, "");
        SocialPreferencesDataFactory socialPreferencesDataFactory = feedsDetailEntityRepository.getAuthRequestContext.get();
        Intrinsics.checkNotNullParameter("local", "");
        Set<String> mutableSet = CollectionsKt.toMutableSet(new LocalSocialPreferencesData(socialPreferencesDataFactory.PlaceComponentResult).BuiltInFictitiousFunctionClassFactory(str, str2));
        mutableSet.add(str3);
        SocialPreferencesDataFactory socialPreferencesDataFactory2 = feedsDetailEntityRepository.getAuthRequestContext.get();
        Intrinsics.checkNotNullParameter("local", "");
        Intrinsics.checkNotNullExpressionValue(Observable.just(Boolean.valueOf(new LocalSocialPreferencesData(socialPreferencesDataFactory2.PlaceComponentResult).BuiltInFictitiousFunctionClassFactory(str, str2, mutableSet))), "");
    }

    public static /* synthetic */ FeedCommentResult PlaceComponentResult(Function1 function1, FetchActivityCommentsResponse fetchActivityCommentsResponse) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (FeedCommentResult) function1.invoke(fetchActivityCommentsResponse);
    }

    public static /* synthetic */ AddActivityCommentInfo BuiltInFictitiousFunctionClassFactory(AddActivityCommentResponse addActivityCommentResponse) {
        Intrinsics.checkNotNullParameter(addActivityCommentResponse, "");
        String id2 = addActivityCommentResponse.getId();
        String str = id2 == null ? "" : id2;
        String userId = addActivityCommentResponse.getUserId();
        String str2 = userId == null ? "" : userId;
        String activityId = addActivityCommentResponse.getActivityId();
        String str3 = activityId == null ? "" : activityId;
        String content = addActivityCommentResponse.getContent();
        String str4 = content == null ? "" : content;
        String createdTime = addActivityCommentResponse.getCreatedTime();
        return new AddActivityCommentInfo(str, str2, str3, str4, createdTime == null ? "" : createdTime, addActivityCommentResponse.getParentCommentId());
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(List list) {
        List<PhoneNumberToContactNameMappable> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (PhoneNumberToContactNameMappable phoneNumberToContactNameMappable : list2) {
            phoneNumberToContactNameMappable.updateNickName(StringUtil.maskName(phoneNumberToContactNameMappable.getNickname()));
            arrayList.add(Unit.INSTANCE);
        }
    }

    @Override // id.dana.feeds.domain.detail.FeedsDetailRepository
    public final Observable<AddActivityCommentInfo> PlaceComponentResult(String p0, String p1, String p2, String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Observable map = this.PlaceComponentResult.get().createData2("network").MyBillsEntityDataFactory(p0, p1, p2, p3).map(new Function() { // from class: id.dana.feeds.data.detail.FeedsDetailEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsDetailEntityRepository.BuiltInFictitiousFunctionClassFactory((AddActivityCommentResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.detail.FeedsDetailRepository
    public final Observable<Boolean> BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable map = this.PlaceComponentResult.get().createData2("network").KClassImpl$Data$declaredNonStaticMembers$2(p0).map(new Function() { // from class: id.dana.feeds.data.detail.FeedsDetailEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsDetailEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((BaseRpcResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.detail.FeedsDetailRepository
    public final Observable<FeedCommentResult> PlaceComponentResult(String p0, String p1, String p2, Integer p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        String blockingFirst = this.BuiltInFictitiousFunctionClassFactory.get().createData2("local").getPhoneNumber().blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        SocialPreferencesDataFactory socialPreferencesDataFactory = this.getAuthRequestContext.get();
        Intrinsics.checkNotNullParameter("local", "");
        final Set<String> BuiltInFictitiousFunctionClassFactory = new LocalSocialPreferencesData(socialPreferencesDataFactory.PlaceComponentResult).BuiltInFictitiousFunctionClassFactory(blockingFirst, p0);
        Observable<FetchActivityCommentsResponse> authRequestContext = this.PlaceComponentResult.get().createData2("network").getAuthRequestContext(p0, p1, p2, p3);
        final Function1<FetchActivityCommentsResponse, FetchActivityCommentsResponse> function1 = new Function1<FetchActivityCommentsResponse, FetchActivityCommentsResponse>() { // from class: id.dana.feeds.data.detail.FeedsDetailEntityRepository$mapDeviceName$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FetchActivityCommentsResponse invoke(FetchActivityCommentsResponse fetchActivityCommentsResponse) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(fetchActivityCommentsResponse, "");
                List<CommentResponse> comments = fetchActivityCommentsResponse.getComments();
                if (comments != null) {
                    List<CommentResponse> list = comments;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((CommentResponse) it.next()).getUser());
                    }
                    final ArrayList arrayList2 = arrayList;
                    final FeedsDetailEntityRepository feedsDetailEntityRepository = FeedsDetailEntityRepository.this;
                    lazy = feedsDetailEntityRepository.MyBillsEntityDataFactory;
                    Object obj = lazy.get();
                    Intrinsics.checkNotNullExpressionValue(obj, "");
                    ContactDeviceNameMapper.PlaceComponentResult((ContactDeviceNameMapper) obj, arrayList2, new Function0<Unit>() { // from class: id.dana.feeds.data.detail.FeedsDetailEntityRepository$mapDeviceName$1$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
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
                            FeedsDetailEntityRepository.MyBillsEntityDataFactory(arrayList2);
                        }
                    }, null, 4);
                }
                return fetchActivityCommentsResponse;
            }
        };
        Observable<R> map = authRequestContext.map(new Function() { // from class: id.dana.feeds.data.detail.FeedsDetailEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsDetailEntityRepository.MyBillsEntityDataFactory(Function1.this, (FetchActivityCommentsResponse) obj);
            }
        });
        final Function1<FetchActivityCommentsResponse, FeedCommentResult> function12 = new Function1<FetchActivityCommentsResponse, FeedCommentResult>() { // from class: id.dana.feeds.data.detail.FeedsDetailEntityRepository$filterReportedComment$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FeedCommentResult invoke(FetchActivityCommentsResponse fetchActivityCommentsResponse) {
                Intrinsics.checkNotNullParameter(fetchActivityCommentsResponse, "");
                FeedCommentResult feedCommentResult = fetchActivityCommentsResponse.toFeedCommentResult();
                Set<String> set = BuiltInFictitiousFunctionClassFactory;
                int size = feedCommentResult.getComments().size();
                List<Comment> comments = feedCommentResult.getComments();
                ArrayList arrayList = new ArrayList();
                for (Object obj : comments) {
                    if (!set.contains(((Comment) obj).getId())) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : arrayList) {
                    if (!((Comment) obj2).getHasReport()) {
                        arrayList2.add(obj2);
                    }
                }
                feedCommentResult.setComments(arrayList2);
                feedCommentResult.setNumberOfReportedComments(size - feedCommentResult.getComments().size());
                return feedCommentResult;
            }
        };
        Observable<FeedCommentResult> map2 = map.map(new Function() { // from class: id.dana.feeds.data.detail.FeedsDetailEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsDetailEntityRepository.PlaceComponentResult(Function1.this, (FetchActivityCommentsResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "");
        return map2;
    }

    @Override // id.dana.feeds.domain.detail.FeedsDetailRepository
    public final Observable<Boolean> MyBillsEntityDataFactory(final String p0, String p1, final String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        final String blockingFirst = this.BuiltInFictitiousFunctionClassFactory.get().createData2("local").getPhoneNumber().blockingFirst();
        Observable map = this.PlaceComponentResult.get().createData2("network").PlaceComponentResult(p0, p1).onErrorResumeNext(new Function() { // from class: id.dana.feeds.data.detail.FeedsDetailEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsDetailEntityRepository.BuiltInFictitiousFunctionClassFactory((Throwable) obj);
            }
        }).doOnNext(new Consumer() { // from class: id.dana.feeds.data.detail.FeedsDetailEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BaseRpcResult baseRpcResult = (BaseRpcResult) obj;
                FeedsDetailEntityRepository.PlaceComponentResult(FeedsDetailEntityRepository.this, blockingFirst, p2, p0);
            }
        }).map(new Function() { // from class: id.dana.feeds.data.detail.FeedsDetailEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsDetailEntityRepository.BuiltInFictitiousFunctionClassFactory((BaseRpcResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }
}
