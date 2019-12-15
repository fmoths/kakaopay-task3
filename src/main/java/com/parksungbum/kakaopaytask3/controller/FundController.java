package com.parksungbum.kakaopaytask3.controller;

import com.parksungbum.kakaopaytask3.service.FundService;
import com.parksungbum.kakaopaytask3.service.dto.AnnualFundStatisticsResponseDto;
import com.parksungbum.kakaopaytask3.service.dto.AverageAmountAndYearResponseDto;
import com.parksungbum.kakaopaytask3.service.dto.InstitutionMaxFundResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FundController {

    private final FundService fundService;

    public FundController(FundService fundService) {
        this.fundService = fundService;
    }

    @GetMapping("/funds/statistics")
    public ResponseEntity<List<AnnualFundStatisticsResponseDto>> showStatistics() {
        List<AnnualFundStatisticsResponseDto> annualFundStatistics =
                fundService.findAllAnnualFundStatistics();

        return ResponseEntity.ok(annualFundStatistics);
    }

    @GetMapping("/funds/maximum/institution")
    public ResponseEntity<InstitutionMaxFundResponseDto> showInstitutionAndYearOfMaximumFund() {
        InstitutionMaxFundResponseDto institutionAndYearOfMaxFund =
                fundService.findYearAndInstitutionOfMaxFund();

        return ResponseEntity.ok(institutionAndYearOfMaxFund);
    }

    @GetMapping("/funds/average/max-min")
    public ResponseEntity<AverageAmountAndYearResponseDto>
    showMaxAverageAndMinAverageFundInfo(@RequestParam(value = "bank") String bankName) {
        return null;
    }
}