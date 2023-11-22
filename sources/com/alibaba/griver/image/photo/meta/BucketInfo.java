package com.alibaba.griver.image.photo.meta;

/* loaded from: classes6.dex */
public class BucketInfo {

    /* renamed from: a  reason: collision with root package name */
    private String f6606a;
    public boolean allPhoto;
    private PhotoInfo b;
    private int c;
    private boolean d;

    public BucketInfo(String str, int i, PhotoInfo photoInfo) {
        this(str, i, photoInfo, false);
    }

    public BucketInfo(String str, int i, PhotoInfo photoInfo, boolean z) {
        this.f6606a = str;
        this.c = i;
        this.b = photoInfo;
        this.d = z;
    }

    public String getName() {
        return this.f6606a;
    }

    public void setName(String str) {
        this.f6606a = str;
    }

    public int getCount() {
        return this.c;
    }

    public void setCount(int i) {
        this.c = i;
    }

    public PhotoInfo getPhoto() {
        return this.b;
    }

    public void setPhoto(PhotoInfo photoInfo) {
        this.b = photoInfo;
    }

    public boolean isSelected() {
        return this.d;
    }

    public void setSelected(boolean z) {
        this.d = z;
    }

    public void increaseCount() {
        this.c++;
    }
}
