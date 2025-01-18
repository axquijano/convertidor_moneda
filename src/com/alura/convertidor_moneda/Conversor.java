package com.alura.convertidor_moneda;

import com.google.gson.annotations.SerializedName;

public record Conversor(
        @SerializedName("base_code")
        String baseCode,       // Moneda base
        @SerializedName("target_code")
        String targetCode,     // Moneda objetivo
        @SerializedName("conversion_rate")
        double conversionRate  // Tasa de conversión
) {
}
