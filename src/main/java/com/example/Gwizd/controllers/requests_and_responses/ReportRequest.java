package com.example.Gwizd.controllers.requests_and_responses;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportRequest {
    private Boolean lost;
    private Double longitude;
    private Double latitude;
    private String photoOidVector;
    private String species;
    private String description;
    private String localization;
    private Boolean dangerous;
}
