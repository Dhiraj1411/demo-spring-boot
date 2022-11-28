package com.assessment.rbc.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "stock")
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="QUARTER")
    private String quarter;
    @Column(name = "STOCK")
    private String stock;
    @Column(name="DATE")
    private String date;
    @Column(name="OPEN")
    private String open;
    @Column(name="HIGH")
    private String high;
    @Column(name="LOW")
    private String low;
    @Column(name="CLOSE")
    private String close;
    @Column(name="VOLUME")
    private String volume;
    @Column(name="PERCENT_CHANGE_PRICE")
    private String percentChangePrice;
    @Column(name="PERCENT_CHANGE_VOLUME_OVER_LAST_WK")
    private String percentChangeVolumeOverLastWk;
    @Column(name="PREVIOUS_WEEKS_VOLUME")
    private String previousWeeksVolume;
    @Column(name="NEXT_WEEKS_OPEN")
    private String nextWeeksOpen;
    @Column(name="NEXT_WEEKS_CLOSE")
    private String nextWeeksClose;
    @Column(name="PERCENT_CHANGE_NEXT_WEEKS_PRICE")
    private String percentChangeNextWeeksPrice;
    @Column(name="DAYS_TO_NEXT_DIVIDEND")
    private String daysToNextDividend;
    @Column(name="PERCENT_RETURN_NEXT_DIVIDEND")
    private String percentReturnNextDividend;
}
