package id.dana.domain.recentrecipient.model;

import java.util.Date;
import javax.annotation.Nullable;

/* loaded from: classes4.dex */
public class RecentRecipient {
    protected String alias;
    protected String cardIndexNo;
    protected String formattedMaskNumber;

    /* renamed from: id  reason: collision with root package name */
    protected String f8181id;
    protected String imageUrl;
    protected String instLocalName;
    private boolean isFavorite;
    protected long lastUpdated;
    protected String name;
    protected String number;
    @Nullable
    private Integer participantCount;
    protected String payMethod;
    protected String payOption;
    protected String prefix;
    protected String recipientName;
    protected String senderName;
    protected int transactionCount;
    protected int type;

    /* JADX INFO: Access modifiers changed from: protected */
    public Long getCurrentTime() {
        return Long.valueOf(new Date().getTime());
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public String getId() {
        return this.f8181id;
    }

    public void setId(String str) {
        this.f8181id = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getInstLocalName() {
        return this.instLocalName;
    }

    public void setInstLocalName(String str) {
        this.instLocalName = str;
    }

    public long getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(long j) {
        this.lastUpdated = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public String getRecipientName() {
        return this.recipientName;
    }

    public void setRecipientName(String str) {
        this.recipientName = str;
    }

    public String getSenderName() {
        return this.senderName;
    }

    public void setSenderName(String str) {
        this.senderName = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
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

    public String getCardIndexNo() {
        return this.cardIndexNo;
    }

    public void setCardIndexNo(String str) {
        this.cardIndexNo = str;
    }

    public String getFormattedMaskNumber() {
        return this.formattedMaskNumber;
    }

    public void setFormattedMaskNumber(String str) {
        this.formattedMaskNumber = str;
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

    @Nullable
    public Integer getParticipantCount() {
        return this.participantCount;
    }

    public void setParticipantCount(@Nullable Integer num) {
        this.participantCount = num;
    }
}
