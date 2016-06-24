package application.enums;

/**
 * Created by pkonwar on 4/16/2016.
 */
public enum STATUS {

    /**
     * Used for Database Status flags
     */
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE"),

    /**
     * Used for Request Status
     */
    SUCCESS("SUCCESS"),
    FAILURE("FAILURE");

    private String status = null;

    STATUS(String type) {
        this.status = type;
    }

    public String getStatus() {
        return status;
    }
}
