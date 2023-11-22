package id.dana.data.config.source;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import id.dana.data.account.repository.source.preference.PreferenceAccountEntityData;
import id.dana.data.config.model.FeedCacheData;
import id.dana.data.config.source.sharedpreference.SocialFeedWrapperModelEntityData;
import id.dana.data.config.source.sharedpreference.ThirdPartyServiceEntityData;
import id.dana.data.storage.PreferenceFacade;
import id.dana.domain.DefaultObserver;
import id.dana.domain.homeinfo.HomeWidgetClearable;
import id.dana.domain.social.InitStatus;
import id.dana.domain.social.model.FeedConfig;
import id.dana.domain.social.model.FeedInit;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u001b\b\u0007\u0012\b\b\u0001\u0010&\u001a\u00020%\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001c8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\"8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b&\u0010'"}, d2 = {"Lid/dana/data/config/source/SecuredPrefHomeWidgetData;", "Lid/dana/data/config/source/HomeWidgetEntityData;", "Lid/dana/domain/homeinfo/HomeWidgetClearable;", "", "clearHomeWidgetCache", "()V", "Lid/dana/data/config/model/FeedCacheData;", "getFeedData", "()Lid/dana/data/config/model/FeedCacheData;", "", "Lid/dana/data/config/source/sharedpreference/ThirdPartyServiceEntityData;", "getServices", "()Ljava/util/List;", "Lid/dana/domain/social/model/FeedConfig;", "feedConfig", "saveFeedHomeConfig", "(Lid/dana/domain/social/model/FeedConfig;)V", "Lid/dana/domain/social/InitStatus;", "initStatus", "saveFeedInitState", "(Lid/dana/domain/social/InitStatus;)V", "thirdPartyServices", "saveServices", "(Ljava/util/List;)V", "Lid/dana/data/config/source/sharedpreference/SocialFeedWrapperModelEntityData;", "socialFeed", "saveSocialFeed", "(Lid/dana/data/config/source/sharedpreference/SocialFeedWrapperModelEntityData;)V", "Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "getGson", "()Lcom/google/gson/Gson;", "gson", "Lid/dana/data/account/repository/source/preference/PreferenceAccountEntityData;", "preferenceAccountEntityData", "Lid/dana/data/account/repository/source/preference/PreferenceAccountEntityData;", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "<init>", "(Lid/dana/data/storage/PreferenceFacade;Lid/dana/data/account/repository/source/preference/PreferenceAccountEntityData;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SecuredPrefHomeWidgetData implements HomeWidgetEntityData, HomeWidgetClearable {
    public static final String FEED_ACTIVITIES = "feedactivities";
    public static final String FEED_CONFIG = "feedconfig";
    public static final String FEED_INIT = "feedinit";
    public static final String SERVICES_HOME = "serviceshome";

    /* renamed from: gson$delegate  reason: from kotlin metadata */
    private final Lazy gson;
    private final PreferenceAccountEntityData preferenceAccountEntityData;
    private final PreferenceFacade preferenceFacade;

    @Inject
    public SecuredPrefHomeWidgetData(@Named("homewidget") PreferenceFacade preferenceFacade, PreferenceAccountEntityData preferenceAccountEntityData) {
        Intrinsics.checkNotNullParameter(preferenceFacade, "");
        Intrinsics.checkNotNullParameter(preferenceAccountEntityData, "");
        this.preferenceFacade = preferenceFacade;
        this.preferenceAccountEntityData = preferenceAccountEntityData;
        this.gson = LazyKt.lazy(new Function0<Gson>() { // from class: id.dana.data.config.source.SecuredPrefHomeWidgetData$gson$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Gson invoke() {
                return new Gson();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "getGson")
    public final Gson getGson() {
        return (Gson) this.gson.getValue();
    }

    @Override // id.dana.data.config.source.HomeWidgetEntityData
    public final void saveFeedInitState(InitStatus initStatus) {
        Intrinsics.checkNotNullParameter(initStatus, "");
        this.preferenceFacade.saveData(FEED_INIT, initStatus.getStatus());
    }

    @Override // id.dana.data.config.source.HomeWidgetEntityData
    public final void saveFeedHomeConfig(FeedConfig feedConfig) {
        Intrinsics.checkNotNullParameter(feedConfig, "");
        this.preferenceFacade.saveData(FEED_CONFIG, getGson().toJson(feedConfig));
    }

    @Override // id.dana.data.config.source.HomeWidgetEntityData
    public final void saveSocialFeed(SocialFeedWrapperModelEntityData socialFeed) {
        Intrinsics.checkNotNullParameter(socialFeed, "");
        this.preferenceFacade.saveData(FEED_ACTIVITIES, getGson().toJson(socialFeed));
    }

    @Override // id.dana.data.config.source.HomeWidgetEntityData
    public final FeedCacheData getFeedData() {
        FeedCacheData feedCacheData = new FeedCacheData();
        String string = this.preferenceFacade.getString(FEED_CONFIG);
        if (string != null) {
            Intrinsics.checkNotNullExpressionValue(string, "");
            feedCacheData.setFeedConfig((FeedConfig) getGson().fromJson(string, FeedConfig.class));
        }
        String string2 = this.preferenceFacade.getString(FEED_ACTIVITIES);
        if (string2 != null) {
            Intrinsics.checkNotNullExpressionValue(string2, "");
            feedCacheData.setSocialFeed((SocialFeedWrapperModelEntityData) getGson().fromJson(string2, SocialFeedWrapperModelEntityData.class));
        }
        String string3 = this.preferenceFacade.getString(FEED_INIT);
        if (string3 != null) {
            Intrinsics.checkNotNullExpressionValue(string3, "");
            feedCacheData.setFeedInit(new FeedInit(0, InitStatus.valueOf(string3)));
        }
        return feedCacheData;
    }

    @Override // id.dana.data.config.source.HomeWidgetEntityData
    public final void saveServices(final List<ThirdPartyServiceEntityData> thirdPartyServices) {
        Intrinsics.checkNotNullParameter(thirdPartyServices, "");
        this.preferenceAccountEntityData.getUserId().subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(Schedulers.MyBillsEntityDataFactory()).subscribe(new DefaultObserver<String>() { // from class: id.dana.data.config.source.SecuredPrefHomeWidgetData$saveServices$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onNext(String userId) {
                PreferenceFacade preferenceFacade;
                Gson gson;
                Intrinsics.checkNotNullParameter(userId, "");
                super.onNext((SecuredPrefHomeWidgetData$saveServices$1) userId);
                if (userId.length() > 0) {
                    preferenceFacade = SecuredPrefHomeWidgetData.this.preferenceFacade;
                    StringBuilder sb = new StringBuilder();
                    sb.append("serviceshome_");
                    sb.append(userId);
                    String obj = sb.toString();
                    gson = SecuredPrefHomeWidgetData.this.getGson();
                    preferenceFacade.saveData(obj, gson.toJson(thirdPartyServices));
                }
            }
        });
    }

    @Override // id.dana.data.config.source.HomeWidgetEntityData
    public final List<ThirdPartyServiceEntityData> getServices() {
        List m3179constructorimpl;
        List list;
        try {
            Result.Companion companion = Result.INSTANCE;
            SecuredPrefHomeWidgetData securedPrefHomeWidgetData = this;
            String blockingFirst = this.preferenceAccountEntityData.getUserId().subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(Schedulers.MyBillsEntityDataFactory()).blockingFirst();
            PreferenceFacade preferenceFacade = this.preferenceFacade;
            StringBuilder sb = new StringBuilder();
            sb.append("serviceshome_");
            sb.append(blockingFirst);
            String string = preferenceFacade.getString(sb.toString());
            if (string != null) {
                Intrinsics.checkNotNullExpressionValue(string, "");
                list = (List) getGson().fromJson(string, TypeToken.getParameterized(List.class, ThirdPartyServiceEntityData.class).getType());
            } else {
                list = null;
            }
            m3179constructorimpl = Result.m3179constructorimpl(list);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m3182exceptionOrNullimpl = Result.m3182exceptionOrNullimpl(m3179constructorimpl);
        if (m3182exceptionOrNullimpl != null) {
            DanaLog.BuiltInFictitiousFunctionClassFactory("Service Cache Error", m3182exceptionOrNullimpl.getMessage());
        }
        List emptyList = CollectionsKt.emptyList();
        if (Result.m3185isFailureimpl(m3179constructorimpl)) {
            m3179constructorimpl = emptyList;
        }
        return (List) m3179constructorimpl;
    }

    @Override // id.dana.domain.homeinfo.HomeWidgetClearable
    public final void clearHomeWidgetCache() {
        this.preferenceFacade.clearAllData();
    }
}
