package id.dana.domain.profilemenu.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.domain.investment.model.UserInvestmentInfo;
import id.dana.domain.social.model.InitFeed;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class SettingModel implements Parcelable {
    public static final Parcelable.Creator<SettingModel> CREATOR = new Parcelable.Creator<SettingModel>() { // from class: id.dana.domain.profilemenu.model.SettingModel.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ SettingModel createFromParcel(Parcel parcel) {
            return new SettingModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SettingModel[] newArray(int i) {
            return new SettingModel[i];
        }
    };
    private String action;
    private String autoRouteAuthenticationType;
    private boolean autoRouteSwitch;
    private String avatarUrl;
    private String balance;
    private String collection;
    private String currency;
    private boolean enable;
    private String enrolmentState;
    private String expense;
    private boolean faceLoginEnabled;
    private boolean hasReddot;
    private String iconUrl;
    private String income;
    private InitFeed initFeedStatus;
    private boolean isFromFeeds;
    private boolean isShowNewBadge;
    private boolean isShowShimmer;
    private boolean isStartReferralLottie;
    private boolean kybRevoked;
    private boolean kycRevoked;
    private String name;
    private boolean needToShow;
    private boolean nullObject;
    private String parent;
    private int position;
    private int reddotInterval;
    private String redirectUrl;
    private int referralUserCount;
    private List<SettingModel> settingChilds;
    private boolean shareFeed;
    private String subtitle;
    private String subtitleColor;
    private String subtitleEn;
    private boolean subtitleIsBelow;
    private String subtitleType;
    private String title;
    private String titleEn;
    private UserInvestmentInfo userInvestmentInfo;
    private String username;
    private int viewType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private SettingModel(boolean z) {
        this.needToShow = true;
        this.income = "";
        this.expense = "";
        this.currency = "";
        this.username = "";
        this.parent = "";
        this.enrolmentState = "";
        this.isShowShimmer = true;
        this.isFromFeeds = false;
        this.isStartReferralLottie = true;
        this.isShowNewBadge = false;
        this.hasReddot = false;
        this.initFeedStatus = null;
        this.userInvestmentInfo = null;
        this.settingChilds = null;
        this.nullObject = z;
    }

    protected SettingModel(Parcel parcel) {
        this.nullObject = false;
        this.needToShow = true;
        this.income = "";
        this.expense = "";
        this.currency = "";
        this.username = "";
        this.parent = "";
        this.enrolmentState = "";
        this.isShowShimmer = true;
        this.isFromFeeds = false;
        this.isStartReferralLottie = true;
        this.isShowNewBadge = false;
        this.hasReddot = false;
        this.initFeedStatus = null;
        this.userInvestmentInfo = null;
        this.settingChilds = null;
        this.nullObject = parcel.readByte() != 0;
        this.title = parcel.readString();
        this.subtitle = parcel.readString();
        this.titleEn = parcel.readString();
        this.subtitleEn = parcel.readString();
        this.subtitleType = parcel.readString();
        this.subtitleIsBelow = parcel.readByte() != 0;
        this.subtitleColor = parcel.readString();
        this.iconUrl = parcel.readString();
        this.redirectUrl = parcel.readString();
        this.action = parcel.readString();
        this.enable = parcel.readByte() != 0;
        this.collection = parcel.readString();
        this.name = parcel.readString();
        this.balance = parcel.readString();
        this.viewType = parcel.readInt();
        this.kybRevoked = parcel.readByte() != 0;
        this.kycRevoked = parcel.readByte() != 0;
        this.avatarUrl = parcel.readString();
        this.needToShow = parcel.readByte() != 0;
        this.shareFeed = parcel.readByte() != 0;
        this.autoRouteSwitch = parcel.readByte() != 0;
        this.income = parcel.readString();
        this.expense = parcel.readString();
        this.currency = parcel.readString();
        this.username = parcel.readString();
        this.enrolmentState = parcel.readString();
        this.faceLoginEnabled = parcel.readByte() != 0;
        this.isFromFeeds = parcel.readByte() != 0;
        this.referralUserCount = parcel.readInt();
        this.isStartReferralLottie = parcel.readByte() != 0;
        this.isShowNewBadge = parcel.readByte() != 0;
        this.hasReddot = parcel.readByte() != 0;
        this.reddotInterval = parcel.readByte();
    }

    public SettingModel() {
        this.nullObject = false;
        this.needToShow = true;
        this.income = "";
        this.expense = "";
        this.currency = "";
        this.username = "";
        this.parent = "";
        this.enrolmentState = "";
        this.isShowShimmer = true;
        this.isFromFeeds = false;
        this.isStartReferralLottie = true;
        this.isShowNewBadge = false;
        this.hasReddot = false;
        this.initFeedStatus = null;
        this.userInvestmentInfo = null;
        this.settingChilds = null;
    }

    public static SettingModel empty() {
        return new SettingModel(true);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.nullObject ? (byte) 1 : (byte) 0);
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeString(this.titleEn);
        parcel.writeString(this.subtitleEn);
        parcel.writeString(this.subtitleType);
        parcel.writeByte(this.subtitleIsBelow ? (byte) 1 : (byte) 0);
        parcel.writeString(this.subtitleColor);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.redirectUrl);
        parcel.writeString(this.action);
        parcel.writeByte(this.enable ? (byte) 1 : (byte) 0);
        parcel.writeString(this.collection);
        parcel.writeString(this.name);
        parcel.writeString(this.balance);
        parcel.writeInt(this.viewType);
        parcel.writeByte(this.kybRevoked ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.kycRevoked ? (byte) 1 : (byte) 0);
        parcel.writeString(this.avatarUrl);
        parcel.writeByte(this.needToShow ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.shareFeed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.autoRouteSwitch ? (byte) 1 : (byte) 0);
        parcel.writeString(this.income);
        parcel.writeString(this.expense);
        parcel.writeString(this.currency);
        parcel.writeString(this.username);
        parcel.writeString(this.enrolmentState);
        parcel.writeByte(this.faceLoginEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isFromFeeds ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.referralUserCount);
        parcel.writeByte(this.isStartReferralLottie ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isShowNewBadge ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.hasReddot ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.reddotInterval);
    }

    public InitFeed getInitFeedStatus() {
        return this.initFeedStatus;
    }

    public void setInitFeedStatus(InitFeed initFeed) {
        this.initFeedStatus = initFeed;
    }

    public boolean isNullObject() {
        return this.nullObject;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public String getName() {
        String str = this.name;
        return str == null ? "" : str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getTitle() {
        String str = this.title;
        return str == null ? "" : str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getTitleEn() {
        String str = this.titleEn;
        return str == null ? "" : str;
    }

    public void setTitleEn(String str) {
        this.titleEn = str;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public void setRedirectUrl(String str) {
        this.redirectUrl = str;
    }

    public int getViewType() {
        return this.viewType;
    }

    public void setViewType(int i) {
        this.viewType = i;
    }

    public String getBalance() {
        return this.balance;
    }

    public void setBalance(String str) {
        this.balance = str;
    }

    public boolean isKybRevoked() {
        return this.kybRevoked;
    }

    public void setKybRevoked(boolean z) {
        this.kybRevoked = z;
    }

    public boolean isKycRevoked() {
        return this.kycRevoked;
    }

    public void setKycRevoked(boolean z) {
        this.kycRevoked = z;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public String getSubtitleEn() {
        return this.subtitleEn;
    }

    public void setSubtitleEn(String str) {
        this.subtitleEn = str;
    }

    public String getSubtitleType() {
        return this.subtitleType;
    }

    public void setSubtitleType(String str) {
        this.subtitleType = str;
    }

    public Boolean getSubtitleIsBelow() {
        return Boolean.valueOf(this.subtitleIsBelow);
    }

    public void setSubtitleIsBelow(boolean z) {
        this.subtitleIsBelow = z;
    }

    public String getSubtitleColor() {
        return this.subtitleColor;
    }

    public void setSubtitleColor(String str) {
        this.subtitleColor = str;
    }

    public String getIconUrl() {
        String str = this.iconUrl;
        return str == null ? "" : str;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String getCollection() {
        return this.collection;
    }

    public void setCollection(String str) {
        this.collection = str;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public boolean isShareFeed() {
        return this.shareFeed;
    }

    public SettingModel setShareFeed(boolean z) {
        this.shareFeed = z;
        return this;
    }

    public boolean isAutoRouteSwitch() {
        return this.autoRouteSwitch;
    }

    public void setAutoRouteSwitch(boolean z) {
        this.autoRouteSwitch = z;
    }

    public String getAutoRouteAuthenticationType() {
        return this.autoRouteAuthenticationType;
    }

    public void setAutoRouteAuthenticationType(String str) {
        this.autoRouteAuthenticationType = str;
    }

    public boolean isNeedToShow() {
        return this.needToShow;
    }

    public void setNeedToShow(boolean z) {
        this.needToShow = z;
    }

    public String getIncome() {
        return this.income;
    }

    public void setIncome(String str) {
        this.income = str;
    }

    public String getExpense() {
        return this.expense;
    }

    public void setExpense(String str) {
        this.expense = str;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public UserInvestmentInfo getUserInvestmentInfo() {
        return this.userInvestmentInfo;
    }

    public void setUserInvestmentInfo(UserInvestmentInfo userInvestmentInfo) {
        this.userInvestmentInfo = userInvestmentInfo;
    }

    public List<SettingModel> getSettingChilds() {
        List<SettingModel> list = this.settingChilds;
        return list == null ? new ArrayList(0) : list;
    }

    public void setSettingChilds(List<SettingModel> list) {
        this.settingChilds = list;
    }

    public String getParent() {
        return this.parent;
    }

    public void setParent(String str) {
        this.parent = str;
    }

    public String getEnrolmentState() {
        String str = this.enrolmentState;
        return str == null ? "" : str;
    }

    public void setEnrolmentState(String str) {
        this.enrolmentState = str;
    }

    public boolean isFaceLoginEnabled() {
        return this.faceLoginEnabled;
    }

    public void setFaceLoginEnabled(boolean z) {
        this.faceLoginEnabled = z;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public boolean isShowShimmer() {
        return this.isShowShimmer;
    }

    public void setShowShimmer(boolean z) {
        this.isShowShimmer = z;
    }

    public boolean isFromFeeds() {
        return this.isFromFeeds;
    }

    public void setFromFeeds(boolean z) {
        this.isFromFeeds = z;
    }

    public int getReferralUserCount() {
        return this.referralUserCount;
    }

    public void setReferralUserCount(int i) {
        this.referralUserCount = i;
    }

    public boolean isStartReferralLottie() {
        return this.isStartReferralLottie;
    }

    public void setStartReferralLottie(boolean z) {
        this.isStartReferralLottie = z;
    }

    public boolean isShowNewBadge() {
        return this.isShowNewBadge;
    }

    public void setShowNewBadge(boolean z) {
        this.isShowNewBadge = z;
    }

    public void setHasReddot(boolean z) {
        this.hasReddot = z;
    }

    public boolean isHasReddot() {
        return this.hasReddot;
    }

    public int getReddotInterval() {
        return this.reddotInterval;
    }

    public void setReddotInterval(int i) {
        this.reddotInterval = i;
    }
}
