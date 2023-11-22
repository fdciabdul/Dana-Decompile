package id.dana.feeds.data.storage.preferences;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.alipay.iap.android.common.product.delegate.IAPLoginUserInfo;
import com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.data.storage.SimpleSecureKeyPreference;
import id.dana.domain.social.InitStatus;
import id.dana.domain.social.model.FeedInit;
import id.dana.domain.social.model.InitFeed;
import id.dana.feeds.data.config.model.FeedConfigResult;
import id.dana.feeds.data.share.source.local.model.CreateFeedActivityEntity;
import id.dana.feeds.domain.share.model.PreviewActivityData;
import id.dana.feeds.domain.timeline.enums.FeedActivityState;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 >2\u00020\u0001:\u0001>B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u000202\u0012\u0006\u0010\r\u001a\u000209¢\u0006\u0004\b<\u0010=J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\bJ\u0013\u0010\n\u001a\u0006*\u00020\t0\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u0010J\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\f2\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0012J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0015J\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0016J\r\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\bJ\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\bJ\u0015\u0010\u000e\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u001aJ\u001d\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0010J\u001d\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u001b¢\u0006\u0004\b\u0011\u0010\u001cJ\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u001dJ%\u0010\u0005\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\fH\u0002¢\u0006\u0004\b\u0005\u0010\u001fJ+\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070 ¢\u0006\u0004\b\u0017\u0010\"J#\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0004\b\u0011\u0010\u000fJ\u001d\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0010J\u001d\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0019¢\u0006\u0004\b\u000e\u0010#J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020$¢\u0006\u0004\b\u0005\u0010%J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020&¢\u0006\u0004\b\u0005\u0010'J\u0015\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b(\u0010\u0016J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020$¢\u0006\u0004\b\u0011\u0010%J\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020$¢\u0006\u0004\b\u0017\u0010%J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020)¢\u0006\u0004\b\u0011\u0010*J\u0015\u0010+\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b+\u0010\u0016J\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020$¢\u0006\u0004\b\u000e\u0010%J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020$¢\u0006\u0004\b\u0014\u0010%J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020)¢\u0006\u0004\b\u0005\u0010*J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\bJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010,J\u001d\u0010+\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b+\u0010\bJ\u001f\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010,J\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020)2\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010-J%\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0013¢\u0006\u0004\b\u0011\u0010.J\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\u0010J\u001d\u0010/\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b/\u0010\u0010J%\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010!\u001a\u000200¢\u0006\u0004\b\u0017\u00101R\u0014\u0010\u0014\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u00103R\u0014\u0010\u0005\u001a\u00020\u00048GX\u0086\u0006¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0016R\u001d\u0010\u000e\u001a\f\u0012\b\u0012\u0006*\u0002050504X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0014\u00106R\u0016\u0010\u0011\u001a\u0002078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000e\u00108R\u0014\u0010\u0017\u001a\u0002098\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010:R\u0014\u0010\u0018\u001a\u00020\u00078\u0002X\u0083D¢\u0006\u0006\n\u0004\b\u0011\u0010;"}, d2 = {"Lid/dana/feeds/data/storage/preferences/SocialPreferences;", "", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "p0", "", "getAuthRequestContext", "(Lid/dana/feeds/domain/timeline/model/SocialFeed;)Z", "", "(Ljava/lang/String;)Z", "Lid/dana/data/storage/LocalStorageFactory$Builder;", "moveToNextValue", "()Lid/dana/data/storage/LocalStorageFactory$Builder;", "", "p1", "PlaceComponentResult", "(Ljava/lang/String;Ljava/util/List;)Z", "(Ljava/lang/String;Ljava/lang/String;)Z", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Ljava/util/List;", "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/feeds/domain/timeline/model/SocialFeed;", "()Z", "BuiltInFictitiousFunctionClassFactory", "lookAheadTest", "Lid/dana/domain/social/model/FeedInit;", "(Ljava/lang/String;)Lid/dana/domain/social/model/FeedInit;", "Lid/dana/feeds/data/share/source/local/model/CreateFeedActivityEntity;", "(Ljava/lang/String;Lid/dana/feeds/data/share/source/local/model/CreateFeedActivityEntity;)Z", "(Z)Z", "", "(Ljava/lang/String;Ljava/util/List;)V", "", "p2", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)Z", "(Ljava/lang/String;Lid/dana/domain/social/model/FeedInit;)Z", "", "(I)Z", "Lid/dana/feeds/data/config/model/FeedConfigResult;", "(Lid/dana/feeds/data/config/model/FeedConfigResult;)Z", "getErrorConfigVersion", "", "(J)Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "(ILjava/lang/String;)Z", "(JLjava/lang/String;)Z", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/feeds/domain/share/model/PreviewActivityData;)Z", "scheduleImpl", "Lid/dana/feeds/domain/timeline/enums/FeedActivityState;", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/feeds/domain/timeline/enums/FeedActivityState;)Z", "Landroid/content/Context;", "Landroid/content/Context;", "Lio/reactivex/subjects/BehaviorSubject;", "Lid/dana/domain/social/model/InitFeed;", "Lkotlin/Lazy;", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/Serializer;", "Lid/dana/data/storage/Serializer;", "Ljava/lang/String;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SocialPreferences {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Lazy PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final String lookAheadTest;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public PreferenceFacade MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Serializer BuiltInFictitiousFunctionClassFactory;

    @Inject
    public SocialPreferences(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.BuiltInFictitiousFunctionClassFactory = serializer;
        this.lookAheadTest = "SocialPreferences production";
        PreferenceFacade createData2 = new LocalStorageFactory(moveToNextValue()).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.MyBillsEntityDataFactory = new SimpleSecureKeyPreference(createData2);
        UserInfoManager.instance().addUserChangeObserver(new IAPUserChangeObserver() { // from class: id.dana.feeds.data.storage.preferences.SocialPreferences$initUserInfoObserver$1
            @Override // com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver
            public final void onUserChanged(IAPLoginUserInfo p0) {
            }

            @Override // com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver
            public final void onUserLogout() {
            }

            @Override // com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver
            public final void onUserLogin(IAPLoginUserInfo p0) {
                PreferenceFacade createData22;
                SocialPreferences socialPreferences = SocialPreferences.this;
                createData22 = new LocalStorageFactory(socialPreferences.moveToNextValue()).createData2("local");
                Intrinsics.checkNotNullExpressionValue(createData22, "");
                socialPreferences.MyBillsEntityDataFactory = new SimpleSecureKeyPreference(createData22);
            }
        });
        this.PlaceComponentResult = LazyKt.lazy(new Function0<BehaviorSubject<InitFeed>>() { // from class: id.dana.feeds.data.storage.preferences.SocialPreferences$initFeedObservable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BehaviorSubject<InitFeed> invoke() {
                BehaviorSubject<InitFeed> BuiltInFictitiousFunctionClassFactory = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
                BuiltInFictitiousFunctionClassFactory.onNext(new InitFeed(InitStatus.NOT_ACTIVATED, 0, null, false, 12, null));
                return BuiltInFictitiousFunctionClassFactory;
            }
        });
    }

    private final LocalStorageFactory.Builder moveToNextValue() {
        return new LocalStorageFactory.Builder(this.KClassImpl$Data$declaredNonStaticMembers$2).setPreferenceGroup(this.lookAheadTest).setPassword(UserInfoManager.instance().getUserId()).setSerializerFacade(this.BuiltInFictitiousFunctionClassFactory);
    }

    @JvmName(name = "PlaceComponentResult")
    public final boolean PlaceComponentResult() {
        Boolean bool = this.MyBillsEntityDataFactory.getBoolean("device_Feed_feature_switch", false);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }

    public final boolean PlaceComponentResult(int p0) {
        MyBillsEntityDataFactory(p0, "following_full_sync_last_page");
        return true;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return lookAheadTest("following_full_sync_finished");
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        moveToNextValue("following_full_sync_finished");
        return true;
    }

    public final boolean getAuthRequestContext(long p0) {
        MyBillsEntityDataFactory(p0, "following_partial_sync_modified_time");
        return true;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
        StringBuilder sb = new StringBuilder();
        sb.append("following_partial_sync_last_page");
        Long l = this.MyBillsEntityDataFactory.getLong("following_partial_sync_modified_time");
        sb.append(l == null ? 0L : l.longValue());
        BuiltInFictitiousFunctionClassFactory(p0, sb.toString());
        return true;
    }

    public final boolean MyBillsEntityDataFactory(int p0) {
        MyBillsEntityDataFactory(p0, "follower_full_sync_last_page");
        return true;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return lookAheadTest("follower_full_sync_finished");
    }

    public final boolean getErrorConfigVersion() {
        moveToNextValue("follower_full_sync_finished");
        return true;
    }

    public final boolean MyBillsEntityDataFactory(long p0) {
        MyBillsEntityDataFactory(p0, "follower_partial_sync_modified_time");
        return true;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(int p0) {
        StringBuilder sb = new StringBuilder();
        sb.append("follower_partial_sync_last_page");
        Long l = this.MyBillsEntityDataFactory.getLong("follower_partial_sync_modified_time");
        sb.append(l == null ? 0L : l.longValue());
        BuiltInFictitiousFunctionClassFactory(p0, sb.toString());
        return true;
    }

    private final boolean MyBillsEntityDataFactory(int p0, String p1) {
        this.MyBillsEntityDataFactory.saveData(p1, Integer.valueOf(p0));
        return true;
    }

    private final boolean lookAheadTest(String p0) {
        Boolean bool = this.MyBillsEntityDataFactory.getBoolean(p0);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private final boolean moveToNextValue(String str) {
        this.MyBillsEntityDataFactory.saveData(str, Boolean.TRUE);
        return true;
    }

    private final boolean MyBillsEntityDataFactory(long p0, String p1) {
        this.MyBillsEntityDataFactory.saveData(p1, Long.valueOf(p0));
        return true;
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(int p0, String p1) {
        this.MyBillsEntityDataFactory.saveData(p1, Integer.valueOf(p0));
        return true;
    }

    public final FeedInit PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append("social_widget_init_status");
        FeedInit feedInit = (FeedInit) preferenceFacade.getObject(sb.toString(), FeedInit.class);
        if (feedInit == null) {
            return new FeedInit(0, InitStatus.NOT_ACTIVATED, 1, null);
        }
        return feedInit;
    }

    public final boolean PlaceComponentResult(String p0, FeedInit p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append("social_widget_init_status");
        preferenceFacade.saveData(sb.toString(), (String) p1);
        return true;
    }

    public final boolean getAuthRequestContext(SocialFeed p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.saveData("cached_timeline_key", (String) p0);
        return true;
    }

    public final SocialFeed getAuthRequestContext() {
        SocialFeed socialFeed = (SocialFeed) this.MyBillsEntityDataFactory.getObject("cached_timeline_key", SocialFeed.class);
        if (socialFeed == null) {
            socialFeed = new SocialFeed(false, null, null, 0, null, null, false, 127, null);
        }
        socialFeed.setFromCache(true);
        return socialFeed;
    }

    public final boolean MyBillsEntityDataFactory(boolean p0) {
        this.MyBillsEntityDataFactory.saveData("feeds_sharing_last_checked", Boolean.valueOf(p0));
        return true;
    }

    public final boolean MyBillsEntityDataFactory() {
        Boolean bool = this.MyBillsEntityDataFactory.getBoolean("feeds_sharing_last_checked", true);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(String p0, String p1, Set<String> p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append(p1);
        sb.append("feed_reported_comment_id");
        preferenceFacade.saveData(sb.toString(), (String) p2);
        return true;
    }

    public final boolean MyBillsEntityDataFactory(String p0, CreateFeedActivityEntity p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append(p1.KClassImpl$Data$declaredNonStaticMembers$2.getShareFeedRequestId());
        sb.append("create_feed_activity");
        String obj = sb.toString();
        List mutableList = CollectionsKt.toMutableList((Collection) MyBillsEntityDataFactory(p0));
        if (!mutableList.contains(obj)) {
            mutableList.add(0, obj);
            PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(p0);
            sb2.append("create_activity_list");
            preferenceFacade.saveData(sb2.toString(), (String) mutableList);
        }
        this.MyBillsEntityDataFactory.saveData(obj, (String) p1);
        return true;
    }

    public final List<String> MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append("create_activity_list");
        List<String> list = (List) preferenceFacade.getObject(sb.toString(), List.class);
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final boolean PlaceComponentResult(String p0, List<String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        List<String> mutableList = CollectionsKt.toMutableList((Collection) MyBillsEntityDataFactory(p0));
        for (String str : p1) {
            StringBuilder sb = new StringBuilder();
            sb.append(p0);
            sb.append(str);
            sb.append("create_feed_activity");
            String obj = sb.toString();
            this.MyBillsEntityDataFactory.clearData(obj);
            mutableList.remove(obj);
        }
        getAuthRequestContext(p0, mutableList);
        return true;
    }

    public final boolean PlaceComponentResult(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append(p1);
        sb.append("create_feed_activity");
        String obj = sb.toString();
        List<String> mutableList = CollectionsKt.toMutableList((Collection) MyBillsEntityDataFactory(p0));
        if (mutableList.contains(obj)) {
            mutableList.remove(obj);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(p0);
            sb2.append(p1);
            sb2.append("create_feed_activity");
            this.MyBillsEntityDataFactory.clearData(sb2.toString());
            PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(p0);
            sb3.append("create_activity_list");
            preferenceFacade.saveData(sb3.toString(), (String) mutableList);
        }
        getAuthRequestContext(p0, mutableList);
        return true;
    }

    private final void getAuthRequestContext(String p0, List<String> p1) {
        if (p1.isEmpty()) {
            PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
            StringBuilder sb = new StringBuilder();
            sb.append(p0);
            sb.append("create_activity_list");
            preferenceFacade.clearData(sb.toString());
            return;
        }
        PreferenceFacade preferenceFacade2 = this.MyBillsEntityDataFactory;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(p0);
        sb2.append("create_activity_list");
        preferenceFacade2.saveData(sb2.toString(), (String) p1);
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(String p0, String p1, FeedActivityState p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append(p1);
        sb.append("create_feed_activity");
        CreateFeedActivityEntity createFeedActivityEntity = (CreateFeedActivityEntity) preferenceFacade.getObject(sb.toString(), CreateFeedActivityEntity.class);
        Intrinsics.checkNotNullParameter(p2, "");
        createFeedActivityEntity.PlaceComponentResult = p2;
        PreferenceFacade preferenceFacade2 = this.MyBillsEntityDataFactory;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(p0);
        sb2.append(p1);
        sb2.append("create_feed_activity");
        preferenceFacade2.saveData(sb2.toString(), (String) createFeedActivityEntity);
        return true;
    }

    public final boolean MyBillsEntityDataFactory(String p0, String p1, PreviewActivityData p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append(p1);
        sb.append("preview_activity");
        preferenceFacade.saveData(sb.toString(), (String) p2);
        return true;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append(p1);
        sb.append("preview_activity");
        preferenceFacade.clearData(sb.toString());
        return true;
    }

    public final boolean getAuthRequestContext(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append("share_feed_request_id_last_transaction");
        preferenceFacade.saveData(sb.toString(), p1);
        return true;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append("share_feed_request_id_last_transaction");
        if (Intrinsics.areEqual(preferenceFacade.getString(sb.toString()), p1)) {
            PreferenceFacade preferenceFacade2 = this.MyBillsEntityDataFactory;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(p0);
            sb2.append("share_feed_request_id_last_transaction");
            preferenceFacade2.clearData(sb2.toString());
            return true;
        }
        return true;
    }

    public final boolean getAuthRequestContext(FeedConfigResult p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.saveData("feed_config", JSONExtKt.PlaceComponentResult().toJson(p0));
        return true;
    }

    public final boolean MyBillsEntityDataFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append("_banner_lastMaxId");
        preferenceFacade.saveData(sb.toString(), p1);
        return true;
    }

    public final boolean MyBillsEntityDataFactory(String p0, List<PreviewActivityData> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append("_feed_banner_list");
        preferenceFacade.saveData(sb.toString(), (String) p1);
        return true;
    }

    public final List<PreviewActivityData> KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append("_feed_banner_list");
        List list = (List) preferenceFacade.getObject(sb.toString(), List.class);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object parseObject = JSONObject.parseObject(((JSONObject) it.next()).toJSONString(), PreviewActivityData.class);
            Intrinsics.checkNotNullExpressionValue(parseObject, "");
            arrayList.add(parseObject);
        }
        return arrayList;
    }

    public final boolean scheduleImpl(String p0, String p1) {
        Object obj;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        List<PreviewActivityData> mutableList = CollectionsKt.toMutableList((Collection) KClassImpl$Data$declaredNonStaticMembers$2(p0));
        Iterator<T> it = mutableList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((PreviewActivityData) obj).getShareFeedRequestId(), p1)) {
                break;
            }
        }
        PreviewActivityData previewActivityData = (PreviewActivityData) obj;
        if (previewActivityData != null) {
            previewActivityData.setSkip(true);
        }
        MyBillsEntityDataFactory(p0, mutableList);
        return true;
    }

    public final boolean getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append("_feed_banner_list");
        preferenceFacade.clearData(sb.toString());
        return true;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append("_has_fetched_user_config_v2");
        Boolean bool = preferenceFacade.getBoolean(sb.toString(), false);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_has_fetched_user_config_v2");
        preferenceFacade.saveData(sb.toString(), Boolean.TRUE);
        return true;
    }

    public final boolean getAuthRequestContext(int p0) {
        this.MyBillsEntityDataFactory.saveData("feed_timeline_version", Integer.valueOf(p0));
        return true;
    }
}
