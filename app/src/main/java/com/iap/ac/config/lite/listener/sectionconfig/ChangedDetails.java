package com.iap.ac.config.lite.listener.sectionconfig;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class ChangedDetails {
    public final Set<String> addedKeys = new HashSet();
    public final Set<String> modifiedKeys = new HashSet();
    public final Set<String> deletedKeys = new HashSet();

    public boolean addedContains(String str) {
        return this.addedKeys.contains(str);
    }

    public boolean deletedContains(String str) {
        return this.deletedKeys.contains(str);
    }

    public void mergeChangeDetails(ChangedDetails changedDetails) {
        this.addedKeys.addAll(changedDetails.addedKeys);
        this.modifiedKeys.addAll(changedDetails.modifiedKeys);
        this.deletedKeys.addAll(changedDetails.deletedKeys);
    }

    public boolean modifiedContains(String str) {
        return this.modifiedKeys.contains(str);
    }
}
