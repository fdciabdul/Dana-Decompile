package id.dana.feeds.data.config.source.split;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import dagger.Lazy;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.constant.ConfigType;
import id.dana.data.toggle.exception.SplitException;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.toggle.exception.UnexpectedTreatment;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.feeds.data.config.model.FeedConfigResult;
import id.dana.feeds.data.config.model.ProfileCtaConfigResponse;
import id.dana.feeds.data.config.source.FeedsConfigData;
import id.dana.feeds.data.config.utils.DefaultFriendshipGenerator;
import id.dana.feeds.data.config.utils.FeedsConfigGenerator;
import id.dana.lib.toggle.ToggleCallback;
import id.dana.lib.toggle.ToggleManager;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Singleton
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u001b\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u001b\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0005J\u0019\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0005J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0005R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/feeds/data/config/source/split/SplitFeedsConfigEntityData;", "Lid/dana/feeds/data/config/source/FeedsConfigData;", "Lio/reactivex/Observable;", "Lid/dana/feeds/data/config/model/FeedConfigResult;", "getAuthRequestContext", "()Lio/reactivex/Observable;", "Lcom/alibaba/fastjson/JSONObject;", "BuiltInFictitiousFunctionClassFactory", "", "", "PlaceComponentResult", "Lid/dana/feeds/data/config/model/ProfileCtaConfigResponse;", "MyBillsEntityDataFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "lookAheadTest", "()Ljava/lang/Object;", "moveToNextValue", "getErrorConfigVersion", "Ldagger/Lazy;", "Lid/dana/data/toggle/SplitFacade;", "Ldagger/Lazy;", "p0", "<init>", "(Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SplitFeedsConfigEntityData implements FeedsConfigData {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<SplitFacade> MyBillsEntityDataFactory;

    @Inject
    public SplitFeedsConfigEntityData(Lazy<SplitFacade> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.MyBillsEntityDataFactory = lazy;
    }

    public static final FeedConfigResult scheduleImpl(BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        Object feedConfigResult = new FeedConfigResult(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
        String authRequestContext = baseTrafficType.getAuthRequestContext("feed_config", false);
        if (FeedConfigResult.class.isAssignableFrom(JSONArray.class)) {
            feedConfigResult = (FeedConfigResult) new JSONArray(authRequestContext != null ? authRequestContext : "");
        } else if (authRequestContext != null) {
            Object obj = null;
            try {
                obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, null), (Class<Object>) FeedConfigResult.class);
            } catch (Exception unused) {
            }
            if (obj != null) {
                feedConfigResult = obj;
            }
        }
        return (FeedConfigResult) feedConfigResult;
    }

    @Override // id.dana.feeds.data.config.source.FeedsConfigData
    public final Object lookAheadTest() {
        return MyBillsEntityDataFactory(this, "feature_friendship_contact_sync");
    }

    @Override // id.dana.feeds.data.config.source.FeedsConfigData
    public final Observable<Boolean> getErrorConfigVersion() {
        return MyBillsEntityDataFactory(this, "feature_home_friendship");
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        DefaultFriendshipGenerator defaultFriendshipGenerator = DefaultFriendshipGenerator.INSTANCE;
        final List<String> PlaceComponentResult = DefaultFriendshipGenerator.PlaceComponentResult();
        final String str = "friendship_emoji_order";
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$getFriendshipEmojiOrder$lambda-6$$inlined$getConfigOnceReady$1
            final /* synthetic */ boolean $getAuthRequestContext = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(str);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str2 = str;
                String BuiltInFictitiousFunctionClassFactory = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = PlaceComponentResult;
                final boolean z = this.$getAuthRequestContext;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str3 = str;
                MyBillsEntityDataFactory.getAuthRequestContext(str2, BuiltInFictitiousFunctionClassFactory, List.class, obj, new ToggleCallback<T>() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$getFriendshipEmojiOrder$lambda-6$$inlined$getConfigOnceReady$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String p0, T p1) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 != null) {
                            boolean z2 = z;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str4 = str3;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z2 && Intrinsics.areEqual(p0, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str4));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(p1);
                                observableEmitter2.onComplete();
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            BaseTrafficType baseTrafficType4 = baseTrafficType2;
                            String str5 = str3;
                            ObservableEmitter observableEmitter3 = observableEmitter;
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str5, "Not Received", ConfigType.ASYNC);
                            observableEmitter3.onError(new SplitNull(str5));
                        }
                    }

                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onError() {
                        baseTrafficType2.MyBillsEntityDataFactory("", str3, "Not Received", ConfigType.ASYNC);
                        observableEmitter.onError(new SplitException("Error when get toggle config"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create;
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final Boolean bool = Boolean.FALSE;
        final String str = "feature_recurring_contact_sync";
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$isRecurringContactSyncEnabled$lambda-3$$inlined$getConfigOnceReady$default$1
            final /* synthetic */ boolean $MyBillsEntityDataFactory = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(str);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str2 = str;
                String BuiltInFictitiousFunctionClassFactory = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = bool;
                final boolean z = this.$MyBillsEntityDataFactory;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str3 = str;
                MyBillsEntityDataFactory.getAuthRequestContext(str2, BuiltInFictitiousFunctionClassFactory, Boolean.class, obj, new ToggleCallback<T>() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$isRecurringContactSyncEnabled$lambda-3$$inlined$getConfigOnceReady$default$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String p0, T p1) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 != null) {
                            boolean z2 = z;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str4 = str3;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z2 && Intrinsics.areEqual(p0, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str4));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(p1);
                                observableEmitter2.onComplete();
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            BaseTrafficType baseTrafficType4 = baseTrafficType2;
                            String str5 = str3;
                            ObservableEmitter observableEmitter3 = observableEmitter;
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str5, "Not Received", ConfigType.ASYNC);
                            observableEmitter3.onError(new SplitNull(str5));
                        }
                    }

                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onError() {
                        baseTrafficType2.MyBillsEntityDataFactory("", str3, "Not Received", ConfigType.ASYNC);
                        observableEmitter.onError(new SplitException("Error when get toggle config"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create;
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final List emptyList = CollectionsKt.emptyList();
        final String str = "friendship_cta_profile";
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$getFriendshipProfileCtaConfig$lambda-9$$inlined$getConfigOnceReady$default$1
            final /* synthetic */ boolean $BuiltInFictitiousFunctionClassFactory = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(str);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str2 = str;
                String BuiltInFictitiousFunctionClassFactory = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = emptyList;
                final boolean z = this.$BuiltInFictitiousFunctionClassFactory;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str3 = str;
                MyBillsEntityDataFactory.getAuthRequestContext(str2, BuiltInFictitiousFunctionClassFactory, List.class, obj, new ToggleCallback<T>() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$getFriendshipProfileCtaConfig$lambda-9$$inlined$getConfigOnceReady$default$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String p0, T p1) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 != null) {
                            boolean z2 = z;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str4 = str3;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z2 && Intrinsics.areEqual(p0, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str4));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(p1);
                                observableEmitter2.onComplete();
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            BaseTrafficType baseTrafficType4 = baseTrafficType2;
                            String str5 = str3;
                            ObservableEmitter observableEmitter3 = observableEmitter;
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str5, "Not Received", ConfigType.ASYNC);
                            observableEmitter3.onError(new SplitNull(str5));
                        }
                    }

                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onError() {
                        baseTrafficType2.MyBillsEntityDataFactory("", str3, "Not Received", ConfigType.ASYNC);
                        observableEmitter.onError(new SplitException("Error when get toggle config"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create.map(new Function() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitFeedsConfigEntityData.PlaceComponentResult((List) obj);
            }
        });
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(final String str, boolean z, final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final Boolean valueOf = Boolean.valueOf(z);
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$getBooleanUserTrafficOnceReady$lambda-0$$inlined$getConfigOnceReady$1
            final /* synthetic */ boolean $BuiltInFictitiousFunctionClassFactory = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(str);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str2 = str;
                String BuiltInFictitiousFunctionClassFactory = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = valueOf;
                final boolean z2 = this.$BuiltInFictitiousFunctionClassFactory;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str3 = str;
                MyBillsEntityDataFactory.getAuthRequestContext(str2, BuiltInFictitiousFunctionClassFactory, Boolean.class, obj, new ToggleCallback<T>() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$getBooleanUserTrafficOnceReady$lambda-0$$inlined$getConfigOnceReady$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String p0, T p1) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 != null) {
                            boolean z3 = z2;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str4 = str3;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z3 && Intrinsics.areEqual(p0, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str4));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(p1);
                                observableEmitter2.onComplete();
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            BaseTrafficType baseTrafficType4 = baseTrafficType2;
                            String str5 = str3;
                            ObservableEmitter observableEmitter3 = observableEmitter;
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str5, "Not Received", ConfigType.ASYNC);
                            observableEmitter3.onError(new SplitNull(str5));
                        }
                    }

                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onError() {
                        baseTrafficType2.MyBillsEntityDataFactory("", str3, "Not Received", ConfigType.ASYNC);
                        observableEmitter.onError(new SplitException("Error when get toggle config"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create;
    }

    public static /* synthetic */ List PlaceComponentResult(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add((ProfileCtaConfigResponse) JSON.parseObject(((JSONObject) it.next()).toJSONString(), ProfileCtaConfigResponse.class));
        }
        return arrayList;
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        FeedsConfigGenerator feedsConfigGenerator = FeedsConfigGenerator.INSTANCE;
        final List<JSONObject> authRequestContext = FeedsConfigGenerator.getAuthRequestContext();
        final String str = "comment_report_reasons";
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$getReportReasonsConfig$lambda-2$$inlined$getConfigOnceReady$default$1
            final /* synthetic */ boolean $MyBillsEntityDataFactory = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(str);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str2 = str;
                String BuiltInFictitiousFunctionClassFactory = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = authRequestContext;
                final boolean z = this.$MyBillsEntityDataFactory;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str3 = str;
                MyBillsEntityDataFactory.getAuthRequestContext(str2, BuiltInFictitiousFunctionClassFactory, List.class, obj, new ToggleCallback<T>() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$getReportReasonsConfig$lambda-2$$inlined$getConfigOnceReady$default$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String p0, T p1) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 != null) {
                            boolean z2 = z;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str4 = str3;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z2 && Intrinsics.areEqual(p0, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str4));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(p1);
                                observableEmitter2.onComplete();
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            BaseTrafficType baseTrafficType4 = baseTrafficType2;
                            String str5 = str3;
                            ObservableEmitter observableEmitter3 = observableEmitter;
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str5, "Not Received", ConfigType.ASYNC);
                            observableEmitter3.onError(new SplitNull(str5));
                        }
                    }

                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onError() {
                        baseTrafficType2.MyBillsEntityDataFactory("", str3, "Not Received", ConfigType.ASYNC);
                        observableEmitter.onError(new SplitException("Error when get toggle config"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create;
    }

    public static /* synthetic */ ObservableSource NetworkUserEntityData$$ExternalSyntheticLambda0(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        DefaultFriendshipGenerator defaultFriendshipGenerator = DefaultFriendshipGenerator.INSTANCE;
        final JSONObject MyBillsEntityDataFactory = DefaultFriendshipGenerator.MyBillsEntityDataFactory();
        final String str = "friendship_emoji_list";
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$getFriendshipEmojiList$lambda-5$$inlined$getConfigOnceReady$1
            final /* synthetic */ boolean $KClassImpl$Data$declaredNonStaticMembers$2 = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(str);
                ToggleManager MyBillsEntityDataFactory2 = ToggleManager.MyBillsEntityDataFactory();
                String str2 = str;
                String BuiltInFictitiousFunctionClassFactory = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = MyBillsEntityDataFactory;
                final boolean z = this.$KClassImpl$Data$declaredNonStaticMembers$2;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str3 = str;
                MyBillsEntityDataFactory2.getAuthRequestContext(str2, BuiltInFictitiousFunctionClassFactory, JSONObject.class, obj, new ToggleCallback<T>() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$getFriendshipEmojiList$lambda-5$$inlined$getConfigOnceReady$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String p0, T p1) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 != null) {
                            boolean z2 = z;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str4 = str3;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z2 && Intrinsics.areEqual(p0, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str4));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(p1);
                                observableEmitter2.onComplete();
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            BaseTrafficType baseTrafficType4 = baseTrafficType2;
                            String str5 = str3;
                            ObservableEmitter observableEmitter3 = observableEmitter;
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str5, "Not Received", ConfigType.ASYNC);
                            observableEmitter3.onError(new SplitNull(str5));
                        }
                    }

                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onError() {
                        baseTrafficType2.MyBillsEntityDataFactory("", str3, "Not Received", ConfigType.ASYNC);
                        observableEmitter.onError(new SplitException("Error when get toggle config"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create;
    }

    public static /* synthetic */ ObservableSource moveToNextValue(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final int i = 50;
        final String str = "friendship_sync_max_contact";
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$getMaxContactPerBatch$lambda-4$$inlined$getConfigOnceReady$default$1
            final /* synthetic */ boolean $MyBillsEntityDataFactory = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(str);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str2 = str;
                String BuiltInFictitiousFunctionClassFactory = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = i;
                final boolean z = this.$MyBillsEntityDataFactory;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str3 = str;
                MyBillsEntityDataFactory.getAuthRequestContext(str2, BuiltInFictitiousFunctionClassFactory, Integer.class, obj, new ToggleCallback<T>() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$getMaxContactPerBatch$lambda-4$$inlined$getConfigOnceReady$default$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String p0, T p1) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 != null) {
                            boolean z2 = z;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str4 = str3;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z2 && Intrinsics.areEqual(p0, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str4));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(p1);
                                observableEmitter2.onComplete();
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            BaseTrafficType baseTrafficType4 = baseTrafficType2;
                            String str5 = str3;
                            ObservableEmitter observableEmitter3 = observableEmitter;
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str5, "Not Received", ConfigType.ASYNC);
                            observableEmitter3.onError(new SplitNull(str5));
                        }
                    }

                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onError() {
                        baseTrafficType2.MyBillsEntityDataFactory("", str3, "Not Received", ConfigType.ASYNC);
                        observableEmitter.onError(new SplitException("Error when get toggle config"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create;
    }

    private static /* synthetic */ Observable MyBillsEntityDataFactory(SplitFeedsConfigEntityData splitFeedsConfigEntityData, final String str) {
        Observable<R> flatMap = splitFeedsConfigEntityData.MyBillsEntityDataFactory.get().KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$$ExternalSyntheticLambda1
            public final /* synthetic */ boolean getAuthRequestContext = false;

            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitFeedsConfigEntityData.PlaceComponentResult(str, this.getAuthRequestContext, (BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.feeds.data.config.source.FeedsConfigData
    public final Observable<FeedConfigResult> getAuthRequestContext() {
        Boolean bool = null;
        Observable<FeedConfigResult> onErrorResumeNext = this.MyBillsEntityDataFactory.get().KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                FeedConfigResult scheduleImpl;
                scheduleImpl = SplitFeedsConfigEntityData.scheduleImpl((BaseTrafficType) obj);
                return scheduleImpl;
            }
        }).onErrorResumeNext(SplitConfigEntityData.INSTANCE.onJSONErrorReturnDefault(new FeedConfigResult(null, null, null, null, null, null, null, null, null, null, null, bool, bool, null, null, 32767, null)));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    @Override // id.dana.feeds.data.config.source.FeedsConfigData
    public final Observable<JSONObject> BuiltInFictitiousFunctionClassFactory() {
        Observable flatMap = this.MyBillsEntityDataFactory.get().KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitFeedsConfigEntityData.NetworkUserEntityData$$ExternalSyntheticLambda0((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.feeds.data.config.source.FeedsConfigData
    public final Observable<List<String>> PlaceComponentResult() {
        Observable flatMap = this.MyBillsEntityDataFactory.get().KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitFeedsConfigEntityData.MyBillsEntityDataFactory((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.feeds.data.config.source.FeedsConfigData
    public final Observable<List<ProfileCtaConfigResponse>> MyBillsEntityDataFactory() {
        Observable flatMap = this.MyBillsEntityDataFactory.get().KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitFeedsConfigEntityData.KClassImpl$Data$declaredNonStaticMembers$2((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.feeds.data.config.source.FeedsConfigData
    public final Observable<Integer> KClassImpl$Data$declaredNonStaticMembers$2() {
        Observable flatMap = this.MyBillsEntityDataFactory.get().KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitFeedsConfigEntityData.moveToNextValue((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.feeds.data.config.source.FeedsConfigData
    public final Observable<List<JSONObject>> NetworkUserEntityData$$ExternalSyntheticLambda0() {
        Observable flatMap = this.MyBillsEntityDataFactory.get().KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitFeedsConfigEntityData.BuiltInFictitiousFunctionClassFactory((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.feeds.data.config.source.FeedsConfigData
    public final Observable<Boolean> moveToNextValue() {
        Observable flatMap = this.MyBillsEntityDataFactory.get().KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitFeedsConfigEntityData.PlaceComponentResult((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }
}
