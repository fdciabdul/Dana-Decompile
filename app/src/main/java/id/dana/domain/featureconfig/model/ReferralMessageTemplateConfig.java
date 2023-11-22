package id.dana.domain.featureconfig.model;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u001b\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0006\u001a\u00020\u00022\b\b\u0003\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0013J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\"\u0010\u0007\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u001aR\"\u0010\u0006\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u001a"}, d2 = {"Lid/dana/domain/featureconfig/model/ReferralMessageTemplateConfig;", "", "", "component1", "()Ljava/lang/String;", "component2", "messageIndonesia", "messageEnglish", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/featureconfig/model/ReferralMessageTemplateConfig;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "referralCode", "insertReferralCode", "(Ljava/lang/String;)Lid/dana/domain/featureconfig/model/ReferralMessageTemplateConfig;", "referralLink", "insertReferralLink", "toString", "Ljava/lang/String;", "getMessageEnglish", "setMessageEnglish", "(Ljava/lang/String;)V", "getMessageIndonesia", "setMessageIndonesia", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ReferralMessageTemplateConfig {
    private static final String REFERRAL_CODE_KEY = "%referral_code%";
    private static final String REFERRAL_LINK_KEY = "%referral_link%";
    private String messageEnglish;
    private String messageIndonesia;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ReferralMessageTemplateConfig() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.featureconfig.model.ReferralMessageTemplateConfig.<init>():void");
    }

    public static /* synthetic */ ReferralMessageTemplateConfig copy$default(ReferralMessageTemplateConfig referralMessageTemplateConfig, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = referralMessageTemplateConfig.messageIndonesia;
        }
        if ((i & 2) != 0) {
            str2 = referralMessageTemplateConfig.messageEnglish;
        }
        return referralMessageTemplateConfig.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMessageIndonesia() {
        return this.messageIndonesia;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMessageEnglish() {
        return this.messageEnglish;
    }

    public final ReferralMessageTemplateConfig copy(@JSONField(name = "message_id") String messageIndonesia, @JSONField(name = "message_en") String messageEnglish) {
        Intrinsics.checkNotNullParameter(messageIndonesia, "");
        Intrinsics.checkNotNullParameter(messageEnglish, "");
        return new ReferralMessageTemplateConfig(messageIndonesia, messageEnglish);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ReferralMessageTemplateConfig) {
            ReferralMessageTemplateConfig referralMessageTemplateConfig = (ReferralMessageTemplateConfig) other;
            return Intrinsics.areEqual(this.messageIndonesia, referralMessageTemplateConfig.messageIndonesia) && Intrinsics.areEqual(this.messageEnglish, referralMessageTemplateConfig.messageEnglish);
        }
        return false;
    }

    public final int hashCode() {
        return (this.messageIndonesia.hashCode() * 31) + this.messageEnglish.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ReferralMessageTemplateConfig(messageIndonesia=");
        sb.append(this.messageIndonesia);
        sb.append(", messageEnglish=");
        sb.append(this.messageEnglish);
        sb.append(')');
        return sb.toString();
    }

    public ReferralMessageTemplateConfig(@JSONField(name = "message_id") String str, @JSONField(name = "message_en") String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.messageIndonesia = str;
        this.messageEnglish = str2;
    }

    public /* synthetic */ ReferralMessageTemplateConfig(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    @JvmName(name = "getMessageIndonesia")
    public final String getMessageIndonesia() {
        return this.messageIndonesia;
    }

    @JvmName(name = "setMessageIndonesia")
    public final void setMessageIndonesia(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.messageIndonesia = str;
    }

    @JvmName(name = "getMessageEnglish")
    public final String getMessageEnglish() {
        return this.messageEnglish;
    }

    @JvmName(name = "setMessageEnglish")
    public final void setMessageEnglish(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.messageEnglish = str;
    }

    public final ReferralMessageTemplateConfig insertReferralCode(String referralCode) {
        Intrinsics.checkNotNullParameter(referralCode, "");
        this.messageIndonesia = StringsKt.replace$default(this.messageIndonesia, REFERRAL_CODE_KEY, referralCode, false, 4, (Object) null);
        this.messageEnglish = StringsKt.replace$default(this.messageEnglish, REFERRAL_CODE_KEY, referralCode, false, 4, (Object) null);
        return this;
    }

    public final ReferralMessageTemplateConfig insertReferralLink(String referralLink) {
        Intrinsics.checkNotNullParameter(referralLink, "");
        this.messageIndonesia = StringsKt.replace$default(this.messageIndonesia, REFERRAL_LINK_KEY, referralLink, false, 4, (Object) null);
        this.messageEnglish = StringsKt.replace$default(this.messageEnglish, REFERRAL_LINK_KEY, referralLink, false, 4, (Object) null);
        return this;
    }
}
