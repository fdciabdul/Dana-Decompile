package com.zoloz.zcore.facade.common.Blob;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class FaceInfoPB extends Message {
    public static final Float DEFAULT_CONFIDENCE;
    public static final String DEFAULT_FEATURE = "";
    public static final String DEFAULT_FEAVERSION = "";
    public static final List<PointPB> DEFAULT_POINTS = Collections.emptyList();
    public static final Float DEFAULT_QUALITY;
    public static final int TAG_CONFIDENCE = 3;
    public static final int TAG_FEATURE = 5;
    public static final int TAG_FEAVERSION = 6;
    public static final int TAG_POINTS = 2;
    public static final int TAG_QUALITY = 4;
    public static final int TAG_RECT = 1;
    @ProtoField(tag = 3, type = Message.Datatype.FLOAT)
    public Float confidence;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public String feaVersion;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public String feature;
    @ProtoField(label = Message.Label.REPEATED, tag = 2)
    public List<PointPB> points;
    @ProtoField(tag = 4, type = Message.Datatype.FLOAT)
    public Float quality;
    @ProtoField(tag = 1)
    public RectPB rect;

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_CONFIDENCE = valueOf;
        DEFAULT_QUALITY = valueOf;
    }

    public FaceInfoPB(FaceInfoPB faceInfoPB) {
        super(faceInfoPB);
        if (faceInfoPB == null) {
            return;
        }
        this.rect = faceInfoPB.rect;
        this.points = copyOf(faceInfoPB.points);
        this.confidence = faceInfoPB.confidence;
        this.quality = faceInfoPB.quality;
        this.feature = faceInfoPB.feature;
        this.feaVersion = faceInfoPB.feaVersion;
    }

    public FaceInfoPB() {
    }

    public final FaceInfoPB fillTagValue(int i, Object obj) {
        switch (i) {
            case 1:
                this.rect = (RectPB) obj;
                break;
            case 2:
                this.points = immutableCopyOf((List) obj);
                break;
            case 3:
                this.confidence = (Float) obj;
                break;
            case 4:
                this.quality = (Float) obj;
                break;
            case 5:
                this.feature = (String) obj;
                break;
            case 6:
                this.feaVersion = (String) obj;
                break;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FaceInfoPB) {
            FaceInfoPB faceInfoPB = (FaceInfoPB) obj;
            return equals(this.rect, faceInfoPB.rect) && equals((List<?>) this.points, (List<?>) faceInfoPB.points) && equals(this.confidence, faceInfoPB.confidence) && equals(this.quality, faceInfoPB.quality) && equals(this.feature, faceInfoPB.feature) && equals(this.feaVersion, faceInfoPB.feaVersion);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            RectPB rectPB = this.rect;
            int hashCode = rectPB != null ? rectPB.hashCode() : 0;
            List<PointPB> list = this.points;
            int hashCode2 = list != null ? list.hashCode() : 1;
            Float f = this.confidence;
            int hashCode3 = f != null ? f.hashCode() : 0;
            Float f2 = this.quality;
            int hashCode4 = f2 != null ? f2.hashCode() : 0;
            String str = this.feature;
            int hashCode5 = str != null ? str.hashCode() : 0;
            String str2 = this.feaVersion;
            int hashCode6 = (((((((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + hashCode4) * 37) + hashCode5) * 37) + (str2 != null ? str2.hashCode() : 0);
            this.hashCode = hashCode6;
            return hashCode6;
        }
        return i;
    }
}
