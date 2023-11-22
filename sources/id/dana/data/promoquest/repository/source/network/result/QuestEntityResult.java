package id.dana.data.promoquest.repository.source.network.result;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eR%\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010"}, d2 = {"Lid/dana/data/promoquest/repository/source/network/result/QuestEntityResult;", "", "", "", "extendInfo", "Ljava/util/Map;", "getExtendInfo", "()Ljava/util/Map;", "", "hasPrize", "Z", "getHasPrize", "()Z", "questActionType", "Ljava/lang/String;", "getQuestActionType", "()Ljava/lang/String;", "questDescription", "getQuestDescription", "questId", "getQuestId", "questName", "getQuestName", "questRedirectType", "getQuestRedirectType", "questRedirectValue", "getQuestRedirectValue", "questStatus", "getQuestStatus", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QuestEntityResult {
    private final Map<String, String> extendInfo;
    private final boolean hasPrize;
    private final String questActionType;
    private final String questDescription;
    private final String questId;
    private final String questName;
    private final String questRedirectType;
    private final String questRedirectValue;
    private final String questStatus;

    public QuestEntityResult() {
        this(false, null, null, null, null, null, null, null, null, 511, null);
    }

    public QuestEntityResult(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, Map<String, String> map) {
        this.hasPrize = z;
        this.questActionType = str;
        this.questDescription = str2;
        this.questId = str3;
        this.questName = str4;
        this.questRedirectType = str5;
        this.questRedirectValue = str6;
        this.questStatus = str7;
        this.extendInfo = map;
    }

    public /* synthetic */ QuestEntityResult(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) == 0 ? map : null);
    }

    @JvmName(name = "getHasPrize")
    public final boolean getHasPrize() {
        return this.hasPrize;
    }

    @JvmName(name = "getQuestActionType")
    public final String getQuestActionType() {
        return this.questActionType;
    }

    @JvmName(name = "getQuestDescription")
    public final String getQuestDescription() {
        return this.questDescription;
    }

    @JvmName(name = "getQuestId")
    public final String getQuestId() {
        return this.questId;
    }

    @JvmName(name = "getQuestName")
    public final String getQuestName() {
        return this.questName;
    }

    @JvmName(name = "getQuestRedirectType")
    public final String getQuestRedirectType() {
        return this.questRedirectType;
    }

    @JvmName(name = "getQuestRedirectValue")
    public final String getQuestRedirectValue() {
        return this.questRedirectValue;
    }

    @JvmName(name = "getQuestStatus")
    public final String getQuestStatus() {
        return this.questStatus;
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }
}
