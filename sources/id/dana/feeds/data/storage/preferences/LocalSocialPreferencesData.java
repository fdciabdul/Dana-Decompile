package id.dana.feeds.data.storage.preferences;

import id.dana.data.storage.PreferenceFacade;
import id.dana.domain.social.InitStatus;
import id.dana.domain.social.model.FeedInit;
import id.dana.feeds.data.config.model.FeedConfigResult;
import id.dana.feeds.data.share.source.local.model.CreateFeedActivityEntity;
import id.dana.feeds.domain.share.model.PreviewActivityData;
import id.dana.feeds.domain.timeline.enums.FeedActivityState;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020/¢\u0006\u0004\b1\u00102J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0010J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\t2\u0006\u0010\u0003\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0014J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0010J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0010J\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u0017J!\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0018J%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\u001aJ\u0019\u0010\u0006\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010\u001bJ\u0019\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u001bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00042\u0006\u0010\u0003\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\u0017J\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\t2\u0006\u0010\u0003\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u0013J\u001f\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010\u000eJ\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u001fJ\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\r\u0010 J\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010!J-\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u0019H\u0016¢\u0006\u0004\b\u000b\u0010#J%\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00110\tH\u0016¢\u0006\u0004\b\u0016\u0010\fJ%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\r\u0010$J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u000b\u0010%J%\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010\u0017J'\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010'J\u001f\u0010(\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b(\u0010\u000eJ\u001f\u0010&\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010\u000eJ\u001f\u0010)\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b)\u0010\u000eJ'\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\"\u001a\u00020*H\u0016¢\u0006\u0004\b\u0016\u0010+J%\u0010\r\u001a\u00020-2\u0006\u0010\u0003\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00110,H\u0016¢\u0006\u0004\b\r\u0010.R\u0016\u0010\u000b\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u00100"}, d2 = {"Lid/dana/feeds/data/storage/preferences/LocalSocialPreferencesData;", "Lid/dana/feeds/data/storage/preferences/SocialPreferencesData;", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "p0", "Lio/reactivex/Observable;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/feeds/domain/timeline/model/SocialFeed;)Lio/reactivex/Observable;", "", "", "p1", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/util/List;)Z", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;)Z", "Lid/dana/feeds/data/config/model/FeedConfigResult;", "()Lio/reactivex/Observable;", "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "getAuthRequestContext", "(Ljava/lang/String;)Ljava/util/List;", "()Lid/dana/feeds/domain/timeline/model/SocialFeed;", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Lio/reactivex/Observable;", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/feeds/domain/share/model/PreviewActivityData;", "", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Set;", "(Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/domain/social/model/FeedInit;", "Lid/dana/feeds/data/share/source/local/model/CreateFeedActivityEntity;", "lookAheadTest", "(I)Z", "(Ljava/lang/String;Lid/dana/feeds/data/share/source/local/model/CreateFeedActivityEntity;)Z", "(Z)Lio/reactivex/Observable;", "p2", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)Z", "(Ljava/lang/String;Lid/dana/domain/social/model/FeedInit;)Lio/reactivex/Observable;", "(Lid/dana/feeds/data/config/model/FeedConfigResult;)Z", "getErrorConfigVersion", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/feeds/domain/share/model/PreviewActivityData;)Z", "moveToNextValue", "scheduleImpl", "Lid/dana/feeds/domain/timeline/enums/FeedActivityState;", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/feeds/domain/timeline/enums/FeedActivityState;)Z", "", "", "(Ljava/lang/String;Ljava/util/List;)V", "Lid/dana/feeds/data/storage/preferences/SocialPreferences;", "Lid/dana/feeds/data/storage/preferences/SocialPreferences;", "<init>", "(Lid/dana/feeds/data/storage/preferences/SocialPreferences;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocalSocialPreferencesData implements SocialPreferencesData {
    private SocialPreferences BuiltInFictitiousFunctionClassFactory;

    public LocalSocialPreferencesData(SocialPreferences socialPreferences) {
        Intrinsics.checkNotNullParameter(socialPreferences, "");
        this.BuiltInFictitiousFunctionClassFactory = socialPreferences;
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final Observable<Boolean> PlaceComponentResult(String p0, FeedInit p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(p0, p1)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final Observable<FeedInit> BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (!this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult()) {
            Observable<FeedInit> just = Observable.just(new FeedInit(0, InitStatus.NOT_ACTIVATED, 1, null));
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }
        Observable<FeedInit> just2 = Observable.just(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(p0));
        Intrinsics.checkNotNullExpressionValue(just2, "");
        return just2;
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final Observable<Boolean> KClassImpl$Data$declaredNonStaticMembers$2(SocialFeed p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p0.getGroupedActivities().size() < 3 || p0.getActivities().size() < 3) {
            SocialFeed authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(p0.getActivities());
            arrayList.addAll(authRequestContext.getActivities());
            List take = CollectionsKt.take(arrayList, 20);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(p0.getGroupedActivities());
            arrayList2.addAll(authRequestContext.getGroupedActivities());
            Observable<Boolean> just = Observable.just(Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new SocialFeed(p0.getHasMore(), p0.getMaxId(), take, p0.getFeedVersion(), CollectionsKt.take(arrayList2, 20), p0.getMinId(), p0.getFromCache()))));
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }
        Observable<Boolean> just2 = Observable.just(Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(p0)));
        Intrinsics.checkNotNullExpressionValue(just2, "");
        return just2;
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final SocialFeed getAuthRequestContext() {
        return this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final Set<String> BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        SocialPreferences socialPreferences = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        PreferenceFacade preferenceFacade = socialPreferences.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append(p1);
        sb.append("feed_reported_comment_id");
        Set<String> set = (Set) preferenceFacade.getObject(sb.toString(), Set.class);
        return set == null ? SetsKt.emptySet() : set;
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final boolean BuiltInFictitiousFunctionClassFactory(String p0, String p1, Set<String> p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        return this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(p0, p1, p2);
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final Observable<Boolean> PlaceComponentResult(boolean p0) {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(p0)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final Observable<Boolean> MyBillsEntityDataFactory() {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final boolean PlaceComponentResult(String p0, CreateFeedActivityEntity p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(p0, p1);
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final boolean PlaceComponentResult(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(p0, p1);
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final boolean BuiltInFictitiousFunctionClassFactory(String p0, List<String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(p0, p1);
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final boolean MyBillsEntityDataFactory(String p0, String p1, FeedActivityState p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
        if (p2 == FeedActivityState.SUCCESS) {
            this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(p0, p1);
            return true;
        }
        this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(p0, p1, p2);
        return true;
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final List<CreateFeedActivityEntity> lookAheadTest(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        List<String> MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(p0);
        ArrayList arrayList = new ArrayList();
        for (String str : MyBillsEntityDataFactory) {
            SocialPreferences socialPreferences = this.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullParameter(str, "");
            CreateFeedActivityEntity createFeedActivityEntity = (CreateFeedActivityEntity) socialPreferences.MyBillsEntityDataFactory.getObject(str, CreateFeedActivityEntity.class);
            if (createFeedActivityEntity != null) {
                arrayList.add(createFeedActivityEntity);
            }
        }
        return arrayList;
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final boolean MyBillsEntityDataFactory(String p0, String p1, PreviewActivityData p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        return this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(p0, p1, p2);
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final boolean getAuthRequestContext(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final boolean moveToNextValue(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(p0, p1);
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(p0, p1);
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final PreviewActivityData MyBillsEntityDataFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        SocialPreferences socialPreferences = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        PreferenceFacade preferenceFacade = socialPreferences.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append(p1);
        sb.append("preview_activity");
        return (PreviewActivityData) preferenceFacade.getObject(sb.toString(), PreviewActivityData.class);
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final String KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        SocialPreferences socialPreferences = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(p0, "");
        PreferenceFacade preferenceFacade = socialPreferences.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append("share_feed_request_id_last_transaction");
        return preferenceFacade.getString(sb.toString());
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final Observable<FeedConfigResult> BuiltInFictitiousFunctionClassFactory() {
        Object object = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getObject("feed_config", FeedConfigResult.class);
        Intrinsics.checkNotNullExpressionValue(object, "");
        Observable<FeedConfigResult> just = Observable.just((FeedConfigResult) object);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final boolean BuiltInFictitiousFunctionClassFactory(FeedConfigResult p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(p0);
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final String MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        SocialPreferences socialPreferences = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(p0, "");
        PreferenceFacade preferenceFacade = socialPreferences.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append("_banner_lastMaxId");
        String string = preferenceFacade.getString(sb.toString());
        return string == null ? "" : string;
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final boolean getErrorConfigVersion(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(p0, p1);
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final List<PreviewActivityData> getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0);
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final boolean MyBillsEntityDataFactory(String p0, List<PreviewActivityData> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(p0, p1);
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final boolean scheduleImpl(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return this.BuiltInFictitiousFunctionClassFactory.scheduleImpl(p0, p1);
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final void PlaceComponentResult(String p0, List<PreviewActivityData> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(p0);
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(p0, p1);
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final Observable<Boolean> PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(p0)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final Observable<Boolean> getErrorConfigVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0(str)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final boolean MyBillsEntityDataFactory(int p0) {
        return this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(p0);
    }

    @Override // id.dana.feeds.data.storage.preferences.SocialPreferencesData
    public final Observable<Integer> KClassImpl$Data$declaredNonStaticMembers$2() {
        Integer integer = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getInteger("feed_timeline_version");
        Intrinsics.checkNotNullExpressionValue(integer, "");
        Observable<Integer> just = Observable.just(Integer.valueOf(integer.intValue()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
