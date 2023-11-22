package id.dana.domain.recentrecipient.model;

/* loaded from: classes4.dex */
public class RecentContactRecipient extends RecentRecipient {
    public RecentContactRecipient(String str, String str2, String str3, String str4, int i, boolean z) {
        this.alias = str3;
        this.f8181id = str;
        this.imageUrl = str4;
        this.recipientName = str3;
        this.name = str3;
        this.number = str2;
        this.type = 0;
        this.lastUpdated = getCurrentTime().longValue();
        setTransactionCount(i);
        setFavorite(z);
    }
}
