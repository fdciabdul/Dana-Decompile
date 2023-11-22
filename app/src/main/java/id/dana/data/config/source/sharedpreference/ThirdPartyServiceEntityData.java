package id.dana.data.config.source.sharedpreference;

import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.constant.UrlParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001Bï\u0003\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u000100\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010Z\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010S\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010X\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u000100\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010G\u001a\u00020!\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\bg\u0010hR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001c\u0010\"\u001a\u0004\u0018\u00010!8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b&\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010'\u001a\u0004\b)\u0010(R\u001c\u0010*\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010'\u001a\u0004\b*\u0010(R\u001c\u0010+\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b+\u0010(R\u001c\u0010,\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006R\u001c\u0010.\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006R\"\u00101\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001008\u0007X\u0087\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0006R\u001c\u00107\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010\u0004\u001a\u0004\b8\u0010\u0006R\u001c\u00109\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010\u0004\u001a\u0004\b:\u0010\u0006R\u001c\u0010;\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010\u0004\u001a\u0004\b<\u0010\u0006R\u001c\u0010=\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010\u0004\u001a\u0004\b>\u0010\u0006R\u001c\u0010?\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010'\u001a\u0004\b@\u0010(R\u001c\u0010A\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010\u0004\u001a\u0004\bB\u0010\u0006R\u001c\u0010C\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010\u0004\u001a\u0004\bD\u0010\u0006R\u001c\u0010E\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010\u0004\u001a\u0004\bF\u0010\u0006R\u001a\u0010G\u001a\u00020!8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bK\u0010\u0004\u001a\u0004\bL\u0010\u0006R\u001c\u0010M\u001a\u0004\u0018\u00010!8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bM\u0010#\u001a\u0004\bN\u0010%R\u001c\u0010O\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bO\u0010\u0004\u001a\u0004\bP\u0010\u0006R\u001c\u0010Q\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bQ\u0010\u0004\u001a\u0004\bR\u0010\u0006R\u001c\u0010T\u001a\u0004\u0018\u00010S8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\"\u0010X\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001008\u0007X\u0087\u0004¢\u0006\f\n\u0004\bX\u00102\u001a\u0004\bY\u00104R\u001c\u0010[\u001a\u0004\u0018\u00010Z8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u001c\u0010_\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b_\u0010\u0004\u001a\u0004\b`\u0010\u0006R\u001c\u0010a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\ba\u0010\u0004\u001a\u0004\bb\u0010\u0006R\u001c\u0010c\u001a\u0004\u0018\u00010!8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bc\u0010#\u001a\u0004\bd\u0010%R\u001c\u0010e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\be\u0010\u0004\u001a\u0004\bf\u0010\u0006"}, d2 = {"Lid/dana/data/config/source/sharedpreference/ThirdPartyServiceEntityData;", "", "", "action", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "", "alwaysConsult", "Z", "getAlwaysConsult", "()Z", "appId", "getAppId", "Lid/dana/data/config/source/sharedpreference/BannerLottieEntityData;", "bannerLottie", "Lid/dana/data/config/source/sharedpreference/BannerLottieEntityData;", "getBannerLottie", "()Lid/dana/data/config/source/sharedpreference/BannerLottieEntityData;", "bizType", "getBizType", "buttonTitle", "getButtonTitle", "clientId", "getClientId", "description", "getDescription", "headerBackgroundColor", "getHeaderBackgroundColor", "icon", "getIcon", "iconLottie", "getIconLottie", "", "indexOfHighlighted", "Ljava/lang/Integer;", "getIndexOfHighlighted", "()Ljava/lang/Integer;", "isBiller", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "isEnable", "isFeatured", "isShowRedDot", "key", "getKey", "keyCategory", "getKeyCategory", "", "keywords", "Ljava/util/List;", "getKeywords", "()Ljava/util/List;", "link", "getLink", "loanStatus", "getLoanStatus", "name", "getName", "nameInd", "getNameInd", "nameTag", "getNameTag", UrlParam.NEED_CONSULT, "getNeedConsult", BranchLinkConstant.MiniAppParams.NEED_OAUTH, "getNeedOauth", "operationType", "getOperationType", "redirectUrl", "getRedirectUrl", "remainingDueDays", "I", "getRemainingDueDays", "()I", "ribbonText", "getRibbonText", "rotationDelayTime", "getRotationDelayTime", "scopes", "getScopes", "screenOrientation", "getScreenOrientation", "Lid/dana/data/config/source/sharedpreference/SkuAttributeModelEntityData;", "skuAttributeModel", "Lid/dana/data/config/source/sharedpreference/SkuAttributeModelEntityData;", "getSkuAttributeModel", "()Lid/dana/data/config/source/sharedpreference/SkuAttributeModelEntityData;", "spaceCodes", "getSpaceCodes", "Lid/dana/data/config/source/sharedpreference/SpmIdEntityData;", "spmId", "Lid/dana/data/config/source/sharedpreference/SpmIdEntityData;", "getSpmId", "()Lid/dana/data/config/source/sharedpreference/SpmIdEntityData;", "subtitleBorderColor", "getSubtitleBorderColor", "subtitleColor", "getSubtitleColor", "type", "getType", "userAction", "getUserAction", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lid/dana/data/config/source/sharedpreference/SpmIdEntityData;Ljava/lang/Boolean;Lid/dana/data/config/source/sharedpreference/SkuAttributeModelEntityData;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;ILjava/lang/String;Ljava/lang/Integer;Lid/dana/data/config/source/sharedpreference/BannerLottieEntityData;Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ThirdPartyServiceEntityData {
    private final String action;
    private final boolean alwaysConsult;
    private final String appId;
    private final BannerLottieEntityData bannerLottie;
    private final String bizType;
    private final String buttonTitle;
    private final String clientId;
    private final String description;
    private final String headerBackgroundColor;
    private final String icon;
    private final String iconLottie;
    private final Integer indexOfHighlighted;
    private final Boolean isBiller;
    private final Boolean isEnable;
    private final Boolean isFeatured;
    private final Boolean isShowRedDot;
    private final String key;
    private final String keyCategory;
    private final List<String> keywords;
    private final String link;
    private final String loanStatus;
    private final String name;
    private final String nameInd;
    private final String nameTag;
    private final Boolean needConsult;
    private final String needOauth;
    private final String operationType;
    private final String redirectUrl;
    private final int remainingDueDays;
    private final String ribbonText;
    private final Integer rotationDelayTime;
    private final String scopes;
    private final String screenOrientation;
    private final SkuAttributeModelEntityData skuAttributeModel;
    private final List<String> spaceCodes;
    private final SpmIdEntityData spmId;
    private final String subtitleBorderColor;
    private final String subtitleColor;
    private final Integer type;
    private final String userAction;

    public ThirdPartyServiceEntityData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, false, -1, 255, null);
    }

    public ThirdPartyServiceEntityData(String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Boolean bool2, Integer num, String str14, String str15, String str16, String str17, String str18, List<String> list, String str19, SpmIdEntityData spmIdEntityData, Boolean bool3, SkuAttributeModelEntityData skuAttributeModelEntityData, Boolean bool4, List<String> list2, String str20, String str21, String str22, Integer num2, Boolean bool5, int i, String str23, Integer num3, BannerLottieEntityData bannerLottieEntityData, String str24, String str25, boolean z) {
        this.key = str;
        this.keyCategory = str2;
        this.action = str3;
        this.clientId = str4;
        this.appId = str5;
        this.isEnable = bool;
        this.icon = str6;
        this.link = str7;
        this.name = str8;
        this.nameInd = str9;
        this.nameTag = str10;
        this.operationType = str11;
        this.redirectUrl = str12;
        this.scopes = str13;
        this.isShowRedDot = bool2;
        this.type = num;
        this.userAction = str14;
        this.description = str15;
        this.subtitleColor = str16;
        this.buttonTitle = str17;
        this.subtitleBorderColor = str18;
        this.keywords = list;
        this.ribbonText = str19;
        this.spmId = spmIdEntityData;
        this.isFeatured = bool3;
        this.skuAttributeModel = skuAttributeModelEntityData;
        this.needConsult = bool4;
        this.spaceCodes = list2;
        this.screenOrientation = str20;
        this.bizType = str21;
        this.needOauth = str22;
        this.indexOfHighlighted = num2;
        this.isBiller = bool5;
        this.remainingDueDays = i;
        this.loanStatus = str23;
        this.rotationDelayTime = num3;
        this.bannerLottie = bannerLottieEntityData;
        this.iconLottie = str24;
        this.headerBackgroundColor = str25;
        this.alwaysConsult = z;
    }

    @JvmName(name = "getKey")
    public final String getKey() {
        return this.key;
    }

    @JvmName(name = "getKeyCategory")
    public final String getKeyCategory() {
        return this.keyCategory;
    }

    @JvmName(name = "getAction")
    public final String getAction() {
        return this.action;
    }

    @JvmName(name = "getClientId")
    public final String getClientId() {
        return this.clientId;
    }

    @JvmName(name = "getAppId")
    public final String getAppId() {
        return this.appId;
    }

    public /* synthetic */ ThirdPartyServiceEntityData(String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Boolean bool2, Integer num, String str14, String str15, String str16, String str17, String str18, List list, String str19, SpmIdEntityData spmIdEntityData, Boolean bool3, SkuAttributeModelEntityData skuAttributeModelEntityData, Boolean bool4, List list2, String str20, String str21, String str22, Integer num2, Boolean bool5, int i, String str23, Integer num3, BannerLottieEntityData bannerLottieEntityData, String str24, String str25, boolean z, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? Boolean.FALSE : bool, (i2 & 64) != 0 ? null : str6, (i2 & 128) != 0 ? null : str7, (i2 & 256) != 0 ? null : str8, (i2 & 512) != 0 ? null : str9, (i2 & 1024) != 0 ? null : str10, (i2 & 2048) != 0 ? null : str11, (i2 & 4096) != 0 ? null : str12, (i2 & 8192) != 0 ? null : str13, (i2 & 16384) != 0 ? Boolean.FALSE : bool2, (i2 & 32768) != 0 ? 0 : num, (i2 & 65536) != 0 ? null : str14, (i2 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : str15, (i2 & 262144) != 0 ? null : str16, (i2 & 524288) != 0 ? null : str17, (i2 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? null : str18, (i2 & 2097152) != 0 ? null : list, (i2 & 4194304) != 0 ? null : str19, (i2 & 8388608) != 0 ? null : spmIdEntityData, (i2 & 16777216) != 0 ? null : bool3, (i2 & 33554432) != 0 ? null : skuAttributeModelEntityData, (i2 & 67108864) != 0 ? Boolean.FALSE : bool4, (i2 & 134217728) != 0 ? null : list2, (i2 & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? null : str20, (i2 & 536870912) != 0 ? null : str21, (i2 & 1073741824) != 0 ? null : str22, (i2 & Integer.MIN_VALUE) != 0 ? null : num2, (i3 & 1) != 0 ? null : bool5, (i3 & 2) != 0 ? -1 : i, (i3 & 4) != 0 ? null : str23, (i3 & 8) != 0 ? null : num3, (i3 & 16) != 0 ? null : bannerLottieEntityData, (i3 & 32) != 0 ? null : str24, (i3 & 64) != 0 ? null : str25, (i3 & 128) == 0 ? z : false);
    }

    @JvmName(name = "isEnable")
    /* renamed from: isEnable  reason: from getter */
    public final Boolean getIsEnable() {
        return this.isEnable;
    }

    @JvmName(name = "getIcon")
    public final String getIcon() {
        return this.icon;
    }

    @JvmName(name = "getLink")
    public final String getLink() {
        return this.link;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "getNameInd")
    public final String getNameInd() {
        return this.nameInd;
    }

    @JvmName(name = "getNameTag")
    public final String getNameTag() {
        return this.nameTag;
    }

    @JvmName(name = "getOperationType")
    public final String getOperationType() {
        return this.operationType;
    }

    @JvmName(name = "getRedirectUrl")
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @JvmName(name = "getScopes")
    public final String getScopes() {
        return this.scopes;
    }

    @JvmName(name = "isShowRedDot")
    /* renamed from: isShowRedDot  reason: from getter */
    public final Boolean getIsShowRedDot() {
        return this.isShowRedDot;
    }

    @JvmName(name = "getType")
    public final Integer getType() {
        return this.type;
    }

    @JvmName(name = "getUserAction")
    public final String getUserAction() {
        return this.userAction;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "getSubtitleColor")
    public final String getSubtitleColor() {
        return this.subtitleColor;
    }

    @JvmName(name = "getButtonTitle")
    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    @JvmName(name = "getSubtitleBorderColor")
    public final String getSubtitleBorderColor() {
        return this.subtitleBorderColor;
    }

    @JvmName(name = "getKeywords")
    public final List<String> getKeywords() {
        return this.keywords;
    }

    @JvmName(name = "getRibbonText")
    public final String getRibbonText() {
        return this.ribbonText;
    }

    @JvmName(name = "getSpmId")
    public final SpmIdEntityData getSpmId() {
        return this.spmId;
    }

    @JvmName(name = "isFeatured")
    /* renamed from: isFeatured  reason: from getter */
    public final Boolean getIsFeatured() {
        return this.isFeatured;
    }

    @JvmName(name = "getSkuAttributeModel")
    public final SkuAttributeModelEntityData getSkuAttributeModel() {
        return this.skuAttributeModel;
    }

    @JvmName(name = "getNeedConsult")
    public final Boolean getNeedConsult() {
        return this.needConsult;
    }

    @JvmName(name = "getSpaceCodes")
    public final List<String> getSpaceCodes() {
        return this.spaceCodes;
    }

    @JvmName(name = "getScreenOrientation")
    public final String getScreenOrientation() {
        return this.screenOrientation;
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "getNeedOauth")
    public final String getNeedOauth() {
        return this.needOauth;
    }

    @JvmName(name = "getIndexOfHighlighted")
    public final Integer getIndexOfHighlighted() {
        return this.indexOfHighlighted;
    }

    @JvmName(name = "isBiller")
    /* renamed from: isBiller  reason: from getter */
    public final Boolean getIsBiller() {
        return this.isBiller;
    }

    @JvmName(name = "getRemainingDueDays")
    public final int getRemainingDueDays() {
        return this.remainingDueDays;
    }

    @JvmName(name = "getLoanStatus")
    public final String getLoanStatus() {
        return this.loanStatus;
    }

    @JvmName(name = "getRotationDelayTime")
    public final Integer getRotationDelayTime() {
        return this.rotationDelayTime;
    }

    @JvmName(name = "getBannerLottie")
    public final BannerLottieEntityData getBannerLottie() {
        return this.bannerLottie;
    }

    @JvmName(name = "getIconLottie")
    public final String getIconLottie() {
        return this.iconLottie;
    }

    @JvmName(name = "getHeaderBackgroundColor")
    public final String getHeaderBackgroundColor() {
        return this.headerBackgroundColor;
    }

    @JvmName(name = "getAlwaysConsult")
    public final boolean getAlwaysConsult() {
        return this.alwaysConsult;
    }
}
