package id.dana.data.profilemenu.model;

import id.dana.domain.profilemenu.model.SettingModel;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class SettingEntity implements Serializable {
    public String action;
    public String collection;
    public boolean enable;
    public boolean hasReddot;
    public String iconUrl;
    public boolean nullObject;
    public int reddotInterval;
    public String redirectUrl;
    public String subtitle;
    public String subtitleColor;
    public String subtitleEn;
    public boolean subtitleIsBelow;
    public String subtitleType;
    public String title;
    public String titleEn;

    private SettingEntity(boolean z) {
        this.hasReddot = false;
        this.nullObject = z;
    }

    public static SettingEntity empty() {
        return new SettingEntity(true);
    }

    public SettingEntity() {
        this.nullObject = false;
        this.hasReddot = false;
    }

    public boolean isNullObject() {
        return this.nullObject;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public String getTitleEn() {
        return this.titleEn;
    }

    public void setTitleEn(String str) {
        this.titleEn = str;
    }

    public String getSubtitleEn() {
        return this.subtitleEn;
    }

    public void setSubtitleEn(String str) {
        this.subtitleEn = str;
    }

    public static SettingEntity from(SettingModel settingModel) {
        SettingEntity settingEntity = new SettingEntity();
        settingEntity.action = settingModel.getAction();
        settingEntity.enable = settingModel.isEnable();
        settingEntity.title = settingModel.getTitle();
        settingEntity.titleEn = settingModel.getTitleEn();
        settingEntity.collection = settingModel.getCollection();
        settingEntity.iconUrl = settingModel.getIconUrl();
        settingEntity.redirectUrl = settingModel.getRedirectUrl();
        settingEntity.subtitle = settingModel.getSubtitle();
        settingEntity.subtitleEn = settingModel.getSubtitleEn();
        settingEntity.subtitleIsBelow = settingModel.getSubtitleIsBelow().booleanValue();
        settingEntity.subtitleColor = settingModel.getSubtitleColor();
        settingEntity.subtitleType = settingModel.getSubtitleType();
        settingEntity.hasReddot = settingModel.isHasReddot();
        return settingEntity;
    }

    public boolean getSubtitleIsBelow() {
        return this.subtitleIsBelow;
    }

    public String getSubtitleType() {
        return this.subtitleType;
    }

    public void setSubtitleType(String str) {
        this.subtitleType = str;
    }

    public String getSubtitleColor() {
        return this.subtitleColor;
    }

    public void setSubtitleColor(String str) {
        this.subtitleColor = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public void setRedirectUrl(String str) {
        this.redirectUrl = str;
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

    public String getCollection() {
        return this.collection;
    }

    public void setCollection(String str) {
        this.collection = str;
    }

    public void setSubtitleIsBelow(Boolean bool) {
        this.subtitleIsBelow = bool.booleanValue();
    }

    public boolean hasReddot() {
        return this.hasReddot;
    }

    public void setHasReddot(boolean z) {
        this.hasReddot = z;
    }

    public int getReddotInterval() {
        return this.reddotInterval;
    }

    public void setReddotInterval(int i) {
        this.reddotInterval = i;
    }
}
