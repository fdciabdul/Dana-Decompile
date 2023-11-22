package com.yalantis.ucrop.model;

/* loaded from: classes8.dex */
public class ExifInfo {
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private int getAuthRequestContext;

    public ExifInfo(int i, int i2, int i3) {
        this.getAuthRequestContext = i;
        this.MyBillsEntityDataFactory = i2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExifInfo exifInfo = (ExifInfo) obj;
        return this.getAuthRequestContext == exifInfo.getAuthRequestContext && this.MyBillsEntityDataFactory == exifInfo.MyBillsEntityDataFactory && this.KClassImpl$Data$declaredNonStaticMembers$2 == exifInfo.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public int hashCode() {
        return (((this.getAuthRequestContext * 31) + this.MyBillsEntityDataFactory) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
