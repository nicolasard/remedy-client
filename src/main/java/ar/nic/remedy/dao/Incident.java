package ar.nic.remedy.dao;

public class Incident {
    private String IncidentID;
    private String Summary;
    private String Status;
    private String Date;
    private UrgencyType Urgency;
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

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
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
}
