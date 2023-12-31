package com.google.zxing.client.result;

import id.dana.cashier.view.InputCardNumberView;

/* loaded from: classes7.dex */
public final class VINParsedResult extends ParsedResult {
    private final String countryCode;
    private final int modelYear;
    private final char plantCode;
    private final String sequentialNumber;
    private final String vehicleAttributes;
    private final String vehicleDescriptorSection;
    private final String vehicleIdentifierSection;
    private final String vin;
    private final String worldManufacturerID;

    public VINParsedResult(String str, String str2, String str3, String str4, String str5, String str6, int i, char c, String str7) {
        super(ParsedResultType.VIN);
        this.vin = str;
        this.worldManufacturerID = str2;
        this.vehicleDescriptorSection = str3;
        this.vehicleIdentifierSection = str4;
        this.countryCode = str5;
        this.vehicleAttributes = str6;
        this.modelYear = i;
        this.plantCode = c;
        this.sequentialNumber = str7;
    }

    public final String getVIN() {
        return this.vin;
    }

    public final String getWorldManufacturerID() {
        return this.worldManufacturerID;
    }

    public final String getVehicleDescriptorSection() {
        return this.vehicleDescriptorSection;
    }

    public final String getVehicleIdentifierSection() {
        return this.vehicleIdentifierSection;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getVehicleAttributes() {
        return this.vehicleAttributes;
    }

    public final int getModelYear() {
        return this.modelYear;
    }

    public final char getPlantCode() {
        return this.plantCode;
    }

    public final String getSequentialNumber() {
        return this.sequentialNumber;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public final String getDisplayResult() {
        StringBuilder sb = new StringBuilder(50);
        sb.append(this.worldManufacturerID);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(this.vehicleDescriptorSection);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(this.vehicleIdentifierSection);
        sb.append('\n');
        String str = this.countryCode;
        if (str != null) {
            sb.append(str);
            sb.append(InputCardNumberView.DIVIDER);
        }
        sb.append(this.modelYear);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(this.plantCode);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(this.sequentialNumber);
        sb.append('\n');
        return sb.toString();
    }
}
