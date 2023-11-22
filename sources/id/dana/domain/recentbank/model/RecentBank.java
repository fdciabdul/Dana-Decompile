package id.dana.domain.recentbank.model;

/* loaded from: classes4.dex */
public class RecentBank {
    private String alias;
    private String bankLogo;
    private String bankName;
    private String bankNumber;
    private String cardIndexNo;
    private String instId;
    private String instLocalName;
    private boolean isFavorite;
    private long lastUpdated;
    private String payMethod;
    private String payOption;
    private String prefix;
    private String recipientName;
    private String senderName;
    private int transactionCount;

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public long getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(long j) {
        this.lastUpdated = j;
    }

    public String getBankLogo() {
        return this.bankLogo;
    }

    public void setBankLogo(String str) {
        this.bankLogo = str;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public String getBankNumber() {
        return this.bankNumber;
    }

    public void setBankNumber(String str) {
        this.bankNumber = str;
    }

    public String getRecipientName() {
        return this.recipientName;
    }

    public void setRecipientName(String str) {
        this.recipientName = str;
    }

    public String getInstId() {
        return this.instId;
    }

    public void setInstId(String str) {
        this.instId = str;
    }

    public String getInstLocalName() {
        return this.instLocalName;
    }

    public void setInstLocalName(String str) {
        this.instLocalName = str;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public String getPayOption() {
        return this.payOption;
    }

    public void setPayOption(String str) {
        this.payOption = str;
    }

    public String getSenderName() {
        return this.senderName;
    }

    public void setSenderName(String str) {
        this.senderName = str;
    }

    public String getCardIndexNo() {
        return this.cardIndexNo;
    }

    public void setCardIndexNo(String str) {
        this.cardIndexNo = str;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public int getTransactionCount() {
        return this.transactionCount;
    }

    public void setTransactionCount(int i) {
        this.transactionCount = i;
    }

    public boolean isFavorite() {
        return this.isFavorite;
    }

    public void setFavorite(boolean z) {
        this.isFavorite = z;
    }
}
