package com.alibaba.griver.image.photo.meta;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes6.dex */
public class PhotoItem extends PhotoInfo {
    public static final Parcelable.Creator<PhotoItem> CREATOR = new Parcelable.Creator<PhotoItem>() { // from class: com.alibaba.griver.image.photo.meta.PhotoItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoItem createFromParcel(Parcel parcel) {
            return new PhotoItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoItem[] newArray(int i) {
            return new PhotoItem[i];
        }
    };
    public static final int TYPE_PHOTO_GIF = 10;

    /* renamed from: a  reason: collision with root package name */
    private boolean f6614a;
    public boolean isDisabledByIntercept;
    public boolean isLoadedOnce;
    public String modifyTimeDesc;
    public boolean takePhoto;

    @Override // com.alibaba.griver.image.photo.meta.PhotoInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PhotoItem() {
        this(null, false, "", "");
    }

    public PhotoItem(String str) {
        this(str, false, "", "");
    }

    public PhotoItem(String str, boolean z) {
        this(str, z, "", "");
    }

    public PhotoItem(String str, boolean z, String str2, String str3) {
        super(str);
        setSelected(z);
        setLeftText(str2);
        setRightText(str3);
        this.f6614a = true;
        this.takePhoto = false;
    }

    public PhotoItem(Parcel parcel) {
        super(parcel);
        this.f6614a = parcel.readInt() > 0;
        this.takePhoto = parcel.readInt() > 0;
    }

    public PhotoItem(PhotoInfo photoInfo) {
        super(photoInfo);
    }

    @Override // com.alibaba.griver.image.photo.meta.PhotoInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f6614a ? 1 : 0);
        parcel.writeInt(this.takePhoto ? 1 : 0);
    }
}
