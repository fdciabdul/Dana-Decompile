package id.dana.data.sendmoney.repository.source.network.result;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class CardHolderResult {
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }
}
