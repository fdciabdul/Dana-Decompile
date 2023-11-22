package com.iap.ac.android.biz.common.model.multilanguage.querycity;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class CountryRegion {
    public String regionCode;
    public String regionName;
    public List<CityRegionsGroupByInitial> cityRegionsGroupByInitials = new ArrayList();
    @Deprecated
    public List<CityRegion> cities = new ArrayList();
}
