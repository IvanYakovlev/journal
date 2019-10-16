package com.pgk.journal.entity;

import javax.persistence.*;

@Entity
@Table(name = "table_journal", schema = "journal")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idEntry;

    @Column(name = "FIO")
    private String fio;

    @Column(name = "DATE_OF_ABSENCE")
    private String dateOfAbsence;

    @Column(name = "START_TIME")
    private String startTime;

    @Column(name = "END_TIME")
    private String endTime;

    @Column(name = "PLACE_OR_CAUSE")
    private String placeCause;

    public Entry() {
    }

    public Entry(Long idEntry, String fio, String dateOfAbsence, String startTime, String endTime, String placeCause) {
        this.idEntry = idEntry;
        this.fio = fio;
        this.dateOfAbsence = dateOfAbsence;
        this.startTime = startTime;
        this.endTime = endTime;
        this.placeCause = placeCause;
    }

    public Long getIdEntry() {
        return idEntry;
    }

    public void setIdEntry(Long idEntry) {
        this.idEntry = idEntry;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getDateOfAbsence() {
        return dateOfAbsence;
    }

    public void setDateOfAbsence(String dateOfAbsence) {
        this.dateOfAbsence = dateOfAbsence;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPlaceCause() {
        return placeCause;
    }

    public void setPlaceCause(String placeCause) {
        this.placeCause = placeCause;
    }
}
