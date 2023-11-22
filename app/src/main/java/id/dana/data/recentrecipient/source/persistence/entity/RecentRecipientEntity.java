package id.dana.data.recentrecipient.source.persistence.entity;

import com.alibaba.griver.core.GriverParams;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.danah5.constant.BaseKey;
import id.dana.wallet_v3.constant.WalletConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b \u0018\u00002\u00020\u0001Bß\u0001\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010D\u001a\u00020.\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010J\u001a\u00020.\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\bM\u0010NR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0019\u001a\u00020\u00188\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u001e8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R$\u0010(\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR$\u0010+\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR$\u0010/\u001a\u0004\u0018\u00010.8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR$\u00108\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR$\u0010;\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0004\u001a\u0004\b<\u0010\u0006\"\u0004\b=\u0010\bR$\u0010>\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u0010\bR$\u0010A\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0004\u001a\u0004\bB\u0010\u0006\"\u0004\bC\u0010\bR\"\u0010D\u001a\u00020.8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010J\u001a\u00020.8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010E\u001a\u0004\bK\u0010G\"\u0004\bL\u0010I"}, d2 = {"Lid/dana/data/recentrecipient/source/persistence/entity/RecentRecipientEntity;", "", "", "alias", "Ljava/lang/String;", "getAlias", "()Ljava/lang/String;", "setAlias", "(Ljava/lang/String;)V", WalletConstant.CARD_INDEX_NO, "getCardIndexNo", "setCardIndexNo", "dataId", "getDataId", "setDataId", "id", "getId", "setId", GriverParams.ShareParams.IMAGE_URL, "getImageUrl", "setImageUrl", "instLocalName", "getInstLocalName", "setInstLocalName", "", TrackerKey.SendMoneyProperties.IS_FAVORITE, "Z", "()Z", "setFavorite", "(Z)V", "", "lastUpdateTime", "J", "getLastUpdateTime", "()J", "setLastUpdateTime", "(J)V", BaseKey.LAST_UPDATED, "getLastUpdated", "setLastUpdated", "name", "getName", "setName", "number", "getNumber", "setNumber", "", "participantCount", "Ljava/lang/Integer;", "getParticipantCount", "()Ljava/lang/Integer;", "setParticipantCount", "(Ljava/lang/Integer;)V", "payMethod", "getPayMethod", "setPayMethod", "payOption", "getPayOption", "setPayOption", "prefix", "getPrefix", "setPrefix", "recipientName", "getRecipientName", "setRecipientName", "senderName", "getSenderName", "setSenderName", "transactionCount", "I", "getTransactionCount", "()I", "setTransactionCount", "(I)V", "type", "getType", "setType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZILjava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RecentRecipientEntity {
    private String alias;
    private String cardIndexNo;
    private String dataId;
    private String id;
    private String imageUrl;
    private String instLocalName;
    private boolean isFavorite;
    private long lastUpdateTime;
    private long lastUpdated;
    private String name;
    private String number;
    private Integer participantCount;
    private String payMethod;
    private String payOption;
    private String prefix;
    private String recipientName;
    private String senderName;
    private int transactionCount;
    private int type;

    public RecentRecipientEntity() {
        this(null, null, null, null, null, 0L, 0L, null, null, null, null, null, null, null, null, 0, false, 0, null, 524287, null);
    }

    public RecentRecipientEntity(String str, String str2, String str3, String str4, String str5, long j, long j2, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i, boolean z, int i2, Integer num) {
        Intrinsics.checkNotNullParameter(str, "");
        this.dataId = str;
        this.alias = str2;
        this.id = str3;
        this.imageUrl = str4;
        this.instLocalName = str5;
        this.lastUpdated = j;
        this.lastUpdateTime = j2;
        this.name = str6;
        this.number = str7;
        this.recipientName = str8;
        this.senderName = str9;
        this.payMethod = str10;
        this.payOption = str11;
        this.cardIndexNo = str12;
        this.prefix = str13;
        this.transactionCount = i;
        this.isFavorite = z;
        this.type = i2;
        this.participantCount = num;
    }

    public /* synthetic */ RecentRecipientEntity(String str, String str2, String str3, String str4, String str5, long j, long j2, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i, boolean z, int i2, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : str5, (i3 & 32) != 0 ? 0L : j, (i3 & 64) == 0 ? j2 : 0L, (i3 & 128) != 0 ? null : str6, (i3 & 256) != 0 ? null : str7, (i3 & 512) != 0 ? null : str8, (i3 & 1024) != 0 ? null : str9, (i3 & 2048) != 0 ? null : str10, (i3 & 4096) != 0 ? null : str11, (i3 & 8192) != 0 ? null : str12, (i3 & 16384) != 0 ? null : str13, (i3 & 32768) != 0 ? 0 : i, (i3 & 65536) != 0 ? false : z, (i3 & AntDetector.SCENE_ID_LOGIN_REGIST) == 0 ? i2 : 0, (i3 & 262144) != 0 ? null : num);
    }

    @JvmName(name = "getDataId")
    public final String getDataId() {
        return this.dataId;
    }

    @JvmName(name = "setDataId")
    public final void setDataId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.dataId = str;
    }

    @JvmName(name = "getAlias")
    public final String getAlias() {
        return this.alias;
    }

    @JvmName(name = "setAlias")
    public final void setAlias(String str) {
        this.alias = str;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "setId")
    public final void setId(String str) {
        this.id = str;
    }

    @JvmName(name = "getImageUrl")
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @JvmName(name = "setImageUrl")
    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    @JvmName(name = "getInstLocalName")
    public final String getInstLocalName() {
        return this.instLocalName;
    }

    @JvmName(name = "setInstLocalName")
    public final void setInstLocalName(String str) {
        this.instLocalName = str;
    }

    @JvmName(name = "getLastUpdated")
    public final long getLastUpdated() {
        return this.lastUpdated;
    }

    @JvmName(name = "setLastUpdated")
    public final void setLastUpdated(long j) {
        this.lastUpdated = j;
    }

    @JvmName(name = "getLastUpdateTime")
    public final long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    @JvmName(name = "setLastUpdateTime")
    public final void setLastUpdateTime(long j) {
        this.lastUpdateTime = j;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "setName")
    public final void setName(String str) {
        this.name = str;
    }

    @JvmName(name = "getNumber")
    public final String getNumber() {
        return this.number;
    }

    @JvmName(name = "setNumber")
    public final void setNumber(String str) {
        this.number = str;
    }

    @JvmName(name = "getRecipientName")
    public final String getRecipientName() {
        return this.recipientName;
    }

    @JvmName(name = "setRecipientName")
    public final void setRecipientName(String str) {
        this.recipientName = str;
    }

    @JvmName(name = "getSenderName")
    public final String getSenderName() {
        return this.senderName;
    }

    @JvmName(name = "setSenderName")
    public final void setSenderName(String str) {
        this.senderName = str;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "setPayMethod")
    public final void setPayMethod(String str) {
        this.payMethod = str;
    }

    @JvmName(name = "getPayOption")
    public final String getPayOption() {
        return this.payOption;
    }

    @JvmName(name = "setPayOption")
    public final void setPayOption(String str) {
        this.payOption = str;
    }

    @JvmName(name = "getCardIndexNo")
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    @JvmName(name = "setCardIndexNo")
    public final void setCardIndexNo(String str) {
        this.cardIndexNo = str;
    }

    @JvmName(name = "getPrefix")
    public final String getPrefix() {
        return this.prefix;
    }

    @JvmName(name = "setPrefix")
    public final void setPrefix(String str) {
        this.prefix = str;
    }

    @JvmName(name = "getTransactionCount")
    public final int getTransactionCount() {
        return this.transactionCount;
    }

    @JvmName(name = "setTransactionCount")
    public final void setTransactionCount(int i) {
        this.transactionCount = i;
    }

    @JvmName(name = TrackerKey.SendMoneyProperties.IS_FAVORITE)
    /* renamed from: isFavorite  reason: from getter */
    public final boolean getIsFavorite() {
        return this.isFavorite;
    }

    @JvmName(name = "setFavorite")
    public final void setFavorite(boolean z) {
        this.isFavorite = z;
    }

    @JvmName(name = "getType")
    public final int getType() {
        return this.type;
    }

    @JvmName(name = "setType")
    public final void setType(int i) {
        this.type = i;
    }

    @JvmName(name = "getParticipantCount")
    public final Integer getParticipantCount() {
        return this.participantCount;
    }

    @JvmName(name = "setParticipantCount")
    public final void setParticipantCount(Integer num) {
        this.participantCount = num;
    }
}
