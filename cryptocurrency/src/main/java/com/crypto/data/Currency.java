package com.crypto.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.json.bind.annotation.JsonbProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Currency {

    private String id;

    private String symbol;

    private String name;

    @JsonbProperty("price_usd")
    private String priceUsd;
}
