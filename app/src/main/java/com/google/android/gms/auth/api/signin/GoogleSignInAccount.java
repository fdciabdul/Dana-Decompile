package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.oauth.OauthConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zab();
    public static Clock zaa = DefaultClock.getInstance();
    final int zab;
    List<Scope> zac;
    private String zad;
    private String zae;
    private String zaf;
    private String zag;
    private Uri zah;
    private String zai;
    private long zaj;
    private String zak;
    private String zal;
    private String zam;
    private Set<Scope> zan = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.zab = i;
        this.zad = str;
        this.zae = str2;
        this.zaf = str3;
        this.zag = str4;
        this.zah = uri;
        this.zai = str5;
        this.zaj = j;
        this.zak = str6;
        this.zac = list;
        this.zal = str7;
        this.zam = str8;
    }

    public static GoogleSignInAccount createDefault() {
        return zae(new Account("<<default account>>", "com.google"), new HashSet());
    }

    public static GoogleSignInAccount fromAccount(Account account) {
        return zae(account, new ArraySet());
    }

    public static GoogleSignInAccount zaa(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set<Scope> set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l.longValue(), Preconditions.checkNotEmpty(str7), new ArrayList((Collection) Preconditions.checkNotNull(set)), str5, str6);
    }

    public static GoogleSignInAccount zab(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String optString2 = jSONObject.optString("id");
        String optString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String optString4 = jSONObject.has("email") ? jSONObject.optString("email") : null;
        String optString5 = jSONObject.has(ExtendInfoUtilKt.DISPLAY_NAME_KEY) ? jSONObject.optString(ExtendInfoUtilKt.DISPLAY_NAME_KEY) : null;
        String optString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        GoogleSignInAccount zaa2 = zaa(optString2, optString3, optString4, optString5, optString6, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        zaa2.zai = jSONObject.has(OauthConstant.PathParams.SERVER_AUTH_CODE) ? jSONObject.optString(OauthConstant.PathParams.SERVER_AUTH_CODE) : null;
        return zaa2;
    }

    private static GoogleSignInAccount zae(Account account, Set<Scope> set) {
        return zaa(null, null, account.name, null, null, null, null, 0L, account.name, set);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof GoogleSignInAccount) {
            GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
            return googleSignInAccount.zak.equals(this.zak) && googleSignInAccount.getRequestedScopes().equals(getRequestedScopes());
        }
        return false;
    }

    public Account getAccount() {
        String str = this.zaf;
        if (str == null) {
            return null;
        }
        return new Account(str, "com.google");
    }

    public String getDisplayName() {
        return this.zag;
    }

    public String getEmail() {
        return this.zaf;
    }

    public String getFamilyName() {
        return this.zam;
    }

    public String getGivenName() {
        return this.zal;
    }

    public Set<Scope> getGrantedScopes() {
        return new HashSet(this.zac);
    }

    public String getId() {
        return this.zad;
    }

    public String getIdToken() {
        return this.zae;
    }

    public Uri getPhotoUrl() {
        return this.zah;
    }

    public Set<Scope> getRequestedScopes() {
        HashSet hashSet = new HashSet(this.zac);
        hashSet.addAll(this.zan);
        return hashSet;
    }

    public String getServerAuthCode() {
        return this.zai;
    }

    public int hashCode() {
        return ((this.zak.hashCode() + 527) * 31) + getRequestedScopes().hashCode();
    }

    public boolean isExpired() {
        return zaa.currentTimeMillis() / 1000 >= this.zaj - 300;
    }

    public GoogleSignInAccount requestExtraScopes(Scope... scopeArr) {
        if (scopeArr != null) {
            Collections.addAll(this.zan, scopeArr);
        }
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zab);
        SafeParcelWriter.writeString(parcel, 2, getId(), false);
        SafeParcelWriter.writeString(parcel, 3, getIdToken(), false);
        SafeParcelWriter.writeString(parcel, 4, getEmail(), false);
        SafeParcelWriter.writeString(parcel, 5, getDisplayName(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getPhotoUrl(), i, false);
        SafeParcelWriter.writeString(parcel, 7, getServerAuthCode(), false);
        SafeParcelWriter.writeLong(parcel, 8, this.zaj);
        SafeParcelWriter.writeString(parcel, 9, this.zak, false);
        SafeParcelWriter.writeTypedList(parcel, 10, this.zac, false);
        SafeParcelWriter.writeString(parcel, 11, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 12, getFamilyName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zac() {
        return this.zak;
    }

    public final String zad() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put("id", getId());
            }
            if (getIdToken() != null) {
                jSONObject.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                jSONObject.put("email", getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put(ExtendInfoUtilKt.DISPLAY_NAME_KEY, getDisplayName());
            }
            if (getGivenName() != null) {
                jSONObject.put("givenName", getGivenName());
            }
            if (getFamilyName() != null) {
                jSONObject.put("familyName", getFamilyName());
            }
            Uri photoUrl = getPhotoUrl();
            if (photoUrl != null) {
                jSONObject.put("photoUrl", photoUrl.toString());
            }
            if (getServerAuthCode() != null) {
                jSONObject.put(OauthConstant.PathParams.SERVER_AUTH_CODE, getServerAuthCode());
            }
            jSONObject.put("expirationTime", this.zaj);
            jSONObject.put("obfuscatedIdentifier", this.zak);
            JSONArray jSONArray = new JSONArray();
            List<Scope> list = this.zac;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, new Comparator() { // from class: com.google.android.gms.auth.api.signin.zaa
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    Parcelable.Creator<GoogleSignInAccount> creator = GoogleSignInAccount.CREATOR;
                    return ((Scope) obj).getScopeUri().compareTo(((Scope) obj2).getScopeUri());
                }
            });
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.getScopeUri());
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove(OauthConstant.PathParams.SERVER_AUTH_CODE);
            return jSONObject.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
