package com.alipay.mobile.beehive.poiselect.util;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes6.dex */
public class GooglePoiItem implements Serializable {
    private String business_status;
    private GeometryEntity geometry;
    private String icon;

    /* renamed from: id  reason: collision with root package name */
    private String f7124id;
    private String name;
    private String place_id;
    private Plus_codeEntity plus_code;
    private String reference;
    private String scope;
    private List<String> types;
    private String vicinity;

    public void setReference(String str) {
        this.reference = str;
    }

    public void setTypes(List<String> list) {
        this.types = list;
    }

    public void setBusiness_status(String str) {
        this.business_status = str;
    }

    public void setScope(String str) {
        this.scope = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setGeometry(GeometryEntity geometryEntity) {
        this.geometry = geometryEntity;
    }

    public void setVicinity(String str) {
        this.vicinity = str;
    }

    public void setId(String str) {
        this.f7124id = str;
    }

    public void setPlus_code(Plus_codeEntity plus_codeEntity) {
        this.plus_code = plus_codeEntity;
    }

    public void setPlace_id(String str) {
        this.place_id = str;
    }

    public String getReference() {
        return this.reference;
    }

    public List<String> getTypes() {
        return this.types;
    }

    public String getBusiness_status() {
        return this.business_status;
    }

    public String getScope() {
        return this.scope;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public GeometryEntity getGeometry() {
        return this.geometry;
    }

    public String getVicinity() {
        return this.vicinity;
    }

    public String getId() {
        return this.f7124id;
    }

    public Plus_codeEntity getPlus_code() {
        return this.plus_code;
    }

    public String getPlace_id() {
        return this.place_id;
    }

    /* loaded from: classes6.dex */
    public class GeometryEntity {

        /* renamed from: a  reason: collision with root package name */
        private ViewportEntity f7125a;
        private LocationEntity b;

        public GeometryEntity() {
        }

        public void setViewport(ViewportEntity viewportEntity) {
            this.f7125a = viewportEntity;
        }

        public void setLocation(LocationEntity locationEntity) {
            this.b = locationEntity;
        }

        public ViewportEntity getViewport() {
            return this.f7125a;
        }

        public LocationEntity getLocation() {
            return this.b;
        }

        /* loaded from: classes6.dex */
        public class ViewportEntity {

            /* renamed from: a  reason: collision with root package name */
            private SouthwestEntity f7127a;
            private NortheastEntity b;

            public ViewportEntity() {
            }

            public void setSouthwest(SouthwestEntity southwestEntity) {
                this.f7127a = southwestEntity;
            }

            public void setNortheast(NortheastEntity northeastEntity) {
                this.b = northeastEntity;
            }

            public SouthwestEntity getSouthwest() {
                return this.f7127a;
            }

            public NortheastEntity getNortheast() {
                return this.b;
            }

            /* loaded from: classes6.dex */
            public class SouthwestEntity {

                /* renamed from: a  reason: collision with root package name */
                private double f7129a;
                private double b;

                public SouthwestEntity() {
                }

                public void setLng(double d) {
                    this.f7129a = d;
                }

                public void setLat(double d) {
                    this.b = d;
                }

                public double getLng() {
                    return this.f7129a;
                }

                public double getLat() {
                    return this.b;
                }
            }

            /* loaded from: classes6.dex */
            public class NortheastEntity {

                /* renamed from: a  reason: collision with root package name */
                private double f7128a;
                private double b;

                public NortheastEntity() {
                }

                public void setLng(double d) {
                    this.f7128a = d;
                }

                public void setLat(double d) {
                    this.b = d;
                }

                public double getLng() {
                    return this.f7128a;
                }

                public double getLat() {
                    return this.b;
                }
            }
        }

        /* loaded from: classes6.dex */
        public class LocationEntity {

            /* renamed from: a  reason: collision with root package name */
            private double f7126a;
            private double b;

            public LocationEntity() {
            }

            public void setLng(double d) {
                this.f7126a = d;
            }

            public void setLat(double d) {
                this.b = d;
            }

            public double getLng() {
                return this.f7126a;
            }

            public double getLat() {
                return this.b;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class Plus_codeEntity {

        /* renamed from: a  reason: collision with root package name */
        private String f7130a;
        private String b;

        public Plus_codeEntity() {
        }

        public void setCompound_code(String str) {
            this.f7130a = str;
        }

        public void setGlobal_code(String str) {
            this.b = str;
        }

        public String getCompound_code() {
            return this.f7130a;
        }

        public String getGlobal_code() {
            return this.b;
        }
    }
}
