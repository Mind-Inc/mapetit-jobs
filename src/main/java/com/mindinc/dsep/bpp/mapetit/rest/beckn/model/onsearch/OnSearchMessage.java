package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.onsearch;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Catalog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OnSearchMessage {
    private Catalog catalog;
}
