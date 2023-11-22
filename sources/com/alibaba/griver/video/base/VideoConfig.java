package com.alibaba.griver.video.base;

import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes6.dex */
public class VideoConfig implements Serializable, Cloneable {
    public static int EFFECT_DEFAULT = 0;
    public static int EFFECT_TRANSPARENT = 1;
    public String resourceId;
    public boolean isBackgroundBlur = false;
    public Map<String, String> extraMap = new HashMap();
    public boolean isOffScreen = false;
    public int switchUrlAlignType = -1;
    public String videoId = "";
    public int videoEffect = EFFECT_DEFAULT;
    public String businessId = "";
    public String appId = "";
    public String appVersion = "";
    public int videoWidth = 0;
    public int videoHeight = 0;
    public boolean keepScreenOn = true;
    public boolean isLooping = false;
    public boolean autoPlayWhenPrepared = true;
    public boolean autoFitCenter = true;
    public boolean needThumbnail = true;
    public boolean needCenterCrop = false;
    public int alignDirection = 0;
    public String thumbUrl = "";
    public long startPlayPos = 0;
    public boolean selfLooping = false;
    public long loopingStartPos = 0;
    public long loopingStopPos = LongCompanionObject.MAX_VALUE;
    public int videoRotation = 0;
    public long videoDuration = 0;
    public boolean isMuteWhenPlaying = false;
    public JSONObject extraInfo = null;
    public String youkuCCode = "01010112";
    public String playMode = "vod";
    public float minCacheTime = -1.0f;
    public float maxCacheTime = -1.0f;
    public int playOrientation = 1;
    public int loopCount = Integer.MAX_VALUE;
    public boolean forceOpenLocalStorage = false;
    public boolean needContentSecurity = true;
    public boolean isTransparentVideo = false;
    public boolean isBackgroundTransparent = false;
    public boolean enableAudioExclusive = true;
    public boolean disableInteractions = false;

