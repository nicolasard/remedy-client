package ar.nic.remedy.dao;

import java.util.Date;

public class Incident {
    private String IncidentID;
    private String Summary;
    private String Status;
    private Date date;
    private UrgencyType Urgency;
    private Integer lifeDays;
    private String AssignedTo;
    private String Notes;

    public String getIncidentID() {
        return IncidentID;
    }

    public void setIncidentID(String incidentID) {
        IncidentID = incidentID;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }


    public String getAssignedTo() {
        return AssignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        AssignedTo = assignedTo;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public UrgencyType getUrgency() {
        return Urgency;
    }

    public void setUrgency(UrgencyType urgency) {
        Urgency = urgency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getLifeDays() {
        return lifeDays;
    }

    public void setLifeDays(Integer lifeDays) {
        this.lifeDays = lifeDays;
    }
}
