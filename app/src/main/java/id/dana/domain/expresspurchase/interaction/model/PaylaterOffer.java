package id.dana.domain.expresspurchase.interaction.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001fB)\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0016\u0010\nR\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0007¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0018\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/PaylaterOffer;", "", "", "component1", "()Z", "Lid/dana/domain/expresspurchase/interaction/model/PaylaterOffer$Partner;", "component2", "()Lid/dana/domain/expresspurchase/interaction/model/PaylaterOffer$Partner;", "", "component3", "()Ljava/lang/String;", "hasOffer", "partner", "cdpContent", "copy", "(ZLid/dana/domain/expresspurchase/interaction/model/PaylaterOffer$Partner;Ljava/lang/String;)Lid/dana/domain/expresspurchase/interaction/model/PaylaterOffer;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCdpContent", "Z", "getHasOffer", "Lid/dana/domain/expresspurchase/interaction/model/PaylaterOffer$Partner;", "getPartner", "<init>", "(ZLid/dana/domain/expresspurchase/interaction/model/PaylaterOffer$Partner;Ljava/lang/String;)V", "Partner"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PaylaterOffer {
    private final String cdpContent;
    private final boolean hasOffer;
    private final Partner partner;

    public PaylaterOffer() {
        this(false, null, null, 7, null);
    }

    public static /* synthetic */ PaylaterOffer copy$default(PaylaterOffer paylaterOffer, boolean z, Partner partner, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = paylaterOffer.hasOffer;
        }
        if ((i & 2) != 0) {
            partner = paylaterOffer.partner;
        }
        if ((i & 4) != 0) {
            str = paylaterOffer.cdpContent;
        }
        return paylaterOffer.copy(z, partner, str);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getHasOffer() {
        return this.hasOffer;
    }

    /* renamed from: component2  reason: from getter */
    public final Partner getPartner() {
        return this.partner;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCdpContent() {
        return this.cdpContent;
    }

    public final PaylaterOffer copy(boolean hasOffer, Partner partner, String cdpContent) {
        return new PaylaterOffer(hasOffer, partner, cdpContent);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PaylaterOffer) {
            PaylaterOffer paylaterOffer = (PaylaterOffer) other;
            return this.hasOffer == paylaterOffer.hasOffer && Intrinsics.areEqual(this.partner, paylaterOffer.partner) && Intrinsics.areEqual(this.cdpContent, paylaterOffer.cdpContent);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z = this.hasOffer;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        Partner partner = this.partner;
        int hashCode = partner == null ? 0 : partner.hashCode();
        String str = this.cdpContent;
        return (((r0 * 31) + hashCode) * 31) + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaylaterOffer(hasOffer=");
        sb.append(this.hasOffer);
        sb.append(", partner=");
        sb.append(this.partner);
        sb.append(", cdpContent=");
        sb.append(this.cdpContent);
        sb.append(')');
        return sb.toString();
    }

    public PaylaterOffer(boolean z, Partner partner, String str) {
        this.hasOffer = z;
        this.partner = partner;
        this.cdpContent = str;
    }

    public /* synthetic */ PaylaterOffer(boolean z, Partner partner, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : partner, (i & 4) != 0 ? null : str);
    }

    @JvmName(name = "getHasOffer")
    public final boolean getHasOffer() {
        return this.hasOffer;
    }

    @JvmName(name = "getPartner")
    public final Partner getPartner() {
        return this.partner;
    }

    @JvmName(name = "getCdpContent")
    public final String getCdpContent() {
        return this.cdpContent;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0018\u0010\u0007"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/PaylaterOffer$Partner;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "id", "redirectedUrl", "tnc", "copy", "(ILjava/lang/String;Ljava/lang/String;)Lid/dana/domain/expresspurchase/interaction/model/PaylaterOffer$Partner;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "I", "getId", "Ljava/lang/String;", "getRedirectedUrl", "getTnc", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Partner {
        private final int id;
        private final String redirectedUrl;
        private final String tnc;

        public static /* synthetic */ Partner copy$default(Partner partner, int i, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = partner.id;
            }
            if ((i2 & 2) != 0) {
                str = partner.redirectedUrl;
            }
            if ((i2 & 4) != 0) {
                str2 = partner.tnc;
            }
            return partner.copy(i, str, str2);
        }

        /* renamed from: component1  reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* renamed from: component2  reason: from getter */
        public final String getRedirectedUrl() {
            return this.redirectedUrl;
        }

        /* renamed from: component3  reason: from getter */
        public final String getTnc() {
            return this.tnc;
        }

        public final Partner copy(int id2, String redirectedUrl, String tnc) {
            Intrinsics.checkNotNullParameter(redirectedUrl, "");
            Intrinsics.checkNotNullParameter(tnc, "");
            return new Partner(id2, redirectedUrl, tnc);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Partner) {
                Partner partner = (Partner) other;
                return this.id == partner.id && Intrinsics.areEqual(this.redirectedUrl, partner.redirectedUrl) && Intrinsics.areEqual(this.tnc, partner.tnc);
            }
            return false;
        }

        public final int hashCode() {
            return (((this.id * 31) + this.redirectedUrl.hashCode()) * 31) + this.tnc.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Partner(id=");
            sb.append(this.id);
            sb.append(", redirectedUrl=");
            sb.append(this.redirectedUrl);
            sb.append(", tnc=");
            sb.append(this.tnc);
            sb.append(')');
            return sb.toString();
        }

        public Partner(int i, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.id = i;
            this.redirectedUrl = str;
            this.tnc = str2;
        }

        @JvmName(name = "getId")
        public final int getId() {
            return this.id;
        }

        @JvmName(name = "getRedirectedUrl")
        public final String getRedirectedUrl() {
            return this.redirectedUrl;
        }

        @JvmName(name = "getTnc")
        public final String getTnc() {
            return this.tnc;
        }
    }
}
