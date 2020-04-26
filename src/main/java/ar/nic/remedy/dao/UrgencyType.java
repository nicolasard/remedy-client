package ar.nic.remedy.dao;

public enum UrgencyType {

    CRITICAL("Critical"),
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");

    private UrgencyType(final String toString){
        this.toString = toString;
    }

    private final String toString;

    @Override
    public String toString(){
        return "nada";
    }
}