    public void addExtra(String str, String str2) {
        this.extraMap.put(str, str2);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VideoConfig videoConfig = (VideoConfig) obj;
        if (this.videoEffect == videoConfig.videoEffect && this.videoWidth == videoConfig.videoWidth && this.videoHeight == videoConfig.videoHeight && this.keepScreenOn == videoConfig.keepScreenOn && this.autoPlayWhenPrepared == videoConfig.autoPlayWhenPrepared && this.autoFitCenter == videoConfig.autoFitCenter && this.needThumbnail == videoConfig.needThumbnail && this.needCenterCrop == videoConfig.needCenterCrop && this.startPlayPos == videoConfig.startPlayPos && this.isLooping == videoConfig.isLooping && this.selfLooping == videoConfig.selfLooping && this.loopingStartPos == videoConfig.loopingStartPos && this.loopingStopPos == videoConfig.loopingStopPos && this.videoRotation == videoConfig.videoRotation && this.videoDuration == videoConfig.videoDuration && this.isMuteWhenPlaying == videoConfig.isMuteWhenPlaying && Float.compare(videoConfig.minCacheTime, this.minCacheTime) == 0 && Float.compare(videoConfig.maxCacheTime, this.maxCacheTime) == 0 && this.playOrientation == videoConfig.playOrientation && this.videoId.equals(videoConfig.videoId) && this.businessId.equals(videoConfig.businessId) && this.appId.equals(videoConfig.appId) && this.appVersion.equals(videoConfig.appVersion) && this.thumbUrl.equals(videoConfig.thumbUrl)) {
            JSONObject jSONObject = this.extraInfo;
            if ((jSONObject == null || jSONObject.equals(videoConfig.extraInfo)) && this.youkuCCode.equals(videoConfig.youkuCCode) && this.disableInteractions == videoConfig.disableInteractions) {
                return this.playMode.equals(videoConfig.playMode);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.videoId.hashCode();
        int i = this.videoEffect;
        int hashCode2 = this.businessId.hashCode();
        int hashCode3 = this.appId.hashCode();
        int hashCode4 = this.appVersion.hashCode();
        int i2 = this.videoWidth;
        int i3 = this.videoHeight;
        boolean z = this.keepScreenOn;
        boolean z2 = this.autoPlayWhenPrepared;
        boolean z3 = this.autoFitCenter;
        boolean z4 = this.needThumbnail;
        boolean z5 = this.needCenterCrop;
        int hashCode5 = this.thumbUrl.hashCode();
        long j = this.startPlayPos;
        int i4 = (int) (j ^ (j >>> 32));
        boolean z6 = this.isLooping;
        boolean z7 = this.selfLooping;
        long j2 = this.loopingStartPos;
        int i5 = (int) (j2 ^ (j2 >>> 32));
        long j3 = this.loopingStopPos;
        int i6 = (int) (j3 ^ (j3 >>> 32));
        int i7 = this.videoRotation;
        long j4 = this.videoDuration;
        int i8 = (int) (j4 ^ (j4 >>> 32));
        boolean z8 = this.isMuteWhenPlaying;
        int hashCode6 = this.extraInfo.hashCode();
        int hashCode7 = this.youkuCCode.hashCode();
        int hashCode8 = this.playMode.hashCode();
        float f = this.minCacheTime;
        int floatToIntBits = f != 0.0f ? Float.floatToIntBits(f) : 0;
        float f2 = this.maxCacheTime;
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + i) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i2) * 31) + i3) * 31) + (z ? 1 : 0)) * 31) + (z2 ? 1 : 0)) * 31) + (z3 ? 1 : 0)) * 31) + (z4 ? 1 : 0)) * 31) + (z5 ? 1 : 0)) * 31) + hashCode5) * 31) + i4) * 31) + (z6 ? 1 : 0)) * 31) + (z7 ? 1 : 0)) * 31) + i5) * 31) + i6) * 31) + i7) * 31) + i8) * 31) + (z8 ? 1 : 0)) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + floatToIntBits) * 31) + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31) + this.playOrientation) * 31) + (this.disableInteractions ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VideoConfig{videoId='");
        sb.append(this.videoId);
        sb.append('\'');
        sb.append(", videoEffect=");
        sb.append(this.videoEffect);
        sb.append(", businessId='");
        sb.append(this.businessId);
        sb.append('\'');
        sb.append(", appId='");
        sb.append(this.appId);
        sb.append('\'');
        sb.append(", appVersion='");
        sb.append(this.appVersion);
        sb.append('\'');
        sb.append(", videoWidth=");
        sb.append(this.videoWidth);
        sb.append(", videoHeight=");
        sb.append(this.videoHeight);
        sb.append(", keepScreenOn=");
        sb.append(this.keepScreenOn);
        sb.append(", autoPlayWhenPrepared=");
        sb.append(this.autoPlayWhenPrepared);
        sb.append(", autoFitCenter=");
        sb.append(this.autoFitCenter);
        sb.append(", needThumbnail=");
        sb.append(this.needThumbnail);
        sb.append(", needCenterCrop=");
        sb.append(this.needCenterCrop);
        sb.append(", thumbUrl='");
        sb.append(this.thumbUrl);
        sb.append('\'');
        sb.append(", startPlayPos=");
        sb.append(this.startPlayPos);
        sb.append(", isLooping=");
        sb.append(this.isLooping);
        sb.append(", loopCount=");
        sb.append(this.loopCount);
        sb.append(", forceOpenLocalStorage=");
        sb.append(this.forceOpenLocalStorage);
        sb.append(", selfLooping=");
        sb.append(this.selfLooping);
        sb.append(", loopingStartPos=");
        sb.append(this.loopingStartPos);
        sb.append(", loopingStopPos=");
        sb.append(this.loopingStopPos);
        sb.append(", videoRotation=");
        sb.append(this.videoRotation);
        sb.append(", videoDuration=");
        sb.append(this.videoDuration);
        sb.append(", isMuteWhenPlaying=");
        sb.append(this.isMuteWhenPlaying);
        sb.append(", extraInfo=");
        sb.append(this.extraInfo);
        sb.append(", youkuCCode='");
        sb.append(this.youkuCCode);
        sb.append('\'');
        sb.append(", playMode='");
        sb.append(this.playMode);
        sb.append('\'');
        sb.append(", minCacheTime=");
        sb.append(this.minCacheTime);
        sb.append(", maxCacheTime=");
        sb.append(this.maxCacheTime);
        sb.append(", playOrientation=");
        sb.append(this.playOrientation);
        sb.append(", needContentSecurity=");
        sb.append(this.needContentSecurity);
        sb.append(", isTransparentVideo=");
        sb.append(this.isTransparentVideo);
        sb.append(", isBackgroundTransparent=");
        sb.append(this.isBackgroundTransparent);
        sb.append(", enableAudioExclusive=");
        sb.append(this.enableAudioExclusive);
        sb.append(", disableInteractions=");
        sb.append(this.disableInteractions);
        sb.append(", extraMap=");
        sb.append(this.extraMap);
        sb.append('}');
        return sb.toString();
    }
}
