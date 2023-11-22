package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.URL;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class GlideUrl implements Key {
    public final Headers KClassImpl$Data$declaredNonStaticMembers$2;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    public String PlaceComponentResult;
    public URL getAuthRequestContext;
    private volatile byte[] lookAheadTest;
    public final URL moveToNextValue;
    public final String scheduleImpl;

    public GlideUrl(URL url) {
        this(url, Headers.BuiltInFictitiousFunctionClassFactory);
    }

    public GlideUrl(String str) {
        this(str, Headers.BuiltInFictitiousFunctionClassFactory);
    }

    private GlideUrl(URL url, Headers headers) {
        this.moveToNextValue = (URL) Preconditions.PlaceComponentResult(url);
        this.scheduleImpl = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (Headers) Preconditions.PlaceComponentResult(headers);
    }

    private GlideUrl(String str, Headers headers) {
        this.moveToNextValue = null;
        this.scheduleImpl = Preconditions.getAuthRequestContext(str);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (Headers) Preconditions.PlaceComponentResult(headers);
    }

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest messageDigest) {
        messageDigest.update(MyBillsEntityDataFactory());
    }

    private byte[] MyBillsEntityDataFactory() {
        if (this.lookAheadTest == null) {
            String str = this.scheduleImpl;
            if (str == null) {
                str = ((URL) Preconditions.PlaceComponentResult(this.moveToNextValue)).toString();
            }
            this.lookAheadTest = str.getBytes(MyBillsEntityDataFactory);
        }
        return this.lookAheadTest;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof GlideUrl) {
            GlideUrl glideUrl = (GlideUrl) obj;
            String str = this.scheduleImpl;
            if (str == null) {
                str = ((URL) Preconditions.PlaceComponentResult(this.moveToNextValue)).toString();
            }
            String str2 = glideUrl.scheduleImpl;
            if (str2 == null) {
                str2 = ((URL) Preconditions.PlaceComponentResult(glideUrl.moveToNextValue)).toString();
            }
            return str.equals(str2) && this.KClassImpl$Data$declaredNonStaticMembers$2.equals(glideUrl.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == 0) {
            String str = this.scheduleImpl;
            if (str == null) {
                str = ((URL) Preconditions.PlaceComponentResult(this.moveToNextValue)).toString();
            }
            int hashCode = str.hashCode();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = hashCode;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (hashCode * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        }
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public String toString() {
        String str = this.scheduleImpl;
        return str == null ? ((URL) Preconditions.PlaceComponentResult(this.moveToNextValue)).toString() : str;
    }
}
