package id.dana.data.nearbyme.repository.source.session;

import android.content.Context;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantImageResult;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.KClassesJvm;

@Singleton
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\b\u0007\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b*\u0010+J\u001d\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0011\u001a\u0006*\u00028\u00008\u0000\"\u0006\b\u0000\u0010\u0010\u0018\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001a\u00020\u00022\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0013\"\u00020\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ5\u0010\u001c\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u001dJ(\u0010\u001f\u001a\u00020\u0018\"\u0006\b\u0000\u0010\u0010\u0018\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00028\u0000H\u0082\b¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001f\u0010)\u001a\u0006*\u00020$0$8AX\u0080\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010("}, d2 = {"Lid/dana/data/nearbyme/repository/source/session/MerchantInfoPreferences;", "", "", "key", "", "defaultValue", "getBoolean", "(Ljava/lang/String;Z)Z", "merchantId", FeatureParams.SHOP_ID, "", "pageNum", SecurityConstants.KEY_PAGE_SIZE, "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantImageResult;", "getMerchantImageResult", "(Ljava/lang/String;Ljava/lang/String;II)Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantImageResult;", "T", "getObject$data_productionRelease", "(Ljava/lang/String;)Ljava/lang/Object;", "", "params", "keyOf", "([Ljava/lang/String;)Ljava/lang/String;", "value", "", "saveBoolean", "(Ljava/lang/String;Z)V", "merchantImage", "saveMerchantImageResult", "(Ljava/lang/String;Ljava/lang/String;IILid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantImageResult;)V", "data", "saveObject", "(Ljava/lang/String;Ljava/lang/Object;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade$delegate", "Lkotlin/Lazy;", "getPreferenceFacade$data_productionRelease", "()Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MerchantInfoPreferences {
    public static final String MERCHANT_INFO_PREFERENCES = "MerchantInfoPreferencesproduction";
    private final Context context;

    /* renamed from: preferenceFacade$delegate  reason: from kotlin metadata */
    private final Lazy preferenceFacade;

    @Inject
    public MerchantInfoPreferences(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.context = context;
        this.preferenceFacade = LazyKt.lazy(new Function0<PreferenceFacade>() { // from class: id.dana.data.nearbyme.repository.source.session.MerchantInfoPreferences$preferenceFacade$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PreferenceFacade invoke() {
                Context context2;
                context2 = MerchantInfoPreferences.this.context;
                return new LocalStorageFactory(new LocalStorageFactory.Builder(context2).setPreferenceGroup(MerchantInfoPreferences.MERCHANT_INFO_PREFERENCES)).createData2("local");
            }
        });
    }

    @JvmName(name = "getPreferenceFacade$data_productionRelease")
    public final PreferenceFacade getPreferenceFacade$data_productionRelease() {
        return (PreferenceFacade) this.preferenceFacade.getValue();
    }

    public final MerchantImageResult getMerchantImageResult(String merchantId, String shopId, int pageNum, int pageSize) {
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(shopId, "");
        String keyOf = keyOf(merchantId, shopId, String.valueOf(pageNum), String.valueOf(pageSize));
        PreferenceFacade preferenceFacade$data_productionRelease = getPreferenceFacade$data_productionRelease();
        StringBuilder sb = new StringBuilder();
        sb.append(KClassesJvm.getJvmName(Reflection.getOrCreateKotlinClass(MerchantImageResult.class)));
        sb.append(keyOf);
        MerchantImageResult merchantImageResult = (MerchantImageResult) preferenceFacade$data_productionRelease.getObject(sb.toString(), MerchantImageResult.class);
        return merchantImageResult == null ? new MerchantImageResult(CollectionsKt.emptyList()) : merchantImageResult;
    }

    public final void saveMerchantImageResult(String merchantId, String shopId, int pageNum, int pageSize, MerchantImageResult merchantImage) {
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(shopId, "");
        Intrinsics.checkNotNullParameter(merchantImage, "");
        String keyOf = keyOf(merchantId, shopId, String.valueOf(pageNum), String.valueOf(pageSize));
        PreferenceFacade preferenceFacade$data_productionRelease = getPreferenceFacade$data_productionRelease();
        StringBuilder sb = new StringBuilder();
        sb.append(KClassesJvm.getJvmName(Reflection.getOrCreateKotlinClass(MerchantImageResult.class)));
        sb.append(keyOf);
        preferenceFacade$data_productionRelease.saveData(sb.toString(), (String) merchantImage);
    }

    public final boolean getBoolean(String key, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(key, "");
        Boolean bool = getPreferenceFacade$data_productionRelease().getBoolean(key, defaultValue);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }

    public final void saveBoolean(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "");
        getPreferenceFacade$data_productionRelease().saveData(key, Boolean.valueOf(value));
    }

    public static /* synthetic */ Object getObject$data_productionRelease$default(MerchantInfoPreferences merchantInfoPreferences, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        Intrinsics.checkNotNullParameter(str, "");
        PreferenceFacade preferenceFacade$data_productionRelease = merchantInfoPreferences.getPreferenceFacade$data_productionRelease();
        StringBuilder sb = new StringBuilder();
        Intrinsics.reifiedOperationMarker(4, "T");
        sb.append(KClassesJvm.getJvmName(Reflection.getOrCreateKotlinClass(Object.class)));
        sb.append(str);
        String obj2 = sb.toString();
        Intrinsics.reifiedOperationMarker(4, "T");
        return preferenceFacade$data_productionRelease.getObject(obj2, Object.class);
    }

    public final /* synthetic */ <T> T getObject$data_productionRelease(String key) {
        Intrinsics.checkNotNullParameter(key, "");
        PreferenceFacade preferenceFacade$data_productionRelease = getPreferenceFacade$data_productionRelease();
        StringBuilder sb = new StringBuilder();
        Intrinsics.reifiedOperationMarker(4, "T");
        sb.append(KClassesJvm.getJvmName(Reflection.getOrCreateKotlinClass(Object.class)));
        sb.append(key);
        String obj = sb.toString();
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) preferenceFacade$data_productionRelease.getObject(obj, Object.class);
    }

    private final /* synthetic */ <T> void saveObject(String key, T data) {
        PreferenceFacade preferenceFacade$data_productionRelease = getPreferenceFacade$data_productionRelease();
        StringBuilder sb = new StringBuilder();
        Intrinsics.reifiedOperationMarker(4, "T");
        sb.append(KClassesJvm.getJvmName(Reflection.getOrCreateKotlinClass(Object.class)));
        sb.append(key);
        preferenceFacade$data_productionRelease.saveData(sb.toString(), (String) data);
    }

    private final String keyOf(String... params) {
        String str = "";
        for (String str2 : params) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            sb.append(InputCardNumberView.DIVIDER);
            str = sb.toString();
        }
        return String.valueOf(str.hashCode());
    }
}
