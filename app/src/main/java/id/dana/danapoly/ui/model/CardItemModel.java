package id.dana.danapoly.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import com.alibaba.griver.core.GriverParams;
import id.dana.danapoly.ui.enums.RewardType;
import id.dana.danapoly.ui.model.play.LocalizationModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u0000 22\u00020\u0001:\u00012B\u0081\u0001\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0002\u0010,\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u0012\b\b\u0002\u0010.\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010*\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010(\u001a\u00020\u001c\u0012\b\b\u0002\u0010!\u001a\u00020\u001c\u0012\b\b\u0002\u0010&\u001a\u00020\u000b¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0007¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\u001a\u0010\u0018\u001a\u00020\u00178\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u001c8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001c8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 R\u001a\u0010#\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0004R\u001a\u0010&\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b'\u0010\u000fR\u001a\u0010(\u001a\u00020\u001c8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010 R\u001a\u0010*\u001a\u00020\u001c8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u001e\u001a\u0004\b+\u0010 R\u001a\u0010,\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\r\u001a\u0004\b-\u0010\u000fR\u001a\u0010.\u001a\u00020\u001c8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\u001e\u001a\u0004\b/\u0010 "}, d2 = {"Lid/dana/danapoly/ui/model/CardItemModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/danapoly/ui/model/play/LocalizationModel;", "actionTitle", "Lid/dana/danapoly/ui/model/play/LocalizationModel;", "getActionTitle", "()Lid/dana/danapoly/ui/model/play/LocalizationModel;", "Lid/dana/danapoly/ui/enums/RewardType;", "cardType", "Lid/dana/danapoly/ui/enums/RewardType;", "getCardType", "()Lid/dana/danapoly/ui/enums/RewardType;", "description", "getDescription", "", "expiredTime", "J", "getExpiredTime", "()J", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", GriverParams.ShareParams.IMAGE_URL, "getImageUrl", "itemType", "I", "getItemType", "name", "getName", "redirectLink", "getRedirectLink", "status", "getStatus", "title", "getTitle", "url", "getUrl", "<init>", "(Ljava/lang/String;Lid/dana/danapoly/ui/model/play/LocalizationModel;Lid/dana/danapoly/ui/model/play/LocalizationModel;Ljava/lang/String;Lid/dana/danapoly/ui/enums/RewardType;Ljava/lang/String;JILid/dana/danapoly/ui/model/play/LocalizationModel;Ljava/lang/String;Ljava/lang/String;Lid/dana/danapoly/ui/model/play/LocalizationModel;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardItemModel implements Parcelable {
    public static final int ITEM_CARD = 0;
    public static final int ITEM_PROMPT = 1;
    private final LocalizationModel actionTitle;
    private final RewardType cardType;
    private final LocalizationModel description;
    private final long expiredTime;
    private final String id;
    private final String imageUrl;
    private final int itemType;
    private final LocalizationModel name;
    private final String redirectLink;
    private final String status;
    private final LocalizationModel title;
    private final String url;
    public static final Parcelable.Creator<CardItemModel> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<CardItemModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CardItemModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new CardItemModel(parcel.readString(), LocalizationModel.CREATOR.createFromParcel(parcel), LocalizationModel.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() == 0 ? null : RewardType.valueOf(parcel.readString()), parcel.readString(), parcel.readLong(), parcel.readInt(), LocalizationModel.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), LocalizationModel.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CardItemModel[] newArray(int i) {
            return new CardItemModel[i];
        }
    }

    public CardItemModel() {
        this(null, null, null, null, null, null, 0L, 0, null, null, null, null, ARiverTrackWatchDogEventConstant.STARTUP_FLAG, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.id);
        this.title.writeToParcel(parcel, flags);
        this.description.writeToParcel(parcel, flags);
        parcel.writeString(this.url);
        RewardType rewardType = this.cardType;
        if (rewardType == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(rewardType.name());
        }
        parcel.writeString(this.status);
        parcel.writeLong(this.expiredTime);
        parcel.writeInt(this.itemType);
        this.actionTitle.writeToParcel(parcel, flags);
        parcel.writeString(this.redirectLink);
        parcel.writeString(this.imageUrl);
        this.name.writeToParcel(parcel, flags);
    }

    public CardItemModel(String str, LocalizationModel localizationModel, LocalizationModel localizationModel2, String str2, RewardType rewardType, String str3, long j, int i, LocalizationModel localizationModel3, String str4, String str5, LocalizationModel localizationModel4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(localizationModel, "");
        Intrinsics.checkNotNullParameter(localizationModel2, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(localizationModel3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(localizationModel4, "");
        this.id = str;
        this.title = localizationModel;
        this.description = localizationModel2;
        this.url = str2;
        this.cardType = rewardType;
        this.status = str3;
        this.expiredTime = j;
        this.itemType = i;
        this.actionTitle = localizationModel3;
        this.redirectLink = str4;
        this.imageUrl = str5;
        this.name = localizationModel4;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r5v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ CardItemModel(java.lang.String r17, id.dana.danapoly.ui.model.play.LocalizationModel r18, id.dana.danapoly.ui.model.play.LocalizationModel r19, java.lang.String r20, id.dana.danapoly.ui.enums.RewardType r21, java.lang.String r22, long r23, int r25, id.dana.danapoly.ui.model.play.LocalizationModel r26, java.lang.String r27, java.lang.String r28, id.dana.danapoly.ui.model.play.LocalizationModel r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r16 = this;
            r0 = r30
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto La
            r1 = r2
            goto Lc
        La:
            r1 = r17
        Lc:
            r3 = r0 & 2
            r4 = 3
            r5 = 0
            if (r3 == 0) goto L18
            id.dana.danapoly.ui.model.play.LocalizationModel r3 = new id.dana.danapoly.ui.model.play.LocalizationModel
            r3.<init>(r5, r5, r4, r5)
            goto L1a
        L18:
            r3 = r18
        L1a:
            r6 = r0 & 4
            if (r6 == 0) goto L24
            id.dana.danapoly.ui.model.play.LocalizationModel r6 = new id.dana.danapoly.ui.model.play.LocalizationModel
            r6.<init>(r5, r5, r4, r5)
            goto L26
        L24:
            r6 = r19
        L26:
            r7 = r0 & 8
            if (r7 == 0) goto L2c
            r7 = r2
            goto L2e
        L2c:
            r7 = r20
        L2e:
            r8 = r0 & 16
            if (r8 == 0) goto L34
            r8 = r5
            goto L36
        L34:
            r8 = r21
        L36:
            r9 = r0 & 32
            if (r9 == 0) goto L3c
            r9 = r2
            goto L3e
        L3c:
            r9 = r22
        L3e:
            r10 = r0 & 64
            if (r10 == 0) goto L45
            r10 = 0
            goto L47
        L45:
            r10 = r23
        L47:
            r12 = r0 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L4d
            r12 = 0
            goto L4f
        L4d:
            r12 = r25
        L4f:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L59
            id.dana.danapoly.ui.model.play.LocalizationModel r13 = new id.dana.danapoly.ui.model.play.LocalizationModel
            r13.<init>(r5, r5, r4, r5)
            goto L5b
        L59:
            r13 = r26
        L5b:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L61
            r14 = r2
            goto L63
        L61:
            r14 = r27
        L63:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L68
            goto L6a
        L68:
            r2 = r28
        L6a:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L74
            id.dana.danapoly.ui.model.play.LocalizationModel r0 = new id.dana.danapoly.ui.model.play.LocalizationModel
            r0.<init>(r5, r5, r4, r5)
            goto L76
        L74:
            r0 = r29
        L76:
            r17 = r16
            r18 = r1
            r19 = r3
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r26 = r12
            r27 = r13
            r28 = r14
            r29 = r2
            r30 = r0
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.ui.model.CardItemModel.<init>(java.lang.String, id.dana.danapoly.ui.model.play.LocalizationModel, id.dana.danapoly.ui.model.play.LocalizationModel, java.lang.String, id.dana.danapoly.ui.enums.RewardType, java.lang.String, long, int, id.dana.danapoly.ui.model.play.LocalizationModel, java.lang.String, java.lang.String, id.dana.danapoly.ui.model.play.LocalizationModel, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getTitle")
    public final LocalizationModel getTitle() {
        return this.title;
    }

    @JvmName(name = "getDescription")
    public final LocalizationModel getDescription() {
        return this.description;
    }

    @JvmName(name = "getUrl")
    public final String getUrl() {
        return this.url;
    }

    @JvmName(name = "getCardType")
    public final RewardType getCardType() {
        return this.cardType;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getExpiredTime")
    public final long getExpiredTime() {
        return this.expiredTime;
    }

    @JvmName(name = "getItemType")
    public final int getItemType() {
        return this.itemType;
    }

    @JvmName(name = "getActionTitle")
    public final LocalizationModel getActionTitle() {
        return this.actionTitle;
    }

    @JvmName(name = "getRedirectLink")
    public final String getRedirectLink() {
        return this.redirectLink;
    }

    @JvmName(name = "getImageUrl")
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @JvmName(name = "getName")
    public final LocalizationModel getName() {
        return this.name;
    }
}
