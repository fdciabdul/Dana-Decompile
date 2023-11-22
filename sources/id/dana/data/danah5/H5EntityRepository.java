package id.dana.data.danah5;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.iap.ac.config.lite.ConfigCenter;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.data.miniprogram.MiniProgramMapperKt;
import id.dana.data.miniprogram.model.MiniProgramVersionRequirementsEntity;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.domain.danah5.H5Repository;
import id.dana.domain.danah5.model.H5ShareData;
import id.dana.domain.danah5.model.H5UserDataEntity;
import id.dana.domain.miniprogram.model.MiniProgramVersionRequirements;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Singleton
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0014\u0012\u0006\u0010\u0004\u001a\u00020\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ-\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0011\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/data/danah5/H5EntityRepository;", "Lid/dana/domain/danah5/H5Repository;", "", "p0", "p1", "Lid/dana/domain/danah5/model/H5ShareData;", "p2", "Landroid/os/Bundle;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/danah5/model/H5ShareData;)Landroid/os/Bundle;", "", "Lio/reactivex/Observable;", "Lid/dana/domain/danah5/model/H5UserDataEntity;", "fetchConfigs", "(Ljava/lang/String;Landroid/os/Bundle;Z)Lio/reactivex/Observable;", "()Ljava/lang/String;", "Lid/dana/data/account/repository/AccountEntityRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/account/repository/AccountEntityRepository;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/data/toggle/SplitFacade;", "PlaceComponentResult", "Lid/dana/data/toggle/SplitFacade;", "getAuthRequestContext", "<init>", "(Landroid/content/Context;Lid/dana/data/toggle/SplitFacade;Lid/dana/data/account/repository/AccountEntityRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class H5EntityRepository implements H5Repository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final AccountEntityRepository MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Context BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final SplitFacade getAuthRequestContext;

    @Inject
    public H5EntityRepository(Context context, SplitFacade splitFacade, AccountEntityRepository accountEntityRepository) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(splitFacade, "");
        Intrinsics.checkNotNullParameter(accountEntityRepository, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.getAuthRequestContext = splitFacade;
        this.MyBillsEntityDataFactory = accountEntityRepository;
    }

    @Override // id.dana.domain.danah5.H5Repository
    public final Observable<H5UserDataEntity> fetchConfigs(final String p0, final Bundle p1, final boolean p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        final String str = null;
        if (TextUtils.isDigitsOnly(p0)) {
            str = p0;
        } else if (StringsKt.startsWith$default(p0, "mini://", false, 2, (Object) null)) {
            str = Uri.parse(p0).getQueryParameter("_ariver_appid");
        }
        Observable<H5UserDataEntity> flatMap = this.MyBillsEntityDataFactory.getUserId().onErrorReturnItem("").flatMap(new Function() { // from class: id.dana.data.danah5.H5EntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return H5EntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(H5EntityRepository.this, str, p0, p2, (String) obj);
            }
        }).flatMap(new Function() { // from class: id.dana.data.danah5.H5EntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return H5EntityRepository.getAuthRequestContext(H5EntityRepository.this, str, p1, (Bundle) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle MyBillsEntityDataFactory(H5EntityRepository h5EntityRepository, String str, String str2, BaseTrafficType baseTrafficType) {
        String BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(h5EntityRepository, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        BuiltInFictitiousFunctionClassFactory = baseTrafficType.BuiltInFictitiousFunctionClassFactory("h5_share_data_traffic_type_device", "split/default-feature-h5-share-data.json");
        H5ShareData h5ShareData = null;
        Object obj = null;
        if (BuiltInFictitiousFunctionClassFactory != null) {
            try {
                obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory, null), (Class<Object>) H5ShareData.class);
            } catch (Exception unused) {
            }
            h5ShareData = (H5ShareData) obj;
        }
        Intrinsics.checkNotNull(h5ShareData);
        return h5EntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(str, str2, h5ShareData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle getAuthRequestContext(H5EntityRepository h5EntityRepository, String str, String str2, BaseTrafficType baseTrafficType) {
        String BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(h5EntityRepository, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        BuiltInFictitiousFunctionClassFactory = baseTrafficType.BuiltInFictitiousFunctionClassFactory("h5_share_data", "split/default-feature-h5-share-data.json");
        H5ShareData h5ShareData = null;
        Object obj = null;
        if (BuiltInFictitiousFunctionClassFactory != null) {
            try {
                obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory, null), (Class<Object>) H5ShareData.class);
            } catch (Exception unused) {
            }
            h5ShareData = (H5ShareData) obj;
        }
        Intrinsics.checkNotNull(h5ShareData);
        return h5EntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(str, str2, h5ShareData);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.os.Bundle KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String r10, java.lang.String r11, id.dana.domain.danah5.model.H5ShareData r12) {
        /*
            r9 = this;
            android.os.Bundle r0 = new android.os.Bundle
            r1 = 2
            r0.<init>(r1)
            java.lang.String[] r1 = r12.getUserId()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2c
            int r4 = r1.length
            r5 = 0
        L10:
            if (r5 >= r4) goto L27
            r6 = r1[r5]
            r7 = r10
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            kotlin.text.Regex r8 = new kotlin.text.Regex
            r8.<init>(r6)
            boolean r6 = r8.matches(r7)
            if (r6 == 0) goto L24
            r1 = 1
            goto L28
        L24:
            int r5 = r5 + 1
            goto L10
        L27:
            r1 = 0
        L28:
            if (r1 != r3) goto L2c
            r1 = 1
            goto L2d
        L2c:
            r1 = 0
        L2d:
            if (r1 == 0) goto L34
            java.lang.String r1 = "userId"
            r0.putString(r1, r11)
        L34:
            java.lang.String[] r11 = r12.getUtdId()
            if (r11 == 0) goto L57
            int r12 = r11.length
            r1 = 0
        L3c:
            if (r1 >= r12) goto L53
            r4 = r11[r1]
            r5 = r10
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            kotlin.text.Regex r6 = new kotlin.text.Regex
            r6.<init>(r4)
            boolean r4 = r6.matches(r5)
            if (r4 == 0) goto L50
            r10 = 1
            goto L54
        L50:
            int r1 = r1 + 1
            goto L3c
        L53:
            r10 = 0
        L54:
            if (r10 != r3) goto L57
            r2 = 1
        L57:
            if (r2 == 0) goto L62
            java.lang.String r10 = r9.KClassImpl$Data$declaredNonStaticMembers$2()
            java.lang.String r11 = "utdId"
            r0.putString(r11, r10)
        L62:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.danah5.H5EntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String, java.lang.String, id.dana.domain.danah5.model.H5ShareData):android.os.Bundle");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MiniProgramVersionRequirementsEntity KClassImpl$Data$declaredNonStaticMembers$2(String str, BaseTrafficType baseTrafficType) {
        String authRequestContext;
        Map emptyMap;
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        authRequestContext = baseTrafficType.getAuthRequestContext("miniprogram_version_management", false);
        Intrinsics.checkNotNull(authRequestContext);
        try {
            Object fromJson = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, null), new TypeToken<Map<String, ? extends MiniProgramVersionRequirementsEntity>>() { // from class: id.dana.data.danah5.H5EntityRepository$checkMiniProgramVersionRequirements$lambda-9$$inlined$toMap$default$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(fromJson, "");
            emptyMap = (Map) fromJson;
        } catch (Exception unused) {
            emptyMap = MapsKt.emptyMap();
        }
        Object obj = emptyMap.get(str);
        Intrinsics.checkNotNull(obj);
        return (MiniProgramVersionRequirementsEntity) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        ConfigCenter configCenter = ConfigCenter.getInstance();
        String utdId = configCenter.isInitialized() ? configCenter.getConfigContext().getIdentifierProvider().getUtdId(this.BuiltInFictitiousFunctionClassFactory) : "";
        Intrinsics.checkNotNullExpressionValue(utdId, "");
        return utdId;
    }

    public static /* synthetic */ Bundle KClassImpl$Data$declaredNonStaticMembers$2(Function0 function0, Throwable th) {
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(th, "");
        return (Bundle) function0.invoke();
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(final H5EntityRepository h5EntityRepository, String str, final String str2, boolean z, final String str3) {
        Observable onErrorReturn;
        Intrinsics.checkNotNullParameter(h5EntityRepository, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        if (str != null) {
            str2 = null;
        }
        final Function0<Bundle> function0 = new Function0<Bundle>() { // from class: id.dana.data.danah5.H5EntityRepository$getSharedData$defaultBundle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Bundle invoke() {
                String KClassImpl$Data$declaredNonStaticMembers$2;
                Bundle bundle = new Bundle(2);
                String str4 = str3;
                H5EntityRepository h5EntityRepository2 = h5EntityRepository;
                bundle.putString("userId", str4);
                KClassImpl$Data$declaredNonStaticMembers$2 = h5EntityRepository2.KClassImpl$Data$declaredNonStaticMembers$2();
                bundle.putString("utdId", KClassImpl$Data$declaredNonStaticMembers$2);
                return bundle;
            }
        };
        if (str2 == null) {
            onErrorReturn = Observable.just(function0.invoke());
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "");
        } else if (z) {
            onErrorReturn = h5EntityRepository.getAuthRequestContext.PlaceComponentResult().map(new Function() { // from class: id.dana.data.danah5.H5EntityRepository$$ExternalSyntheticLambda5
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Bundle MyBillsEntityDataFactory;
                    MyBillsEntityDataFactory = H5EntityRepository.MyBillsEntityDataFactory(H5EntityRepository.this, str2, str3, (BaseTrafficType) obj);
                    return MyBillsEntityDataFactory;
                }
            }).onErrorReturn(new Function() { // from class: id.dana.data.danah5.H5EntityRepository$$ExternalSyntheticLambda6
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return H5EntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(Function0.this, (Throwable) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "");
        } else {
            onErrorReturn = h5EntityRepository.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.danah5.H5EntityRepository$$ExternalSyntheticLambda7
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Bundle authRequestContext;
                    authRequestContext = H5EntityRepository.getAuthRequestContext(H5EntityRepository.this, str2, str3, (BaseTrafficType) obj);
                    return authRequestContext;
                }
            }).onErrorReturn(new Function() { // from class: id.dana.data.danah5.H5EntityRepository$$ExternalSyntheticLambda8
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return H5EntityRepository.MyBillsEntityDataFactory(Function0.this, (Throwable) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "");
        }
        return onErrorReturn;
    }

    public static /* synthetic */ MiniProgramVersionRequirements KClassImpl$Data$declaredNonStaticMembers$2(MiniProgramVersionRequirementsEntity miniProgramVersionRequirementsEntity) {
        Intrinsics.checkNotNullParameter(miniProgramVersionRequirementsEntity, "");
        return MiniProgramMapperKt.MyBillsEntityDataFactory(miniProgramVersionRequirementsEntity);
    }

    public static /* synthetic */ H5UserDataEntity BuiltInFictitiousFunctionClassFactory(H5UserDataEntity h5UserDataEntity, MiniProgramVersionRequirements miniProgramVersionRequirements) {
        Intrinsics.checkNotNullParameter(h5UserDataEntity, "");
        Intrinsics.checkNotNullParameter(miniProgramVersionRequirements, "");
        h5UserDataEntity.setVersionRequirements(miniProgramVersionRequirements);
        return h5UserDataEntity;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public static /* synthetic */ ObservableSource getAuthRequestContext(H5EntityRepository h5EntityRepository, final String str, Bundle bundle, Bundle bundle2) {
        Observable map;
        Intrinsics.checkNotNullParameter(h5EntityRepository, "");
        Intrinsics.checkNotNullParameter(bundle, "");
        Intrinsics.checkNotNullParameter(bundle2, "");
        bundle.putAll(bundle2);
        final H5UserDataEntity h5UserDataEntity = new H5UserDataEntity(str, bundle, null, 4, null);
        if (str == null) {
            map = Observable.just(h5UserDataEntity);
            Intrinsics.checkNotNullExpressionValue(map, "");
        } else {
            ?? r1 = 0;
            map = h5EntityRepository.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.danah5.H5EntityRepository$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    MiniProgramVersionRequirementsEntity KClassImpl$Data$declaredNonStaticMembers$2;
                    KClassImpl$Data$declaredNonStaticMembers$2 = H5EntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(str, (BaseTrafficType) obj);
                    return KClassImpl$Data$declaredNonStaticMembers$2;
                }
            }).onErrorReturnItem(new MiniProgramVersionRequirementsEntity(r1, r1, 3, r1)).map(new Function() { // from class: id.dana.data.danah5.H5EntityRepository$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return H5EntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((MiniProgramVersionRequirementsEntity) obj);
                }
            }).map(new Function() { // from class: id.dana.data.danah5.H5EntityRepository$$ExternalSyntheticLambda4
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return H5EntityRepository.BuiltInFictitiousFunctionClassFactory(H5UserDataEntity.this, (MiniProgramVersionRequirements) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(map, "");
        }
        return map;
    }

    public static /* synthetic */ Bundle MyBillsEntityDataFactory(Function0 function0, Throwable th) {
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(th, "");
        return (Bundle) function0.invoke();
    }
}
