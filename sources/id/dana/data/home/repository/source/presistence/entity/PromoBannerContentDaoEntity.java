package id.dana.data.home.repository.source.presistence.entity;

import com.alipay.mobile.security.faceauth.api.AntDetector;
import javax.annotation.Nonnull;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u001c\u0018\u00002\u00020\u0001Bç\u0001\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0003\u0010\u001b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0012¢\u0006\u0004\b-\u0010.R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0011\u0010\u0010\u001a\u00020\u0012X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0012X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/data/home/repository/source/presistence/entity/PromoBannerContentDaoEntity;", "", "", "PlaceComponentResult", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "lookAheadTest", "getErrorConfigVersion", "scheduleImpl", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda1", "initRecordTimeStamp", "DatabaseTableConfigUtil", "", "I", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Ljava/lang/Integer;", "isLayoutRequested", "PrepareContext", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda8", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PromoBannerContentDaoEntity {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final int initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public final Integer GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    public final String isLayoutRequested;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda8;
    public final String getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final String DatabaseTableConfigUtil;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    public final String PrepareContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String lookAheadTest;
    public final String newProxyInstance;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    public PromoBannerContentDaoEntity() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 524287, null);
    }

    public PromoBannerContentDaoEntity(String str, @Nonnull String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Integer num, String str12, String str13, String str14, String str15, String str16, String str17, int i) {
        Intrinsics.checkNotNullParameter(str2, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.getAuthRequestContext = str2;
        this.MyBillsEntityDataFactory = str3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str4;
        this.PlaceComponentResult = str5;
        this.moveToNextValue = str6;
        this.getErrorConfigVersion = str7;
        this.scheduleImpl = str8;
        this.lookAheadTest = str9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str10;
        this.DatabaseTableConfigUtil = str11;
        this.GetContactSyncConfig = num;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str12;
        this.PrepareContext = str13;
        this.newProxyInstance = str14;
        this.isLayoutRequested = str15;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str16;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str17;
        this.initRecordTimeStamp = i;
    }

    public /* synthetic */ PromoBannerContentDaoEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Integer num, String str12, String str13, String str14, String str15, String str16, String str17, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : str6, (i2 & 64) != 0 ? null : str7, (i2 & 128) != 0 ? null : str8, (i2 & 256) != 0 ? null : str9, (i2 & 512) != 0 ? null : str10, (i2 & 1024) != 0 ? null : str11, (i2 & 2048) != 0 ? null : num, (i2 & 4096) != 0 ? null : str12, (i2 & 8192) != 0 ? null : str13, (i2 & 16384) != 0 ? null : str14, (i2 & 32768) != 0 ? null : str15, (i2 & 65536) != 0 ? null : str16, (i2 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : str17, (i2 & 262144) != 0 ? 0 : i);
    }
}
