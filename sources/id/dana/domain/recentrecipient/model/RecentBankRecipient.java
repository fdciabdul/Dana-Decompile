package id.dana.domain.recentrecipient.model;

/* loaded from: classes4.dex */
public class RecentBankRecipient extends RecentRecipient {
    public RecentBankRecipient(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i, Long l, boolean z) {
        this.alias = str5;
        this.f8181id = str6;
        this.imageUrl = str4;
        this.instLocalName = str7;
        this.name = str3;
        this.number = str2;
        this.recipientName = str;
        this.payMethod = str8;
        this.payOption = str9;
        this.senderName = str10;
        this.cardIndexNo = str11;
        this.formattedMaskNumber = str12;
        this.prefix = str13;
        this.transactionCount = i;
        this.lastUpdated = (l == null ? getCurrentTime() : l).longValue();
        setFavorite(z);
        this.type = 1;
    }
}
