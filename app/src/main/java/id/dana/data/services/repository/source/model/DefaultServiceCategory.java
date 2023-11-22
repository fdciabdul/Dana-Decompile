package id.dana.data.services.repository.source.model;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.constant.DanaUrl;
import id.dana.data.globalnetwork.constants.GlobalNetworkConstants;
import id.dana.data.homeinfo.model.SkuAttributeEntity;
import id.dana.data.homeinfo.model.ThirdPartyEntity;
import id.dana.data.services.repository.ServicesEntityRepository;
import id.dana.domain.services.Category;
import id.dana.lib.drawbitmap.style.Pallette;
import id.dana.model.PayMethodModel;
import id.dana.mybills.ui.constant.MyBillsServiceKey;
import id.dana.mybills.ui.constant.ServiceName;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR?\u0010\u0006\u001a*\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00040\u0002j\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0004`\u00058\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR6\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n`\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t"}, d2 = {"Lid/dana/data/services/repository/source/model/DefaultServiceCategory;", "", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "defaultCategory", "Ljava/util/HashMap;", "getDefaultCategory", "()Ljava/util/HashMap;", "Lid/dana/data/homeinfo/model/ThirdPartyEntity;", "defaultServices", "getDefaultServices", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultServiceCategory {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final DefaultServiceCategory INSTANCE;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static char MyBillsEntityDataFactory;
    private static char[] PlaceComponentResult;
    private static final HashMap<String, List<String>> defaultCategory;
    private static final HashMap<String, ThirdPartyEntity> defaultServices;
    private static int getAuthRequestContext;

    static void MyBillsEntityDataFactory() {
        MyBillsEntityDataFactory = (char) 42065;
        PlaceComponentResult = new char[]{37309, 37286, 37283, 37302, 37264, 37281, 37308, 37290, 37287, 37288, 37293, 37292, 37305, 37280, 37294, 37282};
    }

    private DefaultServiceCategory() {
    }

    @JvmName(name = "getDefaultCategory")
    public final HashMap<String, List<String>> getDefaultCategory() {
        int i = getAuthRequestContext + 71;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        try {
            HashMap<String, List<String>> hashMap = defaultCategory;
            int i3 = getAuthRequestContext + 9;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return hashMap;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Type inference failed for: r24v10, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r24v6, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r24v8, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v100, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v102, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v122, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v124, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v126, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v140, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v142, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v21, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v23, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v33, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v35, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v37, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v49, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v51, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v61, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v63, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v65, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v84, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v86, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v101, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v114, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v116, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v118, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v128, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v130, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v132, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v141, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v143, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v145, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v154, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v156, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v158, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v169, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v171, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v173, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v21, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v23, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v25, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v44, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v46, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v59, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v61, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v70, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v72, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v74, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v84, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v86, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v88, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v97, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v99, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r44v0, types: [java.util.List, id.dana.data.homeinfo.model.SkuAttributeEntity] */
    /* JADX WARN: Type inference failed for: r44v2, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r49v3, types: [java.lang.String, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v101, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v103, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v105, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v114, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v116, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v118, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v128, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v130, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v132, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v142, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v144, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v146, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v155, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v157, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v159, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v171, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v173, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v182, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v184, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v186, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v195, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v197, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v199, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v209, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v211, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v213, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v223, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v225, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v227, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v236, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v238, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v240, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v32, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v34, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v44, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v46, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v48, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v57, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v59, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v61, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v70, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v72, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v74, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v83, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v85, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v87, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r51v3, types: [java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity] */
    /* JADX WARN: Type inference failed for: r52v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /* JADX WARN: Type inference failed for: r53v1, types: [id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r54v0, types: [java.lang.Boolean, java.lang.String] */
    /* JADX WARN: Type inference failed for: r56v0, types: [java.lang.Boolean, java.lang.String] */
    /* JADX WARN: Type inference failed for: r59v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /* JADX WARN: Type inference failed for: r65v0, types: [id.dana.data.homeinfo.model.SkuAttributeEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r68v1, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r73v3, types: [java.lang.String, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r74v2, types: [java.util.List, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.String] */
    /* JADX WARN: Type inference failed for: r74v5, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r75v0, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r75v2, types: [java.util.List, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity] */
    /* JADX WARN: Type inference failed for: r76v3, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r76v5, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r77v3, types: [java.lang.Boolean, java.lang.String] */
    /* JADX WARN: Type inference failed for: r84v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v36, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v38, types: [java.lang.Boolean, java.lang.String, id.dana.data.homeinfo.model.BannerLottieEntity, java.lang.Integer] */
    static {
        boolean z;
        MyBillsEntityDataFactory();
        INSTANCE = new DefaultServiceCategory();
        Object[] objArr = new Object[1];
        a(new char[]{7, 4, 4, 0, 3, '\t', 4, 5, '\f', 14, '\t', 2, 3, 6, 3, 4, '\b', '\t', '\f', 2, 11, 5}, (byte) (Color.green(0) + 61), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 22, objArr);
        Object[] objArr2 = new Object[1];
        a(new char[]{7, 4, 4, 0, 3, '\t', 4, 5, 11, 3, 2, '\n'}, (byte) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 107), TextUtils.indexOf("", "", 0) + 12, objArr2);
        String[] strArr = {"service_paylater_loan_personal", ((String) objArr[0]).intern(), ((String) objArr2[0]).intern(), "service_aplus_reward", "service_pasarpolis", "service_goals", "service_send_money_bank", "service_tix", MyBillsServiceKey.MOBILE_POSTPAID};
        Object[] objArr3 = new Object[1];
        a(new char[]{7, 4, 4, 0, 3, '\t', 4, 5, '\f', 14, '\t', 2, 3, 6, 3, 4, '\b', '\t', '\f', 2, 11, 5}, (byte) (61 - (ViewConfiguration.getPressedStateDuration() >> 16)), View.resolveSizeAndState(0, 0, 0) + 22, objArr3);
        String[] strArr2 = {((String) objArr3[0]).intern(), "service_home_shopping", "service_deals", "service_loyalty", "service_delivery", "service_surprize", "service_aplus_reward", "service_nearby", "service_vaccination_certificate", "service_smartfren"};
        Object[] objArr4 = new Object[1];
        a(new char[]{7, 4, 4, 0, 3, '\t', 4, 5, 11, 3, 2, '\n'}, (byte) (Color.blue(0) + 107), 12 - (ViewConfiguration.getDoubleTapTimeout() >> 16), objArr4);
        String[] strArr3 = {((String) objArr4[0]).intern(), "service_kyb", "service_akulaku", "service_bank", "service_goals", "service_rapor_dana"};
        byte fadingEdgeLength = (byte) (118 - (ViewConfiguration.getFadingEdgeLength() >> 16));
        float minVolume = AudioTrack.getMinVolume();
        String str = MyBillsServiceKey.MOBILE_POSTPAID;
        String str2 = TrackerKey.PromoCenterSourceType.DANA_DEALS;
        Object[] objArr5 = new Object[1];
        a(new char[]{7, 4, 4, 0, 3, '\t', 4, 5, 11, 3, 1, '\t', 11, 7}, fadingEdgeLength, 14 - (minVolume > 0.0f ? 1 : (minVolume == 0.0f ? 0 : -1)), objArr5);
        defaultCategory = MapsKt.hashMapOf(TuplesKt.to(Category.FEATURED, CollectionsKt.listOf((Object[]) strArr)), TuplesKt.to("category_daily", CollectionsKt.listOf((Object[]) strArr2)), TuplesKt.to("category_transfer", CollectionsKt.listOf((Object[]) new String[]{"service_danakaget", "service_withdraw", "service_splitbill", "service_send_money_chat", "service_send_money_bank", "service_e_commerce", "service_e_commerce_beta", "service_send_money_withdraw"})), TuplesKt.to("category_bills", CollectionsKt.listOf((Object[]) new String[]{"service_my_bills", MyBillsServiceKey.ELECTRICITY, MyBillsServiceKey.WATER, MyBillsServiceKey.MOBILE_POSTPAID, MyBillsServiceKey.TELEPHONE, MyBillsServiceKey.GAS_PGN, MyBillsServiceKey.INTERNET_CABLE_TV, MyBillsServiceKey.INSTALLMENT, "service_credit_card_repayment", "service_e_samsat", "service_samsat_signal", "service_maintenance_fees", "service_maintenance_fees_beta", "service_tuition_fees", "service_tuition_fees_beta", "service_internet_cabletv_beta", "service_credit_card_beta", "service_education", "service_penerimaan_negara", "service_pbb", "service_plnnontaglis", "service_bpjs_ketenagakerjaan"})), TuplesKt.to("category_entertainment", CollectionsKt.listOf((Object[]) new String[]{MyBillsServiceKey.DIGITAL_VOUCHER, "service_tix", "service_vidio"})), TuplesKt.to("category_featured_gn", CollectionsKt.emptyList()), TuplesKt.to(WalletConstant.CATEGORY_FINANCE, CollectionsKt.listOf((Object[]) strArr3)), TuplesKt.to("category_top_up", CollectionsKt.listOf((Object[]) new String[]{"service_digital_money", ((String) objArr5[0]).intern(), "service_investment_beta"})), TuplesKt.to("category_insurance", CollectionsKt.listOf((Object[]) new String[]{"service_pasarpolis", MyBillsServiceKey.INSURANCE, "service_insurance_beta", MyBillsServiceKey.BPJS})), TuplesKt.to("category_charity", CollectionsKt.listOf((Object[]) new String[]{"service_zakat", "service_kitabisa"})), TuplesKt.to("category_transportation", CollectionsKt.listOf((Object[]) new String[]{"service_parking", "service_parkee", "service_train_ticket"})), TuplesKt.to("category_shopping", CollectionsKt.listOf((Object[]) new String[]{"service_lazada", "service_bukalapak", "service_warung_pangan", "service_happyfresh", "service_iprice"})), TuplesKt.to("category_health", CollectionsKt.listOf((Object[]) new String[]{"service_covid19", "service_kalcare"})), TuplesKt.to("category_travel", CollectionsKt.listOf("service_miles")), TuplesKt.to("category_others", CollectionsKt.listOf((Object[]) new String[]{"service_sisberdaya", "service_dummy_mp", "service_bbi"})));
        String str3 = null;
        String str4 = null;
        ?? r3 = 0;
        ?? r32 = 0;
        ?? r33 = 0;
        List listOf = CollectionsKt.listOf("MOBILE_RECHARGE_PHONE_NUMBER_LIST");
        ?? r44 = 0;
        Object[] objArr6 = new Object[1];
        a(new char[]{7, 4, 4, 0, 3, '\t', 4, 5, '\f', 14, '\t', 2, 3, 6, 3, 4, '\b', '\t', '\f', 2, 11, 5}, (byte) (61 - TextUtils.getOffsetBefore("", 0)), 23 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), objArr6);
        ?? r52 = 0;
        SkuAttributeEntity skuAttributeEntity = new SkuAttributeEntity(null, listOf, r44, "#FFEAE9", "Pulsa & Data", "https://a.m.dana.id/resource/services/icon_mobile_recharge_new.png", "", ((String) objArr6[0]).intern(), null, DeepRecoverARiverProxy.TYPE_ENTITY_ONLINE_PAGE, r52);
        Object[] objArr7 = new Object[1];
        a(new char[]{7, 4, 4, 0, 3, '\t', 4, 5, '\f', 14, '\t', 2, 3, 6, 3, 4, '\b', '\t', '\f', 2, 11, 5}, (byte) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 60), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 21, objArr7);
        ?? r54 = 0;
        ?? r56 = 0;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        ?? r65 = 0;
        String str8 = null;
        ?? r75 = 0;
        ?? r84 = 0;
        String str9 = null;
        ?? r53 = 0;
        String str10 = null;
        ?? r59 = 0;
        ?? r34 = 0;
        ?? r35 = 0;
        String str11 = null;
        ?? r24 = 0;
        ?? r242 = 0;
        ?? r243 = 0;
        String str12 = null;
        String str13 = null;
        ?? r2 = 0;
        ?? r22 = 0;
        String str14 = null;
        String str15 = null;
        ?? r23 = 0;
        ?? r25 = 0;
        ?? r26 = 0;
        ?? r74 = 0;
        String str16 = null;
        String str17 = null;
        ?? r27 = 0;
        ?? r28 = 0;
        String str18 = null;
        String str19 = null;
        ?? r29 = 0;
        ?? r210 = 0;
        ?? r211 = 0;
        ?? r442 = 0;
        String str20 = null;
        String str21 = null;
        String str22 = null;
        String str23 = null;
        ?? r49 = 0;
        String str24 = null;
        ?? r51 = 0;
        String str25 = null;
        String str26 = null;
        ?? r68 = 0;
        String str27 = null;
        ?? r73 = 0;
        ?? r752 = 0;
        ?? r76 = 0;
        ?? r77 = 0;
        String str28 = null;
        boolean z2 = false;
        String str29 = null;
        boolean z3 = false;
        SkuAttributeEntity skuAttributeEntity2 = null;
        boolean z4 = false;
        String str30 = null;
        boolean z5 = false;
        String str31 = null;
        String str32 = null;
        ?? r4 = 0;
        ?? r42 = 0;
        int i = 6;
        String str33 = null;
        String str34 = null;
        ?? r212 = 0;
        ?? r213 = 0;
        String str35 = null;
        String str36 = null;
        ?? r43 = 0;
        ?? r45 = 0;
        ?? r46 = 0;
        String str37 = null;
        String str38 = null;
        ?? r214 = 0;
        ?? r215 = 0;
        String str39 = null;
        String str40 = null;
        ?? r47 = 0;
        ?? r48 = 0;
        ?? r410 = 0;
        String str41 = null;
        String str42 = null;
        ?? r411 = 0;
        ?? r412 = 0;
        ?? r413 = 0;
        String str43 = null;
        String str44 = null;
        ?? r414 = 0;
        ?? r415 = 0;
        ?? r416 = 0;
        ?? r742 = 0;
        String str45 = null;
        String str46 = null;
        String str47 = null;
        ?? r36 = 0;
        ?? r37 = 0;
        String str48 = null;
        String str49 = null;
        ?? r38 = 0;
        ?? r39 = 0;
        ?? r310 = 0;
        String str50 = null;
        String str51 = null;
        ?? r216 = 0;
        ?? r217 = 0;
        ?? r218 = 0;
        ?? r762 = 0;
        int i2 = 262;
        String str52 = null;
        String str53 = null;
        ?? r219 = 0;
        ?? r220 = 0;
        String str54 = null;
        String str55 = null;
        ?? r311 = 0;
        ?? r312 = 0;
        ?? r313 = 0;
        String str56 = null;
        String str57 = null;
        ?? r314 = 0;
        ?? r315 = 0;
        ?? r316 = 0;
        Integer num = null;
        String str58 = null;
        String str59 = null;
        Boolean bool = null;
        int i3 = -8193;
        int i4 = 7;
        DefaultConstructorMarker defaultConstructorMarker = null;
        String str60 = null;
        String str61 = null;
        ?? r317 = 0;
        ?? r318 = 0;
        ?? r319 = 0;
        String str62 = null;
        String str63 = null;
        ?? r320 = 0;
        ?? r321 = 0;
        ?? r322 = 0;
        String str64 = null;
        String str65 = null;
        ?? r323 = 0;
        ?? r324 = 0;
        ?? r325 = 0;
        String str66 = null;
        String str67 = null;
        ?? r326 = 0;
        ?? r327 = 0;
        ?? r328 = 0;
        String str68 = null;
        String str69 = null;
        ?? r329 = 0;
        ?? r330 = 0;
        ?? r331 = 0;
        List emptyList = CollectionsKt.emptyList();
        Object[] objArr8 = new Object[1];
        a(new char[]{7, 4, 4, 0, 3, '\t', 4, 5, 11, 3, 2, '\n'}, (byte) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 107), 12 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), objArr8);
        SkuAttributeEntity skuAttributeEntity3 = new SkuAttributeEntity(emptyList, r752, r762, Pallette.YELLOW_10, "Emas", "https://a.m.dana.id/promo/homeservices/icon_dana_emas.png", "", ((String) objArr8[0]).intern(), str45, i2, r84);
        boolean z6 = false;
        Object[] objArr9 = new Object[1];
        a(new char[]{7, 4, 4, 0, 3, '\t', 4, 5, 11, 3, 2, '\n'}, (byte) (106 - ImageFormat.getBitsPerPixel(0)), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 12, objArr9);
        String str70 = null;
        String str71 = null;
        ?? r9 = 0;
        ?? r92 = 0;
        String str72 = null;
        String str73 = null;
        ?? r417 = 0;
        ?? r418 = 0;
        ?? r419 = 0;
        String str74 = null;
        String str75 = null;
        ?? r420 = 0;
        ?? r421 = 0;
        ?? r422 = 0;
        Integer num2 = null;
        String str76 = null;
        String str77 = null;
        Boolean bool2 = null;
        int i5 = -8193;
        int i6 = 7;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        String str78 = null;
        String str79 = null;
        ?? r423 = 0;
        ?? r424 = 0;
        ?? r425 = 0;
        String str80 = null;
        String str81 = null;
        ?? r426 = 0;
        ?? r427 = 0;
        ?? r428 = 0;
        String str82 = null;
        String str83 = null;
        ?? r429 = 0;
        ?? r430 = 0;
        ?? r431 = 0;
        String str84 = null;
        String str85 = null;
        ?? r432 = 0;
        ?? r433 = 0;
        String str86 = null;
        String str87 = null;
        ?? r434 = 0;
        ?? r435 = 0;
        ?? r436 = 0;
        String str88 = null;
        String str89 = null;
        ?? r437 = 0;
        ?? r438 = 0;
        ?? r439 = 0;
        String str90 = null;
        String str91 = null;
        String str92 = null;
        String str93 = null;
        String str94 = null;
        String str95 = null;
        String str96 = null;
        String str97 = null;
        String str98 = null;
        String str99 = null;
        String str100 = null;
        String str101 = null;
        String str102 = null;
        boolean z7 = false;
        String str103 = null;
        String str104 = null;
        String str105 = null;
        String str106 = null;
        String str107 = null;
        String str108 = null;
        boolean z8 = false;
        String str109 = null;
        SkuAttributeEntity skuAttributeEntity4 = null;
        boolean z9 = false;
        boolean z10 = false;
        int i7 = -8193;
        int i8 = 7;
        DefaultConstructorMarker defaultConstructorMarker3 = null;
        String str110 = null;
        String str111 = null;
        ?? r440 = 0;
        ?? r441 = 0;
        ?? r443 = 0;
        String str112 = null;
        String str113 = null;
        ?? r444 = 0;
        ?? r445 = 0;
        ?? r446 = 0;
        String str114 = null;
        String str115 = null;
        ?? r447 = 0;
        ?? r448 = 0;
        ?? r449 = 0;
        defaultServices = MapsKt.hashMapOf(TuplesKt.to("service_paylater_loan_personal", new ThirdPartyEntity(str3, str3, str3, str3, str3, str3, str3, str3, str3, str3, str3, str3, str3, false, str4, str4, str4, str4, str4, str4, false, r3, r3, false, r32, r32, r32, r32, false, r33, r33, r33, r33, r33, r33, -8193, 7, null)), TuplesKt.to(((String) objArr7[0]).intern(), new ThirdPartyEntity(r54, "GET", r56, null, "https://a.m.dana.id/resource/services/icon_mobile_recharge_new.png", "/m/mobilerecharge", "Pulsa & Data", str5, str6, null, str7, r65, "mobilerecharge", true, "Beli Pulsa Yuk!", str8, "mobilerecharge_button_title", null, "mobile, recharge, pulsa, paket, data", null, false, r75, skuAttributeEntity, false, null, null, null, null, false, null, r84, null, null, null, null, -4550771, 7, null)), TuplesKt.to("service_akulaku", new ThirdPartyEntity(null, null, str9, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, false, null, r44, false, null, null, null, null, false, null, r52, r53, r54, str10, r56, -8193, 7, r59)), TuplesKt.to("service_bank", new ThirdPartyEntity(null, "GET", null, null, "https://a.m.dana.id/resource/services/icon_bank_new.png", "/m/dbac/landing-page", "Bank Services", null, null, null, null, null, "redirectBank", true, null, null, null, null, null, null, false, null, null, false, null, null, null, null, false, null, null, null, null, null, null, -12403, 7, null)), TuplesKt.to("service_bukalapak", new ThirdPartyEntity(null, "GET", null, null, "http://a.m.dana.id/resource/imgs/merchant/newbukalapak.png", "https://link.dana.id/ipg-registration?params=%5BipgPayload%3D%7B%22bizType%22%3A%22bukalapak%22%2C%22logo%22%3A%22http%3A%2F%2Fa.m.dana.id%2Fresource%2Fimgs%2Fbukalapak%2Fnew_binding.png%22%7D%5D", "Bukalapak", null, null, null, null, null, "redirectBukalapak", true, "bukalapak_description", null, "bukalapak_button_title", null, null, null, false, null, null, false, null, null, null, null, false, null, null, null, null, null, null, -94323, 7, null)), TuplesKt.to("service_dana_food", new ThirdPartyEntity("service_dana_food", null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, false, null, null, false, r34, r34, r34, r34, false, r35, r35, r35, r35, r35, r35, -8194, 7, null)), TuplesKt.to("service_dana_resupply", new ThirdPartyEntity(str9, "POST", "2021072946449119029150", str9, "https://a.m.dana.id/promo/homeservices/DANA-grosir.png", str9, "DANA Grosir", str9, str9, "alipayplus.mobilewallet.oauth.authcode.apply.json", "https://m.dana.id/i/dana-resupply/", "PUBLIC_ID,CASHIER,AGREEMENT_PAY,QUERY_BALANCE,DEFAULT_BASIC_PROFILE,MINI_DANA", "", true, "Beli stok bisnis di sini!", str11, "BELI", str11, "Grosir, grosiran, ecer, eceran, stok, barang, beli, belanja, DANA Bisnis, bisnis, usaha", str11, false, r24, r24, false, r242, r242, r242, r242, false, r243, r243, r243, r243, r243, r243, -360023, 7, null)), TuplesKt.to("service_credit_card_repayment", new ThirdPartyEntity(str12, "GET", "", str12, "https://a.m.dana.id/resource/services/icon_credit_card_new.png", "/i/biller-app/cc/provider", PayMethodModel.CashierSectionTitle.CREDIT_CARD, str12, str12, "", str12, "", "GET", true, "", str13, "", str13, "credit, card, kartu, kredit", str13, true, null, new SkuAttributeEntity(CollectionsKt.emptyList(), r75, null, "#ffeae9", PayMethodModel.CashierSectionTitle.CREDIT_CARD, "https://a.m.dana.id/resource/services/icon_credit_card_new.png", "", "service_credit_card_repayment", "/i/biller-app/cc/payment", 6, r84), false, r2, r2, r2, r2, false, r22, r22, r22, r22, r22, r22, -5601911, 7, null)), TuplesKt.to("service_danakaget", new ThirdPartyEntity(str14, "GET", str14, str14, "https://a.m.dana.id/promo/homeservices/icon-luckymoney-nataru.png", "/m/luckymoney?numberOfMember=201&minWinnerSize=2", "Send DANA Kaget", "Kirim DANA Kaget", str14, str14, str14, str14, "redirectluckymoney", true, "Buat tahun baru jadi seru!", str15, "Send", str15, "DANA, Kaget", str15, true, r23, r23, false, r25, r25, r25, r25, false, r26, r26, r26, r26, r26, r26, -1405171, 7, null)), TuplesKt.to(MyBillsServiceKey.ELECTRICITY, new ThirdPartyEntity(str16, "GET", str16, str16, "https://a.m.dana.id/resource/services/icon_electricity_new.png", "/i/biller-app/electricity", ServiceName.ELECTRICITY, str16, str16, str16, str16, str16, "redirect", true, "electricity_description", str17, "electricity_button_title", str17, "Electricity, Listrik", str17, false, null, new SkuAttributeEntity(r74, CollectionsKt.listOf("ELECTRICITY_PLN_LAST_RECHARGE_ID"), CollectionsKt.listOf("ELECTRICITY_POST_PLN_LAST_RECHARGE_ID"), "#E9F5FE", ServiceName.ELECTRICITY, "https://a.m.dana.id/resource/services/icon_electricity_new.png", "", MyBillsServiceKey.ELECTRICITY, "/i/biller-app/electricity/postpaid?", 1, r84), false, r27, r27, r27, r27, false, r28, r28, r28, r28, r28, r28, -4550771, 7, null)), TuplesKt.to("service_withdraw", new ThirdPartyEntity(str18, "GET", str18, str18, "https://a.m.dana.id/resource/services/icon_withdraw_new.png", DanaUrl.CASHOUT, TrackerKey.TransactionType.WITHDRAW, str18, str18, str18, str18, str18, "redirectwithdraw", true, "withdraw_description", str19, "withdraw_button_title", str19, "Cash, out, Tarik, Saldo", str19, false, r29, r29, false, r210, r210, r210, r210, false, r211, r211, r211, r211, r211, r211, -356467, 7, null)), TuplesKt.to(MyBillsServiceKey.DIGITAL_VOUCHER, new ThirdPartyEntity(null, r442, str20, str21, str22, str23, r49, str24, r51, r52, r53, r54, str10, false, null, str25, r59, str26, str5, str6, false, str7, r65, false, null, r68, str8, str27, false, null, r73, r74, r752, r76, r77, -8193, 7, null)), TuplesKt.to(ServicesEntityRepository.SERVICE_GAMES, new ThirdPartyEntity(r442, str20, str21, str22, str23, r49, str24, r51, r52, r53, r54, str10, str28, z2, str25, r59, str26, str5, str6, str29, z3, r65, skuAttributeEntity2, z4, r68, str8, str27, str30, z5, r73, r74, r752, r76, r77, null, -8193, 7, null)), TuplesKt.to("service_googleplay", new ThirdPartyEntity(str31, "GET", str31, str31, "https://a.m.dana.id/promo/homeservices/icon_google_play.png", "/m/blackhawk", "Google Play", str31, str31, str31, str31, str31, "blackhawk", true, "googleplay_description", str32, "googleplay_button_title", str32, str32, str32, false, "{\"home\":\".d36020\",\"all\":\".d39904\"}", null, false, r4, r4, r4, r4, false, r42, r42, r42, r42, r42, r42, -2191475, 7, null)), TuplesKt.to(MyBillsServiceKey.WATER, new ThirdPartyEntity(str33, "GET", str33, str33, "https://a.m.dana.id/resource/services/icon_water_new.png", "/i/dana-water", ServiceName.WATER, str33, str33, str33, str33, str33, "redirectpdam", true, "water_description", str34, "water_buton_title", str34, "Water, Air", str34, false, null, new SkuAttributeEntity(CollectionsKt.listOf((Object[]) new String[]{"WATER_PDAM_AETRA_LAST_RECHARGE_ID", "WATER_PDAM_PALYJA_LAST_RECHARGE_ID", "WATER_PDAM_KOTA_BOGOR_LAST_RECHARGE_ID"}), r752, r76, Pallette.BLUE_10, ServiceName.WATER, "https://a.m.dana.id/resource/services/icon_water_new.png", "", MyBillsServiceKey.WATER, "/i/dana-water/payment?", i, r84), false, r212, r212, r212, r212, false, r213, r213, r213, r213, r213, r213, -4550771, 7, null)), TuplesKt.to(MyBillsServiceKey.TELEPHONE, new ThirdPartyEntity(str35, str35, str35, "2166010051363143", "https://a.m.dana.id/resource/services/icon_telephone_new.png", str35, ServiceName.TELEPHONE, str35, str35, str35, str35, str35, "redirecttelkom", true, "telephone_description", str36, "telephone_button_title", str36, "Telephone, Telpon, Telkom", str36, false, r43, r43, false, r45, r45, r45, r45, false, r46, r46, r46, r46, r46, r46, -356441, 7, null)), TuplesKt.to(MyBillsServiceKey.BPJS, new ThirdPartyEntity(str37, "GET", str37, str37, "https://a.m.dana.id/resource/services/icon_bpjs_new.png", "/i/bpjs/index", "BPJS Kesehatan", str37, str37, str37, str37, str37, "redirectbpjs", true, "bpjs_description", str38, "bpjs_button_title", str38, "BPJS", str38, false, null, new SkuAttributeEntity(CollectionsKt.listOf("BPJS_LAST_RECHARGE_ID"), r752, r76, Pallette.GREEN_10, "BPJS Kesehatan", "https://m.dana.id/m/portal/img/entrance/bpjs.png", "", MyBillsServiceKey.BPJS, "/i/bpjs/index/transaction", i, r84), false, r214, r214, r214, r214, false, r215, r215, r215, r215, r215, r215, -4550771, 7, null)), TuplesKt.to(MyBillsServiceKey.INSTALLMENT, new ThirdPartyEntity(str39, "GET", "2017060600000000000007", str39, "https://a.m.dana.id/resource/services/icon_installment_new.png", "/i/biller-app/installment", ServiceName.INSTALLMENT, str39, str39, "alipayplus.mobilewallet.oauth.authcode.apply.json", str39, "PUBLIC_ID", "redirectmultifinance", true, "installment_description", str40, "installment_button_title", str40, "Cicilan, Installment", str40, false, r47, r47, false, r48, r48, r48, r48, false, r410, r410, r410, r410, r410, r410, -359031, 7, null)), TuplesKt.to(MyBillsServiceKey.INSURANCE, new ThirdPartyEntity(str41, "GET", "2017060600000000000007", str41, "https://a.m.dana.id/resource/services/icon_insurance_new.png", "/i/biller-app/insurance", "Pay Insurance", str41, str41, "alipayplus.mobilewallet.oauth.authcode.apply.json", str41, "PUBLIC_ID", "redirectinsurance", true, "insurance_description", str42, "insurance_button_title", str42, "Insurance, Asuransi", str42, false, r411, r411, false, r412, r412, r412, r412, false, r413, r413, r413, r413, r413, r413, -359031, 7, null)), TuplesKt.to("service_cabletv", new ThirdPartyEntity(str43, "POST", "2017060600000000000007", str43, "https://a.m.dana.id/promo/homeservices/icon_cable_tv.png", str43, "Cable TV", str43, str43, "alipayplus.mobilewallet.oauth.authcode.apply.json", "https://solusipay.com/danav2/#/redirectcabletv", "PUBLIC_ID", "redirectcabletv", true, "cabletv_description", str44, "cabletv_button_title", str44, "Cable, TV, Kabel", str44, false, r414, r414, false, r415, r415, r415, r415, false, r416, r416, r416, r416, r416, r416, -360023, 7, null)), TuplesKt.to(MyBillsServiceKey.MOBILE_POSTPAID, new ThirdPartyEntity(str46, "GET", str46, str46, "https://a.m.dana.id/resource/services/icon_m_postpaid_new.png", "/i/biller-app/mobile-postpaid", ServiceName.MOBILE_POSTPAID, str46, str46, str46, str46, str46, "redirectpostpaid", true, "mobilepostpaid_description", str47, "mobilepostpaid_button_title", str47, "Mobile, Postpaid, Pascabayar, Pulsa, Paket, Data", str47, false, null, new SkuAttributeEntity(r742, r752, CollectionsKt.listOf("TELCO_POST_LAST_RECHARGE_ID"), "#ffeae9", ServiceName.MOBILE_POSTPAID, "https://a.m.dana.id/resource/services/icon_m_postpaid_new.png", "", str, str45, DeepRecoverARiverProxy.TYPE_ENTITY_PLUGIN, r84), false, r36, r36, r36, r36, false, r37, r37, r37, r37, r37, r37, -4550771, 7, null)), TuplesKt.to("service_tix", new ThirdPartyEntity(str48, "GET", str48, str48, "https://a.m.dana.id/resource/services/icon_tix_newer.png", "https://tixid.onelink.me/xWRW/danawidget", "TIX ID", str48, str48, str48, str48, str48, "redirecttix", true, "tix_description", str49, "tix_button_title", str49, "TIX, XXI, Tiket, Ticket, Bioskop", str49, false, r38, r38, false, r39, r39, r39, r39, false, r310, r310, r310, r310, r310, r310, -356467, 7, null)), TuplesKt.to("service_parking", new ThirdPartyEntity(str50, "GET", str50, str50, "https://a.m.dana.id/resource/services/icon_parking_new.png", "/m/parking", "Parking", str50, str50, str50, str50, str50, "redirectparking", true, "parking_description", str51, "parking_button_title", str51, "Parking, Parkir, Secure", str51, false, r216, r216, false, r217, r217, r217, r217, false, r218, r218, r218, r218, r218, r218, -356467, 7, null)), TuplesKt.to("service_zakat", new ThirdPartyEntity(r442, str20, str21, str22, str23, r49, str24, r51, r52, r53, r54, str10, str28, z2, str25, r59, str26, str5, str6, str29, z3, r65, skuAttributeEntity2, z4, r68, str8, str27, str30, z5, null, r742, r752, r762, null, null, -8193, 7, null)), TuplesKt.to("service_my_bills", new ThirdPartyEntity(str52, "GET", str52, str52, "https://a.m.dana.id/resource/services/icon_bills_new.png", "/i/dana-my-bills/lifestyle-subscription-list", TrackerKey.SourceType.MY_BILLS, str52, str52, str52, str52, str52, "redirectmybills", true, "mybills_description", str53, "mybills_button_title", str53, "Manage Bills, Bill, Reminder, Atur Tagihan, Tagihan, Pengingat", "", false, null, new SkuAttributeEntity(CollectionsKt.emptyList(), r752, r762, "#E9F5FE", "Subscriptions", "https://a.m.dana.id/resource/services/icon_bills_new.png", "", "service_my_bills", str45, i2, r84), false, r219, r219, r219, r219, false, r220, r220, r220, r220, r220, r220, -6123635, 7, null)), TuplesKt.to("service_splitbill", new ThirdPartyEntity(str54, "GET", str54, str54, "https://a.m.dana.id/resource/services/icon_split_bill_new.png", "https://link.dana.id/splitbill", "Split Bill", str54, str54, str54, "https://link.dana.id/splitbill", str54, BranchLinkConstant.ActionTarget.SPLIT_BILL, true, "splitbill_description", str55, "splitbill_button_title", str55, "patungan, split, bill", str55, false, r311, r311, false, r312, r312, r312, r312, false, r313, r313, r313, r313, r313, r313, -1406067, 7, null)), TuplesKt.to("service_lazada", new ThirdPartyEntity(str56, "GET", str56, str56, "https://a.m.dana.id/promo/homeservices/icon-lazada.png", "https://link.dana.id/dana-lazada", "Lazada ", str56, str56, str56, str56, str56, "lazadaAction", true, "lazada_description", str57, "lazada_button_title", str57, str57, str57, false, r314, r314, false, r315, r315, r315, r315, false, r316, r316, r316, r316, r316, r316, -94323, 7, null)), TuplesKt.to("service_esamsat", new ThirdPartyEntity(r442, str20, str21, str22, str23, r49, str24, r51, r52, r53, r54, str10, str28, z2, str25, r59, str26, str5, str6, str29, z3, r65, skuAttributeEntity2, z4, r68, str8, str27, str30, z5, num, str58, r752, r762, str59, bool, i3, i4, defaultConstructorMarker)), TuplesKt.to("service_kitabisa", new ThirdPartyEntity(r442, str20, str21, str22, str23, r49, str24, r51, r52, r53, r54, str10, str28, z2, str25, r59, str26, str5, str6, str29, z3, r65, skuAttributeEntity2, z4, r68, str8, str27, str30, z5, num, str58, r752, r762, str59, bool, i3, i4, defaultConstructorMarker)), TuplesKt.to(GlobalNetworkConstants.GLOBAL_NETWORK_SERVICE, new ThirdPartyEntity(r442, str20, str21, str22, str23, r49, str24, r51, r52, r53, r54, str10, str28, z2, str25, r59, str26, str5, str6, str29, z3, r65, skuAttributeEntity2, z4, r68, str8, str27, str30, z5, num, str58, r752, r762, str59, bool, i3, i4, defaultConstructorMarker)), TuplesKt.to("service_covid19", new ThirdPartyEntity(r442, str20, str21, str22, str23, r49, str24, r51, r52, r53, r54, str10, str28, z2, str25, r59, str26, str5, str6, str29, z3, r65, skuAttributeEntity2, z4, r68, str8, str27, str30, z5, num, str58, r752, r762, str59, bool, i3, i4, defaultConstructorMarker)), TuplesKt.to("service_goals", new ThirdPartyEntity(str60, "GET", str60, str60, "https://a.m.dana.id/resource/services/icon_goals_new.png", "https://link.dana.id/goals?params[source=Services]", "DANA Goals", str60, str60, str60, "https://link.dana.id/goals?params[source=Services]", str60, "goals", true, "", str61, "", str61, "goals", str61, false, r317, r317, false, r318, r318, r318, r318, false, r319, r319, r319, r319, r319, r319, -357491, 7, null)), TuplesKt.to("service_qris_topup", new ThirdPartyEntity(r442, str20, str21, str22, str23, r49, str24, r51, r52, r53, r54, str10, str28, z2, str25, r59, str26, str5, str6, str29, z3, r65, skuAttributeEntity2, z4, r68, str8, str27, str30, z5, num, str58, r752, r762, str59, bool, i3, i4, defaultConstructorMarker)), TuplesKt.to("service_deals", new ThirdPartyEntity(str62, "GET", "2020022069484209111787", str62, "https://a.m.dana.id/resource/services/icon-dana-deals-new.png", "/i/dana-promotion/dana-deals", TrackerKey.PromoCenterSourceType.DANA_DEALS, str62, str62, str62, str62, str62, "redirectDeals", true, "dana deals", str63, str2, str63, str63, str63, false, r320, r320, false, r321, r321, r321, r321, false, r322, r322, r322, r322, r322, r322, -1142903, 7, null)), TuplesKt.to("service_delivery", new ThirdPartyEntity("service_delivery", "POST", "2020030615072407440743", str64, "https://a.m.dana.id/resource/services/icon_delivey_new.png", str64, "Delivery", str64, str64, "alipayplus.mobilewallet.oauth.authcode.apply.json", "https://prod-ampera.innov8.id/binding/callback?redirect_url=https://delivery.m.dana.id", "PUBLIC_ID", "delivery", true, "delivery services", str65, "inno_dana_delivery", str65, "dana, delivery, sameday", str65, false, r323, r323, false, r324, r324, r324, r324, false, r325, r325, r325, r325, r325, r325, -360024, 7, null)), TuplesKt.to("service_digital_money", new ThirdPartyEntity(str66, "POST", "2020030615072407440743", str66, "https://a.m.dana.id/resource/services/icon_digital_money_new.png", str66, "Saldo Digital", str66, str66, "alipayplus.mobilewallet.oauth.authcode.apply.json", "https://prod-ampera.innov8.id/binding/callback?redirect_url=https://billers.m.dana.id/SVC-b0546a48", "PUBLIC_ID,TRANSFER_MONEY,DEFAULT_BASIC_PROFILE", "", true, "", str67, "", str67, "Saldo Digital", str67, true, r326, r326, false, r327, r327, r327, r327, false, r328, r328, r328, r328, r328, r328, -1408599, 7, null)), TuplesKt.to("service_dummy_mp", new ThirdPartyEntity(r442, str20, str21, str22, str23, r49, str24, r51, r52, r53, r54, str10, str28, z2, str25, r59, str26, str5, str6, str29, z3, r65, skuAttributeEntity2, z4, r68, str8, str27, str30, z5, num, str58, r752, r762, str59, bool, i3, i4, defaultConstructorMarker)), TuplesKt.to("service_e_commerce", new ThirdPartyEntity(r442, str20, str21, str22, str23, r49, str24, r51, r52, r53, r54, str10, str28, z2, str25, r59, str26, str5, str6, str29, z3, r65, skuAttributeEntity2, z4, r68, str8, str27, str30, z5, num, str58, r752, r762, str59, bool, i3, i4, defaultConstructorMarker)), TuplesKt.to("service_e_samsat", new ThirdPartyEntity(str68, "GET", str68, str68, "https://a.m.dana.id/resource/services/icon_e_samsat.png", "/i/biller-app/samsat", "e-Samsat", str68, str68, str68, str68, str68, "esamsat", true, "e-samsat", str69, "e-Samsat", str69, str69, str69, false, r329, r329, false, r330, r330, r330, r330, false, r331, r331, r331, r331, r331, r331, -1142899, 7, null)), TuplesKt.to(((String) objArr9[0]).intern(), new ThirdPartyEntity(str70, "POST", "2020060301057416795497", str70, "https://a.m.dana.id/resource/services/icon_dana_emas_new.png", str70, "eMAS", str70, str70, "alipayplus.mobilewallet.oauth.authcode.apply.json", "https://prod-ampera.innov8.id/binding/callback?redirect_url=https://gold.m.dana.id/", "QUERY_BALANCE,DEFAULT_BASIC_PROFILE,MINI_DANA,PUBLIC_ID,KYC_INFO,TRANSFER_MONEY,CASHIER", AccountEntityRepository.BalanceType.EMAS, true, "Buying and Selling gold", str71, str71, str71, "Gold,Emas,Pluang", str71, false, null, skuAttributeEntity3, false, r9, r9, r9, r9, false, r92, r92, r92, r92, r92, r92, -5537367, 7, null)), TuplesKt.to(MyBillsServiceKey.GAS_PGN, new ThirdPartyEntity(str72, "GET", "", str72, "https://a.m.dana.id/resource/services/icon_gas_new.png", "/i/biller-app/pgn", "PGN Gas", str72, str72, "alipayplus.mobilewallet.oauth.authcode.apply.json", str72, "PUBLIC_ID", "Gas", true, "PGN Gas", str73, "Pay Now", str73, "Gas, PGN", str73, false, r417, r417, false, r418, r418, r418, r418, false, r419, r419, r419, r419, r419, r419, -359031, 7, null)), TuplesKt.to("service_happyfresh", new ThirdPartyEntity(str74, "POST", "2020082285691341067539", str74, "https://a.m.dana.id/resource/imgs/entrance/icon_service_happy_fresh.png", str74, "HappyFresh", str74, str74, "alipayplus.mobilewallet.oauth.authcode.apply.json", "http://dana.happyfresh.com/", "PUBLIC_ID,CASHIER,QUERY_BALANCE,DEFAULT_BASIC_PROFILE,MINI_DANA", "", true, "", str75, str75, str75, "HappyFresh", str75, false, r420, r420, false, r421, r421, r421, r421, false, r422, r422, r422, r422, r422, r422, -1343063, 7, null)), TuplesKt.to("service_home_shopping", new ThirdPartyEntity(r442, str20, str21, str22, str23, r49, str24, r51, r52, r53, r54, str10, str28, z2, str25, r59, str26, str5, str6, str29, z3, r65, skuAttributeEntity2, z4, r68, str8, str27, str30, z5, num2, str76, r752, r762, str77, bool2, i5, i6, defaultConstructorMarker2)), TuplesKt.to(MyBillsServiceKey.INTERNET_CABLE_TV, new ThirdPartyEntity(str78, "GET", str78, str78, "https://a.m.dana.id/resource/services/icon_internet_tvcable_new.png", "/i/biller-app/internet-tvcable", "Internet & Cable TV", str78, str78, str78, str78, str78, "", true, "internet and cable tv", str79, "Buy Now", str79, "internet, cable, tv, kabel, televisi", str79, true, r423, r423, false, r424, r424, r424, r424, false, r425, r425, r425, r425, r425, r425, -1405043, 7, null)), TuplesKt.to("service_iprice", new ThirdPartyEntity(r442, str20, str21, str22, str23, r49, str24, r51, r52, r53, r54, str10, str28, z2, str25, r59, str26, str5, str6, str29, z3, r65, skuAttributeEntity2, z4, r68, str8, str27, str30, z5, num2, str76, r752, r762, str77, bool2, i5, i6, defaultConstructorMarker2)), TuplesKt.to("service_kyb", new ThirdPartyEntity(str80, "GET", str80, str80, "https://a.m.dana.id/resource/services/icon_dana_bisnis_new.png", DanaUrl.KYB_LANDING_PAGE, "DANA Bisnis", str80, str80, str80, str80, str80, "redirectkyb", true, "", str81, "", str81, "bisnis", str81, false, r426, r426, false, r427, r427, r427, r427, false, r428, r428, r428, r428, r428, r428, -1405043, 7, null)), TuplesKt.to("service_loyalty", new ThirdPartyEntity(str82, "GET", str82, str82, "https://a.m.dana.id/resource/services/icon_loyalty_card_new.png", "/i/dana-promotion/pocket/list?tabName=loyalty", "Loyalty", str82, str82, str82, str82, str82, "loyalty", true, "Bikin kartu loyalty, dapetin points & voucher gratis!", str83, "BUAT", str83, "promo, member, points, loyalty, kartu", str83, false, r429, r429, false, r430, r430, r430, r430, false, r431, r431, r431, r431, r431, r431, -356467, 7, null)), TuplesKt.to("service_miles", new ThirdPartyEntity(r442, str20, str21, str22, str23, r49, str24, r51, r52, r53, r54, str10, str28, z2, str25, r59, str26, str5, str6, str29, z3, r65, skuAttributeEntity2, z4, r68, str8, str27, str30, z5, num2, str76, r752, r762, str77, bool2, i5, i6, defaultConstructorMarker2)), TuplesKt.to("service_pasarpolis", new ThirdPartyEntity(str84, "GET", "2020052626731886972414", str84, "https://a.m.dana.id/resource/services/icon_dana_siaga_new.png", "/n/dana-finance/insurance", "DANA Siaga", str84, str84, "alipayplus.mobilewallet.oauth.authcode.apply.json", str84, "PUBLIC_ID", "redirectpolis", true, "pasarpolis_description", str85, "pasarpolis_button_title", str85, "Pasar, Polis, Axa", str85, true, null, new SkuAttributeEntity(CollectionsKt.emptyList(), r752, r762, Pallette.BLUE_10, "DANA Siaga", "https://a.m.dana.id/resource/services/icon_dana_siaga_new.png", "", "service_pasarpolis", str45, i2, r84), false, r432, r432, r432, r432, false, r433, r433, r433, r433, r433, r433, -5601911, 7, null)), TuplesKt.to("service_send_money_bank", new ThirdPartyEntity(str86, "GET", str86, str86, "https://a.m.dana.id/promo/homeservices/icon_transfer_to_bank.png", "https://link.dana.id/kirim-bank", "Transfer via Bank", str86, str86, str86, "https://link.dana.id/kirim-bank", str86, BranchLinkConstant.ActionTarget.SEND_MONEY_BANK, true, "Transfer cepat & gampang!", str87, "Send", str87, "transfer to bank, transfer, bank, kirim uang ke bank, kirim", str87, false, r434, r434, false, r435, r435, r435, r435, false, r436, r436, r436, r436, r436, r436, -1406067, 7, null)), TuplesKt.to("service_send_money_chat", new ThirdPartyEntity(str88, "GET", str88, str88, "https://a.m.dana.id/resource/services/icon_sendto_chat_new.png", "https://link.dana.id/kirim-uang-chat", "Transfer via Chat", str88, str88, str88, "https://link.dana.id/kirim-uang-chat", str88, BranchLinkConstant.ActionTarget.SEND_MONEY_CHAT, true, "Send Money to Chat", str89, "Send", str89, "kirim uang, send money, send money to chat, chat, link", str89, false, r437, r437, false, r438, r438, r438, r438, false, r439, r439, r439, r439, r439, r439, -1406067, 7, null)), TuplesKt.to("service_sisberdaya", new ThirdPartyEntity(str90, str91, str92, str93, str94, str95, str96, str97, str98, str99, str100, str101, str102, z7, str103, str104, str105, str106, str107, str108, z8, str109, skuAttributeEntity4, z9, r442, str20, str21, str22, z10, r49, str24, r51, r52, r53, r54, i7, i8, defaultConstructorMarker3)), TuplesKt.to("service_vidio", new ThirdPartyEntity(str110, "GET", str110, str110, "https://a.m.dana.id/resource/services/icon_vidio_new.png", "/m/gamevoucher/denomination?productCode=DIGITAL_VOUCHER_VIDIO", "Vidio", str110, str110, str110, str110, str110, "vidiovoucher", true, str111, str111, str111, str111, "vidio", str111, false, r440, r440, false, r441, r441, r441, r441, false, r443, r443, r443, r443, r443, r443, -274547, 7, null)), TuplesKt.to("service_warung_pangan", new ThirdPartyEntity(str90, str91, str92, str93, str94, str95, str96, str97, str98, str99, str100, str101, str102, z7, str103, str104, str105, str106, str107, str108, z8, str109, skuAttributeEntity4, z9, r442, str20, str21, str22, z10, r49, str24, r51, r52, r53, r54, i7, i8, defaultConstructorMarker3)), TuplesKt.to("service_parkee", new ThirdPartyEntity(str112, "GET", str112, str112, "https://a.m.dana.id/promo/homeservices/icon-parkee.png", "https://m.dana.id/m/parkee", "Parkee ", str112, str112, str112, str112, str112, "parkeeAction", true, "parkee_description", str113, "parkee_button_title", str113, str113, str113, false, r444, r444, false, r445, r445, r445, r445, false, r446, r446, r446, r446, r446, r446, -94323, 7, null)), TuplesKt.to("service_miniprogram_store", new ThirdPartyEntity(str114, "GET", str114, str114, "https://a.m.dana.id/xxxx/xxxxx/xxxxxx.png", "https://link.dana.id/miniprogram-store", "Mini Program Store", str114, str114, str114, "https://link.dana.id/miniprogram-store", str114, BranchLinkConstant.ActionTarget.MINI_PROGRAM_STORE, false, "Mini Program Store", str115, "MP Store", str115, "mini program, store, mini program store", str115, false, r447, r447, false, r448, r448, r448, r448, false, r449, r449, r449, r449, r449, r449, -1406067, 7, null)));
        int i9 = getAuthRequestContext + 25;
        KClassImpl$Data$declaredNonStaticMembers$2 = i9 % 128;
        if (i9 % 2 == 0) {
            z = true;
        } else {
            z = true;
            z6 = true;
        }
        if (z6 != z) {
            Object obj = null;
            obj.hashCode();
        }
    }

    @JvmName(name = "getDefaultServices")
    public final HashMap<String, ThirdPartyEntity> getDefaultServices() {
        int i = getAuthRequestContext + 45;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        HashMap<String, ThirdPartyEntity> hashMap = defaultServices;
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 5;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x006e, code lost:
    
        if (r0.MyBillsEntityDataFactory == r0.PlaceComponentResult) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0082, code lost:
    
        if (r0.MyBillsEntityDataFactory == r0.PlaceComponentResult) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
    
        r3[r0.getAuthRequestContext] = (char) (r0.MyBillsEntityDataFactory - r12);
        r3[r0.getAuthRequestContext + 1] = (char) (r0.PlaceComponentResult - r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0097, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory = r0.MyBillsEntityDataFactory / r2;
        r0.scheduleImpl = r0.MyBillsEntityDataFactory % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = r0.PlaceComponentResult / r2;
        r0.lookAheadTest = r0.PlaceComponentResult % r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00af, code lost:
    
        if (r0.scheduleImpl != r0.lookAheadTest) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b1, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b3, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b4, code lost:
    
        if (r7 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ba, code lost:
    
        if (r0.BuiltInFictitiousFunctionClassFactory != r0.KClassImpl$Data$declaredNonStaticMembers$2) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bc, code lost:
    
        r0.scheduleImpl = ((r0.scheduleImpl + r2) - 1) % r2;
        r0.lookAheadTest = ((r0.lookAheadTest + r2) - 1) % r2;
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e6, code lost:
    
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.lookAheadTest;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.scheduleImpl;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0102, code lost:
    
        r7 = id.dana.data.services.repository.source.model.DefaultServiceCategory.$10 + 105;
        id.dana.data.services.repository.source.model.DefaultServiceCategory.$11 = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x010c, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory = ((r0.BuiltInFictitiousFunctionClassFactory + r2) - 1) % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = ((r0.KClassImpl$Data$declaredNonStaticMembers$2 + r2) - 1) % r2;
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0135, code lost:
    
        r0.getAuthRequestContext += 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(char[] r11, byte r12, int r13, java.lang.Object[] r14) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.source.model.DefaultServiceCategory.a(char[], byte, int, java.lang.Object[]):void");
    }
}
