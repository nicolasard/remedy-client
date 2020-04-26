package ar.nic.remedy.dao;

public enum UrgencyType {
    CRITICAL("Critical","1-Critical"),
    HIGH("High","2-High"),
    MEDIUM("Medium","3-Medium"),
    LOW("Low","4-Low");

    private UrgencyType(final String toString, final String remedyString){
        this.toString = toString;
        this.remedyString = remedyString;
    }

    private final String toString;

    private final String remedyString;

    public static UrgencyType getByRemedyString(String remedyString){
        for (final UrgencyType urgencyType: UrgencyType.values()) {
            if (urgencyType.remedyString.equals(remedyString)) return urgencyType;
        }
        return null;
    }

    @Override
    public String toString(){
        return "nada";
    }
}
