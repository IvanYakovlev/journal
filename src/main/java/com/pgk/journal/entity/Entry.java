package com.pgk.journal.entity;

import javax.persistence.*;

@Entity
@Table(name = "table_journal", schema = "journal")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer idEntry;

    @Column(name = "FIO")
    private String fio;

    @Column(name = "DATE_OF_ABSENCE")
    private String dateOfAbsence;

    @Column(name = "START_TIME")
    private String startTime;

    @Column(name = "END_TIME")
    private String endTime;

    @Column(name = "PLACE_OR_CAUSE")
    private String placeOrCause;

    public Entry() {
    }

    public Entry(String fio, String dateOfAbsence, String startTime, String endTime, String placeOrCause) {
        this.fio = fio;
        this.dateOfAbsence = dateOfAbsence;
        this.startTime = startTime;
        this.endTime = endTime;
        this.placeOrCause = placeOrCause;
    }

    public Integer getIdEntry() {
        return idEntry;
    }

    public void setIdEntry(Integer idEntry) {
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

    public String getPlaceOrCause() {
        return placeOrCause;
    }

    public void setPlaceOrCause(String placeOrCause) {
        this.placeOrCause = placeOrCause;
    }
}
