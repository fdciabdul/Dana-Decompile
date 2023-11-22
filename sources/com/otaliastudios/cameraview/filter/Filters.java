package com.otaliastudios.cameraview.filter;

import com.otaliastudios.cameraview.filters.AutoFixFilter;
import com.otaliastudios.cameraview.filters.BlackAndWhiteFilter;
import com.otaliastudios.cameraview.filters.BrightnessFilter;
import com.otaliastudios.cameraview.filters.ContrastFilter;
import com.otaliastudios.cameraview.filters.CrossProcessFilter;
import com.otaliastudios.cameraview.filters.DocumentaryFilter;
import com.otaliastudios.cameraview.filters.DuotoneFilter;
import com.otaliastudios.cameraview.filters.FillLightFilter;
import com.otaliastudios.cameraview.filters.GammaFilter;
import com.otaliastudios.cameraview.filters.GrainFilter;
import com.otaliastudios.cameraview.filters.GrayscaleFilter;
import com.otaliastudios.cameraview.filters.HueFilter;
import com.otaliastudios.cameraview.filters.InvertColorsFilter;
import com.otaliastudios.cameraview.filters.LomoishFilter;
import com.otaliastudios.cameraview.filters.PosterizeFilter;
import com.otaliastudios.cameraview.filters.SaturationFilter;
import com.otaliastudios.cameraview.filters.SepiaFilter;
import com.otaliastudios.cameraview.filters.SharpnessFilter;
import com.otaliastudios.cameraview.filters.TemperatureFilter;
import com.otaliastudios.cameraview.filters.TintFilter;
import com.otaliastudios.cameraview.filters.VignetteFilter;

/* loaded from: classes8.dex */
public enum Filters {
    NONE(NoFilter.class),
    AUTO_FIX(AutoFixFilter.class),
    BLACK_AND_WHITE(BlackAndWhiteFilter.class),
    BRIGHTNESS(BrightnessFilter.class),
    CONTRAST(ContrastFilter.class),
    CROSS_PROCESS(CrossProcessFilter.class),
    DOCUMENTARY(DocumentaryFilter.class),
    DUOTONE(DuotoneFilter.class),
    FILL_LIGHT(FillLightFilter.class),
    GAMMA(GammaFilter.class),
    GRAIN(GrainFilter.class),
    GRAYSCALE(GrayscaleFilter.class),
    HUE(HueFilter.class),
    INVERT_COLORS(InvertColorsFilter.class),
    LOMOISH(LomoishFilter.class),
    POSTERIZE(PosterizeFilter.class),
    SATURATION(SaturationFilter.class),
    SEPIA(SepiaFilter.class),
    SHARPNESS(SharpnessFilter.class),
    TEMPERATURE(TemperatureFilter.class),
    TINT(TintFilter.class),
    VIGNETTE(VignetteFilter.class);

    private Class<? extends Filter> filterClass;

    Filters(Class cls) {
        this.filterClass = cls;
    }

    public final Filter newInstance() {
        try {
            return this.filterClass.newInstance();
        } catch (IllegalAccessException unused) {
            return new NoFilter();
        } catch (InstantiationException unused2) {
            return new NoFilter();
        }
    }
}
